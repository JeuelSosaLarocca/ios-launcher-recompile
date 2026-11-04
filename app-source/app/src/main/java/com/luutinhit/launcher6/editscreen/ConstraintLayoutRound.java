package com.luutinhit.launcher6.editscreen;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutRound extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public float f16376j;

    /* JADX INFO: renamed from: k */
    public float f16377k;

    /* JADX INFO: renamed from: l */
    public float f16378l;

    /* JADX INFO: renamed from: m */
    public float f16379m;

    /* JADX INFO: renamed from: n */
    public float f16380n;

    /* JADX INFO: renamed from: o */
    public Paint f16381o;

    /* JADX INFO: renamed from: p */
    public RectF f16382p;

    /* JADX INFO: renamed from: q */
    public float f16383q;

    /* JADX INFO: renamed from: r */
    public float f16384r;

    /* JADX INFO: renamed from: s */
    public boolean f16385s;

    /* JADX INFO: renamed from: t */
    public boolean f16386t;

    /* JADX INFO: renamed from: u */
    public boolean f16387u;

    /* JADX INFO: renamed from: v */
    public boolean f16388v;

    /* JADX INFO: renamed from: w */
    public boolean f16389w;

    /* JADX INFO: renamed from: x */
    public boolean f16390x;

    /* JADX INFO: renamed from: y */
    public Path f16391y;

    /* JADX INFO: renamed from: z */
    public Path f16392z;

    public ConstraintLayoutRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16376j = 400.0f;
        this.f16377k = 400.0f;
        this.f16378l = 80.0f;
        this.f16379m = 0.0f;
        this.f16380n = 0.0f;
        this.f16382p = new RectF();
        this.f16383q = 0.0f;
        this.f16384r = 0.0f;
        this.f16385s = true;
        this.f16386t = true;
        this.f16387u = true;
        this.f16388v = true;
        this.f16389w = true;
        this.f16390x = true;
        this.f16391y = new Path();
        this.f16392z = new Path();
        int color = -2565928;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2244h);
            this.f16378l = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.widget_round_corner));
            this.f16389w = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.f16390x = typedArrayObtainStyledAttributes.getBoolean(1, false);
            this.f16385s = typedArrayObtainStyledAttributes.getBoolean(6, true);
            this.f16386t = typedArrayObtainStyledAttributes.getBoolean(7, true);
            this.f16387u = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.f16388v = typedArrayObtainStyledAttributes.getBoolean(4, true);
            color = typedArrayObtainStyledAttributes.getColor(0, -2565928);
            typedArrayObtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.f16381o = paint2;
        paint2.setColor(1062228048);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.clipPath(this.f16391y);
        super.draw(canvas);
    }

    public float getRectHeight() {
        return this.f16377k;
    }

    public float getRectWidth() {
        return this.f16376j;
    }

    public float getRoundRadius() {
        return this.f16378l;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f16390x) {
            canvas.save();
            canvas.translate(this.f16379m - (this.f16376j / 2.0f), this.f16380n - (this.f16377k / 2.0f));
            canvas.translate((this.f16376j / 2.0f) - (this.f16383q / 2.0f), this.f16384r * 2.0f);
            RectF rectF = this.f16382p;
            float f6 = this.f16384r;
            canvas.drawRoundRect(rectF, f6, f6, this.f16381o);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        float f6 = i6;
        this.f16376j = f6;
        float f7 = i7;
        this.f16377k = f7;
        this.f16379m = f6 / 2.0f;
        this.f16380n = f7 / 2.0f;
        this.f16389w = i6 == i7;
        float f8 = f6 / 10.0f;
        this.f16383q = f8;
        float f9 = f8 / 8.0f;
        this.f16384r = f9;
        this.f16382p.set(0.0f, 0.0f, f8, f9);
        m8025y();
    }

    public void setDarkModeBackgroundColor(int i6) {
        setBackgroundColor(i6);
    }

    public void setIsSquare(boolean z5) {
        this.f16389w = z5;
    }

    public void setRectHeight(float f6) {
        if (this.f16377k != f6) {
            this.f16377k = f6;
            m8025y();
            invalidate();
        }
    }

    public void setRectWidth(float f6) {
        if (this.f16376j != f6) {
            this.f16376j = f6;
            m8025y();
            invalidate();
        }
    }

    public void setRoundRadius(float f6) {
        if (this.f16378l != f6) {
            this.f16378l = f6;
            m8025y();
            invalidate();
        }
    }

    /* JADX INFO: renamed from: y */
    public final void m8025y() {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        Path path = this.f16391y;
        path.reset();
        Path path2 = this.f16392z;
        path2.reset();
        float f12 = this.f16376j;
        if (f12 > 0.0f) {
            float f13 = this.f16377k;
            if (f13 <= 0.0f) {
                return;
            }
            float f14 = this.f16378l;
            float fMin = Math.min(f12, f13) / 2.0f;
            float f15 = this.f16376j;
            float f16 = this.f16377k;
            path2.reset();
            float f17 = f15 - 0.0f;
            float f18 = f16 - 0.0f;
            if (f17 <= 0.0f || f18 <= 0.0f) {
                f6 = 2.0f;
            } else {
                float f19 = f14 < 0.0f ? 0.0f : f14;
                float f20 = f17 / 2.0f;
                float f21 = this.f16379m - f20;
                float f22 = f18 / 2.0f;
                float f23 = this.f16380n - f22;
                float fMin2 = f19 / Math.min(f20, f22);
                f6 = 2.0f;
                float fMin3 = fMin2 > 0.5f ? 1.0f - (Math.min(1.0f, (fMin2 - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
                float fMin4 = fMin2 > 0.6f ? 1.0f + (Math.min(1.0f, (fMin2 - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
                float f24 = f21 + f17;
                float f25 = f23 + f18;
                float f26 = f19 / 100.0f;
                float f27 = fMin3 * 128.19f * f26;
                float f28 = 83.62f * f26 * fMin4;
                float f29 = 67.45f * f26;
                float f30 = 51.16f * f26;
                float f31 = 34.86f * f26;
                float f32 = 22.07f * f26;
                float f33 = 13.36f * f26;
                float f34 = 4.64f * f26;
                float fMax = Math.max(f20, f17 - f27);
                float fMax2 = Math.max(f22, f18 - f27);
                float fMin5 = Math.min(f20, f27);
                float fMin6 = Math.min(f22, f27);
                path2.moveTo(f20 + f21, f23);
                if (this.f16386t) {
                    path2.lineTo(f21 + fMax, f23);
                    path2.cubicTo(f24 - f28, f23, f24 - f29, f23 + f34, f24 - f30, f23 + f33);
                    f7 = f29;
                    f8 = f23;
                    path2.cubicTo(f24 - f31, f23 + f32, f24 - f32, f23 + f31, f24 - f33, f23 + f30);
                    path2.cubicTo(f24 - f34, f8 + f7, f24, f8 + f28, f24, f8 + fMin6);
                    f9 = f24;
                } else {
                    path2.lineTo(f24, f23);
                    f7 = f29;
                    f9 = f24;
                    f8 = f23;
                }
                if (this.f16388v) {
                    path2.lineTo(f9, f8 + fMax2);
                    path2.cubicTo(f9, f25 - f28, f9 - f34, f25 - f7, f9 - f33, f25 - f30);
                    float f35 = f9;
                    path2.cubicTo(f35 - f32, f25 - f31, f35 - f31, f25 - f32, f35 - f30, f25 - f33);
                    path2.cubicTo(f35 - f7, f25 - f34, f35 - f28, f25, f21 + fMax, f25);
                    f10 = f25;
                } else {
                    path2.lineTo(f9, f25);
                    f10 = f25;
                }
                if (this.f16387u) {
                    path2.lineTo(f21 + fMin5, f10);
                    path2.cubicTo(f21 + f28, f10, f21 + f7, f10 - f34, f21 + f30, f10 - f33);
                    float f36 = f10;
                    path2.cubicTo(f21 + f31, f36 - f32, f21 + f32, f36 - f31, f21 + f33, f36 - f30);
                    path2.cubicTo(f21 + f34, f36 - f7, f21, f36 - f28, f21, f8 + fMax2);
                    f11 = f21;
                } else {
                    path2.lineTo(f21, f10);
                    f11 = f21;
                }
                if (this.f16385s) {
                    path2.lineTo(f11, f8 + fMin6);
                    path2.cubicTo(f11, f8 + f28, f11 + f34, f8 + f7, f11 + f33, f8 + f30);
                    float f37 = f11;
                    path2.cubicTo(f37 + f32, f8 + f31, f37 + f31, f8 + f32, f37 + f30, f8 + f33);
                    path2.cubicTo(f37 + f7, f8 + f34, f37 + f28, f8, f37 + fMin5, f8);
                } else {
                    path2.lineTo(f11, f8);
                }
                path2.close();
            }
            boolean z5 = this.f16389w;
            if (z5 && f14 == this.f16376j / f6) {
                path.addRoundRect(new RectF(0.0f, 0.0f, this.f16376j, this.f16377k), f14, f14, Path.Direction.CW);
            } else if (z5 || f14 != fMin) {
                path.addPath(path2);
            } else {
                path.addRoundRect(new RectF(0.0f, 0.0f, this.f16376j, this.f16377k), f14, f14, Path.Direction.CW);
            }
        }
    }
}
