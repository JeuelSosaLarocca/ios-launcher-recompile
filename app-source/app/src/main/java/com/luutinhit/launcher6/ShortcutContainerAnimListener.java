package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.e3 */
/* JADX INFO: loaded from: classes.dex */
public final class ShortcutContainerAnimListener extends AnimatorListenerAdapter {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16374j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ View f16375k;

    public /* synthetic */ ShortcutContainerAnimListener(int i6, View view) {
        this.f16374j = i6;
        this.f16375k = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f16374j) {
            case 0:
                super.onAnimationEnd(animator);
                this.f16375k.setLayerType(0, null);
                animator.removeListener(this);
                break;
            default:
                super.onAnimationEnd(animator);
                this.f16375k.setLayerType(0, null);
                animator.removeListener(this);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f16374j) {
            case 0:
                super.onAnimationStart(animator);
                this.f16375k.setLayerType(2, null);
                break;
            default:
                super.onAnimationStart(animator);
                this.f16375k.setLayerType(2, null);
                break;
        }
    }
}
