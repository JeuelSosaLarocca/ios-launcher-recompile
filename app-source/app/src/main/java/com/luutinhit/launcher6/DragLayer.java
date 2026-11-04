package com.luutinhit.launcher6;

import C2.C0148h;
import H0.RunnableC0416n;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import p101l3.C2339d;
import p126s3.SharedPreferencesOnSharedPreferenceChangeListenerC2745d;
import p158z3.SharedPreferencesOnSharedPreferenceChangeListenerC3078i;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class DragLayer extends InsertAbleFrameLayout {
    public static final int ANIMATION_END_DISAPPEAR = 0;
    public static final int ANIMATION_END_REMAIN_VISIBLE = 2;
    public static final int SCRIM_COLOR = 0;
    public static final String TAG = "DragLayer";
    View mAnchorView;
    int mAnchorViewInitialScrollX;
    public float mBackgroundAlpha;
    public int mChildCountOnLastUpdate;
    public TimeInterpolator mCubicEaseOutInterpolator;
    public AppWidgetResizeFrame mCurrentResizeFrame;
    DragController mDragController;
    public ValueAnimator mDropAnim;
    DragView mDropView;
    public Rect mHitRect;
    public boolean mHoverPointClosesFolder;
    public boolean mInScrollArea;
    public boolean mIsRtl;
    public Launcher mLauncher;
    public Drawable mLeftHoverDrawable;
    public Drawable mLeftHoverDrawableActive;
    public View mOverlayView;
    public ArrayList<AppWidgetResizeFrame> mResizeFrames;
    public Drawable mRightHoverDrawable;
    public Drawable mRightHoverDrawableActive;
    public Rect mScrollChildPosition;
    public boolean mShowPageHints;
    public int[] mTmpXY;
    public int mTopViewIndex;
    public TouchCompleteListener mTouchCompleteListener;
    public boolean mWorkSpaceDragOver;
    public int mXDown;
    public int mYDown;

    public DragLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpXY = new int[2];
        this.mResizeFrames = new ArrayList<>();
        this.mDropAnim = null;
        this.mCubicEaseOutInterpolator = new DecelerateInterpolator(1.5f);
        this.mDropView = null;
        this.mAnchorViewInitialScrollX = 0;
        this.mAnchorView = null;
        this.mHoverPointClosesFolder = false;
        this.mHitRect = new Rect();
        this.mChildCountOnLastUpdate = -1;
        this.mBackgroundAlpha = 0.0f;
        this.mScrollChildPosition = new Rect();
        this.mWorkSpaceDragOver = false;
        setMotionEventSplittingEnabled(false);
        setChildrenDrawingOrderEnabled(true);
        Resources resources = getResources();
        this.mLeftHoverDrawable = resources.getDrawable(2131231225);
        this.mRightHoverDrawable = resources.getDrawable(2131231227);
        this.mLeftHoverDrawableActive = resources.getDrawable(2131231226);
        this.mRightHoverDrawableActive = resources.getDrawable(2131231228);
        this.mIsRtl = Utilities.isRtl(resources);
    }

    public void drawPageHints(Canvas canvas) {
        if (this.mShowPageHints) {
            Workspace workspace = this.mLauncher.getWorkspace();
            int measuredWidth = getMeasuredWidth();
            int nextPage = workspace.getNextPage();
            CellLayout cellLayout = (CellLayout) workspace.getChildAt(this.mIsRtl ? nextPage + 1 : nextPage - 1);
            CellLayout cellLayout2 = (CellLayout) workspace.getChildAt(this.mIsRtl ? nextPage - 1 : nextPage + 1);
            if (cellLayout != null && cellLayout.f15477r) {
                Drawable drawable = (this.mInScrollArea && cellLayout.getIsDragOverlapping()) ? this.mLeftHoverDrawableActive : this.mLeftHoverDrawable;
                drawable.setBounds(0, this.mScrollChildPosition.top, drawable.getIntrinsicWidth(), this.mScrollChildPosition.bottom);
                drawable.draw(canvas);
            }
            if (cellLayout2 == null || !cellLayout2.f15477r) {
                return;
            }
            Drawable drawable2 = (this.mInScrollArea && cellLayout2.getIsDragOverlapping()) ? this.mRightHoverDrawableActive : this.mRightHoverDrawable;
            int intrinsicWidth = measuredWidth - drawable2.getIntrinsicWidth();
            Rect rect = this.mScrollChildPosition;
            drawable2.setBounds(intrinsicWidth, rect.top, measuredWidth, rect.bottom);
            drawable2.draw(canvas);
        }
    }

    public boolean handleTouchDown(MotionEvent motionEvent, boolean z5) {
        Rect rect = new Rect();
        int x6 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        ArrayList<AppWidgetResizeFrame> arrayList = this.mResizeFrames;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            AppWidgetResizeFrame appWidgetResizeFrame = arrayList.get(i6);
            i6++;
            AppWidgetResizeFrame appWidgetResizeFrame2 = appWidgetResizeFrame;
            appWidgetResizeFrame2.getHitRect(rect);
            if (rect.contains(x6, y4)) {
                int left = x6 - appWidgetResizeFrame2.getLeft();
                int top = y4 - appWidgetResizeFrame2.getTop();
                int i7 = appWidgetResizeFrame2.f16447G;
                boolean z6 = (i7 & 1) != 0;
                boolean z7 = (i7 & 2) != 0;
                int i8 = appWidgetResizeFrame2.f16468t;
                appWidgetResizeFrame2.f16473y = left < i8 && z6;
                appWidgetResizeFrame2.f16474z = left > appWidgetResizeFrame2.getWidth() - i8 && z6;
                appWidgetResizeFrame2.f16441A = top < appWidgetResizeFrame2.f16456P + i8 && z7;
                boolean z8 = top > (appWidgetResizeFrame2.getHeight() - i8) + appWidgetResizeFrame2.f16457Q && z7;
                appWidgetResizeFrame2.f16442B = z8;
                boolean z9 = appWidgetResizeFrame2.f16473y || appWidgetResizeFrame2.f16474z || appWidgetResizeFrame2.f16441A || z8;
                appWidgetResizeFrame2.f16443C = appWidgetResizeFrame2.getMeasuredWidth();
                appWidgetResizeFrame2.f16444D = appWidgetResizeFrame2.getMeasuredHeight();
                appWidgetResizeFrame2.f16445E = appWidgetResizeFrame2.getLeft();
                appWidgetResizeFrame2.f16446F = appWidgetResizeFrame2.getTop();
                if (z9) {
                    appWidgetResizeFrame2.f16462n.setAlpha(appWidgetResizeFrame2.f16473y ? 1.0f : 0.0f);
                    appWidgetResizeFrame2.f16463o.setAlpha(appWidgetResizeFrame2.f16474z ? 1.0f : 0.0f);
                    appWidgetResizeFrame2.f16464p.setAlpha(appWidgetResizeFrame2.f16441A ? 1.0f : 0.0f);
                    appWidgetResizeFrame2.f16465q.setAlpha(appWidgetResizeFrame2.f16442B ? 1.0f : 0.0f);
                }
                if (z9) {
                    this.mCurrentResizeFrame = appWidgetResizeFrame2;
                    this.mXDown = x6;
                    this.mYDown = y4;
                    requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            }
        }
        Folder openFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (openFolder != null && z5) {
            if (openFolder.f15616S && !isEventOverFolderTextRegion(openFolder, motionEvent)) {
                openFolder.dismissEditingName();
                return true;
            }
            if (!isEventOverFolder(openFolder, motionEvent) && !isOpenFloatingMenu()) {
                if (isInAccessibleDrag()) {
                    isEventOverDropTargetBar(motionEvent);
                    return !isEventOverDropTargetBar(motionEvent);
                }
                this.mLauncher.closeFolder();
                return true;
            }
        }
        return false;
    }

    public boolean handleTouchDownEditMenu(MotionEvent motionEvent, boolean z5) {
        SharedPreferencesOnSharedPreferenceChangeListenerC2745d editMenu = this.mLauncher.getEditMenu();
        if (editMenu == null || !isOpenEditMenu() || !z5 || isEventOverEditMenu(editMenu, motionEvent)) {
            return false;
        }
        this.mLauncher.closeEditMenu();
        return true;
    }

    public boolean handleTouchDownFloatingMenu(MotionEvent motionEvent, boolean z5) {
        SharedPreferencesOnSharedPreferenceChangeListenerC3078i floatingMenu = this.mLauncher.getFloatingMenu();
        if (floatingMenu == null || !isOpenFloatingMenu() || !z5 || isEventOverFloatingMenu(floatingMenu, motionEvent)) {
            return false;
        }
        this.mLauncher.closeFloatingMenu();
        return true;
    }

    public boolean isEventOverDropTargetBar(MotionEvent motionEvent) {
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean isEventOverEditMenu(SharedPreferencesOnSharedPreferenceChangeListenerC2745d sharedPreferencesOnSharedPreferenceChangeListenerC2745d, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(sharedPreferencesOnSharedPreferenceChangeListenerC2745d, this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean isEventOverFloatingMenu(SharedPreferencesOnSharedPreferenceChangeListenerC3078i sharedPreferencesOnSharedPreferenceChangeListenerC3078i, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(sharedPreferencesOnSharedPreferenceChangeListenerC3078i, this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean isEventOverFolder(Folder folder, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(folder, this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean isEventOverFolderTextRegion(Folder folder, MotionEvent motionEvent) {
        getDescendantRectRelativeToSelf(folder.getEditTextRegion(), this.mHitRect);
        return this.mHitRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    public boolean isInAccessibleDrag() {
        C2339d c2339d = LauncherAppState.getInstance().f16223f;
        return (c2339d == null || c2339d.f19394l == null) ? false : true;
    }

    public void sendTapOutsideFolderAccessibilityEvent(boolean z5) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        int i6 = z5 ? R.string.folder_tap_to_rename : R.string.folder_tap_to_close;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(8);
        onInitializeAccessibilityEvent(accessibilityEventObtain);
        accessibilityEventObtain.getText().add(getContext().getString(i6));
        accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
    }

    public void updateChildIndices() {
        this.mTopViewIndex = -1;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (getChildAt(i6) instanceof DragView) {
                this.mTopViewIndex = i6;
            }
        }
        this.mChildCountOnLastUpdate = childCount;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
        if (this.mLauncher.isShaking()) {
            return;
        }
        Folder openFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (openFolder != null) {
            arrayList.add(openFolder);
        } else {
            super.addChildrenForAccessibility(arrayList);
        }
    }

    public void addResizeFrame(ItemInfo itemInfo, LauncherAppWidgetHostView launcherAppWidgetHostView, CellLayout cellLayout) {
        AppWidgetResizeFrame appWidgetResizeFrame = new AppWidgetResizeFrame(getContext(), launcherAppWidgetHostView, cellLayout, this);
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(-1, -1);
        dragLayerLayoutParams.f16210d = true;
        addView(appWidgetResizeFrame, dragLayerLayoutParams);
        this.mResizeFrames.add(appWidgetResizeFrame);
        appWidgetResizeFrame.snapToWidget(false);
    }

    public void animateView(DragView dragView, Rect rect, Rect rect2, float f6, float f7, float f8, float f9, float f10, int i6, Interpolator interpolator, Interpolator interpolator2, Runnable runnable, int i7, View view) {
        int iMax;
        float fHypot = (float) Math.hypot(rect2.left - rect.left, rect2.top - rect.top);
        Resources resources = getResources();
        float integer = resources.getInteger(R.integer.config_dropAnimMaxDist);
        if (i6 < 0) {
            int integer2 = resources.getInteger(R.integer.config_dropAnimMaxDuration);
            if (fHypot < integer) {
                integer2 = (int) (this.mCubicEaseOutInterpolator.getInterpolation(fHypot / integer) * integer2);
            }
            iMax = Math.max(integer2, resources.getInteger(R.integer.config_dropAnimMinDuration));
        } else {
            iMax = i6;
        }
        animateView(dragView, new DragLayerAnimateViewUpdateListener(this, dragView, interpolator2, interpolator, f7, dragView.getScaleX(), f8, f9, f10, f6, dragView.getAlpha(), rect, rect2), iMax, (interpolator2 == null || interpolator == null) ? this.mCubicEaseOutInterpolator : null, runnable, i7, view);
    }

    public void animateViewIntoPosition(DragView dragView, int[] iArr, float f6, float f7, float f8, int i6, Runnable runnable, int i7) {
        Rect rect = new Rect();
        getViewRectRelativeToSelf(dragView, rect);
        animateViewIntoPosition(dragView, rect.left, rect.top, iArr[0], iArr[1], f6, 1.0f, 1.0f, f7, f8, runnable, i6, i7, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        View view2 = this.mOverlayView;
        if (view != view2 && view2 != null) {
            view2.bringToFront();
        }
        updateChildIndices();
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof DragLayerLayoutParams;
    }

    public void clearAllResizeFrames() {
        if (this.mResizeFrames.size() > 0) {
            ArrayList<AppWidgetResizeFrame> arrayList = this.mResizeFrames;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                AppWidgetResizeFrame appWidgetResizeFrame = arrayList.get(i6);
                i6++;
                AppWidgetResizeFrame appWidgetResizeFrame2 = appWidgetResizeFrame;
                appWidgetResizeFrame2.resizeWidgetIfNeeded(true);
                appWidgetResizeFrame2.requestLayout();
                removeView(appWidgetResizeFrame2);
            }
            this.mResizeFrames.clear();
        }
    }

    public void clearAnimatedView() {
        ValueAnimator valueAnimator = this.mDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        DragView dragView = this.mDropView;
        if (dragView != null) {
            DragController dragController = this.mDragController;
            dragController.getClass();
            if (dragView.getParent() != null) {
                dragView.f16482p.removeView(dragView);
            }
            if (dragController.f16102k.f16528l) {
                ArrayList arrayList = new ArrayList(dragController.f16104m);
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    ((DragListener) obj).mo905C();
                }
            }
        }
        this.mDropView = null;
        invalidate();
    }

    public void dismissOverlayView() {
        removeView(this.mOverlayView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f6 = this.mBackgroundAlpha;
        if (f6 > 0.0f) {
            canvas.drawColor(((int) (f6 * 255.0f)) << 24);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mDragController.f16097f || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i6) {
        View view2 = this.mDragController.f16107p;
        return view2 != null && view2.dispatchUnhandledMove(view, i6);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j6) {
        boolean zDrawChild = super.drawChild(canvas, view, j6);
        if (view instanceof Workspace) {
            drawPageHints(canvas);
        }
        return zDrawChild;
    }

    public View getAnimatedView() {
        return this.mDropView;
    }

    public float getBackgroundAlpha() {
        return this.mBackgroundAlpha;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i6, int i7) {
        if (this.mChildCountOnLastUpdate != i6) {
            updateChildIndices();
        }
        int i8 = this.mTopViewIndex;
        if (i8 != -1) {
            if (i7 == i6 - 1) {
                return i8;
            }
            if (i7 >= i8) {
                return i7 + 1;
            }
        }
        return i7;
    }

    public float getDescendantCoordRelativeToSelf(View view, int[] iArr) {
        return getDescendantCoordRelativeToSelf(view, iArr, false);
    }

    public float getDescendantRectRelativeToSelf(View view, Rect rect) {
        int[] iArr = this.mTmpXY;
        iArr[0] = 0;
        iArr[1] = 0;
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf(view, iArr);
        int[] iArr2 = this.mTmpXY;
        int i6 = iArr2[0];
        rect.set(i6, iArr2[1], (int) ((view.getMeasuredWidth() * descendantCoordRelativeToSelf) + i6), (int) ((view.getMeasuredHeight() * descendantCoordRelativeToSelf) + this.mTmpXY[1]));
        return descendantCoordRelativeToSelf;
    }

    public float getLocationInDragLayer(View view, int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        return getDescendantCoordRelativeToSelf(view, iArr);
    }

    public void getViewRectRelativeToSelf(View view, Rect rect) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i6 = iArr[0];
        int i7 = iArr[1];
        view.getLocationInWindow(iArr);
        int i8 = iArr[0] - i6;
        int i9 = iArr[1] - i7;
        rect.set(i8, i9, view.getMeasuredWidth() + i8, view.getMeasuredHeight() + i9);
    }

    public boolean hasResizeFrames() {
        return this.mResizeFrames.size() > 0;
    }

    public void hidePageHints() {
        this.mShowPageHints = false;
        invalidate();
    }

    public boolean isDragWorkspaceOver() {
        return this.mWorkSpaceDragOver;
    }

    public boolean isOpenEditMenu() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (getChildAt(i6) instanceof SharedPreferencesOnSharedPreferenceChangeListenerC2745d) {
                return true;
            }
        }
        return false;
    }

    public boolean isOpenFloatingMenu() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            if (getChildAt(i6) instanceof SharedPreferencesOnSharedPreferenceChangeListenerC3078i) {
                return true;
            }
        }
        return false;
    }

    public boolean isWidgetBeingResized() {
        return this.mCurrentResizeFrame != null;
    }

    public float mapCoordInSelfToDescendent(View view, int[] iArr) {
        Rect rect = Utilities.sOldBounds;
        ArrayList arrayList = new ArrayList();
        float[] fArr = {iArr[0], iArr[1]};
        while (view != this) {
            arrayList.add(view);
            view = (View) view.getParent();
        }
        arrayList.add(this);
        Matrix matrix = new Matrix();
        int size = arrayList.size() - 1;
        float scaleX = 1.0f;
        while (size >= 0) {
            View view2 = (View) arrayList.get(size);
            View view3 = size > 0 ? (View) arrayList.get(size - 1) : null;
            fArr[0] = fArr[0] + view2.getScrollX();
            fArr[1] = fArr[1] + view2.getScrollY();
            if (view3 != null) {
                fArr[0] = fArr[0] - view3.getLeft();
                fArr[1] = fArr[1] - view3.getTop();
                view3.getMatrix().invert(matrix);
                matrix.mapPoints(fArr);
                scaleX = view3.getScaleX() * scaleX;
            }
            size--;
        }
        iArr[0] = Math.round(fArr[0]);
        iArr[1] = Math.round(fArr[1]);
        return scaleX;
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        super.onChildViewAdded(view, view2);
        View view3 = this.mOverlayView;
        if (view3 != null) {
            view3.bringToFront();
        }
        updateChildIndices();
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        updateChildIndices();
    }

    public void onEnterScrollArea(int i6) {
        this.mInScrollArea = true;
        invalidate();
    }

    public void onExitScrollArea() {
        this.mInScrollArea = false;
        invalidate();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        Folder openFolder;
        AccessibilityManager accessibilityManager;
        Launcher launcher = this.mLauncher;
        if (launcher != null && launcher.getWorkspace() != null && (openFolder = this.mLauncher.getWorkspace().getOpenFolder()) != null && (accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility")) != null && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7) {
                boolean z5 = isEventOverFolder(openFolder, motionEvent) || (isInAccessibleDrag() && isEventOverDropTargetBar(motionEvent));
                if (!z5 && !this.mHoverPointClosesFolder) {
                    sendTapOutsideFolderAccessibilityEvent(openFolder.f15616S);
                    this.mHoverPointClosesFolder = true;
                    return true;
                }
                if (!z5) {
                    return true;
                }
                this.mHoverPointClosesFolder = false;
            } else if (action == 9) {
                if (isEventOverFolder(openFolder, motionEvent) || (isInAccessibleDrag() && isEventOverDropTargetBar(motionEvent))) {
                    this.mHoverPointClosesFolder = false;
                    return false;
                }
                sendTapOutsideFolderAccessibilityEvent(openFolder.f15616S);
                this.mHoverPointClosesFolder = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (handleTouchDownFloatingMenu(motionEvent, true) || handleTouchDownEditMenu(motionEvent, true) || handleTouchDown(motionEvent, true)) {
                return true;
            }
        } else if (action == 1 || action == 3) {
            TouchCompleteListener touchCompleteListener = this.mTouchCompleteListener;
            if (touchCompleteListener != null) {
                LauncherAppWidgetHostView launcherAppWidgetHostView = (LauncherAppWidgetHostView) touchCompleteListener;
                C0148h c0148h = launcherAppWidgetHostView.f16537k;
                if (!c0148h.f428a) {
                    c0148h.m362b();
                    launcherAppWidgetHostView.removeCallbacks(launcherAppWidgetHostView.f16535E);
                    if (!launcherAppWidgetHostView.f16539m.showingFloatingMenu) {
                        launcherAppWidgetHostView.m8051a();
                    }
                }
            }
            this.mTouchCompleteListener = null;
        }
        if (hasResizeFrames()) {
            clearAllResizeFrames();
            return true;
        }
        this.mDragController.onInterceptTouchEvent(motionEvent);
        return this.mDragController.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        try {
            super.onLayout(z5, i6, i7, i8, i9);
            try {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    if (childAt.getVisibility() != 8) {
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams instanceof DragLayerLayoutParams) {
                            DragLayerLayoutParams dragLayerLayoutParams = (DragLayerLayoutParams) layoutParams;
                            if (dragLayerLayoutParams.f16210d) {
                                int i11 = dragLayerLayoutParams.f16208b;
                                childAt.layout(i11, dragLayerLayoutParams.f16209c, childAt.getMeasuredWidth() + i11, dragLayerLayoutParams.f16209c + childAt.getMeasuredHeight());
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable th2) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        Folder openFolder = this.mLauncher.getWorkspace().getOpenFolder();
        if (openFolder == null) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        if (view == openFolder) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        if (isInAccessibleDrag() && (view instanceof SearchDropTargetBar)) {
            return super.onRequestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r0 != 3) goto L70;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x6 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        if (action == 0) {
            if (!handleTouchDownFloatingMenu(motionEvent, false) && !handleTouchDownEditMenu(motionEvent, false) && !handleTouchDown(motionEvent, false)) {
            }
            return true;
        }
        if (action == 1 || action == 3) {
            TouchCompleteListener touchCompleteListener = this.mTouchCompleteListener;
            if (touchCompleteListener != null) {
                LauncherAppWidgetHostView launcherAppWidgetHostView = (LauncherAppWidgetHostView) touchCompleteListener;
                C0148h c0148h = launcherAppWidgetHostView.f16537k;
                if (!c0148h.f428a) {
                    c0148h.m362b();
                    launcherAppWidgetHostView.removeCallbacks(launcherAppWidgetHostView.f16535E);
                    if (!launcherAppWidgetHostView.f16539m.showingFloatingMenu) {
                        launcherAppWidgetHostView.m8051a();
                    }
                }
            }
            this.mTouchCompleteListener = null;
        }
        AppWidgetResizeFrame appWidgetResizeFrame = this.mCurrentResizeFrame;
        if (appWidgetResizeFrame != null) {
            if (action != 1) {
                if (action == 2) {
                    appWidgetResizeFrame.updateDeltas(x6 - this.mXDown, y4 - this.mYDown);
                    return true;
                }
            }
            appWidgetResizeFrame.updateDeltas(x6 - this.mXDown, y4 - this.mYDown);
            AppWidgetResizeFrame appWidgetResizeFrame2 = this.mCurrentResizeFrame;
            CellLayout cellLayout = appWidgetResizeFrame2.f16460l;
            int widthGap = cellLayout.getWidthGap() + cellLayout.getCellWidth();
            int heightGap = cellLayout.getHeightGap() + cellLayout.getCellHeight();
            appWidgetResizeFrame2.f16454N = appWidgetResizeFrame2.f16448H * widthGap;
            appWidgetResizeFrame2.f16455O = appWidgetResizeFrame2.f16449I * heightGap;
            appWidgetResizeFrame2.f16452L = 0;
            appWidgetResizeFrame2.f16453M = 0;
            appWidgetResizeFrame2.post(new MergedUiRunnable(0, appWidgetResizeFrame2));
            this.mCurrentResizeFrame = null;
            return true;
        }
        DragController dragController = this.mDragController;
        if (!dragController.f16097f || dragController.f16098g) {
            return false;
        }
        try {
            if (dragController.f16091A == null) {
                dragController.f16091A = VelocityTracker.obtain();
            }
            dragController.f16091A.addMovement(motionEvent);
            int action2 = motionEvent.getAction();
            int[] clampedDragLayerPos = dragController.getClampedDragLayerPos(motionEvent.getX(), motionEvent.getY());
            int i6 = clampedDragLayerPos[0];
            int i7 = clampedDragLayerPos[1];
            Handler handler = dragController.f16093b;
            RunnableC0416n runnableC0416n = dragController.f16110s;
            if (action2 == 0) {
                dragController.f16099h = i6;
                dragController.f16100i = i7;
                int i8 = dragController.mScrollZone;
                if (i6 < i8 || i6 > dragController.f16106o.getWidth() - i8) {
                    dragController.f16109r = 1;
                    handler.postDelayed(runnableC0416n, 500L);
                } else {
                    dragController.f16109r = 0;
                }
                dragController.handleMoveEvent(i6, i7);
                return true;
            }
            if (action2 == 1) {
                dragController.handleMoveEvent(i6, i7);
                handler.removeCallbacks(runnableC0416n);
                if (dragController.f16097f) {
                    DragObject dragObject = dragController.f16102k;
                    DragSource dragSource = dragObject.f16524h;
                    DeleteDropTarget.supportsDrop(dragObject.f16523g);
                    dragController.drop(i6, i7);
                }
                dragController.releaseVelocityTracker();
                return true;
            }
            if (action2 == 2) {
                dragController.handleMoveEvent(i6, i7);
                return true;
            }
            if (action2 == 3) {
                handler.removeCallbacks(runnableC0416n);
                dragController.cancelDrag();
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return true;
    }

    public void setBackgroundAlpha(float f6) {
        if (f6 != this.mBackgroundAlpha) {
            this.mBackgroundAlpha = f6;
            invalidate();
        }
    }

    public void setTouchCompleteListener(TouchCompleteListener touchCompleteListener) {
        this.mTouchCompleteListener = touchCompleteListener;
    }

    public void setWorkSpaceDragOver(boolean z5) {
        this.mWorkSpaceDragOver = z5;
    }

    public void setup(Launcher launcher, DragController dragController) {
        this.mLauncher = launcher;
        this.mDragController = dragController;
    }

    public void showOverlayView(View view) {
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(-1, -1);
        this.mOverlayView = view;
        addView(view, dragLayerLayoutParams);
        this.mOverlayView.bringToFront();
    }

    public void showPageHints() {
        this.mShowPageHints = true;
        Workspace workspace = this.mLauncher.getWorkspace();
        getDescendantRectRelativeToSelf(workspace.getChildAt(workspace.d1()), this.mScrollChildPosition);
        invalidate();
    }

    public float getDescendantCoordRelativeToSelf(View view, int[] iArr, boolean z5) {
        Rect rect = Utilities.sOldBounds;
        ArrayList arrayList = new ArrayList();
        float[] fArr = {iArr[0], iArr[1]};
        for (View view2 = view; view2 != this && view2 != null; view2 = (View) view2.getParent()) {
            arrayList.add(view2);
        }
        arrayList.add(this);
        int size = arrayList.size();
        float scaleX = 1.0f;
        for (int i6 = 0; i6 < size; i6++) {
            View view3 = (View) arrayList.get(i6);
            if (view3 != view || z5) {
                fArr[0] = fArr[0] - view3.getScrollX();
                fArr[1] = fArr[1] - view3.getScrollY();
            }
            view3.getMatrix().mapPoints(fArr);
            fArr[0] = fArr[0] + view3.getLeft();
            fArr[1] = fArr[1] + view3.getTop();
            scaleX *= view3.getScaleX();
        }
        iArr[0] = Math.round(fArr[0]);
        iArr[1] = Math.round(fArr[1]);
        return scaleX;
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public DragLayerLayoutParams generateDefaultLayoutParams() {
        return new DragLayerLayoutParams(-2, -2);
    }

    public void animateViewIntoPosition(DragView dragView, View view, Runnable runnable, View view2) {
        animateViewIntoPosition(dragView, view, -1, runnable, view2);
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public DragLayerLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(getContext(), attributeSet);
        dragLayerLayoutParams.f16210d = false;
        return dragLayerLayoutParams;
    }

    public void animateViewIntoPosition(DragView dragView, View view, int i6, Runnable runnable, View view2) {
        int iRound;
        int iRound2;
        int measuredWidth;
        float intrinsicIconScaleFactor;
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = (ShortcutAndWidgetContainer) view.getParent();
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        if (shortcutAndWidgetContainer != null) {
            shortcutAndWidgetContainer.measureChild(view);
        }
        Rect rect = new Rect();
        getViewRectRelativeToSelf(dragView, rect);
        float scaleX = view.getScaleX();
        float f6 = 1.0f - scaleX;
        int[] iArr = {cellLayoutLayoutParams.f15695k + ((int) ((view.getMeasuredWidth() * f6) / 2.0f)), cellLayoutLayoutParams.f15696l + ((int) ((view.getMeasuredHeight() * f6) / 2.0f))};
        float descendantCoordRelativeToSelf = getDescendantCoordRelativeToSelf((View) view.getParent(), iArr) * scaleX;
        int i7 = iArr[0];
        int i8 = iArr[1];
        if (view instanceof TextView) {
            intrinsicIconScaleFactor = descendantCoordRelativeToSelf / dragView.getIntrinsicIconScaleFactor();
            iRound = (int) ((Math.round(((TextView) view).getPaddingTop() * intrinsicIconScaleFactor) + i8) - (((1.0f - intrinsicIconScaleFactor) * dragView.getMeasuredHeight()) / 2.0f));
            if (dragView.getDragVisualizeOffset() != null) {
                iRound -= Math.round(dragView.getDragVisualizeOffset().y * intrinsicIconScaleFactor);
            }
            measuredWidth = i7 - ((dragView.getMeasuredWidth() - Math.round(descendantCoordRelativeToSelf * view.getMeasuredWidth())) / 2);
        } else {
            if (view instanceof FolderIcon) {
                iRound = (int) (((int) ((Math.round((view.getPaddingTop() - dragView.getDragRegionTop()) * descendantCoordRelativeToSelf) + i8) - ((descendantCoordRelativeToSelf * 2.0f) / 2.0f))) - (((1.0f - descendantCoordRelativeToSelf) * dragView.getMeasuredHeight()) / 2.0f));
                iRound2 = (dragView.getMeasuredWidth() - Math.round(view.getMeasuredWidth() * descendantCoordRelativeToSelf)) / 2;
            } else {
                iRound = i8 - (Math.round((dragView.getHeight() - view.getMeasuredHeight()) * descendantCoordRelativeToSelf) / 2);
                iRound2 = Math.round((dragView.getMeasuredWidth() - view.getMeasuredWidth()) * descendantCoordRelativeToSelf) / 2;
            }
            measuredWidth = i7 - iRound2;
            intrinsicIconScaleFactor = descendantCoordRelativeToSelf;
        }
        int i9 = iRound;
        int i10 = rect.left;
        int i11 = rect.top;
        view.setVisibility(4);
        animateViewIntoPosition(dragView, i10, i11, measuredWidth, i9, 1.0f, 1.0f, 1.0f, intrinsicIconScaleFactor, intrinsicIconScaleFactor, new MergedModelRunnable(view, runnable, 2, false), 0, i6, view2);
    }

    @Override // com.luutinhit.launcher6.InsertAbleFrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public DragLayerLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(layoutParams);
        dragLayerLayoutParams.f16210d = false;
        return dragLayerLayoutParams;
    }

    public void animateView(DragView dragView, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, int i6, TimeInterpolator timeInterpolator, Runnable runnable, int i7, View view) {
        ValueAnimator valueAnimator = this.mDropAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mDropView = dragView;
        ValueAnimator valueAnimator2 = dragView.f16484r;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            valueAnimator2.cancel();
        }
        DragView dragView2 = this.mDropView;
        dragView2.f16486t = 0.0f;
        dragView2.f16485s = 0.0f;
        dragView2.requestLayout();
        if (view != null) {
            this.mAnchorViewInitialScrollX = view.getScrollX();
        }
        this.mAnchorView = view;
        ValueAnimator valueAnimator3 = new ValueAnimator();
        this.mDropAnim = valueAnimator3;
        valueAnimator3.setInterpolator(timeInterpolator);
        this.mDropAnim.setDuration(i6);
        this.mDropAnim.setFloatValues(0.0f, 1.0f);
        this.mDropAnim.addUpdateListener(animatorUpdateListener);
        this.mDropAnim.addListener(new DragLayerAnimEndListener(this, runnable, i7));
        this.mDropAnim.start();
    }

    public void animateViewIntoPosition(DragView dragView, int i6, int i7, int i8, int i9, float f6, float f7, float f8, float f9, float f10, Runnable runnable, int i10, int i11, View view) {
        animateView(dragView, new Rect(i6, i7, dragView.getMeasuredWidth() + i6, dragView.getMeasuredHeight() + i7), new Rect(i8, i9, dragView.getMeasuredWidth() + i8, dragView.getMeasuredHeight() + i9), f6, f7, f8, f9, f10, i11, null, null, runnable, i10, view);
    }
}
