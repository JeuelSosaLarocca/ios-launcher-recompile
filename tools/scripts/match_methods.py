"""Propose names for obfuscated methods by comparing them with AOSP methods.

Usage: python -I match_methods.py <named_pkg_dir> <aosp_src_dir> <out_tsv>

Only jadx-generated names like m1234a are considered (mo* overrides are skipped,
they must be renamed on the interface that declares them).
"""
import re
import sys
from pathlib import Path

HEADER_RE = re.compile(
    r'^(?P<indent>[ \t]*)(?:@\w+[^\n]*\n[ \t]*)*'
    r'(?:(?:public|private|protected|static|final|abstract|synchronized|native)\s+)*'
    r'(?:<[^>]+>\s+)?(?P<ret>[\w.<>\[\], ?]+?)\s+(?P<name>\w+)\s*\((?P<params>[^)]*)\)'
    r'\s*(?:throws [\w., ]+)?\s*\{',
    re.M,
)
STRING_RE = re.compile(r'"((?:[^"\\\n]|\\.){2,})"')
RES_RE = re.compile(r'\bR\.(\w+\.\w+)')
CALL_RE = re.compile(r'\.?\b([a-zA-Z_]\w*)\s*\(')
OBF_RE = re.compile(r'^(m\d{3,5}[A-Za-z]*|mo\d{2,5}[A-Za-z]*|[a-z]\d?|f\d+\w*)$')
KEYWORDS = {"if", "for", "while", "switch", "catch", "return", "new", "synchronized", "super", "this", "throw"}


def simple_type(t):
    t = re.sub(r'<.*>', '', t).strip()
    t = t.replace("final ", "").split(".")[-1]
    return t


def parse_params(params):
    out = []
    for p in [p.strip() for p in params.split(",") if p.strip()]:
        parts = p.replace("final ", "").rsplit(" ", 1)
        out.append(simple_type(parts[0]))
    return tuple(out)


def body_at(text, start):
    depth, i = 0, start
    while i < len(text):
        c = text[i]
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
            if depth == 0:
                return text[start:i + 1]
        elif c == '"':
            i += 1
            while i < len(text) and text[i] != '"':
                i += 2 if text[i] == "\\" else 1
        i += 1
    return text[start:]


def methods_of(text, only_top_level):
    result = []
    for m in HEADER_RE.finditer(text):
        name = m.group("name")
        if name in KEYWORDS or m.group("ret") in KEYWORDS:
            continue
        if only_top_level and m.group("indent") != "    ":
            continue
        body = body_at(text, m.end() - 1)
        calls = {c for c in CALL_RE.findall(body) if c not in KEYWORDS and not OBF_RE.match(c)}
        result.append({
            "name": name,
            "ret": simple_type(m.group("ret")),
            "params": parse_params(m.group("params")),
            "strings": set(STRING_RE.findall(body)),
            "res": set(RES_RE.findall(body)),
            "calls": calls,
            "lines": body.count("\n"),
        })
    return result


def jacc(a, b):
    return len(a & b) / len(a | b) if a or b else 0.0


def score(o, r):
    s = 4 * jacc(o["strings"], r["strings"]) + 4 * jacc(o["res"], r["res"]) + 2.5 * jacc(o["calls"], r["calls"])
    if o["params"] == r["params"]:
        s += 1.5
    elif len(o["params"]) == len(r["params"]):
        s += 0.4
    if o["ret"] == r["ret"]:
        s += 0.6
    ratio = min(o["lines"], r["lines"]) / max(o["lines"], r["lines"], 1)
    return s + 0.5 * ratio


def aosp_sources(aosp_dir):
    """Map class name -> source text, for top-level files and inner classes."""
    sources = {}
    for f in Path(aosp_dir).rglob("*.java"):
        text = f.read_text(encoding="utf-8", errors="ignore")
        sources.setdefault(f.stem, text)
        for m in re.finditer(r'\bclass (\w+)[^{;]*\{', text):
            if m.group(1) != f.stem:
                sources.setdefault(m.group(1), body_at(text, m.end() - 1))
    return sources


def main(named_dir, aosp_dir, out_path):
    aosp = aosp_sources(aosp_dir)
    rows = []
    for f in sorted(Path(named_dir).glob("*.java")):
        ref_text = aosp.get(f.stem)
        if not ref_text:
            continue
        obf = [m for m in methods_of(f.read_text(encoding="utf-8", errors="ignore"), True)
               if re.match(r'^m\d{3,5}[A-Za-z]*$', m["name"])]
        if not obf:
            continue
        refm = [m for m in methods_of(ref_text, False) if not OBF_RE.match(m["name"])]
        existing = {m["name"] for m in methods_of(f.read_text(encoding="utf-8", errors="ignore"), True)}
        cands = []
        for o in obf:
            ranked = sorted(((score(o, r), r["name"], r) for r in refm if r["name"] not in existing),
                            key=lambda x: -x[0])
            if ranked:
                cands.append((o, ranked))
        # greedy unique assignment, best scores first
        taken, chosen = set(), {}
        for o, ranked in sorted(cands, key=lambda c: -c[1][0][0]):
            for sc, name, r in ranked:
                if (name, r["params"]) in taken:
                    continue
                second = next((x[0] for x in ranked if x[1] != name), 0.0)
                chosen[o["name"]] = (sc, second, name, r)
                taken.add((name, r["params"]))
                break
        for o, _ in cands:
            if o["name"] not in chosen:
                continue
            sc, second, name, r = chosen[o["name"]]
            ev = sorted(o["strings"] & r["strings"])[:2] + sorted(o["res"] & r["res"])[:2]
            rows.append((f.stem, o["name"], ",".join(o["params"]), name, ",".join(r["params"]),
                         f"{sc:.2f}", f"{second:.2f}", " | ".join(ev)))
    with open(out_path, "w", encoding="utf-8") as out:
        out.write("class\tobf\tobf_params\tproposal\taosp_params\tscore\tsecond\tevidence\n")
        for row in rows:
            out.write("\t".join(row) + "\n")
    print(f"proposals: {len(rows)}")


if __name__ == "__main__":
    main(*sys.argv[1:4])
