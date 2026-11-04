package com.luutinhit.launcher6;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Z2 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingAppWidgetHostView extends LauncherAppWidgetHostView implements View.OnClickListener {

    /* JADX INFO: renamed from: T */
    public static Resources.Theme f16188T;

    /* JADX INFO: renamed from: F */
    public Rect mRect;

    /* JADX INFO: renamed from: G */
    public View mDefaultView;

    /* JADX INFO: renamed from: H */
    public View.OnClickListener mClickListener;

    /* JADX INFO: renamed from: I */
    public LauncherAppWidgetInfo f16192I;

    /* JADX INFO: renamed from: J */
    public int f16193J;

    /* JADX INFO: renamed from: K */
    public Intent f16194K;

    /* JADX INFO: renamed from: L */
    public boolean f16195L;

    /* JADX INFO: renamed from: M */
    public Launcher f16196M;

    /* JADX INFO: renamed from: N */
    public Bitmap f16197N;

    /* JADX INFO: renamed from: O */
    public Drawable f16198O;

    /* JADX INFO: renamed from: P */
    public Drawable f16199P;

    /* JADX INFO: renamed from: Q */
    public boolean f16200Q;

    /* JADX INFO: renamed from: R */
    public TextPaint f16201R;

    /* JADX INFO: renamed from: S */
    public StaticLayout f16202S;

    public PendingAppWidgetHostView(Launcher launcher, LauncherAppWidgetInfo launcherAppWidgetInfo, boolean z5) {
        super(launcher);
        this.mRect = new Rect();
        this.f16196M = launcher;
        this.f16192I = launcherAppWidgetInfo;
        this.f16193J = launcherAppWidgetInfo.f16570C;
        this.f16194K = new Intent().setComponent(launcherAppWidgetInfo.providerName);
        this.f16195L = z5;
        TextPaint textPaint = new TextPaint();
        this.f16201R = textPaint;
        textPaint.setColor(-1);
        textPaint.setTextSize(TypedValue.applyDimension(0, launcher.getDeviceProfile().f15979E, getResources().getDisplayMetrics()));
        setBackgroundResource(R.drawable.quantum_panel_dark);
        setWillNotDraw(false);
        if (Utilities.f16752m) {
            setElevation(getResources().getDimension(R.dimen.pending_widget_elevation));
        }
    }

    @Override // com.luutinhit.launcher6.LauncherAppWidgetHostView
    /* JADX INFO: renamed from: b */
    public final boolean mo7923b() {
        return this.f16193J != this.f16192I.f16570C;
    }

    /* JADX INFO: renamed from: g */
    public final void applyState() {
        Drawable drawable = this.f16198O;
        if (drawable != null) {
            drawable.setLevel(Math.max(this.f16192I.f16571D, 0));
        }
    }

    @Override // android.appwidget.AppWidgetHostView
    public View getDefaultView() {
        if (this.mDefaultView == null) {
            View viewInflate = this.f16536j.inflate(R.layout.appwidget_not_ready, (ViewGroup) this, false);
            this.mDefaultView = viewInflate;
            viewInflate.setOnClickListener(this);
            applyState();
        }
        return this.mDefaultView;
    }

    /* JADX INFO: renamed from: h */
    public final void updateIcon(IconCache iconCache) {
        LauncherAppWidgetInfo launcherAppWidgetInfo = this.f16192I;
        Bitmap bitmapM8015p = iconCache.m8015p(this.f16194K, launcherAppWidgetInfo.user);
        if (this.f16197N == bitmapM8015p) {
            return;
        }
        this.f16197N = bitmapM8015p;
        Drawable drawable = this.f16198O;
        if (drawable != null) {
            drawable.setCallback(null);
            this.f16198O = null;
        }
        Bitmap bitmap = this.f16197N;
        if (bitmap != null) {
            boolean z5 = this.f16195L;
            Launcher launcher = this.f16196M;
            if (z5) {
                FastBitmapDrawable fastBitmapDrawableCreateIconDrawable = launcher.createIconDrawable(bitmap);
                fastBitmapDrawableCreateIconDrawable.m7684f(FastBitmapDrawableState.DISABLED);
                this.f16198O = fastBitmapDrawableCreateIconDrawable;
                this.f16199P = null;
            } else {
                int i6 = launcherAppWidgetInfo.f16570C;
                if ((i6 & 2) != 0 || (i6 & 4) == 0) {
                    if (f16188T == null) {
                        Resources.Theme themeNewTheme = getResources().newTheme();
                        f16188T = themeNewTheme;
                        themeNewTheme.applyStyle(R.style.PreloadIcon, true);
                    }
                    PreloadIconDrawable preloadIconDrawable = new PreloadIconDrawable(launcher.createIconDrawable(this.f16197N), f16188T);
                    this.f16198O = preloadIconDrawable;
                    preloadIconDrawable.setCallback(this);
                    this.f16199P = null;
                    applyState();
                } else {
                    this.f16198O = new FastBitmapDrawable(launcher, this.f16197N);
                    this.f16199P = getResources().getDrawable(2131231085).mutate();
                    float[] fArr = new float[3];
                    Color.colorToHSV(Utilities.findDominantColorByHue(this.f16197N), fArr);
                    fArr[1] = Math.min(fArr[1], 0.7f);
                    fArr[2] = 1.0f;
                    this.f16199P.setColorFilter(Color.HSVToColor(fArr), PorterDuff.Mode.SRC_IN);
                }
            }
            this.f16200Q = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f16198O == null) {
            return;
        }
        boolean z5 = this.f16200Q;
        Rect rect = this.mRect;
        if (z5) {
            DeviceProfile deviceProfile = this.f16196M.getDeviceProfile();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.pending_widget_min_padding);
            int width = (getWidth() - paddingLeft) - paddingRight;
            int i6 = dimensionPixelSize * 2;
            int i7 = width - i6;
            int height = ((getHeight() - paddingTop) - paddingBottom) - i6;
            if (this.f16199P == null) {
                Drawable drawable = this.f16198O;
                int i8 = drawable instanceof PreloadIconDrawable ? ((PreloadIconDrawable) drawable).f16231f : 0;
                int iMin = Math.min((i8 * 2) + deviceProfile.f15978D, Math.min(i7, height));
                rect.set(0, 0, iMin, iMin);
                rect.inset(i8, i8);
                rect.offsetTo((getWidth() - rect.width()) / 2, (getHeight() - rect.height()) / 2);
                this.f16198O.setBounds(rect);
            } else {
                float fMax = Math.max(0, Math.min(i7, height));
                float f6 = fMax * 1.8f;
                float fMax2 = Math.max(i7, height);
                if (f6 > fMax2) {
                    fMax = fMax2 / 1.8f;
                }
                int iMin2 = (int) Math.min(fMax, deviceProfile.f15978D);
                int height2 = (getHeight() - iMin2) / 2;
                this.f16202S = null;
                if (i7 > 0) {
                    StaticLayout staticLayout = new StaticLayout(getResources().getText(R.string.gadget_setup_text), this.f16201R, i7, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
                    this.f16202S = staticLayout;
                    int height3 = staticLayout.getHeight();
                    if ((iMin2 * 1.8f) + height3 + deviceProfile.f15981G < height) {
                        height2 = (((getHeight() - height3) - deviceProfile.f15981G) - iMin2) / 2;
                    } else {
                        this.f16202S = null;
                    }
                }
                int i9 = height2;
                rect.set(0, 0, iMin2, iMin2);
                rect.offset((getWidth() - iMin2) / 2, i9);
                this.f16198O.setBounds(rect);
                int i10 = paddingLeft + dimensionPixelSize;
                rect.left = i10;
                int i11 = (int) (iMin2 * 0.4f);
                rect.right = i10 + i11;
                int i12 = paddingTop + dimensionPixelSize;
                rect.top = i12;
                rect.bottom = i12 + i11;
                this.f16199P.setBounds(rect);
                if (this.f16202S != null) {
                    rect.left = i10;
                    rect.top = this.f16198O.getBounds().bottom + deviceProfile.f15981G;
                }
            }
            this.f16200Q = false;
        }
        this.f16198O.draw(canvas);
        Drawable drawable2 = this.f16199P;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (this.f16202S != null) {
            canvas.save();
            canvas.translate(rect.left, rect.top);
            this.f16202S.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.luutinhit.launcher6.LauncherAppWidgetHostView, android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f16200Q = true;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void updateAppWidgetSize(Bundle bundle, int i6, int i7, int i8, int i9) {
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f16198O || super.verifyDrawable(drawable);
    }
}
