package com.luutinhit.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.luutinhit.launcher6.C1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherFirstDrawListener implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a */
    public boolean f15437a = false;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Launcher f15438b;

    public LauncherFirstDrawListener(Launcher launcher) {
        this.f15438b = launcher;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.f15437a) {
            return;
        }
        this.f15437a = true;
        Launcher launcher = this.f15438b;
        launcher.mWorkspace.postDelayed(launcher.mBuildLayersRunnable, 500L);
        launcher.mWorkspace.post(new MergedModelRunnable(0, this, this));
    }
}
