package com.luutinhit.launcher6;

import p007I.AbstractC0438a;

/* JADX INFO: renamed from: com.luutinhit.launcher6.P1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherPageRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f15902j = 1;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ int f15903k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Launcher f15904l;

    public LauncherPageRunnable(int i6, Launcher launcher) {
        this.f15903k = i6;
        this.f15904l = launcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15902j) {
            case 0:
                this.f15904l.exitSpringLoadedDragModeDelayed(this.f15903k != 0, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
            default:
                double dM1032d = AbstractC0438a.m1032d(this.f15903k);
                Launcher launcher = this.f15904l;
                if (dM1032d <= 0.8d) {
                    launcher.updateIconTextColor(-1);
                } else {
                    launcher.updateIconTextColor(-12303292);
                }
                break;
        }
    }

    public LauncherPageRunnable(Launcher launcher, int i6) {
        this.f15904l = launcher;
        this.f15903k = i6;
    }
}
