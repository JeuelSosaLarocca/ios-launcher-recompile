package com.luutinhit.launcher6;

import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.K1 */
/* JADX INFO: loaded from: classes.dex */
public final class BindItemsRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ ArrayList f15763j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ int f15764k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ int f15765l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ boolean f15766m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ Launcher f15767n;

    public BindItemsRunnable(Launcher launcher, ArrayList arrayList, int i6, int i7, boolean z5) {
        this.f15767n = launcher;
        this.f15763j = arrayList;
        this.f15764k = i6;
        this.f15765l = i7;
        this.f15766m = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15767n.bindItems(this.f15763j, this.f15764k, this.f15765l, this.f15766m);
    }
}
