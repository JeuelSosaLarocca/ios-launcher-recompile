package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.m0 */
/* JADX INFO: loaded from: classes.dex */
public final class FirstFrameAnimatorHelper extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public FirstFrameAnimatorHelper() {
        super();
    }

    /* JADX INFO: renamed from: o */
    public static FirstFrameDrawListener f16701o;

    /* JADX INFO: renamed from: p */
    public static long f16702p;

    /* JADX INFO: renamed from: q */
    public static boolean f16703q;

    /* JADX INFO: renamed from: j */
    public View f16704j;

    /* JADX INFO: renamed from: k */
    public long f16705k;

    /* JADX INFO: renamed from: l */
    public long f16706l = -1;

    /* JADX INFO: renamed from: m */
    public boolean f16707m;

    /* JADX INFO: renamed from: n */
    public boolean f16708n;

    public FirstFrameAnimatorHelper(ObjectAnimator objectAnimator, View view) {
        this.f16704j = view;
        objectAnimator.addUpdateListener(this);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        ValueAnimator valueAnimator = (ValueAnimator) animator;
        valueAnimator.addUpdateListener(this);
        onAnimationUpdate(valueAnimator);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008f A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x001a, B:12:0x002f, B:14:0x0033, B:16:0x0037, B:19:0x0041, B:23:0x0052, B:27:0x005d, B:42:0x0098, B:31:0x0070, B:33:0x0078, B:35:0x007c, B:39:0x0087, B:41:0x008f), top: B:46:0x0004 }] */
    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        long j6;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f16706l == -1) {
                this.f16705k = f16702p;
                this.f16706l = jCurrentTimeMillis;
            }
            long currentPlayTime = valueAnimator.getCurrentPlayTime();
            boolean z5 = Float.compare(1.0f, valueAnimator.getAnimatedFraction()) == 0;
            if (this.f16707m || !f16703q || currentPlayTime >= valueAnimator.getDuration() || z5) {
                return;
            }
            this.f16707m = true;
            long j7 = f16702p - this.f16705k;
            View view = this.f16704j;
            if (j7 == 0) {
                j6 = 1000;
                if (jCurrentTimeMillis < this.f16706l + 1000 && currentPlayTime > 0) {
                    view.getRootView().invalidate();
                    valueAnimator.setCurrentPlayTime(0L);
                }
                this.f16707m = false;
            }
            j6 = 1000;
            if (j7 == 1) {
                long j8 = this.f16706l;
                if (jCurrentTimeMillis < j8 + j6 && !this.f16708n && jCurrentTimeMillis > j8 + 16 && currentPlayTime > 16) {
                    valueAnimator.setCurrentPlayTime(16L);
                    this.f16708n = true;
                } else if (j7 > 1) {
                    view.post(new MergedModelRunnable(3, this, valueAnimator));
                }
            } else if (j7 > 1) {
                view.post(new MergedModelRunnable(3, this, valueAnimator));
            }
            this.f16707m = false;
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
