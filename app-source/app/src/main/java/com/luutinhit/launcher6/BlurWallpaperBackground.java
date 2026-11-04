package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import p118q3.C2615e;
import p118q3.InterfaceC2614d;

/* JADX INFO: loaded from: classes.dex */
public class BlurWallpaperBackground extends AppCompatImageView implements InterfaceC2614d, Insettable {

    /* JADX INFO: renamed from: m */
    public C2615e f15386m;

    public BlurWallpaperBackground(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setLayerType(2, null);
        setAlpha(0.0f);
        setWillNotDraw(false);
        if (context instanceof Launcher) {
            C2615e blurWallpaperProvider = ((Launcher) context).getBlurWallpaperProvider();
            this.f15386m = blurWallpaperProvider;
            blurWallpaperProvider.m9546b(this);
        }
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: a */
    public final void mo7593a() {
        setImageBitmap(this.f15386m.f20555e);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
    }

    public void setUseTransparency(boolean z5) {
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: q */
    public final void mo7594q() {
    }
}
