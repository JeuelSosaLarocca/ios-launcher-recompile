package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.view.Choreographer;

/* JADX INFO: renamed from: com.luutinhit.launcher6.v0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderGlassFrameCallback implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ ObjectAnimator f17008j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Folder f17009k;

    public FolderGlassFrameCallback(Folder folder, ObjectAnimator objectAnimator) {
        this.f17009k = folder;
        this.f17008j = objectAnimator;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j6) {
        if (this.f17008j.isRunning()) {
            float fFloatValue = ((Float) this.f17008j.getAnimatedValue("scaleX")).floatValue();
            float fFloatValue2 = ((Float) this.f17008j.getAnimatedValue("scaleY")).floatValue();
            Folder folder = this.f17009k;
            LiquidGlassEglTextureView liquidGlassEglTextureView = folder.f15634w;
            if (liquidGlassEglTextureView != null) {
                if (liquidGlassEglTextureView.f16185x > 0 && liquidGlassEglTextureView.f16186y > 0) {
                    liquidGlassEglTextureView.f16187z = liquidGlassEglTextureView.f16185x * fFloatValue;
                    liquidGlassEglTextureView.f16148A = liquidGlassEglTextureView.f16186y * fFloatValue2;
                    liquidGlassEglTextureView.getLocationInWindow(liquidGlassEglTextureView.f23468c0);
                    int i6 = liquidGlassEglTextureView.f23466a0;
                    int[] iArr = liquidGlassEglTextureView.f23468c0;
                    if (i6 != iArr[0] || liquidGlassEglTextureView.f23467b0 != iArr[1] || liquidGlassEglTextureView.f16152E.width() != liquidGlassEglTextureView.f16187z || liquidGlassEglTextureView.f16152E.height() != liquidGlassEglTextureView.f16148A) {
                        int[] iArr2 = liquidGlassEglTextureView.f23468c0;
                        int i7 = iArr2[0];
                        liquidGlassEglTextureView.f23466a0 = i7;
                        int i8 = iArr2[1];
                        liquidGlassEglTextureView.f23467b0 = i8;
                        float f6 = i7;
                        liquidGlassEglTextureView.f16152E.set(f6, i8, liquidGlassEglTextureView.f16187z + f6, liquidGlassEglTextureView.f23467b0 + liquidGlassEglTextureView.f16148A);
                        liquidGlassEglTextureView.f16165R.set(true);
                        liquidGlassEglTextureView.updateViewRect();
                    }
                }
            } else if (folder.f15635x != null && (Math.abs(fFloatValue - folder.f15636y) > 0.001f || Math.abs(fFloatValue2 - this.f17009k.f15637z) > 0.001f)) {
                Folder folder2 = this.f17009k;
                folder2.f15636y = fFloatValue;
                folder2.f15637z = fFloatValue2;
                int[] iArr3 = new int[2];
                folder2.f15635x.getLocationInWindow(iArr3);
                if (Math.abs(this.f17009k.f15598A[0] - iArr3[0]) > 0.1f || Math.abs(this.f17009k.f15598A[1] - iArr3[1]) > 0.1f) {
                    Folder folder3 = this.f17009k;
                    int[] iArr4 = folder3.f15598A;
                    iArr4[0] = iArr3[0];
                    iArr4[1] = iArr3[1];
                    RuntimeShaderGlassView runtimeShaderGlassView = folder3.f15635x;
                    float f7 = iArr3[0];
                    float f8 = iArr3[1];
                    runtimeShaderGlassView.f16028k.setFloatUniform("u_Scale", fFloatValue, fFloatValue2);
                    runtimeShaderGlassView.f16028k.setFloatUniform("u_GlViewPosition", f7, f8);
                    runtimeShaderGlassView.invalidate();
                }
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }
}
