package com.luutinhit.launcher6;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.N1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherMiscRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15854j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ArrayList f15855k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Launcher f15856l;

    public /* synthetic */ LauncherMiscRunnable(Launcher launcher, ArrayList arrayList, int i6) {
        this.f15854j = i6;
        this.f15856l = launcher;
        this.f15855k = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15854j) {
            case 0:
                this.f15856l.bindAppsUpdated(this.f15855k);
                break;
            case 1:
                this.f15856l.bindWidgetsRestored(this.f15855k);
                break;
            default:
                this.f15856l.bindAppInfosRemoved(this.f15855k);
                break;
        }
    }
}
