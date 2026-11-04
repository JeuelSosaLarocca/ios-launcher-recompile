package com.luutinhit.launcher6;

import B3.C0081x;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.w2 */
/* JADX INFO: loaded from: classes.dex */
public final class BindWorkspaceItemsRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ LauncherModelCallbacks f17027j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ArrayList f17028k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ ArrayList f17029l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ ArrayList f17030m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ C0081x f17031n;

    /* JADX INFO: renamed from: o */
    public /* synthetic */ boolean f17032o;

    /* JADX INFO: renamed from: p */
    public /* synthetic */ int f17033p;

    /* JADX INFO: renamed from: q */
    public /* synthetic */ LoaderTask f17034q;

    public BindWorkspaceItemsRunnable(LoaderTask loaderTask, LauncherModelCallbacks launcherModelCallbacks, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, C0081x c0081x, boolean z5, int i6) {
        this.f17034q = loaderTask;
        this.f17027j = launcherModelCallbacks;
        this.f17028k = arrayList;
        this.f17029l = arrayList2;
        this.f17030m = arrayList3;
        this.f17031n = c0081x;
        this.f17032o = z5;
        this.f17033p = i6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i6;
        LauncherModelCallbacks launcherModelCallbacks = this.f17027j;
        LoaderTask loaderTask = this.f17034q;
        LauncherModelCallbacks launcherModelCallbacksM8272m = loaderTask.m8272m(launcherModelCallbacks);
        if (launcherModelCallbacksM8272m != null) {
            launcherModelCallbacksM8272m.startBinding();
        }
        Objects.toString(launcherModelCallbacks);
        ArrayList arrayList = this.f17028k;
        Objects.toString(arrayList);
        loaderTask.f17243n.m7580x(new LoaderBindRunnable(loaderTask, launcherModelCallbacks, arrayList, 2));
        this.f17034q.m8262b(launcherModelCallbacks, this.f17029l, this.f17030m, this.f17031n, null);
        if (launcherModelCallbacksM8272m == null || !this.f17032o || (i6 = this.f17033p) == -1001) {
            return;
        }
        launcherModelCallbacksM8272m.onPageBoundSynchronously(i6);
    }
}
