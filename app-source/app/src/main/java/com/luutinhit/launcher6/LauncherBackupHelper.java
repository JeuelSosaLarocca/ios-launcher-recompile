package com.luutinhit.launcher6;

import android.app.backup.BackupDataInputStream;
import android.app.backup.BackupDataOutput;
import android.app.backup.BackupHelper;
import android.app.backup.BackupManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.CRC32;
import k3.AbstractC2277d;
import k3.C2276c;
import p058c1.C1614c;
import p115p3.C2583a;
import p115p3.C2584b;
import p115p3.C2585c;
import p115p3.C2586d;
import p115p3.C2587e;
import p115p3.C2588f;
import p115p3.C2589g;
import p115p3.C2590h;
import p122r3.AbstractC2659c;
import p122r3.C2673q;
import p122r3.C2674r;
import p154y3.C3030e;

/* JADX INFO: renamed from: com.luutinhit.launcher6.j2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherBackupHelper implements BackupHelper {

    /* JADX INFO: renamed from: r */
    public static final String[] f16591r = {"_id", "modified", "intent", "appWidgetProvider", "appWidgetId", "cellX", "cellY", "container", "icon", "iconPackage", "iconResource", "iconType", "itemType", "screen", "spanX", "spanY", "title", "profileId", "rank"};

    /* JADX INFO: renamed from: s */
    public static final String[] f16592s = {"_id", "modified", "screenRank"};

    /* JADX INFO: renamed from: a */
    public LauncherBackupAgentHelper f16593a;

    /* JADX INFO: renamed from: e */
    public long f16597e;

    /* JADX INFO: renamed from: f */
    public BackupManager f16598f;

    /* JADX INFO: renamed from: h */
    public long f16600h;

    /* JADX INFO: renamed from: i */
    public boolean f16601i;

    /* JADX INFO: renamed from: j */
    public IconCache f16602j;

    /* JADX INFO: renamed from: k */
    public C2584b f16603k;

    /* JADX INFO: renamed from: l */
    public InvariantDeviceProfile f16604l;

    /* JADX INFO: renamed from: m */
    public C2584b f16605m;

    /* JADX INFO: renamed from: g */
    public byte[] f16599g = new byte[512];

    /* JADX INFO: renamed from: n */
    public HashSet f16606n = new HashSet();

    /* JADX INFO: renamed from: p */
    public int f16608p = 1;

    /* JADX INFO: renamed from: q */
    public int f16609q = 0;

    /* JADX INFO: renamed from: b */
    public HashSet f16594b = new HashSet();

    /* JADX INFO: renamed from: c */
    public ArrayList f16595c = new ArrayList();

    /* JADX INFO: renamed from: o */
    public boolean f16607o = true;

    /* JADX INFO: renamed from: d */
    public MergedItemCallbacks[] f16596d = new MergedItemCallbacks[7];

    public LauncherBackupHelper(LauncherBackupAgentHelper launcherBackupAgentHelper) {
        this.f16593a = launcherBackupAgentHelper;
        this.f16597e = C2674r.m9673e(launcherBackupAgentHelper).mo9676f(C2673q.m9672b());
    }

    /* JADX INFO: renamed from: d */
    public static C2587e backupKeyToKey(String str) throws C1614c {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            try {
                C2587e c2587e = new C2587e();
                AbstractC2277d.m9055c(c2587e, bArrDecode, bArrDecode.length);
                if (c2587e.f20462e == checkKey(c2587e)) {
                    return c2587e;
                }
                throw new C1614c("invalid key read from stream" + str);
            } catch (IllegalArgumentException e) {
                e = e;
                throw new C1614c(e);
            }
        } catch (IllegalArgumentException e5) {
            Throwable e = e5;
        }
        return null; // jadx: method fell off the end
    }

    /* JADX INFO: renamed from: g */
    public static long checkKey(C2587e c2587e) {
        CRC32 crc32 = new CRC32();
        crc32.update(c2587e.f20459b);
        crc32.update((int) (c2587e.f20461d & 65535));
        crc32.update((int) ((c2587e.f20461d >> 32) & 65535));
        if (!TextUtils.isEmpty(c2587e.f20460c)) {
            crc32.update(c2587e.f20460c.getBytes());
        }
        return crc32.getValue();
    }

    /* JADX INFO: renamed from: k */
    public static C2584b m8082k(InvariantDeviceProfile invariantDeviceProfile) {
        C2584b c2584b = new C2584b();
        c2584b.f20427b = invariantDeviceProfile.f16711c;
        c2584b.f20428c = invariantDeviceProfile.f16712d;
        c2584b.f20429d = invariantDeviceProfile.f16719k;
        c2584b.f20430e = invariantDeviceProfile.f16720l;
        return c2584b;
    }

    /* JADX INFO: renamed from: m */
    public static String keyToBackupKey(C2587e c2587e) {
        return Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2);
    }

    /* JADX INFO: renamed from: o */
    public static C2588f packIcon(int i6, Bitmap bitmap) {
        C2588f c2588f = new C2588f();
        c2588f.f20463b = i6;
        c2588f.f20464c = Utilities.flattenBitmap(bitmap);
        return c2588f;
    }

    /* JADX INFO: renamed from: q */
    public static byte[] readCheckedBytes(int i6, byte[] bArr) throws C2276c {
        C2583a c2583a = new C2583a();
        AbstractC2277d.m9055c(c2583a, bArr, i6);
        CRC32 crc32 = new CRC32();
        crc32.update(c2583a.f20425b);
        if (c2583a.f20426c == crc32.getValue()) {
            return c2583a.f20425b;
        }
        throw new C2276c("checksum does not match");
    }

    /* JADX INFO: renamed from: v */
    public static byte[] writeCheckedBytes(AbstractC2277d abstractC2277d) {
        C2583a c2583a = new C2583a();
        c2583a.f20425b = AbstractC2277d.m9056d(abstractC2277d);
        CRC32 crc32 = new CRC32();
        crc32.update(c2583a.f20425b);
        c2583a.f20426c = crc32.getValue();
        return AbstractC2277d.m9056d(c2583a);
    }

    /* JADX INFO: renamed from: a */
    public final void applyJournal(C2586d c2586d) {
        this.f16600h = c2586d.f20452c;
        HashSet hashSet = this.f16594b;
        hashSet.clear();
        C2587e[] c2587eArr = c2586d.f20455f;
        if (c2587eArr != null) {
            for (C2587e c2587e : c2587eArr) {
                hashSet.add(keyToBackupKey(c2587e));
            }
        }
        this.f16608p = c2586d.f20456g;
    }

    /* JADX INFO: renamed from: b */
    public final void backupFavorites(BackupDataOutput backupDataOutput) throws IOException {
        Cursor cursorQuery = this.f16593a.getContentResolver().query(Favorites.f15684a, f16591r, m8094j(), null, null);
        try {
            cursorQuery.moveToPosition(-1);
            while (cursorQuery.moveToNext()) {
                long j6 = cursorQuery.getLong(0);
                long j7 = cursorQuery.getLong(1);
                C2587e c2587e = new C2587e();
                c2587e.f20459b = 1;
                c2587e.f20461d = j6;
                c2587e.f20462e = checkKey(c2587e);
                this.f16595c.add(c2587e);
                if (!this.f16594b.contains(Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2)) || j7 >= this.f16600h || this.f16608p < 4) {
                    writeRowToBackup(Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2), packFavorite(cursorQuery), backupDataOutput);
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void backupIcons(BackupDataOutput backupDataOutput) {
        C2587e c2587e;
        String strEncodeToString;
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.f16593a;
        ContentResolver contentResolver = launcherBackupAgentHelper.getContentResolver();
        int i6 = launcherBackupAgentHelper.getResources().getDisplayMetrics().densityDpi;
        C2673q c2673qM9672b = C2673q.m9672b();
        Cursor cursorQuery = contentResolver.query(Favorites.f15684a, f16591r, "(itemType=0 OR itemType=1) AND " + m8094j(), null, null);
        try {
            cursorQuery.moveToPosition(-1);
            int i7 = 0;
            while (cursorQuery.moveToNext()) {
                cursorQuery.getLong(0);
                try {
                    Intent uri = Intent.parseUri(cursorQuery.getString(2), 0);
                    ComponentName component = uri.getComponent();
                    if (component != null) {
                        String strFlattenToShortString = component.flattenToShortString();
                        c2587e = new C2587e();
                        c2587e.f20459b = 3;
                        c2587e.f20460c = strFlattenToShortString;
                        c2587e.f20462e = checkKey(c2587e);
                        strEncodeToString = Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2);
                    } else {
                        c2587e = null;
                        strEncodeToString = null;
                    }
                    boolean zContains = this.f16594b.contains(strEncodeToString);
                    ArrayList arrayList = this.f16595c;
                    if (zContains) {
                        arrayList.add(c2587e);
                    } else if (strEncodeToString != null) {
                        if (i7 < 10) {
                            Bitmap bitmapM8015p = this.f16602j.m8015p(uri, c2673qM9672b);
                            if (bitmapM8015p != null && !this.f16602j.isDefaultIcon(bitmapM8015p, c2673qM9672b)) {
                                writeRowToBackup(keyToBackupKey(c2587e), packIcon(i6, bitmapM8015p), backupDataOutput);
                                arrayList.add(c2587e);
                                i7++;
                            }
                        } else {
                            dataChanged();
                        }
                    }
                } catch (IOException | URISyntaxException unused) {
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void backupScreens(BackupDataOutput backupDataOutput) throws IOException {
        Cursor cursorQuery = this.f16593a.getContentResolver().query(WorkspaceScreens.f15734a, f16592s, null, null, null);
        try {
            cursorQuery.moveToPosition(-1);
            while (cursorQuery.moveToNext()) {
                long j6 = cursorQuery.getLong(0);
                long j7 = cursorQuery.getLong(1);
                C2587e c2587e = new C2587e();
                c2587e.f20459b = 2;
                c2587e.f20461d = j6;
                c2587e.f20462e = checkKey(c2587e);
                this.f16595c.add(c2587e);
                if (!this.f16594b.contains(Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2)) || j7 >= this.f16600h) {
                    C2589g c2589g = new C2589g();
                    c2589g.f20465b = cursorQuery.getLong(0);
                    c2589g.f20466c = cursorQuery.getInt(2);
                    writeRowToBackup(Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2), c2589g, backupDataOutput);
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void backupWidgets(BackupDataOutput backupDataOutput) {
        C2587e c2587e;
        String strEncodeToString;
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.f16593a;
        ContentResolver contentResolver = launcherBackupAgentHelper.getContentResolver();
        int i6 = launcherBackupAgentHelper.getResources().getDisplayMetrics().densityDpi;
        Cursor cursorQuery = contentResolver.query(Favorites.f15684a, f16591r, "itemType=4 AND " + m8094j(), null, null);
        AbstractC2659c abstractC2659cM9639f = AbstractC2659c.m9639f(launcherBackupAgentHelper);
        if (cursorQuery != null) {
            try {
                cursorQuery.moveToPosition(-1);
                int i7 = 0;
                while (cursorQuery.moveToNext()) {
                    cursorQuery.getLong(0);
                    String string = cursorQuery.getString(3);
                    if (ComponentName.unflattenFromString(string) != null) {
                        c2587e = new C2587e();
                        c2587e.f20459b = 4;
                        c2587e.f20460c = string;
                        c2587e.f20462e = checkKey(c2587e);
                        strEncodeToString = Base64.encodeToString(AbstractC2277d.m9056d(c2587e), 2);
                    } else {
                        c2587e = null;
                        strEncodeToString = null;
                    }
                    boolean zContains = this.f16594b.contains(strEncodeToString);
                    ArrayList arrayList = this.f16595c;
                    if (zContains && this.f16608p >= 3) {
                        arrayList.add(c2587e);
                    } else if (strEncodeToString != null) {
                        if (i7 < 5) {
                            LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfoM9645g = abstractC2659cM9639f.m9645g(cursorQuery.getInt(4));
                            if (launcherAppWidgetProviderInfoM9645g != null) {
                                writeRowToBackup(keyToBackupKey(c2587e), m8097p(i6, launcherAppWidgetProviderInfoM9645g), backupDataOutput);
                                arrayList.add(c2587e);
                                i7++;
                            }
                        } else {
                            dataChanged();
                        }
                    }
                }
            } catch (Throwable th) {
                cursorQuery.close();
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }

    /* JADX INFO: renamed from: h */
    public final void dataChanged() {
        if (this.f16598f == null) {
            this.f16598f = new BackupManager(this.f16593a);
        }
        this.f16598f.dataChanged();
    }

    /* JADX INFO: renamed from: i */
    public final C2586d getAppVersion() {
        C2586d c2586d = new C2586d();
        c2586d.f20452c = this.f16600h;
        int i6 = 0;
        c2586d.f20455f = (C2587e[]) this.f16595c.toArray(new C2587e[0]);
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.f16593a;
        try {
            i6 = launcherBackupAgentHelper.getPackageManager().getPackageInfo(launcherBackupAgentHelper.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        c2586d.f20451b = i6;
        c2586d.f20456g = 4;
        c2586d.f20457h = this.f16603k;
        return c2586d;
    }

    /* JADX INFO: renamed from: j */
    public final String m8094j() {
        return "profileId=" + C2674r.m9673e(this.f16593a).mo9676f(C2673q.m9672b());
    }

    /* JADX INFO: renamed from: l */
    public final boolean m8095l(C2586d c2586d) {
        boolean z5;
        C2584b c2584b = this.f16603k;
        C2584b c2584b2 = c2586d.f20457h;
        if (c2584b2 != null) {
            float f6 = c2584b2.f20428c;
            if (f6 != 0.0f) {
                int i6 = c2584b.f20430e;
                float f7 = i6;
                float f8 = c2584b2.f20429d;
                if (f7 >= f8) {
                    this.f16609q = 0;
                    z5 = true;
                } else {
                    z5 = false;
                }
                int i7 = c2584b2.f20430e;
                if (i6 >= i7 && c2584b.f20429d - f7 >= f8 - i7) {
                    this.f16609q = i6 - i7;
                    z5 = true;
                }
                if (z5) {
                    if (c2584b.f20428c < f6 || c2584b.f20427b < c2584b2.f20427b) {
                        if (C3030e.f21954q) {
                            C2584b c2584bM8082k = m8082k(this.f16604l);
                            this.f16605m = c2584bM8082k;
                            c2584bM8082k.f20428c = c2584b2.f20428c;
                            c2584bM8082k.f20427b = c2584b2.f20427b;
                            c2584bM8082k.f20429d = c2584b2.f20429d;
                            c2584bM8082k.f20430e = c2584b2.f20430e;
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: n */
    public final C2585c packFavorite(Cursor cursor) {
        Intent uri;
        int i6;
        C2585c c2585c = new C2585c();
        c2585c.f20431b = cursor.getLong(0);
        c2585c.f20435f = cursor.getInt(13);
        c2585c.f20434e = cursor.getInt(7);
        c2585c.f20436g = cursor.getInt(5);
        c2585c.f20437h = cursor.getInt(6);
        c2585c.f20438i = cursor.getInt(14);
        c2585c.f20439j = cursor.getInt(15);
        c2585c.f20445p = cursor.getInt(11);
        c2585c.f20450u = cursor.getInt(18);
        String string = cursor.getString(16);
        if (!TextUtils.isEmpty(string)) {
            c2585c.f20433d = string;
        }
        String string2 = cursor.getString(2);
        ActivityInfo activityInfo = null;
        if (TextUtils.isEmpty(string2)) {
            uri = null;
        } else {
            try {
                uri = Intent.parseUri(string2, 0);
                try {
                    uri.removeExtra("profile");
                    c2585c.f20443n = uri.toUri(0);
                } catch (Exception unused) {
                }
            } catch (URISyntaxException unused2) {
                uri = null;
            }
        }
        int i7 = cursor.getInt(12);
        c2585c.f20432c = i7;
        if (i7 == 4) {
            c2585c.f20441l = cursor.getInt(4);
            String string3 = cursor.getString(3);
            if (!TextUtils.isEmpty(string3)) {
                c2585c.f20442m = string3;
            }
        } else if (i7 == 1) {
            if (c2585c.f20445p == 0) {
                String string4 = cursor.getString(9);
                if (!TextUtils.isEmpty(string4)) {
                    c2585c.f20446q = string4;
                }
                String string5 = cursor.getString(10);
                if (!TextUtils.isEmpty(string5)) {
                    c2585c.f20447r = string5;
                }
            }
            byte[] blob = cursor.getBlob(8);
            if (blob != null && blob.length > 0) {
                c2585c.f20448s = blob;
            }
        }
        if (c2585c.f20434e == -101 && c2585c.f20443n != null && (((i6 = c2585c.f20432c) == 0 || i6 == 1) && uri != null && uri.getComponent() != null)) {
            PackageManager packageManager = this.f16593a.getPackageManager();
            try {
                activityInfo = packageManager.getActivityInfo(uri.getComponent(), 0);
            } catch (PackageManager.NameNotFoundException unused3) {
            }
            if (activityInfo != null) {
                int i8 = 0;
                loop0: while (true) {
                    MergedItemCallbacks[] mergedItemCallbacksArr = this.f16596d;
                    if (i8 >= mergedItemCallbacksArr.length) {
                        break;
                    }
                    if (mergedItemCallbacksArr[i8] == null) {
                        mergedItemCallbacksArr[i8] = new MergedItemCallbacks(this, CommonAppTypeParser.getResourceForItemType(i8));
                    }
                    ArrayList arrayList = (ArrayList) mergedItemCallbacksArr[i8].f17234k;
                    int size = arrayList.size();
                    int i9 = 0;
                    while (i9 < size) {
                        Object obj = arrayList.get(i9);
                        i9++;
                        Intent intent = (Intent) obj;
                        intent.setPackage(activityInfo.packageName);
                        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
                        if (resolveInfoResolveActivity != null && (resolveInfoResolveActivity.activityInfo.name.equals(activityInfo.name) || resolveInfoResolveActivity.activityInfo.name.equals(activityInfo.targetActivity))) {
                            c2585c.f20449t = i8;
                            break loop0;
                        }
                    }
                    i8++;
                }
            }
        }
        return c2585c;
    }

    /* JADX INFO: renamed from: p */
    public final C2590h m8097p(int i6, LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo) {
        Resources resourcesForApplication;
        C2590h c2590h = new C2590h();
        c2590h.f20467b = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).provider.flattenToShortString();
        c2590h.f20468c = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).label;
        c2590h.f20469d = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).configure != null;
        if (((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).icon != 0) {
            c2590h.f20470e = new C2588f();
            IconCache iconCache = this.f16602j;
            String packageName = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).provider.getPackageName();
            int i7 = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).icon;
            iconCache.getClass();
            try {
                resourcesForApplication = iconCache.f16349h.getResourcesForApplication(packageName);
            } catch (PackageManager.NameNotFoundException unused) {
                resourcesForApplication = null;
            }
            c2590h.f20470e.f20464c = Utilities.flattenBitmap(Utilities.createIconBitmap((resourcesForApplication == null || i7 == 0) ? iconCache.getFullResDefaultActivityIcon() : iconCache.m8013n(i7, resourcesForApplication), this.f16593a));
            c2590h.f20470e.f20463b = i6;
        }
        int i8 = ((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).resizeMode;
        Point point = new Point((i8 & 1) != 0 ? launcherAppWidgetProviderInfo.f16576l : -1, (i8 & 2) != 0 ? launcherAppWidgetProviderInfo.f16577m : -1);
        c2590h.f20472g = point.x;
        c2590h.f20473h = point.y;
        return c2590h;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00f6  */
    @Override // android.app.backup.BackupHelper
    public final void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z5 = false;
        int i6;
        C2586d c2586d = new C2586d();
        if (parcelFileDescriptor != null) {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor.getFileDescriptor());
            try {
                int iAvailable = fileInputStream.available();
                if (iAvailable < 1000000) {
                    byte[] bArr = new byte[iAvailable];
                    int i7 = 0;
                    while (iAvailable > 0) {
                        try {
                            int i8 = fileInputStream.read(bArr, i7, 1);
                            if (i8 > 0) {
                                iAvailable -= i8;
                                i7 += i8;
                            } else {
                                iAvailable = 0;
                            }
                        } catch (IOException unused) {
                            bArr = null;
                        }
                        try {
                            byte[] checkedBytes = readCheckedBytes(i7, bArr);
                            AbstractC2277d.m9055c(c2586d, checkedBytes, checkedBytes.length);
                            iAvailable = 0;
                        } catch (C2276c unused2) {
                            c2586d.m9498f();
                        }
                    }
                }
            } catch (IOException unused3) {
            }
        }
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.f16593a;
        Cursor cursorQuery = launcherBackupAgentHelper.getContentResolver().query(Favorites.f15684a, f16591r, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.close();
            if (LauncherAppState.f16217j != null) {
                if (this.f16603k == null) {
                    LauncherAppState launcherAppState = LauncherAppState.getInstance();
                    InvariantDeviceProfile invariantDeviceProfile = launcherAppState.f16222e;
                    this.f16604l = invariantDeviceProfile;
                    this.f16603k = m8082k(invariantDeviceProfile);
                    this.f16602j = launcherAppState.f16219b;
                }
                ArrayList arrayList = this.f16595c;
                arrayList.clear();
                applyJournal(c2586d);
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f16601i = false;
                try {
                    backupFavorites(backupDataOutput);
                    backupScreens(backupDataOutput);
                    backupIcons(backupDataOutput);
                    backupWidgets(backupDataOutput);
                    HashSet hashSet = new HashSet();
                    int size = arrayList.size();
                    int i9 = 0;
                    while (i9 < size) {
                        Object obj = arrayList.get(i9);
                        i9++;
                        hashSet.add(keyToBackupKey((C2587e) obj));
                    }
                    HashSet hashSet2 = this.f16594b;
                    hashSet2.removeAll(hashSet);
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        backupDataOutput.writeEntityHeader((String) it.next(), -1);
                        this.f16601i = true;
                    }
                    hashSet2.clear();
                    if (!this.f16601i) {
                        C2584b c2584b = c2586d.f20457h;
                        if (c2584b != null && Arrays.equals(AbstractC2277d.m9056d(c2584b), AbstractC2277d.m9056d(this.f16603k)) && c2586d.f20456g == 4) {
                            int i10 = c2586d.f20451b;
                            try {
                                i6 = launcherBackupAgentHelper.getPackageManager().getPackageInfo(launcherBackupAgentHelper.getPackageName(), 0).versionCode;
                            } catch (PackageManager.NameNotFoundException unused4) {
                                i6 = 0;
                            }
                            z5 = i10 != i6;
                        }
                        this.f16601i = z5;
                    }
                    if (this.f16601i) {
                        this.f16600h = jCurrentTimeMillis;
                        writeRowToBackup("#", getAppVersion(), backupDataOutput);
                    }
                } catch (IOException unused5) {
                }
                writeNewStateDescription(parcelFileDescriptor2);
                return;
            }
        }
        dataChanged();
        try {
            new FileOutputStream(parcelFileDescriptor2.getFileDescriptor()).write(writeCheckedBytes(c2586d));
        } catch (IOException unused6) {
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m8098r(int i6, byte[] bArr) throws C2276c, C1614c {
        int i7;
        LauncherBackupAgentHelper launcherBackupAgentHelper = this.f16593a;
        ContentResolver contentResolver = launcherBackupAgentHelper.getContentResolver();
        C2585c c2585c = new C2585c();
        byte[] checkedBytes = readCheckedBytes(i6, bArr);
        AbstractC2277d.m9055c(c2585c, checkedBytes, checkedBytes.length);
        if (c2585c.f20434e == -101) {
            c2585c.f20435f += this.f16609q;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(c2585c.f20431b));
        contentValues.put("screen", Integer.valueOf(c2585c.f20435f));
        contentValues.put("container", Integer.valueOf(c2585c.f20434e));
        contentValues.put("cellX", Integer.valueOf(c2585c.f20436g));
        contentValues.put("cellY", Integer.valueOf(c2585c.f20437h));
        contentValues.put("spanX", Integer.valueOf(c2585c.f20438i));
        contentValues.put("spanY", Integer.valueOf(c2585c.f20439j));
        contentValues.put("rank", Integer.valueOf(c2585c.f20450u));
        if (c2585c.f20432c == 1) {
            contentValues.put("iconType", Integer.valueOf(c2585c.f20445p));
            if (c2585c.f20445p == 0) {
                contentValues.put("iconPackage", c2585c.f20446q);
                contentValues.put("iconResource", c2585c.f20447r);
            }
            contentValues.put("icon", c2585c.f20448s);
        }
        if (TextUtils.isEmpty(c2585c.f20433d)) {
            contentValues.put("title", "");
        } else {
            contentValues.put("title", c2585c.f20433d);
        }
        if (!TextUtils.isEmpty(c2585c.f20443n)) {
            contentValues.put("intent", c2585c.f20443n);
        }
        contentValues.put("itemType", Integer.valueOf(c2585c.f20432c));
        contentValues.put("profileId", Long.valueOf(C2674r.m9673e(launcherBackupAgentHelper).mo9676f(C2673q.m9672b())));
        C2584b c2584b = this.f16605m;
        if (c2584b == null) {
            c2584b = this.f16603k;
        }
        int i8 = c2585c.f20432c;
        if (i8 == 4) {
            if (!TextUtils.isEmpty(c2585c.f20442m)) {
                contentValues.put("appWidgetProvider", c2585c.f20442m);
            }
            contentValues.put("appWidgetId", Integer.valueOf(c2585c.f20441l));
            contentValues.put("restored", (Integer) 7);
            if (c2585c.f20436g + c2585c.f20438i > c2584b.f20428c || c2585c.f20437h + c2585c.f20439j > c2584b.f20427b) {
                this.f16607o = false;
                throw new C1614c("Widget not in screen bounds, aborting restore");
            }
        } else {
            if (c2585c.f20434e != -101 || c2585c.f20443n == null || (!(i8 == 0 || i8 == 1) || (i7 = c2585c.f20449t) == 0 || i7 >= 7)) {
                contentValues.put("restored", (Integer) 1);
            } else {
                contentValues.put("restored", Integer.valueOf(CommonAppTypeParser.encodeItemTypeToFlag(i7) | 1));
            }
            if (c2585c.f20434e == -101) {
                int i9 = c2585c.f20435f;
                if (i9 >= c2584b.f20429d || i9 == c2584b.f20430e) {
                    this.f16607o = false;
                    throw new C1614c("Item not in hotseat bounds, aborting restore");
                }
            } else if (c2585c.f20436g >= c2584b.f20428c || c2585c.f20437h >= c2584b.f20427b) {
                this.f16607o = false;
                throw new C1614c("Item not in desktop bounds, aborting restore");
            }
        }
        contentResolver.insert(Favorites.f15684a, contentValues);
    }

    @Override // android.app.backup.BackupHelper
    public final void restoreEntity(BackupDataInputStream backupDataInputStream) {
        if (this.f16607o) {
            if (this.f16603k == null) {
                LauncherBackupAgentHelper launcherBackupAgentHelper = this.f16593a;
                InvariantDeviceProfile invariantDeviceProfile = new InvariantDeviceProfile(launcherBackupAgentHelper);
                this.f16604l = invariantDeviceProfile;
                this.f16603k = m8082k(invariantDeviceProfile);
                this.f16602j = new IconCache(launcherBackupAgentHelper, this.f16604l);
            }
            int size = backupDataInputStream.size();
            if (this.f16599g.length < size) {
                this.f16599g = new byte[size];
            }
            try {
                backupDataInputStream.read(this.f16599g, 0, size);
                String key = backupDataInputStream.getKey();
                boolean zEquals = "#".equals(key);
                ArrayList arrayList = this.f16595c;
                if (zEquals) {
                    if (!arrayList.isEmpty()) {
                        keyToBackupKey((C2587e) arrayList.get(0));
                        this.f16607o = false;
                        return;
                    }
                    C2586d c2586d = new C2586d();
                    byte[] checkedBytes = readCheckedBytes(size, this.f16599g);
                    AbstractC2277d.m9055c(c2586d, checkedBytes, checkedBytes.length);
                    applyJournal(c2586d);
                    this.f16607o = m8095l(c2586d);
                    return;
                }
                HashSet hashSet = this.f16594b;
                if (hashSet.isEmpty() || hashSet.contains(key)) {
                    C2587e c2587eBackupKeyToKey = backupKeyToKey(key);
                    arrayList.add(c2587eBackupKeyToKey);
                    int i6 = c2587eBackupKeyToKey.f20459b;
                    if (i6 == 1) {
                        m8098r(size, this.f16599g);
                        return;
                    }
                    if (i6 == 2) {
                        m8100t(size, this.f16599g);
                        return;
                    }
                    if (i6 == 3) {
                        m8099s(c2587eBackupKeyToKey, this.f16599g, size);
                    } else if (i6 != 4) {
                        arrayList.remove(c2587eBackupKeyToKey);
                    } else {
                        m8101u(c2587eBackupKeyToKey, this.f16599g, size);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m8099s(C2587e c2587e, byte[] bArr, int i6) throws C2276c {
        C2588f c2588f = new C2588f();
        byte[] checkedBytes = readCheckedBytes(i6, bArr);
        AbstractC2277d.m9055c(c2588f, checkedBytes, checkedBytes.length);
        byte[] bArr2 = c2588f.f20464c;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
        if (bitmapDecodeByteArray == null) {
            return;
        }
        this.f16602j.m7990C(ComponentName.unflattenFromString(c2587e.f20460c), bitmapDecodeByteArray, "", this.f16597e, this.f16604l);
    }

    /* JADX INFO: renamed from: t */
    public final void m8100t(int i6, byte[] bArr) throws C2276c {
        ContentResolver contentResolver = this.f16593a.getContentResolver();
        C2589g c2589g = new C2589g();
        byte[] checkedBytes = readCheckedBytes(i6, bArr);
        AbstractC2277d.m9055c(c2589g, checkedBytes, checkedBytes.length);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Long.valueOf(c2589g.f20465b));
        contentValues.put("screenRank", Integer.valueOf(c2589g.f20466c));
        contentResolver.insert(WorkspaceScreens.f15734a, contentValues);
    }

    /* JADX INFO: renamed from: u */
    public final void m8101u(C2587e c2587e, byte[] bArr, int i6) throws C2276c {
        Bitmap bitmapDecodeByteArray;
        C2590h c2590h = new C2590h();
        byte[] checkedBytes = readCheckedBytes(i6, bArr);
        AbstractC2277d.m9055c(c2590h, checkedBytes, checkedBytes.length);
        byte[] bArr2 = c2590h.f20470e.f20464c;
        if (bArr2 != null && (bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length)) != null) {
            IconCache iconCache = this.f16602j;
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(c2590h.f20467b);
            int i7 = c2590h.f20470e.f20463b;
            iconCache.m7990C(componentNameUnflattenFromString, bitmapDecodeByteArray, c2590h.f20468c, this.f16597e, this.f16604l);
        }
        this.f16606n.add(c2590h.f20467b + "#" + c2590h.f20472g + "," + c2590h.f20473h);
    }

    /* JADX INFO: renamed from: w */
    public final void writeRowToBackup(String str, AbstractC2277d abstractC2277d, BackupDataOutput backupDataOutput) throws IOException {
        byte[] bArrWriteCheckedBytes = writeCheckedBytes(abstractC2277d);
        backupDataOutput.writeEntityHeader(str, bArrWriteCheckedBytes.length);
        backupDataOutput.writeEntityData(bArrWriteCheckedBytes, bArrWriteCheckedBytes.length);
        this.f16601i = true;
    }

    @Override // android.app.backup.BackupHelper
    public final void writeNewStateDescription(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            new FileOutputStream(parcelFileDescriptor.getFileDescriptor()).write(writeCheckedBytes(getAppVersion()));
        } catch (IOException unused) {
        }
    }
}
