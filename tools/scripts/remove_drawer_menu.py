"""Remove the sliding menu (drawer) of the app's settings screen and put "Reload launcher" in the settings list.

res/layout/activity_main.xml
  * root DrawerLayout -> com.luutinhit.launcher6.LockedDrawerLayout (a subclass locked closed). MainActivity still
    does findViewById(R.id.drawer_layout) and casts it to DrawerLayout, so the view must stay.
  * action_navigation (the menu button) -> gone
  * nav_view (the NavigationView) -> gone, without its header layout and its menu; MainActivity still looks it up.
  * scroll_settings (the list) -> layout_marginTop 16dp: nothing sits above the list any more
res/layout/settings_view.xml
  * new last row "Reload launcher" (id reload_launcher) in the main group, wired with android:onClick="reloadLauncher",
    a method added to MainActivity.
res/drawable/ic_reload_launcher.xml (created)

The other entries of the menu (privacy policy, how to use, about, website) are gone for good: their content now lives
in docs/ of the repository. Keeps each file's newline style (the layouts use CRLF). Idempotent.
Usage: python -I remove_drawer_menu.py <app/src/main>
"""
import re
import sys
from pathlib import Path

CRLF = "\r\n"

ICON = """<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:height="30dp"
    android:width="30dp"
    android:viewportWidth="36"
    android:viewportHeight="36">
    <path
        android:fillColor="#00acc1"
        android:pathData="M8.531609 0.59978998l18.874283 0c4.432 0 8 3.56800002 8 8.00000002l0 18.874283c0 4.432 -3.568 8 -8 8l-18.874283 0c-4.432 0 -8 -3.568 -8 -8l0 -18.874283c0 -4.432 3.568 -8.00000002 8 -8.00000002z"/>
    <group
        android:translateX="9"
        android:translateY="9"
        android:scaleX="0.75"
        android:scaleY="0.75">
        <path
            android:fillColor="#ffffff"
            android:pathData="M12,6v3l4,-4 -4,-4v3c-4.42,0 -8,3.58 -8,8 0,1.57 0.46,3.03 1.24,4.26L6.7,14.8c-0.45,-0.83 -0.7,-1.79 -0.7,-2.8 0,-3.31 2.69,-6 6,-6zM18.76,7.74L17.3,9.2c0.44,0.84 0.7,1.79 0.7,2.8 0,3.31 -2.69,6 -6,6v-3l-4,4 4,4v-3c4.42,0 8,-3.58 8,-8 0,-1.57 -0.46,-3.03 -1.24,-4.26z"/>
    </group>
</vector>
"""

ROW = """
                <com.luutinhit.launcherios.customsettings.SettingsItem
                    android:id="@+id/reload_launcher"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:minHeight="48dp"
                    android:onClick="reloadLauncher"
                    app:hideDivider="true"
                    app:settingIcon="@drawable/ic_reload_launcher"
                    app:settingText="@string/reload_launcher"/>"""


def read(p):
    raw = p.read_bytes().decode("utf-8")
    return raw.replace(CRLF, "\n"), (CRLF if CRLF in raw else "\n")


def write(p, text, nl):
    p.write_bytes(text.replace("\n", nl).encode("utf-8"))


def element_span(text, view_id):
    """(start, end) of the opening tag of the element that has android:id=view_id, '>' or '/>' included."""
    idx = text.index(f'android:id="@+id/{view_id}"')
    return text.rindex("<", 0, idx), text.index(">", idx) + 1


def edit_tag(text, view_id, set_attrs, drop_attrs=()):
    """set_attrs: {name: value}, added after the android:id line (replacing an existing one); drop_attrs: removed."""
    start, end = element_span(text, view_id)
    tag = text[start:end]
    for name in list(drop_attrs) + list(set_attrs):
        tag = re.sub(r"\n[ \t]*" + re.escape(name) + r'="[^"]*"', "", tag)
    marker = f'android:id="@+id/{view_id}"'
    id_line_end = tag.index("\n", tag.index(marker))
    line_start = tag.rindex("\n", 0, tag.index(marker)) + 1
    before = tag[line_start:tag.index(marker)]
    indent = before[: len(before) - len(before.lstrip())]
    added = "".join(f'\n{indent}{name}="{value}"' for name, value in set_attrs.items())
    return text[:start] + tag[:id_line_end] + added + tag[id_line_end:] + text[end:]


def main(root):
    root = Path(root)

    p = root / "res/layout/activity_main.xml"
    t, nl = read(p)
    t = t.replace("androidx.drawerlayout.widget.DrawerLayout", "com.luutinhit.launcher6.LockedDrawerLayout")
    t = edit_tag(t, "action_navigation", {"android:visibility": "gone"}, drop_attrs=("android:tint",))
    t = edit_tag(t, "nav_view", {"android:visibility": "gone"},
                 drop_attrs=("app:headerLayout", "app:menu", "app:itemIconTint"))
    t = edit_tag(t, "scroll_settings", {"android:layout_marginTop": "16dp"}, drop_attrs=("app:layout_goneMarginTop",))
    write(p, t, nl)

    p = root / "res/layout/settings_view.xml"
    t, nl = read(p)
    if 'android:id="@+id/reload_launcher"' not in t:
        t = edit_tag(t, "make_default_launcher", {"app:hideDivider": "false"})
        _, end = element_span(t, "make_default_launcher")
        t = t[:end] + ROW + t[end:]
    write(p, t, nl)

    icon = root / "res/drawable/ic_reload_launcher.xml"
    icon.write_bytes(ICON.encode("utf-8"))
    print(f"{root}: done")


if __name__ == "__main__":
    main(sys.argv[1])
