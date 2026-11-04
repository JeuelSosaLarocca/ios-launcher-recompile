package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.luutinhit.launcher6.n2 */
/* JADX INFO: loaded from: classes.dex */
public final class ClingGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16738j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ ViewGroup f16739k;

    public /* synthetic */ ClingGlobalLayoutListener(int i6, ViewGroup viewGroup) {
        this.f16738j = i6;
        this.f16739k = viewGroup;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder;
        ViewGroup viewGroup = this.f16739k;
        switch (this.f16738j) {
            case 0:
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if ("crop_bg_top_and_sides".equals(viewGroup.getTag())) {
                    viewGroup.setTranslationY(-viewGroup.getMeasuredHeight());
                    objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofFloat(viewGroup, "translationY", 0.0f);
                } else {
                    viewGroup.setScaleX(0.0f);
                    viewGroup.setScaleY(0.0f);
                    objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(viewGroup, PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
                }
                objectAnimatorOfPropertyValuesHolder.setDuration(250L);
                objectAnimatorOfPropertyValuesHolder.setInterpolator(new DragInterpolator());
                objectAnimatorOfPropertyValuesHolder.start();
                break;
            default:
                ShortcutAndWidgetContainer shortcutAndWidgetContainer = (ShortcutAndWidgetContainer) viewGroup;
                int measuredWidth = shortcutAndWidgetContainer.getMeasuredWidth();
                DeviceProfile deviceProfile = shortcutAndWidgetContainer.grid;
                shortcutAndWidgetContainer.f16503o = measuredWidth / deviceProfile.inv.f16712d;
                shortcutAndWidgetContainer.f16504p = shortcutAndWidgetContainer.getMeasuredHeight() / deviceProfile.inv.f16711c;
                shortcutAndWidgetContainer.m8039c();
                shortcutAndWidgetContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                break;
        }
    }
}
