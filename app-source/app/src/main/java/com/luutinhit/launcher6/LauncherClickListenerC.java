package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.y1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherClickListenerC implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Launcher f17257j;

    public LauncherClickListenerC(Launcher launcher) {
        this.f17257j = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Launcher launcher = this.f17257j;
        launcher.mWorkspace.getClass();
        launcher.onClickAddWidgetButton(view);
    }
}
