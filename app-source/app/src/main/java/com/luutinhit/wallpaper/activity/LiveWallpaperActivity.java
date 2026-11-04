package com.luutinhit.wallpaper.activity;

import android.app.WallpaperManager;
import android.os.Bundle;
import androidx.fragment.app.C1469C;
import androidx.fragment.app.C1482a;
import com.luutinhit.launcherios.R;
import p029g.AbstractActivityC2058k;
import p061c4.C1672b;
import p061c4.C1679i;

/* JADX INFO: loaded from: classes.dex */
public class LiveWallpaperActivity extends AbstractActivityC2058k {

    /* JADX INFO: renamed from: D */
    public boolean f17647D;

    /* JADX INFO: renamed from: E */
    public WallpaperManager f17648E;

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_live_wallpaper);
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        this.f17648E = wallpaperManager;
        if (bundle == null) {
            if (wallpaperManager.getWallpaperInfo() == null || !this.f17648E.getWallpaperInfo().getPackageName().equals(getPackageName())) {
                C1469C c1469cM8626y = m8626y();
                c1469cM8626y.getClass();
                C1482a c1482a = new C1482a(c1469cM8626y);
                c1482a.m3229g(R.id.container, new C1672b());
                c1482a.m3226d(false);
                this.f17647D = true;
                return;
            }
            C1469C c1469cM8626y2 = m8626y();
            c1469cM8626y2.getClass();
            C1482a c1482a2 = new C1482a(c1469cM8626y2);
            c1482a2.m3229g(R.id.container, new C1679i());
            c1482a2.m3226d(false);
            this.f17647D = false;
        }
    }

    @Override // android.app.Activity
    public final void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f17647D = bundle.getBoolean("intro");
    }

    @Override // androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("intro", this.f17647D);
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (this.f17647D && this.f17648E.getWallpaperInfo() != null && this.f17648E.getWallpaperInfo().getPackageName().equals(getPackageName())) {
            C1469C c1469cM8626y = m8626y();
            c1469cM8626y.getClass();
            C1482a c1482a = new C1482a(c1469cM8626y);
            c1482a.f5093b = R.anim.fragment_enter;
            c1482a.f5094c = R.anim.fragment_exit;
            c1482a.f5095d = 0;
            c1482a.f5096e = 0;
            c1482a.m3229g(R.id.container, new C1679i());
            c1482a.m3226d(false);
            this.f17647D = false;
            return;
        }
        if (this.f17647D) {
            return;
        }
        if (this.f17648E.getWallpaperInfo() == null || !this.f17648E.getWallpaperInfo().getPackageName().equals(getPackageName())) {
            C1469C c1469cM8626y2 = m8626y();
            c1469cM8626y2.getClass();
            C1482a c1482a2 = new C1482a(c1469cM8626y2);
            c1482a2.m3229g(R.id.container, new C1672b());
            c1482a2.m3226d(false);
            this.f17647D = true;
        }
    }
}
