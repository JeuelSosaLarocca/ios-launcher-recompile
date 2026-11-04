package com.luutinhit.launcher6;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.M0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GlassBitmapUploadRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15847j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LiquidGlassRenderer f15848k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Bitmap f15849l;

    public /* synthetic */ GlassBitmapUploadRunnable(LiquidGlassRenderer liquidGlassRenderer, Bitmap bitmap, int i6) {
        this.f15847j = i6;
        this.f15848k = liquidGlassRenderer;
        this.f15849l = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15847j) {
            case 0:
                LiquidGlassRenderer liquidGlassRenderer = this.f15848k;
                int i6 = liquidGlassRenderer.f15883h;
                Bitmap bitmap = this.f15849l;
                liquidGlassRenderer.f15883h = liquidGlassRenderer.uploadTexture(i6, bitmap);
                try {
                    bitmap.recycle();
                } catch (Throwable unused) {
                    return;
                }
                break;
            default:
                LiquidGlassRenderer liquidGlassRenderer2 = this.f15848k;
                liquidGlassRenderer2.f15882g = liquidGlassRenderer2.uploadTexture(liquidGlassRenderer2.f15882g, this.f15849l);
                break;
        }
    }
}
