package com.luutinhit.launcher6;

import android.graphics.Bitmap;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.R0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BitmapResultCallback implements BitmapCallback, GlassBitmapCallback {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15939j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ View f15940k;

    public /* synthetic */ BitmapResultCallback(int i6, View view) {
        this.f15939j = i6;
        this.f15940k = view;
    }

    @Override // com.luutinhit.launcher6.BitmapCallback, com.luutinhit.launcher6.GlassBitmapCallback
    /* JADX INFO: renamed from: a */
    public final void mo1299a(Bitmap bitmap) {
        switch (this.f15939j) {
            case 0:
                ((RuntimeShaderGlassView) this.f15940k).setFullBitmap(bitmap);
                break;
            default:
                ((LiquidGlassEglTextureView) this.f15940k).setBackgroundBitmap(bitmap);
                break;
        }
    }
}
