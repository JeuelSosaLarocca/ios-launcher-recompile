"""Replace a huge `static final byte[] X = {...};` literal with a Base64 string decoded at class init.

javac fails with "code too large" when an array literal pushes <clinit> past 64 KB of bytecode.
The bytes stay identical; only how they are stored changes.

Usage: python -I array_to_base64.py <file.java> <fieldName>
"""
import base64
import re
import sys
from pathlib import Path

CHUNK = 60000  # each string constant must stay under 65535 bytes in the constant pool


def main(path, field):
    p = Path(path)
    s = p.read_text(encoding="utf-8")
    m = re.search(r'(public static final byte\[\] ' + re.escape(field) + r') = \{([^}]*)\};', s)
    if not m:
        raise SystemExit("array not found")
    values = [int(v) for v in m.group(2).replace("\n", " ").split(",") if v.strip()]
    data = bytes(v & 0xFF for v in values)
    b64 = base64.b64encode(data).decode("ascii")
    parts = [b64[i:i + CHUNK] for i in range(0, len(b64), CHUNK)]
    joined = " + ".join(f'"{x}"' for x in parts) if len(parts) == 1 else \
        "new StringBuilder()" + "".join(f'.append("{x}")' for x in parts) + ".toString()"
    repl = (f"/* {len(data)} bytes; stored as Base64 because the array literal made <clinit> too large */\n"
            f"    {m.group(1)} = android.util.Base64.decode({joined}, 0);")
    p.write_text(s[:m.start()] + repl + s[m.end():], encoding="utf-8", newline="\n")
    print(f"{field}: {len(data)} bytes -> {len(parts)} Base64 chunk(s)")


if __name__ == "__main__":
    main(*sys.argv[1:3])
