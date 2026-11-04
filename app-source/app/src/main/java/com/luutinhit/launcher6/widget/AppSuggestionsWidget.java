package com.luutinhit.launcher6.widget;

import A4.RunnableC0026a;
import B3.RunnableC0064g;
import E4.AbstractC0212f;
import G3.C0346b;
import G3.CallableC0345a;
import H3.C0420b;
import J3.AbstractC0543b;
import T0.C1029l;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C1416d;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcherios.R;
import p024a.AbstractC1314a;
import p123r4.AbstractC2679b;
import p124s0.C2720i;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
public class AppSuggestionsWidget extends AbstractC0543b {

    /* JADX INFO: renamed from: v */
    public static final /* synthetic */ int f17040v = 0;

    /* JADX INFO: renamed from: n */
    public Context f17041n;

    /* JADX INFO: renamed from: o */
    public RecyclerView f17042o;

    /* JADX INFO: renamed from: p */
    public C0420b f17043p;

    /* JADX INFO: renamed from: q */
    public Handler f17044q;

    /* JADX INFO: renamed from: r */
    public RunnableC0064g f17045r;

    /* JADX INFO: renamed from: s */
    public InterfaceC2749b f17046s;

    /* JADX INFO: renamed from: t */
    public int f17047t;

    /* JADX INFO: renamed from: u */
    public boolean f17048u;

    public AppSuggestionsWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17044q = new Handler();
        this.f17045r = new RunnableC0064g(3, this);
        this.f17041n = context;
        this.f17048u = m1295D();
        this.f17047t = ((Launcher) context).getDeviceProfile().f15977C;
        LayoutInflater.from(this.f17041n).inflate(R.layout.app_suggestions_widget, (ViewGroup) this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAppSuggestions() {
        try {
            new CallableC3080a(new CallableC0345a(0, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C1029l(4, this), AbstractC2679b.m9681a(), 1));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC1314a.m2681A(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        Handler handler = this.f17044q;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.f17045r, 1000L);
        if (this.f17048u != m1295D()) {
            this.f17048u = m1295D();
            C1416d c1416d = (C1416d) this.f17042o.getLayoutParams();
            int i6 = (int) (((double) this.f17047t) * 0.68d);
            c1416d.setMargins(i6, i6, i6, i6);
            setTextAndBackgroundColor(this.f17042o);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f17041n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f17041n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.app_suggestions_widget_content);
        this.f17042o = recyclerView;
        recyclerView.setItemAnimator(new C2720i());
        C0420b c0420b = new C0420b(this.f17041n);
        this.f17043p = c0420b;
        this.f17042o.setAdapter(c0420b);
        this.f17042o.setLayoutManager(new GridLayoutManager(4));
        this.f17042o.m3419l(new C0346b((int) (((double) this.f17047t) * 1.32d)));
        C1416d c1416d = (C1416d) this.f17042o.getLayoutParams();
        int i6 = (int) (((double) this.f17047t) * 0.68d);
        c1416d.setMargins(i6, i6, i6, i6);
        setTextAndBackgroundColor(this.f17042o);
        Handler handler = this.f17044q;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.f17045r, 1000L);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
        InterfaceC2749b interfaceC2749b = this.f17046s;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
    }
}
