package com.luutinhit.weather.utils;

import O3.AbstractC0744e;
import R4.AbstractC0965g;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.luutinhit.launcher6.SyntheticHelpers;
import com.luutinhit.launcherios.R;
import java.util.Arrays;
import p081h2.AbstractC2127a;

/* JADX INFO: loaded from: classes.dex */
public class RangeSeekBar extends View {

    /* JADX INFO: renamed from: A */
    public Point f17683A;

    /* JADX INFO: renamed from: B */
    public int f17684B;

    /* JADX INFO: renamed from: C */
    public int f17685C;

    /* JADX INFO: renamed from: D */
    public int f17686D;

    /* JADX INFO: renamed from: E */
    public int f17687E;

    /* JADX INFO: renamed from: j */
    public Rect f17688j;

    /* JADX INFO: renamed from: k */
    public Rect f17689k;

    /* JADX INFO: renamed from: l */
    public String f17690l;

    /* JADX INFO: renamed from: m */
    public String f17691m;

    /* JADX INFO: renamed from: n */
    public int f17692n;

    /* JADX INFO: renamed from: o */
    public int f17693o;

    /* JADX INFO: renamed from: p */
    public Paint f17694p;

    /* JADX INFO: renamed from: q */
    public Paint f17695q;

    /* JADX INFO: renamed from: r */
    public Paint f17696r;

    /* JADX INFO: renamed from: s */
    public int f17697s;

    /* JADX INFO: renamed from: t */
    public int f17698t;

    /* JADX INFO: renamed from: u */
    public int f17699u;

    /* JADX INFO: renamed from: v */
    public int f17700v;

    /* JADX INFO: renamed from: w */
    public int f17701w;

    /* JADX INFO: renamed from: x */
    public boolean f17702x;

    /* JADX INFO: renamed from: y */
    public boolean f17703y;

