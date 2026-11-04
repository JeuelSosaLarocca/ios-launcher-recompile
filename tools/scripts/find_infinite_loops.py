"""Find `while (true)` loops with no way out (no break/return/throw inside) and mark their methods.

jadx sometimes drops the `else break;` of a loop (`while (true) { if (i < n) { ... i++; } }`), which
turns it into an endless loop at runtime. Methods containing such a loop get the
JadxSupport.useOriginalBytecode() marker so PostCompile uses the original body.
Constructors and static initializers cannot be marked; they are reported instead.

Usage: python -I find_infinite_loops.py <java_root> [--mark]
"""
import re
import sys
from pathlib import Path

MARKER = "com.luutinhit.launcher6.JadxSupport.useOriginalBytecode();"
DECL = re.compile(r'^(\s+)(?:(?:public|protected|private|static|final|synchronized|/\*[^*]*\*/) )*'
                  r'(?:<[^>]+>\s+)?(?:[\w.<>\[\], ?]+ )?([\w$]+)\([^)]*\)\s*(?:throws [\w., ]+)?\s*\{\s*$')


def strip_strings(line):
    return re.sub(r'"(?:[^"\\]|\\.)*"', '""', line)


def block_end(lines, start):
    depth = 0
    for k in range(start, len(lines)):
        for ch in strip_strings(lines[k]):
            if ch == "{":
                depth += 1
            elif ch == "}":
                depth -= 1
                if depth == 0:
                    return k
    return len(lines) - 1


def main(root, mark=False):
    found = marked = 0
    for f in sorted(Path(root).rglob("*.java")):
        lines = f.read_text(encoding="utf-8").split("\n")
        targets = set()
        for i, line in enumerate(lines):
            if not re.search(r'\bwhile \(true\) \{\s*$', line):
                continue
            end = block_end(lines, i)
            body = "\n".join(strip_strings(l) for l in lines[i + 1:end])
            # nested loops/switches have their own breaks; only labeled breaks or return/throw leave this loop
            exits = re.search(r'\breturn\b|\bthrow\b|\bbreak \w+;', body)
            plain_breaks = re.findall(r'\bbreak;', body)
            nested = re.search(r'\b(while|for|do|switch)\b', body)
            if exits or (plain_breaks and not nested):
                continue
            if plain_breaks and nested:
                continue  # can't tell which construct the breaks belong to
            found += 1
            # enclosing method declaration
            for j in range(i, -1, -1):
                m = DECL.match(lines[j])
                if m and m.group(2) not in ("if", "for", "while", "switch", "catch", "synchronized"):
                    print(f"{f.name}:{i + 1}: endless loop in {m.group(2)}()" + ("  [constructor]" if m.group(2) == f.stem else ""))
                    if m.group(2) != f.stem:
                        targets.add(j)
                    break
        if mark and targets:
            for j in sorted(targets, reverse=True):
                if MARKER not in lines[j + 1]:
                    ind = re.match(r'^(\s*)', lines[j]).group(1)
                    lines.insert(j + 1, f"{ind}    {MARKER} // endless loop in the jadx output; the original bytecode runs")
                    marked += 1
            f.write_text("\n".join(lines), encoding="utf-8", newline="\n")
    print(f"endless loops: {found}, methods marked: {marked}")


if __name__ == "__main__":
    main(sys.argv[1], "--mark" in sys.argv)
