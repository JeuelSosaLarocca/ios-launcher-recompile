package com.luutinhit.launcher6;

import F3.EnumC0278e;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.E1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherWorkspaceTask implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15525j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Launcher f15526k;

    public /* synthetic */ LauncherWorkspaceTask(Launcher launcher, int i6) {
        this.f15525j = i6;
        this.f15526k = launcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15525j) {
            case 0:
                Workspace workspace = this.f15526k.mWorkspace;
                if (workspace != null) {
                    int i6 = workspace.f23397A0;
                    if (!workspace.t1()) {
                        workspace.l0(i6);
                    }
                    View childAt = workspace.getChildAt(i6);
                    if (childAt != null) {
                        childAt.requestFocus();
                    }
                }
                break;
            case 1:
                Launcher launcher = this.f15526k;
                launcher.cancelShakingAnimation();
                launcher.mWidgetsView.requestFocus();
                launcher.mWidgetsView.setVisibility(0);
                launcher.mWidgetsView.setPanelState(EnumC0278e.f849j);
                break;
            case 2:
                Workspace workspace2 = this.f15526k.mWorkspace;
                if (workspace2 != null) {
                    workspace2.p1(true);
                    if (workspace2.getWindowToken() != null) {
                        int childCount = workspace2.getChildCount();
                        for (int i7 = 0; i7 < childCount; i7++) {
                            CellLayout cellLayout = (CellLayout) workspace2.getChildAt(i7);
                            cellLayout.getClass();
                            cellLayout.post(new MergedIdleRunnable(0, cellLayout));
                        }
                    }
                    workspace2.p1(false);
                }
                break;
            case 3:
                Launcher launcher2 = this.f15526k;
                launcher2.bindAllApplications(launcher2.mTmpAppsList);
                launcher2.mTmpAppsList = null;
                break;
            case 4:
                Launcher launcher3 = this.f15526k;
                launcher3.bindWidgetsModel(launcher3.mWidgetsModel);
                break;
            case 5:
                Launcher launcher4 = this.f15526k;
                launcher4.mDragLayer.dismissOverlayView();
                launcher4.showFirstRunClings();
                break;
            case 6:
                this.f15526k.exitSpringLoadedDragModeDelayed(true, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
            case 7:
                this.f15526k.mOverviewPanel.requestFocusFromTouch();
                break;
            case 8:
                this.f15526k.finishBindingItems();
                break;
            case 9:
                this.f15526k.setOrientation();
                break;
            case 10:
                this.f15526k.setRequestedOrientation(-1);
                break;
            case 11:
                this.f15526k.mVibrator.vibrate(50L);
                break;
            default:
                this.f15526k.exitSpringLoadedDragModeDelayed(false, 0, null);
                break;
        }
    }
}
