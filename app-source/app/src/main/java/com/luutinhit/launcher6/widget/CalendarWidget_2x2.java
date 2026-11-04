package com.luutinhit.launcher6.widget;

import A4.RunnableC0026a;
import B3.AbstractC0075r;
import C2.RunnableC0147g;
import E4.AbstractC0212f;
import G3.C0347c;
import G3.CallableC0345a;
import H3.C0423e;
import J0.C0489j;
import J3.AbstractC0543b;
import android.content.Context;
import android.os.Handler;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C1416d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import p024a.AbstractC1314a;
import p081h2.AbstractC2127a;
import p123r4.AbstractC2679b;
import p124s0.C2720i;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;
import s5.AbstractC2752b;

/* JADX INFO: loaded from: classes.dex */
public class CalendarWidget_2x2 extends AbstractC0543b implements View.OnClickListener {

    /* JADX INFO: renamed from: C */
    public static final /* synthetic */ int f17071C = 0;

    /* JADX INFO: renamed from: A */
    public TextViewCustomFont f17072A;

    /* JADX INFO: renamed from: B */
    public TextViewCustomFont f17073B;

    /* JADX INFO: renamed from: n */
    public Context f17074n;

    /* JADX INFO: renamed from: o */
    public Locale f17075o;

    /* JADX INFO: renamed from: p */
    public View f17076p;

    /* JADX INFO: renamed from: q */
    public RecyclerView f17077q;

    /* JADX INFO: renamed from: r */
    public LinearLayoutRound f17078r;

    /* JADX INFO: renamed from: s */
    public C0423e f17079s;

    /* JADX INFO: renamed from: t */
    public boolean f17080t;

    /* JADX INFO: renamed from: u */
    public Handler f17081u;

    /* JADX INFO: renamed from: v */
    public RunnableC0147g f17082v;

    /* JADX INFO: renamed from: w */
    public InterfaceC2749b f17083w;

    /* JADX INFO: renamed from: x */
    public C0347c f17084x;

    /* JADX INFO: renamed from: y */
    public boolean f17085y;

    /* JADX INFO: renamed from: z */
    public int f17086z;

    public CalendarWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17080t = false;
        this.f17081u = new Handler();
        this.f17082v = new RunnableC0147g(8, this);
        this.f17084x = new C0347c(this, new Handler(), 1);
        this.f17074n = context;
        this.f17085y = m1295D();
        this.f17086z = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.68d);
        this.f17080t = false;
        this.f17075o = AbstractC2752b.m9849i(getResources().getConfiguration()).f1788a.get();
        View viewInflate = LayoutInflater.from(this.f17074n).inflate(R.layout.calendar_widget_2x2, (ViewGroup) this, true);
        this.f17076p = viewInflate;
        this.f17077q = (RecyclerView) viewInflate.findViewById(R.id.event_all);
        this.f17072A = (TextViewCustomFont) this.f17076p.findViewById(R.id.calendar_day);
        this.f17073B = (TextViewCustomFont) this.f17076p.findViewById(R.id.calendar_day_in_week);
        this.f17078r = (LinearLayoutRound) findViewById(R.id.calendar_widget_permission);
        ((TextViewCustomFont) this.f17076p.findViewById(R.id.button_request_calendar_permission)).setOnClickListener(this);
        this.f17077q.setItemAnimator(new C2720i());
        this.f17079s = new C0423e(0, this.f17074n, m1295D());
        this.f17077q.setLayoutManager(new LinearLayoutManager(1));
        this.f17077q.setAdapter(this.f17079s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEvents() {
        this.f17080t = false;
        try {
            new CallableC3080a(new CallableC0345a(2, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C0489j(4, this), AbstractC2679b.m9681a(), 1));
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
        Date time = Calendar.getInstance().getTime();
        String str = new SimpleDateFormat("dd", Locale.getDefault()).format(time);
        String str2 = new SimpleDateFormat("EEEE", Locale.getDefault()).format(time);
        this.f17072A.setText(str);
        this.f17073B.setText(str2);
        Context context = this.f17074n;
        if (!Utilities.f16748i || AbstractC2127a.m8789c(context, "android.permission.READ_CALENDAR") == 0) {
            this.f17078r.setVisibility(8);
            this.f17074n.getContentResolver().registerContentObserver(CalendarContract.Events.CONTENT_URI, true, this.f17084x);
            if (!this.f17080t) {
                Handler handler = this.f17081u;
                handler.removeCallbacksAndMessages(null);
                handler.postDelayed(this.f17082v, 5000L);
            }
        } else {
            this.f17078r.setVisibility(0);
        }
        if (this.f17085y != m1295D()) {
            this.f17085y = m1295D();
            m8225H();
        }
    }

    /* JADX INFO: renamed from: H */
    public final void m8225H() {
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.calendar_widget_content);
        C1416d c1416d = (C1416d) linearLayoutRound.getLayoutParams();
        int i6 = this.f17086z;
        c1416d.setMargins(i6, i6, i6, i6);
        C1416d c1416d2 = (C1416d) this.f17078r.getLayoutParams();
        int i7 = this.f17086z;
        c1416d2.setMargins(i7, i7, i7, i7);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(R.id.calendar_day);
        if (m1295D()) {
            linearLayoutRound.setDarkModeBackgroundColor(getResources().getColor(R.color.folder_color_dark));
            this.f17078r.setBackgroundResource(R.drawable.round_rect_qsb_dark);
            textViewCustomFont.setTextColor(-1);
        } else {
            linearLayoutRound.setDarkModeBackgroundColor(getResources().getColor(R.color.folder_color));
            this.f17078r.setBackgroundResource(R.drawable.round_rect_widget_white);
            textViewCustomFont.setTextColor(-16777216);
        }
        C0423e c0423e = this.f17079s;
        if (c0423e != null) {
            c0423e.f1339r = m1295D();
            c0423e.m9703f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f17074n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f17074n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.button_request_calendar_permission) {
            Context context = this.f17074n;
            if (context instanceof Launcher) {
                Launcher launcher = (Launcher) context;
                if (Utilities.f16748i) {
                    if (launcher.shouldShowRequestPermissionRationale("android.permission.READ_CALENDAR")) {
                        AbstractC2127a.m8799n(launcher, new String[]{"android.permission.READ_CALENDAR"}, 68);
                    } else {
                        AbstractC0075r.m198t(launcher, "android.permission.READ_CALENDAR");
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.f17074n.getContentResolver().unregisterContentObserver(this.f17084x);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m8225H();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i6);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
        InterfaceC2749b interfaceC2749b = this.f17083w;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
    }
}
