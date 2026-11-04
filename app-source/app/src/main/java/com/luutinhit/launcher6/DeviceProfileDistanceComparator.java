package com.luutinhit.launcher6;

import java.util.Comparator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.l1 */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceProfileDistanceComparator implements Comparator {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ float f16648j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ float f16649k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ InvariantDeviceProfile f16650l;

    public DeviceProfileDistanceComparator(InvariantDeviceProfile invariantDeviceProfile, float f6, float f7) {
        this.f16650l = invariantDeviceProfile;
        this.f16648j = f6;
        this.f16649k = f7;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        InvariantDeviceProfile invariantDeviceProfile = (InvariantDeviceProfile) obj;
        InvariantDeviceProfile invariantDeviceProfile2 = (InvariantDeviceProfile) obj2;
        float f6 = invariantDeviceProfile.f16727s;
        float f7 = invariantDeviceProfile.f16728t;
        this.f16650l.getClass();
        float f8 = this.f16648j;
        double d6 = f6 - f8;
        float f9 = this.f16649k;
        return Float.compare((float) Math.hypot(d6, f7 - f9), (float) Math.hypot(invariantDeviceProfile2.f16727s - f8, invariantDeviceProfile2.f16728t - f9));
    }
}
