package com.luutinhit.launcher6;

import B3.RunnableC0054W;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.c3 */
/* JADX INFO: loaded from: classes.dex */
public final class ShortcutContainerRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16337j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ShortcutAndWidgetContainer f16338k;

    public /* synthetic */ ShortcutContainerRunnable(ShortcutAndWidgetContainer shortcutAndWidgetContainer, int i6) {
        this.f16337j = i6;
        this.f16338k = shortcutAndWidgetContainer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map;
        switch (this.f16337j) {
            case 0:
                Launcher launcher = this.f16338k.f16506r;
                if (launcher.autoRearrange) {
                    launcher.rearrangeApps(false);
                }
                break;
            case 1:
                ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.f16338k;
                HashMap map2 = shortcutAndWidgetContainer.f16510v;
                if (map2 != null) {
                    for (View view : (Iterable<View>) (Iterable) (map2.keySet())) {
                        if (view instanceof BubbleTextView) {
                            ((BubbleTextView) view).m7600I();
                        } else if (view instanceof LauncherAppWidgetHostView) {
                            ((LauncherAppWidgetHostView) view).onTouchComplete();
                        }
                        ((ValueAnimator) shortcutAndWidgetContainer.f16510v.get(view)).start();
                    }
                }
                break;
            default:
                ShortcutAndWidgetContainer shortcutAndWidgetContainer2 = this.f16338k;
                if (shortcutAndWidgetContainer2.f16510v != null && (map = shortcutAndWidgetContainer2.f16511w) != null) {
                    for (View view2 : (Iterable<View>) (Iterable) (map.keySet())) {
                        view2.post(new RunnableC0054W(22, this, view2));
                    }
                    break;
                }
                break;
        }
    }
}
