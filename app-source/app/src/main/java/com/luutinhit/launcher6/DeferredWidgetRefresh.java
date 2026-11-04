package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHostView;
import android.os.Handler;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.w3 */
/* JADX INFO: loaded from: classes.dex */
public final class DeferredWidgetRefresh implements Runnable {

    /* JADX INFO: renamed from: j */
    public ArrayList f17035j;

    /* JADX INFO: renamed from: k */
    public LauncherAppWidgetHost f17036k;

    /* JADX INFO: renamed from: l */
    public Handler f17037l;

    /* JADX INFO: renamed from: m */
    public boolean f17038m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ Workspace f17039n;

    public DeferredWidgetRefresh(Workspace workspace, ArrayList arrayList, LauncherAppWidgetHost launcherAppWidgetHost) {
        this.f17039n = workspace;
        this.f17035j = arrayList;
        this.f17036k = launcherAppWidgetHost;
        Handler handler = new Handler();
        this.f17037l = handler;
        this.f17038m = true;
        launcherAppWidgetHost.mProviderChangeListeners.add(this);
        handler.postDelayed(this, 10000L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        LauncherAppWidgetHost launcherAppWidgetHost = this.f17036k;
        if (launcherAppWidgetHost != null) {
            launcherAppWidgetHost.mProviderChangeListeners.remove(this);
        }
        Handler handler = this.f17037l;
        if (handler != null) {
            handler.removeCallbacks(this);
        }
        if (this.f17038m) {
            this.f17038m = false;
            ArrayList arrayList = this.f17035j;
            if (arrayList != null) {
                Workspace workspace = this.f17039n;
                if (workspace.f23432V0 != null) {
                    int size = arrayList.size();
                    int i6 = 0;
                    while (i6 < size) {
                        Object obj = arrayList.get(i6);
                        i6++;
                        LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) obj;
                        if (launcherAppWidgetInfo != null) {
                            AppWidgetHostView appWidgetHostView = launcherAppWidgetInfo.f16573F;
                            if (appWidgetHostView instanceof PendingAppWidgetHostView) {
                                workspace.f23432V0.removeItem((PendingAppWidgetHostView) appWidgetHostView, launcherAppWidgetInfo, false);
                                workspace.f23432V0.bindAppWidget(launcherAppWidgetInfo);
                            }
                        }
                    }
                }
            }
        }
    }
}
