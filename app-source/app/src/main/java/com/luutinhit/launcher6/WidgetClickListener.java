package com.luutinhit.launcher6;

import android.view.KeyEvent;
import android.view.View;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.v1 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetClickListener implements View.OnClickListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17010j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ KeyEvent.Callback f17011k;

    public /* synthetic */ WidgetClickListener(KeyEvent.Callback callback, int i6) {
        this.f17010j = i6;
        this.f17011k = callback;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f17010j) {
            case 0:
                Launcher launcher = (Launcher) this.f17011k;
                launcher.mWorkspace.getClass();
                launcher.onClickAddWidgetButton(view);
                break;
            case 1:
                ((Launcher) this.f17011k).cancelShakingAnimation();
                break;
            default:
                LauncherAppWidgetHostView launcherAppWidgetHostView = (LauncherAppWidgetHostView) this.f17011k;
                launcherAppWidgetHostView.getClass();
                try {
                    Object tag = launcherAppWidgetHostView.getTag();
                    Objects.toString(tag);
                    if (tag instanceof LauncherAppWidgetInfo) {
                        LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) tag;
                        if (Launcher.getAppInfoFlags(tag) == null) {
                            int i6 = launcherAppWidgetInfo.itemType;
                            if (i6 == 1 || i6 == 4 || i6 == 5) {
                                DeleteDropTarget.removeWorkspaceOrFolderItem(launcherAppWidgetHostView.f16539m, launcherAppWidgetInfo, launcherAppWidgetHostView);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
                break;
        }
    }
}
