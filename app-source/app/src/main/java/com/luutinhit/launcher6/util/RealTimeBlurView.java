package com.luutinhit.launcher6.util;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.renderscript.Toolkit;
import com.luutinhit.launcherios.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RealTimeBlurView extends View {

    /* JADX INFO: renamed from: A */
    public Bitmap f16979A;

    /* JADX INFO: renamed from: B */
    public Canvas f16980B;

    /* JADX INFO: renamed from: C */
    public Canvas f16981C;

    /* JADX INFO: renamed from: D */
    public float f16982D;

    /* JADX INFO: renamed from: j */
    public Paint f16983j;

    /* JADX INFO: renamed from: k */
    public Paint f16984k;

    /* JADX INFO: renamed from: l */
    public Paint f16985l;

    /* JADX INFO: renamed from: m */
    public Paint f16986m;

    /* JADX INFO: renamed from: n */
    public Rect f16987n;

    /* JADX INFO: renamed from: o */
    public Rect f16988o;

    /* JADX INFO: renamed from: p */
    public int f16989p;

    /* JADX INFO: renamed from: q */
    public int f16990q;

    /* JADX INFO: renamed from: r */
    public float f16991r;

    /* JADX INFO: renamed from: s */
    public View f16992s;

    /* JADX INFO: renamed from: t */
    public int f16993t;

    /* JADX INFO: renamed from: u */
    public int f16994u;

    /* JADX INFO: renamed from: v */
    public float f16995v;

    /* JADX INFO: renamed from: w */
    public boolean f16996w;

    /* JADX INFO: renamed from: x */
    public Bitmap f16997x;

    /* JADX INFO: renamed from: y */
    public Bitmap f16998y;

    /* JADX INFO: renamed from: z */
    public Bitmap f16999z;

    public RealTimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.f16983j = paint;
        Paint paint2 = new Paint(1);
        this.f16984k = paint2;
        Paint paint3 = new Paint(1);
        this.f16985l = paint3;
        new Paint(2);
        this.f16986m = new Paint(2);
        this.f16987n = new Rect();
        this.f16988o = new Rect();
        new RectF();
        this.f16991r = 0.8f;
        Resources resources = getResources();
        int integer = resources.getInteger(R.integer.default_blur_radius);
        int integer2 = resources.getInteger(R.integer.default_downsample_factor);
        int color = resources.getColor(R.color.default_overlay_color);
        try {
            PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
            paint.setXfermode(new PorterDuffXfermode(mode));
            paint2.setXfermode(new PorterDuffXfermode(mode));
            paint3.setXfermode(new PorterDuffXfermode(mode));
        } catch (Throwable unused) {
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2257u);
        setBlurRadius(typedArrayObtainStyledAttributes.getInt(0, integer));
        setDownSampleFactor(typedArrayObtainStyledAttributes.getInt(1, integer2));
        setOverlayColor(typedArrayObtainStyledAttributes.getColor(2, color));
        setTransparentPercent(typedArrayObtainStyledAttributes.getFloat(8, 0.8f));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public final void m8203a() {
        Bitmap bitmap = this.f16997x;
        if (bitmap != null) {
            bitmap.recycle();
            this.f16997x = null;
        }
        Bitmap bitmap2 = this.f16998y;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f16998y = null;
        }
        Bitmap bitmap3 = this.f16979A;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.f16979A = null;
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        m8203a();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:43:0x012a  */
    /* JADX WARN: Code duplicated, block: B:45:0x012e  */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Drawable background;
        Bitmap bitmap;
        Bitmap bitmap2;
        int width;
        int height;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        if (this.f16992s != null) {
            try {
                if (this.f16995v == 0.0f) {
                    m8203a();
                } else {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    Canvas canvas3 = this.f16980B;
                    Paint paint = this.f16985l;
                    Paint paint2 = this.f16984k;
                    Paint paint3 = this.f16983j;
                    if (canvas3 == null || this.f16996w || this.f16993t != width2 || this.f16994u != height2) {
                        m8203a();
                        this.f16996w = false;
                        this.f16993t = width2;
                        this.f16994u = height2;
                        int i6 = this.f16989p;
                        int i7 = width2 / i6;
                        int i8 = height2 / i6;
                        int i9 = (i8 - (i8 % 4)) + 4;
                        Objects.toString(this.f16998y);
                        float f6 = i9;
                        float f7 = f6 * this.f16991r;
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        paint3.setShader(new LinearGradient(0.0f, f6, 0.0f, f7, 0, -16777216, tileMode));
                        float f8 = i7;
                        paint2.setShader(new LinearGradient(f8, 0.0f, (i7 * 11) / 12.0f, 0.0f, 0, -16777216, tileMode));
                        paint.setShader(new LinearGradient(0.0f, 0.0f, f8 / 12.0f, 0.0f, 0, -16777216, tileMode));
                        Bitmap bitmap5 = this.f16998y;
                        if (bitmap5 == null || bitmap5.getWidth() != i7 || this.f16998y.getHeight() != i9) {
                            Bitmap.Config config = Bitmap.Config.ARGB_8888;
                            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i9, config);
                            this.f16997x = bitmapCreateBitmap;
                            Objects.toString(bitmapCreateBitmap);
                            if (this.f16997x != null) {
                                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i7, i9, config);
                                this.f16998y = bitmapCreateBitmap2;
                                Objects.toString(bitmapCreateBitmap2);
                                if (this.f16998y == null) {
                                }
                            }
                        }
                        Canvas canvas4 = new Canvas(this.f16997x);
                        this.f16980B = canvas4;
                        float f9 = 1.0f / this.f16989p;
                        canvas4.scale(f9, f9);
                        background = this.f16992s.getBackground();
                        if (background instanceof ColorDrawable) {
                            this.f16997x.eraseColor(((ColorDrawable) background).getColor());
                        } else {
                            this.f16997x.eraseColor(0);
                        }
                        this.f16992s.draw(this.f16980B);
                        this.f16997x.getWidth();
                        this.f16997x.getHeight();
                        bitmap = this.f16999z;
                        bitmap2 = this.f16997x;
                        if (bitmap != null && bitmap2 != null) {
                            width = bitmap2.getWidth();
                            height = bitmap2.getHeight();
                            bitmap3 = this.f16979A;
                            if (bitmap3 != null || bitmap3.getWidth() != width || this.f16979A.getHeight() != height) {
                                bitmap4 = this.f16979A;
                                if (bitmap4 != null) {
                                    bitmap4.recycle();
                                }
                                this.f16979A = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                                this.f16981C = new Canvas(this.f16979A);
                            }
                            this.f16981C.getWidth();
                            this.f16981C.getHeight();
                            this.f16979A.eraseColor(0);
                            int i10 = (int) this.f16982D;
                            int width3 = bitmap.getWidth() + i10;
                            int height3 = getHeight();
                            Rect rect = this.f16987n;
                            rect.set(i10, 0, width3, height3);
                            Objects.toString(rect);
                            Rect rect2 = this.f16988o;
                            rect2.set(0, 0, width, height);
                            this.f16981C.drawBitmap(bitmap, rect, rect2, (Paint) null);
                            this.f16981C.drawBitmap(bitmap2, 0.0f, 0.0f, this.f16986m);
                            bitmap2 = this.f16979A;
                        }
                        this.f16998y = Toolkit.f15289a.m7540a((int) this.f16995v, bitmap2);
                        canvas2.save();
                        this.f16992s.getX();
                        this.f16992s.getY();
                        getX();
                        getY();
                        canvas2.translate(0.0f, 0);
                        float f10 = this.f16989p;
                        canvas2.scale(f10, f10);
                        float width4 = this.f16998y.getWidth();
                        float height4 = this.f16998y.getHeight();
                        int iSaveLayer = canvas2.saveLayer(0.0f, 0.0f, width4, height4, null);
                        canvas2.drawBitmap(this.f16998y, 0.0f, 0.0f, (Paint) null);
                        canvas2.drawRect(0.0f, 0.0f, width4, height4, paint3);
                        canvas2 = canvas;
                        canvas2.drawRect(0.0f, 0.0f, width4, height4, paint2);
                        canvas2.drawRect(0.0f, 0.0f, width4, height4, paint);
                        canvas2.restoreToCount(iSaveLayer);
                        Objects.toString(this.f16998y);
                        canvas2.restore();
                    } else {
                        background = this.f16992s.getBackground();
                        if (background instanceof ColorDrawable) {
                            this.f16997x.eraseColor(((ColorDrawable) background).getColor());
                        } else {
                            this.f16997x.eraseColor(0);
                        }
                        this.f16992s.draw(this.f16980B);
                        this.f16997x.getWidth();
                        this.f16997x.getHeight();
                        bitmap = this.f16999z;
                        bitmap2 = this.f16997x;
                        if (bitmap != null) {
                            width = bitmap2.getWidth();
                            height = bitmap2.getHeight();
                            bitmap3 = this.f16979A;
                            if (bitmap3 != null) {
                                bitmap4 = this.f16979A;
                                if (bitmap4 != null) {
                                    bitmap4.recycle();
                                }
                                this.f16979A = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                                this.f16981C = new Canvas(this.f16979A);
                            } else {
                                bitmap4 = this.f16979A;
                                if (bitmap4 != null) {
                                    bitmap4.recycle();
                                }
                                this.f16979A = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                                this.f16981C = new Canvas(this.f16979A);
                            }
                            this.f16981C.getWidth();
                            this.f16981C.getHeight();
                            this.f16979A.eraseColor(0);
                            int i11 = (int) this.f16982D;
                            int width5 = bitmap.getWidth() + i11;
                            int height5 = getHeight();
                            Rect rect3 = this.f16987n;
                            rect3.set(i11, 0, width5, height5);
                            Objects.toString(rect3);
                            Rect rect4 = this.f16988o;
                            rect4.set(0, 0, width, height);
                            this.f16981C.drawBitmap(bitmap, rect3, rect4, (Paint) null);
                            this.f16981C.drawBitmap(bitmap2, 0.0f, 0.0f, this.f16986m);
                            bitmap2 = this.f16979A;
                        }
                        this.f16998y = Toolkit.f15289a.m7540a((int) this.f16995v, bitmap2);
                        canvas2.save();
                        this.f16992s.getX();
                        this.f16992s.getY();
                        getX();
                        getY();
                        canvas2.translate(0.0f, 0);
                        float f11 = this.f16989p;
                        canvas2.scale(f11, f11);
                        float width6 = this.f16998y.getWidth();
                        float height6 = this.f16998y.getHeight();
                        int iSaveLayer2 = canvas2.saveLayer(0.0f, 0.0f, width6, height6, null);
                        canvas2.drawBitmap(this.f16998y, 0.0f, 0.0f, (Paint) null);
                        canvas2.drawRect(0.0f, 0.0f, width6, height6, paint3);
                        canvas2 = canvas;
                        canvas2.drawRect(0.0f, 0.0f, width6, height6, paint2);
                        canvas2.drawRect(0.0f, 0.0f, width6, height6, paint);
                        canvas2.restoreToCount(iSaveLayer2);
                        Objects.toString(this.f16998y);
                        canvas2.restore();
                    }
                }
            } catch (Throwable unused) {
                m8203a();
            }
            canvas2.drawColor(this.f16990q);
        }
    }

    public void setBitmapBackground(Bitmap bitmap) {
        this.f16999z = bitmap;
    }

    public void setBlurRadius(int i6) {
        float f6 = i6;
        if (this.f16995v != f6) {
            this.f16995v = f6;
        }
    }

    public void setBlurredView(View view) {
        Objects.toString(view);
        this.f16992s = view;
    }

    public void setDownSampleFactor(int i6) {
        if (i6 <= 0) {
            i6 = 1;
        }
        if (this.f16989p != i6) {
            this.f16989p = i6;
            this.f16996w = true;
        }
    }

    public void setOverlayColor(int i6) {
        this.f16990q = i6;
    }

    public void setTransparentPercent(float f6) {
        this.f16991r = f6;
    }
}
