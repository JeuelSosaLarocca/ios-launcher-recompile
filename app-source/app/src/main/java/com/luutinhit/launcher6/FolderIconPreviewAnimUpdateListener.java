package com.luutinhit.launcher6;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.y0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderIconPreviewAnimUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ boolean f17251j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ float f17252k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ PreviewItemDrawingParams f17253l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ float f17254m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ float f17255n;

    /* JADX INFO: renamed from: o */
    public /* synthetic */ FolderIcon f17256o;

    public FolderIconPreviewAnimUpdateListener(FolderIcon folderIcon, boolean z5, float f6, PreviewItemDrawingParams previewItemDrawingParams, float f7, float f8) {
        this.f17256o = folderIcon;
        this.f17251j = z5;
        this.f17252k = f6;
        this.f17253l = previewItemDrawingParams;
        this.f17254m = f7;
        this.f17255n = f8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        boolean z5 = this.f17251j;
        FolderIcon folderIcon = this.f17256o;
        if (z5) {
            fFloatValue = 1.0f - fFloatValue;
            folderIcon.f15657r.getIconView().setAlpha(fFloatValue);
        }
        PreviewItemDrawingParams previewItemDrawingParams = folderIcon.f15644B;
        PreviewItemDrawingParams previewItemDrawingParams2 = this.f17253l;
        float f6 = previewItemDrawingParams2.f15433a;
        float f7 = this.f17252k;
        previewItemDrawingParams.f15433a = SyntheticHelpers.m7906e(f6, f7, fFloatValue, f7);
        float f8 = previewItemDrawingParams2.f15434b;
        float f9 = this.f17254m;
        previewItemDrawingParams.f15434b = SyntheticHelpers.m7906e(f8, f9, fFloatValue, f9);
        float f10 = previewItemDrawingParams2.f15435c;
        float f11 = this.f17255n;
        previewItemDrawingParams.f15435c = SyntheticHelpers.m7906e(f10, f11, fFloatValue, f11);
        folderIcon.postInvalidateOnAnimation();
    }
}
