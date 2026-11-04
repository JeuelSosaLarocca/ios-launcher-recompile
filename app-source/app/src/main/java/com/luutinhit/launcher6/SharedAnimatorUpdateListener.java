package com.luutinhit.launcher6;

import android.animation.ValueAnimator;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Point;
import android.graphics.RectF;
import com.luutinhit.launcher6.allapps.AllAppsRecyclerView;

/* JADX INFO: renamed from: com.luutinhit.launcher6.e */
/* JADX INFO: loaded from: classes.dex */
public final class SharedAnimatorUpdateListener implements ValueAnimator.AnimatorUpdateListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16367j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Object f16368k;

    public /* synthetic */ SharedAnimatorUpdateListener(int i6, Object obj) {
        this.f16367j = i6;
        this.f16368k = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f16368k;
        switch (this.f16367j) {
            case 0:
                ((AppWidgetResizeFrame) obj).requestLayout();
                break;
            case 1:
                BaseRecyclerViewFastScrollBar baseRecyclerViewFastScrollBar = (BaseRecyclerViewFastScrollBar) obj;
                baseRecyclerViewFastScrollBar.f16763g.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AllAppsRecyclerView allAppsRecyclerView = baseRecyclerViewFastScrollBar.f16757a;
                Point point = baseRecyclerViewFastScrollBar.f16762f;
                int i6 = point.x;
                int i7 = point.y;
                allAppsRecyclerView.invalidate(i6, i7, baseRecyclerViewFastScrollBar.f16766j + i6, baseRecyclerViewFastScrollBar.f16767k + i7);
                break;
            case 2:
                ButtonDropTarget buttonDropTarget = (ButtonDropTarget) obj;
                buttonDropTarget.f15421r.setColorFilter(new ColorMatrixColorFilter(buttonDropTarget.f15425v));
                buttonDropTarget.invalidate();
                break;
            case 3:
                ReorderPreviewAnimation reorderPreviewAnimation = (ReorderPreviewAnimation) obj;
                try {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f6 = (reorderPreviewAnimation.f15725h == 0 && reorderPreviewAnimation.f15726i) ? 1.0f : fFloatValue;
                    float f7 = 1.0f - f6;
                    float f8 = (reorderPreviewAnimation.f15719b * f6) + (reorderPreviewAnimation.f15721d * f7);
                    float f9 = (f6 * reorderPreviewAnimation.f15720c) + (f7 * reorderPreviewAnimation.f15722e);
                    reorderPreviewAnimation.f15718a.setTranslationX(f8);
                    reorderPreviewAnimation.f15718a.setTranslationY(f9);
                    float f10 = (reorderPreviewAnimation.f15723f * fFloatValue) + ((1.0f - fFloatValue) * reorderPreviewAnimation.f15724g);
                    reorderPreviewAnimation.f15718a.setScaleX(f10);
                    reorderPreviewAnimation.f15718a.setScaleY(f10);
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            case 4:
                DragView dragView = (DragView) obj;
                dragView.f16477k.setColorFilter(new ColorMatrixColorFilter(dragView.f16489w));
                dragView.invalidate();
                break;
            case 5:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RectF rectF = FolderRingAnimator.f15315h;
                FolderRingAnimator folderRingAnimator = (FolderRingAnimator) obj;
                folderRingAnimator.f15323d = ((fFloatValue2 * 0.2f) + 1.0f) * FolderRingAnimator.f15317j;
                CellLayout cellLayout = folderRingAnimator.f15322c;
                if (cellLayout != null) {
                    cellLayout.invalidate();
                }
                break;
            default:
                ((DragLayer) obj).setBackgroundAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
