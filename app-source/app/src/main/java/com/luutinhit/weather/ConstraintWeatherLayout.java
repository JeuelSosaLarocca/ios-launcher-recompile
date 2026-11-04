package com.luutinhit.weather;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWeatherLayout extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public int f17656j;

    /* JADX INFO: renamed from: k */
    public int f17657k;

    public ConstraintWeatherLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            Point point = new Point();
            if (Utilities.f16754o) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            this.f17656j = point.x;
            this.f17657k = point.y;
        }
    }

    public void setBackground(int i6) {
        try {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), i6);
            if (bitmapDecodeResource != null) {
                int width = bitmapDecodeResource.getWidth();
                bitmapDecodeResource.getHeight();
                int i7 = this.f17656j;
                if (width > i7) {
                    bitmapDecodeResource = Bitmap.createScaledBitmap(bitmapDecodeResource, i7, this.f17657k, true);
                }
                setBackground(new BitmapDrawable(getResources(), bitmapDecodeResource));
            }
        } catch (Throwable unused) {
            setBackgroundResource(R.drawable.weather_background_default);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        ObjectAnimator duration = ObjectAnimator.ofInt(drawable, "alpha", 0, 255).setDuration(600L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }
}
