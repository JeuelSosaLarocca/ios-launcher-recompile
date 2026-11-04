package com.luutinhit.launcher6;

import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: renamed from: com.luutinhit.launcher6.m3 */
/* JADX INFO: loaded from: classes.dex */
public final class SquareBitmapDrawable extends BitmapDrawable {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public SquareBitmapDrawable(android.content.res.Resources p0, android.graphics.Bitmap p1) {
        super(p0, p1);
    }
    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBitmap().getWidth();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBitmap().getWidth();
    }
}
