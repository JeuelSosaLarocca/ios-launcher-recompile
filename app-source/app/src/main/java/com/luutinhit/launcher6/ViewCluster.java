package com.luutinhit.launcher6;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.K */
/* JADX INFO: loaded from: classes.dex */
public final class ViewCluster {

    /* JADX INFO: renamed from: a */
    public ArrayList f15748a;

    /* JADX INFO: renamed from: b */
    public ItemConfiguration f15749b;

    /* JADX INFO: renamed from: c */
    public Rect f15750c = new Rect();

    /* JADX INFO: renamed from: d */
    public int[] f15751d;

    /* JADX INFO: renamed from: e */
    public int[] f15752e;

    /* JADX INFO: renamed from: f */
    public int[] f15753f;

    /* JADX INFO: renamed from: g */
    public int[] f15754g;

    /* JADX INFO: renamed from: h */
    public boolean f15755h;

    /* JADX INFO: renamed from: i */
    public boolean f15756i;

    /* JADX INFO: renamed from: j */
    public boolean f15757j;

    /* JADX INFO: renamed from: k */
    public boolean f15758k;

    /* JADX INFO: renamed from: l */
    public boolean f15759l;

    /* JADX INFO: renamed from: m */
    public PushedViewsComparator f15760m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ CellLayout f15761n;

    public ViewCluster(CellLayout cellLayout, ArrayList arrayList, ItemConfiguration itemConfiguration) {
        this.f15761n = cellLayout;
        int i6 = cellLayout.mCountY;
        this.f15751d = new int[i6];
        this.f15752e = new int[i6];
        int i7 = cellLayout.mCountX;
        this.f15753f = new int[i7];
        this.f15754g = new int[i7];
        this.f15760m = new PushedViewsComparator(this);
        this.f15748a = (ArrayList) arrayList.clone();
        this.f15749b = itemConfiguration;
        m7755c();
    }

    /* JADX INFO: renamed from: a */
    public final void m7753a(int[] iArr, int i6) {
        ArrayList arrayList = this.f15748a;
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            CellAndSpan cellAndSpan = (CellAndSpan) this.f15749b.f15666a.get(arrayList.get(i7));
            if (i6 == 0) {
                int i8 = cellAndSpan.f15518a;
                for (int i9 = cellAndSpan.f15519b; i9 < cellAndSpan.f15519b + cellAndSpan.f15521d; i9++) {
                    int i10 = iArr[i9];
                    if (i8 < i10 || i10 < 0) {
                        iArr[i9] = i8;
                    }
                }
            } else if (i6 == 1) {
                int i11 = cellAndSpan.f15519b;
                for (int i12 = cellAndSpan.f15518a; i12 < cellAndSpan.f15518a + cellAndSpan.f15520c; i12++) {
                    int i13 = iArr[i12];
                    if (i11 < i13 || i13 < 0) {
                        iArr[i12] = i11;
                    }
                }
            } else if (i6 == 2) {
                int i14 = cellAndSpan.f15518a + cellAndSpan.f15520c;
                for (int i15 = cellAndSpan.f15519b; i15 < cellAndSpan.f15519b + cellAndSpan.f15521d; i15++) {
                    if (i14 > iArr[i15]) {
                        iArr[i15] = i14;
                    }
                }
            } else if (i6 == 3) {
                int i16 = cellAndSpan.f15519b + cellAndSpan.f15521d;
                for (int i17 = cellAndSpan.f15518a; i17 < cellAndSpan.f15518a + cellAndSpan.f15520c; i17++) {
                    if (i16 > iArr[i17]) {
                        iArr[i17] = i16;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final Rect m7754b() {
        boolean z5 = this.f15759l;
        Rect rect = this.f15750c;
        if (z5) {
            ArrayList arrayList = this.f15748a;
            int size = arrayList.size();
            boolean z6 = true;
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                CellAndSpan cellAndSpan = (CellAndSpan) this.f15749b.f15666a.get((View) obj);
                if (z6) {
                    int i7 = cellAndSpan.f15518a;
                    int i8 = cellAndSpan.f15519b;
                    rect.set(i7, i8, cellAndSpan.f15520c + i7, cellAndSpan.f15521d + i8);
                    z6 = false;
                } else {
                    int i9 = cellAndSpan.f15518a;
                    int i10 = cellAndSpan.f15519b;
                    rect.union(i9, i10, cellAndSpan.f15520c + i9, cellAndSpan.f15521d + i10);
                }
            }
        }
        return rect;
    }

    /* JADX INFO: renamed from: c */
    public final void m7755c() {
        CellLayout cellLayout;
        int i6 = 0;
        while (true) {
            cellLayout = this.f15761n;
            if (i6 >= cellLayout.mCountX) {
                break;
            }
            this.f15753f[i6] = -1;
            this.f15754g[i6] = -1;
            i6++;
        }
        for (int i7 = 0; i7 < cellLayout.mCountY; i7++) {
            this.f15751d[i7] = -1;
            this.f15752e[i7] = -1;
        }
        this.f15755h = true;
        this.f15756i = true;
        this.f15758k = true;
        this.f15757j = true;
        this.f15759l = true;
    }
}
