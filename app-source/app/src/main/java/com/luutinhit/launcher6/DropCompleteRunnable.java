package com.luutinhit.launcher6;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.luutinhit.launcher6.r0 */
/* JADX INFO: loaded from: classes.dex */
public final class DropCompleteRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16841j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ View f16842k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ DragObject f16843l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ boolean f16844m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ ViewGroup f16845n;

    public /* synthetic */ DropCompleteRunnable(ViewGroup viewGroup, View view, DragObject dragObject, boolean z5, int i6) {
        this.f16841j = i6;
        this.f16845n = viewGroup;
        this.f16842k = view;
        this.f16843l = dragObject;
        this.f16844m = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16841j) {
            case 0:
                View view = this.f16842k;
                DragObject dragObject = this.f16843l;
                Folder folder = (Folder) this.f16845n;
                folder.mo7691F(view, dragObject, this.f16844m);
                folder.f15619V = null;
                break;
            default:
                View view2 = this.f16842k;
                DragObject dragObject2 = this.f16843l;
                Workspace workspace = (Workspace) this.f16845n;
                workspace.mo7691F(view2, dragObject2, this.f16844m);
                workspace.f23410G1 = null;
                break;
        }
    }
}
