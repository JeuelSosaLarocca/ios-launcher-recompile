package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InsertAbleMotionLayout extends MotionLayout implements ViewGroup.OnHierarchyChangeListener, Insettable {
    protected Rect mInsets;

    public InsertAbleMotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof InsertAbleMotionLayoutParams;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        setFrameLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFrameLayoutChildInsets(View view, Rect rect, Rect rect2) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        InsertAbleMotionLayoutParams insertAbleMotionLayoutParams = (InsertAbleMotionLayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!insertAbleMotionLayoutParams.f23499q0) {
            ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).topMargin = (rect.top - rect2.top) + ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).topMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).leftMargin = (rect.left - rect2.left) + ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).leftMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).rightMargin = (rect.right - rect2.right) + ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).rightMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((ViewGroup.MarginLayoutParams) insertAbleMotionLayoutParams).bottomMargin;
        }
        view.setLayoutParams(insertAbleMotionLayoutParams);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            setFrameLayoutChildInsets(getChildAt(i6), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public InsertAbleMotionLayoutParams generateDefaultLayoutParams() {
        InsertAbleMotionLayoutParams insertAbleMotionLayoutParams = new InsertAbleMotionLayoutParams(-2, -2);
        insertAbleMotionLayoutParams.f23499q0 = false;
        return insertAbleMotionLayoutParams;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public InsertAbleMotionLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        InsertAbleMotionLayoutParams insertAbleMotionLayoutParams = new InsertAbleMotionLayoutParams(context, attributeSet);
        insertAbleMotionLayoutParams.f23499q0 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2249m);
        insertAbleMotionLayoutParams.f23499q0 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return insertAbleMotionLayoutParams;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public InsertAbleMotionLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InsertAbleMotionLayoutParams insertAbleMotionLayoutParams = new InsertAbleMotionLayoutParams(layoutParams);
        insertAbleMotionLayoutParams.f23499q0 = false;
        return insertAbleMotionLayoutParams;
    }
}
