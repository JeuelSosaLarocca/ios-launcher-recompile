package com.luutinhit.launcher6;

import com.luutinhit.launcher6.appslibrary.AppsLibraryView;
import com.luutinhit.launcher6.appslibrary.MergedCallbacks;
import p131t3.ViewOnClickListenerC2791d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.q */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BlurAnimRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16823j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ float f16824k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Object f16825l;

    public /* synthetic */ BlurAnimRunnable(Object obj, float f6, int i6) {
        this.f16823j = i6;
        this.f16825l = obj;
        this.f16824k = f6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16823j) {
            case 0:
                int i6 = BlurScreenLayout.f15374u;
                BlurScreenLayout blurScreenLayout = (BlurScreenLayout) this.f16825l;
                blurScreenLayout.getClass();
                float fMax = Math.max(0.0f, Math.min(1.0f, this.f16824k));
                blurScreenLayout.animate().cancel();
                if (fMax == 0.0f) {
                    blurScreenLayout.f15384s++;
                    blurScreenLayout.f15385t = false;
                    blurScreenLayout.f15376k.removeCallbacksAndMessages(null);
                    blurScreenLayout.animate().cancel();
                    blurScreenLayout.f15383r = null;
                    blurScreenLayout.setBackground(null);
                    break;
                } else {
                    blurScreenLayout.setAlpha(fMax);
                    if (blurScreenLayout.getBackground() == null && !blurScreenLayout.f15385t && blurScreenLayout.f15382q != null) {
                        blurScreenLayout.startBlurTransition(0, null);
                        break;
                    }
                }
                break;
            case 1:
                MergedCallbacks mergedCallbacks = (MergedCallbacks) this.f16825l;
                mergedCallbacks.getClass();
                float fAbs = Math.abs(this.f16824k);
                AppsLibraryView appsLibraryView = (AppsLibraryView) mergedCallbacks.f16286k;
                float interpolation = fAbs / appsLibraryView.f16289j.screenWidth;
                try {
                    interpolation = appsLibraryView.f16305z.getInterpolation(interpolation);
                } catch (Throwable th) {
                    th.getMessage();
                }
                appsLibraryView.f16289j.showBlurWallpaperBackground(interpolation);
                break;
            default:
                MergedCallbacks mergedCallbacks2 = (MergedCallbacks) this.f16825l;
                mergedCallbacks2.getClass();
                float fAbs2 = Math.abs(this.f16824k);
                ViewOnClickListenerC2791d viewOnClickListenerC2791d = (ViewOnClickListenerC2791d) mergedCallbacks2.f16286k;
                float interpolation2 = fAbs2 / viewOnClickListenerC2791d.f21273j.screenWidth;
                try {
                    interpolation2 = viewOnClickListenerC2791d.f21288y.getInterpolation(interpolation2);
                } catch (Throwable th2) {
                    th2.getMessage();
                }
                viewOnClickListenerC2791d.f21273j.showBlurWallpaperBackground(interpolation2);
                break;
        }
    }
}
