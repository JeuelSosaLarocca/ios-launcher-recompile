package com.luutinhit.launcher6.allapps;

import D3.C0194b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.BaseRecyclerView;
import com.luutinhit.launcher6.BaseRecyclerViewFastScrollBar;
import com.luutinhit.launcher6.BaseRecyclerViewFastScrollPopup;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.LaunchSourceProvider;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import m3.AbstractC2402p;
import m3.C2388b;
import m3.C2393g;
import m3.C2395i;
import m3.C2399m;
import p014P.C0784o;
import p124s0.AbstractC2697K;
import p124s0.AbstractC2705T;

/* JADX INFO: loaded from: classes.dex */
public class AllAppsRecyclerView extends BaseRecyclerView implements LaunchSourceProvider {

    /* JADX INFO: renamed from: a1 */
    public C2399m f23470a1;

    /* JADX INFO: renamed from: b1 */
    public C2388b f23471b1;

    /* JADX INFO: renamed from: c1 */
    public C0784o f23472c1;

    /* JADX INFO: renamed from: d1 */
    public int f23473d1;

    /* JADX INFO: renamed from: e1 */
    public int f23474e1;

    /* JADX INFO: renamed from: f1 */
    public int f23475f1;

    public AllAppsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f23507T0 = 0;
        this.mBackgroundPadding = new Rect();
        this.f23508U0 = getResources().getDisplayMetrics().density * 4.0f;
        Resources resources = getResources();
        BaseRecyclerViewFastScrollBar baseRecyclerViewFastScrollBar = new BaseRecyclerViewFastScrollBar();
        baseRecyclerViewFastScrollBar.f16762f = new Point(-1, -1);
        baseRecyclerViewFastScrollBar.mThumbPath = new Path();
        baseRecyclerViewFastScrollBar.f16778v = new Rect();
        baseRecyclerViewFastScrollBar.f16779w = new Rect();
        baseRecyclerViewFastScrollBar.f16757a = this;
        BaseRecyclerViewFastScrollPopup baseRecyclerViewFastScrollPopup = new BaseRecyclerViewFastScrollPopup();
        baseRecyclerViewFastScrollPopup.f16802a = new Rect();
        baseRecyclerViewFastScrollPopup.f16803b = new Rect();
        new Rect();
        baseRecyclerViewFastScrollPopup.f16806e = new Rect();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.container_fastscroll_popup_size);
        resources.getDrawable(R.drawable.container_fastscroll_popup_bg).setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        Paint paint = new Paint();
        baseRecyclerViewFastScrollPopup.f16805d = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextSize(resources.getDimensionPixelSize(R.dimen.container_fastscroll_popup_text_size));
        baseRecyclerViewFastScrollBar.f16758b = baseRecyclerViewFastScrollPopup;
        Paint paint2 = new Paint();
        baseRecyclerViewFastScrollBar.f16770n = paint2;
        paint2.setColor(-16777216);
        paint2.setAlpha(30);
        int color = resources.getColor(R.color.container_fastscroll_thumb_inactive_color);
        baseRecyclerViewFastScrollBar.f16760d = color;
        baseRecyclerViewFastScrollBar.f16761e = resources.getColor(R.color.container_fastscroll_thumb_active_color);
        Paint paint3 = new Paint();
        baseRecyclerViewFastScrollBar.f16763g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(color);
        paint3.setStyle(Paint.Style.FILL);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.container_fastscroll_thumb_min_width);
        baseRecyclerViewFastScrollBar.f16764h = dimensionPixelSize2;
        baseRecyclerViewFastScrollBar.f16766j = dimensionPixelSize2;
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.container_fastscroll_thumb_max_width);
        baseRecyclerViewFastScrollBar.f16765i = dimensionPixelSize3;
        baseRecyclerViewFastScrollBar.f16767k = resources.getDimensionPixelSize(R.dimen.container_fastscroll_thumb_height);
        baseRecyclerViewFastScrollBar.f16768l = dimensionPixelSize3 - dimensionPixelSize2;
        baseRecyclerViewFastScrollBar.f16772p = resources.getDimensionPixelSize(R.dimen.container_fastscroll_thumb_touch_inset);
        this.f23509V0 = baseRecyclerViewFastScrollBar;
        m3420m(new C0194b(3, this));
        this.f23472c1 = new C0784o();
        Resources resources2 = getResources();
        this.f5435z.add(this);
        baseRecyclerViewFastScrollBar.f16775s = true;
        resources2.getDimensionPixelSize(R.dimen.all_apps_empty_search_bg_top_offset);
    }

    @Override // com.luutinhit.launcher6.LaunchSourceProvider
    /* JADX INFO: renamed from: D */
    public final void mo7690D(View view, Bundle bundle) {
        int iM3386P;
        bundle.putString("container", "all_apps");
        this.f23470a1.getClass();
        if ((view instanceof BubbleTextView) && (iM3386P = RecyclerView.m3386P((BubbleTextView) view)) != -1 && ((C2395i) this.f23470a1.f19663e.get(iM3386P)).f19647b == 2) {
            bundle.putString("sub_container", "prediction");
        } else {
            bundle.putString("sub_container", "a-z");
        }
    }

    @Override // com.luutinhit.launcher6.BaseRecyclerView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        synchronized (canvas) {
            Rect rect = this.mBackgroundPadding;
            canvas.clipRect(rect.left, rect.top, getWidth() - this.mBackgroundPadding.right, getHeight() - this.mBackgroundPadding.bottom);
        }
        super.dispatchDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(AbstractC2697K abstractC2697K) {
        super.setAdapter(abstractC2697K);
        C2388b c2388b = this.f23471b1;
        c2388b.getClass();
        ((C2393g) abstractC2697K).f19630C = c2388b;
    }

    public void setApps(C2399m c2399m) {
        this.f23470a1 = c2399m;
        this.f23471b1 = new C2388b(this, c2399m);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == null || super.verifyDrawable(drawable);
    }

    @Override // com.luutinhit.launcher6.BaseRecyclerView
    public final int w0(int i6) {
        if (getChildCount() == 0 || i6 <= 0) {
            return 0;
        }
        return ((i6 - 1) * this.f23475f1) + this.f23474e1;
    }

    @Override // com.luutinhit.launcher6.BaseRecyclerView
    public final void y0(int i6) {
        boolean zIsEmpty = this.f23470a1.f19663e.isEmpty();
        BaseRecyclerViewFastScrollBar baseRecyclerViewFastScrollBar = this.f23509V0;
        if (zIsEmpty || this.f23473d1 == 0) {
            baseRecyclerViewFastScrollBar.setThumbOffset(-1, -1);
            return;
        }
        C2399m c2399m = this.f23470a1;
        int i7 = c2399m.f19675q;
        C0784o c0784o = this.f23472c1;
        c0784o.f2348a = -1;
        c0784o.f2349b = -1;
        ArrayList arrayList = c2399m.f19663e;
        if (!arrayList.isEmpty() && this.f23473d1 != 0) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                int iM3386P = RecyclerView.m3386P(childAt);
                if (iM3386P != -1) {
                    C2395i c2395i = (C2395i) arrayList.get(iM3386P);
                    if (c2395i.f19647b != 0) {
                        c0784o.f2348a = c2395i.f19651f;
                        getLayoutManager().getClass();
                        c0784o.f2349b = AbstractC2705T.m9722C(childAt);
                        break;
                    }
                }
            }
        }
        if (c0784o.f2348a < 0) {
            baseRecyclerViewFastScrollBar.setThumbOffset(-1, -1);
            return;
        }
        int availableScrollBarHeight = getAvailableScrollBarHeight();
        int iV0 = v0(this.f23470a1.f19675q);
        if (iV0 <= 0) {
            baseRecyclerViewFastScrollBar.setThumbOffset(-1, -1);
            return;
        }
        int iW0 = (w0(c0784o.f2348a) + getPaddingTop()) - c0784o.f2349b;
        Rect rect = this.mBackgroundPadding;
        int i9 = rect.top + ((int) ((iW0 / iV0) * availableScrollBarHeight));
        if (!baseRecyclerViewFastScrollBar.f16774r) {
            int availableScrollBarHeight2 = getAvailableScrollBarHeight();
            int iV1 = v0(i7);
            if (iV1 <= 0) {
                baseRecyclerViewFastScrollBar.setThumbOffset(-1, -1);
                return;
            } else {
                baseRecyclerViewFastScrollBar.setThumbOffset(Utilities.isRtl(getResources()) ? rect.left : (getWidth() - rect.right) - baseRecyclerViewFastScrollBar.f16766j, rect.top + ((int) ((((w0(c0784o.f2348a) + getPaddingTop()) - c0784o.f2349b) / iV1) * availableScrollBarHeight2)));
                return;
            }
        }
        int width = Utilities.isRtl(getResources()) ? rect.left : (getWidth() - rect.right) - baseRecyclerViewFastScrollBar.f16766j;
        if (baseRecyclerViewFastScrollBar.f16773q) {
            baseRecyclerViewFastScrollBar.setThumbOffset(width, (int) baseRecyclerViewFastScrollBar.f16771o);
            return;
        }
        int i10 = baseRecyclerViewFastScrollBar.f16762f.y;
        int i11 = i9 - i10;
        if (i11 * i6 <= 0.0f) {
            baseRecyclerViewFastScrollBar.setThumbOffset(width, i10);
            return;
        }
        int iMax = Math.max(0, Math.min(availableScrollBarHeight, (i6 < 0 ? Math.max((int) ((i6 * i10) / i9), i11) : Math.min((int) (((availableScrollBarHeight - i10) * i6) / (availableScrollBarHeight - i9)), i11)) + i10));
        baseRecyclerViewFastScrollBar.setThumbOffset(width, iMax);
        if (i9 == iMax) {
            baseRecyclerViewFastScrollBar.f16774r = false;
        }
    }

    public void setElevationController(AbstractC2402p abstractC2402p) {
    }
}
