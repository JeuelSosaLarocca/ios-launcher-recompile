package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InsertAbleConstraintLayout extends ConstraintLayout implements ViewGroup.OnHierarchyChangeListener, Insettable {
    protected Rect mInsets;

    public InsertAbleConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof InsertAbleConstraintLayoutParams;
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
        InsertAbleConstraintLayoutParams insertAbleConstraintLayoutParams = (InsertAbleConstraintLayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!insertAbleConstraintLayoutParams.f23476q0) {
            ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).topMargin = (rect.top - rect2.top) + ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).topMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).leftMargin = (rect.left - rect2.left) + ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).leftMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).rightMargin = (rect.right - rect2.right) + ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).rightMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((ViewGroup.MarginLayoutParams) insertAbleConstraintLayoutParams).bottomMargin;
        }
        view.setLayoutParams(insertAbleConstraintLayoutParams);
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
    public InsertAbleConstraintLayoutParams generateDefaultLayoutParams() {
        InsertAbleConstraintLayoutParams insertAbleConstraintLayoutParams = new InsertAbleConstraintLayoutParams(-2, -2);
        insertAbleConstraintLayoutParams.f23476q0 = false;
        return insertAbleConstraintLayoutParams;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public InsertAbleConstraintLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        InsertAbleConstraintLayoutParams insertAbleConstraintLayoutParams = new InsertAbleConstraintLayoutParams(context, attributeSet);
        insertAbleConstraintLayoutParams.f23476q0 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2249m);
        insertAbleConstraintLayoutParams.f23476q0 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return insertAbleConstraintLayoutParams;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public InsertAbleConstraintLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InsertAbleConstraintLayoutParams insertAbleConstraintLayoutParams = new InsertAbleConstraintLayoutParams(layoutParams);
        insertAbleConstraintLayoutParams.f23476q0 = false;
        return insertAbleConstraintLayoutParams;
    }
}
