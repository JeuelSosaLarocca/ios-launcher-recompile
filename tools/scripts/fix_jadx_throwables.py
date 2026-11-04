"""Fix jadx try/catch artifacts: `th = th;`, dangling `th = th2;` and undeclared rethrows.

Usage: python -I fix_jadx_throwables.py <java_root>
"""
import re
import sys
from pathlib import Path

SELF_ASSIGN = re.compile(r'^\s*(th\d*) = \1;\n', re.M)
DANGLING = re.compile(r'^(\s*)th = (th\d+);\n(?=\s*\})', re.M)
RETHROW = re.compile(r'\bthrow (th\d*);')
SUPPORT = 'com.luutinhit.launcher6.JadxSupport'


def main(root):
    changed = 0
    for f in Path(root).rglob("*.java"):
        if f.name == "JadxSupport.java":
            continue
        s = f.read_text(encoding="utf-8")
        t = SELF_ASSIGN.sub("", s)
        t = DANGLING.sub(lambda m: f"{m.group(1)}throw {SUPPORT}.sneaky({m.group(2)});\n", t)
        t = RETHROW.sub(lambda m: f"throw {SUPPORT}.sneaky({m.group(1)});", t)
        if t != s:
            f.write_text(t, encoding="utf-8", newline="\n")
            changed += 1
    print(f"files changed: {changed}")


if __name__ == "__main__":
    main(sys.argv[1])
