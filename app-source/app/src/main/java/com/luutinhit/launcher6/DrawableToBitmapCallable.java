package com.luutinhit.launcher6;

import android.graphics.drawable.Drawable;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.luutinhit.launcher6.o3 */
/* JADX INFO: loaded from: classes.dex */
public final class DrawableToBitmapCallable implements Callable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Drawable f16801j;

    public DrawableToBitmapCallable(Drawable drawable) {
        this.f16801j = drawable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f16801j.mutate();
    }
}
