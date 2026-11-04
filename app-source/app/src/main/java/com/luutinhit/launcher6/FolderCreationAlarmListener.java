package com.luutinhit.launcher6;

import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.x3 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderCreationAlarmListener implements OnAlarmListener {

    /* JADX INFO: renamed from: j */
    public CellLayout f17244j;

    /* JADX INFO: renamed from: k */
    public int f17245k;

    /* JADX INFO: renamed from: l */
    public int f17246l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ Workspace f17247m;

    public FolderCreationAlarmListener(Workspace workspace, CellLayout cellLayout, int i6, int i7) {
        this.f17247m = workspace;
        this.f17244j = cellLayout;
        this.f17245k = i6;
        this.f17246l = i7;
    }

    @Override // com.luutinhit.launcher6.OnAlarmListener
    /* JADX INFO: renamed from: h */
    public final void mo7775h(Alarm alarm) {
        Objects.toString(alarm);
        Workspace workspace = this.f17247m;
        FolderRingAnimator folderRingAnimator = workspace.f23453t1;
        if (folderRingAnimator != null) {
            folderRingAnimator.animateToNaturalState();
        }
        FolderRingAnimator folderRingAnimator2 = new FolderRingAnimator(workspace.f23432V0, null);
        workspace.f23453t1 = folderRingAnimator2;
        folderRingAnimator2.f15320a = this.f17245k;
        folderRingAnimator2.f15321b = this.f17246l;
        CellLayout cellLayout = this.f17244j;
        Objects.toString(cellLayout);
        folderRingAnimator2.f15322c = cellLayout;
        workspace.f23453t1.animateToAcceptState();
        cellLayout.showFolderAccept(workspace.f23453t1);
        workspace.setDragMode(1);
    }
}
