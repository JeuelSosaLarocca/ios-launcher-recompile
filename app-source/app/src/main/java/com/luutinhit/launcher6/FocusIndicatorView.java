package com.luutinhit.launcher6;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class FocusIndicatorView extends View implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: r */
    public static final /* synthetic */ int f15589r = 0;

    /* JADX INFO: renamed from: j */
    public int[] f15590j;

    /* JADX INFO: renamed from: k */
    public int[] f15591k;

    /* JADX INFO: renamed from: l */
    public ObjectAnimator f15592l;

    /* JADX INFO: renamed from: m */
    public ViewAnimState f15593m;

    /* JADX INFO: renamed from: n */
    public View f15594n;

    /* JADX INFO: renamed from: o */
    public boolean f15595o;

    /* JADX INFO: renamed from: p */
    public FocusIndicatorFocusListener f15596p;

    /* JADX INFO: renamed from: q */
    public Pair f15597q;

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15590j = new int[2];
        this.f15591k = new int[2];
        setAlpha(0.0f);
        setBackgroundColor(getResources().getColor(R.color.focused_background));
        this.f15596p = new FocusIndicatorFocusListener(this);
    }

    /* JADX INFO: renamed from: a */
    public static void computeLocationRelativeToParent(View view, View view2, int[] iArr) {
        iArr[1] = 0;
        iArr[0] = 0;
        computeLocationRelativeToParentHelper(view, view2, iArr);
        iArr[0] = (int) ((((1.0f - view.getScaleX()) * view.getWidth()) / 2.0f) + iArr[0]);
        iArr[1] = (int) ((((1.0f - view.getScaleY()) * view.getHeight()) / 2.0f) + iArr[1]);
    }

    /* JADX INFO: renamed from: b */
    public static void computeLocationRelativeToParentHelper(View view, View view2, int[] iArr) {
        View view3 = (View) view.getParent();
        iArr[0] = view.getLeft() + iArr[0];
        iArr[1] = view.getTop() + iArr[1];
        if (view3 instanceof PagedView) {
            PagedView pagedView = (PagedView) view3;
            iArr[0] = iArr[0] - pagedView.getScrollForPage(pagedView.indexOfChild(view));
        }
        if (view3 != view2) {
            computeLocationRelativeToParentHelper(view3, view2, iArr);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void endCurrentAnimation() {
        ObjectAnimator objectAnimator = this.f15592l;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f15592l = null;
        }
        ViewAnimState viewAnimState = this.f15593m;
        if (viewAnimState != null) {
            setTranslationX(viewAnimState.f16809a);
            setTranslationY(viewAnimState.f16810b);
            setScaleX(viewAnimState.f16811c);
            setScaleY(viewAnimState.f16812d);
            this.f15593m = null;
        }
    }

    public View.OnFocusChangeListener getHideIndicatorOnFocusListener() {
        return this.f15596p;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Pair pair = this.f15597q;
        if (pair != null) {
            onFocusChange((View) pair.first, ((Boolean) pair.second).booleanValue());
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z5) {
        this.f15597q = null;
        if (!this.f15595o && getWidth() == 0) {
            this.f15597q = Pair.create(view, Boolean.valueOf(z5));
            invalidate();
            return;
        }
        boolean z6 = this.f15595o;
        int[] iArr = this.f15590j;
        if (!z6) {
            computeLocationRelativeToParent(this, (View) getParent(), iArr);
            this.f15595o = true;
        }
        Property property = View.ALPHA;
        if (z5) {
            int width = getWidth();
            int height = getHeight();
            endCurrentAnimation();
            ViewAnimState viewAnimState = new ViewAnimState();
            float f6 = width;
            viewAnimState.f16811c = (view.getScaleX() * view.getWidth()) / f6;
            float f7 = height;
            viewAnimState.f16812d = (view.getScaleY() * view.getHeight()) / f7;
            View view2 = (View) getParent();
            int[] iArr2 = this.f15591k;
            computeLocationRelativeToParent(view, view2, iArr2);
            viewAnimState.f16809a = (iArr2[0] - iArr[0]) - (((1.0f - viewAnimState.f16811c) * f6) / 2.0f);
            viewAnimState.f16810b = (iArr2[1] - iArr[1]) - (((1.0f - viewAnimState.f16812d) * f7) / 2.0f);
            if (getAlpha() > 0.2f) {
                this.f15593m = viewAnimState;
                this.f15592l = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat((Property<?, Float>) property, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, this.f15593m.f16809a), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, this.f15593m.f16810b), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, this.f15593m.f16811c), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, this.f15593m.f16812d));
            } else {
                setTranslationX(viewAnimState.f16809a);
                setTranslationY(viewAnimState.f16810b);
                setScaleX(viewAnimState.f16811c);
                setScaleY(viewAnimState.f16812d);
                this.f15592l = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat((Property<?, Float>) property, 1.0f));
            }
            this.f15594n = view;
        } else if (this.f15594n == view) {
            this.f15594n = null;
            endCurrentAnimation();
            this.f15592l = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat((Property<?, Float>) property, 0.0f));
        }
        ObjectAnimator objectAnimator = this.f15592l;
        if (objectAnimator != null) {
            objectAnimator.setDuration(150L).start();
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        View view = this.f15594n;
        if (view != null) {
            this.f15597q = Pair.create(view, Boolean.TRUE);
            invalidate();
        }
    }
}
