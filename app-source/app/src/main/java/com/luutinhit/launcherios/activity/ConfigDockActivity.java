package com.luutinhit.launcherios.activity;

import P3.AbstractActivityC0816d;
import T3.InterfaceC1067g;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.customsettings.SwitchView;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class ConfigDockActivity extends AbstractActivityC0816d implements InterfaceC1067g {

    /* JADX INFO: renamed from: D */
    public SharedPreferences f17326D;

    /* JADX INFO: renamed from: E */
    public SwitchView f17327E;

    @Override // T3.InterfaceC1067g
    /* JADX INFO: renamed from: g */
    public final void mo909g(boolean z5) {
        try {
            SharedPreferences.Editor editorEdit = this.f17326D.edit();
            editorEdit.putBoolean("marginHotseat", z5);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
        Utilities.m8174z(this);
    }

    public void onClick(View view) {
        SwitchView switchView = this.f17327E;
        switchView.m8339b(!switchView.f17544q);
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_config_dock);
        boolean z5 = true;
        m1821J(findViewById(R.id.root_layout), true);
        this.f17326D = getSharedPreferences(C2234v.m8924b(this), 0);
        SwitchView switchView = (SwitchView) findViewById(R.id.padding_bottom);
        this.f17327E = switchView;
        try {
            z5 = this.f17326D.getBoolean("marginHotseat", false);
        } catch (Throwable unused) {
        }
        switchView.setChecked(z5);
        this.f17327E.setOnSwitchChangeListener(this);
    }
}
