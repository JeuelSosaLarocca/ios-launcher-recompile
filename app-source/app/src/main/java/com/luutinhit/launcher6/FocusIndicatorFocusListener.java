package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.o0 */
/* JADX INFO: loaded from: classes.dex */
public final class FocusIndicatorFocusListener implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ FocusIndicatorView f16780j;

    public FocusIndicatorFocusListener(FocusIndicatorView focusIndicatorView) {
        this.f16780j = focusIndicatorView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z5) {
        if (z5) {
            int i6 = FocusIndicatorView.f15589r;
            FocusIndicatorView focusIndicatorView = this.f16780j;
            focusIndicatorView.endCurrentAnimation();
            focusIndicatorView.setAlpha(0.0f);
        }
    }
}
