package com.luutinhit.launcher6.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class WidgetImageView extends View {

    /* JADX INFO: renamed from: j */
    public Paint f17182j;

    /* JADX INFO: renamed from: k */
    public RectF f17183k;

    /* JADX INFO: renamed from: l */
    public Bitmap f17184l;

    public WidgetImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17182j = new Paint(3);
        this.f17183k = new RectF();
    }

    /* JADX INFO: renamed from: a */
    public final void m8242a() {
        this.f17184l.getWidth();
        this.f17184l.getHeight();
        getWidth();
        getHeight();
        int width = this.f17184l.getWidth();
        int width2 = getWidth();
        RectF rectF = this.f17183k;
        if (width > width2) {
            rectF.set(0.0f, 0.0f, getWidth(), (getWidth() / this.f17184l.getWidth()) * this.f17184l.getHeight());
        } else {
            if (this.f17184l.getHeight() > getHeight()) {
                rectF.set(0.0f, 0.0f, (getHeight() / this.f17184l.getHeight()) * this.f17184l.getWidth(), getHeight());
                return;
            }
            float width3 = getWidth() / this.f17184l.getWidth();
            float height = getHeight() / this.f17184l.getHeight();
            rectF.set(0.0f, 0.0f, Math.min(width3, height) * this.f17184l.getWidth(), Math.min(width3, height) * this.f17184l.getHeight());
        }
    }

    public Bitmap getBitmap() {
        return this.f17184l;
    }

    public Rect getBitmapBounds() {
        m8242a();
        Rect rect = new Rect(0, 0, this.f17184l.getWidth(), this.f17184l.getHeight());
        this.f17183k.round(rect);
        return rect;
    }

    @Override // android.view.View
    public final boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f17184l != null) {
            m8242a();
            canvas.drawBitmap(this.f17184l, (Rect) null, this.f17183k, this.f17182j);
        }
    }

    public void setBitmap(Bitmap bitmap) {
        this.f17184l = bitmap;
        invalidate();
    }
}
