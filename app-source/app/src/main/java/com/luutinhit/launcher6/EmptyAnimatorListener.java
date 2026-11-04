package com.luutinhit.launcher6;

import android.animation.Animator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.X1 */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyAnimatorListener implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        LauncherAnimUtils.sAnimators.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        LauncherAnimUtils.sAnimators.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        LauncherAnimUtils.sAnimators.put(animator, null);
    }
}
