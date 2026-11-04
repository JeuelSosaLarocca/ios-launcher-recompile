package com.luutinhit.launcher6;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.S0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PixelCopyResultListener implements PixelCopy.OnPixelCopyFinishedListener {



    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f15941a = 0;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Bitmap f15942b;

    /* JADX INFO: renamed from: c */
    public /* synthetic */ DragLayer f15943c;

    /* JADX INFO: renamed from: d */
    public /* synthetic */ View f15944d;

    /* JADX INFO: renamed from: e */
    public /* synthetic */ Object f15945e;

    public /* synthetic */ PixelCopyResultListener(RuntimeShaderGlassView runtimeShaderGlassView, Bitmap bitmap, BitmapCallback bitmapCallback, DragLayer dragLayer) {
        this.f15944d = runtimeShaderGlassView;
        this.f15942b = bitmap;
        this.f15945e = bitmapCallback;
        this.f15943c = dragLayer;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int i6) {
        switch (this.f15941a) {
            case 0:
                RuntimeShaderGlassView runtimeShaderGlassView = (RuntimeShaderGlassView) this.f15944d;
                Bitmap bitmap = this.f15942b;
                BitmapCallback bitmapCallback = (BitmapCallback) this.f15945e;
                DragLayer dragLayer = this.f15943c;
                if (i6 != 0) {
                    runtimeShaderGlassView.getClass();
                    RuntimeShaderGlassView.captureBackground(dragLayer, bitmapCallback);
                } else {
                    runtimeShaderGlassView.getClass();
                    bitmap.getWidth();
                    bitmap.getHeight();
                    bitmapCallback.mo1299a(bitmap);
                }
                break;
            default:
                LiquidGlassEglTextureView liquidGlassEglTextureView = (LiquidGlassEglTextureView) this.f15944d;
                GlassBitmapCallback glassBitmapCallback = (GlassBitmapCallback) this.f15945e;
                Bitmap bitmap2 = this.f15942b;
                DragLayer dragLayer2 = this.f15943c;
                if (i6 != 0) {
                    liquidGlassEglTextureView.getClass();
                    LiquidGlassEglTextureView.captureBackground(dragLayer2, glassBitmapCallback);
                } else {
                    liquidGlassEglTextureView.getClass();
                    glassBitmapCallback.mo1299a(bitmap2);
                }
                break;
        }
    }

    public /* synthetic */ PixelCopyResultListener(LiquidGlassEglTextureView liquidGlassEglTextureView, GlassBitmapCallback glassBitmapCallback, Bitmap bitmap, DragLayer dragLayer) {
        this.f15944d = liquidGlassEglTextureView;
        this.f15945e = glassBitmapCallback;
        this.f15942b = bitmap;
        this.f15943c = dragLayer;
    }
}
