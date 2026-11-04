package com.luutinhit.launcher6;

import android.util.Pair;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.w1 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LauncherClickListenerA implements View.OnClickListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ Launcher f17024j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ItemInfo f17025k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Pair f17026l;

    public /* synthetic */ LauncherClickListenerA(Launcher launcher, ItemInfo itemInfo, Pair pair) {
        this.f17024j = launcher;
        this.f17025k = itemInfo;
        this.f17026l = pair;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Launcher.m7825e(this.f17024j, this.f17025k, this.f17026l);
    }
}
