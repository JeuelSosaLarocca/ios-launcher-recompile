"""Apply line-level fixes driven by javac errors in a Gradle log.

Usage: python -I fix_from_log.py <build.log> <java_root> [compile-libs.jar]

Each rule only touches the exact line javac reported, so unrelated code is left alone.
"""
import re
import sys
from collections import defaultdict
from pathlib import Path

ERR_RE = re.compile(r'^(.*?\.java):(\d+): error: (.*)$')


def strip_generics(text):
    prev = None
    while prev != text:
        prev = text
        text = re.sub(r'<[^<>()]*>', '', text)
    return text


def outer_class(lines, idx):
    """Name of the closest enclosing named class declared above idx."""
    for j in range(idx, -1, -1):
        m = re.match(r'^\s*(?:public |protected |private |static |final |abstract )*(?:class|enum) (\w+)', lines[j])
        if m:
            return m.group(1)
    return None


def fix_anonymous(lines, i):
    line = lines[i]
    k = line.rfind("new ")
    m = re.match(r'new ([\w.<>]+)\((.*)\) \{(\s*//.*)?$', line[k:]) if k >= 0 else None
    if not m:
        return False
    lines[i] = line[:k] + f"new {m.group(1)}() {{" + (m.group(3) or "")
    outer = outer_class(lines, i - 1)
    # the instance initializer jadx emits right after the synthetic fields: `this.fX = this;`
    for j in range(i + 1, min(i + 40, len(lines))):
        if re.search(r'^\s*this\.\w+ = this;\s*$', lines[j]) and outer:
            lines[j] = lines[j].replace("= this;", f"= {outer}.this;")
        if re.search(r'^\s*(@Override|public|private|protected)\b.*\(.*\).*\{\s*$', lines[j]):
            break
    return True


def fix_name_clash(lines, i):
    line = lines[i]
    start, end = line.find("("), line.rfind(")")
    if start < 0 or end < start:
        return False
    lines[i] = line[:start] + strip_generics(line[start:end]) + line[end:]
    return True


def fix_multicatch(lines, i):
    m = re.search(r'catch \(([\w. |]+?) (\w+)\)', lines[i])
    if not m or "|" not in m.group(1):
        return False
    types = [t.strip() for t in m.group(1).split("|")]
    wide = "Exception" if "Exception" in types else "Throwable"
    lines[i] = lines[i][:m.start()] + f"catch ({wide} {m.group(2)})" + lines[i][m.end():]
    return True


def drop_throws(lines, i):
    new = re.sub(r'\s+throws [\w., ]+(?=\s*\{)', '', lines[i])
    if new == lines[i]:
        return False
    lines[i] = new
    return True


def fix_raw_foreach(lines, i):
    m = re.search(r'for \(((?:final )?)([\w.<>\[\], ]+?) (\w+) : (.+)\) \{', lines[i])
    if not m:
        # `T v = rawList.get(i);` -> add the cast jadx dropped
        d = re.match(r'^(\s*)([\w.<>\[\]]+) (\w+) = (.+);\s*$', lines[i])
        if not d or d.group(4).startswith('('):
            return False
        lines[i] = f"{d.group(1)}{d.group(2)} {d.group(3)} = ({d.group(2)}) {d.group(4)};"
        return True
    t = m.group(2)
    lines[i] = (lines[i][:m.start()] + f"for ({m.group(1)}{t} {m.group(3)} : (Iterable<{t}>) (Iterable) ({m.group(4)})) {{"
                + lines[i][m.end():])
    return True


def declare_throwable(lines, i):
    m = re.match(r'^(\s*)(e|th\d*) = (\w+);\s*$', lines[i])
    if not m:
        return False
    lines[i] = f"{m.group(1)}Throwable {m.group(2)} = {m.group(3)};"
    return True


def undeclare_throwable(lines, i):
    m = re.match(r'^(\s*)Throwable (e|th\d*) = (\w+);\s*$', lines[i])
    if not m:
        return False
    lines[i] = f"{m.group(1)}{m.group(2)} = {m.group(3)};"
    return True


def outer_this(lines, i):
    """`this.fNNN` that jadx left in an anonymous class: the captured outer instance."""
    m = re.search(r'\bthis\.(f\d+\w*)\b', lines[i])
    outer = outer_class(lines, i)
    if not m or not outer:
        return False
    lines[i] = lines[i][:m.start()] + f"{outer}.this" + lines[i][m.end():]
    return True


def outer_super(lines, i):
    outer = outer_class(lines, i)
    new = re.sub(r'\bsuper/\*[\w.$]+\*/\.', f'{outer}.super.', lines[i])
    if new == lines[i] or not outer:
        return False
    lines[i] = new
    return True


LIB_CLASSES = {}


