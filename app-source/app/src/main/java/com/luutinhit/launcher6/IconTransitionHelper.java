package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.util.CustomIconView;
import com.luutinhit.launcherios.R;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.J2 */
/* JADX INFO: loaded from: classes.dex */
public final class IconTransitionHelper {

    /* JADX INFO: renamed from: a */
    public Launcher f15744a;

    /* JADX INFO: renamed from: b */
    public AppCompatImageView f15745b;

    /* JADX INFO: renamed from: c */
    public int[] f15746c;

    /* JADX INFO: renamed from: d */
    public ObjectAnimator f15747d;

    /* JADX INFO: renamed from: a */
    public final void m7751a(CustomIconView customIconView, Bitmap bitmap) {
        Objects.toString(customIconView);
        Objects.toString(bitmap);
        if (customIconView == null || bitmap == null) {
            return;
        }
        AppCompatImageView appCompatImageView = this.f15745b;
        Launcher launcher = this.f15744a;
        if (appCompatImageView == null) {
            if (appCompatImageView == null) {
                ViewStub viewStub = (ViewStub) launcher.findViewById(R.id.stub_expanded_image_anim);
                if (viewStub != null) {
                    this.f15745b = (AppCompatImageView) viewStub.inflate().findViewById(R.id.expanded_image_anim);
                } else {
                    this.f15745b = (AppCompatImageView) launcher.findViewById(R.id.expanded_image_anim);
                }
            }
            AppCompatImageView appCompatImageView2 = this.f15745b;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(4);
                this.f15745b.setClickable(false);
                this.f15745b.setFocusable(false);
            }
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(launcher.getResources(), bitmap);
        this.f15745b.setVisibility(4);
        this.f15745b.setBackground(bitmapDrawable);
        this.f15745b.setScaleX(5.0f);
        this.f15745b.setScaleY(5.0f);
        DragLayer dragLayer = launcher.getDragLayer();
        int[] iArr = this.f15746c;
        dragLayer.getLocationInDragLayer(customIconView, iArr);
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(-2, -2);
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).leftMargin = iArr[0];
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).topMargin = iArr[1];
        try {
            launcher.getDragLayer().updateViewLayout(this.f15745b, dragLayerLayoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m7752b(LauncherState launcherState, WorkspaceState workspaceState, WorkspaceState workspaceState2, Runnable runnable) {
        Objects.toString(launcherState);
        Objects.toString(workspaceState);
        Objects.toString(workspaceState2);
        Objects.toString(runnable);
        if (launcherState == LauncherState.f16046l || launcherState == LauncherState.f16047m) {
            return;
        }
        Objects.toString(workspaceState);
        Objects.toString(workspaceState2);
        Objects.toString(runnable);
        this.f15744a.closeWidgetView(true);
    }
}
