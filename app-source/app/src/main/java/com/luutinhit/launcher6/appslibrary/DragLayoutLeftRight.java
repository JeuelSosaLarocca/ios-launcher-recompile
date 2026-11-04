package com.luutinhit.launcher6.appslibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import p014P.AbstractC0758N;
import p014P.C0779j;
import p021W.AbstractC1129d;
import p021W.C1130e;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class DragLayoutLeftRight extends FrameLayout {
    public String TAG;
    public View mAppsLibrary;
    public View mBlurLayout;
    public C1130e mDragHelperAppsLibrary;
    public AbstractC1129d mDragHelperCallBackAppsLibrary;
    public AbstractC1129d mDragHelperCallbackLeft;
    public C1130e mDragHelperLeftPage;
    public View mDragLayer;
    public C0779j mGestureDetector;
    public int mHeight;
    public int mLeftOfAppsLibrary;
    public int mLeftOfLeftPage;
    public View mLeftPage;
    public DragLayoutListener mPanelSlideListener;
    public int mRange;
    public DragStatus mStatusAppsLibrary;
    public DragStatus mStatusLeftPage;
    public int mWidth;

    public DragLayoutLeftRight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.TAG = "DragLayoutLeftRight";
        DragStatus dragStatus = DragStatus.f16310l;
        this.mStatusAppsLibrary = dragStatus;
        this.mStatusLeftPage = dragStatus;
        DragHelperCallback dragHelperCallback = new DragHelperCallback(0, this);
        this.mDragHelperCallBackAppsLibrary = dragHelperCallback;
        DragHelperCallback dragHelperCallback2 = new DragHelperCallback(1, this);
        this.mDragHelperCallbackLeft = dragHelperCallback2;
        setWillNotDraw(false);
        this.mGestureDetector = new C0779j(context, new DragLayoutGestureListener());
        this.mDragHelperAppsLibrary = C1130e.m2374h(this, 0.5f, dragHelperCallback);
        this.mDragHelperLeftPage = C1130e.m2374h(this, 0.5f, dragHelperCallback2);
    }

    public void closeAppsLibrary() {
        closeAppsLibrary(true);
    }

    public void closeLeftPage() {
        closeLeftPage(true);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelperAppsLibrary.m2381g()) {
            WeakHashMap weakHashMap = AbstractC0758N.f2272a;
            postInvalidateOnAnimation();
        }
        if (this.mDragHelperLeftPage.m2381g()) {
            WeakHashMap weakHashMap2 = AbstractC0758N.f2272a;
            postInvalidateOnAnimation();
        }
    }

    public DragStatus getStatus() {
        int i6 = this.mLeftOfAppsLibrary;
        if (i6 == 0) {
            this.mStatusAppsLibrary = DragStatus.f16310l;
        } else if (i6 == this.mRange) {
            this.mStatusAppsLibrary = DragStatus.f16309k;
        } else {
            this.mStatusAppsLibrary = DragStatus.f16308j;
        }
        return this.mStatusAppsLibrary;
    }

    public DragStatus getStatusLeft() {
        int i6 = this.mLeftOfLeftPage;
        if (i6 == 0) {
            this.mStatusLeftPage = DragStatus.f16309k;
        } else if (i6 == (-this.mRange)) {
            this.mStatusLeftPage = DragStatus.f16310l;
        } else {
            this.mStatusLeftPage = DragStatus.f16308j;
        }
        return this.mStatusLeftPage;
    }

    public boolean isAppsLibraryClosed() {
        View view = this.mAppsLibrary;
        return view != null && this.mWidth - Math.abs(view.getLeft()) == 0;
    }

    public boolean isAppsLibraryOpening(int i6) {
        this.mAppsLibrary.getLeft();
        View view = this.mAppsLibrary;
        return view != null && Math.abs(view.getLeft()) < i6;
    }

    public boolean isLayoutRtlSupport() {
        WeakHashMap weakHashMap = AbstractC0758N.f2272a;
        return getLayoutDirection() == 1;
    }

    public boolean isLeftPageClosed() {
        Math.abs(this.mLeftPage.getLeft());
        View view = this.mLeftPage;
        return view != null && this.mWidth - Math.abs(view.getLeft()) == 0;
    }

    public boolean isLeftPageOpened() {
        this.mLeftPage.getLeft();
        View view = this.mLeftPage;
        return view != null && Math.abs(view.getLeft()) == 0;
    }

    public boolean isLeftPageOpening(int i6) {
        this.mLeftPage.getLeft();
        View view = this.mLeftPage;
        return view != null && Math.abs(view.getLeft()) < i6;
    }

    public void moveToX(int i6, boolean z5) {
        if (!z5) {
            int i7 = isLayoutRtlSupport() ? -(this.mWidth + i6) : this.mWidth - i6;
            this.mAppsLibrary.layout(i7, 0, this.mWidth + i7, this.mHeight);
        } else {
            int i8 = isLayoutRtlSupport() ? this.mWidth - i6 : -(this.mWidth + i6);
            this.mLeftPage.layout(i8, 0, this.mWidth + i8, this.mHeight);
            this.mLeftPage.getLeft();
            this.mLeftPage.getAlpha();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDragLayer = getChildAt(0);
        this.mBlurLayout = getChildAt(1);
        this.mAppsLibrary = getChildAt(2);
        this.mLeftPage = getChildAt(3);
        this.mDragLayer.setClickable(true);
        this.mAppsLibrary.setClickable(true);
        this.mLeftPage.setClickable(true);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3 && actionMasked != 1) {
            return (this.mDragHelperAppsLibrary.m2391r(motionEvent) || this.mDragHelperLeftPage.m2391r(motionEvent)) && this.mGestureDetector.f2339a.onTouchEvent(motionEvent);
        }
        this.mDragHelperAppsLibrary.m2375a();
        this.mDragHelperLeftPage.m2375a();
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        this.mDragLayer.layout(0, 0, this.mWidth, this.mHeight);
        this.mBlurLayout.layout(0, 0, this.mWidth, this.mHeight);
        View view = this.mAppsLibrary;
        view.layout(view.getLeft(), 0, this.mAppsLibrary.getLeft() + this.mWidth, this.mHeight);
        View view2 = this.mLeftPage;
        view2.layout(view2.getLeft(), 0, this.mLeftPage.getLeft() + this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    public void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.mWidth = this.mDragLayer.getMeasuredWidth();
        this.mHeight = this.mDragLayer.getMeasuredHeight();
        this.mRange = this.mWidth;
        this.mLeftOfAppsLibrary = isLayoutRtlSupport() ? -this.mWidth : this.mWidth;
        this.mLeftOfLeftPage = isLayoutRtlSupport() ? this.mWidth : -this.mWidth;
        this.mDragLayer.layout(0, 0, this.mWidth, this.mHeight);
        this.mBlurLayout.layout(0, 0, this.mWidth, this.mHeight);
        View view = this.mAppsLibrary;
        int i10 = this.mLeftOfAppsLibrary;
        view.layout(i10, 0, this.mWidth + i10, this.mHeight);
        View view2 = this.mLeftPage;
        int i11 = this.mLeftOfLeftPage;
        view2.layout(i11, 0, this.mWidth + i11, this.mHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.mDragHelperAppsLibrary.m2384k(motionEvent);
            this.mDragHelperLeftPage.m2384k(motionEvent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void openAppsLibrary() {
        openAppsLibrary(true);
    }

    public void openLeftPage() {
        openLeftPage(true);
    }

    public void setPanelSlideListener(DragLayoutListener dragLayoutListener) {
    }

    public void closeAppsLibrary(boolean z5) {
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (z5) {
            if (this.mDragHelperAppsLibrary.m2392s(this.mAppsLibrary, zIsLayoutRtlSupport ? -this.mRange : this.mRange, 0)) {
                WeakHashMap weakHashMap = AbstractC0758N.f2272a;
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        View view = this.mAppsLibrary;
        int i6 = this.mRange;
        if (zIsLayoutRtlSupport) {
            i6 = -i6;
        }
        view.layout(i6, 0, zIsLayoutRtlSupport ? 0 : this.mRange * 2, this.mHeight);
    }

    public void closeLeftPage(boolean z5) {
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (z5) {
            if (this.mDragHelperLeftPage.m2392s(this.mLeftPage, zIsLayoutRtlSupport ? this.mRange : -this.mRange, 0)) {
                this.mLeftPage.getLeft();
                WeakHashMap weakHashMap = AbstractC0758N.f2272a;
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        View view = this.mLeftPage;
        int i6 = this.mRange;
        if (!zIsLayoutRtlSupport) {
            i6 = -i6;
        }
        view.layout(i6, 0, zIsLayoutRtlSupport ? this.mRange * 2 : 0, this.mHeight);
    }

    public void openAppsLibrary(boolean z5) {
        if (!z5) {
            this.mAppsLibrary.layout(0, 0, this.mWidth, this.mHeight);
            isLayoutRtlSupport();
        } else if (this.mDragHelperAppsLibrary.m2392s(this.mAppsLibrary, 0, 0)) {
            WeakHashMap weakHashMap = AbstractC0758N.f2272a;
            postInvalidateOnAnimation();
        }
    }

    public void openLeftPage(boolean z5) {
        if (!z5) {
            this.mLeftPage.layout(0, 0, this.mWidth, this.mHeight);
            isLayoutRtlSupport();
        } else if (this.mDragHelperLeftPage.m2392s(this.mLeftPage, 0, 0)) {
            WeakHashMap weakHashMap = AbstractC0758N.f2272a;
            postInvalidateOnAnimation();
        }
    }
}
