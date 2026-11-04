package com.luutinhit.launcher6;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.F0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderItemAnimRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ View f15563j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ float f15564k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ int f15565l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ FolderPagedView f15566m;

    public FolderItemAnimRunnable(FolderPagedView folderPagedView, View view, float f6, int i6) {
        this.f15566m = folderPagedView;
        this.f15563j = view;
        this.f15564k = f6;
        this.f15565l = i6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FolderPagedView folderPagedView = this.f15566m;
        HashMap map = folderPagedView.f23352z0;
        View view = this.f15563j;
        map.remove(view);
        view.setTranslationX(this.f15564k);
        ((CellLayout) view.getParent().getParent()).removeView(view);
        folderPagedView.u0(view, (ShortcutInfo) view.getTag(), this.f15565l);
    }
}
