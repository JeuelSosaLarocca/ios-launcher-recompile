package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.D */
/* JADX INFO: loaded from: classes.dex */
public final class CellLayoutChildAnimListener extends AnimatorListenerAdapter {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15486j;

    /* JADX INFO: renamed from: k */
    public boolean f15487k = false;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ CellLayoutLayoutParams f15488l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ View f15489m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ CellLayout f15490n;

    public /* synthetic */ CellLayoutChildAnimListener(CellLayout cellLayout, CellLayoutLayoutParams cellLayoutLayoutParams, View view, int i6) {
        this.f15486j = i6;
        this.f15490n = cellLayout;
        this.f15488l = cellLayoutLayoutParams;
        this.f15489m = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f15486j) {
            case 0:
                this.f15487k = true;
                break;
            default:
                this.f15487k = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f15486j) {
            case 0:
                boolean z5 = this.f15487k;
                CellLayoutLayoutParams cellLayoutLayoutParams = this.f15488l;
                if (!z5) {
                    cellLayoutLayoutParams.f15692h = true;
                    this.f15489m.requestLayout();
                }
                this.f15490n.f15452G.remove(cellLayoutLayoutParams);
                break;
            default:
                boolean z6 = this.f15487k;
                CellLayoutLayoutParams cellLayoutLayoutParams2 = this.f15488l;
                if (!z6) {
                    cellLayoutLayoutParams2.f15692h = true;
                    this.f15489m.requestLayout();
                }
                this.f15490n.f15452G.remove(cellLayoutLayoutParams2);
                break;
        }
    }
}
