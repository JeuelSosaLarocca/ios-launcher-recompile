package com.luutinhit.launcher6.widget;

import A4.RunnableC0026a;
import B3.AbstractC0075r;
import C2.RunnableC0147g;
import E4.AbstractC0212f;
import G3.C0347c;
import G3.CallableC0345a;
import H3.C0423e;
import J3.AbstractC0543b;
import android.content.Context;
import android.os.Handler;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.C1416d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import p003D.C0157a;
import p024a.AbstractC1314a;
import p081h2.AbstractC2127a;
import p123r4.AbstractC2679b;
import p124s0.C2720i;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;
import s5.AbstractC2752b;

/* JADX INFO: loaded from: classes.dex */
public class CalendarWidget extends AbstractC0543b implements View.OnClickListener {

    /* JADX INFO: renamed from: I */
    public static final /* synthetic */ int f17049I = 0;

    /* JADX INFO: renamed from: A */
    public boolean f17050A;

    /* JADX INFO: renamed from: B */
    public Handler f17051B;

    /* JADX INFO: renamed from: C */
    public RunnableC0147g f17052C;

    /* JADX INFO: renamed from: D */
    public InterfaceC2749b f17053D;

    /* JADX INFO: renamed from: E */
    public C0347c f17054E;

    /* JADX INFO: renamed from: F */
    public int f17055F;

    /* JADX INFO: renamed from: G */
    public TextViewCustomFont f17056G;

    /* JADX INFO: renamed from: H */
    public TextViewCustomFont f17057H;

    /* JADX INFO: renamed from: n */
    public Context f17058n;

    /* JADX INFO: renamed from: o */
    public Locale f17059o;

    /* JADX INFO: renamed from: p */
    public View f17060p;

    /* JADX INFO: renamed from: q */
    public AppCompatImageView f17061q;

    /* JADX INFO: renamed from: r */
    public TextView f17062r;

    /* JADX INFO: renamed from: s */
    public TextView f17063s;

    /* JADX INFO: renamed from: t */
    public RecyclerView f17064t;

    /* JADX INFO: renamed from: u */
    public RecyclerView f17065u;

    /* JADX INFO: renamed from: v */
    public C0423e f17066v;

    /* JADX INFO: renamed from: w */
    public C0423e f17067w;

    /* JADX INFO: renamed from: x */
    public ArrayList f17068x;

    /* JADX INFO: renamed from: y */
    public ArrayList f17069y;

    /* JADX INFO: renamed from: z */
    public boolean f17070z;

    public CalendarWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17068x = new ArrayList();
        this.f17069y = new ArrayList();
        this.f17050A = false;
        this.f17051B = new Handler();
        this.f17052C = new RunnableC0147g(7, this);
        this.f17054E = new C0347c(this, new Handler(), 0);
        this.f17058n = context;
        this.f17055F = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.68d);
        this.f17050A = false;
        this.f17059o = AbstractC2752b.m9849i(getResources().getConfiguration()).f1788a.get();
        View viewInflate = LayoutInflater.from(this.f17058n).inflate(R.layout.calendar_widget, (ViewGroup) this, true);
        this.f17060p = viewInflate;
        this.f17064t = (RecyclerView) viewInflate.findViewById(R.id.event_one);
        this.f17065u = (RecyclerView) this.f17060p.findViewById(R.id.event_all);
        this.f17061q = (AppCompatImageView) this.f17060p.findViewById(R.id.more_icon);
        getResources().getDimensionPixelSize(R.dimen.small_icon_size);
        getResources().getDimensionPixelOffset(R.dimen.small_icon_round_corner);
        this.f17056G = (TextViewCustomFont) this.f17060p.findViewById(R.id.calendar_day);
        this.f17057H = (TextViewCustomFont) this.f17060p.findViewById(R.id.calendar_day_in_week);
        this.f17062r = (TextView) this.f17060p.findViewById(R.id.calendar_error);
        this.f17063s = (TextView) this.f17060p.findViewById(R.id.button_request_calendar_permission);
        this.f17061q.setOnClickListener(this);
        this.f17063s.setOnClickListener(this);
        this.f17064t.setItemAnimator(new C2720i());
        this.f17065u.setItemAnimator(new C2720i());
        RecyclerView recyclerView = this.f17064t;
        C0423e c0423e = new C0423e(0, this.f17058n, m1295D());
        this.f17066v = c0423e;
        recyclerView.setAdapter(c0423e);
        RecyclerView recyclerView2 = this.f17065u;
        C0423e c0423e2 = new C0423e(0, this.f17058n, m1295D());
        this.f17067w = c0423e2;
        recyclerView2.setAdapter(c0423e2);
        this.f17064t.setLayoutManager(new LinearLayoutManager(1));
        this.f17065u.setLayoutManager(new LinearLayoutManager(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEvents() {
        this.f17050A = false;
        try {
            new CallableC3080a(new CallableC0345a(1, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C0157a(2, this), AbstractC2679b.m9681a(), 1));
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
        m8223I();
        m8222H();
    }

    /* JADX INFO: renamed from: H */
    public final void m8222H() {
        ArrayList arrayList;
        Context context = this.f17058n;
        if (Utilities.f16748i && AbstractC2127a.m8789c(context, "android.permission.READ_CALENDAR") != 0) {
            this.f17063s.setVisibility(0);
            this.f17062r.setVisibility(0);
            return;
        }
        this.f17063s.setVisibility(8);
        this.f17062r.setVisibility(8);
        this.f17058n.getContentResolver().registerContentObserver(CalendarContract.Events.CONTENT_URI, true, this.f17054E);
        if (!this.f17050A || ((arrayList = this.f17068x) != null && arrayList.size() <= 0)) {
            Handler handler = this.f17051B;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(this.f17052C, 5000L);
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m8223I() {
        Date time = Calendar.getInstance().getTime();
        String str = new SimpleDateFormat("dd", Locale.getDefault()).format(time);
        String str2 = new SimpleDateFormat("EEEE", Locale.getDefault()).format(time);
        this.f17056G.setText(str);
        this.f17057H.setText(str2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f17058n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f17058n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.calendar_widget_content);
        C1416d c1416d = (C1416d) linearLayoutRound.getLayoutParams();
        int i7 = this.f17055F;
        c1416d.setMargins(i7, i7, i7, i7);
        setTextAndBackgroundColor(linearLayoutRound);
        LinearLayoutRound linearLayoutRound2 = (LinearLayoutRound) findViewById(R.id.calendar_widget_permission);
        C1416d c1416d2 = (C1416d) linearLayoutRound2.getLayoutParams();
        int i8 = this.f17055F;
        c1416d2.setMargins(i8, i8, i8, i8);
        setTextAndBackgroundColor(linearLayoutRound2);
        m8222H();
        m8223I();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.more_icon) {
            boolean z5 = this.f17070z;
            this.f17070z = !z5;
            if (z5) {
                this.f17061q.animate().withLayer().rotation(0.0f).setDuration(268L).start();
                m1296F(this.f17065u, false);
                return;
            } else {
                this.f17061q.animate().withLayer().rotation(90.0f).setDuration(268L).start();
                m1296F(this.f17065u, true);
                return;
            }
        }
        if (id == R.id.button_request_calendar_permission) {
            Context context = this.f17058n;
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
            this.f17058n.getContentResolver().unregisterContentObserver(this.f17054E);
        } catch (Throwable unused) {
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
        InterfaceC2749b interfaceC2749b = this.f17053D;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
    }
}
