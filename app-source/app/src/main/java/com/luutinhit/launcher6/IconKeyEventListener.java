package com.luutinhit.launcher6;

import B3.AbstractC0075r;
import android.view.KeyEvent;
import android.view.View;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.H0 */
/* JADX INFO: loaded from: classes.dex */
public final class IconKeyEventListener implements View.OnKeyListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15698j;

    public /* synthetic */ IconKeyEventListener(int i6) {
        this.f15698j = i6;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0142  */
    /* JADX WARN: Code duplicated, block: B:59:0x015f A[Catch: all -> 0x0167, TRY_LEAVE, TryCatch #0 {all -> 0x0167, blocks: (B:57:0x0144, B:59:0x015f), top: B:96:0x0144 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x016b  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a1 A[Catch: all -> 0x01a9, TRY_LEAVE, TryCatch #1 {all -> 0x01a9, blocks: (B:66:0x0186, B:68:0x01a1), top: B:98:0x0186 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01be  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c8  */
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int[][] iArrM181b = null;
        int[][] iArrM181b2;
        int i7;
        int iM186g;
        int i8;
        ShortcutAndWidgetContainer shortcutsAndWidgets;
        int i9;
        switch (this.f15698j) {
            case 0:
                if (i6 == 21 || i6 == 22 || i6 == 93 || i6 == 92) {
                    return FocusHelper.handleIconKeyEvent(view, i6, keyEvent);
                }
                return false;
            case 1:
                boolean zM197s = AbstractC0075r.m197s(i6);
                if (keyEvent.getAction() != 1 && zM197s) {
                    Launcher launcher = (Launcher) view.getContext();
                    DeviceProfile deviceProfile = launcher.getDeviceProfile();
                    Workspace workspace = (Workspace) view.getRootView().findViewById(R.id.workspace);
                    ShortcutAndWidgetContainer shortcutAndWidgetContainer = (ShortcutAndWidgetContainer) view.getParent();
                    CellLayout cellLayout = (CellLayout) shortcutAndWidgetContainer.getParent();
                    ItemInfo itemInfo = (ItemInfo) view.getTag();
                    int nextPage = workspace.getNextPage();
                    int childCount = workspace.getChildCount();
                    int iIndexOfChild = shortcutAndWidgetContainer.indexOfChild(view);
                    int i10 = ((CellLayoutLayoutParams) cellLayout.getShortcutsAndWidgets().getChildAt(iIndexOfChild).getLayoutParams()).f15685a;
                    CellLayout cellLayout2 = (CellLayout) workspace.getChildAt(nextPage);
                    if (cellLayout2 != null) {
                        ShortcutAndWidgetContainer shortcutsAndWidgets2 = cellLayout2.getShortcutsAndWidgets();
                        ShortcutAndWidgetContainer shortcutAndWidgetContainer2 = shortcutAndWidgetContainer;
                        View childAt = null;
                        if (i6 == 19) {
                            deviceProfile.getClass();
                            int[][] iArrM182c = AbstractC0075r.m182c(cellLayout2, cellLayout, deviceProfile.inv.f16720l);
                            iIndexOfChild += shortcutsAndWidgets2.getChildCount();
                            iArrM181b2 = iArrM182c;
                            shortcutAndWidgetContainer2 = shortcutsAndWidgets2;
                        } else {
                            if (i6 == 21) {
                                deviceProfile.getClass();
                            }
                            if (i6 == 22) {
                                deviceProfile.getClass();
                            }
                            int keyCode = keyEvent.getKeyCode();
                            if ((keyCode == 67 || keyCode == 112) && keyEvent.hasModifiers(4097)) {
                                iArrM181b = AbstractC0075r.m181b(cellLayout2);
                                if (UninstallDropTarget.supportsDrop(launcher, itemInfo)) {
                                    UninstallDropTarget.startUninstallActivity(launcher, itemInfo);
                                }
                            } else {
                                int keyCode2 = keyEvent.getKeyCode();
                                if ((keyCode2 == 67 || keyCode2 == 112) && keyEvent.hasModifiers(4096)) {
                                    iArrM181b = AbstractC0075r.m181b(cellLayout2);
                                    launcher.removeItem(view, itemInfo, true);
                                } else {
                                    iArrM181b2 = AbstractC0075r.m181b(cellLayout);
                                }
                            }
                            iArrM181b2 = iArrM181b;
                            i7 = iIndexOfChild;
                            shortcutAndWidgetContainer2 = null;
                            iM186g = AbstractC0075r.m186g(i6, i7, nextPage, childCount, Utilities.isRtl(view.getResources()), iArrM181b2);
                            if (iM186g != -10 || iM186g == -9) {
                                i8 = nextPage + 1;
                                try {
                                    workspace.l0(i8);
                                    if (((CellLayoutLayoutParams) ((CellLayout) workspace.getChildAt(i8)).getShortcutsAndWidgets().getChildAt(0).getLayoutParams()).f15693i) {
                                        workspace.getChildAt(i8).requestFocus();
                                    }
                                } catch (Throwable th) {
                                    th.getMessage();
                                }
                                shortcutsAndWidgets = shortcutAndWidgetContainer2;
                            } else if (iM186g == -8) {
                                int i11 = nextPage + 1;
                                shortcutsAndWidgets = ((CellLayout) workspace.getChildAt(i11)).getShortcutsAndWidgets();
                                childAt = shortcutsAndWidgets.getChildAt(0);
                                workspace.l0(i11);
                            } else if (iM186g == -5) {
                                i9 = nextPage - 1;
                                try {
                                    workspace.l0(i9);
                                    if (((CellLayoutLayoutParams) ((CellLayout) workspace.getChildAt(i9)).getShortcutsAndWidgets().getChildAt(0).getLayoutParams()).f15693i) {
                                        workspace.getChildAt(i9).requestFocus();
                                    }
                                } catch (Throwable th2) {
                                    th2.getMessage();
                                    i8 = nextPage + 1;
                                    workspace.l0(i8);
                                    if (((CellLayoutLayoutParams) ((CellLayout) workspace.getChildAt(i8)).getShortcutsAndWidgets().getChildAt(0).getLayoutParams()).f15693i) {
                                        workspace.getChildAt(i8).requestFocus();
                                    }
                                }
                                shortcutsAndWidgets = shortcutAndWidgetContainer2;
                            } else if (iM186g == -4) {
                                int i12 = nextPage - 1;
                                shortcutsAndWidgets = ((CellLayout) workspace.getChildAt(i12)).getShortcutsAndWidgets();
                                childAt = shortcutsAndWidgets.getChildAt(shortcutsAndWidgets.getChildCount() - 1);
                                workspace.l0(i12);
                            } else if (iM186g != -3) {
                                if (iM186g == -2) {
                                    i9 = nextPage - 1;
                                    workspace.l0(i9);
                                    if (((CellLayoutLayoutParams) ((CellLayout) workspace.getChildAt(i9)).getShortcutsAndWidgets().getChildAt(0).getLayoutParams()).f15693i) {
                                        workspace.getChildAt(i9).requestFocus();
                                    }
                                }
                                shortcutsAndWidgets = shortcutAndWidgetContainer2;
                            } else {
                                int i13 = nextPage - 1;
                                shortcutsAndWidgets = ((CellLayout) workspace.getChildAt(i13)).getShortcutsAndWidgets();
                                childAt = shortcutsAndWidgets.getChildAt(0);
                                workspace.l0(i13);
                            }
                            if (shortcutsAndWidgets == shortcutsAndWidgets2 && iM186g >= shortcutsAndWidgets2.getChildCount()) {
                                iM186g -= shortcutsAndWidgets2.getChildCount();
                            }
                            if (shortcutsAndWidgets != null) {
                                if (childAt == null && iM186g >= 0) {
                                    childAt = shortcutsAndWidgets.getChildAt(iM186g);
                                }
                                if (childAt != null) {
                                    childAt.requestFocus();
                                    FocusHelper.handleNoopKey(i6, view);
                                }
                            }
                        }
                        i7 = iIndexOfChild;
                        iM186g = AbstractC0075r.m186g(i6, i7, nextPage, childCount, Utilities.isRtl(view.getResources()), iArrM181b2);
                        if (iM186g != -10) {
                            i8 = nextPage + 1;
                            workspace.l0(i8);
                            if (((CellLayoutLayoutParams) ((CellLayout) workspace.getChildAt(i8)).getShortcutsAndWidgets().getChildAt(0).getLayoutParams()).f15693i) {
                                workspace.getChildAt(i8).requestFocus();
                            }
                            shortcutsAndWidgets = shortcutAndWidgetContainer2;
                        } else {
                            i8 = nextPage + 1;
                            workspace.l0(i8);
                            if (((CellLayoutLayoutParams) ((CellLayout) workspace.getChildAt(i8)).getShortcutsAndWidgets().getChildAt(0).getLayoutParams()).f15693i) {
                                workspace.getChildAt(i8).requestFocus();
                            }
                            shortcutsAndWidgets = shortcutAndWidgetContainer2;
                        }
                        if (shortcutsAndWidgets == shortcutsAndWidgets2) {
                            iM186g -= shortcutsAndWidgets2.getChildCount();
                        }
                        if (shortcutsAndWidgets != null) {
                            if (childAt == null) {
                                childAt = shortcutsAndWidgets.getChildAt(iM186g);
                            }
                            if (childAt != null) {
                                childAt.requestFocus();
                                FocusHelper.handleNoopKey(i6, view);
                            }
                        }
                    }
                    break;
                }
                return zM197s;
            default:
                return FocusHelper.handleIconKeyEvent(view, i6, keyEvent);
        }
        return false; // jadx: method fell off the end
    }
}
