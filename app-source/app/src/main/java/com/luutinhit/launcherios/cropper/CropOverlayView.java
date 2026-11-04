package com.luutinhit.launcherios.cropper;

import J0.C0489j;
import S3.AbstractC0995f;
import S3.C0998i;
import S3.C1008s;
import S3.C1009t;
import S3.C1010u;
import S3.EnumC0999j;
import S3.EnumC1000k;
import S3.InterfaceC1007r;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import java.util.Arrays;
import p044w.AbstractC2920f;

/* JADX INFO: loaded from: classes.dex */
public class CropOverlayView extends View {

    /* JADX INFO: renamed from: A */
    public float f17494A;

    /* JADX INFO: renamed from: B */
    public float f17495B;

    /* JADX INFO: renamed from: C */
    public C1010u f17496C;

    /* JADX INFO: renamed from: D */
    public boolean f17497D;

    /* JADX INFO: renamed from: E */
    public int f17498E;

    /* JADX INFO: renamed from: F */
    public int f17499F;

    /* JADX INFO: renamed from: G */
    public float f17500G;

    /* JADX INFO: renamed from: H */
    public EnumC1000k f17501H;

    /* JADX INFO: renamed from: I */
    public EnumC0999j f17502I;

    /* JADX INFO: renamed from: J */
    public Rect f17503J;

    /* JADX INFO: renamed from: K */
    public boolean f17504K;

    /* JADX INFO: renamed from: L */
    public float f17505L;

    /* JADX INFO: renamed from: j */
    public ScaleGestureDetector f17506j;

    /* JADX INFO: renamed from: k */
    public boolean f17507k;

    /* JADX INFO: renamed from: l */
    public C1009t f17508l;

    /* JADX INFO: renamed from: m */
    public InterfaceC1007r f17509m;

    /* JADX INFO: renamed from: n */
    public RectF f17510n;

    /* JADX INFO: renamed from: o */
    public Paint f17511o;

    /* JADX INFO: renamed from: p */
    public Paint f17512p;

    /* JADX INFO: renamed from: q */
    public Paint f17513q;

    /* JADX INFO: renamed from: r */
    public Paint f17514r;

    /* JADX INFO: renamed from: s */
    public Path f17515s;

    /* JADX INFO: renamed from: t */
    public float[] f17516t;

    /* JADX INFO: renamed from: u */
    public RectF f17517u;

    /* JADX INFO: renamed from: v */
    public int f17518v;

    /* JADX INFO: renamed from: w */
    public int f17519w;

    /* JADX INFO: renamed from: x */
    public float f17520x;

    /* JADX INFO: renamed from: y */
    public float f17521y;

