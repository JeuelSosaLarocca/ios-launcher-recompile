package com.luutinhit.weather;

import p083h4.RunnableC2135c;
import p083h4.RunnableC2134b;
import B3.RunnableC0064g;
import H0.RunnableC0416n;
import L1.AbstractC0626a;
import P3.AbstractActivityC0816d;
import R4.AbstractC0965g;
import Y3.C1213c;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.C1416d;
import androidx.constraintlayout.widget.C1428p;
import androidx.fragment.app.C1469C;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.appslibrary.MergedCallbacks;
import com.luutinhit.launcher6.widget.IndicatorView;
import com.luutinhit.launcherios.R;
import com.luutinhit.weather.WeatherActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import p006H.AbstractC0401n;
import p083h4.AnimationAnimationListenerC2139g;
import p083h4.C2140h;
import p083h4.C2142j;
import p083h4.RunnableC2133a;
import p083h4.RunnableC2136d;
import p088i4.C2201f;
import p093j4.C2256b;
import p097k4.C2280b;
import p102l4.C2342a;
import p102l4.C2343b;
import p156z1.C3053d;

/* JADX INFO: loaded from: classes.dex */
public class WeatherActivity extends AbstractActivityC0816d implements View.OnClickListener {

    /* JADX INFO: renamed from: X */
    public static final /* synthetic */ int f17658X = 0;

    /* JADX INFO: renamed from: D */
    public Context f17659D;

    /* JADX INFO: renamed from: E */
    public ViewPager f17660E;

    /* JADX INFO: renamed from: F */
    public ImageView f17661F;

    /* JADX INFO: renamed from: G */
    public ConstraintWeatherLayout f17662G;

    /* JADX INFO: renamed from: H */
    public IndicatorView f17663H;

    /* JADX INFO: renamed from: I */
    public ArrayList f17664I = new ArrayList();

    /* JADX INFO: renamed from: J */
    public C2142j f17665J;

    /* JADX INFO: renamed from: K */
    public ArrayList f17666K;

    /* JADX INFO: renamed from: L */
    public C2256b f17667L;

    /* JADX INFO: renamed from: M */
    public C2256b f17668M;

    /* JADX INFO: renamed from: N */
    public C2256b f17669N;

    /* JADX INFO: renamed from: O */
    public C2280b f17670O;

    /* JADX INFO: renamed from: P */
    public int f17671P;

    /* JADX INFO: renamed from: Q */
    public int f17672Q;

    /* JADX INFO: renamed from: R */
    public int[] f17673R;

    /* JADX INFO: renamed from: S */
    public int[] f17674S;

    /* JADX INFO: renamed from: T */
    public int[] f17675T;

    /* JADX INFO: renamed from: U */
    public int[] f17676U;

    /* JADX INFO: renamed from: V */
    public Random f17677V;

    /* JADX INFO: renamed from: W */
    public AbstractC0626a f17678W;

