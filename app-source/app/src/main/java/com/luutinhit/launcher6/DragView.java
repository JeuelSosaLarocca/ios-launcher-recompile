package com.luutinhit.launcher6;

import android.animation.FloatArrayEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: renamed from: com.luutinhit.launcher6.f0 */
/* JADX INFO: loaded from: classes.dex */
public final class DragView extends View {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public DragView(android.content.Context p0) {
        super(p0);
    }

    /* JADX INFO: renamed from: y */
    public static final /* synthetic */ int f16475y = 0;

    /* JADX INFO: renamed from: j */
    public Bitmap f16476j;

    /* JADX INFO: renamed from: k */
    public Paint f16477k;

    /* JADX INFO: renamed from: l */
    public int f16478l;

    /* JADX INFO: renamed from: m */
    public int f16479m;

    /* JADX INFO: renamed from: n */
    public Point mDragVisualizeOffset;

    /* JADX INFO: renamed from: o */
    public Rect mDragRegion;

    /* JADX INFO: renamed from: p */
    public DragLayer f16482p;

    /* JADX INFO: renamed from: q */
    public boolean f16483q;

    /* JADX INFO: renamed from: r */
    public ValueAnimator f16484r;

    /* JADX INFO: renamed from: s */
    public float f16485s;

    /* JADX INFO: renamed from: t */
    public float f16486t;

    /* JADX INFO: renamed from: u */
    public float mInitialScale;

    /* JADX INFO: renamed from: v */
    public float mIntrinsicIconScale;

    /* JADX INFO: renamed from: w */
    public float[] f16489w;

    /* JADX INFO: renamed from: x */
    public ValueAnimator f16490x;

    /* JADX INFO: renamed from: b */
    public static void setColorScale(int i6, ColorMatrix colorMatrix) {
        colorMatrix.setScale(Color.red(i6) / 255.0f, Color.green(i6) / 255.0f, Color.blue(i6) / 255.0f, Color.alpha(i6) / 255.0f);
    }

    /* JADX INFO: renamed from: a */
    public final void animateFilterTo(float[] fArr) {
        float[] array = this.f16489w;
        if (array == null) {
            array = new ColorMatrix().getArray();
        }
        this.f16489w = Arrays.copyOf(array, array.length);
        ValueAnimator valueAnimator = this.f16490x;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new FloatArrayEvaluator(this.f16489w), array, fArr);
        this.f16490x = valueAnimatorOfObject;
        valueAnimatorOfObject.setDuration(120);
        this.f16490x.addUpdateListener(new SharedAnimatorUpdateListener(4, this));
        this.f16490x.start();
    }

    public Rect getDragRegion() {
        return this.mDragRegion;
    }

    public int getDragRegionHeight() {
        return this.mDragRegion.height();
    }

    public int getDragRegionLeft() {
        return this.mDragRegion.left;
    }

    public int getDragRegionTop() {
        return this.mDragRegion.top;
    }

    public int getDragRegionWidth() {
        return this.mDragRegion.width();
    }

    public Point getDragVisualizeOffset() {
        return this.mDragVisualizeOffset;
    }

    public float getInitialScale() {
        return this.mInitialScale;
    }

    public float getIntrinsicIconScaleFactor() {
        return this.mIntrinsicIconScale;
    }

    public float getOffsetY() {
        return this.f16486t;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        this.f16483q = true;
        canvas.drawBitmap(this.f16476j, 0.0f, 0.0f, this.f16477k);
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        Bitmap bitmap = this.f16476j;
        setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());
    }

    @Override // android.view.View
    public void setAlpha(float f6) {
        super.setAlpha(f6);
        this.f16477k.setAlpha((int) (f6 * 255.0f));
        invalidate();
    }

    public void setColor(int i6) {
        if (this.f16477k == null) {
            this.f16477k = new Paint(2);
        }
        if (i6 == 0) {
            if (Utilities.f16752m && this.f16489w != null) {
                animateFilterTo(new ColorMatrix().getArray());
                return;
            } else {
                this.f16477k.setColorFilter(null);
                invalidate();
                return;
            }
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        setColorScale(i6, colorMatrix2);
        colorMatrix.postConcat(colorMatrix2);
        if (Utilities.f16752m) {
            animateFilterTo(colorMatrix.getArray());
        } else {
            this.f16477k.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            invalidate();
        }
    }

    public void setCrossFadeBitmap(Bitmap bitmap) {
    }

    public void setDragRegion(Rect rect) {
        this.mDragRegion = rect;
    }

    public void setDragVisualizeOffset(Point point) {
        this.mDragVisualizeOffset = point;
    }

    public void setIntrinsicIconScaleFactor(float f6) {
        this.mIntrinsicIconScale = f6;
    }
}
