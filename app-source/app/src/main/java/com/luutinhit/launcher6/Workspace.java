package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import B3.C0081x;
import C0.C0119k;
import G1.C0328n;
import G3.C0351g;
import J1.RunnableC0526l;
import M2.RunnableC0674C;
import O3.AbstractC0744e;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.WallpaperManager;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsList;
import com.luutinhit.launcherios.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.lsposed.hiddenapibypass.AbstractC2545h;
import p100l2.C2333e;
import p101l3.C2339d;
import p101l3.C2340e;
import p101l3.C2341f;
import p101l3.InterfaceC2338c;
import p122r3.C2673q;
import p131t3.ViewOnClickListenerC2791d;

/* JADX INFO: loaded from: classes.dex */
public class Workspace extends PagedView implements DropTarget, DragSource, DragScroller, View.OnTouchListener, DragListener, ViewGroup.OnHierarchyChangeListener, Insettable, UninstallSource, InterfaceC2338c, LaunchSourceProvider {

    /* JADX INFO: renamed from: O1 */
    public static Rect f23395O1;

    /* JADX INFO: renamed from: P1 */
    public static Rect f23396P1;

    /* JADX INFO: renamed from: A0 */
    public int f23397A0;

    /* JADX INFO: renamed from: A1 */
    public float f23398A1;

    /* JADX INFO: renamed from: B0 */
    public ShortcutAndWidgetContainer f23399B0;

    /* JADX INFO: renamed from: B1 */
    public int f23400B1;

    /* JADX INFO: renamed from: C0 */
    public C0081x f23401C0;

    /* JADX INFO: renamed from: C1 */
    public int f23402C1;

    /* JADX INFO: renamed from: D0 */
    public ArrayList f23403D0;

    /* JADX INFO: renamed from: D1 */
    public int f23404D1;

    /* JADX INFO: renamed from: E0 */
    public MergedLoaderRunnable f23405E0;

    /* JADX INFO: renamed from: E1 */
    public SparseArray f23406E1;

    /* JADX INFO: renamed from: F0 */
    public boolean f23407F0;

    /* JADX INFO: renamed from: F1 */
    public ArrayList f23408F1;

    /* JADX INFO: renamed from: G0 */
    public boolean mAddNewPageOnDrag;

    /* JADX INFO: renamed from: G1 */
    public DropCompleteRunnable f23410G1;

    /* JADX INFO: renamed from: H0 */
    public CellInfo mDragInfo;

    /* JADX INFO: renamed from: H1 */
    public boolean f23412H1;

    /* JADX INFO: renamed from: I0 */
    public DeviceProfile grid;

    /* JADX INFO: renamed from: I1 */
    public boolean f23414I1;

    /* JADX INFO: renamed from: J0 */
    public int[] f23415J0;

    /* JADX INFO: renamed from: J1 */
    public float f23416J1;

    /* JADX INFO: renamed from: K0 */
    public int f23417K0;

    /* JADX INFO: renamed from: K1 */
    public WorkspaceStateTransitionAnimation f23418K1;

    /* JADX INFO: renamed from: L0 */
    public int f23419L0;

    /* JADX INFO: renamed from: L1 */
    public C2340e f23420L1;

    /* JADX INFO: renamed from: M0 */
    public AppsLibraryProgressCallback mCustomContentCallbacks;

    /* JADX INFO: renamed from: M1 */
    public WorkspaceDropRunnable f23422M1;

    /* JADX INFO: renamed from: N0 */
    public AppsLibraryProgressCallback f23423N0;

    /* JADX INFO: renamed from: N1 */
    public DecelerateInterpolator f23424N1;

    /* JADX INFO: renamed from: O0 */
    public boolean f23425O0;

    /* JADX INFO: renamed from: P0 */
    public boolean f23426P0;

    /* JADX INFO: renamed from: Q0 */
    public float f23427Q0;

    /* JADX INFO: renamed from: R0 */
    public String f23428R0;

    /* JADX INFO: renamed from: S0 */
    public CellLayout f23429S0;

    /* JADX INFO: renamed from: T0 */
    public CellLayout f23430T0;

    /* JADX INFO: renamed from: U0 */
    public CellLayout f23431U0;

    /* JADX INFO: renamed from: V0 */
    public Launcher f23432V0;

    /* JADX INFO: renamed from: W0 */
    public IconCache f23433W0;

    /* JADX INFO: renamed from: X0 */
    public DragController f23434X0;

    /* JADX INFO: renamed from: Y0 */
    public int[] f23435Y0;

    /* JADX INFO: renamed from: Z0 */
    public int[] f23436Z0;

    /* JADX INFO: renamed from: a1 */
    public float[] f23437a1;

    /* JADX INFO: renamed from: b1 */
    public float[] f23438b1;

    /* JADX INFO: renamed from: c1 */
    public Matrix f23439c1;

    /* JADX INFO: renamed from: d1 */
    public Matrix f23440d1;

    /* JADX INFO: renamed from: e1 */
    public C2333e f23441e1;

    /* JADX INFO: renamed from: f1 */
    public float mSpringLoadedShrinkFactor;

    /* JADX INFO: renamed from: g1 */
    public float f23443g1;

    /* JADX INFO: renamed from: h1 */
    public WorkspaceState mState;

    /* JADX INFO: renamed from: i1 */
    public boolean f23445i1;

    /* JADX INFO: renamed from: j1 */
    public boolean f23446j1;

    /* JADX INFO: renamed from: k1 */
    public boolean f23447k1;

    /* JADX INFO: renamed from: l1 */
    public boolean f23448l1;
    public int[] m1;

    /* JADX INFO: renamed from: n1 */
    public int[] f23449n1;
    public boolean o1;

    /* JADX INFO: renamed from: p1 */
    public B3.b0 f23450p1;

    /* JADX INFO: renamed from: q1 */
    public RunnableC0031a f23451q1;
    public Alarm r1;

    /* JADX INFO: renamed from: s1 */
    public Alarm f23452s1;

    /* JADX INFO: renamed from: t1 */
    public FolderRingAnimator f23453t1;

    /* JADX INFO: renamed from: u1 */
    public FolderIcon f23454u1;

    /* JADX INFO: renamed from: v1 */
    public boolean f23455v1;

    /* JADX INFO: renamed from: w0 */
    public LayoutTransition f23456w0;

    /* JADX INFO: renamed from: w1 */
    public boolean f23457w1;

    /* JADX INFO: renamed from: x0 */
    public WallpaperManager f23458x0;

    /* JADX INFO: renamed from: x1 */
    public float f23459x1;

    /* JADX INFO: renamed from: y0 */
    public IBinder f23460y0;

    /* JADX INFO: renamed from: y1 */
    public Canvas mCanvas;

    /* JADX INFO: renamed from: z0 */
    public int f23462z0;

    /* JADX INFO: renamed from: z1 */
    public float f23463z1;

    static {
        new Rect();
    }

