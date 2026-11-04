package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.c2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherAppWidgetHost extends AppWidgetHost {

    /* JADX INFO: renamed from: a */
    public ArrayList mProviderChangeListeners;

    /* JADX INFO: renamed from: b */
    public int f16335b;

    /* JADX INFO: renamed from: c */
    public Launcher f16336c;

    public LauncherAppWidgetHost(Launcher launcher) {
        super(launcher, 1024);
        this.mProviderChangeListeners = new ArrayList();
        this.f16335b = -1;
        this.f16336c = launcher;
    }

    @Override // android.appwidget.AppWidgetHost
    public final AppWidgetHostView onCreateView(Context context, int i6, AppWidgetProviderInfo appWidgetProviderInfo) {
        return i6 == this.f16335b ? new EmptyErrorAppWidgetHostView(context) : new LauncherAppWidgetHostView(context);
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onProviderChanged(int i6, AppWidgetProviderInfo appWidgetProviderInfo) {
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfoFromProviderInfo = LauncherAppWidgetProviderInfo.fromProviderInfo(appWidgetProviderInfo);
        super.onProviderChanged(i6, launcherAppWidgetProviderInfoFromProviderInfo);
        launcherAppWidgetProviderInfoFromProviderInfo.initSpans();
    }

    @Override // android.appwidget.AppWidgetHost
    public final void onProvidersChanged() {
        ArrayList arrayList = this.mProviderChangeListeners;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            int size = arrayList2.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList2.get(i6);
                i6++;
                ((Runnable) obj).run();
            }
        }
        if (Utilities.f16748i) {
            this.f16336c.notifyWidgetProvidersChanged();
        }
    }

    @Override // android.appwidget.AppWidgetHost
    public final void startListening() {
        try {
            super.startListening();
        } catch (Throwable unused) {
        }
    }

    @Override // android.appwidget.AppWidgetHost
    public final void stopListening() {
        super.stopListening();
        clearViews();
    }
}
