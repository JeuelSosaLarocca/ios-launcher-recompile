package com.luutinhit.launcherios.activity;

import J0.C0489j;
import P3.AbstractActivityC0816d;
import P3.C0828p;
import T0.C1029l;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.C1416d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.customsettings.SwitchView;
import p081h2.AbstractC2127a;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class UtilitiesActivity extends AbstractActivityC0816d implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: D */
    public SharedPreferences f17410D;

    /* JADX INFO: renamed from: E */
    public SwitchView f17411E;

    /* JADX INFO: renamed from: F */
    public SwitchView f17412F;

    /* JADX INFO: renamed from: G */
    public SwitchView f17413G;

    /* JADX INFO: renamed from: H */
    public SwitchView f17414H;

    /* JADX INFO: renamed from: I */
    public ConstraintLayout f17415I;

    /* JADX INFO: renamed from: J */
    public ConstraintLayout f17416J;

    /* JADX INFO: renamed from: K */
    public ConstraintLayout f17417K;

    /* JADX INFO: renamed from: L */
    public ConstraintLayout f17418L;

    /* JADX INFO: renamed from: M */
    public ConstraintLayout f17419M;

    /* JADX INFO: renamed from: N */
    public ConstraintLayout f17420N;

    /* JADX INFO: renamed from: O */
    public ConstraintLayout f17421O;

    /* JADX INFO: renamed from: P */
    public ConstraintLayout f17422P;

    /* JADX INFO: renamed from: Q */
    public View f17423Q;

    /* JADX INFO: renamed from: R */
    public AppCompatSeekBar f17424R;

    /* JADX INFO: renamed from: S */
    public AppCompatImageView f17425S;

    /* JADX INFO: renamed from: T */
    public float f17426T;

    /* JADX INFO: renamed from: U */
    public float f17427U;

    /* JADX INFO: renamed from: V */
    public float f17428V;

    /* JADX INFO: renamed from: W */
    public float f17429W;

    /* JADX INFO: renamed from: X */
    public float f17430X = 0.02f;

    /* JADX INFO: renamed from: Y */
    public int f17431Y;

    /* JADX INFO: renamed from: Z */
    public int f17432Z;

    /* JADX INFO: renamed from: a0 */
    public AppCompatImageView f23545a0;

    /* JADX INFO: renamed from: b0 */
    public AppCompatImageView f23546b0;

    /* JADX INFO: renamed from: K */
    public static void m8305K(UtilitiesActivity utilitiesActivity, String str, boolean z5) {
        try {
            SharedPreferences.Editor editorEdit = utilitiesActivity.f17410D.edit();
            editorEdit.putBoolean(str, z5);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m8306L(int i6) {
        if (i6 == 5) {
            this.f23545a0.setColorFilter(-11806877);
            this.f23546b0.setColorFilter(9079434);
        } else if (i6 == 6) {
            this.f23546b0.setColorFilter(-11806877);
            this.f23545a0.setColorFilter(9079434);
        }
        SharedPreferences.Editor editorEdit = this.f17410D.edit();
        editorEdit.putInt("use_grid_size", i6);
        editorEdit.apply();
        this.f17431Y = i6;
    }

    /* JADX INFO: renamed from: M */
    public final void m8307M(float f6) {
        AppCompatImageView appCompatImageView = this.f17425S;
        if (appCompatImageView != null) {
            C1416d c1416d = (C1416d) appCompatImageView.getLayoutParams();
            int i6 = (int) ((this.f17426T / 4.0f) * f6);
            ((ViewGroup.MarginLayoutParams) c1416d).height = i6;
            ((ViewGroup.MarginLayoutParams) c1416d).width = i6;
            this.f17425S.setLayoutParams(c1416d);
            this.f17425S.invalidate();
        }
    }

    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.item_dark_mode || id == R.id.dark_mode) {
                SwitchView switchView = this.f17411E;
                switchView.m8339b(!switchView.f17544q);
                return;
            }
            if (id == R.id.item_padding_bottom || id == R.id.padding_bottom) {
                SwitchView switchView2 = this.f17412F;
                switchView2.m8339b(!switchView2.f17544q);
                return;
            }
            if (id == R.id.item_auto_rearrange) {
                SwitchView switchView3 = this.f17413G;
                switchView3.m8339b(!switchView3.f17544q);
                return;
            }
            if (id == R.id.item_iphone_8_style) {
                SwitchView switchView4 = this.f17414H;
                switchView4.m8339b(!switchView4.f17544q);
                return;
            }
            if (id == R.id.layout_5x4) {
                m8306L(5);
                return;
            }
            if (id == R.id.layout_6x4) {
                m8306L(6);
                return;
            }
            if (id == R.id.item_navigation_bar) {
                try {
                    startActivity(new Intent(this, (Class<?>) StatusBarAndNotificationActivity.class));
                    overridePendingTransition(R.anim.right_to_left, R.anim.right_to_left_exit);
                } catch (Throwable th) {
                    Toast.makeText(this, "StartActivity " + StatusBarAndNotificationActivity.class.getName() + "  Error: " + th.getMessage(), 1).show();
                }
            }
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_utilities);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17410D = getSharedPreferences(C2234v.m8924b(this), 0);
        this.f17423Q = findViewById(R.id.blurring_view);
        this.f17415I = (ConstraintLayout) findViewById(R.id.root_layout);
        this.f17416J = (ConstraintLayout) findViewById(R.id.item_dark_mode);
        this.f17417K = (ConstraintLayout) findViewById(R.id.item_padding_bottom);
        this.f17418L = (ConstraintLayout) findViewById(R.id.item_auto_rearrange);
        this.f17419M = (ConstraintLayout) findViewById(R.id.item_iphone_8_style);
        this.f17420N = (ConstraintLayout) findViewById(R.id.layout_icon_size);
        this.f17421O = (ConstraintLayout) findViewById(R.id.layout_screen_grid);
        this.f17422P = (ConstraintLayout) findViewById(R.id.item_navigation_bar);
        this.f17411E = (SwitchView) findViewById(R.id.dark_mode);
        this.f17412F = (SwitchView) findViewById(R.id.padding_bottom);
        this.f17413G = (SwitchView) findViewById(R.id.auto_rearrange);
        this.f17414H = (SwitchView) findViewById(R.id.iphone_8_style);
        this.f17424R = (AppCompatSeekBar) findViewById(R.id.seekbar_icon_size);
        this.f17425S = (AppCompatImageView) findViewById(R.id.icon_size_demo);
        this.f23545a0 = (AppCompatImageView) findViewById(R.id.layout_5x4);
        this.f23546b0 = (AppCompatImageView) findViewById(R.id.layout_6x4);
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onPause() {
        super.onPause();
        if (this.f17427U == this.f17429W && this.f17431Y == this.f17432Z) {
            return;
        }
        Utilities.m8174z(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
        if (z5) {
            float f6 = i6 < 10 ? this.f17428V - ((10 - i6) * this.f17430X) : this.f17428V + ((i6 - 10) * this.f17430X);
            this.f17427U = f6;
            m8307M(f6);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0067  */
    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStart() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        super.onStart();
        try {
            if (Utilities.f16753n) {
                Point point = new Point();
                Point point2 = new Point();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                point.x = displayMetrics.widthPixels;
                point.y = displayMetrics.heightPixels;
                getWindowManager().getDefaultDisplay().getSize(point2);
                if (point.y <= point2.y && point.x <= point2.x) {
                    int identifier = getResources().getIdentifier("config_showNavigationBar", "bool", "android");
                    if (identifier > 0) {
                        getResources().getBoolean(identifier);
                    }
                    if (identifier <= 0 || !getResources().getBoolean(identifier)) {
                        this.f17422P.setVisibility(8);
                    }
                }
            } else {
                this.f17422P.setVisibility(8);
            }
        } catch (Throwable unused) {
        }
        try {
            z5 = this.f17410D.getBoolean("dark_mode", false);
        } catch (Throwable unused2) {
            z5 = true;
        }
        this.f17411E.setChecked(z5);
        if (z5) {
            this.f17415I.setBackgroundColor(AbstractC2127a.m8795i(this, R.color.activity_background_dark));
            this.f17416J.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17417K.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17418L.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17419M.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17420N.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17421O.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17422P.setBackgroundResource(R.drawable.item_press_state_dark);
            this.f17423Q.setBackgroundColor(AbstractC2127a.m8795i(this, R.color.default_color_dark));
            Utilities.m8147A(-1, this.f17415I);
            try {
                if (Utilities.f16748i) {
                    getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() & (-8193));
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        this.f17411E.setOnSwitchChangeListener(new C0828p(this, 0));
        SwitchView switchView = this.f17412F;
        try {
            z6 = this.f17410D.getBoolean("marginHotseat", false);
        } catch (Throwable unused3) {
            z6 = true;
        }
        switchView.setChecked(z6);
        this.f17412F.setOnSwitchChangeListener(new C0489j(18, this));
        SwitchView switchView2 = this.f17413G;
        try {
            z7 = this.f17410D.getBoolean("auto_rearrange", false);
        } catch (Throwable unused4) {
            z7 = true;
        }
        switchView2.setChecked(z7);
        this.f17413G.setOnSwitchChangeListener(new C1029l(16, this));
        SwitchView switchView3 = this.f17414H;
        try {
            z8 = this.f17410D.getBoolean("iphone_8_style", false);
        } catch (Throwable unused5) {
            z8 = true;
        }
        switchView3.setChecked(z8);
        this.f17414H.setOnSwitchChangeListener(new C0828p(this, 1));
        int i6 = this.f17410D.getInt("use_grid_size", 0);
        this.f17432Z = i6;
        this.f17431Y = i6;
        m8306L(i6);
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(new DisplayMetrics());
        defaultDisplay.getCurrentSizeRange(new Point(), new Point());
        Point point3 = new Point();
        if (Utilities.f16754o) {
            defaultDisplay.getRealSize(point3);
        } else {
            defaultDisplay.getSize(point3);
        }
        this.f17426T = Math.min(Math.min(point3.x, point3.y), Math.max(point3.x, point3.y));
        Resources resources = getResources();
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.dimen.icon_padding_percent, typedValue, true);
        float f6 = typedValue.getFloat();
        this.f17428V = f6;
        float f7 = this.f17410D.getFloat("icon_padding_edge", f6);
        this.f17427U = f7;
        float f8 = this.f17428V;
        this.f17430X = f8 / 100.0f;
        if (f7 == 0.0f) {
            this.f17427U = f8;
        } else {
            this.f17410D.getInt("icon_padding_edge_progress", 10);
            this.f17424R.setProgress(this.f17410D.getInt("icon_padding_edge_progress", 10));
        }
        float f9 = this.f17427U;
        this.f17429W = f9;
        m8307M(f9);
        this.f17424R.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        SharedPreferences.Editor editorEdit = this.f17410D.edit();
        editorEdit.putFloat("icon_padding_edge", this.f17427U);
        editorEdit.putInt("icon_padding_edge_progress", seekBar.getProgress());
        editorEdit.apply();
    }
}
