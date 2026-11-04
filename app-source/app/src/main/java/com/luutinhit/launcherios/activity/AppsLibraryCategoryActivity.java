package com.luutinhit.launcherios.activity;

import A4.RunnableC0026a;
import E4.AbstractC0212f;
import G3.CallableC0345a;
import P3.AbstractActivityC0816d;
import P3.ViewTreeObserverOnScrollChangedListenerC0813a;
import Q3.C0895c;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.R;
import p003D.C0157a;
import p024a.AbstractC1314a;
import p089j0.C2234v;
import p123r4.AbstractC2679b;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
public class AppsLibraryCategoryActivity extends AbstractActivityC0816d {

    /* JADX INFO: renamed from: L */
    public static final /* synthetic */ int f17317L = 0;

    /* JADX INFO: renamed from: D */
    public RecyclerView f17318D;

    /* JADX INFO: renamed from: E */
    public LinearLayout f17319E;

    /* JADX INFO: renamed from: F */
    public RealTimeBlurView f17320F;

    /* JADX INFO: renamed from: H */
    public int f17322H;

    /* JADX INFO: renamed from: I */
    public InterfaceC2749b f17323I;

    /* JADX INFO: renamed from: K */
    public SharedPreferences f17325K;

    /* JADX INFO: renamed from: G */
    public boolean f17321G = false;

    /* JADX INFO: renamed from: J */
    public C0895c f17324J = new C0895c(0);

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_apps_library_category);
        this.f17325K = getSharedPreferences(C2234v.m8924b(this), 0);
        this.f17320F = (RealTimeBlurView) findViewById(R.id.blurring_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_apps);
        this.f17318D = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        m1821J(findViewById(R.id.root_view), true);
        this.f17319E = (LinearLayout) findViewById(R.id.progress_layout);
        this.f17322H = getResources().getDimensionPixelSize(R.dimen.item_hidden_app_size);
        this.f17320F.setBlurredView((OverScrollLayout) findViewById(R.id.overscroll_layout));
        this.f17318D.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserverOnScrollChangedListenerC0813a(this, 0));
        new LinearLayoutManager(1).e1(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.e1(1);
        this.f17318D.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.f17318D;
        C0895c c0895c = this.f17324J;
        recyclerView2.setAdapter(c0895c);
        c0895c.f2650o = this;
        this.f17319E.setVisibility(0);
        try {
            new CallableC3080a(new CallableC0345a(4, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C0157a(14, this), AbstractC2679b.m9681a(), 1));
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
        InterfaceC2749b interfaceC2749b = this.f17323I;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
        super.onDestroy();
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z5) {
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            SharedPreferences.Editor editorEdit = this.f17325K.edit();
            editorEdit.putBoolean("app_library_dialog_guide", false);
            editorEdit.apply();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStop() {
        if (this.f17321G) {
            Utilities.m8174z(this);
        }
        super.onStop();
    }
}
