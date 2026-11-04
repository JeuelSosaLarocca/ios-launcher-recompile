package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.util.DeleteCircleView;

/* JADX INFO: loaded from: classes.dex */
public class DeleteCircleView extends View {

    /* JADX INFO: renamed from: q */
    public static Paint f16934q;

    /* JADX INFO: renamed from: r */
    public static Paint f16935r;

    /* JADX INFO: renamed from: s */
    public static Paint f16936s;

    /* JADX INFO: renamed from: j */
    public int[] f16937j;

    /* JADX INFO: renamed from: k */
    public float[] f16938k;

    /* JADX INFO: renamed from: l */
    public float f16939l;

    /* JADX INFO: renamed from: m */
    public float f16940m;

    /* JADX INFO: renamed from: n */
    public float f16941n;

    /* JADX INFO: renamed from: o */
    public boolean f16942o;

    /* JADX INFO: renamed from: p */
    public int f16943p;

    public DeleteCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16937j = new int[]{0, -1, 0, -1, 0};
        this.f16938k = new float[]{0.0f, 0.125f, 0.5f, 0.625f, 1.0f};
        Launcher launcher = (Launcher) context;
        this.f16943p = launcher.mDeviceProfile.f16026z;
        setClipToOutline(false);
        setScaleX(0.0f);
        setScaleY(0.0f);
        if (f16934q != null) {
            this.f16942o = launcher.isUseLiquidGlass;
            return;
        }
        this.f16942o = launcher.isUseLiquidGlass;
        Paint paint = new Paint(1);
        f16934q = paint;
        paint.setStyle(Paint.Style.FILL);
        f16934q.setColor(this.f16942o ? -2134061876 : -288568116);
        Paint paint2 = new Paint(1);
        f16935r = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        f16935r.setStrokeCap(Paint.Cap.ROUND);
        f16935r.setColor(this.f16942o ? -285212673 : -301989888);
        Paint paint3 = new Paint(1);
        f16936s = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    /* JADX INFO: renamed from: c */
    public final void m8196c(int i6, boolean z5) {
        if (!z5) {
            setVisibility(i6);
            return;
        }
        if (getVisibility() != i6) {
            if (i6 == 0) {
                setEnabled(true);
                int i7 = 0;
                animate().withLayer().scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withStartAction(new Runnable() { // from class: B3.n

                    /* JADX INFO: renamed from: k */
                    public /* synthetic */ DeleteCircleView f210k;

                    {
                        this.f210k = DeleteCircleView.this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i7) {
                            case 0:
                                DeleteCircleView.super.setVisibility(0);
                                break;
                            default:
                                DeleteCircleView.super.setVisibility(8);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            } else if (i6 == 4 || i6 == 8) {
                int i8 = 1;
                animate().withLayer().scaleX(0.0f).scaleY(0.0f).setDuration(300L).setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f)).withEndAction(new Runnable() { // from class: B3.n

                    /* JADX INFO: renamed from: k */
                    public /* synthetic */ DeleteCircleView f210k;

                    {
                        this.f210k = DeleteCircleView.this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i8) {
                            case 0:
                                DeleteCircleView.super.setVisibility(0);
                                break;
                            default:
                                DeleteCircleView.super.setVisibility(8);
                                break;
                        }
                    }
                }).setStartDelay(20L).start();
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f16939l, this.f16940m, this.f16941n, f16934q);
        if (this.f16942o) {
            canvas.drawCircle(this.f16939l, this.f16940m, this.f16941n - (f16936s.getStrokeWidth() / 2.0f), f16936s);
        }
        float f6 = this.f16941n * 0.4f;
        float f7 = this.f16939l;
        float f8 = this.f16940m;
        canvas.drawLine(f7 - f6, f8, f7 + f6, f8, f16935r);
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        int i8 = this.f16943p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
        setMeasuredDimension(i8, i8);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        int i10 = (int) (((double) i6) * 0.9d);
        int i11 = (int) (((double) i7) * 0.9d);
        this.f16939l = i10 / 2.0f;
        this.f16940m = i11 / 2.0f;
        float fMin = Math.min(i10, i11) / 2.0f;
        this.f16941n = fMin;
        f16936s.setStrokeWidth(fMin / 10.0f);
        f16935r.setStrokeWidth(this.f16941n / 5.0f);
        f16936s.setShader(new SweepGradient(this.f16939l, this.f16940m, this.f16937j, this.f16938k));
    }
}
