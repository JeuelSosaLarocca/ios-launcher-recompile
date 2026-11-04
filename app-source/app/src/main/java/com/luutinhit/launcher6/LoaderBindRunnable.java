package com.luutinhit.launcher6;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.u2 */
/* JADX INFO: loaded from: classes.dex */
public final class LoaderBindRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16894j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherModelCallbacks f16895k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ ArrayList f16896l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ LoaderTask f16897m;

    public /* synthetic */ LoaderBindRunnable(LoaderTask loaderTask, LauncherModelCallbacks launcherModelCallbacks, ArrayList arrayList, int i6) {
        this.f16894j = i6;
        this.f16897m = loaderTask;
        this.f16895k = launcherModelCallbacks;
        this.f16896l = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16894j) {
            case 0:
                SystemClock.uptimeMillis();
                LauncherModelCallbacks launcherModelCallbacksM8272m = this.f16897m.m8272m(this.f16895k);
                if (launcherModelCallbacksM8272m != null) {
                    launcherModelCallbacksM8272m.bindAllApplications(this.f16896l);
                }
                break;
            case 1:
                SystemClock.uptimeMillis();
                LauncherModelCallbacks launcherModelCallbacksM8272m2 = this.f16897m.m8272m(this.f16895k);
                if (launcherModelCallbacksM8272m2 != null) {
                    launcherModelCallbacksM8272m2.bindAllApplications(this.f16896l);
                }
                break;
            default:
                LauncherModelCallbacks launcherModelCallbacksM8272m3 = this.f16897m.m8272m(this.f16895k);
                if (launcherModelCallbacksM8272m3 != null) {
                    launcherModelCallbacksM8272m3.bindScreens(this.f16896l);
                }
                break;
        }
    }
}
