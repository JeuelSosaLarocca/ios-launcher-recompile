package com.luutinhit.launcher6;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.luutinhit.launcher6.d3 */
/* JADX INFO: loaded from: classes.dex */
public final class GlobalLayoutOnceListener implements ViewTreeObserver.OnGlobalLayoutListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16364j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ShortcutAndWidgetContainer f16365k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Runnable f16366l;

    public /* synthetic */ GlobalLayoutOnceListener(ShortcutAndWidgetContainer shortcutAndWidgetContainer, Runnable runnable, int i6) {
        this.f16364j = i6;
        this.f16365k = shortcutAndWidgetContainer;
        this.f16366l = runnable;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f16364j) {
            case 0:
                ((ShortcutContainerRunnable) this.f16366l).run();
                this.f16365k.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                break;
            default:
                ((ShortcutContainerRunnable) this.f16366l).run();
                this.f16365k.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                break;
        }
    }
}
