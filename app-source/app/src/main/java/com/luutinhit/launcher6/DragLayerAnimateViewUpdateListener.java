package com.luutinhit.launcher6;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Y */
/* JADX INFO: loaded from: classes.dex */
public final class DragLayerAnimateViewUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ DragView f16125j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Interpolator f16126k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Interpolator f16127l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ float f16128m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ float f16129n;

    /* JADX INFO: renamed from: o */
    public /* synthetic */ float f16130o;

    /* JADX INFO: renamed from: p */
    public /* synthetic */ float f16131p;

    /* JADX INFO: renamed from: q */
    public /* synthetic */ float f16132q;

    /* JADX INFO: renamed from: r */
    public /* synthetic */ float f16133r;

    /* JADX INFO: renamed from: s */
    public /* synthetic */ float f16134s;

    /* JADX INFO: renamed from: t */
    public /* synthetic */ Rect f16135t;

    /* JADX INFO: renamed from: u */
    public /* synthetic */ Rect f16136u;

    /* JADX INFO: renamed from: v */
    public /* synthetic */ DragLayer f16137v;

    public DragLayerAnimateViewUpdateListener(DragLayer dragLayer, DragView dragView, Interpolator interpolator, Interpolator interpolator2, float f6, float f7, float f8, float f9, float f10, float f11, float f12, Rect rect, Rect rect2) {
        this.f16137v = dragLayer;
        this.f16125j = dragView;
        this.f16126k = interpolator;
        this.f16127l = interpolator2;
        this.f16128m = f6;
        this.f16129n = f7;
        this.f16130o = f8;
        this.f16131p = f9;
        this.f16132q = f10;
        this.f16133r = f11;
        this.f16134s = f12;
        this.f16135t = rect;
        this.f16136u = rect2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        DragView dragView = this.f16125j;
        int measuredWidth = dragView.getMeasuredWidth();
        int measuredHeight = dragView.getMeasuredHeight();
        Interpolator interpolator = this.f16126k;
        float interpolation = interpolator == null ? fFloatValue : interpolator.getInterpolation(fFloatValue);
        Interpolator interpolator2 = this.f16127l;
        float interpolation2 = interpolator2 == null ? fFloatValue : interpolator2.getInterpolation(fFloatValue);
        float f6 = this.f16128m;
        float f7 = this.f16129n;
        float f8 = f6 * f7;
        float f9 = this.f16130o * f7;
        float f10 = 1.0f - fFloatValue;
        float f11 = (f8 * f10) + (this.f16131p * fFloatValue);
        float f12 = (f10 * f9) + (this.f16132q * fFloatValue);
        float fM7906e = SyntheticHelpers.m7906e(1.0f, interpolation, this.f16134s, this.f16133r * interpolation);
        Rect rect = this.f16135t;
        float f13 = (((f8 - 1.0f) * measuredWidth) / 2.0f) + rect.left;
        float f14 = (((f9 - 1.0f) * measuredHeight) / 2.0f) + rect.top;
        Rect rect2 = this.f16136u;
        int iRound = (int) (f13 + Math.round((rect2.left - f13) * interpolation2));
        int iRound2 = (int) (f14 + Math.round((rect2.top - f14) * interpolation2));
        DragLayer dragLayer = this.f16137v;
        View view = dragLayer.mAnchorView;
        int scrollX = (iRound - dragLayer.mDropView.getScrollX()) + (view == null ? 0 : (int) (view.getScaleX() * (dragLayer.mAnchorViewInitialScrollX - dragLayer.mAnchorView.getScrollX())));
        int scrollY = iRound2 - dragLayer.mDropView.getScrollY();
        dragLayer.mDropView.setTranslationX(scrollX);
        dragLayer.mDropView.setTranslationY(scrollY);
        dragLayer.mDropView.setScaleX(f11);
        dragLayer.mDropView.setScaleY(f12);
        dragLayer.mDropView.setAlpha(fM7906e);
    }
}
