package com.luutinhit.launcher6;

/** Helpers for patterns jadx emits that javac rejects. */
public final class JadxSupport {
    private JadxSupport() {
    }

    /** Rethrows {@code t} unchanged without declaring it; callers write {@code throw JadxSupport.sneaky(t);}. */
    public static RuntimeException sneaky(Throwable t) {
        JadxSupport.<RuntimeException>throwAs(t);
        return null;
    }

    /**
     * Marker: when a method calls this, PostCompile replaces the whole method with the original bytecode.
     * Used for methods jadx flagged (duplicated code, failed type inference, ...). The source stays readable;
     * remove the call to make the source version the one that runs.
     */
    public static void useOriginalBytecode() {
    }

    /**
     * Marker: the build runs every method with its original bytecode (PostCompile --original-by-default);
     * a method that calls this runs its source instead. Add it to any method you change.
     */
    public static void useSource() {
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void throwAs(Throwable t) throws T {
        throw (T) t;
    }
}
