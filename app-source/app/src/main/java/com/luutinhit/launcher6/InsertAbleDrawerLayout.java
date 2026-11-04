package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InsertAbleDrawerLayout extends DrawerLayout implements ViewGroup.OnHierarchyChangeListener, Insettable {
    protected Rect mInsets;

    public InsertAbleDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof InsertAbleDrawerLayoutParams;
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
        InsertAbleDrawerLayoutParams insertAbleDrawerLayoutParams = (InsertAbleDrawerLayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!insertAbleDrawerLayoutParams.f16491e) {
            ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).topMargin = (rect.top - rect2.top) + ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).topMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).leftMargin = (rect.left - rect2.left) + ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).leftMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).rightMargin = (rect.right - rect2.right) + ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).rightMargin;
            ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((ViewGroup.MarginLayoutParams) insertAbleDrawerLayoutParams).bottomMargin;
        }
        view.setLayoutParams(insertAbleDrawerLayoutParams);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            setFrameLayoutChildInsets(getChildAt(i6), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public InsertAbleDrawerLayoutParams generateDefaultLayoutParams() {
        InsertAbleDrawerLayoutParams insertAbleDrawerLayoutParams = new InsertAbleDrawerLayoutParams(-2, -2);
        insertAbleDrawerLayoutParams.f16491e = false;
        return insertAbleDrawerLayoutParams;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public InsertAbleDrawerLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        InsertAbleDrawerLayoutParams insertAbleDrawerLayoutParams = new InsertAbleDrawerLayoutParams(context, attributeSet);
        insertAbleDrawerLayoutParams.f16491e = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2249m);
        insertAbleDrawerLayoutParams.f16491e = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return insertAbleDrawerLayoutParams;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout, android.view.ViewGroup
    public InsertAbleDrawerLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InsertAbleDrawerLayoutParams insertAbleDrawerLayoutParams = new InsertAbleDrawerLayoutParams(layoutParams);
        insertAbleDrawerLayoutParams.f16491e = false;
        return insertAbleDrawerLayoutParams;
    }
}
