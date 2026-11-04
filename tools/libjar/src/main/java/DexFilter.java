import com.android.tools.smali.dexlib2.DexFileFactory;
import com.android.tools.smali.dexlib2.Opcodes;
import com.android.tools.smali.dexlib2.dexbacked.DexBackedClassDef;
import com.android.tools.smali.dexlib2.dexbacked.DexBackedDexFile;
import com.android.tools.smali.dexlib2.iface.ClassDef;
import com.android.tools.smali.dexlib2.immutable.ImmutableDexFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Writes the original classes.dex without the app classes that are now compiled from source,
 * so the library code runs exactly as shipped.
 *
 * Usage: DexFilter &lt;original.apk&gt; &lt;mapping.tiny&gt; &lt;app-java-root&gt; &lt;out.dex&gt;
 */
public final class DexFilter {
    public static void main(String[] args) throws Exception {
        Map<String, String> named = new HashMap<>();
        for (String line : Files.readAllLines(Path.of(args[1]))) {
            String[] p = line.split("\t");
            if (p.length == 3 && p[0].equals("CLASS")) named.put(p[1], p[2]);
        }
        File srcRoot = new File(args[2]);

        DexBackedDexFile dex = DexFileFactory.loadDexEntry(new File(args[0]), "classes.dex", true, null).getDexFile();
        List<ClassDef> kept = new ArrayList<>();
        int dropped = 0;
        for (DexBackedClassDef c : dex.getClasses()) {
            String official = c.getType().substring(1, c.getType().length() - 1);
            String n = named.getOrDefault(official, official);
            String top = n.split("\\$")[0];
            if (new File(srcRoot, top + ".java").exists()) {
                dropped++;
            } else {
                kept.add(c);
            }
        }
        Opcodes opcodes = dex.getOpcodes();
        DexFileFactory.writeDexFile(args[3], new ImmutableDexFile(opcodes, kept));
        System.out.println("kept " + kept.size() + " classes, dropped " + dropped + " compiled from source");
    }
}
