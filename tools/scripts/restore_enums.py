"""Rewrite classes jadx could not restore as enums ("Failed to restore enum class") into real enums.

The constants keep their names and order (so name()/ordinal()/valueOf() behave as before) and the
obfuscated static fields stay as aliases, because other code reads them.

Usage: python -I restore_enums.py <file.java> [...]
"""
import re
import sys
from pathlib import Path


def convert(path):
    s = Path(path).read_text(encoding='utf-8')
    pkg = re.search(r'^package ([\w.]+);', s, re.M).group(1)
    cls = re.search(r'^public final class (\w+)', s, re.M).group(1)
    consts = re.findall(r'new ' + cls + r'\("(\w+)", (\d+)\)', s)
    consts = [n for n, _ in sorted(consts, key=lambda c: int(c[1]))]
    # alias fields: `fNNN = local;` where local = new Cls("NAME", i)
    locals_ = dict(re.findall(r'(\w+) = new ' + cls + r'\("(\w+)", \d+\);', s))
    aliases = [(f, locals_[l]) for f, l in re.findall(r'^\s+(f\d+\w*) = (\w+);', s, re.M) if l in locals_]
    array = re.search(r'(?:/\* synthetic \*/ )?' + cls + r'\[\] (f\d+\w*)', s).group(1)
    out = [f'package {pkg};', '',
           '/* Restored as an enum: the bytecode is `final class extends java.lang.Enum`, which jadx could not',
           '   turn back into source. Obfuscated fields are kept as aliases of the constants. */',
           f'public enum {cls} {{', '    ' + ', '.join(consts) + ';', '']
    for f, n in aliases:
        out.append(f'    public static final {cls} {f} = {n};')
    out.append(f'    public static final {cls}[] {array} = values();')
    out.append('}')
    Path(path).write_text('\n'.join(out) + '\n', encoding='utf-8', newline='\n')
    print(cls, consts, len(aliases), 'aliases')


for p in sys.argv[1:]:
    convert(p)
