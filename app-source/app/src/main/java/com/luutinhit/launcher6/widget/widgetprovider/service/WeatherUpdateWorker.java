package com.luutinhit.launcher6.widget.widgetprovider.service;

import B3.AbstractC0075r;
import B3.C0056Y;
import K0.AbstractC0569q;
import K0.AbstractC0577y;
import K0.C0560h;
import K0.C0568p;
import T0.C1022e;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.RemoteViews;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider;
import com.luutinhit.launcherios.R;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.network.OpenWeather;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p105m4.EnumC2410h;
import s5.AbstractC2752b;

/* JADX INFO: loaded from: classes.dex */
public class WeatherUpdateWorker extends Worker {

    /* JADX INFO: renamed from: o */
    public Context f17229o;

    /* JADX INFO: renamed from: p */
    public C0056Y f17230p;

    /* JADX INFO: renamed from: q */
    public OpenWeather f17231q;

    /* JADX INFO: renamed from: r */
    public LocationManager f17232r;

    public WeatherUpdateWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f17229o = context;
        this.f17232r = (LocationManager) context.getSystemService("location");
        this.f17230p = new C0056Y(context);
        this.f17231q = OpenWeather.getInstance(5000, true);
    }

    /* JADX INFO: renamed from: a */
    public static void m8256a(WeatherUpdateWorker weatherUpdateWorker, List list) {
        C0056Y c0056y = weatherUpdateWorker.f17230p;
        if (c0056y != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", AbstractC2752b.m9849i(weatherUpdateWorker.f17229o.getResources().getConfiguration()).f1788a.get());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int iMin = Math.min(list.size(), 6);
            for (int i6 = 0; i6 < iMin; i6++) {
                Hourly hourly = (Hourly) list.get(i6);
                arrayList.add(simpleDateFormat.format(Long.valueOf(hourly.getDt() * 1000)));
                int iRound = Math.round(hourly.getMain().getTemp());
                StringBuilder sb = new StringBuilder();
                sb.append(iRound);
                sb.append((char) 176);
                arrayList2.add(sb.toString());
                arrayList3.add(Integer.valueOf(WeatherWidget.m8232H(hourly.getWeather().get(0).getId(), hourly.getWeather().get(0).getIcon())));
            }
            c0056y.m139i("daily_weather_day", arrayList);
            c0056y.m139i("daily_weather_temp_low", arrayList2);
            c0056y.m137g(arrayList3);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8257c() {
        Context context = this.f17229o;
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget_provider_layout);
            Intent intent = new Intent(context, (Class<?>) WeatherActivity.class);
            intent.setPackage(context.getPackageName());
            remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout, PendingIntent.getActivity(context, 0, intent, (Utilities.f16747h ? 67108864 : 0) | 134217728));
            int i6 = Calendar.getInstance().get(11);
            if (i6 <= 6 || i6 >= 18) {
                remoteViews.setInt(R.id.widget_weather_layout, "setBackgroundResource", R.drawable.weather_background_clear_night);
            }
            C0056Y c0056y = this.f17230p;
            if (c0056y != null) {
                remoteViews.setTextViewText(R.id.widget_weather_location, c0056y.m135e("city"));
                remoteViews.setTextViewText(R.id.widget_weather_temp, c0056y.m135e("current_temp"));
                remoteViews.setImageViewResource(R.id.widget_weather_icon, c0056y.f137a.getInt("current_drawable_id", R.drawable.ic_sunny));
                remoteViews.setTextViewText(R.id.widget_weather_state, c0056y.m135e("weather_state"));
                remoteViews.setTextViewText(R.id.widget_weather_low_high_temp, "H:" + c0056y.m135e("current_temp_high") + " L:" + c0056y.m135e("current_temp_low"));
                ArrayList arrayListM134d = c0056y.m134d("daily_weather_day");
                ArrayList arrayListM134d2 = c0056y.m134d("daily_weather_temp_low");
                ArrayList arrayListM133c = c0056y.m133c();
                if (arrayListM134d.size() >= 6 && arrayListM133c.size() >= 6 && arrayListM134d2.size() >= 6) {
                    remoteViews.setTextViewText(R.id.widget_weather_item_day_1, (CharSequence) arrayListM134d.get(0));
                    remoteViews.setTextViewText(R.id.widget_weather_item_day_2, (CharSequence) arrayListM134d.get(1));
                    remoteViews.setTextViewText(R.id.widget_weather_item_day_3, (CharSequence) arrayListM134d.get(2));
                    remoteViews.setTextViewText(R.id.widget_weather_item_day_4, (CharSequence) arrayListM134d.get(3));
                    remoteViews.setTextViewText(R.id.widget_weather_item_day_5, (CharSequence) arrayListM134d.get(4));
                    remoteViews.setTextViewText(R.id.widget_weather_item_day_6, (CharSequence) arrayListM134d.get(5));
                    remoteViews.setImageViewResource(R.id.widget_weather_item_icon_1, ((Integer) arrayListM133c.get(0)).intValue());
                    remoteViews.setImageViewResource(R.id.widget_weather_item_icon_2, ((Integer) arrayListM133c.get(1)).intValue());
                    remoteViews.setImageViewResource(R.id.widget_weather_item_icon_3, ((Integer) arrayListM133c.get(2)).intValue());
                    remoteViews.setImageViewResource(R.id.widget_weather_item_icon_4, ((Integer) arrayListM133c.get(3)).intValue());
                    remoteViews.setImageViewResource(R.id.widget_weather_item_icon_5, ((Integer) arrayListM133c.get(4)).intValue());
                    remoteViews.setImageViewResource(R.id.widget_weather_item_icon_6, ((Integer) arrayListM133c.get(5)).intValue());
                    remoteViews.setTextViewText(R.id.widget_weather_item_temp_1, String.format("%s", arrayListM134d2.get(0)));
                    remoteViews.setTextViewText(R.id.widget_weather_item_temp_2, String.format("%s", arrayListM134d2.get(1)));
                    remoteViews.setTextViewText(R.id.widget_weather_item_temp_3, String.format("%s", arrayListM134d2.get(2)));
                    remoteViews.setTextViewText(R.id.widget_weather_item_temp_4, String.format("%s", arrayListM134d2.get(3)));
                    remoteViews.setTextViewText(R.id.widget_weather_item_temp_5, String.format("%s", arrayListM134d2.get(4)));
                    remoteViews.setTextViewText(R.id.widget_weather_item_temp_6, String.format("%s", arrayListM134d2.get(5)));
                }
                AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8258d() {
        Context context = this.f17229o;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget_provider_no_connection);
        remoteViews.setTextViewText(R.id.widget_weather_layout_no_connection, context.getString(R.string.fails_to_parse_weather_info));
        remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout_no_connection, PendingIntent.getActivity(context, 3, new Intent(context, (Class<?>) WeatherActivity.class), (Utilities.f16747h ? 67108864 : 0) | 134217728));
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }

    @Override // androidx.work.Worker
    public final AbstractC0569q doWork() {
        LocationManager locationManager;
        int i6;
        Object obj = getInputData().f1723a.get("ACTION_TYPE_KEY");
        if ((obj instanceof Integer ? ((Integer) obj).intValue() : 2) == 2) {
            m8257c();
        } else {
            Context context = this.f17229o;
            if (AbstractC0075r.m194o(context) && (locationManager = this.f17232r) != null && (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network"))) {
                if (!AbstractC0577y.m1345v(context)) {
                    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget_provider_no_connection);
                    remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout_no_connection, PendingIntent.getActivity(context, 2, new Intent(context, (Class<?>) WeatherActivity.class), (Utilities.f16747h ? 67108864 : 0) | 134217728));
                    AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
                } else if (AbstractC0075r.m194o(context)) {
                    CountDownLatch countDownLatch = new CountDownLatch(2);
                    try {
                        i6 = Integer.parseInt(this.f17230p.f137a.getString("preference_unit", "1"));
                    } catch (Throwable unused) {
                        i6 = 1;
                    }
                    EnumC2410h enumC2410h = (i6 == 1 ? 1 : 0) != 0 ? EnumC2410h.f19711k : EnumC2410h.f19710j;
                    OpenWeather openWeather = this.f17231q;
                    openWeather.setUnit(enumC2410h);
                    openWeather.queryWeatherByGPS(context, new C1022e(this, countDownLatch, 7, false));
                    try {
                        if (countDownLatch.await(30L, TimeUnit.SECONDS)) {
                            m8257c();
                        } else {
                            m8258d();
                        }
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        m8258d();
                    }
                }
            } else {
                m8259e();
            }
        }
        return new C0568p(C0560h.f1722b);
    }

    /* JADX INFO: renamed from: e */
    public final void m8259e() {
        Context context = this.f17229o;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget_provider_request_permission);
        remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout_request_permission, PendingIntent.getActivity(context, 1, new Intent(context, (Class<?>) WeatherActivity.class), (Utilities.f16747h ? 67108864 : 0) | 134217728));
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }
}
