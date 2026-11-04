package com.luutinhit.launcherios.activity;

import B3.AbstractC0075r;
import B3.C0056Y;
import B3.RunnableC0064g;
import C3.InterfaceC0149a;
import D3.C0194b;
import G3.C0346b;
import J1.C0500F;
import J3.C0545d;
import P3.AbstractActivityC0816d;
import P3.C0830r;
import P3.C0832t;
import P3.C0833u;
import P3.C0834v;
import P3.RunnableC0829q;
import Q3.C0911s;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.result.C1371c;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.C1506y;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.C1697k;
import com.bumptech.glide.ComponentCallbacks2C1688b;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.activity.WallpaperActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import p081h2.AbstractC2127a;

/* JADX INFO: loaded from: classes.dex */
public class WallpaperActivity extends AbstractActivityC0816d implements InterfaceC0149a, View.OnClickListener {

    /* JADX INFO: renamed from: Y */
    public static final /* synthetic */ int f17433Y = 0;

    /* JADX INFO: renamed from: D */
    public Context f17434D;

    /* JADX INFO: renamed from: E */
    public C0056Y f17435E;

    /* JADX INFO: renamed from: F */
    public ViewPager f17436F;

    /* JADX INFO: renamed from: G */
    public ConstraintLayout f17437G;

    /* JADX INFO: renamed from: H */
    public ConstraintLayout f17438H;

    /* JADX INFO: renamed from: I */
    public LinearLayout f17439I;

    /* JADX INFO: renamed from: J */
    public AppCompatImageView f17440J;

    /* JADX INFO: renamed from: K */
    public AppCompatImageView f17441K;

    /* JADX INFO: renamed from: L */
    public Animation f17442L;

    /* JADX INFO: renamed from: M */
    public C0545d f17443M;

    /* JADX INFO: renamed from: N */
    public C0911s f17444N;

    /* JADX INFO: renamed from: O */
    public int f17445O;

    /* JADX INFO: renamed from: P */
    public int f17446P;

    /* JADX INFO: renamed from: S */
    public RealTimeBlurView f17449S;

    /* JADX INFO: renamed from: V */
    public WallpaperManager f17452V;

    /* JADX INFO: renamed from: Q */
    public Uri f17447Q = null;

    /* JADX INFO: renamed from: R */
    public ArrayList f17448R = new ArrayList();

    /* JADX INFO: renamed from: T */
    public Handler f17450T = new Handler();

    /* JADX INFO: renamed from: U */
    public RunnableC0829q f17451U = new RunnableC0829q(this, 1);

    /* JADX INFO: renamed from: W */
    public C0500F f17453W = new C0500F(2, this);

    /* JADX INFO: renamed from: X */
    public C1371c f17454X = this.f3950r.m2839c("activity_rq#" + this.f3949q.getAndIncrement(), this, new C1506y(2), new C0830r(this));

    /* JADX INFO: renamed from: K */
    public static void m8308K(WallpaperActivity wallpaperActivity) {
        m8310M(wallpaperActivity.f17437G);
        m8310M(wallpaperActivity.f17438H);
        wallpaperActivity.f17439I.animate().withLayer().alpha(0.0f).setDuration(168L).start();
        wallpaperActivity.f17439I.postDelayed(new RunnableC0829q(wallpaperActivity, 0), 169L);
        wallpaperActivity.f17440J.clearAnimation();
        wallpaperActivity.f17452V.getDesiredMinimumWidth();
        wallpaperActivity.f17452V.getDesiredMinimumHeight();
    }

