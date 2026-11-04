package com.luutinhit.launcherios.fragment;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcherios.R;
import p089j0.AbstractC2229q;

/* JADX INFO: loaded from: classes.dex */
public class BlurConfigFragment extends AbstractC2229q {
    @Override // androidx.fragment.app.AbstractComponentCallbacksC1495n
    /* JADX INFO: renamed from: E */
    public final void mo3266E() {
        this.f5170M = true;
    }

    @Override // p089j0.AbstractC2229q
    /* JADX INFO: renamed from: U */
    public final void mo8347U() {
        m8914T(R.xml.blur_config);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC1495n
    /* JADX INFO: renamed from: q */
    public final void mo3287q() {
        RecyclerView recyclerView;
        this.f5170M = true;
        try {
            View view = this.f5172O;
            if (view == null || (recyclerView = (RecyclerView) view.findViewById(android.R.id.list)) == null) {
                return;
            }
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setFocusableInTouchMode(false);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
