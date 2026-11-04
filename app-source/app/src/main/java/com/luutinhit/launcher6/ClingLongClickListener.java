package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.m2 */
/* JADX INFO: loaded from: classes.dex */
public final class ClingLongClickListener implements View.OnLongClickListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ LauncherClings f16735j;

    public ClingLongClickListener(LauncherClings launcherClings) {
        this.f16735j = launcherClings;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        LauncherClings launcherClings = this.f16735j;
        launcherClings.f16798j.showOverviewMode(true);
        launcherClings.f16798j.getWorkspace().post(new ClingDismissRunnable(launcherClings, 1));
        return true;
    }
}
