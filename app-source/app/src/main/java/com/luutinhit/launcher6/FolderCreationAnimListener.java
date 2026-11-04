package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: com.luutinhit.launcher6.I1 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderCreationAnimListener extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ CellLayout f15731j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ FolderIcon f15732k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Launcher f15733l;

    public FolderCreationAnimListener(Launcher launcher, CellLayout cellLayout, FolderIcon folderIcon) {
        this.f15733l = launcher;
        this.f15731j = cellLayout;
        this.f15732k = folderIcon;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        CellLayout cellLayout = this.f15731j;
        if (cellLayout != null) {
            int[] iArr = cellLayout.f15446A;
            iArr[0] = -1;
            iArr[1] = -1;
            cellLayout.invalidate();
            Launcher launcher = this.f15733l;
            launcher.mDragLayer.removeView(launcher.mFolderIconImageView);
            this.f15732k.setVisibility(0);
        }
    }
}
