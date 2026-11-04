package com.luutinhit.launcher6;

import H0.RunnableC0416n;
import M2.RunnableC0674C;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: com.luutinhit.launcher6.X */
/* JADX INFO: loaded from: classes.dex */
public final class DragController {

    /* JADX INFO: renamed from: A */
    public VelocityTracker f16091A;

    /* JADX INFO: renamed from: a */
    public Launcher f16092a;

    /* JADX INFO: renamed from: b */
    public Handler f16093b;

    /* JADX INFO: renamed from: e */
    public boolean f16096e;

    /* JADX INFO: renamed from: f */
    public boolean f16097f;

    /* JADX INFO: renamed from: g */
    public boolean f16098g;

    /* JADX INFO: renamed from: h */
    public int f16099h;

    /* JADX INFO: renamed from: i */
    public int f16100i;

    /* JADX INFO: renamed from: j */
    public int mScrollZone;

    /* JADX INFO: renamed from: k */
    public DragObject f16102k;

    /* JADX INFO: renamed from: n */
    public IBinder f16105n;

    /* JADX INFO: renamed from: o */
    public View f16106o;

    /* JADX INFO: renamed from: p */
    public View f16107p;

    /* JADX INFO: renamed from: q */
    public DragScroller f16108q;

    /* JADX INFO: renamed from: t */
    public DropTarget f16111t;

    /* JADX INFO: renamed from: u */
    public InputMethodManager f16112u;

    /* JADX INFO: renamed from: c */
    public Rect f16094c = new Rect();

    /* JADX INFO: renamed from: d */
    public int[] f16095d = new int[2];

    /* JADX INFO: renamed from: l */
    public ArrayList f16103l = new ArrayList();

    /* JADX INFO: renamed from: m */
    public ArrayList f16104m = new ArrayList();

    /* JADX INFO: renamed from: r */
    public int f16109r = 0;

    /* JADX INFO: renamed from: s */
    public RunnableC0416n f16110s = new RunnableC0416n(this);

    /* JADX INFO: renamed from: v */
    public int[] f16113v = new int[2];

    /* JADX INFO: renamed from: w */
    public long f16114w = -1;

    /* JADX INFO: renamed from: x */
    public int f16115x = 0;

    /* JADX INFO: renamed from: y */
    public int[] f16116y = new int[2];

    /* JADX INFO: renamed from: z */
    public Rect f16117z = new Rect();

    public DragController(Launcher launcher) {
        Resources resources = launcher.getResources();
        this.f16092a = launcher;
        this.f16093b = new Handler();
        this.mScrollZone = resources.getDimensionPixelSize(R.dimen.scroll_zone);
        this.f16091A = VelocityTracker.obtain();
        float f6 = resources.getDisplayMetrics().density;
        resources.getInteger(R.integer.config_flingToDeleteMinVelocity);
        this.f16096e = Utilities.isRtl(resources);
    }

