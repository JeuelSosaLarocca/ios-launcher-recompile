package com.luutinhit.launcher6;

import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.i3 */
/* JADX INFO: loaded from: classes.dex */
public final class Stats {

    /* JADX INFO: renamed from: a */
    public Launcher f16578a;

    /* JADX INFO: renamed from: b */
    public String mLaunchBroadcastPermission;

    public Stats(Launcher launcher) {
        this.f16578a = launcher;
        this.mLaunchBroadcastPermission = launcher.getResources().getString(R.string.receive_launch_broadcasts_permission);
    }
}
