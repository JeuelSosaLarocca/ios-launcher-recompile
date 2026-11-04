package com.luutinhit.launcher6;

import android.widget.RemoteViews;

/* JADX INFO: renamed from: com.luutinhit.launcher6.f2 */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetHostViewRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16492j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherAppWidgetHostView f16493k;

    public /* synthetic */ WidgetHostViewRunnable(LauncherAppWidgetHostView launcherAppWidgetHostView, int i6) {
        this.f16492j = i6;
        this.f16493k = launcherAppWidgetHostView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16492j) {
            case 0:
                this.f16493k.f16533C.start();
                break;
            default:
                LauncherAppWidgetHostView launcherAppWidgetHostView = this.f16493k;
                launcherAppWidgetHostView.updateAppWidget(new RemoteViews(launcherAppWidgetHostView.getAppWidgetInfo().provider.getPackageName(), 0));
                break;
        }
    }
}
