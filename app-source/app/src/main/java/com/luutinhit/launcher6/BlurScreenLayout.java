package com.luutinhit.launcher6;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.luutinhit.launcher6.util.BadgeTextView;
import com.luutinhit.launcherios.R;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import p118q3.C2615e;

/* JADX INFO: loaded from: classes.dex */
public class BlurScreenLayout extends InsertAbleFrameLayout {

    /* JADX INFO: renamed from: u */
    public static final /* synthetic */ int f15374u = 0;

    /* JADX INFO: renamed from: j */
    public Paint f15375j;

    /* JADX INFO: renamed from: k */
    public Handler f15376k;

    /* JADX INFO: renamed from: l */
    public Handler f15377l;

    /* JADX INFO: renamed from: m */
    public float f15378m;

    /* JADX INFO: renamed from: n */
    public boolean f15379n;

    /* JADX INFO: renamed from: o */
    public int f15380o;

    /* JADX INFO: renamed from: p */
    public View f15381p;

    /* JADX INFO: renamed from: q */
    public Launcher f15382q;

    /* JADX INFO: renamed from: r */
    public BitmapDrawable f15383r;

    /* JADX INFO: renamed from: s */
    public volatile int f15384s;

    /* JADX INFO: renamed from: t */
    public boolean f15385t;

