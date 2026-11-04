package com.luutinhit.launcher6.editscreen;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerViewRound extends RecyclerView {

    /* JADX INFO: renamed from: T0 */
    public float f23477T0;

    /* JADX INFO: renamed from: U0 */
    public float f23478U0;

    /* JADX INFO: renamed from: V0 */
    public float f23479V0;

    /* JADX INFO: renamed from: W0 */
    public float f23480W0;

    /* JADX INFO: renamed from: X0 */
    public float f23481X0;

    /* JADX INFO: renamed from: Y0 */
    public Paint f23482Y0;

    /* JADX INFO: renamed from: Z0 */
    public RectF f23483Z0;

    /* JADX INFO: renamed from: a1 */
    public float f23484a1;

    /* JADX INFO: renamed from: b1 */
    public float f23485b1;

    /* JADX INFO: renamed from: c1 */
    public boolean f23486c1;

    /* JADX INFO: renamed from: d1 */
    public boolean f23487d1;

    /* JADX INFO: renamed from: e1 */
    public boolean f23488e1;

    /* JADX INFO: renamed from: f1 */
    public boolean f23489f1;

    /* JADX INFO: renamed from: g1 */
    public boolean f23490g1;

    /* JADX INFO: renamed from: h1 */
    public boolean f23491h1;

    /* JADX INFO: renamed from: i1 */
    public Path f23492i1;

    /* JADX INFO: renamed from: j1 */
    public Path f23493j1;

    public RecyclerViewRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f23477T0 = 400.0f;
        this.f23478U0 = 400.0f;
        this.f23479V0 = 80.0f;
        this.f23480W0 = 0.0f;
        this.f23481X0 = 0.0f;
        this.f23483Z0 = new RectF();
        this.f23484a1 = 0.0f;
        this.f23485b1 = 0.0f;
        this.f23486c1 = true;
        this.f23487d1 = true;
        this.f23488e1 = false;
        this.f23489f1 = false;
        this.f23490g1 = true;
        this.f23491h1 = true;
        this.f23492i1 = new Path();
        this.f23493j1 = new Path();
        int color = -2565928;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2258v);
            this.f23479V0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.icon_round_corner));
            this.f23490g1 = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.f23491h1 = typedArrayObtainStyledAttributes.getBoolean(1, false);
            this.f23486c1 = typedArrayObtainStyledAttributes.getBoolean(6, true);
            this.f23487d1 = typedArrayObtainStyledAttributes.getBoolean(7, true);
            this.f23488e1 = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.f23489f1 = typedArrayObtainStyledAttributes.getBoolean(4, true);
            color = typedArrayObtainStyledAttributes.getColor(0, -2565928);
            typedArrayObtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.f23482Y0 = paint2;
        paint2.setColor(1062228048);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void draw(Canvas canvas) {
        canvas.clipPath(this.f23492i1);
        super.draw(canvas);
    }

    public float getRectHeight() {
        return this.f23478U0;
    }

    public float getRectWidth() {
        return this.f23477T0;
    }

    public float getRoundRadius() {
        return this.f23479V0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f23491h1) {
            canvas.save();
            canvas.translate(this.f23480W0 - (this.f23477T0 / 2.0f), this.f23481X0 - (this.f23478U0 / 2.0f));
            canvas.translate((this.f23477T0 / 2.0f) - (this.f23484a1 / 2.0f), this.f23485b1 * 2.0f);
            RectF rectF = this.f23483Z0;
            float f6 = this.f23485b1;
            canvas.drawRoundRect(rectF, f6, f6, this.f23482Y0);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        float f6 = i6;
        this.f23477T0 = f6;
        float f7 = i7;
        this.f23478U0 = f7;
        this.f23480W0 = f6 / 2.0f;
        this.f23481X0 = f7 / 2.0f;
        this.f23490g1 = i6 == i7;
        float f8 = f6 / 10.0f;
        this.f23484a1 = f8;
        float f9 = f8 / 8.0f;
        this.f23485b1 = f9;
        this.f23483Z0.set(0.0f, 0.0f, f8, f9);
        v0();
    }

    public void setDarkModeBackgroundColor(int i6) {
        setBackgroundColor(i6);
    }

    public void setIsSquare(boolean z5) {
        this.f23490g1 = z5;
    }

    public void setRectHeight(float f6) {
        if (this.f23478U0 != f6) {
            this.f23478U0 = f6;
            v0();
            invalidate();
        }
    }

    public void setRectWidth(float f6) {
        if (this.f23477T0 != f6) {
            this.f23477T0 = f6;
            v0();
            invalidate();
        }
    }

    public void setRoundRadius(float f6) {
        if (this.f23479V0 != f6) {
            this.f23479V0 = f6;
            v0();
            invalidate();
        }
    }

    public final void v0() {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        Path path = this.f23492i1;
        path.reset();
        Path path2 = this.f23493j1;
        path2.reset();
        float f12 = this.f23477T0;
        if (f12 > 0.0f) {
            float f13 = this.f23478U0;
            if (f13 <= 0.0f) {
                return;
            }
            float f14 = this.f23479V0;
            float fMin = Math.min(f12, f13) / 2.0f;
            float f15 = this.f23477T0;
            float f16 = this.f23478U0;
            path2.reset();
            float f17 = f15 - 0.0f;
            float f18 = f16 - 0.0f;
            if (f17 <= 0.0f || f18 <= 0.0f) {
                f6 = 2.0f;
            } else {
                float f19 = f14 < 0.0f ? 0.0f : f14;
                float f20 = f17 / 2.0f;
                float f21 = this.f23480W0 - f20;
                float f22 = f18 / 2.0f;
                float f23 = this.f23481X0 - f22;
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
                if (this.f23487d1) {
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
                if (this.f23489f1) {
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
                if (this.f23488e1) {
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
                if (this.f23486c1) {
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
            boolean z5 = this.f23490g1;
            if (z5 && f14 == this.f23477T0 / f6) {
                path.addRoundRect(new RectF(0.0f, 0.0f, this.f23477T0, this.f23478U0), f14, f14, Path.Direction.CW);
            } else if (z5 || f14 != fMin) {
                path.addPath(path2);
            } else {
                path.addRoundRect(new RectF(0.0f, 0.0f, this.f23477T0, this.f23478U0), f14, f14, Path.Direction.CW);
            }
        }
    }
}
