package com.luutinhit.launcher6.util;

import B3.C0047O;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class RoundedImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: m */
    public float f17000m;

    /* JADX INFO: renamed from: n */
    public float f17001n;

    /* JADX INFO: renamed from: o */
    public float f17002o;

    /* JADX INFO: renamed from: p */
    public float f17003p;

    /* JADX INFO: renamed from: q */
    public float f17004q;

    /* JADX INFO: renamed from: r */
    public C0047O f17005r;

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f17001n = 0.0f;
        this.f17002o = 0.0f;
        this.f17003p = 400.0f;
        this.f17004q = 400.0f;
        this.f17005r = new C0047O(0, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2259w, 0, 0);
        this.f17000m = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, getResources().getDimensionPixelSize(R.dimen.small_icon_round_corner));
        typedArrayObtainStyledAttributes.recycle();
        setClipToOutline(true);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        float f6 = i6;
        this.f17001n = (f6 * 1.0f) / 2.0f;
        float f7 = i7;
        this.f17002o = (1.0f * f7) / 2.0f;
        this.f17003p = f6;
        this.f17004q = f7;
        if (getClipToOutline()) {
            setOutlineProvider(this.f17005r);
        }
    }
}
