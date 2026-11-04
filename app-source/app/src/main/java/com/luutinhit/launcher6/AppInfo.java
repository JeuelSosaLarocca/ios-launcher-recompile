package com.luutinhit.launcher6;

import B3.AbstractC0075r;
import Y0.RunnableC1204i;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import p122r3.AbstractC2662f;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.c */
/* JADX INFO: loaded from: classes.dex */
public final class AppInfo extends ItemInfo {

    /* JADX INFO: renamed from: A */
    public Intent f16326A;

    /* JADX INFO: renamed from: B */
    public Bitmap f16327B;

    /* JADX INFO: renamed from: C */
    public boolean f16328C;

    /* JADX INFO: renamed from: D */
    public ComponentName f16329D;

    /* JADX INFO: renamed from: E */
    public ApplicationInfo f16330E;

    /* JADX INFO: renamed from: F */
    public int f16331F;

    /* JADX INFO: renamed from: G */
    public int f16332G;

    public AppInfo(Context context, AbstractC2662f abstractC2662f, C2673q c2673q, IconCache iconCache) {
        this(context, abstractC2662f, c2673q, iconCache, C2674r.m9673e(context).mo9680j(c2673q));
    }

    /* JADX INFO: renamed from: f */
    public static void m7981f(ArrayList arrayList) {
        arrayList.size();
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            AppInfo appInfo = (AppInfo) obj;
            Objects.toString(appInfo.title);
            Objects.toString(appInfo.f16327B);
            appInfo.f16329D.getPackageName();
        }
    }

    /* JADX INFO: renamed from: g */
    public static int m7982g(AbstractC2662f abstractC2662f) {
        int i6 = abstractC2662f.mo9651a().flags;
        if ((i6 & 1) == 0) {
            return (i6 & 128) != 0 ? 3 : 1;
        }
        return 0;
    }

    /* JADX INFO: renamed from: h */
    public static Intent makeLaunchIntent(Context context, AbstractC2662f abstractC2662f, C2673q c2673q) {
        return new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER").setComponent(abstractC2662f.mo9652b()).setFlags(270532608).putExtra("profile", C2674r.m9673e(context).mo9676f(c2673q));
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: b */
    public final Intent mo7984b() {
        return this.f16326A;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: c */
    public final boolean mo7985c() {
        return this.f16332G != 0;
    }

    /* JADX INFO: renamed from: i */
    public final ShortcutInfo makeShortcut() {
        ShortcutInfo shortcutInfo = new ShortcutInfo();
        shortcutInfo.id = -1L;
        shortcutInfo.container = -1L;
        shortcutInfo.screenId = -1L;
        shortcutInfo.cellX = -1;
        shortcutInfo.cellY = -1;
        shortcutInfo.spanX = 1;
        shortcutInfo.spanY = 1;
        shortcutInfo.minSpanX = 1;
        shortcutInfo.minSpanY = 1;
        shortcutInfo.f16791t = 0;
        shortcutInfo.f16793v = 0;
        shortcutInfo.requiresDbUpdate = false;
        shortcutInfo.copyFrom(this);
        HandlerThread handlerThread = LauncherModel.sWorkerThread;
        Objects.toString(shortcutInfo);
        LauncherModel.m7567y(new RunnableC1204i(shortcutInfo.id, shortcutInfo, new Throwable().getStackTrace()));
        shortcutInfo.f16559G = 0;
        shortcutInfo.f16562J = 0;
        shortcutInfo.title = Utilities.trim(this.title);
        shortcutInfo.f16553A = new Intent(this.f16326A);
        shortcutInfo.f16554B = false;
        shortcutInfo.f16562J = this.f16331F;
        shortcutInfo.f16559G = this.f16332G;
        return shortcutInfo;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    public final String toString() {
        return "ApplicationInfo(title=" + ((Object) this.title) + " id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + Arrays.toString((int[]) null) + " user=" + this.user + ")";
    }

    public AppInfo(Context context, AbstractC2662f abstractC2662f, C2673q c2673q, IconCache iconCache, boolean z5) {
        this.f16331F = 0;
        this.f16332G = 0;
        this.f16330E = abstractC2662f.mo9651a();
        this.f16329D = abstractC2662f.mo9652b();
        this.container = -1L;
        this.f16331F = m7982g(abstractC2662f);
        if (AbstractC0075r.m191l(abstractC2662f.mo9651a())) {
            this.f16332G |= 4;
        }
        if (z5) {
            this.f16332G |= 8;
        }
        iconCache.m8018t(this, abstractC2662f);
        this.f16326A = makeLaunchIntent(context, abstractC2662f, c2673q);
        this.user = c2673q;
    }
}
