package com.luutinhit.launcher6.leftpage.widgets;

import B3.C0069l;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class ClockWidget_2x2 extends AppCompatImageView {

    /* JADX INFO: renamed from: m */
    public Context f16692m;

    /* JADX INFO: renamed from: n */
    public int f16693n;

    /* JADX INFO: renamed from: o */
    public int f16694o;

    /* JADX INFO: renamed from: p */
    public C0069l f16695p;

    public ClockWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        new Rect();
        new Path();
        new RectF();
        this.f16693n = -1;
        this.f16694o = -1;
        this.f16692m = context;
        getResources().getDimensionPixelSize(R.dimen.widget_round_corner);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0069l c0069l = new C0069l(this.f16692m, this.f16693n, this.f16694o);
        this.f16695p = c0069l;
        setBackground(c0069l);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        C0069l c0069l = this.f16695p;
        if (c0069l != null) {
            Context context = this.f16692m;
            if (context instanceof Launcher) {
                ((Launcher) context).removeOnTinyDBChangeListener(c0069l);
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        this.f16693n = getWidth();
        this.f16694o = getHeight();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i6);
    }
}
