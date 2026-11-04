package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicatorMarker extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public ImageView f15922j;

    public PageIndicatorMarker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    /* JADX INFO: renamed from: a */
    public final void inactivate(boolean z5) {
        if (!z5) {
            this.f15922j.animate().alpha(0.5f).scaleX(1.0f).scaleY(1.0f).setDuration(175L).start();
            return;
        }
        this.f15922j.animate().cancel();
        this.f15922j.setAlpha(0.5f);
        this.f15922j.setScaleX(1.0f);
        this.f15922j.setScaleY(1.0f);
    }

    public PageMarkerState getState() {
        return null;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f15922j = (ImageView) findViewById(R.id.marker);
    }

    public void setMarkerDrawables(int i6) {
        this.f15922j.setImageDrawable(getContext().getDrawable(i6));
    }
}
