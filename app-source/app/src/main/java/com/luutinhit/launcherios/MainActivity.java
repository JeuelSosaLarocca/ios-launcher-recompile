package com.luutinhit.launcherios;

import B3.AbstractC0075r;
import C2.C0144d;
import O2.InterfaceC0738b;
import O3.ViewOnClickListenerC0743d;
import P3.AbstractActivityC0816d;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.activity.RatingActivity;
import com.luutinhit.launcherios.customsettings.SettingsView;
import java.util.ArrayList;
import java.util.Arrays;
import p003D.C0157a;
import p029g.C2054g;
import p029g.DialogC2057j;
import p081h2.AbstractC2127a;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class MainActivity extends AbstractActivityC0816d implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, InterfaceC0738b {

    /* JADX INFO: renamed from: K */
    public static final /* synthetic */ int f17277K = 0;

    /* JADX INFO: renamed from: D */
    public SharedPreferences f17278D;

    /* JADX INFO: renamed from: E */
    public Context f17279E;

    /* JADX INFO: renamed from: F */
    public DrawerLayout f17280F;

    /* JADX INFO: renamed from: G */
    public NavigationView f17281G;

    /* JADX INFO: renamed from: H */
    public AppCompatImageView f17282H;

    /* JADX INFO: renamed from: I */
    public SettingsView f17283I;

    /* JADX INFO: renamed from: J */
    public ArrayList f17284J = new ArrayList(Arrays.asList("widget_weather", "widget_favorite", "widget_suggestion"));

    /* JADX INFO: renamed from: K */
    public final void m8291K(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Throwable unused) {
            Toast.makeText(this, R.string.application_not_found, 0).show();
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m8292L() {
        if (Utilities.f16748i) {
            ArrayList arrayList = new ArrayList();
            if (!AbstractC0075r.m195p(this)) {
                arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
            ArrayList arrayList2 = this.f17284J;
            try {
                String string = this.f17278D.getString("list_choose_widget", null);
                if (string != null) {
                    arrayList2 = new ArrayList(Arrays.asList(TextUtils.split(string, "‚‗‚")));
                }
            } catch (Throwable unused) {
            }
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                if (arrayList2.contains("widget_weather") && !AbstractC0075r.m194o(this)) {
                    arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                }
                if (arrayList2.contains("widget_favorite") && !AbstractC0075r.m193n(this)) {
                    arrayList.add("android.permission.READ_CONTACTS");
                }
                if (arrayList2.contains("widget_calendar") && Utilities.f16748i && AbstractC2127a.m8789c(this, "android.permission.READ_CALENDAR") != 0) {
                    arrayList.add("android.permission.READ_CALENDAR");
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            AbstractC2127a.m8799n(this, (String[]) arrayList.toArray(new String[0]), 68);
        }
    }

    /* JADX INFO: renamed from: M */
    public final void m8293M(boolean z5) {
        int iM8795i = AbstractC2127a.m8795i(this, z5 ? R.color.activity_background_dark : R.color.activity_background);
        this.f17283I.setItemBackground(z5 ? R.drawable.item_press_state_dark : R.drawable.item_press_state);
        this.f17280F.setBackgroundColor(iM8795i);
        Utilities.m8147A(z5 ? -1 : -16777216, this.f17280F);
    }

    /**
     * "Reload launcher": it used to be an entry of the sliding menu (removed). Now a row of the settings list,
     * wired from the layout with android:onClick. Same behavior as before: ask, then tell the launcher to reload.
     */
    public void reloadLauncher(View view) {
        com.luutinhit.launcher6.JadxSupport.useSource(); // added on purpose: moved here from the removed drawer menu
        new android.app.AlertDialog.Builder(this)
                .setTitle(R.string.reload_launcher)
                .setPositiveButton(android.R.string.ok, (dialogInterface, i) -> {
                    try {
                        sendBroadcast(new Intent("com.luutinhit.launcherios.ACTION_FORCE_RELOAD_LAUNCHER"));
                        finish();
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    @Override // P3.AbstractActivityC0816d, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onBackPressed() {
        m1820I();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.toString();
            int id = view.getId();
            if (id == R.id.action_navigation) {
                DrawerLayout drawerLayout = this.f17280F;
                if (drawerLayout != null) {
                    drawerLayout.openDrawer(8388611);
                    return;
                }
                return;
            }
            if (id == R.id.action_like || id == R.id.floating_button) {
                startActivity(new Intent(this.f17279E, (Class<?>) RatingActivity.class));
                return;
            }
            if (id == R.id.action_email) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("vnd.android.cursor.dir/email");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"andywill.itplus@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "[" + getString(R.string.app_name) + "]");
                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                    return;
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(this, "There is no email client installed.", 0).show();
                    return;
                }
            }
            if (id == R.id.action_share) {
                try {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    String str = "https://play.google.com/store/apps/details?id=" + getPackageName();
                    intent2.putExtra("android.intent.extra.SUBJECT", getString(R.string.download_app, getString(R.string.app_name)));
                    intent2.putExtra("android.intent.extra.TEXT", str);
                    startActivity(Intent.createChooser(intent2, getString(R.string.share_via)));
                } catch (Throwable th) {
                    th.getMessage();
                    Toast.makeText(this, R.string.application_not_found, 0).show();
                }
            }
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.f17279E = getApplicationContext();
            setContentView(R.layout.activity_main);
            if (getPackageName().contains("luutinhit")) {
                if (this.f17279E != null) {
                    this.f17280F = (DrawerLayout) findViewById(R.id.drawer_layout);
                    this.f17281G = (NavigationView) findViewById(R.id.nav_view);
                    this.f17282H = (AppCompatImageView) findViewById(R.id.header_layout);
                    this.f17283I = (SettingsView) findViewById(R.id.scroll_settings);
                    m1821J(this.f17280F, false);
                    findViewById(R.id.action_like).setOnClickListener(this);
                    findViewById(R.id.action_email).setOnClickListener(this);
                    findViewById(R.id.action_share).setOnClickListener(this);
                    findViewById(R.id.action_navigation).setOnClickListener(this);
                    findViewById(R.id.floating_button).setOnClickListener(this);
                    this.f17278D = C2234v.m8923a(this.f17279E);
                }
                m8292L();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onDestroy() {
        Intent intent;
        try {
            if (Utilities.m8172x() || Utilities.m8168t()) {
                intent = new Intent(this, (Class<?>) IOSLauncher.class);
            } else {
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
            }
            startActivity(intent);
        } catch (Throwable unused) {
        }
        this.f17278D.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        SharedPreferences sharedPreferences = this.f17278D;
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        NavigationView navigationView = this.f17281G;
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        SettingsView settingsView = this.f17283I;
        if (settingsView != null) {
            settingsView.setOnOverScrollListener(new C0157a(11, this));
            if (this.f17278D.getBoolean("dark_mode", false)) {
                m8293M(true);
            }
        }
        if (!Utilities.f16749j || AbstractC0075r.m195p(this)) {
            return;
        }
        int wallpaperId = WallpaperManager.getInstance(this).getWallpaperId(1);
        this.f17278D.getInt("wallpaper_id", 0);
        if (wallpaperId != this.f17278D.getInt("wallpaper_id", 0)) {
            try {
                View viewInflate = getLayoutInflater().inflate(R.layout.dialog_suggest_blur_effect, (ViewGroup) null);
                C0144d c0144d = new C0144d(this, R.style.Rounded_AppCompat_Dialog);
                C2054g c2054g = (C2054g) c0144d.f419k;
                c2054g.f18341t = viewInflate;
                c2054g.f18334m = false;
                DialogC2057j dialogC2057jM351j = c0144d.m351j();
                findViewById(R.id.dialog_blur_effect_button_never).setVisibility(8);
                findViewById(R.id.dialog_blur_effect_button_negative).setOnClickListener(new ViewOnClickListenerC0743d(dialogC2057jM351j, 0));
                findViewById(R.id.dialog_blur_effect_button_positive).setOnClickListener(new ViewOnClickListenerC0743d(dialogC2057jM351j, 1));
                if (dialogC2057jM351j.getWindow() != null) {
                    dialogC2057jM351j.getWindow().setDimAmount(0.2f);
                }
                dialogC2057jM351j.show();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null || !str.equals("dark_mode")) {
            return;
        }
        m8293M(sharedPreferences.getBoolean("dark_mode", false));
    }
}
