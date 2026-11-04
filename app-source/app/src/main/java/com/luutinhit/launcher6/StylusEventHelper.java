package com.luutinhit.launcher6;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.luutinhit.launcher6.j3 */
/* JADX INFO: loaded from: classes.dex */
public final class StylusEventHelper {

    /* JADX INFO: renamed from: a */
    public boolean f16610a;

    /* JADX INFO: renamed from: b */
    public ViewGroup f16611b;

    public StylusEventHelper(ViewGroup viewGroup) {
        this.f16611b = viewGroup;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r6 != 3) goto L40;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkAndPerformStylusEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup = this.f16611b;
        float scaledTouchSlop = ViewConfiguration.get(viewGroup.getContext()).getScaledTouchSlop();
        if (viewGroup.isLongClickable()) {
            boolean z5 = motionEvent.getToolType(0) == 2 && (motionEvent.getButtonState() & 2) == 2;
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (Utilities.pointInView(viewGroup, motionEvent.getX(), motionEvent.getY(), scaledTouchSlop)) {
                            if (!this.f16610a && z5 && viewGroup.performLongClick()) {
                                this.f16610a = true;
                                return true;
                            }
                            if (this.f16610a && !z5) {
                                this.f16610a = false;
                                return false;
                            }
                        }
                    }
                }
                this.f16610a = false;
                return false;
            }
            this.f16610a = false;
            if (z5 && viewGroup.performLongClick()) {
                this.f16610a = true;
                return true;
            }
        }
        return false;
    }
}
