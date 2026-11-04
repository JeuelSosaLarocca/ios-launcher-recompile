package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Objects;
import p118q3.C2615e;
import p118q3.InterfaceC2614d;
import p118q3.SharedPreferencesOnSharedPreferenceChangeListenerC2611a;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicator extends FrameLayout implements InterfaceC2614d {

    /* JADX INFO: renamed from: j */
    public LayoutInflater f15906j;

    /* JADX INFO: renamed from: k */
    public int[] mWindowRange;

    /* JADX INFO: renamed from: l */
    public int f15908l;

    /* JADX INFO: renamed from: m */
    public boolean f15909m;

    /* JADX INFO: renamed from: n */
    public boolean f15910n;

    /* JADX INFO: renamed from: o */
    public ArrayList mMarkers;

    /* JADX INFO: renamed from: p */
    public int f15912p;

    /* JADX INFO: renamed from: q */
    public SharedPreferencesOnSharedPreferenceChangeListenerC2611a f15913q;

    /* JADX INFO: renamed from: r */
    public RectF f15914r;

    /* JADX INFO: renamed from: s */
    public Rect f15915s;

    /* JADX INFO: renamed from: t */
    public float f15916t;

    /* JADX INFO: renamed from: u */
    public Launcher f15917u;

    /* JADX INFO: renamed from: v */
    public LiquidGlassSurfaceView f15918v;

    /* JADX INFO: renamed from: w */
    public RuntimeShaderGlassView f15919w;

    /* JADX INFO: renamed from: x */
    public TextViewCustomFont f15920x;

    /* JADX INFO: renamed from: y */
    public MergedUiRunnable f15921y;

    public PageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: a */
    public final void mo7593a() {
        post(new MergedIdleRunnable(8, this));
    }

    /* JADX INFO: renamed from: b */
    public void mo7783b(int i6, PageIndicatorState pageIndicatorState) {
        ArrayList arrayList;
        LayoutInflater layoutInflater;
        if (this.f15909m || (arrayList = this.mMarkers) == null || (layoutInflater = this.f15906j) == null) {
            return;
        }
        int iMax = Math.max(0, Math.min(i6, arrayList.size()));
        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) layoutInflater.inflate(R.layout.page_indicator_marker, (ViewGroup) this, false);
        pageIndicatorMarker.setMarkerDrawables(pageIndicatorState.f15905a);
        arrayList.add(iMax, pageIndicatorMarker);
        offsetWindowCenterTo(this.f15912p, true);
    }

    /* JADX INFO: renamed from: c */
    public void mo7784c(ArrayList arrayList) {
        if (this.f15909m) {
            return;
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            mo7783b(Integer.MAX_VALUE, (PageIndicatorState) arrayList.get(i6));
        }
    }

    /* JADX INFO: renamed from: d */
    public void mo7785d() {
        removeCallbacks(this.f15921y);
        TextViewCustomFont textViewCustomFont = this.f15920x;
        if (textViewCustomFont != null) {
            textViewCustomFont.setVisibility(8);
        }
        ArrayList arrayList = this.mMarkers;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) obj;
            if (pageIndicatorMarker != null) {
                pageIndicatorMarker.setVisibility(0);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final void offsetWindowCenterTo(int i6, boolean z5) {
        ArrayList arrayList;
        int[] iArr;
        View view;
        int iIndexOf;
        boolean z6 = this.f15909m;
        if (z6 || (arrayList = this.mMarkers) == null || (iArr = this.mWindowRange) == null || this.f15906j == null) {
            return;
        }
        if (i6 < 0) {
            new Throwable().printStackTrace();
        }
        int size = arrayList.size();
        int i7 = this.f15908l;
        int iMin = Math.min(size, i7);
        int iMin2 = Math.min(arrayList.size(), Math.max(0, i6 - (iMin / 2)) + i7);
        int iMin3 = iMin2 - Math.min(arrayList.size(), iMin);
        arrayList.size();
        boolean z7 = (iArr[0] == iMin3 && iArr[1] == iMin2) ? false : true;
        if (!z5 && !z6) {
            LayoutTransition layoutTransition = getLayoutTransition();
            layoutTransition.disableTransitionType(2);
            layoutTransition.disableTransitionType(3);
            layoutTransition.disableTransitionType(0);
            layoutTransition.disableTransitionType(1);
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if ((childAt instanceof PageIndicatorMarker) && ((iIndexOf = arrayList.indexOf((view = (PageIndicatorMarker) childAt))) < iMin3 || iIndexOf >= iMin2)) {
                removeView(view);
            }
        }
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) arrayList.get(i8);
            if (iMin3 > i8 || i8 >= iMin2) {
                pageIndicatorMarker.inactivate(true);
            } else {
                if (indexOfChild(pageIndicatorMarker) < 0) {
                    addView(pageIndicatorMarker, i8 - iMin3);
                }
                if (i8 != i6) {
                    pageIndicatorMarker.inactivate(z7);
                } else if (z7) {
                    pageIndicatorMarker.f15922j.animate().cancel();
                    pageIndicatorMarker.f15922j.setAlpha(1.0f);
                    pageIndicatorMarker.f15922j.setScaleX(1.0f);
                    pageIndicatorMarker.f15922j.setScaleY(1.0f);
                } else {
                    pageIndicatorMarker.f15922j.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(175L).start();
                }
            }
        }
        if (!z5 && !z6) {
            LayoutTransition layoutTransition2 = getLayoutTransition();
            layoutTransition2.enableTransitionType(2);
            layoutTransition2.enableTransitionType(3);
            layoutTransition2.enableTransitionType(0);
            layoutTransition2.enableTransitionType(1);
        }
        iArr[0] = iMin3;
        iArr[1] = iMin2;
    }

    /* JADX INFO: renamed from: f */
    public void mo7787f() {
        ArrayList arrayList;
        if (this.f15909m || (arrayList = this.mMarkers) == null) {
            return;
        }
        while (!arrayList.isEmpty()) {
            mo7788g(Integer.MAX_VALUE);
        }
    }

    /* JADX INFO: renamed from: g */
    public void mo7788g(int i6) {
        ArrayList arrayList;
        if (this.f15909m || (arrayList = this.mMarkers) == null || arrayList.isEmpty()) {
            return;
        }
        arrayList.remove(Math.max(0, Math.min(arrayList.size() - 1, i6)));
        offsetWindowCenterTo(this.f15912p, true);
    }

    public Bitmap getBlurGlassWallpaper() {
        Launcher launcher = this.f15917u;
        C2615e blurWallpaperProvider = launcher.getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f20556f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.f20555e;
        }
        if (bitmap == null) {
            return launcher.getBlurWallpaperProvider().f20557g;
        }
        bitmap.toString();
        return bitmap;
    }

    /* JADX INFO: renamed from: h */
    public void mo7789h() {
        MergedUiRunnable mergedUiRunnable = this.f15921y;
        removeCallbacks(mergedUiRunnable);
        postOnAnimationDelayed(mergedUiRunnable, 1369L);
    }

    /* JADX INFO: renamed from: i */
    public void mo7790i(int i6, PageIndicatorState pageIndicatorState) {
        ArrayList arrayList;
        if (this.f15909m || (arrayList = this.mMarkers) == null) {
            return;
        }
        if (i6 < 0 || i6 >= arrayList.size()) {
            arrayList.size();
        } else {
            ((PageIndicatorMarker) arrayList.get(i6)).setMarkerDrawables(pageIndicatorState.f15905a);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Launcher launcher = this.f15917u;
        boolean z5 = launcher.isUseLiquidGlass;
        if (this.f15910n && z5) {
            if (launcher.isRuntimeRenderSupport) {
                setLayerType(2, null);
                RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher, false);
                this.f15919w = runtimeShaderGlassView;
                runtimeShaderGlassView.setLayerType(2, null);
                this.f15919w.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                this.f15919w.setSdfTexture(R.drawable.in);
                addView(this.f15919w, 0);
                return;
            }
            LiquidGlassSurfaceView liquidGlassSurfaceView = new LiquidGlassSurfaceView(launcher, 0.49f);
            this.f15918v = liquidGlassSurfaceView;
            liquidGlassSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            LiquidGlassSurfaceView liquidGlassSurfaceView2 = this.f15918v;
            int i6 = launcher.screenWidth;
            int i7 = launcher.screenHeight;
            liquidGlassSurfaceView2.f15805l = i6;
            liquidGlassSurfaceView2.f15806m = i7;
            liquidGlassSurfaceView2.f15815v = false;
            this.f15918v.setSdfTexture(R.drawable.in);
            addView(this.f15918v, 0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        Rect rect = this.f15915s;
        super.onLayout(z5, i6, i7, i8, i9);
        if (this.f15910n) {
            try {
                int width = getWidth();
                int height = getHeight();
                if (!z5 || width <= 0 || height <= 0) {
                    return;
                }
                if (Utilities.f16755p) {
                    rect.set(0, 0, width, height);
                    setClipBounds(rect);
                }
                float f6 = i6;
                this.f15916t = f6;
                float f7 = i7;
                LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15918v;
                if (liquidGlassSurfaceView != null) {
                    liquidGlassSurfaceView.updatePositionAndRender();
                    return;
                }
                RuntimeShaderGlassView runtimeShaderGlassView = this.f15919w;
                if (runtimeShaderGlassView != null) {
                    runtimeShaderGlassView.updateGlViewPosition();
                    return;
                }
                SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f15913q;
                if (sharedPreferencesOnSharedPreferenceChangeListenerC2611a != null) {
                    RectF rectF = this.f15914r;
                    rectF.set(0.0f, 0.0f, width, height);
                    sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20532l = true;
                    sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20533m.set(rectF);
                    sharedPreferencesOnSharedPreferenceChangeListenerC2611a.m9543c(f6);
                    sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20537q = f7;
                    sharedPreferencesOnSharedPreferenceChangeListenerC2611a.invalidateSelf();
                    setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof TextViewCustomFont) {
            TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(R.id.tv_search_spotlight);
            this.f15920x = textViewCustomFont;
            Objects.toString(textViewCustomFont);
        }
    }

    public void setActiveMarker(int i6) {
        if (i6 != this.f15912p) {
            this.f15912p = i6;
            offsetWindowCenterTo(i6, false);
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f6) {
        super.setTranslationX(f6);
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15918v;
        if (liquidGlassSurfaceView != null) {
            liquidGlassSurfaceView.setScrollOffset(f6);
            return;
        }
        RuntimeShaderGlassView runtimeShaderGlassView = this.f15919w;
        if (runtimeShaderGlassView != null) {
            runtimeShaderGlassView.setScrollOffset(f6 + this.f15916t);
            return;
        }
        SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = this.f15913q;
        if (sharedPreferencesOnSharedPreferenceChangeListenerC2611a != null) {
            sharedPreferencesOnSharedPreferenceChangeListenerC2611a.m9543c(f6 + this.f15916t);
        }
    }

    public void setUseTransparency(boolean z5) {
    }

    public PageIndicator(Context context, AttributeSet attributeSet, boolean z5) {
        super(context, attributeSet, 0);
        this.f15913q = null;
        new Path();
        this.f15914r = new RectF();
        this.f15915s = new Rect();
        this.f15916t = -1.0f;
        this.f15921y = new MergedUiRunnable(11, this);
        Launcher launcher = (Launcher) context;
        this.f15917u = launcher;
        this.f15909m = z5;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2251o, 0, 0);
        this.f15908l = typedArrayObtainStyledAttributes.getInteger(1, 15);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.f15910n = z6;
        typedArrayObtainStyledAttributes.recycle();
        this.mWindowRange = z5 ? null : new int[2];
        this.f15906j = z5 ? null : LayoutInflater.from(context);
        this.mMarkers = z5 ? null : new ArrayList();
        if (z6) {
            if (!launcher.isUseLiquidGlass) {
                float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_round_corner);
                C2615e blurWallpaperProvider = ((Launcher) context).getBlurWallpaperProvider();
                blurWallpaperProvider.getClass();
                SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = new SharedPreferencesOnSharedPreferenceChangeListenerC2611a(blurWallpaperProvider, dimensionPixelSize, 4);
                this.f15913q = sharedPreferencesOnSharedPreferenceChangeListenerC2611a;
                setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
            } else if (launcher.getBlurWallpaperProvider() != null) {
                launcher.getBlurWallpaperProvider().m9546b(this);
            }
        }
        if (z5) {
            return;
        }
        getLayoutTransition().setDuration(268L);
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: q */
    public final void mo7594q() {
    }
}
