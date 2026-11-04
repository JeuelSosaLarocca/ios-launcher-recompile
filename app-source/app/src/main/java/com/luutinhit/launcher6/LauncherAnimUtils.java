package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Y1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class LauncherAnimUtils {

    /* JADX INFO: renamed from: a */
    public static final WeakHashMap sAnimators = new WeakHashMap();

    /* JADX INFO: renamed from: b */
    public static final EmptyAnimatorListener f16143b = new EmptyAnimatorListener();

    /* JADX INFO: renamed from: a */
    public static AnimatorSet createAnimatorSet() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(f16143b);
        return animatorSet;
    }

    /* JADX INFO: renamed from: b */
    public static ObjectAnimator ofFloat(View view, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setPropertyName(str);
        objectAnimator.setFloatValues(fArr);
        objectAnimator.addListener(f16143b);
        new FirstFrameAnimatorHelper(objectAnimator, view);
        return objectAnimator;
    }

    /* JADX INFO: renamed from: c */
    public static ValueAnimator m7889c(float... fArr) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(fArr);
        valueAnimator.addListener(f16143b);
        return valueAnimator;
    }

    /* JADX INFO: renamed from: d */
    public static ObjectAnimator ofPropertyValuesHolder(View view, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(view);
        objectAnimator.setValues(propertyValuesHolderArr);
        objectAnimator.addListener(f16143b);
        new FirstFrameAnimatorHelper(objectAnimator, view);
        return objectAnimator;
    }
}
