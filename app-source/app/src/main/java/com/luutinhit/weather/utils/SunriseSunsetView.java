package com.luutinhit.weather.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SunriseSunsetView extends View {

    /* JADX INFO: renamed from: j */
    public Paint f17705j;

    /* JADX INFO: renamed from: k */
    public Paint f17706k;

    /* JADX INFO: renamed from: l */
    public Paint f17707l;

    /* JADX INFO: renamed from: m */
    public Paint f17708m;

    /* JADX INFO: renamed from: n */
    public float f17709n;

    /* JADX INFO: renamed from: o */
    public float f17710o;

    /* JADX INFO: renamed from: p */
    public float f17711p;

    public SunriseSunsetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.f17705j = paint;
        Paint paint2 = new Paint(1);
        this.f17706k = paint2;
        Paint paint3 = new Paint(1);
        this.f17707l = paint3;
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        paint2.setStyle(style);
        paint2.setColor(-1);
        paint2.setStrokeWidth(2.0f);
        paint3.setColor(-2130706433);
        paint3.setStrokeWidth(2.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f6;
        Paint paint = this.f17707l;
        super.onDraw(canvas);
        float f7 = this.f17710o;
        canvas.drawLine(0.0f, f7 / 2.0f, this.f17709n, f7 / 2.0f, this.f17706k);
        int i6 = 0;
        while (true) {
            float f8 = i6;
            f6 = this.f17709n;
            if (f8 >= f6) {
                break;
            }
            float f9 = this.f17710o;
            float fSin = ((f9 / 3.6f) * ((float) Math.sin(((f8 - (f6 / 1.32f)) / f6) * 6.2f))) + (f9 / 2.0f);
            int i7 = i6 + 3;
            float f10 = i7;
            float f11 = this.f17710o;
            float f12 = this.f17709n;
            float fSin2 = ((f11 / 3.6f) * ((float) Math.sin(((f10 - (f12 / 1.32f)) / f12) * 6.2f))) + (f11 / 2.0f);
            float f13 = this.f17710o;
            float f14 = f13 / 2.0f;
            Paint paint2 = this.f17705j;
            if (fSin >= f14 || fSin2 >= f13 / 2.0f) {
                paint2.setColor(Integer.MIN_VALUE);
            } else {
                paint2.setColor(-2130706433);
            }
            canvas.drawLine(f8, fSin, f10, fSin2, paint2);
            i6 = i7;
        }
        float f15 = ((this.f17711p * f6) / 2.0f) + (f6 / 4.0f);
        float f16 = this.f17710o;
        float fSin3 = ((f16 / 3.6f) * ((float) Math.sin(((f15 - (f6 / 1.32f)) / f6) * 6.2f))) + (f16 / 2.0f);
        try {
            float f17 = this.f17711p;
            if (f17 < 0.0f || f17 > 1.0f) {
                canvas.drawCircle(f15, fSin3, this.f17710o / 11.0f, paint);
                return;
            }
            if (this.f17708m == null) {
                Paint paint3 = new Paint(1);
                this.f17708m = paint3;
                paint3.setColor(-1);
                this.f17708m.setShadowLayer(this.f17710o / 11.0f, 0.0f, 0.0f, -1);
            }
            canvas.drawCircle(f15, fSin3, this.f17710o / 11.0f, this.f17708m);
        } catch (Throwable unused) {
            canvas.drawCircle(f15, fSin3, this.f17710o / 11.0f, paint);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        this.f17709n = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.f17710o = measuredHeight;
        this.f17705j.setStrokeWidth(measuredHeight / 18.0f);
        super.onMeasure(i6, i7);
    }

    public void setSunriseSunsetTime(float f6) {
        this.f17711p = f6;
        this.f17707l.setStyle((f6 < 0.0f || f6 > 1.0f) ? Paint.Style.STROKE : Paint.Style.FILL_AND_STROKE);
        invalidate();
    }
}
