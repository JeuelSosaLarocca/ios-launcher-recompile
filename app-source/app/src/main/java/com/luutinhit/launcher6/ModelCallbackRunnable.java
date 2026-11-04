package com.luutinhit.launcher6;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.p2 */
/* JADX INFO: loaded from: classes.dex */
public final class ModelCallbackRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16816j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherModelCallbacks f16817k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ ArrayList f16818l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ LauncherModel f16819m;

    public /* synthetic */ ModelCallbackRunnable(LauncherModel launcherModel, LauncherModelCallbacks launcherModelCallbacks, ArrayList arrayList, int i6) {
        this.f16816j = i6;
        this.f16819m = launcherModel;
        this.f16817k = launcherModelCallbacks;
        this.f16818l = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16816j) {
            case 0:
                LauncherModelCallbacks callback = this.f16819m.getCallback();
                if (callback != null && this.f16817k == callback) {
                    callback.bindAppsUpdated(this.f16818l);
                    break;
                }
                break;
            case 1:
                LauncherModelCallbacks callback2 = this.f16819m.getCallback();
                if (callback2 != null && this.f16817k == callback2) {
                    callback2.bindAppsUpdated(this.f16818l);
                    break;
                }
                break;
            default:
                this.f16819m.m7580x(new MergedUiRunnable(8, this));
                break;
        }
    }
}
