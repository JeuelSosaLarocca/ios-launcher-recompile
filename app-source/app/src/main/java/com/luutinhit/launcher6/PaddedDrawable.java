package com.luutinhit.launcher6;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: com.luutinhit.launcher6.y */
/* JADX INFO: loaded from: classes.dex */
public final class PaddedDrawable extends Drawable {

    /* JADX INFO: renamed from: a */
    public Drawable f17248a;

    /* JADX INFO: renamed from: b */
    public Rect f17249b;

    /* JADX INFO: renamed from: c */
    public Rect f17250c;

    public PaddedDrawable(Drawable drawable) {
        this.f17248a = drawable;
        Rect rect = new Rect();
        this.f17249b = rect;
        Rect rect2 = new Rect();
        this.f17250c = rect2;
        drawable.getPadding(rect2);
        rect.left = -rect2.left;
        rect2.left = 0;
        rect.top = -rect2.top;
        rect2.top = 0;
        rect.right = rect2.right;
        rect2.right = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f17248a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f17248a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        rect.set(this.f17250c);
        return (rect.bottom | ((rect.left | rect.top) | rect.right)) != 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        int i6 = rect.left;
        Rect rect2 = this.f17249b;
        this.f17248a.setBounds(i6 + rect2.left, rect.top + rect2.top, rect.right + rect2.right, rect.bottom + rect2.bottom);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i6) {
        this.f17248a.setAlpha(i6);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f17248a.setColorFilter(colorFilter);
    }
}
