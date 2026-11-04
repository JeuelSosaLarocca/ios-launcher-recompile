"""Summarize javac errors from a Gradle log.

Usage: python -I error_report.py <build.log> [detail_category]
"""
import re
import sys
from collections import Counter, defaultdict


def read(path):
    raw = open(path, "rb").read()
    for enc in ("utf-16", "utf-8"):
        try:
            text = raw.decode(enc)
            if ".java" in text:
                return text
        except UnicodeDecodeError:
            pass
    return raw.decode("utf-8", "replace")


def parse(text):
    lines = text.splitlines()
    errors, seen = [], set()
    for i, line in enumerate(lines):
        m = re.search(r'([\w$]+)\.java:(\d+): error: (.*)$', line)
        if not m:
            continue
        key = (m.group(1), m.group(2), m.group(3))
        if key in seen:
            continue
        seen.add(key)
        extra = []
        for nxt in lines[i + 1:i + 6]:
            s = nxt.strip()
            if s.startswith(("symbol:", "location:", "required:", "found:", "reason:")):
                extra.append(s)
        errors.append((m.group(1), int(m.group(2)), m.group(3), extra))
    return errors


def category(msg):
    msg = re.sub(r'\(.*', '', msg)
    msg = re.sub(r'\b[A-Z]\w*(\.\w+)*\b', 'X', msg)
    return msg[:70]


def main(path, detail=None):
    errors = parse(read(path))
    print(f"unique errors: {len(errors)}  files: {len({e[0] for e in errors})}")
    cats = Counter(category(e[2]) for e in errors)
    for c, n in cats.most_common(25):
        print(f"{n:5d}  {c}")
    if detail:
        print(f"\n--- detail: {detail}")
        groups = defaultdict(list)
        for f, ln, msg, extra in errors:
            if detail in msg:
                sym = next((x for x in extra if x.startswith("symbol:")), msg)
                loc = next((x for x in extra if x.startswith("location:")), "")
                groups[(sym, loc)].append(f"{f}:{ln}")
        for (sym, loc), where in sorted(groups.items(), key=lambda kv: -len(kv[1]))[:60]:
            print(f"{len(where):4d}  {sym}  |  {loc}  |  {where[0]}")
    print("\nby file:")
    for f, n in Counter(e[0] for e in errors).most_common(15):
        print(f"{n:5d}  {f}")


if __name__ == "__main__":
    main(*sys.argv[1:3])
