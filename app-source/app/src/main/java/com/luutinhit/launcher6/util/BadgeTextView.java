package com.luutinhit.launcher6.util;

import B3.C0058a;
import B3.RunnableC0054W;
import O3.AbstractC0744e;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import com.luutinhit.launcher6.LauncherAnimUtils;
import com.luutinhit.launcher6.Utilities;

/* JADX INFO: loaded from: classes.dex */
public class BadgeTextView extends TextViewCustomFont {

    /* JADX INFO: renamed from: q */
    public Paint f16910q;

    /* JADX INFO: renamed from: r */
    public int f16911r;

    /* JADX INFO: renamed from: s */
    public int f16912s;

    /* JADX INFO: renamed from: t */
    public float f16913t;

    /* JADX INFO: renamed from: u */
    public float f16914u;

    /* JADX INFO: renamed from: v */
    public RectF f16915v;

    public BadgeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        post(new RunnableC0054W(0, this, attributeSet));
        setGravity(17);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2237a);
        this.f16911r = typedArrayObtainStyledAttributes.getColor(1, -65536);
        this.f16912s = typedArrayObtainStyledAttributes.getColor(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f16910q = paint;
        paint.setAntiAlias(true);
        this.f16910q.setStyle(Paint.Style.FILL);
        this.f16910q.setTextAlign(Paint.Align.CENTER);
        this.f16910q.setTypeface(getTypeface());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (text == null) {
            return;
        }
        if (text.length() == 1) {
            this.f16910q.setColor(this.f16911r);
            float f6 = this.f16913t / 2.0f;
            float f7 = this.f16914u;
            canvas.drawCircle(f6, f7 / 2.0f, f7 / 2.0f, this.f16910q);
            this.f16910q.setColor(this.f16912s);
            this.f16910q.setTextSize((this.f16914u * 2.0f) / 3.0f);
            canvas.drawText(text.toString(), this.f16913t / 2.0f, (float) (((double) this.f16914u) * 0.73d), this.f16910q);
            return;
        }
        this.f16910q.setColor(this.f16911r);
        RectF rectF = this.f16915v;
        if (rectF == null) {
            this.f16915v = new RectF(0.0f, 0.0f, this.f16913t, this.f16914u);
        } else {
            rectF.set(0.0f, 0.0f, this.f16913t, this.f16914u);
        }
        RectF rectF2 = this.f16915v;
        float f8 = this.f16914u;
        canvas.drawRoundRect(rectF2, f8, f8, this.f16910q);
        this.f16910q.setColor(this.f16912s);
        this.f16910q.setTextSize((this.f16914u * 2.0f) / 3.0f);
        canvas.drawText(text.toString(), this.f16913t / 2.0f, (float) (((double) this.f16914u) * 0.73d), this.f16910q);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f16913t = i6;
        this.f16914u = i7;
    }

    /* JADX INFO: renamed from: q */
    public final void m8190q(int i6, boolean z5) {
        if (i6 > 0 && i6 <= 99) {
            setText(String.valueOf(i6));
            setVisibility(0);
        } else if (i6 > 99) {
            setText("99+");
            setVisibility(0);
        } else {
            setText("0");
            if (z5) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
        }
        invalidate();
    }

    public void setBadgeCount(String str) {
        int i6;
        try {
            i6 = Integer.parseInt(str);
        } catch (Exception e) {
            e.getMessage();
            i6 = -1;
        }
        if (i6 != -1) {
            m8190q(i6, false);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        int i7 = 0;
        int i8 = 1;
        if (getVisibility() != i6) {
            if (i6 == 0) {
                setEnabled(true);
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
                objectAnimatorOfPropertyValuesHolder.setDuration(300L);
                objectAnimatorOfPropertyValuesHolder.addListener(new C0058a(this, i7));
                if (Utilities.f16752m) {
                    objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                objectAnimatorOfPropertyValuesHolder.start();
                return;
            }
            if (i6 == 4 || i6 == 8) {
                ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 0.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f));
                objectAnimatorOfPropertyValuesHolder2.setDuration(300L);
                objectAnimatorOfPropertyValuesHolder2.addListener(new C0058a(this, i8));
                if (Utilities.f16752m) {
                    objectAnimatorOfPropertyValuesHolder2.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
                }
                objectAnimatorOfPropertyValuesHolder2.start();
            }
        }
    }

    public void setBadgeCount(int i6) {
        m8190q(i6, true);
    }
}
