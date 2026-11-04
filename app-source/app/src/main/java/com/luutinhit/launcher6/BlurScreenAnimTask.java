package com.luutinhit.launcher6;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.s */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BlurScreenAnimTask {


    /* JADX INFO: renamed from: a */
    public /* synthetic */ BlurScreenLayout f16850a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ int f16851b;

    /* JADX INFO: renamed from: c */
    public /* synthetic */ Bitmap f16852c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ int f16853d;

    /* JADX INFO: renamed from: e */
    public /* synthetic */ boolean f16854e;

    /* JADX INFO: renamed from: f */
    public /* synthetic */ BlurScreenAnimParams f16855f;

    /* JADX INFO: renamed from: g */
    public /* synthetic */ DragLayer f16856g;

    public /* synthetic */ BlurScreenAnimTask(BlurScreenLayout blurScreenLayout, int i6, Bitmap bitmap, int i7, boolean z5, BlurScreenAnimParams blurScreenAnimParams, DragLayer dragLayer) {
        this.f16850a = blurScreenLayout;
        this.f16851b = i6;
        this.f16852c = bitmap;
        this.f16853d = i7;
        this.f16854e = z5;
        this.f16855f = blurScreenAnimParams;
        this.f16856g = dragLayer;
    }

    /* JADX INFO: renamed from: a */
    public final void m8183a(boolean z5) {
        BlurScreenLayout blurScreenLayout = this.f16850a;
        int i6 = this.f16851b;
        Bitmap bitmap = this.f16852c;
        int i7 = this.f16853d;
        boolean z6 = this.f16854e;
        BlurScreenAnimParams blurScreenAnimParams = this.f16855f;
        DragLayer dragLayer = this.f16856g;
        if (i6 != blurScreenLayout.f15384s) {
            BlurScreenLayout.recycleBitmap(bitmap);
        } else if (z5) {
            blurScreenLayout.prepareBlurFrames(i6, i7, z6, new MergedItemCallbacks(0, bitmap), blurScreenAnimParams);
        } else {
            BlurScreenLayout.recycleBitmap(bitmap);
            blurScreenLayout.captureScreen(dragLayer, i6, i7, blurScreenAnimParams, z6);
        }
    }
}
