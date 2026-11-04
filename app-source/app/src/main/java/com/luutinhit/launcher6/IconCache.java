package com.luutinhit.launcher6;

import B3.C0059b;
import G3.RunnableC0360p;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.Al;
import com.luutinhit.launcherios.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import p122r3.AbstractC2662f;
import p122r3.AbstractC2666j;
import p122r3.C2673q;
import p122r3.C2674r;
import p154y3.C3031f;

/* JADX INFO: renamed from: com.luutinhit.launcher6.d1 */
/* JADX INFO: loaded from: classes.dex */
public final class IconCache {

    /* JADX INFO: renamed from: t */
    public static final Object f16341t = new Object();

    /* JADX INFO: renamed from: b */
    public C2674r f16343b;

    /* JADX INFO: renamed from: c */
    public IconDB f16344c;

    /* JADX INFO: renamed from: d */
    public Handler f16345d;

    /* JADX INFO: renamed from: g */
    public Context f16348g;

    /* JADX INFO: renamed from: h */
    public PackageManager f16349h;

    /* JADX INFO: renamed from: i */
    public AbstractC2666j f16350i;

    /* JADX INFO: renamed from: j */
    public SharedPreferences f16351j;

    /* JADX INFO: renamed from: l */
    public int f16353l;

    /* JADX INFO: renamed from: m */
    public int mActivityBgColor;

    /* JADX INFO: renamed from: n */
    public int mPackageBgColor;

    /* JADX INFO: renamed from: o */
    public BitmapFactory.Options f16356o;

    /* JADX INFO: renamed from: p */
    public String f16357p;

    /* JADX INFO: renamed from: q */
    public Bitmap f16358q;

    /* JADX INFO: renamed from: r */
    public Canvas f16359r;

    /* JADX INFO: renamed from: s */
    public Paint f16360s;

    /* JADX INFO: renamed from: a */
    public MainThreadExecutor f16342a = new MainThreadExecutor();

    /* JADX INFO: renamed from: e */
    public HashMap f16346e = new HashMap();

    /* JADX INFO: renamed from: f */
    public HashMap f16347f = new HashMap();

    /* JADX INFO: renamed from: k */
    public HashMap f16352k = new HashMap(50);

