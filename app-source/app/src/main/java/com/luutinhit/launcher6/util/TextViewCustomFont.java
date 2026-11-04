package com.luutinhit.launcher6.util;

import B3.RunnableC0054W;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class TextViewCustomFont extends AppCompatTextView {

    /** Pass-through constructor R8 removed (subclasses called the grandparent directly). */
    public TextViewCustomFont(android.content.Context p0, android.util.AttributeSet p1, int p2) {
        super(p0, p1, p2);
    }

    /* JADX INFO: renamed from: p */
    public static final /* synthetic */ int f17006p = 0;

    public TextViewCustomFont(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        post(new RunnableC0054W(0, this, attributeSet));
    }

    public TextViewCustomFont(Context context) {
        super(context, null);
        post(new RunnableC0054W(0, this, null));
    }
}