    public WeatherActivity() {
        new ArrayList();
        this.f17666K = new ArrayList();
        this.f17673R = new int[]{R.drawable.cloud_1, R.drawable.cloud_2, R.drawable.cloud_3, R.drawable.cloud_4, R.drawable.cloud_5, R.drawable.cloud_6, R.drawable.cloud_7, R.drawable.cloud_8, R.drawable.cloud_9, R.drawable.cloud_10, R.drawable.cloud_11, R.drawable.cloud_12, R.drawable.cloud_13, R.drawable.cloud_14};
        this.f17674S = new int[]{R.drawable.cloud_1, R.drawable.cloud_9, R.drawable.cloud_10};
        this.f17675T = new int[]{R.drawable.cloud_7, R.drawable.cloud_8, R.drawable.cloud_11, R.drawable.cloud_12, R.drawable.cloud_13, R.drawable.cloud_14};
        this.f17676U = new int[]{R.drawable.weather_lighting_1, R.drawable.weather_lighting_2, R.drawable.weather_lighting_3, R.drawable.weather_lighting_5, R.drawable.weather_lighting_6, R.drawable.weather_lighting_8};
        this.f17677V = new Random();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: K */
    public final void m8361K(int i6, boolean z5, int[] iArr) {
        for (int i7 = 0; i7 < i6; i7++) {
            ImageFilterView imageFilterView = new ImageFilterView(this);
            int iGenerateViewId = View.generateViewId();
            imageFilterView.setId(iGenerateViewId);
            Random random = this.f17677V;
            imageFilterView.setImageResource(iArr[random.nextInt(iArr.length)]);
            if (z5) {
                imageFilterView.setAlpha(0.6f);
                imageFilterView.setContrast(0.9f);
                imageFilterView.setBrightness(0.6f);
                imageFilterView.setWarmth(1.0f);
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.1f, 2, -1.1f, 2, (random.nextFloat() - 0.8f) / 3.0f, 2, (random.nextFloat() - 0.8f) / 3.0f);
            translateAnimation.setFillEnabled(true);
            translateAnimation.setFillAfter(true);
            translateAnimation.setStartOffset(((long) i7) * 5000);
            translateAnimation.setDuration((random.nextInt(5) + 1) * 36000);
            translateAnimation.setInterpolator(new PathInterpolator(0.15f, 0.5f, 0.8f, 0.5f));
            translateAnimation.setRepeatCount(-1);
            if (random.nextBoolean()) {
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, -1.1f, 2, (random.nextFloat() - 0.8f) / 3.0f, 2, (random.nextFloat() - 0.8f) / 3.0f);
                translateAnimation2.setDuration((random.nextInt(5) + 1) * 36000);
                translateAnimation2.setInterpolator(new PathInterpolator(0.15f, 0.5f, 0.8f, 0.5f));
                translateAnimation2.setAnimationListener(new AnimationAnimationListenerC2139g(imageFilterView, translateAnimation));
                imageFilterView.startAnimation(translateAnimation2);
            } else {
                imageFilterView.startAnimation(translateAnimation);
            }
            this.f17662G.addView(imageFilterView, 1);
            ArrayList arrayList = this.f17666K;
            arrayList.add(Integer.valueOf(iGenerateViewId));
            arrayList.size();
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m8362L(int i6) {
        C2256b c2256b = (C2256b) findViewById(R.id.weather_drizzle_effect);
        this.f17667L = c2256b;
        if (c2256b != null) {
            this.f17662G.removeView(c2256b);
        } else {
            C2256b c2256b2 = new C2256b(this);
            this.f17667L = c2256b2;
            c2256b2.setId(R.id.weather_drizzle_effect);
        }
        this.f17662G.addView(this.f17667L, 1);
        this.f17667L.post(new RunnableC0416n(i6, 11, this));
    }

    /* JADX INFO: renamed from: M */
    public final void m8363M(int i6) {
        C2256b c2256b = (C2256b) findViewById(R.id.weather_rain_effect);
        this.f17668M = c2256b;
        if (c2256b != null) {
            this.f17662G.removeView(c2256b);
        } else {
            C2256b c2256b2 = new C2256b(this);
            this.f17668M = c2256b2;
            c2256b2.setId(R.id.weather_rain_effect);
        }
        this.f17662G.addView(this.f17668M, 1);
        this.f17668M.post(new RunnableC2136d(this, i6, 0));
    }

    /* JADX INFO: renamed from: N */
    public final void m8364N(int i6) {
        C2256b c2256b = (C2256b) findViewById(R.id.weather_sleet_effect);
        this.f17669N = c2256b;
        if (c2256b != null) {
            this.f17662G.removeView(c2256b);
        } else {
            C2256b c2256b2 = new C2256b(this);
            this.f17669N = c2256b2;
            c2256b2.setId(R.id.weather_sleet_effect);
        }
        this.f17662G.addView(this.f17669N, 1);
        this.f17669N.post(new RunnableC2136d(this, i6, 2));
    }

    /* JADX INFO: renamed from: O */
    public final void m8365O(int i6) {
        C2280b c2280b = (C2280b) findViewById(R.id.weather_snow_effect);
        this.f17670O = c2280b;
        if (c2280b != null) {
            this.f17662G.removeView(c2280b);
        } else {
            C2280b c2280b2 = new C2280b(this);
            this.f17670O = c2280b2;
            c2280b2.setId(R.id.weather_snow_effect);
        }
        this.f17670O.post(new RunnableC2136d(this, i6, 1));
        this.f17662G.addView(this.f17670O, 1);
    }

    /* JADX INFO: renamed from: P */
    public final void m8366P() {
        C2343b c2343b = (C2343b) findViewById(R.id.weather_star_effect);
        if (c2343b != null) {
            this.f17662G.removeView(c2343b);
        } else {
            c2343b = new C2343b(this);
            c2343b.f19410j = new ArrayList();
            c2343b.f19410j = new ArrayList();
            for (int i6 = 0; i6 < 100; i6++) {
                ArrayList arrayList = c2343b.f19410j;
                int height = c2343b.getHeight();
                int width = c2343b.getWidth();
                C2342a c2342a = new C2342a();
                c2342a.f19403c = 255;
                c2342a.f19404d = true;
                c2342a.f19407g = -1;
                c2342a.f19408h = Color.parseColor("#26FFFFFF");
                c2342a.f19409i = 10;
                if (C2342a.f19400l == 0.0f) {
                    C2342a.f19400l = 0.02f;
                }
                if (C2342a.f19398j == null) {
                    Paint paint = new Paint();
                    C2342a.f19398j = paint;
                    paint.setAntiAlias(true);
                    Paint paint2 = C2342a.f19398j;
                    AbstractC0965g.m2010b(paint2);
                    paint2.setColor(-1);
                    Paint paint3 = C2342a.f19398j;
                    AbstractC0965g.m2010b(paint3);
                    paint3.setAlpha(c2342a.f19403c);
                    Paint paint4 = C2342a.f19398j;
                    AbstractC0965g.m2010b(paint4);
                    paint4.setStyle(Paint.Style.FILL_AND_STROKE);
                }
                if (C2342a.f19399k == null) {
                    Paint paint5 = new Paint();
                    C2342a.f19399k = paint5;
                    paint5.setAntiAlias(true);
                    Paint paint6 = C2342a.f19399k;
                    AbstractC0965g.m2010b(paint6);
                    paint6.setColor(-1);
                    Paint paint7 = C2342a.f19399k;
                    AbstractC0965g.m2010b(paint7);
                    paint7.setAlpha(c2342a.f19403c);
                    Paint paint8 = C2342a.f19399k;
                    AbstractC0965g.m2010b(paint8);
                    paint8.setStyle(Paint.Style.FILL_AND_STROKE);
                    Paint paint9 = C2342a.f19399k;
                    AbstractC0965g.m2010b(paint9);
                    paint9.setStrokeWidth(1.0f);
                }
                c2342a.m9174a(height, width);
                arrayList.add(c2342a);
            }
            c2343b.setId(R.id.weather_star_effect);
        }
        this.f17662G.addView(c2343b, 1);
    }

    /* JADX INFO: renamed from: Q */
    public final void m8367Q(float f6) {
        ImageFilterView imageFilterView = new ImageFilterView(this);
        imageFilterView.setId(R.id.weather_sun_effect);
        imageFilterView.setImageResource(R.drawable.sun_light);
        int i6 = this.f17671P;
        C1416d c1416d = new C1416d(i6, i6);
        this.f17662G.addView(imageFilterView, 1, c1416d);
        C1428p c1428p = new C1428p();
        c1428p.m3044e(this.f17662G);
        c1428p.m3046g(imageFilterView.getId(), 3, 3);
        c1428p.m3046g(imageFilterView.getId(), 2, 2);
        c1428p.m3042b(this.f17662G);
        float f7 = 0.5f - f6;
        if (f6 > 0.5f) {
            f6 = 1.0f - f6;
        }
        float f8 = this.f17671P;
        ((ViewGroup.MarginLayoutParams) c1416d).topMargin = (int) ((-f6) * f8);
        ((ViewGroup.MarginLayoutParams) c1416d).rightMargin = (int) (f7 * f8);
        imageFilterView.startAnimation(AnimationUtils.loadAnimation(this.f17659D, R.anim.sun_rotate_anim));
    }

    /* JADX INFO: renamed from: S */
    public final void m8368S(final int i6, final boolean z5) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 100);
        valueAnimatorOfInt.setDuration(5000L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        this.f17662G.post(new Runnable() { // from class: h4.e
            @Override // java.lang.Runnable
            public final void run() {
                int i7 = WeatherActivity.f17658X;
                WeatherActivity weatherActivity = WeatherActivity.this;
                weatherActivity.getClass();
                int i8 = i6;
                boolean z6 = z5;
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: h4.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int i9 = 17;
                        int i10 = 1;
                        int i11 = 2;
                        int i12 = 0;
                        WeatherActivity weatherActivity2 = weatherActivity;
                        Random random = weatherActivity2.f17677V;
                        if (random.nextInt(10) != 0 || random.nextInt(100) >= i8) {
                            return;
                        }
                        ImageView imageView = (ImageView) weatherActivity2.findViewById(R.id.flash);
                        imageView.setVisibility(0);
                        Resources resources = weatherActivity2.getResources();
                        int[] iArr = weatherActivity2.f17676U;
                        int i13 = iArr[random.nextInt(iArr.length)];
                        ThreadLocal threadLocal = AbstractC0401n.f1268a;
                        ClipDrawable clipDrawable = new ClipDrawable(resources.getDrawable(i13, null), 48, 2);
                        ImageFilterView imageFilterView = new ImageFilterView(weatherActivity2);
                        imageFilterView.setId(View.generateViewId());
                        imageFilterView.setImageDrawable(clipDrawable);
                        imageFilterView.setScaleX(random.nextFloat() + 1.0f);
                        imageFilterView.setRotation(random.nextInt(90));
                        imageFilterView.setContrast(2.0f);
                        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, 10000);
                        valueAnimatorOfInt2.setDuration(123L);
                        valueAnimatorOfInt2.setInterpolator(new LinearInterpolator());
                        valueAnimatorOfInt2.addUpdateListener(new C1213c(i11, clipDrawable));
                        boolean zNextBoolean = random.nextBoolean();
                        boolean z7 = z6;
                        if (zNextBoolean) {
                            imageView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new RunnableC2135c(imageView, 6)).start();
                            if (z7 && random.nextBoolean()) {
                                imageFilterView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new RunnableC2134b(weatherActivity2, imageFilterView, i12)).withStartAction(new RunnableC0064g(i9, valueAnimatorOfInt2)).start();
                                weatherActivity2.f17662G.addView(imageFilterView, 1);
                                return;
                            }
                            return;
                        }
                        imageView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new RunnableC2135c(imageView, i12)).start();
                        if (z7 && random.nextBoolean()) {
                            imageFilterView.animate().withLayer().alpha(0.0f).setDuration(0L).setStartDelay(0L).withEndAction(new RunnableC2134b(weatherActivity2, imageFilterView, i10)).withStartAction(new RunnableC0064g(i9, valueAnimatorOfInt2)).start();
                            weatherActivity2.f17662G.addView(imageFilterView, 1);
                        }
                    }
                });
            }
        });
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: renamed from: T */
    public final void m8369T(boolean z5) {
        try {
            AbstractC0626a.m1450a(this, getString(R.string.ad_unit_id_weather), new C3053d(new MergedCallbacks(25)), new C2140h(this, z5));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: U */
    public final void m8370U(int i6, long j6, long j7) {
        Calendar calendar = Calendar.getInstance();
        int i7 = calendar.get(11);
        calendar.setTimeInMillis(j6);
        int i8 = calendar.get(11);
        calendar.setTimeInMillis(j7);
        float f6 = (i7 - i8) / (calendar.get(11) - i8);
        boolean z5 = f6 < 0.0f || f6 > 1.0f;
        View viewFindViewById = findViewById(R.id.weather_sun_effect);
        if (viewFindViewById != null) {
            viewFindViewById.clearAnimation();
            this.f17662G.removeView(viewFindViewById);
        }
        View viewFindViewById2 = findViewById(R.id.weather_rain_effect);
        if (viewFindViewById2 != null) {
            viewFindViewById2.clearAnimation();
            this.f17662G.removeView(viewFindViewById2);
        }
        View viewFindViewById3 = findViewById(R.id.weather_drizzle_effect);
        if (viewFindViewById3 != null) {
            viewFindViewById3.clearAnimation();
            this.f17662G.removeView(viewFindViewById3);
        }
        View viewFindViewById4 = findViewById(R.id.weather_sleet_effect);
        if (viewFindViewById4 != null) {
            viewFindViewById4.clearAnimation();
            this.f17662G.removeView(viewFindViewById4);
        }
        ArrayList arrayList = this.f17666K;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            View viewFindViewById5 = findViewById(((Integer) obj).intValue());
            if (viewFindViewById5 != null) {
                viewFindViewById5.clearAnimation();
                this.f17662G.removeView(viewFindViewById5);
            }
        }
        this.f17662G.invalidate();
        arrayList.clear();
        int[] iArr = this.f17674S;
        int[] iArr2 = this.f17673R;
        int[] iArr3 = this.f17675T;
        if (z5) {
            switch (i6) {
                case 200:
                    m8371V(9);
                    m8361K(8, true, iArr3);
                    m8368S(3, true);
                    m8363M(50);
                    break;
                case 201:
                case 202:
                    m8371V(9);
                    m8361K(10, true, iArr3);
                    m8368S(5, true);
                    m8363M(150);
                    break;
                case 210:
                case 211:
                case 212:
                    m8371V(8);
                    m8361K(8, true, iArr3);
                    m8368S(5, true);
                    break;
                case 221:
                    m8371V(8);
                    m8371V(8);
                    m8361K(6, true, iArr3);
                    m8368S(2, true);
                    break;
                case 230:
                    m8371V(9);
                    m8361K(6, true, iArr3);
                    m8368S(3, true);
                    m8362L(60);
                    break;
                case 231:
                case 232:
                    m8371V(9);
                    m8361K(10, true, iArr3);
                    m8368S(5, true);
                    m8362L(100);
                    break;
                case Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT /* 300 */:
                    m8371V(10);
                    m8361K(6, true, iArr3);
                    m8362L(60);
                    break;
                case 301:
                case 302:
                    m8371V(11);
                    m8361K(10, true, iArr3);
                    m8362L(100);
                    break;
                case 310:
                    m8371V(10);
                    m8361K(6, true, iArr3);
                    m8362L(50);
                    m8363M(50);
                    break;
                case 311:
                case 312:
                case 313:
                case 314:
                case 321:
                    m8371V(11);
                    m8361K(8, true, iArr3);
                    m8362L(100);
                    m8363M(50);
                    break;
                case 500:
                case 501:
                case 520:
                    m8371V(10);
                    m8361K(6, true, iArr3);
                    m8363M(60);
                    break;
                case 502:
                case 503:
                case 521:
                    m8371V(11);
                    m8361K(10, true, iArr3);
                    m8363M(100);
                    break;
                case 504:
                case 522:
                case 531:
                    m8371V(3);
                    m8361K(8, true, iArr3);
                    m8363M(150);
                    break;
                case 511:
                    m8371V(3);
                    m8361K(8, false, iArr3);
                    m8363M(50);
                    m8365O(50);
                    break;
                case 600:
                    m8371V(5);
                    m8361K(5, false, iArr2);
                    m8365O(50);
                    break;
                case 601:
                case 602:
                    m8371V(5);
                    m8361K(5, false, iArr2);
                    m8365O(100);
                    break;
                case 611:
                case 612:
                case 613:
                    m8371V(5);
                    m8361K(5, false, iArr2);
                    m8364N(80);
                    break;
                case 615:
                    m8371V(5);
                    m8361K(5, false, iArr2);
                    m8365O(50);
                    m8363M(30);
                    break;
                case 616:
                case 620:
                case 621:
                case 622:
                    m8371V(3);
                    m8361K(5, false, iArr2);
                    m8365O(80);
                    m8363M(80);
                    break;
                case 701:
                case 711:
                case 721:
                case 731:
                case 741:
                case 751:
                case 761:
                case 762:
                    m8371V(2);
                    m8361K(6, true, iArr2);
                    break;
                case 771:
                    m8371V(5);
                    m8361K(6, false, iArr2);
                    m8364N(60);
                    break;
                case 781:
                    m8371V(8);
                    m8361K(6, true, iArr2);
                    m8368S(3, false);
                    break;
                case 800:
                    m8371V(1);
                    m8366P();
                    break;
                case 801:
                    m8371V(12);
                    m8361K(2, false, iArr);
                    m8366P();
                    break;
                case 802:
                    m8371V(12);
                    m8361K(3, false, iArr);
                    m8366P();
                    break;
                case 803:
                    m8371V(12);
                    m8361K(5, false, iArr2);
                    m8366P();
                    break;
                case 804:
                    m8371V(12);
                    m8361K(8, true, iArr2);
                    break;
            }
        }
        switch (i6) {
            case 200:
                m8371V(9);
                m8361K(8, true, iArr3);
                m8368S(3, true);
                m8363M(50);
                break;
            case 201:
            case 202:
                m8371V(9);
                m8361K(10, true, iArr3);
                m8368S(5, true);
                m8363M(150);
                break;
            case 210:
            case 211:
            case 212:
                m8371V(8);
                m8361K(8, true, iArr3);
                m8368S(5, true);
                break;
            case 221:
                m8371V(8);
                m8371V(8);
                m8361K(6, true, iArr3);
                m8368S(2, true);
                break;
            case 230:
                m8371V(9);
                m8361K(6, true, iArr3);
                m8368S(3, true);
                m8362L(60);
                break;
            case 231:
            case 232:
                m8371V(9);
                m8361K(10, true, iArr3);
                m8368S(5, true);
                m8362L(100);
                break;
            case Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT /* 300 */:
                m8371V(10);
                m8361K(6, true, iArr3);
                m8362L(60);
                break;
            case 301:
            case 302:
                m8371V(11);
                m8361K(10, true, iArr3);
                m8362L(100);
                break;
            case 310:
                m8371V(10);
                m8361K(6, true, iArr3);
                m8362L(50);
                m8363M(50);
                break;
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                m8371V(11);
                m8361K(8, true, iArr3);
                m8362L(100);
                m8363M(50);
                break;
            case 500:
            case 501:
            case 520:
                m8371V(10);
                m8361K(6, true, iArr3);
                m8363M(60);
                break;
            case 502:
            case 503:
            case 521:
                m8371V(11);
                m8361K(10, true, iArr3);
                m8363M(100);
                break;
            case 504:
            case 522:
            case 531:
                m8371V(3);
                m8361K(8, true, iArr3);
                m8363M(150);
                break;
            case 511:
                m8371V(3);
                m8361K(8, false, iArr3);
                m8363M(50);
                m8365O(50);
                break;
            case 600:
                m8371V(5);
                m8361K(5, false, iArr2);
                m8365O(50);
                break;
            case 601:
            case 602:
                m8371V(5);
                m8361K(5, false, iArr2);
                m8365O(100);
                break;
            case 611:
            case 612:
            case 613:
                m8371V(5);
                m8361K(5, false, iArr2);
                m8364N(80);
                break;
            case 615:
                m8371V(5);
                m8361K(5, false, iArr2);
                m8365O(50);
                m8363M(30);
                break;
            case 616:
            case 620:
            case 621:
            case 622:
                m8371V(3);
                m8361K(5, false, iArr2);
                m8365O(80);
                m8363M(80);
                break;
            case 701:
            case 711:
            case 721:
            case 731:
            case 741:
            case 751:
            case 761:
            case 762:
                m8371V(2);
                m8361K(6, true, iArr2);
                break;
            case 771:
                m8371V(5);
                m8361K(6, false, iArr2);
                m8364N(60);
                break;
            case 781:
                m8371V(8);
                m8361K(6, true, iArr2);
                m8368S(3, false);
                break;
            case 800:
                m8371V(0);
                m8367Q(f6);
                break;
            case 801:
                m8371V(13);
                m8367Q(f6);
                m8361K(2, false, iArr);
                break;
            case 802:
                m8371V(13);
                m8367Q(f6);
                m8361K(3, false, iArr);
                break;
            case 803:
                m8371V(14);
                m8367Q(f6);
                m8361K(5, false, iArr2);
                break;
            case 804:
                m8371V(15);
                m8361K(8, true, iArr2);
                break;
        }
    }

    /* JADX INFO: renamed from: V */
    public final void m8371V(int i6) {
        if (this.f17662G.getBackground() == null) {
            this.f17662G.setBackground(R.drawable.weather_background_state);
        }
        this.f17662G.getBackground().setLevel(i6);
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onActivityResult(int i6, int i7, Intent intent) {
        C2142j c2142j;
        super.onActivityResult(i6, i7, intent);
        if (i6 == 33 && i7 == -1 && (c2142j = this.f17665J) != null) {
            c2142j.m8825V();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.city_switch) {
            startActivity(new Intent(this, (Class<?>) WeatherCitiesActivity.class));
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17659D = getApplicationContext();
        new Thread(new RunnableC2133a(this, 0)).start();
        setContentView(R.layout.activity_weather);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        this.f17671P = point.x;
        this.f17672Q = point.y;
        this.f17662G = (ConstraintWeatherLayout) findViewById(R.id.weather_background);
        this.f17660E = (ViewPager) findViewById(R.id.city_page);
        this.f17661F = (ImageView) findViewById(R.id.city_switch);
        this.f17663H = (IndicatorView) findViewById(R.id.indicator);
        m1821J(this.f17662G, false);
        C2142j c2142j = new C2142j();
        this.f17665J = c2142j;
        this.f17664I.add(c2142j);
        C1469C c1469cM8626y = m8626y();
        ArrayList arrayList = this.f17664I;
        C2201f c2201f = new C2201f(c1469cM8626y);
        c2201f.f18971h = arrayList;
        this.f17660E.setAdapter(c2201f);
        this.f17660E.setOffscreenPageLimit(this.f17664I.size());
        this.f17663H.setUpWithViewPager(this.f17660E);
        this.f17661F.setOnClickListener(this);
        this.f17666K.clear();
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f17664I = null;
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        if (i6 == 68) {
            try {
                HashMap map = new HashMap();
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    map.put(strArr[i7], Integer.valueOf(iArr[i7]));
                }
                if (((Integer) map.get("android.permission.ACCESS_FINE_LOCATION")).intValue() != 0) {
                    Toast.makeText(this, R.string.warning_location_permission, 1).show();
                    return;
                }
                C2142j c2142j = this.f17665J;
                if (c2142j != null) {
                    c2142j.m8825V();
                }
            } catch (Throwable unused) {
                Toast.makeText(this, R.string.warning_location_permission, 1).show();
            }
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStart() {
        super.onStart();
        Objects.toString(this.f17678W);
        try {
            AbstractC0626a abstractC0626a = this.f17678W;
            if (abstractC0626a != null) {
                abstractC0626a.mo1452c(this);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
