package com.luutinhit.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.e0 */
/* JADX INFO: loaded from: classes.dex */
public final class DragViewMoveUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ float f16369j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ float f16370k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ DragView f16371l;

    public DragViewMoveUpdateListener(DragView dragView, float f6, float f7) {
        this.f16371l = dragView;
        this.f16369j = f6;
        this.f16370k = f7;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        DragView dragView = this.f16371l;
        float f6 = dragView.f16485s;
        float f7 = dragView.f16486t;
        float f8 = (int) (-f6);
        dragView.f16485s = f6 + f8;
        float f9 = (int) (-f7);
        dragView.f16486t = f7 + f9;
        float f10 = this.f16370k;
        float f11 = this.f16369j;
        dragView.setScaleX(((f10 - f11) * fFloatValue) + f11);
        dragView.setScaleY(((f10 - f11) * fFloatValue) + f11);
        int i6 = DragView.f16475y;
        if (dragView.getParent() == null) {
            valueAnimator.cancel();
        } else {
            dragView.setTranslationX(dragView.getTranslationX() + f8);
            dragView.setTranslationY(dragView.getTranslationY() + f9);
        }
    }
}
