package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import B3.C0081x;
import B3.C0083z;
import G3.RunnableC0360p;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.os.Message;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p122r3.AbstractC2662f;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.B1 */
/* JADX INFO: loaded from: classes.dex */
public final class MergedModelRunnable implements Runnable {



    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15327j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Object f15328k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Object f15329l;

    public /* synthetic */ MergedModelRunnable(int i6, Object obj, Object obj2) {
        this.f15327j = i6;
        this.f15329l = obj;
        this.f15328k = obj2;
    }

    /* JADX INFO: renamed from: a */
    public final void m7543a() {
        synchronized (LauncherModel.sBgLock) {
            try {
                HashSet hashSet = new HashSet();
                if (((PackageIconKey) this.f15328k).f16319b == 0) {
                    return;
                }
                C0081x c0081x = LauncherModel.sBgItemsIdMap;
                c0081x.getClass();
                int i6 = 0;
                int i7 = 0;
                while (i7 < c0081x.size()) {
                    int i8 = i7 + 1;
                    ItemInfo itemInfo = (ItemInfo) c0081x.valueAt(i7);
                    if (itemInfo instanceof ShortcutInfo) {
                        ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                        ComponentName targetComponent = shortcutInfo.getTargetComponent();
                        if (shortcutInfo.hasStatusFlag(3) && targetComponent != null && ((PackageIconKey) this.f15328k).f16318a.equals(targetComponent.getPackageName())) {
                            PackageIconKey packageIconKey = (PackageIconKey) this.f15328k;
                            shortcutInfo.f16561I = packageIconKey.f16320c;
                            int i9 = shortcutInfo.f16560H | 4;
                            shortcutInfo.f16560H = i9;
                            if (packageIconKey.f16319b == 2) {
                                shortcutInfo.f16560H = i9 & (-5);
                            }
                            hashSet.add(shortcutInfo);
                        }
                    }
                    i7 = i8;
                }
                ArrayList arrayList = LauncherModel.sBgAppWidgets;
                int size = arrayList.size();
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) obj;
                    if (launcherAppWidgetInfo.providerName.getPackageName().equals(((PackageIconKey) this.f15328k).f16318a)) {
                        launcherAppWidgetInfo.f16571D = ((PackageIconKey) this.f15328k).f16320c;
                        hashSet.add(launcherAppWidgetInfo);
                    }
                }
                if (!hashSet.isEmpty()) {
                    ((LauncherModel) this.f15329l).f15345m.m7884e(new MergedModelRunnable(9, this, hashSet));
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m7544b() {
        ((ContentResolver) this.f15328k).delete(Favorites.getContentUri(((FolderInfo) this.f15329l).id), null, null);
        Object obj = LauncherModel.sBgLock;
        synchronized (obj) {
            LauncherModel.sBgItemsIdMap.remove(((FolderInfo) this.f15329l).id);
            LauncherModel.sBgFolders.remove(((FolderInfo) this.f15329l).id);
            LauncherModel.sBgWorkspaceItems.remove((FolderInfo) this.f15329l);
        }
        ((ContentResolver) this.f15328k).delete(Favorites.f15684a, "container=" + ((FolderInfo) this.f15329l).id, null);
        synchronized (obj) {
            try {
                ArrayList arrayList = ((FolderInfo) this.f15329l).contents;
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj2 = arrayList.get(i6);
                    i6++;
                    LauncherModel.sBgItemsIdMap.remove(((ItemInfo) obj2).id);
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m7545c() {
        synchronized (LauncherModel.sBgLock) {
            try {
                ArrayList arrayList = new ArrayList();
                C2673q c2673qM9672b = C2673q.m9672b();
                C0081x c0081x = LauncherModel.sBgItemsIdMap;
                c0081x.getClass();
                int i6 = 0;
                while (i6 < c0081x.size()) {
                    int i7 = i6 + 1;
                    ItemInfo itemInfo = (ItemInfo) c0081x.valueAt(i6);
                    if (itemInfo instanceof ShortcutInfo) {
                        ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                        ComponentName targetComponent = shortcutInfo.getTargetComponent();
                        if (shortcutInfo.hasStatusFlag(3) && targetComponent != null && ((String) this.f15328k).equals(targetComponent.getPackageName())) {
                            if (shortcutInfo.hasStatusFlag(2)) {
                                ((LauncherModel) this.f15329l).f15355w.m8020v(shortcutInfo, shortcutInfo.f16563K, c2673qM9672b, shortcutInfo.f16556D && shortcutInfo.container >= 0 && shortcutInfo.f16791t >= 9);
                            } else {
                                shortcutInfo.m8056i(((LauncherModel) this.f15329l).f15355w);
                            }
                            arrayList.add(shortcutInfo);
                        }
                    }
                    i6 = i7;
                }
                if (!arrayList.isEmpty()) {
                    ((LauncherModel) this.f15329l).f15345m.m7884e(new RunnableC0360p(this, arrayList, c2673qM9672b, 16));
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m7546d() {
        if (!((LoaderTask) this.f15329l).f17240k) {
            LauncherModel.m7567y((MergedModelRunnable) this.f15328k);
            return;
        }
        ArrayList arrayList = LauncherModel.mBindCompleteRunnables;
        synchronized (arrayList) {
            arrayList.add((MergedModelRunnable) this.f15328k);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m7547e() {
        LauncherModelCallbacks launcherModelCallbacksM8272m = ((LoaderTask) this.f15329l).m8272m((LauncherModelCallbacks) this.f15328k);
        if (launcherModelCallbacksM8272m != null) {
            launcherModelCallbacksM8272m.finishBindingItems();
        }
        ((LoaderTask) this.f15329l).f17243n.getClass();
        int i6 = 0;
        ((LoaderTask) this.f15329l).f17240k = false;
        ArrayList arrayList = LauncherModel.mBindCompleteRunnables;
        if (arrayList.isEmpty()) {
            return;
        }
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    LauncherModel.m7567y((Runnable) obj);
                }
                LauncherModel.mBindCompleteRunnables.clear();
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // endless loop in the jadx output; the original bytecode runs
        boolean z5;
        switch (this.f15327j) {
            case 0:
                Launcher launcher = ((LauncherFirstDrawListener) this.f15329l).f15438b;
                Workspace workspace = launcher.mWorkspace;
                if (workspace != null && workspace.getViewTreeObserver() != null) {
                    launcher.mWorkspace.getViewTreeObserver().removeOnDrawListener((LauncherFirstDrawListener) this.f15328k);
                    break;
                }
                break;
            case 1:
                ButtonDropTarget buttonDropTarget = (ButtonDropTarget) this.f15329l;
                buttonDropTarget.mo7604A((DragObject) this.f15328k);
                buttonDropTarget.mSearchDropTargetBar.mo905C();
                buttonDropTarget.mLauncher.exitSpringLoadedDragModeDelayed(true, 0, null);
                break;
            case 2:
                ((View) this.f15328k).setVisibility(0);
                Runnable runnable = (Runnable) this.f15329l;
                if (runnable != null) {
                    runnable.run();
                }
                break;
            case 3:
                ((ValueAnimator) this.f15328k).removeUpdateListener((FirstFrameAnimatorHelper) this.f15329l);
                break;
            case 4:
                FolderIcon folderIcon = (FolderIcon) this.f15329l;
                ArrayList arrayList = folderIcon.f15645C;
                ShortcutInfo shortcutInfo = (ShortcutInfo) this.f15328k;
                arrayList.remove(shortcutInfo);
                folderIcon.mFolder.m7700O(shortcutInfo).setVisibility(0);
                folderIcon.invalidate();
                break;
            case 5:
                Launcher launcher2 = (Launcher) this.f15329l;
                if (launcher2.mWorkerHandler != null) {
                    List list = (List) this.f15328k;
                    if (list != null) {
                        Message message = new Message();
                        message.what = 1;
                        message.obj = list;
                        launcher2.mWorkerHandler.removeCallbacksAndMessages(null);
                        launcher2.mWorkerHandler.sendMessageDelayed(message, 500L);
                    } else {
                        launcher2.mWorkerHandler.obtainMessage(0).sendToTarget();
                    }
                }
                break;
            case 6:
                ArrayList arrayList2 = (ArrayList) this.f15329l;
                AnimatorSet animatorSet = (AnimatorSet) this.f15328k;
                animatorSet.playTogether(arrayList2);
                animatorSet.start();
                break;
            case 7:
                ((Launcher) this.f15329l).bindFolders((C0081x) this.f15328k);
                break;
            case 8:
                ((Launcher) this.f15329l).bindRestoreItemsChange((HashSet) this.f15328k);
                break;
            case 9:
                LauncherModelCallbacks callback = ((LauncherModel) ((MergedModelRunnable) this.f15329l).f15329l).getCallback();
                if (callback != null) {
                    callback.bindRestoreItemsChange((HashSet) this.f15328k);
                }
                break;
            case 10:
                try {
                    ArrayList arrayList3 = (ArrayList) this.f15328k;
                    int size = arrayList3.size();
                    int i6 = 0;
                    while (i6 < size) {
                        Object obj = arrayList3.get(i6);
                        i6++;
                        ItemInfo itemInfo = (ItemInfo) obj;
                        long j6 = itemInfo.id;
                        ((ContentResolver) this.f15329l).delete(Favorites.getContentUri(itemInfo.id), null, null);
                        synchronized (LauncherModel.sBgLock) {
                            try {
                                int i7 = itemInfo.itemType;
                                if (i7 == 0 || i7 == 1) {
                                    LauncherModel.sBgWorkspaceItems.remove(itemInfo);
                                } else if (i7 == 2) {
                                    LauncherModel.sBgFolders.remove(itemInfo.id);
                                    C0081x c0081x = LauncherModel.sBgItemsIdMap;
                                    c0081x.getClass();
                                    int i8 = 0;
                                    while (true) {
                                        if (i8 < c0081x.size()) {
                                            int i9 = i8 + 1;
                                            ItemInfo itemInfo2 = (ItemInfo) c0081x.valueAt(i8);
                                            if (itemInfo2.container == itemInfo.id) {
                                                itemInfo.toString();
                                                itemInfo2.toString();
                                            }
                                            i8 = i9;
                                        } else {
                                            LauncherModel.sBgWorkspaceItems.remove(itemInfo);
                                        }
                                    }
                                } else if (i7 == 4) {
                                    LauncherModel.sBgAppWidgets.remove(itemInfo);
                                }
                                LauncherModel.sBgItemsIdMap.remove(itemInfo.id);
                            } catch (Throwable th) {
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.getMessage();
                    return;
                }
                break;
            case 11:
                m7544b();
                break;
            case 12:
                m7543a();
                break;
            case 13:
                m7545c();
                break;
            case 14:
                C0083z c0083z = (C0083z) this.f15328k;
                c0083z.f235h = new ArrayList();
                c0083z.f236i = new ArrayList();
                c0083z.f237j = new HashMap();
                HashSet hashSet = new HashSet();
                SharedPreferences sharedPreferences = (SharedPreferences) c0083z.f233f;
                String str = (String) c0083z.f234g;
                Set<String> stringSet = sharedPreferences.getStringSet(str, null);
                boolean z6 = false;
                if (stringSet == null) {
                    z5 = false;
                } else {
                    hashSet.addAll(stringSet);
                    z5 = true;
                }
                for (AbstractC2662f abstractC2662f : (Iterable<AbstractC2662f>) (Iterable) ((List) this.f15329l)) {
                    String packageName = abstractC2662f.mo9652b().getPackageName();
                    if (!hashSet.contains(packageName)) {
                        hashSet.add(packageName);
                        c0083z.m206d(abstractC2662f, abstractC2662f.mo9653c());
                        z6 = true;
                    }
                }
                if (z6) {
                    sharedPreferences.edit().putStringSet(str, hashSet).apply();
                    c0083z.m204a(z5);
                }
                break;
            case 15:
                m7546d();
                break;
            case 16:
                m7547e();
                break;
            case 17:
                ((MergedUiRunnable) this.f15328k).run();
                ((PagedView) this.f15329l).enableFreeScroll();
                break;
            case 18:
                AppWidgetHostView appWidgetHostView = (AppWidgetHostView) this.f15328k;
                if (appWidgetHostView != null) {
                    appWidgetHostView.setVisibility(0);
                }
                Runnable runnable2 = (Runnable) this.f15329l;
                if (runnable2 != null) {
                    runnable2.run();
                }
                break;
            case 19:
                Workspace workspace2 = (Workspace) this.f15329l;
                boolean z7 = workspace2.f23377a0;
                RunnableC0031a runnableC0031a = (RunnableC0031a) this.f15328k;
                if (z7) {
                    workspace2.f23451q1 = runnableC0031a;
                } else {
                    runnableC0031a.run();
                }
                break;
            default:
                Workspace workspace3 = (Workspace) this.f15329l;
                workspace3.f23445i1 = false;
                workspace3.p1(false);
                MergedModelRunnable mergedModelRunnable = (MergedModelRunnable) this.f15328k;
                if (mergedModelRunnable != null) {
                    mergedModelRunnable.run();
                }
                break;
        }
    }

    public /* synthetic */ MergedModelRunnable(Object obj, Object obj2, int i6, boolean z5) {
        this.f15327j = i6;
        this.f15328k = obj;
        this.f15329l = obj2;
    }
}
