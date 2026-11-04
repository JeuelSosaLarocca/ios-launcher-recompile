import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Makes the R8-optimized library bytecode linkable from javac:
 * <ul>
 *   <li>clears ACC_SYNTHETIC (R8 marks merged lambdas/outlines synthetic; javac ignores synthetic members)</li>
 *   <li>re-adds the pass-through constructors R8 removed from intermediate classes. In dex a constructor
 *       may call a grandparent's &lt;init&gt; directly; Java source can only call the direct superclass.</li>
 * </ul>
 * Constructors needed by classes that are compiled from source are written to a report instead.
 *
 * Also writes added-ctors.txt ("class desc originalTarget") next to the report.
 *
 * Usage: Desynth &lt;in.jar&gt; &lt;out.jar&gt; &lt;source-ctor-report.txt&gt; &lt;source-class-prefix&gt;
 */
public final class Desynth {
    private static final Map<String, String> SUPER = new HashMap<>();
    private static final Map<String, Set<String>> CTORS = new HashMap<>();
    private static final Map<String, Set<String>> NEEDED = new LinkedHashMap<>();
    /** "class desc" -> ancestor whose constructor the original bytecode called. */
    private static final Map<String, String> TARGET = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception {
        Map<String, byte[]> entries = new LinkedHashMap<>();
        try (ZipFile in = new ZipFile(args[0])) {
            Enumeration<? extends ZipEntry> en = in.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                try (InputStream is = in.getInputStream(e)) {
                    entries.put(e.getName(), is.readAllBytes());
                }
            }
        }

