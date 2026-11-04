package com.luutinhit.launcher6;

import android.view.View;
import android.view.ViewParent;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.s0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderReplaceWithItemRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16857j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Folder f16858k;

    public /* synthetic */ FolderReplaceWithItemRunnable(Folder folder, int i6) {
        this.f16857j = i6;
        this.f16858k = folder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View viewCreateShortcut;
        switch (this.f16857j) {
            case 0:
                Folder folder = this.f16858k;
                int size = folder.mInfo.contents.size();
                if (size <= 1) {
                    Launcher launcher = folder.f15628q;
                    if (size == 1) {
                        FolderInfo folderInfo = folder.mInfo;
                        CellLayout cellLayout = launcher.getCellLayout(folderInfo.container, folderInfo.screenId);
                        ShortcutInfo shortcutInfo = (ShortcutInfo) folder.mInfo.contents.remove(0);
                        viewCreateShortcut = launcher.createShortcut(cellLayout, shortcutInfo);
                        FolderInfo folderInfo2 = folder.mInfo;
                        LauncherModel.addOrMoveItemInDatabase(folder.f15628q, shortcutInfo, folderInfo2.container, folderInfo2.screenId, folderInfo2.cellX, folderInfo2.cellY);
                    } else {
                        viewCreateShortcut = null;
                    }
                    View view = viewCreateShortcut;
                    folder.mFolderIcon.clearAnimation();
                    launcher.removeItem(folder.mFolderIcon, folder.mInfo, true);
                    ViewParent viewParent = folder.mFolderIcon;
                    if (viewParent instanceof DropTarget) {
                        folder.mDragController.f16103l.remove((DropTarget) viewParent);
                    }
                    if (view != null) {
                        Workspace workspace = launcher.getWorkspace();
                        FolderInfo folderInfo3 = folder.mInfo;
                        long j6 = folderInfo3.container;
                        long j7 = folderInfo3.screenId;
                        int i6 = folderInfo3.cellX;
                        int i7 = folderInfo3.cellY;
                        int i8 = folderInfo3.spanX;
                        int i9 = folderInfo3.spanY;
                        workspace.getClass();
                        Objects.toString(view);
                        workspace.v0(view, j6, j7, i6, i7, i8, i9, false, true);
                        view.requestFocus();
                    }
                }
                break;
            case 1:
                this.f16858k.f15628q.exitSpringLoadedDragModeDelayed(true, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
                break;
            case 2:
                Folder folder2 = this.f16858k;
                if (folder2.getItemCount() <= 1) {
                    folder2.m7704T();
                }
                break;
            case 3:
                this.f16858k.setLayerType(0, null);
                break;
            default:
                this.f16858k.mContentWrapper.setLayerType(0, null);
                break;
        }
    }
}
