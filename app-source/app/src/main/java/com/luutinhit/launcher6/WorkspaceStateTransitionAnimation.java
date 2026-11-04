package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.B3 */
/* JADX INFO: loaded from: classes.dex */
public final class WorkspaceStateTransitionAnimation {

    /* JADX INFO: renamed from: a */
    public Launcher f15358a;

    /* JADX INFO: renamed from: b */
    public Workspace f15359b;

    /* JADX INFO: renamed from: c */
    public AnimatorSet f15360c;

    /* JADX INFO: renamed from: d */
    public float[] f15361d;

    /* JADX INFO: renamed from: e */
    public float[] f15362e;

    /* JADX INFO: renamed from: f */
    public float[] f15363f;

    /* JADX INFO: renamed from: g */
    public float[] f15364g;

    /* JADX INFO: renamed from: h */
    public float f15365h;

    /* JADX INFO: renamed from: i */
    public ZoomInInterpolator f15366i = new ZoomInInterpolator();

    /* JADX INFO: renamed from: j */
    public float mSpringLoadedShrinkFactor;

    /* JADX INFO: renamed from: k */
    public float mOverviewModeShrinkFactor;

    /* JADX INFO: renamed from: l */
    public float mWorkspaceScrimAlpha;

    /* JADX INFO: renamed from: m */
    public int mAllAppsTransitionTime;

    /* JADX INFO: renamed from: n */
    public int mOverviewTransitionTime;

    /* JADX INFO: renamed from: o */
    public int mOverlayTransitionTime;

    /* JADX INFO: renamed from: p */
    public boolean f15373p;

    public WorkspaceStateTransitionAnimation(Launcher launcher, Workspace workspace) {
        this.f15358a = launcher;
        this.f15359b = workspace;
        DeviceProfile deviceProfile = launcher.getDeviceProfile();
        Resources resources = launcher.getResources();
        this.mAllAppsTransitionTime = resources.getInteger(R.integer.config_allAppsTransitionTime);
        this.mOverviewTransitionTime = resources.getInteger(R.integer.config_overviewTransitionTime);
        this.mOverlayTransitionTime = resources.getInteger(R.integer.config_overlayTransitionTime);
        this.mSpringLoadedShrinkFactor = resources.getInteger(R.integer.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        this.mOverviewModeShrinkFactor = resources.getInteger(R.integer.config_workspaceOverviewShrinkPercentage) / 100.0f;
        this.mWorkspaceScrimAlpha = resources.getInteger(R.integer.config_workspaceScrimAlpha) / 100.0f;
        this.f15373p = deviceProfile.f16003c;
    }
}
