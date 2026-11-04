package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.luutinhit.launcher6.g1 */
/* JADX INFO: loaded from: classes.dex */
public class InsertAbleFrameLayoutParams extends FrameLayout.LayoutParams {

    /* JADX INFO: renamed from: a */
    public boolean f16530a;

    public InsertAbleFrameLayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16530a = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2249m);
        this.f16530a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public InsertAbleFrameLayoutParams(int i6, int i7) {
        super(i6, i7);
        this.f16530a = false;
    }

    public InsertAbleFrameLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f16530a = false;
    }
}
