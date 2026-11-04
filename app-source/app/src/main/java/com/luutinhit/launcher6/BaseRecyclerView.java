package com.luutinhit.launcher6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;
import m3.C2388b;
import m3.RunnableC2387a;
import p124s0.InterfaceC2709X;

/* JADX INFO: renamed from: com.luutinhit.launcher6.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRecyclerView extends RecyclerView implements InterfaceC2709X {

    /** Pass-through constructor R8 removed (subclasses called the grandparent directly). */
    public BaseRecyclerView(android.content.Context p0, android.util.AttributeSet p1, int p2) {
        super(p0, p1, p2);
    }

    /* JADX INFO: renamed from: T0 */
    public int f23507T0;

    /* JADX INFO: renamed from: U0 */
    public float f23508U0;

    /* JADX INFO: renamed from: V0 */
    public BaseRecyclerViewFastScrollBar f23509V0;

    /* JADX INFO: renamed from: W0 */
    public int f23510W0;

    /* JADX INFO: renamed from: X0 */
    public int f23511X0;

    /* JADX INFO: renamed from: Y0 */
    public int f23512Y0;

    /* JADX INFO: renamed from: Z0 */
    public Rect mBackgroundPadding;

    @Override // p124s0.InterfaceC2709X
    /* JADX INFO: renamed from: b */
    public final void mo8143b(MotionEvent motionEvent) {
        x0(motionEvent);
    }

    @Override // p124s0.InterfaceC2709X
    /* JADX INFO: renamed from: d */
    public final boolean mo8144d(MotionEvent motionEvent) {
        return x0(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2;
        super.dispatchDraw(canvas);
        y0(0);
        BaseRecyclerViewFastScrollBar baseRecyclerViewFastScrollBar = this.f23509V0;
        Point point = baseRecyclerViewFastScrollBar.f16762f;
        if (point.x < 0 || point.y < 0) {
            return;
        }
        Paint paint = baseRecyclerViewFastScrollBar.f16770n;
        if (paint.getAlpha() > 0) {
            int i6 = point.x;
            canvas2 = canvas;
            canvas2.drawRect(i6, 0.0f, i6 + baseRecyclerViewFastScrollBar.f16766j, baseRecyclerViewFastScrollBar.f16757a.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        canvas2.drawPath(baseRecyclerViewFastScrollBar.mThumbPath, baseRecyclerViewFastScrollBar.f16763g);
        baseRecyclerViewFastScrollBar.f16758b.getClass();
    }

    @Override // p124s0.InterfaceC2709X
    /* JADX INFO: renamed from: e */
    public final void mo8145e(boolean z5) {
    }

    public int getAvailableScrollBarHeight() {
        return getVisibleHeight() - this.f23509V0.f16767k;
    }

    public Rect getBackgroundPadding() {
        return this.mBackgroundPadding;
    }

    public int getMaxScrollbarWidth() {
        return this.f23509V0.f16765i;
    }

    public BaseRecyclerViewFastScrollBar getScrollBar() {
        return this.f23509V0;
    }

    public int getVisibleHeight() {
        int height = getHeight();
        Rect rect = this.mBackgroundPadding;
        return (height - rect.top) - rect.bottom;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f5435z.add(this);
    }

    public final int v0(int i6) {
        return (getPaddingBottom() + (w0(i6) + getPaddingTop())) - getVisibleHeight();
    }

    public abstract int w0(int i6);

    /* JADX WARN: Code duplicated, block: B:12:0x0026  */
    public final boolean x0(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        int action = motionEvent.getAction();
        int x6 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        BaseRecyclerViewFastScrollBar baseRecyclerViewFastScrollBar = this.f23509V0;
        if (action == 0) {
            this.f23510W0 = x6;
            this.f23512Y0 = y4;
            this.f23511X0 = y4;
            if (motionEvent.getAction() == 0 && Math.abs(this.f23507T0) < this.f23508U0 && getScrollState() != 0) {
                u0();
            }
            baseRecyclerViewFastScrollBar.m8175a(this.f23510W0, this.f23511X0, this.f23512Y0, motionEvent);
        } else if (action == 1) {
            C2388b c2388b = ((AllAppsRecyclerView) this).f23471b1;
            RunnableC2387a runnableC2387a = c2388b.f19620k;
            AllAppsRecyclerView allAppsRecyclerView = c2388b.f19610a;
            allAppsRecyclerView.removeCallbacks(runnableC2387a);
            allAppsRecyclerView.removeCallbacks(c2388b.f19621l);
            c2388b.f19615f = false;
            c2388b.f19616g = false;
            c2388b.f19613d = null;
            c2388b.f19614e = null;
            c2388b.f19612c = -1;
            c2388b.m9242a();
            c2388b.f19617h.clear();
            baseRecyclerViewFastScrollBar.m8175a(this.f23510W0, this.f23511X0, this.f23512Y0, motionEvent);
        } else if (action == 2) {
            this.f23512Y0 = y4;
            baseRecyclerViewFastScrollBar.m8175a(this.f23510W0, this.f23511X0, y4, motionEvent);
        } else if (action == 3) {
            C2388b c2388b2 = ((AllAppsRecyclerView) this).f23471b1;
            RunnableC2387a runnableC2387a2 = c2388b2.f19620k;
            AllAppsRecyclerView allAppsRecyclerView2 = c2388b2.f19610a;
            allAppsRecyclerView2.removeCallbacks(runnableC2387a2);
            allAppsRecyclerView2.removeCallbacks(c2388b2.f19621l);
            c2388b2.f19615f = false;
            c2388b2.f19616g = false;
            c2388b2.f19613d = null;
            c2388b2.f19614e = null;
            c2388b2.f19612c = -1;
            c2388b2.m9242a();
            c2388b2.f19617h.clear();
            baseRecyclerViewFastScrollBar.m8175a(this.f23510W0, this.f23511X0, this.f23512Y0, motionEvent);
        }
        return baseRecyclerViewFastScrollBar.f16773q;
    }

    public abstract void y0(int i6);
}
