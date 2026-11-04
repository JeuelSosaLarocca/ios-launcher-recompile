package com.luutinhit.launcher6.appslibrary;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.h */
/* JADX INFO: loaded from: classes.dex */
public final class DragLayoutGestureListener extends GestureDetector.SimpleOnGestureListener {
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        return Math.abs(f7) <= Math.abs(f6);
    }
}
