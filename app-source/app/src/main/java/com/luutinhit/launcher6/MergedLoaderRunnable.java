package com.luutinhit.launcher6;

import G3.RunnableC0360p;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Rect;
import android.os.DeadObjectException;
import android.os.TransactionTooLargeException;
import android.util.LongSparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import p122r3.AbstractC2659c;
import p122r3.C2673q;
import p122r3.C2674r;
import p154y3.C3033h;

/* JADX INFO: renamed from: com.luutinhit.launcher6.J1 */
/* JADX INFO: loaded from: classes.dex */
public final class MergedLoaderRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f15740j = 1;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ boolean f15741k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Object f15742l;

    /* JADX INFO: renamed from: m */
    public /* synthetic */ Object f15743m;

    public MergedLoaderRunnable(Workspace workspace, CellLayout cellLayout, boolean z5) {
        this.f15742l = workspace;
        this.f15743m = cellLayout;
        this.f15741k = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WidgetPreviewLoader widgetPreviewLoader = null;
        ArrayList arrayList = null;
        LongSparseArray longSparseArray = null;
        int size = 0;
        int i6 = 0;
        C2673q c2673qMo9646h;
        String packageName;
        int i7 = 15;
        boolean z5 = this.f15741k;
        Object obj = this.f15743m;
        Object obj2 = this.f15742l;
        switch (this.f15740j) {
            case 0:
                Launcher launcher = (Launcher) obj2;
                if (!z5) {
                    launcher.exitSpringLoadedDragMode();
                    return;
                } else {
                    launcher.mWidgetsView.setVisibility(8);
                    launcher.showWorkspace(true, (Runnable) obj);
                    return;
                }
            case 1:
                Launcher launcher2 = (Launcher) obj2;
                LauncherModel launcherModel = (LauncherModel) obj;
                if (z5 && !launcherModel.f15354v.f21986h.isEmpty()) {
                    C3033h c3033h = launcherModel.f15354v;
                    c3033h.getClass();
                    launcherModel.f15345m.m7884e(new RunnableC0360p(launcherModel, launcher2, new C3033h(c3033h), i7));
                }
                C3033h c3033h2 = launcherModel.f15354v;
                launcherModel.f15343k.getClass();
                Context context = LauncherAppState.f16216i;
                c3033h2.getClass();
                Rect rect = Utilities.sOldBounds;
                try {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = AbstractC2659c.m9639f(context).mo9642c().iterator();
                    while (it.hasNext()) {
                        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfoFromProviderInfo = LauncherAppWidgetProviderInfo.fromProviderInfo((AppWidgetProviderInfo) it.next());
                        ComponentName componentName = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfoFromProviderInfo).provider;
                        if (componentName == null || !componentName.getPackageName().equals(context.getPackageName())) {
                            arrayList2.add(launcherAppWidgetProviderInfoFromProviderInfo);
                        } else {
                            arrayList2.add(0, launcherAppWidgetProviderInfoFromProviderInfo);
                        }
                    }
                    arrayList2.addAll(context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0));
                    c3033h2.m10276a(arrayList2);
                    while (true) {
                        C2674r c2674r = widgetPreviewLoader.f16865e;
                        if (i6 >= size) {
                            LongSparseArray longSparseArray2 = new LongSparseArray();
                            Cursor cursorM120h = null;
                            try {
                                cursorM120h = widgetPreviewLoader.f16867g.m120h(null, new String[]{"profileId", "packageName", "lastUpdated", "version"}, null);
                                while (cursorM120h.moveToNext()) {
                                    long j6 = cursorM120h.getLong(0);
                                    String string = cursorM120h.getString(1);
                                    long j7 = cursorM120h.getLong(2);
                                    long j8 = cursorM120h.getLong(3);
                                    HashSet hashSet = (HashSet) longSparseArray.get(j6);
                                    if (hashSet != null && hashSet.contains(string)) {
                                        long[] jArrM8185b = widgetPreviewLoader.m8185b(string);
                                        if (jArrM8185b[0] != j8 || jArrM8185b[1] != j7) {
                                        }
                                    }
                                    HashSet hashSet2 = (HashSet) longSparseArray2.get(j6);
                                    if (hashSet2 == null) {
                                        hashSet2 = new HashSet();
                                        longSparseArray2.put(j6, hashSet2);
                                    }
                                    hashSet2.add(string);
                                }
                                for (int i8 = 0; i8 < longSparseArray2.size(); i8++) {
                                    long jKeyAt = longSparseArray2.keyAt(i8);
                                    C2673q c2673qMo9678h = c2674r.mo9678h(jKeyAt);
                                    Iterator it2 = ((HashSet) longSparseArray2.valueAt(i8)).iterator();
                                    while (it2.hasNext()) {
                                        widgetPreviewLoader.removePackage((String) it2.next(), c2673qMo9678h, jKeyAt);
                                    }
                                    break;
                                }
                            } catch (SQLException unused) {
                                if (cursorM120h == null) {
                                    return;
                                }
                            } catch (Throwable th) {
                                if (cursorM120h != null) {
                                    cursorM120h.close();
                                }
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                            }
                            cursorM120h.close();
                            return;
                        }
                        Object obj3 = arrayList.get(i6);
                        i6++;
                        if (obj3 instanceof ResolveInfo) {
                            c2673qMo9646h = C2673q.m9672b();
                            packageName = ((ResolveInfo) obj3).activityInfo.packageName;
                        } else {
                            LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo = (LauncherAppWidgetProviderInfo) obj3;
                            c2673qMo9646h = widgetPreviewLoader.f16866f.mo9646h(launcherAppWidgetProviderInfo);
                            packageName = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).provider.getPackageName();
                        }
                        long jMo9676f = c2674r.mo9676f(c2673qMo9646h);
                        HashSet hashSet3 = (HashSet) longSparseArray.get(jMo9676f);
                        if (hashSet3 == null) {
                            hashSet3 = new HashSet();
                            longSparseArray.put(jMo9676f, hashSet3);
                        }
                        hashSet3.add(packageName);
                    }
                } catch (Exception e) {
                    WeakReference weakReference = LauncherAppState.f16215h;
                    if (!(e.getCause() instanceof TransactionTooLargeException) && !(e.getCause() instanceof DeadObjectException)) {
                        throw e;
                    }
                }
                C3033h c3033h3 = new C3033h(c3033h2);
                launcherModel.f15345m.m7884e(new RunnableC0360p(launcherModel, launcher2, c3033h3, i7));
                widgetPreviewLoader = LauncherAppState.getInstance().f16220c;
                arrayList = c3033h3.f21986h;
                widgetPreviewLoader.getClass();
                Objects.toString(arrayList);
                Rect rect2 = Utilities.sOldBounds;
                longSparseArray = new LongSparseArray();
                size = arrayList.size();
                i6 = 0;
                break;
            default:
                Workspace workspace = (Workspace) obj2;
                if (workspace.V0()) {
                    workspace.f23401C0.remove(-201L);
                    ArrayList arrayList3 = workspace.f23403D0;
                    if (arrayList3 != null) {
                        arrayList3.remove((Object) (-201L));
                        workspace.q1();
                    }
                    workspace.removeView((CellLayout) obj);
                    if (z5) {
                        workspace.n1();
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public MergedLoaderRunnable(LauncherModel launcherModel, boolean z5, Launcher launcher) {
        this.f15743m = launcherModel;
        this.f15741k = z5;
        this.f15742l = launcher;
    }

    public MergedLoaderRunnable(Launcher launcher, boolean z5, Runnable runnable) {
        this.f15742l = launcher;
        this.f15741k = z5;
        this.f15743m = runnable;
    }
}
