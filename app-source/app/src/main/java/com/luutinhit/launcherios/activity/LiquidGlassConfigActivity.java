package com.luutinhit.launcherios.activity;

import G3.C0364t;
import P3.AbstractActivityC0816d;
import P3.C0824l;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.util.RealTimeBlurRoundedView;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.customsettings.SwitchView;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class LiquidGlassConfigActivity extends AbstractActivityC0816d {

    /* JADX INFO: renamed from: J */
    public static final int[] f17384J = {-7829368, 0, -7829368, 0, -7829368};

    /* JADX INFO: renamed from: K */
    public static final float[] f17385K = {0.0f, 0.125f, 0.5f, 0.625f, 1.0f};

    /* JADX INFO: renamed from: D */
    public RealTimeBlurRoundedView f17386D;

    /* JADX INFO: renamed from: E */
    public AppCompatSeekBar f17387E;

    /* JADX INFO: renamed from: F */
    public SwitchView f17388F;

    /* JADX INFO: renamed from: G */
    public SharedPreferences f17389G;

    /* JADX INFO: renamed from: H */
    public int f17390H = 0;

    /* JADX INFO: renamed from: I */
    public boolean f17391I = false;

    /* JADX INFO: renamed from: K */
    public final void m8303K(int i6) {
        boolean z5;
        float f6 = i6 / 100.0f;
        int iMax = Math.max(2, Math.round(5.0f * f6));
        int iMax2 = Math.max(2, Math.round(f6 * 10.0f));
        RealTimeBlurRoundedView realTimeBlurRoundedView = this.f17386D;
        realTimeBlurRoundedView.getClass();
        boolean z6 = true;
        if (iMax <= 0) {
            iMax = 1;
        }
        if (realTimeBlurRoundedView.f16965m != iMax) {
            realTimeBlurRoundedView.f16965m = iMax;
            realTimeBlurRoundedView.f16971s = true;
            z5 = true;
        } else {
            z5 = false;
        }
        float f7 = iMax2;
        if (realTimeBlurRoundedView.f16970r != f7) {
            realTimeBlurRoundedView.f16970r = f7;
        } else {
            z6 = z5;
        }
        if (z6) {
            realTimeBlurRoundedView.invalidate();
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_liquid_glass_config);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17389G = getSharedPreferences(C2234v.m8924b(this), 0);
        RealTimeBlurRoundedView realTimeBlurRoundedView = (RealTimeBlurRoundedView) findViewById(R.id.sample_search_view);
        this.f17386D = realTimeBlurRoundedView;
        realTimeBlurRoundedView.setAutoCropToBlurredView(true);
        this.f17386D.setStrokeWidth(3.0f);
        RealTimeBlurRoundedView realTimeBlurRoundedView2 = this.f17386D;
        int[] iArr = f17384J;
        float[] fArr = f17385K;
        realTimeBlurRoundedView2.f16959O = iArr;
        realTimeBlurRoundedView2.f16960P = fArr;
        realTimeBlurRoundedView2.f16961Q = true;
        realTimeBlurRoundedView2.updateBorderGradient();
        realTimeBlurRoundedView2.invalidate();
        this.f17386D.setBlurredView(findViewById(R.id.sample_image_view));
        this.f17387E = (AppCompatSeekBar) findViewById(R.id.liquid_glass_change);
        this.f17388F = (SwitchView) findViewById(R.id.switch_enable_liquid_glass);
        int i6 = this.f17389G.getInt("preference_liquid_glass_progress", 0);
        boolean z5 = this.f17389G.getBoolean("preference_liquid_glass", false);
        this.f17390H = i6;
        this.f17391I = z5;
        this.f17388F.setChecked(z5);
        this.f17387E.setProgress(i6);
        this.f17387E.setEnabled(z5);
        this.f17387E.setAlpha(z5 ? 1.0f : 0.5f);
        m8303K(i6);
        this.f17388F.setOnSwitchChangeListener(new C0364t(4, this));
        this.f17387E.setOnSeekBarChangeListener(new C0824l(0, this));
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onPause() {
        super.onPause();
        AppCompatSeekBar appCompatSeekBar = this.f17387E;
        int progress = appCompatSeekBar != null ? appCompatSeekBar.getProgress() : this.f17390H;
        boolean z5 = this.f17391I;
        SwitchView switchView = this.f17388F;
        boolean z6 = z5 != (switchView != null && switchView.f17544q);
        if (progress != this.f17390H || z6) {
            try {
                Utilities.m8174z(this);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}
