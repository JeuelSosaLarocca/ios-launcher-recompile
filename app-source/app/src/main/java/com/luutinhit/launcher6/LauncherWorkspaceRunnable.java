package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.r1 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LauncherWorkspaceRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16846j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Launcher f16847k;

    public /* synthetic */ LauncherWorkspaceRunnable(Launcher launcher, int i6) {
        this.f16846j = i6;
        this.f16847k = launcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16846j) {
            case 0:
                this.f16847k.mWidgetsView.requestFocus();
                break;
            case 1:
                Workspace workspace = this.f16847k.mWorkspace;
                int i6 = workspace.f23397A0;
                if (!workspace.t1()) {
                    workspace.setCurrentPage(i6);
                }
                View childAt = workspace.getChildAt(i6);
                if (childAt != null) {
                    childAt.requestFocus();
                }
                break;
            case 2:
                Launcher.m7824b(this.f16847k);
                break;
            case 3:
                Launcher.m7823a(this.f16847k);
                break;
            default:
                Launcher launcher = this.f16847k;
                if (launcher.autoRearrange) {
                    launcher.rearrangeApps(false);
                }
                break;
        }
    }
}
