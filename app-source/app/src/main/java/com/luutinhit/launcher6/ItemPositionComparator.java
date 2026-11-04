package com.luutinhit.launcher6;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.v2 */
/* JADX INFO: loaded from: classes.dex */
public final class ItemPositionComparator implements Comparator {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ InvariantDeviceProfile f17012j;

    public ItemPositionComparator(InvariantDeviceProfile invariantDeviceProfile) {
        this.f17012j = invariantDeviceProfile;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ItemInfo itemInfo = (ItemInfo) obj;
        ItemInfo itemInfo2 = (ItemInfo) obj2;
        InvariantDeviceProfile invariantDeviceProfile = this.f17012j;
        int i6 = invariantDeviceProfile.f16712d;
        int i7 = invariantDeviceProfile.f16711c * i6;
        long j6 = i7 * 6;
        long j7 = i7;
        long j8 = i6;
        long j9 = (((long) itemInfo.cellY) * j8) + (itemInfo.screenId * j7) + (itemInfo.container * j6) + ((long) itemInfo.cellX);
        long j10 = (((long) itemInfo2.cellY) * j8) + (itemInfo2.screenId * j7) + (itemInfo2.container * j6) + ((long) itemInfo2.cellX);
        Rect rect = Utilities.sOldBounds;
        if (j9 < j10) {
            return -1;
        }
        return j9 == j10 ? 0 : 1;
    }
}
