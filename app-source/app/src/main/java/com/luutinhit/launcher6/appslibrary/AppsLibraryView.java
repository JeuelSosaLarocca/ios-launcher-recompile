package com.luutinhit.launcher6.appslibrary;

import A4.RunnableC0026a;
import B3.RunnableC0064g;
import B3.ViewOnClickListenerC0065h;
import E4.AbstractC0212f;
import G3.C0364t;
import G3.C0370z;
import G3.CallableC0366v;
import G3.ViewOnTouchListenerC0363s;
import T0.C1029l;
import U2.C1098d;
import Z3.InterfaceC1307g;
import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.InterfaceC1411y;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.C1416d;
import androidx.constraintlayout.widget.C1428p;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.luutinhit.launcher6.AppInfo;
import com.luutinhit.launcher6.AppsLibraryProgressCallback;
import com.luutinhit.launcher6.DeviceProfile;
import com.luutinhit.launcher6.ExtendedEditText;
import com.luutinhit.launcher6.GlassBitmapUploadRunnable;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherRootView;
import com.luutinhit.launcher6.LiquidGlassRenderer;
import com.luutinhit.launcher6.RuntimeShaderGlassView;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.editscreen.CustomViewRound;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.recyclerviewbouncy.BouncyRecyclerView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Objects;
import n3.C2504b;
import n3.C2510h;
import p024a.AbstractC1314a;
import p118q3.InterfaceC2614d;
import p123r4.AbstractC2679b;
import p154y3.C3027b;
import p159z4.CallableC3080a;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.d */
/* JADX INFO: loaded from: classes.dex */
public final class AppsLibraryView extends MotionLayout implements InterfaceC1411y, InterfaceC1307g, InterfaceC2614d {

    /* JADX INFO: renamed from: A */
    public Handler f16287A;

    /* JADX INFO: renamed from: B */
    public MergedCallbacks f16288B;

    /* JADX INFO: renamed from: j */
    public Launcher f16289j;

    /* JADX INFO: renamed from: k */
    public BouncyRecyclerView f16290k;

    /* JADX INFO: renamed from: l */
    public BouncyRecyclerView f16291l;

    /* JADX INFO: renamed from: m */
    public C2504b f16292m;

    /* JADX INFO: renamed from: n */
    public IndexBarView f16293n;

    /* JADX INFO: renamed from: o */
    public ArrayList f16294o;

    /* JADX INFO: renamed from: p */
    public FrameLayout f16295p;

    /* JADX INFO: renamed from: q */
    public RealTimeBlurView f16296q;

    /* JADX INFO: renamed from: r */
    public CustomViewRound f16297r;

    /* JADX INFO: renamed from: s */
    public RuntimeShaderGlassView f16298s;

    /* JADX INFO: renamed from: t */
    public ExtendedEditText f16299t;

    /* JADX INFO: renamed from: u */
    public boolean f16300u;

    /* JADX INFO: renamed from: v */
    public int f16301v;

    /* JADX INFO: renamed from: w */
    public C2510h f16302w;

    /* JADX INFO: renamed from: x */
    public C3027b f16303x;

    /* JADX INFO: renamed from: y */
    public InputMethodManager f16304y;

    /* JADX INFO: renamed from: z */
    public PathInterpolator f16305z;

