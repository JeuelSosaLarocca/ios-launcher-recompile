package com.luutinhit.launcher6;

import A2.C0022a;
import A4.RunnableC0026a;
import A4.RunnableC0027b;
import B3.C0068k;
import B3.C0069l;
import C2.C0148h;
import E4.AbstractC0212f;
import G3.CallableC0366v;
import G3.RunnableC0360p;
import O3.AbstractC0744e;
import T0.C1029l;
import Y0.RunnableC1204i;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.C1428p;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.util.BadgeTextView;
import com.luutinhit.launcher6.util.CustomIconView;
import com.luutinhit.launcher6.util.DeleteCircleView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.text.NumberFormat;
import java.util.List;
import java.util.Objects;
import p024a.AbstractC1314a;
import p119q4.AbstractC2620e;
import p123r4.AbstractC2679b;
import p127s4.C2750c;
import p127s4.InterfaceC2749b;
import p141v4.EnumC2867a;
import p146w4.AbstractC2934a;
import p154y3.C3031f;

/* JADX INFO: loaded from: classes.dex */
public class BubbleTextView extends ConstraintLayout implements FastScrollFocusableView {

    /* JADX INFO: renamed from: I */
    public static final SparseArray sPreloaderThemes = new SparseArray(2);

    /* JADX INFO: renamed from: A */
    public Partner f15388A;

    /* JADX INFO: renamed from: B */
    public int[] f15389B;

    /* JADX INFO: renamed from: C */
    public boolean f15390C;

    /* JADX INFO: renamed from: D */
    public ObjectAnimator f15391D;

    /* JADX INFO: renamed from: E */
    public ObjectAnimator f15392E;

    /* JADX INFO: renamed from: F */
    public MergedUiRunnable f15393F;

    /* JADX INFO: renamed from: G */
    public LauncherApps f15394G;

    /* JADX INFO: renamed from: H */
    public List f15395H;

    /* JADX INFO: renamed from: j */
    public Launcher f15396j;

    /* JADX INFO: renamed from: k */
    public Drawable mIcon;

    /* JADX INFO: renamed from: l */
    public Bitmap f15398l;

    /* JADX INFO: renamed from: m */
    public C0148h f15399m;

    /* JADX INFO: renamed from: n */
    public StylusEventHelper f15400n;

    /* JADX INFO: renamed from: o */
    public float f15401o;

    /* JADX INFO: renamed from: p */
    public boolean f15402p;

    /* JADX INFO: renamed from: q */
    public int f15403q;

    /* JADX INFO: renamed from: r */
    public int f15404r;

    /* JADX INFO: renamed from: s */
    public boolean f15405s;

    /* JADX INFO: renamed from: t */
    public boolean f15406t;

    /* JADX INFO: renamed from: u */
    public boolean f15407u;

    /* JADX INFO: renamed from: v */
    public CustomIconView f15408v;

    /* JADX INFO: renamed from: w */
    public TextViewCustomFont f15409w;

    /* JADX INFO: renamed from: x */
    public DeleteCircleView f15410x;

    /* JADX INFO: renamed from: y */
    public BadgeTextView f15411y;

    /* JADX INFO: renamed from: z */
    public String f15412z;

    public BubbleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Resources.Theme getPreloaderTheme() {
        Object tag = getTag();
        int i6 = (!(tag instanceof ShortcutInfo) || ((ShortcutInfo) tag).container < 0) ? R.style.PreloadIcon : R.style.PreloadIcon_Folder;
        SparseArray sparseArray = sPreloaderThemes;
        Resources.Theme theme = (Resources.Theme) sparseArray.get(i6);
        if (theme != null) {
            return theme;
        }
        Resources.Theme themeNewTheme = getResources().newTheme();
        themeNewTheme.applyStyle(i6, true);
        sparseArray.put(i6, themeNewTheme);
        return themeNewTheme;
    }

    /* JADX INFO: renamed from: A */
    public final void applyFromPackageItemInfo(C3031f c3031f) {
        if (c3031f != null) {
            this.f15412z = c3031f.f21973C;
            m7599H(this.f15396j.createIconDrawable(c3031f.f21971A), this.f15403q);
            setText(c3031f.title);
            CharSequence charSequence = c3031f.contentDescription;
            if (charSequence != null) {
                setContentDescription(charSequence);
            }
            super.setTag(c3031f);
            verifyHighRes();
        }
    }

