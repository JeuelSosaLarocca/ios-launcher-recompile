package com.luutinhit.launcherios.activity;

import B3.C0056Y;
import H3.C0423e;
import P3.AbstractActivityC0816d;
import P3.RunnableC0818f;
import P3.ViewTreeObserverOnScrollChangedListenerC0819g;
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
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import p005F.AsyncTaskC0222h;
import p091j2.AbstractC2247e;
import p124s0.C2737z;
import p124s0.l0;

/* JADX INFO: loaded from: classes.dex */
public class HiddenAppsActivity extends AbstractActivityC0816d implements InterfaceC0901i, InterfaceC0906n, InterfaceC0958d {

    /* JADX INFO: renamed from: V */
    public static final Handler f17346V = new Handler();

    /* JADX INFO: renamed from: E */
    public Context f17348E;

    /* JADX INFO: renamed from: F */
    public C0056Y f17349F;

    /* JADX INFO: renamed from: G */
    public C2737z f17350G;

    /* JADX INFO: renamed from: I */
    public RecyclerView f17352I;

    /* JADX INFO: renamed from: J */
    public RecyclerView f17353J;

    /* JADX INFO: renamed from: K */
    public LinearLayout f17354K;

    /* JADX INFO: renamed from: L */
    public AppCompatImageView f17355L;

    /* JADX INFO: renamed from: M */
    public Animation f17356M;

    /* JADX INFO: renamed from: P */
    public C0903k f17359P;

    /* JADX INFO: renamed from: Q */
    public C0423e f17360Q;

    /* JADX INFO: renamed from: S */
    public RealTimeBlurView f17362S;

    /* JADX INFO: renamed from: D */
    public String f17347D = "HiddenAppsActivity";

    /* JADX INFO: renamed from: H */
    public int f17351H = 0;

    /* JADX INFO: renamed from: N */
    public ArrayList f17357N = new ArrayList();

    /* JADX INFO: renamed from: O */
    public ArrayList f17358O = new ArrayList();

    /* JADX INFO: renamed from: R */
    public ArrayList f17361R = new ArrayList();

    /* JADX INFO: renamed from: T */
    public ArrayList f17363T = new ArrayList();

    /* JADX INFO: renamed from: U */
    public RunnableC0818f f17364U = new RunnableC0818f(this, 0);

