import net.fabricmc.tinyremapper.OutputConsumerPath;
import net.fabricmc.tinyremapper.TinyRemapper;
import net.fabricmc.tinyremapper.TinyUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Turns the classes javac compiled (against the renamed library jar) into classes that run against
 * the original, untouched library dex:
 * <ol>
 *   <li>calls to constructors that Desynth added only for compilation go back to the ancestor
 *       constructor the original bytecode called;</li>
 *   <li>everything is renamed from the jadx names back to the original (obfuscated) names.</li>
 * </ol>
 * Usage: PostCompile &lt;in.jar&gt; &lt;out.jar&gt; &lt;mapping.tiny&gt; &lt;compile-libs.jar&gt; &lt;added-ctors.txt&gt;
 */
public final class PostCompile {
    public static void main(String[] args) throws Exception {
        Path in = Path.of(args[0]), out = Path.of(args[1]), mapping = Path.of(args[2]), libs = Path.of(args[3]);
        Map<String, String> targets = new HashMap<>();
        for (String line : Files.readAllLines(Path.of(args[4]))) {
            String[] p = line.trim().split(" ");
            if (p.length == 3) targets.put(p[0] + " " + p[1], p[2]);
        }

        Path retargeted = Files.createTempFile("postcompile", ".jar");
        int[] rewritten = {0};
        try (ZipFile zin = new ZipFile(in.toFile());
             OutputStream os = Files.newOutputStream(retargeted);
             ZipOutputStream zout = new ZipOutputStream(os)) {
            Enumeration<? extends ZipEntry> en = zin.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                byte[] data;
                try (InputStream is = zin.getInputStream(e)) {
                    data = is.readAllBytes();
                }
                if (e.getName().endsWith(".class")) {
                    ClassReader reader = new ClassReader(data);
                    ClassWriter writer = new ClassWriter(0);
                    reader.accept(new ClassVisitor(Opcodes.ASM9, writer) {
                        @Override
                        public MethodVisitor visitMethod(int acc, String name, String desc, String sig, String[] exc) {
                            return new MethodVisitor(Opcodes.ASM9, super.visitMethod(acc, name, desc, sig, exc)) {
                                @Override
                                public void visitMethodInsn(int op, String owner, String mn, String md, boolean itf) {
                                    if (op == Opcodes.INVOKESPECIAL && mn.equals("<init>")) {
                                        String t = targets.get(owner + " " + md);
                                        if (t != null) {
                                            owner = t;
                                            rewritten[0]++;
                                        }
                                    }
                                    super.visitMethodInsn(op, owner, mn, md, itf);
                                }
                            };
                        }
                    }, 0);
                    data = writer.toByteArray();
                }
                zout.putNextEntry(new ZipEntry(e.getName()));
                zout.write(data);
                zout.closeEntry();
            }
        }

        TinyRemapper remapper = TinyRemapper.newRemapper()
                .withMappings(TinyUtils.createTinyMappingProvider(mapping, "named", "official"))
                .ignoreConflicts(true)
                .rebuildSourceFilenames(true)
                .build();
        Files.deleteIfExists(out);
        try (OutputConsumerPath consumer = new OutputConsumerPath.Builder(out).build()) {
            remapper.readClassPath(libs);
            remapper.readInputs(retargeted);
            remapper.apply(consumer);
        } finally {
            remapper.finish();
            Files.deleteIfExists(retargeted);
        }
        System.out.println("constructor calls retargeted: " + rewritten[0]);

