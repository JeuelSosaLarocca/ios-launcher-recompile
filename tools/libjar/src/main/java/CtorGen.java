import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.IntInsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Adds to the app sources the constructors that exist in the original bytecode but that jadx did not
 * emit (it hides the constructors of classes R8 merged). Only straight-line constructors made of
 * field stores and a super/this call are translated; anything else is listed for manual work.
 *
 * Usage: CtorGen &lt;named.jar&gt; &lt;app-java-root&gt;
 */
public final class CtorGen {
    private static final Pattern CTOR = Pattern.compile("^\\s+(?:public |protected |private )?(?:/\\*[^*]*\\*/ )?(\\w+)\\(([^)]*)\\)\\s*(?:throws [\\w., ]+)?\\{", Pattern.MULTILINE);

    public static void main(String[] args) throws Exception {
        Path root = Path.of(args[1]);
        int added = 0;
        List<String> manual = new ArrayList<>();
        try (ZipFile jar = new ZipFile(args[0])) {
            Enumeration<? extends ZipEntry> en = jar.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                String name = e.getName();
                if (!name.startsWith("com/luutinhit/") || !name.endsWith(".class") || name.contains("$")) continue;
                Path src = root.resolve(name.substring(0, name.length() - 6) + ".java");
                if (!Files.exists(src)) continue;
                ClassNode cn = new ClassNode();
                try (InputStream is = jar.getInputStream(e)) {
                    new ClassReader(is).accept(cn, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
                }
                String text = Files.readString(src, StandardCharsets.UTF_8);
                String simple = cn.name.substring(cn.name.lastIndexOf('/') + 1);
                if ((cn.access & Opcodes.ACC_ENUM) != 0 || text.contains("enum " + simple + " ")) continue; // jadx emits enum constructors itself
                List<String> existing = existingSignatures(text, simple);
                StringBuilder gen = new StringBuilder();
                for (MethodNode m : cn.methods) {
                    if (!m.name.equals("<init>")) continue;
                    String sig = signature(Type.getArgumentTypes(m.desc));
                    if (existing.contains(sig)) continue;
                    if (sig.isEmpty() && existing.isEmpty()) continue; // javac adds the default constructor
                    String body = translate(cn, m);
                    if (body == null) {
                        manual.add(cn.name + " " + m.desc);
                        continue;
                    }
                    gen.append("\n    /** Restored from bytecode: jadx did not emit this constructor. */\n")
                       .append("    public ").append(simple).append('(').append(params(m.desc)).append(") {\n")
                       .append(body).append("    }\n");
                    added++;
                }
                if (gen.length() > 0) {
                    Matcher cls = Pattern.compile("^public [\\w /*]*(?:class|enum) " + simple + "\\b[^{]*\\{\\r?\\n", Pattern.MULTILINE).matcher(text);
                    if (!cls.find()) {
                        manual.add(cn.name + " (class declaration not found)");
                        continue;
                    }
                    text = text.substring(0, cls.end()) + gen + text.substring(cls.end());
                    Files.writeString(src, text, StandardCharsets.UTF_8);
                }
            }
        }
        System.out.println("constructors restored: " + added);
        for (String m : manual) System.out.println("manual: " + m);
    }

    private static List<String> existingSignatures(String text, String simple) {
        List<String> out = new ArrayList<>();
        Matcher m = CTOR.matcher(text);
        while (m.find()) {
            if (!m.group(1).equals(simple)) continue;
            List<String> types = new ArrayList<>();
            for (String p : m.group(2).split(",")) {
                p = p.trim().replaceAll("<.*>", "").replace("final ", "");
                if (p.isEmpty()) continue;
                String t = p.substring(0, p.lastIndexOf(' ')).trim();
                types.add(t.substring(t.lastIndexOf('.') + 1));
            }
            out.add(String.join(",", types));
        }
        return out;
    }

    private static String javaType(Type t) {
        String c = t.getClassName();
        if (t.getSort() == Type.OBJECT || t.getSort() == Type.ARRAY) {
            // nested classes are referenced with '.', but keep '$' when the "outer" part does not exist on its own
            c = c.replace('$', '.');
        }
        return c;
    }

