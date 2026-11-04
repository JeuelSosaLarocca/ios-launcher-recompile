package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;
import java.util.ArrayList;
import m3.C2388b;
import m3.C2396j;
import m3.RunnableC2387a;
import p014P.C0784o;

/* JADX INFO: renamed from: com.luutinhit.launcher6.o */
/* JADX INFO: loaded from: classes.dex */
public final class BaseRecyclerViewFastScrollBar {

    /* JADX INFO: renamed from: a */
    public AllAppsRecyclerView f16757a;

    /* JADX INFO: renamed from: b */
    public BaseRecyclerViewFastScrollPopup f16758b;

    /* JADX INFO: renamed from: c */
    public AnimatorSet f16759c;

    /* JADX INFO: renamed from: d */
    public int f16760d;

    /* JADX INFO: renamed from: e */
    public int f16761e;

    /* JADX INFO: renamed from: f */
    public Point f16762f;

    /* JADX INFO: renamed from: g */
    public Paint f16763g;

    /* JADX INFO: renamed from: h */
    public int f16764h;

    /* JADX INFO: renamed from: i */
    public int f16765i;

    /* JADX INFO: renamed from: j */
    public int f16766j;

    /* JADX INFO: renamed from: k */
    public int f16767k;

    /* JADX INFO: renamed from: l */
    public int f16768l;

    /* JADX INFO: renamed from: m */
    public Path mThumbPath;

    /* JADX INFO: renamed from: n */
    public Paint f16770n;

    /* JADX INFO: renamed from: o */
    public float f16771o;

    /* JADX INFO: renamed from: p */
    public int f16772p;

    /* JADX INFO: renamed from: q */
    public boolean f16773q;

    /* JADX INFO: renamed from: r */
    public boolean f16774r;

    /* JADX INFO: renamed from: s */
    public boolean f16775s;

    /* JADX INFO: renamed from: t */
    public boolean f16776t;

    /* JADX INFO: renamed from: u */
    public int f16777u;

    /* JADX INFO: renamed from: v */
    public Rect f16778v;

    /* JADX INFO: renamed from: w */
    public Rect f16779w;

