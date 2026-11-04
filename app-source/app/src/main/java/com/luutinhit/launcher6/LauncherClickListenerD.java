package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.z1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherClickListenerD implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Launcher f17265j;

    public LauncherClickListenerD(Launcher launcher) {
        this.f17265j = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Launcher launcher = this.f17265j;
        launcher.mWorkspace.getClass();
        launcher.onClickSettingsButton(view);
    }
}