    /* JADX INFO: renamed from: L */
    public static void m8309L(final WallpaperActivity wallpaperActivity, final Bitmap bitmap) {
        Bitmap bitmapCopy;
        int i6 = 0;
        new Thread(new Runnable() { // from class: P3.s

            /* JADX INFO: renamed from: k */
            public /* synthetic */ WallpaperActivity f2437k;

            {
                this.f2437k = wallpaperActivity;
            }

            @Override // java.lang.Runnable
            public final void run(){
                ConstraintLayout constraintLayout;
                RunnableC0829q runnableC0829q;
                WallpaperActivity wallpaperActivity2 = this.f2437k;
                Bitmap bitmap2 = bitmap;
                int i7 = 2;
                switch (i6) {
                    case 0:
                        int i8 = WallpaperActivity.f17433Y;
                        try {
                            wallpaperActivity2.f17452V.suggestDesiredDimensions(wallpaperActivity2.f17445O, wallpaperActivity2.f17446P);
                            if (Utilities.f16745f) {
                                Rect rect = new Rect(0, 0, wallpaperActivity2.f17445O, wallpaperActivity2.f17446P);
                                wallpaperActivity2.f17452V.setBitmap(bitmap2, rect, true, 1);
                                wallpaperActivity2.f17452V.setBitmap(bitmap2, rect, true, 2);
                            } else {
                                wallpaperActivity2.f17452V.setBitmap(bitmap2);
                            }
                            if (Utilities.f16749j) {
                                wallpaperActivity2.f17452V.getWallpaperId(1);
                                wallpaperActivity2.f17435E.m136f(wallpaperActivity2.f17452V.getWallpaperId(1), "wallpaper_id");
                            }
                            constraintLayout = wallpaperActivity2.f17437G;
                            runnableC0829q = new RunnableC0829q(wallpaperActivity2, i7);
                            break;
                        } catch (Throwable th) {
                            try {
                                th.getMessage();
                                constraintLayout = wallpaperActivity2.f17437G;
                                runnableC0829q = new RunnableC0829q(wallpaperActivity2, i7);
                            } catch (Throwable th2) {
                                wallpaperActivity2.f17437G.post(new RunnableC0829q(wallpaperActivity2, i7));
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                            }
                        }
                        constraintLayout.post(runnableC0829q);
                        return;
                    default:
                        int i9 = WallpaperActivity.f17433Y;
                        FileOutputStream fileOutputStream = null;
                        try {
                            try {
                                File dir = wallpaperActivity2.f17434D.getDir("image", 0);
                                if (dir.exists() || dir.mkdirs()) {
                                    File file = new File(dir, "wallpaper");
                                    if (file.exists() && !file.delete()) {
                                        file.getAbsolutePath();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
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
                                    } catch (Throwable th3) {
                                        fileOutputStream = fileOutputStream2;
                                        Throwable th = th3;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e9) {
                                                e9.getMessage();
                                            }
                                            break;
                                        }
                                        bitmap2.recycle();
                                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                                    }
                                } else {
                                    dir.getAbsolutePath();
                                }
                            } catch (Throwable th4) {
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th4);
                            }
                            break;


                        } catch (Exception e11) {
                            Throwable e = e11;
                        }
                        bitmap2.recycle();
                        return;
                }
            }
        }).start();
        if (!Utilities.f16749j || bitmap.isRecycled() || (bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false)) == null) {
            return;
        }
        int i7 = 1;
        new Thread(new Runnable() { // from class: P3.s

            /* JADX INFO: renamed from: k */
            public /* synthetic */ WallpaperActivity f2437k;

            {
                this.f2437k = wallpaperActivity;
            }

            @Override // java.lang.Runnable
            public final void run(){
                ConstraintLayout constraintLayout;
                RunnableC0829q runnableC0829q;
                WallpaperActivity wallpaperActivity2 = this.f2437k;
                Bitmap bitmap2 = bitmapCopy;
                int i8 = 2;
                switch (i7) {
                    case 0:
                        int i9 = WallpaperActivity.f17433Y;
                        try {
                            wallpaperActivity2.f17452V.suggestDesiredDimensions(wallpaperActivity2.f17445O, wallpaperActivity2.f17446P);
                            if (Utilities.f16745f) {
                                Rect rect = new Rect(0, 0, wallpaperActivity2.f17445O, wallpaperActivity2.f17446P);
                                wallpaperActivity2.f17452V.setBitmap(bitmap2, rect, true, 1);
                                wallpaperActivity2.f17452V.setBitmap(bitmap2, rect, true, 2);
                            } else {
                                wallpaperActivity2.f17452V.setBitmap(bitmap2);
                            }
                            if (Utilities.f16749j) {
                                wallpaperActivity2.f17452V.getWallpaperId(1);
                                wallpaperActivity2.f17435E.m136f(wallpaperActivity2.f17452V.getWallpaperId(1), "wallpaper_id");
                            }
                            constraintLayout = wallpaperActivity2.f17437G;
                            runnableC0829q = new RunnableC0829q(wallpaperActivity2, i8);
                            break;
                        } catch (Throwable th) {
                            try {
                                th.getMessage();
                                constraintLayout = wallpaperActivity2.f17437G;
                                runnableC0829q = new RunnableC0829q(wallpaperActivity2, i8);
                            } catch (Throwable th2) {
                                wallpaperActivity2.f17437G.post(new RunnableC0829q(wallpaperActivity2, i8));
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                            }
                        }
                        constraintLayout.post(runnableC0829q);
                        return;
                    default:
                        int i10 = WallpaperActivity.f17433Y;
                        FileOutputStream fileOutputStream = null;
                        try {
                            try {
                                File dir = wallpaperActivity2.f17434D.getDir("image", 0);
                                if (dir.exists() || dir.mkdirs()) {
                                    File file = new File(dir, "wallpaper");
                                    if (file.exists() && !file.delete()) {
                                        file.getAbsolutePath();
                                    }
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                    try {
                                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
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
                                    } catch (Throwable th3) {
                                        fileOutputStream = fileOutputStream2;
                                        Throwable th = th3;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e9) {
                                                e9.getMessage();
                                            }
                                            break;
                                        }
                                        bitmap2.recycle();
                                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                                    }
                                } else {
                                    dir.getAbsolutePath();
                                }
                            } catch (Throwable th4) {
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th4);
                            }
                            break;


                        } catch (Exception e11) {
                            Throwable e = e11;
                        }
                        bitmap2.recycle();
                        return;
                }
            }
        }).start();
    }

    /* JADX INFO: renamed from: M */
    public static boolean m8310M(ConstraintLayout constraintLayout) {
        if (constraintLayout == null || constraintLayout.getVisibility() != 0) {
            return false;
        }
        constraintLayout.animate().withLayer().alpha(0.0f).setDuration(268L).start();
        constraintLayout.postDelayed(new RunnableC0064g(9, constraintLayout), 269L);
        return true;
    }

    /* JADX INFO: renamed from: N */
    public final void m8311N() {
        this.f17439I.setAlpha(0.0f);
        this.f17439I.setVisibility(0);
        this.f17439I.animate().withLayer().alpha(1.0f).setDuration(168L).start();
        this.f17440J.startAnimation(this.f17442L);
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onActivityResult(int i6, int i7, Intent intent) {
        Intent intent2;
        if (i7 == -1) {
            if (i6 == 0) {
                if (Utilities.m8172x() || Utilities.m8168t()) {
                    intent2 = new Intent(this, (Class<?>) IOSLauncher.class);
                } else {
                    intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.HOME");
                }
                startActivity(intent2);
            } else if (i6 == 1 && intent != null) {
                this.f17447Q = intent.getData();
                ((C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(this.f17434D).mo1609l().mo1601S(this.f17447Q).mo1607d()).mo1592u(this.f17445O, this.f17446P)).m3728P(this.f17441K);
                this.f17438H.setAlpha(0.0f);
                this.f17438H.setVisibility(0);
                this.f17438H.animate().withLayer().alpha(1.0f).setDuration(268L).start();
            }
        }
        super.onActivityResult(i6, i7, intent);
    }

    @Override // P3.AbstractActivityC0816d, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onBackPressed() {
        if (m8310M(this.f17437G) || m8310M(this.f17438H)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            int id = view.getId();
            if (id != R.id.confirm_button) {
                if (id == R.id.confirm_pick_button) {
                    m8311N();
                    C1697k c1697k = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(this.f17434D).mo1609l().mo1601S(this.f17447Q).mo1607d()).mo1592u(this.f17445O, this.f17446P);
                    c1697k.m3729Q(new C0833u(this, 2), c1697k);
                    return;
                }
                return;
            }
            if (this.f17436F != null) {
                m8311N();
                int currentItem = this.f17436F.getCurrentItem();
                if (currentItem < 3) {
                    C1697k c1697k2 = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(this.f17434D).mo1609l().mo1604V(Integer.valueOf(currentItem == 2 ? R.raw.wallpaper_default_3 : R.raw.wallpaper_default_1)).mo1607d()).mo1592u(this.f17445O, this.f17446P);
                    c1697k2.m3729Q(new C0833u(this, 0), c1697k2);
                } else {
                    C1697k c1697k3 = (C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(this.f17434D).mo1609l().mo1605W(((C0834v) this.f17448R.get(currentItem - 3)).f2444a).mo1607d()).mo1592u(this.f17445O, this.f17446P);
                    c1697k3.m3729Q(new C0833u(this, 1), c1697k3);
                }
            }
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.wallpaper_activity);
        m1821J(findViewById(R.id.root_layout), true);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            if (Utilities.f16754o) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            this.f17445O = Math.min(point.x, point.y);
            this.f17446P = Math.max(point.x, point.y);
        }
        Context applicationContext = getApplicationContext();
        this.f17434D = applicationContext;
        this.f17435E = new C0056Y(applicationContext);
        this.f17452V = WallpaperManager.getInstance(this.f17434D);
        this.f17449S = (RealTimeBlurView) findViewById(R.id.blurring_view);
        this.f17440J = (AppCompatImageView) findViewById(R.id.progress);
        this.f17437G = (ConstraintLayout) findViewById(R.id.wallpaper_preview);
        this.f17438H = (ConstraintLayout) findViewById(R.id.wallpaper_pick_preview);
        this.f17441K = (AppCompatImageView) findViewById(R.id.image_pick_view);
        this.f17436F = (ViewPager) findViewById(R.id.view_pager);
        TextViewCustomFont textViewCustomFont = (TextViewCustomFont) findViewById(R.id.confirm_button);
        TextViewCustomFont textViewCustomFont2 = (TextViewCustomFont) findViewById(R.id.confirm_pick_button);
        this.f17439I = (LinearLayout) findViewById(R.id.progress_layout);
        this.f17442L = AnimationUtils.loadAnimation(this, R.anim.ios_spinner_rotate);
        C0545d c0545d = new C0545d(this);
        this.f17443M = c0545d;
        this.f17436F.setAdapter(c0545d);
        textViewCustomFont.setOnClickListener(this);
        textViewCustomFont2.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.grid_wallpaper);
        recyclerView.setNestedScrollingEnabled(false);
        OverScrollLayout overScrollLayout = (OverScrollLayout) findViewById(R.id.overscroll_layout);
        overScrollLayout.setOnOverScrollFinishListener(this);
        this.f17449S.setBlurredView(overScrollLayout);
        recyclerView.m3420m(new C0194b(2, this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(3);
        recyclerView.setLayoutManager(gridLayoutManager);
        C0911s c0911s = new C0911s();
        c0911s.f2688n = new ArrayList();
        c0911s.f2689o = this;
        c0911s.f2691q = LayoutInflater.from(this);
        this.f17444N = c0911s;
        c0911s.f2690p = this;
        recyclerView.setAdapter(c0911s);
        gridLayoutManager.f5379K = new C0832t(this, gridLayoutManager, 0);
        recyclerView.m3419l(new C0346b(getResources().getDimensionPixelSize(R.dimen.column_spacing), 1));
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        boolean z5 = Utilities.f16749j;
        C0500F c0500f = this.f17453W;
        if (z5) {
            registerReceiver(c0500f, intentFilter, 2);
        } else {
            registerReceiver(c0500f, intentFilter);
        }
        int i6 = Build.VERSION.SDK_INT;
        Handler handler = this.f17450T;
        RunnableC0829q runnableC0829q = this.f17451U;
        if (i6 >= 33) {
            handler.postDelayed(runnableC0829q, 500L);
            return;
        }
        if (!AbstractC0075r.m195p(this) && Utilities.f16748i) {
            if (shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE")) {
                AbstractC2127a.m8799n(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 68);
            } else {
                AbstractC0075r.m198t(this, "android.permission.READ_EXTERNAL_STORAGE");
            }
        }
        if (AbstractC0075r.m195p(this)) {
            handler.postDelayed(runnableC0829q, 500L);
        }
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onDestroy() {
        C0500F c0500f = this.f17453W;
        if (c0500f != null) {
            unregisterReceiver(c0500f);
        }
        super.onDestroy();
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        if (i6 == 68) {
            try {
                HashMap map = new HashMap();
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    map.put(strArr[i7], Integer.valueOf(iArr[i7]));
                }
                if (((Integer) map.get("android.permission.READ_EXTERNAL_STORAGE")).intValue() == 0 && ((Integer) map.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() == 0) {
                    this.f17450T.postDelayed(this.f17451U, 500L);
                } else {
                    Toast.makeText(this, R.string.required_storage_permission, 1).show();
                }
            } catch (Throwable unused) {
                Toast.makeText(this, R.string.required_storage_permission, 1).show();
            }
        }
    }
}
