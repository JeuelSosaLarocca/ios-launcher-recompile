package com.luutinhit.launcher6;

import B3.AbstractC0075r;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.ioslauncher.IOSLauncherCallbacks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import p118q3.C2615e;
import p122r3.AbstractC2666j;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.A1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherActionReceiver extends BroadcastReceiver {


    /* JADX INFO: renamed from: a */
    public /* synthetic */ int f15293a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f15294b;

    public /* synthetic */ LauncherActionReceiver(int i6, Object obj) {
        this.f15293a = i6;
        this.f15294b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f15293a) {
            case 0:
                String action = intent.getAction();
                boolean zEquals = "android.intent.action.SCREEN_OFF".equals(action);
                Launcher launcher = (Launcher) this.f15294b;
                if (zEquals) {
                    launcher.mHandler.sendMessage(launcher.mHandler.obtainMessage(2));
                    return;
                }
                if ("android.intent.action.USER_PRESENT".equals(action)) {
                    launcher.mUserPresent = true;
                    launcher.updateAutoAdvanceState();
                    return;
                }
                if ("com.luutinhit.launcherios.ACTION_SET_BACKGROUND".equals(action)) {
                    C2615e c2615e = launcher.mBlurWallpaperProvider;
                    c2615e.getClass();
                    Utilities.f16756q.execute(c2615e.f20568r);
                    return;
                }
                if ("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE".equals(action)) {
                    try {
                        LauncherModel.sBgWidgetProviders = new HashSet(Arrays.asList(intent.getStringArrayExtra("HIDDEN_APPS_REMOVED")));
                        return;
                    } catch (Throwable th) {
                        th.getMessage();
                        return;
                    }
                }
                if ("com.luutinhit.launcherios.ACTION_RELOAD_WIDGET".equals(action)) {
                    Workspace workspace = launcher.mWorkspace;
                    if (workspace != null) {
                        workspace.getCustomContentCallbacks().getClass();
                        return;
                    }
                    return;
                }
                if (!"com.luutinhit.launcherios.ACTION_FORCE_RELOAD_LAUNCHER".equals(action)) {
                    if ("com.luutinhit.SCREEN_UNLOCK".equals(action)) {
                        IOSLauncher iOSLauncher = ((IOSLauncherCallbacks) launcher.mLauncherCallbacks).f16589a;
                        if (iOSLauncher.isUnlockAnim) {
                            iOSLauncher.prepareOpenAnimation(true);
                            iOSLauncher.startPlayOpenAnimation();
                            return;
                        }
                        return;
                    }
                    return;
                }
                launcher.getHotseat().getLayout().getShortcutsAndWidgets().removeAllViews();
                LauncherModel launcherModel = launcher.mModel;
                launcherModel.m7579w(true);
                LauncherModelCallbacks callback = launcherModel.getCallback();
                if (callback == null || callback.setLoadOnResume()) {
                    return;
                }
                launcherModel.startLoader(-1001, 0);
                return;
            case 1:
                Objects.toString(context);
                Objects.toString(intent);
                ((Launcher) this.f15294b).closeSystemDialogs();
                return;
            default:
                Objects.toString(context);
                Objects.toString(intent);
                synchronized (LauncherModel.sBgLock) {
                    try {
                        ((LauncherModel) this.f15294b).f15343k.getClass();
                        AbstractC2666j abstractC2666jM9657c = AbstractC2666j.m9657c(LauncherAppState.f16216i);
                        PackageManager packageManager = context.getPackageManager();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        for (Map.Entry entry : (Iterable<Map.Entry>) (Iterable) (LauncherModel.sPendingPackages.entrySet())) {
                            C2673q c2673q = (C2673q) entry.getKey();
                            arrayList.clear();
                            arrayList2.clear();
                            for (String str : (Iterable<String>) (Iterable) ((HashSet) entry.getValue())) {
                                if (!abstractC2666jM9657c.mo9662f(str, c2673q)) {
                                    if (AbstractC0075r.m189j(packageManager, str, 8192)) {
                                        arrayList2.add(str);
                                    } else {
                                        Launcher.addDumpLog("LauncherModel", "Package not found: " + str, true);
                                        arrayList.add(str);
                                    }
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                LauncherModel launcherModel2 = (LauncherModel) this.f15294b;
                                PackageUpdatedTask packageUpdatedTask = new PackageUpdatedTask(launcherModel2, 3, (String[]) arrayList.toArray(new String[0]), c2673q);
                                launcherModel2.getClass();
                                LauncherModel.enqueuePackageUpdated(packageUpdatedTask);
                            }
                            if (!arrayList2.isEmpty()) {
                                LauncherModel launcherModel3 = (LauncherModel) this.f15294b;
                                PackageUpdatedTask packageUpdatedTask2 = new PackageUpdatedTask(launcherModel3, 4, (String[]) arrayList2.toArray(new String[0]), c2673q);
                                launcherModel3.getClass();
                                LauncherModel.enqueuePackageUpdated(packageUpdatedTask2);
                            }
                        }
                        LauncherModel.sPendingPackages.clear();
                    } catch (Throwable th2) {
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                    }
                    break;
                }

        }
    }
}
