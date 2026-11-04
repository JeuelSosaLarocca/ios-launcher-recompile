package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.luutinhit.launcherios.R;
import java.util.Objects;
import p118q3.C2615e;
import p118q3.InterfaceC2614d;
import p118q3.SharedPreferencesOnSharedPreferenceChangeListenerC2611a;

/* JADX INFO: loaded from: classes.dex */
public class Hotseat extends FrameLayout implements LaunchSourceProvider, InterfaceC2614d {

    /* JADX INFO: renamed from: j */
    public RectF f15704j;

    /* JADX INFO: renamed from: k */
    public DeviceProfile grid;

    /* JADX INFO: renamed from: l */
    public CellLayout mContent;

    /* JADX INFO: renamed from: m */
    public Launcher f15707m;

    /* JADX INFO: renamed from: n */
    public boolean f15708n;

    /* JADX INFO: renamed from: o */
    public boolean f15709o;

    /* JADX INFO: renamed from: p */
    public int f15710p;

    /* JADX INFO: renamed from: q */
    public SharedPreferencesOnSharedPreferenceChangeListenerC2611a f15711q;

    /* JADX INFO: renamed from: r */
    public Rect f15712r;

    /* JADX INFO: renamed from: s */
    public int f15713s;

    /* JADX INFO: renamed from: t */
    public int f15714t;

    /* JADX INFO: renamed from: u */
    public float f15715u;

    /* JADX INFO: renamed from: v */
    public LiquidGlassSurfaceView f15716v;

    /* JADX INFO: renamed from: w */
    public RuntimeShaderGlassView f15717w;

