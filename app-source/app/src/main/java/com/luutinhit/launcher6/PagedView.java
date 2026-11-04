package com.luutinhit.launcher6;

import A2.C0022a;
import B3.AbstractC0041I;
import F0.InterpolatorC0242b;
import O3.AbstractC0744e;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.W2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PagedView extends ViewGroup implements ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: s0 */
    public static final Matrix sTmpInvMatrix = new Matrix();

    /* JADX INFO: renamed from: t0 */
    public static final float[] f23374t0 = new float[2];

    /* JADX INFO: renamed from: u0 */
    public static final Rect f23375u0 = new Rect();

    /* JADX INFO: renamed from: v0 */
    public static final RectF f23376v0 = new RectF();

    /* JADX INFO: renamed from: A */
    public float f16051A;

    /* JADX INFO: renamed from: B */
    public float f16052B;

    /* JADX INFO: renamed from: C */
    public float f16053C;

    /* JADX INFO: renamed from: D */
    public float f16054D;

    /* JADX INFO: renamed from: E */
    public float f16055E;

    /* JADX INFO: renamed from: F */
    public float f16056F;

    /* JADX INFO: renamed from: G */
    public float f16057G;

    /* JADX INFO: renamed from: H */
    public float f16058H;

    /* JADX INFO: renamed from: I */
    public float f16059I;

    /* JADX INFO: renamed from: J */
    public float f16060J;

    /* JADX INFO: renamed from: K */
    public int f16061K;

    /* JADX INFO: renamed from: L */
    public boolean f16062L;

    /* JADX INFO: renamed from: M */
    public int[] f16063M;

    /* JADX INFO: renamed from: N */
    public int f16064N;

    /* JADX INFO: renamed from: O */
    public boolean f16065O;

    /* JADX INFO: renamed from: P */
    public View.OnLongClickListener f16066P;

    /* JADX INFO: renamed from: Q */
    public int f16067Q;

    /* JADX INFO: renamed from: R */
    public int f16068R;

    /* JADX INFO: renamed from: S */
    public boolean f16069S;

    /* JADX INFO: renamed from: T */
    public boolean mAllowOverScroll;

    /* JADX INFO: renamed from: U */
    public int[] f16071U;

    /* JADX INFO: renamed from: V */
    public int f16072V;

    /* JADX INFO: renamed from: W */
    public PageSwitchListener f16073W;

    /* JADX INFO: renamed from: a0 */
    public boolean f23377a0;

    /* JADX INFO: renamed from: b0 */
    public boolean f23378b0;

    /* JADX INFO: renamed from: c0 */
    public int f23379c0;

    /* JADX INFO: renamed from: d0 */
    public int f23380d0;

    /* JADX INFO: renamed from: e0 */
    public int f23381e0;

    /* JADX INFO: renamed from: f0 */
    public PageIndicator mPageIndicator;

    /* JADX INFO: renamed from: g0 */
    public Rect f23383g0;

    /* JADX INFO: renamed from: h0 */
    public float f23384h0;

    /* JADX INFO: renamed from: i0 */
    public boolean f23385i0;

    /* JADX INFO: renamed from: j */
    public boolean f16074j;

    /* JADX INFO: renamed from: j0 */
    public View f23386j0;

    /* JADX INFO: renamed from: k */
    public int f16075k;

    /* JADX INFO: renamed from: k0 */
    public PageReorderRunnable f23387k0;

    /* JADX INFO: renamed from: l */
    public int f16076l;

    /* JADX INFO: renamed from: l0 */
    public int f23388l0;

    /* JADX INFO: renamed from: m */
    public int f16077m;

    /* JADX INFO: renamed from: m0 */
    public boolean f23389m0;

    /* JADX INFO: renamed from: n */
    public int f16078n;

    /* JADX INFO: renamed from: n0 */
    public boolean f23390n0;

    /* JADX INFO: renamed from: o */
    public int f16079o;

    /* JADX INFO: renamed from: o0 */
    public int f23391o0;

    /* JADX INFO: renamed from: p */
    public boolean f16080p;

    /* JADX INFO: renamed from: p0 */
    public MergedModelRunnable f23392p0;

    /* JADX INFO: renamed from: q */
    public int mNormalChildHeight;

    /* JADX INFO: renamed from: q0 */
    public Rect f23393q0;

    /* JADX INFO: renamed from: r */
    public int mCurrentPage;

    /* JADX INFO: renamed from: r0 */
    public boolean f23394r0;

    /* JADX INFO: renamed from: s */
    public int mRestorePage;

    /* JADX INFO: renamed from: t */
    public int f16084t;

    /* JADX INFO: renamed from: u */
    public int f16085u;

    /* JADX INFO: renamed from: v */
    public int f16086v;

    /* JADX INFO: renamed from: w */
    public LauncherScroller f16087w;

    /* JADX INFO: renamed from: x */
    public Interpolator f16088x;

    /* JADX INFO: renamed from: y */
    public VelocityTracker mVelocityTracker;

    /* JADX INFO: renamed from: z */
    public int f16090z;

    public PagedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16074j = false;
        this.f16075k = -1;
        this.f16076l = -1;
        this.f16080p = true;
        this.mRestorePage = -1001;
        this.f16085u = -1;
        this.f16090z = 0;
        this.f16061K = -1;
        this.f16064N = 0;
        this.f16065O = false;
        this.mAllowOverScroll = true;
        this.f16071U = new int[2];
        this.f16072V = -1;
        this.f23377a0 = false;
        this.f23378b0 = false;
        this.f23383g0 = new Rect();
        this.f23384h0 = 1.0f;
        this.f23385i0 = false;
        this.f23388l0 = -1;
        this.f23389m0 = false;
        this.f23393q0 = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2252p, 0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f23381e0 = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        setHapticFeedbackEnabled(false);
        this.f23394r0 = Utilities.isRtl(getResources());
        this.f16087w = new LauncherScroller(getContext());
        setDefaultInterpolator(new InterpolatorC0242b(4));
        this.mCurrentPage = 0;
        this.f16069S = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f16067Q = viewConfiguration.getScaledPagingTouchSlop();
        this.f16068R = viewConfiguration.getScaledMaximumFlingVelocity();
        float f6 = getResources().getDisplayMetrics().density;
        this.f16077m = (int) (500.0f * f6);
        this.f16078n = (int) (250.0f * f6);
        this.f16079o = (int) (f6 * 1500.0f);
        setOnHierarchyChangeListener(this);
        setWillNotDraw(false);
    }

    /* JADX INFO: renamed from: T */
    public static float[] mapPointFromParentToView(PagedView pagedView, float f6, float f7) {
        float left = f6 - pagedView.getLeft();
        float[] fArr = f23374t0;
        fArr[0] = left;
        fArr[1] = f7 - pagedView.getTop();
        Matrix matrix = pagedView.getMatrix();
        Matrix matrix2 = sTmpInvMatrix;
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        return fArr;
    }

    /* JADX INFO: renamed from: U */
    public static float[] mapPointFromViewToParent(PagedView pagedView, float f6, float f7) {
        float[] fArr = f23374t0;
        fArr[0] = f6;
        fArr[1] = f7;
        pagedView.getMatrix().mapPoints(fArr);
        fArr[0] = fArr[0] + pagedView.getLeft();
        fArr[1] = fArr[1] + pagedView.getTop();
        return fArr;
    }

    public int getNearestHoverOverPageIndex() {
        View view = this.f23386j0;
        if (view == null) {
            return -1;
        }
        int translationX = (int) (this.f23386j0.getTranslationX() + (this.f23386j0.getMeasuredWidth() / 2.0f) + view.getLeft());
        int[] iArr = this.f16071U;
        mo7855K(iArr);
        int iIndexOfChild = indexOfChild(this.f23386j0);
        int i6 = Integer.MAX_VALUE;
        for (int i7 = iArr[0]; i7 <= iArr[1]; i7++) {
            View viewMo7726M = mo7726M(i7);
            int iAbs = Math.abs(translationX - ((viewMo7726M.getMeasuredWidth() / 2) + viewMo7726M.getLeft()));
            if (iAbs < i6) {
                iIndexOfChild = i7;
                i6 = iAbs;
            }
        }
        return iIndexOfChild;
    }

    public void setEnableFreeScroll(boolean z5) {
        this.f16074j = z5;
        if (z5) {
            s0();
            int[] iArr = this.f16071U;
            mo7855K(iArr);
            int currentPage = getCurrentPage();
            int i6 = iArr[0];
            if (currentPage < i6) {
                setCurrentPage(i6);
            } else {
                int currentPage2 = getCurrentPage();
                int i7 = iArr[1];
                if (currentPage2 > i7) {
                    setCurrentPage(i7);
                }
            }
        }
        setEnableOverscroll(!z5);
    }

    /* JADX INFO: renamed from: A */
    public void mo7850A(MotionEvent motionEvent) {
        mo7851G(motionEvent, 1.0f);
    }

    /* JADX INFO: renamed from: G */
    public void mo7851G(MotionEvent motionEvent, float f6) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.f16072V);
        if (iFindPointerIndex == -1) {
            return;
        }
        float x6 = motionEvent.getX(iFindPointerIndex);
        if (isTouchPointInViewportWithBuffer((int) x6, (int) motionEvent.getY(iFindPointerIndex)) && ((int) Math.abs(x6 - this.f16057G)) > Math.round(f6 * this.f16067Q)) {
            this.f16064N = 1;
            this.f16060J = Math.abs(this.f16057G - x6) + this.f16060J;
            this.f16057G = x6;
            this.f16058H = 0.0f;
            getViewportOffsetX();
            getScrollX();
            System.nanoTime();
            mo7863Z();
            if (this.f23377a0) {
                return;
            }
            this.f23377a0 = true;
            mo7729X();
        }
    }

    /* JADX INFO: renamed from: H */
    public final void disableFreeScroll() {
        setEnableFreeScroll(false);
    }

    /* JADX INFO: renamed from: I */
    public final void enableFreeScroll() {
        setEnableFreeScroll(true);
    }

    /* JADX INFO: renamed from: J */
    public final int getChildOffset(int i6) {
        if (i6 < 0 || i6 > getChildCount() - 1) {
            return 0;
        }
        return mo7726M(i6).getLeft() - getViewportOffsetX();
    }

    /* JADX INFO: renamed from: K */
    public void mo7855K(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = Math.max(0, getChildCount() - 1);
    }

    /* JADX INFO: renamed from: L */
    public final int getLayoutTransitionOffsetForPage(int i6) {
        int[] iArr = this.f16063M;
        int paddingRight = 0;
        if (iArr == null || i6 >= iArr.length || i6 < 0) {
            return 0;
        }
        View childAt = getChildAt(i6);
        if (!((PagedViewLayoutParams) childAt.getLayoutParams()).f15973a) {
            paddingRight = this.f23394r0 ? getPaddingRight() : getPaddingLeft();
        }
        return (int) (childAt.getX() - (getViewportOffsetX() + (this.f16063M[i6] + paddingRight)));
    }

    /* JADX INFO: renamed from: M */
    public View mo7726M(int i6) {
        return getChildAt(i6);
    }

    /* JADX INFO: renamed from: N */
    public abstract PageIndicatorState mo7727N(int i6);

    /* JADX INFO: renamed from: O */
    public final int getScrollForPage(int i6) {
        int[] iArr = this.f16063M;
        if (iArr == null || i6 >= iArr.length || i6 < 0) {
            return 0;
        }
        return iArr[i6];
    }

    /* JADX INFO: renamed from: P */
    public final void getVisiblePages(int[] iArr) {
        int childCount = getChildCount();
        iArr[0] = -1;
        iArr[1] = -1;
        if (childCount <= 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i6 = -getLeft();
        int viewportWidth = getViewportWidth() + i6;
        Matrix pageShiftMatrix = getPageShiftMatrix();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View viewMo7726M = mo7726M(i8);
            RectF rectF = f23376v0;
            rectF.left = 0.0f;
            rectF.right = viewMo7726M.getMeasuredWidth();
            viewMo7726M.getMatrix().mapRect(rectF);
            rectF.offset(viewMo7726M.getLeft() - getScrollX(), 0.0f);
            pageShiftMatrix.mapRect(rectF);
            if (rectF.left > viewportWidth || rectF.right < i6) {
                if (iArr[0] != -1) {
                    break;
                }
            } else {
                if (iArr[0] < 0) {
                    iArr[0] = i8;
                }
                i7 = i8;
            }
        }
        iArr[1] = i7;
    }

    /* JADX INFO: renamed from: Q */
    public final boolean isPageMoving() {
        return this.f23390n0 & (this.f16064N == 4);
    }

    /* JADX INFO: renamed from: S */
    public final boolean isTouchPointInViewportWithBuffer(int i6, int i7) {
        Rect rect = this.f23383g0;
        int iWidth = rect.left - (rect.width() / 2);
        int i8 = rect.top;
        int iWidth2 = (rect.width() / 2) + rect.right;
        int i9 = rect.bottom;
        Rect rect2 = f23375u0;
        rect2.set(iWidth, i8, iWidth2, i9);
        return rect2.contains(i6, i7);
    }

    /* JADX INFO: renamed from: V */
    public abstract void mo7728V();

    /* JADX INFO: renamed from: W */
    public void mo7861W() {
        this.f23390n0 = false;
    }

    /* JADX INFO: renamed from: X */
    public abstract void mo7729X();

    /* JADX INFO: renamed from: Y */
    public void mo7862Y() {
        this.f23378b0 = false;
    }

    /* JADX INFO: renamed from: Z */
    public void mo7863Z() {
    }

    public void a0() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i6, int i7) {
        int i8 = this.mCurrentPage;
        if (i8 >= 0 && i8 < getPageCount()) {
            mo7726M(this.mCurrentPage).addFocusables(arrayList, i6, i7);
        }
        if (i6 == 17) {
            int i9 = this.mCurrentPage;
            if (i9 > 0) {
                mo7726M(i9 - 1).addFocusables(arrayList, i6, i7);
                return;
            }
            return;
        }
        if (i6 != 66 || this.mCurrentPage >= getPageCount() - 1) {
            return;
        }
        mo7726M(this.mCurrentPage + 1).addFocusables(arrayList, i6, i7);
    }

    public final void b0(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.f16072V) {
            int i6 = action == 0 ? 1 : 0;
            float x6 = motionEvent.getX(i6);
            this.f16053C = x6;
            this.f16057G = x6;
            this.f16059I = motionEvent.getY(i6);
            this.f16058H = 0.0f;
            this.f16072V = motionEvent.getPointerId(i6);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof PagedViewLayoutParams;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x016d  */
    /* JADX WARN: Code duplicated, block: B:57:0x0171  */
    /* JADX WARN: Code duplicated, block: B:58:0x0176  */
    @Override // android.view.View
    public void computeScroll() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        float scaleX;
        float f6;
        float fM7906e;
        LauncherScroller launcherScroller = this.f16087w;
        if (launcherScroller.f15546o) {
            if (this.f16085u != -1) {
                AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
                if (accessibilityManager != null && accessibilityManager.isEnabled() && this.mCurrentPage != getNextPage()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(4096);
                    accessibilityEventObtain.setScrollable(true);
                    accessibilityEventObtain.setScrollX(getScrollX());
                    accessibilityEventObtain.setScrollY(getScrollY());
                    accessibilityEventObtain.setMaxScrollX(this.f16086v);
                    accessibilityEventObtain.setMaxScrollY(0);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                this.mCurrentPage = t0(this.f16085u);
                this.f16085u = -1;
                mo7728V();
                if (this.f16064N == 0 && this.f23377a0) {
                    this.f23377a0 = false;
                    mo7862Y();
                }
                int i6 = this.f23391o0 - 1;
                this.f23391o0 = i6;
                MergedModelRunnable mergedModelRunnable = this.f23392p0;
                if (mergedModelRunnable != null && i6 == 0) {
                    mergedModelRunnable.run();
                    this.f23392p0 = null;
                }
                AccessibilityManager accessibilityManager2 = (AccessibilityManager) getContext().getSystemService("accessibility");
                if (accessibilityManager2 == null || !accessibilityManager2.isEnabled()) {
                    return;
                }
                announceForAccessibility(getCurrentPageDescription());
                return;
            }
            return;
        }
        int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - launcherScroller.f15541j);
        int i7 = launcherScroller.f15542k;
        if (iCurrentAnimationTimeMillis < i7) {
            int i8 = launcherScroller.f15532a;
            if (i8 == 0) {
                float f7 = iCurrentAnimationTimeMillis * launcherScroller.f15543l;
                TimeInterpolator timeInterpolator = launcherScroller.f15547p;
                float fViscousFluid = timeInterpolator == null ? LauncherScroller.viscousFluid(f7) : timeInterpolator.getInterpolation(f7);
                launcherScroller.f15539h = Math.round(launcherScroller.f15544m * fViscousFluid) + launcherScroller.f15533b;
                launcherScroller.f15540i = Math.round(fViscousFluid * launcherScroller.f15545n) + launcherScroller.f15534c;
            } else if (i8 == 1) {
                float f8 = i7;
                float f9 = iCurrentAnimationTimeMillis / f8;
                int i9 = (int) (f9 * 100.0f);
                if (i9 < 100) {
                    float f10 = i9 / 100.0f;
                    int i10 = i9 + 1;
                    float[] fArr = LauncherScroller.f15530y;
                    float f11 = fArr[i9];
                    f6 = (fArr[i10] - f11) / ((i10 / 100.0f) - f10);
                    fM7906e = SyntheticHelpers.m7906e(f9, f10, f6, f11);
                } else {
                    f6 = 0.0f;
                    fM7906e = 1.0f;
                }
                launcherScroller.f15550s = ((f6 * launcherScroller.f15551t) / f8) * 1000.0f;
                int i11 = launcherScroller.f15533b;
                int iRound = Math.round((launcherScroller.f15535d - i11) * fM7906e) + i11;
                launcherScroller.f15539h = iRound;
                int iMin = Math.min(iRound, launcherScroller.f15538g);
                launcherScroller.f15539h = iMin;
                launcherScroller.f15539h = Math.max(iMin, launcherScroller.f15537f);
                int i12 = launcherScroller.f15534c;
                int iRound2 = Math.round(fM7906e * (launcherScroller.f15536e - i12)) + i12;
                launcherScroller.f15540i = iRound2;
                int iMin2 = Math.min(iRound2, 0);
                launcherScroller.f15540i = iMin2;
                int iMax = Math.max(iMin2, 0);
                launcherScroller.f15540i = iMax;
                if (launcherScroller.f15539h == launcherScroller.f15535d && iMax == launcherScroller.f15536e) {
                    launcherScroller.f15546o = true;
                }
            }
        } else {
            launcherScroller.f15539h = launcherScroller.f15535d;
            launcherScroller.f15540i = launcherScroller.f15536e;
            launcherScroller.f15546o = true;
        }
        if (getUnboundedScrollX() == this.f16087w.f15539h) {
            int scrollY = getScrollY();
            LauncherScroller launcherScroller2 = this.f16087w;
            if (scrollY != launcherScroller2.f15540i || this.f23379c0 != launcherScroller2.f15539h) {
                if (this.f16074j) {
                    scaleX = getScaleX();
                } else {
                    scaleX = 1.0f;
                }
                LauncherScroller launcherScroller3 = this.f16087w;
                scrollTo((int) ((1.0f / scaleX) * launcherScroller3.f15539h), launcherScroller3.f15540i);
            }
        } else {
            if (this.f16074j) {
                scaleX = getScaleX();
            } else {
                scaleX = 1.0f;
            }
            LauncherScroller launcherScroller4 = this.f16087w;
            scrollTo((int) ((1.0f / scaleX) * launcherScroller4.f15539h), launcherScroller4.f15540i);
        }
        invalidate();
    }

    public void d0() {
        this.f16064N = 4;
        this.f23390n0 = true;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int childCount = getChildCount();
        if (childCount > 0) {
            int scrollX = getScrollX() + (getViewportWidth() / 2);
            if (scrollX != this.f16061K || this.f16065O) {
                this.f16065O = false;
                g0(scrollX);
                this.f16061K = scrollX;
            }
            getVisiblePages(this.f16071U);
            int[] iArr = this.f16071U;
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (i6 == -1 || i7 == -1) {
                return;
            }
            synchronized (canvas) {
                try {
                    long drawingTime = getDrawingTime();
                    canvas.save();
                    canvas.clipRect(getScrollX(), getScrollY(), (getScrollX() + getRight()) - getLeft(), (getScrollY() + getBottom()) - getTop());
                    int i8 = childCount - 1;
                    while (i8 >= 0) {
                        View viewMo7726M = mo7726M(i8);
                        if (viewMo7726M != this.f23386j0) {
                            boolean z5 = i6 <= i8 && i8 <= i7;
                            boolean z6 = z5 && j0(viewMo7726M);
                            if (viewMo7726M instanceof PagedViewMarker) {
                                ((CellLayout) ((PagedViewMarker) viewMo7726M)).m7657z(z5);
                            }
                            if (z6) {
                                drawChild(canvas, viewMo7726M, drawingTime);
                            }
                        }
                        i8--;
                    }
                    View view = this.f23386j0;
                    if (view != null) {
                        drawChild(canvas, view, drawingTime);
                    }
                    canvas.restore();
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i6) {
        if (super.dispatchUnhandledMove(view, i6)) {
            return true;
        }
        if (this.f23394r0) {
            if (i6 == 17) {
                i6 = 66;
            } else if (i6 == 66) {
                i6 = 17;
            }
        }
        if (i6 == 17) {
            if (getCurrentPage() <= 0) {
                return false;
            }
            l0(getCurrentPage() - 1);
            return true;
        }
        if (i6 != 66 || getCurrentPage() >= getPageCount() - 1) {
            return false;
        }
        l0(getCurrentPage() + 1);
        return true;
    }

    public void e0(float f6) {
        dampedOverScroll(f6);
    }

    public final void f0() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.f23389m0) {
            this.f23389m0 = false;
            this.f23392p0 = new MergedModelRunnable(17, this, new MergedUiRunnable(12, this));
            this.f23391o0 = 2;
            m0(indexOfChild(this.f23386j0), 0);
            if (this.f23386j0 != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.f23386j0, "translationX", 0.0f), ObjectAnimator.ofFloat(this.f23386j0, "translationY", 0.0f), ObjectAnimator.ofFloat(this.f23386j0, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.f23386j0, "scaleY", 1.0f));
                animatorSet.addListener(new C0022a(15, this));
                animatorSet.start();
            }
        }
        this.f16062L = false;
        this.f16064N = 0;
        this.f16072V = -1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void focusableViewAvailable(View view) {
        View viewMo7726M = mo7726M(this.mCurrentPage);
        for (View view2 = view; view2 != viewMo7726M; view2 = (View) view2.getParent()) {
            if (view2 == this || !(view2.getParent() instanceof View)) {
                return;
            }
        }
        super.focusableViewAvailable(view);
    }

    public void g0(int i6) {
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        PagedViewLayoutParams pagedViewLayoutParams = new PagedViewLayoutParams(-2, -2);
        pagedViewLayoutParams.f15973a = false;
        return pagedViewLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        PagedViewLayoutParams pagedViewLayoutParams = new PagedViewLayoutParams(getContext(), attributeSet);
        pagedViewLayoutParams.f15973a = false;
        return pagedViewLayoutParams;
    }

    public int getChildGap() {
        return 0;
    }

    public int getCurrentPage() {
        return this.mCurrentPage;
    }

    public String getCurrentPageDescription() {
        return String.format(getContext().getString(R.string.default_scroll_format), Integer.valueOf(getNextPage() + 1), Integer.valueOf(getChildCount()));
    }

    public int getNextPage() {
        int i6 = this.f16085u;
        return i6 != -1 ? i6 : this.mCurrentPage;
    }

    public int getNormalChildHeight() {
        return this.mNormalChildHeight;
    }

    public int getPageCount() {
        return getChildCount();
    }

    public PageIndicator getPageIndicator() {
        return this.mPageIndicator;
    }

    public View.OnClickListener getPageIndicatorClickListener() {
        return null;
    }

    public String getPageIndicatorDescription() {
        return getCurrentPageDescription();
    }

    public int getPageNearestToCenterOfScreen() {
        int viewportWidth = (getViewportWidth() / 2) + getScrollX() + getViewportOffsetX();
        int childCount = getChildCount();
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        for (int i8 = 0; i8 < childCount; i8++) {
            int iAbs = Math.abs(((getChildOffset(i8) + getViewportOffsetX()) + (mo7726M(i8).getMeasuredWidth() / 2)) - viewportWidth);
            if (iAbs < i6) {
                i7 = i8;
                i6 = iAbs;
            }
        }
        return i7;
    }

    public Matrix getPageShiftMatrix() {
        return getMatrix();
    }

    public int getPageSnapDuration() {
        int i6 = this.f23379c0;
        return (i6 > this.f16086v || i6 < 0) ? 500 : 750;
    }

    public int getRestorePage() {
        return this.mRestorePage;
    }

    public int getUnboundedScrollX() {
        return this.f23380d0;
    }

    public int getViewportHeight() {
        return this.f23383g0.height();
    }

    public int getViewportOffsetX() {
        return (getMeasuredWidth() - getViewportWidth()) / 2;
    }

    public int getViewportOffsetY() {
        return (getMeasuredHeight() - getViewportHeight()) / 2;
    }

    public int getViewportWidth() {
        return this.f23383g0.width();
    }

    /* JADX INFO: renamed from: h */
    public final void abortScrollerAnimation(boolean z5) {
        LauncherScroller launcherScroller = this.f16087w;
        launcherScroller.f15539h = launcherScroller.f15535d;
        launcherScroller.f15540i = launcherScroller.f15536e;
        launcherScroller.f15546o = true;
        if (z5) {
            this.f16085u = -1;
        }
    }

    public void h0() {
        if (getNextPage() > 0) {
            l0(getNextPage() - 1);
        }
    }

    public void i0() {
        if (getNextPage() < getChildCount() - 1) {
            l0(getNextPage() + 1);
        }
    }

    public boolean j0(View view) {
        return view.getVisibility() == 0;
    }

    public void k0() {
        m0(getPageNearestToCenterOfScreen(), getPageSnapDuration());
    }

    public final void l0(int i6) {
        m0(i6, 750);
    }

    public final void m0(int i6, int i7) {
        int iT0 = t0(i6);
        n0(iT0, getScrollForPage(iT0) - getUnboundedScrollX(), i7, false, null);
    }

    public final void n0(int i6, int i7, int i8, boolean z5, TimeInterpolator timeInterpolator) {
        this.f16085u = t0(i6);
        if (this.f23377a0) {
            this.f23377a0 = false;
            mo7862Y();
        }
        awakenScrollBars(i8);
        if (z5) {
            i8 = 0;
        } else if (i8 == 0) {
            i8 = Math.abs(i7);
        }
        if (!this.f16087w.f15546o) {
            abortScrollerAnimation(false);
        }
        if (timeInterpolator != null) {
            this.f16087w.f15547p = timeInterpolator;
        } else {
            this.f16087w.f15547p = this.f16088x;
        }
        this.f16087w.startScroll(getUnboundedScrollX(), i7, i8);
        PageIndicator pageIndicator = this.mPageIndicator;
        if (pageIndicator != null) {
            pageIndicator.setContentDescription(getPageIndicatorDescription());
            if (!this.f23390n0) {
                this.mPageIndicator.setActiveMarker(getNextPage());
            }
        }
        if (z5) {
            computeScroll();
        }
        this.f16065O = true;
        invalidate();
    }

    public final void o0(int i6, int i7) {
        int iT0 = t0(i6);
        int viewportWidth = getViewportWidth() / 2;
        int scrollForPage = getScrollForPage(iT0) - getUnboundedScrollX();
        if (Math.abs(i7) < this.f16078n) {
            m0(iT0, 750);
            return;
        }
        float fMin = Math.min(1.0f, (Math.abs(scrollForPage) * 1.0f) / (viewportWidth * 2));
        float f6 = viewportWidth;
        n0(iT0, scrollForPage, Math.round(Math.abs(((((float) Math.sin((float) (((double) (fMin - 0.5f)) * 0.4712389167638204d))) * f6) + f6) / Math.max(this.f16079o, Math.abs(i7))) * 1000.0f) * 4, false, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i6;
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getParent()).getParent();
        if (this.mPageIndicator != null || (i6 = this.f23381e0) <= -1) {
            return;
        }
        PageIndicator pageIndicator = (PageIndicator) viewGroup.findViewById(i6);
        this.mPageIndicator = pageIndicator;
        pageIndicator.mo7787f();
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            arrayList.add(mo7727N(i7));
        }
        this.mPageIndicator.mo7784c(arrayList);
        View.OnClickListener pageIndicatorClickListener = getPageIndicatorClickListener();
        if (pageIndicatorClickListener != null) {
            this.mPageIndicator.setOnClickListener(pageIndicatorClickListener);
        }
        this.mPageIndicator.setContentDescription(getPageIndicatorDescription());
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if (this.mPageIndicator != null && !this.f23390n0) {
            int iIndexOfChild = indexOfChild(view2);
            this.mPageIndicator.mo7783b(iIndexOfChild, mo7727N(iIndexOfChild));
        }
        this.f16065O = true;
        s0();
        invalidate();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        this.f16065O = true;
        s0();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mPageIndicator = null;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f6;
        float axisValue;
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            if ((motionEvent.getMetaState() & 1) != 0) {
                axisValue = motionEvent.getAxisValue(9);
                f6 = 0.0f;
            } else {
                f6 = -motionEvent.getAxisValue(9);
                axisValue = motionEvent.getAxisValue(10);
            }
            if (axisValue != 0.0f || f6 != 0.0f) {
                if (!this.f23394r0 ? !(axisValue > 0.0f || f6 > 0.0f) : !(axisValue < 0.0f || f6 < 0.0f)) {
                    i0();
                } else {
                    h0();
                }
                return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(getPageCount() > 1);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setScrollable(getPageCount() > 1);
        if (getCurrentPage() < getPageCount() - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        if (getCurrentPage() > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        accessibilityNodeInfo.setClassName(getClass().getName());
        accessibilityNodeInfo.setLongClickable(false);
        if (Utilities.f16752m) {
            accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_LONG_CLICK);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (getChildCount() <= 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 2 || this.f16064N != 1) {
            int i6 = action & 255;
            if (i6 == 0) {
                float x6 = motionEvent.getX();
                float y4 = motionEvent.getY();
                this.f16053C = x6;
                this.f16054D = y4;
                this.f16055E = getScrollX();
                this.f16057G = x6;
                this.f16059I = y4;
                float[] fArrMapPointFromViewToParent = mapPointFromViewToParent(this, x6, y4);
                this.f16051A = fArrMapPointFromViewToParent[0];
                this.f16052B = fArrMapPointFromViewToParent[1];
                this.f16058H = 0.0f;
                this.f16060J = 0.0f;
                this.f16072V = motionEvent.getPointerId(0);
                LauncherScroller launcherScroller = this.f16087w;
                int iAbs = Math.abs(launcherScroller.f15535d - launcherScroller.f15539h);
                boolean z5 = this.f16087w.f15546o;
                if (z5 || iAbs < this.f16067Q / 3) {
                    this.f16064N = 0;
                    if (!z5 && !this.f16074j) {
                        setCurrentPage(getNextPage());
                        if (this.f23377a0) {
                            this.f23377a0 = false;
                            mo7862Y();
                        }
                    }
                } else if (isTouchPointInViewportWithBuffer((int) this.f16053C, (int) this.f16054D)) {
                    this.f16064N = 1;
                } else {
                    this.f16064N = 0;
                }
            } else if (i6 == 1) {
                f0();
            } else if (i6 != 2) {
                if (i6 == 3) {
                    f0();
                } else if (i6 == 6) {
                    b0(motionEvent);
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.clear();
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                }
            } else if (this.f16072V != -1) {
                mo7850A(motionEvent);
            }
            if (this.f16064N == 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0138  */
    /* JADX WARN: Code duplicated, block: B:78:0x013e  */
    /* JADX WARN: Code duplicated, block: B:81:0x014d  */
    /* JADX WARN: Code duplicated, block: B:87:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z6 = false;
        int i10;
        int i11;
        int viewportHeight;
        if (getChildCount() == 0) {
            return;
        }
        int childCount = getChildCount();
        int viewportOffsetX = getViewportOffsetX();
        int viewportOffsetY = getViewportOffsetY();
        this.f23383g0.offset(viewportOffsetX, viewportOffsetY);
        boolean z7 = this.f23394r0;
        int i12 = z7 ? childCount - 1 : 0;
        int i13 = z7 ? -1 : childCount;
        int i14 = z7 ? -1 : 1;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (((PagedViewLayoutParams) getChildAt(i12).getLayoutParams()).f15973a ? 0 : getPaddingLeft()) + viewportOffsetX;
        if (this.f16063M == null || childCount != this.f16084t) {
            this.f16063M = new int[childCount];
        }
        while (i12 != i13) {
            View viewMo7726M = mo7726M(i12);
            if (viewMo7726M.getVisibility() != 8) {
                PagedViewLayoutParams pagedViewLayoutParams = (PagedViewLayoutParams) viewMo7726M.getLayoutParams();
                if (pagedViewLayoutParams.f15973a) {
                    viewportHeight = viewportOffsetY;
                } else {
                    int paddingTop = getPaddingTop() + viewportOffsetY;
                    Rect rect = this.f23393q0;
                    viewportHeight = paddingTop + rect.top;
                    if (this.f16069S) {
                        viewportHeight += ((((getViewportHeight() - rect.top) - rect.bottom) - paddingBottom) - viewMo7726M.getMeasuredHeight()) / 2;
                    }
                }
                int measuredWidth = viewMo7726M.getMeasuredWidth();
                viewMo7726M.layout(paddingLeft, viewportHeight, viewMo7726M.getMeasuredWidth() + paddingLeft, viewMo7726M.getMeasuredHeight() + viewportHeight);
                this.f16063M[i12] = (paddingLeft - (pagedViewLayoutParams.f15973a ? 0 : getPaddingLeft())) - viewportOffsetX;
                int paddingRight = this.f16090z;
                int i15 = i12 + i14;
                PagedViewLayoutParams pagedViewLayoutParams2 = i15 != i13 ? (PagedViewLayoutParams) mo7726M(i15).getLayoutParams() : null;
                if (pagedViewLayoutParams.f15973a) {
                    paddingRight = getPaddingLeft();
                } else if (pagedViewLayoutParams2 != null && pagedViewLayoutParams2.f15973a) {
                    paddingRight = getPaddingRight();
                }
                paddingLeft = getChildGap() + measuredWidth + paddingRight + paddingLeft;
            }
            i12 += i14;
        }
        LayoutTransition layoutTransition = getLayoutTransition();
        if (layoutTransition == null || !layoutTransition.isRunning()) {
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                this.f16086v = getScrollForPage(z7 ? 0 : childCount2 - 1);
            } else {
                z6 = false;
                this.f16086v = 0;
            }
            if (this.f16080p && (i11 = this.mCurrentPage) >= 0 && i11 < childCount) {
                q0();
                this.f16080p = z6;
            }
            if (this.f16087w.f15546o && this.f16084t != childCount) {
                i10 = this.mRestorePage;
                if (i10 != -1001) {
                    setCurrentPage(i10);
                    this.mRestorePage = -1001;
                } else {
                    setCurrentPage(getNextPage());
                }
            }
            this.f16084t = childCount;
            if (isPageMoving()) {
                r0();
            }
        }
        layoutTransition.addTransitionListener(new PagedViewLayoutTransitionListener(this));
        z6 = false;
        if (this.f16080p) {
            q0();
            this.f16080p = z6;
        }
        if (this.f16087w.f15546o) {
            i10 = this.mRestorePage;
            if (i10 != -1001) {
                setCurrentPage(i10);
                this.mRestorePage = -1001;
            } else {
                setCurrentPage(getNextPage());
            }
        }
        this.f16084t = childCount;
        if (isPageMoving()) {
            r0();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        int i8;
        int i9;
        int viewportWidth;
        int viewportHeight;
        int i10;
        Rect rect = this.f23393q0;
        try {
            if (getChildCount() == 0) {
                super.onMeasure(i6, i7);
                return;
            }
            int mode = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            int mode2 = View.MeasureSpec.getMode(i7);
            int size2 = View.MeasureSpec.getSize(i7);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int iMax = (int) (Math.max(displayMetrics.widthPixels + rect.left + rect.right, displayMetrics.heightPixels + rect.top + rect.bottom) * 2.0f);
            if (this.f23385i0) {
                i8 = (int) (iMax / this.f23384h0);
                i9 = i8;
            } else {
                i8 = size;
                i9 = size2;
            }
            this.f23383g0.set(0, 0, size, size2);
            if (mode != 0 && mode2 != 0) {
                if (size > 0 && size2 > 0) {
                    int paddingTop = getPaddingTop() + getPaddingBottom();
                    int paddingLeft = getPaddingLeft() + getPaddingRight();
                    getPaddingLeft();
                    getPaddingRight();
                    int childCount = getChildCount();
                    int i11 = 0;
                    for (int i12 = 0; i12 < childCount; i12++) {
                        View viewMo7726M = mo7726M(i12);
                        if (viewMo7726M.getVisibility() != 8) {
                            PagedViewLayoutParams pagedViewLayoutParams = (PagedViewLayoutParams) viewMo7726M.getLayoutParams();
                            int i13 = 1073741824;
                            if (pagedViewLayoutParams.f15973a) {
                                viewportWidth = getViewportWidth();
                                viewportHeight = getViewportHeight();
                                i10 = 1073741824;
                            } else {
                                int i14 = ((ViewGroup.LayoutParams) pagedViewLayoutParams).width == -2 ? Integer.MIN_VALUE : 1073741824;
                                i13 = ((ViewGroup.LayoutParams) pagedViewLayoutParams).height == -2 ? Integer.MIN_VALUE : 1073741824;
                                getViewportWidth();
                                viewportWidth = ((getViewportWidth() - paddingLeft) - rect.left) - rect.right;
                                viewportHeight = ((getViewportHeight() - paddingTop) - rect.top) - rect.bottom;
                                this.mNormalChildHeight = viewportHeight;
                                int i15 = i13;
                                i13 = i14;
                                i10 = i15;
                            }
                            if (i11 == 0) {
                                i11 = viewportWidth;
                            }
                            viewMo7726M.measure(View.MeasureSpec.makeMeasureSpec(viewportWidth, i13), View.MeasureSpec.makeMeasureSpec(viewportHeight, i10));
                        }
                    }
                    setMeasuredDimension(i8, i9);
                    return;
                }
                super.onMeasure(i6, i7);
                return;
            }
            super.onMeasure(i6, i7);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i6, Rect rect) {
        int i7 = this.f16085u;
        if (i7 == -1) {
            i7 = this.mCurrentPage;
        }
        View viewMo7726M = mo7726M(i7);
        return viewMo7726M != null && viewMo7726M.requestFocus(i6, rect);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x0268  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5;
        int i6;
        int i7;
        super.onTouchEvent(motionEvent);
        if (getChildCount() <= 0 || ((Launcher) getContext()).showingFloatingMenu || ((Launcher) getContext()).isOpeningSearchView()) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z6 = false;
        if (action == 0) {
            if (!this.f16087w.f15546o) {
                abortScrollerAnimation(false);
            }
            float x6 = motionEvent.getX();
            this.f16057G = x6;
            this.f16053C = x6;
            float y4 = motionEvent.getY();
            this.f16059I = y4;
            this.f16054D = y4;
            this.f16055E = getScrollX();
            float[] fArrMapPointFromViewToParent = mapPointFromViewToParent(this, this.f16057G, this.f16059I);
            this.f16051A = fArrMapPointFromViewToParent[0];
            this.f16052B = fArrMapPointFromViewToParent[1];
            this.f16058H = 0.0f;
            this.f16060J = 0.0f;
            this.f16072V = motionEvent.getPointerId(0);
            if (this.f16064N != 1) {
                return true;
            }
            mo7863Z();
            if (this.f23377a0) {
                return true;
            }
            this.f23377a0 = true;
            mo7729X();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                int i8 = this.f16064N;
                if (i8 == 1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f16072V);
                    if (iFindPointerIndex != -1) {
                        float x7 = motionEvent.getX(iFindPointerIndex);
                        float f6 = (this.f16057G + this.f16058H) - x7;
                        this.f16060J = Math.abs(f6) + this.f16060J;
                        if (Math.abs(f6) < 1.0f) {
                            awakenScrollBars();
                            return true;
                        }
                        System.nanoTime();
                        int i9 = (int) f6;
                        scrollBy(i9, 0);
                        this.f16057G = x7;
                        this.f16058H = f6 - i9;
                        return true;
                    }
                } else {
                    if (i8 != 4) {
                        mo7850A(motionEvent);
                        return true;
                    }
                    this.f16057G = motionEvent.getX();
                    float y5 = motionEvent.getY();
                    this.f16059I = y5;
                    float[] fArrMapPointFromViewToParent2 = mapPointFromViewToParent(this, this.f16057G, y5);
                    this.f16051A = fArrMapPointFromViewToParent2[0];
                    this.f16052B = fArrMapPointFromViewToParent2[1];
                    r0();
                    int iIndexOfChild = indexOfChild(this.f23386j0);
                    int nearestHoverOverPageIndex = getNearestHoverOverPageIndex();
                    if (nearestHoverOverPageIndex <= -1 || nearestHoverOverPageIndex == indexOfChild(this.f23386j0)) {
                        removeCallbacks(this.f23387k0);
                        this.f23388l0 = -1;
                        return true;
                    }
                    int[] iArr = this.f16071U;
                    iArr[0] = 0;
                    iArr[1] = getPageCount() - 1;
                    mo7855K(iArr);
                    if (iArr[0] <= nearestHoverOverPageIndex && nearestHoverOverPageIndex <= iArr[1] && nearestHoverOverPageIndex != this.f23388l0 && this.f16087w.f15546o) {
                        this.f23388l0 = nearestHoverOverPageIndex;
                        PageReorderRunnable pageReorderRunnable = new PageReorderRunnable(this, nearestHoverOverPageIndex, iIndexOfChild);
                        this.f23387k0 = pageReorderRunnable;
                        postDelayed(pageReorderRunnable, 80L);
                        return true;
                    }
                }
            } else {
                if (action == 3) {
                    if (this.f16064N == 1) {
                        k0();
                    }
                    f0();
                    return true;
                }
                if (action == 6) {
                    b0(motionEvent);
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.clear();
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        return true;
                    }
                }
            }
            return true;
        }
        int i10 = this.f16064N;
        if (i10 == 1) {
            int i11 = this.f16072V;
            float x8 = motionEvent.getX(motionEvent.findPointerIndex(i11));
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            velocityTracker2.computeCurrentVelocity(1000, this.f16068R);
            int xVelocity = (int) velocityTracker2.getXVelocity(i11);
            int i12 = (int) (x8 - this.f16053C);
            float measuredWidth = mo7726M(this.mCurrentPage).getMeasuredWidth();
            boolean z7 = ((float) Math.abs(i12)) > 0.4f * measuredWidth;
            float fAbs = Math.abs((this.f16057G + this.f16058H) - x8) + this.f16060J;
            this.f16060J = fAbs;
            boolean z8 = fAbs > 25.0f && Math.abs(xVelocity) > this.f16077m;
            if (this.f16074j) {
                if (!this.f16087w.f15546o) {
                    abortScrollerAnimation(true);
                }
                float scaleX = getScaleX();
                int i13 = (int) ((-xVelocity) * scaleX);
                int scrollX = (int) (getScrollX() * scaleX);
                LauncherScroller launcherScroller = this.f16087w;
                launcherScroller.f15547p = this.f16088x;
                int scrollY = getScrollY();
                if (!launcherScroller.f15548q || launcherScroller.f15546o) {
                    i6 = 0;
                } else {
                    float fCurrentAnimationTimeMillis = launcherScroller.f15532a == 1 ? launcherScroller.f15550s : launcherScroller.f15549r - ((launcherScroller.f15553v * ((int) (AnimationUtils.currentAnimationTimeMillis() - launcherScroller.f15541j))) / 2000.0f);
                    float f7 = launcherScroller.f15535d - launcherScroller.f15533b;
                    float f8 = launcherScroller.f15536e - launcherScroller.f15534c;
                    float fHypot = (float) Math.hypot(f7, f8);
                    float f9 = (f7 / fHypot) * fCurrentAnimationTimeMillis;
                    float f10 = (f8 / fHypot) * fCurrentAnimationTimeMillis;
                    float f11 = i13;
                    if (Math.signum(f11) == Math.signum(f9)) {
                        float f12 = 0;
                        if (Math.signum(f12) == Math.signum(f10)) {
                            i13 = (int) (f11 + f9);
                            i6 = (int) (f12 + f10);
                        } else {
                            i6 = 0;
                        }
                    } else {
                        i6 = 0;
                    }
                }
                launcherScroller.f15532a = 1;
                launcherScroller.f15546o = false;
                float fHypot2 = (float) Math.hypot(i13, i6);
                launcherScroller.f15549r = fHypot2;
                double dLog = Math.log((Math.abs(fHypot2) * 0.35f) / (launcherScroller.f15552u * launcherScroller.f15554w));
                double d6 = LauncherScroller.f15529x;
                double d7 = d6 - 1.0d;
                launcherScroller.f15542k = (int) (Math.exp(dLog / d7) * 1000.0d);
                launcherScroller.f15541j = AnimationUtils.currentAnimationTimeMillis();
                launcherScroller.f15533b = scrollX;
                launcherScroller.f15534c = scrollY;
                float f13 = fHypot2 == 0.0f ? 1.0f : i13 / fHypot2;
                float f14 = fHypot2 != 0.0f ? i6 / fHypot2 : 1.0f;
                z5 = true;
                double dExp = Math.exp((d6 / d7) * Math.log((Math.abs(fHypot2) * 0.35f) / (launcherScroller.f15552u * launcherScroller.f15554w))) * ((double) (launcherScroller.f15552u * launcherScroller.f15554w));
                launcherScroller.f15551t = (int) (((double) Math.signum(fHypot2)) * dExp);
                launcherScroller.f15537f = Integer.MIN_VALUE;
                launcherScroller.f15538g = Integer.MAX_VALUE;
                int iRound = scrollX + ((int) Math.round(((double) f13) * dExp));
                launcherScroller.f15535d = iRound;
                int iMin = Math.min(iRound, launcherScroller.f15538g);
                launcherScroller.f15535d = iMin;
                launcherScroller.f15535d = Math.max(iMin, launcherScroller.f15537f);
                int iRound2 = scrollY + ((int) Math.round(dExp * ((double) f14)));
                launcherScroller.f15536e = iRound2;
                int iMin2 = Math.min(iRound2, 0);
                launcherScroller.f15536e = iMin2;
                launcherScroller.f15536e = Math.max(iMin2, 0);
                invalidate();
            } else {
                boolean z9 = ((float) Math.abs(i12)) > measuredWidth * 0.33f && Math.signum((float) xVelocity) != Math.signum((float) i12) && z8;
                boolean z10 = this.f23394r0;
                boolean z11 = !z10 ? i12 >= 0 : i12 <= 0;
                if (!z10 ? xVelocity < 0 : xVelocity > 0) {
                    z6 = true;
                }
                if (((z7 && !z11 && !z8) || (z8 && !z6)) && (i7 = this.mCurrentPage) > 0) {
                    if (!z9) {
                        i7--;
                    }
                    o0(i7, xVelocity);
                } else if (!((z7 && z11 && !z8) || (z8 && z6)) || this.mCurrentPage >= getChildCount() - 1) {
                    k0();
                } else {
                    int i14 = this.mCurrentPage;
                    if (!z9) {
                        i14++;
                    }
                    o0(i14, xVelocity);
                }
                z5 = true;
            }
            a0();
        } else {
            z5 = true;
            if (i10 == 2) {
                int iMax = Math.max(0, this.mCurrentPage - 1);
                if (iMax != this.mCurrentPage) {
                    l0(iMax);
                } else {
                    k0();
                }
            } else if (i10 == 3) {
                int iMin3 = Math.min(getChildCount() - 1, this.mCurrentPage + 1);
                if (iMin3 != this.mCurrentPage) {
                    l0(iMin3);
                } else {
                    k0();
                }
            } else if (i10 == 4) {
                this.f16057G = motionEvent.getX();
                float y6 = motionEvent.getY();
                this.f16059I = y6;
                float[] fArrMapPointFromViewToParent3 = mapPointFromViewToParent(this, this.f16057G, y6);
                this.f16051A = fArrMapPointFromViewToParent3[0];
                this.f16052B = fArrMapPointFromViewToParent3[1];
                r0();
            } else if (!this.f16062L) {
                ((Launcher) getContext()).onClick(this);
            }
        }
        removeCallbacks(this.f23387k0);
        f0();
        return z5;
    }

    public final void p0(View view) {
        int iIndexOfChild = indexOfChild(view);
        if (this.f16064N != 0 || iIndexOfChild == -1) {
            return;
        }
        int[] iArr = this.f16071U;
        iArr[0] = 0;
        iArr[1] = getPageCount() - 1;
        mo7855K(iArr);
        this.f23389m0 = true;
        if (iArr[0] > iIndexOfChild || iIndexOfChild > iArr[1]) {
            return;
        }
        View childAt = getChildAt(iIndexOfChild);
        this.f23386j0 = childAt;
        childAt.animate().withLayer().scaleX(1.15f).scaleY(1.15f).setDuration(100L).start();
        this.f16056F = this.f23386j0.getLeft();
        l0(getPageNearestToCenterOfScreen());
        setEnableFreeScroll(false);
        d0();
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i6, Bundle bundle) {
        if (super.performAccessibilityAction(i6, bundle)) {
            return true;
        }
        if (i6 == 4096) {
            if (getCurrentPage() >= getPageCount() - 1) {
                return false;
            }
            i0();
            return true;
        }
        if (i6 != 8192 || getCurrentPage() <= 0) {
            return false;
        }
        h0();
        return true;
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        this.f16062L = true;
        return super.performLongClick();
    }

    public final void q0() {
        int i6 = this.mCurrentPage;
        int scrollForPage = (i6 < 0 || i6 >= getPageCount()) ? 0 : getScrollForPage(this.mCurrentPage);
        scrollTo(scrollForPage, 0);
        LauncherScroller launcherScroller = this.f16087w;
        launcherScroller.f15535d = scrollForPage;
        launcherScroller.f15544m = scrollForPage - launcherScroller.f15533b;
        launcherScroller.f15546o = false;
        launcherScroller.f15546o = true;
        this.f16085u = -1;
    }

    public final void r0() {
        if (this.f23386j0 != null) {
            float left = (this.f16056F - this.f23386j0.getLeft()) + (getScrollX() - this.f16055E) + (this.f16057G - this.f16053C);
            float f6 = this.f16059I - this.f16054D;
            this.f23386j0.setTranslationX(left);
            this.f23386j0.setTranslationY(f6);
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        PageIndicator pageIndicator = this.mPageIndicator;
        if (pageIndicator != null) {
            pageIndicator.mo7787f();
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        int iIndexOfChild = indexOfChild(view);
        PageIndicator pageIndicator = this.mPageIndicator;
        if (pageIndicator != null && !this.f23390n0) {
            pageIndicator.mo7788g(iIndexOfChild);
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i6) {
        PageIndicator pageIndicator = this.mPageIndicator;
        if (pageIndicator != null && !this.f23390n0) {
            pageIndicator.mo7788g(i6);
        }
        super.removeViewAt(i6);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        int iIndexOfChild = indexOfChild(view);
        PageIndicator pageIndicator = this.mPageIndicator;
        if (pageIndicator != null && !this.f23390n0) {
            pageIndicator.mo7788g(iIndexOfChild);
        }
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild < 0 || iIndexOfChild == getCurrentPage() || isInTouchMode()) {
            return;
        }
        l0(iIndexOfChild);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        int iIndexOfChild = indexOfChild(view);
        int i6 = this.mCurrentPage;
        boolean z6 = this.f16087w.f15546o;
        if (iIndexOfChild == i6 && z6) {
            return false;
        }
        l0(iIndexOfChild);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z5) {
        if (z5) {
            mo7726M(this.mCurrentPage).cancelLongPress();
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    public final void s0() {
        int[] iArr = this.f16071U;
        mo7855K(iArr);
        if (this.f23394r0) {
            this.f16075k = getScrollForPage(iArr[1]);
            this.f16076l = getScrollForPage(iArr[0]);
        } else {
            this.f16075k = getScrollForPage(iArr[0]);
            this.f16076l = getScrollForPage(iArr[1]);
        }
    }

    @Override // android.view.View
    public final void scrollBy(int i6, int i7) {
        scrollTo(getUnboundedScrollX() + i6, getScrollY() + i7);
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        if (this.f16074j) {
            LauncherScroller launcherScroller = this.f16087w;
            if (!launcherScroller.f15546o && (i6 > this.f16076l || i6 < this.f16075k)) {
                launcherScroller.f15546o = true;
            }
            i6 = Math.max(Math.min(i6, this.f16076l), this.f16075k);
        }
        this.f23380d0 = i6;
        boolean z5 = this.f23394r0;
        boolean z6 = !z5 ? i6 >= 0 : i6 <= this.f16086v;
        boolean z7 = !z5 ? i6 <= this.f16086v : i6 >= 0;
        if (z6) {
            super.scrollTo(z5 ? this.f16086v : 0, i7);
            if (this.mAllowOverScroll) {
                this.f23378b0 = true;
                if (z5) {
                    e0(i6 - this.f16086v);
                } else {
                    e0(i6);
                }
            }
        } else if (z7) {
            super.scrollTo(z5 ? 0 : this.f16086v, i7);
            if (this.mAllowOverScroll) {
                this.f23378b0 = true;
                if (z5) {
                    e0(i6);
                } else {
                    e0(i6 - this.f16086v);
                }
            }
        } else {
            if (this.f23378b0) {
                e0(0.0f);
                this.f23378b0 = false;
            }
            this.f23379c0 = i6;
            super.scrollTo(i6, i7);
        }
        System.nanoTime();
        if (isPageMoving()) {
            float[] fArrMapPointFromParentToView = mapPointFromParentToView(this, this.f16051A, this.f16052B);
            this.f16057G = fArrMapPointFromParentToView[0];
            this.f16059I = fArrMapPointFromParentToView[1];
            r0();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEvent(int i6) {
        if (i6 != 4096) {
            super.sendAccessibilityEvent(i6);
        }
    }

    public void setCurrentPage(int i6) {
        if (!this.f16087w.f15546o) {
            abortScrollerAnimation(true);
        }
        if (getChildCount() == 0) {
            return;
        }
        this.f16065O = true;
        this.mCurrentPage = t0(i6);
        q0();
        mo7728V();
        invalidate();
    }

    public void setDefaultInterpolator(Interpolator interpolator) {
        this.f16088x = interpolator;
        this.f16087w.f15547p = interpolator;
    }

    public void setEnableOverscroll(boolean z5) {
        this.mAllowOverScroll = z5;
    }

    public void setMinScale(float f6) {
        this.f23384h0 = f6;
        this.f23385i0 = true;
        requestLayout();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f16066P = onLongClickListener;
        int pageCount = getPageCount();
        for (int i6 = 0; i6 < pageCount; i6++) {
            mo7726M(i6).setOnLongClickListener(onLongClickListener);
        }
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setPageSpacing(int i6) {
        this.f16090z = i6;
        requestLayout();
    }

    public void setPageSwitchListener(PageSwitchListener pageSwitchListener) {
        this.f16073W = pageSwitchListener;
        if (pageSwitchListener != null) {
            pageSwitchListener.onPageSwitch(mo7726M(this.mCurrentPage), this.mCurrentPage);
        }
    }

    public void setRestorePage(int i6) {
        this.mRestorePage = i6;
    }

    @Override // android.view.View
    public void setScaleX(float f6) {
        super.setScaleX(f6);
        if (isPageMoving()) {
            float[] fArrMapPointFromParentToView = mapPointFromParentToView(this, this.f16051A, this.f16052B);
            this.f16057G = fArrMapPointFromParentToView[0];
            this.f16059I = fArrMapPointFromParentToView[1];
            r0();
        }
    }

    public final int t0(int i6) {
        if (this.f16074j) {
            int[] iArr = this.f16071U;
            mo7855K(iArr);
            i6 = Math.max(iArr[0], Math.min(i6, iArr[1]));
        }
        return Math.max(0, Math.min(i6, getPageCount() - 1));
    }

    /* JADX INFO: renamed from: v */
    public final void m7865v(CellLayout cellLayout, int i6) {
        PagedViewLayoutParams pagedViewLayoutParams = new PagedViewLayoutParams(-2, -2);
        pagedViewLayoutParams.f15973a = true;
        super.addView(cellLayout, i6 == 0 ? 0 : getPageCount(), pagedViewLayoutParams);
    }

    /* JADX INFO: renamed from: y */
    public final void dampedOverScroll(float f6) {
        int iRound;
        if (Float.compare(f6, 0.0f) == 0) {
            return;
        }
        int viewportWidth = getViewportWidth();
        DecelerateInterpolator decelerateInterpolator = AbstractC0041I.f108a;
        if (Float.compare(f6, 0.0f) == 0) {
            iRound = 0;
        } else {
            float f7 = viewportWidth;
            float f8 = f6 / f7;
            float interpolation = AbstractC0041I.f108a.getInterpolation(Math.abs(f8)) * (f8 / Math.abs(f8));
            if (Math.abs(interpolation) >= 1.0f) {
                interpolation /= Math.abs(interpolation);
            }
            iRound = Math.round(interpolation * 0.36f * f7);
        }
        if (f6 < 0.0f) {
            this.f23379c0 = iRound;
            super.scrollTo(iRound, getScrollY());
        } else {
            this.f23379c0 = this.f16086v + iRound;
            super.scrollTo(this.f23379c0, getScrollY());
        }
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        PagedViewLayoutParams pagedViewLayoutParams = new PagedViewLayoutParams(layoutParams);
        pagedViewLayoutParams.f15973a = false;
        return pagedViewLayoutParams;
    }
}
