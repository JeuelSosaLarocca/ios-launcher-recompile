package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.x0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FolderIconGlassRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17235j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ FolderIcon f17236k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ boolean f17237l;

    public /* synthetic */ FolderIconGlassRunnable(FolderIcon folderIcon, boolean z5, int i6) {
        this.f17235j = i6;
        this.f17236k = folderIcon;
        this.f17237l = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z5 = this.f17237l;
        FolderIcon folderIcon = this.f17236k;
        switch (this.f17235j) {
            case 0:
                boolean z6 = FolderIcon.f15638G;
                folderIcon.setGlassViewVisible(z5);
                break;
            default:
                LiquidGlassSurfaceView liquidGlassSurfaceView = folderIcon.f15654o;
                if (liquidGlassSurfaceView != null) {
                    liquidGlassSurfaceView.setVisibility(z5 ? 0 : 4);
                }
                break;
        }
    }
}
