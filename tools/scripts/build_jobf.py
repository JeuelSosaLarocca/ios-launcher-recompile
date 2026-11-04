"""Merge manual names (manual.tsv) into jadx's auto-generated map (auto.jobf).

Usage: python -I build_jobf.py <auto.jobf> <manual.tsv> <out.jobf>

manual.tsv uses the names shown in decompiled-deobf/ (jadx aliases); this script
resolves them back to the dex names jadx expects in a .jobf file.
"""
import re
import sys

MEMBER_RE = re.compile(r'^([fm]) (.+?)\.([^.:(]+)([:(].*) = (.+)$')


def main(auto_path, manual_path, out_path):
    lines = open(auto_path, encoding="utf-8").read().splitlines()

    class_alias = {}  # dex full name -> alias
    for line in lines:
        if line.startswith("c "):
            dex, alias = line[2:].split(" = ", 1)
            class_alias[dex] = alias

    alias_to_dex = {}
    for dex, alias in class_alias.items():
        pkg = dex.rsplit(".", 1)[0]
        alias_to_dex[f"{pkg}.{alias}"] = dex

    entries = []
    for raw in open(manual_path, encoding="utf-8-sig"):
        raw = raw.rstrip("\n")
        if not raw.strip() or raw.startswith("#"):
            continue
        entries.append(raw.split("\t"))

    # Classes first, so members can also be written against the new class names.
    class_overrides = {}
    for current, new in entries:
        if "#" not in current:
            dex = alias_to_dex.get(current, current)
            class_overrides[dex] = new
            pkg = current.rsplit(".", 1)[0]
            alias_to_dex.setdefault(f"{pkg}.{new}", dex)

    member_overrides = {}
    for current, new in entries:
        if "#" in current:
            cls, member = current.split("#")
            member_overrides[(alias_to_dex.get(cls, cls), member)] = new

    out, seen_classes, used_members = [], set(), set()
    for line in lines:
        if line.startswith("c "):
            dex, _ = line[2:].split(" = ", 1)
            if dex in class_overrides:
                line = f"c {dex} = {class_overrides[dex]}"
                seen_classes.add(dex)
        else:
            m = MEMBER_RE.match(line)
            if m:
                key = (m.group(2), m.group(5))
                if key in member_overrides:
                    line = f"{m.group(1)} {m.group(2)}.{m.group(3)}{m.group(4)} = {member_overrides[key]}"
                    used_members.add(key)
        out.append(line)

    for dex, new in class_overrides.items():
        if dex not in seen_classes:
            out.append(f"c {dex} = {new}")

    with open(out_path, "w", encoding="utf-8") as f:
        f.write("\n".join(out) + "\n")

    missing = [k for k in member_overrides if k not in used_members]
    print(f"classes: {len(class_overrides)}  members: {len(used_members)}/{len(member_overrides)}")
    for cls, member in missing:
        print(f"  member not found in auto map: {cls}#{member}")


if __name__ == "__main__":
    main(*sys.argv[1:4])
