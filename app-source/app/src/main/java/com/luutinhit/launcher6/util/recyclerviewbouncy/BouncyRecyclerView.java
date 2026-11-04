package com.luutinhit.launcher6.util.recyclerviewbouncy;

import D3.AbstractC0197e;
import D3.C0193a;
import D3.C0194b;
import D3.C0196d;
import D3.InterfaceC0198f;
import E3.C0205a;
import E3.InterfaceC0206b;
import G3.C0364t;
import O3.AbstractC0744e;
import R4.AbstractC0965g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.GlassSurfaceHolder;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LiquidGlassTextureView;
import com.luutinhit.launcher6.RuntimeShaderGlassView;
import com.luutinhit.launcher6.appslibrary.AppsLibraryItemFull;
import com.luutinhit.launcher6.appslibrary.AppsLibraryView;
import java.util.Objects;
import p023Z.C1274e;
import p023Z.C1275f;
import p124s0.AbstractC2697K;
import p124s0.AbstractC2705T;
import p124s0.C2737z;

/* JADX INFO: loaded from: classes.dex */
public final class BouncyRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: e1 */
    public static final /* synthetic */ int f23514e1 = 0;

    /* JADX INFO: renamed from: T0 */
    public C0205a f23515T0;

    /* JADX INFO: renamed from: U0 */
    public InterfaceC0206b f23516U0;

    /* JADX INFO: renamed from: V0 */
    public InterfaceC0198f f23517V0;

    /* JADX INFO: renamed from: W0 */
    public float f23518W0;

    /* JADX INFO: renamed from: X0 */
    public float f23519X0;

    /* JADX INFO: renamed from: Y0 */
    public Integer f23520Y0;

    /* JADX INFO: renamed from: Z0 */
    public float f23521Z0;

    /* JADX INFO: renamed from: a1 */
    public float f23522a1;

    /* JADX INFO: renamed from: b1 */
    public boolean f23523b1;

    /* JADX INFO: renamed from: c1 */
    public boolean f23524c1;

    /* JADX INFO: renamed from: d1 */
    public C1274e f23525d1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BouncyRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC0965g.m2013e(context, "context");
        this.f23518W0 = 0.5f;
        this.f23519X0 = 0.5f;
        this.f23520Y0 = 1;
        this.f23521Z0 = 1.0f;
        this.f23522a1 = 200.0f;
        C1274e c1274e = new C1274e(this, C1274e.f3636m);
        C1275f c1275f = new C1275f();
        c1275f.f3662i = 0.0f;
        c1275f.m2598a(this.f23521Z0);
        c1275f.m2599b(this.f23522a1);
        c1274e.f3652j = c1275f;
        c1274e.m2593a(new C0193a(this, c1274e, 2));
        this.f23525d1 = c1274e;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, AbstractC0744e.f2241e, 0, 0);
        setLongPressDragEnabled(typedArrayObtainStyledAttributes.getBoolean(0, false));
        setItemSwipeEnabled(typedArrayObtainStyledAttributes.getBoolean(1, false));
        this.f23518W0 = typedArrayObtainStyledAttributes.getFloat(4, 0.5f);
        this.f23519X0 = typedArrayObtainStyledAttributes.getFloat(3, 0.5f);
        int i6 = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (i6 == 0) {
            setDampingRatio(1.0f);
        } else if (i6 == 1) {
            setDampingRatio(0.75f);
        } else if (i6 == 2) {
            setDampingRatio(0.5f);
        } else if (i6 == 3) {
            setDampingRatio(0.2f);
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(5, 1);
        if (i7 == 0) {
            setStiffness(50.0f);
        } else if (i7 == 1) {
            setStiffness(200.0f);
        } else if (i7 == 2) {
            setStiffness(1500.0f);
        } else if (i7 == 3) {
            setStiffness(10000.0f);
        }
        typedArrayObtainStyledAttributes.recycle();
        m3420m(new C0194b(0, this));
        setEdgeEffectFactory(new C0196d(this, this));
    }

    public final void setupDirection(Integer num) {
        if (num != null && num.intValue() == 0) {
            C1274e c1274e = new C1274e(this, C1274e.f3635l);
            C1275f c1275f = new C1275f();
            c1275f.f3662i = 0.0f;
            c1275f.m2598a(this.f23521Z0);
            c1275f.m2599b(this.f23522a1);
            c1274e.f3652j = c1275f;
            c1274e.m2593a(new C0193a(this, c1274e, 0));
            this.f23525d1 = c1274e;
            return;
        }
        if (num != null && num.intValue() == 1) {
            C1274e c1274e2 = new C1274e(this, C1274e.f3636m);
            C1275f c1275f2 = new C1275f();
            c1275f2.f3662i = 0.0f;
            c1275f2.m2598a(this.f23521Z0);
            c1275f2.m2599b(this.f23522a1);
            c1274e2.f3652j = c1275f2;
            c1274e2.m2593a(new C0193a(this, c1274e2, 1));
            this.f23525d1 = c1274e2;
        }
    }

    public final float getDampingRatio() {
        return this.f23521Z0;
    }

    public final float getFlingAnimationSize() {
        return this.f23519X0;
    }

    public final boolean getItemSwipeEnabled() {
        return this.f23524c1;
    }

    public final boolean getLongPressDragEnabled() {
        return this.f23523b1;
    }

    public final InterfaceC0206b getOnOverPullListener() {
        return this.f23516U0;
    }

    public final InterfaceC0198f getOnOverScrollListener() {
        return this.f23517V0;
    }

    public final Integer getOrientation() {
        return this.f23520Y0;
    }

    public final float getOverscrollAnimationSize() {
        return this.f23518W0;
    }

    public final float getStiffness() {
        return this.f23522a1;
    }

    public final void setAdapter(AbstractC0197e abstractC0197e) {
        super.setAdapter((AbstractC2697K) abstractC0197e);
        if (abstractC0197e != null) {
            C0205a c0205a = new C0205a(abstractC0197e, this.f23523b1, this.f23524c1);
            this.f23515T0 = c0205a;
            new C2737z(c0205a).m9818i(this);
        }
    }

    public final void setDampingRatio(float f6) {
        this.f23521Z0 = f6;
        C1274e c1274e = this.f23525d1;
        C1275f c1275f = new C1275f();
        c1275f.f3662i = 0.0f;
        c1275f.m2598a(f6);
        c1275f.m2599b(this.f23522a1);
        c1274e.f3652j = c1275f;
    }

    public final void setFlingAnimationSize(float f6) {
        this.f23519X0 = f6;
    }

    public final void setItemSwipeEnabled(boolean z5) {
        this.f23524c1 = z5;
        if (getAdapter() instanceof AbstractC0197e) {
            C0205a c0205a = this.f23515T0;
            if (c0205a != null) {
                c0205a.f634f = z5;
            } else {
                AbstractC0965g.m2017i("callBack");
                throw null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(AbstractC2705T abstractC2705T) {
        super.setLayoutManager(abstractC2705T);
        if (abstractC2705T instanceof LinearLayoutManager) {
            setOrientation(Integer.valueOf(((LinearLayoutManager) abstractC2705T).f5385p));
            setupDirection(this.f23520Y0);
        }
    }

    public final void setLongPressDragEnabled(boolean z5) {
        this.f23523b1 = z5;
        if (getAdapter() instanceof AbstractC0197e) {
            C0205a c0205a = this.f23515T0;
            if (c0205a != null) {
                c0205a.f633e = z5;
            } else {
                AbstractC0965g.m2017i("callBack");
                throw null;
            }
        }
    }

    public final void setOnOverPullListener(InterfaceC0206b interfaceC0206b) {
        this.f23516U0 = interfaceC0206b;
    }

    public final void setOnOverScrollListener(InterfaceC0198f interfaceC0198f) {
        this.f23517V0 = interfaceC0198f;
    }

    public final void setOrientation(Integer num) {
        this.f23520Y0 = num;
        setupDirection(num);
    }

    public final void setOverscrollAnimationSize(float f6) {
        this.f23518W0 = f6;
    }

    public final void setStiffness(float f6) {
        this.f23522a1 = f6;
        C1274e c1274e = this.f23525d1;
        C1275f c1275f = new C1275f();
        c1275f.f3662i = 0.0f;
        c1275f.m2598a(this.f23521Z0);
        c1275f.m2599b(f6);
        c1274e.f3652j = c1275f;
    }

    public final void v0() {
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            AbstractC0965g.m2012d(childAt, "getChildAt(...)");
            if (RecyclerView.m3386P(childAt) != -1) {
                int left = (int) (childAt.getLeft() + translationX);
                int top = (int) (childAt.getTop() + translationY);
                InterfaceC0198f interfaceC0198f = this.f23517V0;
                if (interfaceC0198f != null) {
                    AppsLibraryView appsLibraryView = (AppsLibraryView) ((C0364t) interfaceC0198f).f1205k;
                    appsLibraryView.f16296q.invalidate();
                    Launcher launcher = appsLibraryView.f16289j;
                    if (launcher.isUseLiquidGlass && left >= 0 && top >= 0 && left <= launcher.screenWidth && top <= launcher.screenHeight && (childAt instanceof AppsLibraryItemFull)) {
                        AppsLibraryItemFull appsLibraryItemFull = (AppsLibraryItemFull) childAt;
                        float f6 = left;
                        float f7 = top;
                        LiquidGlassTextureView liquidGlassTextureView = appsLibraryItemFull.f16263r;
                        if (liquidGlassTextureView != null) {
                            GlassSurfaceHolder glassSurfaceHolder = (GlassSurfaceHolder) liquidGlassTextureView.f15932j.f15897v.get(liquidGlassTextureView);
                            if (glassSurfaceHolder != null) {
                                glassSurfaceHolder.f15864f = f6;
                                glassSurfaceHolder.f15865g = f7;
                                glassSurfaceHolder.f15866h = true;
                            }
                        } else {
                            RuntimeShaderGlassView runtimeShaderGlassView = appsLibraryItemFull.f16264s;
                            if (runtimeShaderGlassView != null && RuntimeShaderGlassView.hasPositionChanged(f6, f7, runtimeShaderGlassView.f16032o, runtimeShaderGlassView.f16031n, runtimeShaderGlassView.f16033p, runtimeShaderGlassView.f16034q)) {
                                Objects.toString(runtimeShaderGlassView.getParent());
                                int[] iArr = runtimeShaderGlassView.f16037t;
                                iArr[0] = (int) f6;
                                iArr[1] = (int) f7;
                                runtimeShaderGlassView.f16028k.setFloatUniform("u_GlViewPosition", f6, f7);
                                runtimeShaderGlassView.invalidate();
                            }
                        }
                    }
                }
            }
        }
    }
}