def add_import(lines, i, symbol=None):
    if not symbol or symbol not in LIB_CLASSES or len(LIB_CLASSES[symbol]) != 1:
        return False
    imp = f"import {LIB_CLASSES[symbol][0]};"
    if imp in lines:
        return False
    k = next((j for j, l in enumerate(lines) if l.startswith("import ")), None)
    if k is None:
        k = next(j for j, l in enumerate(lines) if l.startswith("package ")) + 1
    lines.insert(k, imp)
    return True


def bool_to_int(lines, i):
    m = re.match(r'^(\s*(?:int )?\w+ = )(.+);\s*$', lines[i])
    if not m:
        return False
    lines[i] = f"{m.group(1)}({m.group(2)}) ? 1 : 0;"
    return True


DEFAULTS = {"boolean": "false", "int": "0", "long": "0L", "short": "0", "byte": "0", "char": "0", "float": "0.0f", "double": "0.0"}


def init_variable(lines, i, name=None):
    """`T x;` declared above without a value: give it the type's default (the bytecode always assigns it)."""
    if not name:
        return False
    for j in range(i, max(i - 2500, -1), -1):
        m = re.match(r'^(\s*)((?:final )?)([\w.<>\[\], ?]+?) ' + re.escape(name) + r';\s*$', lines[j])
        if m:
            t = m.group(3).strip()
            lines[j] = f"{m.group(1)}{m.group(2)}{t} {name} = {DEFAULTS.get(t, 'null')};"
            return True
    return False


def drop_self_assign(lines, i):
    if not re.match(r'^\s*(\w+) = \1;\s*$', lines[i]):
        return False
    lines[i] = ""
    return True


def default_return(lines, i):
    """Method falls off the end (jadx truncated a catch): return the type's default value."""
    for j in range(i, max(i - 3000, -1), -1):
        m = re.match(r'^\s+(?:(?:public|protected|private|static|final|synchronized|abstract|/\*[^*]*\*/) )*([\w.<>\[\], ?]+?) [\w$]+\(.*\)\s*(?:throws [\w., ]+)?\{\s*$', lines[j])
        if m:
            t = m.group(1).strip()
            if t == 'void':
                return False
            indent = re.match(r'^(\s*)', lines[i]).group(1) + '    '
            lines.insert(i, f"{indent}return {DEFAULTS.get(t, 'null')}; // jadx: method fell off the end")
            return True
    return False


def widen_catch(lines, i, exc=None):
    """A catch for a checked exception the try body never throws."""
    m = re.search(r'catch \(([\w.| ]+?) (\w+)\)', lines[i])
    if not m:
        return False
    types = [t.strip() for t in m.group(1).split("|")]
    if len(types) > 1 and exc:
        # multi-catch: drop only the alternative javac complained about
        kept = [t for t in types if t.split(".")[-1] != exc.split(".")[-1]]
        if kept and len(kept) < len(types):
            lines[i] = lines[i][:m.start()] + f"catch ({' | '.join(kept)} {m.group(2)})" + lines[i][m.end():]
            return True
    lines[i] = lines[i][:m.start()] + f"catch (Exception {m.group(2)})" + lines[i][m.end():]
    return True


def drop_unreachable(lines, i):
    if re.match(r'^\s*(throw |return\b|break;)', lines[i]):
        lines[i] = ""
        return True
    # jadx leaves a `break;` as the last statement of a synchronized/try block to leave it,
    # which makes the code after the block unreachable
    j = i - 1
    while j > 0 and lines[j].strip() == "}":
        j -= 1
    if lines[j].strip() == "break;":
        lines[j] = ""
        return True
    return False


def add_throws(lines, i, exc=None):
    """Declare a checked exception the body lets escape (jadx dropped the throws clause)."""
    if not exc:
        return False
    for j in range(i, max(i - 3000, -1), -1):
        m = re.match(r'^(\s+(?:(?:public|protected|private|static|final|synchronized|/\*[^*]*\*/) )*[\w.<>\[\], ?]+ [\w$]+\(.*\))(\s*throws [\w., ]+)?(\s*\{\s*)$', lines[j])
        if m:
            if m.group(2) and exc in m.group(2):
                return False
            if any(lines[k].strip().startswith("@Override") for k in range(max(j - 3, 0), j)):
                # an override cannot declare new checked exceptions: rethrow unchecked at the statement
                stmt = lines[i]
                if " jadxEx) " in stmt and "try { " in stmt:
                    # already wrapped for another exception: add this one to the catch
                    lines[i] = stmt.replace(" jadxEx) ", f" | {exc} jadxEx) ", 1)
                    return True
                if not stmt.rstrip().endswith(";"):
                    return False
                ind = stmt[:len(stmt) - len(stmt.lstrip())]
                body, decl = stmt.strip(), ""
                d = re.match(r'^((?:final )?[\w.<>\[\]]+) (\w+) = (.+;)$', body)
                if d:  # keep the variable visible after the try block
                    decl, body = f"{d.group(1)} {d.group(2)}; ", f"{d.group(2)} = {d.group(3)}"
                lines[i] = (f"{ind}{decl}try {{ {body} }} catch ({exc} jadxEx) "
                            f"{{ throw com.luutinhit.launcher6.JadxSupport.sneaky(jadxEx); }}")
                return True
            throws = (m.group(2) + ", " + exc) if m.group(2) else (" throws " + exc)
            lines[j] = m.group(1) + throws + m.group(3)
            return True
    return False


