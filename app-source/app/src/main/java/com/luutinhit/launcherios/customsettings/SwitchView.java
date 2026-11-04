package com.luutinhit.launcherios.customsettings;

import O3.AbstractC0744e;
import T3.C1068h;
import T3.InterfaceC1067g;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.luutinhit.launcher6.SyntheticHelpers;

/* JADX INFO: loaded from: classes.dex */
public class SwitchView extends View {

    /* JADX INFO: renamed from: A */
    public float f17523A;

    /* JADX INFO: renamed from: B */
    public float f17524B;

    /* JADX INFO: renamed from: C */
    public float f17525C;

    /* JADX INFO: renamed from: D */
    public float f17526D;

    /* JADX INFO: renamed from: E */
    public float f17527E;

    /* JADX INFO: renamed from: F */
    public float f17528F;

    /* JADX INFO: renamed from: G */
    public float f17529G;

    /* JADX INFO: renamed from: H */
    public float f17530H;

    /* JADX INFO: renamed from: I */
    public float f17531I;

    /* JADX INFO: renamed from: J */
    public float f17532J;

    /* JADX INFO: renamed from: K */
    public float f17533K;

    /* JADX INFO: renamed from: L */
    public float f17534L;

    /* JADX INFO: renamed from: M */
    public float f17535M;

    /* JADX INFO: renamed from: N */
    public InterfaceC1067g f17536N;

    /* JADX INFO: renamed from: j */
    public AccelerateInterpolator f17537j;

    /* JADX INFO: renamed from: k */
    public Paint f17538k;

    /* JADX INFO: renamed from: l */
    public Path f17539l;

    /* JADX INFO: renamed from: m */
    public Path f17540m;

    /* JADX INFO: renamed from: n */
    public RectF f17541n;

    /* JADX INFO: renamed from: o */
    public float f17542o;

    /* JADX INFO: renamed from: p */
    public float f17543p;

    /* JADX INFO: renamed from: q */
    public boolean f17544q;

    /* JADX INFO: renamed from: r */
    public boolean f17545r;

    /* JADX INFO: renamed from: s */
    public float f17546s;

    /* JADX INFO: renamed from: t */
    public float f17547t;

    /* JADX INFO: renamed from: u */
    public int f17548u;

    /* JADX INFO: renamed from: v */
    public int f17549v;

    /* JADX INFO: renamed from: w */
    public boolean f17550w;

    /* JADX INFO: renamed from: x */
    public View.OnClickListener f17551x;

    /* JADX INFO: renamed from: y */
    public float f17552y;

    /* JADX INFO: renamed from: z */
    public float f17553z;

    public SwitchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17537j = new AccelerateInterpolator(2.0f);
        this.f17538k = new Paint();
        this.f17539l = new Path();
        this.f17540m = new Path();
        this.f17541n = new RectF();
        this.f17542o = 0.66f;
        this.f17543p = 0.03f;
        this.f17550w = false;
        setLayerType(1, null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2232C);
        this.f17542o = typedArrayObtainStyledAttributes.getFloat(2, 0.66f);
        this.f17544q = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.f17545r = typedArrayObtainStyledAttributes.getBoolean(0, true);
        int i6 = this.f17544q ? 4 : 1;
        this.f17548u = i6;
        this.f17549v = i6;
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    public final void m8338a(int i6) {
        boolean z5 = this.f17544q;
        if (!z5 && i6 == 4) {
            this.f17544q = true;
        } else if (z5 && i6 == 1) {
            this.f17544q = false;
        }
        this.f17549v = this.f17548u;
        this.f17548u = i6;
        postInvalidate();
    }

    /* JADX INFO: renamed from: b */
    public final void m8339b(boolean z5) {
        InterfaceC1067g interfaceC1067g = this.f17536N;
        if (interfaceC1067g != null) {
            interfaceC1067g.mo909g(z5);
        }
        int i6 = z5 ? 4 : 1;
        int i7 = this.f17548u;
        if (i6 == i7) {
            return;
        }
        if ((i6 == 4 && (i7 == 1 || i7 == 2)) || (i6 == 1 && (i7 == 4 || i7 == 3))) {
            this.f17546s = 1.0f;
        }
        this.f17547t = 1.0f;
        m8338a(i6);
    }

