package com.luutinhit.launcher6.util;

import B3.C0049Q;
import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class SpeedLinearLayoutManager extends LinearLayoutManager {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public SpeedLinearLayoutManager(int p0) {
        super(p0);
    }
    public SpeedLinearLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, p124s0.AbstractC2705T
    public final void A0(RecyclerView recyclerView, int i6) {
        C0049Q c0049q = new C0049Q(recyclerView.getContext(), 0);
        c0049q.f20751a = i6;
        B0(c0049q);
    }
}
