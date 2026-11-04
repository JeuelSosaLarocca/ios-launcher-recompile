package com.luutinhit.launcher6.ioslauncher;

import B3.AbstractC0075r;
import B3.C0046N;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import com.luutinhit.launcher6.LauncherCallbacks;
import com.luutinhit.wallpaper.livewallpaper.LiveWallpaperService;

/* JADX INFO: renamed from: com.luutinhit.launcher6.ioslauncher.f */
/* JADX INFO: loaded from: classes.dex */
public final class IOSLauncherCallbacks implements LauncherCallbacks {

    /* JADX INFO: renamed from: a */
    public /* synthetic */ IOSLauncher f16589a;

    public IOSLauncherCallbacks(IOSLauncher iOSLauncher) {
        this.f16589a = iOSLauncher;
    }

    /* JADX INFO: renamed from: a */
    public final void m8078a() {
        IOSLauncher iOSLauncher = this.f16589a;
        iOSLauncher.mTinyDB = iOSLauncher.getTinyDB();
        iOSLauncher.mWallpaperManager = WallpaperManager.getInstance(iOSLauncher);
        iOSLauncher.mRequestSetDefaultLauncher = new C0046N(iOSLauncher);
        if (iOSLauncher.mTinyDB.m131a("parallax_zoom_animations")) {
            Intent intent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
            intent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(iOSLauncher, (Class<?>) LiveWallpaperService.class));
            iOSLauncher.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8079b() {
        IOSLauncher iOSLauncher = this.f16589a;
        if (iOSLauncher.mCountOpenControlView != iOSLauncher.mNumberShowRateDialog || iOSLauncher.mTinyDB.m131a("not_show_exit_dialog")) {
            iOSLauncher.mCountOpenControlView++;
        } else {
            iOSLauncher.startRatingActivity();
            iOSLauncher.mCountOpenControlView = 0;
            iOSLauncher.mNumberShowRateDialog += 8;
        }
        if (Build.VERSION.SDK_INT >= 33 && !AbstractC0075r.m195p(iOSLauncher)) {
            int wallpaperId = iOSLauncher.mWallpaperManager.getWallpaperId(1);
            WallpaperManager wallpaperManager = iOSLauncher.mWallpaperManager;
            if ((wallpaperManager == null || wallpaperManager.getWallpaperInfo() == null || !iOSLauncher.getPackageName().equalsIgnoreCase(iOSLauncher.mWallpaperManager.getWallpaperInfo().getPackageName())) && wallpaperId != iOSLauncher.mTinyDB.f137a.getInt("wallpaper_id", -1)) {
                iOSLauncher.setOrRestoreWallpaper();
                iOSLauncher.showSuggestWallpaperChangeDialog();
            }
        }
        iOSLauncher.checkHideNavigation();
    }
}
