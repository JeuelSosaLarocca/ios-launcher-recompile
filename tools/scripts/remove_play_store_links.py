"""Hide or remove everything in the app that points to the Play Store (resources and manifest only).

  * res/layout/settings_view.xml     the "Rating 5 star / Download other apps" card and the card with the
                                     developer's other apps (Lock Screen, Control Center, AssistiveTouch)
  * res/layout/activity_main.xml     share (it shares a Play Store link), like and the floating star button
  * res/layout/layout_other_search.xml  the "Search Store" row (opens a Play Store search) and its divider
  * AndroidManifest.xml              RatingActivity disabled; Play distribution meta-data removed

Views are hidden with visibility="gone" instead of deleted: the original bytecode still calls
findViewById(...).setOnClickListener(...) on them and would crash on null.
Keeps each file's newline style (the layouts use CRLF). Idempotent.
Usage: python -I remove_play_store_links.py <app/src/main>
"""
import re
import sys
from pathlib import Path

CRLF = "\r\n"
GONE = 'android:visibility="gone"'


def read(p):
    """Text with LF newlines, plus the newline style the file had."""
    raw = p.read_bytes().decode("utf-8")
    return raw.replace(CRLF, "\n"), (CRLF if CRLF in raw else "\n")


def write(p, text, nl):
    p.write_bytes(text.replace("\n", nl).encode("utf-8"))


def hide_container(text, view_id, container_tag):
    """Adds visibility=gone to the container_tag element that encloses the view with the given id."""
    idx = text.index(f'android:id="@+id/{view_id}"')
    start = text.rindex(f"<{container_tag}", 0, idx)
    head_end = text.index("\n", start)
    if GONE in text[start:text.index(">", start)]:
        return text
    return text[:head_end + 1] + "            " + GONE + "\n" + text[head_end + 1:]


def hide_view(text, view_id):
    idx = text.index(f'android:id="@+id/{view_id}"')
    if GONE in text[idx:text.index(">", idx)]:
        return text
    line_end = text.index("\n", idx)
    line_start = text.rindex("\n", 0, idx) + 1
    indent = text[line_start:idx][: len(text[line_start:idx]) - len(text[line_start:idx].lstrip())]
    return text[:line_end + 1] + indent + GONE + "\n" + text[line_end + 1:]


def main(root):
    root = Path(root)

    p = root / "res/layout/settings_view.xml"
    t, nl = read(p)
    for gid in ("settings_group_suggest_apps", "settings_group_rating_app"):
        t = hide_container(t, gid, "androidx.cardview.widget.CardView")
    write(p, t, nl)

    p = root / "res/layout/activity_main.xml"
    t, nl = read(p)
    for vid in ("action_share", "action_like", "floating_button"):
        t = hide_view(t, vid)
    write(p, t, nl)

    p = root / "res/layout/layout_other_search.xml"
    t, nl = read(p)
    store = t.index('android:id="@+id/search_store"')
    divider = t.rindex("<View", 0, store)
    if GONE not in t[divider:t.index(">", divider)]:
        t = t[:divider] + "<View\n        " + GONE + t[divider + len("<View"):]
    t = hide_view(t, "search_store")
    write(p, t, nl)

    p = root / "AndroidManifest.xml"
    t, nl = read(p)
    t, n = re.subn(r'\n *<meta-data\s+android:name="(?:com\.android\.vending\.[\w.]+|com\.android\.stamp\.[\w.]+)"\s+'
                   r'android:(?:value|resource)="[^"]*"/>', "", t)
    name = 'android:name="com.luutinhit.launcherios.activity.RatingActivity"'
    if "android:enabled" not in t[t.index(name):t.index("/>", t.index(name))]:
        t = t.replace(name, name + '\n            android:enabled="false"', 1)
    write(p, t, nl)
    print(f"{root}: manifest meta-data removed: {n}")


if __name__ == "__main__":
    main(sys.argv[1])
