package com.luutinhit.launcherios.activity;

import C2.C0144d;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.activity.RatingActivity;
import p029g.AbstractActivityC2058k;
import p029g.C2054g;
import p029g.DialogC2057j;
import p081h2.AbstractC2127a;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class RatingActivity extends AbstractActivityC2058k implements View.OnClickListener {

    /* JADX INFO: renamed from: P */
    public static final /* synthetic */ int f17392P = 0;

    /* JADX INFO: renamed from: D */
    public DialogC2057j f17393D;

    /* JADX INFO: renamed from: E */
    public View f17394E;

    /* JADX INFO: renamed from: F */
    public SharedPreferences f17395F;

    /* JADX INFO: renamed from: G */
    public Context f17396G;

    /* JADX INFO: renamed from: H */
    public TextView f17397H;

    /* JADX INFO: renamed from: I */
    public TextView f17398I;

    /* JADX INFO: renamed from: J */
    public TextView f17399J;

    /* JADX INFO: renamed from: K */
    public RatingBar f17400K;

    /* JADX INFO: renamed from: L */
    public ImageView f17401L;

    /* JADX INFO: renamed from: M */
    public EditText f17402M;

    /* JADX INFO: renamed from: N */
    public LinearLayout f17403N;

    /* JADX INFO: renamed from: O */
    public LinearLayout f17404O;

    /* JADX INFO: renamed from: I */
    public final void m8304I() {
        LayerDrawable layerDrawable = (LayerDrawable) this.f17400K.getProgressDrawable();
        Drawable drawable = layerDrawable.getDrawable(2);
        int iM8795i = AbstractC2127a.m8795i(this.f17396G, R.color.yellow);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        drawable.setColorFilter(iM8795i, mode);
        layerDrawable.getDrawable(1).setColorFilter(AbstractC2127a.m8795i(this.f17396G, R.color.yellow), mode);
        layerDrawable.getDrawable(0).setColorFilter(AbstractC2127a.m8795i(this.f17396G, R.color.grey_200), mode);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id == R.id.dialog_rating_button_never) {
                try {
                    SharedPreferences.Editor editorEdit = this.f17395F.edit();
                    editorEdit.putBoolean("not_show_exit_dialog", true);
                    editorEdit.apply();
                } catch (Throwable th) {
                    th.getMessage();
                }
                DialogC2057j dialogC2057j = this.f17393D;
                if (dialogC2057j != null) {
                    dialogC2057j.dismiss();
                    return;
                }
                return;
            }
            if (id != R.id.dialog_rating_button_positive) {
                if (id == R.id.dialog_rating_button_feedback_submit) {
                    Toast.makeText(this.f17396G, R.string.rating_dialog_thank_you, 0).show();
                    DialogC2057j dialogC2057j2 = this.f17393D;
                    if (dialogC2057j2 != null) {
                        dialogC2057j2.dismiss();
                        return;
                    }
                    return;
                }
                if (id == R.id.dialog_rating_button_negative || id == R.id.dialog_rating_button_feedback_cancel) {
                    DialogC2057j dialogC2057j3 = this.f17393D;
                    if (dialogC2057j3 != null) {
                        dialogC2057j3.dismiss();
                        return;
                    }
                    return;
                }
                DialogC2057j dialogC2057j4 = this.f17393D;
                if (dialogC2057j4 != null) {
                    dialogC2057j4.dismiss();
                    return;
                }
                return;
            }
            RatingBar ratingBar = this.f17400K;
            if (ratingBar == null || ratingBar.getRating() < 5.0f) {
                this.f17398I.setVisibility(0);
                this.f17402M.setVisibility(0);
                this.f17404O.setVisibility(0);
                this.f17403N.setVisibility(8);
                this.f17401L.setVisibility(8);
                this.f17397H.setVisibility(8);
                this.f17399J.setVisibility(8);
                this.f17400K.setVisibility(8);
            } else {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
                    intent.addFlags(268435456);
                    this.f17396G.startActivity(intent);
                } catch (Throwable th2) {
                    try {
                        th2.getMessage();
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
                        intent2.addFlags(268435456);
                        this.f17396G.startActivity(intent2);
                    } catch (Throwable unused) {
                        Toast.makeText(this.f17396G, R.string.application_not_found, 0).show();
                    }
                }
            }
            try {
                SharedPreferences.Editor editorEdit2 = this.f17395F.edit();
                editorEdit2.putBoolean("not_show_exit_dialog", true);
                editorEdit2.apply();
            } catch (Throwable th3) {
                th3.getMessage();
            }
        }
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (Build.VERSION.SDK_INT < 26) {
                setRequestedOrientation(1);
            }
            Context applicationContext = getApplicationContext();
            this.f17396G = applicationContext;
            this.f17395F = C2234v.m8923a(applicationContext);
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_rating, (ViewGroup) null);
            this.f17394E = viewInflate;
            this.f17397H = (TextView) viewInflate.findViewById(R.id.dialog_rating_title);
            this.f17399J = (TextView) this.f17394E.findViewById(R.id.dialog_rating_app_name);
            AppCompatButton appCompatButton = (AppCompatButton) this.f17394E.findViewById(R.id.dialog_rating_button_never);
            AppCompatButton appCompatButton2 = (AppCompatButton) this.f17394E.findViewById(R.id.dialog_rating_button_negative);
            AppCompatButton appCompatButton3 = (AppCompatButton) this.f17394E.findViewById(R.id.dialog_rating_button_positive);
            this.f17398I = (TextView) this.f17394E.findViewById(R.id.dialog_rating_feedback_title);
            AppCompatButton appCompatButton4 = (AppCompatButton) this.f17394E.findViewById(R.id.dialog_rating_button_feedback_submit);
            AppCompatButton appCompatButton5 = (AppCompatButton) this.f17394E.findViewById(R.id.dialog_rating_button_feedback_cancel);
            this.f17400K = (RatingBar) this.f17394E.findViewById(R.id.dialog_rating_rating_bar);
            this.f17401L = (ImageView) this.f17394E.findViewById(R.id.dialog_rating_icon);
            this.f17402M = (EditText) this.f17394E.findViewById(R.id.dialog_rating_feedback);
            this.f17403N = (LinearLayout) this.f17394E.findViewById(R.id.dialog_rating_buttons);
            this.f17404O = (LinearLayout) this.f17394E.findViewById(R.id.dialog_rating_feedback_buttons);
            m8304I();
            appCompatButton.setOnClickListener(this);
            appCompatButton2.setOnClickListener(this);
            appCompatButton3.setOnClickListener(this);
            appCompatButton4.setOnClickListener(this);
            appCompatButton5.setOnClickListener(this);
        } catch (Throwable th) {
            th.getMessage();
            finish();
        }
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        DialogC2057j dialogC2057j = this.f17393D;
        if (dialogC2057j != null && dialogC2057j.isShowing()) {
            this.f17393D.dismiss();
        }
        this.f17393D = null;
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onPause() {
        super.onPause();
        finish();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [P3.m] */
    /* JADX WARN: Type inference failed for: r1v4, types: [P3.n] */
    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onResume() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        super.onResume();
        try {
            DialogC2057j dialogC2057j = this.f17393D;
            if (dialogC2057j != null && dialogC2057j.isShowing()) {
                this.f17393D.dismiss();
            }
            C0144d c0144d = new C0144d(this, R.style.Rounded_AppCompat_Dialog);
            View view = this.f17394E;
            C2054g c2054g = (C2054g) c0144d.f419k;
            c2054g.f18341t = view;
            c2054g.f18334m = false;
            c2054g.f18335n = new P3.DialogInterfaceOnCancelListenerC0825m(RatingActivity.this) /* original class P3.m; the field is typed with it */;
            c2054g.f18336o = new P3.DialogInterfaceOnDismissListenerC0826n(RatingActivity.this) /* original class P3.n; the field is typed with it */;
            this.f17393D = c0144d.m351j();
            if (isFinishing()) {
                return;
            }
            if (this.f17393D.getWindow() != null) {
                this.f17393D.getWindow().setDimAmount(0.2f);
            }
            this.f17393D.show();
        } catch (Throwable th) {
            th.getMessage();
            finish();
        }
    }
}
