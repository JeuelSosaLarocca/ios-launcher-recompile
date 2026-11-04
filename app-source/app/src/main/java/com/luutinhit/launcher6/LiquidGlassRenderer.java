package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.TypedValue;
import android.view.Choreographer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.P0 */
/* JADX INFO: loaded from: classes.dex */
public final class LiquidGlassRenderer {

    /* JADX INFO: renamed from: A */
    public static LiquidGlassRenderer f15873A;

    /* JADX INFO: renamed from: B */
    public static final float[] f15874B = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: C */
    public static final float[] f15875C = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* JADX INFO: renamed from: a */
    public Context f15876a;

    /* JADX INFO: renamed from: b */
    public EGLDisplay f15877b;

    /* JADX INFO: renamed from: c */
    public EGLContext f15878c;

    /* JADX INFO: renamed from: d */
    public EGLConfig f15879d;

    /* JADX INFO: renamed from: e */
    public EGLSurface f15880e;

    /* JADX INFO: renamed from: f */
    public int f15881f;

    /* JADX INFO: renamed from: g */
    public int f15882g = 0;

    /* JADX INFO: renamed from: h */
    public int f15883h = 0;

    /* JADX INFO: renamed from: i */
    public int f15884i;

    /* JADX INFO: renamed from: j */
    public int f15885j;

    /* JADX INFO: renamed from: k */
    public int f15886k;

    /* JADX INFO: renamed from: l */
    public int f15887l;

    /* JADX INFO: renamed from: m */
    public int f15888m;

    /* JADX INFO: renamed from: n */
    public int f15889n;

    /* JADX INFO: renamed from: o */
    public int f15890o;

    /* JADX INFO: renamed from: p */
    public int f15891p;

    /* JADX INFO: renamed from: q */
    public int f15892q;

    /* JADX INFO: renamed from: r */
    public int f15893r;

    /* JADX INFO: renamed from: s */
    public FloatBuffer f15894s;

    /* JADX INFO: renamed from: t */
    public FloatBuffer f15895t;

    /* JADX INFO: renamed from: u */
    public ArrayDeque f15896u;

    /* JADX INFO: renamed from: v */
    public ConcurrentHashMap f15897v;

    /* JADX INFO: renamed from: w */
    public int f15898w;

    /* JADX INFO: renamed from: x */
    public int f15899x;

    /* JADX INFO: renamed from: y */
    public boolean f15900y;

    /* JADX INFO: renamed from: z */
    public GlassRenderFrameCallback f15901z;

