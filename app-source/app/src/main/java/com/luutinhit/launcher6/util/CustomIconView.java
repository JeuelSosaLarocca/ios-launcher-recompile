package com.luutinhit.launcher6.util;

import B3.C0068k;
import B3.C0069l;
import B3.RunnableC0064g;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.luutinhit.launcher6.FastBitmapDrawable;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;
import java.util.Objects;
import p118q3.SharedPreferencesOnSharedPreferenceChangeListenerC2611a;

/* JADX INFO: loaded from: classes.dex */
public class CustomIconView extends AppCompatImageView {

    /* JADX INFO: renamed from: A */
    public RunnableC0064g f16916A;

    /* JADX INFO: renamed from: m */
    public Context f16917m;

    /* JADX INFO: renamed from: n */
    public boolean f16918n;

    /* JADX INFO: renamed from: o */
    public boolean f16919o;

    /* JADX INFO: renamed from: p */
    public float f16920p;

    /* JADX INFO: renamed from: q */
    public SharedPreferencesOnSharedPreferenceChangeListenerC2611a f16921q;

    /* JADX INFO: renamed from: r */
    public Rect f16922r;

    /* JADX INFO: renamed from: s */
    public int[] f16923s;

    /* JADX INFO: renamed from: t */
    public int f16924t;

    /* JADX INFO: renamed from: u */
    public int f16925u;

    /* JADX INFO: renamed from: v */
    public Path f16926v;

    /* JADX INFO: renamed from: w */
    public RectF f16927w;

    /* JADX INFO: renamed from: x */
    public int f16928x;

    /* JADX INFO: renamed from: y */
    public int f16929y;

    /* JADX INFO: renamed from: z */
    public boolean f16930z;

    public CustomIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16918n = false;
        this.f16919o = false;
        this.f16922r = new Rect();
        this.f16923s = new int[2];
        this.f16924t = -1;
        this.f16925u = -1;
        this.f16926v = new Path();
        this.f16927w = new RectF();
        this.f16928x = -1;
        this.f16929y = -1;
        this.f16930z = false;
        this.f16916A = new RunnableC0064g(1, this);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2246j);
            this.f16918n = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f16917m = context;
        this.f16920p = getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (!Utilities.f16755p && this.f16921q != null) {
            canvas.clipPath(this.f16926v);
        }
        super.draw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16919o = true;
        SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f16921q;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC2611a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20535o.m9546b(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16930z = false;
        this.f16919o = false;
        SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f16921q;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC2611a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20535o.f20553c.remove(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f16930z) {
            hashCode();
            Objects.toString(getParent());
            RunnableC0064g runnableC0064g = this.f16916A;
            removeCallbacks(runnableC0064g);
            postDelayed(runnableC0064g, 1000L);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        Rect rect = this.f16922r;
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            try {
                if (this.f16921q != null) {
                    int width = getWidth();
                    int height = getHeight();
                    if (Utilities.f16755p) {
                        rect.set(0, 0, width, height);
                        setClipBounds(rect);
                    }
                    int[] iArr = this.f16923s;
                    if (iArr != null && iArr.length != 0) {
                        getLocationOnScreen(iArr);
                        int i10 = iArr[0];
                        if (i10 >= 0 && iArr[1] >= 0) {
                            if (this.f16924t != i10) {
                                this.f16924t = i10;
                                this.f16921q.m9543c(i10 % this.f16928x);
                            }
                            int i11 = this.f16925u;
                            int i12 = iArr[1];
                            if (i11 != i12) {
                                this.f16925u = i12;
                                SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f16921q;
                                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20537q = i12 % this.f16929y;
                                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.invalidateSelf();
                            }
                        }
                    }
                    RectF rectF = this.f16927w;
                    rectF.set(0.0f, 0.0f, width, height);
                    Path path = this.f16926v;
                    float f6 = this.f16920p;
                    path.addRoundRect(rectF, f6, f6, Path.Direction.CW);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public void setClockView(boolean z5) {
        this.f16918n = z5;
        this.f16930z = z5;
    }

    public void setTint(int i6) {
        int i7;
        Objects.toString(getBackground());
        if (getBackground() != null) {
            if (getBackground() instanceof FastBitmapDrawable) {
                ((FastBitmapDrawable) getBackground()).m7685g(i6);
                return;
            }
            if (getBackground() instanceof C0069l) {
                C0069l c0069l = (C0069l) getBackground();
                c0069l.getClass();
                if (i6 == -1) {
                    i6 = -1;
                } else if (i6 == 0) {
                    i6 = -7829368;
                }
                c0069l.f200s.setColor(i6);
                return;
            }
            if (getBackground() instanceof C0068k) {
                C0068k c0068k = (C0068k) getBackground();
                c0068k.getClass();
                if (i6 == -1) {
                    i7 = -1;
                } else {
                    i7 = i6 == 0 ? -16777216 : i6;
                }
                c0068k.f185m.setColor(i7);
                c0068k.f187o.setColor(i6 != 0 ? -16777216 : -1);
                c0068k.invalidateSelf();
            }
        }
    }
}
