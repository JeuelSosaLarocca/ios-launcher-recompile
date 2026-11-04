"""Import the drawables that only exist in a density split APK (split_config.xxhdpi.apk).

jadx decoded only base.apk, so resources whose files live in the density split were missing
(e.g. drawable/ic_widget_pressed -> Resources$NotFoundException at startup).

  * files are copied to res/<dir>/<name>, keeping the split's own directory names
  * compiled 9-patches (no 1px border, stretch data in the `npTc` chunk) are turned back into
    source 9-patches, because aapt2 only compiles the source form
  * the IDs are appended to stable-ids.txt so they keep the IDs the library bytecode expects

Usage: python -I import_density_split.py <split.apk> <res_dir> <stable-ids.txt> <aapt2> <package>
"""
import io
import re
import struct
import subprocess
import sys
import zipfile
from pathlib import Path

from PIL import Image


def png_chunk(data, name):
    pos = 8
    while pos < len(data):
        length, kind = struct.unpack(">I4s", data[pos:pos + 8])
        if kind == name:
            return data[pos + 8:pos + 8 + length]
        pos += 12 + length
    return None


def source_ninepatch(data):
    chunk = png_chunk(data, b"npTc")
    if chunk is None:
        return None
    _, nx, ny, _ = struct.unpack(">4b", chunk[:4])
    pad_l, pad_r, pad_t, pad_b = struct.unpack(">4i", chunk[12:28])
    xdivs = struct.unpack(f">{nx}i", chunk[32:32 + 4 * nx])
    ydivs = struct.unpack(f">{ny}i", chunk[32 + 4 * nx:32 + 4 * nx + 4 * ny])
    img = Image.open(io.BytesIO(data)).convert("RGBA")
    w, h = img.size
    out = Image.new("RGBA", (w + 2, h + 2), (0, 0, 0, 0))
    out.paste(img, (1, 1))
    black = (0, 0, 0, 255)
    for a, b in zip(xdivs[0::2], xdivs[1::2]):
        for x in range(a, b):
            out.putpixel((x + 1, 0), black)
    for a, b in zip(ydivs[0::2], ydivs[1::2]):
        for y in range(a, b):
            out.putpixel((0, y + 1), black)
    for x in range(pad_l, w - pad_r):
        out.putpixel((x + 1, h + 1), black)
    for y in range(pad_t, h - pad_b):
        out.putpixel((w + 1, y + 1), black)
    buf = io.BytesIO()
    out.save(buf, "PNG")
    return buf.getvalue()


def main(split, res_dir, stable_ids, aapt2, package):
    dump = subprocess.run([aapt2, "dump", "resources", split], capture_output=True, text=True).stdout
    entries, current = [], None
    for line in dump.splitlines():
        m = re.match(r"\s+resource (0x[0-9a-f]+) (\w+)/(\S+)", line)
        if m:
            current = m.groups()
            continue
        f = re.search(r"\(file\) (res/\S+)", line)
        if f and current:
            entries.append((*current, f.group(1)))
    res = Path(res_dir)
    zf = zipfile.ZipFile(split)
    copied = patched = 0
    for rid, rtype, name, path in entries:
        data = zf.read(path)
        dest = res / Path(path).relative_to("res")
        dest.parent.mkdir(parents=True, exist_ok=True)
        if path.endswith(".9.png"):
            fixed = source_ninepatch(data)
            if fixed is not None:
                data = fixed
                patched += 1
        dest.write_bytes(data)
        copied += 1
    known = set(Path(stable_ids).read_text(encoding="utf-8").split("\n"))
    with open(stable_ids, "a", encoding="utf-8", newline="\n") as out:
        for rid, rtype, name, _ in {(e[0], e[1], e[2], None) for e in entries}:
            line = f"{package}:{rtype}/{name} = {rid}"
            if line not in known:
                out.write(line + "\n")
    print(f"resources: {len({e[0] for e in entries})}, files copied: {copied}, 9-patches rebuilt: {patched}")


if __name__ == "__main__":
    main(*sys.argv[1:6])
