package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.I */
/* JADX INFO: loaded from: classes.dex */
public final class ReorderPreviewAnimation {

    /* JADX INFO: renamed from: a */
    public View f15718a;

    /* JADX INFO: renamed from: b */
    public float f15719b;

    /* JADX INFO: renamed from: c */
    public float f15720c;

    /* JADX INFO: renamed from: d */
    public float f15721d;

    /* JADX INFO: renamed from: e */
    public float f15722e;

    /* JADX INFO: renamed from: f */
    public float f15723f;

    /* JADX INFO: renamed from: g */
    public float f15724g;

    /* JADX INFO: renamed from: h */
    public int f15725h;

    /* JADX INFO: renamed from: i */
    public boolean f15726i = false;

    /* JADX INFO: renamed from: j */
    public Animator f15727j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ CellLayout f15728k;

    public ReorderPreviewAnimation(CellLayout cellLayout, View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f15728k = cellLayout;
        cellLayout.regionToCenterPoint(i7, i8, i11, i12, cellLayout.f15479t);
        int[] iArr = cellLayout.f15479t;
        int i13 = iArr[0];
        int i14 = iArr[1];
        cellLayout.regionToCenterPoint(i9, i10, i11, i12, iArr);
        int i15 = iArr[0] - i13;
        int i16 = iArr[1] - i14;
        this.f15719b = 0.0f;
        this.f15720c = 0.0f;
        int i17 = i6 == 0 ? -1 : 1;
        if (i15 != i16 || i15 != 0) {
            float f6 = cellLayout.f15460O;
            if (i16 == 0) {
                this.f15719b = Math.signum(i15) * (-i17) * f6;
            } else if (i15 == 0) {
                this.f15720c = Math.signum(i16) * (-i17) * f6;
            } else {
                float f7 = i16;
                float f8 = i15;
                double dAtan = Math.atan(f7 / f8);
                float f9 = -i17;
                double dSignum = Math.signum(f8) * f9;
                double d6 = f6;
                this.f15719b = (int) (Math.abs(Math.cos(dAtan) * d6) * dSignum);
                this.f15720c = (int) (Math.abs(Math.sin(dAtan) * d6) * ((double) (Math.signum(f7) * f9)));
            }
        }
        this.f15725h = i6;
        this.f15721d = view.getTranslationX();
        this.f15722e = view.getTranslationY();
        this.f15723f = cellLayout.getChildrenScale() - (4.0f / view.getWidth());
        this.f15724g = view.getScaleX();
        this.f15718a = view;
    }

    /* JADX INFO: renamed from: a */
    public final void animate() {
        Animator animator = this.f15727j;
        if (animator != null) {
            animator.cancel();
        }
        AnimatorSet animatorSetCreateAnimatorSet = LauncherAnimUtils.createAnimatorSet();
        this.f15727j = animatorSetCreateAnimatorSet;
        CellLayout cellLayout = this.f15728k;
        float[] fArr = {cellLayout.getChildrenScale()};
        View view = this.f15718a;
        animatorSetCreateAnimatorSet.playTogether(LauncherAnimUtils.ofFloat(view, "scaleX", fArr), LauncherAnimUtils.ofFloat(view, "scaleY", cellLayout.getChildrenScale()), LauncherAnimUtils.ofFloat(view, "translationX", 0.0f), LauncherAnimUtils.ofFloat(view, "translationY", 0.0f));
        animatorSetCreateAnimatorSet.setDuration(150L);
        animatorSetCreateAnimatorSet.setInterpolator(new DecelerateInterpolator(1.5f));
        animatorSetCreateAnimatorSet.start();
    }
}