def drop_previous_catch(lines, i):
    """`catch (Exception)` right after another `catch (Exception)` (one was widened from a type never thrown):
    remove the earlier clause; the remaining one catches the same exceptions."""
    ind = lines[i][:len(lines[i]) - len(lines[i].lstrip())]
    for j in range(i - 1, max(i - 40, -1), -1):
        if lines[j].startswith(ind + "} catch (") and lines[j][len(ind)] == "}":
            for k in range(j, i):
                lines[k] = ""
            return True
        if lines[j].startswith(ind) and not lines[j].startswith(ind + " ") and lines[j].strip() and not lines[j].strip().startswith("} catch"):
            return False
    return False


RULES = [
    (re.compile(r'anonymous class implements interface; cannot have arguments'), fix_anonymous),
    (re.compile(r'name clash: .* have the same erasure'), fix_name_clash),
    (re.compile(r'Alternatives in a multi-catch statement cannot be related by subclassing'), fix_multicatch),
    (re.compile(r'\w+\(.*\) in .* cannot (implement|override)'), drop_throws),
    (re.compile(r'incompatible types: Object cannot be converted to'), fix_raw_foreach),
    (re.compile(r'variable (e|th\d*) is already defined'), undeclare_throwable),
    (re.compile(r'incompatible types: boolean cannot be converted to int'), bool_to_int),
    (re.compile(r'variable \w+ might not have been initialized'), drop_self_assign),
    (re.compile(r'missing return statement'), default_return),
    (re.compile(r'unreachable statement'), drop_unreachable),
    (re.compile(r'exception [\w.]+ has already been caught'), drop_previous_catch),
]

# rules that need the "symbol:" line that follows the error
SYMBOL_RULES = [
    (re.compile(r'symbol:\s+variable (e|th\d*)$'), declare_throwable),
    (re.compile(r'symbol:\s+variable f\d+\w*$'), outer_this),
    (re.compile(r'symbol:\s+method \w+\('), outer_super),
    (re.compile(r'symbol:\s+class (\w+)$'), add_import),
]


def main(log_path, root, libs_jar=None):
    if libs_jar:
        import os
        import zipfile
        jars = [libs_jar]
        android_jar = os.environ.get("ANDROID_JAR", r"D:\Android\Sdk\platforms\android-36.1\android.jar")
        if os.path.exists(android_jar):
            jars.append(android_jar)
        for jar in jars:
            for n in zipfile.ZipFile(jar).namelist():
                if n.endswith(".class") and "$" not in n:
                    LIB_CLASSES.setdefault(n.rsplit("/", 1)[-1][:-6], []).append(n[:-6].replace("/", "."))
    todo = defaultdict(set)
    log = open(log_path, encoding="utf-8", errors="replace").read().splitlines()
    for idx, line in enumerate(log):
        m = ERR_RE.match(line.strip())
        if not m:
            continue
        path, ln, msg = m.group(1), int(m.group(2)), m.group(3)
        for rx, fn in RULES:
            if rx.search(msg):
                todo[path].add((ln, fn, None))
        vm = re.match(r'variable (\w+) might not have been initialized', msg)
        if vm:
            todo[path].add((ln, init_variable, vm.group(1)))
        nm = re.match(r'exception ([\w.]+) is never thrown in body of corresponding try statement', msg)
        if nm:
            todo[path].add((ln, widen_catch, nm.group(1)))
        um = re.match(r'unreported exception ([\w.]+); must be caught or declared to be thrown', msg)
        if um:
            todo[path].add((ln, add_throws, um.group(1)))
        if msg == "cannot find symbol":
            sym = next((x.strip() for x in log[idx + 1:idx + 5] if x.strip().startswith("symbol")), "")
            for rx, fn in SYMBOL_RULES:
                sm = rx.search(sym)
                if sm:
                    todo[path].add((ln, fn, sm.group(1) if fn is add_import else None))
    applied = defaultdict(int)
    for path, items in todo.items():
        p = Path(path)
        if not p.exists():
            continue
        lines = p.read_text(encoding="utf-8").split("\n")
        # bottom-up so line numbers stay valid; imports (inserted at the top) go last
        for ln, fn, arg in sorted(items, key=lambda x: (x[1] in (add_import, default_return), -x[0])):
            if (fn(lines, ln - 1, arg) if fn in (add_import, init_variable, add_throws, widen_catch) else fn(lines, ln - 1)):
                applied[fn.__name__] += 1
        p.write_text("\n".join(lines), encoding="utf-8", newline="\n")
    for k, v in applied.items():
        print(f"{k}: {v}")


if __name__ == "__main__":
    main(*sys.argv[1:4])
