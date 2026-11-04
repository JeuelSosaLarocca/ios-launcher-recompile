package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.luutinhit.launcher6.b */
/* JADX INFO: loaded from: classes.dex */
public final class FadeVisibilityAnimator extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: j */
    public ViewGroup f16316j;

    /* JADX INFO: renamed from: k */
    public boolean f16317k;

    public FadeVisibilityAnimator(ViewGroup viewGroup, boolean z5) {
        this.f16316j = viewGroup;
        this.f16317k = z5;
    }

    /* JADX INFO: renamed from: a */
    public static void m7972a(View view, boolean z5) {
        int i6 = z5 ? 8 : 4;
        if (view.getAlpha() < 0.01f && view.getVisibility() != i6) {
            view.setVisibility(i6);
        } else {
            if (view.getAlpha() <= 0.01f || view.getVisibility() == 0) {
                return;
            }
            view.setVisibility(0);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        m7972a(this.f16316j, this.f16317k);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f16316j.setVisibility(0);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        m7972a(this.f16316j, this.f16317k);
    }
}
