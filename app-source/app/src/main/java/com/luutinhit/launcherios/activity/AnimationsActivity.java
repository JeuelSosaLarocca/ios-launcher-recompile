package com.luutinhit.launcherios.activity;

import C2.RunnableC0147g;
import G3.C0364t;
import J0.C0489j;
import P3.AbstractActivityC0816d;
import T0.C1029l;
import android.app.WallpaperManager;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.customsettings.SwitchView;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class AnimationsActivity extends AbstractActivityC0816d {

    /* JADX INFO: renamed from: J */
    public static final /* synthetic */ int f17310J = 0;

    /* JADX INFO: renamed from: D */
    public SharedPreferences f17311D;

    /* JADX INFO: renamed from: E */
    public SwitchView f17312E;

    /* JADX INFO: renamed from: F */
    public SwitchView f17313F;

    /* JADX INFO: renamed from: G */
    public SwitchView f17314G;

    /* JADX INFO: renamed from: H */
    public WallpaperManager f17315H;

    /* JADX INFO: renamed from: I */
    public RunnableC0147g f17316I = new RunnableC0147g(16, this);

    /* JADX INFO: renamed from: K */
    public final void m8294K(String str, boolean z5) {
        try {
            SharedPreferences.Editor editorEdit = this.f17311D.edit();
            editorEdit.putBoolean(str, z5);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.item_unlock_animations || id == R.id.unlock_animation) {
                SwitchView switchView = this.f17312E;
                switchView.m8339b(!switchView.f17544q);
            } else if (id == R.id.item_parallax_zoom_animation || id == R.id.parallax_zoom_wallpaper_animations) {
                SwitchView switchView2 = this.f17314G;
                switchView2.m8339b(!switchView2.f17544q);
            } else if (id == R.id.item_open_close_animations || id == R.id.open_close_app_animation) {
                SwitchView switchView3 = this.f17313F;
                switchView3.m8339b(!switchView3.f17544q);
            }
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean z5;
        super.onCreate(bundle);
        setContentView(R.layout.activity_animations);
        boolean z6 = true;
        m1821J(findViewById(R.id.root_layout), true);
        this.f17311D = getSharedPreferences(C2234v.m8924b(this), 0);
        this.f17315H = WallpaperManager.getInstance(this);
        SwitchView switchView = (SwitchView) findViewById(R.id.unlock_animation);
        this.f17312E = switchView;
        try {
            z5 = this.f17311D.getBoolean("unlock_animation", true);
        } catch (Throwable unused) {
            z5 = true;
        }
        switchView.setChecked(z5);
        this.f17312E.setOnSwitchChangeListener(new C0489j(16, this));
        SwitchView switchView2 = (SwitchView) findViewById(R.id.open_close_app_animation);
        this.f17313F = switchView2;
        try {
            z6 = this.f17311D.getBoolean("open_close_animation", true);
        } catch (Throwable unused2) {
        }
        switchView2.setChecked(z6);
        this.f17313F.setOnSwitchChangeListener(new C1029l(14, this));
        if (((SensorManager) getSystemService("sensor")).getDefaultSensor(11) == null && !this.f17311D.contains("parallax_zoom_animations")) {
            findViewById(R.id.item_parallax_zoom_animation).setVisibility(8);
        }
        SwitchView switchView3 = (SwitchView) findViewById(R.id.parallax_zoom_wallpaper_animations);
        this.f17314G = switchView3;
        switchView3.setOnSwitchChangeListener(new C0364t(3, this));
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onResume() {
        super.onResume();
        WallpaperManager wallpaperManager = this.f17315H;
        boolean z5 = (wallpaperManager == null || wallpaperManager.getWallpaperInfo() == null || !getPackageName().equalsIgnoreCase(this.f17315H.getWallpaperInfo().getPackageName())) ? false : true;
        this.f17314G.setChecked(z5);
        m8294K("parallax_zoom_animations", z5);
    }
}
