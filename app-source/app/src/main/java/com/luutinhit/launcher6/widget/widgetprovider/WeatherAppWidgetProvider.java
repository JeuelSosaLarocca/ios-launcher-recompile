package com.luutinhit.launcher6.widget.widgetprovider;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import com.luutinhit.launcher6.widget.widgetprovider.service.WeatherJobIntentService;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WeatherAppWidgetProvider extends AppWidgetProvider {
    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Objects.toString(intent);
        if (!"com.luutinhit.ACTION_UPDATE_WEATHER_WIDGET_FROM_DB".equals(intent.getAction())) {
            super.onReceive(context, intent);
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) WeatherJobIntentService.class);
        intent2.setAction("com.luutinhit.ACTION_UPDATE_WEATHER_WIDGET_FROM_DB");
        WeatherJobIntentService.m8251e(context, intent2);
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        WeatherJobIntentService.m8251e(context, new Intent(context, (Class<?>) WeatherJobIntentService.class));
    }
}
