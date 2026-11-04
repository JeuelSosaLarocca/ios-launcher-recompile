package com.luutinhit.launcherios.customsettings;

import B3.C0046N;
import C2.C0144d;
import J1.DialogInterfaceOnClickListenerC0519e;
import L1.AbstractC0626a;
import T3.C1066f;
import T3.DialogInterfaceOnClickListenerC1064d;
import T3.RunnableC1061a;
import T3.ViewOnClickListenerC1063c;
import U3.AbstractC1101c;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.appslibrary.MergedCallbacks;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.activity.AnimationsActivity;
import com.luutinhit.launcherios.activity.AppsLibraryCategoryActivity;
import com.luutinhit.launcherios.activity.BlurConfigActivity;
import com.luutinhit.launcherios.activity.EditWidgetActivity;
import com.luutinhit.launcherios.activity.HiddenAppsActivity;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.activity.LabelChangeActivity;
import com.luutinhit.launcherios.activity.LiquidGlassConfigActivity;
import com.luutinhit.launcherios.activity.RatingActivity;
import com.luutinhit.launcherios.activity.UtilitiesActivity;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import com.luutinhit.launcherios.activity.WeatherConfigActivity;
import java.io.File;
import java.util.Objects;
import p029g.C2054g;
import p029g.DialogC2057j;
import p156z1.C3053d;

/* JADX INFO: loaded from: classes.dex */
public class SettingsView extends AbstractC1101c implements View.OnClickListener {

    /* JADX INFO: renamed from: j0 */
    public static final /* synthetic */ int f23547j0 = 0;

    /* JADX INFO: renamed from: e0 */
    public MainActivity f23548e0;

    /* JADX INFO: renamed from: f0 */
    public Context f23549f0;

    /* JADX INFO: renamed from: g0 */
    public DialogC2057j f23550g0;

    /* JADX INFO: renamed from: h0 */
    public PackageManager f23551h0;

    /* JADX INFO: renamed from: i0 */
    public AbstractC0626a f23552i0;

