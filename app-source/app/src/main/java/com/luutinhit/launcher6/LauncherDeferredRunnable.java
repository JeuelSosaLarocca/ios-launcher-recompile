package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.L1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherDeferredRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15820j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ MergedModelRunnable f15821k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Launcher f15822l;

    public LauncherDeferredRunnable(Launcher launcher, int i6, MergedModelRunnable mergedModelRunnable) {
        this.f15822l = launcher;
        this.f15820j = i6;
        this.f15821k = mergedModelRunnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Launcher launcher = this.f15822l;
        Workspace workspace = launcher.mWorkspace;
        if (workspace != null) {
            workspace.l0(this.f15820j);
            launcher.mWorkspace.postDelayed(this.f15821k, Launcher.NEW_APPS_ANIMATION_DELAY);
        }
    }
}
