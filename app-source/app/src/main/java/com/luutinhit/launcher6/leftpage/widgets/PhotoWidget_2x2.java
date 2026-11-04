package com.luutinhit.launcher6.leftpage.widgets;

import B3.ViewOnClickListenerC0065h;
import J3.AbstractC0543b;
import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C1416d;
import com.bumptech.glide.C1697k;
import com.bumptech.glide.C1698l;
import com.bumptech.glide.ComponentCallbacks2C1688b;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.util.RoundedImageView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import p099l1.C2310h;
import p099l1.C2326x;

/* JADX INFO: loaded from: classes.dex */
public class PhotoWidget_2x2 extends AbstractC0543b {

    /* JADX INFO: renamed from: r */
    public static int f16696r = -1;

    /* JADX INFO: renamed from: n */
    public int f16697n;

    /* JADX INFO: renamed from: o */
    public RoundedImageView f16698o;

    /* JADX INFO: renamed from: p */
    public int f16699p;

    /* JADX INFO: renamed from: q */
    public boolean f16700q;

    public PhotoWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes;
        this.f16697n = -1;
        this.f16699p = 0;
        this.f16700q = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.picture_app_widget_2x2, (ViewGroup) this, true);
            if (context instanceof Launcher) {
                Launcher launcher = (Launcher) context;
                if (launcher.getDeviceProfile() != null) {
                    this.f16699p = (int) (((double) launcher.getDeviceProfile().f15977C) * 0.68d);
                }
            }
            if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2253q)) == null) {
                return;
            }
            this.f16700q = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception unused) {
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        m8142G(getContext());
    }

    /* JADX INFO: renamed from: G */
    public final void m8142G(Context context) {
        if (this.f16697n == -1 || context == null || this.f16698o == null) {
            return;
        }
        try {
            Set<String> stringSet = context.getSharedPreferences("photo_widget_prefs", 0).getStringSet("selected_photo_uris_" + this.f16697n, null);
            if (stringSet == null || stringSet.isEmpty()) {
                this.f16698o.setTag(null);
                this.f16698o.setImageDrawable(null);
                this.f16698o.setBackgroundResource(R.drawable.sample_photo_widget);
                return;
            }
            ArrayList arrayList = new ArrayList(stringSet);
            String str = (String) this.f16698o.getTag();
            if (arrayList.size() > 1 && str != null) {
                arrayList.remove(str);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            String str2 = (String) arrayList.get(ThreadLocalRandom.current().nextInt(arrayList.size()));
            if (arrayList.size() == 1 && str2.equals(str)) {
                return;
            }
            this.f16698o.setTag(str2);
            C1697k c1697k = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3646b(context).m3757c(context).mo1612q(Uri.parse(str2)).mo1596H(new C2310h(), new C2326x(context.getResources().getDimensionPixelSize(R.dimen.widget_round_corner)))).mo1587k();
            c1697k.m3729Q(new C1698l(1, this.f16698o), c1697k);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            Context context = getContext();
            View viewFindViewById = findViewById(R.id.icon_delete_widget);
            if (viewFindViewById == null || !(context instanceof Launcher)) {
                return;
            }
            Launcher launcher = (Launcher) context;
            if (launcher.getDeviceProfile() != null) {
                int i6 = -launcher.getDeviceProfile().f15975A;
                viewFindViewById.setTranslationX(launcher.isRTL ? -i6 : i6);
                viewFindViewById.setTranslationY(i6);
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(R.id.picture_widget_content);
        this.f16698o = roundedImageView;
        if (roundedImageView != null) {
            roundedImageView.setOnClickListener(new ViewOnClickListenerC0065h(15, this));
        }
        RoundedImageView roundedImageView2 = this.f16698o;
        if (roundedImageView2 == null) {
            return;
        }
        try {
            C1416d c1416d = (C1416d) roundedImageView2.getLayoutParams();
            if (c1416d == null) {
                return;
            }
            if (!this.f16700q) {
                int i6 = this.f16699p;
                c1416d.setMargins(i6, i6, i6, i6);
                return;
            }
            Context context = getContext();
            if (context == null) {
                return;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.widget_margin_top_bottom);
            int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.widget_elevation_shadow);
            int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.widget_margin_start_end);
            this.f16698o.setElevation(dimensionPixelSize2);
            boolean zIsRtl = Utilities.isRtl(getResources());
            int i7 = zIsRtl ? dimensionPixelSize3 : dimensionPixelSize;
            if (zIsRtl) {
                dimensionPixelSize3 = dimensionPixelSize;
            }
            c1416d.setMargins(i7, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i6);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
    }
}
