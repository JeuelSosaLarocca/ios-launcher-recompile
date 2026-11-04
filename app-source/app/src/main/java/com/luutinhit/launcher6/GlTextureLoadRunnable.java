package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLES30;

/* JADX INFO: renamed from: com.luutinhit.launcher6.I0 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GlTextureLoadRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15729j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LiquidGlassSurfaceView f15730k;

    public /* synthetic */ GlTextureLoadRunnable(LiquidGlassSurfaceView liquidGlassSurfaceView, int i6) {
        this.f15729j = i6;
        this.f15730k = liquidGlassSurfaceView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15729j) {
            case 0:
                this.f15730k.requestRender();
                break;
            case 1:
                LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15730k;
                int i6 = liquidGlassSurfaceView.f15810q;
                int i7 = 1;
                if (i6 != 0) {
                    int[] iArr = liquidGlassSurfaceView.f15799T;
                    iArr[0] = i6;
                    if (liquidGlassSurfaceView.f15795P == 3) {
                        GLES20.glDeleteTextures(1, iArr, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr, 0);
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Context context = liquidGlassSurfaceView.f15803j;
                BitmapFactory.decodeResource(context.getResources(), liquidGlassSurfaceView.f15789J, options);
                int i8 = options.outWidth;
                int i9 = options.outHeight;
                int i10 = liquidGlassSurfaceView.f15807n;
                int i11 = liquidGlassSurfaceView.f15808o;
                if (i9 > i11 || i8 > i10) {
                    int i12 = i9 / 2;
                    int i13 = i8 / 2;
                    while (i12 / i7 >= i11 && i13 / i7 >= i10) {
                        i7 *= 2;
                    }
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = i7;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                try {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), liquidGlassSurfaceView.f15789J, options);
                    if (bitmapDecodeResource != null) {
                        liquidGlassSurfaceView.f15810q = liquidGlassSurfaceView.loadTexture(bitmapDecodeResource);
                    }
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 2:
                LiquidGlassSurfaceView liquidGlassSurfaceView2 = this.f15730k;
                if (liquidGlassSurfaceView2.f15795P == 3) {
                    int i14 = liquidGlassSurfaceView2.f15798S;
                    if (i14 != 0) {
                        int[] iArr2 = liquidGlassSurfaceView2.f15799T;
                        iArr2[0] = i14;
                        GLES30.glDeleteVertexArrays(1, iArr2, 0);
                        liquidGlassSurfaceView2.f15798S = 0;
                    }
                    int i15 = liquidGlassSurfaceView2.f15796Q;
                    if (i15 != 0) {
                        int[] iArr3 = liquidGlassSurfaceView2.f15799T;
                        iArr3[0] = i15;
                        GLES20.glDeleteBuffers(1, iArr3, 0);
                        liquidGlassSurfaceView2.f15796Q = 0;
                    }
                    int i16 = liquidGlassSurfaceView2.f15797R;
                    if (i16 != 0) {
                        int[] iArr4 = liquidGlassSurfaceView2.f15799T;
                        iArr4[0] = i16;
                        GLES20.glDeleteBuffers(1, iArr4, 0);
                        liquidGlassSurfaceView2.f15797R = 0;
                    }
                } else {
                    int i17 = liquidGlassSurfaceView2.f15796Q;
                    if (i17 != 0) {
                        int[] iArr5 = liquidGlassSurfaceView2.f15799T;
                        iArr5[0] = i17;
                        GLES20.glDeleteBuffers(1, iArr5, 0);
                        liquidGlassSurfaceView2.f15796Q = 0;
                    }
                    int i18 = liquidGlassSurfaceView2.f15797R;
                    if (i18 != 0) {
                        int[] iArr6 = liquidGlassSurfaceView2.f15799T;
                        iArr6[0] = i18;
                        GLES20.glDeleteBuffers(1, iArr6, 0);
                        liquidGlassSurfaceView2.f15797R = 0;
                    }
                }
                int i19 = liquidGlassSurfaceView2.f15809p;
                if (i19 != 0) {
                    int[] iArr7 = liquidGlassSurfaceView2.f15799T;
                    iArr7[0] = i19;
                    if (liquidGlassSurfaceView2.f15795P == 3) {
                        GLES20.glDeleteTextures(1, iArr7, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr7, 0);
                    }
                    liquidGlassSurfaceView2.f15809p = 0;
                    liquidGlassSurfaceView2.f15812s = -1;
                }
                int i20 = liquidGlassSurfaceView2.f15810q;
                if (i20 != 0) {
                    int[] iArr8 = liquidGlassSurfaceView2.f15799T;
                    iArr8[0] = i20;
                    if (liquidGlassSurfaceView2.f15795P == 3) {
                        GLES20.glDeleteTextures(1, iArr8, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr8, 0);
                    }
                    liquidGlassSurfaceView2.f15810q = 0;
                    liquidGlassSurfaceView2.f15813t = -1;
                }
                int i21 = liquidGlassSurfaceView2.f15811r;
                if (i21 != 0) {
                    if (liquidGlassSurfaceView2.f15795P == 3) {
                        GLES20.glDeleteProgram(i21);
                    } else {
                        GLES20.glDeleteProgram(i21);
                    }
                    liquidGlassSurfaceView2.f15811r = 0;
                    liquidGlassSurfaceView2.f15814u = -1;
                }
                break;
            case 3:
                LiquidGlassSurfaceView liquidGlassSurfaceView3 = this.f15730k;
                int i22 = liquidGlassSurfaceView3.f15809p;
                if (i22 != 0) {
                    int[] iArr9 = liquidGlassSurfaceView3.f15799T;
                    iArr9[0] = i22;
                    if (liquidGlassSurfaceView3.f15795P == 3) {
                        GLES20.glDeleteTextures(1, iArr9, 0);
                    } else {
                        GLES20.glDeleteTextures(1, iArr9, 0);
                    }
                }
                liquidGlassSurfaceView3.f15809p = liquidGlassSurfaceView3.loadTexture(liquidGlassSurfaceView3.f15804k);
                int i23 = liquidGlassSurfaceView3.f15789J;
                if (i23 != 0) {
                    liquidGlassSurfaceView3.setSdfTexture(i23);
                }
                liquidGlassSurfaceView3.post(new GlTextureLoadRunnable(liquidGlassSurfaceView3, 4));
                break;
            default:
                LiquidGlassSurfaceView liquidGlassSurfaceView4 = this.f15730k;
                if (liquidGlassSurfaceView4.isAttachedToWindow() && liquidGlassSurfaceView4.getVisibility() == 0) {
                    liquidGlassSurfaceView4.requestRender();
                    break;
                }
                break;
        }
    }
}