    public BlurScreenLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        // Find the Launcher behind any ContextWrapper. jadx had duplicated the code after this loop
        // into it and lost the `break` for the found case, which made it spin forever.
        Launcher launcher = null;
        while (context instanceof ContextWrapper) {
            if (context instanceof Launcher) {
                launcher = (Launcher) context;
                break;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                break;
            }
            context = baseContext;
        }
        this.f15382q = launcher;
        this.f15377l = new Handler(Looper.getMainLooper());
        this.f15376k = new Handler(LauncherModel.sWorkerThread.getLooper());
        Paint paint = new Paint(1);
        this.f15375j = paint;
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        this.f15378m = 1.0f / Math.max(1, getResources().getInteger(2131427358));
    }

    /* JADX INFO: renamed from: b */
    public static Bitmap copyBitmap(Bitmap bitmap) {
        if (!isUsableBitmap(bitmap)) {
            return null;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null || ((Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) || config == Bitmap.Config.ALPHA_8)) {
                config = Bitmap.Config.ARGB_8888;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static boolean isUsableBitmap(Bitmap bitmap) {
        return bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
    }

    /* JADX INFO: renamed from: f */
    public static Bitmap overlayBitmap(Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmap3 = null;
        if (isUsableBitmap(bitmap)) {
            if (!isUsableBitmap(bitmap2)) {
                return copyBitmap(bitmap);
            }
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            if (width > 0 && height > 0) {
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, width, height), (Paint) null);
                        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                        return bitmapCreateBitmap;
                    } catch (Throwable th) {
                        bitmap3 = bitmapCreateBitmap;
                        th.getMessage();
                        recycleBitmap(bitmap3);
                        return copyBitmap(bitmap2);
                    }
                } catch (Throwable th2) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                }
            }
        } else if (isUsableBitmap(bitmap2)) {
            return copyBitmap(bitmap2);
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: renamed from: l */
    public static void trackBitmap(ArrayList arrayList, Bitmap bitmap) {
        if (bitmap == null || arrayList.contains(bitmap)) {
            return;
        }
        arrayList.add(bitmap);
    }

    /* JADX INFO: renamed from: a */
    public final void captureScreen(DragLayer dragLayer, int i6, int i7, BlurScreenAnimParams blurScreenAnimParams, boolean z5) {
        Bitmap viewBitmap = null;
        if (i6 != this.f15384s) {
            return;
        }
        try {
            if (this.f15382q.getDragController() != null) {
                this.f15382q.getDragController().getClass();
                viewBitmap = DragController.getViewBitmap(dragLayer);
            } else {
                viewBitmap = null;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        if (isUsableBitmap(viewBitmap)) {
            prepareBlurFrames(i6, i7, z5, new MergedItemCallbacks(0, viewBitmap), blurScreenAnimParams);
            return;
        }
        recycleBitmap(viewBitmap);
        View decorView = this.f15382q.getWindow() != null ? this.f15382q.getWindow().getDecorView() : null;
        if (decorView != null && decorView.getWidth() > 0 && decorView.getHeight() > 0) {
            try {
                decorView.setDrawingCacheEnabled(true);
                decorView.buildDrawingCache();
                Bitmap drawingCache = decorView.getDrawingCache();
                if (isUsableBitmap(drawingCache)) {
                    prepareBlurFrames(i6, i7, z5, new MergedItemCallbacks(0, Bitmap.createBitmap(drawingCache)), blurScreenAnimParams);
                    decorView.setDrawingCacheEnabled(false);
                    decorView.destroyDrawingCache();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    th2.getMessage();
                } catch (Throwable th3) {
                    decorView.setDrawingCacheEnabled(false);
                    decorView.destroyDrawingCache();
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
                }
            }
            decorView.setDrawingCacheEnabled(false);
            decorView.destroyDrawingCache();
        }
        this.f15385t = false;
    }

    /* JADX INFO: renamed from: c */
    public final void animateBlurAlpha(final int i6, final boolean z5) {
        runOnMainThread(new Runnable() { // from class: com.luutinhit.launcher6.r
            @Override // java.lang.Runnable
            public final void run() {
                BlurScreenLayout blurScreenLayout = BlurScreenLayout.this;
                Launcher launcher = blurScreenLayout.f15382q;
                if (launcher != null && launcher.isOpeningSearchView() && blurScreenLayout.getBackground() == null) {
                    return;
                }
                blurScreenLayout.f15384s++;
                blurScreenLayout.f15385t = false;
                blurScreenLayout.f15376k.removeCallbacksAndMessages(null);
                blurScreenLayout.animate().cancel();
                blurScreenLayout.animate().alpha(0.0f).setDuration(Math.max(0, i6)).setInterpolator(new DecelerateInterpolator()).withEndAction(new MergedViewRunnable(blurScreenLayout, z5, 1)).start();
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!this.f15379n || this.f15380o <= 0) {
            return;
        }
        canvas.drawRect(Math.max(0, getWidth() - this.f15380o), 0.0f, getWidth(), getHeight(), this.f15375j);
    }

    /* JADX INFO: renamed from: e */
    public final Bitmap loadBlurWallpaper() {
        FileInputStream fileInputStream;
        Bitmap bitmapDecodeStream = null;
        Launcher launcher = this.f15382q;
        try {
            fileInputStream = new FileInputStream(new File(launcher.getDir("image", 0), "blur"));
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    if (launcher != null) {
                        C2615e blurWallpaperProvider = launcher.getBlurWallpaperProvider();
                        blurWallpaperProvider.getClass();
                        Utilities.f16756q.execute(blurWallpaperProvider.f20568r);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    bitmapDecodeStream = null;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                }
            }
        } catch (Throwable th3) {
            Throwable th = th3;
            fileInputStream = null;
        }
        if (isUsableBitmap(bitmapDecodeStream)) {
            return bitmapDecodeStream;
        }
        recycleBitmap(bitmapDecodeStream);
        try {
            return BitmapFactory.decodeResource(getResources(), R.drawable.blur_default);
        } catch (Throwable th4) {
            th4.getMessage();
            return null;
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        boolean z5 = Utilities.f16748i;
        ActivityManager activityManager = z5 ? (ActivityManager) getContext().getSystemService("activity") : null;
        boolean z6 = rect.right > 0 && (!z5 || (activityManager != null && activityManager.isLowRamDevice()));
        this.f15379n = z6;
        this.f15380o = rect.right;
        setInsets(z6 ? new Rect(0, rect.top, 0, rect.bottom) : new Rect(rect));
        View view = this.f15381p;
        if (view != null && this.f15379n) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int i6 = marginLayoutParams.leftMargin;
                int i7 = rect.left;
                if (i6 != i7 || marginLayoutParams.rightMargin != rect.right) {
                    marginLayoutParams.leftMargin = i7;
                    marginLayoutParams.rightMargin = rect.right;
                    this.f15381p.setLayoutParams(marginLayoutParams);
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public final Bitmap createMaskedBitmap(MergedItemCallbacks mergedItemCallbacks, BlurScreenAnimParams blurScreenAnimParams) {
        Launcher launcher = this.f15382q;
        int width = launcher.screenWidth;
        Bitmap bitmap = (Bitmap) mergedItemCallbacks.f17234k;
        if (width <= 0) {
            width = bitmap.getWidth();
        }
        int height = launcher.screenHeight;
        if (height <= 0) {
            height = bitmap.getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, width, height), new Paint(2));
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        float f6 = blurScreenAnimParams.f17014a;
        float f7 = blurScreenAnimParams.f17015b;
        float f8 = blurScreenAnimParams.f17016c;
        RectF rectF = new RectF(f6, f7, f8, blurScreenAnimParams.f17017d);
        float f9 = blurScreenAnimParams.f17018e;
        canvas.drawRoundRect(rectF, f9, f9, paint);
        if (blurScreenAnimParams.f17019f) {
            canvas.drawCircle(f8, f7, blurScreenAnimParams.f17020g, paint);
        }
        paint.setXfermode(null);
        return bitmapCreateBitmap;
    }

    public Bitmap getBlurBitmap() {
        BitmapDrawable bitmapDrawable = this.f15383r;
        if (bitmapDrawable == null) {
            return null;
        }
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (isUsableBitmap(bitmap)) {
            return bitmap;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [com.luutinhit.launcher6.v] */
    /* JADX INFO: renamed from: i */
    public final void startBlurTransition(int i6, ViewGroup viewGroup) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        char c6;
        BlurScreenAnimParams blurScreenAnimParams;
        Bitmap bitmapM8151c;
        Window window;
        BlurScreenAnimParams blurScreenAnimParams2;
        boolean z5;
        Bitmap bitmap;
        BlurScreenAnimParams blurScreenAnimParams3;
        Launcher launcher;
        float f6;
        float f7;
        float f8;
        float f9;
        float dimensionPixelSize;
        float f10;
        boolean z6;
        BlurScreenLayout blurScreenLayout = this;
        if (blurScreenLayout.f15382q == null) {
            return;
        }
        int i7 = blurScreenLayout.f15384s + 1;
        blurScreenLayout.f15384s = i7;
        blurScreenLayout.f15385t = true;
        if (i6 == 2) {
            if (viewGroup == null || (launcher = blurScreenLayout.f15382q) == null) {
                c6 = 1;
                blurScreenAnimParams3 = null;
            } else {
                if (viewGroup instanceof BubbleTextView) {
                    BubbleTextView bubbleTextView = (BubbleTextView) viewGroup;
                    int[] locationIcon = bubbleTextView.getLocationIcon();
                    float f11 = launcher.getDeviceProfile().f15978D;
                    float f12 = (0.1f * f11) / 2.0f;
                    float f13 = locationIcon[0] - f12;
                    float f14 = locationIcon[1] - f12;
                    float f15 = f11 * 1.1f;
                    float f16 = f13 + f15;
                    float f17 = f15 + f14;
                    float dimensionPixelSize2 = blurScreenLayout.getResources().getDimensionPixelSize(R.dimen.icon_round_corner) * 1.1f;
                    BadgeTextView badgeTextView = bubbleTextView.f15411y;
                    z6 = badgeTextView != null && badgeTextView.getVisibility() == 0;
                    f7 = f17;
                    f9 = f14;
                    dimensionPixelSize = dimensionPixelSize2;
                    f10 = f16;
                    f8 = f13;
                    c6 = 1;
                } else {
                    if (viewGroup instanceof LauncherAppWidgetHostView) {
                        LauncherAppWidgetHostView launcherAppWidgetHostView = (LauncherAppWidgetHostView) viewGroup;
                        int[] locationWidget = launcherAppWidgetHostView.getLocationWidget();
                        int width = launcherAppWidgetHostView.getWidth();
                        int height = launcherAppWidgetHostView.getHeight() - launcherAppWidgetHostView.f16546t;
                        c6 = 1;
                        float f18 = width;
                        float f19 = height;
                        float f20 = locationWidget[0] - ((f18 * 0.05f) / 2.0f);
                        float f21 = locationWidget[1] - ((0.05f * f19) / 2.0f);
                        f6 = (f18 * 1.05f) + f20;
                        f7 = (f19 * 1.05f) + f21;
                        f9 = f21;
                        dimensionPixelSize = (width > launcher.getDeviceProfile().f15982H || height > launcher.getDeviceProfile().f15983I) ? blurScreenLayout.getResources().getDimensionPixelSize(R.dimen.widget_round_corner) * 1.05f : blurScreenLayout.getResources().getDimensionPixelSize(R.dimen.icon_round_corner) * 1.1f;
                        f8 = f20;
                    } else {
                        c6 = 1;
                        int[] iArr = new int[2];
                        viewGroup.getLocationOnScreen(iArr);
                        float width2 = viewGroup.getWidth();
                        float height2 = viewGroup.getHeight();
                        float f22 = iArr[0] - ((width2 * 0.05f) / 2.0f);
                        float f23 = iArr[1] - ((0.05f * height2) / 2.0f);
                        f6 = (width2 * 1.05f) + f22;
                        f7 = (height2 * 1.05f) + f23;
                        f8 = f22;
                        f9 = f23;
                        dimensionPixelSize = blurScreenLayout.getResources().getDimensionPixelSize(R.dimen.icon_round_corner) * 1.6f;
                    }
                    f10 = f6;
                    z6 = false;
                }
                blurScreenAnimParams3 = new BlurScreenAnimParams(f8, f9, f10, f7, dimensionPixelSize, z6, z6 ? (blurScreenLayout.getResources().getDimensionPixelSize(R.dimen.icon_badge_size) - 2.0f) * 0.55f : 0.0f);
            }
            blurScreenAnimParams = blurScreenAnimParams3;
        } else {
            c6 = 1;
            blurScreenAnimParams = null;
        }
        boolean z7 = blurScreenLayout.f15382q.isOpeningFolder() && blurScreenLayout.f15382q.showingFloatingMenu;
        DragLayer dragLayer = blurScreenLayout.f15382q.getDragLayer();
        if (dragLayer == null || dragLayer.getWidth() <= 0 || dragLayer.getHeight() <= 0) {
            blurScreenLayout.f15385t = false;
            return;
        }
        if (i7 == blurScreenLayout.f15384s) {
            try {
                bitmapM8151c = Utilities.m8151c(dragLayer);
            } catch (Throwable th) {
                th.getMessage();
                bitmapM8151c = null;
            }
            if (isUsableBitmap(bitmapM8151c)) {
                blurScreenLayout.prepareBlurFrames(i7, i6, z7, new MergedItemCallbacks(0, bitmapM8151c), blurScreenAnimParams);
                return;
            }
            BlurScreenAnimParams blurScreenAnimParams4 = blurScreenAnimParams;
            recycleBitmap(bitmapM8151c);
            if (Build.VERSION.SDK_INT < 26 || (window = blurScreenLayout.f15382q.getWindow()) == null || !dragLayer.isAttachedToWindow()) {
                captureScreen(dragLayer, i7, i6, blurScreenAnimParams4, z7);
                return;
            }
            int width3 = dragLayer.getWidth();
            int height3 = dragLayer.getHeight();
            if (width3 <= 0) {
                blurScreenLayout = this;
            } else if (height3 > 0) {
                try {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, Bitmap.Config.ARGB_8888);
                    int[] iArr2 = new int[2];
                    dragLayer.getLocationInWindow(iArr2);
                    int i8 = iArr2[0];
                    int i9 = iArr2[c6];
                    Rect rect = new Rect(i8, i9, width3 + i8, height3 + i9);
                    try {
                        Handler handler = blurScreenLayout.f15377l;
                        z5 = z7;
                        bitmap = bitmapCreateBitmap;
                        try {
                            BlurScreenAnimTask blurScreenAnimTask = new BlurScreenAnimTask(this, i7, bitmap, i6, z5, blurScreenAnimParams4, dragLayer);
                            blurScreenAnimParams2 = blurScreenAnimParams4;
                            try {
                                PixelCopy.request(window, rect, bitmap, (PixelCopy.OnPixelCopyFinishedListener) new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.luutinhit.launcher6.v
                                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                                    public final void onPixelCopyFinished(int i10) {
                                        blurScreenAnimTask.m8183a(i10 == 0);
                                    }
                                }, handler);
                            } catch (Throwable th2) {
                                try {
                                    th2.getMessage();
                                    blurScreenAnimTask.m8183a(false);
                                } catch (Throwable th3) {
                                    Throwable th = th3;
                                    recycleBitmap(bitmap);
                                    th.getMessage();
                                    captureScreen(dragLayer, i7, i6, blurScreenAnimParams2, z5);
                                }
                            }
                        } catch (Throwable th4) {
                            Throwable th = th4;
                            blurScreenAnimParams2 = blurScreenAnimParams4;
                        }
                    } catch (Throwable th5) {
                        Throwable th = th5;
                        blurScreenAnimParams2 = blurScreenAnimParams4;
                        z5 = z7;
                        bitmap = bitmapCreateBitmap;
                    }
                } catch (Throwable th6) {
                    th6.getMessage();
                    captureScreen(dragLayer, i7, i6, blurScreenAnimParams4, z7);
                }
            }
            blurScreenLayout.captureScreen(dragLayer, i7, i6, blurScreenAnimParams4, z7);
        }
    }

    /* JADX INFO: renamed from: j */
    public final void runOnMainThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.f15377l.post(runnable);
        }
    }

    /* JADX INFO: renamed from: k */
    public final void prepareBlurFrames(final int i6, final int i7, final boolean z5, final MergedItemCallbacks mergedItemCallbacks, final BlurScreenAnimParams blurScreenAnimParams) {
        if (i6 != this.f15384s) {
            recycleBitmap((Bitmap) mergedItemCallbacks.f17234k);
        } else {
            if (this.f15376k.post(new Runnable() { // from class: com.luutinhit.launcher6.t
                /* JADX WARN: Code duplicated, block: B:114:0x010c A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:116:0x0101 A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:75:0x0103  */
                @Override // java.lang.Runnable
                public final void run() {
                    com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
                    Bitmap bitmap;
                    int size;
                    int i8;
                    Bitmap bitmapM8149a;
                    Bitmap bitmap2;
                    Bitmap bitmapLoadBlurWallpaper = null;
                    int i9 = 0;
                    BlurScreenLayout blurScreenLayout = BlurScreenLayout.this;
                    int i10 = i6;
                    MergedItemCallbacks mergedItemCallbacks2 = mergedItemCallbacks;
                    int i11 = i7;
                    boolean z6 = z5;
                    BlurScreenAnimParams blurScreenAnimParams2 = blurScreenAnimParams;
                    int i12 = BlurScreenLayout.f15374u;
                    blurScreenLayout.getClass();
                    ArrayList arrayList = new ArrayList(5);
                    BlurScreenLayout.trackBitmap(arrayList, (Bitmap) mergedItemCallbacks2.f17234k);
                    Bitmap bitmap3 = null;
                    try {
                        if (i10 != blurScreenLayout.f15384s) {
                            int size2 = arrayList.size();
                            int i13 = 0;
                            while (i13 < size2) {
                                Object obj = arrayList.get(i13);
                                i13++;
                                Bitmap bitmap4 = (Bitmap) obj;
                                if (bitmap4 != null) {
                                    BlurScreenLayout.recycleBitmap(bitmap4);
                                }
                            }
                        } else {
                            Bitmap bitmapCreateMaskedBitmap = (Bitmap) mergedItemCallbacks2.f17234k;
                            if (i11 == 2 && blurScreenAnimParams2 != null && !z6) {
                                bitmapCreateMaskedBitmap = blurScreenLayout.createMaskedBitmap(mergedItemCallbacks2, blurScreenAnimParams2);
                                BlurScreenLayout.trackBitmap(arrayList, bitmapCreateMaskedBitmap);
                            }
                            bitmapM8149a = Utilities.m8149a(bitmapCreateMaskedBitmap, i11 == 0 ? 0.05f : blurScreenLayout.f15378m);
                            if (BlurScreenLayout.isUsableBitmap(bitmapM8149a)) {
                                BlurScreenLayout.trackBitmap(arrayList, bitmapM8149a);
                            } else {
                                bitmapM8149a = null;
                            }
                            if (i10 != blurScreenLayout.f15384s) {
                                int size3 = arrayList.size();
                                int i14 = 0;
                                while (i14 < size3) {
                                    Object obj2 = arrayList.get(i14);
                                    i14++;
                                    Bitmap bitmap5 = (Bitmap) obj2;
                                    if (bitmap5 != null) {
                                        BlurScreenLayout.recycleBitmap(bitmap5);
                                    }
                                }
                            } else {
                                try {
                                    if (i11 != 1 && !z6) {
                                        try {
                                            bitmapLoadBlurWallpaper = blurScreenLayout.f15382q.getBlurWallpaperProvider() != null ? blurScreenLayout.f15382q.getBlurWallpaperProvider().f20555e : null;
                                        } catch (Throwable th) {
                                            th.getMessage();
                                        }
                                        if (!BlurScreenLayout.isUsableBitmap(bitmapLoadBlurWallpaper) && (bitmapLoadBlurWallpaper = blurScreenLayout.loadBlurWallpaper()) != null) {
                                            BlurScreenLayout.trackBitmap(arrayList, bitmapLoadBlurWallpaper);
                                        }
                                        if (bitmapLoadBlurWallpaper != null && bitmapM8149a != null) {
                                            bitmapM8149a = BlurScreenLayout.overlayBitmap(bitmapLoadBlurWallpaper, bitmapM8149a);
                                            BlurScreenLayout.trackBitmap(arrayList, bitmapM8149a);
                                        } else if (bitmapM8149a == null) {
                                            if (bitmapLoadBlurWallpaper != null) {
                                                bitmapM8149a = BlurScreenLayout.copyBitmap(bitmapLoadBlurWallpaper);
                                                BlurScreenLayout.trackBitmap(arrayList, bitmapM8149a);
                                            } else {
                                                bitmapM8149a = null;
                                            }
                                        }
                                    }
                                    if (i11 == 2 && blurScreenAnimParams2 != null && BlurScreenLayout.isUsableBitmap(bitmapM8149a)) {
                                        Bitmap bitmapCreateMaskedBitmap2 = blurScreenLayout.createMaskedBitmap(new MergedItemCallbacks(0, bitmapM8149a), blurScreenAnimParams2);
                                        if (BlurScreenLayout.isUsableBitmap(bitmapCreateMaskedBitmap2)) {
                                            BlurScreenLayout.trackBitmap(arrayList, bitmapCreateMaskedBitmap2);
                                            bitmapM8149a = bitmapCreateMaskedBitmap2;
                                        }
                                    }
                                    int size4 = arrayList.size();
                                    int i15 = 0;
                                    while (i15 < size4) {
                                        Object obj3 = arrayList.get(i15);
                                        i15++;
                                        Bitmap bitmap6 = (Bitmap) obj3;
                                        if (bitmap6 != bitmapM8149a) {
                                            BlurScreenLayout.recycleBitmap(bitmap6);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    bitmap = bitmapM8149a;
                                    Throwable th = th2;
                                    try {
                                        th.getMessage();
                                        size = arrayList.size();
                                        i8 = 0;
                                        while (i8 < size) {
                                            Object obj4 = arrayList.get(i8);
                                            i8++;
                                            bitmap2 = (Bitmap) obj4;
                                            if (bitmap2 != bitmap) {
                                                BlurScreenLayout.recycleBitmap(bitmap2);
                                            }
                                        }
                                        bitmapM8149a = bitmap;
                                    } catch (Throwable th3) {
                                        int size5 = arrayList.size();
                                        while (i9 < size5) {
                                            Object obj5 = arrayList.get(i9);
                                            i9++;
                                            Bitmap bitmap7 = (Bitmap) obj5;
                                            if (bitmap7 != bitmap) {
                                                BlurScreenLayout.recycleBitmap(bitmap7);
                                            }
                                        }
                                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
                                    }
                                }
                                if (BlurScreenLayout.isUsableBitmap(bitmapM8149a)) {
                                    bitmap3 = bitmapM8149a;
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        Throwable th = th4;
                        bitmap = null;
                        th.getMessage();
                        size = arrayList.size();
                        i8 = 0;
                        while (i8 < size) {
                            Object obj6 = arrayList.get(i8);
                            i8++;
                            bitmap2 = (Bitmap) obj6;
                            if (bitmap2 != bitmap) {
                                BlurScreenLayout.recycleBitmap(bitmap2);
                            }
                        }
                        bitmapM8149a = bitmap;
                    }
                    blurScreenLayout.f15377l.post(new BlurBitmapRunnable(blurScreenLayout, i10, bitmap3, i9));
                }
            })) {
                return;
            }
            recycleBitmap((Bitmap) mergedItemCallbacks.f17234k);
            this.f15385t = false;
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.f15381p = getChildAt(0);
        }
    }
}
