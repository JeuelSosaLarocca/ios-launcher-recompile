package com.luutinhit.launcher6;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.Vv;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.luutinhit.launcher6.N2 */
/* JADX INFO: loaded from: classes.dex */
public final class MainThreadExecutor extends AbstractExecutorService implements AutoCloseable {

    /* JADX INFO: renamed from: j */
    public Handler mHandler = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j6, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        Vv.m5475z(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
