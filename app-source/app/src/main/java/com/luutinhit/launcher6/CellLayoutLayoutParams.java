package com.luutinhit.launcher6;

import android.view.ViewGroup;

/* JADX INFO: renamed from: com.luutinhit.launcher6.H */
/* JADX INFO: loaded from: classes.dex */
public final class CellLayoutLayoutParams extends ViewGroup.MarginLayoutParams {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public CellLayoutLayoutParams(android.view.ViewGroup.LayoutParams p0) {
        super(p0);
    }

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public CellLayoutLayoutParams(android.content.Context p0, android.util.AttributeSet p1) {
        super(p0, p1);
    }

    /* JADX INFO: renamed from: a */
    public int f15685a;

    /* JADX INFO: renamed from: b */
    public int f15686b;

    /* JADX INFO: renamed from: c */
    public int f15687c;

    /* JADX INFO: renamed from: d */
    public int f15688d;

    /* JADX INFO: renamed from: e */
    public boolean f15689e;

    /* JADX INFO: renamed from: f */
    public int f15690f;

    /* JADX INFO: renamed from: g */
    public int f15691g;

    /* JADX INFO: renamed from: h */
    public boolean f15692h;

    /* JADX INFO: renamed from: i */
    public boolean f15693i;

    /* JADX INFO: renamed from: j */
    public boolean f15694j;

    /* JADX INFO: renamed from: k */
    public int f15695k;

    /* JADX INFO: renamed from: l */
    public int f15696l;

    /* JADX INFO: renamed from: m */
    public boolean f15697m;

    public CellLayoutLayoutParams(int i6, int i7, int i8, int i9) {
        super(-1, -1);
        this.f15692h = true;
        this.f15693i = false;
        this.f15694j = true;
        this.f15685a = i6;
        this.f15686b = i7;
        this.f15690f = i8;
        this.f15691g = i9;
    }

    /* JADX INFO: renamed from: a */
    public final void m7743a(int i6, int i7, int i8, boolean z5) {
        if (this.f15692h) {
            int i9 = this.f15690f;
            int i10 = this.f15691g;
            boolean z6 = this.f15689e;
            int i11 = z6 ? this.f15687c : this.f15685a;
            int i12 = z6 ? this.f15688d : this.f15686b;
            if (z5) {
                i11 = (i8 - i11) - i9;
            }
            int i13 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            ((ViewGroup.MarginLayoutParams) this).width = ((i9 * i6) - i13) - ((ViewGroup.MarginLayoutParams) this).rightMargin;
            int i14 = ((ViewGroup.MarginLayoutParams) this).topMargin;
            ((ViewGroup.MarginLayoutParams) this).height = ((i10 * i7) - i14) - ((ViewGroup.MarginLayoutParams) this).bottomMargin;
            this.f15695k = (i6 * i11) + i13;
            this.f15696l = (i7 * i12) + i14;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.f15685a);
        sb.append(", ");
        return SyntheticHelpers.m7915n(sb, this.f15686b, ")");
    }
}
