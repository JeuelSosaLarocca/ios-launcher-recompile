package com.luutinhit.launcher6;

import G3.ViewOnLayoutChangeListenerC0359o;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Parcelable;
import com.luutinhit.launcherios.R;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.q3 */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPreviewLoadTask extends AsyncTask {

    /* JADX INFO: renamed from: a */
    public WidgetCacheKey f16831a;

    /* JADX INFO: renamed from: b */
    public Parcelable f16832b;

    /* JADX INFO: renamed from: c */
    public int f16833c;

    /* JADX INFO: renamed from: d */
    public int f16834d;

    /* JADX INFO: renamed from: e */
    public ViewOnLayoutChangeListenerC0359o f16835e;

    /* JADX INFO: renamed from: f */
    public long[] f16836f;

    /* JADX INFO: renamed from: g */
    public /* synthetic */ WidgetPreviewLoader f16837g;

    public WidgetPreviewLoadTask(WidgetPreviewLoader widgetPreviewLoader, WidgetCacheKey widgetCacheKey, Parcelable parcelable, int i6, int i7, ViewOnLayoutChangeListenerC0359o viewOnLayoutChangeListenerC0359o) {
        this.f16837g = widgetPreviewLoader;
        this.f16831a = widgetCacheKey;
        this.f16832b = parcelable;
        this.f16833c = i7;
        this.f16834d = i6;
        this.f16835e = viewOnLayoutChangeListenerC0359o;
        String.format("%s, %s, %d, %d", widgetCacheKey, parcelable, Integer.valueOf(i7), Integer.valueOf(i6));
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:70:0x01b4 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr){
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Bitmap bitmapCreateBitmap;
        Cursor cursorM120h;
        Bitmap bitmapDecodeByteArray;
        Cursor cursor = null;
        if (isCancelled()) {
            return null;
        }
        synchronized (this.f16837g.f16862b) {
            try {
                Iterator it = this.f16837g.f16862b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bitmapCreateBitmap = null;
                        break;
                    }
                    bitmapCreateBitmap = (Bitmap) it.next();
                    if (bitmapCreateBitmap != null && bitmapCreateBitmap.isMutable() && bitmapCreateBitmap.getWidth() == this.f16834d && bitmapCreateBitmap.getHeight() == this.f16833c) {
                        this.f16837g.f16862b.remove(bitmapCreateBitmap);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(this.f16834d, this.f16833c, Bitmap.Config.ARGB_8888);
        }
        Bitmap bitmapCreateBitmap2 = bitmapCreateBitmap;
        if (isCancelled()) {
            return bitmapCreateBitmap2;
        }
        WidgetPreviewLoader widgetPreviewLoader = this.f16837g;
        WidgetCacheKey widgetCacheKey = this.f16831a;
        widgetPreviewLoader.getClass();
        Objects.toString(widgetCacheKey);
        Objects.toString(bitmapCreateBitmap2);
        Objects.toString(this);
        try {
            cursorM120h = widgetPreviewLoader.f16867g.m120h("componentName = ? AND profileId = ? AND size = ?", new String[]{"preview_bitmap"}, new String[]{widgetCacheKey.f149a.flattenToString(), Long.toString(widgetPreviewLoader.f16865e.mo9676f(widgetCacheKey.f150b)), widgetCacheKey.f16849d});
            try {
                try {
                    if (isCancelled()) {
                        if (cursorM120h != null) {
                        }
                        bitmapDecodeByteArray = null;
                        if (!isCancelled() || bitmapDecodeByteArray != null) {
                            return bitmapDecodeByteArray;
                        }
                        this.f16836f = this.f16837g.m8185b(this.f16831a.f149a.getPackageName());
                        Launcher launcher = (Launcher) this.f16835e.getContext();
                        WidgetPreviewLoader widgetPreviewLoader2 = this.f16837g;
                        Parcelable parcelable = this.f16832b;
                        int i6 = this.f16834d;
                        int i7 = this.f16833c;
                        widgetPreviewLoader2.getClass();
                        Objects.toString(launcher);
                        Objects.toString(parcelable);
                        Objects.toString(bitmapCreateBitmap2);
                        if (parcelable instanceof LauncherAppWidgetProviderInfo) {
                            return widgetPreviewLoader2.generateWidgetPreview(launcher, (LauncherAppWidgetProviderInfo) parcelable, i6, bitmapCreateBitmap2, null);
                        }
                        ResolveInfo resolveInfo = (ResolveInfo) parcelable;
                        Objects.toString(launcher);
                        Objects.toString(resolveInfo);
                        Objects.toString(bitmapCreateBitmap2);
                        Canvas canvas = new Canvas();
                        if (bitmapCreateBitmap2 == null) {
                            bitmapCreateBitmap2 = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
                            canvas.setBitmap(bitmapCreateBitmap2);
                        } else {
                            if (bitmapCreateBitmap2.getWidth() != i6 || bitmapCreateBitmap2.getHeight() != i7) {
                                throw new RuntimeException("Improperly sized bitmap passed as argument");
                            }
                            canvas.setBitmap(bitmapCreateBitmap2);
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        }
                        Drawable drawableMutateOnMainThread = widgetPreviewLoader2.mutateOnMainThread(widgetPreviewLoader2.f16864d.getFullResIcon(resolveInfo.activityInfo));
                        drawableMutateOnMainThread.setFilterBitmap(true);
                        ColorMatrix colorMatrix = new ColorMatrix();
                        colorMatrix.setSaturation(0.0f);
                        drawableMutateOnMainThread.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                        drawableMutateOnMainThread.setAlpha(15);
                        Resources resources = widgetPreviewLoader2.f16863c.getResources();
                        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.shortcut_preview_padding_top);
                        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.shortcut_preview_padding_left);
                        int dimensionPixelOffset3 = (i6 - dimensionPixelOffset2) - resources.getDimensionPixelOffset(R.dimen.shortcut_preview_padding_right);
                        drawableMutateOnMainThread.setBounds(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2 + dimensionPixelOffset3, dimensionPixelOffset3 + dimensionPixelOffset);
                        drawableMutateOnMainThread.draw(canvas);
                        int i8 = launcher.getDeviceProfile().f15978D;
                        drawableMutateOnMainThread.setAlpha(255);
                        drawableMutateOnMainThread.setColorFilter(null);
                        drawableMutateOnMainThread.setBounds(0, 0, i8, i8);
                        drawableMutateOnMainThread.draw(canvas);
                        canvas.setBitmap(null);
                        return bitmapCreateBitmap2;
                    }
                    if (cursorM120h.moveToNext()) {
                        byte[] blob = cursorM120h.getBlob(0);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inBitmap = bitmapCreateBitmap2;
                        try {
                            if (!isCancelled()) {
                                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(blob, 0, blob.length, options);
                                cursorM120h.close();
                            }
                        } catch (Exception unused) {
                        }
                        if (!isCancelled()) {
                            return bitmapDecodeByteArray = null;
                        }
                        return bitmapDecodeByteArray = null;
                    }
                } catch (SQLException unused2) {
                    if (cursorM120h != null) {
                    }
                    bitmapDecodeByteArray = null;
                    if (!isCancelled()) {
                        return bitmapDecodeByteArray;
                    }
                    return bitmapDecodeByteArray;
                }
            } catch (Throwable th2) {
                Throwable th = th2;
                cursor = cursorM120h;
                if (cursor != null) {
                    cursor.close();
                }
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        } catch (SQLException unused3) {
            cursorM120h = null;
        } catch (Throwable th3) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
        }
        cursorM120h.close();
        bitmapDecodeByteArray = null;
        if (!isCancelled()) {
            return bitmapDecodeByteArray;
        }
        return bitmapDecodeByteArray;
    }

    @Override // android.os.AsyncTask
    public final void onCancelled(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.toString(bitmap);
        if (bitmap != null) {
            this.f16837g.f16870j.post(new WidgetPreviewWriteRunnable(this, bitmap, 1));
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        Objects.toString(bitmap);
        ViewOnLayoutChangeListenerC0359o viewOnLayoutChangeListenerC0359o = this.f16835e;
        viewOnLayoutChangeListenerC0359o.getClass();
        Objects.toString(bitmap);
        if (bitmap != null) {
            viewOnLayoutChangeListenerC0359o.f1180m.setBitmap(bitmap);
            viewOnLayoutChangeListenerC0359o.f1180m.setAlpha(0.0f);
            viewOnLayoutChangeListenerC0359o.f1180m.animate().alpha(1.0f).setDuration(90L);
        }
        if (this.f16836f != null) {
            this.f16837g.f16870j.post(new WidgetPreviewWriteRunnable(this, bitmap, 0));
        }
    }
}
