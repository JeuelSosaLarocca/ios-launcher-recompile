import com.android.tools.smali.dexlib2.DexFileFactory;
import com.android.tools.smali.dexlib2.Opcode;
import com.android.tools.smali.dexlib2.Opcodes;
import com.android.tools.smali.dexlib2.AccessFlags;
import com.android.tools.smali.dexlib2.ReferenceType;
import com.android.tools.smali.dexlib2.builder.MutableMethodImplementation;
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction35c;
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction3rc;
import com.android.tools.smali.dexlib2.dexbacked.DexBackedDexFile;
import com.android.tools.smali.dexlib2.iface.ClassDef;
import com.android.tools.smali.dexlib2.iface.Field;
import com.android.tools.smali.dexlib2.iface.Method;
import com.android.tools.smali.dexlib2.iface.MethodImplementation;
import com.android.tools.smali.dexlib2.iface.MultiDexContainer;
import com.android.tools.smali.dexlib2.iface.instruction.Instruction;
import com.android.tools.smali.dexlib2.iface.instruction.ReferenceInstruction;
import com.android.tools.smali.dexlib2.iface.instruction.formats.Instruction35c;
import com.android.tools.smali.dexlib2.iface.instruction.formats.Instruction3rc;
import com.android.tools.smali.dexlib2.iface.reference.FieldReference;
import com.android.tools.smali.dexlib2.iface.reference.MethodReference;
import com.android.tools.smali.dexlib2.iface.reference.Reference;
import com.android.tools.smali.dexlib2.iface.reference.TypeReference;
import com.android.tools.smali.dexlib2.immutable.ImmutableClassDef;
import com.android.tools.smali.dexlib2.immutable.ImmutableDexFile;
import com.android.tools.smali.dexlib2.immutable.ImmutableField;
import com.android.tools.smali.dexlib2.immutable.ImmutableMethod;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Builds the app dex from the ORIGINAL app classes (straight from the original classes.dex, so no
 * decompiler or dex2jar mistakes reach the device) and takes from the compiled sources only:
 * <ul>
 *   <li>methods that call JadxSupport.useSource() (the ones changed on purpose), which replace the
 *       original method of the same signature (keeping its access flags);</li>
 *   <li>whatever compiled code those methods reach that the original does not have (new classes such
 *       as lambdas or JadxSupport, new methods and fields).</li>
 * </ul>
 * Library classes (everything in original-libs.dex) are left out; they ship in their own dex.
 *
 * Usage: DexMerge &lt;original.apk&gt; &lt;original-libs.dex&gt; &lt;compiled.apk&gt; &lt;out.dex&gt;
 */
public final class DexMerge {
    private static final String SUPPORT = "Lcom/luutinhit/launcher6/JadxSupport;";
    private static final String INVOKE_SPECIAL = "$invoke$special$";

    private static final Map<String, ClassDef> original = new LinkedHashMap<>();
    private static final Map<String, ClassDef> compiled = new HashMap<>();

