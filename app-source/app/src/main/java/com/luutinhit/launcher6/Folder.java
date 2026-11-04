package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import M2.RunnableC0674C;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Objects;
import p003D.C0165i;
import p101l3.InterfaceC2338c;

/* JADX INFO: loaded from: classes.dex */
public class Folder extends LinearLayout implements DragSource, View.OnClickListener, View.OnLongClickListener, DropTarget, FolderListener, TextView.OnEditorActionListener, View.OnFocusChangeListener, DragListener, UninstallSource, InterfaceC2338c, LaunchSourceProvider {

    /* JADX INFO: renamed from: i0 */
    public static String sDefaultFolderName;

    /* JADX INFO: renamed from: j0 */
    public static String sHintText;

    /* JADX INFO: renamed from: A */
    public int[] f15598A;

    /* JADX INFO: renamed from: B */
    public ExtendedEditText mFolderName;

    /* JADX INFO: renamed from: C */
    public int f15600C;

    /* JADX INFO: renamed from: D */
    public int f15601D;

    /* JADX INFO: renamed from: E */
    public int f15602E;

    /* JADX INFO: renamed from: F */
    public int f15603F;

    /* JADX INFO: renamed from: G */
    public boolean f15604G;

    /* JADX INFO: renamed from: H */
    public boolean f15605H;

    /* JADX INFO: renamed from: I */
    public ShortcutInfo f15606I;

    /* JADX INFO: renamed from: J */
    public View f15607J;

    /* JADX INFO: renamed from: K */
    public boolean f15608K;

    /* JADX INFO: renamed from: L */
    public boolean f15609L;

    /* JADX INFO: renamed from: M */
    public boolean f15610M;

    /* JADX INFO: renamed from: N */
    public boolean f15611N;

    /* JADX INFO: renamed from: O */
    public boolean f15612O;

    /* JADX INFO: renamed from: P */
    public boolean f15613P;

    /* JADX INFO: renamed from: Q */
    public float mFolderIconPivotX;

    /* JADX INFO: renamed from: R */
    public float mFolderIconPivotY;

    /* JADX INFO: renamed from: S */
    public boolean f15616S;

    /* JADX INFO: renamed from: T */
    public boolean f15617T;

    /* JADX INFO: renamed from: U */
    public boolean f15618U;

    /* JADX INFO: renamed from: V */
    public DropCompleteRunnable f15619V;

    /* JADX INFO: renamed from: W */
    public boolean f15620W;

    /* JADX INFO: renamed from: a0 */
    public boolean f23331a0;

    /* JADX INFO: renamed from: b0 */
    public int f23332b0;

    /* JADX INFO: renamed from: c0 */
    public int f23333c0;

    /* JADX INFO: renamed from: d0 */
    public int f23334d0;

    /* JADX INFO: renamed from: e0 */
    public FolderGlassFrameCallback f23335e0;

    /* JADX INFO: renamed from: f0 */
    public FolderReorderAlarmListener f23336f0;

    /* JADX INFO: renamed from: g0 */
    public FolderReorderAlarmListener f23337g0;

    /* JADX INFO: renamed from: j */
    public Alarm f15621j;

    /* JADX INFO: renamed from: k */
    public Alarm f15622k;

    /* JADX INFO: renamed from: l */
    public Alarm f15623l;

    /* JADX INFO: renamed from: m */
    public Alarm f15624m;

    /* JADX INFO: renamed from: n */
    public ArrayList f15625n;

    /* JADX INFO: renamed from: o */
    public int mExpandDuration;

    /* JADX INFO: renamed from: p */
    public InputMethodManager f15627p;

    /* JADX INFO: renamed from: q */
    public Launcher f15628q;

    /* JADX INFO: renamed from: r */
    public DragController mDragController;

    /* JADX INFO: renamed from: s */
    public FolderInfo mInfo;

    /* JADX INFO: renamed from: t */
    public FolderIcon mFolderIcon;

    /* JADX INFO: renamed from: u */
    public FolderPagedView mContent;

    /* JADX INFO: renamed from: v */
    public FrameLayout mContentWrapper;

    /* JADX INFO: renamed from: w */
    public LiquidGlassEglTextureView f15634w;

    /* JADX INFO: renamed from: x */
    public RuntimeShaderGlassView f15635x;

    /* JADX INFO: renamed from: y */
    public float f15636y;

    /* JADX INFO: renamed from: z */
    public float f15637z;

    /* JADX INFO: renamed from: h0 */
    public static final Rect f23327h0 = new Rect();

    /* JADX INFO: renamed from: k0 */
    public static final C0165i f23330k0 = new C0165i(6);

