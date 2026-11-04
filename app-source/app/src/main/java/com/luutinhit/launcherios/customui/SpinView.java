package com.luutinhit.launcherios.customui;

import C2.RunnableC0147g;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class SpinView extends View {

    /* JADX INFO: renamed from: C */
    public static final /* synthetic */ int f17594C = 0;

    /* JADX INFO: renamed from: A */
    public Handler f17595A;

    /* JADX INFO: renamed from: B */
    public RectF f17596B;

    /* JADX INFO: renamed from: j */
    public int f17597j;

    /* JADX INFO: renamed from: k */
    public float f17598k;

    /* JADX INFO: renamed from: l */
    public float f17599l;

    /* JADX INFO: renamed from: m */
    public float f17600m;

    /* JADX INFO: renamed from: n */
    public float f17601n;

    /* JADX INFO: renamed from: o */
    public float f17602o;

    /* JADX INFO: renamed from: p */
    public int f17603p;

    /* JADX INFO: renamed from: q */
    public int f17604q;

    /* JADX INFO: renamed from: r */
    public int f17605r;

    /* JADX INFO: renamed from: s */
    public int f17606s;

    /* JADX INFO: renamed from: t */
    public int f17607t;

    /* JADX INFO: renamed from: u */
    public float f17608u;

    /* JADX INFO: renamed from: v */
    public float f17609v;

    /* JADX INFO: renamed from: w */
    public Paint f17610w;

    /* JADX INFO: renamed from: x */
    public Paint f17611x;

    /* JADX INFO: renamed from: y */
    public int f17612y;

    /* JADX INFO: renamed from: z */
    public HandlerThread f17613z;

    public SpinView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC0744e.f2230A, 0, 0);
        this.f17597j = typedArrayObtainStyledAttributes.getInt(5, 12);
        this.f17598k = typedArrayObtainStyledAttributes.getDimension(4, TypedValue.applyDimension(1, 12.0f, displayMetrics));
        this.f17599l = typedArrayObtainStyledAttributes.getDimension(12, TypedValue.applyDimension(1, 4.0f, displayMetrics));
        this.f17600m = typedArrayObtainStyledAttributes.getDimension(7, TypedValue.applyDimension(1, 10.0f, displayMetrics));
        this.f17601n = typedArrayObtainStyledAttributes.getFloat(9, 1.0f);
        this.f17602o = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.f17603p = typedArrayObtainStyledAttributes.getColor(0, -1);
        this.f17604q = typedArrayObtainStyledAttributes.getColor(3, 0);
        this.f17605r = (int) (typedArrayObtainStyledAttributes.getFloat(6, 0.25f) * 255.0f);
        this.f17606s = typedArrayObtainStyledAttributes.getInt(8, 0);
        this.f17607t = typedArrayObtainStyledAttributes.getInt(2, 1);
        this.f17608u = typedArrayObtainStyledAttributes.getFloat(10, 1.0f);
        this.f17609v = typedArrayObtainStyledAttributes.getInt(11, 60) / 100.0f;
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f17610w = paint;
        paint.setColor(this.f17603p);
        Paint paint2 = new Paint(1);
        this.f17611x = paint2;
        paint2.setColor(this.f17604q);
        HandlerThread handlerThread = new HandlerThread("SpinView");
        this.f17613z = handlerThread;
        handlerThread.start();
        this.f17595A = new Handler(this.f17613z.getLooper());
        float f6 = this.f17600m;
        float f7 = this.f17601n;
        float f8 = this.f17599l;
        this.f17596B = new RectF(f6 * f7, ((-f8) / 2.0f) * f7, (f6 + this.f17598k) * f7, (f8 / 2.0f) * f7);
    }

    public int getColor() {
        return this.f17603p;
    }

    public float getCorners() {
        return this.f17602o;
    }

    public int getDirection() {
        return this.f17607t;
    }

    public int getFadeColor() {
        return this.f17604q;
    }

    public float getLength() {
        return this.f17598k;
    }

    public float getLineWidth() {
        return this.f17599l;
    }

    public int getLines() {
        return this.f17597j;
    }

    public int getOpacity() {
        return this.f17605r;
    }

    public float getRadius() {
        return this.f17600m;
    }

    public int getRotate() {
        return this.f17606s;
    }

    public float getScale() {
        return this.f17601n;
    }

    public float getSpeed() {
        return this.f17608u;
    }

    public float getTrail() {
        return this.f17609v;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f17595A.post(new RunnableC0147g(18, this));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i6;
        super.onDraw(canvas);
        int i7 = 0;
        while (i7 < this.f17597j) {
            canvas.save();
            canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
            canvas.rotate((float) Math.floor(((360.0f / this.f17597j) * i7) + this.f17606s));
            if (Color.alpha(this.f17604q) > 0) {
                RectF rectF = this.f17596B;
                float f6 = this.f17602o;
                float f7 = this.f17599l;
                float f8 = this.f17601n;
                canvas.drawRoundRect(rectF, f6 * f7 * f8, f6 * f7 * f8, this.f17611x);
            }
            Paint paint = this.f17610w;
            float f9 = ((this.f17612y / 50) * this.f17608u) % 1.0f;
            i7++;
            float f10 = i7 / this.f17597j;
            float f11 = this.f17607t;
            float f12 = f9 - (f10 * f11);
            if (f12 < 0.0f || f12 > 1.0f) {
                f12 += f11;
            }
            float f13 = 1.0f - (f12 / this.f17609v);
            if (f13 < 0.0f) {
                i6 = this.f17605r;
            } else {
                int i8 = this.f17605r;
                i6 = i8 + ((int) ((255 - i8) * f13));
            }
            paint.setAlpha(i6);
            RectF rectF2 = this.f17596B;
            float f14 = this.f17602o;
            float f15 = this.f17599l;
            float f16 = this.f17601n;
            canvas.drawRoundRect(rectF2, f14 * f15 * f16, f14 * f15 * f16, this.f17610w);
            canvas.restore();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec((int) ((this.f17600m + this.f17598k) * 2.0f * this.f17601n), 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((this.f17600m + this.f17598k) * 2.0f * this.f17601n), 1073741824));
    }

    public void setColor(int i6) {
        this.f17603p = i6;
    }

    public void setCorners(float f6) {
        this.f17602o = f6;
    }

    public void setDirection(int i6) {
        this.f17607t = i6;
    }

    public void setFadeColor(int i6) {
        this.f17604q = i6;
    }

    public void setLength(float f6) {
        this.f17598k = f6;
    }

    public void setLineWidth(float f6) {
        this.f17599l = f6;
    }

    public void setLines(int i6) {
        this.f17597j = i6;
    }

    public void setOpacity(int i6) {
        this.f17605r = i6;
    }

    public void setRadius(float f6) {
        this.f17600m = f6;
    }

    public void setRotate(int i6) {
        this.f17606s = i6;
    }

    public void setScale(float f6) {
        this.f17601n = f6;
    }

    public void setSpeed(float f6) {
        this.f17608u = f6;
    }

    public void setTrail(float f6) {
        this.f17609v = f6;
    }
}
