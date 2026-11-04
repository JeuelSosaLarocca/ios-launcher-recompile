package com.luutinhit.launcher6;

import J3.C0546e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcherios.R;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p015Q.AbstractC0839e;
import p081h2.AbstractC2127a;

/* JADX INFO: renamed from: com.luutinhit.launcher6.V0 */
/* JADX INFO: loaded from: classes.dex */
public final class RuntimeShaderGlassView extends View {

    /* JADX INFO: renamed from: j */
    public Paint f16027j;

    /* JADX INFO: renamed from: k */
    public RuntimeShader f16028k;

    /* JADX INFO: renamed from: l */
    public Bitmap f16029l;

    /* JADX INFO: renamed from: m */
    public float f16030m;

    /* JADX INFO: renamed from: n */
    public float f16031n;

    /* JADX INFO: renamed from: o */
    public float f16032o;

    /* JADX INFO: renamed from: p */
    public float f16033p;

    /* JADX INFO: renamed from: q */
    public float f16034q;

    /* JADX INFO: renamed from: r */
    public float f16035r;

    /* JADX INFO: renamed from: s */
    public float f16036s;

    /* JADX INFO: renamed from: t */
    public int[] f16037t;

    /* JADX INFO: renamed from: u */
    public int[] f16038u;

    /* JADX INFO: renamed from: v */
    public Handler f16039v;

    /* JADX INFO: renamed from: w */
    public boolean f16040w;

    /* JADX INFO: renamed from: x */
    public Path f16041x;

    /* JADX INFO: renamed from: y */
    public ConcurrentLinkedQueue f16042y;

    /* JADX INFO: renamed from: z */
    public ExecutorService f16043z;

    public RuntimeShaderGlassView(Context context, boolean z5) {
        super(context, null);
        Paint paint = new Paint(1);
        this.f16027j = paint;
        this.f16030m = 0.25f;
        this.f16035r = 0.0f;
        this.f16036s = 0.0f;
        this.f16037t = new int[2];
        this.f16038u = new int[]{-1, -1};
        this.f16041x = new Path();
        this.f16042y = new ConcurrentLinkedQueue();
        this.f16043z = Executors.newFixedThreadPool(2);
        this.f16040w = z5;
        RuntimeShader runtimeShaderM1868a = AbstractC0839e.m1868a(FocusHelper.m7975c(context, FocusHelper.f16321a));
        this.f16028k = runtimeShaderM1868a;
        paint.setAntiAlias(true);
        paint.setShader(runtimeShaderM1868a);
        HandlerThread handlerThread = new HandlerThread("PixelCopyThread");
        handlerThread.start();
        this.f16039v = new Handler(handlerThread.getLooper());
        runtimeShaderM1868a.setFloatUniform("u_RefractionHeight", dpToPx(12.0f));
        runtimeShaderM1868a.setFloatUniform("u_RefractionAmount", dpToPx(-50.0f));
        runtimeShaderM1868a.setFloatUniform("u_DepthEffect", 1.0f);
        runtimeShaderM1868a.setFloatUniform("u_Scale", 1.0f, 1.0f);
        runtimeShaderM1868a.setFloatUniform("u_StrokeWidth", dpToPx(1.6f));
        if (z5) {
            getViewBitmap();
        }
    }

