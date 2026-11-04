package com.luutinhit.launcher6.widget.view;

import J3.AbstractC0543b;
import J3.C0547f;
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
import com.bumptech.glide.ComponentCallbacks2C1688b;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.util.RoundedImageView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import p099l1.C2310h;
import p099l1.C2326x;

/* JADX INFO: loaded from: classes.dex */
public class PictureWidget_2x2 extends AbstractC0543b {

    /* JADX INFO: renamed from: q */
    public static final /* synthetic */ int f17190q = 0;

    /* JADX INFO: renamed from: n */
    public RoundedImageView f17191n;

    /* JADX INFO: renamed from: o */
    public int f17192o;

    /* JADX INFO: renamed from: p */
    public boolean f17193p;

    public PictureWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.picture_app_widget_2x2, (ViewGroup) this, true);
        if (context instanceof Launcher) {
            this.f17192o = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.68d);
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2254r);
            this.f17193p = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        m8245G(getContext());
    }

    /* JADX INFO: renamed from: G */
    public final void m8245G(Context context) {
        Set<String> stringSet = context.getSharedPreferences("photo_widget_prefs", 0).getStringSet("selected_photo_uris", new HashSet());
        if (stringSet == null || stringSet.isEmpty()) {
            this.f17191n.setTag(null);
            this.f17191n.setImageDrawable(null);
            this.f17191n.setBackgroundResource(R.drawable.sample_photo_widget);
            return;
        }
        stringSet.size();
        ArrayList arrayList = new ArrayList(stringSet);
        String str = (String) this.f17191n.getTag();
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
        Uri uri = Uri.parse(str2);
        this.f17191n.setTag(str2);
        C1697k c1697k = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3646b(context).m3757c(context).mo1612q(uri).mo1596H(new C2310h(), new C2326x(context.getResources().getDimensionPixelSize(R.dimen.widget_round_corner)))).mo1587k();
        c1697k.m3729Q(new C0547f(this, this.f17191n), c1697k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        if (viewFindViewById != null && (context instanceof Launcher)) {
            Launcher launcher = (Launcher) context;
            int i6 = -launcher.getDeviceProfile().f15975A;
            viewFindViewById.setTranslationX(launcher.isRTL ? -i6 : i6);
            viewFindViewById.setTranslationY(i6);
        }
        m8245G(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(R.id.picture_widget_content);
        this.f17191n = roundedImageView;
        if (roundedImageView == null) {
            return;
        }
        C1416d c1416d = (C1416d) roundedImageView.getLayoutParams();
        if (!this.f17193p) {
            int i6 = this.f17192o;
            c1416d.setMargins(i6, i6, i6, i6);
            return;
        }
        Context context = getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.widget_margin_top_bottom);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.widget_elevation_shadow);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.widget_margin_start_end);
        this.f17191n.setElevation(dimensionPixelSize2);
        boolean zIsRtl = Utilities.isRtl(getResources());
        int i7 = zIsRtl ? dimensionPixelSize3 : dimensionPixelSize;
        if (zIsRtl) {
            dimensionPixelSize3 = dimensionPixelSize;
        }
        c1416d.setMargins(i7, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
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
