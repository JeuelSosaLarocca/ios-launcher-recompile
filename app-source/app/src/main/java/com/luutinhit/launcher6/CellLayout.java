package com.luutinhit.launcher6;

import A2.C0022a;
import B3.C0044L;
import B3.RunnableC0064g;
import W4.AbstractC1154e;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Parcelable;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcher6.util.CustomIconView;
import com.luutinhit.launcherios.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;
import p014P.AbstractC0758N;
import p101l3.AbstractViewOnClickListenerC2336a;
import p101l3.C2337b;
import p101l3.C2341f;

/* JADX INFO: loaded from: classes.dex */
public class CellLayout extends ViewGroup implements PagedViewMarker {

    /* JADX INFO: renamed from: b0 */
    public static final Paint f23325b0 = new Paint();

    /* JADX INFO: renamed from: A */
    public int[] f15446A;

    /* JADX INFO: renamed from: B */
    public float mBackgroundAlpha;

    /* JADX INFO: renamed from: C */
    public TransitionDrawable f15448C;

    /* JADX INFO: renamed from: D */
    public int f15449D;

    /* JADX INFO: renamed from: E */
    public int f15450E;

    /* JADX INFO: renamed from: F */
    public boolean mIsDragOverlapping;

    /* JADX INFO: renamed from: G */
    public HashMap f15452G;

    /* JADX INFO: renamed from: H */
    public HashMap f15453H;

    /* JADX INFO: renamed from: I */
    public boolean mItemPlacementDirty;

    /* JADX INFO: renamed from: J */
    public int[] f15455J;

    /* JADX INFO: renamed from: K */
    public boolean f15456K;

    /* JADX INFO: renamed from: L */
    public ShortcutAndWidgetContainer mShortcutsAndWidgets;

    /* JADX INFO: renamed from: M */
    public boolean f15458M;

    /* JADX INFO: renamed from: N */
    public float f15459N;

    /* JADX INFO: renamed from: O */
    public float f15460O;

    /* JADX INFO: renamed from: P */
    public ArrayList f15461P;

    /* JADX INFO: renamed from: Q */
    public Rect f15462Q;

    /* JADX INFO: renamed from: R */
    public int[] f15463R;

    /* JADX INFO: renamed from: S */
    public int[] f15464S;

    /* JADX INFO: renamed from: T */
    public Rect f15465T;

    /* JADX INFO: renamed from: U */
    public AbstractViewOnClickListenerC2336a f15466U;

    /* JADX INFO: renamed from: V */
    public boolean f15467V;

    /* JADX INFO: renamed from: W */
    public DeviceProfile grid;

    /* JADX INFO: renamed from: a0 */
    public Stack f23326a0;

    /* JADX INFO: renamed from: j */
    public Launcher f15469j;

    /* JADX INFO: renamed from: k */
    public int mCellWidth;

    /* JADX INFO: renamed from: l */
    public int mCellHeight;

    /* JADX INFO: renamed from: m */
    public int f15472m;

    /* JADX INFO: renamed from: n */
    public int f15473n;

    /* JADX INFO: renamed from: o */
    public int mCountX;

    /* JADX INFO: renamed from: p */
    public int mCountY;

    /* JADX INFO: renamed from: q */
    public boolean mDropPending;

    /* JADX INFO: renamed from: r */
    public boolean f15477r;

    /* JADX INFO: renamed from: s */
    public boolean f15478s;

    /* JADX INFO: renamed from: t */
    public int[] f15479t;

    /* JADX INFO: renamed from: u */
    public int[] f15480u;

    /* JADX INFO: renamed from: v */
    public boolean[][] f15481v;

    /* JADX INFO: renamed from: w */
    public boolean[][] f15482w;

    /* JADX INFO: renamed from: x */
    public View.OnTouchListener f15483x;

    /* JADX INFO: renamed from: y */
    public StylusEventHelper f15484y;

    /* JADX INFO: renamed from: z */
    public ArrayList f15485z;

