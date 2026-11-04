package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: com.luutinhit.launcher6.z */
/* JADX INFO: loaded from: classes.dex */
public final class SharedAnimatorListener extends AnimatorListenerAdapter {

    /** Restored from bytecode: jadx did not emit this constructor. */
    public SharedAnimatorListener(int p0) {
        super();
        this.f17262j = p0;
    }


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17262j;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f17262j) {
            case 2:
                super.onAnimationEnd(animator);
                animator.removeListener(this);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }
}