    public IconCache(Context context, InvariantDeviceProfile invariantDeviceProfile) {
        this.f16348g = context;
        this.f16349h = context.getPackageManager();
        this.f16343b = C2674r.m9673e(context);
        this.f16350i = AbstractC2666j.m9657c(context);
        Rect rect = Utilities.sOldBounds;
        this.f16351j = context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0);
        this.f16353l = invariantDeviceProfile.f16717i;
        this.f16344c = new IconDB(context, "app_icons.db", 655360 + invariantDeviceProfile.f16716h, "icons", 0);
        this.f16345d = new Handler(LauncherModel.sWorkerThread.getLooper());
        this.mActivityBgColor = context.getResources().getColor(R.color.quantum_panel_bg_color);
        this.mPackageBgColor = context.getResources().getColor(R.color.quantum_panel_bg_color_dark);
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f16356o = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        this.f16357p = Locale.getDefault().toString();
    }

    /* JADX INFO: renamed from: s */
    public static C0059b m7987s(String str, C2673q c2673q) {
        Objects.toString(c2673q);
        return new C0059b(new ComponentName(str, SyntheticHelpers.m7913l(str, ".")), c2673q);
    }

    /* JADX INFO: renamed from: A */
    public final ContentValues newContentValues(Bitmap bitmap, String str, int i6, int i7, int i8, String str2, int i9) {
        Objects.toString(bitmap);
        ContentValues contentValues = new ContentValues();
        contentValues.put("icon", Utilities.flattenBitmap(bitmap));
        contentValues.put("history", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("label", str);
        contentValues.put("system_state", this.f16357p);
        contentValues.put("customIcon", Integer.valueOf(i7));
        if (i7 > 0) {
            try {
                if (i9 == 1 && i8 > 0) {
                    contentValues.put("data1", (Integer) 0);
                    contentValues.put("iconName", this.f16348g.getResources().getResourceEntryName(i8));
                } else if (i9 == 2) {
                    if (!TextUtils.isEmpty(str2)) {
                        contentValues.put("data1", (Integer) 1);
                        contentValues.put("iconName", str2);
                    }
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        if (i6 == 0) {
            contentValues.put("icon_low_res", Utilities.flattenBitmap(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 5, bitmap.getHeight() / 5, true)));
        } else {
            synchronized (this) {
                try {
                    if (this.f16358q == null) {
                        this.f16358q = Bitmap.createBitmap(bitmap.getWidth() / 5, bitmap.getHeight() / 5, Bitmap.Config.RGB_565);
                        this.f16359r = new Canvas(this.f16358q);
                        this.f16360s = new Paint(3);
                    }
                    this.f16359r.drawColor(i6);
                    this.f16359r.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.f16358q.getWidth(), this.f16358q.getHeight()), this.f16360s);
                    contentValues.put("icon_low_res", Utilities.flattenBitmap(this.f16358q));
                } catch (Throwable th2) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                }
            }
        }
        return contentValues;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m7989B(C0059b c0059b, IconCacheEntry iconCacheEntry, boolean z5) {
        String str;
        ComponentName componentName = c0059b.f149a;
        C2674r c2674r = this.f16343b;
        Objects.toString(c0059b);
        Objects.toString(iconCacheEntry);
        Cursor cursor = null;
        Bitmap bitmapDecodeByteArray = null;
        Cursor cursor2 = null;
        try {
            IconDB iconDB = this.f16344c;
            String[] strArr = {z5 ? "icon_low_res" : "icon", "label"};
            C2673q c2673q = c0059b.f150b;
            Cursor cursorM120h = iconDB.m120h("componentName = ? AND profileId = ?", strArr, new String[]{componentName.flattenToString(), Long.toString(c2674r.mo9676f(c2673q))});
            try {
                if (!cursorM120h.moveToNext()) {
                    cursorM120h.close();
                    return true;
                }
                BitmapFactory.Options options = z5 ? this.f16356o : null;
                Objects.toString(cursorM120h);
                Objects.toString(options);
                try {
                    byte[] blob = cursorM120h.getBlob(0);
                    bitmapDecodeByteArray = BitmapFactory.decodeByteArray(blob, 0, blob.length, options);
                } catch (Throwable unused) {
                }
                iconCacheEntry.f16211a = bitmapDecodeByteArray;
                iconCacheEntry.f16214d = z5;
                String string = cursorM120h.getString(1);
                iconCacheEntry.f16212b = string;
                if (string == null) {
                    Context context = this.f16348g;
                    String packageName = componentName.getPackageName();
                    Rect rect = Utilities.sOldBounds;
                    try {
                        PackageManager packageManager = context.getPackageManager();
                        str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 128));
                    } catch (Throwable unused2) {
                        str = "";
                    }
                    iconCacheEntry.f16212b = str;
                    iconCacheEntry.f16213c = "";
                } else {
                    iconCacheEntry.f16213c = c2674r.mo9675b(string, c2673q);
                }
                cursorM120h.close();
                return false;
            } catch (SQLiteException unused3) {
                cursor2 = cursorM120h;
                if (cursor2 != null) {
                    cursor2.close();
                }
                return true;
            } catch (Throwable th) {
                cursor = cursorM120h;
                if (cursor != null) {
                    cursor.close();
                }
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        } catch (SQLiteException unused4) {
        } catch (Throwable th2) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
        }
        return false; // jadx: method fell off the end
    }

    /* JADX INFO: renamed from: C */
    public final void m7990C(ComponentName componentName, Bitmap bitmap, String str, long j6, InvariantDeviceProfile invariantDeviceProfile) {
        Objects.toString(componentName);
        Objects.toString(bitmap);
        Objects.toString(invariantDeviceProfile);
        try {
            this.f16348g.getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            String strM8008i = m8008i(componentName);
            String str2 = strM8008i != null ? strM8008i : str;
            if (str2 != null) {
                int i6 = invariantDeviceProfile.f16716h;
                ContentValues contentValuesNewContentValues = newContentValues(Bitmap.createScaledBitmap(bitmap, i6, i6, true), str2, 0, 0, 0, null, 0);
                contentValuesNewContentValues.put("componentName", componentName.flattenToString());
                contentValuesNewContentValues.put("profileId", Long.valueOf(j6));
                this.f16344c.m117e(contentValuesNewContentValues);
            }
        }
    }

    /* JADX INFO: renamed from: D */
    public final synchronized void m7991D(ComponentName componentName, C2673q c2673q) {
        Objects.toString(componentName);
        Objects.toString(c2673q);
        this.f16352k.remove(new C0059b(componentName, c2673q));
        this.f16346e.remove(componentName.getPackageName());
    }

    /* JADX INFO: renamed from: E */
    public final void removeFromMemCacheLocked(String str, C2673q c2673q) {
        Objects.toString(c2673q);
        HashSet<C0059b> hashSet = new HashSet();
        HashMap map = this.f16352k;
        for (C0059b c0059b : (Iterable<C0059b>) (Iterable) (map.keySet())) {
            if (c0059b.f149a.getPackageName().equals(str) && c0059b.f150b.equals(c2673q)) {
                hashSet.add(c0059b);
            }
        }
        for (C0059b c0059b2 : hashSet) {
            if (c0059b2 != null) {
                map.remove(c0059b2);
                ComponentName componentName = c0059b2.f149a;
                if (componentName != null) {
                    this.f16346e.remove(componentName.getPackageName());
                }
            }
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m7993F(String str, C2673q c2673q) {
        Objects.toString(c2673q);
        HashSet<C0059b> hashSet = new HashSet();
        HashMap map = this.f16352k;
        for (C0059b c0059b : (Iterable<C0059b>) (Iterable) (map.keySet())) {
            if (c0059b.f149a.flattenToString().equals(str) && c0059b.f150b.equals(c2673q)) {
                hashSet.add(c0059b);
            }
        }
        for (C0059b c0059b2 : hashSet) {
            if (c0059b2 != null) {
                map.remove(c0059b2);
                ComponentName componentName = c0059b2.f149a;
                if (componentName != null) {
                    this.f16346e.remove(componentName.getPackageName());
                }
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final synchronized void m7994G(String str, C2673q c2673q) {
        Objects.toString(c2673q);
        m7993F(str, c2673q);
        this.f16344c.m113a("componentName = ? AND profileId = ?", new String[]{str, Long.toString(this.f16343b.mo9676f(c2673q))});
    }

    /* JADX INFO: renamed from: H */
    public final synchronized void removeIconsForPkg(String str, C2673q c2673q) {
        Objects.toString(c2673q);
        removeFromMemCacheLocked(str, c2673q);
        long jMo9676f = this.f16343b.mo9676f(c2673q);
        this.f16344c.m113a("componentName LIKE ? AND profileId = ?", new String[]{str + "/%", Long.toString(jMo9676f)});
    }

    /* JADX INFO: renamed from: I */
    public final ContentValues m7996I(AbstractC2662f abstractC2662f) {
        Objects.toString(abstractC2662f);
        ComponentName componentNameMo9652b = abstractC2662f.mo9652b();
        C0059b c0059b = new C0059b(componentNameMo9652b, abstractC2662f.mo9656f());
        int i6 = 0;
        IconCacheEntry iconCacheEntry = null;
        PackageIconKey packageIconKey = new PackageIconKey(0, (String) null, 1);
        HashMap map = this.f16352k;
        IconCacheEntry iconCacheEntry2 = (IconCacheEntry) map.get(c0059b);
        if (iconCacheEntry2 != null && !iconCacheEntry2.f16214d && iconCacheEntry2.f16211a != null) {
            iconCacheEntry = iconCacheEntry2;
        }
        if (iconCacheEntry == null) {
            iconCacheEntry = new IconCacheEntry();
            packageIconKey = m8007h(c0059b);
            if (packageIconKey.f16320c == 1) {
                packageIconKey.f16319b = m8017r(c0059b, packageIconKey.f16319b, String.valueOf(abstractC2662f.mo9655e()), abstractC2662f.mo9651a());
            }
            Drawable drawableM8010k = m8010k(packageIconKey);
            Context context = this.f16348g;
            if (drawableM8010k != null) {
                iconCacheEntry.f16211a = m8016q(Utilities.m8150b(drawableM8010k, abstractC2662f.mo9656f(), context));
                i6 = 1;
            } else {
                iconCacheEntry.f16211a = m8016q(Utilities.m8150b(abstractC2662f.mo9654d(this.f16353l), abstractC2662f.mo9656f(), context));
            }
        }
        CharSequence charSequenceM8008i = m8008i(componentNameMo9652b);
        if (charSequenceM8008i == null) {
            charSequenceM8008i = abstractC2662f.mo9655e();
        }
        iconCacheEntry.f16212b = charSequenceM8008i;
        iconCacheEntry.f16213c = this.f16343b.mo9675b(charSequenceM8008i, abstractC2662f.mo9656f());
        map.put(new C0059b(abstractC2662f.mo9652b(), abstractC2662f.mo9656f()), iconCacheEntry);
        return newContentValues(iconCacheEntry.f16211a, iconCacheEntry.f16212b.toString(), this.mActivityBgColor, i6, packageIconKey.f16319b, packageIconKey.f16318a, packageIconKey.f16320c);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0199 A[PHI: r13 r18 r21 r25
  0x0199: PHI (r13v2 android.database.Cursor) = (r13v3 android.database.Cursor), (r13v5 android.database.Cursor) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0199: PHI (r18v2 long) = (r18v4 long), (r18v5 long) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0199: PHI (r21v2 java.util.HashMap) = (r21v4 java.util.HashMap), (r21v8 java.util.HashMap) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0199: PHI (r25v2 java.util.HashMap) = (r25v4 java.util.HashMap), (r25v8 java.util.HashMap) binds: [B:68:0x01b4, B:58:0x0195] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d1  */
    /* JADX INFO: renamed from: J */
    public final void m7997J(HashSet hashSet) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        C2673q c2673q;
        List<AbstractC2662f> listMo9660b;
        long j6 = 0L;
        Cursor cursor;
        Cursor cursorM120h = null;
        IconCache iconCache = this;
        Objects.toString(hashSet);
        iconCache.f16345d.removeCallbacksAndMessages(f16341t);
        iconCache.f16357p = Locale.getDefault().toString();
        C2674r c2674r = iconCache.f16343b;
        Iterator it = c2674r.mo9679i().iterator();
        while (it.hasNext() && (listMo9660b = iconCache.f16350i.mo9660b(null, (c2673q = (C2673q) it.next()))) != null && !listMo9660b.isEmpty()) {
            Set set = C2673q.m9672b().equals(c2673q) ? hashSet : Collections.EMPTY_SET;
            IconDB iconDB = iconCache.f16344c;
            Objects.toString(c2673q);
            Objects.toString(listMo9660b);
            Objects.toString(set);
            long jMo9676f = c2674r.mo9676f(c2673q);
            PackageManager packageManager = iconCache.f16348g.getPackageManager();
            HashMap map = new HashMap();
            for (Iterator<PackageInfo> it2 = packageManager.getInstalledPackages(8192).iterator(); it2.hasNext(); it2 = it2) {
                PackageInfo next = it2.next();
                map.put(next.packageName, next);
            }
            HashMap map2 = new HashMap();
            for (AbstractC2662f abstractC2662f : listMo9660b) {
                C2674r c2674r2 = c2674r;
                map2.put(abstractC2662f.mo9652b(), abstractC2662f);
                it = it;
                c2674r = c2674r2;
            }
            C2674r c2674r3 = c2674r;
            Iterator it3 = it;
            HashSet hashSet2 = new HashSet();
            Stack stack = new Stack();
            try {
                try {
                    j6 = jMo9676f;
                    try {
                        cursorM120h = iconDB.m120h("profileId = ? ", new String[]{"rowid", "componentName", "lastUpdated", "version", "system_state"}, new String[]{Long.toString(j6)});
                        try {
                            try {
                                int columnIndex = cursorM120h.getColumnIndex("componentName");
                                int columnIndex2 = cursorM120h.getColumnIndex("lastUpdated");
                                int columnIndex3 = cursorM120h.getColumnIndex("version");
                                int columnIndex4 = cursorM120h.getColumnIndex("rowid");
                                int columnIndex5 = cursorM120h.getColumnIndex("system_state");
                                while (cursorM120h.moveToNext()) {
                                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(cursorM120h.getString(columnIndex));
                                    columnIndex = columnIndex;
                                    PackageInfo packageInfo = (PackageInfo) map.get(componentNameUnflattenFromString.getPackageName());
                                    if (packageInfo == null) {
                                        try {
                                            if (!set.contains(componentNameUnflattenFromString.getPackageName())) {
                                                iconCache.m7991D(componentNameUnflattenFromString, c2673q);
                                                hashSet2.add(Integer.valueOf(cursorM120h.getInt(columnIndex4)));
                                            }
                                        } catch (SQLiteException unused) {
                                            map2 = map2;
                                            map = map;
                                            if (cursorM120h != null) {
                                                cursorM120h.close();
                                            }
                                            if (!hashSet2.isEmpty()) {
                                                iconDB.m113a(Utilities.createDbSelectionQuery("rowid", hashSet2), null);
                                            }
                                            if (map2.isEmpty()) {
                                                Stack stack2 = new Stack();
                                                stack2.addAll(map2.values());
                                                new Al(iconCache, j6, map, stack2, stack).m3842b();
                                            } else {
                                                Stack stack3 = new Stack();
                                                stack3.addAll(map2.values());
                                                new Al(iconCache, j6, map, stack3, stack).m3842b();
                                            }
                                            iconCache = this;
                                            it = it3;
                                            c2674r = c2674r3;
                                        }
                                    } else {
                                        map = map;
                                        try {
                                            if ((packageInfo.applicationInfo.flags & 16777216) != 0) {
                                                map = map;
                                            } else {
                                                long j7 = cursorM120h.getLong(columnIndex2);
                                                int i6 = cursorM120h.getInt(columnIndex3);
                                                map2 = map2;
                                                try {
                                                    AbstractC2662f abstractC2662f2 = (AbstractC2662f) map2.remove(componentNameUnflattenFromString);
                                                    Set set2 = set;
                                                    if (i6 != packageInfo.versionCode || j7 != packageInfo.lastUpdateTime || !TextUtils.equals(iconCache.f16357p, cursorM120h.getString(columnIndex5))) {
                                                        if (abstractC2662f2 == null) {
                                                            iconCache.m7991D(componentNameUnflattenFromString, c2673q);
                                                            hashSet2.add(Integer.valueOf(cursorM120h.getInt(columnIndex4)));
                                                        } else {
                                                            stack.add(abstractC2662f2);
                                                        }
                                                    }
                                                    map = map;
                                                    set = set2;
                                                    map2 = map2;
                                                } catch (SQLiteException unused2) {
                                                    if (cursorM120h != null) {
                                                        cursorM120h.close();
                                                    }
                                                    if (!hashSet2.isEmpty()) {
                                                        iconDB.m113a(Utilities.createDbSelectionQuery("rowid", hashSet2), null);
                                                    }
                                                    if (map2.isEmpty()) {
                                                        Stack stack4 = new Stack();
                                                        stack4.addAll(map2.values());
                                                        new Al(iconCache, j6, map, stack4, stack).m3842b();
                                                    } else {
                                                        Stack stack5 = new Stack();
                                                        stack5.addAll(map2.values());
                                                        new Al(iconCache, j6, map, stack5, stack).m3842b();
                                                    }
                                                    iconCache = this;
                                                    it = it3;
                                                    c2674r = c2674r3;
                                                }
                                            }
                                        } catch (SQLiteException unused3) {
                                            map2 = map2;
                                        }
                                    }
                                }
                                map2 = map2;
                                map = map;
                            } catch (Throwable th) {
                                cursor = cursorM120h;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                            }
                        } catch (SQLiteException unused4) {
                            map2 = map2;
                            map = map;
                        }
                    } catch (SQLiteException unused5) {
                        cursorM120h = null;
                        if (cursorM120h != null) {
                            cursorM120h.close();
                        }
                        if (!hashSet2.isEmpty()) {
                            iconDB.m113a(Utilities.createDbSelectionQuery("rowid", hashSet2), null);
                        }
                        if (map2.isEmpty()) {
                            Stack stack6 = new Stack();
                            stack6.addAll(map2.values());
                            new Al(iconCache, j6, map, stack6, stack).m3842b();
                        } else {
                            Stack stack7 = new Stack();
                            stack7.addAll(map2.values());
                            new Al(iconCache, j6, map, stack7, stack).m3842b();
                        }
                        iconCache = this;
                        it = it3;
                        c2674r = c2674r3;
                    }
                } catch (Throwable th2) {
                    Throwable th = th2;
                    cursor = null;
                }
            } catch (SQLiteException unused6) {
                j6 = jMo9676f;
            }
            cursorM120h.close();
            if (!hashSet2.isEmpty()) {
                iconDB.m113a(Utilities.createDbSelectionQuery("rowid", hashSet2), null);
            }
            if (map2.isEmpty() || !stack.isEmpty()) {
                Stack stack8 = new Stack();
                stack8.addAll(map2.values());
                new Al(iconCache, j6, map, stack8, stack).m3842b();
            }
            iconCache = this;
            it = it3;
            c2674r = c2674r3;
        }
    }

    /* JADX INFO: renamed from: K */
    public final Partner m7998K(BubbleTextView bubbleTextView, ItemInfo itemInfo) {
        Objects.toString(bubbleTextView);
        Objects.toString(itemInfo);
        RunnableC0360p runnableC0360p = new RunnableC0360p(this, itemInfo, bubbleTextView, 13);
        Handler handler = this.f16345d;
        handler.post(runnableC0360p);
        return new Partner(2, runnableC0360p, handler);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:? -> B:23:0x004f). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: L */
    public final synchronized void m7999L(String str, C2673q c2673q) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        try {
            Objects.toString(c2673q);
            if (m8024z(str)) {
                return;
            }
            removeIconsForPkg(str, c2673q);
            try {
                PackageInfo packageInfo = this.f16349h.getPackageInfo(str, 8192);
                long jMo9676f = this.f16343b.mo9676f(c2673q);
                for (AbstractC2662f abstractC2662f : (Iterable<AbstractC2662f>) (Iterable) (this.f16350i.mo9660b(str, c2673q))) {
                    Objects.toString(abstractC2662f);
                    Objects.toString(packageInfo);
                    try {
                        try {
                            addIconToDB(m7996I(abstractC2662f), abstractC2662f.mo9652b(), packageInfo, jMo9676f);
                        } catch (Throwable th) {
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            return;
        } catch (Throwable th2) {
            Throwable th = th2;
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m8000a(String str, C2673q c2673q, int i6) {
        Objects.toString(c2673q);
        try {
            long jMo9676f = this.f16343b.mo9676f(c2673q);
            ContentValues contentValues = new ContentValues();
            contentValues.put("data2", Integer.valueOf(i6));
            this.f16344c.m121i(contentValues, new String[]{str, Long.toString(jMo9676f)});
            try {
                SharedPreferences.Editor editorEdit = this.f16351j.edit();
                editorEdit.putInt(str, i6);
                editorEdit.apply();
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    /* JADX INFO: renamed from: b */
    public final synchronized void m8001b(String str, C2673q c2673q, String str2) {
        Objects.toString(c2673q);
        try {
            long jMo9676f = this.f16343b.mo9676f(c2673q);
            ContentValues contentValues = new ContentValues();
            contentValues.put("label", str2);
            this.f16344c.m121i(contentValues, new String[]{str, Long.toString(jMo9676f)});
            try {
                SharedPreferences.Editor editorEdit = this.f16351j.edit();
                editorEdit.putString("custom_label_" + str, str2);
                editorEdit.apply();
            } catch (Throwable th) {
                th.getMessage();
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void addIconToDB(ContentValues contentValues, ComponentName componentName, PackageInfo packageInfo, long j6) {
        Objects.toString(contentValues);
        Objects.toString(componentName);
        Objects.toString(packageInfo);
        if (contentValues.get("label") != null) {
            contentValues.put("componentName", componentName.flattenToString());
            contentValues.put("profileId", Long.valueOf(j6));
            contentValues.put("lastUpdated", Long.valueOf(packageInfo.lastUpdateTime));
            contentValues.put("version", Integer.valueOf(packageInfo.versionCode));
            this.f16344c.m117e(contentValues);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8003d(AbstractC2662f abstractC2662f, PackageInfo packageInfo, long j6, int i6, String str, int i7) {
        int i8 = 0;
        int i9;
        Objects.toString(abstractC2662f);
        Objects.toString(packageInfo);
        Objects.toString(abstractC2662f);
        ComponentName componentNameMo9652b = abstractC2662f.mo9652b();
        C0059b c0059b = new C0059b(componentNameMo9652b, abstractC2662f.mo9656f());
        HashMap map = this.f16352k;
        IconCacheEntry iconCacheEntry = new IconCacheEntry();
        Context context = this.f16348g;
        Drawable drawableCreateFromPath = null;
        try {
            if (i7 == 1) {
                i8 = i6;
                int iM8017r = m8017r(c0059b, i8, String.valueOf(abstractC2662f.mo9655e()), abstractC2662f.mo9651a());
                if (iM8017r > 0) {
                    drawableCreateFromPath = context.getDrawable(iM8017r);
                }
            } else {
                i8 = i6;
                if (i7 == 2) {
                    if (!TextUtils.isEmpty(str)) {
                        drawableCreateFromPath = Drawable.createFromPath(str);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (drawableCreateFromPath != null) {
            iconCacheEntry.f16211a = m8016q(Utilities.m8150b(drawableCreateFromPath, abstractC2662f.mo9656f(), context));
            i9 = 1;
        } else {
            iconCacheEntry.f16211a = m8016q(Utilities.m8150b(abstractC2662f.mo9654d(this.f16353l), abstractC2662f.mo9656f(), context));
            i9 = 0;
        }
        CharSequence charSequenceM8008i = m8008i(componentNameMo9652b);
        if (charSequenceM8008i == null) {
            charSequenceM8008i = abstractC2662f.mo9655e();
        }
        iconCacheEntry.f16212b = charSequenceM8008i;
        iconCacheEntry.f16213c = this.f16343b.mo9675b(charSequenceM8008i, abstractC2662f.mo9656f());
        map.put(new C0059b(abstractC2662f.mo9652b(), abstractC2662f.mo9656f()), iconCacheEntry);
        addIconToDB(newContentValues(iconCacheEntry.f16211a, iconCacheEntry.f16212b.toString(), this.mActivityBgColor, i9, i8, str, i7), abstractC2662f.mo9652b(), packageInfo, j6);
    }

    /* JADX INFO: renamed from: e */
    public final IconCacheEntry m8004e(ComponentName componentName, AbstractC2662f abstractC2662f, C2673q c2673q, boolean z5, boolean z6) {
        Objects.toString(componentName);
        Objects.toString(abstractC2662f);
        Objects.toString(c2673q);
        C0059b c0059b = new C0059b(componentName, c2673q);
        HashMap map = this.f16352k;
        IconCacheEntry iconCacheEntry = (IconCacheEntry) map.get(c0059b);
        if (iconCacheEntry != null && (!iconCacheEntry.f16214d || z6)) {
            return iconCacheEntry;
        }
        IconCacheEntry iconCacheEntry2 = new IconCacheEntry();
        map.put(c0059b, iconCacheEntry2);
        if (m7989B(c0059b, iconCacheEntry2, z6)) {
            if (abstractC2662f != null) {
                PackageIconKey packageIconKeyM8007h = m8007h(c0059b);
                if (packageIconKeyM8007h.f16320c == 1) {
                    packageIconKeyM8007h.f16319b = m8017r(c0059b, packageIconKeyM8007h.f16319b, String.valueOf(abstractC2662f.mo9655e()), abstractC2662f.mo9651a());
                }
                Drawable drawableM8010k = m8010k(packageIconKeyM8007h);
                Context context = this.f16348g;
                try {
                    if (drawableM8010k != null) {
                        iconCacheEntry2.f16211a = m8016q(Utilities.m8150b(drawableM8010k, abstractC2662f.mo9656f(), context));
                    } else {
                        iconCacheEntry2.f16211a = m8016q(Utilities.m8150b(abstractC2662f.mo9654d(this.f16353l), abstractC2662f.mo9656f(), context));
                    }
                } catch (Throwable th) {
                    Objects.toString(componentName);
                    th.getMessage();
                    iconCacheEntry2.f16211a = getDefaultIcon(c2673q);
                }
            } else {
                if (z5) {
                    IconCacheEntry entryForPackageLocked = getEntryForPackageLocked(componentName.getPackageName(), c2673q, false);
                    componentName.toShortString();
                    iconCacheEntry2.f16211a = entryForPackageLocked.f16211a;
                    iconCacheEntry2.f16212b = entryForPackageLocked.f16212b;
                    iconCacheEntry2.f16213c = entryForPackageLocked.f16213c;
                }
                if (iconCacheEntry2.f16211a == null) {
                    componentName.toShortString();
                    iconCacheEntry2.f16211a = getDefaultIcon(c2673q);
                }
            }
        }
        if (TextUtils.isEmpty(iconCacheEntry2.f16212b) && abstractC2662f != null) {
            CharSequence charSequenceMo9655e = abstractC2662f.mo9655e();
            iconCacheEntry2.f16212b = charSequenceMo9655e;
            iconCacheEntry2.f16213c = this.f16343b.mo9675b(charSequenceMo9655e, c2673q);
        }
        String strM8008i = m8008i(componentName);
        if (strM8008i != null) {
            iconCacheEntry2.f16212b = strM8008i;
        }
        return iconCacheEntry2;
    }

    /* JADX INFO: renamed from: f */
    public final synchronized void m8005f(String str, C2673q c2673q, int i6, String str2, int i7) {
        Objects.toString(c2673q);
        m7994G(str, c2673q);
        try {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString != null) {
                String packageName = componentNameUnflattenFromString.getPackageName();
                PackageInfo packageInfo = this.f16349h.getPackageInfo(packageName, 8192);
                long jMo9676f = this.f16343b.mo9676f(c2673q);
                for (AbstractC2662f abstractC2662f : (Iterable<AbstractC2662f>) (Iterable) (this.f16350i.mo9660b(packageName, c2673q))) {
                    if (abstractC2662f != null && abstractC2662f.mo9652b() != null && str.equals(abstractC2662f.mo9652b().flattenToString())) {
                        m8003d(abstractC2662f, packageInfo, jMo9676f, i6, str2, i7);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX INFO: renamed from: g */
    public final int m8006g(ComponentName componentName) {
        try {
            return this.f16351j.getInt(componentName.flattenToString(), 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: h */
    public final PackageIconKey m8007h(C0059b c0059b) {
        Cursor cursorM120h;
        int identifier;
        Objects.toString(c0059b);
        try {
            cursorM120h = this.f16344c.m120h("componentName = ? AND profileId = ?", new String[]{"iconName", "data1", "data4"}, new String[]{c0059b.f149a.flattenToString(), Long.toString(this.f16343b.mo9676f(c0059b.f150b))});
            try {
                if (cursorM120h.moveToNext()) {
                    String string = cursorM120h.getString(cursorM120h.getColumnIndexOrThrow("iconName"));
                    int i6 = cursorM120h.getInt(cursorM120h.getColumnIndexOrThrow("data1"));
                    if (i6 == 2 && !TextUtils.isEmpty(string)) {
                        PackageIconKey packageIconKey = new PackageIconKey(0, string, 2);
                        cursorM120h.close();
                        return packageIconKey;
                    }
                    if (i6 == 1 && !TextUtils.isEmpty(string)) {
                        Context context = this.f16348g;
                        try {
                            identifier = context.getResources().getIdentifier(string, "drawable", context.getPackageName());
                        } catch (Throwable unused) {
                            identifier = 0;
                        }
                        PackageIconKey packageIconKey2 = new PackageIconKey(identifier, (String) null, 1);
                        cursorM120h.close();
                        return packageIconKey2;
                    }
                }
            } catch (Throwable unused2) {
                if (cursorM120h != null) {
                }
                return new PackageIconKey(0, (String) null, 1);
            }
        } catch (Throwable unused3) {
            cursorM120h = null;
        }
        cursorM120h.close();
        return new PackageIconKey(0, (String) null, 1);
    }

    /* JADX INFO: renamed from: i */
    public final String m8008i(ComponentName componentName) {
        try {
            return this.f16351j.getString("custom_label_" + componentName.flattenToString(), null);
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public final synchronized Bitmap getDefaultIcon(C2673q c2673q) {
        try {
            Objects.toString(c2673q);
            if (!this.f16347f.containsKey(c2673q)) {
                HashMap map = this.f16347f;
                Objects.toString(c2673q);
                map.put(c2673q, Utilities.m8150b(getFullResDefaultActivityIcon(), c2673q, this.f16348g));
            }
        } catch (Throwable th) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
        return (Bitmap) this.f16347f.get(c2673q);
    }

    /* JADX INFO: renamed from: k */
    public final Drawable m8010k(PackageIconKey packageIconKey) {
        int i6;
        try {
            int i7 = packageIconKey.f16320c;
            if (i7 != 2) {
                if (i7 != 1 || (i6 = packageIconKey.f16319b) <= 0) {
                    return null;
                }
                return this.f16348g.getDrawable(i6);
            }
            String str = packageIconKey.f16318a;
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return Drawable.createFromPath(str);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: l */
    public final IconCacheEntry getEntryForPackageLocked(String str, C2673q c2673q, boolean z5) {
        C2674r c2674r = this.f16343b;
        PackageManager packageManager = this.f16349h;
        Objects.toString(c2673q);
        C0059b c0059bM7987s = m7987s(str, c2673q);
        HashMap map = this.f16352k;
        IconCacheEntry iconCacheEntry = (IconCacheEntry) map.get(c0059bM7987s);
        if (iconCacheEntry != null && (!iconCacheEntry.f16214d || z5)) {
            return iconCacheEntry;
        }
        IconCacheEntry iconCacheEntry2 = new IconCacheEntry();
        if (m7989B(c0059bM7987s, iconCacheEntry2, z5)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, C2673q.m9672b().equals(c2673q) ? 0 : 8192);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null) {
                    throw new PackageManager.NameNotFoundException("ApplicationInfo is null");
                }
                PackageIconKey packageIconKeyM8007h = m8007h(c0059bM7987s);
                int i6 = 1;
                if (packageIconKeyM8007h.f16320c == 1) {
                    packageIconKeyM8007h.f16319b = m8017r(c0059bM7987s, packageIconKeyM8007h.f16319b, String.valueOf(applicationInfo.loadLabel(packageManager)), applicationInfo);
                }
                Drawable drawableM8010k = m8010k(packageIconKeyM8007h);
                Context context = this.f16348g;
                if (drawableM8010k != null) {
                    iconCacheEntry2.f16211a = m8016q(Utilities.m8150b(drawableM8010k, c2673q, context));
                } else {
                    iconCacheEntry2.f16211a = m8016q(Utilities.m8150b(applicationInfo.loadIcon(packageManager), c2673q, context));
                    i6 = 0;
                }
                CharSequence charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
                iconCacheEntry2.f16212b = charSequenceLoadLabel;
                iconCacheEntry2.f16213c = c2674r.mo9675b(charSequenceLoadLabel, c2673q);
                iconCacheEntry2.f16214d = false;
                String strM8008i = m8008i(c0059bM7987s.f149a);
                iconCacheEntry2.f16212b = strM8008i != null ? strM8008i : iconCacheEntry2.f16212b.toString();
                addIconToDB(newContentValues(iconCacheEntry2.f16211a, strM8008i, this.mPackageBgColor, i6, packageIconKeyM8007h.f16319b, packageIconKeyM8007h.f16318a, packageIconKeyM8007h.f16320c), c0059bM7987s.f149a, packageInfo, c2674r.mo9676f(c2673q));
            } catch (PackageManager.NameNotFoundException unused) {
                return iconCacheEntry2;
            }
        }
        map.put(c0059bM7987s, iconCacheEntry2);
        return iconCacheEntry2;
    }

    /* JADX INFO: renamed from: m */
    public final Drawable getFullResDefaultActivityIcon() {
        return m8013n(Utilities.f16743d ? android.R.drawable.sym_def_app_icon : android.R.mipmap.sym_def_app_icon, Resources.getSystem());
    }

    /* JADX INFO: renamed from: n */
    public final Drawable m8013n(int i6, Resources resources) {
        Drawable drawableForDensity;
        Objects.toString(resources);
        try {
            drawableForDensity = resources.getDrawableForDensity(i6, this.f16353l);
        } catch (Resources.NotFoundException unused) {
            drawableForDensity = null;
        }
        return drawableForDensity != null ? drawableForDensity : getFullResDefaultActivityIcon();
    }

    /* JADX INFO: renamed from: o */
    public final Drawable getFullResIcon(ActivityInfo activityInfo) {
        Resources resourcesForApplication;
        int iconResource;
        Objects.toString(activityInfo);
        try {
            resourcesForApplication = this.f16349h.getResourcesForApplication(activityInfo.applicationInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            resourcesForApplication = null;
        }
        return (resourcesForApplication == null || (iconResource = activityInfo.getIconResource()) == 0) ? getFullResDefaultActivityIcon() : m8013n(iconResource, resourcesForApplication);
    }

    /* JADX INFO: renamed from: p */
    public final synchronized Bitmap m8015p(Intent intent, C2673q c2673q) {
        Throwable th;
        try {
            try {
                Objects.toString(intent);
                Objects.toString(c2673q);
                ComponentName component = intent.getComponent();
                if (component != null) {
                    return m8004e(component, this.f16350i.mo9663g(intent, c2673q), c2673q, true, false).f16211a;
                }
                try {
                    return getDefaultIcon(c2673q);
                } catch (Throwable th2) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                }
            } catch (Throwable th3) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
            }
        } catch (Throwable th4) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th4);
        }

    }

    /* JADX INFO: renamed from: q */
    public final Bitmap m8016q(Bitmap bitmap) {
        Objects.toString(bitmap);
        return Utilities.m8164p(this.f16348g, bitmap);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0034  */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0252, code lost:
    
        if (m8023y(com.luutinhit.launcherios.R.drawable.health_icon, r0) != false) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0328, code lost:
    
        if (m8023y(com.luutinhit.launcherios.R.drawable.new_music_icon, r0) != false) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0337, code lost:
    
        if (m8023y(com.luutinhit.launcherios.R.drawable.new_safari_icon, r0) != false) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0346, code lost:
    
        if (m8023y(com.luutinhit.launcherios.R.drawable.new_notes_icon, r0) != false) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0355, code lost:
    
        if (m8023y(com.luutinhit.launcherios.R.drawable.new_calculator_icon, r0) != false) goto L247;
     */
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m8017r(C0059b c0059b, int i6, String str, ApplicationInfo applicationInfo) {
        int i7;
        boolean z5 = false;
        Objects.toString(c0059b);
        if (i6 == -1) {
            return -1;
        }
        if (i6 == 0) {
            try {
                ComponentName componentName = c0059b.f149a;
                String strFlattenToString = componentName.flattenToString();
                String packageName = componentName.getPackageName();
                Objects.toString(applicationInfo);
                if (applicationInfo != null) {
                    try {
                        int i8 = applicationInfo.flags & 1;
                    } catch (Throwable unused) {
                    }
                }
                Objects.toString(applicationInfo);
                if (applicationInfo != null) {
                    try {
                        z5 = (applicationInfo.flags & 1) != 0;
                    } catch (Throwable unused2) {
                    }
                }
                i7 = 0;
                if (z5) {
                    try {
                        if (!strFlattenToString.contains("dialer") && !strFlattenToString.contains("dialtacts")) {
                            if (strFlattenToString.contains("gmail") || !(strFlattenToString.contains("mms") || strFlattenToString.contains("messaging") || strFlattenToString.contains("conversations"))) {
                                if (!strFlattenToString.contains("contacts") && !strFlattenToString.contains("socialphonebook")) {
                                    if (strFlattenToString.contains("google") || !strFlattenToString.contains("settings")) {
                                        if (strFlattenToString.contains("email")) {
                                            if (m8023y(R.drawable.new_email_icon, packageName)) {
                                                return R.drawable.new_email_icon;
                                            }
                                        } else if (strFlattenToString.contains("gallery") || strFlattenToString.contains("album")) {
                                            if (m8023y(R.drawable.new_photos_icon, packageName)) {
                                                return R.drawable.new_photos_icon;
                                            }
                                        } else if (strFlattenToString.contains("vending")) {
                                            if (m8023y(R.drawable.new_store_icon, packageName)) {
                                                return R.drawable.new_store_icon;
                                            }
                                        } else {
                                            if (strFlattenToString.contains("browser") && !strFlattenToString.contains("vending") && !strFlattenToString.contains("com.sonyericsson.video") && !strFlattenToString.contains("com.mobisystems.files") && !strFlattenToString.contains("com.dropbox.android") && !strFlattenToString.contains("com.miui.player") && !strFlattenToString.contains("com.lge.music") && !str.contains("music") && !str.contains("file")) {
                                                if (m8023y(R.drawable.new_safari_icon, packageName)) {
                                                }
                                                return R.drawable.new_safari_icon;
                                            }
                                            if (!strFlattenToString.contains("video") && strFlattenToString.contains("health")) {
                                                if (m8023y(R.drawable.health_icon, packageName)) {
                                                }
                                                return R.drawable.health_icon;
                                            }
                                            if (strFlattenToString.contains("music")) {
                                                if (m8023y(R.drawable.new_music_icon, packageName)) {
                                                }
                                                return R.drawable.new_music_icon;
                                            }
                                            if (strFlattenToString.contains("calculator")) {
                                                if (m8023y(R.drawable.new_calculator_icon, packageName)) {
                                                }
                                                return R.drawable.new_calculator_icon;
                                            }
                                            if (strFlattenToString.contains("camera")) {
                                                if (m8023y(R.drawable.new_camera_icon, packageName)) {
                                                    return R.drawable.new_camera_icon;
                                                }
                                            } else {
                                                if (!strFlattenToString.contains("voice") && ((strFlattenToString.contains("memo") || strFlattenToString.contains("note")) && !strFlattenToString.contains("com.sony.playmemories.mobile"))) {
                                                    if (m8023y(R.drawable.new_notes_icon, packageName)) {
                                                    }
                                                    return R.drawable.new_notes_icon;
                                                }
                                                if ((strFlattenToString.contains("voicenote") || strFlattenToString.contains("record")) && !strFlattenToString.contains("screenrecorder")) {
                                                    if (m8023y(R.drawable.new_voice_memos_icon, packageName)) {
                                                        return R.drawable.new_voice_memos_icon;
                                                    }
                                                } else if ((!strFlattenToString.contains("clock") && !strFlattenToString.contains("organizer")) || strFlattenToString.contains("wearable") || strFlattenToString.contains("smsorganizer")) {
                                                    if (strFlattenToString.contains("calendar")) {
                                                        if (m8023y(R.drawable.calendar_icon, packageName)) {
                                                            return R.drawable.calendar_icon;
                                                        }
                                                    } else if (strFlattenToString.contains("compass") && m8023y(R.drawable.compass_icon, packageName)) {
                                                        return R.drawable.compass_icon;
                                                    }
                                                } else if (m8023y(R.drawable.clock_icon, packageName)) {
                                                    return R.drawable.clock_icon;
                                                }
                                            }
                                        }
                                    } else if (m8023y(R.drawable.new_settings_icon, packageName)) {
                                        return R.drawable.new_settings_icon;
                                    }
                                }
                                return R.drawable.new_contact_icon;
                            }
                            if (m8023y(R.drawable.new_message_icon, packageName)) {
                                return R.drawable.new_message_icon;
                            }
                        }
                        return R.drawable.new_call_icon;
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                if (strFlattenToString.contains("com.samsung.android.email")) {
                    if (m8023y(R.drawable.new_email_icon, packageName)) {
                        return R.drawable.new_email_icon;
                    }
                } else if (strFlattenToString.contains("video") || !strFlattenToString.contains("health")) {
                    if ((strFlattenToString.contains("radio") || strFlattenToString.contains("com.sec.android.app.fm")) && m8023y(R.drawable.ic_radio, packageName)) {
                        return R.drawable.ic_radio;
                    }
                }
                if (strFlattenToString.contains("com.google.android.googlequicksearchbox")) {
                    if (m8023y(R.drawable.google_icon, packageName)) {
                        return R.drawable.google_icon;
                    }
                } else if (strFlattenToString.contains("com.android.chrome")) {
                    if (m8023y(R.drawable.chrome_icon, packageName)) {
                        return R.drawable.chrome_icon;
                    }
                } else {
                    if (strFlattenToString.contains("com.google.android.apps.translate")) {
                        if (m8023y(R.drawable.translate_icon, packageName)) {
                        }
                        return R.drawable.translate_icon;
                    }
                    if (strFlattenToString.contains("com.google.android.play.games")) {
                        if (m8023y(R.drawable.game_icon, packageName)) {
                        }
                        return R.drawable.game_icon;
                    }
                    if (strFlattenToString.contains("com.google.android.apps.photos")) {
                        if (m8023y(R.drawable.google_photos_icon, packageName)) {
                            return R.drawable.google_photos_icon;
                        }
                    } else if (packageName.equals("com.google.android.apps.docs")) {
                        if (m8023y(R.drawable.drive_icon, packageName)) {
                            return R.drawable.drive_icon;
                        }
                    } else {
                        if (strFlattenToString.contains("com.google.android.keep")) {
                            if (m8023y(R.drawable.keep_icon, packageName)) {
                            }
                            return R.drawable.keep_icon;
                        }
                        if (strFlattenToString.contains("com.google.android.gm")) {
                            if (m8023y(R.drawable.gmail_icon, packageName)) {
                                return R.drawable.gmail_icon;
                            }
                        } else if (strFlattenToString.contains("com.google.android.youtube") && !strFlattenToString.contains("videos") && m8023y(R.drawable.youtube_icon, packageName)) {
                            return R.drawable.youtube_icon;
                        }
                    }
                }
                if (!strFlattenToString.contains("com.sec.android.app.music")) {
                    if (!strFlattenToString.contains("com.sec.android.app.sbrowser")) {
                        if (!strFlattenToString.contains("com.samsung.android.app.notes")) {
                            if (!strFlattenToString.contains("com.sec.android.app.popupcalculator")) {
                                if (strFlattenToString.contains("com.sec.android.app.voicenote")) {
                                    if (m8023y(R.drawable.new_voice_memos_icon, packageName)) {
                                        return R.drawable.new_voice_memos_icon;
                                    }
                                } else if (strFlattenToString.contains("com.google.android.apps.maps") && m8023y(R.drawable.google_maps_icon, packageName)) {
                                    return R.drawable.google_maps_icon;
                                }
                            }
                        }
                    }
                }
                if (!str.equals("facebook") && !strFlattenToString.contains("com.facebook.katana") && !strFlattenToString.contains("com.facebook.lite")) {
                    if (!str.equals("whatsapp") && !strFlattenToString.contains("com.whatsapp")) {
                        if (!str.equals("instagram") && !strFlattenToString.contains("com.instagram.android")) {
                            if (!str.equals("twitter") && !strFlattenToString.contains("com.twitter.android")) {
                                if (!str.equals("snapchat") && !strFlattenToString.contains("com.snapchat.android")) {
                                    if (!str.equals("dropbox") && !strFlattenToString.contains("com.dropbox.android")) {
                                        if (!str.equals("line") && !strFlattenToString.contains("jp.naver.line.android")) {
                                            if (!str.equals("viber") && !strFlattenToString.contains("com.viber.voip")) {
                                                if (!str.equals("flipboard") && !strFlattenToString.contains("flipboard.app")) {
                                                    if (!str.equals("spotify") && !strFlattenToString.contains("com.spotify.music")) {
                                                        if (!str.equals("uber") && !strFlattenToString.contains("com.ubercab")) {
                                                            if (!strFlattenToString.contains("com.google.android.apps.translate")) {
                                                                if (!strFlattenToString.contains("com.samsung.android.game.gamehome") && !strFlattenToString.contains("com.google.android.play.games")) {
                                                                    if (!strFlattenToString.contains("com.google.android.keep")) {
                                                                        if (strFlattenToString.contains("com.google.android.apps.tachyon")) {
                                                                            return R.drawable.new_face_time_icon;
                                                                        }
                                                                        if (!strFlattenToString.contains("com.google.android.apps.nbu.files") && !strFlattenToString.contains("com.sec.android.app.myfiles") && !strFlattenToString.contains("com.mi.android.globalFileexplorer") && !strFlattenToString.contains("com.asus.filemanager")) {
                                                                            if (strFlattenToString.contains("com.samsung.android.video")) {
                                                                                return R.drawable.ic_videos;
                                                                            }
                                                                            if (strFlattenToString.contains("com.netflix.mediaclient")) {
                                                                                return R.drawable.ic_netflix;
                                                                            }
                                                                            if (strFlattenToString.contains("com.xiaomi.hm.health")) {
                                                                                return R.drawable.ic_mifit;
                                                                            }
                                                                            if (strFlattenToString.contains("com.google.android.apps.podcasts")) {
                                                                                return R.drawable.ic_podcasts;
                                                                            }
                                                                            if (!strFlattenToString.contains("com.google.android.apps.magazines") && !strFlattenToString.contains("com.microsoft.amp.apps.bingnews")) {
                                                                                if (!strFlattenToString.contains("com.facebook.orca") && !strFlattenToString.contains("com.facebook.mlite")) {
                                                                                    if (strFlattenToString.contains("com.google.android.apps.chromecast.app")) {
                                                                                        return R.drawable.ic_home;
                                                                                    }
                                                                                    if (strFlattenToString.contains("com.discord")) {
                                                                                        return R.drawable.ic_discord;
                                                                                    }
                                                                                    if (!strFlattenToString.contains("deezer.android.app") && !strFlattenToString.contains("deezer.android.tv")) {
                                                                                        if (strFlattenToString.contains("com.pinterest")) {
                                                                                            return R.drawable.ic_pinterest;
                                                                                        }
                                                                                        if (!strFlattenToString.contains("com.ss.android.ugc.trill") && !strFlattenToString.contains("com.ss.android.ugc.trill.go")) {
                                                                                            if (!strFlattenToString.contains("com.shazam.android") && !strFlattenToString.contains("com.shazam.android.lite")) {
                                                                                                if (strFlattenToString.contains("com.fusionmedia.investing")) {
                                                                                                    return R.drawable.ic_stocks;
                                                                                                }
                                                                                                if (strFlattenToString.contains("com.google.android.apps.books")) {
                                                                                                    return R.drawable.ic_book;
                                                                                                }
                                                                                                if (strFlattenToString.contains("org.telegram.messenger")) {
                                                                                                    return R.drawable.ic_telegram;
                                                                                                }
                                                                                            }
                                                                                            return R.drawable.ic_shazam;
                                                                                        }
                                                                                        return R.drawable.ic_tik_tok;
                                                                                    }
                                                                                    return R.drawable.ic_deezer;
                                                                                }
                                                                                return R.drawable.ic_messenger;
                                                                            }
                                                                            return R.drawable.new_news_icon;
                                                                        }
                                                                        return R.drawable.new_file_icon;
                                                                    }
                                                                    return R.drawable.keep_icon;
                                                                }
                                                                return R.drawable.game_icon;
                                                            }
                                                            return R.drawable.translate_icon;
                                                        }
                                                        return R.drawable.uber_icon;
                                                    }
                                                    return R.drawable.spotify_icon;
                                                }
                                                return R.drawable.flipboard_icon;
                                            }
                                            return R.drawable.viber_icon;
                                        }
                                        return R.drawable.line_icon;
                                    }
                                    return R.drawable.dropbox_icon;
                                }
                                return R.drawable.snapchat_icon;
                            }
                            return R.drawable.twitter_icon;
                        }
                        return R.drawable.instagram_icon;
                    }
                    return R.drawable.whatsapp_icon;
                }
                return R.drawable.facebook_icon;
            } catch (Throwable th2) {
                Throwable th = th2;
                i7 = 0;
            }
        } else {
            i7 = 0;
            if (i6 > 0) {
                return i6;
            }
        }
        return i7;
    }

    /* JADX INFO: renamed from: t */
    public final synchronized void m8018t(AppInfo appInfo, AbstractC2662f abstractC2662f) {
        Throwable th;
        C2673q c2673qMo9656f;
        try {
            try {
                Objects.toString(appInfo);
                Objects.toString(abstractC2662f);
                if (abstractC2662f == null) {
                    try {
                        c2673qMo9656f = appInfo.user;
                    } catch (Throwable th2) {
                        th = th2;
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                } else {
                    c2673qMo9656f = abstractC2662f.mo9656f();
                }
                C2673q c2673q = c2673qMo9656f;
                IconCacheEntry iconCacheEntryM8004e = m8004e(appInfo.f16329D, abstractC2662f, c2673q, false, false);
                appInfo.title = Utilities.trim(iconCacheEntryM8004e.f16212b);
                Objects.toString(iconCacheEntryM8004e);
                Objects.toString(c2673q);
                Bitmap defaultIcon = iconCacheEntryM8004e.f16211a;
                if (defaultIcon == null) {
                    defaultIcon = getDefaultIcon(c2673q);
                }
                appInfo.f16327B = defaultIcon;
                appInfo.contentDescription = iconCacheEntryM8004e.f16213c;
                appInfo.f16328C = iconCacheEntryM8004e.f16214d;
            } catch (Throwable th3) {
                th = th3;
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        } catch (Throwable th4) {
            th = th4;
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
    }

    /* JADX INFO: renamed from: u */
    public final synchronized void m8019u(ShortcutInfo shortcutInfo, ComponentName componentName, AbstractC2662f abstractC2662f, C2673q c2673q, boolean z5, boolean z6) {
        try {
            try {
                Objects.toString(shortcutInfo);
                Objects.toString(componentName);
                Objects.toString(abstractC2662f);
                Objects.toString(c2673q);
                IconCacheEntry iconCacheEntryM8004e = m8004e(componentName, abstractC2662f, c2673q, z5, z6);
                Objects.toString(iconCacheEntryM8004e);
                Objects.toString(c2673q);
                Bitmap defaultIcon = iconCacheEntryM8004e.f16211a;
                if (defaultIcon == null) {
                    defaultIcon = getDefaultIcon(c2673q);
                }
                shortcutInfo.f16558F = defaultIcon;
                shortcutInfo.title = Utilities.trim(iconCacheEntryM8004e.f16212b);
                shortcutInfo.f16555C = isDefaultIcon(iconCacheEntryM8004e.f16211a, c2673q);
                shortcutInfo.f16556D = iconCacheEntryM8004e.f16214d;
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        } catch (Throwable th2) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
        }
    }

    /* JADX INFO: renamed from: v */
    public final synchronized void m8020v(ShortcutInfo shortcutInfo, Intent intent, C2673q c2673q, boolean z5) {
        Throwable th;
        try {
            try {
                Objects.toString(shortcutInfo);
                Objects.toString(intent);
                Objects.toString(c2673q);
                ComponentName component = intent.getComponent();
                if (component == null) {
                    try {
                        shortcutInfo.f16558F = getDefaultIcon(c2673q);
                        shortcutInfo.title = "";
                        shortcutInfo.f16555C = true;
                        shortcutInfo.f16556D = false;
                    } catch (Throwable th2) {
                        th = th2;
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                } else {
                    m8019u(shortcutInfo, component, this.f16350i.mo9663g(intent, c2673q), c2673q, true, z5);
                }
            } catch (Throwable th3) {
                th = th3;
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        } catch (Throwable th4) {
            th = th4;
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
    }

    /* JADX INFO: renamed from: w */
    public final synchronized void m8021w(String str, C2673q c2673q, boolean z5, C3031f c3031f) {
        Objects.toString(c2673q);
        Objects.toString(c3031f);
        IconCacheEntry entryForPackageLocked = getEntryForPackageLocked(str, c2673q, z5);
        Objects.toString(entryForPackageLocked);
        Objects.toString(c2673q);
        Bitmap defaultIcon = entryForPackageLocked.f16211a;
        if (defaultIcon == null) {
            defaultIcon = getDefaultIcon(c2673q);
        }
        c3031f.f21971A = defaultIcon;
        c3031f.title = Utilities.trim(entryForPackageLocked.f16212b);
        c3031f.f21972B = entryForPackageLocked.f16214d;
        c3031f.contentDescription = entryForPackageLocked.f16213c;
    }

    /* JADX INFO: renamed from: x */
    public final boolean isDefaultIcon(Bitmap bitmap, C2673q c2673q) {
        Objects.toString(bitmap);
        Objects.toString(c2673q);
        return this.f16347f.get(c2673q) == bitmap;
    }

    /* JADX INFO: renamed from: y */
    public final boolean m8023y(int i6, String str) {
        HashMap map = this.f16346e;
        if (map.containsValue(Integer.valueOf(i6))) {
            return false;
        }
        map.put(str, Integer.valueOf(i6));
        return true;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m8024z(String str) {
        Cursor cursorM120h = null;
        try {
            cursorM120h = this.f16344c.m120h("componentName LIKE ?", new String[]{"customIcon", "iconName"}, new String[]{"%" + str + "%"});
            if (cursorM120h != null) {
                int columnIndexOrThrow = cursorM120h.getColumnIndexOrThrow("customIcon");
                int columnIndexOrThrow2 = cursorM120h.getColumnIndexOrThrow("iconName");
                while (cursorM120h.moveToNext()) {
                    int i6 = cursorM120h.getInt(columnIndexOrThrow);
                    String string = cursorM120h.getString(columnIndexOrThrow2);
                    if (i6 > 0 || !TextUtils.isEmpty(string)) {
                        cursorM120h.close();
                        return true;
                    }
                }
            }
            if (cursorM120h == null) {
                return false;
            }
        } catch (Throwable unused) {
            if (cursorM120h == null) {
                return false;
            }
        }
        cursorM120h.close();
        return false;
    }
}