    public static void main(String[] args) throws Exception {
        DexBackedDexFile orig = DexFileFactory.loadDexEntry(new File(args[0]), "classes.dex", true, null).getDexFile();
        Set<String> libTypes = new HashSet<>();
        for (ClassDef c : DexFileFactory.loadDexFile(args[1], null).getClasses()) libTypes.add(c.getType());
        for (ClassDef c : orig.getClasses()) {
            if (!libTypes.contains(c.getType())) original.put(c.getType(), c);
        }
        MultiDexContainer<? extends DexBackedDexFile> container = DexFileFactory.loadDexContainer(new File(args[2]), null);
        for (String entry : container.getDexEntryNames()) {
            for (ClassDef c : container.getEntry(entry).getDexFile().getClasses()) {
                if (!libTypes.contains(c.getType())) compiled.put(c.getType(), c);
            }
        }

        // compiled methods to keep, by class; start from the methods marked useSource and follow references
        Map<String, Map<String, Method>> take = new HashMap<>();
        Set<String> takeFields = new HashSet<>();
        Set<String> newClasses = new HashSet<>();
        Deque<Method> work = new ArrayDeque<>();
        for (ClassDef c : compiled.values()) {
            for (Method m : c.getMethods()) {
                if (!calls(m, "useSource")) continue;
                work.add(m);
                // D8 may move the body to "$invoke$special$<name>" and leave <name> as a forwarder;
                // the forwarder is the method that has to replace the original
                if (m.getName().startsWith(INVOKE_SPECIAL)) {
                    String real = m.getName().substring(INVOKE_SPECIAL.length());
                    for (Method w : c.getMethods()) {
                        if (w.getName().equals(real) && w.getParameterTypes().equals(m.getParameterTypes())
                                && w.getReturnType().equals(m.getReturnType())) {
                            work.add(w);
                        }
                    }
                }
            }
        }
        int marked = work.size();
        while (!work.isEmpty()) {
            Method m = work.pop();
            Map<String, Method> forClass = take.computeIfAbsent(m.getDefiningClass(), k -> new LinkedHashMap<>());
            if (forClass.putIfAbsent(key(m), m) != null) continue;
            if (m.getImplementation() == null) continue;
            for (Instruction in : m.getImplementation().getInstructions()) {
                if (!(in instanceof ReferenceInstruction ri)) continue;
                Reference r = ri.getReference();
                String owner = r instanceof MethodReference mr ? mr.getDefiningClass()
                        : r instanceof FieldReference fr ? fr.getDefiningClass()
                        : r instanceof TypeReference tr ? tr.getType() : null;
                if (owner == null) continue;
                owner = owner.replaceFirst("^\\[+", "");
                ClassDef cc = compiled.get(owner);
                if (cc == null) continue;
                if (!original.containsKey(owner)) {
                    // a class only the compiled code has: take all of it
                    if (newClasses.add(owner)) cc.getMethods().forEach(work::add);
                } else if (r instanceof MethodReference mr) {
                    Method target = find(cc, key(mr));
                    if (target != null && find(original.get(owner), key(mr)) == null) work.add(target);
                } else if (r instanceof FieldReference fr) {
                    takeFields.add(owner + "->" + fr.getName() + ":" + fr.getType());
                }
            }
        }

        Map<String, Integer> publicMembers = new HashMap<>();  // original members the compiled code uses from other classes
        List<ClassDef> out = new ArrayList<>();
        for (ClassDef oc : original.values()) {
            String type = oc.getType();
            Map<String, Method> mine = take.getOrDefault(type, Map.of());
            List<Method> methods = new ArrayList<>();
            Set<String> replaced = new HashSet<>();
            for (Method om : oc.getMethods()) {
                Method cm = mine.get(key(om));
                if (cm != null && !om.getName().equals("<clinit>")) {
                    methods.add(new ImmutableMethod(type, om.getName(), cm.getParameters(), om.getReturnType(),
                            om.getAccessFlags(), cm.getAnnotations(), cm.getHiddenApiRestrictions(), fixInvokes(cm)));
                    replaced.add(key(om));
                } else {
                    methods.add(om);
                }
            }
            for (Method cm : mine.values()) {
                if (!replaced.contains(key(cm)) && !cm.getName().equals("<clinit>")) {
                    methods.add(new ImmutableMethod(type, cm.getName(), cm.getParameters(), cm.getReturnType(),
                            cm.getAccessFlags(), cm.getAnnotations(), cm.getHiddenApiRestrictions(), fixInvokes(cm)));
                    System.out.println("added compiled method " + type + "->" + key(cm));
                }
            }
            List<Field> fields = new ArrayList<>();
            Set<String> haveFields = new HashSet<>();
            for (Field f : oc.getFields()) {
                fields.add(f);
                haveFields.add(f.getName() + ":" + f.getType());
            }
            ClassDef cc = compiled.get(type);
            if (cc != null) {
                for (Field f : cc.getFields()) {
                    String k = f.getName() + ":" + f.getType();
                    if (takeFields.contains(type + "->" + k) && haveFields.add(k)) {
                        fields.add(ImmutableField.of(f));
                        System.out.println("added compiled field " + type + "->" + k);
                    }
                }
            }
            out.add(new ImmutableClassDef(type, oc.getAccessFlags(), oc.getSuperclass(), oc.getInterfaces(),
                    oc.getSourceFile(), oc.getAnnotations(), fields, methods));
        }
        for (String t : newClasses) out.add(compiled.get(t));

        checkAccess(take, out);
        DexFileFactory.writeDexFile(args[3], new ImmutableDexFile(orig.getOpcodes(), out));
        int taken = take.values().stream().mapToInt(Map::size).sum();
        System.out.println("app dex: " + out.size() + " classes from the original; " + marked + " useSource methods, "
                + taken + " compiled methods in total, " + newClasses.size() + " compiled-only classes");
    }

