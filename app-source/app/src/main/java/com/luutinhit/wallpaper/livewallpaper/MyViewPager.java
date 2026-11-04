package com.luutinhit.wallpaper.livewallpaper;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import p069e3.C1978f;

/* JADX INFO: loaded from: classes.dex */
public class MyViewPager extends ViewPager {

    /* JADX INFO: renamed from: p0 */
    public ArgbEvaluator f23559p0;

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23559p0 = new ArgbEvaluator();
        C1978f c1978f = new C1978f(3);
        boolean z5 = this.f22359f0 == null;
        this.f22359f0 = c1978f;
        setChildrenDrawingOrderEnabled(true);
        this.f22361h0 = 2;
        this.f22360g0 = 2;
        if (z5) {
            m3450p();
        }
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager
    /* JADX INFO: renamed from: k */
    public final void mo3445k(int i6, float f6, int i7) {
        if (i6 < 1) {
            getRootView().setBackgroundColor(((Integer) this.f23559p0.evaluate(f6, Integer.valueOf(Color.argb(153, 35, 35, 35)), Integer.valueOf(Color.argb(200, 0, 0, 0)))).intValue());
        } else {
            getRootView().setBackgroundColor(Color.argb(200, 0, 0, 0));
        }
        super.mo3445k(i6, f6, i7);
    }
}
