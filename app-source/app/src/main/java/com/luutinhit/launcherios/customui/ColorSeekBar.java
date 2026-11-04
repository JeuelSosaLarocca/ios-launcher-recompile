package com.luutinhit.launcherios.customui;

import J3.C0546e;
import O3.AbstractC0744e;
import U3.InterfaceC1102d;
import U3.InterfaceC1103e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.luutinhit.launcher6.editscreen.SlidingUpCustomizeColorIconStyle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ColorSeekBar extends View {

    /* JADX INFO: renamed from: A */
    public float f17554A;

    /* JADX INFO: renamed from: B */
    public float f17555B;

    /* JADX INFO: renamed from: C */
    public int f17556C;

    /* JADX INFO: renamed from: D */
    public LinearGradient f17557D;

    /* JADX INFO: renamed from: E */
    public Paint f17558E;

    /* JADX INFO: renamed from: F */
    public Paint f17559F;

    /* JADX INFO: renamed from: G */
    public Paint f17560G;

    /* JADX INFO: renamed from: H */
    public Paint f17561H;

    /* JADX INFO: renamed from: I */
    public int f17562I;

    /* JADX INFO: renamed from: J */
    public int f17563J;

    /* JADX INFO: renamed from: K */
    public int f17564K;

    /* JADX INFO: renamed from: L */
    public int f17565L;

    /* JADX INFO: renamed from: M */
    public int f17566M;

    /* JADX INFO: renamed from: N */
    public RectF f17567N;

    /* JADX INFO: renamed from: O */
    public int f17568O;

    /* JADX INFO: renamed from: P */
    public int f17569P;

    /* JADX INFO: renamed from: Q */
    public int f17570Q;

    /* JADX INFO: renamed from: R */
    public int f17571R;

    /* JADX INFO: renamed from: S */
    public int f17572S;

    /* JADX INFO: renamed from: T */
    public int f17573T;

    /* JADX INFO: renamed from: U */
    public ArrayList f17574U;

    /* JADX INFO: renamed from: V */
    public int f17575V;

    /* JADX INFO: renamed from: W */
    public boolean f17576W;

    /* JADX INFO: renamed from: a0 */
    public boolean f23553a0;

    /* JADX INFO: renamed from: b0 */
    public LinearGradient f23554b0;

    /* JADX INFO: renamed from: c0 */
    public int[] f23555c0;

    /* JADX INFO: renamed from: d0 */
    public int f23556d0;

    /* JADX INFO: renamed from: e0 */
    public int f23557e0;

    /* JADX INFO: renamed from: f0 */
    public int f23558f0;

    /* JADX INFO: renamed from: j */
    public int f17577j;

    /* JADX INFO: renamed from: k */
    public int[] f17578k;

    /* JADX INFO: renamed from: l */
    public int f17579l;

    /* JADX INFO: renamed from: m */
    public int f17580m;

    /* JADX INFO: renamed from: n */
    public int f17581n;

    /* JADX INFO: renamed from: o */
    public int f17582o;

    /* JADX INFO: renamed from: p */
    public float f17583p;

    /* JADX INFO: renamed from: q */
    public float f17584q;

    /* JADX INFO: renamed from: r */
    public InterfaceC1102d f17585r;

    /* JADX INFO: renamed from: s */
    public Context f17586s;

    /* JADX INFO: renamed from: t */
    public boolean f17587t;

    /* JADX INFO: renamed from: u */
    public boolean f17588u;

    /* JADX INFO: renamed from: v */
    public boolean f17589v;

    /* JADX INFO: renamed from: w */
    public boolean f17590w;

    /* JADX INFO: renamed from: x */
    public Bitmap f17591x;

    /* JADX INFO: renamed from: y */
    public RectF f17592y;

    /* JADX INFO: renamed from: z */
    public int f17593z;

    public ColorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17577j = -1;
        this.f17578k = new int[]{-16777216, -6749953, -16776961, -16711936, -16711681, -65536, -65281, -39424, -256, -1, -16777216};
        this.f17587t = false;
        this.f17593z = 20;
        this.f17556C = 2;
        new Paint();
        this.f17559F = new Paint();
        this.f17560G = new Paint();
        this.f17561H = new Paint();
        new Paint();
        this.f17570Q = 5;
        this.f17574U = new ArrayList();
        this.f17575V = -1;
        this.f17576W = false;
        this.f23553a0 = true;
        this.f23556d0 = -1;
        this.f23557e0 = -1;
        this.f23558f0 = -1;
        this.f17586s = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2243g, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f17566M = typedArrayObtainStyledAttributes.getInteger(7, 256);
        this.f17568O = typedArrayObtainStyledAttributes.getInteger(4, 0);
        this.f17569P = typedArrayObtainStyledAttributes.getInteger(0, 0);
        this.f17588u = typedArrayObtainStyledAttributes.getBoolean(6, false);
        this.f17587t = typedArrayObtainStyledAttributes.getBoolean(8, false);
        this.f17577j = typedArrayObtainStyledAttributes.getColor(3, 0);
        this.f17556C = (int) typedArrayObtainStyledAttributes.getDimension(1, m8342b(30.0f));
        this.f17593z = (int) typedArrayObtainStyledAttributes.getDimension(9, m8342b(28.0f));
        this.f17570Q = (int) typedArrayObtainStyledAttributes.getDimension(2, m8342b(5.0f));
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            this.f17578k = m8343c(resourceId);
        }
        setBackgroundColor(this.f17577j);
    }

    /* JADX INFO: renamed from: f */
    public static int m8340f(int i6, float f6, int i7) {
        return Math.round(f6 * (i7 - i6)) + i6;
    }

    /* JADX INFO: renamed from: a */
    public final void m8341a() {
        if (this.f17565L < 1) {
            return;
        }
        ArrayList arrayList = this.f17574U;
        arrayList.clear();
        for (int i6 = 0; i6 <= this.f17566M; i6++) {
            arrayList.add(Integer.valueOf(m8346g(i6)));
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m8342b(float f6) {
        return (int) ((f6 * this.f17586s.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: renamed from: c */
    public final int[] m8343c(int i6) {
        int i7 = 0;
        if (isInEditMode()) {
            String[] stringArray = this.f17586s.getResources().getStringArray(i6);
            int[] iArr = new int[stringArray.length];
            while (i7 < stringArray.length) {
                iArr[i7] = Color.parseColor(stringArray[i7]);
                i7++;
            }
            return iArr;
        }
        TypedArray typedArrayObtainTypedArray = this.f17586s.getResources().obtainTypedArray(i6);
        int[] iArr2 = new int[typedArrayObtainTypedArray.length()];
        while (i7 < typedArrayObtainTypedArray.length()) {
            iArr2[i7] = typedArrayObtainTypedArray.getColor(i7, -16777216);
            i7++;
        }
        typedArrayObtainTypedArray.recycle();
        return iArr2;
    }

    /* JADX INFO: renamed from: d */
    public final void m8344d() {
        float f6 = this.f17593z / 2.0f;
        this.f17554A = f6;
        this.f17571R = (int) f6;
        this.f17555B = f6 / 6.0f;
        int height = ((getHeight() - getPaddingBottom()) - this.f17571R) - (((int) this.f17555B) + 1);
        int width = ((getWidth() - getPaddingRight()) - this.f17571R) - ((int) this.f17555B);
        this.f17562I = ((int) this.f17555B) + 1 + getPaddingLeft() + this.f17571R;
        if (!this.f17588u) {
            height = width;
        }
        this.f17563J = height;
        this.f17564K = getPaddingTop() + this.f17571R + ((int) this.f17555B);
        this.f17565L = this.f17563J - this.f17562I;
        float f7 = this.f17562I;
        int i6 = this.f17564K;
        this.f17592y = new RectF(f7, i6, this.f17563J, i6 + this.f17556C);
        int i7 = this.f17593z + this.f17556C + this.f17570Q;
        this.f17567N = new RectF(this.f17562I, i7, this.f17563J, i7 + this.f17556C);
        this.f17557D = new LinearGradient(0.0f, 0.0f, this.f17592y.width(), 0.0f, this.f17578k, (float[]) null, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.f17558E = paint;
        paint.setShader(this.f17557D);
        this.f17558E.setAntiAlias(true);
        Paint paint2 = this.f17561H;
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(this.f17555B);
        paint2.setColor(-1);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.f23555c0 = new int[2];
        m8341a();
    }

    /* JADX INFO: renamed from: e */
    public final boolean m8345e(RectF rectF, float f6, float f7) {
        try {
            float f8 = rectF.left;
            float f9 = this.f17554A;
            return f8 - f9 < f6 && f6 < rectF.right + f9 && rectF.top - f9 < f7 && f7 < rectF.bottom + f9;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    /* JADX INFO: renamed from: g */
    public final int m8346g(int i6) {
        float f6 = i6 / this.f17566M;
        float f7 = this.f17565L;
        float f8 = (f6 * f7) / f7;
        if (f8 <= 0.0d) {
            return this.f17578k[0];
        }
        if (f8 >= 1.0f) {
            int[] iArr = this.f17578k;
            return iArr[iArr.length - 1];
        }
        int[] iArr2 = this.f17578k;
        float length = f8 * (iArr2.length - 1);
        int i7 = (int) length;
        float f9 = length - i7;
        int i8 = iArr2[i7];
        this.f17579l = i8;
        this.f17580m = iArr2[i7 + 1];
        this.f17581n = m8340f(Color.red(i8), f9, Color.red(this.f17580m));
        this.f17582o = m8340f(Color.green(this.f17579l), f9, Color.green(this.f17580m));
        return Color.rgb(this.f17581n, this.f17582o, m8340f(Color.blue(this.f17579l), f9, Color.blue(this.f17580m)));
    }

    public int getAlphaBarPosition() {
        return this.f17569P;
    }

    public int getColor() {
        int i6 = this.f17568O;
        ArrayList arrayList = this.f17574U;
        if (i6 >= arrayList.size()) {
            return m8346g(this.f17568O);
        }
        int i7 = this.f23556d0;
        return (i7 == -1 || i7 != this.f17568O) ? ((Integer) arrayList.get(this.f17568O)).intValue() : ((Integer) arrayList.get(i7)).intValue();
    }

    public int getColorWhite() {
        float f6 = this.f17569P / 255.0f;
        float f7 = this.f17565L;
        float f8 = (f6 * f7) / f7;
        if (f8 <= 0.0d) {
            return this.f23555c0[0];
        }
        if (f8 >= 1.0f) {
            int[] iArr = this.f23555c0;
            return iArr[iArr.length - 1];
        }
        int[] iArr2 = this.f23555c0;
        float length = f8 * (iArr2.length - 1);
        int i6 = (int) length;
        float f9 = length - i6;
        int i7 = iArr2[i6];
        this.f17579l = i7;
        this.f17580m = iArr2[i6 + 1];
        this.f17581n = m8340f(Color.red(i7), f9, Color.red(this.f17580m));
        this.f17582o = m8340f(Color.green(this.f17579l), f9, Color.green(this.f17580m));
        return Color.rgb(this.f17581n, this.f17582o, m8340f(Color.blue(this.f17579l), f9, Color.blue(this.f17580m)));
    }

    public List<Integer> getColors() {
        return this.f17574U;
    }

    public int getMaxValue() {
        return this.f17566M;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f17588u) {
            canvas.rotate(-90.0f);
            canvas.translate(-getHeight(), 0.0f);
            canvas.scale(-1.0f, 1.0f, getHeight() / 2.0f, getWidth() / 2.0f);
        }
        int i6 = this.f17568O;
        float f6 = (i6 / this.f17566M) * this.f17565L;
        if (this.f23556d0 != i6) {
            int color = getColor();
            this.f23558f0 = color;
            int[] iArr = this.f23555c0;
            iArr[0] = color;
            iArr[1] = -1;
            this.f23556d0 = this.f17568O;
        }
        int i7 = this.f23558f0;
        Paint paint = this.f17559F;
        paint.setColor(i7);
        canvas.drawColor(this.f17577j);
        RectF rectF = this.f17592y;
        float f7 = this.f17554A;
        canvas.drawRoundRect(rectF, f7, f7, this.f17558E);
        float f8 = f6 + this.f17562I;
        RectF rectF2 = this.f17592y;
        float fHeight = (rectF2.height() / 2.0f) + rectF2.top;
        canvas.drawCircle(f8, fHeight, (this.f17556C / 2.0f) + 5.0f, paint);
        float f9 = (this.f17556C / 2.0f) + 5.0f;
        Paint paint2 = this.f17561H;
        canvas.drawCircle(f8, fHeight, f9, paint2);
        if (this.f17587t) {
            Paint paint3 = this.f17560G;
            paint3.setAntiAlias(true);
            if (this.f23557e0 != this.f17569P) {
                getColorWhite();
                paint.setColor(getColorWhite());
                this.f23557e0 = this.f17569P;
            }
            float f10 = ((this.f17569P / 255.0f) * this.f17565L) + this.f17562I;
            RectF rectF3 = this.f17567N;
            float fHeight2 = (rectF3.height() / 2.0f) + rectF3.top;
            if (this.f23554b0 == null || paint3.getColor() != this.f23558f0) {
                this.f23554b0 = new LinearGradient(0.0f, 0.0f, this.f17567N.width(), 0.0f, this.f23555c0, (float[]) null, Shader.TileMode.CLAMP);
            }
            paint3.setShader(this.f23554b0);
            RectF rectF4 = this.f17567N;
            float f11 = this.f17554A;
            canvas.drawRoundRect(rectF4, f11, f11, paint3);
            canvas.drawCircle(f10, fHeight2, (this.f17556C / 2.0f) + 5.0f, paint);
            canvas.drawCircle(f10, fHeight2, (this.f17556C / 2.0f) + 5.0f, paint2);
        }
        if (this.f23553a0) {
            this.f23553a0 = false;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        this.f17572S = i6;
        this.f17573T = i7;
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        boolean z5 = this.f17587t;
        int i8 = this.f17556C;
        if (z5) {
            i8 *= 2;
        }
        int i9 = z5 ? this.f17593z * 2 : this.f17593z;
        if (this.f17588u) {
            if (mode == Integer.MIN_VALUE || mode == 0) {
                int i10 = i9 + i8 + this.f17570Q;
                this.f17572S = i10;
                setMeasuredDimension(i10, this.f17573T);
                return;
            }
            return;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int i11 = i9 + i8 + this.f17570Q;
            this.f17573T = i11;
            setMeasuredDimension(this.f17572S, i11);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        try {
            if (this.f17588u) {
                this.f17591x = Bitmap.createBitmap(i7, i6, Bitmap.Config.ARGB_8888);
            } else {
                this.f17591x = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
            }
            this.f17591x.eraseColor(0);
            m8344d();
            this.f17576W = true;
            int i10 = this.f17575V;
            if (i10 != -1) {
                setColor(i10);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        this.f17583p = this.f17588u ? motionEvent.getY() : motionEvent.getX();
        this.f17584q = this.f17588u ? motionEvent.getX() : motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f17589v = false;
                this.f17590w = false;
                return true;
            }
            if (action == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                boolean z5 = this.f17589v;
                if (z5) {
                    float f6 = (this.f17583p - this.f17562I) / this.f17565L;
                    int i6 = this.f17566M;
                    int i7 = (int) (f6 * i6);
                    this.f17568O = i7;
                    if (i7 < 0) {
                        this.f17568O = 0;
                    }
                    if (this.f17568O > i6) {
                        this.f17568O = i6;
                    }
                } else if (this.f17587t && this.f17590w) {
                    int i8 = (int) (((this.f17583p - this.f17562I) / this.f17565L) * 255.0f);
                    this.f17569P = i8;
                    if (i8 < 0) {
                        this.f17569P = 0;
                    }
                    if (this.f17569P > 255) {
                        this.f17569P = 255;
                    }
                }
                InterfaceC1102d interfaceC1102d = this.f17585r;
                if (interfaceC1102d != null && (this.f17590w || z5)) {
                    C0546e c0546e = (C0546e) interfaceC1102d;
                    SlidingUpCustomizeColorIconStyle.m8029u((SlidingUpCustomizeColorIconStyle) c0546e.f1684k, (Bitmap) c0546e.f1685l, getColorWhite());
                }
                invalidate();
                return true;
            }
        } else {
            if (m8345e(this.f17592y, this.f17583p, this.f17584q)) {
                this.f17589v = true;
                return true;
            }
            if (this.f17587t && m8345e(this.f17567N, this.f17583p, this.f17584q)) {
                this.f17590w = true;
            }
        }
        return true;
    }

    public void setAlphaBarPosition(int i6) {
        this.f17569P = i6;
        invalidate();
    }

    public void setBarHeight(float f6) {
        this.f17556C = m8342b(f6);
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setBarHeightPx(int i6) {
        this.f17556C = i6;
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setBarMargin(float f6) {
        this.f17570Q = m8342b(f6);
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setBarMarginPx(int i6) {
        this.f17570Q = i6;
        setLayoutParams(getLayoutParams());
        invalidate();
    }

    public void setColor(int i6) {
        int iRgb = Color.rgb(Color.red(i6), Color.green(i6), Color.blue(i6));
        if (this.f17576W) {
            setColorBarPosition(this.f17574U.indexOf(Integer.valueOf(iRgb)));
        } else {
            this.f17575V = i6;
        }
    }

    public void setColorBarPosition(int i6) {
        this.f17568O = i6;
        int iMin = Math.min(i6, this.f17566M);
        this.f17568O = iMin;
        this.f17568O = Math.max(iMin, 0);
        invalidate();
        InterfaceC1102d interfaceC1102d = this.f17585r;
        if (interfaceC1102d != null) {
            C0546e c0546e = (C0546e) interfaceC1102d;
            SlidingUpCustomizeColorIconStyle.m8029u((SlidingUpCustomizeColorIconStyle) c0546e.f1684k, (Bitmap) c0546e.f1685l, getColorWhite());
        }
    }

    public void setColorSeeds(int i6) {
        setColorSeeds(m8343c(i6));
    }

    public void setMaxPosition(int i6) {
        this.f17566M = i6;
        invalidate();
        m8341a();
    }

    public void setOnColorChangeListener(InterfaceC1102d interfaceC1102d) {
        this.f17585r = interfaceC1102d;
    }

    public void setShowAlphaBar(boolean z5) {
        this.f17587t = z5;
        setLayoutParams(getLayoutParams());
        invalidate();
        InterfaceC1102d interfaceC1102d = this.f17585r;
        if (interfaceC1102d != null) {
            C0546e c0546e = (C0546e) interfaceC1102d;
            SlidingUpCustomizeColorIconStyle.m8029u((SlidingUpCustomizeColorIconStyle) c0546e.f1684k, (Bitmap) c0546e.f1685l, getColorWhite());
        }
    }

    public void setColorSeeds(int[] iArr) {
        this.f17578k = iArr;
        invalidate();
        m8341a();
        InterfaceC1102d interfaceC1102d = this.f17585r;
        if (interfaceC1102d != null) {
            C0546e c0546e = (C0546e) interfaceC1102d;
            SlidingUpCustomizeColorIconStyle.m8029u((SlidingUpCustomizeColorIconStyle) c0546e.f1684k, (Bitmap) c0546e.f1685l, getColorWhite());
        }
    }

    public void setOnInitDoneListener(InterfaceC1103e interfaceC1103e) {
    }
}
