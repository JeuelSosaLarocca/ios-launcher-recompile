package com.luutinhit.launcher6.leftpage.database;

import J1.C0501G;
import J1.C0531q;
import L0.C0621o;
import R4.AbstractC0965g;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p128t0.C2763b;
import p128t0.C2770i;
import p140v3.C2866a;
import p147x0.InterfaceC2952b;

/* JADX INFO: loaded from: classes.dex */
public final class LeftPageWidgetDatabase_Impl extends LeftPageWidgetDatabase {


    /* JADX INFO: renamed from: l */
    public volatile C2866a f16664l;

    @Override // p128t0.AbstractC2775n
    /* JADX INFO: renamed from: d */
    public final C2770i mo3468d() {
        return new C2770i(this, new HashMap(0), new HashMap(0), "LeftPageWidget");
    }

    @Override // p128t0.AbstractC2775n
    /* JADX INFO: renamed from: e */
    public final InterfaceC2952b mo3469e(C2763b c2763b) {
        C0531q c0531q = new C0531q(c2763b, new C0621o(this), "fc241614abab42898ea133b50fc265df", "cb688170a96a1e58a794aa9c0a7d4fac");
        Context context = c2763b.f21133a;
        AbstractC0965g.m2013e(context, "context");
        return c2763b.f21135c.mo910l(new C0501G(context, c2763b.f21134b, c0531q, false, false));
    }

    @Override // p128t0.AbstractC2775n
    /* JADX INFO: renamed from: f */
    public final List mo3470f(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    @Override // p128t0.AbstractC2775n
    /* JADX INFO: renamed from: h */
    public final Set mo3471h() {
        return new HashSet();
    }

    @Override // p128t0.AbstractC2775n
    /* JADX INFO: renamed from: i */
    public final Map mo3472i() {
        HashMap map = new HashMap();
        map.put(C2866a.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.luutinhit.launcher6.leftpage.database.LeftPageWidgetDatabase
    /* JADX INFO: renamed from: p */
    public final C2866a mo8137p() {
        C2866a c2866a;
        if (this.f16664l != null) {
            return this.f16664l;
        }
        synchronized (this) {
            try {
                if (this.f16664l == null) {
                    this.f16664l = new C2866a(this);
                }
                c2866a = this.f16664l;
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        return c2866a;
    }
}
