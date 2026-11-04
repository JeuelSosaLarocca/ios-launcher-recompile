package com.luutinhit.launcher6;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: renamed from: com.luutinhit.launcher6.O0 */
/* JADX INFO: loaded from: classes.dex */
public final class GlassSurfaceHolder {

    /* JADX INFO: renamed from: a */
    public LiquidGlassTextureView f15859a;

    /* JADX INFO: renamed from: b */
    public Surface f15860b;

    /* JADX INFO: renamed from: d */
    public volatile int f15862d;

    /* JADX INFO: renamed from: e */
    public volatile int f15863e;

    /* JADX INFO: renamed from: c */
    public EGLSurface f15861c = EGL14.EGL_NO_SURFACE;

    /* JADX INFO: renamed from: f */
    public volatile float f15864f = 0.0f;

    /* JADX INFO: renamed from: g */
    public volatile float f15865g = 0.0f;

    /* JADX INFO: renamed from: h */
    public volatile boolean f15866h = false;

    public GlassSurfaceHolder(LiquidGlassTextureView liquidGlassTextureView) {
        this.f15859a = liquidGlassTextureView;
        this.f15862d = Math.max(1, liquidGlassTextureView.getWidth());
        this.f15863e = Math.max(1, liquidGlassTextureView.getHeight());
    }

    /* JADX INFO: renamed from: a */
    public final void m7774a(EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        if (this.f15861c != EGL14.EGL_NO_SURFACE) {
            return;
        }
        if (this.f15860b == null) {
            SurfaceTexture surfaceTexture = this.f15859a.getSurfaceTexture();
            if (surfaceTexture == null) {
                return;
            }
            try {
                this.f15860b = new Surface(surfaceTexture);
            } catch (Throwable unused) {
                this.f15860b = null;
            }
        }
        this.f15861c = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, this.f15860b, new int[]{12344}, 0);
    }
}
