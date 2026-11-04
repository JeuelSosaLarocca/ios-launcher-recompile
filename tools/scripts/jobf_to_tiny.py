"""Convert a jadx .jobf rename map into a Tiny v1 mapping (official -> named).

Usage: python -I jobf_to_tiny.py <final.jobf> <classes.txt> <out.tiny>

classes.txt lists every class in the jar, one internal name per line (a/b/C$D),
because classes that are only affected by a package rename have no 'c' line.
"""
import re
import sys

MEMBER_RE = re.compile(r'^([fm]) (.+?)\.([^.:(]+)([:(].*) = (.+)$')


def main(jobf_path, classes_path, out_path):
    pkg_alias, cls_alias, members = {}, {}, []
    for line in open(jobf_path, encoding="utf-8"):
        line = line.rstrip("\n")
        if line.startswith("p "):
            src, alias = line[2:].split(" = ", 1)
            pkg_alias[src] = alias
        elif line.startswith("c "):
            src, alias = line[2:].split(" = ", 1)
            cls_alias[src.replace(".", "/")] = alias
        else:
            m = MEMBER_RE.match(line)
            if m:
                kind, owner, name, desc, alias = m.groups()
                members.append((kind, owner.replace(".", "/"), name, desc.lstrip(":"), alias))

    cache = {}

    def named(cls):
        if cls in cache:
            return cache[cls]
        if "$" in cls.rsplit("/", 1)[-1]:
            outer, inner = cls.rsplit("$", 1)
            result = named(outer) + "$" + cls_alias.get(cls, inner)
        else:
            pkg, _, simple = cls.rpartition("/")
            if pkg:
                first, _, rest = pkg.partition("/")
                pkg = pkg_alias.get(first, first) + (("/" + rest) if rest else "")
            result = (pkg + "/" if pkg else "") + cls_alias.get(cls, simple)
        cache[cls] = result
        return result

    classes = [c.strip() for c in open(classes_path, encoding="utf-8") if c.strip()]
    with open(out_path, "w", encoding="utf-8", newline="\n") as out:
        out.write("v1\tofficial\tnamed\n")
        changed = 0
        for c in classes:
            n = named(c)
            if n != c:
                changed += 1
            out.write(f"CLASS\t{c}\t{n}\n")
        for kind, owner, name, desc, alias in members:
            tag = "FIELD" if kind == "f" else "METHOD"
            out.write(f"{tag}\t{owner}\t{desc}\t{name}\t{alias}\n")
    print(f"classes: {len(classes)} (renamed {changed})  members: {len(members)}")


if __name__ == "__main__":
    main(*sys.argv[1:4])
