package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHostView;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Q1 */
/* JADX INFO: loaded from: classes.dex */
public final class CompleteAddRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f15933j = 0;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ int f15934k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ int f15935l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ Launcher f15936m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ ViewGroup f15937n;

    public CompleteAddRunnable(Launcher launcher, int i6, int i7, CellLayout cellLayout) {
        this.f15936m = launcher;
        this.f15934k = i6;
        this.f15935l = i7;
        this.f15937n = cellLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15933j) {
            case 0:
                Launcher launcher = this.f15936m;
                PendingAddItemInfo pendingAddItemInfo = launcher.mPendingAddInfo;
                launcher.completeAddAppWidget(this.f15934k, pendingAddItemInfo.container, pendingAddItemInfo.screenId, (AppWidgetHostView) this.f15937n, null);
                this.f15936m.exitSpringLoadedDragModeDelayed(this.f15935l != 0, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
            default:
                this.f15936m.completeTwoStageWidgetDrop(this.f15934k, this.f15935l);
                ((CellLayout) this.f15937n).setDropPending(false);
                break;
        }
    }

    public CompleteAddRunnable(int i6, int i7, AppWidgetHostView appWidgetHostView, Launcher launcher) {
        this.f15936m = launcher;
        this.f15934k = i6;
        this.f15937n = appWidgetHostView;
        this.f15935l = i7;
    }
}
