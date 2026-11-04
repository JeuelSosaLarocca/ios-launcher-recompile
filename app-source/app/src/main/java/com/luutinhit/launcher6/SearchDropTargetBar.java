package com.luutinhit.launcher6;

import C0.C0119k;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class SearchDropTargetBar extends FrameLayout implements DragListener {

    /* JADX INFO: renamed from: s */
    public static final DecelerateInterpolator f15947s = new DecelerateInterpolator(0.6f);

    /* JADX INFO: renamed from: t */
    public static final DecelerateInterpolator f15948t = new DecelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: u */
    public static final AccelerateInterpolator sAccelerateInterpolator = new AccelerateInterpolator();

    /* JADX INFO: renamed from: v */
    public static final int f15950v = 175;

    /* JADX INFO: renamed from: j */
    public AnimatorSet f15951j;

    /* JADX INFO: renamed from: k */
    public int f15952k;

    /* JADX INFO: renamed from: l */
    public View f15953l;

    /* JADX INFO: renamed from: m */
    public View f15954m;

    /* JADX INFO: renamed from: n */
    public boolean f15955n;

    /* JADX INFO: renamed from: o */
    public boolean f15956o;

    /* JADX INFO: renamed from: p */
    public ButtonDropTarget mInfoDropTarget;

    /* JADX INFO: renamed from: q */
    public ButtonDropTarget mDeleteDropTarget;

    /* JADX INFO: renamed from: r */
    public ButtonDropTarget mUninstallDropTarget;

    public SearchDropTargetBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f15952k = 3;
        this.f15955n = false;
        this.f15956o = false;
    }

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: C */
    public final void mo905C() {
        if (this.f15955n) {
            this.f15955n = false;
        } else {
            m7801b(3, f15950v);
        }
    }

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: E */
    public final void mo906E(DragSource dragSource, Object obj) {
        m7801b(4, f15950v);
    }

    /* JADX INFO: renamed from: a */
    public final void m7800a(View view, float f6, TimeInterpolator timeInterpolator) {
        if (Float.compare(view.getAlpha(), f6) != 0) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, f6);
            objectAnimatorOfFloat.setInterpolator(timeInterpolator);
            objectAnimatorOfFloat.addListener(new C0119k(this, view));
            this.f15951j.play(objectAnimatorOfFloat);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m7801b(int i6, int i7) {
        if (this.f15952k != i6) {
            this.f15952k = i6;
            this.f15956o = ((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled();
            AnimatorSet animatorSet = this.f15951j;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f15951j = null;
            }
            this.f15951j = null;
            TimeInterpolator timeInterpolator = sAccelerateInterpolator;
            if (i7 > 0) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f15951j = animatorSet2;
                animatorSet2.setDuration(i7);
                m7800a(this.f15954m, SyntheticHelpers.m7904c(this.f15952k), timeInterpolator);
            } else {
                this.f15954m.setAlpha(SyntheticHelpers.m7904c(this.f15952k));
                FadeVisibilityAnimator.m7972a(this.f15954m, this.f15956o);
            }
            if (this.f15953l != null) {
                ((Launcher) getContext()).getDeviceProfile().getClass();
                int i8 = this.f15952k;
                float f6 = 0.0f;
                if (i8 != 1) {
                    if (i8 == 2) {
                        f6 = -1.0f;
                    } else if (i8 != 3 && i8 != 4) {
                        throw null;
                    }
                }
                float measuredHeight = f6 * getMeasuredHeight();
                if (i7 > 0) {
                    int iCompare = Float.compare(this.f15953l.getTranslationY(), measuredHeight);
                    View view = this.f15953l;
                    float fM7905d = SyntheticHelpers.m7905d(this.f15952k);
                    if (iCompare != 0) {
                        timeInterpolator = iCompare < 0 ? f15947s : f15948t;
                    }
                    m7800a(view, fM7905d, timeInterpolator);
                    if (iCompare != 0) {
                        this.f15951j.play(ObjectAnimator.ofFloat(this.f15953l, (Property<View, Float>) View.TRANSLATION_Y, measuredHeight));
                    }
                } else {
                    this.f15953l.setTranslationY(measuredHeight);
                    this.f15953l.setAlpha(SyntheticHelpers.m7905d(this.f15952k));
                    FadeVisibilityAnimator.m7972a(this.f15953l, this.f15956o);
                }
            }
            if (i7 > 0) {
                this.f15951j.start();
            }
        }
    }

    public Rect getSearchBarBounds() {
        View view = this.f15953l;
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        int i6 = iArr[0];
        rect.left = i6;
        rect.top = iArr[1];
        rect.right = this.f15953l.getWidth() + i6;
        rect.bottom = this.f15953l.getHeight() + iArr[1];
        return rect;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View viewFindViewById = findViewById(R.id.drag_target_bar);
        this.f15954m = viewFindViewById;
        this.mInfoDropTarget = (ButtonDropTarget) viewFindViewById.findViewById(R.id.info_target_text);
        this.mDeleteDropTarget = (ButtonDropTarget) this.f15954m.findViewById(R.id.delete_target_text);
        this.mUninstallDropTarget = (ButtonDropTarget) this.f15954m.findViewById(R.id.uninstall_target_text);
        this.mInfoDropTarget.setSearchDropTargetBar(this);
        this.mDeleteDropTarget.setSearchDropTargetBar(this);
        this.mUninstallDropTarget.setSearchDropTargetBar(this);
        this.f15954m.setAlpha(0.0f);
        FadeVisibilityAnimator.m7972a(this.f15954m, this.f15956o);
    }

    public void setQsbSearchBar(View view) {
        this.f15953l = view;
    }
}
