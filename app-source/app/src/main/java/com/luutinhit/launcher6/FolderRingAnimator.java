package com.luutinhit.launcher6;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import com.luutinhit.launcherios.R;

/* JADX INFO: renamed from: com.luutinhit.launcher6.B0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderRingAnimator {

    /* JADX INFO: renamed from: h */
    public static final RectF f15315h = new RectF();

    /* JADX INFO: renamed from: i */
    public static final Paint f15316i = new Paint(1);

    /* JADX INFO: renamed from: j */
    public static int f15317j = -1;

    /* JADX INFO: renamed from: k */
    public static int f15318k = -1;

    /* JADX INFO: renamed from: l */
    public static int f15319l = -1;

    /* JADX INFO: renamed from: a */
    public int f15320a;

    /* JADX INFO: renamed from: b */
    public int f15321b;

    /* JADX INFO: renamed from: c */
    public CellLayout f15322c;

    /* JADX INFO: renamed from: d */
    public float f15323d;

    /* JADX INFO: renamed from: e */
    public FolderIcon f15324e;

    /* JADX INFO: renamed from: f */
    public ValueAnimator f15325f;

    /* JADX INFO: renamed from: g */
    public ValueAnimator f15326g;

    public FolderRingAnimator(Launcher launcher, FolderIcon folderIcon) {
        this.f15324e = folderIcon;
        Resources resources = launcher.getResources();
        if (FolderIcon.f15638G) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("FolderRingAnimator loading drawables on non-UI thread " + Thread.currentThread());
            }
            f15317j = launcher.getDeviceProfile().f15984J;
            int i6 = FolderIcon.f15639H;
            f15318k = i6;
            f15319l = f15317j - (i6 * 6);
            f15316i.setColor(launcher.isDarkMode ? 1493172224 : -2132877602);
            resources.getDimensionPixelSize(R.dimen.icon_round_corner);
            FolderIcon.f15638G = false;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void animateToAcceptState() {
        ValueAnimator valueAnimator = this.f15326g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
        this.f15325f = valueAnimatorM7889c;
        valueAnimatorM7889c.setDuration(100L);
        this.f15325f.addUpdateListener(new SharedAnimatorUpdateListener(5, this));
        this.f15325f.addListener(new FolderRingAnimatorListener(this, 0));
        this.f15325f.start();
    }

    /* JADX INFO: renamed from: b */
    public final void animateToNaturalState() {
        ValueAnimator valueAnimator = this.f15325f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
        this.f15326g = valueAnimatorM7889c;
        valueAnimatorM7889c.setDuration(100L);
        this.f15326g.addUpdateListener(new FolderRingAnimatorUpdateListener(this, f15317j));
        this.f15326g.addListener(new FolderRingAnimatorListener(this, 1));
        this.f15326g.start();
    }
}
