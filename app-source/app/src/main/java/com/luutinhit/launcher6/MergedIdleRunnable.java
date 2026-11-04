package com.luutinhit.launcher6;

import A2.C0022a;
import B3.AbstractC0075r;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.opengl.EGL14;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.view.Surface;
import android.view.WindowManager;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.util.concurrent.CountDownLatch;
import p006H.RunnableC0399l;

/* JADX INFO: renamed from: com.luutinhit.launcher6.B */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MergedIdleRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15313j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Object f15314k;

    public /* synthetic */ MergedIdleRunnable(int i6, Object obj) {
        this.f15313j = i6;
        this.f15314k = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextViewCustomFont textViewCustomFont;
        int iMax;
        int i6 = 1;
        switch (this.f15313j) {
            case 0:
                Paint paint = CellLayout.f23325b0;
                CellLayout cellLayout = (CellLayout) this.f15314k;
                if (cellLayout.isAttachedToWindow()) {
                    cellLayout.mShortcutsAndWidgets.buildLayer();
                }
                break;
            case 1:
                ((Folder) ((C0022a) this.f15314k).f50k).setLayerType(0, null);
                break;
            case 2:
                FolderIcon folderIcon = (FolderIcon) this.f15314k;
                LiquidGlassSurfaceView liquidGlassSurfaceView = folderIcon.f15654o;
                if (liquidGlassSurfaceView == null) {
                    RuntimeShaderGlassView runtimeShaderGlassView = folderIcon.f15655p;
                    if (runtimeShaderGlassView != null) {
                        runtimeShaderGlassView.setFullBitmap(folderIcon.getBlurGlassWallpaper());
                    }
                } else {
                    liquidGlassSurfaceView.setFullBitmap(folderIcon.getBlurGlassWallpaper());
                }
                break;
            case 3:
                GlassSurfaceHolder glassSurfaceHolder = (GlassSurfaceHolder) this.f15314k;
                glassSurfaceHolder.getClass();
                try {
                    if (glassSurfaceHolder.f15861c != EGL14.EGL_NO_SURFACE) {
                        EGL14.eglDestroySurface(EGL14.eglGetDisplay(0), glassSurfaceHolder.f15861c);
                    }
                    break;
                } catch (Throwable unused) {
                }
                glassSurfaceHolder.f15861c = EGL14.EGL_NO_SURFACE;
                Surface surface = glassSurfaceHolder.f15860b;
                if (surface != null) {
                    try {
                        surface.release();
                        break;
                    } catch (Throwable unused2) {
                    }
                    glassSurfaceHolder.f15860b = null;
                }
                break;
            case 4:
                LiquidGlassEglTextureView liquidGlassEglTextureView = (LiquidGlassEglTextureView) this.f15314k;
                liquidGlassEglTextureView.f16178q = liquidGlassEglTextureView.uploadTexture(liquidGlassEglTextureView.f16180s, liquidGlassEglTextureView.f16178q, false);
                liquidGlassEglTextureView.f16165R.set(true);
                liquidGlassEglTextureView.f16166S.set(true);
                break;
            case 5:
                Hotseat hotseat = (Hotseat) this.f15314k;
                LiquidGlassSurfaceView liquidGlassSurfaceView2 = hotseat.f15716v;
                if (liquidGlassSurfaceView2 == null) {
                    RuntimeShaderGlassView runtimeShaderGlassView2 = hotseat.f15717w;
                    if (runtimeShaderGlassView2 != null) {
                        runtimeShaderGlassView2.setFullBitmap(hotseat.getBlurGlassWallpaper());
                    }
                } else {
                    liquidGlassSurfaceView2.setFullBitmap(hotseat.getBlurGlassWallpaper());
                }
                break;
            case 6:
                ((Launcher) ((C0022a) this.f15314k).f50k).appsLibraryLayout.setLayerType(0, null);
                break;
            case 7:
                MessageQueue messageQueueMyQueue = Looper.myQueue();
                CountDownLatch countDownLatch = (CountDownLatch) this.f15314k;
                messageQueueMyQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.luutinhit.launcher6.r2
                    @Override // android.os.MessageQueue.IdleHandler
                    public final boolean queueIdle() {
                        countDownLatch.countDown();
                        return false;
                    }
                });
                break;
            case 8:
                PageIndicator pageIndicator = (PageIndicator) this.f15314k;
                LiquidGlassSurfaceView liquidGlassSurfaceView3 = pageIndicator.f15918v;
                if (liquidGlassSurfaceView3 == null) {
                    RuntimeShaderGlassView runtimeShaderGlassView3 = pageIndicator.f15919w;
                    if (runtimeShaderGlassView3 != null) {
                        runtimeShaderGlassView3.setFullBitmap(pageIndicator.getBlurGlassWallpaper());
                    }
                } else {
                    liquidGlassSurfaceView3.setFullBitmap(pageIndicator.getBlurGlassWallpaper());
                }
                break;
            case 9:
                int i7 = PageIndicatorSpotlight.f15923F;
                PageIndicatorSpotlight pageIndicatorSpotlight = (PageIndicatorSpotlight) this.f15314k;
                TextViewCustomFont textViewCustomFont2 = pageIndicatorSpotlight.f15920x;
                if (textViewCustomFont2 != null) {
                    int i8 = pageIndicatorSpotlight.f15927D + 1;
                    pageIndicatorSpotlight.f15927D = i8;
                    DotsView dotsView = pageIndicatorSpotlight.f15929z;
                    if (dotsView != null) {
                        dotsView.animate().cancel();
                    }
                    if (textViewCustomFont2.getVisibility() == 0) {
                        if (dotsView != null) {
                            dotsView.setAlpha(0.0f);
                        }
                        textViewCustomFont2.setAlpha(1.0f);
                        break;
                    } else {
                        textViewCustomFont2.setAlpha(0.0f);
                        textViewCustomFont2.setVisibility(8);
                        if (dotsView != null) {
                            dotsView.animate().alpha(0.0f).setDuration(180L).withEndAction(new RunnableC0399l(i8, i6, pageIndicatorSpotlight)).start();
                            break;
                        } else if (i8 == pageIndicatorSpotlight.f15927D && (textViewCustomFont = pageIndicatorSpotlight.f15920x) != null) {
                            textViewCustomFont.setAlpha(1.0f);
                            pageIndicatorSpotlight.f15920x.setVisibility(0);
                            break;
                        }
                    }
                }
                break;
            case 10:
                Context context = (Context) this.f15314k;
                try {
                    PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME").setPackage(context.getPackageName()).addFlags(268435456), 1409286144, Build.VERSION.SDK_INT >= 34 ? ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(1).toBundle() : null);
                    AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
                    if (alarmManager != null) {
                        alarmManager.set(3, SystemClock.elapsedRealtime() + 50, activity);
                    }
                    Process.killProcess(Process.myPid());
                } catch (Throwable unused3) {
                    return;
                }
                break;
            default:
                Workspace workspace = (Workspace) this.f15314k;
                Launcher launcher = workspace.f23432V0;
                SharedPreferences sharedPreferences = launcher.getSharedPreferences("com.luutinhit.launcher6.WallpaperCropActivity", 0);
                Resources resources = launcher.getResources();
                WindowManager windowManager = launcher.getWindowManager();
                boolean zOverrideWallpaperDimensions = launcher.overrideWallpaperDimensions();
                if (AbstractC0075r.f215b == null) {
                    Point point = new Point();
                    Point point2 = new Point();
                    windowManager.getDefaultDisplay().getCurrentSizeRange(point, point2);
                    int iMax2 = Math.max(point2.x, point2.y);
                    int iMax3 = Math.max(point.x, point.y);
                    if (Utilities.f16754o) {
                        Point point3 = new Point();
                        windowManager.getDefaultDisplay().getRealSize(point3);
                        iMax2 = Math.max(point3.x, point3.y);
                        iMax3 = Math.min(point3.x, point3.y);
                    }
                    if (resources.getConfiguration().smallestScreenWidthDp >= 720) {
                        float f6 = iMax2;
                        iMax = (int) ((((f6 / iMax3) * 0.30769226f) + 1.0076923f) * f6);
                    } else {
                        iMax = Math.max((int) (iMax3 * 2.0f), iMax2);
                    }
                    AbstractC0075r.f215b = new Point(iMax, iMax2);
                }
                Point point4 = AbstractC0075r.f215b;
                int i9 = sharedPreferences.getInt("wallpaper.width", -1);
                int i10 = sharedPreferences.getInt("wallpaper.height", -1);
                if (i9 == -1 || i10 == -1) {
                    if (!zOverrideWallpaperDimensions) {
                        break; // jadx dropped this: AOSP WallpaperUtils.suggestWallpaperDimension returns here
                    }
                    i9 = point4.x;
                    i10 = point4.y;
                }
                WallpaperManager wallpaperManager = workspace.f23458x0;
                if (i9 != wallpaperManager.getDesiredMinimumWidth() || i10 != wallpaperManager.getDesiredMinimumHeight()) {
                    wallpaperManager.suggestDesiredDimensions(i9, i10);
                }
                break;
        }
    }
}
