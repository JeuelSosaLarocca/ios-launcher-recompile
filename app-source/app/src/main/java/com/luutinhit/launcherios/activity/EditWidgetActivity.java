package com.luutinhit.launcherios.activity;

import B3.C0056Y;
import H3.C0423e;
import P3.AbstractActivityC0816d;
import P3.RunnableC0817e;
import Q3.C0899g;
import Q3.C0903k;
import Q3.InterfaceC0901i;
import Q3.InterfaceC0906n;
import R3.InterfaceC0958d;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import p005F.AsyncTaskC0222h;
import p091j2.AbstractC2247e;
import p124s0.C2737z;
import p124s0.l0;

/* JADX INFO: loaded from: classes.dex */
public class EditWidgetActivity extends AbstractActivityC0816d implements InterfaceC0901i, InterfaceC0906n, InterfaceC0958d {

    /* JADX INFO: renamed from: U */
    public static final Handler f17328U = new Handler();

    /* JADX INFO: renamed from: D */
    public Context f17329D;

    /* JADX INFO: renamed from: E */
    public C0056Y f17330E;

    /* JADX INFO: renamed from: F */
    public C2737z f17331F;

    /* JADX INFO: renamed from: H */
    public RecyclerView f17333H;

    /* JADX INFO: renamed from: I */
    public RecyclerView f17334I;

    /* JADX INFO: renamed from: J */
    public LinearLayout f17335J;

    /* JADX INFO: renamed from: K */
    public AppCompatImageView f17336K;

    /* JADX INFO: renamed from: L */
    public Animation f17337L;

    /* JADX INFO: renamed from: O */
    public C0903k f17340O;

    /* JADX INFO: renamed from: P */
    public C0423e f17341P;

    /* JADX INFO: renamed from: R */
    public OverScrollLayout f17343R;

    /* JADX INFO: renamed from: G */
    public int f17332G = 0;

    /* JADX INFO: renamed from: M */
    public ArrayList f17338M = new ArrayList();

    /* JADX INFO: renamed from: N */
    public ArrayList f17339N = new ArrayList();

    /* JADX INFO: renamed from: Q */
    public ArrayList f17342Q = new ArrayList();

    /* JADX INFO: renamed from: S */
    public ArrayList f17344S = new ArrayList();

    /* JADX INFO: renamed from: T */
    public RunnableC0817e f17345T = new RunnableC0817e(this, 0);

