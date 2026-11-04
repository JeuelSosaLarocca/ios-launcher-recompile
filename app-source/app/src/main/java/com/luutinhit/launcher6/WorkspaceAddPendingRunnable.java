package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.t3 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkspaceAddPendingRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ PendingAddItemInfo f16884j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ long f16885k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ long f16886l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ ItemInfo f16887m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ Workspace f16888n;

    public WorkspaceAddPendingRunnable(Workspace workspace, PendingAddItemInfo pendingAddItemInfo, long j6, long j7, ItemInfo itemInfo) {
        this.f16888n = workspace;
        this.f16884j = pendingAddItemInfo;
        this.f16885k = j6;
        this.f16886l = j7;
        this.f16887m = itemInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Workspace workspace = this.f16888n;
        workspace.f23407F0 = true;
        Launcher launcher = workspace.f23432V0;
        int[] iArr = workspace.f23415J0;
        ItemInfo itemInfo = this.f16887m;
        launcher.addPendingItem(this.f16884j, this.f16885k, this.f16886l, iArr, itemInfo.spanX, itemInfo.spanY);
    }
}
