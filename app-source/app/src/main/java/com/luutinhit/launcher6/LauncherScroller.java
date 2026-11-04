package com.luutinhit.launcher6;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;

/* JADX INFO: renamed from: com.luutinhit.launcher6.E2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherScroller {

    /* JADX INFO: renamed from: A */
    public static final float f15527A;

    /* JADX INFO: renamed from: B */
    public static float f15528B;

    /* JADX INFO: renamed from: x */
    public static final float f15529x = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: y */
    public static final float[] f15530y = new float[101];

    /* JADX INFO: renamed from: z */
    public static final float[] f15531z = new float[101];

    /* JADX INFO: renamed from: a */
    public int f15532a;

    /* JADX INFO: renamed from: b */
    public int f15533b;

    /* JADX INFO: renamed from: c */
    public int f15534c;

    /* JADX INFO: renamed from: d */
    public int f15535d;

    /* JADX INFO: renamed from: e */
    public int f15536e;

    /* JADX INFO: renamed from: f */
    public int f15537f;

    /* JADX INFO: renamed from: g */
    public int f15538g;

    /* JADX INFO: renamed from: h */
    public int f15539h;

    /* JADX INFO: renamed from: i */
    public int f15540i;

    /* JADX INFO: renamed from: j */
    public long f15541j;

    /* JADX INFO: renamed from: k */
    public int f15542k;

    /* JADX INFO: renamed from: l */
    public float f15543l;

    /* JADX INFO: renamed from: m */
    public float f15544m;

    /* JADX INFO: renamed from: n */
    public float f15545n;

    /* JADX INFO: renamed from: o */
    public boolean f15546o;

    /* JADX INFO: renamed from: p */
    public TimeInterpolator f15547p;

    /* JADX INFO: renamed from: q */
    public boolean f15548q;

    /* JADX INFO: renamed from: r */
    public float f15549r;

    /* JADX INFO: renamed from: s */
    public float f15550s;

    /* JADX INFO: renamed from: t */
    public int f15551t;

    /* JADX INFO: renamed from: u */
    public float f15552u;

    /* JADX INFO: renamed from: v */
    public float f15553v;

    /* JADX INFO: renamed from: w */
    public float f15554w;

    static {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15 = 0.0f;
        float f16 = 0.0f;
        int i6 = 0;
        spline: while (true) {
            float f17 = 1.0f;
            if (i6 >= 100) {
                float[] fArr = f15530y;
                f15531z[100] = 1.0f;
                fArr[100] = 1.0f;
                f15527A = 8.0f;
                f15528B = 1.0f;
                f15528B = 1.0f / viscousFluid(1.0f);
                break spline;
            }
            float f18 = i6 / 100.0f;
            float f19 = 1.0f;
            while (true) {
                f6 = ((f19 - f15) / 2.0f) + f15;
                f7 = f17 - f6;
                f8 = f6 * 3.0f * f7;
                f9 = f6 * f6 * f6;
                float f20 = (((f6 * 0.35000002f) + (f7 * 0.175f)) * f8) + f9;
                f10 = f18;
                if (Math.abs(f20 - f18) < 1.0E-5d) {
                    break;
                }
                if (f20 > f10) {
                    f19 = f6;
                } else {
                    f15 = f6;
                }
                f18 = f10;
                f17 = 1.0f;
            }
            f15530y[i6] = (((f7 * 0.5f) + f6) * f8) + f9;
            float f21 = 1.0f;
            while (true) {
                f11 = ((f21 - f16) / 2.0f) + f16;
                f12 = 1.0f - f11;
                f13 = f11 * 3.0f * f12;
                f14 = f11 * f11 * f11;
                float f22 = (((f12 * 0.5f) + f11) * f13) + f14;
                if (Math.abs(f22 - f10) < 1.0E-5d) {
                    break;
                } else if (f22 > f10) {
                    f21 = f11;
                } else {
                    f16 = f11;
                }
            }
            f15531z[i6] = (((f11 * 0.35000002f) + (f12 * 0.175f)) * f13) + f14;
            i6++;
        }
    }

    public LauncherScroller(Context context) {
        boolean z5 = context.getApplicationInfo().targetSdkVersion >= 11;
        this.f15552u = ViewConfiguration.getScrollFriction();
        this.f15546o = true;
        this.f15547p = null;
        float f6 = context.getResources().getDisplayMetrics().density * 160.0f;
        this.f15553v = f6 * 386.0878f * ViewConfiguration.getScrollFriction();
        this.f15548q = z5;
        this.f15554w = f6 * 386.0878f * 0.84f;
    }

    /* JADX INFO: renamed from: b */
    public static float viscousFluid(float f6) {
        float f7 = f6 * f15527A;
        return (f7 < 1.0f ? f7 - (1.0f - ((float) Math.exp(-f7))) : SyntheticHelpers.m7906e(1.0f, (float) Math.exp(1.0f - f7), 0.63212055f, 0.36787945f)) * f15528B;
    }

    /* JADX INFO: renamed from: a */
    public final void startScroll(int i6, int i7, int i8) {
        this.f15532a = 0;
        this.f15546o = false;
        this.f15542k = i8;
        this.f15541j = AnimationUtils.currentAnimationTimeMillis();
        this.f15533b = i6;
        this.f15534c = 0;
        this.f15535d = i6 + i7;
        this.f15536e = 0;
        this.f15544m = i7;
        this.f15545n = 0;
        this.f15543l = 1.0f / this.f15542k;
    }
}
