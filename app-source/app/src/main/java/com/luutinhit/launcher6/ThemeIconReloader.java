package com.luutinhit.launcher6;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;

/**
 * Reloads every app icon when the system switches between light and dark theme.
 *
 * The per-app icons have a light (drawable/) and a dark (drawable-night/) version, but the icon
 * cache (memory and app_icons.db) keeps the bitmaps it already made. On a theme change the cache
 * is emptied and the model reloads through the same path as a locale change.
 * Added for the recompiled copy; registered from LauncherAppState.getInstance().
 */
final class ThemeIconReloader implements ComponentCallbacks {
    private static final String PREF_NIGHT_MODE = "icons_night_mode";

    private final Context context;
    private int nightMode;

    private ThemeIconReloader(Context context, int nightMode) {
        this.context = context;
        this.nightMode = nightMode;
    }

    static void register(Context context) {
        int mode = nightMode(context.getResources().getConfiguration());
        // the theme may have changed while the launcher was not running
        SharedPreferences prefs = context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0);
        if (prefs.getInt(PREF_NIGHT_MODE, -1) != mode) {
            clearIconCache();
            prefs.edit().putInt(PREF_NIGHT_MODE, mode).apply();
        }
        context.registerComponentCallbacks(new ThemeIconReloader(context, mode));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        int mode = nightMode(newConfig);
        if (mode == nightMode) {
            return;
        }
        nightMode = mode;
        context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0).edit().putInt(PREF_NIGHT_MODE, mode).apply();
        clearIconCache();
        LauncherAppState app = LauncherAppState.f16217j;
        if (app != null && app.f16218a != null) {
            app.f16218a.onReceive(context, new Intent(Intent.ACTION_LOCALE_CHANGED));
        }
    }

    @Override
    public void onLowMemory() {
    }

    private static int nightMode(Configuration config) {
        return config.uiMode & Configuration.UI_MODE_NIGHT_MASK;
    }

    private static void clearIconCache() {
        LauncherAppState app = LauncherAppState.f16217j;
        if (app == null || app.f16219b == null) {
            return;
        }
        IconCache iconCache = app.f16219b;
        synchronized (iconCache) {
            iconCache.f16352k.clear();
            // package -> iOS drawable assignments: each iOS icon is given to one app only (IconCache.m8023y),
            // so without this the apps that already had one fall back to their own icon on the reload
            iconCache.f16346e.clear();
        }
        iconCache.f16344c.m113a(null, null);
    }
}
