"""List every unique javac error in a Gradle log, sorted by file and line, with its context.

Usage: python -I list_errors.py <build.log> [file-filter]
"""
import re
import sys


def main(path, only=None):
    lines = open(path, encoding="utf-8", errors="replace").read().splitlines()
    seen, rows = set(), []
    for i, line in enumerate(lines):
        m = re.search(r'([\w$]+\.java):(\d+): error: (.*)$', line)
        if not m or (m.group(1), m.group(2), m.group(3)) in seen:
            continue
        if only and only not in m.group(1):
            continue
        seen.add((m.group(1), m.group(2), m.group(3)))
        ctx = " / ".join(x.strip() for x in lines[i + 1:i + 6] if x.strip().startswith(("symbol", "found", "location")))
        rows.append((m.group(1), int(m.group(2)), m.group(3)[:100], lines[i + 1].strip()[:100], ctx[:120]))
    print(len(rows))
    for f, ln, msg, code, ctx in sorted(rows):
        print(f"{f}:{ln}: {msg}\n      {code}\n      {ctx}")


if __name__ == "__main__":
    main(*sys.argv[1:3])