    public Hotseat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f15704j = new RectF();
        this.f15709o = false;
        this.f15712r = new Rect();
        this.f15715u = -1.0f;
        Launcher launcher = (Launcher) context;
        this.f15707m = launcher;
        DeviceProfile deviceProfile = launcher.getDeviceProfile();
        this.grid = deviceProfile;
        this.f15713s = deviceProfile.getCurrentHeight();
        boolean zM131a = launcher.getTinyDB().m131a("iphone_8_style");
        this.f15708n = zM131a;
        if (launcher.isUseLiquidGlass) {
            if (launcher.getBlurWallpaperProvider() != null) {
                launcher.getBlurWallpaperProvider().m9546b(this);
            }
        } else {
            float dimensionPixelSize = zM131a ? 0.0f : getResources().getDimensionPixelSize(R.dimen.hotseat_background_corner);
            C2615e blurWallpaperProvider = launcher.getBlurWallpaperProvider();
            blurWallpaperProvider.getClass();
            this.f15711q = new SharedPreferencesOnSharedPreferenceChangeListenerC2611a(blurWallpaperProvider, dimensionPixelSize, 1);
        }
    }

    @Override // com.luutinhit.launcher6.LaunchSourceProvider
    /* JADX INFO: renamed from: D */
    public final void mo7690D(View view, Bundle bundle) {
        bundle.putString("container", "hotseat");
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: a */
    public final void mo7593a() {
        post(new MergedIdleRunnable(5, this));
    }

    public Bitmap getBlurGlassWallpaper() {
        Launcher launcher = this.f15707m;
        C2615e blurWallpaperProvider = launcher.getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f20556f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.f20555e;
        }
        if (bitmap == null) {
            return launcher.getBlurWallpaperProvider().f20557g;
        }
        bitmap.toString();
        return bitmap;
    }

    public CellLayout getLayout() {
        this.mContent.getShortcutsAndWidgets().getChildCount();
        return this.mContent;
    }

    public ShortcutAndWidgetContainer getShortcutsAndWidgets() {
        return this.mContent.getShortcutsAndWidgets();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        DeviceProfile deviceProfile = this.grid;
        this.f15710p = deviceProfile.inv.f16720l;
        this.mContent = (CellLayout) findViewById(R.id.layout);
        Launcher launcher = this.f15707m;
        if (launcher.isUseLiquidGlass) {
            if (launcher.isRuntimeRenderSupport) {
                setLayerType(2, null);
                RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher, false);
                this.f15717w = runtimeShaderGlassView;
                runtimeShaderGlassView.setLayerType(2, null);
                this.f15717w.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                this.f15717w.setSdfTexture(R.drawable.long_round);
                addView(this.f15717w, 0);
            } else {
                LiquidGlassSurfaceView liquidGlassSurfaceView = new LiquidGlassSurfaceView(launcher, 0.45f);
                this.f15716v = liquidGlassSurfaceView;
                liquidGlassSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                LiquidGlassSurfaceView liquidGlassSurfaceView2 = this.f15716v;
                int i6 = launcher.screenWidth;
                int i7 = launcher.screenHeight;
                liquidGlassSurfaceView2.f15805l = i6;
                liquidGlassSurfaceView2.f15806m = i7;
                liquidGlassSurfaceView2.f15815v = false;
                this.f15716v.setSdfTexture(R.drawable.long_round);
                addView(this.f15716v, 0);
            }
        }
        this.mContent.setGridSize(deviceProfile.inv.f16719k, 1);
        this.mContent.setIsHotseat(true);
        CellLayout cellLayout = this.mContent;
        int i8 = deviceProfile.f15977C;
        cellLayout.setPadding(i8, 0, i8, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f15707m.getWorkspace().t1();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        Rect rect = this.f15712r;
        super.onLayout(z5, i6, i7, i8, i9);
        int width = getWidth();
        int height = getHeight();
        if (!z5 || width <= 0 || height <= 0) {
            return;
        }
        try {
            this.f15714t = i7;
            if (Utilities.f16755p) {
                rect.set(0, 0, width, height);
                setClipBounds(rect);
            }
            RectF rectF = this.f15704j;
            DeviceProfile deviceProfile = this.grid;
            float f6 = deviceProfile.f15977C;
            float f7 = deviceProfile.f15996V;
            rectF.set(f6 - f7, 0.0f, (width - f6) + f7, height);
            if (this.f15708n) {
                rectF.setEmpty();
                return;
            }
            if (this.f15716v != null) {
                Objects.toString(rectF);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15716v.getLayoutParams();
                layoutParams.width = (int) rectF.width();
                layoutParams.height = (int) rectF.height();
                layoutParams.gravity = 81;
                this.f15716v.setLayoutParams(layoutParams);
                this.f15716v.updatePositionAndRender();
                return;
            }
            if (this.f15717w != null) {
                Objects.toString(rectF);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f15717w.getLayoutParams();
                layoutParams2.width = (int) rectF.width();
                layoutParams2.height = (int) rectF.height();
                layoutParams2.gravity = 81;
                this.f15717w.setLayoutParams(layoutParams2);
                this.f15717w.updateGlViewPosition();
                return;
            }
            SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f15711q;
            if (sharedPreferencesOnSharedPreferenceChangeListenerC2611a != null) {
                this.f15715u = rectF.left;
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20532l = true;
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20533m.set(rectF);
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.m9543c(rectF.left);
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20537q = i7;
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.invalidateSelf();
                setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mContent.setOnLongClickListener(onLongClickListener);
    }

    @Override // android.view.View
    public void setTranslationX(float f6) {
        super.setTranslationX(f6);
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15716v;
        if (liquidGlassSurfaceView != null) {
            liquidGlassSurfaceView.setScrollOffset(f6);
            return;
        }
        RuntimeShaderGlassView runtimeShaderGlassView = this.f15717w;
        if (runtimeShaderGlassView != null) {
            runtimeShaderGlassView.setScrollOffset(f6 + this.f15704j.left);
            return;
        }
        SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f15711q;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC2611a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC2611a.m9543c(f6 + this.f15715u);
        }
    }

    public void setUseTransparency(boolean z5) {
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: q */
    public final void mo7594q() {
    }
}
