package com.luutinhit.launcher6.allapps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.ClickShadowView;
import com.luutinhit.launcher6.DeviceProfile;
import com.luutinhit.launcher6.Launcher;

/* JADX INFO: loaded from: classes.dex */
public class AllAppsRecyclerViewContainerView extends FrameLayout {
    public AllAppsRecyclerViewContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        DeviceProfile deviceProfile = ((Launcher) context).getDeviceProfile();
        ClickShadowView clickShadowView = new ClickShadowView(context);
        int extraSize = clickShadowView.getExtraSize() + deviceProfile.f15998X;
        addView(clickShadowView, extraSize, extraSize);
    }
}