        // Pass 1: hierarchy and existing constructors.
        // {first class that needs the constructor, ancestor whose <init> was called, descriptor}
        List<String[]> skips = new ArrayList<>();
        for (Map.Entry<String, byte[]> e : entries.entrySet()) {
            if (!e.getKey().endsWith(".class")) continue;
            new ClassReader(e.getValue()).accept(new ClassVisitor(Opcodes.ASM9) {
                String name;

                @Override
                public void visit(int v, int acc, String n, String sig, String sup, String[] itf) {
                    name = n;
                    SUPER.put(n, sup);
                    CTORS.computeIfAbsent(n, k -> new LinkedHashSet<>());
                }

                @Override
                public MethodVisitor visitMethod(int acc, String n, String desc, String sig, String[] exc) {
                    boolean isCtor = n.equals("<init>");
                    if (isCtor) CTORS.get(name).add(desc);
                    String self = name;
                    return new MethodVisitor(Opcodes.ASM9) {
                        // NEW types whose <init> has not run yet. An <init> while one is pending creates that
                        // object; otherwise (only in constructors) it is the call on `this`.
                        final java.util.ArrayDeque<String> pendingNew = new java.util.ArrayDeque<>();

                        @Override
                        public void visitTypeInsn(int op, String type) {
                            if (op == Opcodes.NEW) pendingNew.push(type);
                        }

                        @Override
                        public void visitMethodInsn(int op, String owner, String mn, String md, boolean itf) {
                            if (op != Opcodes.INVOKESPECIAL || !mn.equals("<init>")) return;
                            if (!pendingNew.isEmpty()) {
                                String created = pendingNew.pop();
                                if (!created.equals(owner)) skips.add(new String[]{created, owner, md});
                                return;
                            }
                            if (isCtor && !owner.equals(self) && !owner.equals(SUPER.get(self))) {
                                skips.add(new String[]{SUPER.get(self), owner, md});
                            }
                        }
                    };
                }
            }, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
        }

        // Extra requests found by tools/scripts/fix_ctors.py: creations whose real type dex2jar lost
        // (it turns `new X; X's ancestor.<init>` into `new Ancestor`). Target = nearest ancestor with that desc.
        if (args.length > 4 && Files.exists(Path.of(args[4]))) {
            for (String line : Files.readAllLines(Path.of(args[4]))) {
                String[] p = line.trim().split(" ");
                if (p.length != 2 || !SUPER.containsKey(p[0])) continue;
                String t = SUPER.get(p[0]);
                while (t != null && SUPER.containsKey(t) && !CTORS.get(t).contains(p[1])) t = SUPER.get(t);
                if (t != null) skips.add(new String[]{p[0], t, p[1]});
            }
        }

        // Every class from the first one up to (excluding) the called ancestor needs that constructor.
        for (String[] skip : skips) {
            List<String> chain = new ArrayList<>();
            String c = skip[0];
            while (c != null && !c.equals(skip[1]) && SUPER.containsKey(c)) {
                chain.add(c);
                c = SUPER.get(c);
            }
            if (c == null) continue;
            for (String k : chain) {
                if (!CTORS.get(k).contains(skip[2])) {
                    NEEDED.computeIfAbsent(k, x -> new TreeSet<>()).add(skip[2]);
                    TARGET.putIfAbsent(k + " " + skip[2], skip[1]);
                }
            }
        }

        // Pass 2: rewrite.
        int added = 0;
        try (OutputStream os = Files.newOutputStream(Path.of(args[1]));
             ZipOutputStream out = new ZipOutputStream(os);
             PrintWriter report = new PrintWriter(Files.newBufferedWriter(Path.of(args[2])))) {
            for (Map.Entry<String, byte[]> e : entries.entrySet()) {
                byte[] data = e.getValue();
                if (e.getKey().endsWith(".class")) {
                    ClassReader reader = new ClassReader(data);
                    ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                    String cls = reader.getClassName();
                    Set<String> needed = NEEDED.getOrDefault(cls, Set.of());
                    if (cls.startsWith(args[3])) {
                        for (String d : needed) report.println(cls + " " + d);
                        needed = Set.of();
                    }
                    Set<String> toAdd = needed;
                    added += toAdd.size();
                    reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
                        String sup;

                        @Override
                        public void visit(int version, int access, String name, String sig, String s, String[] itf) {
                            sup = s;
                            super.visit(version, access & ~Opcodes.ACC_SYNTHETIC, name, sig, s, itf);
                        }

                        @Override
                        public MethodVisitor visitMethod(int access, String name, String desc, String sig, String[] exc) {
                            return super.visitMethod(access & ~Opcodes.ACC_SYNTHETIC, name, desc, sig, exc);
                        }

                        @Override
                        public FieldVisitor visitField(int access, String name, String desc, String sig, Object value) {
                            return super.visitField(access & ~Opcodes.ACC_SYNTHETIC, name, desc, sig, value);
                        }

                        @Override
                        public void visitEnd() {
                            for (String d : toAdd) {
                                MethodVisitor mv = super.visitMethod(Opcodes.ACC_PUBLIC, "<init>", d, null, null);
                                mv.visitCode();
                                mv.visitVarInsn(Opcodes.ALOAD, 0);
                                int slot = 1;
                                for (Type t : Type.getArgumentTypes(d)) {
                                    mv.visitVarInsn(t.getOpcode(Opcodes.ILOAD), slot);
                                    slot += t.getSize();
                                }
                                mv.visitMethodInsn(Opcodes.INVOKESPECIAL, sup, "<init>", d, false);
                                mv.visitInsn(Opcodes.RETURN);
                                mv.visitMaxs(0, 0);
                                mv.visitEnd();
                            }
                            super.visitEnd();
                        }
                    }, 0);
                    data = writer.toByteArray();
                }
                out.putNextEntry(new ZipEntry(e.getKey()));
                out.write(data);
                out.closeEntry();
            }
        }
        // Calls that compiled code makes to these constructors must be sent back to the original target.
        try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(Path.of(args[2]).resolveSibling("added-ctors.txt")))) {
            for (Map.Entry<String, String> t : TARGET.entrySet()) w.println(t.getKey() + " " + t.getValue());
        }
        System.out.println("constructors added: " + added + ", classes needing them: " + NEEDED.size());
    }
}
