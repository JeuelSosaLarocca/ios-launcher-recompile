package com.luutinhit.launcher6.appslibrary;

import android.os.RemoteException;
import B1.RunnableC0031a;
import G1.C3106x0;
import G3.RunnableC0358n;
import I1.C0460k;
import J3.AbstractC0544c;
import K0.AbstractC0577y;
import R4.AbstractC0965g;
import Y4.C1248e;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.preference.Preference;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.AbstractC1690d;
import com.bumptech.glide.load.data.C1699a;
import com.bumptech.glide.load.data.C1709k;
import com.bumptech.glide.load.data.InterfaceC1703e;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.C9;
import com.luutinhit.launcher6.AppsLibraryProgressCallback;
import com.luutinhit.launcher6.BlurAnimRunnable;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.RuntimeShaderGlassView;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.network.OpenWeather;
import d4.C1913e;
import g5.C2087D;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import o4.C2536a;
import p006H.C0391d;
import p029g.LayoutInflaterFactory2C2069v;
import p034m.C2357d;
import p034m.C2366m;
import p034m.InterfaceC2375v;
import p034m.MenuC2364k;
import p034m.SubMenuC2353C;
import p034m.ViewOnKeyListenerC2358e;
import p035n.C2478k;
import p035n.InterfaceC4475j0;
import p055b2.InterfaceC1573h;
import p058c1.InterfaceC1624m;
import p059c2.C1646m;
import p060c3.C1665f;
import p067e1.C1953k;
import p067e1.RunnableC1950h;
import p068e2.C1969a;
import p068e2.C1972d;
import p069e3.InterfaceC1988p;
import p082h3.AbstractC2132c;
import p085i1.C2162E;
import p085i1.C2165b;
import p085i1.C2178o;
import p085i1.C2187x;
import p085i1.InterfaceC2161D;
import p085i1.InterfaceC2164a;
import p085i1.InterfaceC2181r;
import p085i1.InterfaceC2182s;
import p100l2.BinderC2334f;
import p100l2.C2333e;
import p104m2.AbstractC2384a;
import p105m4.C2407e;
import p110o2.AbstractC2533c;
import p110o2.C2531a;
import p110o2.C2532b;
import p116q0.InterfaceC2600c;
import p121r2.C2650b;
import p124s0.AbstractC2705T;
import p124s0.C2706U;
import p124s0.C2712a;
import p124s0.b0;
import p124s0.l0;
import p124s0.t0;
import p125s1.C2741d;
import p131t3.RunnableC2788a;
import p131t3.ViewOnClickListenerC2791d;
import p138v1.C2852a;
import p138v1.C2853b;
import p138v1.InterfaceC2854c;
import p138v1.InterfaceC2855d;
import p139v2.C2861f;
import p152y1.InterfaceC3021a;
import v5.C2881M;
import v5.C2895g;
import v5.InterfaceC2891c;
import v5.InterfaceC2894f;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.c */
/* JADX INFO: loaded from: classes.dex */
public final class MergedCallbacks implements AppsLibraryProgressCallback, InterfaceC3021a, InterfaceC1573h, InterfaceC1988p, InterfaceC2375v, InterfaceC2182s, InterfaceC2164a, InterfaceC2161D, InterfaceC4475j0, InterfaceC2894f, InterfaceC2600c, t0, InterfaceC2855d {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16285j;

    /* JADX INFO: renamed from: k */
    public Object f16286k;

    public /* synthetic */ MergedCallbacks(int i6, Object obj) {
        this.f16285j = i6;
        this.f16286k = obj;
    }

