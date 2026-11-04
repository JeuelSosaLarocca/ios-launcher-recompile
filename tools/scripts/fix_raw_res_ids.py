"""Replace raw resource IDs left in decompiled resource XML with symbolic references.

jadx writes `android:drawable="0x7f08000c"` (and `?unknown_ref: 7f08002b` in styles) when it cannot
name a resource. aapt2 rejects both.
  * the ID is known (public.xml, or stable-ids.txt, which also has the density-split resources)
        -> @type/name  (?attr/name for an attribute reference)
  * the ID is unknown (removed by the original build's resource shrinker) -> @null

Usage: python -I fix_raw_res_ids.py <res_dir> <public.xml> [stable-ids.txt]
"""
import re
import sys
from pathlib import Path


def load_ids(public_xml, stable_ids=None):
    ids = {}
    for t, n, i in re.findall(r'<public type="(\w+)" name="([^"]+)" id="(0x[0-9a-f]+)"', Path(public_xml).read_text(encoding="utf-8")):
        ids[int(i, 16)] = (t, n)
    if stable_ids:
        for t, n, i in re.findall(r':(\w+)/(\S+) = (0x[0-9a-f]+)', Path(stable_ids).read_text(encoding="utf-8")):
            ids.setdefault(int(i, 16), (t, n))
    return ids


def ref(ids, number, attr_ref):
    res = ids.get(number)
    if res is None:
        return None
    t, n = res
    return f"?attr/{n}" if (attr_ref and t == "attr") else f"@{t}/{n}"


def main(res_dir, public_xml, stable_ids=None):
    ids = load_ids(public_xml, stable_ids)
    raw = re.compile(r'(=")(\??)(0x7f[0-9a-fA-F]{6})(")')
    unknown = re.compile(r'\?unknown_ref: ([0-9a-fA-F]{8})')
    named = nulled = 0
    for f in Path(res_dir).rglob("*.xml"):
        s = f.read_text(encoding="utf-8")

        def repl_raw(m):
            nonlocal named, nulled
            r = ref(ids, int(m.group(3), 16), m.group(2) == "?")
            if r is None:
                nulled += 1
                return m.group(1) + "@null" + m.group(4)
            named += 1
            return m.group(1) + r + m.group(4)

        def repl_unknown(m):
            nonlocal named, nulled
            r = ref(ids, int(m.group(1), 16), True)
            if r is None:
                nulled += 1
                return "@null"
            named += 1
            return r

        t = unknown.sub(repl_unknown, raw.sub(repl_raw, s))
        if t != s:
            f.write_text(t, encoding="utf-8", newline="\n")
    print(f"named: {named}, set to @null (resource removed by the original build): {nulled}")


if __name__ == "__main__":
    main(*sys.argv[1:4])
