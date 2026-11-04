package com.luutinhit.launcher6;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.luutinhit.launcher6.S2 */
/* JADX INFO: loaded from: classes.dex */
public final class PagedViewLayoutTransitionListener implements LayoutTransition.TransitionListener {

    /* JADX INFO: renamed from: a */
    public /* synthetic */ PagedView f15946a;

    public PagedViewLayoutTransitionListener(PagedView pagedView) {
        this.f15946a = pagedView;
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i6) {
        if (layoutTransition.isRunning()) {
            return;
        }
        layoutTransition.removeTransitionListener(this);
        PagedView pagedView = this.f15946a;
        int childCount = pagedView.getChildCount();
        if (childCount > 0) {
            pagedView.f16086v = pagedView.getScrollForPage(pagedView.f23394r0 ? 0 : childCount - 1);
        } else {
            pagedView.f16086v = 0;
        }
    }

    @Override // android.animation.LayoutTransition.TransitionListener
    public final void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i6) {
    }
}