    /* JADX WARN: Code duplicated, block: B:67:0x010d  */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        float fM7906e;
        float f6 = 0.0f;
        float f7 = 0.0f;
        super.onDraw(canvas);
        if (this.f17550w) {
            Paint paint = this.f17538k;
            paint.setAntiAlias(true);
            int i6 = this.f17548u;
            boolean z5 = i6 == 4 || i6 == 3;
            Paint.Style style = Paint.Style.FILL;
            paint.setStyle(style);
            if (this.f17545r) {
                paint.setColor(z5 ? -11806877 : -1842205);
            } else {
                paint.setColor(-1776412);
            }
            Path path = this.f17539l;
            canvas.drawPath(path, paint);
            float f8 = this.f17546s;
            float f9 = this.f17543p;
            float f10 = f8 - f9 > 0.0f ? f8 - f9 : 0.0f;
            this.f17546s = f10;
            float f11 = this.f17547t;
            this.f17547t = f11 - f9 > 0.0f ? f11 - f9 : 0.0f;
            AccelerateInterpolator accelerateInterpolator = this.f17537j;
            float interpolation = accelerateInterpolator.getInterpolation(f10);
            float interpolation2 = accelerateInterpolator.getInterpolation(this.f17547t);
            float f12 = this.f17524B * (z5 ? interpolation : 1.0f - interpolation);
            float f13 = (this.f17552y - this.f17553z) - this.f17526D;
            if (z5) {
                interpolation = 1.0f - interpolation;
            }
            canvas.save();
            canvas.scale(f12, f12, this.f17553z + (f13 * interpolation), this.f17523A);
            paint.setColor(this.f17545r ? -1 : -1776412);
            canvas.drawPath(path, paint);
            canvas.restore();
            canvas.save();
            int i7 = this.f17548u;
            int i8 = i7 - this.f17549v;
            if (i8 == -3) {
                float f14 = this.f17534L;
                fM7906e = SyntheticHelpers.m7906e(this.f17531I, f14, interpolation2, f14);
            } else if (i8 != -2) {
                if (i8 != -1) {
                    if (i8 != 1) {
                        if (i8 == 2) {
                            if (i7 == 4) {
                                f6 = this.f17531I;
                                f7 = this.f17534L;
                            } else if (i7 == 3) {
                                f6 = this.f17532J;
                                f7 = this.f17534L;
                            } else {
                                fM7906e = 0.0f;
                            }
                            fM7906e = f6 - ((f6 - f7) * interpolation2);
                        } else if (i8 == 3) {
                            f6 = this.f17531I;
                            f7 = this.f17534L;
                            fM7906e = f6 - ((f6 - f7) * interpolation2);
                        } else if (i7 == 1) {
                            fM7906e = this.f17534L;
                        } else if (i7 == 4) {
                            fM7906e = this.f17531I;
                        } else {
                            fM7906e = 0.0f;
                        }
                    } else if (i7 == 2) {
                        fM7906e = this.f17534L;
                    } else if (i7 == 4) {
                        f6 = this.f17531I;
                        f7 = this.f17532J;
                        fM7906e = f6 - ((f6 - f7) * interpolation2);
                    } else {
                        fM7906e = 0.0f;
                    }
                } else if (i7 == 3) {
                    float f15 = this.f17532J;
                    fM7906e = SyntheticHelpers.m7906e(this.f17531I, f15, interpolation2, f15);
                } else if (i7 == 1) {
                    fM7906e = this.f17534L;
                } else {
                    fM7906e = 0.0f;
                }
            } else if (i7 == 1) {
                float f16 = this.f17534L;
                fM7906e = SyntheticHelpers.m7906e(this.f17532J, f16, interpolation2, f16);
            } else if (i7 == 2) {
                float f17 = this.f17533K;
                fM7906e = SyntheticHelpers.m7906e(this.f17531I, f17, interpolation2, f17);
            } else {
                fM7906e = 0.0f;
            }
            canvas.translate(fM7906e - this.f17534L, this.f17535M);
            int i9 = this.f17548u;
            if (i9 == 3 || i9 == 2) {
                interpolation2 = 1.0f - interpolation2;
            }
            Path path2 = this.f17540m;
            path2.reset();
            RectF rectF = this.f17541n;
            float f18 = this.f17529G;
            float f19 = this.f17527E / 2.0f;
            rectF.left = f18 + f19;
            rectF.right = this.f17530H - f19;
            path2.arcTo(rectF, 90.0f, 180.0f);
            float f20 = this.f17529G;
            float f21 = interpolation2 * this.f17525C;
            float f22 = this.f17527E / 2.0f;
            rectF.left = f20 + f21 + f22;
            rectF.right = (f21 + this.f17530H) - f22;
            path2.arcTo(rectF, 270.0f, 180.0f);
            path2.close();
            canvas.translate(0.0f, -this.f17535M);
            float f23 = this.f17528F;
            canvas.scale(0.96f, 0.96f, f23 / 2.0f, f23 / 2.0f);
            paint.setStyle(style);
            paint.setColor(z5 ? -1 : -1421507);
            canvas.drawPath(path2, paint);
            canvas.restore();
            paint.reset();
            if (this.f17546s > 0.0f || this.f17547t > 0.0f) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        int size = View.MeasureSpec.getSize(i6);
        int mode = View.MeasureSpec.getMode(i6);
        if (mode != 1073741824) {
            int paddingRight = getPaddingRight() + getPaddingLeft() + ((int) ((getResources().getDisplayMetrics().density * 56.0f) + 0.5f));
            size = mode == Integer.MIN_VALUE ? Math.min(paddingRight, size) : paddingRight;
        }
        int size2 = View.MeasureSpec.getSize(i7);
        int mode2 = View.MeasureSpec.getMode(i7);
        if (mode2 != 1073741824) {
            int paddingBottom = getPaddingBottom() + getPaddingTop() + ((int) (size * this.f17542o));
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(paddingBottom, size2) : paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        C1068h c1068h = (C1068h) parcelable;
        super.onRestoreInstanceState(c1068h.getSuperState());
        boolean z5 = c1068h.f3153j;
        this.f17544q = z5;
        this.f17548u = z5 ? 4 : 1;
        invalidate();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C1068h c1068h = new C1068h(super.onSaveInstanceState());
        c1068h.f3153j = this.f17544q;
        return c1068h;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5;
        int paddingLeft;
        int width;
        int paddingTop;
        int height;
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 > getPaddingRight() + getPaddingLeft()) {
            if (i7 > getPaddingBottom() + getPaddingTop()) {
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            z5 = false;
        }
        this.f17550w = z5;
        if (z5) {
            int paddingLeft2 = (i6 - getPaddingLeft()) - getPaddingRight();
            int paddingTop2 = (i7 - getPaddingTop()) - getPaddingBottom();
            float f6 = paddingLeft2;
            float f7 = this.f17542o;
            float f8 = paddingTop2;
            if (f6 * f7 < f8) {
                paddingLeft = getPaddingLeft();
                width = i6 - getPaddingRight();
                int i10 = ((int) (f8 - (f6 * f7))) / 2;
                paddingTop = getPaddingTop() + i10;
                height = (getHeight() - getPaddingBottom()) - i10;
            } else {
                int i11 = ((int) (f6 - (f8 / f7))) / 2;
                paddingLeft = getPaddingLeft() + i11;
                width = (getWidth() - getPaddingRight()) - i11;
                paddingTop = getPaddingTop();
                height = getHeight() - getPaddingBottom();
            }
            float f9 = (int) ((height - paddingTop) * 0.07f);
            this.f17535M = f9;
            float f10 = paddingLeft;
            float f11 = paddingTop + f9;
            float f12 = width;
            this.f17552y = f12;
            float f13 = height - f9;
            float f14 = f13 - f11;
            this.f17553z = (f12 + f10) / 2.0f;
            this.f17523A = (f13 + f11) / 2.0f;
            this.f17529G = f10;
            this.f17528F = f14;
            this.f17530H = f10 + f14;
            float f15 = f14 / 2.0f;
            float f16 = 0.95f * f15;
            this.f17526D = f16;
            float f17 = 0.2f * f16;
            this.f17525C = f17;
            float f18 = (f15 - f16) * 2.0f;
            this.f17527E = f18;
            float f19 = f12 - f14;
            this.f17531I = f19;
            this.f17532J = f19 - f17;
            this.f17534L = f10;
            this.f17533K = f17 + f10;
            this.f17524B = 1.0f - (f18 / f14);
            Path path = this.f17539l;
            path.reset();
            RectF rectF = new RectF();
            rectF.top = f11;
            rectF.bottom = f13;
            rectF.left = f10;
            rectF.right = f10 + f14;
            path.arcTo(rectF, 90.0f, 180.0f);
            float f20 = this.f17552y;
            rectF.left = f20 - f14;
            rectF.right = f20;
            path.arcTo(rectF, 270.0f, 180.0f);
            path.close();
            RectF rectF2 = this.f17541n;
            rectF2.left = this.f17529G;
            rectF2.right = this.f17530H;
            float f21 = this.f17527E;
            rectF2.top = (f21 / 2.0f) + f11;
            rectF2.bottom = f13 - (f21 / 2.0f);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f17545r) {
            return true;
        }
        int i6 = this.f17548u;
        if ((i6 == 4 || i6 == 1) && this.f17546s * this.f17547t == 0.0f) {
            int action = motionEvent.getAction();
            if (action == 0) {
                return true;
            }
            if (action == 1) {
                int i7 = this.f17548u;
                this.f17549v = i7;
                this.f17547t = 1.0f;
                if (i7 == 1) {
                    m8338a(2);
                    m8339b(true);
                } else if (i7 == 4) {
                    m8338a(3);
                    m8339b(false);
                }
                View.OnClickListener onClickListener = this.f17551x;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z5) {
        int i6 = z5 ? 4 : 1;
        if (i6 == this.f17548u) {
            return;
        }
        m8338a(i6);
    }

    public void setEnable(boolean z5) {
        this.f17545r = z5;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f17551x = onClickListener;
    }

    public void setOnSwitchChangeListener(InterfaceC1067g interfaceC1067g) {
        this.f17536N = interfaceC1067g;
    }
}
