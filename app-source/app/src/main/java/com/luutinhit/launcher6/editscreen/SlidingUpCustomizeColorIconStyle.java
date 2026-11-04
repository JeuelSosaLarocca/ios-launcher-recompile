package com.luutinhit.launcher6.editscreen;

import B3.C0056Y;
import B3.ViewOnClickListenerC0065h;
import F3.AbstractC0279f;
import G3.C0368x;
import J3.C0546e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.luutinhit.launcher6.FastBitmapDrawable;
import com.luutinhit.launcher6.Insettable;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.customui.ColorSeekBar;
import p006H.AbstractC0401n;
import p126s3.RunnableC2747f;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpCustomizeColorIconStyle extends AbstractC0279f implements Insettable, RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: e0 */
    public static final /* synthetic */ int f23494e0 = 0;

    /* JADX INFO: renamed from: S */
    public Launcher f16435S;

    /* JADX INFO: renamed from: T */
    public RadioGroup f16436T;

    /* JADX INFO: renamed from: U */
    public AppCompatRadioButton f16437U;

    /* JADX INFO: renamed from: V */
    public ColorSeekBar f16438V;

    /* JADX INFO: renamed from: W */
    public ConstraintLayoutRound f16439W;

    /* JADX INFO: renamed from: a0 */
    public int f23495a0;

    /* JADX INFO: renamed from: b0 */
    public int f23496b0;

    /* JADX INFO: renamed from: c0 */
    public C0056Y f23497c0;

    /* JADX INFO: renamed from: d0 */
    public Rect f23498d0;

    public SlidingUpCustomizeColorIconStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23496b0 = 1;
        this.f23498d0 = new Rect();
        Launcher launcher = (Launcher) context;
        this.f16435S = launcher;
        this.f23497c0 = launcher.getTinyDB();
    }

    public void setTintedCurrentWorkspaceColor(int i6) {
        Launcher launcher = this.f16435S;
        if (launcher.getWorkspace() != null) {
            launcher.getWorkspace().getCurrentCellLayout().getShortcutsAndWidgets().m8049m(i6);
            launcher.getHotseat().getShortcutsAndWidgets().m8049m(i6);
        }
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ void m8029u(SlidingUpCustomizeColorIconStyle slidingUpCustomizeColorIconStyle, Bitmap bitmap, int i6) {
        slidingUpCustomizeColorIconStyle.f23497c0.m136f(i6, "color_tinted_app");
        slidingUpCustomizeColorIconStyle.f23495a0 = i6;
        if (bitmap != null) {
            slidingUpCustomizeColorIconStyle.f16437U.getBackground().setColorFilter(FastBitmapDrawable.m7679b(i6, bitmap));
            slidingUpCustomizeColorIconStyle.f16437U.postInvalidate();
        }
        slidingUpCustomizeColorIconStyle.setTintedCurrentWorkspaceColor(i6);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i6) {
        if (i6 == R.id.icon_tinted_app) {
            if (this.f23496b0 != 2) {
                this.f23496b0 = 2;
                this.f16439W.animate().translationY(0.0f).setDuration(268L).setInterpolator(new DecelerateInterpolator()).start();
                setTintedCurrentWorkspaceColor(this.f23495a0);
            }
        } else if (i6 == R.id.icon_light_app) {
            if (this.f23496b0 != 1) {
                this.f23496b0 = 1;
                postOnAnimation(new RunnableC2747f(this, 0));
            }
        } else if (i6 == R.id.icon_dark_app && this.f23496b0 != 0) {
            this.f23496b0 = 0;
            this.f23495a0 = 0;
            setTintedCurrentWorkspaceColor(0);
        }
        this.f23497c0.m136f(this.f23496b0, "color_icon_style");
    }

    @Override // F3.AbstractC0279f, android.view.View
    public final void onFinishInflate() {
        int i6 = 1;
        super.onFinishInflate();
        int i7 = R.id.icon_tinted_app;
        this.f16437U = (AppCompatRadioButton) findViewById(R.id.icon_tinted_app);
        this.f16438V = (ColorSeekBar) findViewById(R.id.color_seekbar_tinted_app);
        Resources resources = getResources();
        Resources.Theme theme = this.f16435S.getTheme();
        ThreadLocal threadLocal = AbstractC0401n.f1268a;
        Bitmap bitmapM8159k = Utilities.m8159k(resources.getDrawable(R.drawable.new_weather_icon_dark_rounded, theme));
        this.f16436T = (RadioGroup) findViewById(R.id.icon_selected_style);
        this.f16439W = (ConstraintLayoutRound) findViewById(R.id.customize_color_icon_style_content);
        this.f16438V.setOnColorChangeListener(new C0546e(6, this, bitmapM8159k));
        int i8 = this.f23497c0.f137a.getInt("color_icon_style", 1);
        this.f23496b0 = i8;
        RadioGroup radioGroup = this.f16436T;
        if (i8 == 1) {
            i7 = R.id.icon_light_app;
        } else if (i8 == 0) {
            i7 = R.id.icon_dark_app;
        }
        radioGroup.check(i7);
        this.f16436T.setOnCheckedChangeListener(this);
        m737a(new C0368x(i6, this));
        findViewById(R.id.out_side_customize_color_icon_style).setOnClickListener(new ViewOnClickListenerC0065h(11, this));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i6) {
        super.onVisibilityChanged(view, i6);
        if (i6 != 8 || this.f23496b0 == 1) {
            return;
        }
        postOnAnimation(new RunnableC2747f(this, 1));
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.f23498d0;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }
}
