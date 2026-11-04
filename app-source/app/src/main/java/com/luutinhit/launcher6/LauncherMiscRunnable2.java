package com.luutinhit.launcher6;

import java.util.ArrayList;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.O1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherMiscRunnable2 implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15867j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ArrayList f15868k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ ArrayList f15869l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ C2673q f15870m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ Launcher f15871n;

    public /* synthetic */ LauncherMiscRunnable2(Launcher launcher, ArrayList arrayList, ArrayList arrayList2, C2673q c2673q, int i6) {
        this.f15867j = i6;
        this.f15871n = launcher;
        this.f15868k = arrayList;
        this.f15869l = arrayList2;
        this.f15870m = c2673q;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15867j) {
            case 0:
                this.f15871n.bindShortcutsChanged(this.f15868k, this.f15869l, this.f15870m);
                break;
            default:
                this.f15871n.bindShortcutsHidden(this.f15868k, this.f15869l, this.f15870m);
                break;
        }
    }
}
