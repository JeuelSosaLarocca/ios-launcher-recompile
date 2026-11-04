package com.luutinhit.launcher6;

import A2.C0022a;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.PathInterpolator;
import java.util.HashMap;
import java.util.Objects;
import p131t3.ViewOnClickListenerC2791d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.f3 */
/* JADX INFO: loaded from: classes.dex */
public final class ShortcutAndWidgetContainer extends ViewGroup {

    /* JADX INFO: renamed from: A */
    public float[] f16494A;

    /* JADX INFO: renamed from: B */
    public HashMap f16495B;

    /* JADX INFO: renamed from: C */
    public AnimatorSet f16496C;

    /* JADX INFO: renamed from: D */
    public int[] f16497D;

    /* JADX INFO: renamed from: j */
    public int[] f16498j;

    /* JADX INFO: renamed from: k */
    public WallpaperManager f16499k;

    /* JADX INFO: renamed from: l */
    public boolean mIsHotseatLayout;

    /* JADX INFO: renamed from: m */
    public int f16501m;

    /* JADX INFO: renamed from: n */
    public int f16502n;

    /* JADX INFO: renamed from: o */
    public int f16503o;

    /* JADX INFO: renamed from: p */
    public int f16504p;

    /* JADX INFO: renamed from: q */
    public int f16505q;

    /* JADX INFO: renamed from: r */
    public Launcher f16506r;

    /* JADX INFO: renamed from: s */
    public DeviceProfile grid;

    /* JADX INFO: renamed from: t */
    public Boolean f16508t;

    /* JADX INFO: renamed from: u */
    public boolean f16509u;

    /* JADX INFO: renamed from: v */
    public HashMap f16510v;

    /* JADX INFO: renamed from: w */
    public HashMap f16511w;

    /* JADX INFO: renamed from: x */
    public boolean mInvertIfRtl;

    /* JADX INFO: renamed from: y */
    public float[] f16513y;

    /* JADX INFO: renamed from: z */
    public float[] f16514z;

    public ShortcutAndWidgetContainer(Context context) {
        super(context);
        this.f16498j = new int[2];
        this.f16508t = Boolean.FALSE;
        this.f16509u = false;
        this.f16510v = new HashMap();
        this.f16511w = new HashMap();
        this.mInvertIfRtl = false;
        this.f16513y = new float[]{-9.0f, -3.0f, 6.0f, 12.0f, -10.0f, -2.0f, 5.0f, 13.0f, -13.0f, -3.0f, 6.0f, 16.0f, -17.0f, -6.0f, 9.0f, 20.0f, -22.0f, -9.0f, 12.0f, 25.0f, -28.0f, -12.0f, 15.0f, 31.0f};
        this.f16514z = new float[]{-12.0f, -10.0f, -10.0f, -12.0f, -1.0f, -3.5f, -3.5f, -1.0f, 10.0f, 6.0f, 6.0f, 10.0f, 28.0f, 25.0f, 25.0f, 28.0f, 45.0f, 40.0f, 40.0f, 45.0f, 55.0f, 50.0f, 50.0f, 55.0f};
        this.f16494A = new float[]{6.0f, 6.0f, 6.0f, 6.0f, 8.0f, 8.0f, 8.0f, 8.0f, 8.0f, 10.0f, 10.0f, 8.0f, 10.0f, 10.0f, 10.0f, 10.0f, 13.0f, 13.0f, 13.0f, 13.0f, 15.0f, 15.0f, 15.0f, 15.0f};
        this.f16495B = new HashMap();
        this.f16497D = new int[2];
        setClipChildren(false);
        setClipToPadding(false);
        Launcher launcher = (Launcher) context;
        this.f16506r = launcher;
        this.grid = launcher.getDeviceProfile();
        this.f16499k = WallpaperManager.getInstance(context);
        this.f16496C = LauncherAnimUtils.createAnimatorSet();
    }

