"""Put back the Google API key that was removed from AndroidManifest.xml before publishing.

The repo ships the manifest with the placeholder REPLACE_WITH_THE_KEY_FROM_YOUR_ORIGINAL_APK where the
original app had its Google API key (a com.google.android.geo.API_KEY / similar meta-data). The key
belongs to the original developer, so it is not published. This script reads it from your own copy
of the APK (or from a manifest decoded as text, e.g. jadx's resources/AndroidManifest.xml) and writes
it into the app's manifest. Only needed if you want the features that use that key to keep working.

Usage: python -I restore_api_key.py <original base.apk | decoded AndroidManifest.xml> <app AndroidManifest.xml>
"""
import re
import sys
import zipfile
from pathlib import Path

PLACEHOLDER = "REPLACE_WITH_THE_KEY_FROM_YOUR_ORIGINAL_APK"
KEY = re.compile(rb"AIza[0-9A-Za-z_\-]{35}")
KEY_UTF16 = re.compile("".join(f"{c}\x00" for c in "AIza").encode("latin-1") + rb"(?:[0-9A-Za-z_\-]\x00){35}")


def find_key(source):
    path = Path(source)
    data = zipfile.ZipFile(path).read("AndroidManifest.xml") if path.suffix == ".apk" else path.read_bytes()
    m = KEY.search(data)
    if m:
        return m.group(0).decode()
    m = KEY_UTF16.search(data)  # binary manifests may store strings as UTF-16
    return m.group(0).decode("utf-16-le") if m else None


def main(source, manifest):
    key = find_key(source)
    if not key:
        sys.exit("no Google API key found in " + source)
    text = Path(manifest).read_text(encoding="utf-8")
    if PLACEHOLDER not in text:
        sys.exit("the manifest has no placeholder (already restored?)")
    Path(manifest).write_text(text.replace(PLACEHOLDER, key), encoding="utf-8", newline="\n")
    print("key restored (not printed); do not commit the manifest after this")


if __name__ == "__main__":
    main(*sys.argv[1:3])
