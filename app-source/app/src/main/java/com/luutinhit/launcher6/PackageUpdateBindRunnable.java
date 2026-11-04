package com.luutinhit.launcher6;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.y2 */
/* JADX INFO: loaded from: classes.dex */
public final class PackageUpdateBindRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17258j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherModelCallbacks f17259k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ ArrayList f17260l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ PackageUpdatedTask f17261m;

    public /* synthetic */ PackageUpdateBindRunnable(PackageUpdatedTask packageUpdatedTask, LauncherModelCallbacks launcherModelCallbacks, ArrayList arrayList, int i6) {
        this.f17258j = i6;
        this.f17261m = packageUpdatedTask;
        this.f17259k = launcherModelCallbacks;
        this.f17260l = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17258j) {
            case 0:
                LauncherModelCallbacks callback = this.f17261m.f15304s.getCallback();
                LauncherModelCallbacks launcherModelCallbacks = this.f17259k;
                if (launcherModelCallbacks == callback && callback != null) {
                    launcherModelCallbacks.bindAppsUpdated(this.f17260l);
                    break;
                }
                break;
            case 1:
                LauncherModelCallbacks callback2 = this.f17261m.f15304s.getCallback();
                LauncherModelCallbacks launcherModelCallbacks2 = this.f17259k;
                if (launcherModelCallbacks2 == callback2 && callback2 != null) {
                    launcherModelCallbacks2.bindWidgetsRestored(this.f17260l);
                    break;
                }
                break;
            default:
                LauncherModelCallbacks callback3 = this.f17261m.f15304s.getCallback();
                LauncherModelCallbacks launcherModelCallbacks3 = this.f17259k;
                if (launcherModelCallbacks3 == callback3 && callback3 != null) {
                    launcherModelCallbacks3.bindAppInfosRemoved(this.f17260l);
                    break;
                }
                break;
        }
    }
}