    public Folder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15621j = new Alarm();
        this.f15622k = new Alarm();
        this.f15623l = new Alarm();
        this.f15624m = new Alarm();
        this.f15625n = new ArrayList();
        this.f15636y = 1.0f;
        this.f15637z = 1.0f;
        this.f15598A = new int[2];
        this.f15603F = -1;
        this.f15604G = false;
        this.f15605H = false;
        this.f15609L = false;
        this.f15610M = false;
        this.f15611N = false;
        this.f15612O = false;
        this.f15613P = false;
        this.f15616S = false;
        this.f15618U = false;
        this.f23333c0 = -1;
        this.f23334d0 = -1;
        this.f23335e0 = null;
        this.f23336f0 = new FolderReorderAlarmListener(this, 0);
        this.f23337g0 = new FolderReorderAlarmListener(this, 1);
        setAlwaysDrawnWithCacheEnabled(false);
        this.f15627p = (InputMethodManager) getContext().getSystemService("input_method");
        Resources resources = getResources();
        this.mExpandDuration = resources.getInteger(R.integer.config_folderExpandDuration);
        if (sDefaultFolderName == null) {
            sDefaultFolderName = resources.getString(R.string.folder_name);
        }
        if (sHintText == null) {
            sHintText = resources.getString(R.string.folder_hint_text);
        }
        this.f15628q = (Launcher) context;
        setFocusableInTouchMode(true);
    }

    public int getContentAreaHeight() {
        DeviceProfile deviceProfile = this.f15628q.getDeviceProfile();
        boolean z5 = this.mContent.f23349w0;
        Rect rectM7812d = deviceProfile.m7812d();
        return Math.max(Math.min(((deviceProfile.f16013m - rectM7812d.top) - rectM7812d.bottom) - this.mFolderName.getMeasuredHeight(), this.mContent.getDesiredWidth()), 5);
    }

    public int getContentAreaWidth() {
        return Math.max(this.mContent.getDesiredWidth(), 5);
    }

    public int getFolderHeight() {
        return getPaddingBottom() + getPaddingTop() + getContentAreaHeight();
    }

    public int getFolderPaddingStart() {
        try {
            return (this.f15628q.getDeviceProfile().f16010j - this.mContent.getDesiredWidth()) / 2;
        } catch (Throwable unused) {
            return getResources().getDimensionPixelSize(R.dimen.folder_padding_start);
        }
    }

    public int getFolderPaddingTop() {
        try {
            return (((this.f15628q.getDeviceProfile().f16011k - this.mContent.getDesiredHeight()) / 2) - this.mFolderName.getMeasuredHeight()) - getResources().getDimensionPixelSize(R.dimen.folder_name_margin_bottom);
        } catch (Throwable unused) {
            return getResources().getDimensionPixelSize(R.dimen.folder_padding_top);
        }
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: A */
    public final void mo7658A(ShortcutInfo shortcutInfo) {
        this.f15605H = true;
        if (shortcutInfo == this.f15606I) {
            return;
        }
        View viewM7700O = m7700O(shortcutInfo);
        viewM7700O.clearAnimation();
        FolderPagedView folderPagedView = this.mContent;
        for (int childCount = folderPagedView.getChildCount() - 1; childCount >= 0; childCount--) {
            ((CellLayout) folderPagedView.getChildAt(childCount)).removeView(viewM7700O);
        }
        if (this.f15603F == 1) {
            this.f15604G = true;
        } else {
            addItemLocationsInDatabase();
        }
        if (getItemCount() <= 1) {
            if (this.mInfo.f15523B) {
                this.f15628q.closeFolder(this, true);
            } else {
                m7704T();
            }
        }
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: B */
    public final void mo7605B(DragObject dragObject) {
        if (!dragObject.f16521e) {
            FolderReorderAlarmListener folderReorderAlarmListener = this.f23337g0;
            Alarm alarm = this.f15622k;
            alarm.f16206m = folderReorderAlarmListener;
            alarm.setAlarm(400L);
        }
        this.f15621j.cancelAlarm();
        this.f15623l.cancelAlarm();
        this.f15624m.cancelAlarm();
        if (this.f23333c0 != -1) {
            FolderPagedView folderPagedView = this.mContent;
            if (folderPagedView.getScrollX() != folderPagedView.getScrollForPage(folderPagedView.getNextPage())) {
                folderPagedView.l0(folderPagedView.getNextPage());
            }
            this.f23333c0 = -1;
        }
    }

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: C */
    public final void mo905C() {
        if (this.f15608K && this.f15610M) {
            completeDragExit();
        }
        this.mDragController.f16104m.remove(this);
    }

    @Override // com.luutinhit.launcher6.LaunchSourceProvider
    /* JADX INFO: renamed from: D */
    public final void mo7690D(View view, Bundle bundle) {
        FocusHelper.m7980h(this.mFolderIcon, bundle);
        bundle.putString("sub_container", "folder");
        bundle.putInt("sub_container_page", this.mContent.getCurrentPage());
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: F */
    public final void mo7691F(View view, DragObject dragObject, boolean z5) {
        if (this.f15620W) {
            this.f15619V = new DropCompleteRunnable(this, view, dragObject, z5, 0);
            return;
        }
        boolean z6 = z5 && (!(this.f15619V != null) || this.f23331a0);
        if (!z6) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) dragObject.f16523g;
            View view2 = this.f15607J;
            View viewY0 = (view2 == null || view2.getTag() != shortcutInfo) ? this.mContent.y0(shortcutInfo) : this.f15607J;
            ArrayList<View> itemsInReadingOrder = getItemsInReadingOrder();
            itemsInReadingOrder.add(shortcutInfo.f16791t, viewY0);
            this.mContent.w0(itemsInReadingOrder.size(), itemsInReadingOrder, true);
            this.f15605H = true;
            this.f15609L = true;
            this.mFolderIcon.onDrop(dragObject);
            this.f15609L = false;
        } else if (this.f15611N && !this.f15613P && view != this) {
            m7704T();
        }
        if (view != this) {
            Alarm alarm = this.f15622k;
            if (alarm.f16207n) {
                alarm.cancelAlarm();
                if (!z6) {
                    this.f15612O = true;
                }
                this.f15624m.cancelAlarm();
                completeDragExit();
            }
        }
        this.f15611N = false;
        this.f15610M = false;
        this.f15613P = false;
        this.f15606I = null;
        this.f15607J = null;
        this.f15609L = false;
        updateItemLocationsInDatabaseBatch();
        if (getItemCount() <= this.mContent.f23341C0) {
            this.mInfo.setOption(4, this.f15628q, false);
        }
    }

    /* JADX INFO: renamed from: G */
    public final boolean beginDrag(View view, boolean z5) {
        try {
            Object tag = view.getTag();
            if (tag instanceof ShortcutInfo) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) tag;
                if (!view.isInTouchMode()) {
                    return false;
                }
                this.f15628q.getWorkspace().y0(view, new Point(), this, z5);
                this.f15606I = shortcutInfo;
                this.f15602E = shortcutInfo.f16791t;
                this.f15607J = view;
                FolderPagedView folderPagedView = this.mContent;
                for (int childCount = folderPagedView.getChildCount() - 1; childCount >= 0; childCount--) {
                    ((CellLayout) folderPagedView.getChildAt(childCount)).removeView(view);
                }
                this.mInfo.remove(this.f15606I);
                this.f15610M = true;
                this.f15613P = false;
                return true;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return true;
    }

    /* JADX INFO: renamed from: H */
    public final void centerAboutIcon() {
        DragLayerLayoutParams dragLayerLayoutParams = (DragLayerLayoutParams) getLayoutParams();
        int desiredWidth = this.mContent.getDesiredWidth() + getPaddingRight() + getPaddingLeft();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.folder_name_margin_bottom) + this.mFolderName.getMeasuredHeight() + this.mContent.getDesiredHeight() + getPaddingBottom() + getPaddingTop();
        Launcher launcher = this.f15628q;
        DragLayer dragLayer = (DragLayer) launcher.findViewById(R.id.drag_layer);
        FolderIcon folderIcon = this.mFolderIcon;
        Rect rect = f23327h0;
        float descendantRectRelativeToSelf = dragLayer.getDescendantRectRelativeToSelf(folderIcon, rect);
        int iWidth = (int) (((rect.width() * descendantRectRelativeToSelf) / 2.0f) + rect.left);
        int i6 = desiredWidth / 2;
        int i7 = iWidth - i6;
        int i8 = dimensionPixelSize / 2;
        int iHeight = ((int) (((rect.height() * descendantRectRelativeToSelf) / 2.0f) + rect.top)) - i8;
        Workspace workspace = launcher.getWorkspace();
        workspace.getClass();
        Objects.toString(rect);
        CellLayout cellLayout = (CellLayout) workspace.getChildAt(workspace.getNextPage());
        if (cellLayout != null) {
            ShortcutAndWidgetContainer shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
            int left = shortcutsAndWidgets.getLeft() + workspace.getPaddingLeft() + workspace.getViewportOffsetX();
            int[] iArr = workspace.m1;
            iArr[0] = left;
            iArr[1] = shortcutsAndWidgets.getTop() + cellLayout.getTop();
            float descendantCoordRelativeToSelf = workspace.f23432V0.getDragLayer().getDescendantCoordRelativeToSelf(workspace, iArr);
            int i9 = iArr[0];
            rect.set(i9, iArr[1], (int) ((shortcutsAndWidgets.getMeasuredWidth() * descendantCoordRelativeToSelf) + i9), (int) ((descendantCoordRelativeToSelf * shortcutsAndWidgets.getMeasuredHeight()) + iArr[1]));
        }
        int folderPaddingStart = getFolderPaddingStart();
        int folderPaddingTop = getFolderPaddingTop();
        float f6 = (i7 - folderPaddingStart) + i6;
        setPivotX(f6);
        float f7 = (iHeight - folderPaddingTop) + i8;
        setPivotY(f7);
        this.mFolderIconPivotX = (int) (((f6 * 1.0f) / desiredWidth) * this.mFolderIcon.getMeasuredWidth());
        this.mFolderIconPivotY = (int) (((f7 * 1.0f) / dimensionPixelSize) * this.mFolderIcon.getMeasuredHeight());
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).width = desiredWidth;
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).height = dimensionPixelSize;
        dragLayerLayoutParams.f16208b = folderPaddingStart;
        dragLayerLayoutParams.f16209c = folderPaddingTop;
    }

    /* JADX INFO: renamed from: I */
    public final void m7694I() {
        if (this.f15628q == null || !this.f15618U) {
            return;
        }
        try {
            this.mContent.getChildCount();
            for (int i6 = 0; i6 < this.mContent.getChildCount(); i6++) {
                ((CellLayout) this.mContent.getChildAt(i6)).getShortcutsAndWidgets().m8037a();
            }
            this.f15618U = false;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: J */
    public final void m7695J(boolean z5) {
        m7694I();
        DragLayer dragLayer = (DragLayer) getParent();
        if (dragLayer != null) {
            dragLayer.removeView(this);
        }
        this.mDragController.f16103l.remove(this);
        clearFocus();
        if (z5) {
            this.mFolderIcon.requestFocus();
        }
        if (this.f15604G) {
            addItemLocationsInDatabase();
            this.f15604G = false;
        }
        if (getItemCount() <= 1) {
            boolean z6 = this.f15610M;
            if (!z6 && !this.f15612O) {
                m7704T();
            } else if (z6) {
                this.f15611N = true;
            }
        }
        this.f15612O = false;
        this.f15606I = null;
        this.f15607J = null;
        this.f15609L = false;
        this.f15608K = false;
        this.f15603F = 0;
    }

    /* JADX INFO: renamed from: K */
    public final void completeDragExit() {
        if (this.mInfo.f15523B) {
            this.f15628q.closeFolder();
            this.f15604G = true;
        } else {
            if (this.f15603F == 1) {
                this.f15604G = true;
                return;
            }
            addItemLocationsInDatabase();
            this.f15606I = null;
            this.f15607J = null;
            this.f15609L = false;
            this.f15608K = false;
        }
    }

    /* JADX INFO: renamed from: L */
    public final void dismissEditingName() {
        this.f15627p.hideSoftInputFromWindow(getWindowToken(), 0);
        doneEditingFolderName();
    }

    /* JADX INFO: renamed from: M */
    public final void doneEditingFolderName() {
        this.mFolderName.setHint(sHintText);
        String string = this.mFolderName.getText().toString();
        FolderInfo folderInfo = this.mInfo;
        folderInfo.title = string;
        int i6 = 0;
        while (true) {
            ArrayList arrayList = folderInfo.f15524C;
            if (i6 >= arrayList.size()) {
                LauncherModel.updateItemInDatabase(this.f15628q, this.mInfo);
                m7705U(String.format(getContext().getString(R.string.folder_renamed), string));
                this.mFolderName.clearFocus();
                Selection.setSelection(this.mFolderName.getText(), 0, 0);
                this.f15616S = false;
                return;
            }
            ((FolderListener) arrayList.get(i6)).mo7659h(string);
            i6++;
        }
    }

    /* JADX INFO: renamed from: N */
    public final int getTargetRank(DragObject dragObject, float[] fArr) {
        float[] visualCenter = dragObject.getVisualCenter(fArr);
        FolderPagedView folderPagedView = this.mContent;
        int paddingLeft = ((int) visualCenter[0]) - getPaddingLeft();
        int paddingTop = ((int) visualCenter[1]) - getPaddingTop();
        int nextPage = folderPagedView.getNextPage();
        CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(nextPage);
        int[] iArr = FolderPagedView.sTempPosArray;
        cellLayout.findNearestArea(paddingLeft, paddingTop, 1, 1, 1, 1, false, iArr, null);
        if (folderPagedView.f23345G0.getLayoutDirection() == 1) {
            iArr[0] = (cellLayout.getCountX() - iArr[0]) - 1;
        }
        return Math.min(folderPagedView.mAllocatedContentSize - 1, (iArr[1] * folderPagedView.f23343E0) + (nextPage * folderPagedView.f23341C0) + iArr[0]);
    }

    /* JADX INFO: renamed from: O */
    public final View m7700O(ShortcutInfo shortcutInfo) {
        FolderPagedView folderPagedView = this.mContent;
        for (int i6 = 0; i6 < folderPagedView.getChildCount(); i6++) {
            CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(i6);
            for (int i7 = 0; i7 < cellLayout.getCountY(); i7++) {
                for (int i8 = 0; i8 < cellLayout.getCountX(); i8++) {
                    View childAt = cellLayout.mShortcutsAndWidgets.getChildAt(i8, i7);
                    if (childAt != null) {
                        if (((ItemInfo) childAt.getTag()) == shortcutInfo) {
                            return childAt;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: P */
    public final void onDragOver(DragObject dragObject) {
        if (this.f15624m.f16207n) {
            return;
        }
        float[] fArr = new float[2];
        int targetRank = getTargetRank(dragObject, fArr);
        this.f15600C = targetRank;
        if (targetRank != this.f15601D) {
            Alarm alarm = this.f15621j;
            alarm.cancelAlarm();
            alarm.f16206m = this.f23336f0;
            alarm.setAlarm(250L);
            this.f15601D = this.f15600C;
            RunnableC0674C runnableC0674C = dragObject.f16529m;
            if (runnableC0674C != null) {
                runnableC0674C.m1502a(getContext().getString(R.string.move_to_position, String.valueOf(this.f15600C + 1)));
            }
        }
        float f6 = fArr[0];
        int nextPage = this.mContent.getNextPage();
        float cellWidth = this.mContent.getCurrentCellLayout().getCellWidth() * 0.45f;
        boolean z5 = f6 < cellWidth;
        boolean z6 = f6 > ((float) getWidth()) - cellWidth;
        if (nextPage > 0 && (!this.mContent.f23349w0 ? !z5 : !z6)) {
            showScrollHint(0, dragObject);
            return;
        }
        if (nextPage < this.mContent.getPageCount() - 1 && (!this.mContent.f23349w0 ? !z6 : !z5)) {
            showScrollHint(1, dragObject);
            return;
        }
        this.f15623l.cancelAlarm();
        if (this.f23333c0 != -1) {
            FolderPagedView folderPagedView = this.mContent;
            if (folderPagedView.getScrollX() != folderPagedView.getScrollForPage(folderPagedView.getNextPage())) {
                folderPagedView.l0(folderPagedView.getNextPage());
            }
            this.f23333c0 = -1;
        }
    }

    /* JADX INFO: renamed from: Q */
    public final void m7702Q() {
        try {
            this.f15628q.isShaking();
            this.mContent.getChildCount();
            this.f15618U = true;
            for (int i6 = 0; i6 < this.mContent.getChildCount(); i6++) {
                ((CellLayout) this.mContent.getChildAt(i6)).getShortcutsAndWidgets().m8047k();
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: S */
    public final void addItemLocationsInDatabase() {
        ArrayList<View> itemsInReadingOrder = getItemsInReadingOrder();
        this.mContent.w0(Math.max(-1, itemsInReadingOrder.size()), itemsInReadingOrder, true);
        this.f15605H = true;
    }

    /* JADX INFO: renamed from: T */
    public final void m7704T() {
        FolderReplaceWithItemRunnable folderReplaceWithItemRunnable = new FolderReplaceWithItemRunnable(this, 0);
        View lastItem = this.mContent.getLastItem();
        if (lastItem != null) {
            FolderIcon folderIcon = this.mFolderIcon;
            folderIcon.getClass();
            Objects.toString(lastItem);
            Objects.toString(folderReplaceWithItemRunnable);
            Drawable drawableM7717i = FolderIcon.m7717i((BubbleTextView) lastItem);
            drawableM7717i.getIntrinsicWidth();
            folderIcon.m7719c(lastItem.getMeasuredWidth());
            folderIcon.m7718b(drawableM7717i, 200, true, folderReplaceWithItemRunnable);
        } else {
            folderReplaceWithItemRunnable.run();
        }
        this.f15617T = true;
    }

    /* JADX INFO: renamed from: U */
    public final void m7705U(String str) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(32);
            onInitializeAccessibilityEvent(accessibilityEventObtain);
            accessibilityEventObtain.getText().add(str);
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
        }
    }

    /* JADX INFO: renamed from: V */
    public final void showScrollHint(int i6, DragObject dragObject) {
        if (this.f23333c0 != i6) {
            FolderPagedView folderPagedView = this.mContent;
            folderPagedView.getClass();
            int scrollForPage = (folderPagedView.getScrollForPage(folderPagedView.getNextPage()) + ((int) (((i6 == 0) ^ folderPagedView.f23349w0 ? -0.07f : 0.07f) * folderPagedView.getWidth()))) - folderPagedView.getScrollX();
            if (scrollForPage != 0) {
                folderPagedView.f16087w.f15547p = new DecelerateInterpolator();
                folderPagedView.f16087w.startScroll(folderPagedView.getScrollX(), scrollForPage, 500);
                folderPagedView.invalidate();
            }
            this.f23333c0 = i6;
        }
        Alarm alarm = this.f15623l;
        if (alarm.f16207n && this.f23334d0 == i6) {
            return;
        }
        this.f23334d0 = i6;
        alarm.cancelAlarm();
        alarm.f16206m = new FolderScrollAlarmListener(this, dragObject, 1);
        alarm.setAlarm(500L);
        this.f15621j.cancelAlarm();
        this.f15600C = this.f15602E;
    }

    /* JADX INFO: renamed from: W */
    public final void updateItemLocationsInDatabaseBatch() {
        ArrayList<View> itemsInReadingOrder = getItemsInReadingOrder();
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < itemsInReadingOrder.size(); i6++) {
            ItemInfo itemInfo = (ItemInfo) itemsInReadingOrder.get(i6).getTag();
            itemInfo.f16791t = i6;
            arrayList.add(itemInfo);
        }
        long j6 = this.mInfo.id;
        HandlerThread handlerThread = LauncherModel.sWorkerThread;
        Launcher launcher = this.f15628q;
        Objects.toString(launcher);
        Objects.toString(arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            ItemInfo itemInfo2 = (ItemInfo) arrayList.get(i7);
            itemInfo2.container = j6;
            itemInfo2.screenId = 0;
            ContentValues contentValues = new ContentValues();
            contentValues.put("container", Long.valueOf(itemInfo2.container));
            contentValues.put("cellX", Integer.valueOf(itemInfo2.cellX));
            contentValues.put("cellY", Integer.valueOf(itemInfo2.cellY));
            contentValues.put("rank", Integer.valueOf(itemInfo2.f16791t));
            contentValues.put("screen", Long.valueOf(itemInfo2.screenId));
            arrayList2.add(contentValues);
        }
        Objects.toString(launcher);
        Objects.toString(arrayList2);
        Objects.toString(arrayList);
        LauncherModel.m7567y(new RunnableC0031a(arrayList, arrayList2, new Throwable().getStackTrace(), launcher.getContentResolver(), 14));
    }

    /* JADX INFO: renamed from: X */
    public final void updateTextViewFocus() {
        View firstItem = this.mContent.getFirstItem();
        View lastItem = this.mContent.getLastItem();
        if (firstItem == null || lastItem == null) {
            return;
        }
        this.mFolderName.setNextFocusDownId(lastItem.getId());
        this.mFolderName.setNextFocusRightId(lastItem.getId());
        this.mFolderName.setNextFocusLeftId(lastItem.getId());
        this.mFolderName.setNextFocusUpId(lastItem.getId());
        this.mFolderName.setNextFocusForwardId(firstItem.getId());
        setNextFocusDownId(firstItem.getId());
        setNextFocusRightId(firstItem.getId());
        setNextFocusLeftId(firstItem.getId());
        setNextFocusUpId(firstItem.getId());
        setOnKeyListener(new FolderEditTextKeyListener(this, lastItem));
    }

    @Override // com.luutinhit.launcher6.UninstallSource
    /* JADX INFO: renamed from: a */
    public final void mo7709a() {
        this.f15620W = true;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: b */
    public final void mo7607b(DragObject dragObject) {
        this.f15601D = -1;
        this.f15622k.cancelAlarm();
        this.f23332b0 = (dragObject.f16522f.getDragRegionWidth() / 2) - dragObject.f16519c;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: e */
    public final boolean mo7608e() {
        return true;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: g */
    public final void mo7609g(Rect rect) {
        getHitRect(rect);
        int i6 = rect.left;
        int i7 = this.f23332b0;
        rect.left = i6 - i7;
        rect.right += i7;
    }

    public ViewGroup getContent() {
        return this.mContent;
    }

    public View getEditTextRegion() {
        return this.mFolderName;
    }

    public FolderInfo getInfo() {
        return this.mInfo;
    }

    @Override // com.luutinhit.launcher6.DragSource
    public float getIntrinsicIconScaleFactor() {
        return 1.0f;
    }

    public int getItemCount() {
        return this.mContent.getItemCount();
    }

    public ArrayList<View> getItemsInReadingOrder() {
        boolean z5 = this.f15605H;
        ArrayList<View> arrayList = this.f15625n;
        if (z5) {
            arrayList.clear();
            FolderPagedView folderPagedView = this.mContent;
            for (int i6 = 0; i6 < folderPagedView.getChildCount(); i6++) {
                CellLayout cellLayout = (CellLayout) folderPagedView.getChildAt(i6);
                for (int i7 = 0; i7 < cellLayout.getCountY(); i7++) {
                    for (int i8 = 0; i8 < cellLayout.getCountX(); i8++) {
                        View childAt = cellLayout.mShortcutsAndWidgets.getChildAt(i8, i7);
                        if (childAt != null) {
                            arrayList.add(childAt);
                        }
                    }
                }
            }
            this.f15605H = false;
        }
        return arrayList;
    }

    public float getPivotXForIconAnimation() {
        return this.mFolderIconPivotX;
    }

    public float getPivotYForIconAnimation() {
        return this.mFolderIconPivotY;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: j */
    public final void mo7610j() {
        Alarm alarm = this.f15621j;
        if (alarm.f16207n) {
            alarm.cancelAlarm();
            this.f23336f0.mo7775h(alarm);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15628q.isUseLiquidGlass) {
            this.mContent.getDesiredWidth();
            this.mContent.getDesiredHeight();
            Launcher launcher = this.f15628q;
            if (launcher.isUseLiquidGlass) {
                if (launcher.isRuntimeRenderSupport) {
                    RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher, true);
                    this.f15635x = runtimeShaderGlassView;
                    runtimeShaderGlassView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                    this.f15635x.setFullBitmap(this.f15628q.getBlurWallpaperProvider().f20555e);
                    this.f15635x.setSdfTexture(R.drawable.scale);
                    this.mContentWrapper.addView(this.f15635x, 0);
                    return;
                }
                LiquidGlassEglTextureView liquidGlassEglTextureView = new LiquidGlassEglTextureView(this.f15628q);
                this.f15634w = liquidGlassEglTextureView;
                liquidGlassEglTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
                LiquidGlassEglTextureView liquidGlassEglTextureView2 = this.f15634w;
                Launcher launcher2 = this.f15628q;
                int i6 = launcher2.screenWidth;
                liquidGlassEglTextureView2.f16148A = launcher2.screenHeight;
                this.f15634w.setBackgroundBitmap(this.mFolderIcon.getBlurGlassWallpaper());
                this.f15634w.setSdfTexture(R.drawable.scale);
                this.mContentWrapper.addView(this.f15634w, 0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof ShortcutInfo) {
            this.f15628q.onClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RuntimeShaderGlassView runtimeShaderGlassView = this.f15635x;
        if (runtimeShaderGlassView != null) {
            runtimeShaderGlassView.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
            this.mContentWrapper.removeView(this.f15634w);
            this.f15634w = null;
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
        if (i6 != 6) {
            return false;
        }
        dismissEditingName();
        return true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.mContentWrapper = (FrameLayout) findViewById(R.id.folder_content_wrapper);
        FolderPagedView folderPagedView = (FolderPagedView) findViewById(R.id.folder_content);
        this.mContent = folderPagedView;
        folderPagedView.setFolder(this);
        DeviceProfile deviceProfile = this.f15628q.getDeviceProfile();
        FolderPagedView folderPagedView2 = this.mContent;
        int i6 = deviceProfile.f15977C;
        folderPagedView2.setPadding(i6, deviceProfile.f15987M, i6, i6 * 2);
        ExtendedEditText extendedEditText = (ExtendedEditText) findViewById(R.id.folder_name);
        this.mFolderName = extendedEditText;
        extendedEditText.setOnBackKeyListener(new FolderReorderAlarmListener(this, 2));
        this.mFolderName.setOnFocusChangeListener(this);
        if (!Utilities.f16748i) {
            this.mFolderName.setCustomSelectionActionModeCallback(new FolderActionModeCallback());
        }
        this.mFolderName.setOnEditorActionListener(this);
        this.mFolderName.setSelectAllOnFocus(true);
        ExtendedEditText extendedEditText2 = this.mFolderName;
        extendedEditText2.setInputType(extendedEditText2.getInputType() | 532480);
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z5) {
        ExtendedEditText extendedEditText = this.mFolderName;
        if (view == extendedEditText) {
            if (!z5) {
                dismissEditingName();
            } else {
                extendedEditText.setHint("");
                this.f15616S = true;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Launcher launcher = this.f15628q;
        if (!launcher.isShaking() && !launcher.showingFloatingMenu && (view instanceof BubbleTextView)) {
            launcher.vibrate();
            launcher.openFloatingMenu(view);
            return true;
        }
        launcher.closeFloatingMenu();
        if (launcher.isShaking()) {
            view.clearAnimation();
            return !launcher.isDraggingEnabled() || beginDrag(view, false);
        }
        launcher.onShakingAllApps();
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        return true;
    }

    @Override // p101l3.InterfaceC2338c
    /* JADX INFO: renamed from: q */
    public final void mo7710q(boolean z5) {
        for (int i6 = 0; i6 < this.mContent.getChildCount(); i6++) {
            ((CellLayout) this.mContent.getChildAt(i6)).enableAccessibleDrag(1, z5);
        }
        this.f15628q.getWorkspace().setAddNewPageOnDrag(!z5);
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: r */
    public final boolean mo7711r() {
        return false;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: s */
    public final void mo7611s(DragObject dragObject) {
        View viewY0;
        DragSource dragSource = dragObject.f16524h;
        Launcher launcher = this.f15628q;
        FolderReplaceWithItemRunnable folderReplaceWithItemRunnable = (dragSource == launcher.getWorkspace() || (dragObject.f16524h instanceof Folder)) ? null : new FolderReplaceWithItemRunnable(this, 1);
        FolderPagedView folderPagedView = this.mContent;
        if (this.f15602E / folderPagedView.f23341C0 != folderPagedView.getNextPage()) {
            this.f15600C = getTargetRank(dragObject, null);
            this.f23336f0.mo7775h(this.f15621j);
            this.f15623l.cancelAlarm();
            this.f15624m.cancelAlarm();
        }
        this.mContent.x0();
        ShortcutInfo shortcutInfo = this.f15606I;
        if (this.f15608K) {
            FolderPagedView folderPagedView2 = this.mContent;
            int i6 = this.f15602E;
            viewY0 = folderPagedView2.y0(shortcutInfo);
            folderPagedView2.u0(viewY0, shortcutInfo, i6);
            LauncherModel.addOrMoveItemInDatabase(this.f15628q, shortcutInfo, this.mInfo.id, 0L, shortcutInfo.cellX, shortcutInfo.cellY);
            if (dragObject.f16524h != this) {
                updateItemLocationsInDatabaseBatch();
            }
            this.f15608K = false;
        } else {
            viewY0 = this.f15607J;
            this.mContent.u0(viewY0, shortcutInfo, this.f15602E);
        }
        if (dragObject.f16522f.f16483q) {
            float scaleX = getScaleX();
            float scaleY = getScaleY();
            setScaleX(1.0f);
            setScaleY(1.0f);
            launcher.getDragLayer().animateViewIntoPosition(dragObject.f16522f, viewY0, folderReplaceWithItemRunnable, null);
            setScaleX(scaleX);
            setScaleY(scaleY);
        } else {
            dragObject.f16528l = false;
            viewY0.setVisibility(0);
        }
        this.f15605H = true;
        addItemLocationsInDatabase();
        this.f15609L = true;
        this.mInfo.add(shortcutInfo);
        this.f15609L = false;
        this.f15606I = null;
        this.f15610M = false;
        if (this.mContent.getPageCount() > 1) {
            this.mInfo.setOption(4, launcher, true);
        }
    }

    public void setDragController(DragController dragController) {
        this.mDragController = dragController;
    }

    public void setFolderBackgroundBitmap(Bitmap bitmap) {
    }

    public void setFolderBackgroundResource(int i6) {
        this.mContentWrapper.setBackgroundResource(i6);
    }

    public void setFolderIcon(FolderIcon folderIcon) {
        this.mFolderIcon = folderIcon;
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: t */
    public final boolean mo7712t() {
        return true;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: u */
    public final boolean mo7612u(DragObject dragObject) {
        int i6 = ((ItemInfo) dragObject.f16523g).itemType;
        if (i6 != 0 && i6 != 1) {
            return false;
        }
        this.mContent.getClass();
        return true;
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: v */
    public final void mo7660v() {
        updateTextViewFocus();
    }

    @Override // com.luutinhit.launcher6.UninstallSource
    /* JADX INFO: renamed from: w */
    public final void mo7713w(boolean z5) {
        this.f15620W = false;
        this.f23331a0 = z5;
        DropCompleteRunnable dropCompleteRunnable = this.f15619V;
        if (dropCompleteRunnable != null) {
            dropCompleteRunnable.run();
        }
    }

    @Override // p101l3.InterfaceC2338c
    /* JADX INFO: renamed from: x */
    public final void mo7714x(CellInfo cellInfo, boolean z5) {
        beginDrag(cellInfo.f15556a, true);
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: y */
    public final void mo7661y(ShortcutInfo shortcutInfo) {
        if (this.f15609L) {
            return;
        }
        FolderPagedView folderPagedView = this.mContent;
        folderPagedView.u0(folderPagedView.y0(shortcutInfo), shortcutInfo, folderPagedView.v0());
        this.f15605H = true;
        LauncherModel.addOrMoveItemInDatabase(this.f15628q, shortcutInfo, this.mInfo.id, 0L, shortcutInfo.cellX, shortcutInfo.cellY);
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: z */
    public final void mo7614z(DragObject dragObject) {
        onDragOver(dragObject);
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: h */
    public final void mo7659h(String str) {
    }

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: E */
    public final void mo906E(DragSource dragSource, Object obj) {
    }
}
