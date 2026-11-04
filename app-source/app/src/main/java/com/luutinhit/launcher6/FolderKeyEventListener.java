package com.luutinhit.launcher6;

import B3.AbstractC0075r;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.luutinhit.launcher6.n0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderKeyEventListener implements View.OnKeyListener {

    /* JADX INFO: renamed from: j */
    public Folder f16736j;

    public FolderKeyEventListener(Folder folder) {
        this.f16736j = folder;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // endless loop in the jadx output; the original bytecode runs
        boolean zM197s = AbstractC0075r.m197s(i6);
        if (keyEvent.getAction() != 1) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof ShortcutAndWidgetContainer)) {
                WeakReference weakReference = LauncherAppState.f16215h;
                return false;
            }
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = (ShortcutAndWidgetContainer) parent;
            CellLayout cellLayout = (CellLayout) shortcutAndWidgetContainer.getParent();
            int iIndexOfChild = shortcutAndWidgetContainer.indexOfChild(view);
            FolderPagedView folderPagedView = (FolderPagedView) cellLayout.getParent();
            int iIndexOfChild2 = folderPagedView.indexOfChild(cellLayout);
            int pageCount = folderPagedView.getPageCount();
            boolean zIsRtl = Utilities.isRtl(view.getResources());
            int[][] iArrM181b = AbstractC0075r.m181b(cellLayout);
            int iM186g = AbstractC0075r.m186g(i6, iIndexOfChild, iIndexOfChild2, pageCount, zIsRtl, iArrM181b);
            Folder folder = this.f16736j;
            if (iM186g != -1) {
                View childAt = null;
                switch (iM186g) {
                    case -10:
                    case -9:
                        int i7 = iIndexOfChild2 + 1;
                        ShortcutAndWidgetContainer shortcutsAndWidgets = ((CellLayout) folderPagedView.getChildAt(i7)).getShortcutsAndWidgets();
                        if (shortcutsAndWidgets != null) {
                            folderPagedView.l0(i7);
                            int i8 = ((CellLayoutLayoutParams) view.getLayoutParams()).f15686b;
                            for (int countX = (iM186g == -9) ^ shortcutsAndWidgets.invertLayoutHorizontally() ? 0 : ((CellLayout) shortcutsAndWidgets.getParent()).getCountX() - 1; countX >= 0; countX--) {
                                int i9 = i8;
                                while (true) {
                                    if (i9 >= 0) {
                                        View childAt2 = shortcutsAndWidgets.getChildAt(countX, i9);
                                        if (childAt2 != null) {
                                            childAt = childAt2;
                                        } else {
                                            i9--;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case -8:
                        int i10 = iIndexOfChild2 + 1;
                        ShortcutAndWidgetContainer shortcutsAndWidgets2 = ((CellLayout) folderPagedView.getChildAt(i10)).getShortcutsAndWidgets();
                        if (shortcutsAndWidgets2 != null) {
                            folderPagedView.l0(i10);
                            childAt = shortcutsAndWidgets2.getChildAt(0, 0);
                        }
                        break;
                    case -7:
                        childAt = folderPagedView.getLastItem();
                        break;
                    case -6:
                        childAt = cellLayout.mShortcutsAndWidgets.getChildAt(0, 0);
                        break;
                    case -5:
                    case -2:
                        int i11 = iIndexOfChild2 - 1;
                        ShortcutAndWidgetContainer shortcutsAndWidgets3 = ((CellLayout) folderPagedView.getChildAt(i11)).getShortcutsAndWidgets();
                        if (shortcutsAndWidgets3 != null) {
                            int i12 = ((CellLayoutLayoutParams) view.getLayoutParams()).f15686b;
                            folderPagedView.l0(i11);
                            childAt = shortcutsAndWidgets3.getChildAt((iM186g == -5) ^ shortcutsAndWidgets3.invertLayoutHorizontally() ? 0 : iArrM181b.length - 1, i12);
                        }
                        break;
                    case -4:
                        int i13 = iIndexOfChild2 - 1;
                        ShortcutAndWidgetContainer shortcutsAndWidgets4 = ((CellLayout) folderPagedView.getChildAt(i13)).getShortcutsAndWidgets();
                        if (shortcutsAndWidgets4 != null) {
                            folderPagedView.l0(i13);
                            childAt = shortcutsAndWidgets4.getChildAt(iArrM181b.length - 1, iArrM181b[0].length - 1);
                        }
                        break;
                    case -3:
                        int i14 = iIndexOfChild2 - 1;
                        ShortcutAndWidgetContainer shortcutsAndWidgets5 = ((CellLayout) folderPagedView.getChildAt(i14)).getShortcutsAndWidgets();
                        if (shortcutsAndWidgets5 != null) {
                            folderPagedView.l0(i14);
                            childAt = shortcutsAndWidgets5.getChildAt(0, 0);
                        }
                        break;
                    default:
                        childAt = shortcutAndWidgetContainer.getChildAt(iM186g);
                        break;
                }
                if (childAt != null) {
                    childAt.requestFocus();
                    FocusHelper.handleNoopKey(i6, view);
                    return zM197s;
                }
                if (i6 == 20) {
                    folder.mFolderName.requestFocus();
                    FocusHelper.handleNoopKey(i6, view);
                }
            } else if (i6 == 20) {
                folder.mFolderName.requestFocus();
                FocusHelper.handleNoopKey(i6, view);
                return zM197s;
            }
        }
        return zM197s;
    }
}
