"""Mechanical fixes for jadx output so javac accepts it.

- private -> public on declarations (dex allowed cross-class access that javac rejects)
- drop `final` on non-static field/variable declarations (jadx keeps `final` on fields
  that the bytecode assigns outside constructors)

Usage: python -I relax_modifiers.py <java_root>
"""
import re
import sys
from pathlib import Path

DECL_PRIVATE = re.compile(r'^(\s*(?:@\w+(?:\([^)]*\))?\s+)*)private\b', re.M)
FINAL_VAR = re.compile(r'^(\s*(?:(?:public|protected|private|volatile|transient)\s+)*)final\s+(?=[\w.<>\[\], ?]+\s+\w+\s*(?:=[^=]|;))', re.M)


def main(root):
    changed = 0
    for f in Path(root).rglob("*.java"):
        s = f.read_text(encoding="utf-8")
        t = DECL_PRIVATE.sub(r'\1public', s)
        t = "\n".join(FINAL_VAR.sub(r'\1', line) if "static" not in line else line for line in t.split("\n"))
        if t != s:
            f.write_text(t, encoding="utf-8", newline="\n")
            changed += 1
    print(f"files changed: {changed}")


if __name__ == "__main__":
    main(sys.argv[1])
