package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.AppCompatButton;
import com.luutinhit.launcher6.DeviceProfile;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.util.CustomZoomButton;
import com.luutinhit.launcherios.R;
import p118q3.C2615e;
import p118q3.SharedPreferencesOnSharedPreferenceChangeListenerC2611a;

/* JADX INFO: loaded from: classes.dex */
public class CustomZoomButton extends AppCompatButton {

    /* JADX INFO: renamed from: m */
    public SharedPreferencesOnSharedPreferenceChangeListenerC2611a f16931m;

    /* JADX INFO: renamed from: n */
    public RectF f16932n;

    /* JADX INFO: renamed from: o */
    public int[] f16933o;

    public CustomZoomButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16931m = null;
        this.f16932n = new RectF();
        this.f16933o = new int[2];
        setScaleX(0.0f);
        setScaleY(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
        Launcher launcher = (Launcher) context;
        C2615e blurWallpaperProvider = launcher.getBlurWallpaperProvider();
        blurWallpaperProvider.getClass();
        SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = new SharedPreferencesOnSharedPreferenceChangeListenerC2611a(blurWallpaperProvider, dimensionPixelSize, 4);
        this.f16931m = sharedPreferencesOnSharedPreferenceChangeListenerC2611a;
        setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
        setTextColor(launcher.isDarkMode ? -1 : -16777216);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        DeviceProfile deviceProfile;
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        Context context = getContext();
        if (!(context instanceof Launcher) || (deviceProfile = ((Launcher) context).mDeviceProfile) == null) {
            return;
        }
        int i6 = deviceProfile.f15978D;
        int i7 = deviceProfile.f15976B;
        layoutParams.width = i6;
        layoutParams.height = i7;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a;
        super.onLayout(z5, i6, i7, i8, i9);
        if (!z5 || (sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f16931m) == null) {
            return;
        }
        RectF rectF = this.f16932n;
        rectF.set(0.0f, 0.0f, i8 - i6, i9 - i7);
        sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20532l = true;
        sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20533m.set(rectF);
        int[] iArr = this.f16933o;
        getLocationInWindow(iArr);
        int i10 = iArr[0];
        int i11 = iArr[1];
        sharedPreferencesOnSharedPreferenceChangeListenerC2611a.m9543c(i10);
        sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20537q = iArr[1];
        sharedPreferencesOnSharedPreferenceChangeListenerC2611a.invalidateSelf();
        setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        if (getVisibility() != i6) {
            if (i6 == 0) {
                setEnabled(true);
                int i7 = 1;
                animate().withLayer().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withStartAction(new Runnable() { // from class: B3.m

                    /* JADX INFO: renamed from: k */
                    public /* synthetic */ CustomZoomButton f208k;

                    {
                        this.f208k = CustomZoomButton.this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i7) {
                            case 0:
                                CustomZoomButton.super.setVisibility(8);
                                break;
                            default:
                                CustomZoomButton.super.setVisibility(0);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            } else if (i6 == 4 || i6 == 8) {
                int i8 = 0;
                animate().withLayer().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withEndAction(new Runnable() { // from class: B3.m

                    /* JADX INFO: renamed from: k */
                    public /* synthetic */ CustomZoomButton f208k;

                    {
                        this.f208k = CustomZoomButton.this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i8) {
                            case 0:
                                CustomZoomButton.super.setVisibility(8);
                                break;
                            default:
                                CustomZoomButton.super.setVisibility(0);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            }
        }
    }
}
