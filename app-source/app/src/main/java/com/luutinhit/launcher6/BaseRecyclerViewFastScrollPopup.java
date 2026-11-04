package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.graphics.Rect;

/* JADX INFO: renamed from: com.luutinhit.launcher6.p */
/* JADX INFO: loaded from: classes.dex */
public final class BaseRecyclerViewFastScrollPopup {

    /* JADX INFO: renamed from: a */
    public Rect f16802a;

    /* JADX INFO: renamed from: b */
    public Rect f16803b;

    /* JADX INFO: renamed from: c */
    public String f16804c;

    /* JADX INFO: renamed from: d */
    public Paint f16805d;

    /* JADX INFO: renamed from: e */
    public Rect f16806e;

    /* JADX INFO: renamed from: f */
    public ObjectAnimator f16807f;

    /* JADX INFO: renamed from: g */
    public boolean f16808g;

    /* JADX INFO: renamed from: a */
    public final void animateVisibility(boolean z5) {
        if (this.f16808g != z5) {
            this.f16808g = z5;
            ObjectAnimator objectAnimator = this.f16807f;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", z5 ? 1.0f : 0.0f);
            this.f16807f = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(z5 ? 200L : 150L);
            this.f16807f.start();
        }
    }
}
