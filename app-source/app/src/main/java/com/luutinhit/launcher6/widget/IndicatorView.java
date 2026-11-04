package com.luutinhit.launcher6.widget;

import F0.InterfaceC0246f;
import G3.C0349e;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class IndicatorView extends View implements InterfaceC0246f {

    /* JADX INFO: renamed from: j */
    public Paint f17107j;

    /* JADX INFO: renamed from: k */
    public int f17108k;

    /* JADX INFO: renamed from: l */
    public int f17109l;

    /* JADX INFO: renamed from: m */
    public float f17110m;

    /* JADX INFO: renamed from: n */
    public float f17111n;

    /* JADX INFO: renamed from: o */
    public float f17112o;

    /* JADX INFO: renamed from: p */
    public int f17113p;

    /* JADX INFO: renamed from: q */
    public int f17114q;

    /* JADX INFO: renamed from: r */
    public ArrayList f17115r;

    /* JADX INFO: renamed from: s */
    public ViewPager f17116s;

    public IndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f17115r = new ArrayList();
        this.f17116s = null;
        float f6 = context.getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2248l);
        this.f17108k = typedArrayObtainStyledAttributes.getColor(0, -7829368);
        this.f17109l = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.f17110m = typedArrayObtainStyledAttributes.getDimension(1, 4.0f * f6);
        this.f17111n = typedArrayObtainStyledAttributes.getDimension(5, 2.0f * f6);
        this.f17112o = typedArrayObtainStyledAttributes.getDimension(4, f6 * 5.0f);
        this.f17113p = typedArrayObtainStyledAttributes.getInt(2, 0);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f17107j = paint;
        paint.setColor(this.f17108k);
        paint.setStyle(Paint.Style.FILL);
    }

    public void setCount(int i6) {
        this.f17114q = i6;
        requestLayout();
    }

    public void setSelectPosition(int i6) {
        this.f17113p = i6;
        invalidate();
    }

    @Override // F0.InterfaceC0246f
    /* JADX INFO: renamed from: a */
    public final void mo583a(int i6) {
    }

    @Override // F0.InterfaceC0246f
    /* JADX INFO: renamed from: b */
    public final void mo584b(int i6) {
        setSelectPosition(i6);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f17115r;
            if (i6 >= arrayList.size()) {
                return;
            }
            C0349e c0349e = (C0349e) arrayList.get(i6);
            float f6 = c0349e.f1145a;
            float f7 = c0349e.f1146b;
            Paint paint = this.f17107j;
            paint.setColor(i6 == this.f17113p ? this.f17109l : this.f17108k);
            canvas.drawCircle(f6, f7, this.f17110m, paint);
            i6++;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        float f6 = (this.f17110m + this.f17111n) * 2.0f;
        int i8 = this.f17114q;
        float f7 = this.f17112o;
        setMeasuredDimension((int) (((i8 - 1) * f7) + (i8 * f6)), (int) f6);
        ArrayList arrayList = this.f17115r;
        arrayList.clear();
        float f8 = 0.0f;
        int i9 = 0;
        while (i9 < this.f17114q) {
            C0349e c0349e = new C0349e();
            f8 = i9 == 0 ? this.f17110m + this.f17111n : ((this.f17110m + this.f17111n) * 2.0f) + f7 + f8;
            c0349e.f1145a = f8;
            c0349e.f1146b = getMeasuredHeight() / 2.0f;
            arrayList.add(c0349e);
            i9++;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float x6 = motionEvent.getX();
            float y4 = motionEvent.getY();
            int i6 = 0;
            while (true) {
                ArrayList arrayList = this.f17115r;
                if (i6 >= arrayList.size()) {
                    break;
                }
                if (x6 > (((C0349e) arrayList.get(i6)).f1145a - this.f17110m) - this.f17111n && x6 < ((C0349e) arrayList.get(i6)).f1145a + this.f17110m + this.f17111n && y4 > (((C0349e) arrayList.get(i6)).f1146b - this.f17110m) - this.f17111n && y4 < ((C0349e) arrayList.get(i6)).f1146b + this.f17110m + this.f17111n) {
                    this.f17116s.setCurrentItem(i6);
                }
                i6++;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIndicatorColor(int i6) {
        this.f17108k = i6;
        invalidate();
    }

    public void setRadius(float f6) {
        this.f17110m = f6;
        invalidate();
    }

    public void setSelectColor(int i6) {
        this.f17109l = i6;
        invalidate();
    }

    public void setStrokeWidth(float f6) {
        this.f17111n = f6;
        invalidate();
    }

    public void setUpWithViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f17116s;
        if (viewPager2 != null) {
            ArrayList arrayList = viewPager2.f22356c0;
            if (arrayList != null) {
                arrayList.remove(this);
            }
            this.f17116s = null;
        }
        this.f17116s = viewPager;
        if (viewPager.f22356c0 == null) {
            viewPager.f22356c0 = new ArrayList();
        }
        viewPager.f22356c0.add(this);
        setCount(this.f17116s.getAdapter().mo575c());
    }

    @Override // F0.InterfaceC0246f
    /* JADX INFO: renamed from: c */
    public final void mo585c(int i6, float f6) {
    }
}
