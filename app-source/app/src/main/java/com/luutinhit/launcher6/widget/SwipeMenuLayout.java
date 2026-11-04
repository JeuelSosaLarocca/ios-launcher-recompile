package com.luutinhit.launcher6.widget;

import G3.C0352h;
import G3.C0353i;
import O3.AbstractC0744e;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuLayout extends ViewGroup {

    /* JADX INFO: renamed from: B */
    public static SwipeMenuLayout f17117B;

    /* JADX INFO: renamed from: C */
    public static boolean f17118C;

    /* JADX INFO: renamed from: A */
    public ValueAnimator f17119A;

    /* JADX INFO: renamed from: j */
    public int f17120j;

    /* JADX INFO: renamed from: k */
    public int f17121k;

    /* JADX INFO: renamed from: l */
    public int f17122l;

    /* JADX INFO: renamed from: m */
    public int f17123m;

    /* JADX INFO: renamed from: n */
    public int f17124n;

    /* JADX INFO: renamed from: o */
    public int f17125o;

    /* JADX INFO: renamed from: p */
    public View f17126p;

    /* JADX INFO: renamed from: q */
    public PointF f17127q;

    /* JADX INFO: renamed from: r */
    public boolean f17128r;

    /* JADX INFO: renamed from: s */
    public PointF f17129s;

    /* JADX INFO: renamed from: t */
    public boolean f17130t;

    /* JADX INFO: renamed from: u */
    public VelocityTracker f17131u;

    /* JADX INFO: renamed from: v */
    public boolean f17132v;

    /* JADX INFO: renamed from: w */
    public boolean f17133w;

    /* JADX INFO: renamed from: x */
    public boolean f17134x;

    /* JADX INFO: renamed from: y */
    public boolean f17135y;

    /* JADX INFO: renamed from: z */
    public ValueAnimator f17136z;

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f17127q = new PointF();
        this.f17128r = true;
        this.f17129s = new PointF();
        this.f17132v = true;
        this.f17133w = true;
        this.f17135y = true;
        this.f17120j = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f17121k = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2231B);
        this.f17132v = typedArrayObtainStyledAttributes.getBoolean(2, true);
        this.f17133w = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.f17135y = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static SwipeMenuLayout getViewCache() {
        return f17117B;
    }

    /* JADX INFO: renamed from: a */
    public final void cancelAnimators() {
        ValueAnimator valueAnimator = this.f17119A;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f17119A.cancel();
        }
        ValueAnimator valueAnimator2 = this.f17136z;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f17136z.cancel();
    }

    /* JADX INFO: renamed from: b */
    public final void smoothClose() {
        f17117B = null;
        View view = this.f17126p;
        if (view != null) {
            view.setLongClickable(true);
        }
        cancelAnimators();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.f17119A = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new C0352h(this, 1));
        this.f17119A.setInterpolator(new AccelerateInterpolator());
        this.f17119A.addListener(new C0353i(this, 1));
        this.f17119A.setDuration(300L).start();
    }

    /* JADX INFO: renamed from: c */
    public final void smoothExpand() {
        f17117B = this;
        View view = this.f17126p;
        if (view != null) {
            view.setLongClickable(false);
        }
        cancelAnimators();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollX(), this.f17135y ? this.f17124n : -this.f17124n);
        this.f17136z = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new C0352h(this, 0));
        this.f17136z.setInterpolator(new OvershootInterpolator());
        this.f17136z.addListener(new C0353i(this, 0));
        this.f17136z.setDuration(300L).start();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:61:0x0100  */
    /* JADX WARN: Code duplicated, block: B:64:0x0107  */
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        VelocityTracker velocityTracker;
        float xVelocity;
        if (this.f17132v) {
            if (this.f17131u == null) {
                this.f17131u = VelocityTracker.obtain();
            }
            this.f17131u.addMovement(motionEvent);
            VelocityTracker velocityTracker2 = this.f17131u;
            int action = motionEvent.getAction();
            PointF pointF = this.f17129s;
            PointF pointF2 = this.f17127q;
            if (action == 0) {
                this.f17130t = false;
                this.f17128r = true;
                this.f17134x = false;
                if (f17118C) {
                    return false;
                }
                f17118C = true;
                pointF2.set(motionEvent.getRawX(), motionEvent.getRawY());
                pointF.set(motionEvent.getRawX(), motionEvent.getRawY());
                SwipeMenuLayout swipeMenuLayout = f17117B;
                if (swipeMenuLayout != null) {
                    if (swipeMenuLayout != this) {
                        swipeMenuLayout.smoothClose();
                        this.f17134x = this.f17133w;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.f17122l = motionEvent.getPointerId(0);
            } else if (action == 1) {
                if (Math.abs(motionEvent.getRawX() - pointF.x) > this.f17120j) {
                    this.f17130t = true;
                }
                if (!this.f17134x) {
                    velocityTracker2.computeCurrentVelocity(1000, this.f17121k);
                    xVelocity = velocityTracker2.getXVelocity(this.f17122l);
                    if (Math.abs(xVelocity) > 1000.0f) {
                        if (xVelocity < -1000.0f) {
                            if (this.f17135y) {
                                smoothExpand();
                            } else {
                                smoothClose();
                            }
                        } else if (this.f17135y) {
                            smoothClose();
                        } else {
                            smoothExpand();
                        }
                    } else if (Math.abs(getScrollX()) > this.f17125o) {
                        smoothExpand();
                    } else {
                        smoothClose();
                    }
                }
                velocityTracker = this.f17131u;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                    this.f17131u.recycle();
                    this.f17131u = null;
                }
                f17118C = false;
            } else if (action != 2) {
                if (action == 3) {
                    if (Math.abs(motionEvent.getRawX() - pointF.x) > this.f17120j) {
                        this.f17130t = true;
                    }
                    if (!this.f17134x) {
                        velocityTracker2.computeCurrentVelocity(1000, this.f17121k);
                        xVelocity = velocityTracker2.getXVelocity(this.f17122l);
                        if (Math.abs(xVelocity) > 1000.0f) {
                            if (xVelocity < -1000.0f) {
                                if (this.f17135y) {
                                    smoothExpand();
                                } else {
                                    smoothClose();
                                }
                            } else if (this.f17135y) {
                                smoothClose();
                            } else {
                                smoothExpand();
                            }
                        } else if (Math.abs(getScrollX()) > this.f17125o) {
                            smoothExpand();
                        } else {
                            smoothClose();
                        }
                    }
                    velocityTracker = this.f17131u;
                    if (velocityTracker != null) {
                        velocityTracker.clear();
                        this.f17131u.recycle();
                        this.f17131u = null;
                    }
                    f17118C = false;
                }
            } else if (!this.f17134x) {
                float rawX = pointF2.x - motionEvent.getRawX();
                if (Math.abs(rawX) > 10.0f || Math.abs(getScrollX()) > 10) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                if (Math.abs(rawX) > this.f17120j) {
                    this.f17128r = false;
                }
                scrollBy((int) rawX, 0);
                if (this.f17135y) {
                    if (getScrollX() < 0) {
                        scrollTo(0, 0);
                    }
                    int scrollX = getScrollX();
                    int i6 = this.f17124n;
                    if (scrollX > i6) {
                        scrollTo(i6, 0);
                    }
                } else {
                    int scrollX2 = getScrollX();
                    int i7 = this.f17124n;
                    if (scrollX2 < (-i7)) {
                        scrollTo(-i7, 0);
                    }
                    if (getScrollX() > 0) {
                        scrollTo(0, 0);
                    }
                }
                pointF2.set(motionEvent.getRawX(), motionEvent.getRawY());
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = f17117B;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.smoothClose();
            f17117B = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        if (r4.f17134x != false) goto L35;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f17132v) {
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action != 2 || Math.abs(motionEvent.getRawX() - this.f17129s.x) <= this.f17120j) {
                }
            } else if (this.f17135y) {
                if (getScrollX() <= this.f17120j || motionEvent.getX() >= getWidth() - getScrollX()) {
                    if (!this.f17130t) {
                    }
                } else if (this.f17128r) {
                    smoothClose();
                    return true;
                }
            } else if ((-getScrollX()) <= this.f17120j || motionEvent.getX() <= (-getScrollX())) {
                if (!this.f17130t) {
                }
            } else if (this.f17128r) {
                smoothClose();
                return true;
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int measuredWidth = 0;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                if (i10 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + getPaddingTop());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.f17135y) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + getPaddingTop());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, childAt.getMeasuredHeight() + getPaddingTop());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft = measuredWidth + paddingLeft;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        SwipeMenuLayout swipeMenuLayout = this;
        super.onMeasure(i6, i7);
        swipeMenuLayout.setClickable(true);
        swipeMenuLayout.f17124n = 0;
        swipeMenuLayout.f17123m = 0;
        int childCount = swipeMenuLayout.getChildCount();
        boolean z5 = View.MeasureSpec.getMode(i7) != 1073741824;
        int measuredWidth = 0;
        boolean z6 = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = swipeMenuLayout.getChildAt(i8);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                swipeMenuLayout.measureChild(childAt, i6, i7);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                swipeMenuLayout.f17123m = Math.max(swipeMenuLayout.f17123m, childAt.getMeasuredHeight());
                if (z5 && marginLayoutParams.height == -1) {
                    z6 = true;
                }
                if (i8 > 0) {
                    swipeMenuLayout.f17124n = childAt.getMeasuredWidth() + swipeMenuLayout.f17124n;
                } else {
                    swipeMenuLayout.f17126p = childAt;
                    measuredWidth = childAt.getMeasuredWidth();
                }
            }
        }
        swipeMenuLayout.setMeasuredDimension(swipeMenuLayout.getPaddingRight() + swipeMenuLayout.getPaddingLeft() + measuredWidth, swipeMenuLayout.getPaddingBottom() + swipeMenuLayout.getPaddingTop() + swipeMenuLayout.f17123m);
        swipeMenuLayout.f17125o = (swipeMenuLayout.f17124n * 4) / 10;
        if (z6) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(swipeMenuLayout.getMeasuredHeight(), 1073741824);
            int i9 = 0;
            while (i9 < childCount) {
                View childAt2 = swipeMenuLayout.getChildAt(i9);
                if (childAt2.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                    if (marginLayoutParams2.height == -1) {
                        int i10 = marginLayoutParams2.width;
                        marginLayoutParams2.width = childAt2.getMeasuredWidth();
                        swipeMenuLayout.measureChildWithMargins(childAt2, i6, 0, iMakeMeasureSpec, 0);
                        marginLayoutParams2.width = i10;
                    }
                }
                i9++;
                swipeMenuLayout = this;
            }
        }
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        return Math.abs(getScrollX()) <= this.f17120j && super.performLongClick();
    }

    public void setSwipeEnable(boolean z5) {
        this.f17132v = z5;
    }
}
