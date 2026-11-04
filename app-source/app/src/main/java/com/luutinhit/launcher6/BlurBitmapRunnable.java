package com.luutinhit.launcher6;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.internal.ads.C3856nn;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import java.io.Serializable;
import p116q0.InterfaceC2600c;

/* JADX INFO: renamed from: com.luutinhit.launcher6.u */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BlurBitmapRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16889j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ int f16890k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Object f16891l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ Object f16892m;

    public /* synthetic */ BlurBitmapRunnable(Object obj, int i6, Object obj2, int i7) {
        this.f16889j = i7;
        this.f16891l = obj;
        this.f16890k = i6;
        this.f16892m = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16889j) {
            case 0:
                BlurScreenLayout blurScreenLayout = (BlurScreenLayout) this.f16891l;
                int i6 = this.f16890k;
                Bitmap bitmap = (Bitmap) this.f16892m;
                int i7 = BlurScreenLayout.f15374u;
                blurScreenLayout.getClass();
                if (!BlurScreenLayout.isUsableBitmap(bitmap)) {
                    BlurScreenLayout.recycleBitmap(bitmap);
                    if (i6 == blurScreenLayout.f15384s) {
                        blurScreenLayout.f15385t = false;
                    }
                } else if (i6 == blurScreenLayout.f15384s && blurScreenLayout.f15382q != null) {
                    blurScreenLayout.f15385t = false;
                    blurScreenLayout.f15383r = new BitmapDrawable(blurScreenLayout.getResources(), bitmap);
                    float alpha = (blurScreenLayout.f15382q.isOpeningFloatingMenu() || blurScreenLayout.f15382q.isOpeningFolder()) ? 0.0f : blurScreenLayout.getAlpha();
                    blurScreenLayout.animate().cancel();
                    blurScreenLayout.setAlpha(alpha);
                    blurScreenLayout.setBackground(blurScreenLayout.f15383r);
                    long jRound = Math.round((1.0f - Math.max(0.0f, Math.min(1.0f, alpha))) * 268.0f);
                    if (jRound <= 0) {
                        blurScreenLayout.setAlpha(1.0f);
                    } else {
                        blurScreenLayout.animate().alpha(1.0f).setDuration(jRound).setInterpolator(new DecelerateInterpolator()).start();
                    }
                } else {
                    BlurScreenLayout.recycleBitmap(bitmap);
                }
                break;
            case 1:
                ((IOSLauncher) this.f16891l).lambda$checkHideNavigation$0(this.f16890k, (View) this.f16892m);
                break;
            default:
                ((InterfaceC2600c) ((C3856nn) this.f16891l).f12502l).mo7943c(this.f16890k, (Serializable) this.f16892m);
                break;
        }
    }
}
