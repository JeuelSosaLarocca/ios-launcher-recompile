package com.luutinhit.launcher6;

import B3.RunnableC0054W;
import J3.C0546e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.TypedValue;
import android.view.PixelCopy;
import android.view.TextureView;
import android.view.Window;
import com.google.android.renderscript.Toolkit;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import p081h2.AbstractC2127a;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Z0 */
/* JADX INFO: loaded from: classes.dex */
public final class LiquidGlassEglTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: e0 */
    public static final float[] f23464e0 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: f0 */
    public static final float[] f23465f0 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* JADX INFO: renamed from: A */
    public volatile float f16148A;

    /* JADX INFO: renamed from: B */
    public float f16149B;

    /* JADX INFO: renamed from: C */
    public int f16150C;

    /* JADX INFO: renamed from: D */
    public volatile boolean f16151D;

    /* JADX INFO: renamed from: E */
    public RectF f16152E;

    /* JADX INFO: renamed from: F */
    public int f16153F;

    /* JADX INFO: renamed from: G */
    public int f16154G;

    /* JADX INFO: renamed from: H */
    public int f16155H;

    /* JADX INFO: renamed from: I */
    public int f16156I;

    /* JADX INFO: renamed from: J */
    public int f16157J;

    /* JADX INFO: renamed from: K */
    public int f16158K;

    /* JADX INFO: renamed from: L */
    public int f16159L;

    /* JADX INFO: renamed from: M */
    public int f16160M;

    /* JADX INFO: renamed from: N */
    public int f16161N;

    /* JADX INFO: renamed from: O */
    public int f16162O;

    /* JADX INFO: renamed from: P */
    public FloatBuffer f16163P;

    /* JADX INFO: renamed from: Q */
    public FloatBuffer f16164Q;

    /* JADX INFO: renamed from: R */
    public AtomicBoolean f16165R;

    /* JADX INFO: renamed from: S */
    public AtomicBoolean f16166S;

    /* JADX INFO: renamed from: T */
    public float f16167T;

    /* JADX INFO: renamed from: U */
    public float f16168U;

    /* JADX INFO: renamed from: V */
    public Handler f16169V;

    /* JADX INFO: renamed from: W */
    public ConcurrentLinkedQueue f16170W;

    /* JADX INFO: renamed from: a0 */
    public int f23466a0;

    /* JADX INFO: renamed from: b0 */
    public int f23467b0;

    /* JADX INFO: renamed from: c0 */
    public int[] f23468c0;

    /* JADX INFO: renamed from: d0 */
    public ExecutorService f23469d0;

    /* JADX INFO: renamed from: j */
    public Launcher f16171j;

    /* JADX INFO: renamed from: k */
    public GlassRenderThread f16172k;

    /* JADX INFO: renamed from: l */
    public Object f16173l;

    /* JADX INFO: renamed from: m */
    public EGLDisplay f16174m;

    /* JADX INFO: renamed from: n */
    public EGLContext f16175n;

    /* JADX INFO: renamed from: o */
    public EGLSurface f16176o;

    /* JADX INFO: renamed from: p */
    public int f16177p;

    /* JADX INFO: renamed from: q */
    public int f16178q;

    /* JADX INFO: renamed from: r */
    public int f16179r;

    /* JADX INFO: renamed from: s */
    public volatile Bitmap f16180s;

    /* JADX INFO: renamed from: t */
    public volatile int f16181t;

    /* JADX INFO: renamed from: u */
    public volatile int f16182u;

    /* JADX INFO: renamed from: v */
    public volatile int f16183v;

    /* JADX INFO: renamed from: w */
    public volatile int f16184w;

    /* JADX INFO: renamed from: x */
    public volatile int f16185x;

    /* JADX INFO: renamed from: y */
    public volatile int f16186y;

    /* JADX INFO: renamed from: z */
    public volatile float f16187z;

    public LiquidGlassEglTextureView(Context context) {
        super(context, null);
        this.f16173l = new Object();
        this.f16174m = EGL14.EGL_NO_DISPLAY;
        this.f16175n = EGL14.EGL_NO_CONTEXT;
        this.f16176o = EGL14.EGL_NO_SURFACE;
        this.f16177p = 0;
        this.f16178q = 0;
        this.f16179r = 0;
        this.f16181t = 0;
        this.f16182u = 0;
        this.f16183v = 0;
        this.f16184w = 0;
        this.f16185x = 0;
        this.f16186y = 0;
        this.f16187z = 0.0f;
        this.f16148A = 0.0f;
        this.f16149B = 0.13f;
        this.f16150C = 0;
        this.f16151D = true;
        this.f16152E = new RectF();
        this.f16165R = new AtomicBoolean(true);
        this.f16166S = new AtomicBoolean(false);
        this.f16170W = new ConcurrentLinkedQueue();
        this.f23468c0 = new int[2];
        this.f23469d0 = Executors.newFixedThreadPool(2);
        Launcher launcher = (Launcher) context;
        this.f16171j = launcher;
        setSurfaceTextureListener(this);
        setOpaque(false);
        HandlerThread handlerThread = new HandlerThread("PixelCopyThread");
        handlerThread.start();
        this.f16169V = new Handler(handlerThread.getLooper());
        float[] fArr = f23464e0;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.f16163P = floatBufferAsFloatBuffer;
        float[] fArr2 = f23465f0;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        this.f16164Q = floatBufferAsFloatBuffer2;
        this.f16167T = TypedValue.applyDimension(1, 8.0f, launcher.getResources().getDisplayMetrics());
        this.f16168U = TypedValue.applyDimension(1, -60.0f, launcher.getResources().getDisplayMetrics());
        getViewBitmap();
    }

    /* JADX INFO: renamed from: a */
    public static void releaseEgl(LiquidGlassEglTextureView liquidGlassEglTextureView) {
        int i6 = liquidGlassEglTextureView.f16178q;
        if (i6 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i6}, 0);
            liquidGlassEglTextureView.f16178q = 0;
        }
        int i7 = liquidGlassEglTextureView.f16179r;
        if (i7 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i7}, 0);
            liquidGlassEglTextureView.f16179r = 0;
        }
        int i8 = liquidGlassEglTextureView.f16177p;
        if (i8 != 0) {
            GLES20.glDeleteProgram(i8);
            liquidGlassEglTextureView.f16177p = 0;
        }
        EGLDisplay eGLDisplay = liquidGlassEglTextureView.f16174m;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        EGLSurface eGLSurface2 = liquidGlassEglTextureView.f16176o;
        if (eGLSurface2 != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(liquidGlassEglTextureView.f16174m, eGLSurface2);
        }
        EGLContext eGLContext = liquidGlassEglTextureView.f16175n;
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(liquidGlassEglTextureView.f16174m, eGLContext);
        }
        EGL14.eglTerminate(liquidGlassEglTextureView.f16174m);
        liquidGlassEglTextureView.f16176o = EGL14.EGL_NO_SURFACE;
        liquidGlassEglTextureView.f16175n = EGL14.EGL_NO_CONTEXT;
        liquidGlassEglTextureView.f16174m = EGL14.EGL_NO_DISPLAY;
    }

    /* JADX INFO: renamed from: b */
    public static void drawFrame(LiquidGlassEglTextureView liquidGlassEglTextureView) {
        if (!liquidGlassEglTextureView.f16151D || liquidGlassEglTextureView.f16180s == null || liquidGlassEglTextureView.f16177p == 0) {
            GLES20.glViewport(0, 0, Math.max(1, liquidGlassEglTextureView.f16185x), Math.max(1, liquidGlassEglTextureView.f16186y));
            GLES20.glClear(16384);
            EGL14.eglSwapBuffers(liquidGlassEglTextureView.f16174m, liquidGlassEglTextureView.f16176o);
            return;
        }
        GLES20.glViewport(0, 0, Math.max(1, liquidGlassEglTextureView.f16185x), Math.max(1, liquidGlassEglTextureView.f16186y));
        GLES20.glClear(16384);
        GLES20.glUseProgram(liquidGlassEglTextureView.f16177p);
        int i6 = liquidGlassEglTextureView.f16178q;
        if (i6 != 0) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i6);
        }
        int i7 = liquidGlassEglTextureView.f16179r;
        if (i7 != 0) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, i7);
        }
        if (liquidGlassEglTextureView.f16165R.getAndSet(false)) {
            GLES20.glUniform2f(liquidGlassEglTextureView.f16155H, liquidGlassEglTextureView.f16187z, liquidGlassEglTextureView.f16148A);
            GLES20.glUniform1f(liquidGlassEglTextureView.f16156I, liquidGlassEglTextureView.f16187z * liquidGlassEglTextureView.f16149B);
            GLES20.glUniform1f(liquidGlassEglTextureView.f16157J, liquidGlassEglTextureView.f16167T);
            GLES20.glUniform1f(liquidGlassEglTextureView.f16158K, liquidGlassEglTextureView.f16168U);
            GLES20.glUniform1f(liquidGlassEglTextureView.f16159L, 1.0f);
            int i8 = liquidGlassEglTextureView.f16160M;
            Launcher launcher = liquidGlassEglTextureView.f16171j;
            GLES20.glUniform2f(i8, launcher.screenWidth, launcher.screenHeight);
            GLES20.glUniform1f(liquidGlassEglTextureView.f16162O, 0.8f);
            int i9 = liquidGlassEglTextureView.f16161N;
            RectF rectF = liquidGlassEglTextureView.f16152E;
            GLES20.glUniform2f(i9, rectF.left, rectF.top);
            GLES20.glUniform1i(liquidGlassEglTextureView.f16153F, 0);
            GLES20.glUniform1i(liquidGlassEglTextureView.f16154G, 1);
        }
        GLES20.glEnableVertexAttribArray(0);
        GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) liquidGlassEglTextureView.f16163P);
        GLES20.glEnableVertexAttribArray(1);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) liquidGlassEglTextureView.f16164Q);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(0);
        GLES20.glDisableVertexAttribArray(1);
        EGL14.eglSwapBuffers(liquidGlassEglTextureView.f16174m, liquidGlassEglTextureView.f16176o);
    }

    /* JADX INFO: renamed from: c */
    public static void initEgl(LiquidGlassEglTextureView liquidGlassEglTextureView) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        liquidGlassEglTextureView.f16174m = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed! " + EGL14.eglGetError());
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            throw new RuntimeException("eglInitialize failed! " + EGL14.eglGetError());
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(liquidGlassEglTextureView.f16174m, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        EGLConfig eGLConfig = iArr2[0] > 0 ? eGLConfigArr[0] : null;
        if (eGLConfig == null) {
            throw new RuntimeException("EGLConfig not found!");
        }
        liquidGlassEglTextureView.f16175n = EGL14.eglCreateContext(liquidGlassEglTextureView.f16174m, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(liquidGlassEglTextureView.f16174m, eGLConfig, liquidGlassEglTextureView.getSurfaceTexture(), new int[]{12344}, 0);
        liquidGlassEglTextureView.f16176o = eGLSurfaceEglCreateWindowSurface;
        if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("eglCreateWindowSurface failed! " + EGL14.eglGetError());
        }
        if (EGL14.eglMakeCurrent(liquidGlassEglTextureView.f16174m, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, liquidGlassEglTextureView.f16175n)) {
            return;
        }
        throw new RuntimeException("eglMakeCurrent failed! " + EGL14.eglGetError());
    }

    /* JADX INFO: renamed from: d */
    public static void initGlProgram(LiquidGlassEglTextureView liquidGlassEglTextureView) {
        int iGlCreateProgram;
        Bitmap bitmapDecodeResource;
        int i6;
        GLES20.glDisable(3024);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        String strM7975c = FocusHelper.m7975c(liquidGlassEglTextureView.getContext(), FocusHelper.f16324d);
        String strM7975c2 = FocusHelper.m7975c(liquidGlassEglTextureView.getContext(), FocusHelper.f16322b);
        int iLoadShader = loadShader(35633, strM7975c);
        int iLoadShader2 = loadShader(35632, strM7975c2);
        if (iLoadShader == 0 || iLoadShader2 == 0) {
            iGlCreateProgram = 0;
        } else {
            iGlCreateProgram = GLES20.glCreateProgram();
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
            GLES20.glBindAttribLocation(iGlCreateProgram, 0, "a_Position");
            GLES20.glBindAttribLocation(iGlCreateProgram, 1, "a_TexCoord");
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                GLES20.glGetProgramInfoLog(iGlCreateProgram);
                GLES20.glDeleteProgram(iGlCreateProgram);
                iGlCreateProgram = 0;
            }
        }
        liquidGlassEglTextureView.f16177p = iGlCreateProgram;
        if (iGlCreateProgram == 0) {
            return;
        }
        liquidGlassEglTextureView.f16155H = GLES20.glGetUniformLocation(iGlCreateProgram, "u_ViewSize");
        liquidGlassEglTextureView.f16156I = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_CornerRadius");
        liquidGlassEglTextureView.f16157J = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_RefractionHeight");
        liquidGlassEglTextureView.f16158K = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_RefractionAmount");
        liquidGlassEglTextureView.f16159L = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_DepthEffect");
        liquidGlassEglTextureView.f16160M = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_BackgroundSize");
        liquidGlassEglTextureView.f16161N = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_GlViewPosition");
        liquidGlassEglTextureView.f16162O = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_StrokeWidth");
        liquidGlassEglTextureView.f16153F = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_Texture");
        liquidGlassEglTextureView.f16154G = GLES20.glGetUniformLocation(liquidGlassEglTextureView.f16177p, "u_SDFMask");
        if (liquidGlassEglTextureView.f16180s != null && (i6 = liquidGlassEglTextureView.f16178q) == 0) {
            liquidGlassEglTextureView.f16178q = liquidGlassEglTextureView.uploadTexture(liquidGlassEglTextureView.f16180s, i6, false);
        }
        if (liquidGlassEglTextureView.f16150C != 0 && liquidGlassEglTextureView.f16179r == 0 && (bitmapDecodeResource = BitmapFactory.decodeResource(liquidGlassEglTextureView.f16171j.getResources(), liquidGlassEglTextureView.f16150C)) != null) {
            Bitmap.Config config = bitmapDecodeResource.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCopy = config == config2 ? bitmapDecodeResource : bitmapDecodeResource.copy(config2, false);
            liquidGlassEglTextureView.f16179r = liquidGlassEglTextureView.uploadTexture(bitmapCopy, liquidGlassEglTextureView.f16179r, true);
            if (bitmapCopy != bitmapDecodeResource) {
                bitmapDecodeResource.recycle();
            }
        }
        liquidGlassEglTextureView.f16165R.set(true);
    }

    /* JADX INFO: renamed from: f */
    public static int loadShader(int i6, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i6);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        GLES20.glGetShaderInfoLog(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    /* JADX INFO: renamed from: g */
    public static void captureBackground(DragLayer dragLayer, GlassBitmapCallback glassBitmapCallback) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dragLayer.getWidth(), dragLayer.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = dragLayer.getBackground();
        if (background != null) {
            background.setBounds(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            background.draw(canvas);
        }
        dragLayer.draw(canvas);
        glassBitmapCallback.mo1299a(Bitmap.createScaledBitmap(bitmapCreateBitmap, Math.max(1, dragLayer.getWidth() / 6), Math.max(1, dragLayer.getHeight() / 6), true));
    }

    public void getViewBitmap() {
        Window window = this.f16171j.getWindow();
        DragLayer dragLayer = this.f16171j.getDragLayer();
        BitmapResultCallback bitmapResultCallback = new BitmapResultCallback(1, this);
        if (this.f16180s != null) {
            captureWindowPixels(window, dragLayer, new C0546e(4, this, bitmapResultCallback));
        } else {
            this.f16170W.add(new GlassCaptureRequest(dragLayer, bitmapResultCallback));
        }
    }

    /* JADX INFO: renamed from: j */
    public static Bitmap composeBackgroundBitmap(Bitmap bitmap, Bitmap bitmap2, float f6) {
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
        Bitmap bitmap3 = null;
        try {
            if (!bitmap.isRecycled()) {
                if (bitmap2.isRecycled()) {
                    bitmap2 = bitmap;
                } else {
                    int width2 = bitmap2.getWidth();
                    int height2 = bitmap2.getHeight();
                    if (width2 <= 0 || height2 <= 0) {
                        bitmap2 = null;
                    } else {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, width2, height2), (Paint) null);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        bitmap2 = bitmapCreateBitmap;
                    }
                }
            }
            try {
                System.nanoTime();
                Bitmap bitmapM7540a = Toolkit.f15289a.m7540a(6, bitmap2);
                System.nanoTime();
                System.nanoTime();
                bitmap2.recycle();
                return bitmapM7540a;
            } catch (Throwable unused) {
                bitmap3 = bitmap2;
                try {
                    return AbstractC2127a.m8802r(6, Bitmap.createScaledBitmap(bitmap, iMax, iMax2, true));
                } finally {
                    if (bitmap3 != null) {
                        bitmap3.recycle();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return null; // jadx: method fell off the end
    }

    /* JADX INFO: renamed from: e */
    public final void captureWindowPixels(Window window, DragLayer dragLayer, GlassBitmapCallback glassBitmapCallback) {
        int iMax = Math.max(1, dragLayer.getWidth() / 6);
        int iMax2 = Math.max(1, dragLayer.getHeight() / 6);
        if (Build.VERSION.SDK_INT < 26) {
            captureBackground(dragLayer, glassBitmapCallback);
            return;
        }
        int[] iArr = new int[2];
        dragLayer.getLocationInWindow(iArr);
        int i6 = iArr[0];
        Rect rect = new Rect(i6, iArr[1], dragLayer.getWidth() + i6, dragLayer.getHeight() + iArr[1]);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
        PixelCopy.request(window, rect, bitmapCreateBitmap, new PixelCopyResultListener(this, glassBitmapCallback, bitmapCreateBitmap, dragLayer), this.f16169V);
    }

    /* JADX INFO: renamed from: h */
    public final int uploadTexture(Bitmap bitmap, int i6, boolean z5) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i6 != 0 && (!z5 ? !(this.f16181t == bitmap.getWidth() && this.f16182u == bitmap.getHeight()) : !(this.f16183v == bitmap.getWidth() && this.f16184w == bitmap.getHeight()))) {
            GLES20.glBindTexture(3553, i6);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            GLES20.glBindTexture(3553, 0);
            return i6;
        }
        if (i6 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i6}, 0);
        }
        if (z5) {
            this.f16183v = bitmap.getWidth();
            this.f16184w = bitmap.getHeight();
        } else {
            this.f16181t = bitmap.getWidth();
            this.f16182u = bitmap.getHeight();
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i7 = iArr[0];
        GLES20.glBindTexture(3553, i7);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        return i7;
    }

    /* JADX INFO: renamed from: i */
    public final void updateViewRect() {
        this.f16166S.set(true);
        synchronized (this.f16173l) {
            try {
                GlassRenderThread glassRenderThread = this.f16172k;
                if (glassRenderThread != null) {
                    glassRenderThread.m7886b();
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public final void setBackgroundBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f16180s = bitmap;
        while (true) {
            GlassCaptureRequest glassCaptureRequest = (GlassCaptureRequest) this.f16170W.poll();
            if (glassCaptureRequest == null) {
                break;
            } else {
                captureWindowPixels(this.f16171j.getWindow(), glassCaptureRequest.f16118a, new C0546e(3, this, glassCaptureRequest));
            }
        }
        synchronized (this.f16173l) {
            try {
                GlassRenderThread glassRenderThread = this.f16172k;
                if (glassRenderThread != null) {
                    glassRenderThread.m7885a(new MergedIdleRunnable(4, this));
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            this.f16185x = i8 - i6;
            this.f16186y = i9 - i7;
            this.f16187z = this.f16185x;
            this.f16148A = this.f16186y;
            this.f16165R.set(true);
            updateViewRect();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        this.f16185x = i6;
        this.f16186y = i7;
        synchronized (this.f16173l) {
            try {
                if (this.f16172k == null) {
                    GlassRenderThread glassRenderThread = new GlassRenderThread(this);
                    this.f16172k = glassRenderThread;
                    glassRenderThread.start();
                    updateViewRect();
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        synchronized (this.f16173l) {
            try {
                GlassRenderThread glassRenderThread = this.f16172k;
                if (glassRenderThread != null) {
                    glassRenderThread.f16138j = false;
                    glassRenderThread.m7886b();
                    try {
                        glassRenderThread.join();
                    } catch (InterruptedException unused) {
                    }
                    this.f16172k = null;
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        this.f16185x = i6;
        this.f16186y = i7;
        this.f16165R.set(true);
        updateViewRect();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setSdfTexture(int i6) {
        if (i6 == 0) {
            return;
        }
        this.f16150C = i6;
        Bitmap bitmapDecodeResource = null;
        try {
            bitmapDecodeResource = BitmapFactory.decodeResource(this.f16171j.getResources(), i6);
            if (bitmapDecodeResource != null) {
                Bitmap.Config config = bitmapDecodeResource.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                if (config != config2) {
                    Bitmap bitmapCopy = bitmapDecodeResource.copy(config2, false);
                    bitmapDecodeResource.recycle();
                    bitmapDecodeResource = bitmapCopy;
                }
            }
        } catch (Throwable unused) {
        }
        if (bitmapDecodeResource == null) {
            return;
        }
        synchronized (this.f16173l) {
            GlassRenderThread glassRenderThread = this.f16172k;
            if (glassRenderThread != null) {
                glassRenderThread.m7885a(new RunnableC0054W(18, this, bitmapDecodeResource));
            } else {
                try {
                    bitmapDecodeResource.recycle();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public void setVisible(boolean z5) {
        this.f16151D = z5;
        if (this.f16151D) {
            updateViewRect();
        }
    }
}
