package com.luutinhit.launcher6;

import B3.AbstractC0075r;
import M2.RunnableC0674C;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.luutinhit.launcherios.R;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.f */
/* JADX INFO: loaded from: classes.dex */
public final class AppWidgetResizeFrame extends FrameLayout implements View.OnKeyListener {

    /* JADX INFO: renamed from: R */
    public static final Rect f16440R = new Rect();

    /* JADX INFO: renamed from: A */
    public boolean f16441A;

    /* JADX INFO: renamed from: B */
    public boolean f16442B;

    /* JADX INFO: renamed from: C */
    public int f16443C;

    /* JADX INFO: renamed from: D */
    public int f16444D;

    /* JADX INFO: renamed from: E */
    public int f16445E;

    /* JADX INFO: renamed from: F */
    public int f16446F;

    /* JADX INFO: renamed from: G */
    public int f16447G;

    /* JADX INFO: renamed from: H */
    public int f16448H;

    /* JADX INFO: renamed from: I */
    public int f16449I;

    /* JADX INFO: renamed from: J */
    public int f16450J;

    /* JADX INFO: renamed from: K */
    public int f16451K;

    /* JADX INFO: renamed from: L */
    public int f16452L;

    /* JADX INFO: renamed from: M */
    public int f16453M;

    /* JADX INFO: renamed from: N */
    public int f16454N;

    /* JADX INFO: renamed from: O */
    public int f16455O;

    /* JADX INFO: renamed from: P */
    public int f16456P;

    /* JADX INFO: renamed from: Q */
    public int f16457Q;

    /* JADX INFO: renamed from: j */
    public Launcher f16458j;

    /* JADX INFO: renamed from: k */
    public LauncherAppWidgetHostView f16459k;

    /* JADX INFO: renamed from: l */
    public CellLayout f16460l;

    /* JADX INFO: renamed from: m */
    public DragLayer f16461m;

    /* JADX INFO: renamed from: n */
    public ImageView f16462n;

    /* JADX INFO: renamed from: o */
    public ImageView f16463o;

    /* JADX INFO: renamed from: p */
    public ImageView f16464p;

    /* JADX INFO: renamed from: q */
    public ImageView f16465q;

    /* JADX INFO: renamed from: r */
    public Rect f16466r;

    /* JADX INFO: renamed from: s */
    public int f16467s;

    /* JADX INFO: renamed from: t */
    public int f16468t;

    /* JADX INFO: renamed from: u */
    public int[] f16469u;

    /* JADX INFO: renamed from: v */
    public int[] f16470v;

    /* JADX INFO: renamed from: w */
    public int[] f16471w;

    /* JADX INFO: renamed from: x */
    public RunnableC0674C f16472x;

    /* JADX INFO: renamed from: y */
    public boolean f16473y;

    /* JADX INFO: renamed from: z */
    public boolean f16474z;