    /* JADX INFO: renamed from: A */
    public synchronized InterfaceC1624m m7936A(Class cls) {
        int size = ((ArrayList) this.f16286k).size();
        for (int i6 = 0; i6 < size; i6++) {
            C2741d c2741d = (C2741d) ((ArrayList) this.f16286k).get(i6);
            if (c2741d.f21082a.isAssignableFrom(cls)) {
                return c2741d.f21083b;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: B */
    public void m7937B(int i6, int i7, Preference preference) {
        int i8;
        int i9;
        RecyclerView recyclerView = (RecyclerView) this.f16286k;
        int iM1272k = recyclerView.f5424o.m1272k();
        int i10 = i7 + i6;
        for (int i11 = 0; i11 < iM1272k; i11++) {
            View viewM1271j = recyclerView.f5424o.m1271j(i11);
            l0 l0VarM3387R = RecyclerView.m3387R(viewM1271j);
            if (l0VarM3387R != null && !l0VarM3387R.m9777D() && (i9 = l0VarM3387R.f20919l) >= i6 && i9 < i10) {
                l0VarM3387R.m9779e(2);
                if (preference == null) {
                    l0VarM3387R.m9779e(1024);
                } else if ((1024 & l0VarM3387R.f20926s) == 0) {
                    if (l0VarM3387R.f20927t == null) {
                        ArrayList arrayList = new ArrayList();
                        l0VarM3387R.f20927t = arrayList;
                        l0VarM3387R.f20928u = Collections.unmodifiableList(arrayList);
                    }
                    l0VarM3387R.f20927t.add(preference);
                }
                ((C2706U) viewM1271j.getLayoutParams()).f20805c = true;
            }
        }
        b0 b0Var = recyclerView.f5421l;
        ArrayList arrayList2 = b0Var.f20824c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            l0 l0Var = (l0) arrayList2.get(size);
            if (l0Var != null && (i8 = l0Var.f20919l) >= i6 && i8 < i10) {
                l0Var.m9779e(2);
                b0Var.m9753g(size);
            }
        }
        recyclerView.f22344u0 = true;
    }

    /* JADX INFO: renamed from: C */
    public void m7938C(int i6, int i7) {
        RecyclerView recyclerView = (RecyclerView) this.f16286k;
        int iM1272k = recyclerView.f5424o.m1272k();
        for (int i8 = 0; i8 < iM1272k; i8++) {
            l0 l0VarM3387R = RecyclerView.m3387R(recyclerView.f5424o.m1271j(i8));
            if (l0VarM3387R != null && !l0VarM3387R.m9777D() && l0VarM3387R.f20919l >= i6) {
                if (RecyclerView.f22306K0) {
                    l0VarM3387R.toString();
                }
                l0VarM3387R.m9774A(i7, false);
                recyclerView.f22340q0.f20873f = true;
            }
        }
        ArrayList arrayList = recyclerView.f5421l.f20824c;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            l0 l0Var = (l0) arrayList.get(i9);
            if (l0Var != null && l0Var.f20919l >= i6) {
                if (RecyclerView.f22306K0) {
                    l0Var.toString();
                }
                l0Var.m9774A(i7, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f22343t0 = true;
    }

    /* JADX INFO: renamed from: D */
    public void m7939D(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        RecyclerView recyclerView = (RecyclerView) this.f16286k;
        int iM1272k = recyclerView.f5424o.m1272k();
        int i15 = -1;
        if (i6 < i7) {
            i9 = i6;
            i8 = i7;
            i10 = -1;
        } else {
            i8 = i6;
            i9 = i7;
            i10 = 1;
        }
        for (int i16 = 0; i16 < iM1272k; i16++) {
            l0 l0VarM3387R = RecyclerView.m3387R(recyclerView.f5424o.m1271j(i16));
            if (l0VarM3387R != null && (i14 = l0VarM3387R.f20919l) >= i9 && i14 <= i8) {
                if (RecyclerView.f22306K0) {
                    l0VarM3387R.toString();
                }
                if (l0VarM3387R.f20919l == i6) {
                    l0VarM3387R.m9774A(i7 - i6, false);
                } else {
                    l0VarM3387R.m9774A(i10, false);
                }
                recyclerView.f22340q0.f20873f = true;
            }
        }
        b0 b0Var = recyclerView.f5421l;
        b0Var.getClass();
        if (i6 < i7) {
            i12 = i6;
            i11 = i7;
        } else {
            i11 = i6;
            i12 = i7;
            i15 = 1;
        }
        ArrayList arrayList = b0Var.f20824c;
        int size = arrayList.size();
        for (int i17 = 0; i17 < size; i17++) {
            l0 l0Var = (l0) arrayList.get(i17);
            if (l0Var != null && (i13 = l0Var.f20919l) >= i12 && i13 <= i11) {
                if (i13 == i6) {
                    l0Var.m9774A(i7 - i6, false);
                } else {
                    l0Var.m9774A(i15, false);
                }
                if (RecyclerView.f22306K0) {
                    l0Var.toString();
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.f22343t0 = true;
    }

    /* JADX INFO: renamed from: F */
    public synchronized void m7940F(C1913e c1913e) {
        c1913e.f17755l = true;
        C1913e c1913e2 = (C1913e) this.f16286k;
        if (c1913e2.f17756m == c1913e) {
            c1913e2.f17756m = null;
        }
        notifyAll();
    }

    /* JADX INFO: renamed from: G */
    public synchronized boolean m7941G(C1913e c1913e) {
        C1913e c1913e2 = (C1913e) this.f16286k;
        C1913e c1913e3 = c1913e2.f17756m;
        if (c1913e3 != c1913e && c1913e3 != null) {
            return false;
        }
        c1913e2.f17756m = c1913e;
        notifyAll();
        return true;
    }

    @Override // p034m.InterfaceC2375v
    /* JADX INFO: renamed from: a */
    public void mo7942a(MenuC2364k menuC2364k, boolean z5) {
        switch (this.f16285j) {
            case 6:
                ((LayoutInflaterFactory2C2069v) this.f16286k).m8675l(menuC2364k);
                break;
            default:
                if (menuC2364k instanceof SubMenuC2353C) {
                    ((SubMenuC2353C) menuC2364k).f19452I.mo9197k().m9212c(false);
                }
                InterfaceC2375v interfaceC2375v = ((C2478k) this.f16286k).f20080n;
                if (interfaceC2375v != null) {
                    interfaceC2375v.mo7942a(menuC2364k, z5);
                }
                break;
        }
    }

    @Override // com.luutinhit.launcher6.AppsLibraryProgressCallback
    /* JADX INFO: renamed from: b */
    public void mo7796b(boolean z5) {
        RealTimeBlurView realTimeBlurView;
        switch (this.f16285j) {
            case 0:
                AppsLibraryView appsLibraryView = (AppsLibraryView) this.f16286k;
                Launcher launcher = appsLibraryView.f16289j;
                if (launcher != null && (realTimeBlurView = appsLibraryView.f16296q) != null && launcher.getBlurGlassWallpaper() != null) {
                    realTimeBlurView.setBitmapBackground(appsLibraryView.f16289j.getBlurGlassWallpaper());
                    break;
                }
                break;
            default:
                ViewOnClickListenerC2791d viewOnClickListenerC2791d = (ViewOnClickListenerC2791d) this.f16286k;
                Launcher launcher2 = viewOnClickListenerC2791d.f21273j;
                if (launcher2 != null && viewOnClickListenerC2791d.f21279p != null && launcher2.getBlurGlassWallpaper() != null) {
                    viewOnClickListenerC2791d.f21279p.setBitmapBackground(viewOnClickListenerC2791d.f21273j.getBlurGlassWallpaper());
                }
                viewOnClickListenerC2791d.getVisibility();
                viewOnClickListenerC2791d.getAlpha();
                viewOnClickListenerC2791d.f21284u.getVisibility();
                viewOnClickListenerC2791d.f21284u.getAlpha();
                viewOnClickListenerC2791d.getX();
                viewOnClickListenerC2791d.getY();
                viewOnClickListenerC2791d.f21284u.getX();
                viewOnClickListenerC2791d.f21284u.getY();
                int childCount = viewOnClickListenerC2791d.f21284u.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = viewOnClickListenerC2791d.f21284u.getChildAt(i6);
                    if (childAt instanceof AbstractC0544c) {
                        ((AbstractC0544c) childAt).mo1297A();
                    }
                }
                break;
        }
    }

    @Override // p116q0.InterfaceC2600c
    /* JADX INFO: renamed from: c */
    public void mo7943c(int i6, Serializable serializable) {
        if (i6 == 6 || i6 == 7 || i6 == 8) {
        }
        ((ProfileInstallReceiver) this.f16286k).setResultCode(i6);
    }

    @Override // p035n.InterfaceC4475j0
    /* JADX INFO: renamed from: d */
    public void mo7944d(MenuC2364k menuC2364k, C2366m c2366m) {
        ViewOnKeyListenerC2358e viewOnKeyListenerC2358e = (ViewOnKeyListenerC2358e) this.f16286k;
        viewOnKeyListenerC2358e.f19488o.removeCallbacksAndMessages(null);
        ArrayList arrayList = viewOnKeyListenerC2358e.f19490q;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (menuC2364k == ((C2357d) arrayList.get(i6)).f19473b) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 == -1) {
            return;
        }
        int i7 = i6 + 1;
        viewOnKeyListenerC2358e.f19488o.postAtTime(new RunnableC0031a(this, i7 < arrayList.size() ? (C2357d) arrayList.get(i7) : null, c2366m, menuC2364k, 20, false), menuC2364k, SystemClock.uptimeMillis() + 200);
    }

    @Override // com.luutinhit.launcher6.AppsLibraryProgressCallback
    /* JADX INFO: renamed from: e */
    public void mo7797e() {
        switch (this.f16285j) {
            case 0:
                break;
            default:
                ViewOnClickListenerC2791d viewOnClickListenerC2791d = (ViewOnClickListenerC2791d) this.f16286k;
                int childCount = viewOnClickListenerC2791d.f21284u.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = viewOnClickListenerC2791d.f21284u.getChildAt(i6);
                    if (childAt instanceof AbstractC0544c) {
                        ((AbstractC0544c) childAt).mo1298y();
                    }
                }
                viewOnClickListenerC2791d.f21281r.setVisibility(8);
                viewOnClickListenerC2791d.f21280q.setVisibility(8);
                viewOnClickListenerC2791d.m9949A();
                SlidingUpWidgetsList slidingUpWidgetsList = viewOnClickListenerC2791d.f21282s;
                if (slidingUpWidgetsList != null) {
                    slidingUpWidgetsList.postOnAnimation(new RunnableC2788a(viewOnClickListenerC2791d, 5));
                }
                break;
        }
    }

    @Override // p124s0.t0
    /* JADX INFO: renamed from: f */
    public int mo7945f() {
        AbstractC2705T abstractC2705T = (AbstractC2705T) this.f16286k;
        return abstractC2705T.f20802o - abstractC2705T.m9732E();
    }

    @Override // p085i1.InterfaceC2161D
    /* JADX INFO: renamed from: g */
    public InterfaceC1703e mo7946g(Uri uri) {
        return new C1699a((ContentResolver) this.f16286k, uri, 1);
    }

    @Override // p138v1.InterfaceC2855d
    /* JADX INFO: renamed from: h */
    public InterfaceC2854c mo7947h(int i6) {
        if (i6 == 5) {
            return C2853b.f21450j;
        }
        if (((C2852a) this.f16286k) == null) {
            this.f16286k = new C2852a();
        }
        return (C2852a) this.f16286k;
    }

    @Override // p035n.InterfaceC4475j0
    /* JADX INFO: renamed from: i */
    public void mo7948i(MenuC2364k menuC2364k, C2366m c2366m) {
        ((ViewOnKeyListenerC2358e) this.f16286k).f19488o.removeCallbacksAndMessages(menuC2364k);
    }

    @Override // p124s0.t0
    /* JADX INFO: renamed from: j */
    public int mo7949j(View view) {
        C2706U c2706u = (C2706U) view.getLayoutParams();
        ((AbstractC2705T) this.f16286k).getClass();
        return AbstractC2705T.m9722C(view) - ((ViewGroup.MarginLayoutParams) c2706u).topMargin;
    }

    @Override // p152y1.InterfaceC3021a
    /* JADX INFO: renamed from: k */
    public Object mo2272k() {
        C0391d c0391d = (C0391d) this.f16286k;
        return new RunnableC1950h((C9) c0391d.f1246c, (C2333e) c0391d.f1247d);
    }

    @Override // p085i1.InterfaceC2164a
    /* JADX INFO: renamed from: l */
    public InterfaceC1703e mo407l(AssetManager assetManager, String str) {
        return new C1709k(assetManager, str, 1);
    }

    @Override // v5.InterfaceC2894f
    /* JADX INFO: renamed from: m */
    public void mo2099m(InterfaceC2891c interfaceC2891c, Throwable th) {
        switch (this.f16285j) {
            case 14:
                th.getMessage();
                C2407e c2407e = ((C2536a) this.f16286k).f20267a;
                c2407e.getClass();
                th.getMessage();
                c2407e.f19702c.restoreCurrentResponse(c2407e.f19700a, c2407e.f19701b);
                break;
            case 23:
                ((C2895g) this.f16286k).completeExceptionally(th);
                break;
            default:
                AbstractC0965g.m2014f(interfaceC2891c, "call");
                ((C1248e) this.f16286k).mo1107i(AbstractC0577y.m1336f(th));
                break;
        }
    }

    @Override // com.luutinhit.launcher6.AppsLibraryProgressCallback
    /* JADX INFO: renamed from: n */
    public void mo7798n(float f6) {
        BouncyRecyclerView bouncyRecyclerView;
        float f7;
        int i6;
        switch (this.f16285j) {
            case 0:
                AppsLibraryView appsLibraryView = (AppsLibraryView) this.f16286k;
                if (appsLibraryView.f16289j != null) {
                    float f8 = appsLibraryView.isRtl() ? f6 - appsLibraryView.f16289j.screenWidth : appsLibraryView.f16289j.screenWidth + f6;
                    appsLibraryView.isRtl();
                    RealTimeBlurView realTimeBlurView = appsLibraryView.f16296q;
                    realTimeBlurView.f16982D = f8;
                    realTimeBlurView.invalidate();
                    appsLibraryView.post(new BlurAnimRunnable(this, f6, 1));
                    if (appsLibraryView.f16289j.isRuntimeRenderSupport && (bouncyRecyclerView = appsLibraryView.f16290k) != null) {
                        for (int i7 = 0; i7 < bouncyRecyclerView.getChildCount(); i7++) {
                            AppsLibraryItemFull appsLibraryItemFull = (AppsLibraryItemFull) bouncyRecyclerView.getChildAt(i7);
                            RuntimeShaderGlassView runtimeShaderGlassView = appsLibraryItemFull.f16264s;
                            if (runtimeShaderGlassView != null) {
                                Launcher launcher = appsLibraryItemFull.f16262q;
                                if (launcher.getWorkspace().f23394r0) {
                                    f7 = (-launcher.screenWidth) + f6;
                                    i6 = appsLibraryItemFull.f16266u;
                                } else {
                                    f7 = launcher.screenWidth + f6;
                                    i6 = appsLibraryItemFull.f16266u;
                                }
                                runtimeShaderGlassView.setScrollOffset((int) (f7 + i6));
                            }
                        }
                        if (appsLibraryView.f16298s != null) {
                            appsLibraryView.f16298s.setScrollOffset((int) ((appsLibraryView.f16289j.getWorkspace().f23394r0 ? -appsLibraryView.f16289j.screenWidth : appsLibraryView.f16289j.screenWidth) + f6 + (appsLibraryView.f16301v * 2)));
                        }
                        break;
                    }
                }
                break;
            default:
                ViewOnClickListenerC2791d viewOnClickListenerC2791d = (ViewOnClickListenerC2791d) this.f16286k;
                if (viewOnClickListenerC2791d.f21273j != null) {
                    RealTimeBlurView realTimeBlurView2 = viewOnClickListenerC2791d.f21279p;
                    float f9 = viewOnClickListenerC2791d.isRtl() ? viewOnClickListenerC2791d.f21273j.screenWidth + f6 : f6 - viewOnClickListenerC2791d.f21273j.screenWidth;
                    viewOnClickListenerC2791d.isRtl();
                    realTimeBlurView2.f16982D = f9;
                    realTimeBlurView2.invalidate();
                    viewOnClickListenerC2791d.post(new BlurAnimRunnable(this, f6, 2));
                }
                break;
        }
    }

    @Override // p034m.InterfaceC2375v
    /* JADX INFO: renamed from: o */
    public boolean mo7950o(MenuC2364k menuC2364k) {
        switch (this.f16285j) {
            case 6:
                Window.Callback callback = ((LayoutInflaterFactory2C2069v) this.f16286k).f18446n.getCallback();
                if (callback == null) {
                    return true;
                }
                callback.onMenuOpened(108, menuC2364k);
                return true;
            default:
                C2478k c2478k = (C2478k) this.f16286k;
                if (menuC2364k == c2478k.f20078l) {
                    return false;
                }
                c2478k.f20075H = ((SubMenuC2353C) menuC2364k).f19453J.f19554j;
                InterfaceC2375v interfaceC2375v = c2478k.f20080n;
                if (interfaceC2375v != null) {
                    return interfaceC2375v.mo7950o(menuC2364k);
                }
                return false;
        }
    }

    @Override // p085i1.InterfaceC2182s
    /* JADX INFO: renamed from: p */
    public InterfaceC2181r mo410p(C2187x c2187x) {
        switch (this.f16285j) {
            case 8:
                return new C2165b(0, (AssetManager) this.f16286k, this);
            case 9:
            default:
                return new C2162E(this);
            case 10:
                return new C2165b((Resources) this.f16286k, c2187x.m8885b(Uri.class, InputStream.class));
        }
    }

    @Override // p124s0.t0
    /* JADX INFO: renamed from: q */
    public View mo7951q(int i6) {
        return ((AbstractC2705T) this.f16286k).m9740u(i6);
    }

    @Override // p124s0.t0
    /* JADX INFO: renamed from: r */
    public int mo7952r() {
        return ((AbstractC2705T) this.f16286k).m9735H();
    }

    @Override // p124s0.t0
    /* JADX INFO: renamed from: s */
    public int mo7953s(View view) {
        C2706U c2706u = (C2706U) view.getLayoutParams();
        ((AbstractC2705T) this.f16286k).getClass();
        return AbstractC2705T.m9729y(view) + ((ViewGroup.MarginLayoutParams) c2706u).bottomMargin;
    }

    @Override // v5.InterfaceC2894f
    /* JADX INFO: renamed from: t */
    public void mo2106t(InterfaceC2891c interfaceC2891c, C2881M c2881m) {
        switch (this.f16285j) {
            case 14:
                Objects.toString(c2881m);
                C2087D c2087d = c2881m.f21542a;
                boolean zM8712c = c2087d.m8712c();
                C2536a c2536a = (C2536a) this.f16286k;
                if (!zM8712c) {
                    C2407e c2407e = c2536a.f20267a;
                    Throwable th = new Throwable(c2087d.f18515m);
                    c2407e.getClass();
                    th.getMessage();
                    c2407e.f19702c.restoreCurrentResponse(c2407e.f19700a, c2407e.f19701b);
                } else {
                    CurrentResponse currentResponse = (CurrentResponse) c2881m.f21543b;
                    C2407e c2407e2 = c2536a.f20267a;
                    c2407e2.getClass();
                    Objects.toString(currentResponse);
                    OpenWeather openWeather = c2407e2.f19702c;
                    String str = c2407e2.f19701b;
                    String str2 = c2407e2.f19700a;
                    if (currentResponse == null || currentResponse.getWeather() == null || currentResponse.getMain() == null || currentResponse.getSys() == null) {
                        openWeather.restoreCurrentResponse(str2, str);
                    } else {
                        String strM1090g = new C0460k(2).m1090g(currentResponse);
                        new Handler(Looper.getMainLooper()).post(new RunnableC0358n(c2407e2, str2, currentResponse, 14));
                        openWeather.write(openWeather.mContext, str, strM1090g);
                    }
                }
                break;
            case 23:
                ((C2895g) this.f16286k).complete(c2881m);
                break;
            default:
                AbstractC0965g.m2014f(interfaceC2891c, "call");
                ((C1248e) this.f16286k).mo1107i(c2881m);
                break;
        }
    }

    @Override // p069e3.InterfaceC1988p
    /* JADX INFO: renamed from: u */
    public Object mo834u() {
        switch (this.f16285j) {
            case 4:
                Type type = (Type) this.f16286k;
                if (!(type instanceof ParameterizedType)) {
                    throw new C1665f("Invalid EnumSet type: " + type.toString(), 5);
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new C1665f("Invalid EnumSet type: " + type.toString(), 5);
            default:
                Constructor constructor = (Constructor) this.f16286k;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e) {
                    AbstractC1690d abstractC1690d = AbstractC2132c.f18740a;
                    throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                } catch (InstantiationException e5) {
                    throw new RuntimeException("Failed to invoke constructor '" + AbstractC2132c.m8818b(constructor) + "' with no args", e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException("Failed to invoke constructor '" + AbstractC2132c.m8818b(constructor) + "' with no args", e6.getCause());
                }
        }
    }

    @Override // p055b2.InterfaceC1573h
    /* JADX INFO: renamed from: v */
    public void mo3506v(Object obj, Object obj2){
        switch (this.f16285j) {
            case 3:
                C2861f c2861f = (C2861f) obj2;
                C1969a c1969a = (C1969a) ((C1972d) obj).m3614t();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(c1969a.f12901l);
                int i6 = AbstractC2384a.f19604a;
                C1646m c1646m = (C1646m) this.f16286k;
                if (c1646m == null) {
                    parcelObtain.writeInt(0);
                } else {
                    parcelObtain.writeInt(1);
                    c1646m.writeToParcel(parcelObtain, 0);
                }
                try {
                    c1969a.f12900k.transact(1, parcelObtain, null, 1);
                    parcelObtain.recycle();
                    c2861f.m9994a(null);
                    return;
                } catch (Throwable th) {
                    parcelObtain.recycle();
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            default:
                C2532b c2532b = (C2532b) obj;
                C1953k c1953k = new C1953k(12, (C2861f) obj2);
                if (!c2532b.m3598a()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                C2650b c2650b = (C2650b) this.f16286k;
                BinderC2334f binderC2334f = new BinderC2334f();
                binderC2334f.attachInterface(binderC2334f, "com.google.android.gms.location.internal.ISettingsCallbacks");
                binderC2334f.f19381k = c1953k;
                C2531a c2531a = (C2531a) c2532b.m3614t();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(c2531a.f20259k);
                int i7 = AbstractC2533c.f20262a;
                parcelObtain2.writeInt(1);
                c2650b.writeToParcel(parcelObtain2, 0);
                parcelObtain2.writeStrongBinder(binderC2334f);
                parcelObtain2.writeString(null);
                c2531a.getClass();
                Parcel parcelObtain3 = Parcel.obtain();
                try {
                    try { c2531a.f20258j.transact(63, parcelObtain2, parcelObtain3, 0); } catch (RemoteException jadxEx) { throw com.luutinhit.launcher6.JadxSupport.sneaky(jadxEx); }
                    parcelObtain3.readException();
                    return;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain3.recycle();
                }
        }
    }

    @Override // com.luutinhit.launcher6.AppsLibraryProgressCallback
    /* JADX INFO: renamed from: w */
    public void mo7799w() {
        switch (this.f16285j) {
            case 0:
                AppsLibraryView appsLibraryView = (AppsLibraryView) this.f16286k;
                Launcher launcher = appsLibraryView.f16289j;
                if (launcher != null && launcher.isShaking()) {
                    appsLibraryView.f16289j.cancelShakingAnimation();
                    break;
                }
                break;
            default:
                ViewOnClickListenerC2791d viewOnClickListenerC2791d = (ViewOnClickListenerC2791d) this.f16286k;
                Launcher launcher2 = viewOnClickListenerC2791d.f21273j;
                if (launcher2 != null && launcher2.isShaking()) {
                    viewOnClickListenerC2791d.f21273j.cancelShakingAnimation();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: x */
    public void m7954x(Bundle bundle) {
        C3106x0 c3106x0 = (C3106x0) this.f16286k;
        c3106x0.getClass();
        c3106x0.f1090b.putBundle(AdMobAdapter.class.getName(), bundle);
        if (AdMobAdapter.class.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            c3106x0.f1092d.remove("B3EEABB8EE11C2BE770B684D95219ECB");
        }
    }

    /* JADX INFO: renamed from: y */
    public void m7955y(C2712a c2712a) {
        int i6 = c2712a.f20811a;
        RecyclerView recyclerView = (RecyclerView) this.f16286k;
        if (i6 == 1) {
            recyclerView.f5432w.mo3362Y(c2712a.f20812b, c2712a.f20814d);
            return;
        }
        if (i6 == 2) {
            recyclerView.f5432w.b0(c2712a.f20812b, c2712a.f20814d);
        } else if (i6 == 4) {
            recyclerView.f5432w.c0(c2712a.f20812b, c2712a.f20814d);
        } else {
            if (i6 != 8) {
                return;
            }
            recyclerView.f5432w.a0(c2712a.f20812b, c2712a.f20814d);
        }
    }

    /* JADX INFO: renamed from: z */
    public l0 m7956z(int i6) {
        RecyclerView recyclerView = (RecyclerView) this.f16286k;
        int iM1272k = recyclerView.f5424o.m1272k();
        l0 l0Var = null;
        for (int i7 = 0; i7 < iM1272k; i7++) {
            l0 l0VarM3387R = RecyclerView.m3387R(recyclerView.f5424o.m1271j(i7));
            if (l0VarM3387R != null && !l0VarM3387R.m9789w() && l0VarM3387R.f20919l == i6) {
                if (!((ArrayList) recyclerView.f5424o.f1651e).contains(l0VarM3387R.f20917j)) {
                    l0Var = l0VarM3387R;
                    break;
                }
                l0Var = l0VarM3387R;
            }
        }
        if (l0Var == null) {
            return null;
        }
        if (!((ArrayList) recyclerView.f5424o.f1651e).contains(l0Var.f20917j)) {
            return l0Var;
        }
        boolean z5 = RecyclerView.f22305J0;
        return null;
    }

    public MergedCallbacks(int i6) {
        this.f16285j = i6;
        switch (i6) {
            case 20:
                this.f16286k = new ArrayList();
                break;
            case 22:
                break;
            case 25:
                C3106x0 c3106x0 = new C3106x0();
                this.f16286k = c3106x0;
                c3106x0.f1092d.add("B3EEABB8EE11C2BE770B684D95219ECB");
                break;
            default:
                this.f16286k = new C2178o(2, 500L);
                break;
        }
    }

    /* JADX INFO: renamed from: E */
    public final void m7935E() {
    }
}
