package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.TypedValue;
import android.view.SurfaceHolder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: renamed from: com.luutinhit.launcher6.L0 */
/* JADX INFO: loaded from: classes.dex */
public final class LiquidGlassSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: i0 */
    public static final float[] f23353i0 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: j0 */
    public static final float[] f23354j0 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* JADX INFO: renamed from: A */
    public int f15780A;

    /* JADX INFO: renamed from: B */
    public int f15781B;

    /* JADX INFO: renamed from: C */
    public int f15782C;

    /* JADX INFO: renamed from: D */
    public int f15783D;

    /* JADX INFO: renamed from: E */
    public int f15784E;

    /* JADX INFO: renamed from: F */
    public int f15785F;

    /* JADX INFO: renamed from: G */
    public int f15786G;

    /* JADX INFO: renamed from: H */
    public FloatBuffer f15787H;

    /* JADX INFO: renamed from: I */
    public FloatBuffer f15788I;

    /* JADX INFO: renamed from: J */
    public int f15789J;

    /* JADX INFO: renamed from: K */
    public int[] f15790K;

    /* JADX INFO: renamed from: L */
    public int[] f15791L;

    /* JADX INFO: renamed from: M */
    public RectF f15792M;

    /* JADX INFO: renamed from: N */
    public float f15793N;

    /* JADX INFO: renamed from: O */
    public boolean f15794O;

    /* JADX INFO: renamed from: P */
    public int f15795P;

    /* JADX INFO: renamed from: Q */
    public int f15796Q;

    /* JADX INFO: renamed from: R */
    public int f15797R;

    /* JADX INFO: renamed from: S */
    public int f15798S;

    /* JADX INFO: renamed from: T */
    public int[] f15799T;

    /* JADX INFO: renamed from: U */
    public float f15800U;

    /* JADX INFO: renamed from: V */
    public float f15801V;

    /* JADX INFO: renamed from: W */
    public float f15802W;

    /* JADX INFO: renamed from: a0 */
    public float f23355a0;

    /* JADX INFO: renamed from: b0 */
    public float f23356b0;

    /* JADX INFO: renamed from: c0 */
    public float f23357c0;

    /* JADX INFO: renamed from: d0 */
    public float f23358d0;

    /* JADX INFO: renamed from: e0 */
    public int f23359e0;

    /* JADX INFO: renamed from: f0 */
    public int f23360f0;

    /* JADX INFO: renamed from: g0 */
    public int f23361g0;

    /* JADX INFO: renamed from: h0 */
    public int f23362h0;

    /* JADX INFO: renamed from: j */
    public Context f15803j;

    /* JADX INFO: renamed from: k */
    public Bitmap f15804k;

    /* JADX INFO: renamed from: l */
    public int f15805l;

    /* JADX INFO: renamed from: m */
    public int f15806m;

    /* JADX INFO: renamed from: n */
    public int f15807n;

    /* JADX INFO: renamed from: o */
    public int f15808o;

    /* JADX INFO: renamed from: p */
    public int f15809p;

    /* JADX INFO: renamed from: q */
    public int f15810q;

    /* JADX INFO: renamed from: r */
    public int f15811r;

    /* JADX INFO: renamed from: s */
    public volatile int f15812s;

    /* JADX INFO: renamed from: t */
    public volatile int f15813t;

    /* JADX INFO: renamed from: u */
    public volatile int f15814u;

    /* JADX INFO: renamed from: v */
    public volatile boolean f15815v;

    /* JADX INFO: renamed from: w */
    public float f15816w;

    /* JADX INFO: renamed from: x */
    public int f15817x;

    /* JADX INFO: renamed from: y */
    public int f15818y;

    /* JADX INFO: renamed from: z */
    public int f15819z;

    public LiquidGlassSurfaceView(Context context, float f6) {
        super(context);
        this.f15805l = 0;
        this.f15806m = 0;
        this.f15807n = 0;
        this.f15808o = 0;
        this.f15809p = 0;
        this.f15810q = 0;
        this.f15811r = 0;
        this.f15812s = -1;
        this.f15813t = -1;
        this.f15814u = -1;
        this.f15815v = false;
        this.f15816w = 0.25f;
        this.f15789J = 0;
        this.f15790K = new int[2];
        this.f15791L = new int[2];
        this.f15792M = new RectF();
        this.f15794O = true;
        this.f15795P = 0;
        this.f15796Q = 0;
        this.f15797R = 0;
        this.f15798S = 0;
        this.f15799T = new int[1];
        this.f15800U = Float.NaN;
        this.f15801V = Float.NaN;
        this.f15802W = -1.0f;
        this.f23355a0 = -1.0f;
        this.f23356b0 = -1.0f;
        this.f23357c0 = -1.0f;
        this.f23358d0 = -1.0f;
        this.f23359e0 = -1;
        this.f23360f0 = -1;
        this.f23361g0 = -1;
        this.f23362h0 = -1;
        this.f15803j = context;
        setEGLConfigChooser(new EglConfigChooser(this));
        setEGLContextFactory(new EglContextFactory(this));
        getHolder().setFormat(-3);
        setZOrderOnTop(false);
        setRenderer(this);
        setRenderMode(0);
        float[] fArr = f23353i0;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.f15787H = floatBufferAsFloatBuffer;
        float[] fArr2 = f23354j0;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(fArr2).position(0);
        this.f15788I = floatBufferAsFloatBuffer2;
        this.f15816w = f6;
    }

    /* JADX INFO: renamed from: a */
    public final void bindTexture(int i6, int i7, int i8) {
        if (i7 == 0) {
            return;
        }
        if (this.f15795P == 3) {
            GLES20.glActiveTexture(33984 + i6);
            GLES20.glBindTexture(3553, i7);
            GLES20.glUniform1i(i8, i6);
        } else {
            GLES20.glActiveTexture(33984 + i6);
            GLES20.glBindTexture(3553, i7);
            GLES20.glUniform1i(i8, i6);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int loadShader(int i6, String str) {
        if (this.f15795P == 2) {
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

    /* JADX INFO: renamed from: c */
    public final int createProgram(String str, String str2) {
        if (this.f15795P == 2) {
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
    public final int loadTexture(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        int i6 = this.f15795P;
        int[] iArr = this.f15799T;
        if (i6 == 3) {
            GLES20.glGenTextures(1, iArr, 0);
            int i7 = iArr[0];
            GLES20.glBindTexture(3553, i7);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindTexture(3553, 0);
            return i7;
        }
        GLES20.glGenTextures(1, iArr, 0);
        int i8 = iArr[0];
        GLES20.glBindTexture(3553, i8);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        return i8;
    }

    /* JADX INFO: renamed from: e */
    public final void updatePositionAndRender() {
        int i6;
        int i7;
        if (getVisibility() != 0) {
            return;
        }
        int[] iArr = this.f15790K;
        getLocationOnScreen(iArr);
        int i8 = iArr[0];
        int i9 = iArr[1];
        if (this.f15805l == 0 || this.f15806m == 0 || (i6 = this.f15807n) == 0 || (i7 = this.f15808o) == 0) {
            return;
        }
        int[] iArr2 = this.f15791L;
        if (i8 == iArr2[0] && i9 == iArr2[1]) {
            return;
        }
        iArr2[0] = i8;
        iArr2[1] = i9;
        int i10 = iArr[0];
        int i11 = iArr[1];
        this.f15792M.set(i10, i11, i6 + i10, i7 + i11);
        requestRender();
    }

    /* JADX INFO: renamed from: f */
    public final void setScrollOffset(float f6) {
        int i6;
        if (getVisibility() != 0 || Math.abs(f6 - this.f15793N) <= 1.0f || this.f15805l <= 0 || (i6 = this.f15807n) <= 0) {
            return;
        }
        float f7 = this.f15790K[0] + f6;
        RectF rectF = this.f15792M;
        rectF.left = f7;
        rectF.right = f7 + i6;
        this.f15793N = f6;
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        try {
            queueEvent(new GlTextureLoadRunnable(this, 2));
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        if (!this.f15794O) {
            if (this.f15795P == 3) {
                GLES20.glClear(16384);
                return;
            } else {
                GLES20.glClear(16384);
                return;
            }
        }
        if (this.f15809p == 0 || this.f15811r == 0 || this.f15810q == 0) {
            return;
        }
        if (this.f15795P == 3) {
            GLES20.glClear(16384);
            if (this.f15811r != this.f15814u) {
                GLES20.glUseProgram(this.f15811r);
                this.f15814u = this.f15811r;
            }
        } else {
            GLES20.glClear(16384);
            if (this.f15811r != this.f15814u) {
                GLES20.glUseProgram(this.f15811r);
                this.f15814u = this.f15811r;
            }
        }
        if (this.f15809p != this.f15812s) {
            bindTexture(0, this.f15809p, this.f15817x);
            this.f15812s = this.f15809p;
        }
        if (this.f15810q != this.f15813t) {
            bindTexture(1, this.f15810q, this.f15818y);
            this.f15813t = this.f15810q;
        }
        if (!this.f15815v) {
            int i6 = this.f15807n;
            if (i6 != this.f23359e0 || this.f15808o != this.f23360f0) {
                if (this.f15795P == 3) {
                    GLES20.glUniform2f(this.f15819z, i6, this.f15808o);
                } else {
                    GLES20.glUniform2f(this.f15819z, i6, this.f15808o);
                }
                this.f23359e0 = this.f15807n;
                this.f23360f0 = this.f15808o;
            }
            float f6 = this.f15808o * this.f15816w;
            if (f6 != this.f15802W) {
                if (this.f15795P == 3) {
                    GLES20.glUniform1f(this.f15780A, f6);
                } else {
                    GLES20.glUniform1f(this.f15780A, f6);
                }
                this.f15802W = f6;
            }
            float f7 = this.f15800U;
            if (f7 != this.f23355a0) {
                if (this.f15795P == 3) {
                    GLES20.glUniform1f(this.f15781B, f7);
                } else {
                    GLES20.glUniform1f(this.f15781B, f7);
                }
                this.f23355a0 = this.f15800U;
            }
            float f8 = this.f15801V;
            if (f8 != this.f23356b0) {
                if (this.f15795P == 3) {
                    GLES20.glUniform1f(this.f15782C, f8);
                } else {
                    GLES20.glUniform1f(this.f15782C, f8);
                }
                this.f23356b0 = this.f15801V;
            }
            if (this.f23357c0 != 1.0f) {
                if (this.f15795P == 3) {
                    GLES20.glUniform1f(this.f15783D, 1.0f);
                } else {
                    GLES20.glUniform1f(this.f15783D, 1.0f);
                }
                this.f23357c0 = 1.0f;
            }
            int i7 = this.f15805l;
            if (i7 != this.f23361g0 || this.f15806m != this.f23362h0) {
                if (this.f15795P == 3) {
                    GLES20.glUniform2f(this.f15784E, i7, this.f15806m);
                } else {
                    GLES20.glUniform2f(this.f15784E, i7, this.f15806m);
                }
                this.f23361g0 = this.f15805l;
                this.f23362h0 = this.f15806m;
            }
            if (this.f23358d0 != 2.0f) {
                if (this.f15795P == 3) {
                    GLES20.glUniform1f(this.f15786G, 0.8f);
                } else {
                    GLES20.glUniform1f(this.f15786G, 0.88f);
                }
                this.f23358d0 = 2.0f;
            }
            if (this.f15795P == 3) {
                int i8 = this.f15785F;
                RectF rectF = this.f15792M;
                GLES20.glUniform2f(i8, rectF.left, rectF.top);
            } else {
                int i9 = this.f15785F;
                RectF rectF2 = this.f15792M;
                GLES20.glUniform2f(i9, rectF2.left, rectF2.top);
            }
            this.f15815v = true;
        } else if (this.f15795P == 3) {
            int i10 = this.f15785F;
            RectF rectF3 = this.f15792M;
            GLES20.glUniform2f(i10, rectF3.left, rectF3.top);
        } else {
            int i11 = this.f15785F;
            RectF rectF4 = this.f15792M;
            GLES20.glUniform2f(i11, rectF4.left, rectF4.top);
        }
        if (this.f15795P != 3) {
            GLES20.glDrawArrays(5, 0, 4);
            return;
        }
        GLES30.glBindVertexArray(this.f15798S);
        GLES20.glDrawArrays(5, 0, 4);
        GLES30.glBindVertexArray(0);
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            this.f15807n = i8 - i6;
            this.f15808o = i9 - i7;
            this.f15815v = false;
            updatePositionAndRender();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i6, int i7) {
        this.f15807n = i6;
        this.f15808o = i7;
        if (this.f15795P == 3) {
            GLES20.glViewport(0, 0, i6, i7);
        } else {
            GLES20.glViewport(0, 0, i6, i7);
        }
        Context context = this.f15803j;
        this.f15800U = TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        this.f15801V = TypedValue.applyDimension(1, -55.0f, context.getResources().getDisplayMetrics());
        Bitmap bitmap = this.f15804k;
        if (bitmap != null && this.f15809p == 0) {
            this.f15809p = loadTexture(bitmap);
            setSdfTexture(this.f15789J);
        }
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        if (this.f15795P == 3) {
            GLES20.glDisable(3024);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            int iCreateProgram = createProgram(FocusHelper.m7975c(getContext(), FocusHelper.f16325e), FocusHelper.m7975c(getContext(), FocusHelper.f16323c));
            this.f15811r = iCreateProgram;
            if (iCreateProgram == 0) {
                return;
            }
            this.f15814u = -1;
            GLES20.glUseProgram(this.f15811r);
            this.f15819z = GLES20.glGetUniformLocation(this.f15811r, "u_ViewSize");
            this.f15780A = GLES20.glGetUniformLocation(this.f15811r, "u_CornerRadius");
            this.f15781B = GLES20.glGetUniformLocation(this.f15811r, "u_RefractionHeight");
            this.f15782C = GLES20.glGetUniformLocation(this.f15811r, "u_RefractionAmount");
            this.f15783D = GLES20.glGetUniformLocation(this.f15811r, "u_DepthEffect");
            this.f15784E = GLES20.glGetUniformLocation(this.f15811r, "u_BackgroundSize");
            this.f15785F = GLES20.glGetUniformLocation(this.f15811r, "u_GlViewPosition");
            this.f15786G = GLES20.glGetUniformLocation(this.f15811r, "u_StrokeWidth");
            this.f15817x = GLES20.glGetUniformLocation(this.f15811r, "u_Texture");
            this.f15818y = GLES20.glGetUniformLocation(this.f15811r, "u_SDFMask");
        } else {
            GLES20.glDisable(3024);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            int iCreateProgram2 = createProgram(FocusHelper.m7975c(getContext(), FocusHelper.f16324d), FocusHelper.m7975c(getContext(), FocusHelper.f16322b));
            this.f15811r = iCreateProgram2;
            if (iCreateProgram2 == 0) {
                return;
            }
            GLES20.glUseProgram(iCreateProgram2);
            this.f15819z = GLES20.glGetUniformLocation(this.f15811r, "u_ViewSize");
            this.f15780A = GLES20.glGetUniformLocation(this.f15811r, "u_CornerRadius");
            this.f15781B = GLES20.glGetUniformLocation(this.f15811r, "u_RefractionHeight");
            this.f15782C = GLES20.glGetUniformLocation(this.f15811r, "u_RefractionAmount");
            this.f15783D = GLES20.glGetUniformLocation(this.f15811r, "u_DepthEffect");
            this.f15784E = GLES20.glGetUniformLocation(this.f15811r, "u_BackgroundSize");
            this.f15785F = GLES20.glGetUniformLocation(this.f15811r, "u_GlViewPosition");
            this.f15786G = GLES20.glGetUniformLocation(this.f15811r, "u_StrokeWidth");
            this.f15817x = GLES20.glGetUniformLocation(this.f15811r, "u_Texture");
            this.f15818y = GLES20.glGetUniformLocation(this.f15811r, "u_SDFMask");
        }
        int i6 = this.f15795P;
        FloatBuffer floatBuffer = this.f15788I;
        FloatBuffer floatBuffer2 = this.f15787H;
        int[] iArr = this.f15799T;
        if (i6 == 3) {
            GLES20.glGenBuffers(1, iArr, 0);
            int i7 = iArr[0];
            this.f15796Q = i7;
            GLES20.glBindBuffer(34962, i7);
            floatBuffer2.position(0);
            GLES20.glBufferData(34962, floatBuffer2.capacity() * 4, floatBuffer2, 35044);
            GLES20.glGenBuffers(1, iArr, 0);
            int i8 = iArr[0];
            this.f15797R = i8;
            GLES20.glBindBuffer(34962, i8);
            floatBuffer.position(0);
            GLES20.glBufferData(34962, floatBuffer.capacity() * 4, floatBuffer, 35044);
            GLES20.glBindBuffer(34962, 0);
            GLES30.glGenVertexArrays(1, iArr, 0);
            int i9 = iArr[0];
            this.f15798S = i9;
            GLES30.glBindVertexArray(i9);
            GLES20.glBindBuffer(34962, this.f15796Q);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, 0);
            GLES20.glBindBuffer(34962, this.f15797R);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, 0);
            GLES30.glBindVertexArray(0);
            GLES20.glBindBuffer(34962, 0);
        } else {
            GLES20.glGenBuffers(1, iArr, 0);
            int i10 = iArr[0];
            this.f15796Q = i10;
            GLES20.glBindBuffer(34962, i10);
            floatBuffer2.position(0);
            GLES20.glBufferData(34962, floatBuffer2.capacity() * 4, floatBuffer2, 35044);
            GLES20.glGenBuffers(1, iArr, 0);
            int i11 = iArr[0];
            this.f15797R = i11;
            GLES20.glBindBuffer(34962, i11);
            floatBuffer.position(0);
            GLES20.glBufferData(34962, floatBuffer.capacity() * 4, floatBuffer, 35044);
            GLES20.glBindBuffer(34962, this.f15796Q);
            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, 5126, false, 0, 0);
            GLES20.glBindBuffer(34962, this.f15797R);
            GLES20.glEnableVertexAttribArray(1);
            GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, 0);
            GLES20.glBindBuffer(34962, 0);
        }
        this.f15809p = 0;
        this.f15810q = 0;
        Bitmap bitmap = this.f15804k;
        if (bitmap != null) {
            this.f15809p = loadTexture(bitmap);
        }
        int i12 = this.f15789J;
        if (i12 != 0) {
            setSdfTexture(i12);
        }
        this.f15812s = -1;
        this.f15813t = -1;
        this.f15814u = -1;
        this.f15815v = false;
        int[] iArr2 = this.f15791L;
        iArr2[0] = -1;
        iArr2[1] = -1;
        this.f15802W = -1.0f;
        this.f23355a0 = -1.0f;
        this.f23356b0 = -1.0f;
        this.f23357c0 = -1.0f;
        this.f23358d0 = -1.0f;
        this.f23359e0 = -1;
        this.f23360f0 = -1;
        this.f23361g0 = -1;
        this.f23362h0 = -1;
        requestRender();
    }

    public void setFullBitmap(Bitmap bitmap) {
        if (bitmap == this.f15804k || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f15812s = -1;
        this.f15804k = bitmap;
        this.f15815v = false;
        queueEvent(new GlTextureLoadRunnable(this, 3));
    }

    public void setSdfTexture(int i6) {
        if (i6 == 0) {
            return;
        }
        this.f15789J = i6;
        this.f15813t = -1;
        if (this.f15807n <= 0 || this.f15808o <= 0) {
            return;
        }
        queueEvent(new GlTextureLoadRunnable(this, 1));
    }

    public void setVisible(boolean z5) {
        this.f15794O = z5;
        postOnAnimation(new GlTextureLoadRunnable(this, 0));
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        int[] iArr = this.f15791L;
        iArr[0] = -1;
        iArr[1] = -1;
    }
}
