package com.luutinhit.launcher6.appslibrary;

import J3.C0546e;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import p003D.C0157a;

/* JADX INFO: loaded from: classes.dex */
public class IndexBarView extends View {

    /* JADX INFO: renamed from: v */
    public static final String[] f16267v = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    /* JADX INFO: renamed from: j */
    public String[] f16268j;

    /* JADX INFO: renamed from: k */
    public Paint f16269k;

    /* JADX INFO: renamed from: l */
    public Paint.FontMetrics f16270l;

    /* JADX INFO: renamed from: m */
    public float f16271m;

    /* JADX INFO: renamed from: n */
    public float f16272n;

    /* JADX INFO: renamed from: o */
    public float f16273o;

    /* JADX INFO: renamed from: p */
    public float f16274p;

    /* JADX INFO: renamed from: q */
    public float f16275q;

    /* JADX INFO: renamed from: r */
    public float f16276r;

    /* JADX INFO: renamed from: s */
    public float f16277s;

    /* JADX INFO: renamed from: t */
    public int f16278t;

    /* JADX INFO: renamed from: u */
    public IndexBarListener f16279u;

    public IndexBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16268j = f16267v;
        this.f16278t = -1;
        Paint paint = new Paint(1);
        this.f16269k = paint;
        paint.setColor(-1);
        this.f16269k.setTextSize(TypedValue.applyDimension(2, 11.0f, context.getResources().getDisplayMetrics()));
        this.f16269k.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = this.f16269k.getFontMetrics();
        this.f16270l = fontMetrics;
        this.f16271m = fontMetrics.descent - fontMetrics.ascent;
        this.f16272n = TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
        this.f16277s = this.f16269k.measureText("W");
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String[] strArr = this.f16268j;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (int i6 = 0; i6 < this.f16268j.length; i6++) {
            float f6 = ((i6 * this.f16274p) + this.f16273o) - this.f16270l.ascent;
            if (i6 == this.f16278t) {
                this.f16269k.setColor(-8947849);
                this.f16269k.setFakeBoldText(true);
            } else {
                this.f16269k.setColor(-1);
                this.f16269k.setFakeBoldText(false);
            }
            canvas.drawText(this.f16268j[i6], this.f16276r, f6, this.f16269k);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        String[] strArr = this.f16268j;
        setMeasuredDimension(View.resolveSize((int) (this.f16277s * 2.0f), i6), View.resolveSize((int) Math.ceil(((strArr.length - 1) * this.f16272n) + (strArr.length * this.f16271m)), i7));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        String[] strArr = this.f16268j;
        float length = strArr.length;
        float f6 = this.f16271m;
        float length2 = strArr.length - 1;
        float f7 = this.f16272n;
        this.f16273o = (i7 - ((length2 * f7) + (length * f6))) / 2.0f;
        this.f16276r = i6 / 2.0f;
        float f8 = f6 + f7;
        this.f16274p = f8;
        this.f16275q = 1.0f / f8;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        String[] strArr = this.f16268j;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        int y4 = (int) ((motionEvent.getY() - this.f16273o) * this.f16275q);
        int length = y4 >= 0 ? y4 : 0;
        String[] strArr2 = this.f16268j;
        if (length >= strArr2.length) {
            length = strArr2.length - 1;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            this.f16278t = -1;
            invalidate();
            return true;
        }
        if (length != this.f16278t) {
            this.f16278t = length;
            IndexBarListener indexBarListener = this.f16279u;
            if (indexBarListener != null) {
                String str = this.f16268j[length];
                C0546e c0546e = (C0546e) indexBarListener;
                C0157a c0157a = (C0157a) c0546e.f1684k;
                c0157a.getClass();
                ((AppsLibraryView) c0157a.f444k).f16291l.q0(((int[]) c0546e.f1685l)[length]);
            }
            invalidate();
        }
        return true;
    }

    public void setLetters(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f16268j = strArr;
        requestLayout();
        invalidate();
    }

    public void setOnLetterChangeListener(IndexBarListener indexBarListener) {
        this.f16279u = indexBarListener;
    }
}
