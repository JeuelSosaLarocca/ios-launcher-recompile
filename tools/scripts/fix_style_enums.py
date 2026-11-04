"""Turn raw numbers in decompiled style/theme items back into enum/flag names.

jadx writes `<item name="android:gravity">0x30</item>`; aapt2 wants `top`. Names come from the
framework attrs.xml (SDK platform data) and the app's own res/values/attrs.xml.

Usage: python -I fix_style_enums.py <res_dir> <platform_attrs.xml>
"""
import re
import sys
import xml.etree.ElementTree as ET
from pathlib import Path


def load_attrs(path, prefix):
    out = {}
    root = ET.parse(path).getroot()
    for attr in root.iter("attr"):
        name = attr.get("name")
        kids = [(c.tag, c.get("name"), c.get("value")) for c in attr if c.tag in ("enum", "flag")]
        if name and kids:
            kind = "flag" if kids[0][0] == "flag" else "enum"
            vals = []
            for _, n, v in kids:
                try:
                    vals.append((n, int(v, 0) & 0xFFFFFFFF))
                except (TypeError, ValueError):
                    pass
            if vals:
                out.setdefault(prefix + name, (kind, vals))
    return out


def to_name(kind, vals, number):
    number &= 0xFFFFFFFF
    exact = [n for n, v in vals if v == number]
    if exact:
        return exact[0]
    if kind == "flag":
        # greedy: biggest masks first, each must be fully contained
        rest, names = number, []
        for n, v in sorted(vals, key=lambda x: -bin(x[1]).count("1")):
            if v and rest & v == v:
                names.append(n)
                rest &= ~v
        if rest == 0 and names:
            return "|".join(names)
    return None


def main(res_dir, platform_attrs):
    attrs = load_attrs(platform_attrs, "android:")
    app_attrs = Path(res_dir) / "values" / "attrs.xml"
    if app_attrs.exists():
        attrs.update(load_attrs(app_attrs, ""))
    item = re.compile(r'(<item name="([\w:.]+)">)(-?(?:0x[0-9a-fA-F]+|\d+))(</item>)')
    fixed, unknown = 0, set()
    for f in Path(res_dir).glob("values*/*.xml"):
        s = f.read_text(encoding="utf-8")

        def repl(m):
            nonlocal fixed
            a = attrs.get(m.group(2))
            if not a:
                return m.group(0)
            name = to_name(a[0], a[1], int(m.group(3), 0))
            if name is None:
                unknown.add((m.group(2), m.group(3)))
                return m.group(0)
            fixed += 1
            return m.group(1) + name + m.group(4)

        t = item.sub(repl, s)
        if t != s:
            f.write_text(t, encoding="utf-8", newline="\n")
    print(f"values converted: {fixed}")
    for a, v in sorted(unknown):
        print(f"  no name for {a} = {v}")


if __name__ == "__main__":
    main(*sys.argv[1:3])
