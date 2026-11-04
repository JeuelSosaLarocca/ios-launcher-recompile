package com.luutinhit.launcher6.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p003D.AbstractC0159c;
import p014P.AbstractC0758N;
import p014P.C0763T;

/* JADX INFO: loaded from: classes.dex */
public class OverScrollBounceBehavior extends AbstractC0159c {

    /* JADX INFO: renamed from: a */
    public int f16944a;

    public OverScrollBounceBehavior() {
    }

    @Override // p003D.AbstractC0159c
    /* JADX INFO: renamed from: k */
    public final void mo423k(int i6, View view) {
        if (i6 == 0) {
            return;
        }
        this.f16944a -= i6;
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            viewGroup.getChildAt(i7).setTranslationY(this.f16944a);
        }
    }

    @Override // p003D.AbstractC0159c
    /* JADX INFO: renamed from: p */
    public final boolean mo428p(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i6, int i7) {
        this.f16944a = 0;
        return true;
    }

    @Override // p003D.AbstractC0159c
    /* JADX INFO: renamed from: q */
    public final void mo429q(CoordinatorLayout coordinatorLayout, View view, View view2, int i6) {
        ViewGroup viewGroup = (ViewGroup) view2;
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            C0763T c0763tM1652a = AbstractC0758N.m1652a(viewGroup.getChildAt(i7));
            c0763tM1652a.m1676e(0.0f);
            View view3 = (View) c0763tM1652a.f2287a.get();
            if (view3 != null) {
                view3.animate().start();
            }
        }
    }

    public OverScrollBounceBehavior(Context context, AttributeSet attributeSet) {
    }
}