    /* JADX INFO: renamed from: z */
    public float f17522z;

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17508l = new C1009t();
        this.f17510n = new RectF();
        this.f17515s = new Path();
        this.f17516t = new float[8];
        this.f17517u = new RectF();
        this.f17499F = 1;
        this.f17500G = this.f17498E / 1;
        this.f17503J = new Rect();
    }

    /* JADX INFO: renamed from: e */
    public static Paint m8322e(int i6, float f6) {
        if (f6 <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i6);
        paint.setStrokeWidth(f6);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8323a(RectF rectF) {
        float f6;
        float f7;
        float[] fArr = this.f17516t;
        float fM2056o = AbstractC0995f.m2056o(fArr);
        float fM2058q = AbstractC0995f.m2058q(fArr);
        float fM2057p = AbstractC0995f.m2057p(fArr);
        float fM2054m = AbstractC0995f.m2054m(fArr);
        boolean z5 = (fArr[0] == fArr[6] || fArr[1] == fArr[7]) ? false : true;
        RectF rectF2 = this.f17517u;
        if (!z5) {
            rectF2.set(fM2056o, fM2058q, fM2057p, fM2054m);
            return false;
        }
        float f8 = fArr[0];
        float f9 = fArr[1];
        float f10 = fArr[4];
        float f11 = fArr[5];
        float f12 = fArr[6];
        float f13 = fArr[7];
        if (f13 < f9) {
            f7 = fArr[3];
            if (f9 < f7) {
                float f14 = fArr[2];
                f6 = f12;
                f9 = f11;
                f12 = f14;
                f11 = f13;
                f8 = f10;
            } else {
                f7 = f9;
                f9 = f7;
                f12 = f8;
                f8 = fArr[2];
                f6 = f10;
            }
        } else {
            float f15 = fArr[3];
            if (f9 > f15) {
                f6 = fArr[2];
                f11 = f15;
                f7 = f13;
            } else {
                f6 = f8;
                f8 = f12;
                f12 = f10;
                f7 = f11;
                f11 = f9;
                f9 = f13;
            }
        }
        float f16 = (f9 - f11) / (f8 - f6);
        float f17 = (-1.0f) / f16;
        float f18 = f11 - (f16 * f6);
        float f19 = f11 - (f6 * f17);
        float f20 = f7 - (f16 * f12);
        float f21 = f7 - (f12 * f17);
        float fCenterY = rectF.centerY() - rectF.top;
        float fCenterX = rectF.centerX();
        float f22 = rectF.left;
        float f23 = fCenterY / (fCenterX - f22);
        float f24 = -f23;
        float f25 = rectF.top;
        float f26 = f25 - (f22 * f23);
        float f27 = rectF.right;
        float f28 = f25 - (f24 * f27);
        float f29 = f16 - f23;
        float f30 = (f26 - f18) / f29;
        float fMax = Math.max(fM2056o, f30 < f27 ? f30 : fM2056o);
        float f31 = (f26 - f19) / (f17 - f23);
        if (f31 >= rectF.right) {
            f31 = fMax;
        }
        float fMax2 = Math.max(fMax, f31);
        float f32 = f17 - f24;
        float f33 = (f28 - f21) / f32;
        if (f33 >= rectF.right) {
            f33 = fMax2;
        }
        float fMax3 = Math.max(fMax2, f33);
        float f34 = (f28 - f19) / f32;
        if (f34 <= rectF.left) {
            f34 = fM2057p;
        }
        float fMin = Math.min(fM2057p, f34);
        float f35 = (f28 - f20) / (f16 - f24);
        float fMin2 = Math.min(fMin, f35 > rectF.left ? f35 : fMin);
        float f36 = (f26 - f20) / f29;
        if (f36 <= rectF.left) {
            f36 = fMin2;
        }
        float fMin3 = Math.min(fMin2, f36);
        float fMax4 = Math.max(fM2058q, Math.max((f16 * fMax3) + f18, (f17 * fMin3) + f19));
        float fMin4 = Math.min(fM2054m, Math.min((f17 * fMax3) + f21, (f16 * fMin3) + f20));
        rectF2.left = fMax3;
        rectF2.top = fMax4;
        rectF2.right = fMin3;
        rectF2.bottom = fMin4;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final void m8324b(boolean z5) {
        try {
            InterfaceC1007r interfaceC1007r = this.f17509m;
            if (interfaceC1007r != null) {
                int i6 = CropImageView.f17458S;
                ((CropImageView) ((C0489j) interfaceC1007r).f1511k).m8315c(z5, true);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8325c(Canvas canvas) {
        if (this.f17513q != null) {
            Paint paint = this.f17511o;
            float strokeWidth = paint != null ? paint.getStrokeWidth() : 0.0f;
            RectF rectFM2062a = this.f17508l.m2062a();
            rectFM2062a.inset(strokeWidth, strokeWidth);
            float fWidth = rectFM2062a.width() / 3.0f;
            float fHeight = rectFM2062a.height() / 3.0f;
            if (this.f17502I != EnumC0999j.f2907k) {
                float f6 = rectFM2062a.left + fWidth;
                float f7 = rectFM2062a.right - fWidth;
                canvas.drawLine(f6, rectFM2062a.top, f6, rectFM2062a.bottom, this.f17513q);
                canvas.drawLine(f7, rectFM2062a.top, f7, rectFM2062a.bottom, this.f17513q);
                float f8 = rectFM2062a.top + fHeight;
                float f9 = rectFM2062a.bottom - fHeight;
                canvas.drawLine(rectFM2062a.left, f8, rectFM2062a.right, f8, this.f17513q);
                canvas.drawLine(rectFM2062a.left, f9, rectFM2062a.right, f9, this.f17513q);
                return;
            }
            float fWidth2 = (rectFM2062a.width() / 2.0f) - strokeWidth;
            float fHeight2 = (rectFM2062a.height() / 2.0f) - strokeWidth;
            float f10 = rectFM2062a.left + fWidth;
            float f11 = rectFM2062a.right - fWidth;
            float fSin = (float) (Math.sin(Math.acos((fWidth2 - fWidth) / fWidth2)) * ((double) fHeight2));
            canvas.drawLine(f10, (rectFM2062a.top + fHeight2) - fSin, f10, (rectFM2062a.bottom - fHeight2) + fSin, this.f17513q);
            canvas.drawLine(f11, (rectFM2062a.top + fHeight2) - fSin, f11, (rectFM2062a.bottom - fHeight2) + fSin, this.f17513q);
            float f12 = rectFM2062a.top + fHeight;
            float f13 = rectFM2062a.bottom - fHeight;
            float fCos = (float) (Math.cos(Math.asin((fHeight2 - fHeight) / fHeight2)) * ((double) fWidth2));
            canvas.drawLine((rectFM2062a.left + fWidth2) - fCos, f12, (rectFM2062a.right - fWidth2) + fCos, f12, this.f17513q);
            canvas.drawLine((rectFM2062a.left + fWidth2) - fCos, f13, (rectFM2062a.right - fWidth2) + fCos, f13, this.f17513q);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8326d(RectF rectF) {
        float fWidth = rectF.width();
        C1009t c1009t = this.f17508l;
        if (fWidth < Math.max(c1009t.f2918c, c1009t.f2922g / c1009t.f2926k)) {
            float fMax = (Math.max(c1009t.f2918c, c1009t.f2922g / c1009t.f2926k) - rectF.width()) / 2.0f;
            rectF.left -= fMax;
            rectF.right += fMax;
        }
        if (rectF.height() < Math.max(c1009t.f2919d, c1009t.f2923h / c1009t.f2927l)) {
            float fMax2 = (Math.max(c1009t.f2919d, c1009t.f2923h / c1009t.f2927l) - rectF.height()) / 2.0f;
            rectF.top -= fMax2;
            rectF.bottom += fMax2;
        }
        if (rectF.width() > Math.min(c1009t.f2920e, c1009t.f2924i / c1009t.f2926k)) {
            float fWidth2 = (rectF.width() - Math.min(c1009t.f2920e, c1009t.f2924i / c1009t.f2926k)) / 2.0f;
            rectF.left += fWidth2;
            rectF.right -= fWidth2;
        }
        if (rectF.height() > Math.min(c1009t.f2921f, c1009t.f2925j / c1009t.f2927l)) {
            float fHeight = (rectF.height() - Math.min(c1009t.f2921f, c1009t.f2925j / c1009t.f2927l)) / 2.0f;
            rectF.top += fHeight;
            rectF.bottom -= fHeight;
        }
        m8323a(rectF);
        RectF rectF2 = this.f17517u;
        if (rectF2.width() > 0.0f && rectF2.height() > 0.0f) {
            float fMax3 = Math.max(rectF2.left, 0.0f);
            float fMax4 = Math.max(rectF2.top, 0.0f);
            float fMin = Math.min(rectF2.right, getWidth());
            float fMin2 = Math.min(rectF2.bottom, getHeight());
            if (rectF.left < fMax3) {
                rectF.left = fMax3;
            }
            if (rectF.top < fMax4) {
                rectF.top = fMax4;
            }
            if (rectF.right > fMin) {
                rectF.right = fMin;
            }
            if (rectF.bottom > fMin2) {
                rectF.bottom = fMin2;
            }
        }
        if (!this.f17497D || Math.abs(rectF.width() - (rectF.height() * this.f17500G)) <= 0.1d) {
            return;
        }
        if (rectF.width() > rectF.height() * this.f17500G) {
            float fAbs = Math.abs((rectF.height() * this.f17500G) - rectF.width()) / 2.0f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        } else {
            float fAbs2 = Math.abs((rectF.width() / this.f17500G) - rectF.height()) / 2.0f;
            rectF.top += fAbs2;
            rectF.bottom -= fAbs2;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m8327f() {
        float[] fArr = this.f17516t;
        float fMax = Math.max(AbstractC0995f.m2056o(fArr), 0.0f);
        float fMax2 = Math.max(AbstractC0995f.m2058q(fArr), 0.0f);
        float fMin = Math.min(AbstractC0995f.m2057p(fArr), getWidth());
        float fMin2 = Math.min(AbstractC0995f.m2054m(fArr), getHeight());
        if (fMin <= fMax || fMin2 <= fMax2) {
            return;
        }
        RectF rectF = new RectF();
        this.f17504K = true;
        float f6 = this.f17522z;
        float f7 = fMin - fMax;
        float f8 = f6 * f7;
        float f9 = fMin2 - fMax2;
        float f10 = f6 * f9;
        Rect rect = this.f17503J;
        int iWidth = rect.width();
        C1009t c1009t = this.f17508l;
        if (iWidth > 0 && rect.height() > 0) {
            float f11 = (rect.left / c1009t.f2926k) + fMax;
            rectF.left = f11;
            rectF.top = (rect.top / c1009t.f2927l) + fMax2;
            rectF.right = (rect.width() / c1009t.f2926k) + f11;
            rectF.bottom = (rect.height() / c1009t.f2927l) + rectF.top;
            rectF.left = Math.max(fMax, rectF.left);
            rectF.top = Math.max(fMax2, rectF.top);
            rectF.right = Math.min(fMin, rectF.right);
            rectF.bottom = Math.min(fMin2, rectF.bottom);
        } else if (!this.f17497D || fMin <= fMax || fMin2 <= fMax2) {
            rectF.left = fMax + f8;
            rectF.top = fMax2 + f10;
            rectF.right = fMin - f8;
            rectF.bottom = fMin2 - f10;
        } else if (f7 / f9 > this.f17500G) {
            rectF.top = fMax2 + f10;
            rectF.bottom = fMin2 - f10;
            float width = getWidth() / 2.0f;
            this.f17500G = this.f17498E / this.f17499F;
            float fMax3 = Math.max(Math.max(c1009t.f2918c, c1009t.f2922g / c1009t.f2926k), rectF.height() * this.f17500G) / 2.0f;
            rectF.left = width - fMax3;
            rectF.right = width + fMax3;
        } else {
            rectF.left = fMax + f8;
            rectF.right = fMin - f8;
            float height = getHeight() / 2.0f;
            float fMax4 = Math.max(Math.max(c1009t.f2919d, c1009t.f2923h / c1009t.f2927l), rectF.width() / this.f17500G) / 2.0f;
            rectF.top = height - fMax4;
            rectF.bottom = height + fMax4;
        }
        m8326d(rectF);
        c1009t.f2916a.set(rectF);
    }

    /* JADX INFO: renamed from: g */
    public final void m8328g() {
        if (this.f17504K) {
            setCropWindowRect(AbstractC0995f.f2838b);
            m8327f();
            invalidate();
        }
    }

    public int getAspectRatioX() {
        return this.f17498E;
    }

    public int getAspectRatioY() {
        return this.f17499F;
    }

    public EnumC0999j getCropShape() {
        return this.f17502I;
    }

    public RectF getCropWindowRect() {
        return this.f17508l.m2062a();
    }

    public EnumC1000k getGuidelines() {
        return this.f17501H;
    }

    public Rect getInitialCropWindowRect() {
        return this.f17503J;
    }

    /* JADX INFO: renamed from: h */
    public final void m8329h(float[] fArr, int i6, int i7) {
        float[] fArr2 = this.f17516t;
        if (fArr == null || !Arrays.equals(fArr2, fArr)) {
            if (fArr == null) {
                Arrays.fill(fArr2, 0.0f);
            } else {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            }
            this.f17518v = i6;
            this.f17519w = i7;
            RectF rectFM2062a = this.f17508l.m2062a();
            if (rectFM2062a.width() == 0.0f || rectFM2062a.height() == 0.0f) {
                m8327f();
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final boolean m8330i(boolean z5) {
        if (this.f17507k == z5) {
            return false;
        }
        this.f17507k = z5;
        if (!z5 || this.f17506j != null) {
            return true;
        }
        this.f17506j = new ScaleGestureDetector(getContext(), new C1008s(this));
        return true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        C1009t c1009t = this.f17508l;
        RectF rectFM2062a = c1009t.m2062a();
        float[] fArr = this.f17516t;
        float fMax = Math.max(AbstractC0995f.m2056o(fArr), 0.0f);
        float fMax2 = Math.max(AbstractC0995f.m2058q(fArr), 0.0f);
        float fMin = Math.min(AbstractC0995f.m2057p(fArr), getWidth());
        float fMin2 = Math.min(AbstractC0995f.m2054m(fArr), getHeight());
        EnumC0999j enumC0999j = this.f17502I;
        EnumC0999j enumC0999j2 = EnumC0999j.f2906j;
        Path path = this.f17515s;
        if (enumC0999j != enumC0999j2) {
            path.reset();
            int i6 = Build.VERSION.SDK_INT;
            RectF rectF = this.f17510n;
            rectF.set(rectFM2062a.left, rectFM2062a.top, rectFM2062a.right, rectFM2062a.bottom);
            float fAbs = Math.abs(rectFM2062a.right - rectFM2062a.left) * this.f17505L;
            path.addRoundRect(rectF, fAbs, fAbs, Path.Direction.CW);
            canvas2.save();
            if (i6 >= 26) {
                canvas2.clipOutPath(path);
            } else {
                canvas2.clipPath(path, Region.Op.XOR);
            }
            canvas2.drawRect(fMax, fMax2, fMin, fMin2, this.f17514r);
            canvas2.restore();
        } else if (fArr[0] == fArr[6] || fArr[1] == fArr[7]) {
            canvas2 = canvas;
            canvas2.drawRect(fMax, fMax2, fMin, rectFM2062a.top, this.f17514r);
            canvas2.drawRect(fMax, rectFM2062a.bottom, fMin, fMin2, this.f17514r);
            canvas2.drawRect(fMax, rectFM2062a.top, rectFM2062a.left, rectFM2062a.bottom, this.f17514r);
            canvas2.drawRect(rectFM2062a.right, rectFM2062a.top, fMin, rectFM2062a.bottom, this.f17514r);
        } else {
            int i7 = Build.VERSION.SDK_INT;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.close();
            canvas2.save();
            if (i7 >= 26) {
                canvas2.clipOutPath(path);
            } else {
                canvas2.clipPath(path, Region.Op.INTERSECT);
            }
            canvas2.clipRect(rectFM2062a, Region.Op.XOR);
            canvas2.drawRect(fMax, fMax2, fMin, fMin2, this.f17514r);
            canvas.restore();
            canvas2 = canvas;
        }
        RectF rectF2 = c1009t.f2916a;
        if (rectF2.width() >= 100.0f && rectF2.height() >= 100.0f) {
            EnumC1000k enumC1000k = this.f17501H;
            if (enumC1000k == EnumC1000k.f2910k) {
                m8325c(canvas);
            } else if (enumC1000k == EnumC1000k.f2909j && this.f17496C != null) {
                m8325c(canvas);
            }
        }
        Paint paint = this.f17511o;
        if (paint != null) {
            float strokeWidth = paint.getStrokeWidth();
            RectF rectFM2062a2 = c1009t.m2062a();
            float f6 = strokeWidth / 2.0f;
            rectFM2062a2.inset(f6, f6);
            if (this.f17502I == enumC0999j2) {
                canvas2.drawRect(rectFM2062a2, this.f17511o);
            } else {
                float fAbs2 = Math.abs(rectFM2062a2.right - rectFM2062a2.left) * this.f17505L;
                canvas2.drawRoundRect(rectFM2062a2, fAbs2, fAbs2, this.f17511o);
            }
        }
        if (this.f17512p != null) {
            Paint paint2 = this.f17511o;
            float strokeWidth2 = paint2 != null ? paint2.getStrokeWidth() : 0.0f;
            float strokeWidth3 = this.f17512p.getStrokeWidth();
            float f7 = strokeWidth3 / 2.0f;
            float f8 = (this.f17502I == enumC0999j2 ? this.f17520x : 0.0f) + f7;
            RectF rectFM2062a3 = c1009t.m2062a();
            rectFM2062a3.inset(f8, f8);
            float f9 = (strokeWidth3 - strokeWidth2) / 2.0f;
            float f10 = f7 + f9;
            float f11 = rectFM2062a3.left - f9;
            float f12 = rectFM2062a3.top;
            canvas2.drawLine(f11, f12 - f10, f11, this.f17521y + f12, this.f17512p);
            float f13 = rectFM2062a3.left;
            float f14 = rectFM2062a3.top - f9;
            canvas.drawLine(f13 - f10, f14, this.f17521y + f13, f14, this.f17512p);
            float f15 = rectFM2062a3.right + f9;
            float f16 = rectFM2062a3.top;
            canvas.drawLine(f15, f16 - f10, f15, f16 + this.f17521y, this.f17512p);
            float f17 = rectFM2062a3.right;
            float f18 = rectFM2062a3.top - f9;
            canvas.drawLine(f17 + f10, f18, f17 - this.f17521y, f18, this.f17512p);
            float f19 = rectFM2062a3.left - f9;
            float f20 = rectFM2062a3.bottom;
            canvas.drawLine(f19, f20 + f10, f19, f20 - this.f17521y, this.f17512p);
            float f21 = rectFM2062a3.left;
            float f22 = rectFM2062a3.bottom + f9;
            canvas.drawLine(f21 - f10, f22, this.f17521y + f21, f22, this.f17512p);
            float f23 = rectFM2062a3.right + f9;
            float f24 = rectFM2062a3.bottom;
            canvas.drawLine(f23, f24 + f10, f23, f24 - this.f17521y, this.f17512p);
            float f25 = rectFM2062a3.right;
            float f26 = rectFM2062a3.bottom + f9;
            canvas.drawLine(f25 + f10, f26, f25 - this.f17521y, f26, this.f17512p);
        }
    }

    /* JADX WARN: Code duplicated, block: B:150:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:151:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:158:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:160:0x0409  */
    /* JADX WARN: Code duplicated, block: B:165:0x041a  */
    /* JADX WARN: Code duplicated, block: B:167:0x042a  */
    /* JADX WARN: Code duplicated, block: B:172:0x0434  */
    /* JADX WARN: Code duplicated, block: B:174:0x0444  */
    /* JADX WARN: Code duplicated, block: B:179:0x044e  */
    /* JADX WARN: Code duplicated, block: B:181:0x045a  */
    /* JADX WARN: Code duplicated, block: B:189:0x046e  */
    /* JADX WARN: Code duplicated, block: B:192:0x0478  */
    /* JADX WARN: Code duplicated, block: B:31:0x0091  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        MotionEvent motionEvent2;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        int i6;
        boolean z5;
        boolean z6;
        if (!isEnabled()) {
            return false;
        }
        if (this.f17507k) {
            motionEvent2 = motionEvent;
            this.f17506j.onTouchEvent(motionEvent2);
        } else {
            motionEvent2 = motionEvent;
        }
        int action = motionEvent2.getAction();
        int i7 = 3;
        C1009t c1009t = this.f17508l;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x6 = motionEvent2.getX();
                    float y4 = motionEvent2.getY();
                    if (this.f17496C != null) {
                        float f11 = this.f17495B;
                        RectF rectFM2062a = c1009t.m2062a();
                        float f12 = m8323a(rectFM2062a) ? 0.0f : f11;
                        C1010u c1010u = this.f17496C;
                        RectF rectF = this.f17517u;
                        float f13 = f12;
                        int i8 = this.f17518v;
                        int i9 = this.f17519w;
                        boolean z7 = this.f17497D;
                        float f14 = this.f17500G;
                        PointF pointF = c1010u.f2933f;
                        float f15 = x6 + pointF.x;
                        float f16 = y4 + pointF.y;
                        int i10 = c1010u.f2932e;
                        if (i10 == 9) {
                            float fCenterX = f15 - rectFM2062a.centerX();
                            float fCenterY = f16 - rectFM2062a.centerY();
                            float f17 = rectFM2062a.left + fCenterX;
                            if (f17 >= 0.0f) {
                                float f18 = rectFM2062a.right + fCenterX;
                                if (f18 > i8 || f17 < rectF.left || f18 > rectF.right) {
                                    fCenterX /= 1.05f;
                                    pointF.x -= fCenterX / 2.0f;
                                }
                            } else {
                                fCenterX /= 1.05f;
                                pointF.x -= fCenterX / 2.0f;
                            }
                            float f19 = rectFM2062a.top + fCenterY;
                            if (f19 >= 0.0f) {
                                float f20 = rectFM2062a.bottom + fCenterY;
                                if (f20 > i9 || f19 < rectF.top || f20 > rectF.bottom) {
                                    fCenterY /= 1.05f;
                                    pointF.y -= fCenterY / 2.0f;
                                }
                            } else {
                                fCenterY /= 1.05f;
                                pointF.y -= fCenterY / 2.0f;
                            }
                            rectFM2062a.offset(fCenterX, fCenterY);
                            float f21 = rectFM2062a.left;
                            float f22 = rectF.left;
                            if (f21 < f22 + f13) {
                                rectFM2062a.offset(f22 - f21, 0.0f);
                            }
                            float f23 = rectFM2062a.top;
                            float f24 = rectF.top;
                            if (f23 < f24 + f13) {
                                rectFM2062a.offset(0.0f, f24 - f23);
                            }
                            float f25 = rectFM2062a.right;
                            float f26 = rectF.right;
                            if (f25 > f26 - f13) {
                                rectFM2062a.offset(f26 - f25, 0.0f);
                            }
                            float f27 = rectFM2062a.bottom;
                            float f28 = rectF.bottom;
                            if (f27 > f28 - f13) {
                                rectFM2062a.offset(0.0f, f28 - f27);
                            }
                        } else if (z7) {
                            switch (AbstractC2920f.m10113b(i10)) {
                                case 0:
                                    if ((rectFM2062a.right - f15) / (rectFM2062a.bottom - f16) >= f14) {
                                        c1010u.m2066b(rectFM2062a, f15, rectF, f13, f14, true, false);
                                        rectFM2062a.top = rectFM2062a.bottom - (rectFM2062a.width() / f14);
                                    } else {
                                        c1010u.m2068e(rectFM2062a, f16, rectF, f13, f14, true, false);
                                        rectFM2062a.left = rectFM2062a.right - (rectFM2062a.height() * f14);
                                    }
                                    break;
                                case 1:
                                    if ((f15 - rectFM2062a.left) / (rectFM2062a.bottom - f16) >= f14) {
                                        c1010u.m2067d(rectFM2062a, f15, rectF, i8, f13, f14, true, false);
                                        rectFM2062a.top = rectFM2062a.bottom - (rectFM2062a.width() / f14);
                                    } else {
                                        c1010u.m2068e(rectFM2062a, f16, rectF, f13, f14, false, true);
                                        rectFM2062a.right = (rectFM2062a.height() * f14) + rectFM2062a.left;
                                    }
                                    break;
                                case 2:
                                    if ((rectFM2062a.right - f15) / (f16 - rectFM2062a.top) >= f14) {
                                        c1010u.m2066b(rectFM2062a, f15, rectF, f13, f14, false, true);
                                        rectFM2062a.bottom = (rectFM2062a.width() / f14) + rectFM2062a.top;
                                    } else {
                                        c1010u.m2065a(rectFM2062a, f16, rectF, i9, f13, f14, true, false);
                                        rectFM2062a.left = rectFM2062a.right - (rectFM2062a.height() * f14);
                                    }
                                    break;
                                case 3:
                                    if ((f15 - rectFM2062a.left) / (f16 - rectFM2062a.top) >= f14) {
                                        c1010u.m2067d(rectFM2062a, f15, rectF, i8, f13, f14, false, true);
                                        rectFM2062a.bottom = (rectFM2062a.width() / f14) + rectFM2062a.top;
                                    } else {
                                        c1010u.m2065a(rectFM2062a, f16, rectF, i9, f13, f14, false, true);
                                        rectFM2062a.right = (rectFM2062a.height() * f14) + rectFM2062a.left;
                                    }
                                    break;
                                case 4:
                                    c1010u.m2066b(rectFM2062a, f15, rectF, f13, f14, true, true);
                                    C1010u.m2064f(rectFM2062a, rectF, f14);
                                    break;
                                case 5:
                                    c1010u.m2068e(rectFM2062a, f16, rectF, f13, f14, true, true);
                                    C1010u.m2063c(rectFM2062a, rectF, f14);
                                    break;
                                case 6:
                                    c1010u.m2067d(rectFM2062a, f15, rectF, i8, f13, f14, true, true);
                                    C1010u.m2064f(rectFM2062a, rectF, f14);
                                    break;
                                case 7:
                                    c1010u.m2065a(rectFM2062a, f16, rectF, i9, f13, f14, true, true);
                                    C1010u.m2063c(rectFM2062a, rectF, f14);
                                    break;
                            }
                        } else {
                            switch (AbstractC2920f.m10113b(i10)) {
                                case 0:
                                    c1010u.m2068e(rectFM2062a, f16, rectF, f13, 0.0f, false, false);
                                    c1010u.m2066b(rectFM2062a, f15, rectF, f13, 0.0f, false, false);
                                    break;
                                case 1:
                                    c1010u.m2068e(rectFM2062a, f16, rectF, f13, 0.0f, false, false);
                                    c1010u.m2067d(rectFM2062a, f15, rectF, i8, f13, 0.0f, false, false);
                                    break;
                                case 2:
                                    c1010u.m2065a(rectFM2062a, f16, rectF, i9, f13, 0.0f, false, false);
                                    c1010u.m2066b(rectFM2062a, f15, rectF, f13, 0.0f, false, false);
                                    break;
                                case 3:
                                    c1010u.m2065a(rectFM2062a, f16, rectF, i9, f13, 0.0f, false, false);
                                    c1010u.m2067d(rectFM2062a, f15, rectF, i8, f13, 0.0f, false, false);
                                    break;
                                case 4:
                                    c1010u.m2066b(rectFM2062a, f15, rectF, f13, 0.0f, false, false);
                                    break;
                                case 5:
                                    c1010u.m2068e(rectFM2062a, f16, rectF, f13, 0.0f, false, false);
                                    break;
                                case 6:
                                    c1010u.m2067d(rectFM2062a, f15, rectF, i8, f13, 0.0f, false, false);
                                    break;
                                case 7:
                                    c1010u.m2065a(rectFM2062a, f16, rectF, i9, f13, 0.0f, false, false);
                                    break;
                            }
                        }
                        c1009t.f2916a.set(rectFM2062a);
                        z6 = true;
                        m8324b(true);
                        invalidate();
                    } else {
                        z6 = true;
                    }
                    getParent().requestDisallowInterceptTouchEvent(z6);
                    return z6;
                }
                if (action != 3) {
                    return false;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f17496C != null) {
                this.f17496C = null;
                m8324b(false);
                invalidate();
                return true;
            }
        } else {
            float x7 = motionEvent2.getX();
            float y5 = motionEvent2.getY();
            float f29 = this.f17494A;
            EnumC0999j enumC0999j = this.f17502I;
            EnumC0999j enumC0999j2 = EnumC0999j.f2907k;
            RectF rectF2 = c1009t.f2916a;
            if (enumC0999j == enumC0999j2) {
                float fWidth = rectF2.width() / 6.0f;
                float f30 = rectF2.left;
                float f31 = f30 + fWidth;
                float f32 = (fWidth * 5.0f) + f30;
                float fHeight = rectF2.height() / 6.0f;
                float f33 = rectF2.top;
                float f34 = f33 + fHeight;
                float f35 = (fHeight * 5.0f) + f33;
                if (x7 < f31) {
                    if (y5 < f34) {
                        i7 = 1;
                    } else if (y5 < f35) {
                        i7 = 5;
                    }
                } else if (x7 < f32) {
                    i7 = y5 < f34 ? 6 : y5 < f35 ? 9 : 8;
                } else if (y5 < f34) {
                    i7 = 2;
                } else {
                    i7 = y5 < f35 ? 7 : 4;
                }
            } else {
                if (C1009t.m2061b(x7, y5, rectF2.left, rectF2.top, f29)) {
                    i6 = 1;
                } else if (C1009t.m2061b(x7, y5, rectF2.right, rectF2.top, f29)) {
                    i6 = 2;
                } else if (C1009t.m2061b(x7, y5, rectF2.left, rectF2.bottom, f29)) {
                    i6 = 3;
                } else if (C1009t.m2061b(x7, y5, rectF2.right, rectF2.bottom, f29)) {
                    i6 = 4;
                } else {
                    float f36 = rectF2.left;
                    float f37 = rectF2.top;
                    float f38 = rectF2.right;
                    float f39 = rectF2.bottom;
                    RectF rectF3 = c1009t.f2916a;
                    if (x7 <= f36 || x7 >= f38 || y5 <= f37 || y5 >= f39) {
                        f6 = rectF2.left;
                        float f40 = rectF2.right;
                        float f41 = rectF2.top;
                        if (x7 > f6 || x7 >= f40 || Math.abs(y5 - f41) > f29) {
                            f7 = rectF2.left;
                            float f42 = rectF2.right;
                            float f43 = rectF2.bottom;
                            if (x7 > f7 || x7 >= f42 || Math.abs(y5 - f43) > f29) {
                                f8 = rectF2.left;
                                float f44 = rectF2.top;
                                float f45 = rectF2.bottom;
                                if (Math.abs(x7 - f8) <= f29 || y5 <= f44 || y5 >= f45) {
                                    f9 = rectF2.right;
                                    float f46 = rectF2.top;
                                    float f47 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29 || y5 <= f46 || y5 >= f47) {
                                        f10 = rectF2.left;
                                        float f48 = rectF2.top;
                                        float f49 = rectF2.right;
                                        float f50 = rectF2.bottom;
                                        if (x7 > f10 && x7 < f49 && y5 > f48 && y5 < f50) {
                                            if (rectF3.width() >= 100.0f || rectF3.height() < 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = true;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        i6 = 7;
                                    }
                                } else {
                                    i6 = 5;
                                }
                            } else {
                                i6 = 8;
                            }
                        } else {
                            i6 = 6;
                        }
                    } else if (rectF3.width() >= 100.0f && rectF3.height() >= 100.0f) {
                        f6 = rectF2.left;
                        float f410 = rectF2.right;
                        float f411 = rectF2.top;
                        if (x7 > f6) {
                            f7 = rectF2.left;
                            float f412 = rectF2.right;
                            float f413 = rectF2.bottom;
                            if (x7 > f7) {
                                f8 = rectF2.left;
                                float f414 = rectF2.top;
                                float f415 = rectF2.bottom;
                                if (Math.abs(x7 - f8) <= f29) {
                                    f9 = rectF2.right;
                                    float f416 = rectF2.top;
                                    float f417 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f418 = rectF2.top;
                                        float f419 = rectF2.right;
                                        float f51 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f4110 = rectF2.top;
                                        float f4111 = rectF2.right;
                                        float f52 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                } else {
                                    f9 = rectF2.right;
                                    float f4112 = rectF2.top;
                                    float f4113 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f4114 = rectF2.top;
                                        float f4115 = rectF2.right;
                                        float f53 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f4116 = rectF2.top;
                                        float f4117 = rectF2.right;
                                        float f54 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                }
                            } else {
                                f8 = rectF2.left;
                                float f4118 = rectF2.top;
                                float f4119 = rectF2.bottom;
                                if (Math.abs(x7 - f8) <= f29) {
                                    f9 = rectF2.right;
                                    float f41110 = rectF2.top;
                                    float f41111 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f41112 = rectF2.top;
                                        float f41113 = rectF2.right;
                                        float f55 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f41114 = rectF2.top;
                                        float f41115 = rectF2.right;
                                        float f56 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                } else {
                                    f9 = rectF2.right;
                                    float f41116 = rectF2.top;
                                    float f41117 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f41118 = rectF2.top;
                                        float f41119 = rectF2.right;
                                        float f57 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f411110 = rectF2.top;
                                        float f411111 = rectF2.right;
                                        float f58 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                }
                            }
                        } else {
                            f7 = rectF2.left;
                            float f4120 = rectF2.right;
                            float f4121 = rectF2.bottom;
                            if (x7 > f7) {
                                f8 = rectF2.left;
                                float f41120 = rectF2.top;
                                float f41121 = rectF2.bottom;
                                if (Math.abs(x7 - f8) <= f29) {
                                    f9 = rectF2.right;
                                    float f411112 = rectF2.top;
                                    float f411113 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f411114 = rectF2.top;
                                        float f411115 = rectF2.right;
                                        float f59 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f411116 = rectF2.top;
                                        float f411117 = rectF2.right;
                                        float f510 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                } else {
                                    f9 = rectF2.right;
                                    float f411118 = rectF2.top;
                                    float f411119 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f4111110 = rectF2.top;
                                        float f4111111 = rectF2.right;
                                        float f511 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f4111112 = rectF2.top;
                                        float f4111113 = rectF2.right;
                                        float f512 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                }
                            } else {
                                f8 = rectF2.left;
                                float f41122 = rectF2.top;
                                float f41123 = rectF2.bottom;
                                if (Math.abs(x7 - f8) <= f29) {
                                    f9 = rectF2.right;
                                    float f4111114 = rectF2.top;
                                    float f4111115 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f4111116 = rectF2.top;
                                        float f4111117 = rectF2.right;
                                        float f513 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f4111118 = rectF2.top;
                                        float f4111119 = rectF2.right;
                                        float f514 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                } else {
                                    f9 = rectF2.right;
                                    float f41111110 = rectF2.top;
                                    float f41111111 = rectF2.bottom;
                                    if (Math.abs(x7 - f9) <= f29) {
                                        f10 = rectF2.left;
                                        float f41111112 = rectF2.top;
                                        float f41111113 = rectF2.right;
                                        float f515 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    } else {
                                        f10 = rectF2.left;
                                        float f41111114 = rectF2.top;
                                        float f41111115 = rectF2.right;
                                        float f516 = rectF2.bottom;
                                        if (x7 > f10) {
                                            if (rectF3.width() >= 100.0f) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            if (z5) {
                                                i6 = 9;
                                            }
                                        }
                                        i6 = 0;
                                    }
                                }
                            }
                        }
                    } else {
                        i6 = 9;
                    }
                }
                i7 = i6;
            }
            C1010u c1010u2 = i7 != 0 ? new C1010u(i7, c1009t, x7, y5) : null;
            this.f17496C = c1010u2;
            if (c1010u2 != null) {
                invalidate();
                return true;
            }
        }
        return true;
    }

    public void setAspectRatioX(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f17498E != i6) {
            this.f17498E = i6;
            this.f17500G = i6 / this.f17499F;
            if (this.f17504K) {
                m8327f();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        }
        if (this.f17499F != i6) {
            this.f17499F = i6;
            this.f17500G = this.f17498E / i6;
            if (this.f17504K) {
                m8327f();
                invalidate();
            }
        }
    }

    public void setCornerPercent(float f6) {
        this.f17505L = f6;
    }

    public void setCropShape(EnumC0999j enumC0999j) {
        if (this.f17502I != enumC0999j) {
            this.f17502I = enumC0999j;
            invalidate();
        }
    }

    public void setCropWindowChangeListener(InterfaceC1007r interfaceC1007r) {
        this.f17509m = interfaceC1007r;
    }

    public void setCropWindowRect(RectF rectF) {
        this.f17508l.f2916a.set(rectF);
    }

    public void setFixedAspectRatio(boolean z5) {
        if (this.f17497D != z5) {
            this.f17497D = z5;
            if (this.f17504K) {
                m8327f();
                invalidate();
            }
        }
    }

    public void setGuidelines(EnumC1000k enumC1000k) {
        if (this.f17501H != enumC1000k) {
            this.f17501H = enumC1000k;
            if (this.f17504K) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(C0998i c0998i) {
        C1009t c1009t = this.f17508l;
        c1009t.getClass();
        c1009t.f2918c = c0998i.f2870H;
        c1009t.f2919d = c0998i.f2871I;
        c1009t.f2922g = c0998i.f2872J;
        c1009t.f2923h = c0998i.f2873K;
        c1009t.f2924i = c0998i.f2874L;
        c1009t.f2925j = c0998i.f2875M;
        setCornerPercent(c0998i.f2890k);
        setCropShape(c0998i.f2889j);
        setSnapRadius(c0998i.f2891l);
        setGuidelines(c0998i.f2893n);
        setFixedAspectRatio(c0998i.f2901v);
        setAspectRatioX(c0998i.f2902w);
        setAspectRatioY(c0998i.f2903x);
        m8330i(c0998i.f2898s);
        this.f17494A = c0998i.f2892m;
        this.f17522z = c0998i.f2900u;
        this.f17511o = m8322e(c0998i.f2905z, c0998i.f2904y);
        this.f17520x = c0998i.f2864B;
        this.f17521y = c0998i.f2865C;
        this.f17512p = m8322e(c0998i.f2866D, c0998i.f2863A);
        this.f17513q = m8322e(c0998i.f2868F, c0998i.f2867E);
        int i6 = c0998i.f2869G;
        Paint paint = new Paint();
        paint.setColor(i6);
        this.f17514r = paint;
    }

    public void setInitialCropWindowRect(Rect rect) {
        if (rect == null) {
            rect = AbstractC0995f.f2837a;
        }
        this.f17503J.set(rect);
        if (this.f17504K) {
            m8327f();
            invalidate();
            m8324b(false);
        }
    }

    public void setSnapRadius(float f6) {
        this.f17495B = f6;
    }
}
