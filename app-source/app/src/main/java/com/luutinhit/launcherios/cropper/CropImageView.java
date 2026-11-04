package com.luutinhit.launcherios.cropper;

import J0.C0489j;
import O3.AbstractC0744e;
import S3.AbstractC0995f;
import S3.AnimationAnimationListenerC0997h;
import S3.AsyncTaskC0991b;
import S3.AsyncTaskC0993d;
import S3.C0998i;
import S3.C1009t;
import S3.EnumC0999j;
import S3.EnumC1000k;
import S3.EnumC1006q;
import S3.InterfaceC1001l;
import S3.InterfaceC1002m;
import S3.InterfaceC1003n;
import S3.InterfaceC1004o;
import S3.InterfaceC1005p;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.luutinhit.launcherios.R;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CropImageView extends FrameLayout {

    /* JADX INFO: renamed from: S */
    public static final /* synthetic */ int f17458S = 0;

    /* JADX INFO: renamed from: A */
    public boolean f17459A;

    /* JADX INFO: renamed from: B */
    public boolean f17460B;

    /* JADX INFO: renamed from: C */
    public boolean f17461C;

    /* JADX INFO: renamed from: D */
    public boolean f17462D;

    /* JADX INFO: renamed from: E */
    public int f17463E;

    /* JADX INFO: renamed from: F */
    public InterfaceC1005p f17464F;

    /* JADX INFO: renamed from: G */
    public InterfaceC1001l f17465G;

    /* JADX INFO: renamed from: H */
    public Uri f17466H;

    /* JADX INFO: renamed from: I */
    public int f17467I;

    /* JADX INFO: renamed from: J */
    public float f17468J;

    /* JADX INFO: renamed from: K */
    public float f17469K;

    /* JADX INFO: renamed from: L */
    public float f17470L;

    /* JADX INFO: renamed from: M */
    public RectF f17471M;

    /* JADX INFO: renamed from: N */
    public int f17472N;

    /* JADX INFO: renamed from: O */
    public boolean f17473O;

    /* JADX INFO: renamed from: P */
    public Uri f17474P;

    /* JADX INFO: renamed from: Q */
    public WeakReference f17475Q;

    /* JADX INFO: renamed from: R */
    public WeakReference f17476R;

    /* JADX INFO: renamed from: j */
    public ImageView f17477j;

    /* JADX INFO: renamed from: k */
    public CropOverlayView f17478k;

    /* JADX INFO: renamed from: l */
    public Matrix f17479l;

    /* JADX INFO: renamed from: m */
    public Matrix f17480m;

    /* JADX INFO: renamed from: n */
    public ProgressBar f17481n;

    /* JADX INFO: renamed from: o */
    public float[] f17482o;

    /* JADX INFO: renamed from: p */
    public float[] f17483p;

    /* JADX INFO: renamed from: q */
    public AnimationAnimationListenerC0997h f17484q;

    /* JADX INFO: renamed from: r */
    public Bitmap f17485r;

    /* JADX INFO: renamed from: s */
    public int f17486s;

    /* JADX INFO: renamed from: t */
    public int f17487t;

    /* JADX INFO: renamed from: u */
    public boolean f17488u;

    /* JADX INFO: renamed from: v */
    public boolean f17489v;

    /* JADX INFO: renamed from: w */
    public int f17490w;

    /* JADX INFO: renamed from: x */
    public int f17491x;

    /* JADX INFO: renamed from: y */
    public int f17492y;

    /* JADX INFO: renamed from: z */
    public EnumC1006q f17493z;

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bundle bundleExtra;
        this.f17479l = new Matrix();
        this.f17480m = new Matrix();
        this.f17482o = new float[8];
        this.f17483p = new float[8];
        this.f17459A = false;
        this.f17460B = true;
        this.f17461C = true;
        this.f17462D = true;
        this.f17467I = 1;
        this.f17468J = 1.0f;
        C0998i c0998i = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (intent != null && (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) != null) {
            c0998i = (C0998i) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (c0998i == null) {
            c0998i = new C0998i();
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2245i, 0, 0);
                try {
                    c0998i.f2901v = typedArrayObtainStyledAttributes.getBoolean(10, c0998i.f2901v);
                    c0998i.f2902w = typedArrayObtainStyledAttributes.getInteger(0, c0998i.f2902w);
                    c0998i.f2903x = typedArrayObtainStyledAttributes.getInteger(1, c0998i.f2903x);
                    c0998i.f2894o = EnumC1006q.values()[typedArrayObtainStyledAttributes.getInt(26, c0998i.f2894o.ordinal())];
                    c0998i.f2897r = typedArrayObtainStyledAttributes.getBoolean(2, c0998i.f2897r);
                    c0998i.f2898s = typedArrayObtainStyledAttributes.getBoolean(24, c0998i.f2898s);
                    c0998i.f2899t = typedArrayObtainStyledAttributes.getInteger(19, c0998i.f2899t);
                    c0998i.f2889j = EnumC0999j.values()[typedArrayObtainStyledAttributes.getInt(27, c0998i.f2889j.ordinal())];
                    c0998i.f2893n = EnumC1000k.values()[typedArrayObtainStyledAttributes.getInt(13, c0998i.f2893n.ordinal())];
                    c0998i.f2891l = typedArrayObtainStyledAttributes.getDimension(30, c0998i.f2891l);
                    c0998i.f2892m = typedArrayObtainStyledAttributes.getDimension(31, c0998i.f2892m);
                    c0998i.f2900u = typedArrayObtainStyledAttributes.getFloat(16, c0998i.f2900u);
                    c0998i.f2904y = typedArrayObtainStyledAttributes.getDimension(9, c0998i.f2904y);
                    c0998i.f2905z = typedArrayObtainStyledAttributes.getInteger(8, c0998i.f2905z);
                    c0998i.f2863A = typedArrayObtainStyledAttributes.getDimension(7, c0998i.f2863A);
                    c0998i.f2864B = typedArrayObtainStyledAttributes.getDimension(6, c0998i.f2864B);
                    c0998i.f2865C = typedArrayObtainStyledAttributes.getDimension(5, c0998i.f2865C);
                    c0998i.f2866D = typedArrayObtainStyledAttributes.getInteger(4, c0998i.f2866D);
                    c0998i.f2867E = typedArrayObtainStyledAttributes.getDimension(15, c0998i.f2867E);
                    c0998i.f2868F = typedArrayObtainStyledAttributes.getInteger(14, c0998i.f2868F);
                    c0998i.f2869G = typedArrayObtainStyledAttributes.getInteger(3, c0998i.f2869G);
                    c0998i.f2895p = typedArrayObtainStyledAttributes.getBoolean(28, this.f17460B);
                    c0998i.f2896q = typedArrayObtainStyledAttributes.getBoolean(29, this.f17461C);
                    c0998i.f2863A = typedArrayObtainStyledAttributes.getDimension(7, c0998i.f2863A);
                    c0998i.f2870H = (int) typedArrayObtainStyledAttributes.getDimension(23, c0998i.f2870H);
                    c0998i.f2871I = (int) typedArrayObtainStyledAttributes.getDimension(22, c0998i.f2871I);
                    c0998i.f2872J = (int) typedArrayObtainStyledAttributes.getFloat(21, c0998i.f2872J);
                    c0998i.f2873K = (int) typedArrayObtainStyledAttributes.getFloat(20, c0998i.f2873K);
                    c0998i.f2874L = (int) typedArrayObtainStyledAttributes.getFloat(18, c0998i.f2874L);
                    c0998i.f2875M = (int) typedArrayObtainStyledAttributes.getFloat(17, c0998i.f2875M);
                    c0998i.f22195b0 = typedArrayObtainStyledAttributes.getBoolean(11, c0998i.f22195b0);
                    c0998i.f22196c0 = typedArrayObtainStyledAttributes.getBoolean(11, c0998i.f22196c0);
                    this.f17459A = typedArrayObtainStyledAttributes.getBoolean(25, this.f17459A);
                    if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.hasValue(0) && !typedArrayObtainStyledAttributes.hasValue(10)) {
                        c0998i.f2901v = true;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
        c0998i.m2060b();
        this.f17493z = c0998i.f2894o;
        this.f17462D = c0998i.f2897r;
        this.f17463E = c0998i.f2899t;
        this.f17460B = c0998i.f2895p;
        this.f17461C = c0998i.f2896q;
        this.f17488u = c0998i.f22195b0;
        this.f17489v = c0998i.f22196c0;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.crop_image_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ImageView_image);
        this.f17477j = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) viewInflate.findViewById(R.id.CropOverlayView);
        this.f17478k = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new C0489j(21, this));
        cropOverlayView.setInitialAttributeValues(c0998i);
        this.f17481n = (ProgressBar) viewInflate.findViewById(R.id.CropProgressBar);
        m8319g();
    }

    /* JADX INFO: renamed from: a */
    public final void m8313a(float f6, float f7, boolean z5, boolean z6) {
        if (this.f17485r != null) {
            if (f6 <= 0.0f || f7 <= 0.0f) {
                return;
            }
            Matrix matrix = this.f17479l;
            Matrix matrix2 = this.f17480m;
            matrix.invert(matrix2);
            CropOverlayView cropOverlayView = this.f17478k;
            RectF cropWindowRect = cropOverlayView.getCropWindowRect();
            matrix2.mapRect(cropWindowRect);
            matrix.reset();
            matrix.postTranslate((f6 - this.f17485r.getWidth()) / 2.0f, (f7 - this.f17485r.getHeight()) / 2.0f);
            m8316d();
            int i6 = this.f17487t;
            float[] fArr = this.f17482o;
            if (i6 > 0) {
                matrix.postRotate(i6, (AbstractC0995f.m2056o(fArr) + AbstractC0995f.m2057p(fArr)) / 2.0f, (AbstractC0995f.m2058q(fArr) + AbstractC0995f.m2054m(fArr)) / 2.0f);
                m8316d();
            }
            float fMin = Math.min(f6 / (AbstractC0995f.m2057p(fArr) - AbstractC0995f.m2056o(fArr)), f7 / (AbstractC0995f.m2054m(fArr) - AbstractC0995f.m2058q(fArr)));
            EnumC1006q enumC1006q = this.f17493z;
            if (enumC1006q == EnumC1006q.f2912j || ((enumC1006q == EnumC1006q.f2913k && fMin < 1.0f) || (fMin > 1.0f && this.f17462D))) {
                matrix.postScale(fMin, fMin, (AbstractC0995f.m2056o(fArr) + AbstractC0995f.m2057p(fArr)) / 2.0f, (AbstractC0995f.m2058q(fArr) + AbstractC0995f.m2054m(fArr)) / 2.0f);
                m8316d();
            }
            float f8 = this.f17488u ? -this.f17468J : this.f17468J;
            float f9 = this.f17489v ? -this.f17468J : this.f17468J;
            matrix.postScale(f8, f9, (AbstractC0995f.m2056o(fArr) + AbstractC0995f.m2057p(fArr)) / 2.0f, (AbstractC0995f.m2058q(fArr) + AbstractC0995f.m2054m(fArr)) / 2.0f);
            m8316d();
            matrix.mapRect(cropWindowRect);
            if (z5) {
                this.f17469K = f6 > AbstractC0995f.m2057p(fArr) - AbstractC0995f.m2056o(fArr) ? 0.0f : Math.max(Math.min((f6 / 2.0f) - cropWindowRect.centerX(), -AbstractC0995f.m2056o(fArr)), getWidth() - AbstractC0995f.m2057p(fArr)) / f8;
                this.f17470L = f7 <= AbstractC0995f.m2054m(fArr) - AbstractC0995f.m2058q(fArr) ? Math.max(Math.min((f7 / 2.0f) - cropWindowRect.centerY(), -AbstractC0995f.m2058q(fArr)), getHeight() - AbstractC0995f.m2054m(fArr)) / f9 : 0.0f;
            } else {
                this.f17469K = Math.min(Math.max(this.f17469K * f8, -cropWindowRect.left), (-cropWindowRect.right) + f6) / f8;
                this.f17470L = Math.min(Math.max(this.f17470L * f9, -cropWindowRect.top), (-cropWindowRect.bottom) + f7) / f9;
            }
            matrix.postTranslate(this.f17469K * f8, this.f17470L * f9);
            cropWindowRect.offset(this.f17469K * f8, this.f17470L * f9);
            cropOverlayView.setCropWindowRect(cropWindowRect);
            m8316d();
            cropOverlayView.invalidate();
            ImageView imageView = this.f17477j;
            if (z6) {
                AnimationAnimationListenerC0997h animationAnimationListenerC0997h = this.f17484q;
                System.arraycopy(fArr, 0, animationAnimationListenerC0997h.f2855m, 0, 8);
                animationAnimationListenerC0997h.f2857o.set(animationAnimationListenerC0997h.f2853k.getCropWindowRect());
                matrix.getValues(animationAnimationListenerC0997h.f2859q);
                imageView.startAnimation(this.f17484q);
            } else {
                imageView.setImageMatrix(matrix);
            }
            m8321i(false);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m8314b() {
        Bitmap bitmap = this.f17485r;
        if (bitmap != null && (this.f17492y > 0 || this.f17466H != null)) {
            bitmap.recycle();
        }
        this.f17485r = null;
        this.f17492y = 0;
        this.f17466H = null;
        this.f17467I = 1;
        this.f17487t = 0;
        this.f17468J = 1.0f;
        this.f17469K = 0.0f;
        this.f17470L = 0.0f;
        this.f17479l.reset();
        this.f17474P = null;
        this.f17477j.setImageBitmap(null);
        m8318f();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX INFO: renamed from: c */
    public final void m8315c(boolean z5, boolean z6) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        float fMax;
        int width = getWidth();
        int height = getHeight();
        if (this.f17485r == null || width <= 0 || height <= 0) {
            return;
        }
        CropOverlayView cropOverlayView = this.f17478k;
        RectF cropWindowRect = cropOverlayView.getCropWindowRect();
        if (z5) {
            if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > width || cropWindowRect.bottom > height) {
                m8313a(width, height, false, false);
                return;
            }
            return;
        }
        if (this.f17462D || this.f17468J > 1.0f) {
            if (this.f17468J < this.f17463E) {
                float f6 = width;
                if (cropWindowRect.width() < f6 * 0.5f) {
                    float f7 = height;
                    if (cropWindowRect.height() < 0.5f * f7) {
                        fMax = Math.min(this.f17463E, Math.min(f6 / ((cropWindowRect.width() / this.f17468J) / 0.64f), f7 / ((cropWindowRect.height() / this.f17468J) / 0.64f)));
                    } else {
                        fMax = 0.0f;
                    }
                } else {
                    fMax = 0.0f;
                }
            } else {
                fMax = 0.0f;
            }
            if (this.f17468J > 1.0f) {
                float f8 = width;
                if (cropWindowRect.width() > f8 * 0.65f || cropWindowRect.height() > height * 0.65f) {
                    fMax = Math.max(1.0f, Math.min(f8 / ((cropWindowRect.width() / this.f17468J) / 0.51f), height / ((cropWindowRect.height() / this.f17468J) / 0.51f)));
                }
            }
            float f9 = this.f17462D ? fMax : 1.0f;
            if (f9 <= 0.0f || f9 == this.f17468J) {
                return;
            }
            if (z6) {
                if (this.f17484q == null) {
                    this.f17484q = new AnimationAnimationListenerC0997h(this.f17477j, cropOverlayView);
                }
                AnimationAnimationListenerC0997h animationAnimationListenerC0997h = this.f17484q;
                Matrix matrix = this.f17479l;
                animationAnimationListenerC0997h.reset();
                System.arraycopy(this.f17482o, 0, animationAnimationListenerC0997h.f2854l, 0, 8);
                animationAnimationListenerC0997h.f2856n.set(animationAnimationListenerC0997h.f2853k.getCropWindowRect());
                matrix.getValues(animationAnimationListenerC0997h.f2858p);
            }
            this.f17468J = f9;
            m8313a(width, height, true, z6);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8316d() {
        float[] fArr = this.f17482o;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.f17485r.getWidth();
        fArr[3] = 0.0f;
        fArr[4] = this.f17485r.getWidth();
        fArr[5] = this.f17485r.getHeight();
        fArr[6] = 0.0f;
        fArr[7] = this.f17485r.getHeight();
        Matrix matrix = this.f17479l;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.f17483p;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 100.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 100.0f;
        fArr2[5] = 100.0f;
        fArr2[6] = 0.0f;
        fArr2[7] = 100.0f;
        matrix.mapPoints(fArr2);
    }

    /* JADX INFO: renamed from: e */
    public final void m8317e(Bitmap bitmap, int i6, Uri uri, int i7, int i8) {
        Bitmap bitmap2 = this.f17485r;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            ImageView imageView = this.f17477j;
            imageView.clearAnimation();
            m8314b();
            this.f17485r = bitmap;
            imageView.setImageBitmap(bitmap);
            this.f17466H = uri;
            this.f17492y = i6;
            this.f17467I = i7;
            this.f17487t = i8;
            m8313a(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.f17478k;
            if (cropOverlayView != null) {
                cropOverlayView.m8328g();
                m8318f();
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m8318f() {
        CropOverlayView cropOverlayView = this.f17478k;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.f17460B || this.f17485r == null) ? 4 : 0);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m8319g() {
        this.f17481n.setVisibility(this.f17461C && ((this.f17485r == null && this.f17475Q != null) || this.f17476R != null) ? 0 : 4);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        CropOverlayView cropOverlayView = this.f17478k;
        return new Pair<>(Integer.valueOf(cropOverlayView.getAspectRatioX()), Integer.valueOf(cropOverlayView.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.f17478k.getCropWindowRect();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.crop_delete_edge);
        float[] fArr = new float[8];
        float f6 = cropWindowRect.left;
        float f7 = dimensionPixelSize;
        fArr[0] = f6 + f7;
        float f8 = cropWindowRect.top;
        fArr[1] = f8 + f7;
        float f9 = cropWindowRect.right;
        fArr[2] = f9 - f7;
        fArr[3] = f8 + f7;
        fArr[4] = f9 - f7;
        float f10 = cropWindowRect.bottom;
        fArr[5] = f10 - f7;
        fArr[6] = f6 + f7;
        fArr[7] = f10 - f7;
        Matrix matrix = this.f17479l;
        Matrix matrix2 = this.f17480m;
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        for (int i6 = 0; i6 < 8; i6++) {
            fArr[i6] = fArr[i6] * this.f17467I;
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i6 = this.f17467I;
        Bitmap bitmap = this.f17485r;
        if (bitmap == null) {
            return null;
        }
        float[] cropPoints = getCropPoints();
        int width = bitmap.getWidth() * i6;
        int height = bitmap.getHeight() * i6;
        CropOverlayView cropOverlayView = this.f17478k;
        return AbstractC0995f.m2055n(cropPoints, width, height, cropOverlayView.f17497D, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY());
    }

    public EnumC0999j getCropShape() {
        return this.f17478k.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.f17478k;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        Bitmap bitmap;
        if (this.f17485r == null) {
            return null;
        }
        this.f17477j.clearAnimation();
        Uri uri = this.f17466H;
        CropOverlayView cropOverlayView = this.f17478k;
        if (uri == null || this.f17467I <= 1) {
            bitmap = AbstractC0995f.m2047f(this.f17485r, getCropPoints(), this.f17487t, cropOverlayView.f17497D, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), this.f17488u, this.f17489v).f2835a;
        } else {
            bitmap = AbstractC0995f.m2045d(getContext(), this.f17466H, getCropPoints(), this.f17487t, this.f17485r.getWidth() * this.f17467I, this.f17485r.getHeight() * this.f17467I, cropOverlayView.f17497D, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), 0, 0, this.f17488u, this.f17489v).f2835a;
        }
        return AbstractC0995f.m2059r(bitmap, 0, 0, 1);
    }

    public void getCroppedImageAsync() {
        if (this.f17465G == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        m8320h(0, 0, 1, null, null, 0);
    }

    public EnumC1000k getGuidelines() {
        return this.f17478k.getGuidelines();
    }

    public int getImageResource() {
        return this.f17492y;
    }

    public Uri getImageUri() {
        return this.f17466H;
    }

    public int getMaxZoom() {
        return this.f17463E;
    }

    public int getRotatedDegrees() {
        return this.f17487t;
    }

    public EnumC1006q getScaleType() {
        return this.f17493z;
    }

    public Rect getWholeImageRect() {
        int i6 = this.f17467I;
        Bitmap bitmap = this.f17485r;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i6, bitmap.getHeight() * i6);
    }

    /* JADX INFO: renamed from: h */
    public final void m8320h(int i6, int i7, int i8, Uri uri, Bitmap.CompressFormat compressFormat, int i9) {
        Bitmap bitmap = this.f17485r;
        if (bitmap != null) {
            this.f17477j.clearAnimation();
            WeakReference weakReference = this.f17476R;
            AsyncTaskC0991b asyncTaskC0991b = weakReference != null ? (AsyncTaskC0991b) weakReference.get() : null;
            if (asyncTaskC0991b != null) {
                asyncTaskC0991b.cancel(true);
            }
            int i10 = i8 != 1 ? i6 : 0;
            int i11 = i8 != 1 ? i7 : 0;
            int width = this.f17467I * bitmap.getWidth();
            int height = bitmap.getHeight();
            int i12 = this.f17467I;
            int i13 = height * i12;
            Uri uri2 = this.f17466H;
            CropOverlayView cropOverlayView = this.f17478k;
            if (uri2 == null || (i12 <= 1 && i8 != 2)) {
                this.f17476R = new WeakReference(new AsyncTaskC0991b(this, bitmap, getCropPoints(), this.f17487t, cropOverlayView.f17497D, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), i10, i11, this.f17488u, this.f17489v, i8, uri, compressFormat, i9));
            } else {
                this.f17476R = new WeakReference(new AsyncTaskC0991b(this, this.f17466H, getCropPoints(), this.f17487t, width, i13, cropOverlayView.f17497D, cropOverlayView.getAspectRatioX(), cropOverlayView.getAspectRatioY(), i10, i11, this.f17488u, this.f17489v, i8, uri, compressFormat, i9));
            }
            ((AsyncTaskC0991b) this.f17476R.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m8319g();
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m8321i(boolean z5) {
        Bitmap bitmap = this.f17485r;
        CropOverlayView cropOverlayView = this.f17478k;
        if (bitmap != null && !z5) {
            float f6 = this.f17467I * 100.0f;
            float[] fArr = this.f17483p;
            float fM2057p = f6 / (AbstractC0995f.m2057p(fArr) - AbstractC0995f.m2056o(fArr));
            float fM2054m = (this.f17467I * 100.0f) / (AbstractC0995f.m2054m(fArr) - AbstractC0995f.m2058q(fArr));
            float width = getWidth();
            float height = getHeight();
            C1009t c1009t = cropOverlayView.f17508l;
            c1009t.f2920e = width;
            c1009t.f2921f = height;
            c1009t.f2926k = fM2057p;
            c1009t.f2927l = fM2054m;
        }
        cropOverlayView.m8329h(z5 ? null : this.f17482o, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (this.f17490w <= 0 || this.f17491x <= 0) {
            m8321i(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.f17490w;
        layoutParams.height = this.f17491x;
        setLayoutParams(layoutParams);
        if (this.f17485r == null) {
            m8321i(true);
            return;
        }
        float f6 = i8 - i6;
        float f7 = i9 - i7;
        m8313a(f6, f7, true, false);
        if (this.f17471M == null) {
            if (this.f17473O) {
                this.f17473O = false;
                m8315c(false, false);
                return;
            }
            return;
        }
        int i10 = this.f17472N;
        if (i10 != this.f17486s) {
            this.f17487t = i10;
            m8313a(f6, f7, true, false);
        }
        this.f17479l.mapRect(this.f17471M);
        RectF rectF = this.f17471M;
        CropOverlayView cropOverlayView = this.f17478k;
        cropOverlayView.setCropWindowRect(rectF);
        m8315c(false, false);
        RectF cropWindowRect = cropOverlayView.getCropWindowRect();
        cropOverlayView.m8326d(cropWindowRect);
        cropOverlayView.f17508l.f2916a.set(cropWindowRect);
        this.f17471M = null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i6, int i7) {
        int width;
        int height;
        super.onMeasure(i6, i7);
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        Bitmap bitmap = this.f17485r;
        if (bitmap == null) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (size2 == 0) {
            size2 = bitmap.getHeight();
        }
        double width2 = size < this.f17485r.getWidth() ? ((double) size) / ((double) this.f17485r.getWidth()) : Double.POSITIVE_INFINITY;
        double height2 = size2 < this.f17485r.getHeight() ? ((double) size2) / ((double) this.f17485r.getHeight()) : Double.POSITIVE_INFINITY;
        if (width2 == Double.POSITIVE_INFINITY && height2 == Double.POSITIVE_INFINITY) {
            width = this.f17485r.getWidth();
            height = this.f17485r.getHeight();
        } else if (width2 <= height2) {
            height = (int) (((double) this.f17485r.getHeight()) * width2);
            width = size;
        } else {
            width = (int) (((double) this.f17485r.getWidth()) * height2);
            height = size2;
        }
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(width, size) : width;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(height, size2) : height;
        }
        this.f17490w = size;
        this.f17491x = size2;
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005e  */
    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        CropImageView cropImageView;
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        if (this.f17475Q == null && this.f17466H == null && this.f17485r == null && this.f17492y == 0) {
            Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
            if (uri != null) {
                String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                if (string == null) {
                    cropImageView = this;
                } else {
                    Pair pair = AbstractC0995f.f2843g;
                    Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) AbstractC0995f.f2843g.second).get();
                    AbstractC0995f.f2843g = null;
                    if (bitmap == null || bitmap.isRecycled()) {
                        cropImageView = this;
                    } else {
                        cropImageView = this;
                        cropImageView.m8317e(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                    }
                }
                if (cropImageView.f17466H == null) {
                    setImageUriAsync(uri);
                }
            } else {
                cropImageView = this;
                int i6 = bundle.getInt("LOADED_IMAGE_RESOURCE");
                if (i6 > 0) {
                    setImageResource(i6);
                } else {
                    Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                    if (uri2 != null) {
                        setImageUriAsync(uri2);
                    }
                }
            }
            int i7 = bundle.getInt("DEGREES_ROTATED");
            cropImageView.f17472N = i7;
            cropImageView.f17487t = i7;
            Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
            CropOverlayView cropOverlayView = cropImageView.f17478k;
            if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                cropOverlayView.setInitialCropWindowRect(rect);
            }
            RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
            if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                cropImageView.f17471M = rectF;
            }
            cropOverlayView.setCropShape(EnumC0999j.valueOf(bundle.getString("CROP_SHAPE")));
            cropImageView.f17462D = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
            cropImageView.f17463E = bundle.getInt("CROP_MAX_ZOOM");
            cropImageView.f17488u = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
            cropImageView.f17489v = bundle.getBoolean("CROP_FLIP_VERTICALLY");
        }
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState(){
        AsyncTaskC0993d asyncTaskC0993d;
        OutputStream outputStreamOpenOutputStream;
        boolean z5 = true;
        if (this.f17466H == null && this.f17485r == null && this.f17492y < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.f17466H;
        if (this.f17459A && uri == null && this.f17492y < 1) {
            Context context = getContext();
            Bitmap bitmap = this.f17485r;
            Uri uriFromFile = this.f17474P;
            Rect rect = AbstractC0995f.f2837a;
            try {
                if (uriFromFile == null) {
                    uriFromFile = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
                } else if (new File(uriFromFile.getPath()).exists()) {
                    z5 = false;
                }
                if (z5) {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    try {
                        outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uriFromFile);
                        try {
                            bitmap.compress(compressFormat, 95, outputStreamOpenOutputStream);
                            AbstractC0995f.m2044c(outputStreamOpenOutputStream);
                        } catch (Throwable th) {
                            AbstractC0995f.m2044c(outputStreamOpenOutputStream);
                            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                        }
                    } catch (Throwable th2) {
                        Throwable th = th2;
                        outputStreamOpenOutputStream = null;
                    }
                }
                uri = uriFromFile;
            } catch (Exception unused) {
                uri = null;
            }
            this.f17474P = uri;
        }
        if (uri != null && this.f17485r != null) {
            String string = UUID.randomUUID().toString();
            AbstractC0995f.f2843g = new Pair(string, new WeakReference(this.f17485r));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", string);
        }
        WeakReference weakReference = this.f17475Q;
        if (weakReference != null && (asyncTaskC0993d = (AsyncTaskC0993d) weakReference.get()) != null) {
            bundle.putParcelable("LOADING_IMAGE_URI", asyncTaskC0993d.f2831b);
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f17492y);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.f17467I);
        bundle.putInt("DEGREES_ROTATED", this.f17487t);
        CropOverlayView cropOverlayView = this.f17478k;
        bundle.putParcelable("INITIAL_CROP_RECT", cropOverlayView.getInitialCropWindowRect());
        RectF rectF = AbstractC0995f.f2839c;
        rectF.set(cropOverlayView.getCropWindowRect());
        Matrix matrix = this.f17479l;
        Matrix matrix2 = this.f17480m;
        matrix.invert(matrix2);
        matrix2.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", cropOverlayView.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f17462D);
        bundle.putInt("CROP_MAX_ZOOM", this.f17463E);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f17488u);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f17489v);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        this.f17473O = i8 > 0 && i9 > 0;
    }

    public void setAutoZoomEnabled(boolean z5) {
        if (this.f17462D != z5) {
            this.f17462D = z5;
            m8315c(false, false);
            this.f17478k.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.f17478k.setInitialCropWindowRect(rect);
    }

    public void setCropShape(EnumC0999j enumC0999j) {
        this.f17478k.setCropShape(enumC0999j);
    }

    public void setFixedAspectRatio(boolean z5) {
        this.f17478k.setFixedAspectRatio(z5);
    }

    public void setFlippedHorizontally(boolean z5) {
        if (this.f17488u != z5) {
            this.f17488u = z5;
            m8313a(getWidth(), getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z5) {
        if (this.f17489v != z5) {
            this.f17489v = z5;
            m8313a(getWidth(), getHeight(), true, false);
        }
    }

    public void setGuidelines(EnumC1000k enumC1000k) {
        this.f17478k.setGuidelines(enumC1000k);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f17478k.setInitialCropWindowRect(null);
        m8317e(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i6) {
        if (i6 != 0) {
            this.f17478k.setInitialCropWindowRect(null);
            m8317e(BitmapFactory.decodeResource(getResources(), i6), i6, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference weakReference = this.f17475Q;
            AsyncTaskC0993d asyncTaskC0993d = weakReference != null ? (AsyncTaskC0993d) weakReference.get() : null;
            if (asyncTaskC0993d != null) {
                asyncTaskC0993d.cancel(true);
            }
            m8314b();
            this.f17471M = null;
            this.f17472N = 0;
            this.f17478k.setInitialCropWindowRect(null);
            WeakReference weakReference2 = new WeakReference(new AsyncTaskC0993d(this, uri));
            this.f17475Q = weakReference2;
            ((AsyncTaskC0993d) weakReference2.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m8319g();
        }
    }

    public void setMaxZoom(int i6) {
        if (this.f17463E == i6 || i6 <= 0) {
            return;
        }
        this.f17463E = i6;
        m8315c(false, false);
        this.f17478k.invalidate();
    }

    public void setMultiTouchEnabled(boolean z5) {
        CropOverlayView cropOverlayView = this.f17478k;
        if (cropOverlayView.m8330i(z5)) {
            m8315c(false, false);
            cropOverlayView.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(InterfaceC1001l interfaceC1001l) {
        this.f17465G = interfaceC1001l;
    }

    public void setOnSetImageUriCompleteListener(InterfaceC1005p interfaceC1005p) {
        this.f17464F = interfaceC1005p;
    }

    public void setRotatedDegrees(int i6) {
        int i7 = this.f17487t;
        if (i7 != i6) {
            int i8 = i6 - i7;
            if (this.f17485r != null) {
                int i9 = i8 < 0 ? (i8 % 360) + 360 : i8 % 360;
                CropOverlayView cropOverlayView = this.f17478k;
                boolean z5 = !cropOverlayView.f17497D && ((i9 > 45 && i9 < 135) || (i9 > 215 && i9 < 305));
                RectF rectF = AbstractC0995f.f2839c;
                rectF.set(cropOverlayView.getCropWindowRect());
                float fHeight = (z5 ? rectF.height() : rectF.width()) / 2.0f;
                float fWidth = (z5 ? rectF.width() : rectF.height()) / 2.0f;
                if (z5) {
                    boolean z6 = this.f17488u;
                    this.f17488u = this.f17489v;
                    this.f17489v = z6;
                }
                Matrix matrix = this.f17479l;
                Matrix matrix2 = this.f17480m;
                matrix.invert(matrix2);
                float[] fArr = AbstractC0995f.f2840d;
                fArr[0] = rectF.centerX();
                fArr[1] = rectF.centerY();
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 1.0f;
                fArr[5] = 0.0f;
                matrix2.mapPoints(fArr);
                this.f17487t = (this.f17487t + i9) % 360;
                m8313a(getWidth(), getHeight(), true, false);
                float[] fArr2 = AbstractC0995f.f2841e;
                matrix.mapPoints(fArr2, fArr);
                float fSqrt = (float) (((double) this.f17468J) / Math.sqrt(Math.pow(fArr2[5] - fArr2[3], 2.0d) + Math.pow(fArr2[4] - fArr2[2], 2.0d)));
                this.f17468J = fSqrt;
                this.f17468J = Math.max(fSqrt, 1.0f);
                m8313a(getWidth(), getHeight(), true, false);
                matrix.mapPoints(fArr2, fArr);
                double dSqrt = Math.sqrt(Math.pow(fArr2[5] - fArr2[3], 2.0d) + Math.pow(fArr2[4] - fArr2[2], 2.0d));
                float f6 = (float) (((double) fHeight) * dSqrt);
                float f7 = (float) (((double) fWidth) * dSqrt);
                float f8 = fArr2[0];
                float f9 = fArr2[1];
                rectF.set(f8 - f6, f9 - f7, f8 + f6, f9 + f7);
                cropOverlayView.m8328g();
                cropOverlayView.setCropWindowRect(rectF);
                m8313a(getWidth(), getHeight(), true, false);
                m8315c(false, false);
                RectF cropWindowRect = cropOverlayView.getCropWindowRect();
                cropOverlayView.m8326d(cropWindowRect);
                cropOverlayView.f17508l.f2916a.set(cropWindowRect);
            }
        }
    }

    public void setSaveBitmapToInstanceState(boolean z5) {
        this.f17459A = z5;
    }

    public void setScaleType(EnumC1006q enumC1006q) {
        if (enumC1006q != this.f17493z) {
            this.f17493z = enumC1006q;
            this.f17468J = 1.0f;
            this.f17470L = 0.0f;
            this.f17469K = 0.0f;
            this.f17478k.m8328g();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z5) {
        if (this.f17460B != z5) {
            this.f17460B = z5;
            m8318f();
        }
    }

    public void setShowProgressBar(boolean z5) {
        if (this.f17461C != z5) {
            this.f17461C = z5;
            m8319g();
        }
    }

    public void setSnapRadius(float f6) {
        if (f6 >= 0.0f) {
            this.f17478k.setSnapRadius(f6);
        }
    }

    public void setOnCropWindowChangedListener(InterfaceC1004o interfaceC1004o) {
    }

    public void setOnSetCropOverlayMovedListener(InterfaceC1002m interfaceC1002m) {
    }

    public void setOnSetCropOverlayReleasedListener(InterfaceC1003n interfaceC1003n) {
    }
}
