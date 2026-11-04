package com.luutinhit.launcher6;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.luutinhit.launcherios.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import p006H.AbstractC0401n;
import p122r3.AbstractC2659c;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.s3 */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPreviewLoader {

    /* JADX INFO: renamed from: c */
    public Context f16863c;

    /* JADX INFO: renamed from: d */
    public IconCache f16864d;

    /* JADX INFO: renamed from: e */
    public C2674r f16865e;

    /* JADX INFO: renamed from: f */
    public AbstractC2659c f16866f;

    /* JADX INFO: renamed from: g */
    public IconDB f16867g;

    /* JADX INFO: renamed from: h */
    public int mProfileBadgeMargin;

    /* JADX INFO: renamed from: a */
    public HashMap mPackageVersions = new HashMap();

    /* JADX INFO: renamed from: b */
    public Set f16862b = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: i */
    public MainThreadExecutor mMainThreadExecutor = new MainThreadExecutor();

    /* JADX INFO: renamed from: j */
    public Handler f16870j = new Handler(LauncherModel.sWorkerThread.getLooper());

    public WidgetPreviewLoader(Context context, IconCache iconCache) {
        this.f16863c = context;
        this.f16864d = iconCache;
        this.f16866f = AbstractC2659c.m9639f(context);
        this.f16865e = C2674r.m9673e(context);
        this.f16867g = new IconDB(context, "widgetpreviews.db", 4, "shortcut_and_widget_previews", 1);
        this.mProfileBadgeMargin = context.getResources().getDimensionPixelSize(R.dimen.profile_badge_margin);
    }

    /* JADX INFO: renamed from: a */
    public final Bitmap generateWidgetPreview(Launcher launcher, LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo, int i6, Bitmap bitmap, int[] iArr) {
        Drawable drawableMo9649k;
        Bitmap bitmap2;
        int width;
        int height;
        int i7;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo2;
        AbstractC2659c abstractC2659c;
        Bitmap bitmapCreateBitmap = bitmap;
        Objects.toString(launcher);
        Objects.toString(launcherAppWidgetProviderInfo);
        Objects.toString(bitmapCreateBitmap);
        int i8 = i6 < 0 ? Integer.MAX_VALUE : i6;
        int i9 = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).previewImage;
        AbstractC2659c abstractC2659c2 = this.f16866f;
        if (i9 != 0) {
            drawableMo9649k = abstractC2659c2.mo9649k(launcherAppWidgetProviderInfo);
            if (drawableMo9649k != null) {
                drawableMo9649k = mutateOnMainThread(drawableMo9649k);
            } else {
                Integer.toHexString(((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).previewImage);
                Objects.toString(((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).provider);
            }
        } else {
            drawableMo9649k = null;
        }
        boolean z5 = drawableMo9649k != null;
        int i10 = launcherAppWidgetProviderInfo.f16574j;
        int i11 = launcherAppWidgetProviderInfo.f16575k;
        Context context = this.f16863c;
        if (z5) {
            width = drawableMo9649k.getIntrinsicWidth();
            height = drawableMo9649k.getIntrinsicHeight();
            bitmap2 = null;
        } else {
            Resources resources = context.getResources();
            Resources.Theme theme = context.getTheme();
            ThreadLocal threadLocal = AbstractC0401n.f1268a;
            Bitmap bitmap3 = ((BitmapDrawable) resources.getDrawable(2131231332, theme)).getBitmap();
            int width2 = bitmap3.getWidth() * i10;
            int height2 = bitmap3.getHeight() * i11;
            bitmap2 = bitmap3;
            width = width2;
            height = height2;
        }
        if (iArr != null) {
            iArr[0] = width;
        }
        int i12 = this.mProfileBadgeMargin;
        float f6 = width > i8 ? (i8 - (i12 * 2)) / width : 1.0f;
        if (f6 != 1.0f) {
            width = (int) (width * f6);
            height = (int) (height * f6);
        }
        if (width <= 0 || height <= 0) {
            Resources resources2 = context.getResources();
            Resources.Theme theme2 = context.getTheme();
            ThreadLocal threadLocal2 = AbstractC0401n.f1268a;
            bitmap2 = ((BitmapDrawable) resources2.getDrawable(2131231332, theme2)).getBitmap();
            width = bitmap2.getWidth() * i10;
            height = bitmap2.getHeight() * i11;
        }
        Canvas canvas = new Canvas();
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            canvas.setBitmap(bitmapCreateBitmap);
            i7 = 0;
        } else {
            canvas.setBitmap(bitmapCreateBitmap);
            i7 = 0;
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        int width3 = (bitmapCreateBitmap.getWidth() - width) / 2;
        if (z5) {
            drawableMo9649k.setBounds(width3, i7, width3 + width, height);
            drawableMo9649k.draw(canvas);
            launcherAppWidgetProviderInfo2 = launcherAppWidgetProviderInfo;
            abstractC2659c = abstractC2659c2;
        } else {
            Paint paint = new Paint();
            paint.setFilterBitmap(true);
            int i13 = launcher.getDeviceProfile().f15978D;
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            float width4 = bitmap2.getWidth() * f6;
            float height3 = bitmap2.getHeight() * f6;
            RectF rectF = new RectF(0.0f, 0.0f, width4, height3);
            float f7 = width3;
            int i14 = 0;
            while (i14 < i10) {
                int i15 = i14;
                float f8 = height3;
                int i16 = 0;
                float f9 = 0.0f;
                while (i16 < i11) {
                    rectF.offsetTo(f7, f9);
                    canvas.drawBitmap(bitmap2, rect, rectF, paint);
                    i16++;
                    f9 += f8;
                }
                i14 = i15 + 1;
                f7 += width4;
                height3 = f8;
            }
            float f10 = height3;
            float f11 = i13;
            float fMin = Math.min(Math.min(width, height) / ((((int) (0.25f * f11)) * 2) + i13), f6);
            try {
                launcherAppWidgetProviderInfo2 = launcherAppWidgetProviderInfo;
                abstractC2659c = abstractC2659c2;
                try {
                    Drawable drawableMo9647i = abstractC2659c.mo9647i(launcherAppWidgetProviderInfo2, this.f16864d);
                    if (drawableMo9647i != null) {
                        Drawable drawableMutateOnMainThread = mutateOnMainThread(drawableMo9647i);
                        float f12 = f11 * fMin;
                        int i17 = ((int) ((width4 - f12) / 2.0f)) + width3;
                        int i18 = (int) ((f10 - f12) / 2.0f);
                        int i19 = (int) f12;
                        drawableMutateOnMainThread.setBounds(i17, i18, i17 + i19, i19 + i18);
                        drawableMutateOnMainThread.draw(canvas);
                    }
                } catch (Resources.NotFoundException unused) {
                }
            } catch (Resources.NotFoundException unused2) {
                launcherAppWidgetProviderInfo2 = launcherAppWidgetProviderInfo;
                abstractC2659c = abstractC2659c2;
            }
            canvas.setBitmap(null);
        }
        return abstractC2659c.mo9644e(launcherAppWidgetProviderInfo2, bitmapCreateBitmap, Math.min(bitmapCreateBitmap.getWidth(), width + i12), Math.min(bitmapCreateBitmap.getHeight(), height + i12));
    }

    /* JADX INFO: renamed from: b */
    public final long[] m8185b(String str) {
        long[] jArr;
        synchronized (this.mPackageVersions) {
            jArr = (long[]) this.mPackageVersions.get(str);
            if (jArr == null) {
                jArr = new long[2];
                try {
                    PackageInfo packageInfo = this.f16863c.getPackageManager().getPackageInfo(str, 0);
                    jArr[0] = packageInfo.versionCode;
                    jArr[1] = packageInfo.lastUpdateTime;
                } catch (PackageManager.NameNotFoundException unused) {
                }
                this.mPackageVersions.put(str, jArr);
            }
        }
        return jArr;
    }

    /* JADX INFO: renamed from: c */
    public final Drawable mutateOnMainThread(Drawable drawable) {
        Objects.toString(drawable);
        try {
            return (Drawable) this.mMainThreadExecutor.submit(new DrawableToBitmapCallable(drawable)).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void removePackage(String str, C2673q c2673q, long j6) {
        Objects.toString(c2673q);
        synchronized (this.mPackageVersions) {
            this.mPackageVersions.remove(str);
        }
        this.f16867g.m113a("packageName = ? AND profileId = ?", new String[]{str, Long.toString(j6)});
    }
}
