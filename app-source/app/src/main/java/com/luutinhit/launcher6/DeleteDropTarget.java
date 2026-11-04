package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class DeleteDropTarget extends ButtonDropTarget {
    public DeleteDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: F */
    public static void removeWorkspaceOrFolderItem(Launcher launcher, ItemInfo itemInfo, View view) {
        launcher.removeItem(view, itemInfo, true);
        launcher.getWorkspace().n1();
        launcher.getDragLayer().announceForAccessibility(launcher.getString(R.string.item_removed));
    }

    /* JADX INFO: renamed from: G */
    public static boolean supportsDrop(Object obj) {
        boolean z5 = obj instanceof ShortcutInfo;
        boolean z6 = z5 || (obj instanceof LauncherAppWidgetInfo) || (obj instanceof FolderInfo);
        if (z5) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) obj;
            if (LauncherAppState.getInstance().f16222e.f16710b) {
                return shortcutInfo.itemType == 1;
            }
        }
        return z6;
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    /* JADX INFO: renamed from: A */
    public final void mo7604A(DragObject dragObject) {
        ItemInfo itemInfo = (ItemInfo) dragObject.f16523g;
        DragSource dragSource = dragObject.f16524h;
        if ((dragSource instanceof Workspace) || (dragSource instanceof Folder)) {
            removeWorkspaceOrFolderItem(this.mLauncher, itemInfo, null);
        }
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    /* JADX INFO: renamed from: D */
    public final boolean mo7606D(DragSource dragSource, Object obj) {
        return dragSource.mo7712t() && supportsDrop(obj);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f15419p = getResources().getColor(R.color.delete_target_hover_tint);
        setDrawable(2131231080);
    }
}