    public LiquidGlassRenderer(Context context) {
        String strM7975c;
        String strM7975c2;
        this.f15877b = EGL14.EGL_NO_DISPLAY;
        this.f15878c = EGL14.EGL_NO_CONTEXT;
        this.f15880e = EGL14.EGL_NO_SURFACE;
        this.f15881f = 0;
        this.f15884i = -1;
        this.f15885j = -1;
        this.f15886k = -1;
        this.f15887l = -1;
        this.f15888m = -1;
        this.f15889n = -1;
        this.f15890o = -1;
        this.f15891p = -1;
        this.f15892q = -1;
        this.f15893r = -1;
        float[] fArr = f15874B;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.f15894s = floatBufferAsFloatBuffer;
        float[] fArr2 = f15875C;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        this.f15895t = floatBufferAsFloatBuffer2;
        this.f15896u = new ArrayDeque();
        this.f15897v = new ConcurrentHashMap();
        this.f15900y = false;
        this.f15901z = new GlassRenderFrameCallback(this);
        this.f15876a = context;
        float fApplyDimension = TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        float fApplyDimension2 = TypedValue.applyDimension(1, -55.0f, context.getResources().getDisplayMetrics());
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f15877b = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            EGL14.eglGetError();
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f15877b, iArr, 0, iArr, 1)) {
            EGL14.eglGetError();
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        EGL14.eglChooseConfig(EGL14.eglGetDisplay(0), new int[]{12352, 64, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
        EGLConfig eGLConfig = iArr2[0] > 0 ? eGLConfigArr[0] : null;
        this.f15879d = eGLConfig;
        if (eGLConfig != null) {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.f15877b, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
            this.f15878c = eGLContextEglCreateContext;
            if (eGLContextEglCreateContext != EGL14.EGL_NO_CONTEXT) {
                this.f15900y = true;
            }
        }
        if (this.f15878c == EGL14.EGL_NO_CONTEXT) {
            EGLConfig[] eGLConfigArr2 = new EGLConfig[1];
            int[] iArr3 = new int[1];
            EGL14.eglChooseConfig(EGL14.eglGetDisplay(0), new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr2, 0, 1, iArr3, 0);
            EGLConfig eGLConfig2 = iArr3[0] > 0 ? eGLConfigArr2[0] : null;
            this.f15879d = eGLConfig2;
            EGLContext eGLContextEglCreateContext2 = EGL14.eglCreateContext(this.f15877b, eGLConfig2, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            this.f15878c = eGLContextEglCreateContext2;
            if (eGLContextEglCreateContext2 == EGL14.EGL_NO_CONTEXT) {
                EGL14.eglGetError();
            }
            this.f15900y = false;
        }
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f15877b, this.f15879d, new int[]{12375, 1, 12374, 1, 12344}, 0);
        this.f15880e = eGLSurfaceEglCreatePbufferSurface;
        if (eGLSurfaceEglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
            throw new RuntimeException("eglCreatePbufferSurface failed: " + EGL14.eglGetError());
        }
        if (!EGL14.eglMakeCurrent(this.f15877b, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, this.f15878c)) {
            throw new RuntimeException("eglMakeCurrent (pbuffer) failed: " + EGL14.eglGetError());
        }
        String strM7975c3 = "";
        if (this.f15900y) {
            GLES20.glDisable(3024);
            GLES20.glDisable(2929);
            GLES20.glDisable(2884);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            try {
                strM7975c2 = FocusHelper.m7975c(context, FocusHelper.f16325e);
            } catch (Throwable unused) {
                strM7975c2 = "";
            }
            try {
                strM7975c3 = FocusHelper.m7975c(context, FocusHelper.f16323c);
            } catch (Throwable unused2) {
            }
            int iCreateProgram = createProgram(strM7975c2, strM7975c3);
            this.f15881f = iCreateProgram;
            GLES20.glUseProgram(iCreateProgram);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) this.f15894s);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) this.f15895t);
            this.f15884i = GLES20.glGetUniformLocation(this.f15881f, "u_ViewSize");
            this.f15885j = GLES20.glGetUniformLocation(this.f15881f, "u_CornerRadius");
            this.f15886k = GLES20.glGetUniformLocation(this.f15881f, "u_RefractionHeight");
            this.f15887l = GLES20.glGetUniformLocation(this.f15881f, "u_RefractionAmount");
            this.f15888m = GLES20.glGetUniformLocation(this.f15881f, "u_DepthEffect");
            this.f15889n = GLES20.glGetUniformLocation(this.f15881f, "u_BackgroundSize");
            this.f15890o = GLES20.glGetUniformLocation(this.f15881f, "u_GlViewPosition");
            this.f15891p = GLES20.glGetUniformLocation(this.f15881f, "u_StrokeWidth");
            this.f15892q = GLES20.glGetUniformLocation(this.f15881f, "u_Texture");
            this.f15893r = GLES20.glGetUniformLocation(this.f15881f, "u_SDFMask");
            int i6 = this.f15886k;
            if (i6 != -1) {
                GLES20.glUniform1f(i6, fApplyDimension);
            }
            int i7 = this.f15887l;
            if (i7 != -1) {
                GLES20.glUniform1f(i7, fApplyDimension2);
            }
            int i8 = this.f15888m;
            if (i8 != -1) {
                GLES20.glUniform1f(i8, 1.0f);
            }
            int i9 = this.f15891p;
            if (i9 != -1) {
                GLES20.glUniform1f(i9, 0.88f);
            }
            int i10 = this.f15889n;
            if (i10 != -1) {
                try {
                    GLES20.glUniform2f(i10, ((Launcher) context).screenWidth, ((Launcher) context).screenHeight);
                } catch (Throwable unused3) {
                }
            }
            int i11 = this.f15892q;
            if (i11 != -1) {
                GLES20.glUniform1i(i11, 0);
            }
            int i12 = this.f15893r;
            if (i12 != -1) {
                GLES20.glUniform1i(i12, 1);
            }
        } else {
            GLES20.glDisable(3024);
            GLES20.glDisable(2929);
            GLES20.glDisable(2884);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            try {
                strM7975c = FocusHelper.m7975c(context, FocusHelper.f16324d);
            } catch (Throwable unused4) {
                strM7975c = "";
            }
            try {
                strM7975c3 = FocusHelper.m7975c(context, FocusHelper.f16322b);
            } catch (Throwable unused5) {
            }
            String str = strM7975c3;
            int iCreateProgram2 = createProgram(strM7975c.contains("precision") ? strM7975c : "precision mediump float;\n".concat(strM7975c), str.contains("precision") ? str : "precision mediump float;\n".concat(str));
            this.f15881f = iCreateProgram2;
            GLES20.glUseProgram(iCreateProgram2);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, (Buffer) this.f15894s);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, (Buffer) this.f15895t);
            this.f15884i = GLES20.glGetUniformLocation(this.f15881f, "u_ViewSize");
            this.f15885j = GLES20.glGetUniformLocation(this.f15881f, "u_CornerRadius");
            this.f15886k = GLES20.glGetUniformLocation(this.f15881f, "u_RefractionHeight");
            this.f15887l = GLES20.glGetUniformLocation(this.f15881f, "u_RefractionAmount");
            this.f15888m = GLES20.glGetUniformLocation(this.f15881f, "u_DepthEffect");
            this.f15889n = GLES20.glGetUniformLocation(this.f15881f, "u_BackgroundSize");
            this.f15890o = GLES20.glGetUniformLocation(this.f15881f, "u_GlViewPosition");
            this.f15891p = GLES20.glGetUniformLocation(this.f15881f, "u_StrokeWidth");
            this.f15892q = GLES20.glGetUniformLocation(this.f15881f, "u_Texture");
            this.f15893r = GLES20.glGetUniformLocation(this.f15881f, "u_SDFMask");
            int i13 = this.f15886k;
            if (i13 != -1) {
                GLES20.glUniform1f(i13, fApplyDimension);
            }
            int i14 = this.f15887l;
            if (i14 != -1) {
                GLES20.glUniform1f(i14, fApplyDimension2);
            }
            int i15 = this.f15888m;
            if (i15 != -1) {
                GLES20.glUniform1f(i15, 1.0f);
            }
            int i16 = this.f15891p;
            if (i16 != -1) {
                GLES20.glUniform1f(i16, 0.88f);
            }
            int i17 = this.f15889n;
            if (i17 != -1) {
                try {
                    GLES20.glUniform2f(i17, ((Launcher) context).screenWidth, ((Launcher) context).screenHeight);
                } catch (Throwable unused6) {
                }
            }
            int i18 = this.f15892q;
            if (i18 != -1) {
                GLES20.glUniform1i(i18, 0);
            }
            int i19 = this.f15893r;
            if (i19 != -1) {
                GLES20.glUniform1i(i19, 1);
            }
        }
        Choreographer.getInstance().postFrameCallback(this.f15901z);
    }

    /* JADX INFO: renamed from: c */
    public static LiquidGlassRenderer getInstance(Context context) {
        if (f15873A == null) {
            synchronized (LiquidGlassRenderer.class) {
                try {
                    if (f15873A == null) {
                        f15873A = new LiquidGlassRenderer(context);
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
        return f15873A;
    }

    /* JADX INFO: renamed from: a */
    public final int loadShader(int i6, String str) {
        if (str == null) {
            return 0;
        }
        if (this.f15900y) {
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
        int iGlCreateShader2 = GLES20.glCreateShader(i6);
        GLES20.glShaderSource(iGlCreateShader2, str);
        GLES20.glCompileShader(iGlCreateShader2);
        int[] iArr2 = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader2, 35713, iArr2, 0);
        if (iArr2[0] != 0) {
            return iGlCreateShader2;
        }
        GLES20.glGetShaderInfoLog(iGlCreateShader2);
        GLES20.glDeleteShader(iGlCreateShader2);
        return 0;
    }

    /* JADX INFO: renamed from: b */
    public final int createProgram(String str, String str2) {
        if (this.f15900y) {
            int iLoadShader = loadShader(35633, str);
            int iLoadShader2 = loadShader(35632, str2);
            if (iLoadShader != 0 && iLoadShader2 != 0) {
                int iGlCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
                GLES20.glBindAttribLocation(iGlCreateProgram, 0, "a_Position");
                GLES20.glBindAttribLocation(iGlCreateProgram, 1, "a_TexCoord");
                GLES20.glLinkProgram(iGlCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                if (iArr[0] == 1) {
                    return iGlCreateProgram;
                }
                GLES20.glGetProgramInfoLog(iGlCreateProgram);
                GLES20.glDeleteProgram(iGlCreateProgram);
                return 0;
            }
        } else {
            int iLoadShader3 = loadShader(35633, str);
            int iLoadShader4 = loadShader(35632, str2);
            if (iLoadShader3 != 0 && iLoadShader4 != 0) {
                int iGlCreateProgram2 = GLES20.glCreateProgram();
                GLES20.glAttachShader(iGlCreateProgram2, iLoadShader3);
                GLES20.glAttachShader(iGlCreateProgram2, iLoadShader4);
                GLES20.glBindAttribLocation(iGlCreateProgram2, 0, "a_Position");
                GLES20.glBindAttribLocation(iGlCreateProgram2, 1, "a_TexCoord");
                GLES20.glLinkProgram(iGlCreateProgram2);
                int[] iArr2 = new int[1];
                GLES20.glGetProgramiv(iGlCreateProgram2, 35714, iArr2, 0);
                if (iArr2[0] == 1) {
                    return iGlCreateProgram2;
                }
                GLES20.glGetProgramInfoLog(iGlCreateProgram2);
                GLES20.glDeleteProgram(iGlCreateProgram2);
                return 0;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public final int uploadTexture(int i6, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        boolean z5 = i6 == 0;
        if (this.f15900y) {
            if (!z5) {
                GLES20.glBindTexture(3553, i6);
                GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
                GLES20.glBindTexture(3553, 0);
                return i6;
            }
            if (i6 != 0) {
                GLES20.glDeleteTextures(1, new int[]{i6}, 0);
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
        if (!z5) {
            GLES20.glBindTexture(3553, i6);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            GLES20.glBindTexture(3553, 0);
            return i6;
        }
        if (i6 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i6}, 0);
        }
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        int i8 = iArr2[0];
        GLES20.glBindTexture(3553, i8);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        return i8;
    }

    /* JADX INFO: renamed from: e */
    public final void queueEvent(Runnable runnable) {
        synchronized (this.f15896u) {
            this.f15896u.addLast(runnable);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void setMaskResource(int i6) {
        Bitmap bitmapDecodeResource;
        if (i6 == 0 || (bitmapDecodeResource = BitmapFactory.decodeResource(this.f15876a.getResources(), i6)) == null) {
            return;
        }
        Bitmap.Config config = bitmapDecodeResource.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2) {
            bitmapDecodeResource = bitmapDecodeResource.copy(config2, false);
        }
        queueEvent(new GlassBitmapUploadRunnable(this, bitmapDecodeResource, 0));
    }
}
