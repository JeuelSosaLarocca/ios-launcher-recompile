package com.luutinhit.launcher6.widget.widgetprovider;

import B4.RunnableC0098o;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class AnalogClockWidgetProvider extends AppWidgetProvider {

    /* JADX INFO: renamed from: c */
    public static Context f17207c;

    /* JADX INFO: renamed from: a */
    public static final Handler f17205a = new Handler();

    /* JADX INFO: renamed from: b */
    public static boolean f17206b = false;

    /* JADX INFO: renamed from: d */
    public static final RunnableC0098o f17208d = new RunnableC0098o(1);

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        f17206b = false;
        f17205a.removeCallbacks(f17208d);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        f17207c = context;
        if (f17206b) {
            return;
        }
        f17206b = true;
        f17205a.post(f17208d);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        f17207c = context;
        if (f17206b) {
            return;
        }
        f17206b = true;
        f17205a.post(f17208d);
    }
}
