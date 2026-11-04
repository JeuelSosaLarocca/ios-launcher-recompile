package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.T2 */
/* JADX INFO: loaded from: classes.dex */
public final class PageReorderRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15960j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ int f15961k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ PagedView f15962l;

    public PageReorderRunnable(PagedView pagedView, int i6, int i7) {
        this.f15962l = pagedView;
        this.f15960j = i6;
        this.f15961k = i7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PagedView pagedView = this.f15962l;
        int i6 = this.f15960j;
        pagedView.l0(i6);
        int i7 = this.f15961k;
        int i8 = i7 < i6 ? -1 : 1;
        int i9 = i7 > i6 ? i7 - 1 : i6;
        for (int i10 = i7 < i6 ? i7 + 1 : i6; i10 <= i9; i10++) {
            View childAt = pagedView.getChildAt(i10);
            int childOffset = pagedView.getChildOffset(i10) + pagedView.getViewportOffsetX();
            int childOffset2 = pagedView.getChildOffset(i10 + i8) + pagedView.getViewportOffsetX();
            AnimatorSet animatorSet = (AnimatorSet) childAt.getTag(100);
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            childAt.setTranslationX(childOffset - childOffset2);
            AnimatorSet animatorSet2 = new AnimatorSet();
            Matrix matrix = PagedView.sTmpInvMatrix;
            animatorSet2.setDuration(Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT);
            animatorSet2.playTogether(ObjectAnimator.ofFloat(childAt, "translationX", 0.0f));
            animatorSet2.start();
            childAt.setTag(animatorSet2);
        }
        pagedView.removeView(pagedView.f23386j0);
        pagedView.addView(pagedView.f23386j0, i6);
        pagedView.f23388l0 = -1;
        PageIndicator pageIndicator = pagedView.mPageIndicator;
        if (pageIndicator != null) {
            pageIndicator.setActiveMarker(pagedView.getNextPage());
        }
    }
}
