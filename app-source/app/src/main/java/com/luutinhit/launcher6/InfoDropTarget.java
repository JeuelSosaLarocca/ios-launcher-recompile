package com.luutinhit.launcher6;

import android.content.ComponentName;
import android.content.Context;
import android.util.AttributeSet;
import com.luutinhit.launcherios.R;
import p122r3.C2673q;

/* JADX INFO: loaded from: classes.dex */
public class InfoDropTarget extends ButtonDropTarget {
    public InfoDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: F */
    public static void startDetailsActivityForInfo(Launcher launcher, Object obj) {
        ComponentName component;
        if (obj instanceof AppInfo) {
            component = ((AppInfo) obj).f16329D;
        } else if (obj instanceof ShortcutInfo) {
            component = ((ShortcutInfo) obj).f16553A.getComponent();
        } else {
            component = obj instanceof PendingAddItemInfo ? ((PendingAddItemInfo) obj).componentName : null;
        }
        C2673q c2673qM9672b = obj instanceof ItemInfo ? ((ItemInfo) obj).user : C2673q.m9672b();
        if (component != null) {
            launcher.startApplicationDetailsActivity(component, c2673qM9672b);
        }
    }

    /* JADX INFO: renamed from: G */
    public static boolean m7746G(Object obj) {
        boolean z5 = (obj instanceof AppInfo) || (obj instanceof PendingAddItemInfo);
        if (obj instanceof ShortcutInfo) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) obj;
            if (LauncherAppState.getInstance().f16222e.f16710b) {
                return shortcutInfo.itemType == 0;
            }
        }
        return z5;
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    /* JADX INFO: renamed from: A */
    public final void mo7604A(DragObject dragObject) {
        startDetailsActivityForInfo(this.mLauncher, dragObject.f16523g);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    /* JADX INFO: renamed from: D */
    public final boolean mo7606D(DragSource dragSource, Object obj) {
        if (!dragSource.mo7711r()) {
            return false;
        }
        getContext();
        return m7746G(obj);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f15419p = getResources().getColor(R.color.info_target_hover_tint);
        setDrawable(2131231032);
    }
}
