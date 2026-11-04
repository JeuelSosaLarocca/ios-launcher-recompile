package com.luutinhit.launcher6;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Choreographer;
import java.util.Iterator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.N0 */
/* JADX INFO: loaded from: classes.dex */
public final class GlassRenderFrameCallback implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ LiquidGlassRenderer f15853j;

    public GlassRenderFrameCallback(LiquidGlassRenderer liquidGlassRenderer) {
        this.f15853j = liquidGlassRenderer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j6) {
        Iterator it = this.f15853j.f15897v.values().iterator();
        while (it.hasNext()) {
            if (((GlassSurfaceHolder) it.next()).f15866h) {
                LiquidGlassRenderer liquidGlassRenderer = this.f15853j;
                synchronized (liquidGlassRenderer.f15896u) {
                    while (true) {
                        Runnable runnable = (Runnable) liquidGlassRenderer.f15896u.pollFirst();
                        if (runnable == null) {
                            break;
                        } else {
                            runnable.run();
                        }
                    }
                }
                for (GlassSurfaceHolder glassSurfaceHolder : (GlassSurfaceHolder[]) liquidGlassRenderer.f15897v.values().toArray(new GlassSurfaceHolder[0])) {
                    try {
                        glassSurfaceHolder.m7774a(liquidGlassRenderer.f15877b, liquidGlassRenderer.f15879d);
                        if (glassSurfaceHolder.f15861c != EGL14.EGL_NO_SURFACE && glassSurfaceHolder.f15866h) {
                            glassSurfaceHolder.f15866h = false;
                            EGLDisplay eGLDisplay = liquidGlassRenderer.f15877b;
                            EGLSurface eGLSurface = glassSurfaceHolder.f15861c;
                            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, liquidGlassRenderer.f15878c)) {
                                if (liquidGlassRenderer.f15900y) {
                                    if (glassSurfaceHolder.f15862d != liquidGlassRenderer.f15898w || glassSurfaceHolder.f15863e != liquidGlassRenderer.f15899x) {
                                        GLES20.glViewport(0, 0, glassSurfaceHolder.f15862d, glassSurfaceHolder.f15863e);
                                        liquidGlassRenderer.f15898w = glassSurfaceHolder.f15862d;
                                        liquidGlassRenderer.f15899x = glassSurfaceHolder.f15863e;
                                    }
                                    GLES20.glClear(16384);
                                    if (liquidGlassRenderer.f15882g != 0) {
                                        GLES20.glActiveTexture(33984);
                                        GLES20.glBindTexture(3553, liquidGlassRenderer.f15882g);
                                    }
                                    if (liquidGlassRenderer.f15883h != 0) {
                                        GLES20.glActiveTexture(33985);
                                        GLES20.glBindTexture(3553, liquidGlassRenderer.f15883h);
                                    }
                                    int i6 = liquidGlassRenderer.f15884i;
                                    if (i6 != -1) {
                                        GLES20.glUniform2f(i6, glassSurfaceHolder.f15862d, glassSurfaceHolder.f15863e);
                                    }
                                    int i7 = liquidGlassRenderer.f15885j;
                                    if (i7 != -1) {
                                        GLES20.glUniform1f(i7, Math.min(glassSurfaceHolder.f15862d, glassSurfaceHolder.f15863e) * 0.13f);
                                    }
                                    int i8 = liquidGlassRenderer.f15890o;
                                    if (i8 != -1) {
                                        GLES20.glUniform2f(i8, glassSurfaceHolder.f15864f, glassSurfaceHolder.f15865g);
                                    }
                                    GLES20.glDrawArrays(5, 0, 4);
                                } else {
                                    if (glassSurfaceHolder.f15862d != liquidGlassRenderer.f15898w || glassSurfaceHolder.f15863e != liquidGlassRenderer.f15899x) {
                                        GLES20.glViewport(0, 0, glassSurfaceHolder.f15862d, glassSurfaceHolder.f15863e);
                                        liquidGlassRenderer.f15898w = glassSurfaceHolder.f15862d;
                                        liquidGlassRenderer.f15899x = glassSurfaceHolder.f15863e;
                                    }
                                    GLES20.glClear(16384);
                                    if (liquidGlassRenderer.f15882g != 0) {
                                        GLES20.glActiveTexture(33984);
                                        GLES20.glBindTexture(3553, liquidGlassRenderer.f15882g);
                                    }
                                    if (liquidGlassRenderer.f15883h != 0) {
                                        GLES20.glActiveTexture(33985);
                                        GLES20.glBindTexture(3553, liquidGlassRenderer.f15883h);
                                    }
                                    int i9 = liquidGlassRenderer.f15884i;
                                    if (i9 != -1) {
                                        GLES20.glUniform2f(i9, glassSurfaceHolder.f15862d, glassSurfaceHolder.f15863e);
                                    }
                                    int i10 = liquidGlassRenderer.f15885j;
                                    if (i10 != -1) {
                                        GLES20.glUniform1f(i10, Math.min(glassSurfaceHolder.f15862d, glassSurfaceHolder.f15863e) * 0.13f);
                                    }
                                    int i11 = liquidGlassRenderer.f15890o;
                                    if (i11 != -1) {
                                        GLES20.glUniform2f(i11, glassSurfaceHolder.f15864f, glassSurfaceHolder.f15865g);
                                    }
                                    GLES20.glDrawArrays(5, 0, 4);
                                }
                                EGL14.eglSwapBuffers(liquidGlassRenderer.f15877b, glassSurfaceHolder.f15861c);
                            } else {
                                EGL14.eglGetError();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                EGLDisplay eGLDisplay2 = liquidGlassRenderer.f15877b;
                EGLSurface eGLSurface2 = liquidGlassRenderer.f15880e;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, liquidGlassRenderer.f15878c);
                break;
            }
        }
        Choreographer.getInstance().postFrameCallback(this);
    }
}
