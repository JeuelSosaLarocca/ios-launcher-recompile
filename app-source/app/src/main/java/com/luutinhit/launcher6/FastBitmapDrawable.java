package com.luutinhit.launcher6;

import B3.C0056Y;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.annotation.Keep;
import com.luutinhit.launcherios.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class FastBitmapDrawable extends Drawable {

    /* JADX INFO: renamed from: o */
    public static final ZInterpolator f15571o = new ZInterpolator(0);

    /* JADX INFO: renamed from: p */
    public static final SparseArray sCachedBrightnessFilter = new SparseArray();

    /* JADX INFO: renamed from: q */
    public static final ColorMatrix f15573q = new ColorMatrix();

    /* JADX INFO: renamed from: r */
    public static final ColorMatrix f15574r = new ColorMatrix();

    /* JADX INFO: renamed from: a */
    public Paint f15575a;

    /* JADX INFO: renamed from: b */
    public Bitmap f15576b;

    /* JADX INFO: renamed from: c */
    public FastBitmapDrawableState f15577c;

    /* JADX INFO: renamed from: d */
    public int f15578d;

    /* JADX INFO: renamed from: e */
    public int f15579e;

    /* JADX INFO: renamed from: f */
    public int mAlpha;

    /* JADX INFO: renamed from: g */
    public int f15581g;

    /* JADX INFO: renamed from: h */
    public AnimatorSet f15582h;

    /* JADX INFO: renamed from: i */
    public float f15583i;

    /* JADX INFO: renamed from: j */
    public int f15584j;

    /* JADX INFO: renamed from: k */
    public RectF f15585k;

    /* JADX INFO: renamed from: l */
    public boolean f15586l;

    /* JADX INFO: renamed from: m */
    public Paint f15587m;

    /* JADX INFO: renamed from: n */
    public ColorMatrixColorFilter f15588n;

    public FastBitmapDrawable(Launcher launcher, Bitmap bitmap) {
        this.f15575a = new Paint(2);
        this.f15577c = FastBitmapDrawableState.NORMAL;
        this.f15578d = 0;
        this.f15579e = 0;
        this.mAlpha = 255;
        this.f15581g = Integer.MAX_VALUE;
        this.f15586l = false;
        this.f15587m = new Paint();
        this.f15576b = bitmap;
        setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        m7683e(launcher);
    }

    /* JADX INFO: renamed from: b */
    public static ColorMatrixColorFilter m7679b(int i6, Bitmap bitmap) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        if (bitmap != null && m7681d(bitmap) >= 0.6f) {
            colorMatrix.postConcat(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        }
        colorMatrix.postConcat(new ColorMatrix(new float[]{2.0f, 0.0f, 0.0f, 0.0f, -255.0f, 0.0f, 2.0f, 0.0f, 0.0f, -255.0f, 0.0f, 0.0f, 2.0f, 0.0f, -255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        colorMatrix.postConcat(new ColorMatrix(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(i6), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(i6), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(i6), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
        return new ColorMatrixColorFilter(colorMatrix);
    }

    /* JADX INFO: renamed from: c */
    public static int m7680c(FastBitmapDrawableState fastBitmapDrawableState, FastBitmapDrawableState fastBitmapDrawableState2) {
        int iOrdinal = fastBitmapDrawableState2.ordinal();
        if (iOrdinal == 0) {
            int iOrdinal2 = fastBitmapDrawableState.ordinal();
            if (iOrdinal2 != 1) {
                return (iOrdinal2 == 2 || iOrdinal2 == 3) ? 275 : 368;
            }
            return 0;
        }
        if (iOrdinal == 1) {
            return 368;
        }
        if (iOrdinal == 2) {
            return 225;
        }
        if (iOrdinal != 3) {
            return 0;
        }
        Objects.requireNonNull(fastBitmapDrawableState);
        return fastBitmapDrawableState == FastBitmapDrawableState.NORMAL ? 225 : 150;
    }

    /* JADX INFO: renamed from: d */
    public static float m7681d(Bitmap bitmap) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), bitmapCreateScaledBitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
        int width = bitmapCreateBitmap.getWidth();
        int height = bitmapCreateBitmap.getHeight();
        int i6 = width * height;
        int[] iArr = new int[i6];
        bitmapCreateBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            if (iArr[i8] == -1) {
                i7++;
            }
        }
        float f6 = i7 / i6;
        float f7 = 2;
        return f6 * f7 * f7;
    }

    /* JADX INFO: renamed from: a */
    public final boolean setState(FastBitmapDrawableState fastBitmapDrawableState) {
        FastBitmapDrawableState fastBitmapDrawableState2 = this.f15577c;
        int i6 = 0;
        if (fastBitmapDrawableState2 == fastBitmapDrawableState) {
            return false;
        }
        this.f15577c = fastBitmapDrawableState;
        AnimatorSet animatorSet = this.f15582h;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.f15582h = null;
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f15582h = animatorSet2;
        animatorSet2.playTogether(ObjectAnimator.ofFloat(this, "desaturation", fastBitmapDrawableState.f16632j), ObjectAnimator.ofFloat(this, "brightness", fastBitmapDrawableState.f16633k));
        this.f15582h.setInterpolator(fastBitmapDrawableState.f16634l);
        this.f15582h.setDuration(m7680c(fastBitmapDrawableState2, fastBitmapDrawableState));
        AnimatorSet animatorSet3 = this.f15582h;
        if (fastBitmapDrawableState == FastBitmapDrawableState.FAST_SCROLL_UNHIGHLIGHTED) {
            Objects.requireNonNull(fastBitmapDrawableState2);
            if (fastBitmapDrawableState2 == FastBitmapDrawableState.NORMAL) {
                i6 = 37;
            }
        }
        animatorSet3.setStartDelay(i6);
        this.f15582h.start();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z5 = this.f15586l;
        Paint paint = this.f15575a;
        Bitmap bitmap = this.f15576b;
        if (!z5) {
            canvas.drawBitmap(bitmap, (Rect) null, getBounds(), paint);
            return;
        }
        RectF rectF = this.f15585k;
        Paint paint2 = this.f15587m;
        float f6 = this.f15583i;
        canvas.drawRoundRect(rectF, f6, f6, paint2);
        int i6 = this.f15584j;
        canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, (i6 * 4) / 5, (i6 * 4) / 5, true), i6 / 10.0f, i6 / 10.0f, paint);
    }

    /* JADX INFO: renamed from: e */
    public final void m7683e(Launcher launcher) {
        C0056Y tinyDB = launcher.getTinyDB();
        int i6 = tinyDB.f137a.getInt("color_icon_style", 1);
        if (i6 == 2) {
            m7685g(tinyDB.f137a.getInt("color_tinted_app", -1));
        } else if (i6 == 0) {
            m7685g(0);
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m7684f(FastBitmapDrawableState fastBitmapDrawableState) {
        if (this.f15577c == fastBitmapDrawableState) {
            return false;
        }
        this.f15577c = fastBitmapDrawableState;
        AnimatorSet animatorSet = this.f15582h;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.f15582h = null;
        setDesaturation(fastBitmapDrawableState.f16632j);
        setBrightness(fastBitmapDrawableState.f16633k);
        return true;
    }

    /* JADX INFO: renamed from: g */
    public final void m7685g(int i6) {
        Paint paint = this.f15575a;
        try {
            if (i6 == -1) {
                this.f15588n = null;
                paint.setColorFilter(null);
            } else {
                Bitmap bitmap = this.f15576b;
                if (i6 == 0) {
                    ColorMatrix colorMatrix = new ColorMatrix();
                    colorMatrix.setSaturation(0.0f);
                    if (bitmap != null && m7681d(bitmap) >= 0.5f) {
                        colorMatrix.postConcat(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
                    }
                    ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
                    this.f15588n = colorMatrixColorFilter;
                    paint.setColorFilter(colorMatrixColorFilter);
                } else {
                    ColorMatrixColorFilter colorMatrixColorFilterM7679b = m7679b(i6, bitmap);
                    this.f15588n = colorMatrixColorFilterM7679b;
                    paint.setColorFilter(colorMatrixColorFilterM7679b);
                }
            }
            invalidateSelf();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f15576b.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f15576b.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x001f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0021 A[Catch: all -> 0x000d, TRY_LEAVE, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0027 A[Catch: all -> 0x000d, TRY_ENTER, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0031 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x003e A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x004b A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x005c A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0088 A[Catch: all -> 0x000d, TryCatch #0 {all -> 0x000d, blocks: (B:2:0x0000, B:4:0x0006, B:12:0x001b, B:15:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:27:0x0081, B:23:0x004b, B:25:0x005c, B:26:0x007b, B:28:0x0084, B:30:0x008d, B:29:0x0088, B:8:0x0010, B:10:0x0014), top: B:34:0x0000 }] */
    /* JADX INFO: renamed from: h */
    public final void updateFilter() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i6;
        boolean z5 = false;
        Paint paint;
        SparseArray sparseArray;
        ColorFilter colorMatrixColorFilter;
        float f6;
        int i7;
        ColorMatrix colorMatrix;
        try {
            int i8 = this.f15578d;
            if (i8 <= 0) {
                int i9 = this.f15579e;
                if (i9 > 0) {
                    i6 = i9 | 65536;
                    z5 = true;
                } else {
                    i6 = -1;
                }
                if (i6 == this.f15581g) {
                    return;
                }
                this.f15581g = i6;
                paint = this.f15575a;
                if (i6 != -1) {
                    sparseArray = sCachedBrightnessFilter;
                    colorMatrixColorFilter = (ColorFilter) sparseArray.get(i6);
                    if (colorMatrixColorFilter == null) {
                        f6 = this.f15579e / 48.0f;
                        i7 = (int) (255.0f * f6);
                        if (z5) {
                            colorMatrixColorFilter = new PorterDuffColorFilter(Color.argb(i7, 0, 0, 0), PorterDuff.Mode.SRC_ATOP);
                        } else {
                            float f7 = 1.0f - (this.f15578d / 48.0f);
                            colorMatrix = f15574r;
                            colorMatrix.setSaturation(f7);
                            if (this.f15579e > 0) {
                                float f8 = 1.0f - f6;
                                ColorMatrix colorMatrix2 = f15573q;
                                float[] array = colorMatrix2.getArray();
                                array[0] = f8;
                                array[6] = f8;
                                array[12] = f8;
                                float f9 = i7;
                                array[4] = f9;
                                array[9] = f9;
                                array[14] = f9;
                                colorMatrix.preConcat(colorMatrix2);
                            }
                            colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
                        }
                        sparseArray.append(i6, colorMatrixColorFilter);
                    }
                    paint.setColorFilter(colorMatrixColorFilter);
                } else {
                    paint.setColorFilter(this.f15588n);
                }
                invalidateSelf();
            }
            i6 = (i8 << 16) | this.f15579e;
            z5 = false;
            if (i6 == this.f15581g) {
                return;
            }
            this.f15581g = i6;
            paint = this.f15575a;
            if (i6 != -1) {
                sparseArray = sCachedBrightnessFilter;
                colorMatrixColorFilter = (ColorFilter) sparseArray.get(i6);
                if (colorMatrixColorFilter == null) {
                    f6 = this.f15579e / 48.0f;
                    i7 = (int) (255.0f * f6);
                    if (z5) {
                        colorMatrixColorFilter = new PorterDuffColorFilter(Color.argb(i7, 0, 0, 0), PorterDuff.Mode.SRC_ATOP);
                    } else {
                        float f10 = 1.0f - (this.f15578d / 48.0f);
                        colorMatrix = f15574r;
                        colorMatrix.setSaturation(f10);
                        if (this.f15579e > 0) {
                            float f11 = 1.0f - f6;
                            ColorMatrix colorMatrix3 = f15573q;
                            float[] array2 = colorMatrix3.getArray();
                            array2[0] = f11;
                            array2[6] = f11;
                            array2[12] = f11;
                            float f12 = i7;
                            array2[4] = f12;
                            array2[9] = f12;
                            array2[14] = f12;
                            colorMatrix.preConcat(colorMatrix3);
                        }
                        colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
                    }
                    sparseArray.append(i6, colorMatrixColorFilter);
                }
                paint.setColorFilter(colorMatrixColorFilter);
            } else {
                paint.setColorFilter(this.f15588n);
            }
            invalidateSelf();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i6) {
        this.mAlpha = i6;
        this.f15575a.setAlpha(i6);
    }

    @Keep
    public void setBrightness(float f6) {
        int iFloor = (int) Math.floor(f6 * 48.0f);
        if (this.f15579e != iFloor) {
            this.f15579e = iFloor;
            updateFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    @Keep
    public void setDesaturation(float f6) {
        int iFloor = (int) Math.floor(f6 * 48.0f);
        if (this.f15578d != iFloor) {
            this.f15578d = iFloor;
            updateFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z5) {
        Paint paint = this.f15575a;
        paint.setFilterBitmap(z5);
        paint.setAntiAlias(z5);
    }

    public FastBitmapDrawable(Launcher launcher, Bitmap bitmap, int i6, boolean z5) {
        this.f15575a = new Paint(2);
        this.f15577c = FastBitmapDrawableState.NORMAL;
        this.f15578d = 0;
        this.f15579e = 0;
        this.mAlpha = 255;
        this.f15581g = Integer.MAX_VALUE;
        this.f15586l = false;
        Paint paint = new Paint();
        this.f15587m = paint;
        this.f15576b = bitmap;
        this.f15586l = z5;
        setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (z5) {
            this.f15584j = i6;
            this.f15583i = launcher.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
            float f6 = i6;
            this.f15585k = new RectF(0.0f, 0.0f, f6, f6);
            paint.setAntiAlias(true);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL);
        }
        m7683e(launcher);
    }
}
