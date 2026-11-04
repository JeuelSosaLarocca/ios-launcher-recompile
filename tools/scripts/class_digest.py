"""Write a compact digest of obfuscated classes: header, fields, methods, strings, users.

Usage: python -I class_digest.py <sources_root> <package_dir_rel> <out_txt>
"""
import re
import sys
from pathlib import Path

OBF_NAME_RE = re.compile(r'^([A-Za-z]\d|.*C\d{4}.*|.*Abstract.*\d.*|Interface.*\d.*|Enum.*\d.*)$')
HEADER_RE = re.compile(r'^\s*(public |private |protected |static |final |abstract )*(class|interface|enum) .*\{')
FIELD_RE = re.compile(r'^    (public |private |protected |static |final |volatile |transient )*[\w.<>\[\], ?]+ \w+( = .{0,40})?;')
METHOD_RE = re.compile(r'^    (public |private |protected |static |final |abstract |synchronized |native )*[\w.<>\[\], ?]+ \w+\(.*\)( throws [\w., ]+)? ?[{;]')
STRING_RE = re.compile(r'"((?:[^"\\\n]|\\.){3,80})"')


def main(root, pkg_rel, out_path):
    root = Path(root)
    pkg = root / pkg_rel
    targets = [f for f in sorted(pkg.rglob("*.java")) if OBF_NAME_RE.match(f.stem)]
    texts = {f: f.read_text(encoding="utf-8", errors="ignore") for f in pkg.parent.rglob("*.java")}

    with open(out_path, "w", encoding="utf-8") as out:
        for f in targets:
            text = texts[f]
            lines = text.splitlines()
            header = next((l.strip() for l in lines if HEADER_RE.match(l)), "?")
            fields = [l.strip() for l in lines if FIELD_RE.match(l)][:25]
            methods = [l.strip().rstrip("{").strip() for l in lines if METHOD_RE.match(l)][:30]
            strings = sorted(set(STRING_RE.findall(text)))[:12]
            word = re.compile(r'\b' + re.escape(f.stem) + r'\b')
            users = sorted({g.stem for g, t in texts.items() if g != f and word.search(t)})[:12]
            out.write(f"### {f.relative_to(pkg)} ({len(lines)} lines)\n{header}\n")
            if fields:
                out.write("  F: " + " || ".join(fields) + "\n")
            if methods:
                out.write("  M: " + " || ".join(methods) + "\n")
            if strings:
                out.write("  S: " + " | ".join(strings) + "\n")
            if users:
                out.write("  U: " + ", ".join(users) + "\n")


if __name__ == "__main__":
    main(*sys.argv[1:4])
