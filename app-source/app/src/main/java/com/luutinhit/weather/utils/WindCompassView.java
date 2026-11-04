package com.luutinhit.weather.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class WindCompassView extends View {

    /* JADX INFO: renamed from: A */
    public Paint f17712A;

    /* JADX INFO: renamed from: B */
    public double f17713B;

    /* JADX INFO: renamed from: C */
    public int f17714C;

    /* JADX INFO: renamed from: j */
    public Canvas f17715j;

    /* JADX INFO: renamed from: k */
    public int f17716k;

    /* JADX INFO: renamed from: l */
    public int f17717l;

    /* JADX INFO: renamed from: m */
    public int f17718m;

    /* JADX INFO: renamed from: n */
    public int f17719n;

    /* JADX INFO: renamed from: o */
    public float f17720o;

    /* JADX INFO: renamed from: p */
    public Paint f17721p;

    /* JADX INFO: renamed from: q */
    public Paint f17722q;

    /* JADX INFO: renamed from: r */
    public Paint f17723r;

    /* JADX INFO: renamed from: s */
    public Paint f17724s;

    /* JADX INFO: renamed from: t */
    public Path f17725t;

    /* JADX INFO: renamed from: u */
    public Paint f17726u;

    /* JADX INFO: renamed from: v */
    public Paint f17727v;

    /* JADX INFO: renamed from: w */
    public Rect f17728w;

    /* JADX INFO: renamed from: x */
    public Rect f17729x;

    /* JADX INFO: renamed from: y */
    public Rect f17730y;

    /* JADX INFO: renamed from: z */
    public Paint f17731z;

    public WindCompassView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f17713B = 0.0d;
        this.f17714C = 0;
        Paint paint = new Paint();
        this.f17721p = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
        paint.setColor(context.getResources().getColor(R.color.white));
        Paint paint2 = new Paint();
        this.f17722q = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(context.getResources().getColor(R.color.lightGray));
        Paint paint3 = new Paint();
        this.f17723r = paint3;
        paint3.setStyle(style);
        paint3.setAntiAlias(true);
        paint3.setColor(context.getResources().getColor(R.color.gray));
        Paint paint4 = new Paint();
        this.f17724s = paint4;
        paint4.setStyle(style);
        paint4.setAntiAlias(true);
        paint4.setColor(context.getResources().getColor(R.color.red));
        this.f17725t = new Path();
        Paint paint5 = new Paint();
        this.f17726u = paint5;
        paint5.setStyle(style);
        paint5.setAntiAlias(true);
        paint5.setTextSize(40.0f);
        paint5.setColor(context.getResources().getColor(R.color.red));
        Paint paint6 = new Paint();
        this.f17727v = paint6;
        paint6.setStyle(style);
        paint6.setAntiAlias(true);
        paint6.setTextSize(40.0f);
        paint6.setColor(context.getResources().getColor(R.color.white));
        this.f17728w = new Rect();
        this.f17729x = new Rect();
        this.f17730y = new Rect();
        Paint paint7 = new Paint();
        this.f17731z = paint7;
        paint7.setStyle(style);
        paint7.setAntiAlias(true);
        paint7.setColor(context.getResources().getColor(R.color.white));
        Paint paint8 = new Paint();
        this.f17712A = paint8;
        paint8.setStyle(style);
        paint8.setAntiAlias(true);
        paint8.setColor(context.getResources().getColor(R.color.white));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f6;
        super.onDraw(canvas);
        this.f17715j = canvas;
        canvas.save();
        int i6 = this.f17719n;
        int i7 = i6 / 8;
        this.f17715j.rotate(this.f17714C, this.f17717l, i6);
        Path path = this.f17725t;
        path.moveTo(this.f17717l, 0.0f);
        float f7 = 2.0f;
        float fSqrt = ((float) ((((double) i7) / Math.sqrt(3.0d)) * 2.0d)) / 2.0f;
        float f8 = i7;
        path.lineTo(this.f17717l - fSqrt, f8);
        path.lineTo(this.f17717l + fSqrt, f8);
        path.close();
        this.f17715j.drawPath(path, this.f17724s);
        this.f17715j.rotate(-this.f17714C, this.f17717l, this.f17719n);
        Paint paint = this.f17726u;
        paint.setTextSize(this.f17719n / 5.0f);
        Paint paint2 = this.f17727v;
        paint2.setTextSize(this.f17719n / 5.0f);
        Rect rect = this.f17728w;
        paint.getTextBounds("N", 0, 1, rect);
        int iWidth = rect.width();
        int iHeight = rect.height();
        paint.getTextBounds("W", 0, 1, rect);
        rect.width();
        int iHeight2 = rect.height();
        float f9 = this.f17720o / 2.0f;
        int i8 = 0;
        while (i8 < 180) {
            if (i8 == 0 || i8 == 45 || i8 == 90 || i8 == 135) {
                f6 = 2.0f;
                this.f17715j.drawLine(getWidth() / 2.0f, 0.0f, getWidth() / 2.0f, this.f17720o, this.f17721p);
            } else if (i8 % 15 == 0) {
                f6 = 2.0f;
                this.f17715j.drawLine(getWidth() / f7, 0.0f, getWidth() / f7, this.f17720o, this.f17722q);
            } else {
                f6 = 2.0f;
                this.f17715j.drawLine(getWidth() / 2.0f, 0.0f, getWidth() / 2.0f, this.f17720o, this.f17723r);
            }
            if (i8 == 0) {
                this.f17715j.drawText("N", this.f17717l - (iWidth / f6), (this.f17718m - this.f17719n) + f9 + iHeight + this.f17720o, paint);
            } else if (i8 == 45) {
                this.f17715j.rotate(-90.0f, this.f17717l, this.f17719n);
                this.f17715j.drawText("E", (((this.f17717l + this.f17719n) - iWidth) - this.f17720o) - f9, (iHeight / f6) + this.f17718m, paint2);
                this.f17715j.rotate(90.0f, this.f17717l, this.f17719n);
            } else if (i8 == 90) {
                this.f17715j.rotate(-180.0f, this.f17717l, this.f17719n);
                this.f17715j.drawText("S", this.f17717l - (iWidth / f6), ((this.f17718m + this.f17719n) - f9) - this.f17720o, paint2);
                this.f17715j.rotate(180.0f, this.f17717l, this.f17719n);
            } else if (i8 == 135) {
                this.f17715j.rotate(-270.0f, this.f17717l, this.f17719n);
                this.f17715j.drawText("W", (this.f17717l - this.f17719n) + this.f17720o + f9, (iHeight2 / f6) + this.f17718m, paint2);
                this.f17715j.rotate(270.0f, this.f17717l, this.f17719n);
            }
            this.f17715j.rotate(2.0f, this.f17717l, this.f17719n);
            i8++;
            f7 = 2.0f;
        }
        this.f17715j.restore();
        String strValueOf = String.valueOf((int) this.f17713B);
        Paint paint3 = this.f17731z;
        paint3.setTextSize(this.f17719n / 3.0f);
        int length = strValueOf.length();
        Rect rect2 = this.f17729x;
        paint3.getTextBounds(strValueOf, 0, length, rect2);
        Paint paint4 = this.f17712A;
        paint4.setTextSize(this.f17719n / 5.0f);
        Rect rect3 = this.f17730y;
        paint4.getTextBounds("km/h", 0, 4, rect3);
        int iWidth2 = rect2.width();
        int iHeight3 = rect2.height();
        int iWidth3 = rect3.width();
        int iHeight4 = rect3.height();
        Canvas canvas2 = this.f17715j;
        float f10 = this.f17717l - (iWidth2 / 2.0f);
        float f11 = (this.f17718m + iHeight3) - iHeight4;
        float f12 = iHeight3 / 3.0f;
        canvas2.drawText(strValueOf, f10, f11 - f12, paint3);
        this.f17715j.drawText("km/h", this.f17717l - (iWidth3 / 2.0f), this.f17718m + iHeight4 + f12, paint4);
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        super.onMeasure(i6, i7);
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        this.f17716k = Math.min(size, size2);
        if (mode == 0) {
            this.f17716k = size2;
        } else if (mode2 == 0) {
            this.f17716k = size;
        }
        this.f17717l = size / 2;
        int i8 = this.f17716k;
        this.f17718m = i8 / 2;
        int i9 = i8 / 2;
        this.f17719n = i9;
        this.f17720o = i9 / 9.0f;
    }
}
