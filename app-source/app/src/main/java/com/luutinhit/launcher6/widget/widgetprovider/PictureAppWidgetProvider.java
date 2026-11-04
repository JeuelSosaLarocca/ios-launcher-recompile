package com.luutinhit.launcher6.widget.widgetprovider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.luutinhit.launcher6.SyntheticHelpers;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.widget.widgetprovider.config.PictureAppWidgetProviderConfigureActivity;
import com.luutinhit.launcherios.R;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class PictureAppWidgetProvider extends AppWidgetProvider {
    /* JADX INFO: renamed from: a */
    public static void m8249a(Context context, AppWidgetManager appWidgetManager, int i6) {
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.picture_app_widget_provider);
            Bitmap bitmapDecodeStream = null;
            String string = C2234v.m8923a(context).getString("appwidget_" + i6, null);
            if (string != null) {
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(new File(URI.create(string))));
                } catch (Throwable th) {
                    th.getMessage();
                }
                if (bitmapDecodeStream == null || bitmapDecodeStream.isRecycled()) {
                    remoteViews.setImageViewResource(R.id.widget_picture_layout, R.drawable.sample_photo_widget);
                } else {
                    int byteCount = bitmapDecodeStream.getByteCount();
                    bitmapDecodeStream.getWidth();
                    bitmapDecodeStream.getHeight();
                    if (byteCount > 1048576) {
                        Bundle appWidgetOptions = appWidgetManager.getAppWidgetOptions(i6);
                        int i7 = appWidgetOptions.getInt("appWidgetMaxWidth", 200);
                        int i8 = appWidgetOptions.getInt("appWidgetMaxHeight", 200);
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        int iApplyDimension = (int) TypedValue.applyDimension(1, i7, displayMetrics);
                        int iApplyDimension2 = (int) TypedValue.applyDimension(1, i8, displayMetrics);
                        float width = bitmapDecodeStream.getWidth();
                        float height = bitmapDecodeStream.getHeight();
                        float fMin = Math.min(iApplyDimension / width, iApplyDimension2 / height);
                        if (fMin >= 1.0f) {
                            fMin = 0.5f;
                        }
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, Math.round(width * fMin), Math.round(height * fMin), true);
                        if (bitmapCreateScaledBitmap != bitmapDecodeStream && !bitmapDecodeStream.isRecycled()) {
                            bitmapDecodeStream.recycle();
                        }
                        bitmapDecodeStream = bitmapCreateScaledBitmap;
                    }
                    remoteViews.setImageViewBitmap(R.id.widget_picture_layout, bitmapDecodeStream);
                }
            } else {
                remoteViews.setImageViewResource(R.id.widget_picture_layout, R.drawable.sample_photo_widget);
            }
            Intent intent = new Intent(context, (Class<?>) PictureAppWidgetProviderConfigureActivity.class);
            intent.putExtra("appWidgetId", i6);
            intent.setAction("android.appwidget.action.APPWIDGET_CONFIGURE" + i6);
            remoteViews.setOnClickPendingIntent(R.id.widget_picture_layout, PendingIntent.getActivity(context, i6, intent, Utilities.f16748i ? 201326592 : 134217728));
            appWidgetManager.updateAppWidget(i6, remoteViews);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDeleted(Context context, int[] iArr) {
        for (int i6 : iArr) {
            String strM7909h = SyntheticHelpers.m7909h(i6, "appwidget_");
            SharedPreferences.Editor editorEdit = C2234v.m8923a(context).edit();
            editorEdit.remove(strM7909h);
            editorEdit.apply();
            new File(new ContextWrapper(context).getDir("image", 0), strM7909h.replace("/", "_") + ".jpg").delete();
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onDisabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onEnabled(Context context) {
    }

    @Override // android.appwidget.AppWidgetProvider
    public final void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i6 : iArr) {
            m8249a(context, appWidgetManager, i6);
        }
    }
}
