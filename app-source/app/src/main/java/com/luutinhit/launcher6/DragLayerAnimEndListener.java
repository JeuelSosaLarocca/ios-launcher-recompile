package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Z */
/* JADX INFO: loaded from: classes.dex */
public final class DragLayerAnimEndListener extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Runnable f16145j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ int f16146k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ DragLayer f16147l;

    public DragLayerAnimEndListener(DragLayer dragLayer, Runnable runnable, int i6) {
        this.f16147l = dragLayer;
        this.f16145j = runnable;
        this.f16146k = i6;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Runnable runnable = this.f16145j;
        if (runnable != null) {
            runnable.run();
        }
        if (this.f16146k != 0) {
            return;
        }
        this.f16147l.clearAnimatedView();
    }
}
