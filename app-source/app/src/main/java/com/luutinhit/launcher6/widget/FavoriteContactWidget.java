package com.luutinhit.launcher6.widget;

import A4.RunnableC0026a;
import B3.AbstractC0075r;
import C2.RunnableC0147g;
import E4.AbstractC0212f;
import G3.C0347c;
import G3.CallableC0345a;
import H3.C0423e;
import J3.AbstractC0543b;
import T0.C1029l;
import android.content.Context;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.C1416d;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.editscreen.ConstraintLayoutRound;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import p024a.AbstractC1314a;
import p081h2.AbstractC2127a;
import p123r4.AbstractC2679b;
import p124s0.C2720i;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
public class FavoriteContactWidget extends AbstractC0543b implements View.OnClickListener {

    /* JADX INFO: renamed from: G */
    public static final /* synthetic */ int f17087G = 0;

    /* JADX INFO: renamed from: A */
    public boolean f17088A;

    /* JADX INFO: renamed from: B */
    public Handler f17089B;

    /* JADX INFO: renamed from: C */
    public RunnableC0147g f17090C;

    /* JADX INFO: renamed from: D */
    public InterfaceC2749b f17091D;

    /* JADX INFO: renamed from: E */
    public C0347c f17092E;

    /* JADX INFO: renamed from: F */
    public int f17093F;

    /* JADX INFO: renamed from: n */
    public Context f17094n;

    /* JADX INFO: renamed from: o */
    public View f17095o;

    /* JADX INFO: renamed from: p */
    public TextView f17096p;

    /* JADX INFO: renamed from: q */
    public AppCompatImageView f17097q;

    /* JADX INFO: renamed from: r */
    public RecyclerView f17098r;

    /* JADX INFO: renamed from: s */
    public RecyclerView f17099s;

    /* JADX INFO: renamed from: t */
    public TextViewCustomFont f17100t;

    /* JADX INFO: renamed from: u */
    public C0423e f17101u;

    /* JADX INFO: renamed from: v */
    public C0423e f17102v;

    /* JADX INFO: renamed from: w */
    public ArrayList f17103w;

    /* JADX INFO: renamed from: x */
    public ArrayList f17104x;

    /* JADX INFO: renamed from: y */
    public boolean f17105y;

    /* JADX INFO: renamed from: z */
    public boolean f17106z;

    public FavoriteContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17103w = new ArrayList();
        this.f17104x = new ArrayList();
        this.f17088A = false;
        this.f17089B = new Handler();
        this.f17090C = new RunnableC0147g(9, this);
        this.f17092E = new C0347c(this, new Handler(), 2);
        this.f17094n = context;
        this.f17105y = m1295D();
        this.f17093F = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.68d);
        this.f17088A = false;
        View viewInflate = LayoutInflater.from(this.f17094n).inflate(R.layout.favorite_contact_widget, (ViewGroup) this, true);
        this.f17095o = viewInflate;
        this.f17098r = (RecyclerView) viewInflate.findViewById(R.id.favourite_contracts_one);
        this.f17099s = (RecyclerView) this.f17095o.findViewById(R.id.favourite_contracts_all);
        this.f17097q = (AppCompatImageView) this.f17095o.findViewById(R.id.more_icon);
        this.f17096p = (TextView) this.f17095o.findViewById(R.id.contact_error);
        this.f17100t = (TextViewCustomFont) this.f17095o.findViewById(R.id.button_request_contact_permission);
        this.f17097q.setOnClickListener(this);
        this.f17100t.setOnClickListener(this);
        this.f17098r.setItemAnimator(new C2720i());
        this.f17099s.setItemAnimator(new C2720i());
        RecyclerView recyclerView = this.f17098r;
        C0423e c0423e = new C0423e(1, this.f17094n, m1295D());
        this.f17101u = c0423e;
        recyclerView.setAdapter(c0423e);
        RecyclerView recyclerView2 = this.f17099s;
        C0423e c0423e2 = new C0423e(1, this.f17094n, m1295D());
        this.f17102v = c0423e2;
        recyclerView2.setAdapter(c0423e2);
        this.f17098r.setLayoutManager(new GridLayoutManager(4, 0));
        this.f17099s.setLayoutManager(new GridLayoutManager(4, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFavoriteContacts() {
        if (!AbstractC0075r.m193n(this.f17094n)) {
            this.f17096p.setVisibility(0);
            this.f17098r.setVisibility(4);
            boolean z5 = this.f17094n instanceof Launcher;
            return;
        }
        this.f17088A = false;
        try {
            new CallableC3080a(new CallableC0345a(3, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C1029l(5, this), AbstractC2679b.m9681a(), 1));
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
        m8227H();
        if (this.f17105y != m1295D()) {
            this.f17105y = m1295D();
            m8228I();
        }
    }

    /* JADX INFO: renamed from: H */
    public final void m8227H() {
        ArrayList arrayList;
        if (!AbstractC0075r.m193n(this.f17094n)) {
            this.f17096p.setVisibility(0);
            this.f17100t.setVisibility(0);
            return;
        }
        this.f17096p.setVisibility(8);
        this.f17100t.setVisibility(8);
        this.f17094n.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_STREQUENT_URI, true, this.f17092E);
        if (!this.f17088A || ((arrayList = this.f17103w) != null && arrayList.size() <= 0)) {
            Handler handler = this.f17089B;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(this.f17090C, 1000L);
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m8228I() {
        ConstraintLayoutRound constraintLayoutRound = (ConstraintLayoutRound) findViewById(R.id.favorite_contact_widget_content);
        C1416d c1416d = (C1416d) constraintLayoutRound.getLayoutParams();
        int i6 = this.f17093F;
        c1416d.setMargins(i6, i6, i6, i6);
        constraintLayoutRound.setDarkModeBackgroundColor(m1295D() ? getResources().getColor(R.color.folder_color_dark) : getResources().getColor(R.color.folder_color));
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.favorite_contact_widget_permission);
        C1416d c1416d2 = (C1416d) linearLayoutRound.getLayoutParams();
        int i7 = this.f17093F;
        c1416d2.setMargins(i7, i7, i7, i7);
        setTextAndBackgroundColor(linearLayoutRound);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f17094n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f17094n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
        m8228I();
        m8227H();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.more_icon) {
            boolean z5 = this.f17106z;
            this.f17106z = !z5;
            if (z5) {
                this.f17097q.animate().withLayer().rotation(0.0f).setDuration(268L).start();
                m1296F(this.f17099s, false);
                return;
            } else {
                this.f17097q.animate().withLayer().rotation(90.0f).setDuration(268L).start();
                m1296F(this.f17099s, true);
                return;
            }
        }
        if (view.getId() == R.id.button_request_contact_permission) {
            Context context = this.f17094n;
            if (context instanceof Launcher) {
                Launcher launcher = (Launcher) context;
                if (Utilities.f16748i) {
                    if (launcher.shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS")) {
                        AbstractC2127a.m8799n(launcher, new String[]{"android.permission.READ_CONTACTS"}, 68);
                    } else {
                        AbstractC0075r.m198t(launcher, "android.permission.READ_CONTACTS");
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.f17094n.getContentResolver().unregisterContentObserver(this.f17092E);
        } catch (Throwable unused) {
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
        InterfaceC2749b interfaceC2749b = this.f17091D;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
    }
}
