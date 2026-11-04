package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.F */
/* JADX INFO: loaded from: classes.dex */
public final class CellInfo {

    /* JADX INFO: renamed from: a */
    public View f15556a;

    /* JADX INFO: renamed from: b */
    public int f15557b;

    /* JADX INFO: renamed from: c */
    public int f15558c;

    /* JADX INFO: renamed from: d */
    public int f15559d;

    /* JADX INFO: renamed from: e */
    public int f15560e;

    /* JADX INFO: renamed from: f */
    public long f15561f;

    /* JADX INFO: renamed from: g */
    public long f15562g;

    public CellInfo(View view, ItemInfo itemInfo) {
        this.f15557b = -1;
        this.f15558c = -1;
        this.f15556a = view;
        this.f15557b = itemInfo.cellX;
        this.f15558c = itemInfo.cellY;
        this.f15559d = itemInfo.spanX;
        this.f15560e = itemInfo.spanY;
        this.f15561f = itemInfo.screenId;
        this.f15562g = itemInfo.container;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Cell[view=");
        View view = this.f15556a;
        sb.append(view == null ? "null" : view.getClass());
        sb.append(", x=");
        sb.append(this.f15557b);
        sb.append(", y=");
        return SyntheticHelpers.m7915n(sb, this.f15558c, "]");
    }
}
