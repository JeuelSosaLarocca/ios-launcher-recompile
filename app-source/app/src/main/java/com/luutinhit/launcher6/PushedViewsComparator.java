package com.luutinhit.launcher6;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.J */
/* JADX INFO: loaded from: classes.dex */
public final class PushedViewsComparator implements Comparator {

    /* JADX INFO: renamed from: j */
    public int f15737j = 0;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ViewCluster f15738k;

    public PushedViewsComparator(ViewCluster viewCluster) {
        this.f15738k = viewCluster;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        ViewCluster viewCluster = this.f15738k;
        CellAndSpan cellAndSpan = (CellAndSpan) viewCluster.f15749b.f15666a.get((View) obj);
        CellAndSpan cellAndSpan2 = (CellAndSpan) viewCluster.f15749b.f15666a.get((View) obj2);
        int i11 = this.f15737j;
        if (i11 == 0) {
            i6 = cellAndSpan2.f15518a + cellAndSpan2.f15520c;
            i7 = cellAndSpan.f15518a;
            i8 = cellAndSpan.f15520c;
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    i9 = cellAndSpan.f15519b;
                    i10 = cellAndSpan2.f15519b;
                } else {
                    i9 = cellAndSpan.f15518a;
                    i10 = cellAndSpan2.f15518a;
                }
                return i9 - i10;
            }
            i6 = cellAndSpan2.f15519b + cellAndSpan2.f15521d;
            i7 = cellAndSpan.f15519b;
            i8 = cellAndSpan.f15521d;
        }
        return i6 - (i7 + i8);
    }
}