    public AppsLibraryView(IOSLauncher iOSLauncher) {
        super(iOSLauncher);
        this.f16294o = new ArrayList();
        this.f16300u = false;
        this.f16305z = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
        this.f16287A = new Handler(Looper.getMainLooper(), new C1098d(2, this));
        this.f16288B = new MergedCallbacks(0, this);
        C0370z c0370z = new C0370z(4, this);
        LayoutInflater.from(iOSLauncher).inflate(R.layout.apps_libray_layout, (ViewGroup) this, true);
        this.f16289j = iOSLauncher;
        setX(0.0f);
        setY(0.0f);
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        setPadding(0, 0, 0, 0);
        int i6 = this.f16289j.getDeviceProfile().f15977C;
        this.f16301v = i6;
        CustomViewRound customViewRound = (CustomViewRound) findViewById(R.id.search_box_apps_library);
        this.f16297r = customViewRound;
        BouncyRecyclerView bouncyRecyclerView = (BouncyRecyclerView) findViewById(R.id.list_apps_library);
        this.f16290k = bouncyRecyclerView;
        this.f16292m = new C2504b(0);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.layout_list_apps_library);
        this.f16295p = frameLayout;
        RealTimeBlurView realTimeBlurView = (RealTimeBlurView) findViewById(R.id.realtime_blur_search_box);
        this.f16296q = realTimeBlurView;
        ExtendedEditText extendedEditText = (ExtendedEditText) findViewById(R.id.et_search);
        this.f16299t = extendedEditText;
        BouncyRecyclerView bouncyRecyclerView2 = (BouncyRecyclerView) findViewById(R.id.apps_library_search_view);
        this.f16291l = bouncyRecyclerView2;
        this.f16293n = (IndexBarView) findViewById(R.id.index_bar_view);
        bouncyRecyclerView.setLayoutManager(new GridLayoutManager(2));
        Resources resources = getResources();
        AppsLibraryItemDecoration appsLibraryItemDecoration = new AppsLibraryItemDecoration();
        appsLibraryItemDecoration.f16314l = resources;
        appsLibraryItemDecoration.f16313k = (i6 * 3) / 2;
        bouncyRecyclerView.m3419l(appsLibraryItemDecoration);
        bouncyRecyclerView2.setLayoutManager(new LinearLayoutManager(1));
        frameLayout.setX(0.0f);
        frameLayout.setY(0.0f);
        frameLayout.setTranslationX(0.0f);
        frameLayout.setTranslationY(0.0f);
        frameLayout.setPadding(0, 0, 0, 0);
        C1416d c1416d = (C1416d) frameLayout.getLayoutParams();
        Launcher launcher = this.f16289j;
        ((ViewGroup.MarginLayoutParams) c1416d).height = launcher.screenHeight;
        int i7 = i6 * 2;
        C1416d c1416d2 = (C1416d) customViewRound.getLayoutParams();
        DeviceProfile deviceProfile = launcher.mDeviceProfile;
        int i8 = ((deviceProfile.f16009i + deviceProfile.f15983I) - deviceProfile.f15978D) - deviceProfile.f15980F;
        c1416d2.setMargins(i7, i8, i7, 0);
        customViewRound.setLayoutParams(c1416d2);
        int i9 = i8 + ((ViewGroup.MarginLayoutParams) c1416d2).height + i7;
        int paddingBottom = bouncyRecyclerView.getPaddingBottom();
        bouncyRecyclerView.setPadding(i7, i9, i7, paddingBottom);
        bouncyRecyclerView2.setPadding(i7, i9, i7, paddingBottom);
        ((ViewGroup.MarginLayoutParams) ((C1416d) realTimeBlurView.getLayoutParams())).height = i9 - 8;
        if (launcher.isUseLiquidGlass && launcher.isRuntimeRenderSupport && this.f16298s == null) {
            setLayerType(2, null);
            RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher, false);
            this.f16298s = runtimeShaderGlassView;
            runtimeShaderGlassView.setLayerType(2, null);
            this.f16298s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
            this.f16298s.setCornerRadiusPercent(0.5f);
            customViewRound.f16399p = false;
            customViewRound.invalidate();
            customViewRound.addView(this.f16298s, 0);
        }
        setDarkMode(this.f16289j.isDarkMode);
        if (Utilities.f16752m) {
            extendedEditText.setShowSoftInputOnFocus(false);
        } else {
            extendedEditText.setTextIsSelectable(true);
        }
        extendedEditText.setOnTouchListener(new ViewOnTouchListenerC0363s(1, this));
        customViewRound.setOnClickListener(new ViewOnClickListenerC0065h(8, this));
        extendedEditText.addTextChangedListener(c0370z);
        setTransitionListener(this);
        this.f16303x = new C3027b(iOSLauncher);
        this.f16304y = (InputMethodManager) iOSLauncher.getSystemService("input_method");
        realTimeBlurView.setBlurredView(frameLayout);
        bouncyRecyclerView.setOnOverScrollListener(new C0364t(6, this));
        Launcher launcher2 = this.f16289j;
        if (launcher2.isUseLiquidGlass) {
            launcher2.getBlurWallpaperProvider().m9546b(this);
            refreshGlassBackground();
        }
    }

    /* JADX INFO: renamed from: G */
    public final void removeExpandedFolder() {
        AppsLibraryFolderExpandView appsLibraryFolderExpandView;
        Launcher launcher = this.f16289j;
        if (launcher == null || launcher.getLauncherView() == null || (appsLibraryFolderExpandView = (AppsLibraryFolderExpandView) launcher.getLauncherView().findViewById(R.id.apps_library_folder_expand)) == null) {
            return;
        }
        Launcher launcher2 = appsLibraryFolderExpandView.f16282n;
        launcher2.appsLibraryLayout.setAlpha(1.0f);
        launcher2.appsLibraryLayout.setScaleX(1.0f);
        launcher2.appsLibraryLayout.setScaleY(1.0f);
        LauncherRootView launcherRootView = (LauncherRootView) appsLibraryFolderExpandView.getParent();
        if (launcherRootView != null) {
            launcherRootView.removeView(appsLibraryFolderExpandView);
        }
    }

    /* JADX INFO: renamed from: H */
    public final int resolveAppCategory(AppInfo appInfo) {
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        Launcher launcher = this.f16289j;
        ComponentName componentName = appInfo.f16329D;
        ApplicationInfo applicationInfo = appInfo.f16330E;
        if (applicationInfo != null) {
            boolean z12 = false;
            try {
                int iM8006g = launcher.getIconCache().m8006g(componentName);
                if (iM8006g == 0 && (!Utilities.f16743d ? (applicationInfo.flags & 33554432) == 33554432 : applicationInfo.category == 0)) {
                    iM8006g = 1;
                }
                z5 = iM8006g == 1;
            } catch (Throwable unused) {
            }
            if (z5) {
                launcher.getModel().enqueuePackageUpdate(1, componentName.flattenToString());
                return 1;
            }
            try {
                int iM8006g2 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g2 == 0 && Utilities.f16743d && applicationInfo.category == 1) {
                    iM8006g2 = 2;
                }
                z6 = iM8006g2 == 2;
            } catch (Throwable unused2) {
            }
            if (z6) {
                launcher.getModel().enqueuePackageUpdate(2, componentName.flattenToString());
                return 2;
            }
            try {
                int iM8006g3 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g3 == 0 && Utilities.f16743d && applicationInfo.category == 2) {
                    iM8006g3 = 3;
                }
                z7 = iM8006g3 == 3;
            } catch (Throwable unused3) {
            }
            if (z7) {
                launcher.getModel().enqueuePackageUpdate(3, componentName.flattenToString());
                return 3;
            }
            try {
                int iM8006g4 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g4 == 0 && Utilities.f16743d && applicationInfo.category == 3) {
                    iM8006g4 = 4;
                }
                z8 = iM8006g4 == 4;
            } catch (Throwable unused4) {
            }
            if (z8) {
                launcher.getModel().enqueuePackageUpdate(4, componentName.flattenToString());
                return 4;
            }
            try {
                int iM8006g5 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g5 == 0 && Utilities.f16743d && applicationInfo.category == 4) {
                    iM8006g5 = 5;
                }
                z9 = iM8006g5 == 5;
            } catch (Throwable unused5) {
            }
            if (z9) {
                launcher.getModel().enqueuePackageUpdate(5, componentName.flattenToString());
                return 5;
            }
            try {
                int iM8006g6 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g6 == 0 && Utilities.f16743d && applicationInfo.category == 5) {
                    iM8006g6 = 6;
                }
                z10 = iM8006g6 == 6;
            } catch (Throwable unused6) {
            }
            if (z10) {
                launcher.getModel().enqueuePackageUpdate(6, componentName.flattenToString());
                return 6;
            }
            try {
                int iM8006g7 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g7 == 0 && Utilities.f16743d && applicationInfo.category == 6) {
                    iM8006g7 = 7;
                }
                z11 = iM8006g7 == 7;
            } catch (Throwable unused7) {
            }
            if (z11) {
                launcher.getModel().enqueuePackageUpdate(7, componentName.flattenToString());
                return 7;
            }
            try {
                int iM8006g8 = launcher.getIconCache().m8006g(componentName);
                if (iM8006g8 == 0 && Utilities.f16743d && applicationInfo.category == 7) {
                    iM8006g8 = 8;
                }
                if (iM8006g8 == 8) {
                    z12 = true;
                }
            } catch (Throwable unused8) {
            }
            if (z12) {
                launcher.getModel().enqueuePackageUpdate(8, componentName.flattenToString());
                return 8;
            }
            launcher.getModel().enqueuePackageUpdate(9, componentName.flattenToString());
        }
        return 9;
    }

    /* JADX INFO: renamed from: I */
    public final void updateTransitionAlpha(int i6, float f6) {
        BouncyRecyclerView bouncyRecyclerView = this.f16291l;
        BouncyRecyclerView bouncyRecyclerView2 = this.f16290k;
        if (i6 == R.id.apps_library_start) {
            bouncyRecyclerView2.setAlpha(f6);
            bouncyRecyclerView.setAlpha(1.0f - f6);
        } else if (i6 == R.id.apps_library_end) {
            bouncyRecyclerView2.setAlpha(1.0f - f6);
            bouncyRecyclerView.setAlpha(f6);
        }
    }

    /* JADX INFO: renamed from: J */
    public final void onTransitionStateChanged(int i6) {
        InputMethodManager inputMethodManager = this.f16304y;
        ExtendedEditText extendedEditText = this.f16299t;
        if (i6 == R.id.apps_library_end) {
            this.f16300u = true;
            extendedEditText.requestFocus();
            extendedEditText.requestFocus();
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(extendedEditText, 0);
                return;
            }
            return;
        }
        if (i6 == R.id.apps_library_start) {
            this.f16293n.setVisibility(8);
            BouncyRecyclerView bouncyRecyclerView = this.f16291l;
            bouncyRecyclerView.setVisibility(8);
            bouncyRecyclerView.setAlpha(0.0f);
            this.f16300u = false;
            extendedEditText.setText("");
            extendedEditText.clearFocus();
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(extendedEditText.getWindowToken(), 0);
            }
        }
    }

    /* JADX INFO: renamed from: K */
    public final void refreshGlassBackground() {
        Launcher launcher = this.f16289j;
        if (launcher.isUseLiquidGlass) {
            if (!launcher.isRuntimeRenderSupport) {
                LiquidGlassRenderer liquidGlassRenderer = LiquidGlassRenderer.getInstance(launcher);
                Bitmap bitmap = launcher.getBlurWallpaperProvider().f20555e;
                liquidGlassRenderer.getClass();
                if (bitmap != null && !bitmap.isRecycled()) {
                    liquidGlassRenderer.queueEvent(new GlassBitmapUploadRunnable(liquidGlassRenderer, bitmap, 1));
                }
                LiquidGlassRenderer.getInstance(launcher).setMaskResource(R.drawable.lib);
                return;
            }
            int i6 = 0;
            while (true) {
                BouncyRecyclerView bouncyRecyclerView = this.f16290k;
                if (i6 >= bouncyRecyclerView.getChildCount()) {
                    break;
                }
                AppsLibraryItemFull appsLibraryItemFull = (AppsLibraryItemFull) bouncyRecyclerView.getChildAt(i6);
                Bitmap bitmap2 = launcher.getBlurWallpaperProvider().f20555e;
                RuntimeShaderGlassView runtimeShaderGlassView = appsLibraryItemFull.f16264s;
                if (runtimeShaderGlassView != null) {
                    runtimeShaderGlassView.setFullBitmap(bitmap2);
                }
                i6++;
            }
            RuntimeShaderGlassView runtimeShaderGlassView2 = this.f16298s;
            if (runtimeShaderGlassView2 != null) {
                runtimeShaderGlassView2.setFullBitmap(launcher.getBlurWallpaperProvider().f20555e);
            }
        }
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: a */
    public final void mo7593a() {
        post(new RunnableC0064g(16, this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        BouncyRecyclerView bouncyRecyclerView;
        Objects.toString(keyEvent);
        if (keyEvent == null || keyEvent.getKeyCode() != 4 || (bouncyRecyclerView = this.f16291l) == null || bouncyRecyclerView.getVisibility() != 0) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        transitionToStart();
        return true;
    }

    public AppsLibraryProgressCallback getCallBack() {
        return this.f16288B;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            loadLayoutDescription(R.xml.apps_library_layout_scene);
            C1428p constraintSet = getConstraintSet(R.id.apps_library_end);
            DeviceProfile deviceProfile = this.f16289j.mDeviceProfile;
            int i6 = ((deviceProfile.f16009i + deviceProfile.f15983I) - deviceProfile.f15978D) - deviceProfile.f15980F;
            int i7 = this.f16301v * 2;
            constraintSet.m3051r(3, i6);
            constraintSet.m3051r(6, i7);
            constraintSet.m3051r(7, i7);
            updateState(R.id.apps_library_end, constraintSet);
        } catch (Throwable unused) {
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9){
        super.onLayout(z5, i6, i7, i8, i9);
        RuntimeShaderGlassView runtimeShaderGlassView = this.f16298s;
        if (runtimeShaderGlassView != null) {
            runtimeShaderGlassView.updateGlViewPosition();
        }
    }

    @Override // Z3.InterfaceC1307g
    /* JADX INFO: renamed from: r */
    public final void mo2492r(View view) {
        try {
            this.f16289j.startAppShortcutOrInfoActivity(view);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void setApps(ArrayList<AppInfo> arrayList) {
        try {
            new CallableC3080a(new CallableC0366v(this, arrayList, 3)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C1029l(29, this), AbstractC2679b.m9681a(), 1));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC1314a.m2681A(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public void setDarkMode(boolean z5) {
        this.f16297r.setDarkModeTransparentBackground(z5);
    }

    public void setUseTransparency(boolean z5) {
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: q */
    public final void mo7594q() {
    }
}
