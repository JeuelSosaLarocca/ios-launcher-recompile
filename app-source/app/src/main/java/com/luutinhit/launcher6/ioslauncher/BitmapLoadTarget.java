package com.luutinhit.launcher6.ioslauncher;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import p138v1.InterfaceC2854c;
import u1.AbstractC2815b;

/* JADX INFO: renamed from: com.luutinhit.launcher6.ioslauncher.e */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapLoadTarget extends AbstractC2815b {


    /* JADX INFO: renamed from: m */
    public /* synthetic */ int f16587m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ Activity f16588n;

    public /* synthetic */ BitmapLoadTarget(Activity activity, int i6) {
        this.f16587m = i6;
        this.f16588n = activity;
    }

    @Override // u1.InterfaceC2820g
    /* JADX INFO: renamed from: d */
    public final void mo1301d(Object obj, InterfaceC2854c interfaceC2854c) {
        switch (this.f16587m) {
            case 0:
                Bitmap bitmap = (Bitmap) obj;
                bitmap.getWidth();
                bitmap.getHeight();
                ((IOSLauncher) this.f16588n).setWallpaperFromBitmap(bitmap);
                break;
            case 1:
                Bitmap bitmap2 = (Bitmap) obj;
                bitmap2.getWidth();
                bitmap2.getHeight();
                IOSLauncher iOSLauncher = (IOSLauncher) this.f16588n;
                iOSLauncher.setWallpaperFromBitmap(bitmap2);
                iOSLauncher.saveToInternalStorage("wallpaper", bitmap2);
                break;
            default:
                Bitmap bitmap3 = (Bitmap) obj;
                try {
                    bitmap3.getWidth();
                    bitmap3.getHeight();
                    IconChangeActivity iconChangeActivity = (IconChangeActivity) this.f16588n;
                    iconChangeActivity.f17372J.setImageBitmap(Utilities.m8164p(iconChangeActivity.f17366D, bitmap3));
                } catch (Throwable th) {
                    th.getMessage();
                }
                break;
        }
    }

    @Override // u1.InterfaceC2820g
    /* JADX INFO: renamed from: i */
    public final void mo1826i(Drawable drawable) {
        int i6 = this.f16587m;
    }

    /* JADX INFO: renamed from: k */
    public final void m8075k(Drawable drawable) {
    }

    /* JADX INFO: renamed from: l */
    public final void m8076l(Drawable drawable) {
    }

    /* JADX INFO: renamed from: m */
    public final void m8077m(Drawable drawable) {
    }
}