    /* JADX INFO: renamed from: K */
    public final void m8298K() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3 = this.f17361R;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            int i6 = 0;
            while (true) {
                arrayList = this.f17358O;
                if (i6 >= size) {
                    break;
                }
                Object obj = arrayList3.get(i6);
                i6++;
                String str = (String) obj;
                ArrayList arrayList4 = this.f17357N;
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
            if (arrayList != null && (arrayList2 = this.f17357N) != null) {
                arrayList2.removeAll(arrayList);
            }
            this.f17351H = this.f17361R.size();
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m8299L() {
        C0899g c0899g;
        if (this.f17360Q != null) {
            ArrayList arrayList = this.f17361R;
            if (arrayList == null) {
                this.f17361R = new ArrayList();
            } else {
                arrayList.clear();
            }
            for (int i6 = 0; i6 < ((ArrayList) this.f17360Q.f1340s).size(); i6++) {
                ArrayList arrayList2 = (ArrayList) this.f17360Q.f1340s;
                if (arrayList2 != null && (c0899g = (C0899g) arrayList2.get(i6)) != null) {
                    this.f17361R.add(c0899g.f2658c);
                }
            }
            this.f17349F.m139i("list_hidden_apps", this.f17361R);
        }
    }

    @Override // Q3.InterfaceC0906n
    /* JADX INFO: renamed from: b */
    public final void mo1970b() {
        Handler handler = f17346V;
        RunnableC0818f runnableC0818f = this.f17364U;
        handler.removeCallbacks(runnableC0818f);
        handler.postDelayed(runnableC0818f, 500L);
    }

    @Override // R3.InterfaceC0958d
    /* JADX INFO: renamed from: e */
    public final void mo2004e() {
    }

    @Override // R3.InterfaceC0958d
    /* JADX INFO: renamed from: j */
    public final void mo2005j(l0 l0Var) {
        C2737z c2737z = this.f17350G;
        if (c2737z != null) {
            c2737z.m9828t(l0Var);
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_hidden_apps);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17348E = getApplicationContext();
        this.f17349F = new C0056Y(this);
        try {
            ((LinearLayout) findViewById(R.id.linear_layout)).getLayoutTransition().enableTransitionType(4);
        } catch (Throwable th) {
            th.getMessage();
        }
        this.f17362S = (RealTimeBlurView) findViewById(R.id.blurring_view);
        this.f17353J = (RecyclerView) findViewById(R.id.list_choose);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_apps);
        this.f17352I = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        this.f17355L = (AppCompatImageView) findViewById(R.id.progress);
        this.f17354K = (LinearLayout) findViewById(R.id.progress_layout);
        this.f17356M = AnimationUtils.loadAnimation(this, R.anim.ios_spinner_rotate);
        this.f17362S.setBlurredView((OverScrollLayout) findViewById(R.id.overscroll_layout));
        findViewById(R.id.scroll_view).getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserverOnScrollChangedListenerC0819g(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.e1(1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(1);
        linearLayoutManager2.e1(1);
        this.f17353J.setLayoutManager(linearLayoutManager);
        this.f17352I.setLayoutManager(linearLayoutManager2);
        this.f17353J.setNestedScrollingEnabled(false);
        this.f17361R = this.f17349F.m134d("list_hidden_apps");
        new AsyncTaskC0222h(3, this).execute(new Void[0]);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        AbstractC2247e.m8948p(this);
        overridePendingTransition(R.anim.empty_anim, R.anim.left_to_right);
        return true;
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onPause() {
        ArrayList arrayList;
        m8299L();
        ArrayList arrayList2 = this.f17363T;
        if (arrayList2 != null && (arrayList = this.f17361R) != null && !arrayList2.equals(arrayList)) {
            Intent intent = new Intent("com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE");
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = this.f17363T;
            int size = arrayList4.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList4.get(i6);
                i6++;
                String str = (String) obj;
                if (!this.f17361R.contains(str)) {
                    arrayList3.add(str);
                }
            }
            intent.putExtra("HIDDEN_APPS_UPDATED", (String[]) arrayList3.toArray(new String[0]));
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = this.f17361R;
            int size2 = arrayList6.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj2 = arrayList6.get(i7);
                i7++;
                String str2 = (String) obj2;
                if (!this.f17363T.contains(str2)) {
                    arrayList5.add(str2);
                }
            }
            intent.putExtra("HIDDEN_APPS_REMOVED", (String[]) arrayList5.toArray(new String[0]));
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
        }
        super.onPause();
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onResume() {
        this.f17363T = this.f17349F.m134d("list_hidden_apps");
        super.onResume();
    }

    @Override // Q3.InterfaceC0906n
    /* JADX INFO: renamed from: q */
    public final void mo1971q(int i6, String str, String str2, Bitmap bitmap) {
        C0899g c0899g = new C0899g(i6, str, str2, bitmap);
        this.f17351H--;
        C0903k c0903k = this.f17359P;
        int iM1969p = c0903k.m1969p(i6);
        c0903k.f2667n.add(iM1969p, c0899g);
        c0903k.f20775j.m9712e(iM1969p, 1);
        Handler handler = f17346V;
        RunnableC0818f runnableC0818f = this.f17364U;
        handler.removeCallbacks(runnableC0818f);
        handler.postDelayed(runnableC0818f, 500L);
    }

    @Override // Q3.InterfaceC0901i
    /* JADX INFO: renamed from: t */
    public final void mo1966t(int i6, String str, String str2, Bitmap bitmap) {
        C0899g c0899g = new C0899g(i6, str, str2, bitmap);
        int i7 = this.f17351H;
        this.f17351H = i7 + 1;
        C0423e c0423e = this.f17360Q;
        ((ArrayList) c0423e.f1340s).add(i7, c0899g);
        c0423e.f20775j.m9712e(i7, 1);
        Handler handler = f17346V;
        RunnableC0818f runnableC0818f = this.f17364U;
        handler.removeCallbacks(runnableC0818f);
        handler.postDelayed(runnableC0818f, 500L);
    }
}
