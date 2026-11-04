package com.luutinhit.launcher6.widget.widgetprovider;

import L3.C0639a;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;
import java.util.Calendar;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWidgetProvider extends AppWidgetProvider {

    /* JADX INFO: renamed from: h */
    public static int f17209h = -1;

    /* JADX INFO: renamed from: a */
    public Context f17210a;

    /* JADX INFO: renamed from: b */
    public Paint f17211b;

    /* JADX INFO: renamed from: c */
    public Paint f17212c;

    /* JADX INFO: renamed from: d */
    public RectF f17213d = new RectF();

    /* JADX INFO: renamed from: e */
    public float f17214e;

    /* JADX INFO: renamed from: f */
    public int f17215f;

    /* JADX INFO: renamed from: g */
    public Drawable f17216g;

    /* JADX INFO: renamed from: a */
    public static void m8247a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (C0639a.f1948m == null) {
            C0639a.f1948m = new C0639a(applicationContext);
        }
        C0639a c0639a = C0639a.f1948m;
        c0639a.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, 60000);
        ((AlarmManager) c0639a.f1950k.getSystemService("alarm")).setRepeating(1, calendar.getTimeInMillis(), 60000L, C0639a.f1947l);
    }

    /* JADX INFO: renamed from: b */
    public final void m8248b(Context context, boolean z5) {
        Intent intentRegisterReceiver = Utilities.f16749j ? context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 2) : context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver.getIntExtra("level", 0);
        int intExtra2 = intentRegisterReceiver.getIntExtra("scale", 1);
        if (intExtra2 <= 0) {
            intExtra2 = 100;
        }
        int i6 = (intExtra * 100) / intExtra2;
        if (z5 || i6 != f17209h) {
            this.f17210a = context;
            Paint paint = new Paint(1);
            this.f17211b = paint;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            this.f17211b.setStrokeWidth(5.0f);
            Paint paint2 = this.f17211b;
            Paint.Cap cap = Paint.Cap.ROUND;
            paint2.setStrokeCap(cap);
            this.f17211b.setColor(-16711936);
            Paint paint3 = new Paint(1);
            this.f17212c = paint3;
            paint3.setStyle(style);
            this.f17212c.setStrokeWidth(6.0f);
            this.f17212c.setStrokeCap(cap);
            this.f17212c.setColor(-2130706433);
            this.f17215f = this.f17210a.getResources().getDimensionPixelSize(R.dimen.battery_widget_progress_size);
            this.f17214e = this.f17210a.getResources().getDimensionPixelSize(R.dimen.battery_widget_progress_stroke) * 1.1f;
            this.f17216g = this.f17210a.getDrawable(R.drawable.ic_phone);
            f17209h = i6;
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.battery_widget_provider);
            int i7 = this.f17215f;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i7, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            RectF rectF = this.f17213d;
            float f6 = this.f17214e;
            float f7 = this.f17215f - f6;
            rectF.set(f6, f6, f7, f7);
            this.f17212c.setStrokeWidth(this.f17214e);
            this.f17211b.setColor(i6 < 10 ? -65536 : -16711936);
            this.f17211b.setStrokeWidth(this.f17214e);
            canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f17212c);
            canvas.drawArc(rectF, 270.0f, i6 * 3.6f, false, this.f17211b);
            int i8 = (int) (((double) this.f17214e) * 3.2d);
            Drawable drawable = this.f17216g;
            int i9 = this.f17215f - i8;
            drawable.setBounds(i8, i8, i9, i9);
            this.f17216g.draw(canvas);
            remoteViews.setImageViewBitmap(R.id.widget_battery_progress, bitmapCreateBitmap);
            remoteViews.setTextViewText(R.id.widget_battery_text, i6 + "%");
            Intent intent = new Intent("android.intent.action.POWER_USAGE_SUMMARY");
            intent.setPackage(this.f17210a.getPackageName());
            remoteViews.setOnClickPendingIntent(R.id.widget_battery_layout, PendingIntent.getActivity(context, 0, intent, Utilities.f16748i ? 201326592 : 134217728));
            AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, (Class<?>) BatteryWidgetProvider.class), remoteViews);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
        if (AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context.getPackageName(), getClass().getName())).length == 0) {
            Context applicationContext = context.getApplicationContext();
            if (C0639a.f1948m == null) {
                C0639a.f1948m = new C0639a(applicationContext);
            }
            ((AlarmManager) C0639a.f1948m.f1950k.getSystemService("alarm")).cancel(C0639a.f1947l);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
        m8247a(context);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Objects.toString(intent);
        if (intent == null || intent.getAction() == null || !"com.luutinhit.ACTION_UPDATE_BATTERY_WIDGET".equals(intent.getAction())) {
            super.onReceive(context, intent);
        } else {
            m8248b(context, false);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        m8247a(context);
        m8248b(context, true);
    }
}
