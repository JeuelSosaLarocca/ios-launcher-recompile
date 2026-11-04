"""Match obfuscated classes against a reference source tree by shared string literals.

Usage: python -I match_strings.py <obfuscated_dir> <reference_dir> <out_tsv>
"""
import re
import sys
from pathlib import Path

STRING_RE = re.compile(r'"((?:[^"\\]|\\.){4,})"')
OBF_NAME_RE = re.compile(r'^([A-Za-z]\d|.*C\d{4}.*|.*Abstract.*\d.*|Interface.*\d.*|Enum.*\d.*)$')


def strings_of(path):
    text = path.read_text(encoding="utf-8", errors="ignore")
    return {s for s in STRING_RE.findall(text) if not s.startswith("/* ")}


def main(obf_dir, ref_dir, out_path):
    refs = {}
    for f in Path(ref_dir).rglob("*.java"):
        s = strings_of(f)
        if s:
            refs[f.stem] = s

    rows = []
    for f in sorted(Path(obf_dir).glob("*.java")):
        if not OBF_NAME_RE.match(f.stem):
            continue
        s = strings_of(f)
        best = []
        for name, rs in refs.items():
            shared = s & rs
            if shared:
                best.append((len(shared), name, sorted(shared)[:4]))
        best.sort(reverse=True)
        top = best[:3]
        rows.append((f.stem, len(s), top))

    with open(out_path, "w", encoding="utf-8") as out:
        for stem, n, top in rows:
            cands = " | ".join(f"{name}({cnt}: {', '.join(ex)})" for cnt, name, ex in top)
            out.write(f"{stem}\t{n}\t{cands}\n")


if __name__ == "__main__":
    main(*sys.argv[1:4])
