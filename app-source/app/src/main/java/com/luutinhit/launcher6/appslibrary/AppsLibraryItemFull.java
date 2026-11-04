package com.luutinhit.launcher6.appslibrary;

import Q3.C0911s;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.C1416d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.AppInfo;
import com.luutinhit.launcher6.GlassSurfaceHolder;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherAnimUtils;
import com.luutinhit.launcher6.LiquidGlassTextureView;
import com.luutinhit.launcher6.RuntimeShaderGlassView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AppsLibraryItemFull extends ConstraintLayout implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    /* JADX INFO: renamed from: j */
    public AppsLibraryBubbleTextView f16255j;

    /* JADX INFO: renamed from: k */
    public AppsLibraryBubbleTextView f16256k;

    /* JADX INFO: renamed from: l */
    public AppsLibraryBubbleTextView f16257l;

    /* JADX INFO: renamed from: m */
    public AppsLibraryBubbleTextView f16258m;

    /* JADX INFO: renamed from: n */
    public ConstraintLayout f16259n;

    /* JADX INFO: renamed from: o */
    public TextViewCustomFont f16260o;

    /* JADX INFO: renamed from: p */
    public String f16261p;

    /* JADX INFO: renamed from: q */
    public Launcher f16262q;

    /* JADX INFO: renamed from: r */
    public LiquidGlassTextureView f16263r;

    /* JADX INFO: renamed from: s */
    public RuntimeShaderGlassView f16264s;

    /* JADX INFO: renamed from: t */
    public boolean f16265t;

    /* JADX INFO: renamed from: u */
    public int f16266u;

    public AppsLibraryItemFull(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16261p = "";
        this.f16265t = false;
        setLayerType(2, null);
        LayoutInflater.from(context).inflate(R.layout.apps_library_item_full, (ViewGroup) this, true);
        if (context instanceof Launcher) {
            this.f16262q = (Launcher) context;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.app_background);
        this.f16259n = constraintLayout;
        this.f16260o = (TextViewCustomFont) findViewById(R.id.app_category_title);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView = (AppsLibraryBubbleTextView) findViewById(R.id.app_1);
        this.f16255j = appsLibraryBubbleTextView;
        AppsLibraryBubbleTextView appsLibraryBubbleTextView2 = (AppsLibraryBubbleTextView) findViewById(R.id.app_2);
        this.f16256k = appsLibraryBubbleTextView2;
        AppsLibraryBubbleTextView appsLibraryBubbleTextView3 = (AppsLibraryBubbleTextView) findViewById(R.id.app_3);
        this.f16257l = appsLibraryBubbleTextView3;
        AppsLibraryBubbleTextView appsLibraryBubbleTextView4 = (AppsLibraryBubbleTextView) findViewById(R.id.app_4);
        this.f16258m = appsLibraryBubbleTextView4;
        this.f16262q.getTinyDB().m140j(this);
        Launcher launcher = this.f16262q;
        if (!launcher.isUseLiquidGlass) {
            constraintLayout.setBackgroundResource(launcher.isDarkMode ? R.drawable.icon_apps_library_background_dark : R.drawable.icon_apps_library_background);
        } else if (launcher.isRuntimeRenderSupport) {
            RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher, false);
            this.f16264s = runtimeShaderGlassView;
            runtimeShaderGlassView.setLayerType(2, null);
            runtimeShaderGlassView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            runtimeShaderGlassView.setFullBitmap(this.f16262q.getBlurWallpaperProvider().f20555e);
            runtimeShaderGlassView.setSdfTexture(R.drawable.lib);
            constraintLayout.addView(runtimeShaderGlassView, 0);
        } else {
            LiquidGlassTextureView liquidGlassTextureView = new LiquidGlassTextureView(this.f16262q);
            this.f16263r = liquidGlassTextureView;
            liquidGlassTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
            constraintLayout.addView(liquidGlassTextureView, 0);
        }
        int i6 = this.f16262q.getDeviceProfile().f15977C / 3;
        C1416d c1416d = (C1416d) appsLibraryBubbleTextView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) c1416d).topMargin = i6;
        c1416d.setMarginStart(i6);
        C1416d c1416d2 = (C1416d) appsLibraryBubbleTextView2.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) c1416d2).topMargin = i6;
        c1416d2.setMarginEnd(i6);
        C1416d c1416d3 = (C1416d) appsLibraryBubbleTextView3.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) c1416d3).bottomMargin = i6;
        c1416d3.setMarginStart(i6);
        C1416d c1416d4 = (C1416d) appsLibraryBubbleTextView4.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) c1416d4).bottomMargin = i6;
        c1416d4.setMarginEnd(i6);
        appsLibraryBubbleTextView.setOnClickListener(this);
        appsLibraryBubbleTextView2.setOnClickListener(this);
        appsLibraryBubbleTextView3.setOnClickListener(this);
        appsLibraryBubbleTextView4.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i6 = 0;
        if (view == null || view.getTag() == null) {
            return;
        }
        if (view.getId() != R.id.app_4 || !this.f16265t) {
            this.f16262q.startAppShortcutOrInfoActivity(view);
            return;
        }
        AppsLibraryFolderExpandView appsLibraryFolderExpandView = this.f16258m.f16254K;
        if (appsLibraryFolderExpandView.getParent() != null) {
            Objects.toString(appsLibraryFolderExpandView);
            Objects.toString(appsLibraryFolderExpandView.getParent());
            return;
        }
        Launcher launcher = appsLibraryFolderExpandView.f16282n;
        launcher.hideAppsLibrary();
        launcher.getLauncherView().addView(appsLibraryFolderExpandView);
        appsLibraryFolderExpandView.setScaleX(0.3f);
        appsLibraryFolderExpandView.setScaleY(0.3f);
        appsLibraryFolderExpandView.setAlpha(0.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(appsLibraryFolderExpandView, PropertyValuesHolder.ofFloat("alpha", 1.0f), PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(399L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.02f, 0.11f, 0.13f, 1.0f));
        objectAnimatorOfPropertyValuesHolder.addListener(new AppsLibraryFolderExpandAnimListener(appsLibraryFolderExpandView, i6));
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        LiquidGlassTextureView liquidGlassTextureView = this.f16263r;
        if (liquidGlassTextureView == null) {
            RuntimeShaderGlassView runtimeShaderGlassView = this.f16264s;
            if (runtimeShaderGlassView != null) {
                runtimeShaderGlassView.updateGlViewPosition();
                this.f16266u = i6;
                return;
            }
            return;
        }
        float f6 = i6;
        float f7 = i7;
        GlassSurfaceHolder glassSurfaceHolder = (GlassSurfaceHolder) liquidGlassTextureView.f15932j.f15897v.get(liquidGlassTextureView);
        if (glassSurfaceHolder == null) {
            return;
        }
        glassSurfaceHolder.f15864f = f6;
        glassSurfaceHolder.f15865g = f7;
        glassSurfaceHolder.f15866h = true;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null || !str.equals("dark_mode")) {
            return;
        }
        this.f16259n.setBackgroundResource(sharedPreferences.getBoolean(str, false) ? R.drawable.icon_apps_library_background_dark : R.drawable.icon_apps_library_background);
    }

    public void setApps(ArrayList<AppInfo> arrayList) {
        Objects.toString(arrayList);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView = this.f16255j;
        appsLibraryBubbleTextView.setTag(null);
        appsLibraryBubbleTextView.getIconView().setBackground(null);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView2 = this.f16256k;
        appsLibraryBubbleTextView2.setTag(null);
        appsLibraryBubbleTextView2.getIconView().setBackground(null);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView3 = this.f16257l;
        appsLibraryBubbleTextView3.setTag(null);
        appsLibraryBubbleTextView3.getIconView().setBackground(null);
        AppsLibraryBubbleTextView appsLibraryBubbleTextView4 = this.f16258m;
        appsLibraryBubbleTextView4.setTag(null);
        appsLibraryBubbleTextView4.getIconView().setBackground(null);
        int i6 = 0;
        this.f16265t = false;
        if (arrayList != null) {
            int size = arrayList.size();
            int i7 = 1;
            if (size <= 4) {
                if (size > 0) {
                    appsLibraryBubbleTextView.setTag(arrayList.get(0));
                    appsLibraryBubbleTextView.applyFromApplicationInfo(arrayList.get(0));
                    if (size > 1) {
                        appsLibraryBubbleTextView2.setTag(arrayList.get(1));
                        appsLibraryBubbleTextView2.applyFromApplicationInfo(arrayList.get(1));
                    }
                    if (size > 2) {
                        appsLibraryBubbleTextView3.setTag(arrayList.get(2));
                        appsLibraryBubbleTextView3.applyFromApplicationInfo(arrayList.get(2));
                    }
                    if (size > 3) {
                        appsLibraryBubbleTextView4.setTag(arrayList.get(3));
                        appsLibraryBubbleTextView4.applyFromApplicationInfo(arrayList.get(3));
                        return;
                    }
                    return;
                }
                return;
            }
            appsLibraryBubbleTextView.setTag(arrayList.get(0));
            appsLibraryBubbleTextView.applyFromApplicationInfo(arrayList.get(0));
            appsLibraryBubbleTextView2.setTag(arrayList.get(1));
            appsLibraryBubbleTextView2.applyFromApplicationInfo(arrayList.get(1));
            appsLibraryBubbleTextView3.setTag(arrayList.get(2));
            appsLibraryBubbleTextView3.applyFromApplicationInfo(arrayList.get(2));
            appsLibraryBubbleTextView4.setTag(arrayList.get(3));
            Objects.toString(arrayList);
            Paint paint = new Paint(1);
            paint.setAntiAlias(true);
            int width = arrayList.get(0).f16327B.getWidth();
            double d6 = width;
            int i8 = (int) (d6 / 2.6d);
            int i9 = (int) ((d6 * 0.6d) / 7.800000000000001d);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            int iMin = Math.min(arrayList.size() - 3, 4);
            while (i6 < iMin) {
                int i10 = i6 % 2;
                int i11 = ((i10 + i7) * i9) + (i10 * i8);
                int i12 = i6 / 2;
                int i13 = ((i12 + i7) * i9) + (i12 * i8);
                canvas.drawBitmap(arrayList.get(i6 + 3).f16327B, (Rect) null, new Rect(i11, i13, i11 + i8, i13 + i8), paint);
                i6++;
                i8 = i8;
                i7 = 1;
            }
            appsLibraryBubbleTextView4.m7599H(appsLibraryBubbleTextView4.f16253J.createIconDrawable(bitmapCreateBitmap), appsLibraryBubbleTextView4.getIconSize());
            String str = this.f16261p;
            AppsLibraryFolderExpandView appsLibraryFolderExpandView = appsLibraryBubbleTextView4.f16254K;
            appsLibraryFolderExpandView.getClass();
            Objects.toString(arrayList);
            C0911s c0911s = appsLibraryFolderExpandView.f16284p;
            ArrayList arrayList2 = c0911s.f2688n;
            arrayList2.clear();
            arrayList2.addAll(arrayList);
            c0911s.f2690p = str;
            c0911s.m9703f();
            this.f16265t = true;
        }
    }

    public void setTitle(String str) {
        this.f16261p = str;
        this.f16260o.setText(str);
    }
}