    /* JADX INFO: renamed from: D */
    public final void applyFromShortcutInfo(ShortcutInfo shortcutInfo, IconCache iconCache, boolean z5) {
        if (shortcutInfo != null) {
            if (shortcutInfo.getTargetComponent() != null) {
                this.f15412z = shortcutInfo.getTargetComponent().flattenToString();
            }
            if (shortcutInfo.f16558F == null) {
                shortcutInfo.m8056i(iconCache);
            }
            Bitmap bitmap = shortcutInfo.f16558F;
            this.f15398l = bitmap;
            bitmap.getWidth();
            this.f15398l.getHeight();
            FastBitmapDrawable fastBitmapDrawableCreateIconDrawable = this.f15396j.createIconDrawable(this.f15398l);
            if (shortcutInfo.mo7985c()) {
                fastBitmapDrawableCreateIconDrawable.m7684f(FastBitmapDrawableState.DISABLED);
            }
            m7599H(fastBitmapDrawableCreateIconDrawable, this.f15403q);
            CharSequence charSequence = shortcutInfo.contentDescription;
            if (charSequence != null) {
                setContentDescription(charSequence);
            }
            setText(shortcutInfo.title);
            setTag(shortcutInfo);
            if (z5 || shortcutInfo.hasStatusFlag(3)) {
                applyState(z5);
            }
        }
    }

    /* JADX INFO: renamed from: F */
    public final void applyState(boolean z5) {
        ShortcutInfo shortcutInfo;
        int i6;
        PreloadIconDrawable preloadIconDrawable;
        if (!(getTag() instanceof ShortcutInfo) || (shortcutInfo = (ShortcutInfo) getTag()) == null) {
            return;
        }
        if (shortcutInfo.getTargetComponent() != null) {
            this.f15412z = shortcutInfo.getTargetComponent().flattenToString();
        }
        if (shortcutInfo.hasStatusFlag(3)) {
            i6 = shortcutInfo.hasStatusFlag(4) ? shortcutInfo.f16561I : 0;
        } else {
            i6 = 100;
        }
        setContentDescription(i6 > 0 ? getContext().getString(R.string.app_downloading_title, shortcutInfo.title, NumberFormat.getPercentInstance().format(((double) i6) * 0.01d)) : getContext().getString(R.string.app_waiting_download_title, shortcutInfo.title));
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            if (drawable instanceof PreloadIconDrawable) {
                preloadIconDrawable = (PreloadIconDrawable) drawable;
            } else {
                preloadIconDrawable = new PreloadIconDrawable(this.mIcon, getPreloaderTheme());
                m7599H(preloadIconDrawable, this.f15403q);
            }
            preloadIconDrawable.setLevel(i6);
            if (!z5 || preloadIconDrawable.f16234i > -1.0f) {
                return;
            }
            ObjectAnimator objectAnimator = preloadIconDrawable.f16235j;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (0.0f != preloadIconDrawable.f16234i) {
                preloadIconDrawable.f16234i = 0.0f;
                preloadIconDrawable.invalidateSelf();
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(preloadIconDrawable, "animationProgress", 0.0f, 1.0f);
            preloadIconDrawable.f16235j = objectAnimatorOfFloat;
            objectAnimatorOfFloat.start();
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m7598G() {
        if (this.f15391D.isRunning()) {
            this.f15391D.cancel();
        }
        if (this.f15390C) {
            this.f15392E.start();
        }
    }

    /* JADX INFO: renamed from: H */
    public final void m7599H(Drawable drawable, int i6) {
        Drawable drawable2;
        CustomIconView customIconView = this.f15408v;
        customIconView.getWidth();
        this.mIcon = drawable;
        String str = this.f15412z;
        if (str == null || (!(str.contains("clock") || this.f15412z.contains("ch.bitspin.timely") || (this.f15412z.contains("organizer") && !this.f15412z.contains("microsoft"))) || this.f15412z.contains("wearable"))) {
            String str2 = this.f15412z;
            if (str2 != null && str2.contains("calendar")) {
                float f6 = i6;
                this.mIcon = new C0068k(getContext(), f6, f6);
            }
        } else {
            customIconView.setClockView(true);
            float f7 = i6;
            this.mIcon = new C0069l(getContext(), f7, f7);
        }
        if (i6 != -1 && (drawable2 = this.mIcon) != null) {
            drawable2.setBounds(0, 0, i6, i6);
        }
        customIconView.setBackgroundDrawable(this.mIcon);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0034  */
    /* JADX INFO: renamed from: I */
    public final void m7600I() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Pair pairCreate;
        Object tag = getTag();
        if (tag instanceof AppInfo) {
            AppInfo appInfo = (AppInfo) tag;
            pairCreate = Pair.create(appInfo.f16329D, Integer.valueOf(appInfo.f16331F));
        } else if (tag instanceof ShortcutInfo) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) tag;
            ComponentName targetComponent = shortcutInfo.getTargetComponent();
            if (shortcutInfo.itemType != 0 || targetComponent == null) {
                pairCreate = null;
            } else {
                pairCreate = Pair.create(targetComponent, Integer.valueOf(shortcutInfo.f16562J));
            }
        } else {
            pairCreate = null;
        }
        DeleteCircleView deleteCircleView = this.f15410x;
        if (pairCreate == null && (tag instanceof ShortcutInfo)) {
            if (((ShortcutInfo) tag).itemType == 1) {
                deleteCircleView.m8196c(0, true);
            }
        } else if (pairCreate != null) {
            deleteCircleView.m8196c(0, true);
        }
    }

