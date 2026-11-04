package com.luutinhit.launcher6;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class InsertAbleLinearLayout extends OverScrollLayout implements ViewGroup.OnHierarchyChangeListener, Insettable {
    protected Rect mInsets;

    public InsertAbleLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInsets = new Rect();
        setOnHierarchyChangeListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof InsertAbleLinearLayoutParams;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        setLinearLayoutChildInsets(view2, this.mInsets, new Rect());
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            setLinearLayoutChildInsets(getChildAt(i6), rect, this.mInsets);
        }
        this.mInsets.set(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLinearLayoutChildInsets(View view, Rect rect, Rect rect2) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        InsertAbleLinearLayoutParams insertAbleLinearLayoutParams = (InsertAbleLinearLayoutParams) view.getLayoutParams();
        if (view instanceof Insettable) {
            ((Insettable) view).setInsets(rect);
        } else if (!insertAbleLinearLayoutParams.f16567a) {
            ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).topMargin = (rect.top - rect2.top) + ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).topMargin;
            ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).leftMargin = (rect.left - rect2.left) + ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).leftMargin;
            ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).rightMargin = (rect.right - rect2.right) + ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).rightMargin;
            ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).bottomMargin = (rect.bottom - rect2.bottom) + ((LinearLayout.LayoutParams) insertAbleLinearLayoutParams).bottomMargin;
        }
        view.setLayoutParams(insertAbleLinearLayoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public InsertAbleLinearLayoutParams generateDefaultLayoutParams() {
        InsertAbleLinearLayoutParams insertAbleLinearLayoutParams = new InsertAbleLinearLayoutParams(-2, -2);
        insertAbleLinearLayoutParams.f16567a = false;
        return insertAbleLinearLayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public InsertAbleLinearLayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        InsertAbleLinearLayoutParams insertAbleLinearLayoutParams = new InsertAbleLinearLayoutParams(context, attributeSet);
        insertAbleLinearLayoutParams.f16567a = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2249m);
        insertAbleLinearLayoutParams.f16567a = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return insertAbleLinearLayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public InsertAbleLinearLayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InsertAbleLinearLayoutParams insertAbleLinearLayoutParams = new InsertAbleLinearLayoutParams(layoutParams);
        insertAbleLinearLayoutParams.f16567a = false;
        return insertAbleLinearLayoutParams;
    }
}
