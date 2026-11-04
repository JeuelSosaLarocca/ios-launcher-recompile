"""Make methods that jadx flagged run their original bytecode.

Inserts `com.luutinhit.launcher6.JadxSupport.useOriginalBytecode();` as the first statement of every
method whose JADX WARN comments say the decompiled body may be wrong (duplicated code, failed type
inference, restructure failures, ...). PostCompile then swaps in the original method body.
Constructors are skipped (nothing may come before super()), as are methods listed in EXCLUDE.

Usage: python -I mark_original_bytecode.py <java_root>
"""
import re
import sys
from pathlib import Path

RISKY = ("Code duplicated", "type inference failed", "Type inference failed", "Code restructure failed",
         "Instruction removed", "Unreachable blocks removed", "incorrect switch cases order",
         "multi-entry loop", "Failed to find 'out' block", "Type inference fix")
# methods deliberately changed in the source (see docs/RECOMPILE-NOTES.md)
EXCLUDE = {("LauncherProvider.java", "loadDefaultFavoritesIfNecessary")}
MARKER = "com.luutinhit.launcher6.JadxSupport.useOriginalBytecode();"
DECL = re.compile(r'^(\s+)(?:(?:public|protected|private|static|final|synchronized|/\*[^*]*\*/) )*'
                  r'(?:<[^>]+>\s+)?[\w.<>\[\], ?]+ ([\w$]+)\([^)]*\)\s*(?:throws [\w., ]+)?\s*\{\s*$')


def main(root):
    marked = 0
    for f in Path(root).rglob("*.java"):
        lines = f.read_text(encoding="utf-8").split("\n")
        out, changed = [], False
        for i, line in enumerate(lines):
            out.append(line)
            m = DECL.match(line)
            if not m or (f.name, m.group(2)) in EXCLUDE or m.group(2) == f.stem:  # skip constructors
                continue
            # collect the comment/annotation block right above the declaration
            j, warns = i - 1, []
            while j >= 0 and re.match(r'^\s*(/\*|\*|@|//)', lines[j]):
                warns.append(lines[j])
                j -= 1
            if not any("JADX WARN" in w and any(r in w for r in RISKY) for w in warns):
                continue
            if i + 1 < len(lines) and MARKER in lines[i + 1]:
                continue
            out.append(f"{m.group(1)}    {MARKER} // jadx flagged this method; the original bytecode runs")
            marked += 1
            changed = True
        if changed:
            f.write_text("\n".join(out), encoding="utf-8", newline="\n")
    print(f"methods marked: {marked}")


if __name__ == "__main__":
    main(sys.argv[1])
