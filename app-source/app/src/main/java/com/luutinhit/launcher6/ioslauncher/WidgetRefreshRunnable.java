package com.luutinhit.launcher6.ioslauncher;

import android.view.View;
import com.luutinhit.launcher6.ShortcutAndWidgetContainer;
import com.luutinhit.launcher6.Utilities;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.ioslauncher.d */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetRefreshRunnable implements Runnable {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ IOSLauncher f16586j;

    public WidgetRefreshRunnable(IOSLauncher iOSLauncher) {
        this.f16586j = iOSLauncher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            boolean z5 = Utilities.f16752m;
            IOSLauncher iOSLauncher = this.f16586j;
            if (z5) {
                if (iOSLauncher.mPowerManager != null && !iOSLauncher.mPowerManager.isInteractive()) {
                    return;
                }
            } else if (iOSLauncher.mPowerManager != null && !iOSLauncher.mPowerManager.isScreenOn()) {
                return;
            }
            if (iOSLauncher.getHotseat() != null && iOSLauncher.getHotseat().f15709o) {
                iOSLauncher.getHotseat().setTranslationY(0.0f);
            }
            ArrayList<ShortcutAndWidgetContainer> allShortcutAndWidgetContainers = iOSLauncher.getWorkspace().getAllShortcutAndWidgetContainers();
            int size = allShortcutAndWidgetContainers.size();
            int i6 = 0;
            while (i6 < size) {
                ShortcutAndWidgetContainer shortcutAndWidgetContainer = allShortcutAndWidgetContainers.get(i6);
                i6++;
                ShortcutAndWidgetContainer shortcutAndWidgetContainer2 = shortcutAndWidgetContainer;
                if (shortcutAndWidgetContainer2 != null && shortcutAndWidgetContainer2.f16509u) {
                    Iterator it = shortcutAndWidgetContainer2.f16495B.keySet().iterator();
                    while (it.hasNext()) {
                        ((View) it.next()).setTranslationY(0.0f);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
