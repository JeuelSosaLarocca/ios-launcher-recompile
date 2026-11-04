package com.luutinhit.launcher6.leftpage.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import p124s0.b0;
import p124s0.h0;

/* JADX INFO: loaded from: classes.dex */
public class WrapStaggeredGridLayoutManager extends StaggeredGridLayoutManager {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public WrapStaggeredGridLayoutManager() {
        super();
    }
    public WrapStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, p124s0.AbstractC2705T
    public final void d0(b0 b0Var, h0 h0Var) {
        try {
            U0(b0Var, h0Var, true);
        } catch (Throwable unused) {
        }
    }
}
