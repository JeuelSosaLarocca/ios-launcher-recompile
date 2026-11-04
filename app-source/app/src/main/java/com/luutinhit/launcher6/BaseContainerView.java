package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.allapps.AllAppsContainerView;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseContainerView extends FrameLayout implements Insettable {

    /* JADX INFO: renamed from: j */
    public Rect f16641j;

    /* JADX INFO: renamed from: k */
    public Rect f16642k;

    /* JADX INFO: renamed from: l */
    public int mContainerBoundsInset;

    /* JADX INFO: renamed from: m */
    public Drawable f16644m;

    /* JADX INFO: renamed from: n */
    public View f16645n;

    /* JADX INFO: renamed from: o */
    public View f16646o;

    /* JADX INFO: renamed from: p */
    public int f16647p;

    public BaseContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16641j = new Rect();
        this.f16642k = new Rect();
        this.mContainerBoundsInset = getResources().getDimensionPixelSize(R.dimen.container_bounds_inset);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2238b, 0, 0);
        this.f16644m = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.container_max_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.container_min_margin);
        int i6 = ((Launcher) context).getDeviceProfile().f16012l;
        if (dimensionPixelSize > 0) {
            this.f16647p = Math.max(dimensionPixelSize2, (i6 - dimensionPixelSize) / 2);
        } else {
            this.f16647p = Math.max(dimensionPixelSize2, (int) getResources().getFraction(R.fraction.container_margin, i6, 1));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void updateBackgroundAndPaddings() {
        Rect rect = this.f16641j;
        int i6 = rect.top;
        int i7 = this.mContainerBoundsInset;
        int i8 = i6 + i7;
        int i9 = rect.bottom + i7;
        int i10 = this.f16647p;
        new Rect(i10, i8, i10, i9);
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.f16642k;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        InsetDrawable insetDrawable = new InsetDrawable(this.f16644m, rect2.left, 0, rect2.right, 0);
        this.f16645n.setBackground(insetDrawable.getConstantState().newDrawable());
        this.f16646o.setBackground(insetDrawable);
        this.f16646o.setPadding(0, 0, 0, 0);
        Rect rect4 = new Rect();
        insetDrawable.getPadding(rect4);
        AllAppsContainerView allAppsContainerView = (AllAppsContainerView) this;
        allAppsContainerView.f16248w.mBackgroundPadding.set(rect4);
        allAppsContainerView.f16244s.f19640u.set(rect4);
        allAppsContainerView.f16251z.mo9249d(rect4);
        int maxScrollbarWidth = allAppsContainerView.f16248w.getMaxScrollbarWidth();
        int iMax = Math.max(allAppsContainerView.f16236A, maxScrollbarWidth);
        boolean zIsRtl = Utilities.isRtl(allAppsContainerView.getResources());
        int i11 = allAppsContainerView.f16239D;
        if (zIsRtl) {
            allAppsContainerView.f16248w.setPadding(rect2.left + maxScrollbarWidth, i11, rect2.right + iMax, i11);
        } else {
            allAppsContainerView.f16248w.setPadding(rect2.left + iMax, i11, rect2.right + maxScrollbarWidth, i11);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) allAppsContainerView.f16249x.getLayoutParams();
        marginLayoutParams.leftMargin = rect2.left;
        marginLayoutParams.rightMargin = rect2.right;
        allAppsContainerView.f16249x.setLayoutParams(marginLayoutParams);
    }

    public final View getContentView() {
        return this.f16646o;
    }

    public final View getRevealView() {
        return this.f16645n;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f16646o = findViewById(R.id.main_content);
        this.f16645n = findViewById(R.id.reveal_view);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public final void setInsets(Rect rect) {
        this.f16641j.set(rect);
        updateBackgroundAndPaddings();
    }

    public final void setSearchBarBounds(Rect rect) {
        post(new MergedUiRunnable(1, this));
    }
}