    public void setPivotsForZoom(View view) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
    }

    /* JADX INFO: renamed from: a */
    public final void m8037a() {
        this.f16508t = Boolean.FALSE;
        ShortcutContainerRunnable shortcutContainerRunnable = new ShortcutContainerRunnable(this, 2);
        if (getMeasuredWidth() == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new GlobalLayoutOnceListener(this, shortcutContainerRunnable, 1));
        } else {
            shortcutContainerRunnable.run();
        }
    }

    /* JADX INFO: renamed from: b */
    public final View getChildAt(int i6, int i7) {
        int i8;
        try {
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
                int i10 = cellLayoutLayoutParams.f15685a;
                if (i10 <= i6 && i6 < i10 + cellLayoutLayoutParams.f15690f && (i8 = cellLayoutLayoutParams.f15686b) <= i7 && i7 < i8 + cellLayoutLayoutParams.f15691g) {
                    return childAt;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final void m8039c() {
        if (this.mIsHotseatLayout || (getChildAt(0) instanceof ViewOnClickListenerC2791d)) {
            return;
        }
        int i6 = 0;
        while (true) {
            int childCount = getChildCount();
            HashMap map = this.f16495B;
            if (i6 >= childCount) {
                map.size();
                return;
            }
            View childAt = getChildAt(i6);
            if ((childAt instanceof BubbleTextView) || (childAt instanceof FolderIcon)) {
                Object tag = childAt.getTag();
                if (tag instanceof ItemInfo) {
                    ItemInfo itemInfo = (ItemInfo) tag;
                    int i7 = (itemInfo.cellY * this.grid.inv.f16712d) + itemInfo.cellX;
                    PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.f16503o * this.f16513y[i7], 0.0f);
                    PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.f16504p * this.f16514z[i7], 0.0f);
                    float[] fArr = this.f16494A;
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(childAt, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, fArr[i7], 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, fArr[i7], 1.0f));
                    objectAnimatorOfPropertyValuesHolder.setDuration(866L);
                    map.put(childAt, objectAnimatorOfPropertyValuesHolder);
                }
            }
            i6++;
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).cancelLongPress();
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean invertLayoutHorizontally() {
        return this.mInvertIfRtl && Utilities.isRtl(getResources());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f16503o == 0 && this.f16504p == 0) {
            int measuredWidth = getMeasuredWidth();
            DeviceProfile deviceProfile = this.grid;
            this.f16503o = measuredWidth / deviceProfile.inv.f16712d;
            this.f16504p = getMeasuredHeight() / deviceProfile.inv.f16711c;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void measureChild(View view) {
        int i6 = this.f16501m;
        int i7 = this.f16502n;
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        if (cellLayoutLayoutParams.f15693i) {
            cellLayoutLayoutParams.f15695k = 0;
            cellLayoutLayoutParams.f15696l = 0;
            ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).width = getMeasuredWidth();
            ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).height = getMeasuredHeight();
        } else {
            cellLayoutLayoutParams.m7743a(i6, i7, this.f16505q, invertLayoutHorizontally());
            if (!(view instanceof LauncherAppWidgetHostView)) {
                int i8 = (int) (this.grid.f16020t / 2.0f);
                view.setPadding(i8, 0, i8, 0);
            }
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).width, 1073741824), View.MeasureSpec.makeMeasureSpec(((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).height, 1073741824));
    }

    /* JADX INFO: renamed from: f */
    public final void m8042f() {
        HashMap map = this.f16495B;
        if (map.isEmpty()) {
            this.f16509u = false;
            return;
        }
        this.f16496C.setInterpolator(new PathInterpolator(0.0f, 1.01f, 0.0f, 1.01f));
        this.f16496C.playTogether(map.values());
        this.f16496C.addListener(new C0022a(16, this));
        this.f16496C.start();
    }

    /* JADX INFO: renamed from: g */
    public final void m8043g() {
        this.f16509u = true;
        if (this.f16495B.size() != getChildCount()) {
            m8039c();
        }
        this.f16496C = LauncherAnimUtils.createAnimatorSet();
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof BubbleTextView) || (childAt instanceof FolderIcon)) {
                Object tag = childAt.getTag();
                if (tag instanceof ItemInfo) {
                    ItemInfo itemInfo = (ItemInfo) tag;
                    int i7 = (itemInfo.cellY * this.grid.inv.f16712d) + itemInfo.cellX;
                    childAt.setTranslationX(this.f16503o * this.f16513y[i7]);
                    childAt.setTranslationY(this.f16504p * this.f16514z[i7]);
                    float[] fArr = this.f16494A;
                    childAt.setScaleX(fArr[i7]);
                    childAt.setScaleY(fArr[i7]);
                }
            }
        }
    }

    public int getCellContentHeight() {
        int measuredHeight = getMeasuredHeight();
        boolean z5 = this.mIsHotseatLayout;
        DeviceProfile deviceProfile = this.grid;
        return Math.min(measuredHeight, z5 ? deviceProfile.f15991Q : deviceProfile.f15983I);
    }

    public int getCellContentWidth() {
        int measuredHeight = getMeasuredHeight();
        boolean z5 = this.mIsHotseatLayout;
        DeviceProfile deviceProfile = this.grid;
        return Math.min(measuredHeight, z5 ? deviceProfile.f15990P : deviceProfile.f15982H);
    }

    /* JADX INFO: renamed from: h */
    public final float m8044h(View view) {
        float width;
        double dRandom;
        if (view instanceof LauncherAppWidgetHostView) {
            width = view.getWidth();
            dRandom = Math.random();
        } else {
            int i6 = this.f16503o;
            if (i6 == 0) {
                i6 = this.grid.f15982H;
            }
            width = i6;
            dRandom = Math.random();
        }
        return ((((float) dRandom) * 0.38f) + 0.3f) * width;
    }

    /* JADX INFO: renamed from: i */
    public final float m8045i(View view) {
        float height;
        float fRandom;
        float f6;
        if (view instanceof LauncherAppWidgetHostView) {
            height = view.getHeight();
            fRandom = ((float) Math.random()) * 0.38f;
            f6 = 0.3f;
        } else {
            int i6 = this.f16504p;
            if (i6 == 0) {
                i6 = this.grid.f15983I;
            }
            height = i6;
            fRandom = ((float) Math.random()) * 0.38f;
            f6 = 0.36f;
        }
        return (fRandom + f6) * height;
    }

    /* JADX INFO: renamed from: j */
    public final void m8046j(int i6, int i7, int i8, int i9) {
        this.f16501m = i6;
        this.f16502n = i7;
        this.f16505q = i8;
    }

    /* JADX INFO: renamed from: k */
    public final void m8047k() {
        this.f16508t = Boolean.TRUE;
        ShortcutContainerRunnable shortcutContainerRunnable = new ShortcutContainerRunnable(this, 1);
        if (getMeasuredWidth() == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new GlobalLayoutOnceListener(this, shortcutContainerRunnable, 0));
        } else {
            shortcutContainerRunnable.run();
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m8048l(View view) {
        if (view instanceof BubbleTextView) {
            ((BubbleTextView) view).m7600I();
        } else if (view instanceof LauncherAppWidgetHostView) {
            ((LauncherAppWidgetHostView) view).onTouchComplete();
        }
        HashMap map = this.f16510v;
        if (map.get(view) == null || ((ValueAnimator) map.get(view)).isRunning()) {
            return;
        }
        ((ValueAnimator) map.get(view)).start();
    }

    /* JADX INFO: renamed from: m */
    public final void m8049m(int i6) {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            Objects.toString(childAt);
            if (childAt instanceof BubbleTextView) {
                BubbleTextView bubbleTextView = (BubbleTextView) childAt;
                if (bubbleTextView.getIconView() != null) {
                    bubbleTextView.getIconView().setTint(i6);
                }
            } else if (childAt instanceof FolderIcon) {
                FolderIcon folderIcon = (FolderIcon) childAt;
                Folder folder = folderIcon.getFolder();
                folder.getClass();
                for (int i8 = 0; i8 < folder.mContent.getChildCount(); i8++) {
                    try {
                        ((CellLayout) folder.mContent.getChildAt(i8)).getShortcutsAndWidgets().m8049m(i6);
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                folderIcon.postInvalidateOnAnimation();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        getMeasuredHeight();
        int[] iArr = this.f16498j;
        getLocationOnScreen(iArr);
        int[] iArr2 = this.f16497D;
        if (iArr2[0] != 0 && iArr2[1] != 0) {
            this.f16497D = iArr;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
                int i11 = cellLayoutLayoutParams.f15695k;
                int i12 = cellLayoutLayoutParams.f15696l;
                childAt.layout(i11, i12, ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).width + i11, ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).height + i12);
                if (cellLayoutLayoutParams.f15697m) {
                    cellLayoutLayoutParams.f15697m = false;
                    this.f16499k.sendWallpaperCommand(getWindowToken(), "android.home.drop", (((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).width / 2) + iArr[0] + i11, (((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).height / 2) + iArr[1] + i12, 0, null);
                }
            }
        }
        int measuredWidth = getMeasuredWidth();
        DeviceProfile deviceProfile = this.grid;
        this.f16503o = measuredWidth / deviceProfile.inv.f16712d;
        int measuredHeight = getMeasuredHeight() / deviceProfile.inv.f16711c;
        this.f16504p = measuredHeight;
        if (this.f16503o == 0 && measuredHeight == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ClingGlobalLayoutListener(1, this));
        } else {
            m8039c();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        try {
            int childCount = getChildCount();
            setMeasuredDimension(View.MeasureSpec.getSize(i6), View.MeasureSpec.getSize(i7));
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        boolean z5 = view instanceof BubbleTextView;
        if (z5 || (view instanceof FolderIcon) || (view instanceof LauncherAppWidgetHostView)) {
            Launcher launcher = this.f16506r;
            if (launcher.isUseLiquidGlass && !launcher.isRuntimeRenderSupport && (view instanceof FolderIcon) && this.mIsHotseatLayout) {
                ((FolderIcon) view).m7721f();
            }
            boolean z6 = view instanceof LauncherAppWidgetHostView;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("pivotX", m8044h(view), m8044h(view)), PropertyValuesHolder.ofFloat("pivotY", m8045i(view), m8045i(view)), PropertyValuesHolder.ofFloat("rotation", ((3.1415927f / (z6 ? 6.0f : 2.0f)) * (-1.0f)) + ((float) (Math.random() * ((double) (z6 ? 0.1f : 0.6f)))), (3.1415927f / (z6 ? 6.0f : 2.0f)) + ((float) (((double) (z6 ? 0.1f : 0.6f)) * Math.random()))));
            objectAnimatorOfPropertyValuesHolder.setDuration((long) ((Math.random() * 36.0d) + 113.0d));
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            objectAnimatorOfPropertyValuesHolder.setRepeatMode(2);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            objectAnimatorOfPropertyValuesHolder.addListener(new ShortcutContainerAnimListener(0, view));
            this.f16510v.put(view, objectAnimatorOfPropertyValuesHolder);
            if (this.f16508t.booleanValue()) {
                objectAnimatorOfPropertyValuesHolder.start();
                if (z5) {
                    ((BubbleTextView) view).m7600I();
                }
                if (z6) {
                    ((LauncherAppWidgetHostView) view).onTouchComplete();
                }
            }
            HashMap map = this.f16511w;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("pivotX", this.f16503o / 2.0f), PropertyValuesHolder.ofFloat("pivotY", this.f16504p / 2.0f), PropertyValuesHolder.ofFloat("rotation", 0.0f));
            objectAnimatorOfPropertyValuesHolder2.setDuration(100L);
            objectAnimatorOfPropertyValuesHolder2.addListener(new ShortcutContainerAnimListener(1, view));
            map.put(view, objectAnimatorOfPropertyValuesHolder2);
            if (this.mIsHotseatLayout || (getChildAt(0) instanceof ViewOnClickListenerC2791d)) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof ItemInfo) {
                ItemInfo itemInfo = (ItemInfo) tag;
                int i6 = itemInfo.cellX;
                int i7 = itemInfo.cellY;
                DeviceProfile deviceProfile = this.grid;
                int i8 = (i7 * deviceProfile.inv.f16712d) + i6;
                if (this.f16503o == 0 && this.f16504p == 0) {
                    int measuredWidth = getMeasuredWidth();
                    InvariantDeviceProfile invariantDeviceProfile = deviceProfile.inv;
                    this.f16503o = measuredWidth / invariantDeviceProfile.f16712d;
                    this.f16504p = getMeasuredHeight() / invariantDeviceProfile.f16711c;
                }
                PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.f16503o * this.f16513y[i8], 0.0f);
                PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.f16504p * this.f16514z[i8], 0.0f);
                float[] fArr = this.f16494A;
                ObjectAnimator objectAnimatorOfPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, fArr[i8], 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, fArr[i8], 1.0f));
                objectAnimatorOfPropertyValuesHolder3.setDuration(866L);
                this.f16495B.put(view, objectAnimatorOfPropertyValuesHolder3);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((view instanceof BubbleTextView) || (view instanceof FolderIcon)) {
            boolean zBooleanValue = this.f16508t.booleanValue();
            HashMap map = this.f16511w;
            HashMap map2 = this.f16510v;
            if (zBooleanValue) {
                ((ValueAnimator) map2.get(view)).end();
                ((ValueAnimator) map.get(view)).start();
            }
            map2.remove(view);
            map.remove(view);
            this.f16495B.remove(view);
        }
        postOnAnimationDelayed(new ShortcutContainerRunnable(this, 0), 168L);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (view != null) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            requestRectangleOnScreen(rect);
        }
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingCacheEnabled(boolean z5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            childAt.setDrawingCacheEnabled(z5);
            if (!childAt.isHardwareAccelerated() && z5) {
                childAt.buildDrawingCache(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawnWithCacheEnabled(boolean z5) {
        super.setChildrenDrawnWithCacheEnabled(z5);
    }

    public void setIconTextColor(int i6) {
        try {
            for (View view : (Iterable<View>) (Iterable) (this.f16510v.keySet())) {
                Objects.toString(view);
                if (view instanceof BubbleTextView) {
                    ((BubbleTextView) view).setTextColor(i6);
                } else if (view instanceof FolderIcon) {
                    FolderIcon folderIcon = (FolderIcon) view;
                    folderIcon.setTextColor(i6);
                    Folder folder = folderIcon.mFolder;
                    if (folder != null && folder.mContent != null) {
                        for (int i7 = 0; i7 < folder.mContent.getChildCount(); i7++) {
                            ((CellLayout) folder.mContent.getChildAt(i7)).getShortcutsAndWidgets().setIconTextColor(i6);
                        }
                    }
                } else if (view instanceof LauncherAppWidgetHostView) {
                    ((LauncherAppWidgetHostView) view).setTextColor(i6);
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void setInvertIfRtl(boolean z5) {
        this.mInvertIfRtl = z5;
    }

    public void setIsHotseat(boolean z5) {
        this.mIsHotseatLayout = z5;
    }

    public void setIsShaking(boolean z5) {
        this.f16508t = Boolean.valueOf(z5);
    }

    public void setupLp(CellLayoutLayoutParams cellLayoutLayoutParams) {
        cellLayoutLayoutParams.m7743a(this.f16501m, this.f16502n, this.f16505q, invertLayoutHorizontally());
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
