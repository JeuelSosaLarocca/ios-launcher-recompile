package com.luutinhit.launcher6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PageIndicatorSpotlight extends PageIndicator {

    /* JADX INFO: renamed from: F */
    public static final /* synthetic */ int f15923F = 0;

    /* JADX INFO: renamed from: A */
    public int f15924A;

    /* JADX INFO: renamed from: B */
    public int f15925B;

    /* JADX INFO: renamed from: C */
    public int f15926C;

    /* JADX INFO: renamed from: D */
    public int f15927D;

    /* JADX INFO: renamed from: E */
    public MergedIdleRunnable f15928E;

    /* JADX INFO: renamed from: z */
    public DotsView f15929z;

    public PageIndicatorSpotlight(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, true);
        this.f15928E = new MergedIdleRunnable(9, this);
        getResources().getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_size);
        getResources().getDimensionPixelSize(R.dimen.dynamic_grid_page_indicator_margin);
        setLayoutTransition(null);
    }

    /* JADX INFO: renamed from: k */
    public static int clampIndex(int i6, int i7) {
        if (i6 < 0) {
            return 0;
        }
        return Math.min(i6, i7);
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: b */
    public final void mo7783b(int i6, PageIndicatorState pageIndicatorState) {
        int i7;
        int iMin = Math.min(this.f15924A, 5);
        int iClampIndex = clampIndex(i6, this.f15924A);
        int i8 = this.f15924A;
        if (i8 > 0 && iClampIndex <= (i7 = this.f15925B)) {
            this.f15925B = i7 + 1;
            this.f15912p++;
        }
        this.f15924A = i8 + 1;
        this.f15925B = clampIndex(this.f15925B, i8);
        this.f15912p = clampIndex(this.f15912p, this.f15924A - 1);
        this.f15926C = getWindowStart(this.f15925B);
        updateIndicator(false);
        if (iMin != Math.min(this.f15924A, 5)) {
            requestLayout();
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: c */
    public final void mo7784c(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        int iMin = Math.min(this.f15924A, 5);
        int size = arrayList.size() + this.f15924A;
        this.f15924A = size;
        this.f15925B = clampIndex(this.f15925B, size - 1);
        this.f15912p = clampIndex(this.f15912p, this.f15924A - 1);
        this.f15926C = getWindowStart(this.f15925B);
        updateIndicator(false);
        if (iMin != Math.min(this.f15924A, 5)) {
            requestLayout();
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: d */
    public final void mo7785d() {
        removeCallbacks(this.f15928E);
        this.f15927D++;
        TextViewCustomFont textViewCustomFont = this.f15920x;
        if (textViewCustomFont != null) {
            textViewCustomFont.animate().cancel();
            this.f15920x.setAlpha(0.0f);
            this.f15920x.setVisibility(8);
        }
        DotsView dotsView = this.f15929z;
        if (dotsView != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = dotsView.animate();
            viewPropertyAnimatorAnimate.cancel();
            viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(180L).start();
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: f */
    public final void mo7787f() {
        int iMin = Math.min(this.f15924A, 5);
        this.f15924A = 0;
        this.f15925B = 0;
        this.f15912p = 0;
        this.f15926C = 0;
        updateIndicator(false);
        if (iMin != 0) {
            requestLayout();
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: g */
    public final void mo7788g(int i6) {
        int i7 = this.f15924A;
        if (i7 == 0) {
            return;
        }
        int iMin = Math.min(i7, 5);
        int iClampIndex = clampIndex(i6, this.f15924A - 1);
        int i8 = this.f15925B;
        if (iClampIndex < i8) {
            this.f15925B = i8 - 1;
            this.f15912p--;
        } else if (iClampIndex == i8 && iClampIndex == this.f15924A - 1) {
            this.f15925B = i8 - 1;
            this.f15912p--;
        }
        int i9 = this.f15924A;
        int i10 = i9 - 1;
        this.f15924A = i10;
        if (i10 == 0) {
            this.f15925B = 0;
            this.f15912p = 0;
            this.f15926C = 0;
        } else {
            this.f15925B = clampIndex(this.f15925B, i9 - 2);
            this.f15912p = clampIndex(this.f15912p, this.f15924A - 1);
            this.f15926C = getWindowStart(this.f15925B);
        }
        updateIndicator(false);
        if (iMin != Math.min(this.f15924A, 5)) {
            requestLayout();
        }
    }

    public int getNoOfPages() {
        return this.f15924A;
    }

    public int getVisibleDotCounts() {
        return 5;
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: h */
    public final void mo7789h() {
        MergedIdleRunnable mergedIdleRunnable = this.f15928E;
        removeCallbacks(mergedIdleRunnable);
        postOnAnimationDelayed(mergedIdleRunnable, 1369L);
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    /* JADX INFO: renamed from: i */
    public final void mo7790i(int i6, PageIndicatorState pageIndicatorState) {
    }

    /* JADX INFO: renamed from: j */
    public final int getWindowStart(int i6) {
        int i7 = this.f15924A;
        if (i7 <= 5) {
            return 0;
        }
        int i8 = i7 - 5;
        if (i6 <= 2) {
            return 0;
        }
        return i6 >= i7 + (-3) ? i8 : clampIndex(i6 - 2, i8);
    }

    /* JADX INFO: renamed from: l */
    public final void updateIndicator(boolean z5) {
        int iMin;
        int iMin2;
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        float[] fArr4;
        float[] fArr5;
        float[] fArr6;
        float[] fArr7;
        float[] fArr8;
        int[] iArr;
        int i6;
        int i7;
        int i8;
        int i9;
        DotsView dotsView = this.f15929z;
        if (dotsView != null) {
            int i10 = this.f15924A;
            int i11 = this.f15925B;
            int i12 = this.f15926C;
            int iMax = Math.max(0, i10);
            if (iMax == 0) {
                iMin = 0;
            } else {
                iMin = i11 < 0 ? 0 : Math.min(i11, iMax - 1);
            }
            if (iMax <= 5) {
                iMin2 = 0;
            } else {
                iMin2 = i12 < 0 ? 0 : Math.min(i12, iMax - 5);
            }
            int i13 = dotsView.f15513v;
            if (iMax == i13 && iMin == dotsView.f15514w && iMin2 == dotsView.f15515x) {
                return;
            }
            if (!z5 || iMax != i13 || iMax <= 0 || iMin == dotsView.f15514w || dotsView.getWidth() <= 0) {
                int visibleDotCount = DotsView.getVisibleDotCount(dotsView.f15515x, dotsView.f15513v);
                dotsView.f15513v = iMax;
                dotsView.f15514w = iMin;
                dotsView.f15515x = iMin2;
                dotsView.updateDotPositions();
                if (visibleDotCount != DotsView.getVisibleDotCount(dotsView.f15515x, dotsView.f15513v)) {
                    dotsView.requestLayout();
                }
                dotsView.invalidate();
                return;
            }
            float animationProgress = dotsView.getAnimationProgress(System.nanoTime());
            int i14 = 0;
            while (true) {
                int i15 = dotsView.f15516y;
                fArr = dotsView.f15511t;
                fArr2 = dotsView.f15505n;
                fArr3 = dotsView.f15509r;
                fArr4 = dotsView.f15507p;
                fArr5 = dotsView.f15512u;
                fArr6 = dotsView.f15510s;
                fArr7 = dotsView.f15508q;
                fArr8 = dotsView.f15506o;
                if (i14 >= i15) {
                    break;
                }
                fArr2[i14] = DotsView.lerp(fArr2[i14], fArr8[i14], animationProgress);
                fArr4[i14] = DotsView.lerp(fArr4[i14], fArr7[i14], animationProgress);
                fArr3[i14] = DotsView.lerp(fArr3[i14], fArr6[i14], animationProgress);
                fArr[i14] = DotsView.lerp(fArr[i14], fArr5[i14], animationProgress);
                i14++;
            }
            dotsView.f15517z = false;
            dotsView.f15493A = 0L;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int i18 = dotsView.f15516y;
                iArr = dotsView.f15504m;
                if (i16 >= i18) {
                    break;
                }
                if (fArr[i16] > 1.0E-4f) {
                    if (i17 != i16) {
                        iArr[i17] = iArr[i16];
                        fArr2[i17] = fArr2[i16];
                        fArr8[i17] = fArr8[i16];
                        fArr4[i17] = fArr4[i16];
                        fArr7[i17] = fArr7[i16];
                        fArr3[i17] = fArr3[i16];
                        fArr6[i17] = fArr6[i16];
                        fArr[i17] = fArr[i16];
                        fArr5[i17] = fArr5[i16];
                    }
                    i17++;
                }
                i16++;
            }
            dotsView.f15516y = i17;
            int i19 = dotsView.f15513v;
            int i20 = dotsView.f15515x;
            int visibleDotCount2 = DotsView.getVisibleDotCount(i20, i19);
            int visibleDotCount3 = DotsView.getVisibleDotCount(iMin2, iMax);
            dotsView.f15513v = iMax;
            dotsView.f15514w = iMin;
            dotsView.f15515x = iMin2;
            int i21 = 0;
            while (true) {
                if (i21 >= dotsView.f15516y) {
                    break;
                }
                int i22 = i21;
                int i23 = iArr[i22];
                int i24 = visibleDotCount2;
                int i25 = i23 - iMin2;
                if (i25 < 0 || i25 >= visibleDotCount3) {
                    i8 = i22;
                    i9 = i24;
                    fArr8[i8] = dotsView.computeDotX(i23 < iMin2 ? -1 : visibleDotCount3, visibleDotCount3);
                    fArr7[i8] = fArr4[i8];
                    fArr6[i8] = fArr3[i8];
                    fArr5[i8] = 0.0f;
                } else {
                    fArr8[i22] = dotsView.computeDotX(i25, visibleDotCount3);
                    i8 = i22;
                    i9 = i24;
                    fArr7[i8] = dotsView.computeDotScale(i23, i25, iMin2, iMin, visibleDotCount3);
                    fArr6[i8] = i23 == iMin ? 1.0f : 0.5019608f;
                    fArr5[i8] = 1.0f;
                }
                i21 = i8 + 1;
                visibleDotCount2 = i9;
            }
            int i26 = visibleDotCount2;
            int i27 = 0;
            while (i27 < visibleDotCount3) {
                int i28 = iMin2 + i27;
                int i29 = iMin2;
                float[] fArr9 = fArr8;
                int i30 = 0;
                while (true) {
                    i6 = dotsView.f15516y;
                    if (i30 >= i6) {
                        i7 = -1;
                        break;
                    }
                    int i31 = i30;
                    if (iArr[i31] == i28) {
                        i7 = i31;
                        break;
                    }
                    i30 = i31 + 1;
                }
                if (i7 >= 0) {
                    iMin2 = i29;
                } else {
                    if (i6 >= 8) {
                        dotsView.updateDotPositions();
                        dotsView.invalidate();
                        return;
                    }
                    dotsView.f15516y = i6 + 1;
                    int i32 = i28 < i20 ? -1 : i26;
                    float f6 = i28 == iMin ? 1.0f : 0.5019608f;
                    iArr[i6] = i28;
                    fArr2[i6] = dotsView.computeDotX(i32, i26);
                    fArr9[i6] = dotsView.computeDotX(i27, visibleDotCount3);
                    fArr4[i6] = 0.0f;
                    iMin2 = i29;
                    fArr7[i6] = dotsView.computeDotScale(i28, i27, iMin2, iMin, visibleDotCount3);
                    fArr6[i6] = f6;
                    fArr3[i6] = f6;
                    fArr[i6] = 0.0f;
                    fArr5[i6] = 1.0f;
                }
                i27++;
                fArr8 = fArr9;
            }
            if (i26 != visibleDotCount3) {
                dotsView.requestLayout();
            }
            dotsView.f15493A = System.nanoTime();
            dotsView.f15517z = true;
            dotsView.postInvalidateOnAnimation();
        }
    }

    @Override // com.luutinhit.launcher6.PageIndicator, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f15929z = (DotsView) findViewById(R.id.page_indicator_dots);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(R.id.tv_search_spotlight);
        this.f15920x = textViewCustomFont;
        boolean z5 = textViewCustomFont != null && textViewCustomFont.getVisibility() == 0;
        DotsView dotsView = this.f15929z;
        if (dotsView != null) {
            dotsView.setAlpha(z5 ? 0.0f : 1.0f);
        }
        TextViewCustomFont textViewCustomFont2 = this.f15920x;
        if (textViewCustomFont2 != null) {
            textViewCustomFont2.setAlpha(z5 ? 1.0f : 0.0f);
        }
        updateIndicator(false);
    }

    @Override // com.luutinhit.launcher6.PageIndicator
    public void setActiveMarker(int i6) {
        int i7;
        int iClampIndex;
        int i8 = this.f15924A;
        if (i8 == 0) {
            this.f15912p = 0;
            this.f15925B = 0;
            updateIndicator(false);
            return;
        }
        int iClampIndex2 = clampIndex(i6, i8 - 1);
        this.f15912p = iClampIndex2;
        if (iClampIndex2 < 0 || iClampIndex2 >= (i7 = this.f15924A)) {
            return;
        }
        this.f15912p = iClampIndex2;
        int i9 = this.f15925B;
        if (iClampIndex2 == i9) {
            return;
        }
        this.f15925B = iClampIndex2;
        int i10 = this.f15926C;
        if (i7 <= 5) {
            iClampIndex = 0;
        } else {
            int i11 = i7 - 5;
            int iClampIndex3 = clampIndex(i10, i11);
            if (Math.abs(iClampIndex2 - i9) > 1) {
                iClampIndex = clampIndex(iClampIndex2 - 2, i11);
            } else {
                int i12 = i9 - iClampIndex3;
                if (iClampIndex2 > i9 && i12 >= 3) {
                    iClampIndex3++;
                } else if (iClampIndex2 < i9 && i12 <= 1) {
                    iClampIndex3--;
                }
                iClampIndex = clampIndex(iClampIndex3, i11);
            }
        }
        this.f15926C = iClampIndex;
        TextViewCustomFont textViewCustomFont = this.f15920x;
        updateIndicator(textViewCustomFont == null || textViewCustomFont.getVisibility() != 0);
    }
}
