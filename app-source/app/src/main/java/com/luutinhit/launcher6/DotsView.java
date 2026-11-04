package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public final class DotsView extends View {

    /* JADX INFO: renamed from: A */
    public long f15493A;

    /* JADX INFO: renamed from: B */
    public int f15494B;

    /* JADX INFO: renamed from: C */
    public int f15495C;

    /* JADX INFO: renamed from: D */
    public int f15496D;

    /* JADX INFO: renamed from: E */
    public int f15497E;

    /* JADX INFO: renamed from: F */
    public float f15498F;

    /* JADX INFO: renamed from: G */
    public float f15499G;

    /* JADX INFO: renamed from: H */
    public boolean f15500H;

    /* JADX INFO: renamed from: j */
    public Paint f15501j;

    /* JADX INFO: renamed from: k */
    public int f15502k;

    /* JADX INFO: renamed from: l */
    public int f15503l;

    /* JADX INFO: renamed from: m */
    public int[] f15504m;

    /* JADX INFO: renamed from: n */
    public float[] f15505n;

    /* JADX INFO: renamed from: o */
    public float[] f15506o;

    /* JADX INFO: renamed from: p */
    public float[] f15507p;

    /* JADX INFO: renamed from: q */
    public float[] f15508q;

    /* JADX INFO: renamed from: r */
    public float[] f15509r;

    /* JADX INFO: renamed from: s */
    public float[] f15510s;

    /* JADX INFO: renamed from: t */
    public float[] f15511t;

    /* JADX INFO: renamed from: u */
    public float[] f15512u;

    /* JADX INFO: renamed from: v */
    public int f15513v;

    /* JADX INFO: renamed from: w */
    public int f15514w;

    /* JADX INFO: renamed from: x */
    public int f15515x;

    /* JADX INFO: renamed from: y */
    public int f15516y;

    /* JADX INFO: renamed from: z */
    public boolean f15517z;

    public DotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint(1);
        this.f15501j = paint;
        this.f15504m = new int[8];
        this.f15505n = new float[8];
        this.f15506o = new float[8];
        this.f15507p = new float[8];
        this.f15508q = new float[8];
        this.f15509r = new float[8];
        this.f15510s = new float[8];
        this.f15511t = new float[8];
        this.f15512u = new float[8];
        this.f15500H = false;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_size);
        this.f15502k = dimensionPixelSize;
        this.f15503l = dimensionPixelSize + (getResources().getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_margin) << 1);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
        setImportantForAccessibility(2);
    }

    /* JADX INFO: renamed from: b */
    public static float lerp(float f6, float f7, float f8) {
        return SyntheticHelpers.m7906e(f7, f6, f8, f6);
    }

    /* JADX INFO: renamed from: g */
    public static int getVisibleDotCount(int i6, int i7) {
        if (i7 <= 0 || i6 < 0 || i6 >= i7) {
            return 0;
        }
        return Math.min(5, i7 - i6);
    }

    /* JADX INFO: renamed from: a */
    public final float getAnimationProgress(long j6) {
        if (!this.f15517z) {
            return 1.0f;
        }
        long j7 = j6 - this.f15493A;
        float fMin = j7 <= 0 ? 0.0f : Math.min(1.0f, j7 / 2.0E8f);
        if (fMin < 1.0f) {
            float f6 = 1.0f - fMin;
            return 1.0f - (f6 * f6);
        }
        for (int i6 = 0; i6 < this.f15516y; i6++) {
            this.f15505n[i6] = this.f15506o[i6];
            this.f15507p[i6] = this.f15508q[i6];
            this.f15509r[i6] = this.f15510s[i6];
            this.f15511t[i6] = this.f15512u[i6];
        }
        this.f15517z = false;
        this.f15493A = 0L;
        return 1.0f;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0025  */
    /* JADX INFO: renamed from: c */
    public final void updateDotPositions() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int iMin;
        this.f15517z = false;
        this.f15493A = 0L;
        int i6 = this.f15513v;
        if (i6 == 0) {
            this.f15514w = 0;
            this.f15515x = 0;
            this.f15516y = 0;
            return;
        }
        int i7 = this.f15514w;
        this.f15514w = i7 < 0 ? 0 : Math.min(i7, i6 - 1);
        int i8 = this.f15513v;
        if (i8 <= 5) {
            iMin = 0;
        } else {
            int i9 = this.f15515x;
            int i10 = i8 - 5;
            if (i9 < 0) {
                iMin = 0;
            } else {
                iMin = Math.min(i9, i10);
            }
        }
        this.f15515x = iMin;
        int visibleDotCount = getVisibleDotCount(iMin, this.f15513v);
        this.f15516y = visibleDotCount;
        for (int i11 = 0; i11 < visibleDotCount; i11++) {
            int i12 = this.f15515x + i11;
            float fComputeDotX = computeDotX(i11, visibleDotCount);
            float fComputeDotScale = computeDotScale(i12, i11, this.f15515x, this.f15514w, visibleDotCount);
            float f6 = i12 == this.f15514w ? 1.0f : 0.5019608f;
            this.f15504m[i11] = i12;
            this.f15506o[i11] = fComputeDotX;
            this.f15505n[i11] = fComputeDotX;
            this.f15508q[i11] = fComputeDotScale;
            this.f15507p[i11] = fComputeDotScale;
            this.f15510s[i11] = f6;
            this.f15509r[i11] = f6;
            this.f15512u[i11] = 1.0f;
            this.f15511t[i11] = 1.0f;
        }
    }

    /* JADX INFO: renamed from: d */
    public final float computeDotScale(int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (i6 != i9 && (i11 = this.f15513v) > 5) {
            boolean z5 = false;
            boolean z6 = i7 == 0 && i8 > 0;
            if (i7 == i10 - 1 && i8 + i10 < i11) {
                z5 = true;
            }
            if (z6 || z5) {
                return 0.5f;
            }
        }
        return 1.0f;
    }

    /* JADX INFO: renamed from: e */
    public final void updateCenterY() {
        this.f15498F = (((getHeight() - this.f15496D) - this.f15497E) * 0.5f) + this.f15496D;
        this.f15499G = this.f15502k * 0.5f;
    }

    /* JADX INFO: renamed from: f */
    public final void updateContentBounds() {
        this.f15494B = getPaddingLeft();
        this.f15495C = getPaddingRight();
        this.f15496D = getPaddingTop();
        this.f15497E = getPaddingBottom();
    }

    /* JADX INFO: renamed from: h */
    public final float computeDotX(int i6, int i7) {
        float width = (((getWidth() - this.f15494B) - this.f15495C) * 0.5f) + this.f15494B;
        if (i7 <= 0) {
            return width;
        }
        int i8 = i7 - 1;
        int i9 = this.f15503l;
        return (width - ((i8 * i9) * 0.5f)) + (getLayoutDirection() == 1 ? (i8 - i6) * i9 : i6 * i9);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f15516y == 0) {
            return;
        }
        float animationProgress = getAnimationProgress(System.nanoTime());
        if (this.f15517z) {
            postInvalidateOnAnimation();
        }
        int i6 = 0;
        while (true) {
            int i7 = this.f15516y;
            Paint paint = this.f15501j;
            if (i6 >= i7) {
                paint.setAlpha(255);
                return;
            }
            float fLerp = lerp(this.f15511t[i6], this.f15512u[i6], animationProgress);
            if (fLerp > 0.001f) {
                float fLerp2 = lerp(this.f15509r[i6], this.f15510s[i6], animationProgress) * fLerp;
                if (fLerp2 > 0.001f) {
                    paint.setAlpha((int) ((fLerp2 * 255.0f) + 0.5f));
                    canvas.drawCircle(lerp(this.f15505n[i6], this.f15506o[i6], animationProgress), this.f15498F, this.f15499G * lerp(this.f15507p[i6], this.f15508q[i6], animationProgress), paint);
                }
            }
            i6++;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            updateContentBounds();
            updateCenterY();
        }
        if (z5 || this.f15500H) {
            this.f15500H = false;
            if (this.f15513v > 0) {
                updateDotPositions();
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        updateContentBounds();
        int visibleDotCount = getVisibleDotCount(this.f15515x, this.f15513v);
        int i8 = this.f15494B + this.f15495C;
        int i9 = this.f15502k;
        int i10 = i8 + (visibleDotCount == 0 ? 0 : ((visibleDotCount - 1) * this.f15503l) + i9);
        int i11 = this.f15496D + this.f15497E;
        if (visibleDotCount == 0) {
            i9 = 0;
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, i6, 0), View.resolveSizeAndState(i11 + i9, i7, 0));
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i6) {
        super.onRtlPropertiesChanged(i6);
        this.f15500H = true;
        requestLayout();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        updateContentBounds();
        updateCenterY();
        if (this.f15513v > 0) {
            updateDotPositions();
            invalidate();
        }
    }
}
