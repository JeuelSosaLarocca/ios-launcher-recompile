"""Propose names for obfuscated fields (fNNNNNx) by comparing with AOSP classes.

Usage: python -I match_fields.py <named_pkg_dir> <aosp_src_dir> <out_tsv>

Signals, strongest first:
  getter/setter  a readable accessor returns/assigns the field in both sources
  resource       the field is assigned from the same R.<type>.<name>
  unique-type    the field's type occurs exactly once among the fields of both classes
"""
import re
import sys
from pathlib import Path

OBF_FIELD_DECL = re.compile(r'^    (?:(?:public|private|protected|static|final|volatile|transient)\s+)*([\w.<>\[\], ?]+?)\s+(f\d+\w*)\s*[;=]', re.M)
AOSP_FIELD_DECL = re.compile(r'^\s+(?:(?:public|private|protected|static|final|volatile|transient)\s+)*([\w.<>\[\], ?]+?)\s+([a-zA-Z_]\w*)\s*(?:;|=[^=])', re.M)
GETTER = r'(\w+)\(\)\s*\{{\s*return (?:this\.)?({f});\s*\}}'
SETTER = r'(set\w+)\(\s*(?:final\s+)?[\w.<>\[\]]+ (\w+)\)\s*\{{\s*(?:this\.)?({f}) = \2;\s*\}}'
RES_ASSIGN = r'(?:this\.)?({f})\s*=\s*[^;]*?\bR\.(\w+\.\w+)'
SKIP_TYPES = {"int", "float", "boolean", "long", "double", "short", "byte", "char", "String", "Object"}
NOT_FIELDS = {"return", "else", "new", "case", "throw"}


def simple(t):
    return re.sub(r'<.*>', '', t).split(".")[-1].strip()


def main(named_dir, aosp_dir, out_path):
    aosp = {f.stem: f for f in Path(aosp_dir).rglob("*.java")}
    rows = []
    for f in sorted(Path(named_dir).glob("*.java")):
        if f.stem not in aosp:
            continue
        o = f.read_text(encoding="utf-8", errors="ignore")
        r = aosp[f.stem].read_text(encoding="utf-8", errors="ignore")
        ofields = {name: simple(t) for t, name in OBF_FIELD_DECL.findall(o)}
        if not ofields:
            continue
        rfields = {name: simple(t) for t, name in AOSP_FIELD_DECL.findall(r)
                   if name not in NOT_FIELDS and simple(t) not in NOT_FIELDS}

        found = {}

        def add(field, name, why):
            if field in ofields and name in rfields and field not in found:
                found[field] = (name, why)

        ogets = {m: fld for m, fld in re.findall(GETTER.format(f=r'f\d+\w*'), o)}
        rgets = {m: fld for m, fld in re.findall(GETTER.format(f=r'[a-zA-Z_]\w*'), r)}
        for m, fld in ogets.items():
            if m in rgets:
                add(fld, rgets[m], f"getter {m}()")
        osets = {m: fld for m, _, fld in re.findall(SETTER.format(f=r'f\d+\w*'), o)}
        rsets = {m: fld for m, _, fld in re.findall(SETTER.format(f=r'[a-zA-Z_]\w*'), r)}
        for m, fld in osets.items():
            if m in rsets:
                add(fld, rsets[m], f"setter {m}()")

        ores = {}
        for fld, res in re.findall(RES_ASSIGN.format(f=r'f\d+\w*'), o):
            ores.setdefault(res, set()).add(fld)
        rres = {}
        for fld, res in re.findall(RES_ASSIGN.format(f=r'[a-zA-Z_]\w*'), r):
            rres.setdefault(res, set()).add(fld)
        for res, flds in ores.items():
            if len(flds) == 1 and len(rres.get(res, ())) == 1:
                add(next(iter(flds)), next(iter(rres[res])), f"resource R.{res}")

        def counts(d):
            c = {}
            for t in d.values():
                c[t] = c.get(t, 0) + 1
            return c
        oc, rc = counts(ofields), counts(rfields)
        for fld, t in ofields.items():
            if t in SKIP_TYPES or oc.get(t) != 1 or rc.get(t) != 1:
                continue
            name = next(n for n, rt in rfields.items() if rt == t)
            add(fld, name, f"unique-type {t}")

        used = {}
        for fld, (name, why) in found.items():
            if name in used:  # two obf fields mapped to one AOSP name: drop the weaker
                continue
            used[name] = fld
            rows.append((f.stem, fld, ofields[fld], name, why))

    with open(out_path, "w", encoding="utf-8") as out:
        out.write("class\tobf\ttype\tproposal\tevidence\n")
        for row in rows:
            out.write("\t".join(row) + "\n")
    print(f"field proposals: {len(rows)}")


if __name__ == "__main__":
    main(*sys.argv[1:4])
