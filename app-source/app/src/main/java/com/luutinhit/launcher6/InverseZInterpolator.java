package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.n1 */
/* JADX INFO: loaded from: classes.dex */
public final class InverseZInterpolator implements TimeInterpolator {

    /* JADX INFO: renamed from: a */
    public ZInterpolator f16737a;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        return 1.0f - this.f16737a.getInterpolation(1.0f - f6);
    }
}
