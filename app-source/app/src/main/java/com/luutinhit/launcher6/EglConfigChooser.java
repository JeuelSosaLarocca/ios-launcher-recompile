package com.luutinhit.launcher6;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: renamed from: com.luutinhit.launcher6.J0 */
/* JADX INFO: loaded from: classes.dex */
public final class EglConfigChooser implements GLSurfaceView.EGLConfigChooser {

    /* JADX INFO: renamed from: a */
    public /* synthetic */ LiquidGlassSurfaceView f15739a;

    public EglConfigChooser(LiquidGlassSurfaceView liquidGlassSurfaceView) {
        this.f15739a = liquidGlassSurfaceView;
    }

    @Override // android.opengl.GLSurfaceView.EGLConfigChooser
    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 64, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, eGLConfigArr, 1, iArr);
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15739a;
        if (zEglChooseConfig && iArr[0] > 0) {
            liquidGlassSurfaceView.f15795P = 3;
            return eGLConfigArr[0];
        }
        if (egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, eGLConfigArr, 1, iArr) && iArr[0] > 0) {
            liquidGlassSurfaceView.f15795P = 2;
            return eGLConfigArr[0];
        }
        if (!egl10.eglChooseConfig(eGLDisplay, new int[]{12352, 4, 12321, 1, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) {
            throw new IllegalArgumentException("No EGLConfig chosen.");
        }
        liquidGlassSurfaceView.f15795P = 2;
        return eGLConfigArr[0];
    }
}
