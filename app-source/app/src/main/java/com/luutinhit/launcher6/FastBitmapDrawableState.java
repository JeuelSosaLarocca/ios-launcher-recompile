package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.k0 */
/* JADX INFO: loaded from: classes.dex */
public enum FastBitmapDrawableState {

    NORMAL(0.0f, 0.0f, new DecelerateInterpolator()),
    PRESSED(0.0f, 0.39215687f, FastBitmapDrawable.f15571o),
    FAST_SCROLL_HIGHLIGHTED(0.0f, 0.0f, new DecelerateInterpolator()),
    FAST_SCROLL_UNHIGHLIGHTED(0.0f, 0.0f, new DecelerateInterpolator()),
    DISABLED(1.0f, 0.5f, new DecelerateInterpolator());


    /* JADX INFO: renamed from: j */
    public float f16632j;

    /* JADX INFO: renamed from: k */
    public float f16633k;

    /* JADX INFO: renamed from: l */
    public TimeInterpolator f16634l;

    FastBitmapDrawableState(float f6, float f7, TimeInterpolator timeInterpolator) {
        this.f16632j = f6;
        this.f16633k = f7;
        this.f16634l = timeInterpolator;
    }
}
