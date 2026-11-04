package com.luutinhit.launcher6;

import B3.C0081x;
import B3.C0083z;
import G1.C0328n;
import G3.RunnableC0360p;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.RunnableC3718ke;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import p003D.C0165i;
import p122r3.AbstractC2662f;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.x2 */
/* JADX INFO: loaded from: classes.dex */
public final class LoaderTask implements Runnable {

    /* JADX INFO: renamed from: j */
    public Context f17239j;

    /* JADX INFO: renamed from: k */
    public boolean f17240k;

    /* JADX INFO: renamed from: l */
    public boolean f17241l;

    /* JADX INFO: renamed from: m */
    public int f17242m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ LauncherModel f17243n;

    public LoaderTask(LauncherModel launcherModel, Context context, int i6) {
        this.f17243n = launcherModel;
        this.f17239j = context;
        this.f17242m = i6;
    }

    /* JADX INFO: renamed from: e */
    public static void clearSBgDataStructures() {
        synchronized (LauncherModel.sBgLock) {
            LauncherModel.sBgWorkspaceItems.clear();
            LauncherModel.sBgAppWidgets.clear();
            LauncherModel.sBgFolders.clear();
            LauncherModel.sBgItemsIdMap.clear();
            LauncherModel.sBgWorkspaceScreens.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void bindWorkspace(int i6) {
        ArrayList arrayList;
        C0081x c0081x;
        SystemClock.uptimeMillis();
        LauncherModelCallbacks launcherModelCallbacks = (LauncherModelCallbacks) this.f17243n.f15352t.get();
        if (launcherModelCallbacks == null) {
            return;
        }
        synchronized (LauncherModel.sBgLock) {
            try {
                try {
                    ArrayList arrayList2 = LauncherModel.sBgWorkspaceItems;
                    ArrayList arrayList3 = new ArrayList(arrayList2.size());
                    arrayList3.addAll(arrayList2);
                    ArrayList arrayList4 = LauncherModel.sBgAppWidgets;
                    ArrayList arrayList5 = new ArrayList(arrayList4.size());
                    arrayList5.addAll(arrayList4);
                    ArrayList arrayList6 = LauncherModel.sBgWorkspaceScreens;
                    ArrayList arrayList7 = new ArrayList(arrayList6.size());
                    arrayList7.addAll(arrayList6);
                    C0081x c0081xM200d = LauncherModel.sBgFolders.m200d();
                    C0081x c0081xM200d2 = LauncherModel.sBgItemsIdMap.m200d();
                    int currentWorkspaceScreen = i6;
                    boolean z5 = currentWorkspaceScreen != -1001;
                    if (!z5) {
                        currentWorkspaceScreen = launcherModelCallbacks.getCurrentWorkspaceScreen();
                    }
                    int i7 = currentWorkspaceScreen < arrayList7.size() ? currentWorkspaceScreen : -1001;
                    long jLongValue = i7 < 0 ? -1L : ((Long) arrayList7.get(i7)).longValue();
                    this.f17243n.unbindWorkspaceItemsOnMainThread();
                    ArrayList arrayList8 = new ArrayList();
                    ArrayList arrayList9 = new ArrayList();
                    int i8 = i7;
                    ArrayList arrayList10 = new ArrayList();
                    ArrayList arrayList11 = new ArrayList();
                    C0081x c0081x2 = new C0081x();
                    boolean z6 = z5;
                    C0081x c0081x3 = new C0081x();
                    Objects.toString(arrayList3);
                    Objects.toString(arrayList8);
                    Objects.toString(arrayList9);
                    arrayList3.size();
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        if (((ItemInfo) it.next()) == null) {
                            it.remove();
                        }
                    }
                    HashSet hashSet = new HashSet();
                    Collections.sort(arrayList3, new C0165i(7));
                    int size = arrayList3.size();
                    int i9 = 0;
                    while (i9 < size) {
                        Object obj = arrayList3.get(i9);
                        int i10 = i9 + 1;
                        ArrayList arrayList12 = arrayList3;
                        ItemInfo itemInfo = (ItemInfo) obj;
                        int i11 = size;
                        long j6 = itemInfo.container;
                        if (j6 == -100) {
                            if (itemInfo.screenId == jLongValue) {
                                arrayList8.add(itemInfo);
                                hashSet.add(Long.valueOf(itemInfo.id));
                            } else {
                                arrayList9.add(itemInfo);
                            }
                        } else if (j6 == -101) {
                            arrayList8.add(itemInfo);
                            hashSet.add(Long.valueOf(itemInfo.id));
                        } else if (hashSet.contains(Long.valueOf(j6))) {
                            arrayList8.add(itemInfo);
                            hashSet.add(Long.valueOf(itemInfo.id));
                        } else {
                            arrayList9.add(itemInfo);
                        }
                        size = i11;
                        arrayList3 = arrayList12;
                        i9 = i10;
                    }
                    int size2 = arrayList5.size();
                    int i12 = 0;
                    while (i12 < size2) {
                        Object obj2 = arrayList5.get(i12);
                        i12++;
                        LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) obj2;
                        if (launcherAppWidgetInfo != null) {
                            int i13 = size2;
                            if (launcherAppWidgetInfo.container == -100 && launcherAppWidgetInfo.screenId == jLongValue) {
                                arrayList10.add(launcherAppWidgetInfo);
                            } else {
                                arrayList11.add(launcherAppWidgetInfo);
                            }
                            size2 = i13;
                            i12 = i12;
                        }
                    }
                    Objects.toString(c0081xM200d2);
                    Objects.toString(c0081xM200d);
                    Objects.toString(c0081x2);
                    Objects.toString(c0081x3);
                    int size3 = c0081xM200d.size();
                    int i14 = 0;
                    while (i14 < size3) {
                        long jKeyAt = c0081xM200d.keyAt(i14);
                        FolderInfo folderInfo = (FolderInfo) c0081xM200d.valueAt(i14);
                        int i15 = size3;
                        ItemInfo itemInfo2 = (ItemInfo) c0081xM200d2.get(jKeyAt);
                        if (itemInfo2 == null || folderInfo == null) {
                            arrayList = arrayList10;
                            c0081x = c0081xM200d;
                        } else {
                            arrayList = arrayList10;
                            c0081x = c0081xM200d;
                            if (itemInfo2.container == -100 && itemInfo2.screenId == jLongValue) {
                                c0081x2.put(jKeyAt, folderInfo);
                            } else {
                                c0081x3.put(jKeyAt, folderInfo);
                            }
                        }
                        i14++;
                        size3 = i15;
                        c0081xM200d = c0081x;
                        arrayList10 = arrayList;
                    }
                    Objects.toString(arrayList8);
                    Collections.sort(arrayList8, new ItemPositionComparator(LauncherAppState.getInstance().f16222e));
                    this.f17243n.m7580x(new BindWorkspaceItemsRunnable(this, launcherModelCallbacks, arrayList7, arrayList8, arrayList10, c0081x2, z6, i8));
                    ArrayList arrayList13 = LauncherModel.mDeferredBindRunnables;
                    synchronized (arrayList13) {
                        arrayList13.clear();
                    }
                    Objects.toString(arrayList9);
                    Collections.sort(arrayList9, new ItemPositionComparator(LauncherAppState.getInstance().f16222e));
                    m8262b(launcherModelCallbacks, arrayList9, arrayList11, c0081x3, z6 ? arrayList13 : null);
                    MergedModelRunnable mergedModelRunnable = new MergedModelRunnable(16, this, launcherModelCallbacks);
                    if (!z6) {
                        this.f17243n.m7580x(mergedModelRunnable);
                    } else {
                        synchronized (arrayList13) {
                            arrayList13.add(mergedModelRunnable);
                        }
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            } catch (Throwable th2) {
                Throwable th = th2;
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8262b(LauncherModelCallbacks launcherModelCallbacks, ArrayList arrayList, ArrayList arrayList2, C0081x c0081x, ArrayList arrayList3) {
        Objects.toString(launcherModelCallbacks);
        Objects.toString(arrayList);
        Objects.toString(c0081x);
        Objects.toString(arrayList3);
        arrayList.size();
        boolean z5 = arrayList3 != null;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 6;
            RunnableC3718ke runnableC3718ke = new RunnableC3718ke(this, launcherModelCallbacks, arrayList, i6, i7 <= size ? 6 : size - i6, 1);
            if (z5) {
                synchronized (arrayList3) {
                    arrayList3.add(runnableC3718ke);
                }
            } else {
                this.f17243n.m7580x(runnableC3718ke);
            }
            i6 = i7;
        }
        if (c0081x.size() > 0) {
            RunnableC0360p runnableC0360p = new RunnableC0360p(this, launcherModelCallbacks, c0081x, 17);
            if (z5) {
                synchronized (arrayList3) {
                    arrayList3.add(runnableC0360p);
                }
            } else {
                this.f17243n.m7580x(runnableC0360p);
            }
        }
        int size2 = arrayList2.size();
        for (int i8 = 0; i8 < size2; i8++) {
            RunnableC0360p runnableC0360p2 = new RunnableC0360p(this, launcherModelCallbacks, (LauncherAppWidgetInfo) arrayList2.get(i8), 18);
            if (z5) {
                arrayList3.add(runnableC0360p2);
            } else {
                this.f17243n.m7580x(runnableC0360p2);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m8263c(C0081x c0081x, ItemInfo itemInfo, ArrayList arrayList) {
        int i6;
        Objects.toString(c0081x);
        Objects.toString(itemInfo);
        Objects.toString(arrayList);
        InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
        int i7 = invariantDeviceProfile.f16712d;
        long j6 = itemInfo.screenId;
        long j7 = itemInfo.container;
        if (j7 == -101) {
            WeakReference weakReference = this.f17243n.f15352t;
            if (weakReference == null || ((LauncherModelCallbacks) weakReference.get()).isAllAppsButtonRank((int) itemInfo.screenId)) {
                itemInfo.toString();
                return false;
            }
            ItemInfo[][] itemInfoArr = (ItemInfo[][]) c0081x.get(-101L);
            long j8 = itemInfo.screenId;
            int i8 = invariantDeviceProfile.f16719k;
            if (j8 >= i8) {
                itemInfo.toString();
                return false;
            }
            if (itemInfoArr == null) {
                ItemInfo[][] itemInfoArr2 = (ItemInfo[][]) Array.newInstance((Class<?>) ItemInfo.class, i8, 1);
                itemInfoArr2[(int) itemInfo.screenId][0] = itemInfo;
                c0081x.put(-101L, itemInfoArr2);
                return true;
            }
            ItemInfo[] itemInfoArr3 = itemInfoArr[(int) j8];
            if (itemInfoArr3[0] == null) {
                itemInfoArr3[0] = itemInfo;
                return true;
            }
            itemInfo.toString();
            Objects.toString(((ItemInfo[][]) c0081x.get(-101L))[(int) itemInfo.screenId][0]);
            return false;
        }
        if (j7 == -100) {
            if (!arrayList.contains(Long.valueOf(j6))) {
                return false;
            }
            boolean zM201f = c0081x.m201f(itemInfo.screenId);
            int i9 = invariantDeviceProfile.f16711c;
            if (!zM201f) {
                c0081x.put(itemInfo.screenId, (ItemInfo[][]) Array.newInstance((Class<?>) ItemInfo.class, i7 + 1, i9 + 1));
            }
            ItemInfo[][] itemInfoArr4 = (ItemInfo[][]) c0081x.get(itemInfo.screenId);
            if ((itemInfo.container != -100 || itemInfo.cellX >= 0) && (i6 = itemInfo.cellY) >= 0) {
                int i10 = itemInfo.cellX;
                if (itemInfo.spanX + i10 <= i7 && i6 + itemInfo.spanY <= i9) {
                    while (true) {
                        int i11 = itemInfo.cellX;
                        if (i10 < itemInfo.spanX + i11) {
                            for (int i12 = itemInfo.cellY; i12 < itemInfo.cellY + itemInfo.spanY; i12++) {
                                if (itemInfoArr4[i10][i12] != null) {
                                    itemInfo.toString();
                                    Objects.toString(itemInfoArr4[i10][i12]);
                                    return false;
                                }
                            }
                            i10++;
                        } else {
                            while (i11 < itemInfo.cellX + itemInfo.spanX) {
                                for (int i13 = itemInfo.cellY; i13 < itemInfo.cellY + itemInfo.spanY; i13++) {
                                    itemInfoArr4[i11][i13] = itemInfo;
                                }
                                i11++;
                            }
                            return true; // jadx dropped this (AOSP checkItemPlacement): cells marked, item placed
                        }
                    }
                }
            }
            itemInfo.toString();
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final void m8264d() {
        synchronized (this.f17243n.f15344l) {
            try {
                LauncherModel launcherModel = this.f17243n;
                if (launcherModel.mLoaderTask == this) {
                    launcherModel.mLoaderTask = null;
                }
                launcherModel.f15347o = false;
                launcherModel.f15348p = true;
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        this.f17239j = null;
    }

    /* JADX INFO: renamed from: f */
    public final void loadAndBindAllApps() {
        if (this.f17243n.f15350r) {
            onlyBindAllApps();
            return;
        }
        Thread.currentThread().getName();
        Looper.myLooper();
        Looper.getMainLooper();
        PackageManager packageManager = this.f17239j.getPackageManager();
        LauncherModel launcherModel = this.f17243n;
        LauncherModelCallbacks launcherModelCallbacks = (LauncherModelCallbacks) launcherModel.f15352t.get();
        if (launcherModelCallbacks != null) {
            List<C2673q> listMo9679i = launcherModel.f15357y.mo9679i();
            C0328n c0328n = launcherModel.f15353u;
            ((ArrayList) c0328n.f1070k).clear();
            ((ArrayList) c0328n.f1071l).clear();
            ((ArrayList) c0328n.f1072m).clear();
            ((ArrayList) c0328n.f1073n).clear();
            for (C2673q c2673q : listMo9679i) {
                List listMo9660b = launcherModel.f15356x.mo9660b(null, c2673q);
                if (listMo9660b != null && !listMo9660b.isEmpty()) {
                    boolean zMo9680j = launcherModel.f15357y.mo9680j(c2673q);
                    for (int i6 = 0; i6 < listMo9660b.size(); i6++) {
                        AbstractC2662f abstractC2662f = (AbstractC2662f) listMo9660b.get(i6);
                        try {
                            ApplicationInfo applicationInfoMo9651a = abstractC2662f.mo9651a();
                            if (applicationInfoMo9651a != null && applicationInfoMo9651a.sourceDir != null) {
                                if ((applicationInfoMo9651a.flags & 8388608) == 0) {
                                    Objects.toString(abstractC2662f.mo9652b());
                                } else {
                                    packageManager.getApplicationInfo(applicationInfoMo9651a.packageName, 0);
                                    launcherModel.f15353u.m851a(new AppInfo(this.f17239j, abstractC2662f, c2673q, launcherModel.f15355w, zMo9680j));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    C0083z c0083zM202c = C0083z.m202c(this.f17239j, c2673q);
                    if (c0083zM202c != null) {
                        launcherModel.m7580x(new MergedModelRunnable(15, this, new MergedModelRunnable(c0083zM202c, listMo9660b, 14, false)));
                    }
                }
            }
            C0328n c0328n2 = launcherModel.f15353u;
            ArrayList arrayList = (ArrayList) c0328n2.f1071l;
            c0328n2.f1071l = new ArrayList();
            launcherModel.f15345m.m7884e(new LoaderBindRunnable(this, launcherModelCallbacks, arrayList, 1));
            C0083z.m203e(this.f17239j, listMo9679i);
        }
        synchronized (this) {
            try {
                if (this.f17241l) {
                    return;
                }
                updateIconCache();
                synchronized (this) {
                    try {
                        if (!this.f17241l) {
                            this.f17243n.f15350r = true;
                        }
                    } catch (Throwable th) {
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                }
            } catch (Throwable th2) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void loadAllAppsAndUpdateIcons() {
        if (!this.f17243n.f15350r) {
            loadAndBindAllApps();
        }
        if (this.f17243n.f15351s) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (LauncherModel.sBgLock) {
            try {
                ArrayList arrayList2 = (ArrayList) this.f17243n.f15353u.f1070k;
                int size = arrayList2.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList2.get(i6);
                    i6++;
                    AppInfo appInfo = (AppInfo) obj;
                    LauncherModel launcherModel = this.f17243n;
                    ComponentName componentName = appInfo.f16329D;
                    C2673q c2673q = appInfo.user;
                    launcherModel.getClass();
                    Objects.toString(componentName);
                    Objects.toString(c2673q);
                    if (LauncherModel.filterItemInfos(LauncherModel.sBgItemsIdMap, new Partner(4, componentName, c2673q)).isEmpty()) {
                        arrayList.add(appInfo);
                    }
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f17243n.addAppsToAllApps(this.f17239j, arrayList);
        this.f17243n.f15351s = true;
    }

    /* JADX INFO: renamed from: h */
    public final void loadAndBindWorkspace() {
        this.f17240k = true;
        if (!this.f17243n.f15349q) {
            loadWorkspace();
            synchronized (this) {
                try {
                    if (this.f17241l) {
                        return;
                    } else {
                        this.f17243n.f15349q = true;
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
        bindWorkspace(-1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 48991. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    /* JADX INFO: renamed from: i */
    public final void loadWorkspace() {
        /*
            Method dump skipped, instruction units count: 4899
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.LoaderTask.loadWorkspace():void");
    }

    /* JADX INFO: renamed from: j */
    public final void onlyBindAllApps() {
        LauncherModel launcherModel = this.f17243n;
        LauncherModelCallbacks launcherModelCallbacks = (LauncherModelCallbacks) launcherModel.f15352t.get();
        if (launcherModelCallbacks == null) {
            return;
        }
        LoaderBindRunnable loaderBindRunnable = new LoaderBindRunnable(this, launcherModelCallbacks, (ArrayList) ((ArrayList) launcherModel.f15353u.f1070k).clone(), 0);
        if (LauncherModel.sWorkerThread.getThreadId() != Process.myTid()) {
            loaderBindRunnable.run();
        } else {
            launcherModel.f15345m.m7884e(loaderBindRunnable);
        }
    }

    /* JADX INFO: renamed from: k */
    public final void runBindSynchronousPage(int i6) {
        LauncherModel launcherModel;
        if (i6 == -1001) {
            throw new RuntimeException("Should not call runBindSynchronousPage() without valid page index");
        }
        LauncherModel launcherModel2 = this.f17243n;
        if (!launcherModel2.f15350r || !launcherModel2.f15349q) {
            throw new RuntimeException("Expecting AllApps and Workspace to be loaded");
        }
        synchronized (launcherModel2.f15344l) {
            launcherModel = this.f17243n;
            if (launcherModel.f15347o) {
                throw new RuntimeException("Error! Background loading is already running");
            }
        }
        launcherModel.f15345m.m7883b();
        bindWorkspace(i6);
        onlyBindAllApps();
    }

    /* JADX INFO: renamed from: l */
    public final void stopLocked() {
        synchronized (this) {
            this.f17241l = true;
            notify();
        }
    }

    /* JADX INFO: renamed from: m */
    public final LauncherModelCallbacks m8272m(LauncherModelCallbacks launcherModelCallbacks) {
        Objects.toString(launcherModelCallbacks);
        synchronized (this.f17243n.f15344l) {
            try {
                if (this.f17241l) {
                    return null;
                }
                WeakReference weakReference = this.f17243n.f15352t;
                if (weakReference == null) {
                    return null;
                }
                LauncherModelCallbacks launcherModelCallbacks2 = (LauncherModelCallbacks) weakReference.get();
                if (launcherModelCallbacks2 != launcherModelCallbacks) {
                    return null;
                }
                if (launcherModelCallbacks2 == null) {
                    return null;
                }
                return launcherModelCallbacks2;
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public final void updateIconCache() {
        try {
            HashSet hashSet = new HashSet();
            synchronized (LauncherModel.sBgLock) {
                try {
                    C0081x c0081x = LauncherModel.sBgItemsIdMap;
                    c0081x.getClass();
                    int i6 = 0;
                    while (i6 < c0081x.size()) {
                        int i7 = i6 + 1;
                        ItemInfo itemInfo = (ItemInfo) c0081x.valueAt(i6);
                        if (itemInfo instanceof ShortcutInfo) {
                            ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                            if (shortcutInfo.hasStatusFlag(3) && shortcutInfo.getTargetComponent() != null) {
                                hashSet.add(shortcutInfo.getTargetComponent().getPackageName());
                            }
                        } else if (itemInfo instanceof LauncherAppWidgetInfo) {
                            LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) itemInfo;
                            if (launcherAppWidgetInfo.hasRestoreFlag(2)) {
                                hashSet.add(launcherAppWidgetInfo.providerName.getPackageName());
                            }
                        }
                        i6 = i7;
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
            hashSet.toString();
            this.f17243n.f15355w.m7997J(hashSet);
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    /* JADX INFO: renamed from: o */
    public final void updateItem(long j6, ContentValues contentValues) {
        Objects.toString(contentValues);
        this.f17239j.getContentResolver().update(Favorites.f15684a, contentValues, "_id= ?", new String[]{Long.toString(j6)});
    }

    /**
     * The body is taken from the original bytecode by PostCompile (it replaces methods that only throw
     * "Method not decompiled"). jadx wrapped the whole method in synchronized (mLock), while the original
     * only holds the lock at the start and the end; holding it while waiting for the UI thread deadlocked.
     */
    @Override // java.lang.Runnable
    public final void run() {
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.LoaderTask.run():void (jadx monitor structure was wrong)");
    }
}
