package com.luutinhit.launcher6.appslibrary;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.luutinhit.launcher6.Insettable;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InsertAbleDragLayout extends DragLayoutLeftRight implements ViewGroup.OnHierarchyChangeListener, Insettable {
    protected Rect mInsets;

    public InsertAbleDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof DragLayoutLayoutParams;
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
        DragLayoutLayoutParams dragLayoutLayoutParams = (DragLayoutLayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!dragLayoutLayoutParams.f16315a) {
            ((FrameLayout.LayoutParams) dragLayoutLayoutParams).topMargin = (rect.top - rect2.top) + ((FrameLayout.LayoutParams) dragLayoutLayoutParams).topMargin;
            ((FrameLayout.LayoutParams) dragLayoutLayoutParams).leftMargin = (rect.left - rect2.left) + ((FrameLayout.LayoutParams) dragLayoutLayoutParams).leftMargin;
            ((FrameLayout.LayoutParams) dragLayoutLayoutParams).rightMargin = (rect.right - rect2.right) + ((FrameLayout.LayoutParams) dragLayoutLayoutParams).rightMargin;
            ((FrameLayout.LayoutParams) dragLayoutLayoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((FrameLayout.LayoutParams) dragLayoutLayoutParams).bottomMargin;
        }
        view.setLayoutParams(dragLayoutLayoutParams);
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
    public DragLayoutLayoutParams generateDefaultLayoutParams() {
        DragLayoutLayoutParams dragLayoutLayoutParams = new DragLayoutLayoutParams(-2, -2);
        dragLayoutLayoutParams.f16315a = false;
        return dragLayoutLayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public DragLayoutLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        DragLayoutLayoutParams dragLayoutLayoutParams = new DragLayoutLayoutParams(context, attributeSet);
        dragLayoutLayoutParams.f16315a = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2249m);
        dragLayoutLayoutParams.f16315a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return dragLayoutLayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public DragLayoutLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        DragLayoutLayoutParams dragLayoutLayoutParams = new DragLayoutLayoutParams(layoutParams);
        dragLayoutLayoutParams.f16315a = false;
        return dragLayoutLayoutParams;
    }
}
