package com.luutinhit.launcher6.ioslauncher;

import A2.C0022a;
import B3.C0046N;
import B3.C0056Y;
import B3.RunnableC0054W;
import B3.ViewOnClickListenerC0045M;
import C2.C0144d;
import G3.RunnableC0358n;
import O3.ViewOnClickListenerC0743d;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.WallpaperManager;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import androidx.annotation.Keep;
import com.bumptech.glide.C1697k;
import com.bumptech.glide.ComponentCallbacks2C1688b;
import com.luutinhit.launcher6.BlurBitmapRunnable;
import com.luutinhit.launcher6.Hotseat;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherAnimUtils;
import com.luutinhit.launcher6.ShortcutAndWidgetContainer;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcherios.MainActivity;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.activity.RatingActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import p029g.C2054g;
import p029g.DialogC2057j;
import t5.C2801d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class IOSLauncher extends Launcher {
    public static final int MIN_FLING_VELOCITY = 250;
    public static final int MIN_SNAP_VELOCITY = 1500;
    public static final String TAG = "IOSLauncher";
    public DialogC2057j mDialogWarningWallpaper;
    public InputMethodManager mInputMethodManager;
    public PowerManager mPowerManager;
    public C0046N mRequestSetDefaultLauncher;
    public C0056Y mTinyDB;
    WallpaperManager mWallpaperManager;
    public int mCountOpenControlView = 0;
    public int mNumberShowRateDialog = 8;
    public boolean mHasPrepareOpenAnimation = false;
    public boolean mBeginDragLeftPage = false;
    public boolean mBeginDragLibraryPage = false;
    public int mMinFlingVelocity = MIN_FLING_VELOCITY;
    public int mMinSnapVelocity = MIN_SNAP_VELOCITY;
    public ExecutorService mWallpaperExecutor = Executors.newSingleThreadExecutor();
    public Runnable mRestorePosition = new WidgetRefreshRunnable(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHideNavigation() {
        if (this.isHideNavigation) {
            try {
                View decorView = getWindow().getDecorView();
                decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.luutinhit.launcher6.ioslauncher.b
                    @Override // android.view.View.OnSystemUiVisibilityChangeListener
                    public final void onSystemUiVisibilityChange(int i6) {
                        IOSLauncher.this.lambda$checkHideNavigation$1(decorView, i6);
                    }
                });
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public int getDurationWithVelocity(float f6, float f7) {
        int iRound;
        if (Math.abs(f6) >= this.mMinFlingVelocity) {
            iRound = Math.round(Math.abs(f7 / Math.max(this.mMinSnapVelocity, Math.abs(f6))) * 1000.0f) * 6;
        } else {
            iRound = 268;
        }
        return Math.max(iRound, 136);
    }

    public File getFileWallpaperFromStorage() {
        try {
            File file = new File(new ContextWrapper(this).getDir("image", 0), "wallpaper");
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void hideNavigationNow() {
        try {
            View decorView = getWindow().getDecorView();
            decorView.postDelayed(new RunnableC0054W(24, this, decorView), 500L);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMyLauncherDefault() {
        try {
            PackageManager packageManager = getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            return packageManager.resolveActivity(intent, 65536).activityInfo.packageName.equals(getPackageName());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkHideNavigation$0(int i6, View view) {
        int i7;
        if ((i6 & 4) == 0) {
            try {
                if (Utilities.f16753n) {
                    i7 = 4866;
                } else {
                    requestWindowFeature(1);
                    getWindow().setFlags(1024, 1024);
                    i7 = 1799;
                }
                view.setSystemUiVisibility(i7);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkHideNavigation$1(View view, int i6) {
        view.postDelayed(new BlurBitmapRunnable(this, i6, view, 1), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideNavigationNow$2(View view) {
        int i6;
        try {
            if (Utilities.f16753n) {
                i6 = 4866;
            } else {
                requestWindowFeature(1);
                getWindow().setFlags(1024, 1024);
                i6 = 1799;
            }
            view.setSystemUiVisibility(i6);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeNormalHomeState$6() {
        try {
            if (getDragLayer() != null) {
                getDragLayer().setScaleX(1.0f);
                getDragLayer().setScaleY(1.0f);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToInternalStorage$11(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File dir = getDir("image", 0);
                if (!dir.exists() && !dir.mkdirs()) {
                    dir.getAbsolutePath();
                    bitmap.recycle();
                    return;
                }
                File file = new File(dir, str);
                if (file.exists() && !file.delete()) {
                    file.getAbsolutePath();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        e.getMessage();
                    }
                } catch (IOException e5) {
                    fileOutputStream = fileOutputStream2;
                    Throwable e = e5;
                    e.getMessage();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e = e6;
                            e.getMessage();
                        }
                    }
                } catch (Exception e7) {
                    fileOutputStream = fileOutputStream2;
                    Throwable e = e7;
                    e.getMessage();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                            e = e8;
                            e.getMessage();
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e9) {
                            e9.getMessage();
                        }
                    }
                    bitmap.recycle();
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
                bitmap.recycle();
            } catch (Throwable th2) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
            }
        } catch (Exception e11) {
            Throwable e = e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWallpaperFromBitmap$10(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            return;
        }
        try {
            this.mWallpaperManager.suggestDesiredDimensions(this.screenWidth, this.screenHeight);
            if (Utilities.f16745f) {
                this.mWallpaperManager.setBitmap(bitmap, new Rect(0, 0, this.screenWidth, this.screenHeight), true, 1);
            } else {
                this.mWallpaperManager.setBitmap(bitmap);
            }
            if (Utilities.f16749j) {
                int wallpaperId = this.mWallpaperManager.getWallpaperId(1);
                C0056Y c0056y = this.mTinyDB;
                if (c0056y != null) {
                    c0056y.m136f(wallpaperId, "wallpaper_id");
                }
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
        } catch (OutOfMemoryError e5) {
            e5.getMessage();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAppsLibrarySettingsGuide$9(DialogC2057j dialogC2057j, View view) {
        dialogC2057j.dismiss();
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$showSuggestWallpaperChangeDialog$3(View view) {
        this.mTinyDB.f137a.edit().putBoolean("not_show_suggest_blur_effect_dialog", true).apply();
        DialogC2057j dialogC2057j = this.mDialogWarningWallpaper;
        if (dialogC2057j == null || !dialogC2057j.isShowing()) {
            return;
        }
        this.mDialogWarningWallpaper.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSuggestWallpaperChangeDialog$4(View view) {
        DialogC2057j dialogC2057j = this.mDialogWarningWallpaper;
        if (dialogC2057j == null || !dialogC2057j.isShowing()) {
            return;
        }
        this.mDialogWarningWallpaper.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSuggestWallpaperChangeDialog$5(View view) {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        DialogC2057j dialogC2057j = this.mDialogWarningWallpaper;
        if (dialogC2057j == null || !dialogC2057j.isShowing()) {
            return;
        }
        this.mDialogWarningWallpaper.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPlayOpenAnimation$7() {
        this.mHasPrepareOpenAnimation = false;
        playOpenAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeNormalHomeState() {
        getDragLayer().postDelayed(new IOSLauncherTask(this, 1), 889L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToInternalStorage(String str, Bitmap bitmap) {
        Bitmap bitmapCopy;
        if (bitmap == null || bitmap.isRecycled() || (bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false)) == null) {
            return;
        }
        new Thread(new RunnableC0358n(this, str, bitmapCopy, 8)).start();
    }

    public void setDefaultWallpaperFromResource() {
        C1697k c1697k = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(getApplicationContext()).mo1609l().mo1604V(Integer.valueOf(R.raw.wallpaper_default_1)).mo1607d()).mo1592u(this.screenWidth, this.screenHeight);
        c1697k.m3729Q(new BitmapLoadTarget(this, 1), c1697k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrRestoreWallpaper() {
        File fileWallpaperFromStorage = getFileWallpaperFromStorage();
        if (fileWallpaperFromStorage != null) {
            setWallpaperFromFile(fileWallpaperFromStorage);
        } else {
            setDefaultWallpaperFromResource();
        }
    }

    public void setWallpaperFromFile(File file) {
        C1697k c1697k = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(getApplicationContext()).mo1609l().mo1603U(file).mo1607d()).mo1592u(this.screenWidth, this.screenHeight);
        c1697k.m3729Q(new BitmapLoadTarget(this, 0), c1697k);
    }

    public void showAppsLibrarySettingsGuide() {
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_apps_library_settings, (ViewGroup) null);
        Button button = (Button) viewInflate.findViewById(R.id.dialog_set_default_button_negative);
        Button button2 = (Button) viewInflate.findViewById(R.id.dialog_set_default_button_positive);
        C0144d c0144d = new C0144d(this, R.style.Rounded_AppCompat_Dialog);
        ((C2054g) c0144d.f419k).f18341t = viewInflate;
        DialogC2057j dialogC2057jM351j = c0144d.m351j();
        button.setOnClickListener(new ViewOnClickListenerC0743d(dialogC2057jM351j, 3));
        button2.setOnClickListener(new ViewOnClickListenerC0045M(2, this, dialogC2057jM351j));
        dialogC2057jM351j.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuggestWallpaperChangeDialog() {
        if (this.mTinyDB.f137a.getBoolean("not_show_suggest_blur_effect_dialog", false)) {
            return;
        }
        try {
            View viewInflate = getLayoutInflater().inflate(R.layout.dialog_suggest_blur_effect, (ViewGroup) null);
            C0144d c0144d = new C0144d(this, R.style.Rounded_AppCompat_Dialog);
            C2054g c2054g = (C2054g) c0144d.f419k;
            c2054g.f18341t = viewInflate;
            c2054g.f18334m = false;
            this.mDialogWarningWallpaper = c0144d.m351j();
            int i6 = 0;
            viewInflate.findViewById(R.id.dialog_blur_effect_button_never).setOnClickListener(new View.OnClickListener() { // from class: com.luutinhit.launcher6.ioslauncher.c

                /* JADX INFO: renamed from: k */
                public /* synthetic */ IOSLauncher f16585k;

                {
                    this.f16585k = IOSLauncher.this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i6) {
                        case 0:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$3(view);
                            break;
                        case 1:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$4(view);
                            break;
                        default:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$5(view);
                            break;
                    }
                }
            });
            int i7 = 1;
            viewInflate.findViewById(R.id.dialog_blur_effect_button_negative).setOnClickListener(new View.OnClickListener() { // from class: com.luutinhit.launcher6.ioslauncher.c

                /* JADX INFO: renamed from: k */
                public /* synthetic */ IOSLauncher f16585k;

                {
                    this.f16585k = IOSLauncher.this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i7) {
                        case 0:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$3(view);
                            break;
                        case 1:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$4(view);
                            break;
                        default:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$5(view);
                            break;
                    }
                }
            });
            int i8 = 2;
            viewInflate.findViewById(R.id.dialog_blur_effect_button_positive).setOnClickListener(new View.OnClickListener() { // from class: com.luutinhit.launcher6.ioslauncher.c

                /* JADX INFO: renamed from: k */
                public /* synthetic */ IOSLauncher f16585k;

                {
                    this.f16585k = IOSLauncher.this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i8) {
                        case 0:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$3(view);
                            break;
                        case 1:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$4(view);
                            break;
                        default:
                            this.f16585k.lambda$showSuggestWallpaperChangeDialog$5(view);
                            break;
                    }
                }
            });
            if (this.mDialogWarningWallpaper.getWindow() != null) {
                this.mDialogWarningWallpaper.getWindow().setDimAmount(0.2f);
            }
            this.mDialogWarningWallpaper.show();
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRatingActivity() {
        com.luutinhit.launcher6.JadxSupport.useSource(); // changed on purpose: the "rate 5 stars" dialog never pops up by itself
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoomInLauncherView() {
        C2801d.m9955b().m9958e("OPEN_ANIM");
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(getDragLayer(), PropertyValuesHolder.ofFloat("scaleX", 0.95f), PropertyValuesHolder.ofFloat("scaleY", 0.95f));
        objectAnimatorOfPropertyValuesHolder.setStartDelay(0L);
        objectAnimatorOfPropertyValuesHolder.setDuration(238L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new DecelerateInterpolator(0.8f));
        objectAnimatorOfPropertyValuesHolder.start();
        objectAnimatorOfPropertyValuesHolder.addListener(new C0022a(17, this));
    }

    @Override // com.luutinhit.launcher6.Launcher, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Utilities.f16752m) {
            getWindow().setExitTransition(null);
            getWindow().setEnterTransition(null);
            getWindow().setAllowReturnTransitionOverlap(false);
            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setTransitionBackgroundFadeDuration(0L);
        }
        setLauncherCallbacks(new IOSLauncherCallbacks(this));
        super.onCreate(bundle);
        this.mPowerManager = (PowerManager) getSystemService("power");
        this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (this.isHideNavigation) {
            hideNavigationNow();
        }
        float f6 = getResources().getDisplayMetrics().density;
        this.mMinFlingVelocity = (int) (250.0f * f6);
        this.mMinSnapVelocity = (int) (f6 * 1500.0f);
    }

    @Override // com.luutinhit.launcher6.Launcher, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        if (z5) {
            checkHideNavigation();
        }
    }

    @Override // com.luutinhit.launcher6.Launcher
    public void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
    }

    public void playOpenAnimation() {
        try {
            Hotseat hotseat = getHotseat();
            hotseat.animate().withLayer().translationY(0.0f).setInterpolator(new OvershootInterpolator(0.8f)).setDuration(866L).setListener(new C0022a(11, hotseat)).start();
            ArrayList<ShortcutAndWidgetContainer> allShortcutAndWidgetContainers = getWorkspace().getAllShortcutAndWidgetContainers();
            int size = allShortcutAndWidgetContainers.size();
            int i6 = 0;
            while (i6 < size) {
                ShortcutAndWidgetContainer shortcutAndWidgetContainer = allShortcutAndWidgetContainers.get(i6);
                i6++;
                ShortcutAndWidgetContainer shortcutAndWidgetContainer2 = shortcutAndWidgetContainer;
                try {
                    if (shortcutAndWidgetContainer2.f16509u) {
                        shortcutAndWidgetContainer2.m8042f();
                    }
                } catch (Throwable unused) {
                    Iterator it = shortcutAndWidgetContainer2.f16495B.keySet().iterator();
                    while (it.hasNext()) {
                        ((View) it.next()).setTranslationY(0.0f);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
            runOnUiThread(this.mRestorePosition);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0018 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public void prepareOpenAnimation(boolean z5) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        try {
            if (Utilities.f16752m) {
                if (this.mPowerManager.isInteractive()) {
                    if (!z5) {
                        return;
                    }
                }
            } else if (this.mPowerManager.isScreenOn()) {
                if (!z5) {
                    return;
                }
            }
            int currentWorkspaceScreen = getCurrentWorkspaceScreen();
            if (currentWorkspaceScreen <= 0 || getWorkspace() == null || currentWorkspaceScreen >= getWorkspace().getPageCount()) {
                return;
            }
            getWorkspace().getCurrentCellLayout().getShortcutsAndWidgets().m8043g();
            Hotseat hotseat = getHotseat();
            hotseat.f15709o = true;
            hotseat.setTranslationY(hotseat.f15713s - hotseat.f15714t);
            this.mHasPrepareOpenAnimation = true;
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void release() {
        try {
            this.mWallpaperExecutor.shutdown();
            if (this.mWallpaperExecutor.awaitTermination(2L, TimeUnit.SECONDS)) {
                return;
            }
            this.mWallpaperExecutor.shutdownNow();
        } catch (InterruptedException unused) {
            this.mWallpaperExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public void setWallpaperFromBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled() || this.screenWidth <= 0 || this.screenHeight <= 0) {
            return;
        }
        this.mWallpaperExecutor.execute(new RunnableC0054W(23, this, bitmap));
    }

    public void startPlayOpenAnimation() {
        if (this.mHasPrepareOpenAnimation) {
            if (Utilities.f16752m ? this.mPowerManager.isInteractive() : this.mPowerManager.isScreenOn()) {
                this.mHasPrepareOpenAnimation = false;
                playOpenAnimation();
            } else {
                getDragLayer().postDelayed(new IOSLauncherTask(this, 0), 136L);
            }
            getDragLayer().removeCallbacks(this.mRestorePosition);
            getDragLayer().postOnAnimationDelayed(this.mRestorePosition, 1688L);
        }
    }
}