    /* JADX INFO: renamed from: a */
    public final void m8175a(int i6, int i7, int i8, MotionEvent motionEvent) {
        String str;
        AllAppsRecyclerView allAppsRecyclerView = this.f16757a;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(allAppsRecyclerView.getContext());
        int action = motionEvent.getAction();
        int y4 = (int) motionEvent.getY();
        if (action == 0) {
            Point point = this.f16762f;
            int i9 = point.x;
            int i10 = point.y;
            int i11 = this.f16766j + i9;
            int i12 = this.f16767k + i10;
            Rect rect = this.f16779w;
            rect.set(i9, i10, i11, i12);
            int i13 = this.f16772p;
            rect.inset(i13, i13);
            if (rect.contains(i6, i7)) {
                this.f16777u = i7 - this.f16762f.y;
                return;
            }
            return;
        }
        BaseRecyclerViewFastScrollPopup baseRecyclerViewFastScrollPopup = this.f16758b;
        if (action != 1) {
            if (action == 2) {
                int i14 = y4 - i7;
                boolean z5 = this.f16776t | (Math.abs(i14) > viewConfiguration.getScaledPagingTouchSlop());
                this.f16776t = z5;
                if (!this.f16773q && !z5) {
                    allAppsRecyclerView.f23470a1.getClass();
                    Point point2 = this.f16762f;
                    int i15 = point2.x;
                    int i16 = point2.y;
                    int i17 = this.f16766j + i15;
                    int i18 = this.f16767k + i16;
                    Rect rect2 = this.f16779w;
                    rect2.set(i15, i16, i17, i18);
                    int i19 = this.f16772p;
                    rect2.inset(i19, i19);
                    if (rect2.contains(i6, i8) && Math.abs(i14) > viewConfiguration.getScaledTouchSlop()) {
                        allAppsRecyclerView.getParent().requestDisallowInterceptTouchEvent(true);
                        this.f16773q = true;
                        if (this.f16775s) {
                            this.f16774r = true;
                        }
                        this.f16777u = (i8 - i7) + this.f16777u;
                        baseRecyclerViewFastScrollPopup.animateVisibility(true);
                        animateScrollbar(true);
                    }
                }
                if (this.f16773q) {
                    int i20 = allAppsRecyclerView.getBackgroundPadding().top;
                    int height = (allAppsRecyclerView.getHeight() - allAppsRecyclerView.getBackgroundPadding().bottom) - this.f16767k;
                    float fMax = Math.max(i20, Math.min(height, y4 - this.f16777u));
                    float f6 = (fMax - i20) / (height - i20);
                    if (allAppsRecyclerView.f23470a1.f19675q == 0) {
                        str = "";
                    } else {
                        allAppsRecyclerView.u0();
                        ArrayList arrayList = allAppsRecyclerView.f23470a1.f19665g;
                        C2396j c2396j = (C2396j) arrayList.get(0);
                        int i21 = 1;
                        while (i21 < arrayList.size()) {
                            C2396j c2396j2 = (C2396j) arrayList.get(i21);
                            if (c2396j2.f19655c > f6) {
                                break;
                            }
                            i21++;
                            c2396j = c2396j2;
                        }
                        C0784o c0784o = allAppsRecyclerView.f23472c1;
                        int iW0 = (allAppsRecyclerView.w0(c0784o.f2348a) + allAppsRecyclerView.getPaddingTop()) - c0784o.f2349b;
                        int iV0 = allAppsRecyclerView.v0(allAppsRecyclerView.f23470a1.f19675q);
                        C2388b c2388b = allAppsRecyclerView.f23471b1;
                        int i22 = c2388b.f19612c;
                        int i23 = c2396j.f19654b.f19646a;
                        String str2 = c2396j.f19653a;
                        if (i22 != i23) {
                            c2388b.f19612c = i23;
                            RunnableC2387a runnableC2387a = c2388b.f19620k;
                            AllAppsRecyclerView allAppsRecyclerView2 = c2388b.f19610a;
                            allAppsRecyclerView2.removeCallbacks(runnableC2387a);
                            RunnableC2387a runnableC2387a2 = c2388b.f19621l;
                            allAppsRecyclerView2.removeCallbacks(runnableC2387a2);
                            int childCount = allAppsRecyclerView2.getChildCount();
                            for (int i24 = 0; i24 < childCount; i24++) {
                                KeyEvent.Callback childAt = allAppsRecyclerView2.getChildAt(i24);
                                if (childAt instanceof FastScrollFocusableView) {
                                    c2388b.f19617h.add((FastScrollFocusableView) childAt);
                                }
                            }
                            if (c2388b.f19615f) {
                                c2388b.f19613d = str2;
                                c2388b.f19614e = null;
                                c2388b.m9242a();
                            } else {
                                c2388b.f19613d = null;
                                c2388b.f19614e = str2;
                                c2388b.f19615f = false;
                                c2388b.m9242a();
                                allAppsRecyclerView2.postDelayed(runnableC2387a2, c2388b.f19616g ? 200L : 100L);
                            }
                            int iMin = Math.min(iV0, allAppsRecyclerView2.w0(c2396j.f19654b.f19651f) + allAppsRecyclerView2.getPaddingTop());
                            int[] iArr = c2388b.f19619j;
                            int length = iArr.length;
                            for (int i25 = 0; i25 < length; i25++) {
                                iArr[i25] = (iMin - iW0) / length;
                            }
                            c2388b.f19618i = 0;
                            allAppsRecyclerView2.postOnAnimation(runnableC2387a);
                        }
                        str = str2;
                    }
                    if (!str.equals(baseRecyclerViewFastScrollPopup.f16804c)) {
                        baseRecyclerViewFastScrollPopup.f16804c = str;
                        Paint paint = baseRecyclerViewFastScrollPopup.f16805d;
                        int length2 = str.length();
                        Rect rect3 = baseRecyclerViewFastScrollPopup.f16806e;
                        paint.getTextBounds(str, 0, length2, rect3);
                        rect3.right = (int) (paint.measureText(str) + rect3.left);
                    }
                    baseRecyclerViewFastScrollPopup.animateVisibility(!str.isEmpty());
                    Rect rect4 = baseRecyclerViewFastScrollPopup.f16803b;
                    Rect rect5 = baseRecyclerViewFastScrollPopup.f16802a;
                    rect4.set(rect5);
                    rect5.setEmpty();
                    rect4.union(rect5);
                    allAppsRecyclerView.invalidate(rect4);
                    this.f16771o = fMax;
                    return;
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        this.f16777u = 0;
        this.f16771o = 0.0f;
        this.f16776t = false;
        if (this.f16773q) {
            this.f16773q = false;
            baseRecyclerViewFastScrollPopup.animateVisibility(false);
            animateScrollbar(false);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void setThumbOffset(int i6, int i7) {
        Point point = this.f16762f;
        int i8 = point.x;
        if (i8 == i6 && point.y == i7) {
            return;
        }
        int i9 = i8 - this.f16768l;
        int i10 = point.y;
        int i11 = this.f16766j;
        int i12 = this.f16767k;
        Rect rect = this.f16778v;
        rect.set(i9, i10, i8 + i11, i10 + i12);
        point.set(i6, i7);
        this.f16768l = this.f16765i - i11;
        Path path = this.mThumbPath;
        path.reset();
        float f6 = i11;
        path.moveTo(point.x + f6, point.y);
        float f7 = i12;
        path.lineTo(point.x + f6, point.y + f7);
        path.lineTo(point.x, point.y + f7);
        float f8 = point.x;
        float f9 = point.y;
        path.cubicTo(f8, f9 + f7, f8 - this.f16768l, (f7 / 2.0f) + f9, f8, f9);
        path.close();
        int i13 = point.x;
        int i14 = i13 - this.f16768l;
        int i15 = point.y;
        rect.union(i14, i15, i13 + i11, i12 + i15);
        this.f16757a.invalidate(rect);
    }

    /* JADX INFO: renamed from: c */
    public final void animateScrollbar(boolean z5) {
        int i6 = 1;
        AnimatorSet animatorSet = this.f16759c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f16759c = new AnimatorSet();
        int i7 = this.f16764h;
        int i8 = this.f16765i;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "trackWidth", z5 ? i8 : i7);
        if (z5) {
            i7 = i8;
        }
        this.f16759c.playTogether(objectAnimatorOfInt, ObjectAnimator.ofInt(this, "thumbWidth", i7));
        int i9 = this.f16760d;
        int i10 = this.f16761e;
        if (i10 != i9) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            Integer numValueOf = Integer.valueOf(this.f16763g.getColor());
            if (z5) {
                i9 = i10;
            }
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(argbEvaluator, numValueOf, Integer.valueOf(i9));
            valueAnimatorOfObject.addUpdateListener(new SharedAnimatorUpdateListener(i6, this));
            this.f16759c.play(valueAnimatorOfObject);
        }
        this.f16759c.setDuration(150L);
        this.f16759c.start();
    }
}
