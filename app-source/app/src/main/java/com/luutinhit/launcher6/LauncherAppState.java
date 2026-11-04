package com.luutinhit.launcher6;

import B3.C0061d;
import J1.C0508N;
import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.luutinhit.launcherios.R;
import java.lang.ref.WeakReference;
import java.util.Objects;
import p101l3.C2339d;
import p122r3.AbstractC2666j;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.a2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherAppState {

    /* JADX INFO: renamed from: h */
    public static WeakReference f16215h = new WeakReference(null);

    /* JADX INFO: renamed from: i */
    public static Context f16216i;

    /* JADX INFO: renamed from: j */
    public static LauncherAppState f16217j;

    /* JADX INFO: renamed from: a */
    public LauncherModel f16218a;

    /* JADX INFO: renamed from: b */
    public IconCache f16219b;

    /* JADX INFO: renamed from: c */
    public WidgetPreviewLoader f16220c;

    /* JADX INFO: renamed from: d */
    public boolean f16221d;

    /* JADX INFO: renamed from: e */
    public InvariantDeviceProfile f16222e;

    /* JADX INFO: renamed from: f */
    public C2339d f16223f;

    /* JADX INFO: renamed from: g */
    public Launcher f16224g;

    public LauncherAppState() {
        Context context = f16216i;
        if (context == null) {
            throw new IllegalStateException("LauncherAppState inited before app context set");
        }
        InvariantDeviceProfile invariantDeviceProfile = new InvariantDeviceProfile(context);
        this.f16222e = invariantDeviceProfile;
        IconCache iconCache = new IconCache(f16216i, invariantDeviceProfile);
        this.f16219b = iconCache;
        this.f16220c = new WidgetPreviewLoader(f16216i, iconCache);
        String string = f16216i.getString(R.string.app_filter_class);
        if (!TextUtils.isEmpty(string)) {
            try {
                if (Class.forName(string).newInstance() != null) {
                    throw new ClassCastException();
                }
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
            }
        }
        LauncherModel launcherModel = new LauncherModel(this, this.f16219b);
        this.f16218a = launcherModel;
        AbstractC2666j.m9657c(f16216i).mo9659a(launcherModel);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.search.action.GLOBAL_SEARCH_ACTIVITY_CHANGED");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_ADDED");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_AVAILABLE");
        intentFilter.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_UPDATE_LABEL");
        intentFilter.addAction("com.luutinhit.launcherios.ACTION_UPDATE_CATEGORY");
        boolean z5 = Utilities.f16749j;
        if (z5) {
            f16216i.registerReceiver(launcherModel, intentFilter, 2);
        } else {
            f16216i.registerReceiver(launcherModel, intentFilter);
        }
        C2674r.m9673e(f16216i).mo9674a();
        C0061d c0061d = new C0061d(f16216i);
        Context context2 = c0061d.f160a;
        if (z5) {
            context2.registerReceiver(c0061d, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"), 2);
        } else {
            context2.registerReceiver(c0061d, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.WALLPAPER_CHANGED");
        intentFilter2.addAction("com.luutinhit.launcherios.MY_ACTION_WALLPAPER_CHANGED");
        if (z5) {
            f16216i.registerReceiver(new C0508N(2), intentFilter2, 2);
        } else {
            f16216i.registerReceiver(new C0508N(2), intentFilter2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static LauncherAppState getInstance() {
        com.luutinhit.launcher6.JadxSupport.useSource(); // changed on purpose: icons follow the system light/dark theme
        if (f16217j == null) {
            f16217j = new LauncherAppState();
            ThemeIconReloader.register(f16216i);
        }
        return f16217j;
    }

    /* JADX INFO: renamed from: c */
    public static LauncherProvider getLauncherProvider() {
        return (LauncherProvider) f16215h.get();
    }

    /* JADX INFO: renamed from: b */
    public final InvariantDeviceProfile getInvariantDeviceProfile() {
        return this.f16222e;
    }

    /* JADX INFO: renamed from: d */
    public final LauncherModel m7931d(Launcher launcher) {
        if (getLauncherProvider() == null && launcher != null) {
            try {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = launcher.getContentResolver().acquireContentProviderClient("com.luutinhit.launcherios.settings");
                if (contentProviderClientAcquireContentProviderClient != null) {
                    try {
                        ContentProvider localContentProvider = contentProviderClientAcquireContentProviderClient.getLocalContentProvider();
                        if (localContentProvider instanceof LauncherProvider) {
                            f16215h = new WeakReference((LauncherProvider) localContentProvider);
                        }
                    } catch (Throwable th) {
                        try {
                            SyntheticHelpers.m7919r(contentProviderClientAcquireContentProviderClient);
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                }
                if (contentProviderClientAcquireContentProviderClient != null) {
                    SyntheticHelpers.m7919r(contentProviderClientAcquireContentProviderClient);
                }
            } catch (Throwable unused) {
            }
        }
        LauncherProvider launcherProvider = getLauncherProvider();
        launcherProvider.f15838j = launcher;
        launcherProvider.f15839k.f15443n = launcher;
        LauncherModel launcherModel = this.f16218a;
        launcherModel.getClass();
        Objects.toString(launcher);
        synchronized (launcherModel.f15344l) {
            launcherModel.unbindItemInfosAndClearQueuedBindRunnables();
            launcherModel.f15352t = new WeakReference(launcher);
        }
        this.f16223f = (launcher == null || !Utilities.f16752m) ? null : new C2339d(launcher);
        return this.f16218a;
    }
}
