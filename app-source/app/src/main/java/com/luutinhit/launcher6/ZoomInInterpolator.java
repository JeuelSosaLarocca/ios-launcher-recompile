package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.C3 */
/* JADX INFO: loaded from: classes.dex */
public final class ZoomInInterpolator implements TimeInterpolator {

    /* JADX INFO: renamed from: a */
    public InverseZInterpolator f15444a;

    /* JADX INFO: renamed from: b */
    public DecelerateInterpolator f15445b;

    public ZoomInInterpolator() {
        InverseZInterpolator inverseZInterpolator = new InverseZInterpolator();
        inverseZInterpolator.f16737a = new ZInterpolator(1);
        this.f15444a = inverseZInterpolator;
        this.f15445b = new DecelerateInterpolator(3.0f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f6) {
        return this.f15445b.getInterpolation(this.f15444a.getInterpolation(f6));
    }
}