    public Workspace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23401C0 = new C0081x();
        this.f23403D0 = new ArrayList();
        this.f23407F0 = false;
        this.mAddNewPageOnDrag = true;
        this.f23415J0 = new int[2];
        this.f23417K0 = -1;
        this.f23419L0 = -1;
        this.f23427Q0 = -1.0f;
        this.f23428R0 = "Widgets page";
        this.f23429S0 = null;
        this.f23430T0 = null;
        this.f23431U0 = null;
        this.f23435Y0 = new int[2];
        this.f23436Z0 = new int[2];
        this.f23437a1 = new float[2];
        this.f23438b1 = new float[2];
        this.f23439c1 = new Matrix();
        this.f23440d1 = new Matrix();
        this.mState = WorkspaceState.f15305k;
        this.f23445i1 = false;
        this.f23446j1 = true;
        this.f23447k1 = false;
        this.f23448l1 = false;
        this.m1 = new int[2];
        this.f23449n1 = new int[2];
        Point point = new Point();
        this.r1 = new Alarm();
        this.f23452s1 = new Alarm();
        this.f23453t1 = null;
        this.f23454u1 = null;
        this.f23455v1 = false;
        this.f23457w1 = false;
        this.mCanvas = new Canvas();
        this.f23400B1 = 0;
        this.f23402C1 = -1;
        this.f23404D1 = -1;
        this.f23408F1 = new ArrayList();
        this.f23422M1 = new WorkspaceDropRunnable(this, 0);
        this.f23424N1 = new DecelerateInterpolator(3.0f);
        Launcher launcher = (Launcher) context;
        this.f23432V0 = launcher;
        this.f23418K1 = new WorkspaceStateTransitionAnimation(launcher, this);
        Resources resources = getResources();
        DeviceProfile deviceProfile = launcher.getDeviceProfile();
        this.grid = deviceProfile;
        this.o1 = deviceProfile.f16003c;
        this.f23458x0 = WallpaperManager.getInstance(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2236G, 0, 0);
        this.mSpringLoadedShrinkFactor = resources.getInteger(R.integer.config_workspaceSpringLoadShrinkPercentage) / 100.0f;
        float integer = resources.getInteger(R.integer.config_workspaceOverviewShrinkPercentage) / 100.0f;
        this.f23443g1 = integer;
        int i6 = typedArrayObtainStyledAttributes.getInt(2, 1);
        this.f23397A0 = i6;
        this.f23462z0 = i6;
        typedArrayObtainStyledAttributes.recycle();
        setOnHierarchyChangeListener(this);
        setHapticFeedbackEnabled(false);
        this.mCurrentPage = this.f23397A0;
        this.f23433W0 = LauncherAppState.getInstance().f16219b;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        setChildrenDrawnWithCacheEnabled(true);
        setMinScale(integer);
        LayoutTransition layoutTransition = new LayoutTransition();
        this.f23456w0 = layoutTransition;
        layoutTransition.enableTransitionType(3);
        this.f23456w0.enableTransitionType(1);
        this.f23456w0.disableTransitionType(2);
        this.f23456w0.disableTransitionType(0);
        setLayoutTransition(this.f23456w0);
        this.f23450p1 = new B3.b0(this);
        launcher.getWindowManager().getDefaultDisplay().getSize(point);
        this.f23459x1 = deviceProfile.f15978D * 0.55f;
        Utilities.f16756q.execute(new MergedIdleRunnable(11, this));
        setMotionEventSplittingEnabled(true);
    }

    public static void G0(View view, Canvas canvas, int i6) {
        Objects.toString(view);
        Objects.toString(canvas);
        canvas.save();
        float f6 = i6 / 2.0f;
        canvas.translate((-view.getScrollX()) + f6, (-view.getScrollY()) + f6);
        view.draw(canvas);
        canvas.restore();
    }

    public static int[] L0(int i6, int i7, int i8, int i9, CellLayout cellLayout, int[] iArr) {
        Objects.toString(cellLayout);
        return cellLayout.findNearestArea(i6, i7, i8, i9, i8, i9, false, iArr, null);
    }

    public static Rect M0(int i6, Launcher launcher) {
        Objects.toString(launcher);
        InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
        Display defaultDisplay = launcher.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getCurrentSizeRange(point, point2);
        int i7 = invariantDeviceProfile.f16712d;
        Utilities.isRtl(launcher.getResources());
        int i8 = invariantDeviceProfile.f16711c;
        if (i6 == 0) {
            if (f23395O1 == null) {
                Rect rectM7812d = invariantDeviceProfile.f16725q.m7812d();
                int i9 = (point2.x - rectM7812d.left) - rectM7812d.right;
                int i10 = (point.y - rectM7812d.top) - rectM7812d.bottom;
                Rect rect = new Rect();
                f23395O1 = rect;
                rect.set(i9 / i7, i10 / i8, 0, 0);
            }
            return f23395O1;
        }
        if (i6 != 1) {
            return null;
        }
        if (f23396P1 == null) {
            Rect rectM7812d2 = invariantDeviceProfile.f16726r.m7812d();
            int i11 = (point.x - rectM7812d2.left) - rectM7812d2.right;
            int i12 = (point2.y - rectM7812d2.top) - rectM7812d2.bottom;
            Rect rect2 = new Rect();
            f23396P1 = rect2;
            rect2.set(i11 / i7, i12 / i8, 0, 0);
        }
        return f23396P1;
    }

    public static void b1(View view, float[] fArr, Matrix matrix) {
        Objects.toString(view);
        Objects.toString(matrix);
        fArr[0] = fArr[0] - view.getLeft();
        fArr[1] = fArr[1] - view.getTop();
    }

    public int getNumLeftCustomPages() {
        return U0() ? 1 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    public static boolean r1(View view, Object obj) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        FolderIcon folderIcon;
        Objects.toString(obj);
        Objects.toString(view);
        if (view != null) {
            CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
            if (!cellLayoutLayoutParams.f15689e || (cellLayoutLayoutParams.f15687c == cellLayoutLayoutParams.f15685a && cellLayoutLayoutParams.f15688d == cellLayoutLayoutParams.f15686b)) {
                if (view instanceof FolderIcon) {
                    folderIcon = (FolderIcon) view;
                    folderIcon.getClass();
                    Objects.toString(obj);
                    ItemInfo itemInfo = (ItemInfo) obj;
                    if (folderIcon.mFolder.f15617T && folderIcon.m7725m(itemInfo)) {
                        return true;
                    }
                }
            }
        } else if (view instanceof FolderIcon) {
            folderIcon = (FolderIcon) view;
            folderIcon.getClass();
            Objects.toString(obj);
            ItemInfo itemInfo2 = (ItemInfo) obj;
            if (folderIcon.mFolder.f15617T) {
            }
        }
        return false;
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: A */
    public final void mo7850A(MotionEvent motionEvent) {
        View childAt;
        Objects.toString(motionEvent);
        float x6 = motionEvent.getX() - this.f23463z1;
        float y4 = motionEvent.getY() - this.f23398A1;
        float fAbs = Math.abs(x6);
        float fAbs2 = Math.abs(y4);
        if (Float.compare(fAbs, 0.0f) == 0) {
            return;
        }
        float fAtan = (float) Math.atan(fAbs2 / fAbs);
        float f6 = this.f16067Q;
        if ((fAbs > f6 || fAbs2 > f6) && (childAt = getChildAt(this.mCurrentPage)) != null) {
            childAt.cancelLongPress();
        }
        S0(getCurrentPage());
        S0(getCurrentPage());
        if (fAtan > 1.0471976f) {
            return;
        }
        if (fAtan > 0.5235988f) {
            super.mo7851G(motionEvent, (((float) Math.sqrt((fAtan - 0.5235988f) / 0.5235988f)) * 4.0f) + 1.0f);
        } else {
            super.mo7850A(motionEvent);
        }
    }

    public final void A0() {
        FolderRingAnimator folderRingAnimator = this.f23453t1;
        if (folderRingAnimator != null) {
            folderRingAnimator.animateToNaturalState();
            this.f23453t1 = null;
        }
        Alarm alarm = this.r1;
        alarm.f16206m = null;
        alarm.cancelAlarm();
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: B */
    public final void mo7605B(DragObject dragObject) {
        Objects.toString(dragObject);
        if (!this.f23448l1) {
            this.f23431U0 = this.f23429S0;
        } else if (this.f23377a0) {
            this.f23431U0 = (CellLayout) getChildAt(getNextPage());
        } else {
            this.f23431U0 = this.f23430T0;
        }
        int i6 = this.f23400B1;
        if (i6 == 1) {
            this.f23455v1 = true;
        } else if (i6 == 2) {
            this.f23457w1 = true;
        }
        setCurrentDragOverlappingLayout(null);
        this.f23448l1 = false;
        setCurrentDropLayout(null);
        setCurrentDragOverlappingLayout(null);
        ((Alarm) this.f23441e1.f19377k).cancelAlarm();
        this.f23432V0.getDragLayer().hidePageHints();
    }

    public final void B0(boolean z5) {
        if (z5) {
            this.f23452s1.cancelAlarm();
        }
        this.f23402C1 = -1;
        this.f23404D1 = -1;
    }

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: C */
    public final void mo905C() {
        if (!this.f23407F0) {
            i1(true, null, 0, this.f23399B0 != null);
        }
        p1(false);
        Launcher launcher = this.f23432V0;
        launcher.unlockScreenOrientation(false);
        Context context = getContext();
        InstallShortcutReceiver.f15736b = false;
        InstallShortcutReceiver.flushInstallQueue(context);
        this.f23399B0 = null;
        launcher.onInteractionEnd();
    }

    public final long C0() {
        Launcher launcher = this.f23432V0;
        if (launcher.isWorkspaceLoading()) {
            Launcher.addDumpLog("Workspace", "    - workspace loading, skip", true);
            return -1L;
        }
        int iQ0 = Q0(-201L);
        C0081x c0081x = this.f23401C0;
        CellLayout cellLayout = (CellLayout) c0081x.get(-201L);
        c0081x.remove(-201L);
        ArrayList arrayList = this.f23403D0;
        arrayList.remove((Object) (-201L));
        long jGenerateNewScreenId = LauncherAppState.getLauncherProvider().f15839k.generateNewScreenId();
        c0081x.put(jGenerateNewScreenId, cellLayout);
        arrayList.add(Long.valueOf(jGenerateNewScreenId));
        q1();
        if (getPageIndicator() != null) {
            getPageIndicator().mo7790i(iQ0, mo7727N(iQ0));
        }
        launcher.getModel().getClass();
        LauncherModel.updateWorkspaceScreenOrder(launcher, arrayList);
        return jGenerateNewScreenId;
    }

    @Override // com.luutinhit.launcher6.LaunchSourceProvider
    /* JADX INFO: renamed from: D */
    public final void mo7690D(View view, Bundle bundle) {
        Objects.toString(view);
        Objects.toString(bundle);
        bundle.putString("container", "homescreen");
        bundle.putInt("container_page", getCurrentPage());
    }

    public final void D0(int i6) {
        CellLayout cellLayout = (CellLayout) this.f23432V0.getLayoutInflater().inflate(R.layout.workspace_screen, (ViewGroup) this, false);
        cellLayout.f15477r = false;
        cellLayout.f15478s = false;
        long j6 = i6 == 0 ? -301L : -302L;
        this.f23401C0.put(j6, cellLayout);
        ArrayList arrayList = this.f23403D0;
        if (i6 == 0) {
            arrayList.add(0, Long.valueOf(j6));
        } else {
            arrayList.add(arrayList.size(), Long.valueOf(j6));
        }
        int i7 = this.grid.f15977C;
        cellLayout.setPadding(i7, 0, i7, 0);
        m7865v(cellLayout, i6);
        if (i6 == 0) {
            this.f23397A0 = this.f23462z0 + 1;
            int i8 = this.mRestorePage;
            if (i8 != -1001) {
                this.mRestorePage = i8 + 1;
            } else {
                setCurrentPage(getCurrentPage() + 1);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0045 A[PHI: r5
  0x0045: PHI (r5v2 boolean) = (r5v1 boolean), (r5v12 boolean) binds: [B:5:0x0020, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: E */
    public final void mo906E(DragSource dragSource, Object obj) {
        boolean z5;
        Objects.toString(dragSource);
        Objects.toString(obj);
        boolean z6 = false;
        p1(false);
        Launcher launcher = this.f23432V0;
        launcher.lockScreenOrientation();
        launcher.onInteractionBegin();
        InstallShortcutReceiver.f15736b = true;
        if (this.mAddNewPageOnDrag) {
            this.f23407F0 = false;
            this.f23405E0 = null;
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.f23399B0;
            if (shortcutAndWidgetContainer == null) {
                z5 = false;
            } else {
                z6 = shortcutAndWidgetContainer.getChildCount() == 1;
                if (indexOfChild((CellLayout) this.f23399B0.getParent()) == getChildCount() - d1()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            }
            if ((z6 && z5) || this.f23401C0.m201f(-201L)) {
                return;
            }
            W0(this.f23403D0.contains(-302L) ? getChildCount() - 1 : getChildCount(), -201L);
        }
    }

    public final Bitmap E0(View view, AtomicInteger atomicInteger) {
        Objects.toString(view);
        Objects.toString(atomicInteger);
        int i6 = atomicInteger.get();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth() + i6, view.getHeight() + i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = this.mCanvas;
        canvas.setBitmap(bitmapCreateBitmap);
        G0(view, canvas, i6);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: F */
    public final void mo7691F(View view, DragObject dragObject, boolean z5) {
        CellInfo cellInfo;
        Objects.toString(view);
        Objects.toString(dragObject);
        if (this.f23412H1) {
            this.f23410G1 = new DropCompleteRunnable(this, view, dragObject, z5, 1);
            return;
        }
        boolean z6 = this.f23410G1 != null;
        if (!z5 || (z6 && !this.f23414I1)) {
            CellInfo cellInfo2 = this.mDragInfo;
            if (cellInfo2 != null) {
                CellLayout cellLayout = this.f23432V0.getCellLayout(cellInfo2.f15562g, cellInfo2.f15561f);
                if (cellLayout != null) {
                    cellLayout.onDropChild(this.mDragInfo.f15556a);
                } else {
                    WeakReference weakReference = LauncherAppState.f16215h;
                }
            }
        } else if (view != this && (cellInfo = this.mDragInfo) != null) {
            l1(cellInfo.f15556a);
        }
        if (dragObject.f16527k || (z6 && !this.f23414I1)) {
            this.mDragInfo.f15556a.setVisibility(0);
        }
        this.mDragInfo = null;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0040  */
    public final boolean F0(View view, long j6, CellLayout cellLayout, int[] iArr, float f6, boolean z5, DragView dragView, WorkspaceDropRunnable workspaceDropRunnable) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z6;
        Objects.toString(view);
        Objects.toString(cellLayout);
        Objects.toString(dragView);
        Objects.toString(workspaceDropRunnable);
        if (f6 <= this.f23459x1) {
            View childAt = cellLayout.mShortcutsAndWidgets.getChildAt(iArr[0], iArr[1]);
            CellInfo cellInfo = this.mDragInfo;
            if (cellInfo != null) {
                CellLayout cellLayoutR0 = R0(cellInfo.f15556a);
                CellInfo cellInfo2 = this.mDragInfo;
                if (cellInfo2.f15557b == iArr[0] && cellInfo2.f15558c == iArr[1] && cellLayoutR0 == cellLayout) {
                    z6 = true;
                } else {
                    z6 = false;
                }
            } else {
                z6 = false;
            }
            if (childAt != null && !z6 && this.f23455v1) {
                this.f23455v1 = false;
                long jO0 = O0(cellLayout);
                boolean z7 = childAt.getTag() instanceof ShortcutInfo;
                boolean z8 = view.getTag() instanceof ShortcutInfo;
                if (z7 && z8) {
                    ShortcutInfo shortcutInfo = (ShortcutInfo) view.getTag();
                    ShortcutInfo shortcutInfo2 = (ShortcutInfo) childAt.getTag();
                    if (!z5) {
                        R0(this.mDragInfo.f15556a).removeView(this.mDragInfo.f15556a);
                    }
                    Rect rect = new Rect();
                    float descendantRectRelativeToSelf = this.f23432V0.getDragLayer().getDescendantRectRelativeToSelf(childAt, rect);
                    cellLayout.removeView(childAt);
                    FolderIcon folderIconAddFolder = this.f23432V0.addFolder(cellLayout, j6, jO0, iArr[0], iArr[1]);
                    shortcutInfo2.cellX = -1;
                    shortcutInfo2.cellY = -1;
                    shortcutInfo.cellX = -1;
                    shortcutInfo.cellY = -1;
                    if (dragView == null) {
                        folderIconAddFolder.getClass();
                        Objects.toString(shortcutInfo2);
                        folderIconAddFolder.mInfo.add(shortcutInfo2);
                        Objects.toString(shortcutInfo);
                        folderIconAddFolder.mInfo.add(shortcutInfo);
                        return true;
                    }
                    folderIconAddFolder.getClass();
                    Objects.toString(shortcutInfo2);
                    Objects.toString(childAt);
                    Objects.toString(shortcutInfo);
                    Objects.toString(dragView);
                    Objects.toString(rect);
                    Objects.toString(workspaceDropRunnable);
                    Drawable drawableM7717i = FolderIcon.m7717i((BubbleTextView) childAt);
                    drawableM7717i.getIntrinsicWidth();
                    folderIconAddFolder.m7719c(childAt.getMeasuredWidth());
                    folderIconAddFolder.m7718b(drawableM7717i, 350, false, null);
                    Objects.toString(shortcutInfo2);
                    folderIconAddFolder.mInfo.add(shortcutInfo2);
                    folderIconAddFolder.onDrop(shortcutInfo, dragView, rect, descendantRectRelativeToSelf, 1, workspaceDropRunnable, null);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: G */
    public final void mo7851G(MotionEvent motionEvent, float f6) {
        Objects.toString(motionEvent);
        super.mo7851G(motionEvent, 1.0f);
    }

    public final void H0(int i6, int i7) {
        if (i6 > i7) {
            i7 = i6;
            i6 = i7;
        }
        int childCount = getChildCount();
        int iMin = Math.min(i7, childCount - 1);
        for (int iMax = Math.max(i6, 0); iMax <= iMin; iMax++) {
            CellLayout cellLayout = (CellLayout) getChildAt(iMax);
            cellLayout.setChildrenDrawnWithCacheEnabled(true);
            cellLayout.setChildrenDrawingCacheEnabled(true);
        }
    }

    public final void I0() {
        if (this.f23446j1) {
            int childCount = getChildCount();
            int[] iArr = this.f23449n1;
            getVisiblePages(iArr);
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (i6 == i7) {
                if (i7 < childCount - 1) {
                    i7++;
                } else if (i6 > 0) {
                    i6--;
                }
            }
            CellLayout cellLayout = (CellLayout) this.f23401C0.get(-301L);
            int i8 = 0;
            while (i8 < childCount) {
                CellLayout cellLayout2 = (CellLayout) getChildAt(i8);
                boolean z5 = cellLayout2 != cellLayout && i6 <= i8 && i8 <= i7 && j0(cellLayout2);
                cellLayout2.getClass();
                cellLayout2.mShortcutsAndWidgets.setLayerType(z5 ? 2 : 0, CellLayout.f23325b0);
                i8++;
            }
        }
    }

    public final int[] J0(ItemInfo itemInfo, boolean z5) {
        Objects.toString(itemInfo);
        int[] iArr = new int[2];
        if (getChildCount() <= 0) {
            iArr[0] = Integer.MAX_VALUE;
            iArr[1] = Integer.MAX_VALUE;
            return iArr;
        }
        CellLayout cellLayout = (CellLayout) getChildAt(d1());
        int i6 = itemInfo.spanX;
        int i7 = itemInfo.spanY;
        Objects.toString(cellLayout);
        Rect rect = new Rect();
        cellLayout.cellToRect(0, 0, i6, i7, rect);
        iArr[0] = rect.width();
        int iHeight = rect.height();
        iArr[1] = iHeight;
        if (z5) {
            int i8 = iArr[0];
            int i9 = (int) this.mSpringLoadedShrinkFactor;
            iArr[0] = i8 * i9;
            iArr[1] = iHeight * i9;
        }
        return iArr;
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: K */
    public final void mo7855K(int[] iArr) {
        int iD1 = d1();
        int childCount = getChildCount() - 1;
        iArr[0] = Math.max(0, Math.min(iD1, getChildCount() - 1));
        iArr[1] = Math.max(0, childCount);
    }

    public final void K0(int i6, boolean z5, Runnable runnable) {
        Objects.toString(runnable);
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("alpha", 0.0f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("backgroundAlpha", 0.0f);
        CellLayout cellLayout = (CellLayout) this.f23401C0.get(-201L);
        this.f23405E0 = new MergedLoaderRunnable(this, cellLayout, z5);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(cellLayout, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        objectAnimatorOfPropertyValuesHolder.setDuration(150);
        objectAnimatorOfPropertyValuesHolder.setStartDelay(i6);
        objectAnimatorOfPropertyValuesHolder.addListener(new C0119k(6, this, runnable));
        objectAnimatorOfPropertyValuesHolder.start();
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: N */
    public final PageIndicatorState mo7727N(int i6) {
        if (S0(i6) == -201 && this.f23403D0.size() - d1() > 1) {
            return new PageIndicatorState(2131231065);
        }
        PageIndicatorState pageIndicatorState = new PageIndicatorState();
        pageIndicatorState.f15905a = R.drawable.ic_indicator_current;
        return pageIndicatorState;
    }

    public final View N0(ItemOperator itemOperator) {
        Objects.toString(itemOperator);
        View[] viewArr = new View[1];
        a1(false, new Partner(5, itemOperator, viewArr));
        return viewArr[0];
    }

    public final long O0(CellLayout cellLayout) {
        Objects.toString(cellLayout);
        C0081x c0081x = this.f23401C0;
        int iIndexOfValue = c0081x.indexOfValue(cellLayout);
        if (iIndexOfValue != -1) {
            return c0081x.keyAt(iIndexOfValue);
        }
        return -1L;
    }

    public final String P0(int i6) {
        int iD1 = d1();
        int childCount = getChildCount() - iD1;
        int iIndexOf = this.f23403D0.indexOf(-201L);
        if (iIndexOf >= 0 && childCount > 1) {
            if (i6 == iIndexOf) {
                return getContext().getString(R.string.workspace_new_page);
            }
            childCount--;
        }
        return childCount == 0 ? getContext().getString(R.string.all_apps_home_button_label) : getContext().getString(R.string.workspace_scroll_format, Integer.valueOf((i6 + 1) - iD1), Integer.valueOf(childCount));
    }

    public final int Q0(long j6) {
        return indexOfChild((View) this.f23401C0.get(j6));
    }

    public final CellLayout R0(View view) {
        Objects.toString(view);
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts = getWorkspaceAndHotseatCellLayouts();
        int size = workspaceAndHotseatCellLayouts.size();
        int i6 = 0;
        while (i6 < size) {
            CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i6);
            i6++;
            CellLayout cellLayout2 = cellLayout;
            if (cellLayout2.getShortcutsAndWidgets().indexOfChild(view) > -1) {
                return cellLayout2;
            }
        }
        return null;
    }

    public final long S0(int i6) {
        if (i6 < 0) {
            return -1L;
        }
        ArrayList arrayList = this.f23403D0;
        if (i6 < arrayList.size()) {
            return ((Long) arrayList.get(i6)).longValue();
        }
        return -1L;
    }

    public final CellLayout T0(long j6) {
        return (CellLayout) this.f23401C0.get(j6);
    }

    public final boolean U0() {
        ArrayList arrayList = this.f23403D0;
        return arrayList.contains(-301L) || arrayList.contains(-302L);
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: V */
    public final void mo7728V() {
        PageSwitchListener pageSwitchListener = this.f16073W;
        if (pageSwitchListener != null) {
            pageSwitchListener.onPageSwitch(mo7726M(getNextPage()), getNextPage());
        }
        PageIndicator pageIndicator = this.mPageIndicator;
        if (pageIndicator != null) {
            pageIndicator.setContentDescription(getPageIndicatorDescription());
            if (!this.f23390n0) {
                this.mPageIndicator.setActiveMarker(getNextPage());
            }
        }
        if (U0()) {
            int nextPage = getNextPage();
            int childCount = getChildCount() - 1;
            if ((nextPage == 0) != this.f23425O0) {
                boolean z5 = nextPage == 0;
                this.f23425O0 = z5;
                AppsLibraryProgressCallback appsLibraryProgressCallback = this.mCustomContentCallbacks;
                if (appsLibraryProgressCallback != null) {
                    if (z5) {
                        appsLibraryProgressCallback.mo7796b(false);
                    } else {
                        appsLibraryProgressCallback.mo7797e();
                    }
                }
            }
            if ((nextPage == childCount) != this.f23426P0) {
                boolean z6 = nextPage == childCount;
                this.f23426P0 = z6;
                AppsLibraryProgressCallback appsLibraryProgressCallback2 = this.f23423N0;
                if (appsLibraryProgressCallback2 != null) {
                    if (z6) {
                        appsLibraryProgressCallback2.mo7796b(false);
                    } else {
                        appsLibraryProgressCallback2.mo7797e();
                    }
                }
            }
        }
    }

    public final boolean V0() {
        return this.f23401C0.m201f(-201L) && getChildCount() - d1() > 1;
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: W */
    public final void mo7861W() {
        this.f23390n0 = false;
        Launcher launcher = this.f23432V0;
        if (launcher.isWorkspaceLoading()) {
            return;
        }
        ArrayList arrayList = this.f23403D0;
        arrayList.clear();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            arrayList.add(Long.valueOf(O0((CellLayout) getChildAt(i6))));
        }
        q1();
        launcher.getModel().getClass();
        LauncherModel.updateWorkspaceScreenOrder(launcher, arrayList);
        setLayoutTransition(this.f23456w0);
    }

    public final void W0(int i6, long j6) {
        C0081x c0081x = this.f23401C0;
        if (c0081x.m201f(j6)) {
            throw new RuntimeException("Screen id " + j6 + " already exists!");
        }
        Launcher launcher = this.f23432V0;
        CellLayout cellLayout = (CellLayout) launcher.getLayoutInflater().inflate(R.layout.workspace_screen, (ViewGroup) this, false);
        DeviceProfile deviceProfile = this.grid;
        int i7 = deviceProfile.f15977C;
        cellLayout.setPadding(i7, deviceProfile.f16006f ? i7 : 0, i7, 0);
        cellLayout.setOnLongClickListener(this.f16066P);
        cellLayout.setOnClickListener(launcher);
        cellLayout.setSoundEffectsEnabled(false);
        c0081x.put(j6, cellLayout);
        this.f23403D0.add(i6, Long.valueOf(j6));
        addView(cellLayout, i6);
        C2339d c2339d = LauncherAppState.getInstance().f16223f;
        if (c2339d == null || c2339d.f19394l == null) {
            return;
        }
        cellLayout.enableAccessibleDrag(2, true);
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: X */
    public final void mo7729X() {
        if (isHardwareAccelerated()) {
            p1(false);
        } else {
            int i6 = this.f16085u;
            if (i6 != -1) {
                H0(this.mCurrentPage, i6);
            } else {
                int i7 = this.mCurrentPage;
                H0(i7 - 1, i7 + 1);
            }
        }
        getPageIndicator().mo7785d();
    }

    public final boolean X0() {
        Objects.toString(this.mState);
        return this.mState == WorkspaceState.f15309o;
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: Y */
    public final void mo7862Y() {
        this.f23378b0 = false;
        if (isHardwareAccelerated()) {
            p1(false);
        } else {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                CellLayout cellLayout = (CellLayout) getChildAt(i6);
                cellLayout.setChildrenDrawnWithCacheEnabled(false);
                if (!isHardwareAccelerated()) {
                    cellLayout.setChildrenDrawingCacheEnabled(false);
                }
            }
        }
        if (this.f23434X0.f16097f && t1()) {
            DragController dragController = this.f23434X0;
            int[] iArr = dragController.f16113v;
            int i7 = iArr[0];
            int i8 = iArr[1];
            int[] iArr2 = dragController.f16095d;
            DropTarget dropTargetFindDropTarget = dragController.findDropTarget(i7, i8, iArr2);
            DragObject dragObject = dragController.f16102k;
            dragObject.f16517a = iArr2[0];
            dragObject.f16518b = iArr2[1];
            dragController.checkTouchMove(dropTargetFindDropTarget);
        }
        RunnableC0031a runnableC0031a = this.f23451q1;
        if (runnableC0031a != null) {
            runnableC0031a.run();
            this.f23451q1 = null;
        }
        if (this.f23447k1) {
            n1();
            this.f23447k1 = false;
        }
        if (this.f23432V0.isShaking()) {
            return;
        }
        getPageIndicator().mo7789h();
    }

    public final boolean Y0() {
        int nextPage = getNextPage();
        if (this.mRestorePage != -1001) {
            return false;
        }
        ArrayList arrayList = this.f23403D0;
        int iIndexOf = arrayList.indexOf(-301L);
        int iIndexOf2 = arrayList.indexOf(-302L);
        if (iIndexOf != nextPage || iIndexOf == -1) {
            return iIndexOf2 == nextPage && iIndexOf2 != -1;
        }
        return true;
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: Z */
    public final void mo7863Z() {
    }

    public final boolean Z0(int i6, int i7, Rect rect) {
        Objects.toString(rect);
        int[] iArr = this.f23436Z0;
        iArr[0] = i6;
        iArr[1] = i7;
        this.f23432V0.getDragLayer().getDescendantCoordRelativeToSelf(this, iArr, true);
        DeviceProfile deviceProfile = this.grid;
        deviceProfile.getClass();
        return new Rect(0, deviceProfile.f16013m - deviceProfile.f15995U, deviceProfile.f16012l, Integer.MAX_VALUE).contains(iArr[0], iArr[1]);
    }

    @Override // com.luutinhit.launcher6.UninstallSource
    /* JADX INFO: renamed from: a */
    public final void mo7709a() {
        this.f23412H1 = true;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final void a0() {
    }

    public final void a1(boolean z5, ItemOperator itemOperator) {
        Objects.toString(itemOperator);
        ArrayList<ShortcutAndWidgetContainer> allShortcutAndWidgetContainers = getAllShortcutAndWidgetContainers();
        int size = allShortcutAndWidgetContainers.size();
        for (int i6 = 0; i6 < size; i6++) {
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = allShortcutAndWidgetContainers.get(i6);
            int childCount = shortcutAndWidgetContainer.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = shortcutAndWidgetContainer.getChildAt(i7);
                ItemInfo itemInfo = (ItemInfo) childAt.getTag();
                if (z5 && (itemInfo instanceof FolderInfo) && (childAt instanceof FolderIcon)) {
                    FolderIcon folderIcon = (FolderIcon) childAt;
                    ArrayList<View> itemsInReadingOrder = folderIcon.getFolder().getItemsInReadingOrder();
                    int size2 = itemsInReadingOrder.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        View view = itemsInReadingOrder.get(i8);
                        if (itemOperator.mo2269d((ItemInfo) view.getTag(), view, folderIcon)) {
                            return;
                        }
                    }
                } else if (itemOperator.mo2269d(itemInfo, childAt, null)) {
                    return;
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i6, int i7) {
        Objects.toString(arrayList);
        if (this.f23432V0.isAppsViewVisible()) {
            return;
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.addFocusables(arrayList, i6);
        } else {
            super.addFocusables(arrayList, i6, i7);
        }
    }

    @Override // android.view.View
    public final void announceForAccessibility(CharSequence charSequence) {
        Objects.toString(charSequence);
        if (this.f23432V0.isAppsViewVisible()) {
            return;
        }
        super.announceForAccessibility(charSequence);
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: b */
    public final void mo7607b(DragObject dragObject) {
        Objects.toString(dragObject);
        this.f23455v1 = false;
        this.f23457w1 = false;
        this.f23431U0 = null;
        CellLayout currentDropLayout = getCurrentDropLayout();
        setCurrentDropLayout(currentDropLayout);
        setCurrentDragOverlappingLayout(currentDropLayout);
        if (t1()) {
            return;
        }
        this.f23432V0.getDragLayer().showPageHints();
    }

    public final void c1(Hotseat hotseat, float[] fArr) {
        Objects.toString(hotseat);
        int i6 = (int) fArr[0];
        int[] iArr = this.f23436Z0;
        iArr[0] = i6;
        iArr[1] = (int) fArr[1];
        Launcher launcher = this.f23432V0;
        launcher.getDragLayer().getDescendantCoordRelativeToSelf(this, iArr, true);
        launcher.getDragLayer().mapCoordInSelfToDescendent(hotseat.getLayout(), iArr);
        fArr[0] = iArr[0];
        fArr[1] = iArr[1];
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.View
    public final void computeScroll() {
        super.computeScroll();
        this.f23450p1.m142b();
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final void d0() {
        super.d0();
        setLayoutTransition(null);
    }

    public final int d1() {
        ArrayList arrayList = this.f23403D0;
        boolean zContains = arrayList.contains(-301L);
        return arrayList.contains(-302L) ? (zContains ? 1 : 0) + 1 : zContains ? 1 : 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Objects.toString(sparseArray);
        this.f23406E1 = sparseArray;
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup, android.view.View
    public final boolean dispatchUnhandledMove(View view, int i6) {
        Objects.toString(view);
        if (t1()) {
            return false;
        }
        return super.dispatchUnhandledMove(view, i6);
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: e */
    public final boolean mo7608e() {
        return true;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final void e0(float f6) {
        boolean z5 = this.f23394r0;
        if ((f6 <= 0.0f && (U0() || z5)) || (f6 >= 0.0f && (U0() || !z5))) {
            dampedOverScroll(f6);
        }
    }

    public final boolean e1(int i6, int i7, int i8) {
        Launcher launcher = this.f23432V0;
        boolean z5 = launcher.getDeviceProfile().f16005e;
        if (launcher.getHotseat() != null && !z5) {
            Rect rect = new Rect();
            launcher.getHotseat().getHitRect(rect);
            if (rect.contains(i6, i7)) {
                return false;
            }
        }
        if (t1() || getOpenFolder() != null) {
            return false;
        }
        this.f23448l1 = true;
        int nextPage = getNextPage() + (i8 == 0 ? -1 : 1);
        setCurrentDropLayout(null);
        if (nextPage < 0 || nextPage >= getChildCount() || S0(nextPage) == -301) {
            return false;
        }
        setCurrentDragOverlappingLayout((CellLayout) getChildAt(nextPage));
        invalidate();
        return true;
    }

    public final void f1() {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ShortcutAndWidgetContainer shortcutsAndWidgets = ((CellLayout) getChildAt(i6)).getShortcutsAndWidgets();
            int childCount2 = shortcutsAndWidgets.getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt = shortcutsAndWidgets.getChildAt(i7);
                if (childAt != null && (childAt.getTag() instanceof LauncherAppWidgetInfo)) {
                    LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) childAt.getTag();
                    LauncherAppWidgetHostView launcherAppWidgetHostView = (LauncherAppWidgetHostView) launcherAppWidgetInfo.f16573F;
                    if (launcherAppWidgetHostView != null && launcherAppWidgetHostView.mo7923b()) {
                        Launcher launcher = this.f23432V0;
                        launcher.removeItem(launcherAppWidgetHostView, launcherAppWidgetInfo, false);
                        launcher.bindAppWidget(launcherAppWidgetInfo);
                    }
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: g */
    public final void mo7609g(Rect rect) {
        Objects.toString(rect);
        this.f23432V0.getDragLayer().getDescendantRectRelativeToSelf(this, rect);
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final void g0(int i6) {
        float fMax;
        float fMax2;
        boolean z5 = this.o1;
        boolean z6 = this.f23394r0;
        if (z5 && !t1()) {
            for (int iD1 = d1(); iD1 < getChildCount(); iD1++) {
                CellLayout cellLayout = (CellLayout) getChildAt(iD1);
                if (cellLayout != null) {
                    int scrollForPage = i6 - (getScrollForPage(iD1) + (getViewportWidth() / 2));
                    int childCount = getChildCount();
                    int i7 = iD1 + 1;
                    if ((scrollForPage < 0 && !z6) || (scrollForPage > 0 && z6)) {
                        i7 = iD1 - 1;
                    }
                    cellLayout.getShortcutsAndWidgets().setAlpha(1.0f - Math.abs(Math.max(Math.min(scrollForPage / (((i7 < 0 || i7 > childCount + (-1)) ? cellLayout.getMeasuredWidth() + this.f16090z : Math.abs(getScrollForPage(i7) - getScrollForPage(iD1))) * 1.0f), 1.0f), -1.0f)));
                }
            }
        }
        boolean zU0 = U0();
        Launcher launcher = this.f23432V0;
        if (zU0) {
            ArrayList arrayList = this.f23403D0;
            int iIndexOf = arrayList.indexOf(-301L);
            int iIndexOf2 = arrayList.indexOf(-302L);
            int scrollX = (getScrollX() - getScrollForPage(iIndexOf)) - getLayoutTransitionOffsetForPage(iIndexOf);
            int scrollX2 = (getScrollX() - getScrollForPage(iIndexOf2)) - getLayoutTransitionOffsetForPage(iIndexOf2);
            float scrollForPage2 = getScrollForPage(iIndexOf + 1) - getScrollForPage(iIndexOf);
            float f6 = scrollForPage2 - scrollX;
            if (f6 < 0.0f) {
                if (z6) {
                    fMax = Math.max(0.0f, f6 / scrollForPage2);
                    fMax2 = Math.min(0.0f, f6);
                } else {
                    float f7 = -(scrollX2 + scrollForPage2);
                    fMax = Math.min(0.0f, f7 / scrollForPage2);
                    fMax2 = Math.min(0.0f, f7);
                }
            } else if (z6) {
                float f8 = -(scrollX2 + scrollForPage2);
                fMax = Math.min(0.0f, f8 / scrollForPage2);
                fMax2 = Math.max(0.0f, f8);
            } else {
                fMax = Math.max(0.0f, f6 / scrollForPage2);
                fMax2 = Math.max(0.0f, f6);
            }
            if (Float.compare(fMax, this.f23427Q0) != 0) {
                C0081x c0081x = this.f23401C0;
                if (fMax > 0.0f) {
                    CellLayout cellLayout2 = (CellLayout) c0081x.get(-301L);
                    if (cellLayout2.getVisibility() != 0 && !t1()) {
                        cellLayout2.setVisibility(0);
                    }
                    AppsLibraryProgressCallback appsLibraryProgressCallback = this.mCustomContentCallbacks;
                    if (appsLibraryProgressCallback != null) {
                        appsLibraryProgressCallback.mo7799w();
                        this.mCustomContentCallbacks.mo7798n(fMax2);
                    }
                } else if (fMax < 0.0f) {
                    CellLayout cellLayout3 = (CellLayout) c0081x.get(-302L);
                    if (cellLayout3.getVisibility() != 0 && !t1()) {
                        cellLayout3.setVisibility(0);
                    }
                    AppsLibraryProgressCallback appsLibraryProgressCallback2 = this.f23423N0;
                    if (appsLibraryProgressCallback2 != null) {
                        appsLibraryProgressCallback2.mo7799w();
                        this.f23423N0.mo7798n(fMax2);
                    }
                }
                this.f23427Q0 = fMax;
                if (launcher.getHotseat() != null) {
                    launcher.getHotseat().setTranslationX(fMax2);
                }
                if (getPageIndicator() != null) {
                    getPageIndicator().setTranslationX(fMax2);
                }
            }
        }
        I0();
        getViewportWidth();
        getScrollForPage(getCurrentPage());
        ArrayList<ShortcutAndWidgetContainer> allShortcutAndWidgetContainers = launcher.getWorkspace().getAllShortcutAndWidgetContainers();
        int size = allShortcutAndWidgetContainers.size();
        int i8 = 0;
        while (i8 < size) {
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = allShortcutAndWidgetContainers.get(i8);
            i8++;
            ShortcutAndWidgetContainer shortcutAndWidgetContainer2 = shortcutAndWidgetContainer;
            int childCount2 = shortcutAndWidgetContainer2.getChildCount();
            for (int i9 = 0; i9 < childCount2; i9++) {
                View childAt = shortcutAndWidgetContainer2.getChildAt(i9);
                Objects.toString(childAt);
                if (childAt instanceof FolderIcon) {
                    ((FolderIcon) childAt).m7724l();
                }
            }
        }
    }

    public final void g1() {
        setLayoutTransition(null);
        if (U0()) {
            h1(0);
            h1(1);
        }
        removeAllViews();
        this.f23403D0.clear();
        this.f23401C0.clear();
        setLayoutTransition(this.f23456w0);
    }

    public ArrayList<ShortcutAndWidgetContainer> getAllShortcutAndWidgetContainers() {
        ArrayList<ShortcutAndWidgetContainer> arrayList = new ArrayList<>();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            arrayList.add(((CellLayout) getChildAt(i6)).getShortcutsAndWidgets());
        }
        Launcher launcher = this.f23432V0;
        if (launcher.getHotseat() != null) {
            arrayList.add(launcher.getHotseat().getLayout().getShortcutsAndWidgets());
        }
        return arrayList;
    }

    public CellLayout getCurrentCellLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    public CellLayout getCurrentDropLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    @Override // com.luutinhit.launcher6.PagedView
    public String getCurrentPageDescription() {
        if (U0() && getNextPage() == 0) {
            return this.f23428R0;
        }
        int i6 = this.f16085u;
        if (i6 == -1) {
            i6 = this.mCurrentPage;
        }
        return P0(i6);
    }

    public int getCurrentPageOffsetFromCustomContent() {
        getNextPage();
        getNumLeftCustomPages();
        return getNextPage() - getNumLeftCustomPages();
    }

    public AppsLibraryProgressCallback getCustomContentCallbacks() {
        return this.mCustomContentCallbacks;
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        if (t1()) {
            return 393216;
        }
        return super.getDescendantFocusability();
    }

    public CellInfo getDragInfo() {
        return this.mDragInfo;
    }

    @Override // com.luutinhit.launcher6.DragSource
    public float getIntrinsicIconScaleFactor() {
        return 1.0f;
    }

    public Folder getOpenFolder() {
        DragLayer dragLayer = this.f23432V0.getDragLayer();
        int childCount = dragLayer.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = dragLayer.getChildAt(i6);
            if (childAt instanceof Folder) {
                Folder folder = (Folder) childAt;
                if (folder.getInfo().f15523B) {
                    return folder;
                }
            }
        }
        return null;
    }

    public int getOverviewModeTranslationY() {
        Utilities.isRtl(getResources());
        DeviceProfile deviceProfile = this.grid;
        Rect rectM7812d = deviceProfile.m7812d();
        int iMin = Math.min(deviceProfile.overviewModeMaxIconZoneHeightPx, Math.max(deviceProfile.overviewModeMinIconZoneHeightPx, (int) (deviceProfile.overviewModeIconZoneRatio * deviceProfile.f16013m)));
        int normalChildHeight = (int) (this.f23443g1 * getNormalChildHeight());
        Rect rect = this.f23393q0;
        int i6 = rect.top + rectM7812d.top;
        int viewportHeight = (getViewportHeight() - rect.bottom) - rectM7812d.bottom;
        int i7 = rect.top;
        return (-((((viewportHeight - i6) - normalChildHeight) / 2) + i6)) + (((((getViewportHeight() - rect.bottom) - iMin) - i7) - normalChildHeight) / 2) + i7;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public View.OnClickListener getPageIndicatorClickListener() {
        return new SearchPullClickListener(this);
    }

    @Override // com.luutinhit.launcher6.PagedView
    public String getPageIndicatorDescription() {
        return getCurrentPageDescription() + ", " + getResources().getString(R.string.settings_button_text);
    }

    @Override // com.luutinhit.launcher6.PagedView
    public Matrix getPageShiftMatrix() {
        if (Float.compare(this.f23416J1, 0.0f) == 0) {
            return super.getPageShiftMatrix();
        }
        Matrix matrix = this.f23440d1;
        matrix.set(getMatrix());
        matrix.postTranslate(-this.f23416J1, 0.0f);
        return matrix;
    }

    public AppsLibraryProgressCallback getRightCustomContentCallbacks() {
        return this.f23423N0;
    }

    public ArrayList<Long> getScreenOrder() {
        return this.f23403D0;
    }

    public WorkspaceState getState() {
        return this.mState;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public int getUnboundedScrollX() {
        return super.getUnboundedScrollX();
    }

    public float getWallpaperOffsetForCenterPage() {
        int scrollForPage = getScrollForPage(getPageNearestToCenterOfScreen());
        B3.b0 b0Var = this.f23450p1;
        Workspace workspace = b0Var.f153a;
        int childCount = workspace.getChildCount();
        if (childCount >= 4 && workspace.V0()) {
            childCount--;
        }
        int[] iArr = B3.b0.f152h;
        b0Var.m143c(scrollForPage, childCount, iArr);
        return iArr[0] / iArr[1];
    }

    public ArrayList<CellLayout> getWorkspaceAndHotseatCellLayouts() {
        ArrayList<CellLayout> arrayList = new ArrayList<>();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            arrayList.add((CellLayout) getChildAt(i6));
        }
        Launcher launcher = this.f23432V0;
        if (launcher.getHotseat() != null) {
            arrayList.add(launcher.getHotseat().getLayout());
        }
        return arrayList;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final void h0() {
        if (!t1()) {
            super.h0();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.completeDragExit();
        }
    }

    public final void h1(int i6) {
        AppsLibraryProgressCallback appsLibraryProgressCallback;
        AppsLibraryProgressCallback appsLibraryProgressCallback2;
        long j6 = i6 == 0 ? -301L : -302L;
        CellLayout cellLayoutT0 = T0(j6);
        if (cellLayoutT0 == null) {
            throw new RuntimeException("Expected custom content screen to exist");
        }
        this.f23401C0.remove(j6);
        this.f23403D0.remove(Long.valueOf(j6));
        removeView(cellLayoutT0);
        if (i6 == 0 && (appsLibraryProgressCallback2 = this.mCustomContentCallbacks) != null) {
            appsLibraryProgressCallback2.mo7799w();
            this.mCustomContentCallbacks.mo7797e();
            this.mCustomContentCallbacks = null;
            this.f23397A0 = this.f23462z0 - 1;
            int i7 = this.mRestorePage;
            if (i7 != -1001) {
                this.mRestorePage = i7 - 1;
            } else {
                setCurrentPage(getCurrentPage() - 1);
            }
        }
        if (i6 != 1 || (appsLibraryProgressCallback = this.f23423N0) == null) {
            return;
        }
        appsLibraryProgressCallback.mo7799w();
        this.f23423N0.mo7797e();
        this.f23423N0 = null;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final void i0() {
        if (!t1()) {
            super.i0();
        }
        Folder openFolder = getOpenFolder();
        if (openFolder != null) {
            openFolder.completeDragExit();
        }
    }

    public final void i1(boolean z5, Runnable runnable, int i6, boolean z6) {
        Objects.toString(runnable);
        Launcher launcher = this.f23432V0;
        if (launcher.isWorkspaceLoading()) {
            Launcher.addDumpLog("Workspace", "    - workspace loading, skip", true);
            return;
        }
        if (i6 > 0) {
            postDelayed(new RunnableC0526l(this, z5, runnable, z6), i6);
            return;
        }
        boolean zIsWorkspaceLoading = launcher.isWorkspaceLoading();
        ArrayList arrayList = this.f23403D0;
        if (zIsWorkspaceLoading) {
            Launcher.addDumpLog("Workspace", "    - workspace loading, skip", true);
        } else if (!V0() && arrayList.size() != 0) {
            Long l6 = (Long) arrayList.get(arrayList.size() - 1);
            long jLongValue = l6.longValue();
            if (jLongValue != -301) {
                C0081x c0081x = this.f23401C0;
                CellLayout cellLayout = (CellLayout) c0081x.get(jLongValue);
                if (cellLayout.getShortcutsAndWidgets().getChildCount() == 0 && !cellLayout.mDropPending) {
                    c0081x.remove(jLongValue);
                    arrayList.remove(l6);
                    c0081x.put(-201L, cellLayout);
                    arrayList.add(-201L);
                    q1();
                    launcher.getModel().getClass();
                    LauncherModel.updateWorkspaceScreenOrder(launcher, arrayList);
                }
            }
        }
        if (!V0()) {
            if (z6) {
                n1();
            }
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (getNextPage() == arrayList.indexOf(-201L)) {
            m0(getNextPage() - 1, 400);
            K0(400, z6, runnable);
        } else {
            m0(getNextPage(), 0);
            K0(0, z6, runnable);
        }
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: j */
    public final void mo7610j() {
    }

    @Override // com.luutinhit.launcher6.PagedView
    public final boolean j0(View view) {
        Objects.toString(view);
        CellLayout cellLayout = (CellLayout) view;
        if (super.j0(view)) {
            return cellLayout.getShortcutsAndWidgets().getAlpha() > 0.0f || cellLayout.getBackgroundAlpha() > 0.0f;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j1(HashSet hashSet, C2673q c2673q) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Objects.toString(hashSet);
        Objects.toString(c2673q);
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts = getWorkspaceAndHotseatCellLayouts();
        int size = workspaceAndHotseatCellLayouts.size();
        int i6 = 0;
        while (i6 < size) {
            CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i6);
            i6++;
            CellLayout cellLayout2 = cellLayout;
            ShortcutAndWidgetContainer shortcutsAndWidgets = cellLayout2.getShortcutsAndWidgets();
            HashMap map = new HashMap();
            for (int i7 = 0; i7 < shortcutsAndWidgets.getChildCount(); i7++) {
                View childAt = shortcutsAndWidgets.getChildAt(i7);
                map.put((ItemInfo) childAt.getTag(), childAt);
            }
            ArrayList arrayList = new ArrayList();
            HashMap map2 = new HashMap();
            LauncherModel.filterItemInfos(map.keySet(), new C0328n(hashSet, c2673q, map2, arrayList, map, 18));
            for (FolderInfo folderInfo : (Iterable<FolderInfo>) (Iterable) (map2.keySet())) {
                ArrayList arrayList2 = (ArrayList) map2.get(folderInfo);
                int size2 = arrayList2.size();
                int i8 = 0;
                while (i8 < size2) {
                    Object obj = arrayList2.get(i8);
                    i8++;
                    folderInfo.remove((ShortcutInfo) obj);
                }
            }
            int size3 = arrayList.size();
            int i9 = 0;
            while (i9 < size3) {
                Object obj2 = arrayList.get(i9);
                i9++;
                View view = (View) obj2;
                cellLayout2.removeViewInLayout(view);
                if (view instanceof DropTarget) {
                    this.f23434X0.f16103l.remove((DropTarget) view);
                }
            }
            if (arrayList.size() > 0) {
                shortcutsAndWidgets.requestLayout();
                shortcutsAndWidgets.invalidate();
            }
        }
        n1();
    }

    public final void k1(HashSet hashSet, C2673q c2673q) {
        Objects.toString(hashSet);
        Objects.toString(c2673q);
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        ArrayList<CellLayout> workspaceAndHotseatCellLayouts = getWorkspaceAndHotseatCellLayouts();
        int size = workspaceAndHotseatCellLayouts.size();
        int i6 = 0;
        while (i6 < size) {
            CellLayout cellLayout = workspaceAndHotseatCellLayouts.get(i6);
            i6++;
            ShortcutAndWidgetContainer shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
            int childCount = shortcutsAndWidgets.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                hashSet2.add((ItemInfo) shortcutsAndWidgets.getChildAt(i7).getTag());
            }
        }
        LauncherModel.filterItemInfos(hashSet2, new C2333e(hashSet, c2673q, hashSet3, 16));
        j1(hashSet3, c2673q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l1(View view) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Objects.toString(view);
        CellLayout cellLayoutR0 = R0(view);
        if (cellLayoutR0 != null) {
            cellLayoutR0.removeView(view);
        } else {
            WeakReference weakReference = LauncherAppState.f16215h;
        }
        if (view instanceof DropTarget) {
            this.f23434X0.f16103l.remove((DropTarget) view);
        }
    }

    public final void m1(int i6) {
        if (this.f23406E1 != null) {
            this.f23408F1.add(Integer.valueOf(i6));
            CellLayout cellLayout = (CellLayout) getChildAt(i6);
            if (cellLayout != null) {
                SparseArray sparseArray = this.f23406E1;
                Objects.toString(sparseArray);
                try {
                    cellLayout.dispatchRestoreInstanceState(sparseArray);
                } catch (IllegalArgumentException unused) {
                    WeakReference weakReference = LauncherAppState.f16215h;
                }
            }
        }
    }

    public final void n1() {
        ArrayList arrayList;
        Launcher launcher = this.f23432V0;
        if (launcher.isWorkspaceLoading()) {
            Launcher.addDumpLog("Workspace", "    - workspace loading, skip", true);
            return;
        }
        if (this.f23377a0) {
            this.f23447k1 = true;
            return;
        }
        int nextPage = getNextPage();
        ArrayList arrayList2 = new ArrayList();
        C0081x c0081x = this.f23401C0;
        int size = c0081x.size();
        for (int i6 = 0; i6 < size; i6++) {
            long jKeyAt = c0081x.keyAt(i6);
            CellLayout cellLayout = (CellLayout) c0081x.valueAt(i6);
            if (jKeyAt >= 0 && cellLayout.getShortcutsAndWidgets().getChildCount() == 0) {
                arrayList2.add(Long.valueOf(jKeyAt));
            }
        }
        C2339d c2339d = LauncherAppState.getInstance().f16223f;
        int iD1 = d1() + 1;
        int size2 = arrayList2.size();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            arrayList = this.f23403D0;
            if (i8 >= size2) {
                break;
            }
            Object obj = arrayList2.get(i8);
            i8++;
            Long l6 = (Long) obj;
            CellLayout cellLayout2 = (CellLayout) c0081x.get(l6.longValue());
            c0081x.remove(l6.longValue());
            arrayList.remove(l6);
            if (getChildCount() > iD1) {
                if (indexOfChild(cellLayout2) < nextPage) {
                    i7++;
                }
                if (c2339d != null && c2339d.f19394l != null) {
                    cellLayout2.enableAccessibleDrag(2, false);
                }
                removeView(cellLayout2);
            } else {
                this.f23405E0 = null;
                c0081x.put(-201L, cellLayout2);
                arrayList.add(-201L);
            }
            q1();
        }
        if (!arrayList2.isEmpty()) {
            launcher.getModel().getClass();
            LauncherModel.updateWorkspaceScreenOrder(launcher, arrayList);
        }
        if (i7 >= 0) {
            setCurrentPage(nextPage - i7);
        }
    }

    public final void o1() {
        WorkspaceState workspaceState;
        boolean z5 = Utilities.f16752m;
        WorkspaceState workspaceState2 = WorkspaceState.f15305k;
        int i6 = 0;
        if (!z5) {
            setImportantForAccessibility(this.mState != workspaceState2 ? 4 : 0);
            return;
        }
        int pageCount = getPageCount();
        int iD1 = d1();
        while (true) {
            workspaceState = WorkspaceState.f15309o;
            if (iD1 >= pageCount) {
                break;
            }
            CellLayout cellLayout = (CellLayout) getChildAt(iD1);
            Objects.toString(cellLayout);
            WorkspaceState workspaceState3 = this.mState;
            if (workspaceState3 == workspaceState) {
                cellLayout.setImportantForAccessibility(1);
                cellLayout.getShortcutsAndWidgets().setImportantForAccessibility(4);
                cellLayout.setContentDescription(P0(iD1));
                if (this.f23420L1 == null) {
                    this.f23420L1 = new C2340e(this);
                }
                cellLayout.setAccessibilityDelegate(this.f23420L1);
            } else {
                int i7 = workspaceState3 == workspaceState2 ? 0 : 4;
                cellLayout.setImportantForAccessibility(2);
                cellLayout.getShortcutsAndWidgets().setImportantForAccessibility(i7);
                cellLayout.setContentDescription(null);
                cellLayout.setAccessibilityDelegate(null);
            }
            iD1++;
        }
        WorkspaceState workspaceState4 = this.mState;
        if (workspaceState4 != workspaceState2 && workspaceState4 != workspaceState) {
            i6 = 4;
        }
        setImportantForAccessibility(i6);
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IBinder windowToken = getWindowToken();
        this.f23460y0 = windowToken;
        this.f23450p1.m141a(windowToken);
        computeScroll();
        DragController dragController = this.f23434X0;
        if (dragController != null) {
            dragController.f16105n = this.f23460y0;
        }
        Launcher launcher = this.f23432V0;
        IBinder iBinder = this.f23460y0;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                AbstractC2545h.m9471a("Landroid/app/WallpaperManager;");
                WallpaperManager.class.getDeclaredMethod("setWallpaperZoomOut", IBinder.class, Float.TYPE).invoke(WallpaperManager.getInstance(launcher), iBinder, Float.valueOf(1.0f));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        Objects.toString(view);
        Objects.toString(view2);
        if (!(view2 instanceof CellLayout)) {
            throw new IllegalArgumentException("A Workspace can only have CellLayout children.");
        }
        CellLayout cellLayout = (CellLayout) view2;
        cellLayout.setOnInterceptTouchListener(this);
        cellLayout.setClickable(true);
        cellLayout.setImportantForAccessibility(2);
        cellLayout.setIsShaking(this.f23432V0.isShaking());
        super.onChildViewAdded(view, view2);
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f23450p1.m141a(null);
        this.f23460y0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Objects.toString(canvas);
        super.onDraw(canvas);
        post(this.f23422M1);
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        S0(getCurrentPage());
        S0(getCurrentPage());
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewOnClickListenerC2791d viewOnClickListenerC2791d;
        SlidingUpWidgetsList slidingUpWidgetsList;
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle;
        Objects.toString(motionEvent);
        Launcher launcher = this.f23432V0;
        if (launcher != null && (viewOnClickListenerC2791d = launcher.leftPage) != null && (((slidingUpWidgetsList = viewOnClickListenerC2791d.f21282s) != null && slidingUpWidgetsList.getVisibility() == 0) || ((slidingUpWidgetsAppStyle = viewOnClickListenerC2791d.f21283t) != null && slidingUpWidgetsAppStyle.getVisibility() == 0))) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f23463z1 = motionEvent.getX();
            this.f23398A1 = motionEvent.getY();
        } else if ((action == 1 || action == 6) && this.f16064N == 0 && ((CellLayout) getChildAt(this.mCurrentPage)) != null) {
            try {
                Objects.toString(motionEvent);
                int[] iArr = this.f23435Y0;
                getLocationOnScreen(iArr);
                int actionIndex = motionEvent.getActionIndex();
                iArr[0] = iArr[0] + ((int) motionEvent.getX(actionIndex));
                iArr[1] = iArr[1] + ((int) motionEvent.getY(actionIndex));
                IBinder windowToken = getWindowToken();
                if (windowToken != null) {
                    this.f23458x0.sendWallpaperCommand(windowToken, motionEvent.getAction() == 1 ? "android.wallpaper.tap" : "android.wallpaper.secondaryTap", iArr[0], iArr[1], 0, null);
                }
            } catch (Throwable unused) {
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        getChildCount();
        if (this.f16080p && (i10 = this.mCurrentPage) >= 0 && i10 < getChildCount()) {
            this.f23450p1.m142b();
            B3.b0 b0Var = this.f23450p1;
            Message.obtain(b0Var.f155c, 5, b0Var.f157e).sendToTarget();
        }
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // com.luutinhit.launcher6.PagedView, android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i6, Rect rect) {
        Objects.toString(rect);
        if (this.f23432V0.isAppsViewVisible()) {
            return false;
        }
        Folder openFolder = getOpenFolder();
        return openFolder != null ? openFolder.requestFocus(i6, rect) : super.onRequestFocusInDescendants(i6, rect);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Objects.toString(view);
        Objects.toString(motionEvent);
        if (t1()) {
            return true;
        }
        return (t1() || indexOfChild(view) == this.mCurrentPage) ? false : true;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i6) {
        this.f23432V0.onWindowVisibilityChanged(i6);
    }

    public final void p1(boolean z5) {
        boolean z6 = true;
        boolean z7 = this.mState == WorkspaceState.f15309o;
        if (!z5 && !z7 && !this.f23445i1 && !this.f23377a0) {
            z6 = false;
        }
        if (z6 != this.f23446j1) {
            this.f23446j1 = z6;
            if (z6) {
                I0();
                return;
            }
            for (int i6 = 0; i6 < getPageCount(); i6++) {
                CellLayout cellLayout = (CellLayout) getChildAt(i6);
                cellLayout.getClass();
                cellLayout.mShortcutsAndWidgets.setLayerType(0, CellLayout.f23325b0);
            }
        }
    }

    @Override // p101l3.InterfaceC2338c
    /* JADX INFO: renamed from: q */
    public final void mo7710q(boolean z5) {
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            ((CellLayout) getChildAt(i6)).enableAccessibleDrag(2, z5);
        }
        Launcher launcher = this.f23432V0;
        if (z5) {
            setOnClickListener(null);
        } else {
            setOnClickListener(launcher);
        }
        launcher.getHotseat().getLayout().enableAccessibleDrag(2, z5);
    }

    public final void q1() {
        ArrayList arrayList = this.f23403D0;
        arrayList.remove((Object) (-302L));
        arrayList.add(-302L);
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: r */
    public final boolean mo7711r() {
        return this.f23432V0.getDeviceProfile().inv.f16710b;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0110  */
    /* JADX WARN: Code duplicated, block: B:46:0x0118  */
    /* JADX WARN: Code duplicated, block: B:49:0x0121  */
    /* JADX WARN: Code duplicated, block: B:52:0x015c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0165  */
    /* JADX WARN: Code duplicated, block: B:58:0x016e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0189 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0191  */
    /* JADX WARN: Code duplicated, block: B:67:0x0198  */
    /* JADX WARN: Code duplicated, block: B:69:0x019c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:72:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b4  */
    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: s */
    public final void mo7611s(DragObject dragObject) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        View view;
        Launcher launcher;
        MergedModelRunnable mergedModelRunnable;
        int i6;
        View view2;
        View view3;
        float f6;
        CellLayout cellLayout;
        int i7;
        int i8;
        long j6;
        char c6;
        ItemInfo itemInfo;
        LauncherAppWidgetHostView launcherAppWidgetHostView;
        AppWidgetProviderInfo appWidgetInfo;
        int i9;
        int i10 = 0;
        View viewCreateShortcut;
        ItemInfo itemInfo2;
        CellLayout cellLayout2;
        ItemInfo itemInfo3;
        int i11 = 0;
        boolean z5 = false;
        ItemInfo itemInfo4;
        ItemInfo itemInfo5;
        CellLayout cellLayout3;
        boolean z6;
        int i12;
        boolean z7;
        AppWidgetHostView appWidgetHostView;
        int i13;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z8;
        int i20;
        Workspace workspace = this;
        float f7 = workspace.f23459x1;
        int i21 = 1;
        Objects.toString(dragObject);
        workspace.f23437a1 = dragObject.getVisualCenter(workspace.f23437a1);
        CellLayout cellLayout4 = workspace.f23431U0;
        Launcher launcher2 = workspace.f23432V0;
        if (cellLayout4 != null) {
            if (launcher2.isHotseatLayout(cellLayout4)) {
                workspace.c1(launcher2.getHotseat(), workspace.f23437a1);
            } else {
                b1(cellLayout4, workspace.f23437a1, null);
            }
        }
        if (dragObject.f16524h == workspace) {
            CellInfo cellInfo = workspace.mDragInfo;
            if (cellInfo != null) {
                View view4 = cellInfo.f15556a;
                if (cellLayout4 == null || dragObject.f16527k) {
                    view = view4;
                    launcher = launcher2;
                    dragObject = dragObject;
                    mergedModelRunnable = null;
                    i6 = -1;
                } else {
                    boolean z9 = workspace.R0(view4) != cellLayout4;
                    boolean zIsHotseatLayout = launcher2.isHotseatLayout(cellLayout4);
                    long j7 = zIsHotseatLayout ? -101L : -100L;
                    long jO0 = workspace.f23415J0[0] < 0 ? workspace.mDragInfo.f15561f : workspace.O0(cellLayout4);
                    CellInfo cellInfo2 = workspace.mDragInfo;
                    int i22 = cellInfo2 != null ? cellInfo2.f15559d : 1;
                    int i23 = cellInfo2 != null ? cellInfo2.f15560e : 1;
                    float[] fArr = workspace.f23437a1;
                    int[] iArrL0 = L0((int) fArr[0], (int) fArr[1], i22, i23, cellLayout4, workspace.f23415J0);
                    workspace.f23415J0 = iArrL0;
                    float[] fArr2 = workspace.f23437a1;
                    float distanceFromCell = cellLayout4.getDistanceFromCell(fArr2[0], fArr2[1], iArrL0);
                    if (workspace.f23448l1) {
                        f6 = distanceFromCell;
                        cellLayout = cellLayout4;
                        i7 = 2;
                    } else {
                        f6 = distanceFromCell;
                        cellLayout = cellLayout4;
                        i7 = 2;
                        if (workspace.F0(view4, j7, cellLayout, workspace.f23415J0, f6, false, dragObject.f16522f, null)) {
                            return;
                        }
                    }
                    CellLayout cellLayout5 = cellLayout;
                    if (workspace.w0(view4, cellLayout5, workspace.f23415J0, f6, dragObject, false)) {
                        return;
                    }
                    ItemInfo itemInfo6 = (ItemInfo) dragObject.f16523g;
                    int i24 = itemInfo6.spanX;
                    int i25 = itemInfo6.spanY;
                    int i26 = itemInfo6.minSpanX;
                    if (i26 <= 0 || (i10 = itemInfo6.minSpanY) <= 0) {
                        i8 = i25;
                    } else {
                        i24 = i26;
                        i8 = i10;
                    }
                    int[] iArr = new int[i7];
                    float[] fArr3 = workspace.f23437a1;
                    int[] iArrM7626A = cellLayout5.m7626A((int) fArr3[0], (int) fArr3[1], i24, i8, i22, i23, view4, workspace.f23415J0, iArr, 2);
                    view = view4;
                    workspace.f23415J0 = iArrM7626A;
                    boolean z10 = iArrM7626A[0] >= 0 && iArrM7626A[1] >= 0;
                    if (z10 && (view instanceof AppWidgetHostView) && ((i9 = iArr[0]) != itemInfo6.spanX || iArr[1] != itemInfo6.spanY)) {
                        itemInfo6.spanX = i9;
                        int i27 = iArr[1];
                        itemInfo6.spanY = i27;
                        AppWidgetResizeFrame.updateWidgetSizeRanges(i9, i27, (AppWidgetHostView) view, launcher2);
                    }
                    if (workspace.S0(workspace.mCurrentPage) == jO0 || zIsHotseatLayout) {
                        i6 = -1;
                    } else {
                        int iQ0 = workspace.Q0(jO0);
                        workspace.l0(iQ0);
                        i6 = iQ0;
                    }
                    if (z10) {
                        ItemInfo itemInfo7 = (ItemInfo) view.getTag();
                        if (z9) {
                            CellLayout cellLayoutR0 = workspace.R0(view);
                            if (cellLayoutR0 != null) {
                                cellLayoutR0.removeView(view);
                            } else {
                                WeakReference weakReference = LauncherAppState.f16215h;
                            }
                            int[] iArr2 = workspace.f23415J0;
                            int i28 = iArr2[0];
                            int i29 = iArr2[1];
                            j6 = jO0;
                            int i30 = itemInfo7.spanX;
                            int i31 = itemInfo7.spanY;
                            Objects.toString(view);
                            launcher = launcher2;
                            c6 = 0;
                            workspace.v0(view, j7, j6, i28, i29, i30, i31, false, false);
                        } else {
                            j6 = jO0;
                            launcher = launcher2;
                            c6 = 0;
                        }
                        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
                        int[] iArr3 = workspace.f23415J0;
                        int i32 = iArr3[c6];
                        cellLayoutLayoutParams.f15687c = i32;
                        cellLayoutLayoutParams.f15685a = i32;
                        int i33 = iArr3[1];
                        cellLayoutLayoutParams.f15688d = i33;
                        cellLayoutLayoutParams.f15686b = i33;
                        cellLayoutLayoutParams.f15690f = itemInfo6.spanX;
                        cellLayoutLayoutParams.f15691g = itemInfo6.spanY;
                        cellLayoutLayoutParams.f15692h = true;
                        if (j7 == -101 || !(view instanceof LauncherAppWidgetHostView) || (appWidgetInfo = (launcherAppWidgetHostView = (LauncherAppWidgetHostView) view).getAppWidgetInfo()) == null || appWidgetInfo.resizeMode == 0 || dragObject.f16525i) {
                            itemInfo = itemInfo7;
                            mergedModelRunnable = null;
                        } else {
                            itemInfo = itemInfo7;
                            workspace = this;
                            mergedModelRunnable = new MergedModelRunnable(19, workspace, new RunnableC0031a(this, itemInfo, launcherAppWidgetHostView, cellLayout5, 19, false));
                        }
                        LauncherModel.modifyItemInDatabase(workspace.f23432V0, itemInfo, j7, j6, cellLayoutLayoutParams.f15685a, cellLayoutLayoutParams.f15686b, itemInfo6.spanX, itemInfo6.spanY);
                    } else {
                        dragObject = dragObject;
                        view = view;
                        launcher = launcher2;
                        CellLayoutLayoutParams cellLayoutLayoutParams2 = (CellLayoutLayoutParams) view.getLayoutParams();
                        int[] iArr4 = workspace.f23415J0;
                        iArr4[0] = cellLayoutLayoutParams2.f15685a;
                        iArr4[1] = cellLayoutLayoutParams2.f15686b;
                        ((CellLayout) view.getParent().getParent()).markCellsAsOccupiedForView(view);
                        mergedModelRunnable = null;
                    }
                }
                CellLayout cellLayout6 = (CellLayout) view.getParent().getParent();
                MergedModelRunnable mergedModelRunnable2 = new MergedModelRunnable(20, workspace, mergedModelRunnable);
                workspace.f23445i1 = true;
                if (dragObject.f16522f.f16483q) {
                    int i34 = ((ItemInfo) view.getTag()).itemType;
                    if (i34 == 4 || i34 == 5) {
                        view3 = view;
                        launcher.getDragLayer().animateViewIntoPosition(dragObject.f16522f, view3, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, mergedModelRunnable2, this);
                    } else {
                        view3 = view;
                        launcher.getDragLayer().animateViewIntoPosition(dragObject.f16522f, view3, i6 < 0 ? -1 : Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, mergedModelRunnable2, this);
                    }
                    view2 = view3;
                } else {
                    view2 = view;
                    dragObject.f16528l = false;
                    view2.setVisibility(0);
                }
                cellLayout6.onDropChild(view2);
                return;
            }
            return;
        }
        float[] fArr4 = workspace.f23437a1;
        int[] iArr5 = {(int) fArr4[0], (int) fArr4[1]};
        Object obj = dragObject.f16523g;
        Objects.toString(obj);
        Objects.toString(cellLayout4);
        Objects.toString(dragObject);
        WorkspaceDropRunnable workspaceDropRunnable = new WorkspaceDropRunnable(workspace, i21);
        ItemInfo itemInfo8 = (ItemInfo) obj;
        int i35 = itemInfo8.spanX;
        int i36 = itemInfo8.spanY;
        CellInfo cellInfo3 = workspace.mDragInfo;
        if (cellInfo3 != null) {
            i35 = cellInfo3.f15559d;
            i36 = cellInfo3.f15560e;
        }
        int i37 = i36;
        int i38 = i35;
        long j8 = launcher2.isHotseatLayout(cellLayout4) ? -101L : -100L;
        long jO1 = workspace.O0(cellLayout4);
        if (!launcher2.isHotseatLayout(cellLayout4) && jO1 != workspace.S0(workspace.mCurrentPage) && workspace.mState != WorkspaceState.f15307m) {
            workspace.m0(workspace.Q0(jO1), 950);
        }
        if (!(itemInfo8 instanceof PendingAddItemInfo)) {
            int i39 = itemInfo8.itemType;
            if (i39 == 0 || i39 == 1) {
                ItemInfo itemInfoMakeShortcut = (itemInfo8.container == -1 && (itemInfo8 instanceof AppInfo)) ? ((AppInfo) itemInfo8).makeShortcut() : itemInfo8;
                viewCreateShortcut = launcher2.createShortcut(cellLayout4, (ShortcutInfo) itemInfoMakeShortcut);
                itemInfo2 = itemInfoMakeShortcut;
            } else {
                if (i39 != 2) {
                    throw new IllegalStateException("Unknown item type: " + itemInfo8.itemType);
                }
                viewCreateShortcut = FolderIcon.m7716g(launcher2, cellLayout4, (FolderInfo) itemInfo8, workspace.f23433W0);
                itemInfo2 = itemInfo8;
            }
            View view5 = viewCreateShortcut;
            int[] iArrL1 = L0(iArr5[0], iArr5[1], i38, i37, cellLayout4, workspace.f23415J0);
            workspace.f23415J0 = iArrL1;
            float[] fArr5 = workspace.f23437a1;
            float distanceFromCell2 = cellLayout4.getDistanceFromCell(fArr5[0], fArr5[1], iArrL1);
            dragObject.f16526j = workspaceDropRunnable;
            if (workspace.F0(view5, j8, cellLayout4, workspace.f23415J0, distanceFromCell2, true, dragObject.f16522f, workspaceDropRunnable) || workspace.w0(view5, cellLayout4, workspace.f23415J0, distanceFromCell2, dragObject, true)) {
                return;
            }
            float[] fArr6 = workspace.f23437a1;
            int[] iArrM7626A2 = cellLayout4.m7626A((int) fArr6[0], (int) fArr6[1], 1, 1, 1, 1, null, workspace.f23415J0, null, 3);
            workspace.f23415J0 = iArrM7626A2;
            LauncherModel.addOrMoveItemInDatabase(workspace.f23432V0, itemInfo2, j8, jO1, iArrM7626A2[0], iArrM7626A2[1]);
            ItemInfo itemInfo9 = itemInfo2;
            int[] iArr6 = workspace.f23415J0;
            int i40 = iArr6[0];
            int i41 = iArr6[1];
            int i42 = itemInfo9.spanX;
            int i43 = itemInfo9.spanY;
            Objects.toString(view5);
            workspace.v0(view5, j8, jO1, i40, i41, i42, i43, false, false);
            cellLayout4.onDropChild(view5);
            cellLayout4.getShortcutsAndWidgets().measureChild(view5);
            if (dragObject.f16522f != null) {
                workspace.setFinalTransitionTransform(cellLayout4);
                launcher2.getDragLayer().animateViewIntoPosition(dragObject.f16522f, view5, workspaceDropRunnable, workspace);
                Objects.toString(cellLayout4);
                return;
            }
            return;
        }
        PendingAddItemInfo pendingAddItemInfo = (PendingAddItemInfo) obj;
        if (pendingAddItemInfo.itemType == 1) {
            itemInfo3 = itemInfo8;
            i11 = 2;
            int[] iArrL2 = L0(iArr5[0], iArr5[1], i38, i37, cellLayout4, workspace.f23415J0);
            cellLayout2 = cellLayout4;
            workspace.f23415J0 = iArrL2;
            float[] fArr7 = workspace.f23437a1;
            float distanceFromCell3 = cellLayout2.getDistanceFromCell(fArr7[0], fArr7[1], iArrL2);
            ItemInfo itemInfo10 = (ItemInfo) dragObject.f16523g;
            int[] iArr7 = workspace.f23415J0;
            Objects.toString(itemInfo10);
            Objects.toString(cellLayout2);
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = cellLayout2.mShortcutsAndWidgets;
            if (!(distanceFromCell3 > f7 ? false : workspace.s1(shortcutAndWidgetContainer.getChildAt(iArr7[0], iArr7[1]), itemInfo10, true))) {
                Object obj2 = dragObject.f16523g;
                int[] iArr8 = workspace.f23415J0;
                Objects.toString(obj2);
                Objects.toString(cellLayout2);
                if (distanceFromCell3 > f7 ? false : r1(shortcutAndWidgetContainer.getChildAt(iArr8[0], iArr8[1]), obj2)) {
                }
                itemInfo4 = (ItemInfo) dragObject.f16523g;
                if (z5) {
                    i14 = itemInfo4.spanX;
                    i15 = itemInfo4.spanY;
                    i16 = itemInfo4.minSpanX;
                    if (i16 > 0 || (i20 = itemInfo4.minSpanY) <= 0) {
                        i17 = i14;
                        i18 = i15;
                    } else {
                        i17 = i16;
                        i18 = i20;
                    }
                    int[] iArr9 = new int[i11];
                    float[] fArr8 = workspace.f23437a1;
                    itemInfo5 = itemInfo3;
                    cellLayout3 = cellLayout2;
                    workspace.f23415J0 = cellLayout3.m7626A((int) fArr8[0], (int) fArr8[1], i17, i18, itemInfo5.spanX, itemInfo5.spanY, null, workspace.f23415J0, iArr9, 3);
                    i19 = iArr9[0];
                    if (i19 == itemInfo4.spanX || iArr9[1] != itemInfo4.spanY) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    itemInfo4.spanX = i19;
                    itemInfo4.spanY = iArr9[1];
                    z6 = z8;
                } else {
                    itemInfo5 = itemInfo3;
                    cellLayout3 = cellLayout2;
                    z6 = false;
                }
                WorkspaceAddPendingRunnable workspaceAddPendingRunnable = new WorkspaceAddPendingRunnable(workspace, pendingAddItemInfo, j8, jO1, itemInfo4);
                i12 = pendingAddItemInfo.itemType;
                if (i12 != 4 || i12 == 5) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    appWidgetHostView = ((C0351g) pendingAddItemInfo).f1150D;
                } else {
                    appWidgetHostView = null;
                }
                if (appWidgetHostView != null && z6) {
                    AppWidgetResizeFrame.updateWidgetSizeRanges(itemInfo4.spanX, itemInfo4.spanY, appWidgetHostView, launcher2);
                }
                if (z7 || (launcherAppWidgetProviderInfo = ((C0351g) pendingAddItemInfo).f1149C) == null || ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).configure == null) {
                    i13 = 0;
                } else {
                    i13 = 1;
                }
                x0(itemInfo5, cellLayout3, dragObject.f16522f, workspaceAddPendingRunnable, i13, appWidgetHostView);
            }
            z5 = false;
            itemInfo4 = (ItemInfo) dragObject.f16523g;
            if (z5) {
                i14 = itemInfo4.spanX;
                i15 = itemInfo4.spanY;
                i16 = itemInfo4.minSpanX;
                if (i16 > 0) {
                    i17 = i14;
                    i18 = i15;
                } else {
                    i17 = i14;
                    i18 = i15;
                }
                int[] iArr10 = new int[i11];
                float[] fArr9 = workspace.f23437a1;
                itemInfo5 = itemInfo3;
                cellLayout3 = cellLayout2;
                workspace.f23415J0 = cellLayout3.m7626A((int) fArr9[0], (int) fArr9[1], i17, i18, itemInfo5.spanX, itemInfo5.spanY, null, workspace.f23415J0, iArr10, 3);
                i19 = iArr10[0];
                if (i19 == itemInfo4.spanX) {
                    z8 = true;
                } else {
                    z8 = true;
                }
                itemInfo4.spanX = i19;
                itemInfo4.spanY = iArr10[1];
                z6 = z8;
            } else {
                itemInfo5 = itemInfo3;
                cellLayout3 = cellLayout2;
                z6 = false;
            }
            WorkspaceAddPendingRunnable workspaceAddPendingRunnable2 = new WorkspaceAddPendingRunnable(workspace, pendingAddItemInfo, j8, jO1, itemInfo4);
            i12 = pendingAddItemInfo.itemType;
            if (i12 != 4) {
                z7 = true;
            } else {
                z7 = true;
            }
            if (z7) {
                appWidgetHostView = ((C0351g) pendingAddItemInfo).f1150D;
            } else {
                appWidgetHostView = null;
            }
            if (appWidgetHostView != null) {
                AppWidgetResizeFrame.updateWidgetSizeRanges(itemInfo4.spanX, itemInfo4.spanY, appWidgetHostView, launcher2);
            }
            if (z7) {
                i13 = 0;
            } else {
                i13 = 0;
            }
            x0(itemInfo5, cellLayout3, dragObject.f16522f, workspaceAddPendingRunnable2, i13, appWidgetHostView);
        }
        cellLayout2 = cellLayout4;
        itemInfo3 = itemInfo8;
        i11 = 2;
        z5 = true;
        itemInfo4 = (ItemInfo) dragObject.f16523g;
        if (z5) {
            i14 = itemInfo4.spanX;
            i15 = itemInfo4.spanY;
            i16 = itemInfo4.minSpanX;
            if (i16 > 0) {
                i17 = i14;
                i18 = i15;
            } else {
                i17 = i14;
                i18 = i15;
            }
            int[] iArr11 = new int[i11];
            float[] fArr10 = workspace.f23437a1;
            itemInfo5 = itemInfo3;
            cellLayout3 = cellLayout2;
            workspace.f23415J0 = cellLayout3.m7626A((int) fArr10[0], (int) fArr10[1], i17, i18, itemInfo5.spanX, itemInfo5.spanY, null, workspace.f23415J0, iArr11, 3);
            i19 = iArr11[0];
            if (i19 == itemInfo4.spanX) {
                z8 = true;
            } else {
                z8 = true;
            }
            itemInfo4.spanX = i19;
            itemInfo4.spanY = iArr11[1];
            z6 = z8;
        } else {
            itemInfo5 = itemInfo3;
            cellLayout3 = cellLayout2;
            z6 = false;
        }
        WorkspaceAddPendingRunnable workspaceAddPendingRunnable3 = new WorkspaceAddPendingRunnable(workspace, pendingAddItemInfo, j8, jO1, itemInfo4);
        i12 = pendingAddItemInfo.itemType;
        if (i12 != 4) {
            z7 = true;
        } else {
            z7 = true;
        }
        if (z7) {
            appWidgetHostView = ((C0351g) pendingAddItemInfo).f1150D;
        } else {
            appWidgetHostView = null;
        }
        if (appWidgetHostView != null) {
            AppWidgetResizeFrame.updateWidgetSizeRanges(itemInfo4.spanX, itemInfo4.spanY, appWidgetHostView, launcher2);
        }
        if (z7) {
            i13 = 0;
        } else {
            i13 = 0;
        }
        x0(itemInfo5, cellLayout3, dragObject.f16522f, workspaceAddPendingRunnable3, i13, appWidgetHostView);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:16:0x002b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    public final boolean s1(View view, ItemInfo itemInfo, boolean z5) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        CellInfo cellInfo;
        boolean z6;
        boolean z7;
        int i6;
        boolean z8;
        Objects.toString(itemInfo);
        Objects.toString(view);
        if (view != null) {
            CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
            if (!cellLayoutLayoutParams.f15689e || (cellLayoutLayoutParams.f15687c == cellLayoutLayoutParams.f15685a && cellLayoutLayoutParams.f15688d == cellLayoutLayoutParams.f15686b)) {
                cellInfo = this.mDragInfo;
                if (cellInfo == null && view == cellInfo.f15556a) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (view != null && !z6 && (!z5 || this.f23455v1)) {
                    z7 = view.getTag() instanceof ShortcutInfo;
                    i6 = itemInfo.itemType;
                    if (i6 != 0 || i6 == 1) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (!z7 && z8) {
                        return true;
                    }
                }
            }
        } else {
            cellInfo = this.mDragInfo;
            if (cellInfo == null) {
                z6 = false;
            } else {
                z6 = false;
            }
            if (view != null) {
                z7 = view.getTag() instanceof ShortcutInfo;
                i6 = itemInfo.itemType;
                if (i6 != 0) {
                    z8 = true;
                } else {
                    z8 = true;
                }
                if (!z7) {
                }
            }
        }
        return false;
    }

    public void setAddNewPageOnDrag(boolean z5) {
        this.mAddNewPageOnDrag = z5;
    }

    public void setCurrentDragOverlappingLayout(CellLayout cellLayout) {
        Objects.toString(cellLayout);
        CellLayout cellLayout2 = this.f23430T0;
        if (cellLayout2 != null) {
            cellLayout2.setIsDragOverlapping(false);
        }
        this.f23430T0 = cellLayout;
        if (cellLayout != null) {
            cellLayout.setIsDragOverlapping(true);
        }
        invalidate();
    }

    public void setCurrentDropLayout(CellLayout cellLayout) {
        Objects.toString(cellLayout);
        CellLayout cellLayout2 = this.f23429S0;
        if (cellLayout2 != null) {
            cellLayout2.revertTempState();
            CellLayout cellLayout3 = this.f23429S0;
            if (cellLayout3.f15456K) {
                cellLayout3.f15456K = false;
            }
            int[] iArr = cellLayout3.f15455J;
            iArr[1] = -1;
            iArr[0] = -1;
            cellLayout3.revertTempState();
            cellLayout3.setIsDragOverlapping(false);
        }
        this.f23429S0 = cellLayout;
        if (cellLayout != null) {
            cellLayout.f15456K = true;
        }
        B0(true);
        A0();
        if (-1 == this.f23417K0 && -1 == this.f23419L0) {
            return;
        }
        this.f23417K0 = -1;
        this.f23419L0 = -1;
        setDragMode(0);
    }

    public void setDragMode(int i6) {
        if (i6 != this.f23400B1) {
            if (i6 == 0) {
                z0();
                B0(false);
                A0();
            } else if (i6 == 2) {
                B0(true);
                A0();
            } else if (i6 == 1) {
                z0();
                B0(true);
            } else if (i6 == 3) {
                z0();
                A0();
            }
            this.f23400B1 = i6;
        }
    }

    public void setFinalTransitionTransform(CellLayout cellLayout) {
        Objects.toString(cellLayout);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        Objects.toString(rect);
        Rect rect2 = this.f23393q0;
        rect2.set(rect);
        CellLayout cellLayoutT0 = T0(-301L);
        if (cellLayoutT0 != null) {
            KeyEvent.Callback childAt = cellLayoutT0.getShortcutsAndWidgets().getChildAt(0);
            if (childAt instanceof Insettable) {
                ((Insettable) childAt).setInsets(rect2);
            }
        }
    }

    public void setLauncherOverlay(SimpleCallback simpleCallback) {
        Objects.toString(simpleCallback);
        float fMin = Math.min(1.0f, Math.max(0.0f, 0.0f) / 1.0f);
        float interpolation = 1.0f - this.f23424N1.getInterpolation(fMin);
        Launcher launcher = this.f23432V0;
        float measuredWidth = launcher.getDragLayer().getMeasuredWidth() * fMin * 1.0f;
        if (this.f23394r0) {
            measuredWidth = -measuredWidth;
        }
        this.f23416J1 = measuredWidth;
        PageIndicator pageIndicator = getPageIndicator();
        Objects.toString(pageIndicator);
        if (pageIndicator != null) {
            pageIndicator.setTranslationX(measuredWidth);
            pageIndicator.setAlpha(interpolation);
        }
        View childAt = getChildAt(getCurrentPage());
        Objects.toString(childAt);
        if (childAt != null) {
            childAt.setTranslationX(measuredWidth);
            childAt.setAlpha(interpolation);
        }
        Hotseat hotseat = launcher.getHotseat();
        Objects.toString(hotseat);
        if (hotseat != null) {
            hotseat.setTranslationX(measuredWidth);
            hotseat.setAlpha(interpolation);
        }
        if (measuredWidth == 0.0f) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt2 = getChildAt(childCount);
                Objects.toString(childAt2);
                if (childAt2 != null) {
                    childAt2.setTranslationX(0.0f);
                    childAt2.setAlpha(interpolation);
                }
            }
        }
    }

    public void setState(WorkspaceState workspaceState) {
        this.mState = workspaceState;
    }

    public void setup(DragController dragController) {
        Objects.toString(dragController);
        C2333e c2333e = new C2333e(15, false);
        c2333e.f19379m = this.f23432V0;
        Alarm alarm = new Alarm();
        c2333e.f19377k = alarm;
        alarm.f16206m = c2333e;
        this.f23441e1 = c2333e;
        this.f23434X0 = dragController;
        p1(false);
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: t */
    public final boolean mo7712t() {
        return true;
    }

    public final boolean t1() {
        return this.mState != WorkspaceState.f15305k;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:36:0x00af  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:53:0x010d  */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cd, code lost:
    
        if (r1 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010e, code lost:
    
        if ((r4 == r2.f15710p) != false) goto L55;
     */
    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean mo7612u(DragObject dragObject) {
        CellLayout cellLayout;
        WorkspaceState workspaceState;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArrM7626A;
        Object obj;
        int[] iArr;
        boolean zR1;
        Objects.toString(dragObject);
        CellLayout cellLayout2 = this.f23431U0;
        if (dragObject.f16524h != this) {
            if (cellLayout2 == null || ((workspaceState = this.mState) != WorkspaceState.f15305k && workspaceState != WorkspaceState.f15307m)) {
                return false;
            }
            this.f23437a1 = dragObject.getVisualCenter(this.f23437a1);
            Launcher launcher = this.f23432V0;
            if (launcher.isHotseatLayout(cellLayout2)) {
                c1(launcher.getHotseat(), this.f23437a1);
            } else {
                b1(cellLayout2, this.f23437a1, null);
            }
            CellInfo cellInfo = this.mDragInfo;
            if (cellInfo != null) {
                i6 = cellInfo.f15559d;
                i7 = cellInfo.f15560e;
            } else {
                ItemInfo itemInfo = (ItemInfo) dragObject.f16523g;
                i6 = itemInfo.spanX;
                i7 = itemInfo.spanY;
            }
            int i10 = i7;
            int i11 = i6;
            Object obj2 = dragObject.f16523g;
            if (obj2 instanceof C0351g) {
                C0351g c0351g = (C0351g) obj2;
                int i12 = c0351g.minSpanX;
                i8 = c0351g.minSpanY;
                i9 = i12;
            } else {
                i8 = i10;
                i9 = i11;
            }
            float[] fArr = this.f23437a1;
            int[] iArrL0 = L0((int) fArr[0], (int) fArr[1], i9, i8, cellLayout2, this.f23415J0);
            this.f23415J0 = iArrL0;
            float[] fArr2 = this.f23437a1;
            float distanceFromCell = cellLayout2.getDistanceFromCell(fArr2[0], fArr2[1], iArrL0);
            boolean z5 = this.f23455v1;
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = cellLayout2.mShortcutsAndWidgets;
            if (!z5) {
                if (this.f23457w1) {
                    obj = dragObject.f16523g;
                    iArr = this.f23415J0;
                    Objects.toString(obj);
                    Objects.toString(cellLayout2);
                    if (distanceFromCell > this.f23459x1) {
                        zR1 = false;
                    } else {
                        zR1 = r1(shortcutAndWidgetContainer.getChildAt(iArr[0], iArr[1]), obj);
                    }
                }
                float[] fArr3 = this.f23437a1;
                int i13 = (int) fArr3[0];
                int i14 = (int) fArr3[1];
                cellLayout = cellLayout2;
                iArrM7626A = cellLayout.m7626A(i13, i14, i9, i8, i11, i10, null, this.f23415J0, new int[2], 4);
                this.f23415J0 = iArrM7626A;
                if (iArrM7626A[0] >= 0) {
                }
                boolean zIsHotseatLayout = launcher.isHotseatLayout(cellLayout);
                if (this.f23415J0 != null) {
                    Hotseat hotseat = launcher.getHotseat();
                    int[] iArr2 = this.f23415J0;
                    int i15 = iArr2[0];
                    int i16 = iArr2[1];
                    hotseat.getClass();
                }
                launcher.showOutOfSpaceMessage(zIsHotseatLayout);
                return false;
            }
            ItemInfo itemInfo2 = (ItemInfo) dragObject.f16523g;
            int[] iArr3 = this.f23415J0;
            Objects.toString(itemInfo2);
            Objects.toString(cellLayout2);
            if (!(distanceFromCell > this.f23459x1 ? false : s1(shortcutAndWidgetContainer.getChildAt(iArr3[0], iArr3[1]), itemInfo2, true))) {
                if (this.f23457w1) {
                    obj = dragObject.f16523g;
                    iArr = this.f23415J0;
                    Objects.toString(obj);
                    Objects.toString(cellLayout2);
                    if (distanceFromCell > this.f23459x1) {
                        zR1 = false;
                    } else {
                        zR1 = r1(shortcutAndWidgetContainer.getChildAt(iArr[0], iArr[1]), obj);
                    }
                }
                float[] fArr4 = this.f23437a1;
                int i17 = (int) fArr4[0];
                int i18 = (int) fArr4[1];
                cellLayout = cellLayout2;
                iArrM7626A = cellLayout.m7626A(i17, i18, i9, i8, i11, i10, null, this.f23415J0, new int[2], 4);
                this.f23415J0 = iArrM7626A;
                if (iArrM7626A[0] >= 0 || iArrM7626A[1] < 0) {
                    boolean zIsHotseatLayout2 = launcher.isHotseatLayout(cellLayout);
                    if (this.f23415J0 != null && zIsHotseatLayout2) {
                        Hotseat hotseat2 = launcher.getHotseat();
                        int[] iArr4 = this.f23415J0;
                        int i19 = iArr4[0];
                        int i110 = iArr4[1];
                        hotseat2.getClass();
                    }
                    launcher.showOutOfSpaceMessage(zIsHotseatLayout2);
                    return false;
                }
            }
            return true;
        }
        cellLayout = cellLayout2;
        if (O0(cellLayout) == -201) {
            C0();
        }
        return true;
    }

    public final void u0() {
        if (this.f23401C0.m201f(-201L)) {
            return;
        }
        W0(this.f23403D0.contains(-302L) ? getChildCount() - 1 : getChildCount(), -201L);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x008d A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0093 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:36:0x00be  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ca A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f0 A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00fc A[Catch: all -> 0x001f, TryCatch #0 {all -> 0x001f, blocks: (B:4:0x0010, B:6:0x0016, B:14:0x0033, B:16:0x0048, B:18:0x0050, B:25:0x0085, B:27:0x008d, B:31:0x00a1, B:32:0x00a3, B:37:0x00c2, B:39:0x00ca, B:40:0x00ec, B:42:0x00f0, B:43:0x00f8, B:45:0x00fc, B:28:0x0093, B:19:0x0061, B:21:0x006d, B:23:0x0071, B:24:0x0077, B:47:0x0106, B:48:0x010d), top: B:51:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x00ca, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void v0(View view, long j6, long j7, int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        CellLayout cellLayoutT0;
        int i10 = 0;
        int i11 = 0;
        ViewGroup.LayoutParams layoutParams;
        CellLayoutLayoutParams cellLayoutLayoutParams;
        int viewIdForItem;
        boolean z7;
        int i12;
        CellLayoutLayoutParams cellLayoutLayoutParams2;
        Objects.toString(view);
        if (j6 == -100) {
            try {
                if (T0(j7) == null) {
                    new Throwable().printStackTrace();
                    return;
                }
            } catch (Throwable th) {
                th.getMessage();
                return;
            }
        }
        if (j7 == -201) {
            throw new RuntimeException("Screen id should not be EXTRA_EMPTY_SCREEN_ID");
        }
        Launcher launcher = this.f23432V0;
        if (j6 == -101) {
            cellLayoutT0 = launcher.getHotseat().getLayout();
            view.setOnKeyListener(new IconKeyEventListener(1));
            if (view instanceof FolderIcon) {
                ((FolderIcon) view).setTextVisible(false);
            }
            if (z6) {
                i10 = (int) j7;
                launcher.getHotseat().getClass();
                launcher.getHotseat().getClass();
                i11 = 0;
            } else {
                launcher.getHotseat().getClass();
            }
            layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CellLayoutLayoutParams) {
                cellLayoutLayoutParams = (CellLayoutLayoutParams) layoutParams;
                cellLayoutLayoutParams.f15685a = i10;
                cellLayoutLayoutParams.f15686b = i11;
                cellLayoutLayoutParams.f15690f = i8;
                cellLayoutLayoutParams.f15691g = i9;
            } else {
                cellLayoutLayoutParams = new CellLayoutLayoutParams(i10, i11, i8, i9);
            }
            if (i8 < 0 && i9 < 0) {
                cellLayoutLayoutParams.f15692h = false;
            }
            viewIdForItem = launcher.getViewIdForItem((ItemInfo) view.getTag());
            z7 = !(view instanceof Folder);
            if (z5) {
                i12 = 0;
            } else {
                i12 = -1;
            }
            cellLayoutLayoutParams2 = cellLayoutLayoutParams;
            if (!cellLayoutT0.addViewToCellLayout(view, i12, viewIdForItem, cellLayoutLayoutParams2, z7)) {
                Launcher.addDumpLog("Workspace", "Failed to add to item at (" + cellLayoutLayoutParams2.f15685a + "," + cellLayoutLayoutParams2.f15686b + ") to CellLayout", true);
            }
            if (!(view instanceof Folder)) {
                view.setHapticFeedbackEnabled(false);
                view.setOnLongClickListener(this.f16066P);
            }
            if (view instanceof DropTarget) {
                this.f23434X0.f16103l.add((DropTarget) view);
            }
        }
        if (view instanceof FolderIcon) {
            ((FolderIcon) view).setTextVisible(true);
        }
        cellLayoutT0 = T0(j7);
        view.setOnKeyListener(new IconKeyEventListener(2));
        i10 = i6;
        i11 = i7;
        layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CellLayoutLayoutParams) {
            cellLayoutLayoutParams = new CellLayoutLayoutParams(i10, i11, i8, i9);
        } else {
            cellLayoutLayoutParams = (CellLayoutLayoutParams) layoutParams;
            cellLayoutLayoutParams.f15685a = i10;
            cellLayoutLayoutParams.f15686b = i11;
            cellLayoutLayoutParams.f15690f = i8;
            cellLayoutLayoutParams.f15691g = i9;
        }
        if (i8 < 0) {
            cellLayoutLayoutParams.f15692h = false;
        }
        viewIdForItem = launcher.getViewIdForItem((ItemInfo) view.getTag());
        z7 = !(view instanceof Folder);
        if (z5) {
            i12 = 0;
        } else {
            i12 = -1;
        }
        cellLayoutLayoutParams2 = cellLayoutLayoutParams;
        if (!cellLayoutT0.addViewToCellLayout(view, i12, viewIdForItem, cellLayoutLayoutParams2, z7)) {
            Launcher.addDumpLog("Workspace", "Failed to add to item at (" + cellLayoutLayoutParams2.f15685a + "," + cellLayoutLayoutParams2.f15686b + ") to CellLayout", true);
        }
        if (!(view instanceof Folder)) {
            view.setHapticFeedbackEnabled(false);
            view.setOnLongClickListener(this.f16066P);
        }
        if (view instanceof DropTarget) {
            this.f23434X0.f16103l.add((DropTarget) view);
        }
    }

    @Override // com.luutinhit.launcher6.UninstallSource
    /* JADX INFO: renamed from: w */
    public final void mo7713w(boolean z5) {
        this.f23412H1 = false;
        this.f23414I1 = z5;
        DropCompleteRunnable dropCompleteRunnable = this.f23410G1;
        if (dropCompleteRunnable != null) {
            dropCompleteRunnable.run();
        }
    }

    public final boolean w0(View view, CellLayout cellLayout, int[] iArr, float f6, DragObject dragObject, boolean z5) {
        Objects.toString(view);
        Objects.toString(cellLayout);
        Objects.toString(dragObject);
        if (f6 <= this.f23459x1) {
            View childAt = cellLayout.mShortcutsAndWidgets.getChildAt(iArr[0], iArr[1]);
            if (this.f23457w1) {
                this.f23457w1 = false;
                if (childAt instanceof FolderIcon) {
                    FolderIcon folderIcon = (FolderIcon) childAt;
                    Object obj = dragObject.f16523g;
                    folderIcon.getClass();
                    Objects.toString(obj);
                    ItemInfo itemInfo = (ItemInfo) obj;
                    if (!folderIcon.mFolder.f15617T && folderIcon.m7725m(itemInfo)) {
                        folderIcon.onDrop(dragObject);
                        if (!z5) {
                            R0(this.mDragInfo.f15556a).removeView(this.mDragInfo.f15556a);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // p101l3.InterfaceC2338c
    /* JADX INFO: renamed from: x */
    public final void mo7714x(CellInfo cellInfo, boolean z5) {
        Objects.toString(cellInfo);
        View view = cellInfo.f15556a;
        if (view.isInTouchMode()) {
            this.mDragInfo = cellInfo;
            if (view instanceof FolderIcon) {
                ((FolderIcon) view).setVisibilityGlassBackground(false);
            }
            view.setVisibility(4);
            CellLayout cellLayout = (CellLayout) view.getParent().getParent();
            cellLayout.getClass();
            Objects.toString(view);
            cellLayout.markCellsAsUnoccupiedForView(view);
            Objects.toString(view);
            Objects.toString(this);
            y0(view, new Point(), this, z5);
        }
    }

    public final void x0(ItemInfo itemInfo, CellLayout cellLayout, DragView dragView, Runnable runnable, int i6, AppWidgetHostView appWidgetHostView) {
        Objects.toString(itemInfo);
        Objects.toString(cellLayout);
        Objects.toString(dragView);
        Objects.toString(runnable);
        Objects.toString(appWidgetHostView);
        Rect rect = new Rect();
        Launcher launcher = this.f23432V0;
        launcher.getDragLayer().getViewRectRelativeToSelf(dragView, rect);
        float[] fArr = {1.0f, 1.0f};
        int[] iArr = this.f23415J0;
        Objects.toString(dragView);
        Objects.toString(cellLayout);
        Objects.toString(itemInfo);
        int i7 = itemInfo.spanX;
        int i8 = itemInfo.spanY;
        int i9 = iArr[0];
        int i10 = iArr[1];
        Objects.toString(cellLayout);
        Rect rect2 = new Rect();
        cellLayout.cellToRect(i9, i10, i7, i8, rect2);
        int[] iArr2 = {rect2.left, rect2.top};
        setFinalTransitionTransform(cellLayout);
        float descendantCoordRelativeToSelf = launcher.getDragLayer().getDescendantCoordRelativeToSelf(cellLayout, iArr2, true);
        Objects.toString(cellLayout);
        iArr2[0] = iArr2[0] - ((int) (((double) ((dragView.getMeasuredWidth() - (rect2.width() * descendantCoordRelativeToSelf)) / 2.0f)) - Math.ceil(cellLayout.getUnusedHorizontalSpace() / 2.0f)));
        iArr2[1] = iArr2[1] - ((int) ((dragView.getMeasuredHeight() - (descendantCoordRelativeToSelf * rect2.height())) / 2.0f));
        int integer = launcher.getResources().getInteger(R.integer.config_dropAnimMaxDuration) - 200;
        int i11 = itemInfo.itemType;
        boolean z5 = i11 == 4 || i11 == 5;
        if (appWidgetHostView == null && z5) {
            fArr[1] = 1.0f;
            fArr[0] = 1.0f;
        }
        DragLayer dragLayer = launcher.getDragLayer();
        if (i6 == 4) {
            launcher.getDragLayer().animateViewIntoPosition(dragView, iArr2, 0.0f, 0.1f, 0.1f, 0, runnable, integer);
        } else {
            dragLayer.animateViewIntoPosition(dragView, rect.left, rect.top, iArr2[0], iArr2[1], 1.0f, 1.0f, 1.0f, fArr[0], fArr[1], new MergedModelRunnable(appWidgetHostView, runnable, 18, false), i6 == 1 ? 2 : 0, integer, this);
        }
    }

    public final void y0(View view, Point point, DragSource dragSource, boolean z5) {
        boolean z6;
        Point point2;
        Rect rect;
        int i6;
        Objects.toString(view);
        Objects.toString(point);
        Objects.toString(dragSource);
        view.clearFocus();
        view.setPressed(false);
        Launcher launcher = this.f23432V0;
        launcher.onDragStarted(view);
        AtomicInteger atomicInteger = new AtomicInteger(2);
        Bitmap bitmapE0 = E0(view, atomicInteger);
        int width = bitmapE0.getWidth();
        int height = bitmapE0.getHeight();
        DragLayer dragLayer = launcher.getDragLayer();
        int[] iArr = this.m1;
        float locationInDragLayer = dragLayer.getLocationInDragLayer(view, iArr);
        float f6 = width;
        int iRound = Math.round(iArr[0] - ((f6 - (view.getWidth() * locationInDragLayer)) / 2.0f));
        float f7 = height;
        int iRound2 = Math.round((iArr[1] - ((f7 - (locationInDragLayer * f7)) / 2.0f)) - (atomicInteger.get() / 2.0f));
        boolean z7 = view instanceof BubbleTextView;
        DeviceProfile deviceProfile = this.grid;
        if (z7) {
            BubbleTextView bubbleTextView = (BubbleTextView) view;
            int i7 = deviceProfile.f15978D;
            int paddingTop = view.getPaddingTop();
            int i8 = (width - i7) / 2;
            int i9 = i8 + i7;
            int i10 = i7 + paddingTop;
            if (bubbleTextView.f15402p) {
                iRound = bubbleTextView.getIcon().getBounds().contains(point.x, point.y) ? Math.round(iArr[0]) : Math.round((iArr[0] + point.x) - (f6 / 2.0f));
            }
            Point point3 = new Point((-atomicInteger.get()) / 2, atomicInteger.get() / 2);
            Rect rect2 = new Rect(i8, paddingTop, i9, i10);
            point2 = point3;
            rect = rect2;
            i6 = iRound2 + paddingTop;
            z6 = false;
        } else {
            if (view instanceof FolderIcon) {
                int i11 = deviceProfile.f15984J;
                z6 = false;
                point2 = new Point((-atomicInteger.get()) / 2, (atomicInteger.get() / 2) - view.getPaddingTop());
                rect = new Rect(0, view.getPaddingTop(), view.getWidth(), i11);
            } else {
                z6 = false;
                point2 = null;
                rect = null;
            }
            i6 = iRound2;
        }
        int i12 = iRound;
        if (z7) {
            ((BubbleTextView) view).setStayPressed(z6);
        }
        if (view.getTag() == null || !(view.getTag() instanceof ItemInfo)) {
            throw new IllegalStateException("Drag started with a view that has no tag set. This will cause a crash (issue 11627249) down the line. View: " + view + "  tag: " + view.getTag());
        }
        if (view.getParent() instanceof ShortcutAndWidgetContainer) {
            this.f23399B0 = (ShortcutAndWidgetContainer) view.getParent();
        }
        this.f23434X0.startDrag(bitmapE0, i12, i6, dragSource, view.getTag(), 0, point2, rect, locationInDragLayer, z5).setIntrinsicIconScaleFactor(dragSource.getIntrinsicIconScaleFactor());
        bitmapE0.recycle();
    }

    /* JADX WARN: Code duplicated, block: B:72:0x018c  */
    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: z */
    public final void mo7614z(DragObject dragObject) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        char c6;
        char c7;
        CellLayout currentDropLayout;
        int i6;
        char c8;
        int i7;
        char c9;
        CellLayout cellLayout;
        int i8;
        int i9;
        Objects.toString(dragObject);
        if (this.f23448l1) {
            return;
        }
        WorkspaceState workspaceState = this.mState;
        WorkspaceState workspaceState2 = WorkspaceState.f15305k;
        WorkspaceState workspaceState3 = WorkspaceState.f15307m;
        if (workspaceState == workspaceState2 || workspaceState == workspaceState3) {
            Rect rect = new Rect();
            ItemInfo itemInfo = (ItemInfo) dragObject.f16523g;
            if (itemInfo == null) {
                WeakReference weakReference = LauncherAppState.f16215h;
                return;
            }
            if (itemInfo.spanX < 0 || itemInfo.spanY < 0) {
                throw new RuntimeException("Improper spans found");
            }
            this.f23437a1 = dragObject.getVisualCenter(this.f23437a1);
            CellInfo cellInfo = this.mDragInfo;
            View view = cellInfo == null ? null : cellInfo.f15556a;
            boolean zT1 = t1();
            Launcher launcher = this.f23432V0;
            int i10 = 2;
            if (zT1) {
                CellLayout layout = (launcher.getHotseat() == null || !Z0(dragObject.f16517a, dragObject.f16518b, rect)) ? null : launcher.getHotseat().getLayout();
                if (layout == null) {
                    DragView dragView = dragObject.f16522f;
                    float f6 = dragObject.f16517a;
                    float f7 = dragObject.f16518b;
                    Objects.toString(dragView);
                    int childCount = getChildCount();
                    float f8 = Float.MAX_VALUE;
                    int i11 = 0;
                    CellLayout cellLayout2 = null;
                    while (true) {
                        if (i11 >= childCount) {
                            c6 = 0;
                            c7 = 1;
                            layout = cellLayout2;
                            break;
                        }
                        c7 = 1;
                        if (((Long) this.f23403D0.get(i11)).longValue() == -301) {
                            i9 = childCount;
                        } else {
                            CellLayout cellLayout3 = (CellLayout) getChildAt(i11);
                            c6 = 0;
                            float[] fArr = new float[i10];
                            fArr[0] = f6;
                            fArr[1] = f7;
                            Matrix matrix = cellLayout3.getMatrix();
                            Matrix matrix2 = this.f23439c1;
                            matrix.invert(matrix2);
                            b1(cellLayout3, fArr, matrix2);
                            float f9 = fArr[0];
                            if (f9 >= 0.0f && f9 <= cellLayout3.getWidth()) {
                                float f10 = fArr[1];
                                if (f10 >= 0.0f && f10 <= cellLayout3.getHeight()) {
                                    layout = cellLayout3;
                                    break;
                                }
                            }
                            float width = cellLayout3.getWidth() / 2;
                            float[] fArr2 = this.f23438b1;
                            fArr2[0] = width;
                            fArr2[1] = cellLayout3.getHeight() / 2;
                            Objects.toString(cellLayout3);
                            i9 = childCount;
                            fArr2[0] = fArr2[0] + cellLayout3.getLeft();
                            fArr2[1] = fArr2[1] + cellLayout3.getTop();
                            fArr[0] = f6;
                            fArr[1] = f7;
                            float f11 = f6 - fArr2[0];
                            float f12 = fArr2[1];
                            float f13 = f12 - f12;
                            float f14 = (f13 * f13) + (f11 * f11);
                            if (f14 < f8) {
                                f8 = f14;
                                cellLayout2 = cellLayout3;
                            }
                        }
                        i11++;
                        childCount = i9;
                        i10 = 2;
                    }
                } else {
                    c6 = 0;
                    c7 = 1;
                }
                if (layout != this.f23429S0) {
                    setCurrentDropLayout(layout);
                    setCurrentDragOverlappingLayout(layout);
                    if (this.mState == workspaceState3) {
                        if (launcher.isHotseatLayout(layout)) {
                            ((Alarm) this.f23441e1.f19377k).cancelAlarm();
                        } else {
                            C2333e c2333e = this.f23441e1;
                            CellLayout cellLayout4 = this.f23429S0;
                            Alarm alarm = (Alarm) c2333e.f19377k;
                            alarm.cancelAlarm();
                            alarm.setAlarm(cellLayout4 == null ? 950L : 500L);
                            c2333e.f19378l = cellLayout4;
                        }
                    }
                }
            } else {
                c6 = 0;
                c7 = 1;
                if (launcher.getHotseat() != null) {
                    Object obj = dragObject.f16523g;
                    if ((obj instanceof LauncherAppWidgetInfo) || (obj instanceof C0351g) || !Z0(dragObject.f16517a, dragObject.f16518b, rect)) {
                        currentDropLayout = null;
                    } else {
                        currentDropLayout = launcher.getHotseat().getLayout();
                    }
                } else {
                    currentDropLayout = null;
                }
                if (currentDropLayout == null) {
                    currentDropLayout = getCurrentDropLayout();
                }
                if (currentDropLayout != this.f23429S0) {
                    setCurrentDropLayout(currentDropLayout);
                    setCurrentDragOverlappingLayout(currentDropLayout);
                }
            }
            CellLayout cellLayout5 = this.f23429S0;
            if (cellLayout5 != null) {
                if (launcher.isHotseatLayout(cellLayout5)) {
                    c1(launcher.getHotseat(), this.f23437a1);
                } else {
                    b1(this.f23429S0, this.f23437a1, null);
                }
                int i12 = itemInfo.spanX;
                int i13 = itemInfo.spanY;
                int i14 = itemInfo.minSpanX;
                if (i14 <= 0 || (i8 = itemInfo.minSpanY) <= 0) {
                    i6 = i13;
                } else {
                    i12 = i14;
                    i6 = i8;
                }
                float[] fArr3 = this.f23437a1;
                int i15 = i12;
                int[] iArrL0 = L0((int) fArr3[c6], (int) fArr3[c7], i15, i6, this.f23429S0, this.f23415J0);
                int i16 = i6;
                this.f23415J0 = iArrL0;
                int i17 = iArrL0[c6];
                int i18 = iArrL0[c7];
                if (i17 == this.f23417K0 && i18 == this.f23419L0) {
                    c8 = 0;
                } else {
                    this.f23417K0 = i17;
                    this.f23419L0 = i18;
                    c8 = 0;
                    setDragMode(0);
                }
                CellLayout cellLayout6 = this.f23429S0;
                float[] fArr4 = this.f23437a1;
                float distanceFromCell = cellLayout6.getDistanceFromCell(fArr4[c8], fArr4[c7], this.f23415J0);
                CellLayout cellLayout7 = this.f23429S0;
                int[] iArr = this.f23415J0;
                Objects.toString(cellLayout7);
                Objects.toString(dragObject);
                if (distanceFromCell > this.f23459x1) {
                    i7 = 0;
                    c9 = 1;
                } else {
                    CellLayout cellLayout8 = this.f23429S0;
                    int[] iArr2 = this.f23415J0;
                    View childAt = cellLayout8.mShortcutsAndWidgets.getChildAt(iArr2[0], iArr2[c7]);
                    ItemInfo itemInfo2 = (ItemInfo) dragObject.f16523g;
                    boolean zS1 = s1(childAt, itemInfo2, false);
                    if (this.f23400B1 == 0 && zS1) {
                        Alarm alarm2 = this.r1;
                        if (!alarm2.f16207n) {
                            FolderCreationAlarmListener folderCreationAlarmListener = new FolderCreationAlarmListener(this, cellLayout7, iArr[0], iArr[c7]);
                            if (dragObject.f16525i) {
                                folderCreationAlarmListener.mo7775h(alarm2);
                            } else {
                                alarm2.f16206m = folderCreationAlarmListener;
                                alarm2.setAlarm(0L);
                            }
                            RunnableC0674C runnableC0674C = dragObject.f16529m;
                            if (runnableC0674C != null) {
                                runnableC0674C.m1502a(C2341f.m9173L(getContext(), childAt));
                            }
                            i7 = 0;
                            c9 = 1;
                        }
                    }
                    boolean zR1 = r1(childAt, itemInfo2);
                    if (zR1 && this.f23400B1 == 0) {
                        FolderIcon folderIcon = (FolderIcon) childAt;
                        this.f23454u1 = folderIcon;
                        folderIcon.getClass();
                        Objects.toString(itemInfo2);
                        if (!folderIcon.mFolder.f15617T && folderIcon.m7725m(itemInfo2)) {
                            CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) folderIcon.getLayoutParams();
                            CellLayout cellLayout9 = (CellLayout) folderIcon.getParent().getParent();
                            FolderRingAnimator folderRingAnimator = folderIcon.mFolderRingAnimator;
                            int i19 = cellLayoutLayoutParams.f15685a;
                            int i20 = cellLayoutLayoutParams.f15686b;
                            folderRingAnimator.f15320a = i19;
                            folderRingAnimator.f15321b = i20;
                            Objects.toString(cellLayout9);
                            folderRingAnimator.f15322c = cellLayout9;
                            folderIcon.mFolderRingAnimator.animateToAcceptState();
                            cellLayout9.showFolderAccept(folderIcon.mFolderRingAnimator);
                            MergedItemCallbacks mergedItemCallbacks = folderIcon.f15648F;
                            Alarm alarm3 = folderIcon.mOpenAlarm;
                            alarm3.f16206m = mergedItemCallbacks;
                            if ((itemInfo2 instanceof AppInfo) || (itemInfo2 instanceof ShortcutInfo)) {
                                alarm3.setAlarm(800L);
                            }
                            folderIcon.f15647E = itemInfo2;
                        }
                        setDragMode(2);
                        RunnableC0674C runnableC0674C2 = dragObject.f16529m;
                        if (runnableC0674C2 != null) {
                            runnableC0674C2.m1502a(C2341f.m9173L(getContext(), childAt));
                        }
                        i7 = 0;
                        c9 = 1;
                    } else {
                        if (this.f23400B1 != 2 || zR1) {
                            i7 = 0;
                        } else {
                            i7 = 0;
                            setDragMode(0);
                        }
                        c9 = 1;
                        if (this.f23400B1 == 1 && !zS1) {
                            setDragMode(i7);
                        }
                    }
                }
                CellLayout cellLayout10 = this.f23429S0;
                float[] fArr5 = this.f23437a1;
                int i21 = (int) fArr5[i7];
                int i22 = (int) fArr5[c9];
                int i23 = itemInfo.spanX;
                int i24 = itemInfo.spanY;
                int[] iArr3 = this.f23415J0;
                cellLayout10.getClass();
                Objects.toString(view);
                int[] iArrFindNearestArea = cellLayout10.findNearestArea(i21, i22, i23, i24, i23, i24, false, iArr3, null);
                int i25 = iArrFindNearestArea[0];
                int i26 = iArrFindNearestArea[1];
                View view2 = view;
                ArrayList arrayList = cellLayout10.f15461P;
                cellLayout10.getViewsIntersectingRegion(i25, i26, i23, i24, view2, null, arrayList);
                boolean zIsEmpty = arrayList.isEmpty();
                int i27 = this.f23400B1;
                if (i27 == 0 || i27 == 3) {
                    Alarm alarm4 = this.f23452s1;
                    if (!alarm4.f16207n && (this.f23402C1 != i17 || this.f23404D1 != i18)) {
                        CellLayout cellLayout11 = this.f23429S0;
                        float[] fArr6 = this.f23437a1;
                        cellLayout11.m7626A((int) fArr6[0], (int) fArr6[1], i15, i16, itemInfo.spanX, itemInfo.spanY, view2, this.f23415J0, new int[2], 0);
                        alarm4.f16206m = new MergedLruCache(this, i15, i16, itemInfo.spanX, itemInfo.spanY, view2);
                        alarm4.setAlarm(350L);
                    }
                }
                int i28 = this.f23400B1;
                if ((i28 == 1 || i28 == 2 || zIsEmpty) && (cellLayout = this.f23429S0) != null) {
                    cellLayout.revertTempState();
                }
            }
        }
    }

    public final void z0() {
        FolderIcon folderIcon = this.f23454u1;
        if (folderIcon != null) {
            folderIcon.getClass();
            folderIcon.mFolderRingAnimator.animateToNaturalState();
            folderIcon.mOpenAlarm.cancelAlarm();
            this.f23454u1 = null;
        }
    }
}
