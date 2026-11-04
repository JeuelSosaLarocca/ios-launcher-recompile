package com.luutinhit.launcher6;

import M2.RunnableC0674C;

/* JADX INFO: renamed from: com.luutinhit.launcher6.g0 */
/* JADX INFO: loaded from: classes.dex */
public final class DragObject {

    /* JADX INFO: renamed from: i */
    public boolean f16525i;

    /* JADX INFO: renamed from: m */
    public RunnableC0674C f16529m;

    /* JADX INFO: renamed from: a */
    public int f16517a = -1;

    /* JADX INFO: renamed from: b */
    public int f16518b = -1;

    /* JADX INFO: renamed from: c */
    public int f16519c = -1;

    /* JADX INFO: renamed from: d */
    public int f16520d = -1;

    /* JADX INFO: renamed from: e */
    public boolean f16521e = false;

    /* JADX INFO: renamed from: f */
    public DragView f16522f = null;

    /* JADX INFO: renamed from: g */
    public Object f16523g = null;

    /* JADX INFO: renamed from: h */
    public DragSource f16524h = null;

    /* JADX INFO: renamed from: j */
    public WorkspaceDropRunnable f16526j = null;

    /* JADX INFO: renamed from: k */
    public boolean f16527k = false;

    /* JADX INFO: renamed from: l */
    public boolean f16528l = true;

    /* JADX INFO: renamed from: a */
    public final float[] getVisualCenter(float[] fArr) {
        if (fArr == null) {
            fArr = new float[2];
        }
        int i6 = this.f16517a - this.f16519c;
        int i7 = this.f16518b - this.f16520d;
        fArr[0] = (this.f16522f.getDragRegion().width() / 2) + i6;
        fArr[1] = (this.f16522f.getDragRegion().height() / 2) + i7;
        return fArr;
    }
}