    public AppWidgetResizeFrame(Context context, LauncherAppWidgetHostView launcherAppWidgetHostView, CellLayout cellLayout, DragLayer dragLayer) {
        super(context);
        this.f16469u = new int[2];
        this.f16470v = new int[2];
        this.f16471w = new int[2];
        this.f16456P = 0;
        this.f16457Q = 0;
        this.f16458j = (Launcher) context;
        this.f16460l = cellLayout;
        this.f16459k = launcherAppWidgetHostView;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo = (LauncherAppWidgetProviderInfo) launcherAppWidgetHostView.getAppWidgetInfo();
        int i6 = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).resizeMode;
        this.f16447G = i6;
        this.f16461m = dragLayer;
        this.f16450J = launcherAppWidgetProviderInfo.f16576l;
        this.f16451K = launcherAppWidgetProviderInfo.f16577m;
        this.f16472x = ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled() ? new RunnableC0674C(1, this) : null;
        setForeground(getResources().getDrawable(R.drawable.widget_resize_frame_new));
        setPadding(0, 0, 0, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.widget_handle_margin);
        ImageView imageView = new ImageView(context);
        this.f16462n = imageView;
        imageView.setImageResource(2131231129);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 19);
        layoutParams.leftMargin = dimensionPixelSize;
        addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.f16463o = imageView2;
        imageView2.setImageResource(2131231129);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 21);
        layoutParams2.rightMargin = dimensionPixelSize;
        addView(imageView2, layoutParams2);
        ImageView imageView3 = new ImageView(context);
        this.f16464p = imageView3;
        imageView3.setImageResource(2131231129);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, 49);
        layoutParams3.topMargin = dimensionPixelSize;
        addView(imageView3, layoutParams3);
        ImageView imageView4 = new ImageView(context);
        this.f16465q = imageView4;
        imageView4.setImageResource(2131231129);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 81);
        layoutParams4.bottomMargin = dimensionPixelSize;
        addView(imageView4, layoutParams4);
        this.f16466r = AppWidgetHostView.getDefaultPaddingForWidget(context, launcherAppWidgetHostView.getAppWidgetInfo().provider, null);
        if (i6 == 1) {
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
        } else if (i6 == 2) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.resize_frame_background_padding);
        this.f16467s = dimensionPixelSize2;
        this.f16468t = dimensionPixelSize2 * 3;
        cellLayout.markCellsAsUnoccupiedForView(launcherAppWidgetHostView);
        setOnKeyListener(this);
    }

    /* JADX INFO: renamed from: a */
    public static void getWidgetSizeRanges(Launcher launcher, int i6, int i7, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        Rect rectM0 = Workspace.M0(0, launcher);
        Rect rectM1 = Workspace.M0(1, launcher);
        float f6 = launcher.getResources().getDisplayMetrics().density;
        int i8 = rectM0.left;
        int i9 = rectM0.top;
        int i10 = i6 - 1;
        int i11 = (int) (((rectM0.right * i10) + (i8 * i6)) / f6);
        int i12 = i7 - 1;
        rect.set((int) (((i10 * rectM1.right) + (i6 * rectM1.left)) / f6), (int) (((rectM0.bottom * i12) + (i9 * i7)) / f6), i11, (int) (((i12 * rectM1.bottom) + (i7 * rectM1.top)) / f6));
    }

    /* JADX INFO: renamed from: d */
    public static void updateWidgetSizeRanges(int i6, int i7, AppWidgetHostView appWidgetHostView, Launcher launcher) {
        Rect rect = f16440R;
        getWidgetSizeRanges(launcher, i6, i7, rect);
        appWidgetHostView.updateAppWidgetSize(null, rect.left, rect.top, rect.right, rect.bottom);
        appWidgetHostView.setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: b */
    public final void resizeWidgetIfNeeded(boolean z5) {
        int iMin;
        int i6;
        int i7;
        int iMin2;
        CellLayout cellLayout = this.f16460l;
        int widthGap = cellLayout.getWidthGap() + cellLayout.getCellWidth();
        int heightGap = cellLayout.getHeightGap() + cellLayout.getCellHeight();
        int i8 = this.f16452L + this.f16454N;
        int i9 = this.f16453M + this.f16455O;
        float f6 = ((i8 * 1.0f) / widthGap) - this.f16448H;
        float f7 = ((i9 * 1.0f) / heightGap) - this.f16449I;
        int countX = cellLayout.getCountX();
        int countY = cellLayout.getCountY();
        int iRound = Math.abs(f6) > 0.66f ? Math.round(f6) : 0;
        int iRound2 = Math.abs(f7) > 0.66f ? Math.round(f7) : 0;
        if (!z5 && iRound == 0 && iRound2 == 0) {
            return;
        }
        LauncherAppWidgetHostView launcherAppWidgetHostView = this.f16459k;
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) launcherAppWidgetHostView.getLayoutParams();
        int i10 = cellLayoutLayoutParams.f15690f;
        int i11 = cellLayoutLayoutParams.f15691g;
        boolean z6 = cellLayoutLayoutParams.f15689e;
        int i12 = z6 ? cellLayoutLayoutParams.f15687c : cellLayoutLayoutParams.f15685a;
        int i13 = z6 ? cellLayoutLayoutParams.f15688d : cellLayoutLayoutParams.f15686b;
        boolean z7 = this.f16473y;
        int i14 = this.f16450J;
        if (z7) {
            iMin = Math.min(cellLayoutLayoutParams.f15690f - i14, Math.max(-i12, iRound));
            iRound = Math.max(-(cellLayoutLayoutParams.f15690f - i14), Math.min(i12, iRound * (-1)));
            i6 = -iRound;
        } else if (this.f16474z) {
            iRound = Math.max(-(cellLayoutLayoutParams.f15690f - i14), Math.min(countX - (i12 + i10), iRound));
            i6 = iRound;
            iMin = 0;
        } else {
            iMin = 0;
            i6 = 0;
        }
        boolean z8 = this.f16441A;
        int i15 = this.f16451K;
        if (z8) {
            iMin2 = Math.min(cellLayoutLayoutParams.f15691g - i15, Math.max(-i13, iRound2));
            iRound2 = Math.max(-(cellLayoutLayoutParams.f15691g - i15), Math.min(i13, iRound2 * (-1)));
            i7 = -iRound2;
        } else {
            if (this.f16442B) {
                iRound2 = Math.max(-(cellLayoutLayoutParams.f15691g - i15), Math.min(countY - (i13 + i11), iRound2));
                i7 = iRound2;
            } else {
                i7 = 0;
            }
            iMin2 = 0;
        }
        int[] iArr = this.f16469u;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean z9 = this.f16473y;
        if (z9 || this.f16474z) {
            i10 += iRound;
            i12 += iMin;
            if (i6 != 0) {
                iArr[0] = z9 ? -1 : 1;
            }
        }
        int i16 = i10;
        int i17 = i12;
        boolean z10 = this.f16441A;
        if (z10 || this.f16442B) {
            i11 += iRound2;
            i13 += iMin2;
            if (i7 != 0) {
                iArr[1] = z10 ? -1 : 1;
            }
        }
        int i18 = i11;
        int i19 = i13;
        if (!z5 && i7 == 0 && i6 == 0) {
            return;
        }
        int[] iArr2 = this.f16470v;
        if (z5) {
            iArr[0] = iArr2[0];
            iArr[1] = iArr2[1];
        } else {
            iArr2[0] = iArr[0];
            iArr2[1] = iArr[1];
        }
        if (this.f16460l.createAreaForResize(i17, i19, i16, i18, this.f16459k, iArr, z5)) {
            Launcher launcher = this.f16458j;
            RunnableC0674C runnableC0674C = this.f16472x;
            if (runnableC0674C != null && (cellLayoutLayoutParams.f15690f != i16 || cellLayoutLayoutParams.f15691g != i18)) {
                runnableC0674C.m1502a(launcher.getString(R.string.widget_resized, Integer.valueOf(i16), Integer.valueOf(i18)));
            }
            cellLayoutLayoutParams.f15687c = i17;
            cellLayoutLayoutParams.f15688d = i19;
            cellLayoutLayoutParams.f15690f = i16;
            cellLayoutLayoutParams.f15691g = i18;
            this.f16449I += i7;
            this.f16448H += i6;
            if (!z5) {
                updateWidgetSizeRanges(i16, i18, launcherAppWidgetHostView, launcher);
            }
        }
        launcherAppWidgetHostView.requestLayout();
    }

    /* JADX INFO: renamed from: c */
    public final void snapToWidget(boolean z5) {
        DragLayerLayoutParams dragLayerLayoutParams = (DragLayerLayoutParams) getLayoutParams();
        LauncherAppWidgetHostView launcherAppWidgetHostView = this.f16459k;
        int width = launcherAppWidgetHostView.getWidth();
        int i6 = this.f16467s;
        int i7 = i6 * 2;
        Rect rect = this.f16466r;
        int i8 = ((width + i7) - rect.left) - rect.right;
        int height = ((launcherAppWidgetHostView.getHeight() + i7) - rect.top) - rect.bottom;
        int left = launcherAppWidgetHostView.getLeft();
        int[] iArr = this.f16471w;
        int i9 = 0;
        iArr[0] = left;
        iArr[1] = launcherAppWidgetHostView.getTop();
        ShortcutAndWidgetContainer shortcutsAndWidgets = this.f16460l.getShortcutsAndWidgets();
        DragLayer dragLayer = this.f16461m;
        dragLayer.getDescendantCoordRelativeToSelf(shortcutsAndWidgets, iArr);
        int i10 = (iArr[0] - i6) + rect.left;
        int i11 = (iArr[1] - i6) + rect.top;
        if (i11 < 0) {
            this.f16456P = -i11;
        } else {
            this.f16456P = 0;
        }
        int i12 = i11 + height;
        if (i12 > dragLayer.getHeight()) {
            this.f16457Q = -(i12 - dragLayer.getHeight());
        } else {
            this.f16457Q = 0;
        }
        ImageView imageView = this.f16465q;
        ImageView imageView2 = this.f16464p;
        ImageView imageView3 = this.f16463o;
        ImageView imageView4 = this.f16462n;
        if (z5) {
            PropertyValuesHolder[] propertyValuesHolderArr = {PropertyValuesHolder.ofInt("width", ((FrameLayout.LayoutParams) dragLayerLayoutParams).width, i8), PropertyValuesHolder.ofInt("height", ((FrameLayout.LayoutParams) dragLayerLayoutParams).height, height), PropertyValuesHolder.ofInt("x", dragLayerLayoutParams.f16208b, i10), PropertyValuesHolder.ofInt("y", dragLayerLayoutParams.f16209c, i11)};
            WeakHashMap weakHashMap = LauncherAnimUtils.sAnimators;
            ObjectAnimator objectAnimator = new ObjectAnimator();
            objectAnimator.setTarget(dragLayerLayoutParams);
            objectAnimator.setValues(propertyValuesHolderArr);
            objectAnimator.addListener(LauncherAnimUtils.f16143b);
            new FirstFrameAnimatorHelper(objectAnimator, this);
            ObjectAnimator objectAnimatorOfFloat = LauncherAnimUtils.ofFloat(imageView4, "alpha", 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = LauncherAnimUtils.ofFloat(imageView3, "alpha", 1.0f);
            ObjectAnimator objectAnimatorOfFloat3 = LauncherAnimUtils.ofFloat(imageView2, "alpha", 1.0f);
            ObjectAnimator objectAnimatorOfFloat4 = LauncherAnimUtils.ofFloat(imageView, "alpha", 1.0f);
            objectAnimator.addUpdateListener(new SharedAnimatorUpdateListener(i9, this));
            AnimatorSet animatorSetCreateAnimatorSet = LauncherAnimUtils.createAnimatorSet();
            int i13 = this.f16447G;
            if (i13 == 2) {
                animatorSetCreateAnimatorSet.playTogether(objectAnimator, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            } else if (i13 == 1) {
                animatorSetCreateAnimatorSet.playTogether(objectAnimator, objectAnimatorOfFloat, objectAnimatorOfFloat2);
            } else {
                animatorSetCreateAnimatorSet.playTogether(objectAnimator, objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
            }
            animatorSetCreateAnimatorSet.setDuration(150L);
            animatorSetCreateAnimatorSet.start();
        } else {
            ((FrameLayout.LayoutParams) dragLayerLayoutParams).width = i8;
            ((FrameLayout.LayoutParams) dragLayerLayoutParams).height = height;
            dragLayerLayoutParams.f16208b = i10;
            dragLayerLayoutParams.f16209c = i11;
            imageView4.setAlpha(1.0f);
            imageView3.setAlpha(1.0f);
            imageView2.setAlpha(1.0f);
            imageView.setAlpha(1.0f);
            requestLayout();
        }
        setFocusableInTouchMode(true);
        requestFocus();
    }

    /* JADX INFO: renamed from: e */
    public final void updateDeltas(int i6, int i7) {
        boolean z5 = this.f16473y;
        DragLayer dragLayer = this.f16461m;
        int i8 = this.f16468t;
        if (z5) {
            int iMax = Math.max(-this.f16445E, i6);
            this.f16452L = iMax;
            this.f16452L = Math.min(this.f16443C - (i8 * 2), iMax);
        } else if (this.f16474z) {
            int iMin = Math.min(dragLayer.getWidth() - (this.f16445E + this.f16443C), i6);
            this.f16452L = iMin;
            this.f16452L = Math.max((i8 * 2) + (-this.f16443C), iMin);
        }
        if (this.f16441A) {
            int iMax2 = Math.max(-this.f16446F, i7);
            this.f16453M = iMax2;
            this.f16453M = Math.min(this.f16444D - (i8 * 2), iMax2);
        } else if (this.f16442B) {
            int iMin2 = Math.min(dragLayer.getHeight() - (this.f16446F + this.f16444D), i7);
            this.f16453M = iMin2;
            this.f16453M = Math.max((i8 * 2) + (-this.f16444D), iMin2);
        }
        DragLayerLayoutParams dragLayerLayoutParams = (DragLayerLayoutParams) getLayoutParams();
        if (this.f16473y) {
            int i9 = this.f16445E;
            int i10 = this.f16452L;
            dragLayerLayoutParams.f16208b = i9 + i10;
            ((FrameLayout.LayoutParams) dragLayerLayoutParams).width = this.f16443C - i10;
        } else if (this.f16474z) {
            ((FrameLayout.LayoutParams) dragLayerLayoutParams).width = this.f16443C + this.f16452L;
        }
        if (this.f16441A) {
            int i11 = this.f16446F;
            int i12 = this.f16453M;
            dragLayerLayoutParams.f16209c = i11 + i12;
            ((FrameLayout.LayoutParams) dragLayerLayoutParams).height = this.f16444D - i12;
        } else if (this.f16442B) {
            ((FrameLayout.LayoutParams) dragLayerLayoutParams).height = this.f16444D + this.f16453M;
        }
        resizeWidgetIfNeeded(false);
        requestLayout();
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        if (!AbstractC0075r.m197s(i6)) {
            return false;
        }
        this.f16461m.clearAllResizeFrames();
        this.f16459k.requestFocus();
        return true;
    }
}
