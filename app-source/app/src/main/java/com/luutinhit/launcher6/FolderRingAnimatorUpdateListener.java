package com.luutinhit.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.A0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderRingAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15291j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ FolderRingAnimator f15292k;

    public FolderRingAnimatorUpdateListener(FolderRingAnimator folderRingAnimator, int i6) {
        this.f15292k = folderRingAnimator;
        this.f15291j = i6;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = (((1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.2f) + 1.0f) * this.f15291j;
        FolderRingAnimator folderRingAnimator = this.f15292k;
        folderRingAnimator.f15323d = fFloatValue;
        CellLayout cellLayout = folderRingAnimator.f15322c;
        if (cellLayout != null) {
            cellLayout.invalidate();
        }
    }
}
