package com.luutinhit.launcher6.util.overscroll;

import B3.C0038F;
import C3.InterfaceC0149a;
import C3.InterfaceC0150b;
import C3.InterfaceC0151c;
import C3.RunnableC0152d;
import C3.RunnableC0153e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import p124s0.AbstractC2705T;

/* JADX INFO: loaded from: classes.dex */
public class OverScrollLayout extends LinearLayout {
    public static final int SCROLL_BOTTOM = 2;
    public static int SCROLL_HORIZONTAL = 0;
    public static final int SCROLL_LEFT = 3;
    public static final int SCROLL_RIGHT = 4;
    public static final int SCROLL_TOP = 1;
    public static int SCROLL_VERTICAL = 1;
    public static final String TAG = "OverScrollLayout";
    public boolean abortScroller;
    public float baseOverScrollLength;
    public boolean bottomOverScrollEnable;
    public boolean canOverScrollHorizontally;
    public boolean canOverScrollVertical;
    public InterfaceC0151c checkListener;
    public boolean checkScrollDirectionFinish;
    public View child;
    public ViewConfiguration configuration;
    public int dealtX;
    public int dealtY;
    public GestureDetector detector;
    public boolean disallowIntercept;
    public float downX;
    public float downY;
    public boolean finishOverScroll;
    public RunnableC0152d flingRunnable;
    public OverScroller flingScroller;
    public boolean isHorizontallyMove;
    public boolean isOverScrollBottom;
    public boolean isOverScrollLeft;
    public boolean isOverScrollRight;
    public boolean isOverScrollTop;
    public boolean isVerticalMove;
    public boolean leftOverScrollEnable;
    public Scroller mScroller;
    public float oldX;
    public float oldY;
    public InterfaceC0149a onOverScrollFinishListener;
    public InterfaceC0150b onOverScrollListener;
    public RunnableC0153e overScrollRunnable;
    public boolean rightOverScrollEnable;
    public boolean shouldSetScrollerStart;
    public boolean topOverScrollEnable;

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.topOverScrollEnable = true;
        this.bottomOverScrollEnable = true;
        this.leftOverScrollEnable = true;
        this.rightOverScrollEnable = true;
        this.configuration = ViewConfiguration.get(getContext());
        this.mScroller = new Scroller(getContext(), new PathInterpolator(0.25f, 0.68f, 0.38f, 0.88f));
        this.flingRunnable = new RunnableC0152d(this);
        this.overScrollRunnable = new RunnableC0153e(this);
        this.flingScroller = new OverScroller(getContext());
        this.detector = new GestureDetector(getContext(), new C0038F(1, this));
    }

    /* JADX INFO: renamed from: i */
    public static void handleFling(OverScrollLayout overScrollLayout, float f6) {
        float scaledMaximumFlingVelocity = f6 / overScrollLayout.configuration.getScaledMaximumFlingVelocity();
        if (overScrollLayout.canOverScrollVertical) {
            if (overScrollLayout.canChildScrollUp()) {
                overScrollLayout.overScrollRunnable.m365a(0.0f, scaledMaximumFlingVelocity);
                return;
            } else {
                overScrollLayout.overScrollRunnable.m365a(0.0f, -scaledMaximumFlingVelocity);
                return;
            }
        }
        if (overScrollLayout.canChildScrollRight()) {
            overScrollLayout.overScrollRunnable.m365a(-scaledMaximumFlingVelocity, 0.0f);
        } else {
            overScrollLayout.overScrollRunnable.m365a(scaledMaximumFlingVelocity, 0.0f);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        char c6;
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
            return;
        }
        if (this.abortScroller) {
            this.abortScroller = false;
            return;
        }
        if (this.finishOverScroll) {
            InterfaceC0149a interfaceC0149a = this.onOverScrollFinishListener;
            if (interfaceC0149a != null) {
                if (this.isOverScrollTop) {
                    c6 = 1;
                } else if (this.isOverScrollBottom) {
                    c6 = 2;
                } else if (this.isOverScrollLeft) {
                    c6 = 3;
                } else {
                    c6 = this.isOverScrollRight ? (char) 4 : (char) 0;
                }
                WallpaperActivity wallpaperActivity = (WallpaperActivity) interfaceC0149a;
                if (c6 == 2) {
                    wallpaperActivity.f17450T.postDelayed(wallpaperActivity.f17451U, 0L);
                }
            }
            this.isOverScrollTop = false;
            this.isOverScrollBottom = false;
            this.isOverScrollLeft = false;
            this.isOverScrollRight = false;
            this.finishOverScroll = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:194:0x0296 A[Catch: all -> 0x000a, TryCatch #0 {all -> 0x000a, blocks: (B:3:0x0001, B:5:0x0005, B:9:0x000d, B:213:0x02f0, B:20:0x002c, B:21:0x0032, B:22:0x0038, B:24:0x003c, B:26:0x0040, B:28:0x0044, B:31:0x004a, B:33:0x005b, B:35:0x0062, B:49:0x0084, B:52:0x008a, B:54:0x0099, B:68:0x00bd, B:71:0x00c3, B:73:0x00d2, B:57:0x00a5, B:59:0x00a9, B:62:0x00ae, B:64:0x00b5, B:38:0x006c, B:40:0x0070, B:43:0x0075, B:45:0x007c, B:74:0x00dc, B:76:0x00e0, B:77:0x00eb, B:79:0x00f1, B:81:0x00f8, B:83:0x0115, B:85:0x0119, B:86:0x011b, B:88:0x011f, B:90:0x0123, B:91:0x0125, B:93:0x0130, B:95:0x0134, B:102:0x0142, B:104:0x014e, B:106:0x0154, B:97:0x0138, B:99:0x013c, B:109:0x0169, B:111:0x016d, B:113:0x0171, B:116:0x0177, B:118:0x0188, B:120:0x018f, B:134:0x01b1, B:137:0x01b7, B:139:0x01c6, B:141:0x01d0, B:144:0x01d5, B:146:0x01dc, B:150:0x01e5, B:153:0x01eb, B:155:0x01fa, B:123:0x0199, B:125:0x019d, B:128:0x01a2, B:130:0x01a9, B:156:0x0204, B:158:0x0208, B:159:0x0213, B:161:0x0219, B:163:0x0220, B:165:0x023d, B:167:0x0241, B:168:0x0243, B:170:0x0247, B:172:0x024b, B:173:0x024d, B:175:0x0258, B:177:0x025c, B:184:0x026a, B:186:0x0276, B:188:0x027c, B:179:0x0260, B:181:0x0264, B:192:0x0291, B:194:0x0296, B:195:0x029c, B:197:0x02b2, B:199:0x02be, B:201:0x02d0, B:203:0x02dc, B:205:0x02e0, B:207:0x02e4, B:209:0x02e8, B:212:0x02ed, B:202:0x02d3, B:198:0x02b5), top: B:218:0x0001 }] */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        try {
            if (this.disallowIntercept) {
                return super.dispatchTouchEvent(motionEvent);
            }
            this.detector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.flingRunnable.f432j = true;
                this.downY = motionEvent.getY();
                this.oldY = 0.0f;
                int currY = this.mScroller.getCurrY();
                this.dealtY = currY;
                if (currY == 0) {
                    this.isVerticalMove = false;
                } else {
                    this.shouldSetScrollerStart = true;
                    this.abortScroller = true;
                    this.mScroller.abortAnimation();
                }
                this.downX = motionEvent.getX();
                this.oldX = 0.0f;
                int currX = this.mScroller.getCurrX();
                this.dealtX = currX;
                if (currX == 0) {
                    this.isHorizontallyMove = false;
                } else {
                    this.shouldSetScrollerStart = true;
                    this.abortScroller = true;
                    this.mScroller.abortAnimation();
                }
                if (!this.isOverScrollTop && !this.isOverScrollBottom && !this.isOverScrollLeft && !this.isOverScrollRight) {
                    updateOverScrollDirection();
                    return super.dispatchTouchEvent(motionEvent);
                }
                return true;
            }
            if (action == 1) {
                this.finishOverScroll = true;
                mSmoothScrollTo(0, 0);
            } else if (action != 2) {
                if (action == 3) {
                    this.finishOverScroll = true;
                    mSmoothScrollTo(0, 0);
                } else if (action == 5 || action == 6) {
                    this.oldY = 0.0f;
                    this.oldX = 0.0f;
                }
            } else {
                if (this.child == null) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.canOverScrollVertical) {
                    if (!this.isOverScrollTop && !this.isOverScrollBottom) {
                        detectDragDirection(motionEvent.getX(), motionEvent.getY());
                        if (this.oldY == 0.0f) {
                            this.oldY = motionEvent.getY();
                            return true;
                        }
                        boolean z5 = this.isOverScrollTop || (this.topOverScrollEnable && this.isVerticalMove && this.oldY - motionEvent.getY() < 0.0f && !canChildScrollUp());
                        if (!this.isOverScrollTop && z5) {
                            this.oldY = motionEvent.getY();
                            this.isOverScrollTop = z5;
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                        this.isOverScrollTop = z5;
                        boolean z6 = this.isOverScrollBottom || (this.bottomOverScrollEnable && this.isVerticalMove && this.oldY - motionEvent.getY() > 0.0f && !canChildScrollDown());
                        if (!this.isOverScrollBottom && z6) {
                            this.oldY = motionEvent.getY();
                            this.isOverScrollBottom = z6;
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                        this.isOverScrollBottom = z6;
                        this.oldY = motionEvent.getY();
                    }
                    if (this.shouldSetScrollerStart) {
                        this.shouldSetScrollerStart = false;
                        this.mScroller.startScroll(this.dealtX, this.dealtY, 0, 0);
                    }
                    float f6 = this.oldY;
                    if (f6 == 0.0f) {
                        this.oldY = motionEvent.getY();
                        return true;
                    }
                    this.dealtY = (int) (this.dealtY + getDampedOffset(f6 - motionEvent.getY(), this.dealtY));
                    this.oldY = motionEvent.getY();
                    if (this.isOverScrollTop && this.dealtY > 0) {
                        this.dealtY = 0;
                    }
                    if (this.isOverScrollBottom && this.dealtY < 0) {
                        this.dealtY = 0;
                    }
                    mSmoothScrollTo(this.dealtX, this.dealtY);
                    boolean z7 = this.isOverScrollTop;
                    if ((z7 && this.dealtY == 0 && !this.isOverScrollBottom) || (this.isOverScrollBottom && this.dealtY == 0 && !z7)) {
                        this.oldY = 0.0f;
                        this.isOverScrollTop = false;
                        this.isOverScrollBottom = false;
                        if (canChildScrollDown() || canChildScrollUp()) {
                            this.oldY = 0.0f;
                            this.dealtY = 0;
                            motionEvent.setAction(0);
                            super.dispatchTouchEvent(motionEvent);
                            motionEvent.setAction(2);
                            if (super.dispatchTouchEvent(motionEvent)) {
                            }
                            return false;
                        }
                    }
                    return true;
                }
                if (this.canOverScrollHorizontally) {
                    if (!this.isOverScrollLeft && !this.isOverScrollRight) {
                        detectDragDirection(motionEvent.getX(), motionEvent.getY());
                        if (this.oldX == 0.0f) {
                            this.oldX = motionEvent.getX();
                            return true;
                        }
                        boolean z8 = this.isOverScrollLeft || (this.leftOverScrollEnable && this.isHorizontallyMove && this.oldX - motionEvent.getX() < 0.0f && !canChildScrollLeft());
                        if (!this.isOverScrollLeft && z8) {
                            this.oldX = motionEvent.getX();
                            this.isOverScrollLeft = z8;
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                        this.isOverScrollLeft = z8;
                        boolean z9 = this.rightOverScrollEnable && this.isHorizontallyMove && this.oldX - motionEvent.getX() > 0.0f && !canChildScrollRight();
                        if (!this.isOverScrollRight && z9) {
                            this.oldX = motionEvent.getX();
                            this.isOverScrollRight = z9;
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                        this.isOverScrollRight = z9;
                        this.oldX = motionEvent.getX();
                    }
                    if (this.shouldSetScrollerStart) {
                        this.shouldSetScrollerStart = false;
                        this.mScroller.startScroll(this.dealtX, this.dealtY, 0, 0);
                    }
                    float f7 = this.oldX;
                    if (f7 == 0.0f) {
                        this.oldX = motionEvent.getX();
                        return true;
                    }
                    this.dealtX = (int) (this.dealtX + getDampedOffset(f7 - motionEvent.getX(), this.dealtX));
                    this.oldX = motionEvent.getX();
                    if (this.isOverScrollLeft && this.dealtX > 0) {
                        this.dealtX = 0;
                    }
                    if (this.isOverScrollRight && this.dealtX < 0) {
                        this.dealtX = 0;
                    }
                    mSmoothScrollTo(this.dealtX, this.dealtY);
                    boolean z10 = this.isOverScrollLeft;
                    if ((z10 && this.dealtX == 0 && !this.isOverScrollRight) || (this.isOverScrollRight && this.dealtX == 0 && !z10)) {
                        this.oldX = 0.0f;
                        this.isOverScrollRight = false;
                        this.isOverScrollLeft = false;
                        if (canChildScrollLeft() || canChildScrollRight()) {
                            this.oldX = 0.0f;
                            this.dealtX = 0;
                            motionEvent.setAction(0);
                            super.dispatchTouchEvent(motionEvent);
                            motionEvent.setAction(2);
                            if (super.dispatchTouchEvent(motionEvent)) {
                            }
                            return false;
                        }
                    }
                    return true;
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    public InterfaceC0150b getOnOverScrollListener() {
        return null;
    }

    public InterfaceC0151c getOverScrollCheckListener() {
        return null;
    }

    public boolean isBottomOverScrollEnable() {
        return this.bottomOverScrollEnable;
    }

    public boolean isLeftOverScrollEnable() {
        return this.leftOverScrollEnable;
    }

    public boolean isRightOverScrollEnable() {
        return this.rightOverScrollEnable;
    }

    public boolean isTopOverScrollEnable() {
        return this.topOverScrollEnable;
    }

    /* JADX INFO: renamed from: j */
    public final boolean canChildScrollDown() {
        View view = this.child;
        return view != null && view.canScrollVertically(1);
    }

    /* JADX INFO: renamed from: k */
    public final boolean canChildScrollLeft() {
        View view = this.child;
        return view != null && view.canScrollHorizontally(-1);
    }

    /* JADX INFO: renamed from: l */
    public final boolean canChildScrollRight() {
        View view = this.child;
        return view != null && view.canScrollHorizontally(1);
    }

    /* JADX INFO: renamed from: m */
    public final boolean canChildScrollUp() {
        View view = this.child;
        return view != null && view.canScrollVertically(-1);
    }

    public void mSmoothScrollBy(int i6, int i7) {
        Scroller scroller = this.mScroller;
        scroller.startScroll(scroller.getFinalX(), this.mScroller.getFinalY(), i6, i7);
        invalidate();
    }

    public void mSmoothScrollTo(int i6, int i7) {
        mSmoothScrollBy(i6 - this.mScroller.getFinalX(), i7 - this.mScroller.getFinalY());
    }

    /* JADX INFO: renamed from: n */
    public final void updateOverScrollDirection() {
        int i6;
        if (this.checkScrollDirectionFinish) {
            return;
        }
        View view = this.child;
        if ((view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof WebView)) {
            this.canOverScrollHorizontally = false;
            this.canOverScrollVertical = true;
        } else if (view instanceof RecyclerView) {
            AbstractC2705T layoutManager = ((RecyclerView) view).getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                i6 = ((StaggeredGridLayoutManager) layoutManager).f5453t;
            } else {
                i6 = layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).f5385p : -1;
            }
            this.canOverScrollHorizontally = i6 == 0;
            this.canOverScrollVertical = 1 == i6;
        } else if (view instanceof HorizontalScrollView) {
            this.canOverScrollHorizontally = true;
            this.canOverScrollVertical = false;
        } else if (view instanceof ViewPager) {
            this.canOverScrollHorizontally = false;
            this.canOverScrollVertical = false;
        } else {
            this.canOverScrollHorizontally = false;
            this.canOverScrollVertical = true;
        }
        this.checkScrollDirectionFinish = true;
        if (this.canOverScrollVertical) {
            this.baseOverScrollLength = getHeight();
        } else {
            this.baseOverScrollLength = getWidth();
        }
    }

    /* JADX INFO: renamed from: o */
    public final void detectDragDirection(float f6, float f7) {
        if (this.isVerticalMove || this.isHorizontallyMove) {
            return;
        }
        if (this.canOverScrollVertical) {
            this.isVerticalMove = Math.abs(f7 - this.downY) >= ((float) this.configuration.getScaledTouchSlop());
        } else if (this.canOverScrollHorizontally) {
            this.isHorizontallyMove = Math.abs(f6 - this.downX) >= ((float) this.configuration.getScaledTouchSlop());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int childCount = getChildCount();
        if (childCount > 1) {
            throw new IllegalStateException("OverScrollLayout only can host 1 element");
        }
        if (childCount == 1) {
            View childAt = getChildAt(0);
            this.child = childAt;
            childAt.setOverScrollMode(2);
        }
        super.onFinishInflate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: renamed from: p */
    public final float getDampedOffset(float f6, float f7) {
        if (f6 * f7 < 0.0f) {
            return f6;
        }
        return (1.0f - Math.min(new AccelerateInterpolator(0.15f).getInterpolation((float) Math.min(Math.max(Math.abs(f7), 0.1d) / ((double) Math.abs(this.baseOverScrollLength)), 1.0d)), 1.0f)) * f6;
    }

    public void setBottomOverScrollEnable(boolean z5) {
        this.bottomOverScrollEnable = z5;
    }

    public void setDisallowInterceptTouchEvent(boolean z5) {
        this.disallowIntercept = z5;
    }

    public void setLeftOverScrollEnable(boolean z5) {
        this.leftOverScrollEnable = z5;
    }

    public void setOnOverScrollFinishListener(InterfaceC0149a interfaceC0149a) {
        this.onOverScrollFinishListener = interfaceC0149a;
    }

    public void setRightOverScrollEnable(boolean z5) {
        this.rightOverScrollEnable = z5;
    }

    public void setTopOverScrollEnable(boolean z5) {
        this.topOverScrollEnable = z5;
    }

    public void setOnOverScrollListener(InterfaceC0150b interfaceC0150b) {
    }

    public void setOverScrollCheckListener(InterfaceC0151c interfaceC0151c) {
    }
}
