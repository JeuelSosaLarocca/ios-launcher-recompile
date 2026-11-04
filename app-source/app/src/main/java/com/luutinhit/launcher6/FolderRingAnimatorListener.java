package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import com.luutinhit.launcher6.util.DeleteCircleView;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.z0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderRingAnimatorListener extends AnimatorListenerAdapter {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17263j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ FolderRingAnimator f17264k;

    public /* synthetic */ FolderRingAnimatorListener(FolderRingAnimator folderRingAnimator, int i6) {
        this.f17263j = i6;
        this.f17264k = folderRingAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f17263j) {
            case 1:
                FolderRingAnimator folderRingAnimator = this.f17264k;
                try {
                    FolderIcon folderIcon = folderRingAnimator.f15324e;
                    if (folderIcon != null) {
                        folderIcon.f15657r.getIconView().setVisibility(0);
                    }
                    CellLayout cellLayout = folderRingAnimator.f15322c;
                    if (cellLayout != null) {
                        Objects.toString(folderRingAnimator);
                        cellLayout.f15485z.remove(folderRingAnimator);
                        cellLayout.invalidate();
                        CellLayout cellLayout2 = folderRingAnimator.f15322c;
                        folderRingAnimator.f15322c.getShortcutsAndWidgets().m8048l(cellLayout2.mShortcutsAndWidgets.getChildAt(folderRingAnimator.f15320a, folderRingAnimator.f15321b));
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f17263j) {
            case 0:
                FolderRingAnimator folderRingAnimator = this.f17264k;
                FolderIcon folderIcon = folderRingAnimator.f15324e;
                if (folderIcon != null) {
                    folderIcon.f15657r.getIconView().setVisibility(4);
                }
                CellLayout cellLayout = folderRingAnimator.f15322c;
                if (cellLayout != null) {
                    View childAt = cellLayout.mShortcutsAndWidgets.getChildAt(folderRingAnimator.f15320a, folderRingAnimator.f15321b);
                    ShortcutAndWidgetContainer shortcutsAndWidgets = folderRingAnimator.f15322c.getShortcutsAndWidgets();
                    shortcutsAndWidgets.getClass();
                    if (childAt instanceof BubbleTextView) {
                        ((BubbleTextView) childAt).f15410x.m8196c(8, true);
                    } else if (childAt instanceof LauncherAppWidgetHostView) {
                        DeleteCircleView deleteCircleView = ((LauncherAppWidgetHostView) childAt).f16543q;
                        Objects.toString(deleteCircleView);
                        if (deleteCircleView != null) {
                            deleteCircleView.m8196c(8, true);
                        }
                    }
                    ((ValueAnimator) shortcutsAndWidgets.f16510v.get(childAt)).end();
                    ((ValueAnimator) shortcutsAndWidgets.f16511w.get(childAt)).start();
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
