package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.luutinhit.launcher6.a3 */
/* JADX INFO: loaded from: classes.dex */
public final class PreloadIconDrawable extends Drawable {

    /* JADX INFO: renamed from: k */
    public static final Rect f16225k = new Rect();

    /* JADX INFO: renamed from: b */
    public boolean f16227b;

    /* JADX INFO: renamed from: c */
    public Paint f16228c;

    /* JADX INFO: renamed from: d */
    public Drawable f16229d;

    /* JADX INFO: renamed from: e */
    public Drawable f16230e;

    /* JADX INFO: renamed from: f */
    public int f16231f;

    /* JADX INFO: renamed from: j */
    public ObjectAnimator f16235j;

    /* JADX INFO: renamed from: a */
    public RectF mIndicatorRect = new RectF();

    /* JADX INFO: renamed from: g */
    public int f16232g = 0;

    /* JADX INFO: renamed from: h */
    public int f16233h = 0;

    /* JADX INFO: renamed from: i */
    public float f16234i = -1.0f;

    public PreloadIconDrawable(Drawable drawable, Resources.Theme theme) {
        this.f16229d = drawable;
        Paint paint = new Paint(1);
        this.f16228c = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        setBounds(drawable.getBounds());
        applyPreloaderTheme(theme);
        onLevelChange(0);
    }

    /* JADX INFO: renamed from: a */
    public final void applyPreloaderTheme(Resources.Theme theme) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(AbstractC0744e.f2255s);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f16230e = drawable;
        drawable.setFilterBitmap(true);
        this.f16228c.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(1, 0.0f));
        this.f16231f = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        typedArrayObtainStyledAttributes.recycle();
        onBoundsChange(getBounds());
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect(getBounds());
        Rect rect2 = f16225k;
        if (!canvas.getClipBounds(rect2) || Rect.intersects(rect2, rect)) {
            boolean z5 = this.f16227b;
            RectF rectF = this.mIndicatorRect;
            Paint paint = this.f16228c;
            if (z5) {
                Drawable drawable = this.f16230e;
                Rect bounds = drawable.getBounds();
                drawable.getPadding(rect2);
                float fWidth = bounds.width() / drawable.getIntrinsicWidth();
                float fHeight = bounds.height() / drawable.getIntrinsicHeight();
                rectF.set((rect2.left * fWidth) + bounds.left, (rect2.top * fHeight) + bounds.top, bounds.right - (rect2.right * fWidth), bounds.bottom - (rect2.bottom * fHeight));
                float strokeWidth = paint.getStrokeWidth() / 2.0f;
                rectF.inset(strokeWidth, strokeWidth);
                this.f16227b = false;
            }
            float f6 = this.f16234i;
            float f7 = 0.5f;
            if (f6 >= 0.0f && f6 < 1.0f) {
                paint.setAlpha((int) ((1.0f - f6) * 255.0f));
                this.f16230e.setAlpha(paint.getAlpha());
                this.f16230e.draw(canvas);
                canvas.drawOval(rectF, paint);
                f7 = 0.5f + (this.f16234i * 0.5f);
            } else if (f6 == -1.0f) {
                paint.setAlpha(255);
                this.f16230e.setAlpha(255);
                this.f16230e.draw(canvas);
                int i6 = this.f16233h;
                if (i6 >= 100) {
                    canvas.drawOval(rectF, paint);
                } else if (i6 > 0) {
                    canvas.drawArc(rectF, -90.0f, i6 * 3.6f, false, paint);
                }
            } else {
                f7 = 1.0f;
            }
            canvas.save();
            canvas.scale(f7, f7, rect.exactCenterX(), rect.exactCenterY());
            this.f16229d.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f16229d.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f16229d.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f16229d.setBounds(rect);
        if (this.f16230e != null) {
            Rect rect2 = f16225k;
            rect2.set(rect);
            int i6 = this.f16231f;
            rect2.inset(-i6, -i6);
            this.f16230e.setBounds(rect2);
        }
        this.f16227b = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i6) {
        this.f16233h = i6;
        ObjectAnimator objectAnimator = this.f16235j;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f16235j = null;
        }
        this.f16234i = -1.0f;
        Drawable drawable = this.f16229d;
        if (i6 > 0) {
            int iHSVToColor = this.f16232g;
            if (iHSVToColor == 0) {
                if (drawable instanceof FastBitmapDrawable) {
                    int iFindDominantColorByHue = Utilities.findDominantColorByHue(((FastBitmapDrawable) drawable).f15576b);
                    this.f16232g = iFindDominantColorByHue;
                    float[] fArr = new float[3];
                    Color.colorToHSV(iFindDominantColorByHue, fArr);
                    if (fArr[1] < 0.2f) {
                        this.f16232g = -16738680;
                    } else {
                        fArr[2] = Math.max(0.6f, fArr[2]);
                        iHSVToColor = Color.HSVToColor(fArr);
                        this.f16232g = iHSVToColor;
                    }
                } else {
                    this.f16232g = -16738680;
                }
                iHSVToColor = -16738680;
            }
            this.f16228c.setColor(iHSVToColor);
        }
        if (drawable instanceof FastBitmapDrawable) {
            ((FastBitmapDrawable) drawable).m7684f(i6 <= 0 ? FastBitmapDrawableState.DISABLED : FastBitmapDrawableState.NORMAL);
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i6) {
        this.f16229d.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f16229d.setColorFilter(colorFilter);
    }
}
