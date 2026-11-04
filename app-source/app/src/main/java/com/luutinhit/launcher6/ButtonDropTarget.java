package com.luutinhit.launcher6;

import M2.RunnableC0674C;
import android.animation.AnimatorSet;
import android.animation.FloatArrayEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class ButtonDropTarget extends ConstraintLayout implements DropTarget, DragListener, View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public Launcher mLauncher;

    /* JADX INFO: renamed from: k */
    public int mBottomDragPadding;

    /* JADX INFO: renamed from: l */
    public SearchDropTargetBar mSearchDropTargetBar;

    /* JADX INFO: renamed from: m */
    public ImageView f15416m;

    /* JADX INFO: renamed from: n */
    public TextViewCustomFont f15417n;

    /* JADX INFO: renamed from: o */
    public boolean f15418o;

    /* JADX INFO: renamed from: p */
    public int f15419p;

    /* JADX INFO: renamed from: q */
    public ColorStateList f15420q;

    /* JADX INFO: renamed from: r */
    public Drawable f15421r;

    /* JADX INFO: renamed from: s */
    public AnimatorSet f15422s;

    /* JADX INFO: renamed from: t */
    public ColorMatrix f15423t;

    /* JADX INFO: renamed from: u */
    public ColorMatrix f15424u;

    /* JADX INFO: renamed from: v */
    public ColorMatrix f15425v;

    public ButtonDropTarget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f15419p = 0;
        this.mBottomDragPadding = getResources().getDimensionPixelSize(R.dimen.drop_target_drag_padding);
        LayoutInflater.from(context).inflate(R.layout.icon_view_layout, (ViewGroup) this, true);
        this.f15416m = (ImageView) findViewById(R.id.icon_app);
        this.f15417n = (TextViewCustomFont) findViewById(R.id.icon_name);
    }

    /* JADX INFO: renamed from: A */
    public abstract void mo7604A(DragObject dragObject);

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: B */
    public final void mo7605B(DragObject dragObject) {
        if (dragObject.f16521e) {
            dragObject.f16522f.setColor(this.f15419p);
            return;
        }
        dragObject.f16522f.setColor(0);
        if (Utilities.f16752m) {
            animateTextColor(this.f15420q.getDefaultColor());
        } else {
            this.f15421r.setColorFilter(null);
            setTextColor(this.f15420q);
        }
    }

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: C */
    public final void mo905C() {
        this.f15418o = false;
    }

    /* JADX INFO: renamed from: D */
    public abstract boolean mo7606D(DragSource dragSource, Object obj);

    @Override // com.luutinhit.launcher6.DragListener
    /* JADX INFO: renamed from: E */
    public final void mo906E(DragSource dragSource, Object obj) {
        this.f15418o = mo7606D(dragSource, obj);
        this.f15421r.setColorFilter(null);
        AnimatorSet animatorSet = this.f15422s;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f15422s = null;
        }
        setTextColor(this.f15420q);
        ((ViewGroup) getParent()).setVisibility(this.f15418o ? 0 : 8);
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: b */
    public final void mo7607b(DragObject dragObject) {
        dragObject.f16522f.setColor(this.f15419p);
        if (Utilities.f16752m) {
            animateTextColor(this.f15419p);
        } else {
            if (this.f15425v == null) {
                this.f15425v = new ColorMatrix();
            }
            DragView.setColorScale(this.f15419p, this.f15425v);
            this.f15421r.setColorFilter(new ColorMatrixColorFilter(this.f15425v));
            setTextColor(this.f15419p);
        }
        RunnableC0674C runnableC0674C = dragObject.f16529m;
        if (runnableC0674C != null) {
            runnableC0674C.f2015k.removeCallbacks(runnableC0674C);
        }
        sendAccessibilityEvent(4);
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: e */
    public final boolean mo7608e() {
        return this.f15418o;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: g */
    public final void mo7609g(Rect rect) {
        super.getHitRect(rect);
        rect.bottom += this.mBottomDragPadding;
        int[] iArr = new int[2];
        this.mLauncher.getDragLayer().getDescendantCoordRelativeToSelf(this, iArr);
        rect.offsetTo(iArr[0], iArr[1]);
    }

    public int getTextColor() {
        return getTextColors().getDefaultColor();
    }

    public ColorStateList getTextColors() {
        TextViewCustomFont textViewCustomFont = this.f15417n;
        if (textViewCustomFont != null) {
            return textViewCustomFont.getTextColors();
        }
        return null;
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: j */
    public final void mo7610j() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LauncherAppState.getInstance().f16223f.m9171c(this, null, null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f15420q = getTextColors();
        ((Launcher) getContext()).getDeviceProfile().getClass();
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: s */
    public void mo7611s(DragObject dragObject) {
        int paddingLeft;
        int paddingRight;
        DragLayer dragLayer = this.mLauncher.getDragLayer();
        Rect rect = new Rect();
        dragLayer.getViewRectRelativeToSelf(dragObject.f16522f, rect);
        int intrinsicWidth = this.f15421r.getIntrinsicWidth();
        int intrinsicHeight = this.f15421r.getIntrinsicHeight();
        int measuredWidth = dragObject.f16522f.getMeasuredWidth();
        int measuredHeight = dragObject.f16522f.getMeasuredHeight();
        DragLayer dragLayer2 = this.mLauncher.getDragLayer();
        Rect rect2 = new Rect();
        dragLayer2.getViewRectRelativeToSelf(this, rect2);
        if (Utilities.isRtl(getResources())) {
            paddingRight = rect2.right - getPaddingRight();
            paddingLeft = paddingRight - intrinsicWidth;
        } else {
            paddingLeft = getPaddingLeft() + rect2.left;
            paddingRight = paddingLeft + intrinsicWidth;
        }
        int measuredHeight2 = ((getMeasuredHeight() - intrinsicHeight) / 2) + rect2.top;
        rect2.set(paddingLeft, measuredHeight2, paddingRight, measuredHeight2 + intrinsicHeight);
        rect2.offset((-(measuredWidth - intrinsicWidth)) / 2, (-(measuredHeight - intrinsicHeight)) / 2);
        float fWidth = rect2.width() / rect.width();
        this.mSearchDropTargetBar.f15955n = true;
        dragLayer.animateView(dragObject.f16522f, rect, rect2, fWidth, 1.0f, 1.0f, 0.1f, 0.1f, 285, new DecelerateInterpolator(2.0f), new LinearInterpolator(), new MergedModelRunnable(1, this, dragObject), 0, null);
    }

    @TargetApi(17)
    public void setDrawable(int i6) {
        Drawable drawable = getResources().getDrawable(i6);
        this.f15421r = drawable;
        this.f15416m.setImageDrawable(drawable);
    }

    public void setLauncher(Launcher launcher) {
        this.mLauncher = launcher;
    }

    public void setSearchDropTargetBar(SearchDropTargetBar searchDropTargetBar) {
        this.mSearchDropTargetBar = searchDropTargetBar;
    }

    public void setText(CharSequence charSequence) {
        this.f15417n.setText(charSequence);
    }

    @Keep
    public void setTextColor(int i6) {
        this.f15417n.setTextColor(i6);
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: u */
    public final boolean mo7612u(DragObject dragObject) {
        return mo7606D(dragObject.f16524h, dragObject.f16523g);
    }

    /* JADX INFO: renamed from: y */
    public final void animateTextColor(int i6) {
        AnimatorSet animatorSet = this.f15422s;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f15422s = animatorSet2;
        animatorSet2.setDuration(120);
        if (this.f15423t == null) {
            this.f15423t = new ColorMatrix();
            this.f15424u = new ColorMatrix();
            this.f15425v = new ColorMatrix();
        }
        DragView.setColorScale(getTextColor(), this.f15423t);
        DragView.setColorScale(i6, this.f15424u);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new FloatArrayEvaluator(this.f15425v.getArray()), this.f15423t.getArray(), this.f15424u.getArray());
        valueAnimatorOfObject.addUpdateListener(new SharedAnimatorUpdateListener(2, this));
        this.f15422s.play(valueAnimatorOfObject);
        this.f15422s.play(ObjectAnimator.ofArgb(this, "textColor", i6));
        this.f15422s.start();
    }

    @Override // com.luutinhit.launcher6.DropTarget
    /* JADX INFO: renamed from: z */
    public final void mo7614z(DragObject dragObject) {
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f15417n.setTextColor(colorStateList);
    }
}
