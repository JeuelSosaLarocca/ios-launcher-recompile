package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.V */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceProfile {

    /* JADX INFO: renamed from: A */
    public int f15975A;

    /* JADX INFO: renamed from: B */
    public int f15976B;

    /* JADX INFO: renamed from: C */
    public int f15977C;

    /* JADX INFO: renamed from: D */
    public int f15978D;

    /* JADX INFO: renamed from: E */
    public int f15979E;

    /* JADX INFO: renamed from: F */
    public int f15980F;

    /* JADX INFO: renamed from: G */
    public int f15981G;

    /* JADX INFO: renamed from: H */
    public int f15982H;

    /* JADX INFO: renamed from: I */
    public int f15983I;

    /* JADX INFO: renamed from: J */
    public int f15984J;

    /* JADX INFO: renamed from: K */
    public int f15985K;

    /* JADX INFO: renamed from: L */
    public int f15986L;

    /* JADX INFO: renamed from: M */
    public int f15987M;

    /* JADX INFO: renamed from: N */
    public boolean f15988N;

    /* JADX INFO: renamed from: O */
    public int f15989O;

    /* JADX INFO: renamed from: P */
    public int f15990P;

    /* JADX INFO: renamed from: Q */
    public int f15991Q;

    /* JADX INFO: renamed from: R */
    public int f15992R;

    /* JADX INFO: renamed from: S */
    public int f15993S;

    /* JADX INFO: renamed from: T */
    public int f15994T;

    /* JADX INFO: renamed from: U */
    public int f15995U;

    /* JADX INFO: renamed from: V */
    public int f15996V = 0;

    /* JADX INFO: renamed from: W */
    public boolean f15997W;

    /* JADX INFO: renamed from: X */
    public int f15998X;

    /* JADX INFO: renamed from: Y */
    public int f15999Y;

    /* JADX INFO: renamed from: Z */
    public int f16000Z;

    /* JADX INFO: renamed from: a */
    public InvariantDeviceProfile inv;

    /* JADX INFO: renamed from: a0 */
    public int f23363a0;

    /* JADX INFO: renamed from: b */
    public boolean f16002b;

    /* JADX INFO: renamed from: b0 */
    public int f23364b0;

    /* JADX INFO: renamed from: c */
    public boolean f16003c;

    /* JADX INFO: renamed from: c0 */
    public int f23365c0;

    /* JADX INFO: renamed from: d */
    public boolean f16004d;

    /* JADX INFO: renamed from: d0 */
    public int f23366d0;

    /* JADX INFO: renamed from: e */
    public boolean f16005e;

    /* JADX INFO: renamed from: e0 */
    public int f23367e0;

    /* JADX INFO: renamed from: f */
    public boolean f16006f;

    /* JADX INFO: renamed from: f0 */
    public int f23368f0;

    /* JADX INFO: renamed from: g */
    public boolean f16007g;

    /* JADX INFO: renamed from: g0 */
    public int f23369g0;

    /* JADX INFO: renamed from: h */
    public float f16008h;

    /* JADX INFO: renamed from: h0 */
    public int searchBarSpaceHeightPx;

    /* JADX INFO: renamed from: i */
    public int f16009i;

    /* JADX INFO: renamed from: i0 */
    public int f23371i0;

    /* JADX INFO: renamed from: j */
    public int f16010j;

    /* JADX INFO: renamed from: j0 */
    public int f23372j0;

    /* JADX INFO: renamed from: k */
    public int f16011k;

    /* JADX INFO: renamed from: l */
    public int f16012l;

    /* JADX INFO: renamed from: m */
    public int f16013m;

    /* JADX INFO: renamed from: n */
    public int overviewModeMinIconZoneHeightPx;

    /* JADX INFO: renamed from: o */
    public int overviewModeMaxIconZoneHeightPx;

    /* JADX INFO: renamed from: p */
    public int overviewModeBarItemWidthPx;

    /* JADX INFO: renamed from: q */
    public int overviewModeBarSpacerWidthPx;

    /* JADX INFO: renamed from: r */
    public float overviewModeIconZoneRatio;

    /* JADX INFO: renamed from: s */
    public int f16019s;

    /* JADX INFO: renamed from: t */
    public int f16020t;

    /* JADX INFO: renamed from: u */
    public Rect f16021u;

    /* JADX INFO: renamed from: v */
    public int f16022v;

    /* JADX INFO: renamed from: w */
    public int defaultPageSpacingPx;

    /* JADX INFO: renamed from: x */
    public int f16024x;

    /* JADX INFO: renamed from: y */
    public int f16025y;

    /* JADX INFO: renamed from: z */
    public int f16026z;

    /* JADX WARN: Code duplicated, block: B:9:0x0038  */
    public DeviceProfile(Context context, InvariantDeviceProfile invariantDeviceProfile, Point point, Point point2, int i6, int i7, boolean z5) {
        boolean z6;
        float f6;
        float f7;
        int dimensionPixelSize = 0;
        boolean z7 = false;
        this.f16007g = false;
        this.f15997W = false;
        this.inv = invariantDeviceProfile;
        this.f16005e = z5;
        if (z5) {
            z6 = false;
        } else {
            float f8 = i6;
            float f9 = i7;
            invariantDeviceProfile.getClass();
            if (f9 / f8 > 1.85f || f8 / f9 > 1.85f) {
                z6 = true;
            } else {
                z6 = false;
            }
        }
        this.f16006f = z6;
        if (i6 > i7) {
            f6 = i6;
            f7 = i7;
        } else {
            f6 = i7;
            f7 = i6;
        }
        this.f16008h = f6 / f7;
        invariantDeviceProfile.getClass();
        try {
            Resources resources = invariantDeviceProfile.f16730v.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        } catch (Throwable unused) {
        }
        this.f16009i = dimensionPixelSize;
        Resources resources2 = context.getResources();
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        boolean z8 = resources2.getBoolean(R.bool.is_tablet);
        this.f16002b = z8;
        boolean z9 = resources2.getBoolean(R.bool.is_large_tablet);
        this.f16003c = z9;
        this.f16004d = (z8 || z9) ? false : true;
        this.f15988N = this.inv.f16734z.m131a("marginHotseat");
        this.f15997W = this.inv.f16734z.m131a("iphone_8_style");
        try {
            int identifier2 = resources2.getIdentifier("config_navBarInteractionMode", "integer", "android");
            z7 = identifier2 > 0 && resources2.getInteger(identifier2) == 2;
        } catch (Throwable th) {
            th.getMessage();
        }
        this.f16007g = z7;
        int identifier3 = context.getResources().getIdentifier("navigation_bar_gesture_height", "dimen", "android");
        if (identifier3 != 0) {
            context.getResources().getDimensionPixelSize(identifier3);
        } else {
            float f10 = context.getResources().getDisplayMetrics().density;
        }
        resources2.getBoolean(R.bool.hotseat_transpose_layout_with_orientation);
        this.f16021u = AppWidgetHostView.getDefaultPaddingForWidget(context, new ComponentName(context.getPackageName(), DeviceProfile.class.getName()), null);
        int dimensionPixelSize2 = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_edge_margin);
        this.f16020t = dimensionPixelSize2;
        this.f16019s = dimensionPixelSize2 * 2;
        this.f16022v = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_margin) + resources2.getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_height);
        this.defaultPageSpacingPx = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_workspace_page_spacing);
        this.overviewModeMinIconZoneHeightPx = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_overview_min_icon_zone_height);
        this.overviewModeMaxIconZoneHeightPx = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_overview_max_icon_zone_height);
        this.overviewModeBarItemWidthPx = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_overview_bar_item_width);
        this.overviewModeBarSpacerWidthPx = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_overview_bar_spacer_width);
        this.overviewModeIconZoneRatio = resources2.getInteger(R.integer.config_dynamic_grid_overview_icon_zone_percentage) / 100.0f;
        int dimensionPixelSize3 = resources2.getDimensionPixelSize(R.dimen.dynamic_grid_icon_drawable_padding);
        float f11 = invariantDeviceProfile.f16715g;
        Rect rect = Utilities.sOldBounds;
        this.f15998X = Math.round(TypedValue.applyDimension(1, f11, displayMetrics));
        this.f16010j = i6;
        this.f16011k = i7;
        if (z5) {
            this.f16012l = point2.x;
            this.f16013m = point.y;
        } else {
            this.f16012l = point.x;
            this.f16013m = point2.y;
        }
        m7814f(dimensionPixelSize3, resources2);
        float f12 = this.f15983I * this.inv.f16711c;
        Rect rectM7812d = m7812d();
        m7814f(f12 <= ((float) ((this.f16013m - rectM7812d.top) - rectM7812d.bottom)) ? dimensionPixelSize3 : 0, resources2);
        context.getResources().getInteger(R.integer.config_allAppsButtonPaddingPercent);
        context.getResources().getDimensionPixelSize(R.dimen.all_apps_button_scale_down);
    }

    /* JADX INFO: renamed from: a */
    public final int getCurrentHeight() {
        boolean z5 = this.f16005e;
        int i6 = this.f16011k;
        int i7 = this.f16010j;
        return z5 ? Math.min(i7, i6) : Math.max(i7, i6);
    }

    /* JADX INFO: renamed from: b */
    public final int getCurrentWidth() {
        boolean z5 = this.f16005e;
        int i6 = this.f16011k;
        int i7 = this.f16010j;
        return z5 ? Math.max(i7, i6) : Math.min(i7, i6);
    }

    /* JADX INFO: renamed from: c */
    public final Rect getHotseatRect() {
        Rect rect = new Rect();
        int i6 = this.f23363a0 + this.f23366d0 + this.f23369g0 + this.f23372j0;
        boolean z5 = this.f16002b;
        int i7 = this.f16012l;
        if (!z5) {
            Rect rect2 = this.f16021u;
            int i8 = rect2.left;
            int i9 = this.f16019s;
            rect.set(i9 - i8, 0, i7 - (i9 - rect2.right), i6);
            return rect;
        }
        int currentWidth = getCurrentWidth();
        int i10 = this.f16020t;
        int i11 = this.inv.f16712d;
        int i12 = (((currentWidth - (i10 * 2)) - (this.f15982H * i11)) / ((i11 + 1) * 2)) + i10;
        rect.set(i12, 0, i7 - i12, i6);
        return rect;
    }

    /* JADX INFO: renamed from: d */
    public final Rect m7812d() {
        int i6;
        getHotseatRect();
        Rect rect = new Rect();
        boolean z5 = this.f15988N;
        if (!this.f16002b || this.f16005e) {
            int i7 = this.f15995U;
            int i8 = this.f16022v;
            int i9 = i7 + i8 + (z5 ? this.f15989O : 0);
            boolean z6 = this.f16007g;
            if (this.f16006f) {
                i8 = (int) ((((double) this.f16008h) + (z6 ? 2.2d : 2.0d)) * ((double) this.f15977C));
            } else if (!z6) {
                i8 = 0;
            }
            i6 = i8 + i9;
        } else {
            int currentHeight = getCurrentHeight();
            int i10 = this.f15978D;
            int i11 = this.inv.f16711c;
            i6 = this.f15995U + this.f16022v + ((currentHeight - (i10 * i11)) / (i11 + 3)) + (z5 ? this.f15989O : 0);
        }
        rect.set(0, 0, 0, i6);
        return rect;
    }

    /* JADX INFO: renamed from: e */
    public final void m7813e(int i6) {
        if (i6 == 1) {
            this.f15995U = this.f15994T;
            this.f23372j0 = this.f23371i0;
            this.f23369g0 = this.f23368f0;
            this.f23366d0 = this.f16004d ? this.f23364b0 : this.f23365c0;
            return;
        }
        this.f15995U = this.f15993S;
        this.f23372j0 = this.searchBarSpaceHeightPx;
        this.f23369g0 = this.f23367e0;
        this.f23366d0 = this.f23365c0;
    }

    /* JADX INFO: renamed from: f */
    public final void m7814f(int i6, Resources resources) {
        InvariantDeviceProfile invariantDeviceProfile = this.inv;
        this.f15978D = invariantDeviceProfile.f16716h;
        int currentWidth = getCurrentWidth();
        int i7 = this.f15978D;
        int i8 = (currentWidth - (i7 * 4)) / 10;
        this.f15977C = i8;
        int i9 = (i8 * 4) + (i7 * 3);
        this.f16025y = i9;
        this.f16024x = i9;
        this.f15979E = i7 / 5;
        int currentWidth2 = getCurrentWidth() / 15;
        this.f16026z = currentWidth2;
        this.f15975A = currentWidth2 / 3;
        float f6 = this.f15979E;
        Paint paint = new Paint();
        paint.setTypeface(Typeface.createFromAsset(resources.getAssets(), "fonts/SFProTextMedium.otf"));
        paint.setTextSize(f6);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f15980F = (int) ((-fontMetrics.top) + fontMetrics.bottom);
        this.f15981G = i6;
        this.f15992R = this.f15978D;
        this.f15996V = (int) (((double) this.f15977C) / 3.9d);
        this.searchBarSpaceHeightPx = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_height);
        this.f23371i0 = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_height_tall);
        this.f15999Y = resources.getDimensionPixelSize(R.dimen.qsb_internal_padding_top);
        this.f16000Z = resources.getDimensionPixelSize(R.dimen.qsb_internal_padding_bottom);
        this.f23365c0 = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_extra_top_padding);
        this.f23364b0 = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_negative_top_padding_short);
        boolean z5 = this.f16002b;
        if (z5) {
            this.f23363a0 = this.f15999Y;
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_bottom_padding_tablet) + this.f16000Z;
            this.f23367e0 = dimensionPixelSize;
            this.f23368f0 = dimensionPixelSize;
        } else {
            this.f23363a0 = this.f15999Y;
            this.f23367e0 = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_bottom_padding) + this.f16000Z;
            this.f23368f0 = resources.getDimensionPixelSize(R.dimen.dynamic_grid_search_bar_bottom_negative_padding_short) + this.f16000Z;
        }
        resources.getDimensionPixelSize(R.dimen.dragViewScale);
        int i10 = this.f15978D;
        double d6 = (((double) this.f16026z) * 0.8d) + ((double) (this.f15980F + i10));
        int i11 = this.f15996V;
        int i12 = (int) (((double) (i11 * 2)) + d6);
        this.f15993S = i12;
        this.f15994T = (int) d6;
        this.f16022v = (int) (i12 / 3.3f);
        this.f15990P = i10;
        this.f15991Q = i10;
        this.f15989O = this.f15977C - i11;
        this.f15982H = (getCurrentWidth() - (this.f15977C * 2)) / invariantDeviceProfile.f16712d;
        int currentHeight = getCurrentHeight();
        int i13 = this.f16022v;
        int i14 = currentHeight - i13;
        boolean z6 = this.f16007g;
        boolean z7 = this.f16006f;
        int i15 = (((((i14 - ((z7 && z6) ? this.f15989O : 0)) - this.f15995U) - (this.f15988N ? this.f15989O : 0)) - this.f16009i) - ((!invariantDeviceProfile.f16731w || invariantDeviceProfile.f16732x) ? 0 : invariantDeviceProfile.f16733y)) - (z7 ? this.f15977C : 0);
        if (z7) {
            i13 = (int) ((((double) this.f16008h) + (z6 ? 2.2d : 2.0d)) * ((double) this.f15977C));
        } else if (!z6) {
            i13 = 0;
        }
        int i16 = (i15 - i13) / invariantDeviceProfile.f16711c;
        this.f15983I = i16;
        int i17 = this.f15978D;
        this.f15976B = (int) (((double) i17) * 0.45d);
        int i18 = this.f15982H;
        if (z5) {
            i18 = (int) (((double) i18) * 1.2d);
        }
        this.f15985K = i18;
        if (z5) {
            i16 = (int) (((double) i16) * 1.2d);
        }
        this.f15986L = i16;
        this.f15984J = i17;
        float f7 = this.f15979E;
        Rect rect = Utilities.sOldBounds;
        Paint paint2 = new Paint();
        paint2.setTextSize(f7);
        Paint.FontMetrics fontMetrics2 = paint2.getFontMetrics();
        this.f15987M = (this.f15977C * 2) - ((this.f15986L - this.f15984J) - Math.round((-fontMetrics2.top) + fontMetrics2.bottom));
    }
}
