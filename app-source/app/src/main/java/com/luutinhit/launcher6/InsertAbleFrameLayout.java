package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InsertAbleFrameLayout extends FrameLayout implements ViewGroup.OnHierarchyChangeListener, Insettable {
    protected Rect mInsets;

    public InsertAbleFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof InsertAbleFrameLayoutParams;
    }

    public void onChildViewAdded(View view, View view2) {
        setFrameLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    public void onChildViewRemoved(View view, View view2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFrameLayoutChildInsets(View view, Rect rect, Rect rect2) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        InsertAbleFrameLayoutParams insertAbleFrameLayoutParams = (InsertAbleFrameLayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!insertAbleFrameLayoutParams.f16530a) {
            ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).topMargin = (rect.top - rect2.top) + ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).topMargin;
            ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).leftMargin = (rect.left - rect2.left) + ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).leftMargin;
            ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).rightMargin = (rect.right - rect2.right) + ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).rightMargin;
            ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).bottomMargin;
        }
        view.setLayoutParams(insertAbleFrameLayoutParams);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            setFrameLayoutChildInsets(getChildAt(i6), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public InsertAbleFrameLayoutParams generateDefaultLayoutParams() {
        return new InsertAbleFrameLayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public InsertAbleFrameLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new InsertAbleFrameLayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public InsertAbleFrameLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new InsertAbleFrameLayoutParams(layoutParams);
    }
}
