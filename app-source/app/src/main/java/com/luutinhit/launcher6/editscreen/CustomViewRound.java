package com.luutinhit.launcher6.editscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.luutinhit.launcher6.Launcher;

/* JADX INFO: loaded from: classes.dex */
public class CustomViewRound extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public float f16393j;

    /* JADX INFO: renamed from: k */
    public float f16394k;

    /* JADX INFO: renamed from: l */
    public float f16395l;

    /* JADX INFO: renamed from: m */
    public Paint f16396m;

    /* JADX INFO: renamed from: n */
    public Path f16397n;

    /* JADX INFO: renamed from: o */
    public Paint f16398o;

    /* JADX INFO: renamed from: p */
    public boolean f16399p;

    public CustomViewRound(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16393j = 80.0f;
        this.f16394k = 0.0f;
        this.f16395l = 0.0f;
        this.f16397n = new Path();
        this.f16399p = true;
        setWillNotDraw(false);
        setLayerType(2, null);
        Paint paint = new Paint(1);
        this.f16396m = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-2565928);
        if ((context instanceof Launcher) && ((Launcher) context).isUseLiquidGlass) {
            Paint paint2 = new Paint(1);
            this.f16398o = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(2.0f);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8026a(int i6, int i7) {
        if (i6 <= 0 || i7 <= 0) {
            return;
        }
        Path path = this.f16397n;
        float f6 = this.f16393j;
        path.reset();
        float f7 = (i6 - 2.0f) - 2.0f;
        float f8 = (i7 - 2.0f) - 2.0f;
        if (f7 <= 0.0f || f8 <= 0.0f) {
            return;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        float f9 = f7 / 2.0f;
        float f10 = this.f16394k - f9;
        float f11 = f8 / 2.0f;
        float f12 = this.f16395l - f11;
        float fMin = f6 / Math.min(f9, f11);
        float fMin2 = fMin > 0.5f ? 1.0f - (Math.min(1.0f, (fMin - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin3 = fMin > 0.6f ? 1.0f + (Math.min(1.0f, (fMin - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        float f13 = f10 + f7;
        float f14 = f12 + f8;
        float f15 = f6 / 100.0f;
        float f16 = 128.19f * f15 * fMin2;
        float f17 = 83.62f * f15 * fMin3;
        float f18 = 67.45f * f15;
        float f19 = 51.16f * f15;
        float f20 = 34.86f * f15;
        float f21 = 22.07f * f15;
        float f22 = 13.36f * f15;
        float f23 = 4.64f * f15;
        float fMax = Math.max(f9, f7 - f16);
        float fMax2 = Math.max(f11, f8 - f16);
        float fMin4 = Math.min(f9, f16);
        float fMin5 = Math.min(f11, f16);
        path.moveTo(f9 + f10, f12);
        path.lineTo(f10 + fMax, f12);
        path.cubicTo(f13 - f17, f12, f13 - f18, f12 + f23, f13 - f19, f12 + f22);
        path.cubicTo(f13 - f20, f12 + f21, f13 - f21, f12 + f20, f13 - f22, f12 + f19);
        path.cubicTo(f13 - f23, f12 + f18, f13, f12 + f17, f13, f12 + fMin5);
        path.lineTo(f13, f12 + fMax2);
        path.cubicTo(f13, f14 - f17, f13 - f23, f14 - f18, f13 - f22, f14 - f19);
        path.cubicTo(f13 - f21, f14 - f20, f13 - f20, f14 - f21, f13 - f19, f14 - f22);
        path.cubicTo(f13 - f18, f14 - f23, f13 - f17, f14, f10 + fMax, f14);
        path.lineTo(f10 + fMin4, f14);
        path.cubicTo(f10 + f17, f14, f10 + f18, f14 - f23, f10 + f19, f14 - f22);
        path.cubicTo(f10 + f20, f14 - f21, f10 + f21, f14 - f20, f10 + f22, f14 - f19);
        path.cubicTo(f10 + f23, f14 - f18, f10, f14 - f17, f10, f12 + fMax2);
        path.lineTo(f10, f12 + fMin5);
        path.cubicTo(f10, f12 + f17, f10 + f23, f12 + f18, f10 + f22, f12 + f19);
        path.cubicTo(f10 + f21, f12 + f20, f10 + f20, f12 + f21, f10 + f19, f12 + f22);
        path.cubicTo(f10 + f18, f12 + f23, f10 + f17, f12, f10 + fMin4, f12);
        path.close();
    }

    public float getRoundRadius() {
        return this.f16393j;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f16399p) {
            Path path = this.f16397n;
            Paint paint = this.f16398o;
            if (paint == null) {
                paint = this.f16396m;
            }
            canvas.drawPath(path, paint);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        float f6 = i6 / 2.0f;
        this.f16394k = f6;
        float f7 = i7 / 2.0f;
        this.f16395l = f7;
        this.f16393j = Math.min(f6, f7) - 2.0f;
        m8026a(i6, i7);
        Paint paint = this.f16398o;
        if (paint != null) {
            paint.setShader(new SweepGradient(this.f16394k, this.f16395l, new int[]{922746879, -855638017, 922746879, -855638017, 922746879}, new float[]{0.0f, 0.05f, 0.5f, 0.55f, 1.0f}));
        }
    }

    public void setDarkModeTransparentBackground(boolean z5) {
        this.f16396m.setColor(z5 ? -1726211044 : -1713447202);
        invalidate();
    }

    public void setRoundRadius(float f6) {
        if (this.f16393j != f6) {
            this.f16393j = f6;
            m8026a(getWidth(), getHeight());
            invalidate();
        }
    }
}
