package com.luutinhit.launcher6.leftpage.widgets;

import J3.AbstractC0544c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C1416d;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.widget.view.TimeView;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class ClockWidget extends AbstractC0544c {

    /* JADX INFO: renamed from: j */
    public Context f16689j;

    /* JADX INFO: renamed from: k */
    public View f16690k;

    /* JADX INFO: renamed from: l */
    public TimeView f16691l;

    public ClockWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16689j = context;
        int i6 = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.68d);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.clock_widget, (ViewGroup) this, true);
        this.f16690k = viewInflate;
        this.f16691l = (TimeView) viewInflate.findViewById(R.id.time_view);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.clock_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        ((C1416d) this.f16691l.getLayoutParams()).setMargins(i6, i6, i6, i6);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        this.f16691l.invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f16689j).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f16689j).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
    }

    @Override // android.view.View
    public void setTranslationX(float f6) {
    }
}
