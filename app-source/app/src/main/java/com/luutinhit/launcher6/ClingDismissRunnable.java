package com.luutinhit.launcher6;

import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.l2 */
/* JADX INFO: loaded from: classes.dex */
public final class ClingDismissRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16651j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherClings f16652k;

    public /* synthetic */ ClingDismissRunnable(LauncherClings launcherClings, int i6) {
        this.f16651j = i6;
        this.f16652k = launcherClings;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16651j) {
            case 0:
                MergedUiRunnable mergedUiRunnable = new MergedUiRunnable(7, this);
                LauncherClings launcherClings = this.f16652k;
                launcherClings.m8179a(launcherClings.f16798j.findViewById(R.id.migration_cling), mergedUiRunnable, "cling_gel.migration.dismissed");
                break;
            default:
                LauncherClings launcherClings2 = this.f16652k;
                launcherClings2.m8179a(launcherClings2.f16798j.findViewById(R.id.longpress_cling), null, "cling_gel.workspace.dismissed");
                break;
        }
    }
}
