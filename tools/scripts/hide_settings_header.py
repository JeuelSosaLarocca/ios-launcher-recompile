"""Remove the banner image and the mail button from the top of the app's settings screen.

res/layout/activity_main.xml:
  * header_layout   (the "LAUNCHER IOS" banner)  -> invisible, 1dp high, no image. It must NOT be gone: the settings
    list's overscroll bounce (D/C0157a, case 11) computes  scale = overscroll / header.getMeasuredHeight() + 1  and
    scales the header with it; a gone view measures 0, the division gives Infinity and View.setScaleX() throws
    IllegalArgumentException, which crashed the launcher process while scrolling the list.
  * action_email    (the mail button)             -> gone
  (The menu button and the list margin are handled by remove_drawer_menu.py, which runs after this script.)

Nothing is deleted: MainActivity still calls findViewById(R.id.header_layout / R.id.action_email) and
setOnClickListener / setScaleX on them. Works from the original file and from an earlier version of this script
(which used visibility=gone on the banner). Keeps the file's newline style (CRLF). Idempotent.
Usage: python -I hide_settings_header.py <app/src/main>
"""
import re
import sys
from pathlib import Path

CRLF = "\r\n"


def read(p):
    raw = p.read_bytes().decode("utf-8")
    return raw.replace(CRLF, "\n"), (CRLF if CRLF in raw else "\n")


def write(p, text, nl):
    p.write_bytes(text.replace("\n", nl).encode("utf-8"))


def element_span(text, view_id):
    """(start, end) of the opening tag of the element that has android:id=view_id, '>' or '/>' included."""
    idx = text.index(f'android:id="@+id/{view_id}"')
    start = text.rindex("<", 0, idx)
    end = text.index(">", idx) + 1
    return start, end


def edit_tag(text, view_id, set_attrs, drop_attrs=()):
    """set_attrs: {name: value} (added after the android:id line, or replaced in place); drop_attrs: names to remove."""
    start, end = element_span(text, view_id)
    tag = text[start:end]
    for name in list(drop_attrs) + list(set_attrs):
        tag = re.sub(r'\n[ \t]*' + re.escape(name) + r'="[^"]*"', "", tag)
    id_line_end = tag.index("\n", tag.index(f'android:id="@+id/{view_id}"'))
    line_start = tag.rindex("\n", 0, tag.index(f'android:id="@+id/{view_id}"')) + 1
    before = tag[line_start:tag.index(f'android:id="@+id/{view_id}"')]
    indent = before[: len(before) - len(before.lstrip())]
    added = "".join(f'\n{indent}{name}="{value}"' for name, value in set_attrs.items())
    tag = tag[:id_line_end] + added + tag[id_line_end:]
    return text[:start] + tag + text[end:]


def main(root):
    p = Path(root) / "res/layout/activity_main.xml"
    t, nl = read(p)
    t = edit_tag(t, "header_layout",
                 {"android:visibility": "invisible", "android:layout_height": "1dp"},
                 drop_attrs=("android:src", "android:adjustViewBounds"))
    t = edit_tag(t, "action_email", {"android:visibility": "gone"})
    write(p, t, nl)
    print(f"{p}: done")


if __name__ == "__main__":
    main(sys.argv[1])