    /* JADX INFO: renamed from: J */
    public final void m7601J() {
        Drawable drawable = this.mIcon;
        if (drawable instanceof FastBitmapDrawable) {
            FastBitmapDrawable fastBitmapDrawable = (FastBitmapDrawable) drawable;
            if ((getTag() instanceof ItemInfo) && ((ItemInfo) getTag()).mo7985c()) {
                fastBitmapDrawable.setState(FastBitmapDrawableState.DISABLED);
            } else if (this.f15405s) {
                fastBitmapDrawable.setState(FastBitmapDrawableState.PRESSED);
            } else {
                fastBitmapDrawable.setState(FastBitmapDrawableState.NORMAL);
            }
        }
    }

    /* JADX INFO: renamed from: K */
    public final void verifyHighRes() {
        Partner partner = this.f15388A;
        if (partner != null) {
            ((Handler) partner.f16124l).removeCallbacks((RunnableC0360p) partner.f16123k);
            this.f15388A = null;
        }
        if (getTag() instanceof AppInfo) {
            AppInfo appInfo = (AppInfo) getTag();
            if (appInfo.f16328C) {
                this.f15388A = LauncherAppState.getInstance().f16219b.m7998K(this, appInfo);
                return;
            }
            return;
        }
        if (getTag() instanceof ShortcutInfo) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) getTag();
            if (shortcutInfo.f16556D) {
                this.f15388A = LauncherAppState.getInstance().f16219b.m7998K(this, shortcutInfo);
                return;
            }
            return;
        }
        if (getTag() instanceof C3031f) {
            C3031f c3031f = (C3031f) getTag();
            if (c3031f.f21972B) {
                this.f15388A = LauncherAppState.getInstance().f16219b.m7998K(this, c3031f);
            }
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.f15399m.m362b();
    }

    public BadgeTextView getBadgeView() {
        return this.f15411y;
    }

    public Bitmap getBitmapIcon() {
        return this.f15398l;
    }

    public String getComponentName() {
        return this.f15412z;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getIconSize() {
        return this.f15403q;
    }

    public CustomIconView getIconView() {
        return this.f15408v;
    }

    public int[] getLocationIcon() {
        int[] iArr = this.f15389B;
        return iArr != null ? iArr : getLocationIconViewOnScreen();
    }

    public int[] getLocationIconViewOnScreen() {
        int[] iArr = new int[2];
        getIconView().getLocationOnScreen(iArr);
        return iArr;
    }

    public TextView getName() {
        return this.f15409w;
    }

    public String getPackageName() {
        String str = this.f15412z;
        if (str == null) {
            return null;
        }
        if (!str.contains("/")) {
            return this.f15412z;
        }
        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(this.f15412z);
        if (componentNameUnflattenFromString != null) {
            return componentNameUnflattenFromString.getPackageName();
        }
        return null;
    }

    public List<android.content.pm.ShortcutInfo> getShortcutInfoList() {
        return this.f15395H;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.mIcon;
        if (drawable instanceof PreloadIconDrawable) {
            ((PreloadIconDrawable) drawable).applyPreloaderTheme(getPreloaderTheme());
        }
        this.f15401o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Drawable drawable = this.mIcon;
        boolean z5 = drawable instanceof C0069l;
        Launcher launcher = this.f15396j;
        if (z5) {
            launcher.removeOnTinyDBChangeListener((C0069l) drawable);
        } else if (drawable instanceof C0068k) {
            launcher.removeOnTinyDBChangeListener((C0068k) drawable);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i6, KeyEvent keyEvent) {
        this.f15406t = true;
        boolean zOnKeyUp = super.onKeyUp(i6, keyEvent);
        this.f15406t = false;
        m7601J();
        return zOnKeyUp;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        Launcher launcher = this.f15396j;
        launcher.mDeviceProfile.f15980F = getName().getMeasuredHeight();
        DeviceProfile deviceProfile = launcher.mDeviceProfile;
        deviceProfile.f15987M = (deviceProfile.f15977C * 2) - ((deviceProfile.f15986L - deviceProfile.f15984J) - deviceProfile.f15980F);
        int i10 = -deviceProfile.f15975A;
        float f6 = launcher.isRTL ? -i10 : i10;
        DeleteCircleView deleteCircleView = this.f15410x;
        deleteCircleView.setTranslationX(f6);
        deleteCircleView.setTranslationY(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (r2 != 3) goto L30;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        StylusEventHelper stylusEventHelper = this.f15400n;
        boolean zCheckAndPerformStylusEvent = stylusEventHelper.checkAndPerformStylusEvent(motionEvent);
        C0148h c0148h = this.f15399m;
        if (zCheckAndPerformStylusEvent) {
            c0148h.m362b();
            zOnTouchEvent = true;
        }
        int action = motionEvent.getAction();
        MergedUiRunnable mergedUiRunnable = this.f15393F;
        Launcher launcher = this.f15396j;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!Utilities.pointInView(this, motionEvent.getX(), motionEvent.getY(), this.f15401o)) {
                        c0148h.m362b();
                        return zOnTouchEvent;
                    }
                }
            }
            removeCallbacks(mergedUiRunnable);
            setStayPressed(false);
            launcher.onTouchIcon(this, motionEvent);
            c0148h.m362b();
            return zOnTouchEvent;
        }
        if (!this.f15406t) {
            this.f15405s = true;
            m7601J();
        }
        if (!stylusEventHelper.f16610a) {
            c0148h.m364d();
        }
        if (!launcher.isShaking() && !launcher.isWidgetsViewVisible()) {
            this.f15390C = false;
            this.f15389B = getLocationIconViewOnScreen();
            postDelayed(mergedUiRunnable, ViewConfiguration.getTapTimeout() + 200);
        }
        return zOnTouchEvent;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f15407u) {
            return;
        }
        super.requestLayout();
    }

    public void setLongPressTimeout(int i6) {
        this.f15399m.f429b = i6;
    }

    public void setStayPressed(boolean z5) {
        this.f15405s = z5;
        m7601J();
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        int i6 = 1;
        if (obj != null) {
            ItemInfo itemInfo = (ItemInfo) obj;
            HandlerThread handlerThread = LauncherModel.sWorkerThread;
            Objects.toString(itemInfo);
            LauncherModel.m7567y(new RunnableC1204i(itemInfo.id, itemInfo, new Throwable().getStackTrace()));
            C1029l c1029l = new C1029l(i6, new CallableC0366v(this, obj, 2));
            AbstractC2620e abstractC2620e = AbstractC0212f.f640a;
            AbstractC2934a.m10120a(abstractC2620e, "scheduler is null");
            try {
                RunnableC0026a runnableC0026a = new RunnableC0026a(new MergedItemCallbacks(i6, this), AbstractC2679b.m9681a(), 0);
                try {
                    RunnableC0027b runnableC0027b = new RunnableC0027b(runnableC0026a, c1029l);
                    runnableC0026a.mo38c(runnableC0027b);
                    InterfaceC2749b interfaceC2749bM9550b = abstractC2620e.m9550b(runnableC0027b);
                    C2750c c2750c = runnableC0027b.f66l;
                    c2750c.getClass();
                    EnumC2867a.m10032c(c2750c, interfaceC2749bM9550b);
                } catch (NullPointerException e) {
                    throw e;
                } catch (Throwable th) {
                    AbstractC1314a.m2681A(th);
                    NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                    nullPointerException.initCause(th);
                    throw nullPointerException;
                }
            } catch (NullPointerException e5) {
                throw e5;
            } catch (Throwable th2) {
                AbstractC1314a.m2681A(th2);
                NullPointerException nullPointerException2 = new NullPointerException("subscribeActual failed");
                nullPointerException2.initCause(th2);
                throw nullPointerException2;
            }
        }
        super.setTag(obj);
    }

    public void setText(CharSequence charSequence) {
        this.f15409w.setText(charSequence);
    }

    public void setTextColor(int i6) {
        this.f15404r = i6;
        this.f15409w.setTextColor(i6);
    }

    public void setTextVisibility(boolean z5) {
        TextViewCustomFont textViewCustomFont = this.f15409w;
        if (textViewCustomFont != null) {
            textViewCustomFont.setVisibility(z5 ? 0 : 8);
        }
        if (z5) {
            return;
        }
        C1428p c1428p = new C1428p();
        c1428p.m3044e(this);
        c1428p.m3046g(R.id.icon_app, 3, 3);
        c1428p.m3046g(R.id.icon_app, 4, 4);
        c1428p.m3042b(this);
    }

    /* JADX INFO: renamed from: y */
    public final void applyFromApplicationInfo(AppInfo appInfo) {
        if (appInfo != null) {
            ComponentName componentName = appInfo.f16329D;
            if (componentName != null) {
                this.f15412z = componentName.flattenToString();
            }
            FastBitmapDrawable fastBitmapDrawableCreateIconDrawable = this.f15396j.createIconDrawable(appInfo.f16327B);
            if (appInfo.mo7985c()) {
                fastBitmapDrawableCreateIconDrawable.m7684f(FastBitmapDrawableState.DISABLED);
            }
            m7599H(fastBitmapDrawableCreateIconDrawable, this.f15403q);
            setText(appInfo.title);
            CharSequence charSequence = appInfo.contentDescription;
            if (charSequence != null) {
                setContentDescription(charSequence);
            }
            super.setTag(appInfo);
            verifyHighRes();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, 0);
        int i7 = 8;
        this.f15404r = -1;
        this.f15406t = false;
        this.f15407u = false;
        this.f15412z = "";
        this.f15390C = false;
        this.f15393F = new MergedUiRunnable(2, this);
        this.f15394G = null;
        this.f15395H = null;
        LayoutInflater.from(context).inflate(R.layout.icon_view_layout, (ViewGroup) this, true);
        this.f15408v = (CustomIconView) findViewById(R.id.icon_app);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(R.id.icon_name);
        this.f15409w = textViewCustomFont;
        this.f15410x = (DeleteCircleView) findViewById(R.id.icon_delete);
        this.f15411y = (BadgeTextView) findViewById(R.id.icon_badge);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2242f, 0, 0);
        this.f15402p = typedArrayObtainStyledAttributes.getBoolean(4, false);
        textViewCustomFont.setVisibility(typedArrayObtainStyledAttributes.getBoolean(1, false) ? 8 : 0);
        typedArrayObtainStyledAttributes.recycle();
        Launcher launcher = (Launcher) context;
        this.f15396j = launcher;
        if (Utilities.f16744e) {
            this.f15394G = (LauncherApps) context.getSystemService("launcherapps");
        }
        DeviceProfile deviceProfile = launcher.getDeviceProfile();
        int i8 = deviceProfile.f15978D;
        this.f15403q = i8;
        C1428p c1428p = new C1428p();
        c1428p.m3044e(this);
        c1428p.m3047j(R.id.icon_app).f4702e.f4734c = i8;
        c1428p.m3047j(R.id.icon_app).f4702e.f4735d = i8;
        c1428p.m3042b(this);
        setClipChildren(false);
        setClipToPadding(false);
        textViewCustomFont.setTextSize(0, deviceProfile.f15979E);
        setTextColor(this.f15404r);
        textViewCustomFont.measure(0, 0);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.96f, 1.1f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.96f, 1.1f));
        objectAnimatorOfPropertyValuesHolder.addListener(new C0022a(i7, this));
        objectAnimatorOfPropertyValuesHolder.setDuration(368L);
        this.f15391D = objectAnimatorOfPropertyValuesHolder;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        objectAnimatorOfPropertyValuesHolder2.addListener(new SharedAnimatorListener(0));
        objectAnimatorOfPropertyValuesHolder2.setDuration(268L);
        this.f15392E = objectAnimatorOfPropertyValuesHolder2;
        this.f15399m = new C0148h(this);
        this.f15400n = new StylusEventHelper(this);
        setAccessibilityDelegate(LauncherAppState.getInstance().f16223f);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f15404r = colorStateList.getDefaultColor();
        this.f15409w.setTextColor(colorStateList);
    }
}
