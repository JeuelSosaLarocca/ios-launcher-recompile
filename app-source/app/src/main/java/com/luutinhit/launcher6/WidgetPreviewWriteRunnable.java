package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.graphics.Bitmap;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.p3 */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPreviewWriteRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16820j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Bitmap f16821k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ WidgetPreviewLoadTask f16822l;

    public /* synthetic */ WidgetPreviewWriteRunnable(WidgetPreviewLoadTask widgetPreviewLoadTask, Bitmap bitmap, int i6) {
        this.f16820j = i6;
        this.f16822l = widgetPreviewLoadTask;
        this.f16821k = bitmap;
    }

    /* JADX INFO: renamed from: a */
    public final void m8182a() {
        if (this.f16822l.isCancelled()) {
            synchronized (this.f16822l.f16837g.f16862b) {
                this.f16822l.f16837g.f16862b.add(this.f16821k);
            }
            return;
        }
        WidgetPreviewLoadTask widgetPreviewLoadTask = this.f16822l;
        WidgetPreviewLoader widgetPreviewLoader = widgetPreviewLoadTask.f16837g;
        WidgetCacheKey widgetCacheKey = widgetPreviewLoadTask.f16831a;
        long[] jArr = widgetPreviewLoadTask.f16836f;
        Bitmap bitmap = this.f16821k;
        widgetPreviewLoader.getClass();
        Objects.toString(widgetCacheKey);
        Objects.toString(bitmap);
        ContentValues contentValues = new ContentValues();
        contentValues.put("componentName", widgetCacheKey.f149a.flattenToShortString());
        contentValues.put("profileId", Long.valueOf(widgetPreviewLoader.f16865e.mo9676f(widgetCacheKey.f150b)));
        contentValues.put("size", widgetCacheKey.f16849d);
        contentValues.put("packageName", widgetCacheKey.f149a.getPackageName());
        contentValues.put("version", Long.valueOf(jArr[0]));
        contentValues.put("lastUpdated", Long.valueOf(jArr[1]));
        contentValues.put("preview_bitmap", Utilities.flattenBitmap(bitmap));
        widgetPreviewLoader.f16867g.m117e(contentValues);
        this.f16822l.getClass();
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16820j) {
            case 0:
                m8182a();
                return;
            default:
                synchronized (this.f16822l.f16837g.f16862b) {
                    this.f16822l.f16837g.f16862b.add(this.f16821k);
                    break;
                }

        }
    }
}
