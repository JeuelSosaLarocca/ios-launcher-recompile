package com.luutinhit.launcher6;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: renamed from: com.luutinhit.launcher6.K0 */
/* JADX INFO: loaded from: classes.dex */
public final class EglContextFactory implements GLSurfaceView.EGLContextFactory {

    /* JADX INFO: renamed from: a */
    public /* synthetic */ LiquidGlassSurfaceView f15762a;

    public EglContextFactory(LiquidGlassSurfaceView liquidGlassSurfaceView) {
        this.f15762a = liquidGlassSurfaceView;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, this.f15762a.f15795P, 12344});
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
            return;
        }
        egl10.eglGetError();
    }
}
