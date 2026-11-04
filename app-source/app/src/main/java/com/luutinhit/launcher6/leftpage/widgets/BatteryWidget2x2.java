package com.luutinhit.launcher6.leftpage.widgets;

import J3.AbstractC0543b;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.C1416d;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcherios.R;
import p055b2.RunnableC1584s;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWidget2x2 extends AbstractC0543b {

    /* JADX INFO: renamed from: A */
    public boolean f16675A;

    /* JADX INFO: renamed from: n */
    public Context f16676n;

    /* JADX INFO: renamed from: o */
    public Handler f16677o;

    /* JADX INFO: renamed from: p */
    public RunnableC1584s f16678p;

    /* JADX INFO: renamed from: q */
    public ImageView f16679q;

    /* JADX INFO: renamed from: r */
    public TextView f16680r;

    /* JADX INFO: renamed from: s */
    public Paint f16681s;

    /* JADX INFO: renamed from: t */
    public Paint f16682t;

    /* JADX INFO: renamed from: u */
    public RectF f16683u;

    /* JADX INFO: renamed from: v */
    public float f16684v;

    /* JADX INFO: renamed from: w */
    public int f16685w;

    /* JADX INFO: renamed from: x */
    public Drawable f16686x;

    /* JADX INFO: renamed from: y */
    public int f16687y;

    /* JADX INFO: renamed from: z */
    public boolean f16688z;

    public BatteryWidget2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16677o = new Handler();
        this.f16678p = new RunnableC1584s(18, this);
        this.f16683u = new RectF();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2239c);
            this.f16675A = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f16676n = context;
        this.f16688z = m1295D();
        this.f16687y = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.68d);
        LayoutInflater.from(context).inflate(R.layout.battery_widget_2x2, (ViewGroup) this, true);
        setClipToOutline(true);
        Paint paint = new Paint(1);
        this.f16681s = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f16681s.setStrokeWidth(5.0f);
        Paint paint2 = this.f16681s;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint2.setStrokeCap(cap);
        this.f16681s.setColor(-16711936);
        Paint paint3 = new Paint(1);
        this.f16682t = paint3;
        paint3.setStyle(style);
        this.f16682t.setStrokeWidth(6.0f);
        this.f16682t.setStrokeCap(cap);
        this.f16682t.setColor(-2130706433);
        this.f16685w = this.f16676n.getResources().getDimensionPixelSize(R.dimen.battery_widget_progress_size);
        this.f16684v = this.f16676n.getResources().getDimensionPixelSize(R.dimen.battery_widget_progress_stroke) * 1.1f;
        this.f16686x = this.f16676n.getDrawable(R.drawable.ic_phone);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        Handler handler = this.f16677o;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.f16678p, 2000L);
        if (this.f16688z != m1295D()) {
            this.f16688z = m1295D();
            m8141G();
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m8141G() {
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.battery_widget_content);
        C1416d c1416d = (C1416d) linearLayoutRound.getLayoutParams();
        if (this.f16675A) {
            int dimensionPixelSize = this.f16676n.getResources().getDimensionPixelSize(R.dimen.widget_margin_top_bottom);
            int dimensionPixelSize2 = this.f16676n.getResources().getDimensionPixelSize(R.dimen.widget_elevation_shadow);
            int dimensionPixelSize3 = this.f16676n.getResources().getDimensionPixelSize(R.dimen.widget_margin_start_end);
            linearLayoutRound.setElevation(dimensionPixelSize2);
            if (Utilities.isRtl(getResources())) {
                c1416d.setMargins(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
            } else {
                c1416d.setMargins(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize2);
            }
        } else {
            int i6 = this.f16687y;
            c1416d.setMargins(i6, i6, i6, i6);
        }
        linearLayoutRound.setBackgroundResource(R.drawable.widget_shadow_rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f16676n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f16676n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
        Handler handler = this.f16677o;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.f16678p, 2000L);
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f16679q = (ImageView) findViewById(R.id.widget_battery_progress);
        this.f16680r = (TextView) findViewById(R.id.widget_battery_text);
        m8141G();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i6);
    }

    @Override // J3.AbstractC0543b
    public void setTextAndBackgroundColor(ViewGroup viewGroup) {
        super.setTextAndBackgroundColor(viewGroup);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
    }
}
