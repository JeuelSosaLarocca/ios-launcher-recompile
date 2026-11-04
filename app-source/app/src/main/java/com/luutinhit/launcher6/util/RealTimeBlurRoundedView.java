package com.luutinhit.launcher6.util;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.SweepGradient;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class RealTimeBlurRoundedView extends View {

    /* JADX INFO: renamed from: A */
    public Canvas f16945A;

    /* JADX INFO: renamed from: B */
    public Rect f16946B;

    /* JADX INFO: renamed from: C */
    public Rect f16947C;

    /* JADX INFO: renamed from: D */
    public float f16948D;

    /* JADX INFO: renamed from: E */
    public boolean f16949E;

    /* JADX INFO: renamed from: F */
    public boolean f16950F;

    /* JADX INFO: renamed from: G */
    public boolean f16951G;

    /* JADX INFO: renamed from: H */
    public boolean f16952H;

    /* JADX INFO: renamed from: I */
    public Path f16953I;

    /* JADX INFO: renamed from: J */
    public Path f16954J;

    /* JADX INFO: renamed from: K */
    public boolean f16955K;

    /* JADX INFO: renamed from: L */
    public boolean f16956L;

    /* JADX INFO: renamed from: M */
    public boolean f16957M;

    /* JADX INFO: renamed from: N */
    public float f16958N;

    /* JADX INFO: renamed from: O */
    public int[] f16959O;

    /* JADX INFO: renamed from: P */
    public float[] f16960P;

    /* JADX INFO: renamed from: Q */
    public boolean f16961Q;

    /* JADX INFO: renamed from: j */
    public Paint f16962j;

    /* JADX INFO: renamed from: k */
    public Paint f16963k;

    /* JADX INFO: renamed from: l */
    public Matrix f16964l;

    /* JADX INFO: renamed from: m */
    public int f16965m;

    /* JADX INFO: renamed from: n */
    public int f16966n;

    /* JADX INFO: renamed from: o */
    public View f16967o;

    /* JADX INFO: renamed from: p */
    public int f16968p;

    /* JADX INFO: renamed from: q */
    public int f16969q;

    /* JADX INFO: renamed from: r */
    public float f16970r;

    /* JADX INFO: renamed from: s */
    public boolean f16971s;

    /* JADX INFO: renamed from: t */
    public Bitmap f16972t;

    /* JADX INFO: renamed from: u */
    public Bitmap f16973u;

    /* JADX INFO: renamed from: v */
    public Bitmap f16974v;

    /* JADX INFO: renamed from: w */
    public Bitmap f16975w;

    /* JADX INFO: renamed from: x */
    public Bitmap f16976x;

    /* JADX INFO: renamed from: y */
    public Canvas f16977y;

    /* JADX INFO: renamed from: z */
    public Canvas f16978z;

    /* JADX WARN: Code duplicated, block: B:14:0x0086  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public RealTimeBlurRoundedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int integer;
        int integer2 = 0;
        int color = 0;
        this.f16962j = new Paint(2);
        this.f16963k = new Paint(1);
        this.f16964l = new Matrix();
        this.f16965m = 4;
        this.f16970r = 10.0f;
        this.f16946B = new Rect();
        this.f16947C = new Rect();
        this.f16948D = 0.0f;
        this.f16949E = true;
        this.f16950F = true;
        this.f16951G = true;
        this.f16952H = true;
        this.f16953I = new Path();
        this.f16954J = new Path();
        this.f16955K = false;
        this.f16956L = false;
        this.f16957M = false;
        this.f16958N = 0.0f;
        this.f16961Q = false;
        Resources resources = getResources();
        try {
            integer = resources.getInteger(R.integer.default_blur_radius);
            try {
                integer2 = resources.getInteger(R.integer.default_downsample_factor);
                try {
                    color = resources.getColor(R.color.default_overlay_color);
                } catch (Resources.NotFoundException unused) {
                    color = 0;
                }
            } catch (Resources.NotFoundException unused2) {
                integer2 = 4;
                color = 0;
                Paint.Style style = Paint.Style.STROKE;
                Paint paint = this.f16963k;
                paint.setStyle(style);
                paint.setStrokeJoin(Paint.Join.ROUND);
                paint.setStrokeCap(Paint.Cap.ROUND);
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2257u);
                    setBlurRadius(typedArrayObtainStyledAttributes.getInt(0, integer));
                    setDownSampleFactor(typedArrayObtainStyledAttributes.getInt(1, integer2));
                    setOverlayColor(typedArrayObtainStyledAttributes.getColor(2, color));
                    this.f16948D = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
                    this.f16949E = typedArrayObtainStyledAttributes.getBoolean(6, true);
                    this.f16950F = typedArrayObtainStyledAttributes.getBoolean(7, true);
                    this.f16951G = typedArrayObtainStyledAttributes.getBoolean(3, true);
                    this.f16952H = typedArrayObtainStyledAttributes.getBoolean(4, true);
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        } catch (Resources.NotFoundException unused3) {
            integer = 10;
        }
        Paint.Style style2 = Paint.Style.STROKE;
        Paint paint2 = this.f16963k;
        paint2.setStyle(style2);
        paint2.setStrokeJoin(Paint.Join.ROUND);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2257u);
            setBlurRadius(typedArrayObtainStyledAttributes2.getInt(0, integer));
            setDownSampleFactor(typedArrayObtainStyledAttributes2.getInt(1, integer2));
            setOverlayColor(typedArrayObtainStyledAttributes2.getColor(2, color));
            this.f16948D = typedArrayObtainStyledAttributes2.getDimension(5, 0.0f);
            this.f16949E = typedArrayObtainStyledAttributes2.getBoolean(6, true);
            this.f16950F = typedArrayObtainStyledAttributes2.getBoolean(7, true);
            this.f16951G = typedArrayObtainStyledAttributes2.getBoolean(3, true);
            this.f16952H = typedArrayObtainStyledAttributes2.getBoolean(4, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void buildRoundRectPath(Path path, float f6, float f7, float f8, float f9, float f10, float f11, boolean z5, boolean z6, boolean z7, boolean z8) {
        float f12;
        float f13 = f10 < 0.0f ? 0.0f : f10;
        float f14 = f11 < 0.0f ? 0.0f : f11;
        float f15 = f8 - f6;
        float f16 = f9 - f7;
        float f17 = f15 / 2.0f;
        if (f13 <= f17) {
            f17 = f13;
        }
        float f18 = f16 / 2.0f;
        float f19 = f14 > f18 ? f18 : f14;
        float f20 = f15 - (f17 * 2.0f);
        float f21 = f16 - (2.0f * f19);
        float f22 = f7 + f19;
        path.moveTo(f8, f22);
        if (z6) {
            float f23 = f8 - f17;
            path.cubicTo(f8, f22 - computeCornerCurve(f19), computeCornerCurve(f17) + f23, f7, f23, f7);
        } else {
            path.rLineTo(0.0f, -f19);
            path.rLineTo(-f17, 0.0f);
        }
        path.rLineTo(-f20, 0.0f);
        if (z5) {
            f12 = f22;
            path.cubicTo(((f8 - f17) - f20) - computeCornerCurve(f17), f7, f6, f22 - computeCornerCurve(f19), f6, f12);
        } else {
            f12 = f22;
            path.rLineTo(-f17, 0.0f);
            path.rLineTo(0.0f, f19);
        }
        path.rLineTo(0.0f, f21);
        if (z7) {
            float f24 = f6 + f17;
            path.cubicTo(f6, computeCornerCurve(f19) + f12 + f21, f24 - computeCornerCurve(f17), f9, f24, f9);
        } else {
            path.rLineTo(0.0f, f19);
            path.rLineTo(f17, 0.0f);
        }
        path.rLineTo(f20, 0.0f);
        if (z8) {
            float f25 = f9 - f19;
            path.cubicTo(f6 + f17 + f20 + computeCornerCurve(f17), f9, f8, computeCornerCurve(f19) + f25, f8, f25);
        } else {
            path.rLineTo(f17, 0.0f);
            path.rLineTo(0.0f, -f19);
        }
        path.rLineTo(0.0f, -f21);
        path.close();
    }

    /* JADX INFO: renamed from: c */
    public static float computeCornerCurve(float f6) {
        return ((f6 / 60.0f) * 3.1415927f) + (f6 / 2.0f);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:45:0x00da  */
    /* JADX WARN: Code duplicated, block: B:48:0x0110  */
    /* JADX WARN: Code duplicated, block: B:52:0x011a  */
    /* JADX WARN: Code duplicated, block: B:73:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x01fd  */
    /* JADX INFO: renamed from: b */
    public final void drawBlurredBackground(Canvas canvas) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Bitmap bitmap;
        Bitmap bitmap2;
        Matrix matrix;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6 = null;
        Bitmap bitmap7;
        if (this.f16967o != null) {
            if (this.f16970r <= 0.0f) {
                releaseBitmaps();
            } else {
                int width = getWidth();
                int height = getHeight();
                if (width > 0 && height > 0) {
                    if (this.f16977y == null || this.f16971s || this.f16968p != width || this.f16969q != height) {
                        this.f16971s = false;
                        this.f16968p = width;
                        this.f16969q = height;
                        int iMax = Math.max(1, width / this.f16965m);
                        int iMax2 = Math.max(1, height / this.f16965m);
                        int i6 = (iMax2 - (iMax2 % 4)) + 4;
                        Bitmap bitmap8 = this.f16972t;
                        if (bitmap8 != null && bitmap8.getWidth() == iMax && this.f16972t.getHeight() == i6) {
                            bitmap = this.f16976x;
                            if (bitmap == null) {
                                bitmap2 = this.f16976x;
                                if (bitmap2 != null) {
                                    this.f16976x.recycle();
                                }
                                this.f16976x = Bitmap.createBitmap(iMax, i6, Bitmap.Config.ARGB_8888);
                                this.f16945A = new Canvas(this.f16976x);
                                if (this.f16967o.getBackground() instanceof ColorDrawable) {
                                    this.f16972t.eraseColor(((ColorDrawable) this.f16967o.getBackground()).getColor());
                                } else {
                                    this.f16972t.eraseColor(0);
                                }
                                this.f16977y.save();
                                matrix = this.f16964l;
                                matrix.reset();
                                float f6 = 1.0f / this.f16965m;
                                matrix.setScale(f6, f6);
                                if (this.f16957M) {
                                    int[] iArr = new int[2];
                                    int[] iArr2 = new int[2];
                                    this.f16967o.getLocationInWindow(iArr);
                                    getLocationInWindow(iArr2);
                                    matrix.preTranslate(-(iArr2[0] - iArr[0]), -(iArr2[1] - iArr[1]));
                                }
                                this.f16977y.setMatrix(matrix);
                                this.f16967o.draw(this.f16977y);
                                this.f16977y.restore();
                                bitmap3 = this.f16974v;
                                bitmap4 = this.f16972t;
                                if (bitmap3 != null) {
                                    if (bitmap4 != null) {
                                        bitmap4 = null;
                                    } else {
                                        bitmap4 = null;
                                    }
                                }
                                if (bitmap4 != null) {
                                    Bitmap bitmapM7540a = Toolkit.f15289a.m7540a((int) Math.min(25.0f, Math.max(1.0f, this.f16970r)), bitmap4);
                                    bitmap7 = this.f16973u;
                                    if (bitmap7 != null) {
                                        this.f16973u.recycle();
                                    }
                                    this.f16973u = bitmapM7540a;
                                }
                                bitmap5 = this.f16973u;
                                if (bitmap5 != null) {
                                    bitmap6.eraseColor(0);
                                    this.f16945A.drawBitmap(this.f16973u, 0.0f, 0.0f, (Paint) null);
                                    canvas.save();
                                    canvas.translate(0.0f, 0);
                                    float f7 = this.f16965m;
                                    canvas.scale(f7, f7);
                                    canvas.drawBitmap(this.f16976x, 0.0f, 0.0f, (Paint) null);
                                    canvas.restore();
                                }
                            } else {
                                bitmap2 = this.f16976x;
                                if (bitmap2 != null) {
                                    this.f16976x.recycle();
                                }
                                this.f16976x = Bitmap.createBitmap(iMax, i6, Bitmap.Config.ARGB_8888);
                                this.f16945A = new Canvas(this.f16976x);
                                if (this.f16967o.getBackground() instanceof ColorDrawable) {
                                    this.f16972t.eraseColor(((ColorDrawable) this.f16967o.getBackground()).getColor());
                                } else {
                                    this.f16972t.eraseColor(0);
                                }
                                this.f16977y.save();
                                matrix = this.f16964l;
                                matrix.reset();
                                float f8 = 1.0f / this.f16965m;
                                matrix.setScale(f8, f8);
                                if (this.f16957M) {
                                    int[] iArr3 = new int[2];
                                    int[] iArr4 = new int[2];
                                    this.f16967o.getLocationInWindow(iArr3);
                                    getLocationInWindow(iArr4);
                                    matrix.preTranslate(-(iArr4[0] - iArr3[0]), -(iArr4[1] - iArr3[1]));
                                }
                                this.f16977y.setMatrix(matrix);
                                this.f16967o.draw(this.f16977y);
                                this.f16977y.restore();
                                bitmap3 = this.f16974v;
                                bitmap4 = this.f16972t;
                                if (bitmap3 != null) {
                                    if (bitmap4 != null) {
                                        bitmap4 = null;
                                    } else {
                                        bitmap4 = null;
                                    }
                                }
                                if (bitmap4 != null) {
                                    Bitmap bitmapM7540a2 = Toolkit.f15289a.m7540a((int) Math.min(25.0f, Math.max(1.0f, this.f16970r)), bitmap4);
                                    bitmap7 = this.f16973u;
                                    if (bitmap7 != null) {
                                        this.f16973u.recycle();
                                    }
                                    this.f16973u = bitmapM7540a2;
                                }
                                bitmap5 = this.f16973u;
                                if (bitmap5 != null) {
                                    bitmap6.eraseColor(0);
                                    this.f16945A.drawBitmap(this.f16973u, 0.0f, 0.0f, (Paint) null);
                                    canvas.save();
                                    canvas.translate(0.0f, 0);
                                    float f9 = this.f16965m;
                                    canvas.scale(f9, f9);
                                    canvas.drawBitmap(this.f16976x, 0.0f, 0.0f, (Paint) null);
                                    canvas.restore();
                                }
                            }
                        } else {
                            releaseBlurredBitmap();
                            try {
                                this.f16972t = Bitmap.createBitmap(iMax, i6, Bitmap.Config.ARGB_8888);
                                this.f16977y = new Canvas(this.f16972t);
                                bitmap = this.f16976x;
                                if (bitmap == null && bitmap.getWidth() == iMax && this.f16976x.getHeight() == i6) {
                                    if (this.f16967o.getBackground() instanceof ColorDrawable) {
                                        this.f16972t.eraseColor(((ColorDrawable) this.f16967o.getBackground()).getColor());
                                    } else {
                                        this.f16972t.eraseColor(0);
                                    }
                                    this.f16977y.save();
                                    matrix = this.f16964l;
                                    matrix.reset();
                                    float f10 = 1.0f / this.f16965m;
                                    matrix.setScale(f10, f10);
                                    if (this.f16957M) {
                                        int[] iArr5 = new int[2];
                                        int[] iArr6 = new int[2];
                                        this.f16967o.getLocationInWindow(iArr5);
                                        getLocationInWindow(iArr6);
                                        matrix.preTranslate(-(iArr6[0] - iArr5[0]), -(iArr6[1] - iArr5[1]));
                                    }
                                    this.f16977y.setMatrix(matrix);
                                    this.f16967o.draw(this.f16977y);
                                    this.f16977y.restore();
                                    bitmap3 = this.f16974v;
                                    bitmap4 = this.f16972t;
                                    if (bitmap3 != null) {
                                        if (bitmap4 != null) {
                                            bitmap4 = null;
                                        } else {
                                            bitmap4 = null;
                                        }
                                    }
                                    if (bitmap4 != null) {
                                        Bitmap bitmapM7540a3 = Toolkit.f15289a.m7540a((int) Math.min(25.0f, Math.max(1.0f, this.f16970r)), bitmap4);
                                        bitmap7 = this.f16973u;
                                        if (bitmap7 != null) {
                                            this.f16973u.recycle();
                                        }
                                        this.f16973u = bitmapM7540a3;
                                    }
                                    bitmap5 = this.f16973u;
                                    if (bitmap5 != null) {
                                        bitmap6.eraseColor(0);
                                        this.f16945A.drawBitmap(this.f16973u, 0.0f, 0.0f, (Paint) null);
                                        canvas.save();
                                        canvas.translate(0.0f, 0);
                                        float f11 = this.f16965m;
                                        canvas.scale(f11, f11);
                                        canvas.drawBitmap(this.f16976x, 0.0f, 0.0f, (Paint) null);
                                        canvas.restore();
                                    }
                                } else {
                                    bitmap2 = this.f16976x;
                                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                                        this.f16976x.recycle();
                                    }
                                    try {
                                        this.f16976x = Bitmap.createBitmap(iMax, i6, Bitmap.Config.ARGB_8888);
                                        this.f16945A = new Canvas(this.f16976x);
                                        if (this.f16967o.getBackground() instanceof ColorDrawable) {
                                            this.f16972t.eraseColor(((ColorDrawable) this.f16967o.getBackground()).getColor());
                                        } else {
                                            this.f16972t.eraseColor(0);
                                        }
                                        this.f16977y.save();
                                        matrix = this.f16964l;
                                        matrix.reset();
                                        float f12 = 1.0f / this.f16965m;
                                        matrix.setScale(f12, f12);
                                        if (this.f16957M) {
                                            int[] iArr7 = new int[2];
                                            int[] iArr8 = new int[2];
                                            this.f16967o.getLocationInWindow(iArr7);
                                            getLocationInWindow(iArr8);
                                            matrix.preTranslate(-(iArr8[0] - iArr7[0]), -(iArr8[1] - iArr7[1]));
                                        }
                                        this.f16977y.setMatrix(matrix);
                                        this.f16967o.draw(this.f16977y);
                                        this.f16977y.restore();
                                        bitmap3 = this.f16974v;
                                        bitmap4 = this.f16972t;
                                        if (bitmap3 != null && !bitmap3.isRecycled()) {
                                            if (bitmap4 != null || bitmap4.isRecycled()) {
                                                bitmap4 = null;
                                            } else {
                                                int width2 = bitmap4.getWidth();
                                                int height2 = bitmap4.getHeight();
                                                Bitmap bitmap9 = this.f16975w;
                                                if (bitmap9 == null || bitmap9.getWidth() != width2 || this.f16975w.getHeight() != height2) {
                                                    Bitmap bitmap10 = this.f16975w;
                                                    if (bitmap10 != null && !bitmap10.isRecycled()) {
                                                        this.f16975w.recycle();
                                                    }
                                                    this.f16975w = Bitmap.createBitmap(width2, height2, Bitmap.Config.ARGB_8888);
                                                    this.f16978z = new Canvas(this.f16975w);
                                                }
                                                this.f16975w.eraseColor(0);
                                                int width3 = bitmap3.getWidth();
                                                int height3 = bitmap3.getHeight();
                                                int width4 = getWidth();
                                                int height4 = getHeight();
                                                int iMax3 = Math.max(0, Math.min((int) 0.0f, width3));
                                                int iMin = Math.min(width4 + iMax3, width3);
                                                int iMin2 = Math.min(height4, height3);
                                                Rect rect = this.f16946B;
                                                rect.set(iMax3, 0, iMin, iMin2);
                                                if (rect.width() > 0 && rect.height() > 0) {
                                                    int iCeil = (int) Math.ceil(rect.width() / this.f16965m);
                                                    int iCeil2 = (int) Math.ceil(rect.height() / this.f16965m);
                                                    Rect rect2 = this.f16947C;
                                                    rect2.set(0, 0, iCeil, iCeil2);
                                                    this.f16978z.drawBitmap(bitmap3, rect, rect2, (Paint) null);
                                                    this.f16978z.drawBitmap(bitmap4, 0.0f, 0.0f, this.f16962j);
                                                    bitmap4 = this.f16975w;
                                                }
                                            }
                                        }
                                        if (bitmap4 != null && !bitmap4.isRecycled()) {
                                            try {
                                                Bitmap bitmapM7540a4 = Toolkit.f15289a.m7540a((int) Math.min(25.0f, Math.max(1.0f, this.f16970r)), bitmap4);
                                                bitmap7 = this.f16973u;
                                                if (bitmap7 != null && bitmap7 != bitmapM7540a4 && !bitmap7.isRecycled()) {
                                                    this.f16973u.recycle();
                                                }
                                                this.f16973u = bitmapM7540a4;
                                            } catch (Exception unused) {
                                            }
                                        }
                                        bitmap5 = this.f16973u;
                                        if (bitmap5 != null && !bitmap5.isRecycled() && (bitmap6 = this.f16976x) != null) {
                                            bitmap6.eraseColor(0);
                                            this.f16945A.drawBitmap(this.f16973u, 0.0f, 0.0f, (Paint) null);
                                            canvas.save();
                                            canvas.translate(0.0f, 0);
                                            float f13 = this.f16965m;
                                            canvas.scale(f13, f13);
                                            canvas.drawBitmap(this.f16976x, 0.0f, 0.0f, (Paint) null);
                                            canvas.restore();
                                        }
                                    } catch (OutOfMemoryError unused2) {
                                        releaseBitmaps();
                                    }
                                }
                            } catch (OutOfMemoryError unused3) {
                                releaseBitmaps();
                            }
                        }
                    } else {
                        if (this.f16967o.getBackground() instanceof ColorDrawable) {
                            this.f16972t.eraseColor(((ColorDrawable) this.f16967o.getBackground()).getColor());
                        } else {
                            this.f16972t.eraseColor(0);
                        }
                        this.f16977y.save();
                        matrix = this.f16964l;
                        matrix.reset();
                        float f14 = 1.0f / this.f16965m;
                        matrix.setScale(f14, f14);
                        if (this.f16957M) {
                            int[] iArr9 = new int[2];
                            int[] iArr10 = new int[2];
                            this.f16967o.getLocationInWindow(iArr9);
                            getLocationInWindow(iArr10);
                            matrix.preTranslate(-(iArr10[0] - iArr9[0]), -(iArr10[1] - iArr9[1]));
                        }
                        this.f16977y.setMatrix(matrix);
                        this.f16967o.draw(this.f16977y);
                        this.f16977y.restore();
                        bitmap3 = this.f16974v;
                        bitmap4 = this.f16972t;
                        if (bitmap3 != null) {
                            if (bitmap4 != null) {
                                bitmap4 = null;
                            } else {
                                bitmap4 = null;
                            }
                        }
                        if (bitmap4 != null) {
                            Bitmap bitmapM7540a5 = Toolkit.f15289a.m7540a((int) Math.min(25.0f, Math.max(1.0f, this.f16970r)), bitmap4);
                            bitmap7 = this.f16973u;
                            if (bitmap7 != null) {
                                this.f16973u.recycle();
                            }
                            this.f16973u = bitmapM7540a5;
                        }
                        bitmap5 = this.f16973u;
                        if (bitmap5 != null) {
                            bitmap6.eraseColor(0);
                            this.f16945A.drawBitmap(this.f16973u, 0.0f, 0.0f, (Paint) null);
                            canvas.save();
                            canvas.translate(0.0f, 0);
                            float f15 = this.f16965m;
                            canvas.scale(f15, f15);
                            canvas.drawBitmap(this.f16976x, 0.0f, 0.0f, (Paint) null);
                            canvas.restore();
                        }
                    }
                }
            }
        }
        int i7 = this.f16966n;
        if (i7 != 0) {
            canvas.drawColor(i7);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void releaseBitmaps() {
        releaseBlurredBitmap();
        Bitmap bitmap = this.f16975w;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f16975w.recycle();
            this.f16975w = null;
        }
        Bitmap bitmap2 = this.f16976x;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f16976x.recycle();
            this.f16976x = null;
        }
        this.f16978z = null;
        this.f16977y = null;
        this.f16945A = null;
    }

    /* JADX INFO: renamed from: e */
    public final void releaseBlurredBitmap() {
        Bitmap bitmap = this.f16972t;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f16972t.recycle();
            this.f16972t = null;
        }
        Bitmap bitmap2 = this.f16973u;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f16973u.recycle();
        this.f16973u = null;
    }

    /* JADX INFO: renamed from: f */
    public final void updateBorderGradient() {
        float f6 = this.f16958N;
        Paint paint = this.f16963k;
        if (f6 <= 0.0f) {
            paint.setShader(null);
        } else {
            if (!this.f16961Q || getWidth() <= 0 || getHeight() <= 0) {
                return;
            }
            paint.setShader(new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, this.f16959O, this.f16960P));
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        releaseBitmaps();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:6:0x0011  */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5;
        boolean z6 = this.f16955K;
        Path path = this.f16954J;
        Path path2 = this.f16953I;
        if (z6 || this.f16956L) {
            float width = getWidth();
            float height = getHeight();
            if (width == 0.0f || height == 0.0f) {
                path2 = path2;
            } else {
                if (this.f16955K) {
                    this.f16955K = false;
                    path2.reset();
                    float f6 = this.f16948D;
                    if (f6 > 0.0f) {
                        float fMin = Math.min(f6, Math.min(width, height) / 2.0f);
                        z5 = false;
                        buildRoundRectPath(path2, 0.0f, 0.0f, width, height, fMin, fMin, this.f16949E, this.f16950F, this.f16951G, this.f16952H);
                    } else {
                        z5 = false;
                    }
                } else {
                    z5 = false;
                }
                if (this.f16956L) {
                    this.f16956L = z5;
                    path.reset();
                    float f7 = this.f16958N;
                    if (f7 > 0.0f) {
                        float f8 = f7 / 2.0f;
                        float fMax = Math.max(0.0f, Math.min(this.f16948D, Math.min(width, height) / 2.0f) - f8);
                        buildRoundRectPath(path, f8, f8, width - f8, height - f8, fMax, fMax, this.f16949E, this.f16950F, this.f16951G, this.f16952H);
                    }
                }
            }
        } else {
            path2 = path2;
        }
        if (this.f16948D <= 0.0f || path2.isEmpty()) {
            drawBlurredBackground(canvas);
        } else {
            int iSave = canvas.save();
            canvas.clipPath(path2);
            drawBlurredBackground(canvas);
            canvas.restoreToCount(iSave);
        }
        if (this.f16958N <= 0.0f || path.isEmpty()) {
            return;
        }
        canvas.drawPath(path, this.f16963k);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (this.f16948D > 0.0f || this.f16958N > 0.0f) {
            this.f16955K = true;
            this.f16956L = true;
        }
        updateBorderGradient();
    }

    public void setAutoCropToBlurredView(boolean z5) {
        if (this.f16957M != z5) {
            this.f16957M = z5;
            invalidate();
        }
    }

    public void setBitmapBackground(Bitmap bitmap) {
        this.f16974v = bitmap;
        invalidate();
    }

    public void setBlurRadius(int i6) {
        float f6 = i6;
        if (this.f16970r != f6) {
            this.f16970r = f6;
            invalidate();
        }
    }

    public void setBlurredView(View view) {
        this.f16967o = view;
        invalidate();
    }

    public void setCornerRadius(float f6) {
        if (this.f16948D != f6) {
            this.f16948D = f6;
            this.f16955K = f6 > 0.0f;
            this.f16956L = this.f16958N > 0.0f;
            invalidate();
        }
    }

    public void setDownSampleFactor(int i6) {
        if (i6 <= 0) {
            i6 = 1;
        }
        if (this.f16965m != i6) {
            this.f16965m = i6;
            this.f16971s = true;
            invalidate();
        }
    }

    public void setOverlayColor(int i6) {
        if (this.f16966n != i6) {
            this.f16966n = i6;
            invalidate();
        }
    }

    public void setStrokeWidth(float f6) {
        if (this.f16958N != f6) {
            this.f16958N = f6;
            this.f16963k.setStrokeWidth(f6);
            this.f16956L = true;
            invalidate();
        }
    }
}
