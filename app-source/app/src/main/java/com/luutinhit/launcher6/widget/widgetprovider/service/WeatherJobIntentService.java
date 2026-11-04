package com.luutinhit.launcher6.widget.widgetprovider.service;

import B3.AbstractC0075r;
import B3.C0056Y;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.widget.WeatherWidget;
import com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider;
import com.luutinhit.launcherios.R;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import p005F.AbstractC0229o;
import p005F.AbstractServiceC0230p;
import p105m4.EnumC2410h;
import p105m4.InterfaceC2415m;
import s5.AbstractC2752b;

/* JADX INFO: loaded from: classes.dex */
public class WeatherJobIntentService extends AbstractServiceC0230p implements SharedPreferences.OnSharedPreferenceChangeListener, InterfaceC2415m {

    /* JADX INFO: renamed from: q */
    public Context f17221q;

    /* JADX INFO: renamed from: r */
    public LocationManager f17222r;

    /* JADX INFO: renamed from: s */
    public C0056Y f17223s;

    /* JADX INFO: renamed from: t */
    public OpenWeather f17224t = OpenWeather.getInstance(5000, true);

    /* JADX INFO: renamed from: u */
    public boolean f17225u = true;

    /* JADX INFO: renamed from: v */
    public boolean f17226v = false;

    /* JADX INFO: renamed from: w */
    public int f17227w = 3600000;

    /* JADX INFO: renamed from: x */
    public long f17228x = 0;

