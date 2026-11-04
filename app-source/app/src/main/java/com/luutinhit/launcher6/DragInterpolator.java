package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.M2 */
/* JADX INFO: loaded from: classes.dex */
public final class DragInterpolator implements TimeInterpolator {

    /* JADX INFO: renamed from: a */
    public float f15852a = 1.0f / ((0 * 1.0f) + (((float) (-Math.pow(100, -1.0f))) + 1.0f));

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        if (Float.compare(f6, 1.0f) == 0) {
            return 1.0f;
        }
        return ((0 * f6) + ((float) (-Math.pow(100, -f6))) + 1.0f) * this.f15852a;
    }
}