    public SettingsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        this.f23549f0 = context2;
        if (context2 != null) {
            if (context2 instanceof MainActivity) {
                this.f23548e0 = (MainActivity) context2;
            }
            this.f23551h0 = context2.getPackageManager();
            new Thread(new RunnableC1061a(this, 0)).start();
        }
        LayoutInflater.from(context).inflate(R.layout.settings_view, (ViewGroup) this, true);
        SettingsItem settingsItem = (SettingsItem) findViewById(R.id.notification_badges);
        findViewById(R.id.lock_screen).setOnClickListener(this);
        findViewById(R.id.assistive_touch).setOnClickListener(this);
        findViewById(R.id.control_center).setOnClickListener(this);
        settingsItem.setOnClickListener(this);
        findViewById(R.id.config_liquid_glass).setOnClickListener(this);
        findViewById(R.id.choose_wallpaper).setOnClickListener(this);
        findViewById(R.id.config_weather).setOnClickListener(this);
        findViewById(R.id.hidden_apps).setOnClickListener(this);
        findViewById(R.id.config_blur).setOnClickListener(this);
        findViewById(R.id.utilities).setOnClickListener(this);
        findViewById(R.id.change_icon).setOnClickListener(this);
        findViewById(R.id.change_label).setOnClickListener(this);
        findViewById(R.id.app_library).setOnClickListener(this);
        findViewById(R.id.config_widget).setOnClickListener(this);
        findViewById(R.id.config_animation).setOnClickListener(this);
        findViewById(R.id.make_default_launcher).setOnClickListener(this);
        findViewById(R.id.rate).setOnClickListener(this);
        findViewById(R.id.download).setOnClickListener(this);
        if (Utilities.f16755p) {
            try {
                String packageName = context2.getPackageName();
                String string = Settings.Secure.getString(context2.getContentResolver(), "enabled_notification_listeners");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                for (String str : string.split(":")) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                    if (componentNameUnflattenFromString != null && TextUtils.equals(packageName, componentNameUnflattenFromString.getPackageName())) {
                        settingsItem.setVisibility(8);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public static void m8331B(SettingsView settingsView, int i6) {
        if (i6 == 0) {
            settingsView.m8333C("com.luutinhit.lockscreennotificationsios");
            return;
        }
        if (i6 == 1) {
            settingsView.m8333C("com.luutinhit.assistivetouch");
        } else if (i6 != 2) {
            settingsView.getClass();
        } else {
            settingsView.m8333C("com.luutinhit.controlcenter");
        }
    }

    /* JADX INFO: renamed from: F */
    public static void m8332F(LinearLayout linearLayout, int i6) {
        int childCount = linearLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = linearLayout.getChildAt(i7);
            if (childAt instanceof SettingsItem) {
                childAt.setBackgroundResource(i6);
            }
        }
    }

    /* JADX INFO: renamed from: C */
    public final void m8333C(String str) {
        Context context = this.f23549f0;
        try {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=".concat(str)));
                intent.addFlags(268435456);
                context.startActivity(intent);
            } catch (Throwable unused) {
                Toast.makeText(context, R.string.application_not_found, 0).show();
            }
        } catch (ActivityNotFoundException unused2) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=".concat(str)));
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }

    /* JADX INFO: renamed from: D */
    public final boolean m8334D(String str) {
        try {
            return this.f23551h0.getPackageInfo(str, 0).packageName.equals(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: E */
    public final void m8335E() {
        try {
            C3053d c3053d = new C3053d(new MergedCallbacks(25));
            Context context = this.f23549f0;
            AbstractC0626a.m1450a(context, context.getString(R.string.ad_unit_id), c3053d, new C1066f(this));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m8336G(int i6, int i7) {
        MainActivity mainActivity = this.f23548e0;
        try {
            View viewInflate = mainActivity.getLayoutInflater().inflate(R.layout.download_tool_dialog, (ViewGroup) null);
            if (viewInflate instanceof AppCompatImageView) {
                if (i6 == 0) {
                    ((AppCompatImageView) viewInflate).setImageResource(R.mipmap.lock_screen_background);
                } else if (i6 == 1) {
                    ((AppCompatImageView) viewInflate).setImageResource(R.mipmap.assistive_touch_background);
                } else if (i6 == 2) {
                    ((AppCompatImageView) viewInflate).setImageResource(R.mipmap.control_center_background);
                }
                viewInflate.setOnClickListener(new ViewOnClickListenerC1063c(this, i6));
                C0144d c0144d = new C0144d(mainActivity);
                C2054g c2054g = (C2054g) c0144d.f419k;
                c2054g.f18325d = c2054g.f18322a.getText(R.string.download);
                c2054g.f18327f = c2054g.f18322a.getText(i7);
                c2054g.f18341t = viewInflate;
                DialogInterfaceOnClickListenerC1064d dialogInterfaceOnClickListenerC1064d = new DialogInterfaceOnClickListenerC1064d(this, i6);
                c2054g.f18328g = c2054g.f18322a.getText(android.R.string.ok);
                c2054g.f18329h = dialogInterfaceOnClickListenerC1064d;
                DialogInterfaceOnClickListenerC0519e dialogInterfaceOnClickListenerC0519e = new DialogInterfaceOnClickListenerC0519e(2);
                c2054g.f18330i = c2054g.f18322a.getText(android.R.string.cancel);
                c2054g.f18331j = dialogInterfaceOnClickListenerC0519e;
                this.f23550g0 = c0144d.m351j();
            }
            DialogC2057j dialogC2057j = this.f23550g0;
            if (dialogC2057j != null) {
                dialogC2057j.show();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: H */
    public final void m8337H(String str) {
        Context context = this.f23549f0;
        try {
            Intent launchIntentForPackage = this.f23551h0.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
            }
            context.startActivity(launchIntentForPackage);
        } catch (Throwable unused) {
            Toast.makeText(context, R.string.application_not_found, 0).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            Context context = this.f23549f0;
            if (id == R.id.rate) {
                context.startActivity(new Intent(context, (Class<?>) RatingActivity.class));
                return;
            }
            MainActivity mainActivity = this.f23548e0;
            if (id == R.id.download) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://dev?id=5295002497598445111"));
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=5295002497598445111"));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                }
            } else if (id == R.id.lock_screen) {
                if (m8334D("com.luutinhit.lockscreennotificationsios")) {
                    try {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName("com.luutinhit.lockscreennotificationsios", "com.luutinhit.lockscreennotificationsios.MainActivity"));
                        intent3.putExtra("hideLayoutIntro", true);
                        intent3.putExtra("not_show_rating_dialog", true);
                        context.startActivity(intent3);
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                        }
                    } catch (Throwable th2) {
                        th2.getMessage();
                        m8337H("com.luutinhit.lockscreennotificationsios");
                    }
                } else {
                    m8336G(0, R.string.download_lock_screen);
                }
            } else if (id == R.id.assistive_touch) {
                if (m8334D("com.luutinhit.assistivetouch")) {
                    try {
                        Intent intent4 = new Intent();
                        intent4.setComponent(new ComponentName("com.luutinhit.assistivetouch", "com.luutinhit.assistivetouch.MainActivity"));
                        intent4.putExtra("hideLayoutIntro", true);
                        intent4.putExtra("not_show_rating_dialog", true);
                        context.startActivity(intent4);
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                        }
                    } catch (Throwable th3) {
                        th3.getMessage();
                        m8337H("com.luutinhit.assistivetouch");
                    }
                } else {
                    m8336G(1, R.string.download_assistive_touch);
                }
            } else if (id == R.id.control_center) {
                if (m8334D("com.luutinhit.controlcenter")) {
                    try {
                        Intent intent5 = new Intent();
                        intent5.setComponent(new ComponentName("com.luutinhit.controlcenter", "com.luutinhit.controlcenter.MainActivity"));
                        intent5.putExtra("hideLayoutIntro", true);
                        intent5.putExtra("not_show_rating_dialog", true);
                        context.startActivity(intent5);
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                        }
                    } catch (Throwable th4) {
                        th4.getMessage();
                        m8337H("com.luutinhit.controlcenter");
                    }
                } else {
                    m8336G(2, R.string.download_control_center);
                }
            } else if (id == R.id.choose_wallpaper) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) WallpaperActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th5) {
                    Toast.makeText(context, "startWallpapers Error: " + th5.getMessage(), 1).show();
                }
            } else if (id == R.id.config_liquid_glass) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) LiquidGlassConfigActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th6) {
                    Toast.makeText(context, "Liquid Glass error: " + th6.getMessage(), 1).show();
                }
            } else if (id == R.id.config_animation) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) AnimationsActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th7) {
                    Toast.makeText(context, "startWallpapers Error: " + th7.getMessage(), 1).show();
                }
            } else if (id == R.id.notification_badges) {
                try {
                    context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th8) {
                    Toast.makeText(context, "Error: " + th8.getMessage(), 1).show();
                }
            } else if (id == R.id.config_widget) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) EditWidgetActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th9) {
                    Toast.makeText(context, "Error: " + th9.getMessage(), 1).show();
                }
            } else if (id == R.id.config_weather) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) WeatherConfigActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th10) {
                    Toast.makeText(context, "Error: " + th10.getMessage(), 1).show();
                }
            } else if (id == R.id.hidden_apps) {
                try {
                    String path = context.getDatabasePath("app_icons.db").getPath();
                    if (path == null || path.isEmpty() || !new File(path).exists()) {
                        context.startActivity(new Intent(context, (Class<?>) IOSLauncher.class));
                        Toast.makeText(context, R.string.start_ios_launcher_firstly, 1).show();
                    } else {
                        context.startActivity(new Intent(context, (Class<?>) HiddenAppsActivity.class));
                        if (mainActivity != null) {
                            mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                        }
                    }
                } catch (Throwable th11) {
                    Toast.makeText(context, "Error: " + th11.getMessage(), 1).show();
                }
            } else if (id == R.id.config_blur) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) BlurConfigActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th12) {
                    Toast.makeText(context, "Blur error: " + th12.getMessage(), 1).show();
                }
            } else if (id == R.id.utilities) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) UtilitiesActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th13) {
                    Toast.makeText(context, "startUtilities Error: " + th13.getMessage(), 1).show();
                }
            } else if (id == R.id.change_icon) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) IconChangeActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th14) {
                    Toast.makeText(context, "startChangeIcon Error: " + th14.getMessage(), 1).show();
                }
            } else if (id == R.id.change_label) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) LabelChangeActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th15) {
                    Toast.makeText(context, "startChangeLabel Error: " + th15.getMessage(), 1).show();
                }
            } else if (id == R.id.app_library) {
                try {
                    context.startActivity(new Intent(context, (Class<?>) AppsLibraryCategoryActivity.class));
                    if (mainActivity != null) {
                        mainActivity.overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                    }
                } catch (Throwable th16) {
                    Toast.makeText(context, "startChangeLabel Error: " + th16.getMessage(), 1).show();
                }
            } else if (id == R.id.make_default_launcher) {
                new C0046N(context).m111a();
            }
            Objects.toString(this.f23552i0);
            try {
                AbstractC0626a abstractC0626a = this.f23552i0;
                if (abstractC0626a != null) {
                    abstractC0626a.mo1452c(mainActivity);
                }
            } catch (Throwable th17) {
                th17.getMessage();
            }
        }
    }

    public void setItemBackground(int i6) {
        m8332F((LinearLayout) findViewById(R.id.settings_group_suggest_apps), i6);
        m8332F((LinearLayout) findViewById(R.id.settings_group_settings_app), i6);
        m8332F((LinearLayout) findViewById(R.id.settings_group_rating_app), i6);
    }
}
