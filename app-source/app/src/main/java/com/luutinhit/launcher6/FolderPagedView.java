package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FolderPagedView extends PagedView {

    /* JADX INFO: renamed from: K0 */
    public static final int[] sTempPosArray = new int[2];

    /* JADX INFO: renamed from: A0 */
    public int f23339A0;

    /* JADX INFO: renamed from: B0 */
    public int f23340B0;

    /* JADX INFO: renamed from: C0 */
    public int f23341C0;

    /* JADX INFO: renamed from: D0 */
    public int mAllocatedContentSize;

    /* JADX INFO: renamed from: E0 */
    public int f23343E0;

    /* JADX INFO: renamed from: F0 */
    public int f23344F0;

    /* JADX INFO: renamed from: G0 */
    public Folder f23345G0;

    /* JADX INFO: renamed from: H0 */
    public FocusIndicatorView mFocusIndicatorView;

    /* JADX INFO: renamed from: I0 */
    public FolderKeyEventListener f23347I0;

    /* JADX INFO: renamed from: J0 */
    public PageIndicator mPageIndicator;

    /* JADX INFO: renamed from: w0 */
    public boolean f23349w0;

    /* JADX INFO: renamed from: x0 */
    public LayoutInflater f23350x0;

    /* JADX INFO: renamed from: y0 */
    public IconCache f23351y0;

    /* JADX INFO: renamed from: z0 */
    public HashMap f23352z0;

    public FolderPagedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23352z0 = new HashMap();
        LauncherAppState launcherAppState = LauncherAppState.getInstance();
        InvariantDeviceProfile invariantDeviceProfile = launcherAppState.f16222e;
        int i6 = invariantDeviceProfile.f16714f;
        this.f23339A0 = i6;
        int i7 = invariantDeviceProfile.f16713e;
        this.f23340B0 = i7;
        this.f23341C0 = i6 * i7;
        this.f23350x0 = LayoutInflater.from(context);
        this.f23351y0 = launcherAppState.f16219b;
        this.f23349w0 = Utilities.isRtl(getResources());
        setImportantForAccessibility(1);
    }

    public void setupContentDimensions(int i6) {
        this.mAllocatedContentSize = i6;
        this.f23343E0 = this.f23339A0;
        this.f23344F0 = this.f23340B0;
        for (int pageCount = getPageCount() - 1; pageCount >= 0; pageCount--) {
            ((CellLayout) getChildAt(pageCount)).setGridSize(this.f23343E0, this.f23344F0);
        }
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: M */
    public final View mo7726M(int i6) {
        return (CellLayout) getChildAt(i6);
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: N */
    public final PageIndicatorState mo7727N(int i6) {
        return new PageIndicatorState(R.drawable.ic_indicator_current);
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
        Folder folder = this.f23345G0;
        if (folder != null) {
            folder.updateTextViewFocus();
        }
    }

    @Override // com.luutinhit.launcher6.PagedView
    /* JADX INFO: renamed from: X */
    public final void mo7729X() {
        int[] iArr = sTempPosArray;
        getVisiblePages(iArr);
        for (int i6 = iArr[0]; i6 <= iArr[1]; i6++) {
            z0(i6);
        }
    }

    public String getAccessibilityDescription() {
        return String.format(getContext().getString(R.string.folder_opened), Integer.valueOf(this.f23343E0), Integer.valueOf(this.f23344F0));
    }

    public int getAllocatedContentSize() {
        return this.mAllocatedContentSize;
    }

    @Override // com.luutinhit.launcher6.PagedView
    public int getChildGap() {
        return getPaddingRight() + getPaddingLeft();
    }

    public CellLayout getCurrentCellLayout() {
        return (CellLayout) getChildAt(getNextPage());
    }

    public int getDesiredHeight() {
        if (getPageCount() <= 0) {
            return 0;
        }
        return getPaddingBottom() + getPaddingTop() + ((CellLayout) getChildAt(0)).getDesiredHeight();
    }

    public int getDesiredWidth() {
        if (getPageCount() <= 0) {
            return 0;
        }
        return getPaddingRight() + getPaddingLeft() + ((CellLayout) getChildAt(0)).getDesiredWidth();
    }

    public View getFirstItem() {
        if (getChildCount() < 1) {
            return null;
        }
        ShortcutAndWidgetContainer shortcutsAndWidgets = getCurrentCellLayout().getShortcutsAndWidgets();
        return this.f23343E0 > 0 ? shortcutsAndWidgets.getChildAt(0, 0) : shortcutsAndWidgets.getChildAt(0);
    }

    public int getItemCount() {
        int childCount = getChildCount() - 1;
        if (childCount < 0) {
            return 0;
        }
        return (childCount * this.f23341C0) + ((CellLayout) getChildAt(childCount)).getShortcutsAndWidgets().getChildCount();
    }

    public View getLastItem() {
        if (getChildCount() < 1) {
            return null;
        }
        ShortcutAndWidgetContainer shortcutsAndWidgets = getCurrentCellLayout().getShortcutsAndWidgets();
        int childCount = shortcutsAndWidgets.getChildCount() - 1;
        int i6 = this.f23343E0;
        return i6 > 0 ? shortcutsAndWidgets.getChildAt(childCount % i6, childCount / i6) : shortcutsAndWidgets.getChildAt(childCount);
    }

    public void setFolder(Folder folder) {
        this.f23345G0 = folder;
        this.mFocusIndicatorView = (FocusIndicatorView) folder.findViewById(R.id.focus_indicator);
        this.f23347I0 = new FolderKeyEventListener(folder);
        this.mPageIndicator = (PageIndicator) folder.findViewById(R.id.folder_page_indicator);
        DeviceProfile deviceProfile = LauncherAppState.getInstance().f16224g.getDeviceProfile();
        this.mPageIndicator.getLayoutParams().height = (int) (((double) deviceProfile.f15977C) * 1.6d);
    }

    public void setMarkerScale(float f6) {
        int childCount = this.mPageIndicator.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = this.mPageIndicator.getChildAt(i6);
            childAt.animate().cancel();
            childAt.setScaleX(f6);
            childAt.setScaleY(f6);
        }
    }

    public final void u0(View view, ShortcutInfo shortcutInfo, int i6) {
        int i7 = this.f23341C0;
        int i8 = i6 % i7;
        int i9 = i6 / i7;
        shortcutInfo.f16791t = i6;
        int i10 = this.f23343E0;
        shortcutInfo.cellX = i8 % i10;
        shortcutInfo.cellY = i8 / i10;
        CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
        cellLayoutLayoutParams.f15685a = shortcutInfo.cellX;
        cellLayoutLayoutParams.f15686b = shortcutInfo.cellY;
        ((CellLayout) getChildAt(i9)).addViewToCellLayout(view, -1, this.f23345G0.f15628q.getViewIdForItem(shortcutInfo), cellLayoutLayoutParams, true);
    }

    public final int v0() {
        int itemCount = getItemCount();
        ArrayList arrayList = new ArrayList(this.f23345G0.getItemsInReadingOrder());
        arrayList.add(itemCount, null);
        w0(arrayList.size(), arrayList, false);
        setCurrentPage(itemCount / this.f23341C0);
        return itemCount;
    }
    /** arrangeChildren(list, itemCount, saveChanges) in AOSP; rewritten because jadx type inference failed. */
    public final void w0(int i6, ArrayList arrayList, boolean z5) {
        ArrayList<CellLayout> pages = new ArrayList<>();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            CellLayout page = (CellLayout) getChildAt(i7);
            page.removeAllViews();
            pages.add(page);
        }
        setupContentDimensions(i6);
        Iterator<CellLayout> it = pages.iterator();
        CellLayout currentPage = null;
        int position = 0;
        int rank = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            View view = arrayList.size() > i8 ? (View) arrayList.get(i8) : null;
            if (currentPage == null || position >= this.f23341C0) {
                if (it.hasNext()) {
                    currentPage = it.next();
                } else {
                    DeviceProfile deviceProfile = ((Launcher) getContext()).getDeviceProfile();
                    CellLayout cellLayout3 = new CellLayout(getContext(), null);
                    int i11 = deviceProfile.f15985K;
                    int i12 = deviceProfile.f15986L;
                    cellLayout3.mCellWidth = i11;
                    cellLayout3.f15472m = i11;
                    cellLayout3.mCellHeight = i12;
                    cellLayout3.f15473n = i12;
                    cellLayout3.mShortcutsAndWidgets.m8046j(i11, i12, cellLayout3.mCountX, cellLayout3.mCountY);
                    cellLayout3.getShortcutsAndWidgets().setMotionEventSplittingEnabled(false);
                    cellLayout3.setImportantForAccessibility(2);
                    cellLayout3.setInvertIfRtl(true);
                    cellLayout3.setGridSize(this.f23343E0, this.f23344F0);
                    PagedViewLayoutParams pagedViewLayoutParams = new PagedViewLayoutParams(-2, -2);
                    pagedViewLayoutParams.f15973a = false;
                    addView(cellLayout3, -1, pagedViewLayoutParams);
                    currentPage = cellLayout3;
                }
                position = 0;
            }
            if (view != null) {
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
                int i13 = this.f23343E0;
                int newX = position % i13;
                int newY = position / i13;
                ItemInfo itemInfo = (ItemInfo) view.getTag();
                if (itemInfo.cellX != newX || itemInfo.cellY != newY || itemInfo.f16791t != rank) {
                    itemInfo.cellX = newX;
                    itemInfo.cellY = newY;
                    itemInfo.f16791t = rank;
                    if (z5) {
                        LauncherModel.addOrMoveItemInDatabase(getContext(), itemInfo, this.f23345G0.mInfo.id, 0L, itemInfo.cellX, itemInfo.cellY);
                    }
                }
                cellLayoutLayoutParams.f15685a = itemInfo.cellX;
                cellLayoutLayoutParams.f15686b = itemInfo.cellY;
                currentPage.addViewToCellLayout(view, -1, this.f23345G0.f15628q.getViewIdForItem(itemInfo), cellLayoutLayoutParams, true);
                if (rank < 9 && (view instanceof BubbleTextView)) {
                    ((BubbleTextView) view).verifyHighRes();
                }
            }
            rank++;
            position++;
        }
        boolean z6 = false;
        while (it.hasNext()) {
            removeView(it.next());
            z6 = true;
        }
        if (z6) {
            setCurrentPage(0);
        }
        setEnableOverscroll(getPageCount() > 1);
        this.mPageIndicator.setVisibility(getPageCount() <= 1 ? 8 : 0);
    }

    public final void x0() {
        HashMap map = this.f23352z0;
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry entry : (Iterable<Map.Entry>) (Iterable) (new HashMap(map).entrySet())) {
            ((View) entry.getKey()).animate().cancel();
            ((Runnable) entry.getValue()).run();
        }
    }

    public final BubbleTextView y0(ShortcutInfo shortcutInfo) {
        BubbleTextView bubbleTextView = (BubbleTextView) this.f23350x0.inflate(R.layout.folder_application, (ViewGroup) null, false);
        Bitmap bitmap = shortcutInfo.f16558F;
        IconCache iconCache = this.f23351y0;
        if (bitmap == null) {
            shortcutInfo.m8056i(iconCache);
        }
        shortcutInfo.f16558F.getWidth();
        bubbleTextView.applyFromShortcutInfo(shortcutInfo, iconCache, false);
        bubbleTextView.setOnClickListener(this.f23345G0);
        bubbleTextView.setOnLongClickListener(this.f23345G0);
        bubbleTextView.setOnFocusChangeListener(this.mFocusIndicatorView);
        bubbleTextView.setLongPressTimeout(1369);
        bubbleTextView.setOnKeyListener(this.f23347I0);
        bubbleTextView.setTextColor(this.f23345G0.f15628q.mIconTextColor);
        bubbleTextView.setLayoutParams(new CellLayoutLayoutParams(shortcutInfo.cellX, shortcutInfo.cellY, shortcutInfo.spanX, shortcutInfo.spanY));
        return bubbleTextView;
    }

    public final void z0(int i6) {
        try {
            CellLayout cellLayout = (CellLayout) getChildAt(i6);
            if (cellLayout != null) {
                ShortcutAndWidgetContainer shortcutsAndWidgets = cellLayout.getShortcutsAndWidgets();
                for (int childCount = shortcutsAndWidgets.getChildCount() - 1; childCount >= 0; childCount--) {
                    ((BubbleTextView) shortcutsAndWidgets.getChildAt(childCount)).verifyHighRes();
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
