package com.luutinhit.launcher6.editscreen;

import B3.C0047O;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutRound extends LinearLayout {

    /* JADX INFO: renamed from: A */
    public C0047O f16417A;

    /* JADX INFO: renamed from: j */
    public float f16418j;

    /* JADX INFO: renamed from: k */
    public float f16419k;

    /* JADX INFO: renamed from: l */
    public float f16420l;

    /* JADX INFO: renamed from: m */
    public float f16421m;

    /* JADX INFO: renamed from: n */
    public float f16422n;

    /* JADX INFO: renamed from: o */
    public Paint f16423o;

    /* JADX INFO: renamed from: p */
    public RectF f16424p;

    /* JADX INFO: renamed from: q */
    public float f16425q;

    /* JADX INFO: renamed from: r */
    public float f16426r;

    /* JADX INFO: renamed from: s */
    public boolean f16427s;

    /* JADX INFO: renamed from: t */
    public boolean f16428t;

    /* JADX INFO: renamed from: u */
    public boolean f16429u;

    /* JADX INFO: renamed from: v */
    public boolean f16430v;

    /* JADX INFO: renamed from: w */
    public boolean f16431w;

    /* JADX INFO: renamed from: x */
    public boolean f16432x;

    /* JADX INFO: renamed from: y */
    public Path f16433y;

    /* JADX INFO: renamed from: z */
    public Path f16434z;

    public LinearLayoutRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16418j = 400.0f;
        this.f16419k = 400.0f;
        this.f16420l = 80.0f;
        this.f16421m = 0.0f;
        this.f16422n = 0.0f;
        this.f16424p = new RectF();
        this.f16425q = 0.0f;
        this.f16426r = 0.0f;
        this.f16427s = true;
        this.f16428t = true;
        this.f16429u = true;
        this.f16430v = true;
        this.f16431w = true;
        this.f16432x = true;
        this.f16433y = new Path();
        this.f16434z = new Path();
        this.f16417A = new C0047O(2, this);
        int color = -2565928;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2250n);
            this.f16420l = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.sliding_background_round_corner));
            this.f16431w = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.f16432x = typedArrayObtainStyledAttributes.getBoolean(1, false);
            this.f16427s = typedArrayObtainStyledAttributes.getBoolean(6, true);
            this.f16428t = typedArrayObtainStyledAttributes.getBoolean(7, true);
            this.f16429u = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.f16430v = typedArrayObtainStyledAttributes.getBoolean(4, true);
            color = typedArrayObtainStyledAttributes.getColor(0, -2565928);
            typedArrayObtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
        setBackgroundColor(color);
        Paint paint = new Paint(1);
        this.f16423o = paint;
        paint.setColor(1062228048);
    }

    /* JADX INFO: renamed from: a */
    public final void m8028a() {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        Path path = this.f16433y;
        path.reset();
        Path path2 = this.f16434z;
        path2.reset();
        float f13 = this.f16418j;
        if (f13 > 0.0f) {
            float f14 = this.f16419k;
            if (f14 <= 0.0f) {
                return;
            }
            float f15 = this.f16420l;
            float fMin = Math.min(f13, f14) / 2.0f;
            float f16 = this.f16418j;
            float f17 = this.f16419k;
            boolean z5 = this.f16427s;
            boolean z6 = this.f16428t;
            boolean z7 = this.f16429u;
            boolean z8 = this.f16430v;
            path2.reset();
            float f18 = f16 - 0.0f;
            float f19 = f17 - 0.0f;
            if (f18 <= 0.0f || f19 <= 0.0f) {
                f6 = 2.0f;
            } else {
                float f20 = f15 < 0.0f ? 0.0f : f15;
                float f21 = f18 / 2.0f;
                float f22 = this.f16421m - f21;
                f6 = 2.0f;
                float f23 = f19 / 2.0f;
                float f24 = this.f16422n - f23;
                float fMin2 = f20 / Math.min(f21, f23);
                float fMin3 = 1.0f;
                float fMin4 = fMin2 > 0.5f ? 1.0f - (Math.min(1.0f, (fMin2 - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
                if (fMin2 > 0.6f) {
                    fMin3 = 1.0f + (Math.min(1.0f, (fMin2 - 0.6f) / 0.3f) * 0.042454004f);
                }
                float f25 = f22 + f18;
                float f26 = f24 + f19;
                float f27 = f20 / 100.0f;
                float f28 = fMin3;
                float f29 = 128.19f * f27 * fMin4;
                float f30 = 83.62f * f27 * f28;
                float f31 = 67.45f * f27;
                float f32 = 51.16f * f27;
                float f33 = 34.86f * f27;
                float f34 = 22.07f * f27;
                float f35 = 13.36f * f27;
                float f36 = 4.64f * f27;
                float fMax = Math.max(f21, f18 - f29);
                float fMax2 = Math.max(f23, f19 - f29);
                float fMin5 = Math.min(f21, f29);
                float fMin6 = Math.min(f23, f29);
                path2.moveTo(f21 + f22, f24);
                if (z6) {
                    path2.lineTo(f22 + fMax, f24);
                    float f37 = f24 + f35;
                    f7 = f22;
                    path2.cubicTo(f25 - f30, f24, f25 - f31, f24 + f36, f25 - f32, f37);
                    f8 = fMin6;
                    f9 = f24;
                    path2.cubicTo(f25 - f33, f24 + f34, f25 - f34, f24 + f33, f25 - f35, f24 + f32);
                    path2.cubicTo(f25 - f36, f9 + f31, f25, f9 + f30, f25, f9 + f8);
                    f10 = f25;
                } else {
                    path2.lineTo(f25, f24);
                    f10 = f25;
                    f8 = fMin6;
                    f9 = f24;
                    f7 = f22;
                }
                if (z8) {
                    path2.lineTo(f10, f9 + fMax2);
                    path2.cubicTo(f10, f26 - f30, f10 - f36, f26 - f31, f10 - f35, f26 - f32);
                    float f38 = f10;
                    path2.cubicTo(f38 - f34, f26 - f33, f38 - f33, f26 - f34, f38 - f32, f26 - f35);
                    path2.cubicTo(f38 - f31, f26 - f36, f38 - f30, f26, f7 + fMax, f26);
                    f11 = f26;
                } else {
                    path2.lineTo(f10, f26);
                    f11 = f26;
                }
                if (z7) {
                    path2.lineTo(f7 + fMin5, f11);
                    path2.cubicTo(f7 + f30, f11, f7 + f31, f11 - f36, f7 + f32, f11 - f35);
                    float f39 = f11;
                    path2.cubicTo(f7 + f33, f39 - f34, f7 + f34, f39 - f33, f7 + f35, f39 - f32);
                    float f40 = f7;
                    path2.cubicTo(f7 + f36, f39 - f31, f40, f39 - f30, f7, f9 + fMax2);
                    f12 = f40;
                } else {
                    path2.lineTo(f7, f11);
                    f12 = f7;
                }
                if (z5) {
                    path2.lineTo(f12, f9 + f8);
                    path2.cubicTo(f12, f9 + f30, f12 + f36, f9 + f31, f12 + f35, f9 + f32);
                    float f41 = f12;
                    path2.cubicTo(f41 + f34, f9 + f33, f41 + f33, f9 + f34, f41 + f32, f9 + f35);
                    path2.cubicTo(f41 + f31, f9 + f36, f41 + f30, f9, f41 + fMin5, f9);
                } else {
                    path2.lineTo(f12, f9);
                }
                path2.close();
            }
            boolean z9 = this.f16431w;
            if (z9 && f15 == this.f16418j / f6) {
                path.addRoundRect(new RectF(0.0f, 0.0f, this.f16418j, this.f16419k), f15, f15, Path.Direction.CW);
            } else if (z9 || f15 != fMin) {
                path.addPath(path2);
            } else {
                path.addRoundRect(new RectF(0.0f, 0.0f, this.f16418j, this.f16419k), f15, f15, Path.Direction.CW);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.clipPath(this.f16433y);
        super.draw(canvas);
    }

    public float getRectHeight() {
        return this.f16419k;
    }

    public float getRectWidth() {
        return this.f16418j;
    }

    public float getRoundRadius() {
        return this.f16420l;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f16432x) {
            canvas.save();
            canvas.translate(this.f16421m - (this.f16418j / 2.0f), this.f16422n - (this.f16419k / 2.0f));
            canvas.translate((this.f16418j / 2.0f) - (this.f16425q / 2.0f), this.f16426r * 2.0f);
            RectF rectF = this.f16424p;
            float f6 = this.f16426r;
            canvas.drawRoundRect(rectF, f6, f6, this.f16423o);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        float f6 = i6;
        this.f16418j = f6;
        float f7 = i7;
        this.f16419k = f7;
        this.f16421m = f6 / 2.0f;
        this.f16422n = f7 / 2.0f;
        this.f16431w = i6 == i7;
        float f8 = f6 / 10.0f;
        this.f16425q = f8;
        float f9 = f8 / 8.0f;
        this.f16426r = f9;
        this.f16424p.set(0.0f, 0.0f, f8, f9);
        m8028a();
        if (getClipToOutline()) {
            setOutlineProvider(this.f16417A);
        }
    }

    public void setDarkModeBackgroundColor(int i6) {
        setBackgroundColor(i6);
    }

    public void setDarkModeTransparentBackground(boolean z5) {
        setBackgroundColor(z5 ? -1726211044 : -1713447202);
        invalidate();
    }

    public void setIsSquare(boolean z5) {
        this.f16431w = z5;
    }

    public void setRectHeight(float f6) {
        if (this.f16419k != f6) {
            this.f16419k = f6;
            m8028a();
            invalidate();
        }
    }

    public void setRectWidth(float f6) {
        if (this.f16418j != f6) {
            this.f16418j = f6;
            m8028a();
            invalidate();
        }
    }

    public void setRoundRadius(float f6) {
        if (this.f16420l != f6) {
            this.f16420l = f6;
            m8028a();
            invalidate();
        }
    }
}
