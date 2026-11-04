package com.luutinhit.launcher6.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class BackCircleView extends View {

    /* JADX INFO: renamed from: r */
    public static final int[] f16900r = {-16777216, 0, -16777216, 0, -16777216};

    /* JADX INFO: renamed from: s */
    public static final float[] f16901s = {0.0f, 0.125f, 0.5f, 0.625f, 1.0f};

    /* JADX INFO: renamed from: j */
    public Paint f16902j;

    /* JADX INFO: renamed from: k */
    public Paint f16903k;

    /* JADX INFO: renamed from: l */
    public Paint f16904l;

    /* JADX INFO: renamed from: m */
    public float f16905m;

    /* JADX INFO: renamed from: n */
    public float f16906n;

    /* JADX INFO: renamed from: o */
    public float f16907o;

    /* JADX INFO: renamed from: p */
    public float f16908p;

    /* JADX INFO: renamed from: q */
    public Path f16909q;

    public BackCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.f16902j = paint;
        Paint paint2 = new Paint(1);
        this.f16903k = paint2;
        Paint paint3 = new Paint(1);
        this.f16904l = paint3;
        this.f16909q = new Path();
        setClipToOutline(false);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-2134061876);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setColor(-16777216);
        paint3.setStyle(style);
        paint3.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f16905m, this.f16906n, this.f16907o, this.f16902j);
        canvas.drawCircle(this.f16905m, this.f16906n, this.f16908p, this.f16904l);
        canvas.drawPath(this.f16909q, this.f16903k);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f16905m = i6 / 2.0f;
        this.f16906n = i7 / 2.0f;
        this.f16907o = (Math.min(i6, i7) / 2.0f) * 0.9f;
        Paint paint = this.f16904l;
        float strokeWidth = paint.getStrokeWidth();
        float f6 = this.f16907o;
        this.f16908p = f6 - (strokeWidth / 2.0f);
        this.f16903k.setStrokeWidth(f6 / 9.0f);
        paint.setShader(new SweepGradient(this.f16905m, this.f16906n, f16900r, f16901s));
        Path path = this.f16909q;
        path.reset();
        float f7 = this.f16907o;
        float f8 = this.f16905m;
        float f9 = (0.38f * f7) / 2.0f;
        float f10 = f8 + f9;
        float f11 = f8 - f9;
        float f12 = this.f16906n;
        float f13 = (f7 * 0.8f) / 2.0f;
        path.moveTo(f10, f12 - f13);
        path.lineTo(f11, this.f16906n);
        path.lineTo(f10, f12 + f13);
    }
}
