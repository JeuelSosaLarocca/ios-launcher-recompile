package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.L */
/* JADX INFO: loaded from: classes.dex */
public final class ClickShadowView extends View {

    /* JADX INFO: renamed from: j */
    public float mShadowPadding;

    public ClickShadowView(Context context) {
        super(context);
        new Paint(2).setColor(-16777216);
        this.mShadowPadding = getResources().getDimension(R.dimen.blur_size_click_shadow);
        getResources().getDimension(R.dimen.click_shadow_high_shift);
    }

    public int getExtraSize() {
        return (int) (this.mShadowPadding * 3.0f);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }
}
