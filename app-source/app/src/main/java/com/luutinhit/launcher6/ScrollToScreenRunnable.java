package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.M1 */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollToScreenRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ long f15850j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Launcher f15851k;

    public ScrollToScreenRunnable(Launcher launcher, long j6) {
        this.f15851k = launcher;
        this.f15850j = j6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Workspace workspace = this.f15851k.mWorkspace;
        workspace.m0(workspace.Q0(this.f15850j), 950);
    }
}
