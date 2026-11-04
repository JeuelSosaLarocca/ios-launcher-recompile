package com.luutinhit.wallpaper.livewallpaper;

import android.service.wallpaper.WallpaperService;
import p070e4.SharedPreferencesOnSharedPreferenceChangeListenerC1997d;

/* JADX INFO: loaded from: classes.dex */
public class LiveWallpaperService extends WallpaperService {

    /* JADX INFO: renamed from: j */
    public int f17655j = 0;

    @Override // android.service.wallpaper.WallpaperService
    public final WallpaperService.Engine onCreateEngine() {
        return new SharedPreferencesOnSharedPreferenceChangeListenerC1997d(this);
    }
}
