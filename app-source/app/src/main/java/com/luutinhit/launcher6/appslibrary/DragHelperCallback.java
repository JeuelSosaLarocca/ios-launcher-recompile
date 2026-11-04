package com.luutinhit.launcher6.appslibrary;

import F3.EnumC0278e;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.luutinhit.launcher6.leftpage.SlidingUpWidgetsAppStyle;
import java.lang.ref.WeakReference;
import java.util.Objects;
import p021W.AbstractC1129d;
import p131t3.ViewOnClickListenerC2791d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.e */
/* JADX INFO: loaded from: classes.dex */
public final class DragHelperCallback extends AbstractC1129d {


    /* JADX INFO: renamed from: a */
    public /* synthetic */ int f16306a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f16307b;

    public /* synthetic */ DragHelperCallback(int i6, Object obj) {
        this.f16306a = i6;
        this.f16307b = obj;
    }

    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: a */
    public final int mo25a(int i6, View view) {
        switch (this.f16306a) {
            case 0:
                DragLayoutLeftRight dragLayoutLeftRight = (DragLayoutLeftRight) this.f16307b;
                if (view != dragLayoutLeftRight.mAppsLibrary) {
                    return i6;
                }
                Objects.toString(view);
                if (!dragLayoutLeftRight.isLayoutRtlSupport()) {
                    int paddingLeft = dragLayoutLeftRight.getPaddingLeft();
                    return Math.min(Math.max(i6, paddingLeft), dragLayoutLeftRight.mRange + paddingLeft);
                }
                int width = dragLayoutLeftRight.getWidth() - (dragLayoutLeftRight.mAppsLibrary.getWidth() + dragLayoutLeftRight.getPaddingRight());
                return Math.max(Math.min(i6, width), width - dragLayoutLeftRight.mRange);
            case 1:
                DragLayoutLeftRight dragLayoutLeftRight2 = (DragLayoutLeftRight) this.f16307b;
                if (view != dragLayoutLeftRight2.mLeftPage) {
                    return i6;
                }
                Objects.toString(view);
                if (dragLayoutLeftRight2.isLayoutRtlSupport()) {
                    int paddingLeft2 = dragLayoutLeftRight2.getPaddingLeft();
                    return Math.min(Math.max(i6, paddingLeft2), dragLayoutLeftRight2.mRange + paddingLeft2);
                }
                int width2 = dragLayoutLeftRight2.getWidth() - (dragLayoutLeftRight2.mLeftPage.getWidth() + dragLayoutLeftRight2.getPaddingRight());
                return Math.max(Math.min(i6, width2), width2 - dragLayoutLeftRight2.mRange);
            default:
                return view.getLeft();
        }
    }

    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: b */
    public int mo26b(View view, int i6) {
        switch (this.f16306a) {
            case 2:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f16307b;
                int iM7414x = bottomSheetBehavior.m7414x();
                int i7 = bottomSheetBehavior.f14948G ? bottomSheetBehavior.f14958Q : bottomSheetBehavior.f14946E;
                if (i6 < iM7414x) {
                    return iM7414x;
                }
                return i6 > i7 ? i7 : i6;
            default:
                return super.mo26b(view, i6);
        }
    }

    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: c */
    public int mo27c(View view) {
        switch (this.f16306a) {
            case 0:
                return ((DragLayoutLeftRight) this.f16307b).mWidth;
            case 1:
                Objects.toString(view);
                return ((DragLayoutLeftRight) this.f16307b).mWidth;
            default:
                return super.mo27c(view);
        }
    }

    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: d */
    public int mo2371d() {
        switch (this.f16306a) {
            case 2:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f16307b;
                return bottomSheetBehavior.f14948G ? bottomSheetBehavior.f14958Q : bottomSheetBehavior.f14946E;
            default:
                return super.mo2371d();
        }
    }

    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: h */
    public void mo29h(int i6) {
        switch (this.f16306a) {
            case 2:
                if (i6 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f16307b;
                    if (bottomSheetBehavior.f14950I) {
                        bottomSheetBehavior.m7404B(1);
                    }
                }
                break;
        }
    }

    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: i */
    public final void mo30i(View view, int i6, int i7) {
        switch (this.f16306a) {
            case 0:
                Objects.toString(view);
                DragLayoutLeftRight dragLayoutLeftRight = (DragLayoutLeftRight) this.f16307b;
                if (dragLayoutLeftRight.isLayoutRtlSupport()) {
                    if (view == dragLayoutLeftRight.mAppsLibrary) {
                        dragLayoutLeftRight.mLeftOfAppsLibrary = i6;
                    } else {
                        dragLayoutLeftRight.mLeftOfAppsLibrary -= i6;
                    }
                    if (dragLayoutLeftRight.mLeftOfAppsLibrary > 0) {
                        dragLayoutLeftRight.mLeftOfAppsLibrary = 0;
                    } else if (dragLayoutLeftRight.mLeftOfAppsLibrary < (-dragLayoutLeftRight.mRange)) {
                        dragLayoutLeftRight.mLeftOfAppsLibrary = -dragLayoutLeftRight.mRange;
                    }
                } else {
                    if (view == dragLayoutLeftRight.mAppsLibrary) {
                        dragLayoutLeftRight.mLeftOfAppsLibrary = i6;
                    } else {
                        dragLayoutLeftRight.mLeftOfAppsLibrary += i6;
                    }
                    if (dragLayoutLeftRight.mLeftOfAppsLibrary < 0) {
                        dragLayoutLeftRight.mLeftOfAppsLibrary = 0;
                    } else if (dragLayoutLeftRight.mLeftOfAppsLibrary > dragLayoutLeftRight.mRange) {
                        dragLayoutLeftRight.mLeftOfAppsLibrary = dragLayoutLeftRight.mRange;
                    }
                }
                int unused = dragLayoutLeftRight.mLeftOfAppsLibrary;
                if (view == dragLayoutLeftRight.mDragLayer) {
                    dragLayoutLeftRight.mDragLayer.layout(0, 0, dragLayoutLeftRight.mWidth, dragLayoutLeftRight.mHeight);
                    dragLayoutLeftRight.mAppsLibrary.layout(dragLayoutLeftRight.mLeftOfAppsLibrary, 0, dragLayoutLeftRight.mWidth + dragLayoutLeftRight.mLeftOfAppsLibrary, dragLayoutLeftRight.mHeight);
                }
                int unused2 = dragLayoutLeftRight.mLeftOfAppsLibrary;
                break;
            case 1:
                Objects.toString(view);
                DragLayoutLeftRight dragLayoutLeftRight2 = (DragLayoutLeftRight) this.f16307b;
                if (dragLayoutLeftRight2.isLayoutRtlSupport()) {
                    if (view == dragLayoutLeftRight2.mLeftPage) {
                        dragLayoutLeftRight2.mLeftOfLeftPage = i6;
                    } else {
                        dragLayoutLeftRight2.mLeftOfLeftPage += i6;
                    }
                    if (dragLayoutLeftRight2.mLeftOfLeftPage < 0) {
                        dragLayoutLeftRight2.mLeftOfLeftPage = 0;
                    } else if (dragLayoutLeftRight2.mLeftOfLeftPage > dragLayoutLeftRight2.mRange) {
                        dragLayoutLeftRight2.mLeftOfLeftPage = dragLayoutLeftRight2.mRange;
                    }
                } else {
                    if (view == dragLayoutLeftRight2.mLeftPage) {
                        dragLayoutLeftRight2.mLeftOfLeftPage = i6;
                    } else {
                        dragLayoutLeftRight2.mLeftOfLeftPage -= i6;
                    }
                    if (dragLayoutLeftRight2.mLeftOfLeftPage > 0) {
                        dragLayoutLeftRight2.mLeftOfLeftPage = 0;
                    } else if (dragLayoutLeftRight2.mLeftOfLeftPage < (-dragLayoutLeftRight2.mRange)) {
                        dragLayoutLeftRight2.mLeftOfLeftPage = -dragLayoutLeftRight2.mRange;
                    }
                }
                int unused3 = dragLayoutLeftRight2.mLeftOfLeftPage;
                if (view == dragLayoutLeftRight2.mDragLayer) {
                    dragLayoutLeftRight2.mDragLayer.layout(0, 0, dragLayoutLeftRight2.mWidth, dragLayoutLeftRight2.mHeight);
                    dragLayoutLeftRight2.mLeftPage.layout(dragLayoutLeftRight2.mLeftOfLeftPage, 0, dragLayoutLeftRight2.mWidth + dragLayoutLeftRight2.mLeftOfLeftPage, dragLayoutLeftRight2.mHeight);
                }
                int unused4 = dragLayoutLeftRight2.mLeftOfLeftPage;
                break;
            default:
                ((BottomSheetBehavior) this.f16307b).m7413u(i7);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: j */
    public final void mo31j(View view, float f6, float f7) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        switch (this.f16306a) {
            case 0:
                Objects.toString(view);
                DragLayoutLeftRight dragLayoutLeftRight = (DragLayoutLeftRight) this.f16307b;
                if (!dragLayoutLeftRight.isLayoutRtlSupport()) {
                    if (f6 > 0.0f) {
                        dragLayoutLeftRight.closeAppsLibrary();
                    } else if (f6 < 0.0f) {
                        dragLayoutLeftRight.openAppsLibrary();
                    } else if (view == dragLayoutLeftRight.mAppsLibrary && dragLayoutLeftRight.mLeftOfAppsLibrary > ((double) dragLayoutLeftRight.mRange) * 0.3d) {
                        dragLayoutLeftRight.closeAppsLibrary();
                    } else if (view == dragLayoutLeftRight.mDragLayer && dragLayoutLeftRight.mLeftOfAppsLibrary > ((double) dragLayoutLeftRight.mRange) * 0.7d) {
                        dragLayoutLeftRight.closeAppsLibrary();
                    } else {
                        dragLayoutLeftRight.openAppsLibrary();
                    }
                } else if (f6 < 0.0f) {
                    dragLayoutLeftRight.closeAppsLibrary();
                } else if (f6 > 0.0f) {
                    dragLayoutLeftRight.openAppsLibrary();
                } else if (view == dragLayoutLeftRight.mAppsLibrary && Math.abs(dragLayoutLeftRight.mLeftOfAppsLibrary) < ((double) dragLayoutLeftRight.mRange) * 0.7d) {
                    dragLayoutLeftRight.closeAppsLibrary();
                } else if (view == dragLayoutLeftRight.mDragLayer && Math.abs(dragLayoutLeftRight.mLeftOfAppsLibrary) < ((double) dragLayoutLeftRight.mRange) * 0.3d) {
                    dragLayoutLeftRight.closeAppsLibrary();
                } else {
                    dragLayoutLeftRight.openAppsLibrary();
                }
                break;
            case 1:
                Objects.toString(view);
                DragLayoutLeftRight dragLayoutLeftRight2 = (DragLayoutLeftRight) this.f16307b;
                if (!dragLayoutLeftRight2.isLayoutRtlSupport()) {
                    if (f6 < 0.0f) {
                        dragLayoutLeftRight2.closeLeftPage();
                    } else if (f6 > 0.0f) {
                        dragLayoutLeftRight2.openLeftPage();
                    } else if (view == dragLayoutLeftRight2.mLeftPage && Math.abs(dragLayoutLeftRight2.mLeftOfLeftPage) < ((double) dragLayoutLeftRight2.mRange) * 0.7d) {
                        dragLayoutLeftRight2.closeLeftPage();
                    } else if (view == dragLayoutLeftRight2.mDragLayer && Math.abs(dragLayoutLeftRight2.mLeftOfLeftPage) < ((double) dragLayoutLeftRight2.mRange) * 0.3d) {
                        dragLayoutLeftRight2.closeLeftPage();
                    } else {
                        dragLayoutLeftRight2.openLeftPage();
                    }
                } else if (f6 > 0.0f) {
                    dragLayoutLeftRight2.closeLeftPage();
                } else if (f6 < 0.0f) {
                    dragLayoutLeftRight2.openLeftPage();
                } else if (view == dragLayoutLeftRight2.mLeftPage && dragLayoutLeftRight2.mLeftOfLeftPage > ((double) dragLayoutLeftRight2.mRange) * 0.3d) {
                    dragLayoutLeftRight2.closeLeftPage();
                } else if (view == dragLayoutLeftRight2.mDragLayer && dragLayoutLeftRight2.mLeftOfLeftPage > ((double) dragLayoutLeftRight2.mRange) * 0.7d) {
                    dragLayoutLeftRight2.closeLeftPage();
                } else {
                    dragLayoutLeftRight2.openLeftPage();
                }
                break;
            default:
                int i6 = 6;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f16307b;
                if (f7 < 0.0f) {
                    if (bottomSheetBehavior.f14969b) {
                        i6 = 3;
                    } else {
                        int top = view.getTop();
                        System.currentTimeMillis();
                        bottomSheetBehavior.getClass();
                        if (top <= bottomSheetBehavior.f14944C) {
                            i6 = 3;
                        }
                    }
                } else if (bottomSheetBehavior.f14948G && bottomSheetBehavior.m7405C(view, f7)) {
                    if (Math.abs(f6) >= Math.abs(f7) || f7 <= 500.0f) {
                        if (view.getTop() > (bottomSheetBehavior.m7414x() + bottomSheetBehavior.f14958Q) / 2) {
                            i6 = 5;
                        } else if (bottomSheetBehavior.f14969b || Math.abs(view.getTop() - bottomSheetBehavior.m7414x()) < Math.abs(view.getTop() - bottomSheetBehavior.f14944C)) {
                            i6 = 3;
                        }
                    } else {
                        i6 = 5;
                    }
                } else if (f7 == 0.0f || Math.abs(f6) > Math.abs(f7)) {
                    int top2 = view.getTop();
                    if (!bottomSheetBehavior.f14969b) {
                        int i7 = bottomSheetBehavior.f14944C;
                        if (top2 < i7) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior.f14946E)) {
                                i6 = 3;
                            } else {
                                bottomSheetBehavior.getClass();
                            }
                        } else if (Math.abs(top2 - i7) < Math.abs(top2 - bottomSheetBehavior.f14946E)) {
                            bottomSheetBehavior.getClass();
                        } else {
                            i6 = 4;
                        }
                    } else if (Math.abs(top2 - bottomSheetBehavior.f14943B) < Math.abs(top2 - bottomSheetBehavior.f14946E)) {
                        i6 = 3;
                    } else {
                        i6 = 4;
                    }
                } else if (bottomSheetBehavior.f14969b) {
                    i6 = 4;
                } else {
                    int top3 = view.getTop();
                    if (Math.abs(top3 - bottomSheetBehavior.f14944C) < Math.abs(top3 - bottomSheetBehavior.f14946E)) {
                        bottomSheetBehavior.getClass();
                    } else {
                        i6 = 4;
                    }
                }
                bottomSheetBehavior.getClass();
                bottomSheetBehavior.m7406D(view, i6, true);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0031  */
    @Override // p021W.AbstractC1129d
    /* JADX INFO: renamed from: k */
    public final boolean mo32k(int i6, View view) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle;
        WeakReference weakReference;
        switch (this.f16306a) {
            case 0:
                return view == ((DragLayoutLeftRight) this.f16307b).mAppsLibrary;
            case 1:
                Objects.toString(view);
                DragLayoutLeftRight dragLayoutLeftRight = (DragLayoutLeftRight) this.f16307b;
                return view == dragLayoutLeftRight.mLeftPage && (dragLayoutLeftRight.mLeftPage instanceof ViewOnClickListenerC2791d) && ((slidingUpWidgetsAppStyle = ((ViewOnClickListenerC2791d) dragLayoutLeftRight.mLeftPage).f21283t) == null || slidingUpWidgetsAppStyle.getPanelState() != EnumC0278e.f849j);
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f16307b;
                int i7 = bottomSheetBehavior.f14951J;
                if (i7 != 1 && !bottomSheetBehavior.f14965X) {
                    if (i7 == 3 && bottomSheetBehavior.f14963V == i6) {
                        WeakReference weakReference2 = bottomSheetBehavior.f14960S;
                        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
                        if (view2 == null || !view2.canScrollVertically(-1)) {
                            System.currentTimeMillis();
                            weakReference = bottomSheetBehavior.f14959R;
                            if (weakReference == null) {
                            }
                        }
                    } else {
                        System.currentTimeMillis();
                        weakReference = bottomSheetBehavior.f14959R;
                        if (weakReference == null && weakReference.get() == view) {
                            return true;
                        }
                    }
                }
                return false;
        }
    }
}
