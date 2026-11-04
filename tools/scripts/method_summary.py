"""Print a one-line summary per obfuscated method of the given classes.

Usage: python -I method_summary.py <named_pkg_dir> <out_txt> <ClassName> [<ClassName> ...]
Class names may include a subpackage, e.g. appslibrary/AppsLibraryView.
"""
import re
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent))
from match_methods import methods_of  # noqa: E402

GL_RE = re.compile(r'\b(GLES\d+\.gl\w+|EGL14\.egl\w+|u_\w+|a_\w+)')


def main(pkg_dir, out_path, *classes):
    with open(out_path, "w", encoding="utf-8") as out:
        for cls in classes:
            text = (Path(pkg_dir) / f"{cls}.java").read_text(encoding="utf-8", errors="ignore")
            out.write(f"### {cls}\n")
            for m in methods_of(text, True):
                if not re.match(r'^m\d{3,5}[A-Za-z]*$', m["name"]):
                    continue
                start = text.find(f" {m['name']}(")
                body = text[start:start + 4000]
                gl = sorted(set(GL_RE.findall(body)))[:6]
                calls = sorted(m["calls"])[:10]
                out.write(f"{m['name']}({','.join(m['params'])}):{m['ret']} L{m['lines']}"
                          f" calls={calls} str={sorted(m['strings'])[:3]} res={sorted(m['res'])[:3]} gl={gl}\n")


if __name__ == "__main__":
    main(*sys.argv[1:])
