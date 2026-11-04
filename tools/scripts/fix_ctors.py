"""Add the pass-through constructors R8 removed, based on javac errors.

R8 drops constructors that only call super(...); creation sites then call the superclass
constructor directly, which dex allows. For each `new X(args)` javac rejects:
  * X compiled from source -> add `public X(args) { super(args); }` to X.java
  * X from the library jar -> append "X desc" to extra-ctors.txt for Desynth

Usage: python -I fix_ctors.py <build.log> <java_root> <javap> <classpath> <extra-ctors.txt>
"""
import re
import subprocess
import sys
from pathlib import Path

PRIM = {'int': 'I', 'boolean': 'Z', 'float': 'F', 'long': 'J', 'double': 'D', 'char': 'C', 'byte': 'B', 'short': 'S'}


def javap(tool, cp, cls, cache={}):
    if cls not in cache:
        out = subprocess.run([tool, '-p', '-cp', cp, cls], capture_output=True, text=True).stdout
        sup = re.search(r'class [\w.$]+(?:<.*?>)? extends ([\w.$]+)', out)
        simple = cls.split('.')[-1]
        ctors = [[t.strip() for t in m.group(1).split(',') if t.strip()]
                 for m in re.finditer(r'^\s+(?:public|protected)?\s*' + re.escape(cls) + r'\((.*?)\);', out, re.M)]
        cache[cls] = (sup.group(1) if sup else None, ctors, bool(out))
    return cache[cls]


def simple_name(t):
    return re.split(r'[.$]', t)[-1]


def desc_of(types):
    out = []
    for t in types:
        dims = t.count('[]')
        base = t.replace('[]', '')
        out.append('[' * dims + (PRIM[base] if base in PRIM else 'L' + base.replace('.', '/') + ';'))
    return '(' + ''.join(out) + ')V'


def resolve(src_file, name, root):
    """FQN of a simple class name as seen from src_file."""
    text = src_file.read_text(encoding='utf-8')
    m = re.search(r'^import ([\w.]+\.' + re.escape(name) + r');', text, re.M)
    if m:
        return m.group(1)
    pkg = re.search(r'^package ([\w.]+);', text, re.M).group(1)
    if (root / pkg.replace('.', '/') / f'{name}.java').exists():
        return f'{pkg}.{name}'
    hits = list(root.rglob(f'{name}.java'))
    if len(hits) == 1:
        return '.'.join(hits[0].relative_to(root).with_suffix('').parts)
    return f'{pkg}.{name}'


def main(log, root, tool, cp, extra_path):
    root = Path(root)
    lines = open(log, encoding='utf-8', errors='replace').read().splitlines()
    wanted = {}
    for i, l in enumerate(lines):
        m = re.search(r'^\s*(.*?\.java):\d+: error: (?:constructor (\w+) in class \w+ cannot be applied to given types;|no suitable constructor found for (\w+)\((.*?)\))', l)
        if not m:
            sm = re.search(r'^\s*(.*?\.java):\d+: error: cannot find symbol', l)
            sym = next((x.strip() for x in lines[i + 1:i + 5] if x.strip().startswith('symbol')), '') if sm else ''
            cm = re.match(r'symbol:\s+constructor (\w+)\((.*)\)$', sym)
            if not cm:
                continue
            fqn = resolve(Path(sm.group(1)), cm.group(1), root)
            args = [a.strip() for a in cm.group(2).split(',') if a.strip()]
            wanted.setdefault(fqn, set()).add(tuple(args))
            continue
        cls = m.group(2) or m.group(3)
        if m.group(3) is not None:
            found = m.group(4)
        else:
            found = next((x.strip()[len('found:'):].strip() for x in lines[i + 1:i + 6] if x.strip().startswith('found:')), None)
        if found is None:
            continue
        args = [] if found in ('', 'no arguments') else [a.strip() for a in found.split(',')]
        fqn = resolve(Path(m.group(1)), cls, root)
        wanted.setdefault(fqn, set()).add(tuple(args))

    extra, added = [], 0
    for fqn, arg_sets in sorted(wanted.items()):
        sup, _, ok = javap(tool, cp, fqn)
        if not ok:
            print('not found:', fqn); continue
        src = root / (fqn.replace('.', '/') + '.java')
        for args in sorted(arg_sets):
            # parameter types: a constructor of the nearest ancestor that takes these arguments
            types, owner = None, sup
            while owner and types is None:
                _, ctors, ok2 = javap(tool, cp, owner)
                if not ok2:
                    break
                for c in ctors:
                    if len(c) == len(args) and all(simple_name(a) == simple_name(b) or a in ('null', '<null>') for a, b in zip(args, c)):
                        types = c; break
                if types is None:
                    owner = javap(tool, cp, owner)[0]
            if types is None:
                if not args:
                    types = []
                else:
                    print('no matching super constructor:', fqn, args); continue
            if src.exists():
                text = src.read_text(encoding='utf-8')
                simple = fqn.split('.')[-1]
                params = ', '.join(f'{t.replace("$", ".")} p{k}' for k, t in enumerate(types))
                call = ', '.join(f'p{k}' for k in range(len(types)))
                ctor = (f'\n    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */\n'
                        f'    public {simple}({params}) {{\n        super({call});\n    }}\n')
                if f'public {simple}({params})' in text:
                    continue
                m = re.search(r'^public [\w /*]*(?:class) ' + simple + r'\b[^{]*\{\r?\n', text, re.M)
                if not m:
                    print('class declaration not found:', fqn); continue
                src.write_text(text[:m.end()] + ctor + text[m.end():], encoding='utf-8', newline='\n')
                added += 1
            else:
                extra.append(f'{fqn.replace(".", "/")} {desc_of(types)}')
    with open(extra_path, 'a', encoding='utf-8') as f:
        for e in extra:
            f.write(e + '\n')
    print(f'source constructors added: {added}, library constructors requested: {len(extra)}')


if __name__ == '__main__':
    main(*sys.argv[1:6])
