package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.UserManager;
import android.util.AttributeSet;
import android.util.Pair;
import com.luutinhit.launcherios.R;
import p122r3.C2673q;

/* JADX INFO: loaded from: classes.dex */
public class UninstallDropTarget extends ButtonDropTarget {

    /* JADX INFO: renamed from: w */
    public static final /* synthetic */ int f15974w = 0;

    public UninstallDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: F */
    public static Pair getAppInfoFlags(Object obj) {
        if (obj instanceof AppInfo) {
            AppInfo appInfo = (AppInfo) obj;
            return Pair.create(appInfo.f16329D, Integer.valueOf(appInfo.f16331F));
        }
        if (!(obj instanceof ShortcutInfo)) {
            return null;
        }
        ShortcutInfo shortcutInfo = (ShortcutInfo) obj;
        ComponentName targetComponent = shortcutInfo.getTargetComponent();
        if (shortcutInfo.itemType != 0 || targetComponent == null) {
            return null;
        }
        return Pair.create(targetComponent, Integer.valueOf(shortcutInfo.f16562J));
    }

    /* JADX INFO: renamed from: G */
    public static boolean startUninstallActivity(Launcher launcher, Object obj) {
        Pair appInfoFlags = getAppInfoFlags(obj);
        return launcher.startApplicationUninstallActivity((ComponentName) appInfoFlags.first, ((Integer) appInfoFlags.second).intValue(), ((ItemInfo) obj).user);
    }

    /* JADX INFO: renamed from: H */
    public static boolean supportsDrop(Context context, Object obj) {
        if (Utilities.f16755p) {
            Bundle userRestrictions = ((UserManager) context.getSystemService("user")).getUserRestrictions();
            if (userRestrictions.getBoolean("no_control_apps", false) || userRestrictions.getBoolean("no_uninstall_apps", false)) {
                return false;
            }
        }
        Pair appInfoFlags = getAppInfoFlags(obj);
        return (appInfoFlags == null || (((Integer) appInfoFlags.second).intValue() & 1) == 0) ? false : true;
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    /* JADX INFO: renamed from: A */
    public final void mo7604A(DragObject dragObject) {
        Pair appInfoFlags = getAppInfoFlags(dragObject.f16523g);
        Object obj = dragObject.f16523g;
        C2673q c2673q = ((ItemInfo) obj).user;
        if (startUninstallActivity(this.mLauncher, obj)) {
            this.mLauncher.addOnResumeCallback(new RunnableC0031a(this, appInfoFlags, c2673q, dragObject, 18, false));
        } else {
            DragSource dragSource = dragObject.f16524h;
            if (dragSource instanceof UninstallSource) {
                ((UninstallSource) dragSource).mo7713w(false);
            }
        }
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget
    /* JADX INFO: renamed from: D */
    public final boolean mo7606D(DragSource dragSource, Object obj) {
        return supportsDrop(getContext(), obj);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f15419p = getResources().getColor(R.color.uninstall_target_hover_tint);
        setDrawable(2131231107);
    }

    @Override // com.luutinhit.launcher6.ButtonDropTarget, com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: s */
    public final void mo7611s(DragObject dragObject) {
        DragSource dragSource = dragObject.f16524h;
        if (dragSource instanceof UninstallSource) {
            ((UninstallSource) dragSource).mo7709a();
        }
        super.mo7611s(dragObject);
    }
}
