package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.j0 */
/* JADX INFO: loaded from: classes.dex */
public final class ZInterpolator implements TimeInterpolator {

    /** Restored from bytecode: jadx did not emit this constructor. */
    public ZInterpolator(int p0) {
        super();
        this.f16590a = p0;
    }


    /* JADX INFO: renamed from: a */
    public /* synthetic */ int f16590a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        switch (this.f16590a) {
            case 0:
                if (f6 < 0.05f) {
                    return f6 / 0.05f;
                }
                if (f6 < 0.3f) {
                    return 1.0f;
                }
                return (1.0f - f6) / 0.7f;
            default:
                return (1.0f - (0.35f / (f6 + 0.35f))) / 0.7407408f;
        }
    }
}
