package com.luutinhit.launcher6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.luutinhit.launcher6.L2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherViewPropertyAnimator extends Animator implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: k */
    public ViewPropertyAnimator f15824k;

    /* JADX INFO: renamed from: l */
    public View f15825l;

    /* JADX INFO: renamed from: m */
    public float f15826m;

    /* JADX INFO: renamed from: n */
    public float f15827n;

    /* JADX INFO: renamed from: o */
    public float f15828o;

    /* JADX INFO: renamed from: p */
    public float f15829p;

    /* JADX INFO: renamed from: q */
    public long mStartDelay;

    /* JADX INFO: renamed from: r */
    public long mDuration;

    /* JADX INFO: renamed from: s */
    public TimeInterpolator f15832s;

    /* JADX INFO: renamed from: v */
    public FirstFrameAnimatorHelper f15835v;

    /* JADX INFO: renamed from: j */
    public EnumSet mPropertiesToSet = EnumSet.noneOf(ViewPropertyAnimatorProperty.class);

    /* JADX INFO: renamed from: t */
    public ArrayList mListeners = new ArrayList();

    /* JADX INFO: renamed from: u */
    public boolean mRunning = false;

    public LauncherViewPropertyAnimator(View view) {
        this.f15825l = view;
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener animatorListener) {
        this.mListeners.add(animatorListener);
    }

    @Override // android.animation.Animator
    public final void cancel() {
        ViewPropertyAnimator viewPropertyAnimator = this.f15824k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // android.animation.Animator
    public final Animator clone() {
        return super.clone();
    }

    @Override // android.animation.Animator
    public final long getDuration() {
        return this.mDuration;
    }

    @Override // android.animation.Animator
    public final ArrayList getListeners() {
        return this.mListeners;
    }

    @Override // android.animation.Animator
    public final long getStartDelay() {
        return this.mStartDelay;
    }

    @Override // android.animation.Animator
    public final boolean isRunning() {
        return this.mRunning;
    }

    @Override // android.animation.Animator
    public final boolean isStarted() {
        return this.f15824k != null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.mListeners;
            if (i6 >= arrayList.size()) {
                this.mRunning = false;
                return;
            } else {
                ((Animator.AnimatorListener) arrayList.get(i6)).onAnimationCancel(this);
                i6++;
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.mListeners;
            if (i6 >= arrayList.size()) {
                this.mRunning = false;
                return;
            } else {
                ((Animator.AnimatorListener) arrayList.get(i6)).onAnimationEnd(this);
                i6++;
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.mListeners;
            if (i6 >= arrayList.size()) {
                return;
            }
            ((Animator.AnimatorListener) arrayList.get(i6)).onAnimationRepeat(this);
            i6++;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f15835v.onAnimationStart(animator);
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.mListeners;
            if (i6 >= arrayList.size()) {
                this.mRunning = true;
                return;
            } else {
                ((Animator.AnimatorListener) arrayList.get(i6)).onAnimationStart(this);
                i6++;
            }
        }
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        this.mListeners.clear();
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener animatorListener) {
        this.mListeners.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public final Animator setDuration(long j6) {
        this.mPropertiesToSet.add(ViewPropertyAnimatorProperty.f15775q);
        this.mDuration = j6;
        return this;
    }

    @Override // android.animation.Animator
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mPropertiesToSet.add(ViewPropertyAnimatorProperty.f15776r);
        this.f15832s = timeInterpolator;
    }

    @Override // android.animation.Animator
    public final void setStartDelay(long j6) {
        this.mPropertiesToSet.add(ViewPropertyAnimatorProperty.f15774p);
        this.mStartDelay = j6;
    }

    @Override // android.animation.Animator
    public final void setTarget(Object obj) {
        throw new RuntimeException("Not implemented");
    }

    @Override // android.animation.Animator
    public final void setupEndValues() {
    }

    @Override // android.animation.Animator
    public final void setupStartValues() {
    }

    @Override // android.animation.Animator
    public final void start() {
        View view = this.f15825l;
        this.f15824k = view.animate();
        ViewPropertyAnimator viewPropertyAnimator = this.f15824k;
        FirstFrameAnimatorHelper firstFrameAnimatorHelper = new FirstFrameAnimatorHelper();
        firstFrameAnimatorHelper.f16706l = -1L;
        firstFrameAnimatorHelper.f16704j = view;
        viewPropertyAnimator.setListener(firstFrameAnimatorHelper);
        this.f15835v = firstFrameAnimatorHelper;
        ViewPropertyAnimatorProperty viewPropertyAnimatorProperty = ViewPropertyAnimatorProperty.f15768j;
        EnumSet enumSet = this.mPropertiesToSet;
        if (enumSet.contains(viewPropertyAnimatorProperty)) {
            this.f15824k.translationX(0.0f);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15769k)) {
            this.f15824k.translationY(this.f15826m);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15770l)) {
            this.f15824k.scaleX(this.f15827n);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15772n)) {
            this.f15824k.rotationY(0.0f);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15771m)) {
            this.f15824k.scaleY(this.f15828o);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15773o)) {
            this.f15824k.alpha(this.f15829p);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15774p)) {
            this.f15824k.setStartDelay(this.mStartDelay);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15775q)) {
            this.f15824k.setDuration(this.mDuration);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15776r)) {
            this.f15824k.setInterpolator(this.f15832s);
        }
        if (enumSet.contains(ViewPropertyAnimatorProperty.f15777s)) {
            this.f15824k.withLayer();
        }
        this.f15824k.setListener(this);
        this.f15824k.start();
        addListener(LauncherAnimUtils.f16143b);
    }
}