    /* JADX INFO: renamed from: e */
    public static void m8251e(Context context, Intent intent) {
        try {
            ComponentName componentName = new ComponentName(context, (Class<?>) WeatherJobIntentService.class);
            synchronized (AbstractServiceC0230p.f677o) {
                AbstractC0229o abstractC0229oM517b = AbstractServiceC0230p.m517b(context, componentName, true, 1000);
                abstractC0229oM517b.m516b(1000);
                abstractC0229oM517b.mo510a(intent);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8252d() {
        try {
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.weather_app_widget_provider_layout);
            Intent intent = new Intent(this, (Class<?>) WeatherActivity.class);
            intent.setPackage(getPackageName());
            remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout, PendingIntent.getActivity(this, 0, intent, Utilities.f16748i ? 67108864 : 0));
            int i6 = Calendar.getInstance().get(11);
            if (i6 <= 6 || i6 >= 18) {
                remoteViews.setInt(R.id.widget_weather_layout, "setBackgroundResource", R.drawable.weather_background_clear_night);
            }
            C0056Y c0056y = this.f17223s;
            if (c0056y != null) {
                remoteViews.setTextViewText(R.id.widget_weather_location, c0056y.m135e("city"));
                remoteViews.setTextViewText(R.id.widget_weather_temp, this.f17223s.m135e("current_temp"));
                remoteViews.setImageViewResource(R.id.widget_weather_icon, this.f17223s.f137a.getInt("current_drawable_id", R.drawable.ic_sunny));
                remoteViews.setTextViewText(R.id.widget_weather_state, this.f17223s.m135e("weather_state"));
                remoteViews.setTextViewText(R.id.widget_weather_low_high_temp, "H:" + this.f17223s.m135e("current_temp_high") + " L:" + this.f17223s.m135e("current_temp_low"));
                ArrayList arrayListM134d = this.f17223s.m134d("daily_weather_day");
                ArrayList arrayListM134d2 = this.f17223s.m134d("daily_weather_temp_low");
                ArrayList arrayListM133c = this.f17223s.m133c();
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
                AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: f */
    public final int m8253f(String str) {
        try {
            return Integer.parseInt(this.f17223s.f137a.getString(str, "1"));
        } catch (Throwable th) {
            th.getMessage();
            return 1;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m8254g() {
        if (AbstractC0075r.m194o(this.f17221q)) {
            this.f17228x = System.currentTimeMillis();
            EnumC2410h enumC2410h = this.f17225u ? EnumC2410h.f19711k : EnumC2410h.f19710j;
            OpenWeather openWeather = this.f17224t;
            openWeather.setUnit(enumC2410h);
            openWeather.queryWeatherByGPS(this.f17221q, this);
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: h */
    public final void mo2127h(HourlyResponse hourlyResponse) {
        List<Hourly> list;
        if (hourlyResponse == null || (list = hourlyResponse.getList()) == null || list.isEmpty() || this.f17223s == null) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", AbstractC2752b.m9849i(getResources().getConfiguration()).f1788a.get());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int iMin = Math.min(list.size(), 6);
        for (int i6 = 0; i6 < iMin; i6++) {
            Hourly hourly = list.get(i6);
            arrayList.add(simpleDateFormat.format(Long.valueOf(hourly.getDt())));
            int temp = hourly.getMain().getTemp();
            StringBuilder sb = new StringBuilder();
            sb.append(temp);
            sb.append((char) 176);
            arrayList2.add(sb.toString());
            arrayList3.add(Integer.valueOf(WeatherWidget.m8232H(hourly.getWeather().get(0).getId(), hourly.getWeather().get(0).getIcon())));
        }
        this.f17223s.m139i("daily_weather_day", arrayList);
        this.f17223s.m139i("daily_weather_temp_low", arrayList2);
        this.f17223s.m137g(arrayList3);
        m8252d();
    }

    /* JADX INFO: renamed from: i */
    public final void m8255i() {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.weather_app_widget_provider_request_permission);
        Intent intent = new Intent(this, (Class<?>) WeatherActivity.class);
        intent.setPackage(getPackageName());
        remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout_request_permission, PendingIntent.getActivity(this, 0, intent, Utilities.f16748i ? 67108864 : 0));
        AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }

    @Override // p005F.AbstractServiceC0230p, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        C0056Y c0056y = this.f17223s;
        if (c0056y != null) {
            c0056y.f137a.unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            if (str.equals("preference_unit")) {
                this.f17225u = m8253f(str) == 1;
                m8254g();
            } else if (str.equals("preference_auto_refresh")) {
                this.f17227w = m8253f(str) * 3600000;
            }
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: t */
    public final void mo2136t(String str, CurrentResponse currentResponse, Throwable th) {
        if (currentResponse != null && th == null) {
            try {
                if (this.f17223s != null) {
                    this.f17226v = true;
                    if (TextUtils.isEmpty(str)) {
                        str = currentResponse.getName();
                    }
                    this.f17223s.m138h("city", str);
                    this.f17223s.m138h("weather_state", currentResponse.getWeather().get(0).getDescription());
                    this.f17223s.m136f(WeatherWidget.m8232H(currentResponse.getWeather().get(0).getId(), currentResponse.getWeather().get(0).getIcon()), "current_drawable_id");
                    C0056Y c0056y = this.f17223s;
                    int temp = currentResponse.getMain().getTemp();
                    StringBuilder sb = new StringBuilder();
                    sb.append(temp);
                    sb.append((char) 176);
                    c0056y.m138h("current_temp", sb.toString());
                    this.f17223s.m138h("CURRENT_DAY", currentResponse.getDt() + "");
                    C0056Y c0056y2 = this.f17223s;
                    int tempMin = currentResponse.getMain().getTempMin();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(tempMin);
                    sb2.append((char) 176);
                    c0056y2.m138h("current_temp_low", sb2.toString());
                    C0056Y c0056y3 = this.f17223s;
                    int tempMax = currentResponse.getMain().getTempMax();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(tempMax);
                    sb3.append((char) 176);
                    c0056y3.m138h("current_temp_high", sb3.toString());
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.weather_app_widget_provider_no_connection);
        remoteViews.setTextViewText(R.id.widget_weather_layout_no_connection, getString(R.string.fails_to_parse_weather_info));
        Intent intent = new Intent(this, (Class<?>) WeatherActivity.class);
        intent.setPackage(getPackageName());
        remoteViews.setOnClickPendingIntent(R.id.widget_weather_layout_no_connection, PendingIntent.getActivity(this, 0, intent, Utilities.f16748i ? 67108864 : 0));
        AppWidgetManager.getInstance(this).updateAppWidget(new ComponentName(this, (Class<?>) WeatherAppWidgetProvider.class), remoteViews);
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: v */
    public final void mo2138v(DailyResponse dailyResponse) {
    }
}
