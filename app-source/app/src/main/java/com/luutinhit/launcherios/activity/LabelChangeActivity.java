package com.luutinhit.launcherios.activity;

import A4.RunnableC0026a;
import C2.C0144d;
import E4.AbstractC0212f;
import G3.CallableC0345a;
import O3.ViewOnClickListenerC0743d;
import P3.AbstractActivityC0816d;
import P3.ViewTreeObserverOnScrollChangedListenerC0813a;
import Q3.C0895c;
import T0.C1029l;
import W3.C1149a;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.activity.LabelChangeActivity;
import java.util.ArrayList;
import p024a.AbstractC1314a;
import p029g.C2054g;
import p029g.DialogC2057j;
import p123r4.AbstractC2679b;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
public class LabelChangeActivity extends AbstractActivityC0816d {


    /* JADX INFO: renamed from: J */
    public static final /* synthetic */ int f17377J = 0;

    /* JADX INFO: renamed from: D */
    public LinearLayout f17378D;

    /* JADX INFO: renamed from: E */
    public RealTimeBlurView f17379E;

    /* JADX INFO: renamed from: F */
    public boolean f17380F = false;

    /* JADX INFO: renamed from: G */
    public int f17381G;

    /* JADX INFO: renamed from: H */
    public InterfaceC2749b f17382H;

    /* JADX INFO: renamed from: I */
    public C0895c f17383I;

    /* JADX INFO: renamed from: K */
    public final void m8302K(final int i6, final String str, final String str2) {
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_change_label, (ViewGroup) null);
            EditText editText = (EditText) viewInflate.findViewById(R.id.ed_label);
            editText.setText(str2);
            editText.setSelection(str2.length());
            C0144d c0144d = new C0144d(this);
            ((C2054g) c0144d.f419k).f18341t = viewInflate;
            DialogC2057j dialogC2057jM351j = c0144d.m351j();
            if (!isFinishing()) {
                dialogC2057jM351j.show();
            }
            viewInflate.findViewById(R.id.bt_cancel).setOnClickListener(new ViewOnClickListenerC0743d(dialogC2057jM351j, 2));
            viewInflate.findViewById(R.id.bt_ok).setOnClickListener(new View.OnClickListener() { // from class: P3.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i7 = LabelChangeActivity.f17377J;
                    LabelChangeActivity labelChangeActivity = LabelChangeActivity.this;
                    labelChangeActivity.getClass();
                    String strValueOf = String.valueOf(editText.getText());
                    if (!str2.equals(strValueOf)) {
                        C0895c c0895c = labelChangeActivity.f17383I;
                        ArrayList arrayList = c0895c.f2649n;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            int i8 = i6;
                            if (size > i8) {
                                ((C1149a) c0895c.f2649n.get(i8)).f3367c = strValueOf;
                                c0895c.m9704g(i8);
                            }
                        }
                        Intent intent = new Intent("com.luutinhit.launcherios.ACTION_UPDATE_LABEL");
                        intent.putExtra("EXTRA_COMPONENT_NAME", str);
                        intent.putExtra("EXTRA_APP_LABEL", strValueOf);
                        labelChangeActivity.sendBroadcast(intent);
                        labelChangeActivity.f17380F = true;
                    }
                    DialogC2057j dialogC2057j = dialogC2057jM351j;
                    if (dialogC2057j != null) {
                        dialogC2057j.dismiss();
                    }
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_change_label);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17379E = (RealTimeBlurView) findViewById(R.id.blurring_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_apps);
        recyclerView.setNestedScrollingEnabled(false);
        this.f17378D = (LinearLayout) findViewById(R.id.progress_layout);
        this.f17381G = getResources().getDimensionPixelSize(R.dimen.item_hidden_app_size);
        this.f17379E.setBlurredView((OverScrollLayout) findViewById(R.id.overscroll_layout));
        recyclerView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserverOnScrollChangedListenerC0813a(this, 2));
        new LinearLayoutManager(1).e1(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.e1(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        C0895c c0895c = new C0895c(2);
        this.f17383I = c0895c;
        recyclerView.setAdapter(c0895c);
        this.f17383I.f2650o = this;
        this.f17378D.setVisibility(0);
        try {
            new CallableC3080a(new CallableC0345a(6, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C1029l(15, this), AbstractC2679b.m9681a(), 1));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC1314a.m2681A(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onDestroy() {
        InterfaceC2749b interfaceC2749b = this.f17382H;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
        super.onDestroy();
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStop() {
        if (this.f17380F) {
            Utilities.m8174z(this);
        }
        super.onStop();
    }
}
