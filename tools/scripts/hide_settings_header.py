"""Remove the banner image and the mail button from the top of the app's settings screen.

res/layout/activity_main.xml:
  * header_layout   (the "LAUNCHER IOS" banner image)  -> visibility=gone
  * action_email    (the mail button)                   -> visibility=gone
  * action_navigation (menu button, white icon that sat on the banner) -> tinted with colorAccent so it is
    visible on the plain background
  * scroll_settings (the list, anchored under the banner) -> layout_goneMarginTop, so it starts below the menu
    button instead of at the top of the screen

Hidden, not deleted: MainActivity still calls findViewById(R.id.header_layout / R.id.action_email) and
setOnClickListener on them. Keeps the file's newline style (CRLF). Idempotent.
Usage: python -I hide_settings_header.py <app/src/main>
"""
import sys
from pathlib import Path

CRLF = "\r\n"


def read(p):
    raw = p.read_bytes().decode("utf-8")
    return raw.replace(CRLF, "\n"), (CRLF if CRLF in raw else "\n")


def write(p, text, nl):
    p.write_bytes(text.replace("\n", nl).encode("utf-8"))


def add_attr(text, view_id, attr):
    """Adds one attribute line right after the android:id line of the view, unless it is already there."""
    idx = text.index(f'android:id="@+id/{view_id}"')
    name = attr.split("=")[0]
    if name in text[idx:text.index(">", idx)]:
        return text
    line_end = text.index("\n", idx)
    line_start = text.rindex("\n", 0, idx) + 1
    before = text[line_start:idx]
    indent = before[: len(before) - len(before.lstrip())]
    return text[:line_end + 1] + indent + attr + "\n" + text[line_end + 1:]


def main(root):
    p = Path(root) / "res/layout/activity_main.xml"
    t, nl = read(p)
    t = add_attr(t, "header_layout", 'android:visibility="gone"')
    t = add_attr(t, "action_email", 'android:visibility="gone"')
    t = add_attr(t, "action_navigation", 'android:tint="@color/colorAccent"')
    t = add_attr(t, "scroll_settings", 'app:layout_goneMarginTop="64dp"')
    write(p, t, nl)
    print(f"{p}: done")


if __name__ == "__main__":
    main(sys.argv[1])
