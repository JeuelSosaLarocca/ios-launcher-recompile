package com.luutinhit.launcher6;

import G3.RunnableC0358n;
import W4.AbstractC1154e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p081h2.AbstractC2127a;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.n3 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Utilities {

    /* JADX INFO: renamed from: a */
    public static final Rect sOldBounds = new Rect();

    /* JADX INFO: renamed from: b */
    public static final Canvas f16741b;

    /* JADX INFO: renamed from: c */
    public static final Pattern f16742c;

    /* JADX INFO: renamed from: d */
    public static final boolean f16743d;

    /* JADX INFO: renamed from: e */
    public static final boolean f16744e;

    /* JADX INFO: renamed from: f */
    public static final boolean f16745f;

    /* JADX INFO: renamed from: g */
    public static final boolean f16746g;

    /* JADX INFO: renamed from: h */
    public static final boolean f16747h;

    /* JADX INFO: renamed from: i */
    public static final boolean f16748i;

    /* JADX INFO: renamed from: j */
    public static final boolean f16749j;

    /* JADX INFO: renamed from: k */
    public static final boolean f16750k;

    /* JADX INFO: renamed from: l */
    public static final boolean f16751l;

    /* JADX INFO: renamed from: m */
    public static final boolean f16752m;

    /* JADX INFO: renamed from: n */
    public static final boolean f16753n;

    /* JADX INFO: renamed from: o */
    public static final boolean f16754o;

    /* JADX INFO: renamed from: p */
    public static final boolean f16755p;

    /* JADX INFO: renamed from: q */
    public static final ThreadPoolExecutor f16756q;

    static {
        Canvas canvas = new Canvas();
        f16741b = canvas;
        f16742c = Pattern.compile("^[\\s|\\p{javaSpaceChar}]*(.*)[\\s|\\p{javaSpaceChar}]*$");
        canvas.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
        int i6 = Build.VERSION.SDK_INT;
        f16743d = i6 >= 26;
        f16744e = i6 >= 25;
        f16745f = i6 >= 24;
        f16746g = i6 >= 30;
        f16747h = i6 >= 31;
        f16748i = i6 >= 23;
        f16749j = i6 >= 33;
        f16750k = i6 >= 34;
        f16751l = i6 >= 22;
        f16752m = true;
        f16753n = true;
        f16754o = true;
        f16755p = true;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f16756q = new ThreadPoolExecutor(iAvailableProcessors + 1, (iAvailableProcessors * 2) + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    /* JADX INFO: renamed from: A */
    public static void m8147A(int i6, ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroup.getChildAt(i7);
            if (childAt instanceof ViewGroup) {
                m8147A(i6, (ViewGroup) childAt);
            } else if ((childAt instanceof TextViewCustomFont) && childAt.getId() != R.id.action_back) {
                ((TextViewCustomFont) childAt).setTextColor(i6);
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public static String trim(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return f16742c.matcher(charSequence).replaceAll("$1");
    }

    /* JADX INFO: renamed from: a */
    public static Bitmap m8149a(Bitmap bitmap, float f6) {
        Objects.toString(bitmap);
        if (bitmap == null) {
            return null;
        }
        try {
            try {
                return Toolkit.f15289a.m7540a((int) 6.0f, Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f6), Math.round(bitmap.getHeight() * f6), false));
            } catch (Throwable unused) {
                return AbstractC2127a.m8802r((int) 6.0f, Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f6), Math.round(f6 * bitmap.getHeight()), true));
            }
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static Bitmap m8150b(Drawable drawable, C2673q c2673q, Context context) {
        Bitmap bitmapCreateIconBitmap = createIconBitmap(drawable, context);
        if (!f16752m || c2673q == null || C2673q.m9672b().equals(c2673q)) {
            return bitmapCreateIconBitmap;
        }
        Drawable userBadgedIcon = context.getPackageManager().getUserBadgedIcon(new SquareBitmapDrawable(null, bitmapCreateIconBitmap), c2673q.f20687a);
        return userBadgedIcon instanceof BitmapDrawable ? ((BitmapDrawable) userBadgedIcon).getBitmap() : createIconBitmap(userBadgedIcon, context);
    }

    /* JADX INFO: renamed from: c */
    public static Bitmap m8151c(ViewGroup viewGroup) {
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                Bitmap[] bitmapArr = {null};
                new Handler(Looper.getMainLooper()).post(new RunnableC0358n(bitmapArr, viewGroup, countDownLatch, 7));
                try {
                    countDownLatch.await();
                    Objects.toString(bitmapArr[0]);
                    return bitmapArr[0];
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            } else if (viewGroup.getWindowToken() != null && viewGroup.getVisibility() == 0) {
                int width = viewGroup.getWidth();
                int height = viewGroup.getHeight();
                if (width > 0 && height > 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Drawable background = viewGroup.getBackground();
                    if (background != null) {
                        background.setBounds(0, 0, width, height);
                        background.draw(canvas);
                    }
                    viewGroup.draw(canvas);
                    return bitmapCreateBitmap;
                }
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static String createDbSelectionQuery(String str, AbstractCollection abstractCollection) {
        Locale locale = Locale.ENGLISH;
        return str + " IN (" + TextUtils.join(", ", abstractCollection) + ")";
    }

    /* JADX INFO: renamed from: e */
    public static Bitmap createIconBitmap(Context context, Bitmap bitmap) {
        int i6 = LauncherAppState.getInstance().f16222e.f16716h;
        return (i6 == bitmap.getWidth() && i6 == bitmap.getHeight()) ? bitmap : createIconBitmap(new BitmapDrawable(context.getResources(), bitmap), context);
    }

    /* JADX INFO: renamed from: f */
    public static Bitmap createIconBitmap(Context context, String str, String str2) {
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            if (resourcesForApplication != null) {
                return createIconBitmap(resourcesForApplication.getDrawableForDensity(resourcesForApplication.getIdentifier(str2, null, null), LauncherAppState.getInstance().f16222e.f16717i), context);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public static Bitmap createIconBitmap(Cursor cursor, int i6, Context context) {
        byte[] blob = cursor.getBlob(i6);
        try {
            return createIconBitmap(context, BitmapFactory.decodeByteArray(blob, 0, blob.length));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0059  */
    /* JADX INFO: renamed from: h */
    public static Bitmap createIconBitmap(Drawable drawable, Context context) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        int i6;
        int i7;
        Bitmap bitmapCreateBitmap;
        Canvas canvas = f16741b;
        synchronized (canvas) {
            try {
                int i8 = LauncherAppState.getInstance().f16222e.f16716h;
                if (drawable instanceof PaintDrawable) {
                    PaintDrawable paintDrawable = (PaintDrawable) drawable;
                    paintDrawable.setIntrinsicWidth(i8);
                    paintDrawable.setIntrinsicHeight(i8);
                } else if ((drawable instanceof BitmapDrawable) && (bitmap = (bitmapDrawable = (BitmapDrawable) drawable).getBitmap()) != null && bitmap.getDensity() == 0) {
                    bitmapDrawable.setTargetDensity(context.getResources().getDisplayMetrics());
                }
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    i6 = i8;
                    i7 = i6;
                } else {
                    float f6 = intrinsicWidth / intrinsicHeight;
                    if (intrinsicWidth > intrinsicHeight) {
                        i7 = (int) (i8 / f6);
                        i6 = i8;
                    } else if (intrinsicHeight > intrinsicWidth) {
                        i6 = (int) (i8 * f6);
                        i7 = i8;
                    } else {
                        i6 = i8;
                        i7 = i6;
                    }
                }
                bitmapCreateBitmap = Bitmap.createBitmap(i8, i8, Bitmap.Config.ARGB_8888);
                canvas.setBitmap(bitmapCreateBitmap);
                int i9 = (i8 - i6) / 2;
                int i10 = (i8 - i7) / 2;
                Rect rect = sOldBounds;
                rect.set(drawable.getBounds());
                drawable.setBounds(i9, i10, i6 + i9, i7 + i10);
                canvas.save();
                float f7 = i8 / 2.0f;
                canvas.scale(1.0f, 1.0f, f7, f7);
                drawable.draw(canvas);
                canvas.restore();
                drawable.setBounds(rect);
                canvas.setBitmap(null);
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: i */
    public static Bitmap m8157i(Context context, int i6, int i7, int i8, float f6) {
        Bitmap bitmapDecodeResource;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i6);
        } catch (Throwable unused) {
            bitmapDecodeResource = null;
        }
        try {
            try {
                return m8158j(bitmapDecodeResource, i7, i8, f6);
            } catch (Throwable unused2) {
                return BitmapFactory.decodeResource(context.getResources(), i6);
            }
        } catch (Throwable unused3) {
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public static Bitmap m8158j(Bitmap bitmap, int i6, int i7, float f6) {
        try {
            if (i6 < bitmap.getWidth() || i7 < bitmap.getHeight()) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i6, i7, true);
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Rect rect = new Rect(0, 0, i6, i7);
            RectF rectF = new RectF(rect);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, f6, f6, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return bitmap;
        }
    }

    /* JADX INFO: renamed from: k */
    public static Bitmap m8159k(Drawable drawable) {
        Objects.toString(drawable);
        try {
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() != null) {
                    return bitmapDrawable.getBitmap();
                }
            }
            Bitmap bitmapCreateBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX INFO: renamed from: l */
    public static int findDominantColorByHue(Bitmap bitmap) {
        char c6;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int iSqrt = (int) Math.sqrt((height * width) / 20);
        if (iSqrt < 1) {
            iSqrt = 1;
        }
        float[] fArr = new float[3];
        float[] fArr2 = new float[360];
        char c7 = 0;
        int i6 = -1;
        int i7 = 0;
        float f6 = -1.0f;
        while (true) {
            c6 = 2;
            if (i7 >= height) {
                break;
            }
            for (int i8 = 0; i8 < width; i8 += iSqrt) {
                int pixel = bitmap.getPixel(i8, i7);
                if (((pixel >> 24) & 255) >= 128) {
                    Color.colorToHSV(pixel | (-16777216), fArr);
                    int i9 = (int) fArr[0];
                    if (i9 >= 0 && i9 < 360) {
                        float f7 = fArr2[i9] + (fArr[1] * fArr[2]);
                        fArr2[i9] = f7;
                        if (f7 > f6) {
                            i6 = i9;
                            f6 = f7;
                        }
                    }
                }
            }
            i7 += iSqrt;
        }
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        int i11 = -16777216;
        float f8 = -1.0f;
        while (i10 < height) {
            int i12 = 0;
            while (i12 < width) {
                int pixel2 = bitmap.getPixel(i12, i10) | (-16777216);
                Color.colorToHSV(pixel2, fArr);
                if (((int) fArr[c7]) == i6) {
                    float f9 = fArr[1];
                    float f10 = fArr[c6];
                    int i13 = ((int) (f9 * 100.0f)) + ((int) (f10 * 10000.0f));
                    float fFloatValue = f9 * f10;
                    Float f11 = (Float) sparseArray.get(i13);
                    if (f11 != null) {
                        fFloatValue += f11.floatValue();
                    }
                    sparseArray.put(i13, Float.valueOf(fFloatValue));
                    if (fFloatValue > f8) {
                        i11 = pixel2;
                        f8 = fFloatValue;
                    }
                }
                i12 += iSqrt;
                c7 = 0;
                c6 = 2;
            }
            i10 += iSqrt;
            c7 = 0;
            c6 = 2;
        }
        return i11;
    }

    /* JADX INFO: renamed from: m */
    public static Pair findSystemApk(PackageManager packageManager, String str) {
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(new Intent(str), 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (activityInfo.applicationInfo.flags & 1) != 0) {
                String str2 = activityInfo.packageName;
                try {
                    return Pair.create(str2, packageManager.getResourcesForApplication(str2));
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    public static byte[] flattenBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getHeight() * bitmap.getWidth() * 4);
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: o */
    public static String m8163o(String str) {
        if (TextUtils.isEmpty(str) || !str.equals("com.luutinhit.launcherios")) {
            return null;
        }
        return "c2b4356399bad096b3c343b9b5f99a42";
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004a  */
    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0062  */
    /* JADX WARN: Code duplicated, block: B:23:0x0093  */
    /* JADX WARN: Code duplicated, block: B:39:0x00dd A[EDGE_INSN: B:39:0x00dd->B:40:0x00de BREAK  A[LOOP:0: B:20:0x0060->B:38:0x00da]] */
    /* JADX WARN: Code duplicated, block: B:46:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00da A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX INFO: renamed from: p */
    public static Bitmap m8164p(Context context, Bitmap bitmap) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i6;
        int dimensionPixelSize;
        int iMin;
        int i7;
        int i8;
        int i9;
        int iSqrt;
        Objects.toString(bitmap);
        Objects.toString(bitmap);
        scan: {
        if (bitmap == null) {
            i6 = -1;
            break scan;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            if (!m8167s(bitmap.getPixel(0, 0))) {
                dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
                iMin = Math.min(dimensionPixelSize, width / 9);
                i7 = iMin / 6;
                if (i7 < 1) {
                    i7 = 1;
                }
                i8 = width - 1;
                i9 = height - 1;
                i6 = 0;
                while (true) {
                    if (i6 > iMin) {
                        i6 = -1;
                        break;
                    }
                    iSqrt = (int) ((((double) i6) / Math.sqrt(2.0d)) + (((Math.sqrt(2.0d) - 1.0d) / Math.sqrt(2.0d)) * ((double) dimensionPixelSize)));
                    int i10 = i8 / 2;
                    int i11 = i8 - iSqrt;
                    int i12 = i8 - i6;
                    int i13 = i9 / 2;
                    int i14 = i9 - iSqrt;
                    int i15 = i9 - i6;
                    if (!m8167s(bitmap.getPixel(iSqrt, iSqrt))) {
                    }
                    i6 += i7;
                }
            } else {
                int i16 = width - 1;
                if (!m8167s(bitmap.getPixel(i16, 0))) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
                    iMin = Math.min(dimensionPixelSize, width / 9);
                    i7 = iMin / 6;
                    if (i7 < 1) {
                        i7 = 1;
                    }
                    i8 = width - 1;
                    i9 = height - 1;
                    i6 = 0;
                    while (true) {
                        if (i6 > iMin) {
                            i6 = -1;
                            break;
                        }
                        iSqrt = (int) ((((double) i6) / Math.sqrt(2.0d)) + (((Math.sqrt(2.0d) - 1.0d) / Math.sqrt(2.0d)) * ((double) dimensionPixelSize)));
                        int i17 = i8 / 2;
                        int i18 = i8 - iSqrt;
                        int i19 = i8 - i6;
                        int i110 = i9 / 2;
                        int i111 = i9 - iSqrt;
                        int i112 = i9 - i6;
                        if (!m8167s(bitmap.getPixel(iSqrt, iSqrt))) {
                        }
                        i6 += i7;
                    }
                } else {
                    int i20 = height - 1;
                    if (!m8167s(bitmap.getPixel(i16, i20)) || !m8167s(bitmap.getPixel(0, i20))) {
                        dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
                        iMin = Math.min(dimensionPixelSize, width / 9);
                        i7 = iMin / 6;
                        if (i7 < 1) {
                            i7 = 1;
                        }
                        i8 = width - 1;
                        i9 = height - 1;
                        i6 = 0;
                        while (true) {
                            if (i6 > iMin) {
                                i6 = -1;
                                break;
                            }
                            iSqrt = (int) ((((double) i6) / Math.sqrt(2.0d)) + (((Math.sqrt(2.0d) - 1.0d) / Math.sqrt(2.0d)) * ((double) dimensionPixelSize)));
                            int i113 = i8 / 2;
                            int i114 = i8 - iSqrt;
                            int i115 = i8 - i6;
                            int i116 = i9 / 2;
                            int i117 = i9 - iSqrt;
                            int i118 = i9 - i6;
                            if (!m8167s(bitmap.getPixel(iSqrt, iSqrt)) && m8167s(bitmap.getPixel(i113, i6)) && m8167s(bitmap.getPixel(i114, iSqrt)) && m8167s(bitmap.getPixel(i115, i116)) && m8167s(bitmap.getPixel(i114, i117)) && m8167s(bitmap.getPixel(i113, i118)) && m8167s(bitmap.getPixel(iSqrt, i117)) && m8167s(bitmap.getPixel(i6, i116))) {
                                break;
                            }
                            i6 += i7;
                        }
                    } else {
                        i6 = 0;
                    }
                }
            }
        } else {
            i6 = -1;
            break scan;
        }
        }
        if (i6 < 0) {
            Objects.toString(bitmap);
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            context.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
            float f6 = width2;
            float f7 = height2;
            new RectF(0.0f, 0.0f, f6, f7);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            AbstractC1154e.m2413c(canvas, f6, f7, paint);
            canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, (width2 * 4) / 5, (height2 * 4) / 5, true), f6 / 10.0f, f7 / 10.0f, new Paint(2));
            return Bitmap.createScaledBitmap(bitmapCreateBitmap, width2, height2, true);
        }
        Objects.toString(bitmap);
        int width3 = bitmap.getWidth();
        int height3 = bitmap.getHeight();
        int i21 = i6 * 2;
        int i22 = width3 - i21;
        int i23 = height3 - i21;
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, i6, i6, i22, i23);
        context.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(i22, i23, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap3);
        Rect rect = new Rect(0, 0, i22, i23);
        RectF rectF = new RectF(rect);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.FILL);
        canvas2.drawARGB(0, 0, 0, 0);
        AbstractC1154e.m2413c(canvas2, rectF.width(), rectF.height(), paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas2.drawBitmap(bitmapCreateBitmap2, rect, rect, paint2);
        return Bitmap.createScaledBitmap(bitmapCreateBitmap3, width3, height3, true);
    }

    /* JADX INFO: renamed from: q */
    public static SharedPreferences m8165q(Context context) {
        return context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0);
    }

    /* JADX INFO: renamed from: r */
    public static boolean isRotationAllowedForDevice(Context context) {
        boolean z5 = false;
        if (f16745f) {
            int i6 = DisplayMetrics.DENSITY_DEVICE_STABLE;
            Resources resources = context.getResources();
            if ((resources.getConfiguration().smallestScreenWidthDp * resources.getDisplayMetrics().densityDpi) / i6 >= 600) {
                z5 = true;
            }
        }
        return m8165q(context).getBoolean("pref_allowRotation", z5);
    }

    /* JADX INFO: renamed from: s */
    public static boolean m8167s(int i6) {
        Color.alpha(i6);
        return ((-16777216) & i6) != 0 && Color.alpha(i6) > 200;
    }

    /* JADX INFO: renamed from: t */
    public static boolean m8168t() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("huawei");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: u */
    public static boolean isLauncherAppTarget(Intent intent) {
        if (intent != null && "android.intent.action.MAIN".equals(intent.getAction()) && intent.getComponent() != null && intent.getCategories() != null && intent.getCategories().size() == 1 && intent.hasCategory("android.intent.category.LAUNCHER") && TextUtils.isEmpty(intent.getDataString())) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                return true;
            }
            Set<String> setKeySet = extras.keySet();
            if (setKeySet.size() == 1 && setKeySet.contains("profile")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: v */
    public static boolean isRtl(Resources resources) {
        return f16754o && resources.getConfiguration().getLayoutDirection() == 1;
    }

    /* JADX INFO: renamed from: w */
    public static boolean isSystemApp(Context context, Intent intent) {
        String packageName;
        ApplicationInfo applicationInfo;
        ActivityInfo activityInfo;
        PackageManager packageManager = context.getPackageManager();
        ComponentName component = intent.getComponent();
        if (component == null) {
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            packageName = (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName;
        } else {
            packageName = component.getPackageName();
        }
        if (packageName != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (applicationInfo.flags & 1) != 0) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: x */
    public static boolean m8172x() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("vivo");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: y */
    public static boolean pointInView(ViewGroup viewGroup, float f6, float f7, float f8) {
        float f9 = -f8;
        return f6 >= f9 && f7 >= f9 && f6 < ((float) viewGroup.getWidth()) + f8 && f7 < ((float) viewGroup.getHeight()) + f8;
    }

    /* JADX INFO: renamed from: z */
    public static void m8174z(Context context) {
        new Handler(LauncherModel.sWorkerThread.getLooper()).postDelayed(new MergedIdleRunnable(10, context), 250L);
    }
}