    /* JADX INFO: renamed from: K */
    public final ArrayList m8295K() {
        try {
            String string = this.f17330E.f137a.getString("list_choose_widget", null);
            return string != null ? new ArrayList(Arrays.asList(TextUtils.split(string, "‚‗‚"))) : new ArrayList(Arrays.asList("widget_weather", "widget_favorite", "widget_suggestion"));
        } catch (Throwable unused) {
            return new ArrayList(Arrays.asList("widget_weather", "widget_favorite", "widget_suggestion"));
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m8296L() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = this.f17342Q;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            int i6 = 0;
            while (true) {
                arrayList = this.f17339N;
                if (i6 >= size) {
                    break;
                }
                Object obj = arrayList3.get(i6);
                i6++;
                String str = (String) obj;
                ArrayList arrayList4 = this.f17338M;
                if (arrayList4 != null) {
                    int size2 = arrayList4.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        Object obj2 = arrayList4.get(i7);
                        i7++;
                        C0899g c0899g = (C0899g) obj2;
                        if (c0899g != null && str != null && str.equals(c0899g.f2658c)) {
                            arrayList.add(c0899g);
                        }
                    }
                }
            }
            Objects.toString(arrayList);
            if (arrayList != null && (arrayList2 = this.f17338M) != null) {
                arrayList2.removeAll(arrayList);
            }
            this.f17332G = this.f17342Q.size();
        }
    }

    /* JADX INFO: renamed from: M */
    public final void m8297M() {
        C0899g c0899g;
        if (this.f17341P != null) {
            ArrayList arrayList = this.f17342Q;
            if (arrayList == null) {
                this.f17342Q = new ArrayList();
            } else {
                arrayList.clear();
            }
            for (int i6 = 0; i6 < ((ArrayList) this.f17341P.f1340s).size(); i6++) {
                ArrayList arrayList2 = (ArrayList) this.f17341P.f1340s;
                if (arrayList2 != null && (c0899g = (C0899g) arrayList2.get(i6)) != null) {
                    this.f17342Q.add(c0899g.f2658c);
                }
            }
            this.f17330E.m139i("list_choose_widget", this.f17342Q);
        }
    }

    @Override // Q3.InterfaceC0906n
    /* JADX INFO: renamed from: b */
    public final void mo1970b() {
        Handler handler = f17328U;
        RunnableC0817e runnableC0817e = this.f17345T;
        handler.removeCallbacks(runnableC0817e);
        handler.postDelayed(runnableC0817e, 500L);
    }

    @Override // R3.InterfaceC0958d
    /* JADX INFO: renamed from: e */
    public final void mo2004e() {
        OverScrollLayout overScrollLayout = this.f17343R;
        if (overScrollLayout != null) {
            overScrollLayout.setDisallowInterceptTouchEvent(false);
        }
    }

    @Override // R3.InterfaceC0958d
    /* JADX INFO: renamed from: j */
    public final void mo2005j(l0 l0Var) {
        OverScrollLayout overScrollLayout = this.f17343R;
        if (overScrollLayout != null) {
            overScrollLayout.setDisallowInterceptTouchEvent(true);
        }
        C2737z c2737z = this.f17331F;
        if (c2737z != null) {
            c2737z.m9828t(l0Var);
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_widget);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17329D = getApplicationContext();
        this.f17330E = new C0056Y(this);
        try {
            ((LinearLayout) findViewById(R.id.linear_layout)).getLayoutTransition().enableTransitionType(4);
        } catch (Throwable th) {
            th.getMessage();
        }
        this.f17334I = (RecyclerView) findViewById(R.id.list_choose);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_apps);
        this.f17333H = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.f17336K = (AppCompatImageView) findViewById(R.id.progress);
        this.f17335J = (LinearLayout) findViewById(R.id.progress_layout);
        this.f17337L = AnimationUtils.loadAnimation(this, R.anim.ios_spinner_rotate);
        this.f17343R = (OverScrollLayout) findViewById(R.id.overscroll_layout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.e1(1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(1);
        linearLayoutManager2.e1(1);
        this.f17334I.setLayoutManager(linearLayoutManager);
        this.f17333H.setLayoutManager(linearLayoutManager2);
        this.f17334I.setNestedScrollingEnabled(false);
        this.f17342Q = m8295K();
        new AsyncTaskC0222h(2, this).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        AbstractC2247e.m8948p(this);
        overridePendingTransition(R.anim.empty_anim, R.anim.empty_anim);
        return true;
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onPause() {
        ArrayList arrayList;
        m8297M();
        ArrayList arrayList2 = this.f17344S;
        if (arrayList2 != null && (arrayList = this.f17342Q) != null && !arrayList2.equals(arrayList)) {
            sendBroadcast(new Intent("com.luutinhit.launcherios.ACTION_RELOAD_WIDGET"));
        }
        super.onPause();
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onResume() {
        this.f17344S = m8295K();
        super.onResume();
    }

    @Override // Q3.InterfaceC0906n
    /* JADX INFO: renamed from: q */
    public final void mo1971q(int i6, String str, String str2, Bitmap bitmap) {
        C0899g c0899g = new C0899g(i6, str, str2, bitmap);
        this.f17332G--;
        C0903k c0903k = this.f17340O;
        int iM1969p = c0903k.m1969p(i6);
        c0903k.f2667n.add(iM1969p, c0899g);
        c0903k.f20775j.m9712e(iM1969p, 1);
        Handler handler = f17328U;
        RunnableC0817e runnableC0817e = this.f17345T;
        handler.removeCallbacks(runnableC0817e);
        handler.postDelayed(runnableC0817e, 500L);
    }

    @Override // Q3.InterfaceC0901i
    /* JADX INFO: renamed from: t */
    public final void mo1966t(int i6, String str, String str2, Bitmap bitmap) {
        C0899g c0899g = new C0899g(i6, str, str2, bitmap);
        int i7 = this.f17332G;
        this.f17332G = i7 + 1;
        C0423e c0423e = this.f17341P;
        ((ArrayList) c0423e.f1340s).add(i7, c0899g);
        c0423e.f20775j.m9712e(i7, 1);
        Handler handler = f17328U;
        RunnableC0817e runnableC0817e = this.f17345T;
        handler.removeCallbacks(runnableC0817e);
        handler.postDelayed(runnableC0817e, 500L);
    }
}