    /**
     * The sources made private members public so javac could compile them; in the original they are
     * still private. A compiled invoke-virtual of a method that is private in the original becomes
     * invoke-direct.
     */
    private static MethodImplementation fixInvokes(Method m) {
        MethodImplementation impl = m.getImplementation();
        if (impl == null) return null;
        MutableMethodImplementation mut = null;
        int i = 0;
        for (Instruction in : impl.getInstructions()) {
            if ((in.getOpcode() == Opcode.INVOKE_VIRTUAL || in.getOpcode() == Opcode.INVOKE_VIRTUAL_RANGE)
                    && ((ReferenceInstruction) in).getReference() instanceof MethodReference mr) {
                ClassDef oc = original.get(mr.getDefiningClass());
                Method om = oc == null ? null : find(oc, key(mr));
                if (om != null && AccessFlags.PRIVATE.isSet(om.getAccessFlags())) {
                    if (mut == null) mut = new MutableMethodImplementation(impl);
                    if (in instanceof Instruction35c c) {
                        mut.replaceInstruction(i, new BuilderInstruction35c(Opcode.INVOKE_DIRECT, c.getRegisterCount(),
                                c.getRegisterC(), c.getRegisterD(), c.getRegisterE(), c.getRegisterF(), c.getRegisterG(), mr));
                    } else {
                        Instruction3rc c = (Instruction3rc) in;
                        mut.replaceInstruction(i, new BuilderInstruction3rc(Opcode.INVOKE_DIRECT_RANGE,
                                c.getStartRegister(), c.getRegisterCount(), mr));
                    }
                }
            }
            i++;
        }
        return mut != null ? mut : impl;
    }

    /** Reports compiled code that uses a member the original keeps private in another class. */
    private static void checkAccess(Map<String, Map<String, Method>> take, List<ClassDef> out) {
        Map<String, ClassDef> byType = new HashMap<>();
        for (ClassDef c : out) byType.put(c.getType(), c);
        for (Map<String, Method> ms : take.values()) {
            for (Method m : ms.values()) {
                if (m.getImplementation() == null) continue;
                for (Instruction in : m.getImplementation().getInstructions()) {
                    if (!(in instanceof ReferenceInstruction ri)) continue;
                    if (ri.getReference() instanceof MethodReference mr && !mr.getDefiningClass().equals(m.getDefiningClass())) {
                        ClassDef c = byType.get(mr.getDefiningClass());
                        Method t = c == null ? null : find(c, key(mr));
                        if (t != null && AccessFlags.PRIVATE.isSet(t.getAccessFlags()))
                            System.out.println("WARNING: " + m.getDefiningClass() + "->" + m.getName() + " calls private " + mr.getDefiningClass() + "->" + key(mr));
                    } else if (ri.getReference() instanceof FieldReference fr && !fr.getDefiningClass().equals(m.getDefiningClass())) {
                        ClassDef c = byType.get(fr.getDefiningClass());
                        if (c == null) continue;
                        for (Field f : c.getFields()) {
                            if (f.getName().equals(fr.getName()) && f.getType().equals(fr.getType()) && AccessFlags.PRIVATE.isSet(f.getAccessFlags()))
                                System.out.println("WARNING: " + m.getDefiningClass() + "->" + m.getName() + " uses private " + fr.getDefiningClass() + "->" + fr.getName());
                        }
                    }
                }
            }
        }
    }

    private static boolean calls(Method m, String marker) {
        if (m.getImplementation() == null) return false;
        for (Instruction in : m.getImplementation().getInstructions()) {
            if (in instanceof ReferenceInstruction ri && ri.getReferenceType() == ReferenceType.METHOD
                    && ri.getReference() instanceof MethodReference mr
                    && mr.getDefiningClass().equals(SUPPORT) && mr.getName().equals(marker)) {
                return true;
            }
        }
        return false;
    }

    private static Method find(ClassDef c, String key) {
        for (Method m : c.getMethods()) if (key(m).equals(key)) return m;
        return null;
    }

    private static String key(MethodReference m) {
        return m.getName() + "(" + String.join("", m.getParameterTypes().stream().map(CharSequence::toString).toList()) + ")" + m.getReturnType();
    }
}