    public CellLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mDropPending = false;
        this.f15477r = true;
        this.f15478s = true;
        this.f15479t = new int[2];
        this.f15480u = new int[2];
        this.f15485z = new ArrayList();
        this.f15446A = new int[]{-1, -1};
        this.f15449D = -1;
        this.f15450E = -1;
        this.mIsDragOverlapping = false;
        this.f15452G = new HashMap();
        this.f15453H = new HashMap();
        this.mItemPlacementDirty = false;
        this.f15455J = new int[2];
        this.f15456K = false;
        this.f15458M = false;
        this.f15459N = 1.0f;
        this.f15461P = new ArrayList();
        this.f15462Q = new Rect();
        this.f15463R = new int[2];
        this.f15464S = new int[]{-100, -100};
        this.f15465T = new Rect();
        this.f15467V = false;
        this.f23326a0 = new Stack();
        setWillNotDraw(false);
        setClipToPadding(false);
        setClipChildren(false);
        Launcher launcher = (Launcher) context;
        this.f15469j = launcher;
        DeviceProfile deviceProfile = launcher.getDeviceProfile();
        this.grid = deviceProfile;
        this.mCellHeight = -1;
        this.mCellWidth = -1;
        this.f15473n = -1;
        this.f15472m = -1;
        InvariantDeviceProfile invariantDeviceProfile = deviceProfile.inv;
        int i6 = invariantDeviceProfile.f16712d;
        this.mCountX = i6;
        int i7 = invariantDeviceProfile.f16711c;
        this.mCountY = i7;
        int[] iArr = {i6, i7};
        Class cls = Boolean.TYPE;
        this.f15481v = (boolean[][]) Array.newInstance((Class<?>) cls, iArr);
        this.f15482w = (boolean[][]) Array.newInstance((Class<?>) cls, this.mCountX, this.mCountY);
        setAlwaysDrawnWithCacheEnabled(false);
        Resources resources = getResources();
        this.f15459N = deviceProfile.f15992R / deviceProfile.f15978D;
        TransitionDrawable transitionDrawable = (TransitionDrawable) resources.getDrawable(R.drawable.bg_screenpanel);
        this.f15448C = transitionDrawable;
        transitionDrawable.setCallback(this);
        transitionDrawable.setAlpha((int) (this.mBackgroundAlpha * 255.0f));
        this.f15460O = deviceProfile.f15978D * 0.12f;
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = new ShortcutAndWidgetContainer(context);
        this.mShortcutsAndWidgets = shortcutAndWidgetContainer;
        shortcutAndWidgetContainer.m8046j(this.mCellWidth, this.mCellHeight, this.mCountX, this.mCountY);
        this.f15484y = new StylusEventHelper(this);
        addView(shortcutAndWidgetContainer);
    }

    /* JADX INFO: renamed from: j */
    public static void computeDirectionVector(float f6, float f7, int[] iArr) {
        double dAtan = Math.atan(f7 / f6);
        iArr[0] = 0;
        iArr[1] = 0;
        if (Math.abs(Math.cos(dAtan)) > 0.5d) {
            iArr[0] = (int) Math.signum(f6);
        }
        if (Math.abs(Math.sin(dAtan)) > 0.5d) {
            iArr[1] = (int) Math.signum(f7);
        }
    }

    public void setUseTempCoords(boolean z5) {
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            ((CellLayoutLayoutParams) shortcutAndWidgetContainer.getChildAt(i6).getLayoutParams()).f15689e = z5;
        }
    }

    /* JADX INFO: renamed from: A */
    public final int[] m7626A(int i6, int i7, int i8, int i9, int i10, int i11, View view, int[] iArr, int[] iArr2, int i12) {
        int i13;
        int i14;
        char c6;
        Objects.toString(view);
        CellLayout cellLayout = this;
        int[] iArrFindNearestArea = cellLayout.findNearestArea(i6, i7, i10, i11, i10, i11, false, iArr, null);
        int[] iArr3 = iArr2 == null ? new int[2] : iArr2;
        int[] iArr4 = cellLayout.f15464S;
        int[] iArr5 = cellLayout.f15463R;
        if ((i12 == 2 || i12 == 3 || i12 == 4) && (i13 = iArr4[0]) != -100) {
            iArr5[0] = i13;
            iArr5[1] = iArr4[1];
            if (i12 == 2 || i12 == 3) {
                iArr4[0] = -100;
                iArr4[1] = -100;
            }
            i14 = i10;
            c6 = 1;
        } else {
            Objects.toString(view);
            int[] iArr6 = new int[2];
            c6 = 1;
            cellLayout.findNearestArea(i6, i7, i10, i11, i10, i11, false, iArr6, null);
            Rect rect = new Rect();
            cellLayout = this;
            cellLayout.regionToRect(iArr6[0], iArr6[1], i10, i11, rect);
            rect.offset(i6 - rect.centerX(), i7 - rect.centerY());
            Rect rect2 = new Rect();
            cellLayout.getViewsIntersectingRegion(iArr6[0], iArr6[1], i10, i11, view, rect2, cellLayout.f15461P);
            i14 = i10;
            int iWidth = rect2.width();
            int iHeight = rect2.height();
            cellLayout.regionToRect(rect2.left, rect2.top, rect2.width(), rect2.height(), rect2);
            int iCenterX = (rect2.centerX() - i6) / i14;
            int iCenterY = (rect2.centerY() - i7) / i11;
            int i15 = cellLayout.mCountX;
            if (iWidth == i15 || i14 == i15) {
                iCenterX = 0;
            }
            int i16 = cellLayout.mCountY;
            if (iHeight == i16 || i11 == i16) {
                iCenterY = 0;
            }
            if (iCenterX == 0 && iCenterY == 0) {
                iArr5[0] = 1;
                iArr5[1] = 0;
            } else {
                computeDirectionVector(iCenterX, iCenterY, iArr5);
            }
            iArr4[0] = iArr5[0];
            iArr4[1] = iArr5[1];
        }
        ItemConfiguration itemConfigurationM7649r = cellLayout.m7649r(i6, i7, i8, i9, i14, i11, cellLayout.f15463R, view, true, new ItemConfiguration(cellLayout));
        ItemConfiguration itemConfiguration = new ItemConfiguration(cellLayout);
        Objects.toString(view);
        Objects.toString(itemConfiguration);
        int[] iArr7 = new int[2];
        int[] iArr8 = new int[2];
        cellLayout.findNearestArea(i6, i7, i8, i9, i10, i11, true, iArr7, iArr8);
        if (iArr7[0] < 0 || iArr7[c6] < 0) {
            itemConfiguration.f15670e = false;
        } else {
            cellLayout.copyCurrentStateToSolution(itemConfiguration);
            itemConfiguration.f15671f = iArr7[0];
            itemConfiguration.f15672g = iArr7[c6];
            itemConfiguration.f15673h = iArr8[0];
            itemConfiguration.f15674i = iArr8[c6];
            itemConfiguration.f15670e = true;
        }
        if (!itemConfigurationM7649r.f15670e || itemConfigurationM7649r.f15673h * itemConfigurationM7649r.f15674i < itemConfiguration.f15673h * itemConfiguration.f15674i) {
            itemConfigurationM7649r = itemConfiguration.f15670e ? itemConfiguration : null;
        }
        if (i12 == 0) {
            if (itemConfigurationM7649r == null) {
                iArr3[1] = -1;
                iArr3[0] = -1;
                iArrFindNearestArea[1] = -1;
                iArrFindNearestArea[0] = -1;
                return iArrFindNearestArea;
            }
            cellLayout.m7638f(itemConfigurationM7649r, view, 0);
            iArrFindNearestArea[0] = itemConfigurationM7649r.f15671f;
            iArrFindNearestArea[1] = itemConfigurationM7649r.f15672g;
            iArr3[0] = itemConfigurationM7649r.f15673h;
            iArr3[1] = itemConfigurationM7649r.f15674i;
            return iArrFindNearestArea;
        }
        boolean z5 = true;
        boolean z6 = false;
        cellLayout.setUseTempCoords(true);
        if (itemConfigurationM7649r != null) {
            iArrFindNearestArea[0] = itemConfigurationM7649r.f15671f;
            iArrFindNearestArea[1] = itemConfigurationM7649r.f15672g;
            iArr3[0] = itemConfigurationM7649r.f15673h;
            iArr3[1] = itemConfigurationM7649r.f15674i;
            if (i12 == 1 || i12 == 2 || i12 == 3) {
                cellLayout.copySolutionToTempState(itemConfigurationM7649r, view);
                cellLayout.setItemPlacementDirty(true);
                cellLayout.animateItemsToSolution(itemConfigurationM7649r, view, i12 == 2);
                if (i12 == 2 || i12 == 3) {
                    cellLayout.commitTempPlacement();
                    cellLayout.completeAndClearReorderPreviewAnimations();
                    z6 = false;
                    cellLayout.setItemPlacementDirty(false);
                } else {
                    cellLayout.m7638f(itemConfigurationM7649r, view, 1);
                    z6 = false;
                }
            } else {
                z6 = false;
            }
        } else {
            iArr3[1] = -1;
            iArr3[0] = -1;
            iArrFindNearestArea[1] = -1;
            iArrFindNearestArea[0] = -1;
            z5 = false;
        }
        if (i12 == 2 || !z5) {
            cellLayout.setUseTempCoords(z6);
        }
        cellLayout.mShortcutsAndWidgets.requestLayout();
        return iArrFindNearestArea;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x019d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0193 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x0193 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0137  */
    /* JADX WARN: Code duplicated, block: B:56:0x013c  */
    /* JADX WARN: Code duplicated, block: B:59:0x0145  */
    /* JADX WARN: Code duplicated, block: B:62:0x014e A[LOOP:4: B:57:0x013e->B:62:0x014e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x0152  */
    /* JADX WARN: Code duplicated, block: B:66:0x015b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0162 A[LOOP:6: B:64:0x0154->B:69:0x0162, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:70:0x0165  */
    /* JADX WARN: Code duplicated, block: B:73:0x016e  */
    /* JADX WARN: Code duplicated, block: B:76:0x017a A[LOOP:7: B:71:0x0167->B:76:0x017a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x017f  */
    /* JADX WARN: Code duplicated, block: B:80:0x018a  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c9 A[LOOP:8: B:78:0x0183->B:86:0x01c9, LOOP_END] */
    /* JADX INFO: renamed from: B */
    public final boolean pushViewsToTempLocation(ArrayList arrayList, Rect rect, int[] iArr, View view, ItemConfiguration itemConfiguration) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i6;
        int i7;
        HashMap map;
        HashMap map2;
        boolean z5;
        ArrayList arrayList2;
        int i8;
        int i9;
        int[] iArr2;
        ArrayList arrayList3 = null;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr3;
        CellLayout cellLayout = this;
        Objects.toString(arrayList);
        Objects.toString(rect);
        Objects.toString(view);
        Objects.toString(itemConfiguration);
        ViewCluster viewCluster = new ViewCluster(cellLayout, arrayList, itemConfiguration);
        Rect rectM7754b = viewCluster.m7754b();
        int i14 = iArr[0];
        int i15 = 3;
        int i16 = 2;
        int i17 = 1;
        if (i14 < 0) {
            i6 = rectM7754b.right - rect.left;
            i7 = 0;
        } else if (i14 > 0) {
            i6 = rect.right - rectM7754b.left;
            i7 = 2;
        } else if (iArr[1] < 0) {
            i6 = rectM7754b.bottom - rect.top;
            i7 = 1;
        } else {
            i6 = rect.bottom - rectM7754b.top;
            i7 = 3;
        }
        if (i6 <= 0) {
            return false;
        }
        int i18 = 0;
        for (int size = arrayList.size(); i18 < size; size = size) {
            int i19 = i18 + 1;
            CellAndSpan cellAndSpan = (CellAndSpan) itemConfiguration.f15666a.get((View) arrayList.get(i18));
            cellLayout.m7655x(cellAndSpan.f15518a, cellAndSpan.f15519b, cellAndSpan.f15520c, cellAndSpan.f15521d, cellLayout.f15482w, false);
            i18 = i19;
        }
        HashMap map3 = itemConfiguration.f15666a;
        Iterator it = map3.keySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            map = itemConfiguration.f15667b;
            if (!zHasNext) {
                break;
            }
            View view2 = (View) it.next();
            CellAndSpan cellAndSpan2 = (CellAndSpan) map3.get(view2);
            CellAndSpan cellAndSpan3 = (CellAndSpan) map.get(view2);
            cellAndSpan2.getClass();
            Objects.toString(cellAndSpan3);
            cellAndSpan3.f15518a = cellAndSpan2.f15518a;
            cellAndSpan3.f15519b = cellAndSpan2.f15519b;
            cellAndSpan3.f15520c = cellAndSpan2.f15520c;
            cellAndSpan3.f15521d = cellAndSpan2.f15521d;
        }
        PushedViewsComparator pushedViewsComparator = viewCluster.f15760m;
        pushedViewsComparator.f15737j = i7;
        Collections.sort(viewCluster.f15749b.f15668c, pushedViewsComparator);
        boolean z6 = false;
        while (true) {
            map2 = itemConfiguration.f15666a;
            if (i6 <= 0 || z6) {
                break;
            }
            ArrayList arrayList4 = itemConfiguration.f15668c;
            int size2 = arrayList4.size();
            int i20 = 0;
            while (i20 < size2) {
                int i21 = i20 + 1;
                View view3 = (View) arrayList4.get(i20);
                if (viewCluster.f15748a.contains(view3) || view3 == view) {
                    arrayList2 = arrayList4;
                    i8 = size2;
                } else {
                    Objects.toString(view3);
                    CellAndSpan cellAndSpan4 = (CellAndSpan) viewCluster.f15749b.f15666a.get(view3);
                    if (i7 == 0) {
                        i9 = 1;
                        boolean z7 = viewCluster.f15755h;
                        iArr2 = viewCluster.f15751d;
                        if (z7) {
                            viewCluster.m7753a(iArr2, 0);
                        }
                        if (i7 != 0) {
                            arrayList3 = arrayList4;
                            i10 = cellAndSpan4.f15519b;
                            while (true) {
                                if (i10 < cellAndSpan4.f15519b + cellAndSpan4.f15521d) {
                                    arrayList2 = arrayList3;
                                    i8 = size2;
                                } else if (iArr2[i10] == cellAndSpan4.f15518a + cellAndSpan4.f15520c) {
                                    i10++;
                                }
                            }
                        } else if (i7 != i9) {
                            i11 = cellAndSpan4.f15518a;
                            while (true) {
                                if (i11 < cellAndSpan4.f15518a + cellAndSpan4.f15520c) {
                                    arrayList3 = arrayList4;
                                    if (iArr2[i11] == cellAndSpan4.f15519b + cellAndSpan4.f15521d) {
                                        i11++;
                                        arrayList4 = arrayList3;
                                    }
                                } else {
                                    arrayList2 = arrayList4;
                                    i8 = size2;
                                }
                            }
                        } else if (i7 != i16) {
                            if (i7 == 3) {
                                i13 = cellAndSpan4.f15518a;
                                while (true) {
                                    if (i13 < cellAndSpan4.f15518a + cellAndSpan4.f15520c) {
                                        if (iArr2[i13] == cellAndSpan4.f15519b) {
                                            arrayList3 = arrayList4;
                                        } else {
                                            i13++;
                                        }
                                    }
                                }
                            }
                            arrayList2 = arrayList4;
                            i8 = size2;
                        } else {
                            i12 = cellAndSpan4.f15519b;
                            while (true) {
                                if (i12 < cellAndSpan4.f15519b + cellAndSpan4.f15521d) {
                                    arrayList2 = arrayList4;
                                    i8 = size2;
                                } else if (iArr2[i12] == cellAndSpan4.f15518a) {
                                    arrayList3 = arrayList4;
                                } else {
                                    i12++;
                                }
                            }
                        }
                        if (!((CellLayoutLayoutParams) view3.getLayoutParams()).f15694j) {
                            z6 = true;
                            break;
                        }
                        Objects.toString(view3);
                        viewCluster.f15748a.add(view3);
                        viewCluster.m7755c();
                        CellAndSpan cellAndSpan5 = (CellAndSpan) map2.get(view3);
                        arrayList2 = arrayList3;
                        i8 = size2;
                        map2 = map2;
                        cellLayout.m7655x(cellAndSpan5.f15518a, cellAndSpan5.f15519b, cellAndSpan5.f15520c, cellAndSpan5.f15521d, cellLayout.f15482w, false);
                    } else if (i7 != i17) {
                        if (i7 != i16) {
                            boolean z8 = viewCluster.f15758k;
                            iArr3 = viewCluster.f15754g;
                            if (z8) {
                                viewCluster.m7753a(iArr3, i15);
                            }
                        } else {
                            boolean z9 = viewCluster.f15756i;
                            iArr3 = viewCluster.f15752e;
                            if (z9) {
                                viewCluster.m7753a(iArr3, i16);
                            }
                        }
                        iArr2 = iArr3;
                        i9 = 1;
                    } else {
                        boolean z10 = viewCluster.f15757j;
                        int[] iArr4 = viewCluster.f15753f;
                        if (z10) {
                            i9 = 1;
                            viewCluster.m7753a(iArr4, 1);
                        } else {
                            i9 = 1;
                        }
                        iArr2 = iArr4;
                    }
                    if (i7 != 0) {
                        arrayList3 = arrayList4;
                        i10 = cellAndSpan4.f15519b;
                        while (true) {
                            if (i10 < cellAndSpan4.f15519b + cellAndSpan4.f15521d) {
                                arrayList2 = arrayList3;
                                i8 = size2;
                            } else if (iArr2[i10] == cellAndSpan4.f15518a + cellAndSpan4.f15520c) {
                                i10++;
                            }
                        }
                    } else if (i7 != i9) {
                        i11 = cellAndSpan4.f15518a;
                        while (true) {
                            if (i11 < cellAndSpan4.f15518a + cellAndSpan4.f15520c) {
                                arrayList3 = arrayList4;
                                if (iArr2[i11] == cellAndSpan4.f15519b + cellAndSpan4.f15521d) {
                                    i11++;
                                    arrayList4 = arrayList3;
                                }
                            } else {
                                arrayList2 = arrayList4;
                                i8 = size2;
                            }
                        }
                    } else if (i7 != i16) {
                        if (i7 == 3) {
                            i13 = cellAndSpan4.f15518a;
                            while (true) {
                                if (i13 < cellAndSpan4.f15518a + cellAndSpan4.f15520c) {
                                    if (iArr2[i13] == cellAndSpan4.f15519b) {
                                        arrayList3 = arrayList4;
                                    } else {
                                        i13++;
                                    }
                                }
                            }
                        }
                        arrayList2 = arrayList4;
                        i8 = size2;
                    } else {
                        i12 = cellAndSpan4.f15519b;
                        while (true) {
                            if (i12 < cellAndSpan4.f15519b + cellAndSpan4.f15521d) {
                                arrayList2 = arrayList4;
                                i8 = size2;
                            } else if (iArr2[i12] == cellAndSpan4.f15518a) {
                                arrayList3 = arrayList4;
                            } else {
                                i12++;
                            }
                        }
                    }
                    if (!((CellLayoutLayoutParams) view3.getLayoutParams()).f15694j) {
                        z6 = true;
                        break;
                    }
                    Objects.toString(view3);
                    viewCluster.f15748a.add(view3);
                    viewCluster.m7755c();
                    CellAndSpan cellAndSpan6 = (CellAndSpan) map2.get(view3);
                    arrayList2 = arrayList3;
                    i8 = size2;
                    map2 = map2;
                    cellLayout.m7655x(cellAndSpan6.f15518a, cellAndSpan6.f15519b, cellAndSpan6.f15520c, cellAndSpan6.f15521d, cellLayout.f15482w, false);
                }
                map2 = map2;
                arrayList4 = arrayList2;
                size2 = i8;
                i20 = i21;
                i15 = 3;
                i16 = 2;
                i17 = 1;
            }
            i6--;
            ArrayList arrayList5 = viewCluster.f15748a;
            int size3 = arrayList5.size();
            int i22 = 0;
            while (i22 < size3) {
                Object obj = arrayList5.get(i22);
                i22++;
                CellAndSpan cellAndSpan7 = (CellAndSpan) viewCluster.f15749b.f15666a.get((View) obj);
                if (i7 == 0) {
                    cellAndSpan7.f15518a--;
                } else if (i7 == 1) {
                    cellAndSpan7.f15519b--;
                } else if (i7 != 2) {
                    cellAndSpan7.f15519b++;
                } else {
                    cellAndSpan7.f15518a++;
                }
            }
            viewCluster.m7755c();
            i15 = 3;
            i16 = 2;
            i17 = 1;
        }
        Rect rectM7754b2 = viewCluster.m7754b();
        if (z6 || rectM7754b2.left < 0 || rectM7754b2.right > cellLayout.mCountX || rectM7754b2.top < 0 || rectM7754b2.bottom > cellLayout.mCountY) {
            for (View view4 : (Iterable<View>) (Iterable) (map.keySet())) {
                CellAndSpan cellAndSpan8 = (CellAndSpan) map.get(view4);
                CellAndSpan cellAndSpan9 = (CellAndSpan) map2.get(view4);
                cellAndSpan8.getClass();
                Objects.toString(cellAndSpan9);
                cellAndSpan9.f15518a = cellAndSpan8.f15518a;
                cellAndSpan9.f15519b = cellAndSpan8.f15519b;
                cellAndSpan9.f15520c = cellAndSpan8.f15520c;
                cellAndSpan9.f15521d = cellAndSpan8.f15521d;
            }
            z5 = false;
        } else {
            z5 = true;
        }
        ArrayList arrayList6 = viewCluster.f15748a;
        int size4 = arrayList6.size();
        int i23 = 0;
        while (i23 < size4) {
            int i24 = i23 + 1;
            CellAndSpan cellAndSpan10 = (CellAndSpan) map2.get((View) arrayList6.get(i23));
            cellLayout.m7655x(cellAndSpan10.f15518a, cellAndSpan10.f15519b, cellAndSpan10.f15520c, cellAndSpan10.f15521d, cellLayout.f15482w, true);
            cellLayout = this;
            i23 = i24;
        }
        return z5;
    }

    /* JADX INFO: renamed from: C */
    public final void regionToCenterPoint(int i6, int i7, int i8, int i9, int[] iArr) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i10 = this.mCellWidth;
        iArr[0] = ((i8 * i10) / 2) + (i6 * i10) + paddingLeft;
        int i11 = this.mCellHeight;
        iArr[1] = (((i9 * i11) / 2) + ((i7 * i11) + paddingTop)) - (i11 / 4);
    }

    /* JADX INFO: renamed from: D */
    public final void regionToRect(int i6, int i7, int i8, int i9, Rect rect) {
        Objects.toString(rect);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i10 = this.mCellWidth;
        int i11 = (i6 * i10) + paddingLeft;
        int i12 = this.mCellHeight;
        int i13 = (i7 * i12) + paddingTop;
        rect.set(i11, i13, (i8 * i10) + i11, (i9 * i12) + i13);
    }

    /* JADX INFO: renamed from: E */
    public final void revertTempState() {
        completeAndClearReorderPreviewAnimations();
        if (this.mItemPlacementDirty) {
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
            int childCount = shortcutAndWidgetContainer.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = shortcutAndWidgetContainer.getChildAt(i6);
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
                int i7 = cellLayoutLayoutParams.f15687c;
                int i8 = cellLayoutLayoutParams.f15685a;
                if (i7 != i8 || cellLayoutLayoutParams.f15688d != cellLayoutLayoutParams.f15686b) {
                    cellLayoutLayoutParams.f15687c = i8;
                    int i9 = cellLayoutLayoutParams.f15686b;
                    cellLayoutLayoutParams.f15688d = i9;
                    animateChildToPosition(childAt, i8, i9, 150, 0, false, false);
                }
            }
            setItemPlacementDirty(false);
        }
    }

    /* JADX INFO: renamed from: F */
    public final void setGridSize(int i6, int i7) {
        this.mCountX = i6;
        this.mCountY = i7;
        int[] iArr = {i6, i7};
        Class cls = Boolean.TYPE;
        this.f15481v = (boolean[][]) Array.newInstance((Class<?>) cls, iArr);
        this.f15482w = (boolean[][]) Array.newInstance((Class<?>) cls, this.mCountX, this.mCountY);
        this.f23326a0.clear();
        this.mShortcutsAndWidgets.m8046j(this.mCellWidth, this.mCellHeight, this.mCountX, this.mCountY);
        requestLayout();
    }

    /* JADX INFO: renamed from: G */
    public final void showFolderAccept(FolderRingAnimator folderRingAnimator) {
        Objects.toString(folderRingAnimator);
        this.f15485z.add(folderRingAnimator);
        Launcher launcher = this.f15469j;
        if (launcher == null || !launcher.isShaking()) {
            return;
        }
        View childAt = this.mShortcutsAndWidgets.getChildAt(folderRingAnimator.f15320a, folderRingAnimator.f15321b);
        if (childAt != null) {
            childAt.clearAnimation();
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean addViewToCellLayout(View view, int i6, int i7, CellLayoutLayoutParams cellLayoutLayoutParams, boolean z5) {
        int i8;
        Objects.toString(view);
        Objects.toString(cellLayoutLayoutParams);
        if (view != null) {
            try {
                if (view instanceof BubbleTextView) {
                    ((BubbleTextView) view).setTextVisibility(!this.f15458M);
                }
                view.setScaleX(getChildrenScale());
                view.setScaleY(getChildrenScale());
                int i9 = cellLayoutLayoutParams.f15685a;
                if (i9 >= 0) {
                    int i10 = this.mCountX;
                    if (i9 <= i10 - 1 && (i8 = cellLayoutLayoutParams.f15686b) >= 0) {
                        int i11 = this.mCountY;
                        if (i8 <= i11 - 1) {
                            if (cellLayoutLayoutParams.f15690f < 0) {
                                cellLayoutLayoutParams.f15690f = i10;
                            }
                            if (cellLayoutLayoutParams.f15691g < 0) {
                                cellLayoutLayoutParams.f15691g = i11;
                            }
                            view.setId(i7);
                            if (view instanceof LauncherAppWidgetHostView) {
                                float f6 = (((LauncherAppWidgetHostView) view).getLauncherAppWidgetProviderInfo() == null || ((LauncherAppWidgetHostView) view).getLauncherAppWidgetProviderInfo().f16574j <= 1 || ((LauncherAppWidgetHostView) view).getLauncherAppWidgetProviderInfo().f16575k <= 1) ? 1.0f : 0.66f;
                                DeviceProfile deviceProfile = this.grid;
                                int i12 = (int) (deviceProfile.f15977C * f6);
                                ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).rightMargin = i12;
                                ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).leftMargin = i12;
                                ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).topMargin = (this.mCellHeight - deviceProfile.f15978D) - deviceProfile.f15980F;
                                ((ViewGroup.MarginLayoutParams) cellLayoutLayoutParams).bottomMargin = 0;
                            }
                            this.mShortcutsAndWidgets.addView(view, i6, cellLayoutLayoutParams);
                            if (z5) {
                                markCellsAsOccupiedForView(view);
                            }
                            return true;
                        }
                    }
                }
            } catch (Throwable unused) {
                post(new CellLayoutRunnable());
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m7634b(View view, int i6, int i7, int i8, int i9) {
        Objects.toString(view);
        ShortcutAndWidgetContainer shortcutsAndWidgets = getShortcutsAndWidgets();
        boolean[][] zArr = this.f15481v;
        if (shortcutsAndWidgets.indexOfChild(view) == -1) {
            return false;
        }
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        ItemInfo itemInfo = (ItemInfo) view.getTag();
        HashMap map = this.f15452G;
        if (map.containsKey(cellLayoutLayoutParams)) {
            ((Animator) map.get(cellLayoutLayoutParams)).cancel();
            map.remove(cellLayoutLayoutParams);
        }
        int i10 = cellLayoutLayoutParams.f15695k;
        int i11 = cellLayoutLayoutParams.f15696l;
        zArr[cellLayoutLayoutParams.f15685a][cellLayoutLayoutParams.f15686b] = false;
        zArr[i6][i7] = true;
        cellLayoutLayoutParams.f15692h = true;
        cellLayoutLayoutParams.f15689e = false;
        itemInfo.cellX = i6;
        cellLayoutLayoutParams.f15685a = i6;
        itemInfo.cellY = i7;
        cellLayoutLayoutParams.f15686b = i7;
        shortcutsAndWidgets.setupLp(cellLayoutLayoutParams);
        cellLayoutLayoutParams.f15692h = false;
        int i12 = cellLayoutLayoutParams.f15695k;
        int i13 = cellLayoutLayoutParams.f15696l;
        cellLayoutLayoutParams.f15695k = i10;
        cellLayoutLayoutParams.f15696l = i11;
        if (i10 == i12 && i11 == i13) {
            cellLayoutLayoutParams.f15692h = true;
            return true;
        }
        ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
        valueAnimatorM7889c.setDuration(i8);
        map.put(cellLayoutLayoutParams, valueAnimatorM7889c);
        valueAnimatorM7889c.addUpdateListener(new CellLayoutChildAnimUpdateListener(cellLayoutLayoutParams, i10, i12, i11, i13, view, 1));
        valueAnimatorM7889c.addListener(new CellLayoutChildAnimListener(this, cellLayoutLayoutParams, view, 1));
        valueAnimatorM7889c.setStartDelay(i9);
        valueAnimatorM7889c.start();
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean animateChildToPosition(View view, int i6, int i7, int i8, int i9, boolean z5, boolean z6) {
        Objects.toString(view);
        ShortcutAndWidgetContainer shortcutsAndWidgets = getShortcutsAndWidgets();
        boolean[][] zArr = this.f15481v;
        if (!z5) {
            zArr = this.f15482w;
        }
        if (shortcutsAndWidgets.indexOfChild(view) == -1) {
            return false;
        }
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        ItemInfo itemInfo = (ItemInfo) view.getTag();
        HashMap map = this.f15452G;
        if (map.containsKey(cellLayoutLayoutParams)) {
            ((Animator) map.get(cellLayoutLayoutParams)).cancel();
            map.remove(cellLayoutLayoutParams);
        }
        int i10 = cellLayoutLayoutParams.f15695k;
        int i11 = cellLayoutLayoutParams.f15696l;
        if (z6) {
            zArr[cellLayoutLayoutParams.f15685a][cellLayoutLayoutParams.f15686b] = false;
            zArr[i6][i7] = true;
        }
        cellLayoutLayoutParams.f15692h = true;
        if (z5) {
            itemInfo.cellX = i6;
            cellLayoutLayoutParams.f15685a = i6;
            itemInfo.cellY = i7;
            cellLayoutLayoutParams.f15686b = i7;
        } else {
            cellLayoutLayoutParams.f15687c = i6;
            cellLayoutLayoutParams.f15688d = i7;
        }
        shortcutsAndWidgets.setupLp(cellLayoutLayoutParams);
        cellLayoutLayoutParams.f15692h = false;
        int i12 = cellLayoutLayoutParams.f15695k;
        int i13 = cellLayoutLayoutParams.f15696l;
        cellLayoutLayoutParams.f15695k = i10;
        cellLayoutLayoutParams.f15696l = i11;
        if (i10 == i12 && i11 == i13) {
            cellLayoutLayoutParams.f15692h = true;
            return true;
        }
        ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
        valueAnimatorM7889c.setDuration(i8);
        map.put(cellLayoutLayoutParams, valueAnimatorM7889c);
        valueAnimatorM7889c.addUpdateListener(new CellLayoutChildAnimUpdateListener(cellLayoutLayoutParams, i10, i12, i11, i13, view, 0));
        valueAnimatorM7889c.addListener(new CellLayoutChildAnimListener(this, cellLayoutLayoutParams, view, 0));
        valueAnimatorM7889c.setStartDelay(i9);
        valueAnimatorM7889c.start();
        return true;
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).cancelLongPress();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Objects.toString(layoutParams);
        return layoutParams instanceof CellLayoutLayoutParams;
    }

    /* JADX INFO: renamed from: d */
    public final void animateItemsToSolution(ItemConfiguration itemConfiguration, View view, boolean z5) {
        CellAndSpan cellAndSpan;
        boolean[][] zArr;
        Objects.toString(itemConfiguration);
        Objects.toString(view);
        boolean[][] zArr2 = this.f15482w;
        for (int i6 = 0; i6 < this.mCountX; i6++) {
            for (int i7 = 0; i7 < this.mCountY; i7++) {
                zArr2[i6][i7] = false;
            }
        }
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i8);
            if (childAt == view || (cellAndSpan = (CellAndSpan) itemConfiguration.f15666a.get(childAt)) == null) {
                zArr = zArr2;
            } else {
                animateChildToPosition(childAt, cellAndSpan.f15518a, cellAndSpan.f15519b, 150, 0, false, false);
                zArr = zArr2;
                m7655x(cellAndSpan.f15518a, cellAndSpan.f15519b, cellAndSpan.f15520c, cellAndSpan.f15521d, zArr, true);
            }
            i8++;
            zArr2 = zArr;
        }
        boolean[][] zArr3 = zArr2;
        if (z5) {
            m7655x(itemConfiguration.f15671f, itemConfiguration.f15672g, itemConfiguration.f15673h, itemConfiguration.f15674i, zArr3, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        return (this.f15467V && this.f15466U.m2368v(motionEvent)) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Objects.toString(sparseArray);
        if (this.f15478s) {
            Objects.toString(sparseArray);
            Parcelable parcelable = (Parcelable) sparseArray.get(R.id.cell_layout_jail_id);
            sparseArray = parcelable instanceof C0044L ? (C0044L) parcelable : new C0044L();
        }
        super.dispatchRestoreInstanceState(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        Objects.toString(sparseArray);
        if (!this.f15478s) {
            super.dispatchSaveInstanceState(sparseArray);
            return;
        }
        Objects.toString(sparseArray);
        Parcelable parcelable = (Parcelable) sparseArray.get(R.id.cell_layout_jail_id);
        C0044L c0044l = parcelable instanceof C0044L ? (C0044L) parcelable : new C0044L();
        super.dispatchSaveInstanceState(c0044l);
        sparseArray.put(R.id.cell_layout_jail_id, c0044l);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:90:0x0176  */
    /* JADX INFO: renamed from: e */
    public final void m7637e(InvariantDeviceProfile invariantDeviceProfile, boolean z5) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i6;
        ShortcutAndWidgetContainer shortcutAndWidgetContainer;
        Launcher launcher;
        int i7;
        int i8;
        Objects.toString(invariantDeviceProfile);
        ShortcutAndWidgetContainer shortcutsAndWidgets = getShortcutsAndWidgets();
        if (shortcutsAndWidgets != null) {
            shortcutsAndWidgets.getChildCount();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            int i9 = invariantDeviceProfile.f16711c;
            int i10 = invariantDeviceProfile.f16712d;
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i9, i10);
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i6 = invariantDeviceProfile.f16711c;
                shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
                if (i11 >= i6) {
                    break;
                }
                for (int i14 = 0; i14 < i10; i14++) {
                    View childAt = shortcutAndWidgetContainer.getChildAt(i14, i11);
                    if (childAt != null) {
                        iArr[i11][i14] = 1;
                        if (childAt.getTag() instanceof ItemInfo) {
                            if (!(childAt instanceof LauncherAppWidgetHostView)) {
                                map.put(Integer.valueOf(i12), childAt);
                                i12++;
                            } else if (!map2.containsValue(childAt)) {
                                map2.put(Integer.valueOf(i13), childAt);
                                i13++;
                            }
                        }
                    }
                }
                i11++;
            }
            float f6 = 30.0f;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int i18 = -100;
                launcher = this.f15469j;
                if (i16 >= i6) {
                    break;
                }
                float f7 = f6;
                int i19 = i15;
                int i20 = i17;
                int i21 = 0;
                while (i21 < i10) {
                    if (i19 < map.size()) {
                        View childAt2 = shortcutAndWidgetContainer.getChildAt(i21, i16);
                        if (childAt2 == null) {
                            View view = (View) map.get(Integer.valueOf(i19));
                            Object tag = view.getTag();
                            if (tag instanceof ItemInfo) {
                                ItemInfo itemInfo = (ItemInfo) tag;
                                if (i21 == itemInfo.cellX && i16 == itemInfo.cellY) {
                                    i7 = i19;
                                } else {
                                    i7 = i19;
                                    if (m7634b(view, i21, i16, z5 ? 150 : 0, i20)) {
                                        if (z5) {
                                            i20 = (int) (i20 + f7);
                                            f7 *= 0.9f;
                                        }
                                        i8 = i21;
                                        LauncherModel.modifyItemInDatabase(this.f15469j, itemInfo, i18, launcher.getWorkspace().O0(this), itemInfo.cellX, itemInfo.cellY, itemInfo.spanX, itemInfo.spanY);
                                    }
                                }
                                i8 = i21;
                            } else {
                                i7 = i19;
                                i8 = i21;
                            }
                        } else {
                            i7 = i19;
                            i8 = i21;
                            if (childAt2 instanceof LauncherAppWidgetHostView) {
                            }
                            i21 = i8 + 1;
                            i18 = -100;
                        }
                        i19 = i7 + 1;
                        i21 = i8 + 1;
                        i18 = -100;
                    } else {
                        i7 = i19;
                        i8 = i21;
                    }
                    i19 = i7;
                    i21 = i8 + 1;
                    i18 = -100;
                }
                i16++;
                i17 = i20;
                i15 = i19;
                f6 = f7;
            }
            float f8 = f6;
            int i22 = i17;
            for (int i23 = 0; i23 < map2.size(); i23++) {
                View view2 = (View) map2.get(Integer.valueOf(i23));
                if (view2 != null) {
                    Object tag2 = view2.getTag();
                    if (tag2 instanceof ItemInfo) {
                        ItemInfo itemInfo2 = (ItemInfo) tag2;
                        int i24 = itemInfo2.cellX;
                        int i25 = itemInfo2.cellY;
                        for (int i26 = 0; i26 < itemInfo2.cellX; i26++) {
                            int i27 = itemInfo2.spanY;
                            int i28 = i25;
                            while (true) {
                                if (i28 >= i25 + i27) {
                                    i24 = i26;
                                    break;
                                } else if (shortcutAndWidgetContainer.getChildAt(i26, i28) != null) {
                                    break;
                                } else {
                                    i28++;
                                }
                            }
                        }
                        for (int i29 = 0; i29 < itemInfo2.cellY; i29++) {
                            int i30 = itemInfo2.spanX;
                            int i31 = i24;
                            while (true) {
                                if (i31 >= i24 + i30) {
                                    i25 = i29;
                                    break;
                                } else if (shortcutAndWidgetContainer.getChildAt(i31, i29) != null) {
                                    break;
                                } else {
                                    i31++;
                                }
                            }
                        }
                        if (i24 != itemInfo2.cellX || i25 != itemInfo2.cellY) {
                            if (m7634b(view2, i24, i25, z5 ? 150 : 0, i22)) {
                                if (z5) {
                                    i22 = (int) (i22 + f8);
                                    f8 *= 0.9f;
                                }
                                LauncherModel.modifyItemInDatabase(this.f15469j, itemInfo2, -100, launcher.getWorkspace().O0(this), itemInfo2.cellX, itemInfo2.cellY, itemInfo2.spanX, itemInfo2.spanY);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0093  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:6:0x001e  */
    /* JADX INFO: renamed from: f */
    public final void m7638f(ItemConfiguration itemConfiguration, View view, int i6) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i7;
        ValueAnimator valueAnimatorM7889c;
        PowerManager powerManager;
        long j6;
        ArrayList arrayList;
        Objects.toString(itemConfiguration);
        Objects.toString(view);
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        int i8 = 0;
        while (i8 < childCount) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i8);
            if (childAt == view) {
                i7 = i8;
            } else {
                CellAndSpan cellAndSpan = (CellAndSpan) itemConfiguration.f15666a.get(childAt);
                boolean z5 = (i6 != 0 || (arrayList = itemConfiguration.f15669d) == null || arrayList.contains(childAt)) ? false : true;
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
                if (cellAndSpan == null || z5) {
                    i7 = i8;
                } else {
                    i7 = i8;
                    ReorderPreviewAnimation reorderPreviewAnimation = new ReorderPreviewAnimation(this, childAt, i6, cellLayoutLayoutParams.f15685a, cellLayoutLayoutParams.f15686b, cellAndSpan.f15518a, cellAndSpan.f15519b, cellAndSpan.f15520c, cellAndSpan.f15521d);
                    HashMap map = this.f15453H;
                    View view2 = reorderPreviewAnimation.f15718a;
                    boolean zContainsKey = map.containsKey(view2);
                    float f6 = reorderPreviewAnimation.f15720c;
                    float f7 = reorderPreviewAnimation.f15719b;
                    if (zContainsKey) {
                        Animator animator = ((ReorderPreviewAnimation) map.get(view2)).f15727j;
                        if (animator != null) {
                            animator.cancel();
                        }
                        map.remove(view2);
                        if (f7 == 0.0f && f6 == 0.0f) {
                            reorderPreviewAnimation.animate();
                        } else if (f7 == 0.0f) {
                            valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
                            reorderPreviewAnimation.f15727j = valueAnimatorM7889c;
                            Context context = getContext();
                            Rect rect = Utilities.sOldBounds;
                            powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager != null) {
                                valueAnimatorM7889c.setRepeatMode(2);
                                valueAnimatorM7889c.setRepeatCount(-1);
                            } else {
                                valueAnimatorM7889c.setRepeatMode(2);
                                valueAnimatorM7889c.setRepeatCount(-1);
                            }
                            if (reorderPreviewAnimation.f15725h == 0) {
                                j6 = 350;
                            } else {
                                j6 = 300;
                            }
                            valueAnimatorM7889c.setDuration(j6);
                            valueAnimatorM7889c.setStartDelay((int) (Math.random() * 60.0d));
                            valueAnimatorM7889c.addUpdateListener(new SharedAnimatorUpdateListener(3, reorderPreviewAnimation));
                            valueAnimatorM7889c.addListener(new C0022a(9, reorderPreviewAnimation));
                            map.put(view2, reorderPreviewAnimation);
                            valueAnimatorM7889c.start();
                        } else {
                            valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
                            reorderPreviewAnimation.f15727j = valueAnimatorM7889c;
                            Context context2 = getContext();
                            Rect rect2 = Utilities.sOldBounds;
                            powerManager = (PowerManager) context2.getSystemService("power");
                            if (powerManager != null) {
                                valueAnimatorM7889c.setRepeatMode(2);
                                valueAnimatorM7889c.setRepeatCount(-1);
                            } else {
                                valueAnimatorM7889c.setRepeatMode(2);
                                valueAnimatorM7889c.setRepeatCount(-1);
                            }
                            if (reorderPreviewAnimation.f15725h == 0) {
                                j6 = 350;
                            } else {
                                j6 = 300;
                            }
                            valueAnimatorM7889c.setDuration(j6);
                            valueAnimatorM7889c.setStartDelay((int) (Math.random() * 60.0d));
                            valueAnimatorM7889c.addUpdateListener(new SharedAnimatorUpdateListener(3, reorderPreviewAnimation));
                            valueAnimatorM7889c.addListener(new C0022a(9, reorderPreviewAnimation));
                            map.put(view2, reorderPreviewAnimation);
                            valueAnimatorM7889c.start();
                        }
                    } else if (f7 == 0.0f || f6 != 0.0f) {
                        valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
                        reorderPreviewAnimation.f15727j = valueAnimatorM7889c;
                        Context context3 = getContext();
                        Rect rect3 = Utilities.sOldBounds;
                        powerManager = (PowerManager) context3.getSystemService("power");
                        if (powerManager != null || !Utilities.f16752m || !powerManager.isPowerSaveMode()) {
                            valueAnimatorM7889c.setRepeatMode(2);
                            valueAnimatorM7889c.setRepeatCount(-1);
                        }
                        if (reorderPreviewAnimation.f15725h == 0) {
                            j6 = 350;
                        } else {
                            j6 = 300;
                        }
                        valueAnimatorM7889c.setDuration(j6);
                        valueAnimatorM7889c.setStartDelay((int) (Math.random() * 60.0d));
                        valueAnimatorM7889c.addUpdateListener(new SharedAnimatorUpdateListener(3, reorderPreviewAnimation));
                        valueAnimatorM7889c.addListener(new C0022a(9, reorderPreviewAnimation));
                        map.put(view2, reorderPreviewAnimation);
                        valueAnimatorM7889c.start();
                    }
                }
            }
            i8 = i7 + 1;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void cellToRect(int i6, int i7, int i8, int i9, Rect rect) {
        Objects.toString(rect);
        int i10 = this.mCellWidth;
        int i11 = this.mCellHeight;
        int i12 = i8 * i10;
        int i13 = i9 * i11;
        int paddingLeft = (i10 * i6) + getPaddingLeft();
        int paddingTop = (i11 * i7) + getPaddingTop();
        rect.set(paddingLeft, paddingTop, i12 + paddingLeft, i13 + paddingTop);
        rect.toString();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Objects.toString(attributeSet);
        CellLayoutLayoutParams cellLayoutLayoutParams = new CellLayoutLayoutParams(getContext(), attributeSet);
        cellLayoutLayoutParams.f15692h = true;
        cellLayoutLayoutParams.f15693i = false;
        cellLayoutLayoutParams.f15694j = true;
        cellLayoutLayoutParams.f15690f = 1;
        cellLayoutLayoutParams.f15691g = 1;
        return cellLayoutLayoutParams;
    }

    public float getBackgroundAlpha() {
        return this.mBackgroundAlpha;
    }

    public int getCellHeight() {
        return this.mCellHeight;
    }

    public int getCellWidth() {
        return this.mCellWidth;
    }

    public float getChildrenScale() {
        if (this.f15458M) {
            return this.f15459N;
        }
        return 1.0f;
    }

    public int getCountX() {
        return this.mCountX;
    }

    public int getCountY() {
        return this.mCountY;
    }

    public int getDesiredHeight() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i6 = this.mCountY;
        int i7 = (this.mCellHeight * i6) + paddingBottom;
        Math.max(i6 - 1, 0);
        return i7;
    }

    public int getDesiredWidth() {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int i6 = this.mCountX;
        int i7 = (this.mCellWidth * i6) + paddingRight;
        Math.max(i6 - 1, 0);
        return i7;
    }

    public int getHeightGap() {
        return 0;
    }

    public boolean getIsDragOverlapping() {
        return this.mIsDragOverlapping;
    }

    public ShortcutAndWidgetContainer getShortcutsAndWidgets() {
        return this.mShortcutsAndWidgets;
    }

    public int getUnusedHorizontalSpace() {
        return ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mCountX * this.mCellWidth);
    }

    public int getWidthGap() {
        return 0;
    }

    /* JADX INFO: renamed from: h */
    public final void commitTempPlacement() {
        int i6;
        for (int i7 = 0; i7 < this.mCountX; i7++) {
            int i8 = this.mCountY;
            if (i8 >= 0) {
                System.arraycopy(this.f15482w[i7], 0, this.f15481v[i7], 0, i8);
            }
        }
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i9);
            CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
            ItemInfo itemInfo = (ItemInfo) childAt.getTag();
            if (itemInfo != null) {
                int i10 = itemInfo.cellX;
                int i11 = cellLayoutLayoutParams.f15687c;
                if (i10 != i11 || itemInfo.cellY != cellLayoutLayoutParams.f15688d || itemInfo.spanX != cellLayoutLayoutParams.f15690f || itemInfo.spanY != cellLayoutLayoutParams.f15691g) {
                    itemInfo.requiresDbUpdate = true;
                }
                cellLayoutLayoutParams.f15685a = i11;
                itemInfo.cellX = i11;
                int i12 = cellLayoutLayoutParams.f15688d;
                cellLayoutLayoutParams.f15686b = i12;
                itemInfo.cellY = i12;
                itemInfo.spanX = cellLayoutLayoutParams.f15690f;
                itemInfo.spanY = cellLayoutLayoutParams.f15691g;
            }
        }
        Workspace workspace = this.f15469j.getWorkspace();
        workspace.getClass();
        Objects.toString(this);
        int childCount2 = getShortcutsAndWidgets().getChildCount();
        long jO0 = workspace.O0(this);
        if (workspace.f23432V0.isHotseatLayout(this)) {
            jO0 = -1;
            i6 = -101;
        } else {
            i6 = -100;
        }
        long j6 = jO0;
        for (int i13 = 0; i13 < childCount2; i13++) {
            ItemInfo itemInfo2 = (ItemInfo) getShortcutsAndWidgets().getChildAt(i13).getTag();
            if (itemInfo2 != null && itemInfo2.requiresDbUpdate) {
                itemInfo2.requiresDbUpdate = false;
                LauncherModel.modifyItemInDatabase(workspace.f23432V0, itemInfo2, i6, j6, itemInfo2.cellX, itemInfo2.cellY, itemInfo2.spanX, itemInfo2.spanY);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final void completeAndClearReorderPreviewAnimations() {
        HashMap map = this.f15453H;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((ReorderPreviewAnimation) it.next()).animate();
        }
        map.clear();
    }

    /* JADX INFO: renamed from: k */
    public final void copyCurrentStateToSolution(ItemConfiguration itemConfiguration) {
        Objects.toString(itemConfiguration);
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i6);
            CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
            int i7 = cellLayoutLayoutParams.f15685a;
            int i8 = cellLayoutLayoutParams.f15686b;
            int i9 = cellLayoutLayoutParams.f15690f;
            int i10 = cellLayoutLayoutParams.f15691g;
            CellAndSpan cellAndSpan = new CellAndSpan();
            cellAndSpan.f15518a = i7;
            cellAndSpan.f15519b = i8;
            cellAndSpan.f15520c = i9;
            cellAndSpan.f15521d = i10;
            Objects.toString(childAt);
            Objects.toString(cellAndSpan);
            itemConfiguration.f15666a.put(childAt, cellAndSpan);
            itemConfiguration.f15667b.put(childAt, new CellAndSpan());
            itemConfiguration.f15668c.add(childAt);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void copySolutionToTempState(ItemConfiguration itemConfiguration, View view) {
        Objects.toString(itemConfiguration);
        Objects.toString(view);
        for (int i6 = 0; i6 < this.mCountX; i6++) {
            for (int i7 = 0; i7 < this.mCountY; i7++) {
                this.f15482w[i6][i7] = false;
            }
        }
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i8);
            if (childAt != view) {
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
                CellAndSpan cellAndSpan = (CellAndSpan) itemConfiguration.f15666a.get(childAt);
                if (cellAndSpan != null) {
                    int i9 = cellAndSpan.f15518a;
                    cellLayoutLayoutParams.f15687c = i9;
                    int i10 = cellAndSpan.f15519b;
                    cellLayoutLayoutParams.f15688d = i10;
                    int i11 = cellAndSpan.f15520c;
                    cellLayoutLayoutParams.f15690f = i11;
                    int i12 = cellAndSpan.f15521d;
                    cellLayoutLayoutParams.f15691g = i12;
                    m7655x(i9, i10, i11, i12, this.f15482w, true);
                }
            }
        }
        m7655x(itemConfiguration.f15671f, itemConfiguration.f15672g, itemConfiguration.f15673h, itemConfiguration.f15674i, this.f15482w, true);
    }

    /* JADX INFO: renamed from: m */
    public final boolean createAreaForResize(int i6, int i7, int i8, int i9, View view, int[] iArr, boolean z5) {
        Objects.toString(view);
        int[] iArr2 = new int[2];
        regionToCenterPoint(i6, i7, i8, i9, iArr2);
        ItemConfiguration itemConfigurationM7649r = m7649r(iArr2[0], iArr2[1], i8, i9, i8, i9, iArr, view, true, new ItemConfiguration(this));
        setUseTempCoords(true);
        if (itemConfigurationM7649r != null && itemConfigurationM7649r.f15670e) {
            copySolutionToTempState(itemConfigurationM7649r, view);
            setItemPlacementDirty(true);
            animateItemsToSolution(itemConfigurationM7649r, view, z5);
            if (z5) {
                commitTempPlacement();
                completeAndClearReorderPreviewAnimations();
                setItemPlacementDirty(false);
            } else {
                m7638f(itemConfigurationM7649r, view, 1);
            }
            this.mShortcutsAndWidgets.requestLayout();
        }
        return itemConfigurationM7649r.f15670e;
    }

    /* JADX INFO: renamed from: n */
    public final void enableAccessibleDrag(int i6, boolean z5) {
        this.f15467V = z5;
        if (z5) {
            if (i6 == 2 && !(this.f15466U instanceof C2341f)) {
                this.f15466U = new C2341f(this);
            } else if (i6 == 1 && !(this.f15466U instanceof C2337b)) {
                this.f15466U = new C2337b(this);
            }
            AbstractC0758N.m1667p(this, this.f15466U);
            setImportantForAccessibility(1);
            getShortcutsAndWidgets().setImportantForAccessibility(1);
            setOnClickListener(this.f15466U);
        } else {
            AbstractC0758N.m1667p(this, null);
            setImportantForAccessibility(2);
            getShortcutsAndWidgets().setImportantForAccessibility(2);
            setOnClickListener(this.f15469j);
        }
        if (getParent() != null) {
            getParent().notifySubtreeAccessibilityStateChanged(this, this, 1);
        }
    }

    /* JADX INFO: renamed from: o */
    public final boolean m7646o(int i6, int i7, int[] iArr) {
        int i8 = 0;
        int i9 = this.mCountX - (i6 - 1);
        int i10 = this.mCountY - (i7 - 1);
        boolean z5 = false;
        for (int i11 = 0; i11 < i10 && !z5; i11++) {
            int i12 = 0;
            while (i12 < i9) {
                int i13 = 0;
                while (true) {
                    if (i13 >= i6) {
                        z5 = true;
                        if (iArr == null) {
                            break;
                        }
                        iArr[0] = i12;
                        iArr[1] = i11;
                        break;
                    }
                    int i14 = 0;
                    while (true) {
                        if (i14 < i7) {
                            i8 = i12 + i13;
                            if (this.f15481v[i8][i11 + i14]) {
                                break;
                            }
                            i14++;
                        } else {
                            i13++;
                        }
                    }
                }
                i12 = i8 + 1;
            }
        }
        return z5;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        View iconView;
        Objects.toString(canvas);
        if (!this.f15477r) {
            return;
        }
        if (this.mBackgroundAlpha > 0.0f) {
            this.f15448C.draw(canvas);
        }
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f15485z;
            if (i6 >= arrayList.size()) {
                return;
            }
            FolderRingAnimator folderRingAnimator = (FolderRingAnimator) arrayList.get(i6);
            float f6 = folderRingAnimator.f15323d;
            int i7 = folderRingAnimator.f15320a;
            int i8 = folderRingAnimator.f15321b;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i9 = (this.mCellWidth * i7) + paddingLeft;
            int[] iArr = this.f15480u;
            iArr[0] = i9;
            iArr[1] = (this.mCellHeight * i8) + paddingTop;
            View childAt = this.mShortcutsAndWidgets.getChildAt(folderRingAnimator.f15320a, folderRingAnimator.f15321b);
            if (childAt != null) {
                int left = (this.mCellWidth / 2) + iArr[0];
                int i10 = iArr[1] + this.mCellHeight;
                DeviceProfile deviceProfile = this.grid;
                int top = (i10 - (deviceProfile.f15978D / 2)) - deviceProfile.f15980F;
                if (childAt instanceof BubbleTextView) {
                    iconView = ((BubbleTextView) childAt).getIconView();
                } else {
                    iconView = childAt instanceof FolderIcon ? ((FolderIcon) childAt).getIconView() : null;
                }
                if (iconView != null) {
                    left = iconView.getLeft() + iArr[0] + (deviceProfile.f15978D / 2);
                    top = (deviceProfile.f15978D / 2) + iconView.getTop() + iArr[1];
                }
                int childrenScale = (int) (getChildrenScale() * folderRingAnimator.f15323d);
                canvas.save();
                float f7 = childrenScale;
                float f8 = f7 / 2.0f;
                canvas.translate(left - f8, top - f8);
                FolderRingAnimator.f15315h.set(0.0f, 0.0f, f7, f7);
                canvas.drawPath(AbstractC1154e.m2420j(f7, f7), FolderRingAnimator.f15316i);
                canvas.restore();
            }
            i6++;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        if (this.f15467V) {
            return true;
        }
        View.OnTouchListener onTouchListener = this.f15483x;
        return onTouchListener != null && onTouchListener.onTouch(this, motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        int i10;
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        boolean z6 = shortcutAndWidgetContainer.getChildCount() > 0 && ((CellLayoutLayoutParams) shortcutAndWidgetContainer.getChildAt(0).getLayoutParams()).f15693i;
        int paddingLeft = getPaddingLeft();
        if (z6) {
            shortcutAndWidgetContainer.layout(0, 0, i8 - i6, i9 - i7);
            return;
        }
        int iCeil = paddingLeft + ((int) Math.ceil(getUnusedHorizontalSpace() / 2.0f));
        int paddingTop = getPaddingTop();
        if (getParent() instanceof Workspace) {
            DeviceProfile deviceProfile = this.grid;
            if (deviceProfile.f16006f && (i10 = (int) (((double) deviceProfile.f15976B) - (((double) ((this.mCellHeight - deviceProfile.f15978D) - deviceProfile.f15980F)) - (((double) deviceProfile.f16026z) * 0.68d)))) > paddingTop) {
                paddingTop = i10;
            }
            setPadding(getPaddingLeft(), paddingTop, getPaddingRight(), getPaddingBottom());
        }
        shortcutAndWidgetContainer.layout(iCeil, paddingTop, (iCeil + i8) - i6, (paddingTop + i9) - i7);
    }

    @Override // android.view.View
    public final void onMeasure(int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i6);
        int size2 = View.MeasureSpec.getSize(i7);
        int paddingRight = size - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = size2 - (getPaddingBottom() + getPaddingTop());
        int i8 = this.f15472m;
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        if (i8 < 0 || this.f15473n < 0) {
            int i9 = this.mCountX;
            int i10 = paddingRight / i9;
            int i11 = this.mCountY;
            int i12 = paddingBottom / i11;
            if (i10 != this.mCellWidth || i12 != this.mCellHeight) {
                this.mCellWidth = i10;
                this.mCellHeight = i12;
                shortcutAndWidgetContainer.m8046j(i10, i12, i9, i11);
            }
        }
        int i13 = this.f15450E;
        int i14 = this.f15449D;
        if (i14 > 0 && i13 > 0) {
            paddingBottom = i13;
            paddingRight = i14;
        } else if (mode == 0 || mode2 == 0) {
            throw new RuntimeException("CellLayout cannot have UNSPECIFIED dimensions");
        }
        boolean z5 = false;
        if (shortcutAndWidgetContainer.getChildCount() > 0 && ((CellLayoutLayoutParams) shortcutAndWidgetContainer.getChildAt(0).getLayoutParams()).f15693i) {
            z5 = true;
        }
        if (z5) {
            paddingRight = size;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingRight, 1073741824);
        if (z5) {
            paddingBottom = size2;
        }
        shortcutAndWidgetContainer.measure(iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(paddingBottom, 1073741824));
        int measuredWidth = shortcutAndWidgetContainer.getMeasuredWidth();
        int measuredHeight = shortcutAndWidgetContainer.getMeasuredHeight();
        if (i14 <= 0 || i13 <= 0) {
            setMeasuredDimension(size, size2);
        } else {
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        TransitionDrawable transitionDrawable = this.f15448C;
        Rect rect = this.f15465T;
        transitionDrawable.getPadding(rect);
        transitionDrawable.setBounds(-rect.left, -rect.top, i6 + rect.right, i7 + rect.bottom);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        return (this.f15469j.mWorkspace.X0() && this.f15484y.checkAndPerformStylusEvent(motionEvent)) || super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0080  */
    /* JADX INFO: renamed from: p */
    public final void findNearestArea(int i6, int i7, int i8, int i9, int[] iArr, boolean[][] zArr, boolean[][] zArr2, int[] iArr2) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int[] iArr3 = iArr2 != null ? iArr2 : new int[2];
        int i10 = this.mCountX;
        int i11 = this.mCountY;
        int i12 = Integer.MIN_VALUE;
        float f6 = Float.MAX_VALUE;
        for (int i13 = 0; i13 < i11 - (i9 - 1); i13++) {
            for (int i14 = 0; i14 < i10 - (i8 - 1); i14++) {
                int i15 = 0;
                while (true) {
                    if (i15 >= i8) {
                        int i16 = i14 - i6;
                        int i17 = i13 - i7;
                        int i18 = i12;
                        float fHypot = (float) Math.hypot(i16, i17);
                        int[] iArr4 = this.f15479t;
                        computeDirectionVector(i16, i17, iArr4);
                        int i19 = (iArr[1] * iArr4[1]) + (iArr[0] * iArr4[0]);
                        if (Float.compare(fHypot, f6) < 0) {
                            iArr3[0] = i14;
                            iArr3[1] = i13;
                            f6 = fHypot;
                            i12 = i19;
                            break;

                        }
                        i12 = i18;
                        if (Float.compare(fHypot, f6) == 0 && i19 > i12) {
                            iArr3[0] = i14;
                            iArr3[1] = i13;
                            f6 = fHypot;
                            i12 = i19;
                            break;
                        }
                        break;
                    }
                    for (int i20 = 0; i20 < i9; i20++) {
                        if (zArr[i14 + i15][i13 + i20] && (zArr2 == null || zArr2[i15][i20])) {
                            break;
                        }
                    }
                    i15++;
                }
            }
        }
        if (f6 == Float.MAX_VALUE) {
            iArr3[0] = -1;
            iArr3[1] = -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x012d  */
    /* JADX WARN: Code duplicated, block: B:81:0x0130  */
    /* JADX WARN: Code duplicated, block: B:84:0x0136  */
    /* JADX WARN: Code duplicated, block: B:85:0x0139  */
    /* JADX INFO: renamed from: q */
    public final int[] findNearestArea(int i6, int i7, int i8, int i9, int i10, int i11, boolean z5, int[] iArr, int[] iArr2) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = 0;
        int i17 = 0;
        boolean z6;
        int i18 = 0;
        int i19 = 0;
        Stack stack = null;
        int i20;
        int i21;
        boolean z7 = false;
        int i22 = 0;
        int i23 = 0;
        boolean z8;
        boolean z9;
        CellLayout cellLayout = this;
        Stack stack2 = cellLayout.f23326a0;
        if (stack2.isEmpty()) {
            for (int i24 = 0; i24 < cellLayout.mCountX * cellLayout.mCountY; i24++) {
                stack2.push(new Rect());
            }
        }
        int i25 = (int) (i6 - (((i10 - 1) * cellLayout.mCellWidth) / 2.0f));
        int i26 = (int) (i7 - (((i11 - 1) * cellLayout.mCellHeight) / 2.0f));
        int[] iArr3 = iArr != null ? iArr : new int[2];
        Rect rect = new Rect(-1, -1, -1, -1);
        Stack stack3 = new Stack();
        int i27 = cellLayout.mCountX;
        int i28 = cellLayout.mCountY;
        if (i8 > 0 && i9 > 0 && i10 > 0 && i11 > 0 && i10 >= i8 && i11 >= i9) {
            Stack stack4 = stack3;
            double d6 = Double.MAX_VALUE;
            int i29 = 0;
            while (i29 < i28 - (i9 - 1)) {
                int i30 = 0;
                while (i30 < i27 - (i8 - 1)) {
                    if (z5) {
                        int i31 = 0;
                        while (true) {
                            if (i31 < i8) {
                                int i32 = i30;
                                int i33 = 0;
                                while (true) {
                                    if (i33 < i9) {
                                        int i34 = i33;
                                        if (cellLayout.f15481v[i32 + i31][i29 + i34]) {
                                            i19 = i29;
                                            i17 = i27;
                                            i16 = i28;
                                            stack = stack4;
                                            i18 = i32;
                                        } else {
                                            i33 = i34 + 1;
                                        }
                                    } else {
                                        i31++;
                                        i30 = i32;
                                    }
                                }
                            } else {
                                i12 = i30;
                                boolean z10 = i8 >= i10;
                                boolean z11 = i9 >= i11;
                                boolean z12 = z10;
                                i13 = i29;
                                int i35 = i8;
                                int i36 = i9;
                                boolean z13 = true;
                                while (true) {
                                    if (z12 && z11) {
                                        break;
                                    }
                                    if (!z13 || z12) {
                                        i20 = i36;
                                        i21 = i27;
                                        if (!z11) {
                                            int i37 = 0;
                                            while (i37 < i35) {
                                                int i38 = i13 + i20;
                                                int i39 = i37;
                                                if (i38 > i28 - 1 || cellLayout.f15481v[i12 + i39][i38]) {
                                                    z11 = true;
                                                    break;
                                                }
                                                i37 = i39 + 1;
                                            }
                                            if (!z11) {
                                                i22 = i35;
                                                i23 = i20 + 1;
                                                z7 = z12;
                                            }
                                            if (i22 >= i10) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            boolean z14 = z7 | z8;
                                            if (i23 >= i11) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            z11 |= z9;
                                            z13 = !z13;
                                            z12 = z14;
                                            i36 = i23;
                                            i35 = i22;
                                            i27 = i21;
                                        }
                                        z7 = z12;
                                    } else {
                                        i21 = i27;
                                        int i40 = 0;
                                        while (true) {
                                            i20 = i36;
                                            if (i40 >= i36) {
                                                z7 = z12;
                                                break;
                                            }
                                            int i41 = i12 + i35;
                                            int i42 = i40;
                                            if (i41 > i21 - 1 || cellLayout.f15481v[i41][i13 + i42]) {
                                                z7 = true;
                                                break;
                                            }
                                            i40 = i42 + 1;
                                            i36 = i20;
                                        }
                                        if (!z7) {
                                            i35++;
                                        }
                                    }
                                    i22 = i35;
                                    i23 = i20;
                                    if (i22 >= i10) {
                                        z8 = true;
                                    } else {
                                        z8 = false;
                                    }
                                    boolean z15 = z7 | z8;
                                    if (i23 >= i11) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    z11 |= z9;
                                    z13 = !z13;
                                    z12 = z15;
                                    i36 = i23;
                                    i35 = i22;
                                    i27 = i21;
                                }
                                i14 = i36;
                                i15 = i35;
                            }
                            i30 = i18 + 1;
                            cellLayout = this;
                            i29 = i19;
                            i27 = i17;
                            i28 = i16;
                            stack4 = stack;
                        }
                    } else {
                        i12 = i30;
                        i13 = i29;
                        i14 = -1;
                        i15 = -1;
                    }
                    int i43 = i27;
                    Stack stack5 = stack4;
                    int[] iArr4 = cellLayout.f15479t;
                    i16 = i28;
                    int i44 = i12;
                    int i45 = i13;
                    i17 = i43;
                    cellLayout.regionToCenterPoint(i44, i45, 1, 1, iArr4);
                    Rect rect2 = (Rect) stack2.pop();
                    rect2.set(i44, i45, i44 + i15, i45 + i14);
                    Iterator it = stack5.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z6 = false;
                            break;
                        }
                        if (((Rect) it.next()).contains(rect2)) {
                            z6 = true;
                            break;
                        }
                    }
                    stack5.push(rect2);
                    i18 = i44;
                    i19 = i45;
                    stack = stack5;
                    boolean z16 = z6;
                    double dHypot = Math.hypot(iArr4[0] - i25, iArr4[1] - i26);
                    if ((dHypot <= d6 && !z16) || rect2.contains(rect)) {
                        iArr3[0] = i18;
                        iArr3[1] = i19;
                        if (iArr2 != null) {
                            iArr2[0] = i15;
                            iArr2[1] = i14;
                        }
                        rect.set(rect2);
                        d6 = dHypot;
                    }
                    i30 = i18 + 1;
                    cellLayout = this;
                    i29 = i19;
                    i27 = i17;
                    i28 = i16;
                    stack4 = stack;
                }
                i29++;
                cellLayout = this;
            }
            Stack stack6 = stack4;
            if (d6 == Double.MAX_VALUE) {
                iArr3[0] = -1;
                iArr3[1] = -1;
            }
            Objects.toString(stack6);
            while (!stack6.isEmpty()) {
                stack2.push((Rect) stack6.pop());
            }
            int i46 = iArr3[0];
            int i47 = iArr3[1];
        }
        return iArr3;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x03d6 A[LOOP:2: B:90:0x035e->B:100:0x03d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:102:0x03df  */
    /* JADX WARN: Code duplicated, block: B:111:0x0404  */
    /* JADX WARN: Code duplicated, block: B:113:0x041b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0421  */
    /* JADX WARN: Code duplicated, block: B:126:0x03d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x0356 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x022f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x021e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x010f  */
    /* JADX WARN: Code duplicated, block: B:62:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:63:0x0205  */
    /* JADX WARN: Code duplicated, block: B:65:0x020e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0244 A[LOOP:4: B:70:0x0242->B:71:0x0244, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x0291 A[LOOP:5: B:73:0x028f->B:74:0x0291, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x0327  */
    /* JADX WARN: Code duplicated, block: B:86:0x032f A[LOOP:7: B:85:0x032d->B:86:0x032f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:89:0x0359  */
    /* JADX WARN: Code duplicated, block: B:91:0x0360  */
    /* JADX WARN: Code duplicated, block: B:96:0x03c3  */
    /* JADX INFO: renamed from: r */
    public final ItemConfiguration m7649r(int i6, int i7, int i8, int i9, int i10, int i11, int[] iArr, View view, boolean z5, ItemConfiguration itemConfiguration) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z6 = false;
        int i12;
        CellLayout cellLayout;
        ArrayList arrayList;
        int size;
        int[] iArr2;
        int size2;
        Rect rect;
        int i13;
        int size3;
        int i14;
        char c6;
        boolean[][] zArr;
        int i15;
        int i16;
        int size4 = 0;
        int i17;
        Rect rect2;
        int i18;
        boolean z7;
        int size5;
        int i19;
        int i20;
        CellAndSpan cellAndSpan;
        int size6;
        int i21;
        int i22;
        HashMap map;
        int i23;
        boolean z8;
        int i24;
        CellAndSpan cellAndSpan2;
        Objects.toString(view);
        Objects.toString(itemConfiguration);
        copyCurrentStateToSolution(itemConfiguration);
        boolean[][] zArr2 = this.f15482w;
        for (int i25 = 0; i25 < this.mCountX; i25++) {
            int i26 = this.mCountY;
            if (i26 >= 0) {
                System.arraycopy(this.f15481v[i25], 0, zArr2[i25], 0, i26);
            }
        }
        int[] iArrFindNearestArea = findNearestArea(i6, i7, i10, i11, i10, i11, false, new int[2], null);
        int i27 = iArrFindNearestArea[0];
        int i28 = iArrFindNearestArea[1];
        Objects.toString(view);
        Objects.toString(itemConfiguration);
        if (i27 >= 0 && i28 >= 0) {
            ArrayList arrayList2 = this.f15461P;
            arrayList2.clear();
            int i29 = i27 + i10;
            int i30 = i28 + i11;
            Rect rect3 = this.f15462Q;
            rect3.set(i27, i28, i29, i30);
            if (view != null && (cellAndSpan2 = (CellAndSpan) itemConfiguration.f15666a.get(view)) != null) {
                cellAndSpan2.f15518a = i27;
                cellAndSpan2.f15519b = i28;
            }
            Rect rect4 = new Rect(i27, i28, i29, i30);
            Rect rect5 = new Rect();
            Iterator it = itemConfiguration.f15666a.keySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                HashMap map2 = itemConfiguration.f15666a;
                if (zHasNext) {
                    View view2 = (View) it.next();
                    if (view2 != view) {
                        CellAndSpan cellAndSpan3 = (CellAndSpan) map2.get(view2);
                        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view2.getLayoutParams();
                        int i31 = cellAndSpan3.f15518a;
                        int i32 = cellAndSpan3.f15519b;
                        Iterator it2 = it;
                        rect5.set(i31, i32, cellAndSpan3.f15520c + i31, cellAndSpan3.f15521d + i32);
                        if (Rect.intersects(rect4, rect5)) {
                            if (cellLayoutLayoutParams.f15694j) {
                                arrayList2.add(view2);
                            } else {
                                z6 = false;
                            }
                        }
                        it = it2;
                    }
                } else {
                    itemConfiguration.f15669d = new ArrayList(arrayList2);
                    Objects.toString(arrayList2);
                    Rect rect6 = this.f15462Q;
                    Objects.toString(rect6);
                    Objects.toString(view);
                    Objects.toString(itemConfiguration);
                    if (Math.abs(iArr[1]) + Math.abs(iArr[0]) > 1) {
                        int i33 = iArr[1];
                        iArr[1] = 0;
                        if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                            iArr[1] = i33;
                            int i34 = iArr[0];
                            iArr[0] = 0;
                            if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                                iArr[0] = i34;
                                iArr[0] = i34 * (-1);
                                int i35 = iArr[1] * (-1);
                                iArr[1] = i35;
                                iArr[1] = 0;
                                if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                                    iArr[1] = i35;
                                    int i36 = iArr[0];
                                    iArr[0] = 0;
                                    if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                                        iArr[0] = i36;
                                        iArr[0] = i36 * (-1);
                                        iArr[1] = iArr[1] * (-1);
                                        cellLayout = this;
                                        arrayList = arrayList2;
                                        Objects.toString(arrayList);
                                        Objects.toString(rect3);
                                        Objects.toString(view);
                                        Objects.toString(itemConfiguration);
                                        size = arrayList.size();
                                        iArr2 = cellLayout.f15480u;
                                        if (size == 0) {
                                            rect2 = rect3;
                                            z7 = true;
                                            c6 = 1;
                                        } else {
                                            size2 = arrayList.size();
                                            rect = null;
                                            i13 = 0;
                                            while (i13 < size2) {
                                                Object obj = arrayList.get(i13);
                                                i13++;
                                                cellAndSpan = (CellAndSpan) map2.get((View) obj);
                                                if (rect == null) {
                                                    int i37 = cellAndSpan.f15518a;
                                                    int i38 = cellAndSpan.f15519b;
                                                    rect = new Rect(i37, i38, cellAndSpan.f15520c + i37, cellAndSpan.f15521d + i38);
                                                } else {
                                                    int i39 = cellAndSpan.f15518a;
                                                    int i40 = cellAndSpan.f15519b;
                                                    rect.union(i39, i40, cellAndSpan.f15520c + i39, cellAndSpan.f15521d + i40);
                                                }
                                            }
                                            size3 = arrayList.size();
                                            i14 = 0;
                                            while (i14 < size3) {
                                                int i41 = i14 + 1;
                                                CellAndSpan cellAndSpan4 = (CellAndSpan) map2.get((View) arrayList.get(i14));
                                                cellLayout.m7655x(cellAndSpan4.f15518a, cellAndSpan4.f15519b, cellAndSpan4.f15520c, cellAndSpan4.f15521d, cellLayout.f15482w, false);
                                                cellLayout = this;
                                                i14 = i41;
                                            }
                                            c6 = 1;
                                            zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, rect.width(), rect.height());
                                            i15 = rect.top;
                                            i16 = rect.left;
                                            i17 = 0;
                                            for (size4 = arrayList.size(); i17 < size4; size4 = size4) {
                                                int i42 = i17 + 1;
                                                CellAndSpan cellAndSpan5 = (CellAndSpan) map2.get((View) arrayList.get(i17));
                                                m7655x(cellAndSpan5.f15518a - i16, cellAndSpan5.f15519b - i15, cellAndSpan5.f15520c, cellAndSpan5.f15521d, zArr, true);
                                                i17 = i42;
                                                i16 = i16;
                                            }
                                            cellLayout = this;
                                            boolean[][] zArr3 = cellLayout.f15482w;
                                            Objects.toString(rect3);
                                            cellLayout.m7655x(rect3.left, rect3.top, rect3.width(), rect3.height(), zArr3, true);
                                            rect2 = rect3;
                                            cellLayout.findNearestArea(rect.left, rect.top, rect.width(), rect.height(), iArr, cellLayout.f15482w, zArr, cellLayout.f15480u);
                                            i18 = iArr2[0];
                                            if (i18 >= 0 || (i20 = iArr2[1]) < 0) {
                                                z7 = false;
                                            } else {
                                                int i43 = i18 - rect.left;
                                                int i44 = i20 - rect.top;
                                                int size7 = arrayList.size();
                                                int i45 = 0;
                                                while (i45 < size7) {
                                                    Object obj2 = arrayList.get(i45);
                                                    i45++;
                                                    CellAndSpan cellAndSpan6 = (CellAndSpan) map2.get((View) obj2);
                                                    cellAndSpan6.f15518a += i43;
                                                    cellAndSpan6.f15519b += i44;
                                                }
                                                z7 = true;
                                            }
                                            size5 = arrayList.size();
                                            i19 = 0;
                                            while (i19 < size5) {
                                                int i46 = i19 + 1;
                                                CellAndSpan cellAndSpan7 = (CellAndSpan) map2.get((View) arrayList.get(i19));
                                                cellLayout.m7655x(cellAndSpan7.f15518a, cellAndSpan7.f15519b, cellAndSpan7.f15520c, cellAndSpan7.f15521d, cellLayout.f15482w, true);
                                                i19 = i46;
                                            }
                                        }
                                        if (!z7) {
                                            size6 = arrayList.size();
                                            i21 = 0;
                                            while (true) {
                                                if (i21 < size6) {
                                                    i22 = i21 + 1;
                                                    View view3 = (View) arrayList.get(i21);
                                                    Objects.toString(view3);
                                                    Objects.toString(rect2);
                                                    Objects.toString(itemConfiguration);
                                                    CellAndSpan cellAndSpan8 = (CellAndSpan) map2.get(view3);
                                                    cellLayout.m7655x(cellAndSpan8.f15518a, cellAndSpan8.f15519b, cellAndSpan8.f15520c, cellAndSpan8.f15521d, cellLayout.f15482w, false);
                                                    boolean[][] zArr4 = cellLayout.f15482w;
                                                    Objects.toString(rect2);
                                                    Rect rect7 = rect2;
                                                    cellLayout.m7655x(rect7.left, rect7.top, rect7.width(), rect7.height(), zArr4, true);
                                                    rect2 = rect7;
                                                    map = map2;
                                                    cellLayout.findNearestArea(cellAndSpan8.f15518a, cellAndSpan8.f15519b, cellAndSpan8.f15520c, cellAndSpan8.f15521d, iArr, cellLayout.f15482w, null, cellLayout.f15480u);
                                                    i23 = iArr2[0];
                                                    if (i23 >= 0 || (i24 = iArr2[c6]) < 0) {
                                                        z8 = false;
                                                    } else {
                                                        cellAndSpan8.f15518a = i23;
                                                        cellAndSpan8.f15519b = i24;
                                                        z8 = true;
                                                    }
                                                    cellLayout.m7655x(cellAndSpan8.f15518a, cellAndSpan8.f15519b, cellAndSpan8.f15520c, cellAndSpan8.f15521d, cellLayout.f15482w, true);
                                                    if (!z8) {
                                                        cellLayout = this;
                                                        i21 = i22;
                                                        map2 = map;
                                                    }
                                                }
                                            }
                                        }
                                        z6 = true;
                                        break;
                                    }
                                }
                            }
                        }
                        z6 = true;
                    } else {
                        if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                            iArr[0] = iArr[0] * (-1);
                            iArr[1] = iArr[1] * (-1);
                            if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                                int i47 = iArr[0] * (-1);
                                iArr[0] = i47;
                                int i48 = iArr[1] * (-1);
                                iArr[1] = i48;
                                iArr[1] = i47;
                                iArr[0] = i48;
                                if (!pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                                    iArr[0] = iArr[0] * (-1);
                                    iArr[1] = iArr[1] * (-1);
                                    cellLayout = this;
                                    arrayList = arrayList2;
                                    if (!cellLayout.pushViewsToTempLocation(arrayList2, rect6, iArr, view, itemConfiguration)) {
                                        int i49 = iArr[0] * (-1);
                                        iArr[0] = i49;
                                        int i50 = iArr[1] * (-1);
                                        iArr[1] = i50;
                                        iArr[1] = i49;
                                        iArr[0] = i50;
                                        Objects.toString(arrayList);
                                        Objects.toString(rect3);
                                        Objects.toString(view);
                                        Objects.toString(itemConfiguration);
                                        size = arrayList.size();
                                        iArr2 = cellLayout.f15480u;
                                        if (size == 0) {
                                            rect2 = rect3;
                                            z7 = true;
                                            c6 = 1;
                                        } else {
                                            size2 = arrayList.size();
                                            rect = null;
                                            i13 = 0;
                                            while (i13 < size2) {
                                                Object obj3 = arrayList.get(i13);
                                                i13++;
                                                cellAndSpan = (CellAndSpan) map2.get((View) obj3);
                                                if (rect == null) {
                                                    int i310 = cellAndSpan.f15518a;
                                                    int i311 = cellAndSpan.f15519b;
                                                    rect = new Rect(i310, i311, cellAndSpan.f15520c + i310, cellAndSpan.f15521d + i311);
                                                } else {
                                                    int i312 = cellAndSpan.f15518a;
                                                    int i410 = cellAndSpan.f15519b;
                                                    rect.union(i312, i410, cellAndSpan.f15520c + i312, cellAndSpan.f15521d + i410);
                                                }
                                            }
                                            size3 = arrayList.size();
                                            i14 = 0;
                                            while (i14 < size3) {
                                                int i411 = i14 + 1;
                                                CellAndSpan cellAndSpan9 = (CellAndSpan) map2.get((View) arrayList.get(i14));
                                                cellLayout.m7655x(cellAndSpan9.f15518a, cellAndSpan9.f15519b, cellAndSpan9.f15520c, cellAndSpan9.f15521d, cellLayout.f15482w, false);
                                                cellLayout = this;
                                                i14 = i411;
                                            }
                                            c6 = 1;
                                            zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, rect.width(), rect.height());
                                            i15 = rect.top;
                                            i16 = rect.left;
                                            i17 = 0;
                                            while (i17 < size4) {
                                                int i412 = i17 + 1;
                                                CellAndSpan cellAndSpan10 = (CellAndSpan) map2.get((View) arrayList.get(i17));
                                                m7655x(cellAndSpan10.f15518a - i16, cellAndSpan10.f15519b - i15, cellAndSpan10.f15520c, cellAndSpan10.f15521d, zArr, true);
                                                i17 = i412;
                                                i16 = i16;
                                            }
                                            cellLayout = this;
                                            boolean[][] zArr5 = cellLayout.f15482w;
                                            Objects.toString(rect3);
                                            cellLayout.m7655x(rect3.left, rect3.top, rect3.width(), rect3.height(), zArr5, true);
                                            rect2 = rect3;
                                            cellLayout.findNearestArea(rect.left, rect.top, rect.width(), rect.height(), iArr, cellLayout.f15482w, zArr, cellLayout.f15480u);
                                            i18 = iArr2[0];
                                            if (i18 >= 0) {
                                                z7 = false;
                                            } else {
                                                z7 = false;
                                            }
                                            size5 = arrayList.size();
                                            i19 = 0;
                                            while (i19 < size5) {
                                                int i413 = i19 + 1;
                                                CellAndSpan cellAndSpan11 = (CellAndSpan) map2.get((View) arrayList.get(i19));
                                                cellLayout.m7655x(cellAndSpan11.f15518a, cellAndSpan11.f15519b, cellAndSpan11.f15520c, cellAndSpan11.f15521d, cellLayout.f15482w, true);
                                                i19 = i413;
                                            }
                                        }
                                        if (!z7) {
                                            size6 = arrayList.size();
                                            i21 = 0;
                                            while (true) {
                                                if (i21 < size6) {
                                                    i22 = i21 + 1;
                                                    View view4 = (View) arrayList.get(i21);
                                                    Objects.toString(view4);
                                                    Objects.toString(rect2);
                                                    Objects.toString(itemConfiguration);
                                                    CellAndSpan cellAndSpan12 = (CellAndSpan) map2.get(view4);
                                                    cellLayout.m7655x(cellAndSpan12.f15518a, cellAndSpan12.f15519b, cellAndSpan12.f15520c, cellAndSpan12.f15521d, cellLayout.f15482w, false);
                                                    boolean[][] zArr6 = cellLayout.f15482w;
                                                    Objects.toString(rect2);
                                                    Rect rect8 = rect2;
                                                    cellLayout.m7655x(rect8.left, rect8.top, rect8.width(), rect8.height(), zArr6, true);
                                                    rect2 = rect8;
                                                    map = map2;
                                                    cellLayout.findNearestArea(cellAndSpan12.f15518a, cellAndSpan12.f15519b, cellAndSpan12.f15520c, cellAndSpan12.f15521d, iArr, cellLayout.f15482w, null, cellLayout.f15480u);
                                                    i23 = iArr2[0];
                                                    if (i23 >= 0) {
                                                        z8 = false;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    cellLayout.m7655x(cellAndSpan12.f15518a, cellAndSpan12.f15519b, cellAndSpan12.f15520c, cellAndSpan12.f15521d, cellLayout.f15482w, true);
                                                    if (!z8) {
                                                        cellLayout = this;
                                                        i21 = i22;
                                                        map2 = map;
                                                    }
                                                }
                                            }
                                        }
                                        z6 = true;
                                        break;
                                    }
                                }
                            }
                        }
                        z6 = true;
                    }
                }
                i11 = i11;
                break;
            }
            if (z6) {
                itemConfiguration.f15670e = true;
                itemConfiguration.f15671f = iArrFindNearestArea[0];
                itemConfiguration.f15672g = iArrFindNearestArea[1];
                itemConfiguration.f15673h = i10;
                itemConfiguration.f15674i = i11;
                return itemConfiguration;
            }
            if (i10 <= i8 && (i9 == i11 || z5)) {
                return m7649r(i6, i7, i8, i9, i10 - 1, i11, iArr, view, false, itemConfiguration);
            }
            i12 = i11;
            if (i12 > i9) {
                return m7649r(i6, i7, i8, i9, i10, i12 - 1, iArr, view, true, itemConfiguration);
            }
            itemConfiguration.f15670e = false;
            return itemConfiguration;
        }
        iArrFindNearestArea = iArrFindNearestArea;
        i11 = i11;
        z6 = false;
        if (z6) {
            if (i10 <= i8) {
            }
            i12 = i11;
            if (i12 > i9) {
                return m7649r(i6, i7, i8, i9, i10, i12 - 1, iArr, view, true, itemConfiguration);
            }
            itemConfiguration.f15670e = false;
            return itemConfiguration;
        }
        itemConfiguration.f15670e = true;
        itemConfiguration.f15671f = iArrFindNearestArea[0];
        itemConfiguration.f15672g = iArrFindNearestArea[1];
        itemConfiguration.f15673h = i10;
        itemConfiguration.f15674i = i11;
        return itemConfiguration;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        for (int i6 = 0; i6 < this.mCountX; i6++) {
            for (int i7 = 0; i7 < this.mCountY; i7++) {
                this.f15481v[i6][i7] = false;
            }
        }
        this.mShortcutsAndWidgets.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        if (shortcutAndWidgetContainer.getChildCount() > 0) {
            for (int i6 = 0; i6 < this.mCountX; i6++) {
                for (int i7 = 0; i7 < this.mCountY; i7++) {
                    this.f15481v[i6][i7] = false;
                }
            }
            shortcutAndWidgetContainer.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        Objects.toString(view);
        markCellsAsUnoccupiedForView(view);
        this.mShortcutsAndWidgets.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i6) {
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        markCellsAsUnoccupiedForView(shortcutAndWidgetContainer.getChildAt(i6));
        shortcutAndWidgetContainer.removeViewAt(i6);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        Objects.toString(view);
        markCellsAsUnoccupiedForView(view);
        this.mShortcutsAndWidgets.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i6, int i7) {
        int i8 = i6;
        while (true) {
            int i9 = i6 + i7;
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
            if (i8 >= i9) {
                shortcutAndWidgetContainer.removeViews(i6, i7);
                return;
            } else {
                markCellsAsUnoccupiedForView(shortcutAndWidgetContainer.getChildAt(i8));
                i8++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i6, int i7) {
        int i8 = i6;
        while (true) {
            int i9 = i6 + i7;
            ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
            if (i8 >= i9) {
                shortcutAndWidgetContainer.removeViewsInLayout(i6, i7);
                return;
            } else {
                markCellsAsUnoccupiedForView(shortcutAndWidgetContainer.getChildAt(i8));
                i8++;
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public final float getDistanceFromCell(float f6, float f7, int[] iArr) {
        int i6 = iArr[0];
        int i7 = iArr[1];
        int[] iArr2 = this.f15479t;
        regionToCenterPoint(i6, i7, 1, 1, iArr2);
        return (float) Math.hypot(f6 - iArr2[0], f7 - iArr2[1]);
    }

    public void setBackgroundAlpha(float f6) {
        if (this.mBackgroundAlpha != f6) {
            this.mBackgroundAlpha = f6;
            this.f15448C.setAlpha((int) (f6 * 255.0f));
        }
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawingCacheEnabled(boolean z5) {
        this.mShortcutsAndWidgets.setChildrenDrawingCacheEnabled(z5);
    }

    @Override // android.view.ViewGroup
    public void setChildrenDrawnWithCacheEnabled(boolean z5) {
        this.mShortcutsAndWidgets.setChildrenDrawnWithCacheEnabled(z5);
    }

    public void setDropPending(boolean z5) {
        this.mDropPending = z5;
    }

    public void setInvertIfRtl(boolean z5) {
        this.mShortcutsAndWidgets.setInvertIfRtl(z5);
    }

    public void setIsDragOverlapping(boolean z5) {
        if (this.mIsDragOverlapping != z5) {
            this.mIsDragOverlapping = z5;
            TransitionDrawable transitionDrawable = this.f15448C;
            if (z5) {
                transitionDrawable.startTransition(120);
            } else if (this.mBackgroundAlpha > 0.0f) {
                transitionDrawable.reverseTransition(120);
            } else {
                transitionDrawable.resetTransition();
            }
            invalidate();
        }
    }

    public void setIsHotseat(boolean z5) {
        this.f15458M = z5;
        this.mShortcutsAndWidgets.setIsHotseat(z5);
    }

    public void setIsShaking(boolean z5) {
        this.mShortcutsAndWidgets.setIsShaking(z5);
    }

    public void setItemPlacementDirty(boolean z5) {
        this.mItemPlacementDirty = z5;
    }

    public void setOnInterceptTouchListener(View.OnTouchListener onTouchListener) {
        Objects.toString(onTouchListener);
        this.f15483x = onTouchListener;
    }

    public void setShortcutAndWidgetAlpha(float f6) {
        this.mShortcutsAndWidgets.setAlpha(f6);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: renamed from: t */
    public final void getViewsIntersectingRegion(int i6, int i7, int i8, int i9, View view, Rect rect, ArrayList arrayList) {
        Objects.toString(view);
        Objects.toString(rect);
        Objects.toString(arrayList);
        if (rect != null) {
            rect.set(i6, i7, i6 + i8, i7 + i9);
        }
        arrayList.clear();
        Rect rect2 = new Rect(i6, i7, i8 + i6, i9 + i7);
        Rect rect3 = new Rect();
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i10);
            if (childAt != view) {
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) childAt.getLayoutParams();
                int i11 = cellLayoutLayoutParams.f15685a;
                int i12 = cellLayoutLayoutParams.f15686b;
                rect3.set(i11, i12, cellLayoutLayoutParams.f15690f + i11, cellLayoutLayoutParams.f15691g + i12);
                if (Rect.intersects(rect2, rect3)) {
                    this.f15461P.add(childAt);
                    if (rect != null) {
                        rect.union(rect3);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: u */
    public final boolean isRegionVacant(int i6, int i7, int i8, int i9) {
        int i10 = (i8 + i6) - 1;
        int i11 = (i9 + i7) - 1;
        if (i6 < 0 || i7 < 0 || i10 >= this.mCountX || i11 >= this.mCountY) {
            return false;
        }
        while (i6 <= i10) {
            for (int i12 = i7; i12 <= i11; i12++) {
                if (this.f15481v[i6][i12]) {
                    return false;
                }
            }
            i6++;
        }
        return true;
    }

    /* JADX INFO: renamed from: v */
    public final void markCellsAsOccupiedForView(View view) {
        Objects.toString(view);
        if (view == null || view.getParent() != this.mShortcutsAndWidgets) {
            return;
        }
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        m7655x(cellLayoutLayoutParams.f15685a, cellLayoutLayoutParams.f15686b, cellLayoutLayoutParams.f15690f, cellLayoutLayoutParams.f15691g, this.f15481v, true);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Objects.toString(drawable);
        if (super.verifyDrawable(drawable)) {
            return true;
        }
        return this.f15477r && drawable == this.f15448C;
    }

    /* JADX INFO: renamed from: w */
    public final void markCellsAsUnoccupiedForView(View view) {
        Objects.toString(view);
        if (view == null || view.getParent() != this.mShortcutsAndWidgets) {
            return;
        }
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        m7655x(cellLayoutLayoutParams.f15685a, cellLayoutLayoutParams.f15686b, cellLayoutLayoutParams.f15690f, cellLayoutLayoutParams.f15691g, this.f15481v, false);
    }

    /* JADX INFO: renamed from: x */
    public final void m7655x(int i6, int i7, int i8, int i9, boolean[][] zArr, boolean z5) {
        if (i6 < 0 || i7 < 0) {
            return;
        }
        for (int i10 = i6; i10 < i6 + i8 && i10 < this.mCountX; i10++) {
            for (int i11 = i7; i11 < i7 + i9 && i11 < this.mCountY; i11++) {
                zArr[i10][i11] = z5;
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public final void onDropChild(View view) {
        Objects.toString(view);
        if (view != null) {
            ((CellLayoutLayoutParams) view.getLayoutParams()).f15697m = true;
            view.requestLayout();
            markCellsAsOccupiedForView(view);
            if (view instanceof FolderIcon) {
                ((FolderIcon) view).setVisibilityGlassBackground(true ^ this.f15458M);
            }
            if (this.f15469j.isShaking()) {
                if (view instanceof BubbleTextView) {
                    ((BubbleTextView) view).m7600I();
                } else if (view instanceof LauncherAppWidgetHostView) {
                    ((LauncherAppWidgetHostView) view).onTouchComplete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: z */
    public final void m7657z(boolean z5) {
        BubbleTextView bubbleTextView;
        CustomIconView customIconView;
        ShortcutAndWidgetContainer shortcutAndWidgetContainer = this.mShortcutsAndWidgets;
        int childCount = shortcutAndWidgetContainer.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = shortcutAndWidgetContainer.getChildAt(i6);
            if (childAt instanceof FolderIcon) {
                FolderIcon folderIcon = (FolderIcon) childAt;
                folderIcon.f15665z = z5;
                if (folderIcon.isAttachedToWindow()) {
                    folderIcon.setGlassViewVisible(z5);
                } else {
                    folderIcon.post(new FolderIconGlassRunnable(folderIcon, z5, 0));
                }
            } else if ((childAt instanceof BubbleTextView) && (customIconView = (bubbleTextView = (BubbleTextView) childAt).f15408v) != null && customIconView.f16918n) {
                CustomIconView iconView = bubbleTextView.getIconView();
                boolean z6 = z5 && iconView.f16918n && iconView.f16919o && iconView.isShown();
                iconView.f16930z = z6;
                if (z6) {
                    RunnableC0064g runnableC0064g = iconView.f16916A;
                    iconView.removeCallbacks(runnableC0064g);
                    iconView.postDelayed(runnableC0064g, 136L);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Objects.toString(layoutParams);
        CellLayoutLayoutParams cellLayoutLayoutParams = new CellLayoutLayoutParams(layoutParams);
        cellLayoutLayoutParams.f15692h = true;
        cellLayoutLayoutParams.f15693i = false;
        cellLayoutLayoutParams.f15694j = true;
        cellLayoutLayoutParams.f15690f = 1;
        cellLayoutLayoutParams.f15691g = 1;
        return cellLayoutLayoutParams;
    }
}