    /* JADX INFO: renamed from: c */
    public static void captureBackground(DragLayer dragLayer, BitmapCallback bitmapCallback) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getWidth(), dragLayer.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = dragLayer.getBackground();
        if (background != null) {
            background.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            background.draw(canvas);
        }
        dragLayer.draw(canvas);
        bitmapCallback.mo1299a(bitmapCreateBitmap);
    }

    /* JADX INFO: renamed from: d */
    public static boolean hasPositionChanged(float f6, float f7, float f8, float f9, float f10, float f11) {
        return f6 < f10 && f6 + f8 > 0.0f && f7 < f11 && f7 + f9 > 0.0f;
    }

    /* JADX INFO: renamed from: e */
    public static Bitmap composeBackgroundBitmap(Bitmap bitmap, Bitmap bitmap2, float f6) {
        Bitmap bitmap3;
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap2;
        }
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return bitmap;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        bitmap2.getWidth();
        bitmap2.getHeight();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMax = Math.max(1, Math.round(width / f6));
        int iMax2 = Math.max(1, Math.round(height / f6));
        Bitmap bitmapM7540a = null;
        try {
            System.nanoTime();
            if (!bitmap.isRecycled()) {
                if (bitmap2.isRecycled()) {
                    bitmap2 = bitmap;
                } else {
                    float width2 = bitmap2.getWidth();
                    float height2 = bitmap2.getHeight();
                    if (width2 <= 0.0f || height2 <= 0.0f) {
                        bitmap2 = null;
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) width2, (int) height2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, width2, height2), (Paint) null);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        bitmap2 = bitmapCreateBitmap;
                    }
                }
            }
            try {
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, iMax, iMax2, true);
                bitmapM7540a = Toolkit.f15289a.m7540a(6, bitmap2);
                System.nanoTime();
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM7540a, width, height, true);
                System.nanoTime();
                bitmap2.recycle();
                if (bitmapM7540a != null) {
                    bitmapM7540a.recycle();
                }
                return bitmapCreateScaledBitmap;
            } catch (Throwable unused) {
                Bitmap bitmap4 = bitmapM7540a;
                bitmapM7540a = bitmap2;
                bitmap3 = bitmap4;
                try {
                    return AbstractC2127a.m8802r((int) 6, Bitmap.createScaledBitmap(bitmap, iMax, iMax2, true));
                } finally {
                    if (bitmapM7540a != null) {
                        bitmapM7540a.recycle();
                    }
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                }
            }
        } catch (Throwable unused2) {
            bitmap3 = null;
        }
        return null; // jadx: method fell off the end
    }

    public void getViewBitmap() {
        Window window = ((Launcher) getContext()).getWindow();
        DragLayer dragLayer = ((Launcher) getContext()).getDragLayer();
        BitmapResultCallback bitmapResultCallback = new BitmapResultCallback(0, this);
        if (this.f16029l != null) {
            captureWindowPixels(window, dragLayer, new C0546e(2, this, bitmapResultCallback));
        } else {
            this.f16042y.add(new BlurCaptureRequest(dragLayer, bitmapResultCallback));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void captureWindowPixels(Window window, DragLayer dragLayer, BitmapCallback bitmapCallback) {
        if (Build.VERSION.SDK_INT < 26) {
            captureBackground(dragLayer, bitmapCallback);
            return;
        }
        int[] iArr = new int[2];
        dragLayer.getLocationInWindow(iArr);
        int i6 = iArr[0];
        Rect rect = new Rect(i6, iArr[1], dragLayer.getWidth() + i6, dragLayer.getHeight() + iArr[1]);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getWidth(), dragLayer.getHeight(), Bitmap.Config.ARGB_8888);
        PixelCopy.request(window, rect, bitmapCreateBitmap, new PixelCopyResultListener(this, bitmapCreateBitmap, bitmapCallback, dragLayer), this.f16039v);
    }

    /* JADX INFO: renamed from: b */
    public final float dpToPx(float f6) {
        return getResources().getDisplayMetrics().density * f6;
    }

    /* JADX INFO: renamed from: f */
    public final void setScrollOffset(float f6) {
        int[] iArr = this.f16037t;
        int i6 = iArr[1];
        Objects.toString(getParent());
        this.f16028k.setFloatUniform("u_GlViewPosition", f6, iArr[1]);
        invalidate();
    }

    /* JADX INFO: renamed from: g */
    public final void updateGlViewPosition() {
        int[] iArr = this.f16038u;
        getLocationOnScreen(iArr);
        int[] iArr2 = this.f16037t;
        if (Arrays.equals(iArr, iArr2)) {
            return;
        }
        int i6 = iArr[0];
        iArr2[0] = i6;
        int i7 = iArr[1];
        iArr2[1] = i7;
        if (hasPositionChanged(i6, i7, this.f16032o, this.f16031n, this.f16033p, this.f16034q)) {
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            Objects.toString(getParent());
            this.f16028k.setFloatUniform("u_GlViewPosition", iArr2[0], iArr2[1]);
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap;
        if (!canvas.isHardwareAccelerated() || (bitmap = this.f16029l) == null || bitmap.isRecycled()) {
            super.onDraw(canvas);
        } else {
            canvas.drawPath(this.f16041x, this.f16027j);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            getWidth();
            getHeight();
            Objects.toString(getParent());
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.f16028k.setFloatUniform("u_GlViewPosition", iArr[0], iArr[1]);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        Objects.toString(getParent());
        float f6 = i6;
        this.f16032o = f6;
        float f7 = i7;
        this.f16031n = f7;
        this.f16035r = f6 * 0.5f;
        this.f16036s = f7 * 0.5f;
        float f8 = this.f16030m * f7;
        this.f16028k.setFloatUniform("u_ViewSize", f6, f7);
        this.f16028k.setFloatUniform("u_CornerRadius", f8);
        Path path = this.f16041x;
        path.reset();
        Path path2 = new Path();
        float f9 = f6 - 0.0f;
        float f10 = f7 - 0.0f;
        if (f9 > 0.0f && f10 > 0.0f) {
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            float f11 = f9 / 2.0f;
            float f12 = this.f16035r - f11;
            float f13 = f10 / 2.0f;
            float f14 = this.f16036s - f13;
            float fMin = f8 / Math.min(f11, f13);
            float fMin2 = fMin > 0.5f ? 1.0f - (Math.min(1.0f, (fMin - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
            float fMin3 = fMin > 0.6f ? 1.0f + (Math.min(1.0f, (fMin - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
            float f15 = f12 + f9;
            float f16 = f14 + f10;
            float f17 = f8 / 100.0f;
            float f18 = 128.19f * f17 * fMin2;
            float f19 = 83.62f * f17 * fMin3;
            float f20 = f17 * 67.45f;
            float f21 = f17 * 51.16f;
            float f22 = f17 * 34.86f;
            float f23 = f17 * 22.07f;
            float f24 = f17 * 13.36f;
            float f25 = f17 * 4.64f;
            float fMax = Math.max(f11, f9 - f18);
            float fMax2 = Math.max(f13, f10 - f18);
            float fMin4 = Math.min(f11, f18);
            float fMin5 = Math.min(f13, f18);
            path2.moveTo(f11 + f12, f14);
            float f26 = fMax + f12;
            path2.lineTo(f26, f14);
            float f27 = f15 - f19;
            float f28 = f15 - f20;
            float f29 = f14 + f25;
            float f30 = f15 - f21;
            float f31 = f14 + f24;
            path2.cubicTo(f27, f14, f28, f29, f30, f31);
            float f32 = f15 - f22;
            float f33 = f14 + f23;
            float f34 = f15 - f23;
            float f35 = f14 + f22;
            float f36 = f15 - f24;
            float f37 = f14 + f21;
            path2.cubicTo(f32, f33, f34, f35, f36, f37);
            float f38 = f15 - f25;
            float f39 = f14 + f20;
            float f40 = f14 + f19;
            float f41 = f14 + fMin5;
            path2.cubicTo(f38, f39, f15, f40, f15, f41);
            float f42 = f14 + fMax2;
            path2.lineTo(f15, f42);
            float f43 = f16 - f19;
            float f44 = f16 - f20;
            float f45 = f16 - f21;
            path2.cubicTo(f15, f43, f38, f44, f36, f45);
            float f46 = f16 - f22;
            float f47 = f16 - f23;
            float f48 = f16 - f24;
            path2.cubicTo(f34, f46, f32, f47, f30, f48);
            float f49 = f16 - f25;
            path2.cubicTo(f28, f49, f27, f16, f26, f16);
            float f50 = f12 + fMin4;
            path2.lineTo(f50, f16);
            float f51 = f12 + f19;
            float f52 = f12 + f20;
            float f53 = f12 + f21;
            path2.cubicTo(f51, f16, f52, f49, f53, f48);
            float f54 = f12 + f22;
            float f55 = f12 + f23;
            float f56 = f12 + f24;
            path2.cubicTo(f54, f47, f55, f46, f56, f45);
            float f57 = f12 + f25;
            path2.cubicTo(f57, f44, f12, f43, f12, f42);
            path2.lineTo(f12, f41);
            path2.cubicTo(f12, f40, f57, f39, f56, f37);
            path2.cubicTo(f55, f35, f54, f33, f53, f31);
            path2.cubicTo(f52, f29, f51, f14, f50, f14);
            path2.close();
        }
        path.addPath(path2);
    }

    public void setCornerRadiusPercent(float f6) {
        this.f16030m = f6;
    }

    public void setFullBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.f16029l == bitmap) {
            return;
        }
        this.f16033p = bitmap.getWidth();
        this.f16034q = bitmap.getHeight();
        this.f16029l = bitmap;
        if (this.f16040w) {
            while (true) {
                BlurCaptureRequest blurCaptureRequest = (BlurCaptureRequest) this.f16042y.poll();
                if (blurCaptureRequest == null) {
                    break;
                }
                captureWindowPixels(((Launcher) getContext()).getWindow(), blurCaptureRequest.f15964a, new C0546e(1, this, blurCaptureRequest));
            }
        }
        Bitmap bitmap2 = this.f16029l;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f16028k.setInputShader("u_Texture", new BitmapShader(bitmap2, tileMode, tileMode));
        this.f16028k.setFloatUniform("u_BackgroundSize", this.f16033p, this.f16034q);
        invalidate();
    }

    public void setSdfTexture(int i6) {
        if (i6 == 0) {
            return;
        }
        if (i6 == R.drawable.draff) {
            this.f16030m = 0.23f;
            this.f16028k.setFloatUniform("u_RefractionHeight", dpToPx(18.0f));
            this.f16028k.setFloatUniform("u_RefractionAmount", dpToPx(-50.0f));
        } else if (i6 == R.drawable.scale) {
            this.f16030m = 0.11f;
        } else if (i6 == R.drawable.long_round) {
            this.f16030m = 0.42f;
            this.f16028k.setFloatUniform("u_RefractionHeight", dpToPx(12.0f));
            this.f16028k.setFloatUniform("u_RefractionAmount", dpToPx(-50.0f));
        } else if (i6 == R.drawable.lib) {
            this.f16030m = 0.18f;
        } else if (i6 == R.drawable.in) {
            this.f16030m = 0.49f;
        }
        this.f16028k.setFloatUniform("u_CornerRadius", this.f16031n * this.f16030m);
    }
}
