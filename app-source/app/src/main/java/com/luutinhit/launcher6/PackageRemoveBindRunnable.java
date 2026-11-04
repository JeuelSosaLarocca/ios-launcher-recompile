package com.luutinhit.launcher6;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.z2 */
/* JADX INFO: loaded from: classes.dex */
public final class PackageRemoveBindRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17266j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherModelCallbacks f17267k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ PackageUpdatedTask f17268l;

    public /* synthetic */ PackageRemoveBindRunnable(PackageUpdatedTask packageUpdatedTask, LauncherModelCallbacks launcherModelCallbacks, int i6) {
        this.f17266j = i6;
        this.f17268l = packageUpdatedTask;
        this.f17267k = launcherModelCallbacks;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17266j) {
            case 0:
                LauncherModelCallbacks callback = this.f17268l.f15304s.getCallback();
                LauncherModelCallbacks launcherModelCallbacks = this.f17267k;
                if (launcherModelCallbacks == callback && callback != null) {
                    launcherModelCallbacks.notifyWidgetProvidersChanged();
                    break;
                }
                break;
            default:
                PackageUpdatedTask packageUpdatedTask = this.f17268l;
                LauncherModelCallbacks callback2 = packageUpdatedTask.f15304s.getCallback();
                LauncherModelCallbacks launcherModelCallbacks2 = this.f17267k;
                if (launcherModelCallbacks2 == callback2 && callback2 != null) {
                    launcherModelCallbacks2.onAllAppsChanged((ArrayList) packageUpdatedTask.f15304s.f15353u.f1070k);
                    break;
                }
                break;
        }
    }
}
