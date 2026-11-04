package com.luutinhit.launcher6;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.u3 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkspaceDropRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16898j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Workspace f16899k;

    public /* synthetic */ WorkspaceDropRunnable(Workspace workspace, int i6) {
        this.f16898j = i6;
        this.f16899k = workspace;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i6;
        Runnable[] runnableArr;
        switch (this.f16898j) {
            case 0:
                LauncherModel model = this.f16899k.f23432V0.getModel();
                model.getClass();
                ArrayList arrayList = LauncherModel.mDeferredBindRunnables;
                if (arrayList.isEmpty()) {
                    return;
                }
                synchronized (arrayList) {
                    runnableArr = (Runnable[]) arrayList.toArray(new Runnable[0]);
                    arrayList.clear();

                }
                for (Runnable runnable : runnableArr) {
                    model.f15345m.m7884e(runnable);
                }
                return;
            default:
                this.f16899k.f23432V0.exitSpringLoadedDragModeDelayed(true, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                return;
        }
    }
}
