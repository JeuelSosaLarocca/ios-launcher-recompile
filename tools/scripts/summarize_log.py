"""Group unique javac errors in a Gradle log by message shape, with one example each.

Usage: python -I summarize_log.py <build.log> [top]
"""
import collections
import re
import sys


def main(path, top="25"):
    lines = open(path, encoding="utf-8", errors="replace").read().splitlines()
    counts, examples, seen = collections.Counter(), {}, set()
    for i, line in enumerate(lines):
        m = re.search(r'([\w$]+\.java:\d+): error: (.*)$', line)
        if not m or (m.group(1), m.group(2)) in seen:
            continue
        seen.add((m.group(1), m.group(2)))
        shape = re.sub(r'\(.*?\)', '(..)', re.sub(r'\b[A-Z][\w$]*\b', 'X', m.group(2)))[:80]
        counts[shape] += 1
        ctx = [x.strip() for x in lines[i + 1:i + 6] if x.strip().startswith(("symbol", "required", "found", "reason"))]
        examples.setdefault(shape, (m.group(1), m.group(2)[:130], lines[i + 1].strip()[:120], " / ".join(ctx)[:160]))
    print("unique", sum(counts.values()))
    for shape, n in counts.most_common(int(top)):
        f, msg, code, ctx = examples[shape]
        print(f"{n:4d} {shape}\n        {f}: {msg}\n        {code}\n        {ctx}")


if __name__ == "__main__":
    main(*sys.argv[1:3])
