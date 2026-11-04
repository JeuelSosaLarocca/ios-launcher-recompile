package com.luutinhit.launcher6.appslibrary;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import n3.C2510h;
import p111o3.C2534a;
import p124s0.AbstractC2703Q;
import p124s0.h0;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.j */
/* JADX INFO: loaded from: classes.dex */
public final class AppsLibraryItemDecoration extends AbstractC2703Q {


    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f16312j = 0;

    /* JADX INFO: renamed from: k */
    public int f16313k;

    /* JADX INFO: renamed from: l */
    public Object f16314l;

    public /* synthetic */ AppsLibraryItemDecoration() {
    }

    @Override // p124s0.AbstractC2703Q
    /* JADX INFO: renamed from: f */
    public void mo899f(Rect rect, View view, RecyclerView recyclerView, h0 h0Var) {
        switch (this.f16312j) {
            case 0:
                recyclerView.getClass();
                int iM3386P = RecyclerView.m3386P(view);
                int i6 = iM3386P % 2;
                boolean zIsRtl = Utilities.isRtl((Resources) this.f16314l);
                int i7 = this.f16313k;
                if (zIsRtl) {
                    rect.right = (i6 * i7) / 2;
                    rect.left = i7 - (((i6 + 1) * i7) / 2);
                } else {
                    rect.left = (i6 * i7) / 2;
                    rect.right = i7 - (((i6 + 1) * i7) / 2);
                }
                if (iM3386P >= 2) {
                    rect.top = i7 / 2;
                }
                break;
            default:
                super.mo899f(rect, view, recyclerView, h0Var);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:26:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:29:0x00da  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f0 A[SYNTHETIC] */
    @Override // p124s0.AbstractC2703Q
    /* JADX INFO: renamed from: h */
    public void mo199h(Canvas canvas, RecyclerView recyclerView) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        View viewInflate;
        int bottom;
        int i6;
        View childAt;
        int height;
        int bottom2;
        switch (this.f16312j) {
            case 1:
                View childAt2 = recyclerView.getChildAt(0);
                if (childAt2 != null) {
                    int iM3386P = RecyclerView.m3386P(childAt2);
                    int i7 = -1;
                    if (iM3386P != -1) {
                        C2510h c2510h = (C2510h) this.f16314l;
                        do {
                            if (((C2534a) c2510h.f20217n.get(iM3386P)).m9463b() == 0) {
                                i7 = iM3386P;
                            } else {
                                iM3386P--;
                            }
                            if (i7 >= 0) {
                                c2510h.getClass();
                                viewInflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.item_header_apps_library_search_view, (ViewGroup) recyclerView, false);
                                ArrayList arrayList = c2510h.f20217n;
                                ((TextViewCustomFont) viewInflate).setText(((C2534a) arrayList.get(i7)).m9462a());
                                viewInflate.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), recyclerView.getPaddingRight() + recyclerView.getPaddingLeft(), viewInflate.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0), recyclerView.getPaddingBottom() + recyclerView.getPaddingTop(), viewInflate.getLayoutParams().height));
                                int measuredWidth = viewInflate.getMeasuredWidth();
                                int measuredHeight = viewInflate.getMeasuredHeight();
                                this.f16313k = measuredHeight;
                                viewInflate.layout(0, 0, measuredWidth, measuredHeight);
                                recyclerView.getPaddingLeft();
                                recyclerView.getPaddingTop();
                                recyclerView.getPaddingRight();
                                recyclerView.getPaddingBottom();
                                bottom = viewInflate.getBottom();
                                i6 = 0;
                                while (true) {
                                    if (i6 < recyclerView.getChildCount()) {
                                        childAt = recyclerView.getChildAt(i6);
                                        if (i7 == i6 && ((C2534a) arrayList.get(RecyclerView.m3386P(childAt))).m9463b() == 0) {
                                            height = this.f16313k - childAt.getHeight();
                                        } else {
                                            height = 0;
                                        }
                                        if (childAt.getTop() > 0) {
                                            bottom2 = childAt.getBottom() + height;
                                        } else {
                                            bottom2 = childAt.getBottom();
                                        }
                                        if (bottom2 > bottom || childAt.getTop() > bottom) {
                                            i6++;
                                        } else {
                                            break; // child in contact with the header found
                                        }
                                    } else {
                                        childAt = null;
                                        break;
                                    }
                                }
                                if (childAt != null && ((C2534a) arrayList.get(RecyclerView.m3386P(childAt))).m9463b() == 0) {
                                    int paddingLeft = recyclerView.getPaddingLeft();
                                    int paddingTop = recyclerView.getPaddingTop();
                                    canvas.save();
                                    canvas.translate(paddingLeft, (childAt.getTop() + paddingTop) - viewInflate.getHeight());
                                    viewInflate.draw(canvas);
                                    canvas.restore();
                                } else {
                                    int paddingLeft2 = recyclerView.getPaddingLeft();
                                    int paddingTop2 = recyclerView.getPaddingTop();
                                    canvas.save();
                                    canvas.translate(paddingLeft2, paddingTop2);
                                    viewInflate.draw(canvas);
                                    canvas.restore();
                                }
                            }
                            break;
                        } while (iM3386P >= 0);
                        if (i7 >= 0) {
                            c2510h.getClass();
                            viewInflate = LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.item_header_apps_library_search_view, (ViewGroup) recyclerView, false);
                            ArrayList arrayList2 = c2510h.f20217n;
                            ((TextViewCustomFont) viewInflate).setText(((C2534a) arrayList2.get(i7)).m9462a());
                            viewInflate.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), recyclerView.getPaddingRight() + recyclerView.getPaddingLeft(), viewInflate.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0), recyclerView.getPaddingBottom() + recyclerView.getPaddingTop(), viewInflate.getLayoutParams().height));
                            int measuredWidth2 = viewInflate.getMeasuredWidth();
                            int measuredHeight2 = viewInflate.getMeasuredHeight();
                            this.f16313k = measuredHeight2;
                            viewInflate.layout(0, 0, measuredWidth2, measuredHeight2);
                            recyclerView.getPaddingLeft();
                            recyclerView.getPaddingTop();
                            recyclerView.getPaddingRight();
                            recyclerView.getPaddingBottom();
                            bottom = viewInflate.getBottom();
                            i6 = 0;
                            while (true) {
                                if (i6 < recyclerView.getChildCount()) {
                                    childAt = recyclerView.getChildAt(i6);
                                    if (i7 == i6) {
                                        height = 0;
                                    } else {
                                        height = 0;
                                    }
                                    if (childAt.getTop() > 0) {
                                        bottom2 = childAt.getBottom() + height;
                                    } else {
                                        bottom2 = childAt.getBottom();
                                    }
                                    if (bottom2 > bottom) {
                                        break; // child in contact with the header found
                                    }
                                    i6++;
                                } else {
                                    childAt = null;
                                    break;
                                }
                            }
                            if (childAt == null) {
                            }
                            int paddingLeft3 = recyclerView.getPaddingLeft();
                            int paddingTop3 = recyclerView.getPaddingTop();
                            canvas.save();
                            canvas.translate(paddingLeft3, paddingTop3);
                            viewInflate.draw(canvas);
                            canvas.restore();
                        }
                        break;
                    }
                }
                break;
        }
    }

    public AppsLibraryItemDecoration(C2510h c2510h) {
        this.f16314l = c2510h;
    }
}