        if (args.length > 5) {
            int[] copied = mergeMissingMembers(out, Path.of(args[5]));
            System.out.println("members restored from the original classes: " + copied[0] + " methods, " + copied[1] + " fields; method bodies taken from the original: " + copied[2]);
        }
    }

    /**
     * jadx does not emit synthetic members (accessors, bridges, R8 outlines). The original library dex
     * still calls them, so every method/field the original class had and the recompiled one lacks is
     * copied over from the original bytecode (official names, as the output now uses).
     */
    private static int[] mergeMissingMembers(Path jar, Path originalJar) throws Exception {
        Map<String, org.objectweb.asm.tree.ClassNode> originals = new HashMap<>();
        try (ZipFile z = new ZipFile(originalJar.toFile())) {
            Enumeration<? extends ZipEntry> en = z.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                if (!e.getName().endsWith(".class")) continue;
                org.objectweb.asm.tree.ClassNode cn = new org.objectweb.asm.tree.ClassNode();
                try (InputStream is = z.getInputStream(e)) {
                    new ClassReader(is).accept(cn, 0);
                }
                originals.put(cn.name, cn);
            }
        }
        int[] copied = {0, 0, 0};
        Path tmp = Files.createTempFile("postcompile-merge", ".jar");
        try (ZipFile zin = new ZipFile(jar.toFile());
             OutputStream os = Files.newOutputStream(tmp);
             ZipOutputStream zout = new ZipOutputStream(os)) {
            Enumeration<? extends ZipEntry> en = zin.entries();
            while (en.hasMoreElements()) {
                ZipEntry e = en.nextElement();
                byte[] data;
                try (InputStream is = zin.getInputStream(e)) {
                    data = is.readAllBytes();
                }
                if (e.getName().endsWith(".class")) {
                    org.objectweb.asm.tree.ClassNode cn = new org.objectweb.asm.tree.ClassNode();
                    new ClassReader(data).accept(cn, 0);
                    org.objectweb.asm.tree.ClassNode orig = originals.get(cn.name);
                    if (orig != null) {
                        java.util.Set<String> have = new java.util.HashSet<>();
                        for (org.objectweb.asm.tree.MethodNode m : cn.methods) have.add(m.name + m.desc);
                        java.util.Set<String> haveF = new java.util.HashSet<>();
                        for (org.objectweb.asm.tree.FieldNode f : cn.fields) haveF.add(f.name + ":" + f.desc);
                        boolean changed = false;
                        // methods jadx could not decompile only throw "Method not decompiled: ...": use the original body
                        for (int k = 0; k < cn.methods.size(); k++) {
                            org.objectweb.asm.tree.MethodNode m = cn.methods.get(k);
                            if (!isJadxStub(m)) continue;
                            for (org.objectweb.asm.tree.MethodNode om : orig.methods) {
                                if (om.name.equals(m.name) && om.desc.equals(m.desc)) {
                                    if (hasDex2jarNewObject(om) && !isStubOnly(m)) {
                                        System.out.println("keeping source (dex2jar new Object in original): " + cn.name + "." + m.name + m.desc);
                                        continue;
                                    }
                                    cn.methods.set(k, om);
                                    copied[2]++;
                                    changed = true;
                                    if (isStubOnly(m)) System.out.println("original bytecode for undecompiled method " + cn.name + "." + m.name + m.desc);
                                }
                            }
                        }
                        for (org.objectweb.asm.tree.MethodNode m : orig.methods) {
                            if (m.name.equals("<clinit>") || have.contains(m.name + m.desc)) continue;
                            cn.methods.add(m);
                            copied[0]++;
                            changed = true;
                        }
                        for (org.objectweb.asm.tree.FieldNode f : orig.fields) {
                            if (haveF.contains(f.name + ":" + f.desc)) continue;
                            cn.fields.add(f);
                            copied[1]++;
                            changed = true;
                        }
                        if (changed) {
                            ClassWriter w = new ClassWriter(0);
                            cn.accept(w);
                            data = w.toByteArray();
                        }
                    }
                }
                zout.putNextEntry(new ZipEntry(e.getName()));
                zout.write(data);
                zout.closeEntry();
            }
        }
        Files.move(tmp, jar, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        return copied;
    }

    private static boolean isJadxStub(org.objectweb.asm.tree.MethodNode m) {
        if (m.instructions == null) return false;
        for (org.objectweb.asm.tree.AbstractInsnNode in : m.instructions) {
            if (in instanceof org.objectweb.asm.tree.LdcInsnNode l && l.cst instanceof String s
                    && s.startsWith("Method not decompiled: ")) {
                return true;
            }
            if (in instanceof org.objectweb.asm.tree.MethodInsnNode mi && mi.getOpcode() == Opcodes.INVOKESTATIC
                    && mi.owner.endsWith("/JadxSupport") && mi.name.equals("useOriginalBytecode")) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStubOnly(org.objectweb.asm.tree.MethodNode m) {
        for (org.objectweb.asm.tree.AbstractInsnNode in : m.instructions) {
            if (in instanceof org.objectweb.asm.tree.LdcInsnNode l && l.cst instanceof String s && s.startsWith("Method not decompiled: ")) return true;
        }
        return false;
    }

    /** dex2jar turns `new X; X's ancestor.<init>` into `new Ancestor`; such bodies must not be reused. */
    private static boolean hasDex2jarNewObject(org.objectweb.asm.tree.MethodNode m) {
        for (org.objectweb.asm.tree.AbstractInsnNode in : m.instructions) {
            if (in instanceof org.objectweb.asm.tree.TypeInsnNode t && t.getOpcode() == Opcodes.NEW && t.desc.equals("java/lang/Object")) {
                return true;
            }
        }
        return false;
    }
}
