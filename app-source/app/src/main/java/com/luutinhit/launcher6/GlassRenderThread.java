package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Y0 */
/* JADX INFO: loaded from: classes.dex */
public final class GlassRenderThread extends Thread {

    /* JADX INFO: renamed from: j */
    public volatile boolean f16138j = true;

    /* JADX INFO: renamed from: k */
    public Object f16139k = new Object();

    /* JADX INFO: renamed from: l */
    public Runnable f16140l = null;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ LiquidGlassEglTextureView f16141m;

    public GlassRenderThread(LiquidGlassEglTextureView liquidGlassEglTextureView) {
        this.f16141m = liquidGlassEglTextureView;
    }

    /* JADX INFO: renamed from: a */
    public final void m7885a(Runnable runnable) {
        synchronized (this.f16139k) {
            this.f16140l = runnable;
        }
        m7886b();
    }

    /* JADX INFO: renamed from: b */
    public final void m7886b() {
        this.f16141m.f16166S.set(true);
        synchronized (this.f16141m.f16173l) {
            this.f16141m.f16173l.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Runnable runnable;
        try {
            LiquidGlassEglTextureView.initEgl(this.f16141m);
            LiquidGlassEglTextureView.initGlProgram(this.f16141m);
            long jNanoTime = System.nanoTime();
            while (this.f16138j) {
                synchronized (this.f16139k) {
                    try {
                        runnable = this.f16140l;
                        this.f16140l = null;
                    } catch (Throwable th) {
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    this.f16141m.f16165R.set(true);
                }
                if (this.f16141m.f16166S.getAndSet(false)) {
                    LiquidGlassEglTextureView.drawFrame(this.f16141m);
                    jNanoTime = System.nanoTime();
                } else {
                    long jNanoTime2 = 16666667 - (System.nanoTime() - jNanoTime);
                    if (jNanoTime2 > 0) {
                        try {
                            Thread.sleep(Math.min(10L, jNanoTime2 / 1000000));
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        Thread.sleep(1L);
                    }
                }
            }
            try {
                LiquidGlassEglTextureView.releaseEgl(this.f16141m);
            } catch (Throwable unused2) {
            }
        } catch (Throwable th2) {
            try {
                LiquidGlassEglTextureView.releaseEgl(this.f16141m);
            } catch (Throwable unused3) {
            }
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
        }
    }
}