    /* JADX INFO: renamed from: i */
    public static Bitmap getViewBitmap(DragLayer dragLayer) {
        dragLayer.clearFocus();
        dragLayer.setPressed(false);
        boolean zWillNotCacheDrawing = dragLayer.willNotCacheDrawing();
        dragLayer.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = dragLayer.getDrawingCacheBackgroundColor();
        dragLayer.setDrawingCacheBackgroundColor(0);
        float alpha = dragLayer.getAlpha();
        dragLayer.setAlpha(1.0f);
        if (drawingCacheBackgroundColor != 0) {
            dragLayer.destroyDrawingCache();
        }
        dragLayer.buildDrawingCache();
        Bitmap drawingCache = dragLayer.getDrawingCache();
        if (drawingCache == null) {
            dragLayer.toString();
            new RuntimeException();
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        dragLayer.destroyDrawingCache();
        dragLayer.setAlpha(alpha);
        dragLayer.setWillNotCacheDrawing(zWillNotCacheDrawing);
        dragLayer.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: a */
    public final void cancelDrag() {
        if (this.f16097f) {
            DropTarget dropTarget = this.f16111t;
            if (dropTarget != null) {
                dropTarget.mo7605B(this.f16102k);
            }
            DragObject dragObject = this.f16102k;
            dragObject.f16528l = false;
            dragObject.f16527k = true;
            dragObject.f16521e = true;
            dragObject.f16524h.mo7691F(null, dragObject, false);
        }
        releaseVelocityTracker();
    }

    /* JADX INFO: renamed from: b */
    public final void m7869b(int i6, int i7) {
        Launcher launcher = this.f16092a;
        int i8 = this.f16115x < ViewConfiguration.get(launcher).getScaledWindowTouchSlop() ? 900 : 500;
        DragLayer dragLayer = launcher.getDragLayer();
        boolean z5 = this.f16096e;
        int i9 = !z5 ? 1 : 0;
        Handler handler = this.f16093b;
        RunnableC0416n runnableC0416n = this.f16110s;
        int i10 = this.mScrollZone;
        if (i6 < i10) {
            if (this.f16109r == 0) {
                this.f16109r = 1;
                if (((Workspace) this.f16108q).e1(i6, i7, z5 ? 1 : 0)) {
                    dragLayer.onEnterScrollArea(z5 ? 1 : 0);
                    runnableC0416n.f1310k = z5 ? 1 : 0;
                    handler.postDelayed(runnableC0416n, i8);
                    return;
                }
                return;
            }
            return;
        }
        if (i6 <= this.f16106o.getWidth() - i10) {
            clearScrollRunnable();
            return;
        }
        if (this.f16109r == 0) {
            this.f16109r = 1;
            if (((Workspace) this.f16108q).e1(i6, i7, i9)) {
                dragLayer.onEnterScrollArea(i9);
                runnableC0416n.f1310k = i9;
                handler.postDelayed(runnableC0416n, i8);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void checkTouchMove(DropTarget dropTarget) {
        if (dropTarget != null) {
            DropTarget dropTarget2 = this.f16111t;
            if (dropTarget2 != dropTarget) {
                if (dropTarget2 != null) {
                    dropTarget2.mo7605B(this.f16102k);
                }
                dropTarget.mo7607b(this.f16102k);
            }
            dropTarget.mo7614z(this.f16102k);
        } else {
            DropTarget dropTarget3 = this.f16111t;
            if (dropTarget3 != null) {
                dropTarget3.mo7605B(this.f16102k);
            }
        }
        this.f16111t = dropTarget;
    }

    /* JADX INFO: renamed from: d */
    public final void clearScrollRunnable() {
        Handler handler = this.f16093b;
        RunnableC0416n runnableC0416n = this.f16110s;
        handler.removeCallbacks(runnableC0416n);
        if (this.f16109r == 1) {
            this.f16109r = 0;
            runnableC0416n.f1310k = 1;
            Workspace workspace = (Workspace) this.f16108q;
            if (workspace.f23448l1) {
                workspace.invalidate();
                CellLayout currentDropLayout = workspace.getCurrentDropLayout();
                workspace.setCurrentDropLayout(currentDropLayout);
                workspace.setCurrentDragOverlappingLayout(currentDropLayout);
                workspace.f23448l1 = false;
            }
            this.f16092a.getDragLayer().onExitScrollArea();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e */
    public final void drop(float f6, float f7) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int[] iArr = this.f16095d;
        DropTarget dropTargetFindDropTarget = findDropTarget((int) f6, (int) f7, iArr);
        DragObject dragObject = this.f16102k;
        boolean z5 = false;
        dragObject.f16517a = iArr[0];
        dragObject.f16518b = iArr[1];
        if (dropTargetFindDropTarget != null) {
            dragObject.f16521e = true;
            dropTargetFindDropTarget.mo7605B(dragObject);
            if (dropTargetFindDropTarget.mo7612u(this.f16102k)) {
                dropTargetFindDropTarget.mo7611s(this.f16102k);
                z5 = true;
            }
        }
        DragObject dragObject2 = this.f16102k;
        dragObject2.f16524h.mo7691F((View) dropTargetFindDropTarget, dragObject2, z5);
    }

    /* JADX INFO: renamed from: f */
    public final void releaseVelocityTracker() {
        boolean z5;
        if (this.f16097f) {
            int i6 = 0;
            this.f16097f = false;
            this.f16098g = false;
            clearScrollRunnable();
            DragObject dragObject = this.f16102k;
            DragView dragView = dragObject.f16522f;
            if (dragView != null) {
                z5 = dragObject.f16528l;
                if (!z5 && dragView.getParent() != null) {
                    dragView.f16482p.removeView(dragView);
                }
                this.f16102k.f16522f = null;
            } else {
                z5 = false;
            }
            if (!z5) {
                ArrayList arrayList = new ArrayList(this.f16104m);
                int size = arrayList.size();
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    ((DragListener) obj).mo905C();
                }
            }
        }
        VelocityTracker velocityTracker = this.f16091A;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f16091A = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: g */
    public final DropTarget findDropTarget(int i6, int i7, int[] iArr) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        ArrayList arrayList = this.f16103l;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DropTarget dropTarget = (DropTarget) arrayList.get(size);
            if (dropTarget.mo7608e()) {
                Rect rect = this.f16094c;
                dropTarget.mo7609g(rect);
                DragObject dragObject = this.f16102k;
                dragObject.f16517a = i6;
                dragObject.f16518b = i7;
                if (rect.contains(i6, i7)) {
                    iArr[0] = i6;
                    iArr[1] = i7;
                    this.f16092a.getDragLayer().mapCoordInSelfToDescendent((View) dropTarget, iArr);
                    return dropTarget;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public final int[] getClampedDragLayerPos(float f6, float f7) {
        DragLayer dragLayer = this.f16092a.getDragLayer();
        Rect rect = this.f16117z;
        dragLayer.getLocalVisibleRect(rect);
        int iMax = (int) Math.max(rect.left, Math.min(f6, rect.right - 1));
        int[] iArr = this.f16116y;
        iArr[0] = iMax;
        iArr[1] = (int) Math.max(rect.top, Math.min(f7, rect.bottom - 1));
        return iArr;
    }

    /* JADX INFO: renamed from: j */
    public final void handleMoveEvent(int i6, int i7) {
        DragView dragView = this.f16102k.f16522f;
        dragView.setTranslationX((i6 - dragView.f16478l) + ((int) dragView.f16485s));
        dragView.setTranslationY((i7 - dragView.f16479m) + ((int) dragView.f16486t));
        int[] iArr = this.f16095d;
        DropTarget dropTargetFindDropTarget = findDropTarget(i6, i7, iArr);
        DragObject dragObject = this.f16102k;
        dragObject.f16517a = iArr[0];
        dragObject.f16518b = iArr[1];
        checkTouchMove(dropTargetFindDropTarget);
        double d6 = this.f16115x;
        int[] iArr2 = this.f16113v;
        this.f16115x = (int) (Math.hypot(iArr2[0] - i6, iArr2[1] - i7) + d6);
        iArr2[0] = i6;
        iArr2[1] = i7;
        m7869b(i6, i7);
    }

    /* JADX INFO: renamed from: k */
    public final void onAppsRemoved(HashSet hashSet, HashSet hashSet2) {
        ComponentName component;
        DragObject dragObject = this.f16102k;
        if (dragObject != null) {
            Object obj = dragObject.f16523g;
            if (obj instanceof ShortcutInfo) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) obj;
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = (ComponentName) it.next();
                    Intent intent = shortcutInfo.f16553A;
                    if (intent != null && (component = intent.getComponent()) != null && (component.equals(componentName) || hashSet.contains(component.getPackageName()))) {
                        cancelDrag();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f16098g) {
            return false;
        }
        if (this.f16091A == null) {
            this.f16091A = VelocityTracker.obtain();
        }
        this.f16091A.addMovement(motionEvent);
        int action = motionEvent.getAction();
        int[] clampedDragLayerPos = getClampedDragLayerPos(motionEvent.getX(), motionEvent.getY());
        int i6 = clampedDragLayerPos[0];
        int i7 = clampedDragLayerPos[1];
        if (action == 0) {
            this.f16099h = i6;
            this.f16100i = i7;
            this.f16111t = null;
        } else if (action == 1) {
            this.f16114w = System.currentTimeMillis();
            if (this.f16097f) {
                DragObject dragObject = this.f16102k;
                DragSource dragSource = dragObject.f16524h;
                DeleteDropTarget.supportsDrop(dragObject.f16523g);
                drop(i6, i7);
            }
            releaseVelocityTracker();
        } else if (action == 3) {
            cancelDrag();
        }
        return this.f16097f;
    }

    /* JADX INFO: renamed from: m */
    public final DragView startDrag(Bitmap bitmap, int i6, int i7, DragSource dragSource, Object obj, int i8, Point point, Rect rect, float f6, boolean z5) {
        InputMethodManager inputMethodManager = this.f16112u;
        Launcher launcher = this.f16092a;
        if (inputMethodManager == null) {
            this.f16112u = (InputMethodManager) launcher.getSystemService("input_method");
        }
        this.f16112u.hideSoftInputFromWindow(this.f16105n, 0);
        ArrayList arrayList = this.f16104m;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj2 = arrayList.get(i9);
            i9++;
            ((DragListener) obj2).mo906E(dragSource, obj);
        }
        int i10 = this.f16099h - i6;
        int i11 = this.f16100i - i7;
        int i12 = rect == null ? 0 : rect.left;
        int i13 = rect == null ? 0 : rect.top;
        this.f16097f = true;
        this.f16098g = z5;
        DragObject dragObject = new DragObject();
        this.f16102k = dragObject;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        DragView dragView = new DragView(launcher);
        dragView.mDragVisualizeOffset = null;
        dragView.mDragRegion = null;
        dragView.f16482p = null;
        dragView.f16483q = false;
        dragView.f16485s = 0.0f;
        dragView.f16486t = 0.0f;
        dragView.mInitialScale = 1.0f;
        dragView.mIntrinsicIconScale = 1.0f;
        DragLayer dragLayer = launcher.getDragLayer();
        dragView.f16482p = dragLayer;
        dragView.mInitialScale = f6;
        int i14 = i12;
        float f7 = width;
        float dimensionPixelSize = (dragView.getResources().getDimensionPixelSize(R.dimen.dragViewScale) + f7) / f7;
        dragView.setScaleX(f6);
        dragView.setScaleY(f6);
        int i15 = i13;
        ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
        dragView.f16484r = valueAnimatorM7889c;
        valueAnimatorM7889c.setDuration(150L);
        valueAnimatorM7889c.addUpdateListener(new DragViewMoveUpdateListener(dragView, f6, dimensionPixelSize));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        dragView.f16476j = bitmapCreateBitmap;
        dragView.setDragRegion(new Rect(0, 0, width, height));
        dragView.f16478l = i10;
        dragView.f16479m = i11;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        dragView.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        dragView.f16477k = new Paint(2);
        if (Utilities.f16752m) {
            dragView.setElevation(dragView.getResources().getDimension(R.dimen.drag_elevation));
        }
        dragObject.f16522f = dragView;
        DragObject dragObject2 = this.f16102k;
        dragObject2.f16521e = false;
        if (this.f16098g) {
            dragObject2.f16519c = bitmap.getWidth() / 2;
            this.f16102k.f16520d = bitmap.getHeight() / 2;
            this.f16102k.f16525i = true;
        } else {
            dragObject2.f16519c = this.f16099h - (i6 + i14);
            dragObject2.f16520d = this.f16100i - (i7 + i15);
            dragObject2.f16529m = ((AccessibilityManager) dragView.getContext().getSystemService("accessibility")).isEnabled() ? new RunnableC0674C(1, dragView) : null;
        }
        DragObject dragObject3 = this.f16102k;
        dragObject3.f16524h = dragSource;
        dragObject3.f16523g = obj;
        if (point != null) {
            dragView.setDragVisualizeOffset(new Point(point));
        }
        if (rect != null) {
            dragView.setDragRegion(new Rect(rect));
        }
        launcher.getDragLayer().performHapticFeedback(0);
        int i16 = this.f16099h;
        int i17 = this.f16100i;
        dragLayer.addView(dragView);
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(0, 0);
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).width = bitmapCreateBitmap.getWidth();
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).height = bitmapCreateBitmap.getHeight();
        dragLayerLayoutParams.f16210d = true;
        dragView.setLayoutParams(dragLayerLayoutParams);
        dragView.setTranslationX(i16 - i10);
        dragView.setTranslationY(i17 - i11);
        dragView.post(new MergedUiRunnable(4, dragView));
        handleMoveEvent(this.f16099h, this.f16100i);
        return dragView;
    }

    /* JADX INFO: renamed from: n */
    public final void m7880n(View view, Bitmap bitmap, WidgetsContainerView widgetsContainerView, PendingAddItemInfo pendingAddItemInfo, Rect rect, float f6) {
        DragLayer dragLayer = this.f16092a.getDragLayer();
        int[] iArr = this.f16095d;
        dragLayer.getLocationInDragLayer(view, iArr);
        startDrag(bitmap, iArr[0] + rect.left + ((int) (((bitmap.getWidth() * f6) - bitmap.getWidth()) / 2.0f)), iArr[1] + rect.top + ((int) (((bitmap.getHeight() * f6) - bitmap.getHeight()) / 2.0f)), widgetsContainerView, pendingAddItemInfo, 1, null, null, f6, false);
    }
}
