package com.luutinhit.launcher6;

import R4.AbstractC0965g;
import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p042u.AbstractC2812a;
import p069e3.C1977e;
import p124s0.AbstractC2705T;
import p128t0.C2774m;

/* JADX INFO: renamed from: com.luutinhit.launcher6.z3 */
/* JADX INFO: loaded from: classes.dex */
public class MergedLruCache implements OnAlarmListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17269j;

    /* JADX INFO: renamed from: k */
    public int f17270k;

    /* JADX INFO: renamed from: l */
    public int f17271l;

    /* JADX INFO: renamed from: m */
    public int f17272m;

    /* JADX INFO: renamed from: n */
    public int f17273n;

    /* JADX INFO: renamed from: o */
    public Object f17274o;

    /* JADX INFO: renamed from: p */
    public Object f17275p;

    public MergedLruCache(int i6) {
        this.f17269j = 2;
        this.f17270k = i6;
        if (i6 <= 0) {
            AbstractC2812a.m9972c("maxSize <= 0");
            throw null;
        }
        this.f17274o = new C2774m(1);
        this.f17275p = new C1977e(20);
    }

    /* JADX INFO: renamed from: a */
    public void m8275a(View view) {
        p124s0.q0 q0Var = (p124s0.q0) view.getLayoutParams();
        q0Var.f20991e = this;
        ArrayList arrayList = (ArrayList) this.f17274o;
        arrayList.add(view);
        this.f17271l = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f17270k = Integer.MIN_VALUE;
        }
        if (q0Var.f20803a.m9789w() || q0Var.f20803a.m9792z()) {
            this.f17272m = ((StaggeredGridLayoutManager) this.f17275p).f5451r.mo3106c(view) + this.f17272m;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m8276b() {
        p124s0.r0 r0VarM2076A;
        ArrayList arrayList = (ArrayList) this.f17274o;
        View view = (View) arrayList.get(arrayList.size() - 1);
        p124s0.q0 q0Var = (p124s0.q0) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f17275p;
        this.f17271l = staggeredGridLayoutManager.f5451r.mo3105b(view);
        if (q0Var.f20992f && (r0VarM2076A = staggeredGridLayoutManager.f5437B.m2076A(q0Var.f20803a.m9782j())) != null && r0VarM2076A.f20999k == 1) {
            int i6 = this.f17271l;
            int[] iArr = r0VarM2076A.f21000l;
            this.f17271l = (iArr == null ? 0 : iArr[this.f17273n]) + i6;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m8277c() {
        p124s0.r0 r0VarM2076A;
        View view = (View) ((ArrayList) this.f17274o).get(0);
        p124s0.q0 q0Var = (p124s0.q0) view.getLayoutParams();
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f17275p;
        this.f17270k = staggeredGridLayoutManager.f5451r.mo3108e(view);
        if (q0Var.f20992f && (r0VarM2076A = staggeredGridLayoutManager.f5437B.m2076A(q0Var.f20803a.m9782j())) != null && r0VarM2076A.f20999k == -1) {
            int i6 = this.f17270k;
            int[] iArr = r0VarM2076A.f21000l;
            this.f17270k = i6 - (iArr != null ? iArr[this.f17273n] : 0);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m8278d() {
        ((ArrayList) this.f17274o).clear();
        this.f17270k = Integer.MIN_VALUE;
        this.f17271l = Integer.MIN_VALUE;
        this.f17272m = 0;
    }

    /* JADX INFO: renamed from: e */
    public int m8279e() {
        boolean z5 = ((StaggeredGridLayoutManager) this.f17275p).f5456w;
        ArrayList arrayList = (ArrayList) this.f17274o;
        return z5 ? m8281g(arrayList.size() - 1, -1) : m8281g(0, arrayList.size());
    }

    /* JADX INFO: renamed from: f */
    public int m8280f() {
        boolean z5 = ((StaggeredGridLayoutManager) this.f17275p).f5456w;
        ArrayList arrayList = (ArrayList) this.f17274o;
        return z5 ? m8281g(0, arrayList.size()) : m8281g(arrayList.size() - 1, -1);
    }

    /* JADX INFO: renamed from: g */
    public int m8281g(int i6, int i7) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f17275p;
        int iMo3114k = staggeredGridLayoutManager.f5451r.mo3114k();
        int iMo3110g = staggeredGridLayoutManager.f5451r.mo3110g();
        int i8 = i7 > i6 ? 1 : -1;
        while (i6 != i7) {
            View view = (View) ((ArrayList) this.f17274o).get(i6);
            int iMo3108e = staggeredGridLayoutManager.f5451r.mo3108e(view);
            int iMo3105b = staggeredGridLayoutManager.f5451r.mo3105b(view);
            boolean z5 = iMo3108e <= iMo3110g;
            boolean z6 = iMo3105b >= iMo3114k;
            if (z5 && z6 && (iMo3108e < iMo3114k || iMo3105b > iMo3110g)) {
                return AbstractC2705T.m9723I(view);
            }
            i6 += i8;
        }
        return -1;
    }

    @Override // com.luutinhit.launcher6.OnAlarmListener
    /* JADX INFO: renamed from: h */
    public void mo7775h(Alarm alarm) {
        Objects.toString(alarm);
        Workspace workspace = (Workspace) this.f17275p;
        float[] fArr = workspace.f23437a1;
        workspace.f23415J0 = Workspace.L0((int) fArr[0], (int) fArr[1], this.f17270k, this.f17271l, workspace.f23429S0, workspace.f23415J0);
        int[] iArr = workspace.f23415J0;
        workspace.f23402C1 = iArr[0];
        workspace.f23404D1 = iArr[1];
        CellLayout cellLayout = workspace.f23429S0;
        float[] fArr2 = workspace.f23437a1;
        int i6 = (int) fArr2[0];
        int i7 = (int) fArr2[1];
        View view = (View) this.f17274o;
        int[] iArrM7626A = cellLayout.m7626A(i6, i7, this.f17270k, this.f17271l, this.f17272m, this.f17273n, view, iArr, new int[2], 1);
        workspace.f23415J0 = iArrM7626A;
        if (iArrM7626A[0] < 0 || iArrM7626A[1] < 0) {
            workspace.f23429S0.revertTempState();
        } else {
            workspace.setDragMode(3);
        }
    }

    /* JADX INFO: renamed from: i */
    public Object m8282i(Object obj) {
        AbstractC0965g.m2013e(obj, "key");
        synchronized (((C1977e) this.f17275p)) {
            C2774m c2774m = (C2774m) this.f17274o;
            c2774m.getClass();
            Object obj2 = c2774m.f21182a.get(obj);
            if (obj2 != null) {
                this.f17272m++;
                return obj2;
            }
            this.f17273n++;
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public int m8283j(int i6) {
        int i7 = this.f17271l;
        if (i7 != Integer.MIN_VALUE) {
            return i7;
        }
        if (((ArrayList) this.f17274o).size() == 0) {
            return i6;
        }
        m8276b();
        return this.f17271l;
    }

    /* JADX INFO: renamed from: k */
    public View m8284k(int i6, int i7) {
        ArrayList arrayList = (ArrayList) this.f17274o;
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.f17275p;
        View view = null;
        if (i7 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f5456w && AbstractC2705T.m9723I(view2) >= i6) || ((!staggeredGridLayoutManager.f5456w && AbstractC2705T.m9723I(view2) <= i6) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i8 = 0;
        while (i8 < size2) {
            View view3 = (View) arrayList.get(i8);
            if ((staggeredGridLayoutManager.f5456w && AbstractC2705T.m9723I(view3) <= i6) || ((!staggeredGridLayoutManager.f5456w && AbstractC2705T.m9723I(view3) >= i6) || !view3.hasFocusable())) {
                break;
            }
            i8++;
            view = view3;
        }
        return view;
    }

    /* JADX INFO: renamed from: l */
    public int m8285l(int i6) {
        int i7 = this.f17270k;
        if (i7 != Integer.MIN_VALUE) {
            return i7;
        }
        if (((ArrayList) this.f17274o).size() == 0) {
            return i6;
        }
        m8277c();
        return this.f17270k;
    }

    /* JADX INFO: renamed from: m */
    public void m8286m() {
        ArrayList arrayList = (ArrayList) this.f17274o;
        int size = arrayList.size();
        View view = (View) arrayList.remove(size - 1);
        p124s0.q0 q0Var = (p124s0.q0) view.getLayoutParams();
        q0Var.f20991e = null;
        if (q0Var.f20803a.m9789w() || q0Var.f20803a.m9792z()) {
            this.f17272m -= ((StaggeredGridLayoutManager) this.f17275p).f5451r.mo3106c(view);
        }
        if (size == 1) {
            this.f17270k = Integer.MIN_VALUE;
        }
        this.f17271l = Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: n */
    public void m8287n() {
        ArrayList arrayList = (ArrayList) this.f17274o;
        View view = (View) arrayList.remove(0);
        p124s0.q0 q0Var = (p124s0.q0) view.getLayoutParams();
        q0Var.f20991e = null;
        if (arrayList.size() == 0) {
            this.f17271l = Integer.MIN_VALUE;
        }
        if (q0Var.f20803a.m9789w() || q0Var.f20803a.m9792z()) {
            this.f17272m -= ((StaggeredGridLayoutManager) this.f17275p).f5451r.mo3106c(view);
        }
        this.f17270k = Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: o */
    public void m8288o(View view) {
        p124s0.q0 q0Var = (p124s0.q0) view.getLayoutParams();
        q0Var.f20991e = this;
        ArrayList arrayList = (ArrayList) this.f17274o;
        arrayList.add(0, view);
        this.f17270k = Integer.MIN_VALUE;
        if (arrayList.size() == 1) {
            this.f17271l = Integer.MIN_VALUE;
        }
        if (q0Var.f20803a.m9789w() || q0Var.f20803a.m9792z()) {
            this.f17272m = ((StaggeredGridLayoutManager) this.f17275p).f5451r.mo3106c(view) + this.f17272m;
        }
    }

    /* JADX INFO: renamed from: p */
    public Object m8289p(Object obj, Object obj2) {
        Object objPut;
        AbstractC0965g.m2013e(obj, "key");
        synchronized (((C1977e) this.f17275p)) {
            this.f17271l++;
            C2774m c2774m = (C2774m) this.f17274o;
            c2774m.getClass();
            objPut = c2774m.f21182a.put(obj, obj2);
            if (objPut != null) {
                this.f17271l--;
            }
        }
        m8290q(this.f17270k);
        return objPut;
    }

    /* JADX INFO: renamed from: q */
    public void m8290q(int i6) {
        while (true) {
            synchronized (((C1977e) this.f17275p)) {
                try {
                    if (!(this.f17271l >= 0 && (!((C2774m) this.f17274o).f21182a.isEmpty() || this.f17271l == 0))) {
                        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
                    }
                    if (this.f17271l > i6 && !((C2774m) this.f17274o).f21182a.isEmpty()) {
                        Set setEntrySet = ((C2774m) this.f17274o).f21182a.entrySet();
                        AbstractC0965g.m2012d(setEntrySet, "map.entries");
                        Set set = setEntrySet;
                        Object next = null;
                        if (set instanceof List) {
                            List list = (List) set;
                            if (!list.isEmpty()) {
                                next = list.get(0);
                            }
                        } else {
                            Iterator it = set.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                            }
                        }
                        Map.Entry entry = (Map.Entry) next;
                        if (entry == null) {
                            return;
                        }
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        C2774m c2774m = (C2774m) this.f17274o;
                        c2774m.getClass();
                        AbstractC0965g.m2013e(key, "key");
                        c2774m.f21182a.remove(key);
                        int i7 = this.f17271l;
                        AbstractC0965g.m2013e(value, "value");
                        this.f17271l = i7 - 1;
                    }
                    return;
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
    }

    public String toString() {
        String str;
        switch (this.f17269j) {
            case 2:
                synchronized (((C1977e) this.f17275p)) {
                    try {
                        int i6 = this.f17272m;
                        int i7 = this.f17273n + i6;
                        str = "LruCache[maxSize=" + this.f17270k + ",hits=" + this.f17272m + ",misses=" + this.f17273n + ",hitRate=" + (i7 != 0 ? (i6 * 100) / i7 : 0) + "%]";
                    } catch (Throwable th) {
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                }
                return str;
            default:
                return super.toString();
        }
    }

    public MergedLruCache(StaggeredGridLayoutManager staggeredGridLayoutManager, int i6) {
        this.f17269j = 1;
        this.f17275p = staggeredGridLayoutManager;
        this.f17274o = new ArrayList();
        this.f17270k = Integer.MIN_VALUE;
        this.f17271l = Integer.MIN_VALUE;
        this.f17272m = 0;
        this.f17273n = i6;
    }

    public MergedLruCache(Workspace workspace, int i6, int i7, int i8, int i9, View view) {
        this.f17269j = 0;
        this.f17275p = workspace;
        this.f17270k = i6;
        this.f17271l = i7;
        this.f17272m = i8;
        this.f17273n = i9;
        this.f17274o = view;
    }
}
