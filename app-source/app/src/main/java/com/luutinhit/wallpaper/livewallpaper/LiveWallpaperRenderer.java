package com.luutinhit.wallpaper.livewallpaper;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import androidx.annotation.Keep;
import com.luutinhit.launcherios.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p024a.AbstractC1314a;
import p055b2.RunnableC1584s;
import p070e4.C1998e;
import p070e4.InterfaceC1996c;
import p070e4.SharedPreferencesOnSharedPreferenceChangeListenerC1997d;
import r5.C2684b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class LiveWallpaperRenderer implements GLSurfaceView.Renderer {
    public static final float MAX_BIAS_RANGE = 0.003f;
    public static final int REFRESH_RATE = 60;
    public static final String TAG = "LiveWallpaperRenderer";
    public float biasRange;
    public float currentOrientationOffsetX;
    public float currentOrientationOffsetY;
    public boolean isDefaultWallpaper;
    public InterfaceC1996c mCallbacks;
    public Context mContext;
    public float orientationOffsetX;
    public float orientationOffsetY;
    public float preA;
    public float preB;
    public float screenAspectRatio;
    public int screenH;
    public float scrollRange;
    public ScheduledFuture<?> transitionHandle;
    public C1998e wallpaper;
    public float wallpaperAspectRatio;
    public float[] mMVPMatrix = new float[16];
    public float[] mProjectionMatrix = new float[16];
    public float[] mViewMatrix = new float[16];
    public ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public float transitionStep = 1.0f;
    public float scrollStep = 1.0f;
    public Queue<Float> scrollOffsetXQueue = new C2684b();
    public float scrollOffsetX = 0.5f;
    public float scrollOffsetXBackup = 0.5f;
    public boolean scrollMode = true;
    public int delay = 3;
    public Runnable transition = new RunnableC1584s(4, this);
    public boolean needsRefreshWallpaper = true;

    public LiveWallpaperRenderer(Context context, InterfaceC1996c interfaceC1996c) {
        this.mContext = context;
        this.mCallbacks = interfaceC1996c;
    }

    public Bitmap cropBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float f6 = width / height;
        this.wallpaperAspectRatio = f6;
        float f7 = this.screenAspectRatio;
        if (f6 >= f7) {
            double height2 = bitmap.getHeight();
            int i6 = this.screenH;
            if (height2 <= ((double) i6) * 1.1d) {
                return bitmap;
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (((double) i6) * 1.1d * ((double) this.wallpaperAspectRatio)), (int) (((double) i6) * 1.1d), true);
            bitmap.recycle();
            return bitmapCreateScaledBitmap;
        }
        this.scrollRange = 1.0f;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, ((int) (height - (width / f7))) / 2, (int) width, (int) (width / f7));
        bitmap.recycle();
        double height3 = bitmapCreateBitmap.getHeight();
        int i7 = this.screenH;
        if (height3 <= ((double) i7) * 1.1d) {
            return bitmapCreateBitmap;
        }
        Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapCreateBitmap, (int) (((double) i7) * 1.1d * ((double) this.screenAspectRatio)), (int) (((double) i7) * 1.1d), true);
        bitmapCreateBitmap.recycle();
        return bitmapCreateScaledBitmap2;
    }

    public Bitmap getSavedWallpaperFromStorage() {
        try {
            return BitmapFactory.decodeStream(new FileInputStream(new File(new ContextWrapper(this.mContext).getDir("image", 0), "wallpaper")));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void loadTexture() {
        int[] iArr;
        try {
            Bitmap bitmapDecodeStream = null;
            try {
                if (this.isDefaultWallpaper) {
                    try {
                        bitmapDecodeStream = getSavedWallpaperFromStorage();
                    } catch (Throwable th) {
                        th.getMessage();
                        try {
                            bitmapDecodeStream = ((BitmapDrawable) WallpaperManager.getInstance(this.mContext).getDrawable()).getBitmap();
                        } catch (Throwable th2) {
                            th2.getMessage();
                        }
                    }
                    if (bitmapDecodeStream == null) {
                        bitmapDecodeStream = BitmapFactory.decodeStream(this.mContext.getResources().openRawResource(R.raw.wallpaper_default_3));
                    }
                } else {
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(this.mContext.getResources().openRawResource(R.raw.wallpaper_default_3));
                    } catch (Throwable unused) {
                        this.isDefaultWallpaper = true;
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            if (bitmapDecodeStream == null) {
                return;
            }
            C1998e c1998e = this.wallpaper;
            if (c1998e != null && (iArr = c1998e.f18089k) != null) {
                GLES20.glDeleteTextures(iArr.length, iArr, 0);
                AbstractC1314a.m2692e("Destroy picture");
            }
            this.wallpaper = new C1998e(cropBitmap(bitmapDecodeStream));
            preCalculate();
            System.gc();
        } catch (Throwable th4) {
            th4.getMessage();
        }
    }

    public void preCalculate() {
        float f6 = this.scrollStep;
        if (f6 > 0.0f) {
            float f7 = this.wallpaperAspectRatio;
            float f8 = this.screenAspectRatio;
            if (f7 > ((1.0f / (f6 * 3.0f)) + 1.0f) * f8) {
                this.scrollRange = (1.0f / (f6 * 3.0f)) + 1.0f;
            } else if (f7 >= f8) {
                this.scrollRange = f7 / f8;
            } else {
                this.scrollRange = 1.0f;
            }
        } else {
            this.scrollRange = 1.0f;
        }
        float f9 = this.screenAspectRatio;
        this.preA = (this.scrollRange - 1.0f) * f9;
        if (f9 < 1.0f) {
            this.preB = (this.biasRange / f9) - 1.0f;
        } else {
            this.preB = (this.biasRange * f9) - 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transitionCal() {
        boolean z5;
        boolean z6 = true;
        if (Math.abs(this.currentOrientationOffsetX - this.orientationOffsetX) > 1.0E-4d || Math.abs(this.currentOrientationOffsetY - this.orientationOffsetY) > 1.0E-4d) {
            float f6 = this.orientationOffsetX;
            float f7 = this.currentOrientationOffsetX;
            int i6 = this.delay;
            float f8 = this.orientationOffsetY;
            float f9 = this.currentOrientationOffsetY;
            this.currentOrientationOffsetX = f7 + ((f6 - f7) / (i6 * 1.0f));
            this.currentOrientationOffsetY = f9 + ((f8 - f9) / (i6 * 1.0f));
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.scrollOffsetXQueue.isEmpty()) {
            z6 = z5;
        } else {
            this.scrollOffsetX = this.scrollOffsetXQueue.poll().floatValue();
        }
        if (z6) {
            ((SharedPreferencesOnSharedPreferenceChangeListenerC1997d) this.mCallbacks).m8540b();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        try {
            if (this.needsRefreshWallpaper) {
                loadTexture();
                this.needsRefreshWallpaper = false;
            }
            GLES20.glClear(16640);
            float f6 = (((this.scrollOffsetX * (-2.0f)) + 1.0f) * this.preA) + this.currentOrientationOffsetX;
            float f7 = this.currentOrientationOffsetY;
            Matrix.setLookAtM(this.mViewMatrix, 0, f6, f7, this.preB, f6, f7, 0.0f, 0.0f, 1.0f, 0.0f);
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.mProjectionMatrix, 0, this.mViewMatrix, 0);
            this.wallpaper.m8542a(this.mMVPMatrix);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i6, int i7) {
        if (i7 == 0) {
            i7 = 1;
        }
        this.screenAspectRatio = i6 / i7;
        this.screenH = i7;
        GLES20.glViewport(0, 0, i6, i7);
        float[] fArr = this.mProjectionMatrix;
        float f6 = this.screenAspectRatio;
        Matrix.frustumM(fArr, 0, f6 * (-0.1f), f6 * 0.1f, -0.1f, 0.1f, 0.1f, 2.0f);
        this.needsRefreshWallpaper = true;
        ((SharedPreferencesOnSharedPreferenceChangeListenerC1997d) this.mCallbacks).m8540b();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glEnable(3042);
        GLES20.glBlendFuncSeparate(770, 771, 1, 1);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int iGlCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(iGlCreateShader, "uniform mat4 uMVPMatrix;attribute vec4 aPosition;attribute vec2 aTexCoords;varying vec2 vTexCoords;void main(){  vTexCoords = aTexCoords;  gl_Position = uMVPMatrix * aPosition;}");
        GLES20.glCompileShader(iGlCreateShader);
        AbstractC1314a.m2692e("glCompileShader");
        int iGlCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(iGlCreateShader2, "precision mediump float;uniform sampler2D uTexture;varying vec2 vTexCoords;void main(){  gl_FragColor = texture2D(uTexture, vTexCoords);}");
        GLES20.glCompileShader(iGlCreateShader2);
        AbstractC1314a.m2692e("glCompileShader");
        int iGlCreateProgram = GLES20.glCreateProgram();
        AbstractC1314a.m2692e("glCreateProgram");
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader);
        GLES20.glAttachShader(iGlCreateProgram, iGlCreateShader2);
        GLES20.glLinkProgram(iGlCreateProgram);
        AbstractC1314a.m2692e("glLinkProgram");
        GLES20.glDeleteShader(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader2);
        C1998e.f18074n = iGlCreateProgram;
        C1998e.f18075o = GLES20.glGetAttribLocation(iGlCreateProgram, "aPosition");
        C1998e.f18076p = GLES20.glGetAttribLocation(C1998e.f18074n, "aTexCoords");
        C1998e.f18078r = GLES20.glGetUniformLocation(C1998e.f18074n, "uMVPMatrix");
        C1998e.f18077q = GLES20.glGetUniformLocation(C1998e.f18074n, "uTexture");
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        C1998e.f18073m = iArr[0];
    }

    public void release() {
        int[] iArr;
        C1998e c1998e = this.wallpaper;
        if (c1998e != null && (iArr = c1998e.f18089k) != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            AbstractC1314a.m2692e("Destroy picture");
        }
        stopTransition();
        this.scheduler.shutdown();
    }

    public void setBiasRange(int i6) {
        this.biasRange = (i6 * MAX_BIAS_RANGE) + 0.03f;
        preCalculate();
        ((SharedPreferencesOnSharedPreferenceChangeListenerC1997d) this.mCallbacks).m8540b();
    }

    public void setDelay(int i6) {
        this.delay = i6;
    }

    public void setIsDefaultWallpaper(boolean z5) {
        this.isDefaultWallpaper = z5;
        this.needsRefreshWallpaper = true;
        ((SharedPreferencesOnSharedPreferenceChangeListenerC1997d) this.mCallbacks).m8540b();
    }

    public void setOffset(float f6, float f7) {
        if (!this.scrollMode) {
            this.scrollOffsetXBackup = f6;
        } else {
            this.scrollOffsetXBackup = f6;
            this.scrollOffsetXQueue.offer(Float.valueOf(f6));
        }
    }

    public void setOffsetStep(float f6, float f7) {
        if (this.scrollStep != f6) {
            this.scrollStep = f6;
            preCalculate();
        }
    }

    public void setOrientationAngle(float f6, float f7) {
        this.orientationOffsetX = (float) (Math.sin(f6) * ((double) this.biasRange));
        this.orientationOffsetY = (float) (Math.sin(f7) * ((double) this.biasRange));
    }

    public void setScrollMode(boolean z5) {
        this.scrollMode = z5;
        if (z5) {
            this.scrollOffsetXQueue.offer(Float.valueOf(this.scrollOffsetXBackup));
        } else {
            this.scrollOffsetXQueue.clear();
            this.scrollOffsetXQueue.offer(Float.valueOf(0.5f));
        }
    }

    public void startTransition() {
        try {
            stopTransition();
            this.transitionHandle = this.scheduler.scheduleAtFixedRate(this.transition, 0L, 16L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void stopTransition() {
        ScheduledFuture<?> scheduledFuture = this.transitionHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
