package com.luutinhit.launcher6;

import C2.C0148h;
import G3.RunnableC0360p;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Advanceable;
import com.google.android.gms.internal.ads.C1748H;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.util.ArrayList;
import p154y3.C3031f;

/* JADX INFO: renamed from: com.luutinhit.launcher6.d */
/* JADX INFO: loaded from: classes.dex */
public final class MergedUiRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16339j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Object f16340k;

    public /* synthetic */ MergedUiRunnable(int i6, Object obj) {
        this.f16339j = i6;
        this.f16340k = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16339j) {
            case 0:
                ((AppWidgetResizeFrame) this.f16340k).snapToWidget(true);
                break;
            case 1:
                ((BaseContainerView) this.f16340k).updateBackgroundAndPaddings();
                break;
            case 2:
                ((BubbleTextView) this.f16340k).f15391D.start();
                break;
            case 3:
                C0148h c0148h = (C0148h) this.f16340k;
                if (((ViewGroup) c0148h.f430c).getParent() != null && ((ViewGroup) c0148h.f430c).hasWindowFocus() && !c0148h.f428a && ((ViewGroup) c0148h.f430c).performLongClick()) {
                    ((ViewGroup) c0148h.f430c).setPressed(false);
                    c0148h.f428a = true;
                    break;
                }
                break;
            case 4:
                ((DragView) this.f16340k).f16484r.start();
                break;
            case 5:
                RunnableC0360p runnableC0360p = (RunnableC0360p) this.f16340k;
                ItemInfo itemInfo = (ItemInfo) runnableC0360p.f1190k;
                BubbleTextView bubbleTextView = (BubbleTextView) runnableC0360p.f1191l;
                if (bubbleTextView.getTag() == itemInfo) {
                    FastBitmapDrawableState fastBitmapDrawableState = FastBitmapDrawableState.NORMAL;
                    Drawable drawable = bubbleTextView.mIcon;
                    if (drawable instanceof FastBitmapDrawable) {
                        fastBitmapDrawableState = ((FastBitmapDrawable) drawable).f15577c;
                    }
                    bubbleTextView.f15388A = null;
                    bubbleTextView.f15407u = true;
                    if (itemInfo instanceof AppInfo) {
                        bubbleTextView.applyFromApplicationInfo((AppInfo) itemInfo);
                    } else if (itemInfo instanceof ShortcutInfo) {
                        bubbleTextView.applyFromShortcutInfo((ShortcutInfo) itemInfo, LauncherAppState.getInstance().f16219b, false);
                        if (itemInfo.f16791t < 9 && itemInfo.container >= 0) {
                            Workspace workspace = bubbleTextView.f15396j.getWorkspace();
                            long j6 = itemInfo.container;
                            workspace.getClass();
                            C1748H c1748h = new C1748H();
                            c1748h.f7484j = j6;
                            View viewN0 = workspace.N0(c1748h);
                            if (viewN0 != null) {
                                viewN0.invalidate();
                            }
                        }
                    } else if (itemInfo instanceof C3031f) {
                        bubbleTextView.applyFromPackageItemInfo((C3031f) itemInfo);
                    }
                    Drawable drawable2 = bubbleTextView.mIcon;
                    if (drawable2 instanceof FastBitmapDrawable) {
                        ((FastBitmapDrawable) drawable2).m7684f(fastBitmapDrawableState);
                    }
                    bubbleTextView.f15407u = false;
                }
                break;
            case 6:
                ((Advanceable) ((View) this.f16340k)).advance();
                break;
            case 7:
                ((ClingDismissRunnable) this.f16340k).f16652k.showLongPressCling(false);
                break;
            case 8:
                ModelCallbackRunnable modelCallbackRunnable = (ModelCallbackRunnable) this.f16340k;
                LauncherModelCallbacks callback = modelCallbackRunnable.f16819m.getCallback();
                LauncherModelCallbacks launcherModelCallbacks = modelCallbackRunnable.f16817k;
                if (launcherModelCallbacks == callback && callback != null) {
                    launcherModelCallbacks.bindAppsAdded(null, null, null, modelCallbackRunnable.f16818l);
                    break;
                }
                break;
            case 9:
                ArrayList arrayList = (ArrayList) this.f16340k;
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    ((ItemInfo) obj).mo7673e();
                }
                break;
            case 10:
                Launcher launcher = ((DatabaseHelper) this.f16340k).f15443n;
                if (launcher != null) {
                    launcher.onAppWidgetHostReset();
                }
                break;
            case 11:
                PageIndicator pageIndicator = (PageIndicator) this.f16340k;
                try {
                    ArrayList arrayList2 = pageIndicator.mMarkers;
                    int size2 = arrayList2.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        Object obj2 = arrayList2.get(i7);
                        i7++;
                        PageIndicatorMarker pageIndicatorMarker = (PageIndicatorMarker) obj2;
                        if (pageIndicatorMarker != null) {
                            pageIndicatorMarker.setVisibility(8);
                        }
                    }
                    TextViewCustomFont textViewCustomFont = pageIndicator.f15920x;
                    if (textViewCustomFont != null) {
                        textViewCustomFont.setVisibility(0);
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
                break;
            default:
                ((PagedView) this.f16340k).mo7861W();
                break;
        }
    }
}