    /* JADX INFO: renamed from: z */
    public Point f17704z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        AbstractC0965g.m2013e(context, "context");
        this.f17688j = new Rect();
        this.f17689k = new Rect();
        this.f17690l = "";
        this.f17691m = "";
        this.f17692n = -16776961;
        this.f17693o = -65536;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(getResources().getDimensionPixelSize(R.dimen.rsb_text_size));
        this.f17694p = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        this.f17695q = paint2;
        new RectF();
        this.f17684B = 1;
        this.f17685C = 100;
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.rsb_trackDefaultThickness);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.rsb_touchRadius);
        int iM8795i = AbstractC2127a.m8795i(context, R.color.rsb_trackDefaultColor);
        int iM8795i2 = AbstractC2127a.m8795i(context, R.color.rsb_trackSelectedDefaultColor);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, AbstractC0744e.f2256t, 0, 0);
        AbstractC0965g.m2012d(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            setMax(typedArrayObtainStyledAttributes.getInteger(2, 100));
            setMinRange(typedArrayObtainStyledAttributes.getInteger(6, 1));
            this.f17701w = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize2);
            this.f17697s = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, dimensionPixelSize);
            this.f17698t = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, dimensionPixelSize);
            this.f17699u = typedArrayObtainStyledAttributes.getColor(11, iM8795i);
            this.f17700v = typedArrayObtainStyledAttributes.getColor(13, iM8795i2);
            this.f17704z = new Point(typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0));
            this.f17683A = new Point(typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0), typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0));
            this.f17702x = typedArrayObtainStyledAttributes.getBoolean(12, true);
            this.f17703y = typedArrayObtainStyledAttributes.getBoolean(14, true);
            int integer = typedArrayObtainStyledAttributes.getInteger(1, -1);
            int integer2 = typedArrayObtainStyledAttributes.getInteger(0, -1);
            if (integer != -1) {
                this.f17686D = Math.max(0, integer);
                m8395b(1);
            }
            if (integer2 != -1) {
                this.f17687E = Math.min(this.f17685C, integer2);
                m8395b(2);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m8394a(int i6, float f6, int i7) {
        float[] fArr = new float[3];
        float[] fArr2 = new float[3];
        Color.colorToHSV(i6, fArr);
        Color.colorToHSV(i7, fArr2);
        for (int i8 = 0; i8 < 3; i8++) {
            float f7 = fArr[i8];
            fArr2[i8] = SyntheticHelpers.m7906e(fArr2[i8], f7, f6, f7);
        }
        return Color.HSVToColor(fArr2);
    }

    public final void setMaxThumbValue(int i6) {
        this.f17687E = Math.min(i6, this.f17685C);
        m8395b(2);
        invalidate();
    }

    public final void setMinThumbValue(int i6) {
        this.f17686D = Math.max(i6, 0);
        m8395b(1);
        invalidate();
    }

    /* JADX INFO: renamed from: b */
    public final void m8395b(int i6) {
        if (i6 == 1) {
            int i7 = this.f17686D;
            int i8 = this.f17687E;
            int i9 = this.f17684B;
            if (i7 > i8 - i9) {
                this.f17687E = i7 + i9;
                return;
            }
            return;
        }
        if (i6 != 2) {
            return;
        }
        int i10 = this.f17687E;
        int i11 = this.f17686D;
        int i12 = this.f17684B;
        if (i10 <= i11 + i12) {
            this.f17686D = i10 - i12;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8396c(int i6, int i7, int i8, int i9) {
        this.f17690l = String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i6), (char) 176}, 2));
        this.f17691m = String.format("%s%s", Arrays.copyOf(new Object[]{Integer.valueOf(i7), (char) 176}, 2));
        setMax(i9 - i8);
        setMinThumbValue(i6 - i8);
        setMaxThumbValue(i7 - i8);
        this.f17692n = m8394a(Color.parseColor("#7BD2FF"), (i6 + 50) / 100.0f, Color.parseColor("#FF0000"));
        this.f17693o = m8394a(Color.parseColor("#7BD2FF"), (i7 + 50) / 100.0f, Color.parseColor("#FF0000"));
    }

    public final int getMax() {
        return this.f17685C;
    }

    public final Point getMaxThumbOffset() {
        return this.f17683A;
    }

    public final int getMaxThumbValue() {
        return this.f17687E;
    }

    public final int getMinRange() {
        return this.f17684B;
    }

    public final Point getMinThumbOffset() {
        return this.f17704z;
    }

    public final int getMinThumbValue() {
        return this.f17686D;
    }

    public final int getTouchRadius() {
        return this.f17701w;
    }

    public final int getTrackColor() {
        return this.f17699u;
    }

    public final boolean getTrackRoundedCaps() {
        return this.f17702x;
    }

    public final int getTrackSelectedColor() {
        return this.f17700v;
    }

    public final boolean getTrackSelectedRoundedCaps() {
        return this.f17703y;
    }

    public final int getTrackSelectedThickness() {
        return this.f17698t;
    }

    public final int getTrackThickness() {
        return this.f17697s;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f6;
        AbstractC0965g.m2013e(canvas, "canvas");
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        float height = getHeight() / 2.0f;
        Paint paint = this.f17694p;
        String str = this.f17690l;
        int length = str.length();
        Rect rect = this.f17688j;
        paint.getTextBounds(str, 0, length, rect);
        float fWidth = rect.width() / 3.0f;
        float fWidth2 = rect.width() + paddingLeft + fWidth;
        String str2 = this.f17691m;
        int length2 = str2.length();
        Rect rect2 = this.f17689k;
        paint.getTextBounds(str2, 0, length2, rect2);
        float width = ((getWidth() - paddingRight) - rect2.width()) - fWidth;
        float fAbs = Math.abs(width - fWidth2);
        float f7 = this.f17686D;
        int i6 = this.f17685C;
        float f8 = ((f7 / i6) * fAbs) + fWidth2;
        float f9 = ((this.f17687E / i6) * fAbs) + fWidth2;
        float f10 = 2;
        canvas.drawText(this.f17690l, (rect.width() / 2.0f) + paddingLeft, (getHeight() / 2.0f) - ((paint.ascent() + paint.descent()) / f10), paint);
        canvas.drawText(this.f17691m, (rect2.width() / 2.0f) + fWidth + width, (getHeight() / 2.0f) - ((paint.ascent() + paint.descent()) / f10), paint);
        Paint paint2 = this.f17695q;
        paint2.setColor(this.f17699u);
        float f11 = this.f17697s;
        float f12 = f11 / f10;
        float f13 = height - f12;
        float f14 = height + f12;
        if (this.f17702x) {
            canvas.drawRoundRect(fWidth2 - f12, f13, f12 + width, f14, f11, f11, paint2);
            f6 = fWidth2;
        } else {
            f6 = fWidth2;
            canvas.drawRect(f6, f13, width, f14, paint2);
        }
        if (this.f17696r == null) {
            Paint paint3 = new Paint(1);
            paint3.setStyle(Paint.Style.FILL);
            paint3.setShader(new LinearGradient(f6, 0.0f, width, 0.0f, this.f17692n, this.f17693o, Shader.TileMode.CLAMP));
            this.f17696r = paint3;
        }
        float f15 = this.f17698t;
        Paint paint4 = this.f17696r;
        AbstractC0965g.m2010b(paint4);
        float f16 = f15 / f10;
        float f17 = height - f16;
        float f18 = height + f16;
        if (this.f17703y) {
            canvas.drawRoundRect(f8 - f16, f17, f9 + f16, f18, f15, f15, paint4);
        } else {
            canvas.drawRect(f8, f17, f9, f18, paint4);
        }
    }

    public final void setMax(int i6) {
        this.f17685C = i6;
        this.f17686D = 0;
        this.f17687E = i6;
    }

    public final void setMaxThumbOffset(Point point) {
        AbstractC0965g.m2013e(point, "<set-?>");
        this.f17683A = point;
    }

    public final void setMinRange(int i6) {
        this.f17684B = Math.max(i6, 1);
    }

    public final void setMinThumbOffset(Point point) {
        AbstractC0965g.m2013e(point, "<set-?>");
        this.f17704z = point;
    }

    public final void setTouchRadius(int i6) {
        this.f17701w = i6;
    }

    public final void setTrackColor(int i6) {
        this.f17699u = i6;
    }

    public final void setTrackRoundedCaps(boolean z5) {
        this.f17702x = z5;
    }

    public final void setTrackSelectedColor(int i6) {
        this.f17700v = i6;
    }

    public final void setTrackSelectedRoundedCaps(boolean z5) {
        this.f17703y = z5;
    }

    public final void setTrackSelectedThickness(int i6) {
        this.f17698t = i6;
    }

    public final void setTrackThickness(int i6) {
        this.f17697s = i6;
    }
}