    private static String signature(Type[] types) {
        List<String> out = new ArrayList<>();
        for (Type t : types) {
            String j = javaType(t);
            out.add(j.substring(j.lastIndexOf('.') + 1));
        }
        return String.join(",", out);
    }

    private static String params(String desc) {
        Type[] types = Type.getArgumentTypes(desc);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < types.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(javaType(types[i])).append(" p").append(i);
        }
        return sb.toString();
    }

    /** Straight-line translation; returns null when the constructor is not simple enough. */
    private static String translate(ClassNode cn, MethodNode m) {
        Type[] argTypes = Type.getArgumentTypes(m.desc);
        String[] slotName = new String[m.maxLocals + 1];
        int slot = 1;
        for (int i = 0; i < argTypes.length; i++) {
            slotName[slot] = "p" + i;
            slot += argTypes[i].getSize();
        }
        Deque<String> stack = new ArrayDeque<>();
        String superCall = null;
        List<String> stmts = new ArrayList<>();
        for (AbstractInsnNode in = m.instructions.getFirst(); in != null; in = in.getNext()) {
            int op = in.getOpcode();
            if (op < 0) continue; // labels, line numbers, frames
            if (in instanceof VarInsnNode v && op >= Opcodes.ILOAD && op <= Opcodes.ALOAD) {
                if (v.var == 0) stack.push("this");
                else if (v.var < slotName.length && slotName[v.var] != null) stack.push(slotName[v.var]);
                else return null;
            } else if (op == Opcodes.ACONST_NULL) {
                stack.push("null");
            } else if (op >= Opcodes.ICONST_M1 && op <= Opcodes.ICONST_5) {
                stack.push(Integer.toString(op - Opcodes.ICONST_0));
            } else if (op == Opcodes.LCONST_0 || op == Opcodes.LCONST_1) {
                stack.push((op - Opcodes.LCONST_0) + "L");
            } else if (op >= Opcodes.FCONST_0 && op <= Opcodes.FCONST_2) {
                stack.push((op - Opcodes.FCONST_0) + ".0f");
            } else if (in instanceof IntInsnNode i && (op == Opcodes.BIPUSH || op == Opcodes.SIPUSH)) {
                stack.push(Integer.toString(i.operand));
            } else if (in instanceof LdcInsnNode l) {
                Object c = l.cst;
                if (c instanceof String s) stack.push('"' + s.replace("\\", "\\\\").replace("\"", "\\\"") + '"');
                else if (c instanceof Float f) stack.push(f + "f");
                else if (c instanceof Long lv) stack.push(lv + "L");
                else if (c instanceof Integer || c instanceof Double) stack.push(c.toString());
                else return null;
            } else if (in instanceof FieldInsnNode f && op == Opcodes.PUTFIELD) {
                String value = stack.pop();
                String target = stack.pop();
                if (!target.equals("this") || !f.owner.equals(cn.name)) return null;
                if (f.desc.equals("Z") && (value.equals("0") || value.equals("1"))) value = value.equals("1") ? "true" : "false";
                stmts.add("        this." + f.name + " = " + value + ";\n");
            } else if (in instanceof FieldInsnNode f && op == Opcodes.GETSTATIC) {
                stack.push(javaType(Type.getObjectType(f.owner)) + "." + f.name);
            } else if (in instanceof TypeInsnNode t && op == Opcodes.CHECKCAST) {
                stack.push("(" + javaType(Type.getObjectType(t.desc)) + ") " + stack.pop());
            } else if (in instanceof MethodInsnNode mi && op == Opcodes.INVOKESPECIAL && mi.name.equals("<init>")) {
                int n = Type.getArgumentTypes(mi.desc).length;
                String[] a = new String[n];
                for (int i = n - 1; i >= 0; i--) a[i] = stack.pop();
                String recv = stack.pop();
                if (!recv.equals("this") || superCall != null) return null;
                superCall = "        " + (mi.owner.equals(cn.name) ? "this" : "super") + "(" + String.join(", ", a) + ");\n";
            } else if (op == Opcodes.RETURN) {
                break;
            } else {
                return null;
            }
        }
        if (superCall == null) return null;
        return superCall + String.join("", stmts);
    }
}
