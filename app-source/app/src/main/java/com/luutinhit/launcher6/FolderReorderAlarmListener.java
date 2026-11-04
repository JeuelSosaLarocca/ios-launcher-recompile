package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.q0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderReorderAlarmListener implements OnAlarmListener, OnBackKeyListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16826j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Folder f16827k;

    public /* synthetic */ FolderReorderAlarmListener(Folder folder, int i6) {
        this.f16826j = i6;
        this.f16827k = folder;
    }

    @Override // com.luutinhit.launcher6.OnAlarmListener
    /* JADX INFO: renamed from: h */
    public void mo7775h(Alarm alarm) {
        int i6;
        int i7;
        switch (this.f16826j) {
            case 0:
                Folder folder = this.f16827k;
                FolderPagedView folderPagedView = folder.mContent;
                int i8 = folder.f15602E;
                int i9 = folder.f15600C;
                folderPagedView.x0();
                int nextPage = folderPagedView.getNextPage();
                int i10 = folderPagedView.f23341C0;
                int i11 = i9 / i10;
                int i12 = i9 % i10;
                int i13 = i8 % i10;
                int i14 = i8 / i10;
                if (i9 != i8) {
                    int i15 = -1;
                    if (i9 > i8) {
                        if (i14 < nextPage) {
                            i15 = nextPage * i10;
                            i13 = 0;
                        } else {
                            i8 = -1;
                        }
                        i7 = 1;
                    } else {
                        if (i14 > nextPage) {
                            i6 = ((nextPage + 1) * i10) - 1;
                            i13 = i10 - 1;
                        } else {
                            i8 = -1;
                            i6 = -1;
                        }
                        i15 = i6;
                        i7 = -1;
                    }
                    while (i8 != i15) {
                        int i16 = i8 + i7;
                        int i17 = i16 / i10;
                        int i18 = i16 % i10;
                        int i19 = folderPagedView.f23343E0;
                        int i20 = i18 % i19;
                        int i21 = i18 / i19;
                        CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(i17);
                        View childAt = cellLayout.mShortcutsAndWidgets.getChildAt(i20, i21);
                        if (childAt != null) {
                            if (nextPage != i17) {
                                cellLayout.removeView(childAt);
                                folderPagedView.u0(childAt, (ShortcutInfo) childAt.getTag(), i8);
                            } else {
                                FolderItemAnimRunnable folderItemAnimRunnable = new FolderItemAnimRunnable(folderPagedView, childAt, childAt.getTranslationX(), i8);
                                childAt.animate().translationXBy((i7 > 0) ^ folderPagedView.f23349w0 ? -childAt.getWidth() : childAt.getWidth()).setDuration(230L).setStartDelay(0L).withEndAction(folderItemAnimRunnable);
                                folderPagedView.f23352z0.put(childAt, folderItemAnimRunnable);
                            }
                        }
                        i8 = i16;
                    }
                    if ((i12 - i13) * i7 > 0) {
                        CellLayout cellLayout2 = (CellLayout) folderPagedView.getChildAt(nextPage);
                        float f6 = 30.0f;
                        int i22 = 0;
                        while (i13 != i12) {
                            int i23 = i13 + i7;
                            int i24 = folderPagedView.f23343E0;
                            View childAt2 = cellLayout2.mShortcutsAndWidgets.getChildAt(i23 % i24, i23 / i24);
                            if (childAt2 != null) {
                                ((ItemInfo) childAt2.getTag()).f16791t -= i7;
                            }
                            int i25 = folderPagedView.f23343E0;
                            CellLayout cellLayout3 = cellLayout2;
                            if (cellLayout3.animateChildToPosition(childAt2, i13 % i25, i13 / i25, 230, i22, true, true)) {
                                i22 += (int) f6;
                                f6 *= 0.9f;
                            }
                            i13 = i23;
                            cellLayout2 = cellLayout3;
                        }
                    }
                }
                folder.f15602E = folder.f15600C;
                break;
            default:
                this.f16827k.completeDragExit();
                break;
        }
    }
}
