package com.luutinhit.launcher6;

import B3.RunnableC0054W;
import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class LauncherRootView extends InsertAbleFrameLayout {

    /* JADX INFO: renamed from: o */
    public static final /* synthetic */ int f15840o = 0;

    /* JADX INFO: renamed from: j */
    public Paint f15841j;

    /* JADX INFO: renamed from: k */
    public boolean f15842k;

    /* JADX INFO: renamed from: l */
    public int f15843l;

    /* JADX INFO: renamed from: m */
    public View f15844m;

    /* JADX INFO: renamed from: n */
    public Launcher f15845n;

    public LauncherRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (context instanceof Launcher) {
            this.f15845n = (Launcher) context;
        }
        Paint paint = new Paint(1);
        this.f15841j = paint;
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0054W(21, this, canvas));
            return;
        }
        if (!this.f15842k) {
            return;
        }
        int width = getWidth();
        synchronized (canvas) {
            try {
                try {
                    canvas.drawRect(width - this.f15843l, 0.0f, width, getHeight(), this.f15841j);
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            } catch (Throwable th2) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        Launcher launcher = this.f15845n;
        if (launcher != null) {
            try {
                if (!launcher.isOnCustomContent()) {
                    launcher.pullDetector.m76c(motionEvent);
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        boolean z5 = rect.right > 0 && (!Utilities.f16748i || ((ActivityManager) getContext().getSystemService(ActivityManager.class)).isLowRamDevice());
        this.f15842k = z5;
        this.f15843l = rect.right;
        setInsets(z5 ? new Rect(0, rect.top, 0, rect.bottom) : rect);
        View view = this.f15844m;
        if (view != null && this.f15842k) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i6 = marginLayoutParams.leftMargin;
            int i7 = rect.left;
            if (i6 != i7 || marginLayoutParams.rightMargin != rect.right) {
                marginLayoutParams.leftMargin = i7;
                marginLayoutParams.rightMargin = rect.right;
                this.f15844m.setLayoutParams(marginLayoutParams);
            }
        }
        return true;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        if (getChildCount() > 0) {
            this.f15844m = getChildAt(0);
        }
        super.onFinishInflate();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        super.setBackground(drawable);
        if (drawable != null) {
            ObjectAnimator duration = ObjectAnimator.ofInt(drawable, "alpha", 0, 255).setDuration(268L);
            duration.setInterpolator(new DecelerateInterpolator());
            duration.start();
        }
    }
}
