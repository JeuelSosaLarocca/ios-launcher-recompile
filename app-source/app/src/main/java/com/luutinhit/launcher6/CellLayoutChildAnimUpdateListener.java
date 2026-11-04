package com.luutinhit.launcher6;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.C */
/* JADX INFO: loaded from: classes.dex */
public final class CellLayoutChildAnimUpdateListener implements ValueAnimator.AnimatorUpdateListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15426j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ CellLayoutLayoutParams f15427k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ int f15428l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ int f15429m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ int f15430n;

    /* JADX INFO: renamed from: o */
    public /* synthetic */ int f15431o;

    /* JADX INFO: renamed from: p */
    public /* synthetic */ View f15432p;

    public /* synthetic */ CellLayoutChildAnimUpdateListener(CellLayoutLayoutParams cellLayoutLayoutParams, int i6, int i7, int i8, int i9, View view, int i10) {
        this.f15426j = i10;
        this.f15427k = cellLayoutLayoutParams;
        this.f15428l = i6;
        this.f15429m = i7;
        this.f15430n = i8;
        this.f15431o = i9;
        this.f15432p = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f15426j) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f6 = 1.0f - fFloatValue;
                int i6 = (int) ((this.f15429m * fFloatValue) + (this.f15428l * f6));
                CellLayoutLayoutParams cellLayoutLayoutParams = this.f15427k;
                cellLayoutLayoutParams.f15695k = i6;
                cellLayoutLayoutParams.f15696l = (int) ((fFloatValue * this.f15431o) + (f6 * this.f15430n));
                this.f15432p.requestLayout();
                break;
            default:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f7 = 1.0f - fFloatValue2;
                int i7 = (int) ((this.f15429m * fFloatValue2) + (this.f15428l * f7));
                CellLayoutLayoutParams cellLayoutLayoutParams2 = this.f15427k;
                cellLayoutLayoutParams2.f15695k = i7;
                cellLayoutLayoutParams2.f15696l = (int) ((fFloatValue2 * this.f15431o) + (f7 * this.f15430n));
                this.f15432p.requestLayout();
                break;
        }
    }
}
