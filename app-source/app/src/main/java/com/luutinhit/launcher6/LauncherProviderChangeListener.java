package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.D2 */
/* JADX INFO: loaded from: classes.dex */
public interface LauncherProviderChangeListener {
    void onAppWidgetHostReset();

    void onLauncherProviderChange();

    void onSettingsChanged(String str, boolean z5);
}
