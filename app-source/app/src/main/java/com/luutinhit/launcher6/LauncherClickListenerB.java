package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.x1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherClickListenerB implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Launcher f17238j;

    public LauncherClickListenerB(Launcher launcher) {
        this.f17238j = launcher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Launcher launcher = this.f17238j;
        launcher.mWorkspace.getClass();
        launcher.startWallpaperPicker(view);
    }
}
