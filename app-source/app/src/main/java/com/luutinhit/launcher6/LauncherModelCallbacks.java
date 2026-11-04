package com.luutinhit.launcher6;

import B3.C0081x;
import java.util.ArrayList;
import java.util.HashSet;
import p122r3.C2673q;
import p154y3.C3033h;

/* JADX INFO: renamed from: com.luutinhit.launcher6.q2 */
/* JADX INFO: loaded from: classes.dex */
public interface LauncherModelCallbacks {
    void bindAllApplications(ArrayList arrayList);

    void bindAppInfosRemoved(ArrayList arrayList);

    void bindAppWidget(LauncherAppWidgetInfo launcherAppWidgetInfo);

    void bindAppsAdded(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4);

    void bindAppsUpdated(ArrayList arrayList);

    void bindFolders(C0081x c0081x);

    void bindItems(ArrayList arrayList, int i6, int i7, boolean z5);

    void bindRestoreItemsChange(HashSet hashSet);

    void bindScreens(ArrayList arrayList);

    void bindShortcutsChanged(ArrayList arrayList, ArrayList arrayList2, C2673q c2673q);

    void bindShortcutsHidden(ArrayList arrayList, ArrayList arrayList2, C2673q c2673q);

    void bindWidgetsModel(C3033h c3033h);

    void bindWidgetsRestored(ArrayList arrayList);

    void bindWorkspaceComponentsRemoved(HashSet hashSet, HashSet hashSet2, C2673q c2673q);

    void finishBindingItems();

    int getCurrentWorkspaceScreen();

    boolean isAllAppsButtonRank(int i6);

    void notifyWidgetProvidersChanged();

    void onAllAppsChanged(ArrayList arrayList);

    void onPageBoundSynchronously(int i6);

    boolean setLoadOnResume();

    void startBinding();
}
