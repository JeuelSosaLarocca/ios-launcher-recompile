package com.luutinhit.launcherios.activity;

import P3.AbstractActivityC0816d;
import P3.ViewOnClickListenerC0827o;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.C1697k;
import com.bumptech.glide.ComponentCallbacks2C1688b;
import com.luutinhit.launcherios.R;
import p067e1.C1952j;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class StatusBarAndNotificationActivity extends AbstractActivityC0816d implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: D */
    public AppCompatImageView f17406D;

    /* JADX INFO: renamed from: E */
    public AppCompatImageView f17407E;

    /* JADX INFO: renamed from: F */
    public AppCompatCheckBox f17408F;

    /* JADX INFO: renamed from: G */
    public SharedPreferences f17409G;

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
        this.f17406D.setVisibility(z5 ? 0 : 4);
        this.f17407E.setVisibility(z5 ? 4 : 0);
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_status_bar_and_notification);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17409G = getSharedPreferences(C2234v.m8924b(this), 0);
        this.f17406D = (AppCompatImageView) findViewById(R.id.hide_navigation_image);
        this.f17407E = (AppCompatImageView) findViewById(R.id.show_navigation_image);
        this.f17408F = (AppCompatCheckBox) findViewById(R.id.hide_navigation_checkbox);
        findViewById(R.id.confirm_button).setOnClickListener(new ViewOnClickListenerC0827o(this));
        this.f17408F.setOnCheckedChangeListener(this);
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStart() {
        super.onStart();
        C1697k c1697kMo1613r = ComponentCallbacks2C1688b.m3646b(this).m3758d(this).mo1613r(Integer.valueOf(R.drawable.hide_navigation));
        C1952j c1952j = C1952j.f17899b;
        ((C1697k) c1697kMo1613r.mo1584h(c1952j)).m3728P(this.f17406D);
        ((C1697k) ComponentCallbacks2C1688b.m3646b(this).m3758d(this).mo1613r(Integer.valueOf(R.drawable.show_navigation)).mo1584h(c1952j)).m3728P(this.f17407E);
        boolean z5 = true;
        try {
            z5 = this.f17409G.getBoolean("hide_navigation", true);
        } catch (Throwable unused) {
        }
        this.f17408F.setChecked(z5);
        this.f17406D.setVisibility(z5 ? 0 : 4);
        this.f17407E.setVisibility(z5 ? 4 : 0);
    }
}
