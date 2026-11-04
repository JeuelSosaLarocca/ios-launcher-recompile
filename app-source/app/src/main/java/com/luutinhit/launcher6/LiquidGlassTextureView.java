package com.luutinhit.launcher6;

import B3.RunnableC0054W;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Q0 */
/* JADX INFO: loaded from: classes.dex */
public final class LiquidGlassTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: j */
    public LiquidGlassRenderer f15932j;

    public LiquidGlassTextureView(Context context) {
        super(context, null, 0);
        LiquidGlassRenderer liquidGlassRenderer = LiquidGlassRenderer.getInstance(context);
        this.f15932j = liquidGlassRenderer;
        setSurfaceTextureListener(this);
        setOpaque(false);
        liquidGlassRenderer.getClass();
        GlassSurfaceHolder glassSurfaceHolder = new GlassSurfaceHolder(this);
        if (((GlassSurfaceHolder) liquidGlassRenderer.f15897v.put(this, glassSurfaceHolder)) == null) {
            liquidGlassRenderer.queueEvent(new RunnableC0054W(17, liquidGlassRenderer, glassSurfaceHolder));
        }
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LiquidGlassRenderer liquidGlassRenderer = this.f15932j;
        if (liquidGlassRenderer.f15897v.containsKey(this)) {
            return;
        }
        GlassSurfaceHolder glassSurfaceHolder = new GlassSurfaceHolder(this);
        if (((GlassSurfaceHolder) liquidGlassRenderer.f15897v.put(this, glassSurfaceHolder)) == null) {
            liquidGlassRenderer.queueEvent(new RunnableC0054W(17, liquidGlassRenderer, glassSurfaceHolder));
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        LiquidGlassRenderer liquidGlassRenderer = this.f15932j;
        GlassSurfaceHolder glassSurfaceHolder = (GlassSurfaceHolder) liquidGlassRenderer.f15897v.remove(this);
        if (glassSurfaceHolder != null) {
            liquidGlassRenderer.queueEvent(new MergedIdleRunnable(3, glassSurfaceHolder));
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
        GlassSurfaceHolder glassSurfaceHolder = (GlassSurfaceHolder) this.f15932j.f15897v.get(this);
        if (glassSurfaceHolder == null) {
            return;
        }
        glassSurfaceHolder.f15862d = Math.max(1, i6);
        glassSurfaceHolder.f15863e = Math.max(1, i7);
        glassSurfaceHolder.f15866h = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        GlassSurfaceHolder glassSurfaceHolder = (GlassSurfaceHolder) this.f15932j.f15897v.get(this);
        if (glassSurfaceHolder == null) {
            return;
        }
        glassSurfaceHolder.f15862d = Math.max(1, i6);
        glassSurfaceHolder.f15863e = Math.max(1, i7);
        glassSurfaceHolder.f15866h = true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setFullBitmap(Bitmap bitmap) {
        LiquidGlassRenderer liquidGlassRenderer = this.f15932j;
        liquidGlassRenderer.getClass();
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        liquidGlassRenderer.queueEvent(new GlassBitmapUploadRunnable(liquidGlassRenderer, bitmap, 1));
    }

    public void setSdfTexture(int i6) {
        this.f15932j.setMaskResource(i6);
    }
}
