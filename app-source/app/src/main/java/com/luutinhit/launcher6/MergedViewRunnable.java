package com.luutinhit.launcher6;

import F3.EnumC0278e;
import G3.RunnableC0365u;
import android.view.KeyEvent;
import android.view.View;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;

/* JADX INFO: renamed from: com.luutinhit.launcher6.p1 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MergedViewRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16813j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ boolean f16814k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ KeyEvent.Callback f16815l;

    public /* synthetic */ MergedViewRunnable(KeyEvent.Callback callback, boolean z5, int i6) {
        this.f16813j = i6;
        this.f16815l = callback;
        this.f16814k = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Launcher launcher;
        InvariantDeviceProfile invariantDeviceProfile;
        boolean z5 = this.f16814k;
        int i6 = 1;
        KeyEvent.Callback callback = this.f16815l;
        switch (this.f16813j) {
            case 0:
                Launcher launcher2 = (Launcher) callback;
                launcher2.mWidgetsView.clearFocus();
                WidgetsContainerView widgetsContainerView = launcher2.mWidgetsView;
                SlidingUpWidgetsCellAppStyle slidingUpWidgetsCellAppStyle = widgetsContainerView.f17185S.mWidgetsAppStyle;
                if (slidingUpWidgetsCellAppStyle != null) {
                    slidingUpWidgetsCellAppStyle.postOnAnimation(new RunnableC0365u(widgetsContainerView, i6));
                }
                launcher2.mWidgetsView.setVisibility(8);
                launcher2.mWidgetsView.setPanelStateInternal(EnumC0278e.f850k);
                launcher2.mWidgetsView.m742j();
                if (z5) {
                    launcher2.onShakingAllApps();
                }
                break;
            case 1:
                int i7 = BlurScreenLayout.f15374u;
                BlurScreenLayout blurScreenLayout = (BlurScreenLayout) callback;
                blurScreenLayout.animate().cancel();
                blurScreenLayout.f15383r = null;
                blurScreenLayout.setBackground(null);
                if (z5 && (launcher = blurScreenLayout.f15382q) != null && launcher.getDragLayer() != null && blurScreenLayout.getParent() == launcher.getDragLayer()) {
                    launcher.getDragLayer().removeView(blurScreenLayout);
                    break;
                }
                break;
            default:
                Workspace workspace = (Workspace) callback;
                DeviceProfile deviceProfile = workspace.grid;
                if (deviceProfile != null && (invariantDeviceProfile = deviceProfile.inv) != null) {
                    if (!z5) {
                        CellLayout currentCellLayout = workspace.getCurrentCellLayout();
                        if (currentCellLayout != null) {
                            currentCellLayout.m7637e(invariantDeviceProfile, true);
                        }
                    } else {
                        int iU0 = (workspace.U0()) ? 1 : 0;
                        while (iU0 < workspace.getPageCount()) {
                            View childAt = workspace.getChildAt(iU0);
                            if (childAt instanceof CellLayout) {
                                ((CellLayout) childAt).m7637e(invariantDeviceProfile, iU0 == workspace.getCurrentPage());
                            }
                            iU0++;
                        }
                    }
                    break;
                }
                break;
        }
    }
}
