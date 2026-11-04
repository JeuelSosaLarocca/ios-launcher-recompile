package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import B3.AbstractC0075r;
import B3.C0062e;
import B3.C0081x;
import G1.C0328n;
import G3.RunnableC0360p;
import U0.RunnableC1089s;
import android.appwidget.AppWidgetProviderInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Pair;
import com.google.android.gms.internal.ads.Al;
import com.luutinhit.launcherios.R;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import p122r3.AbstractC2662f;
import p122r3.AbstractC2666j;
import p122r3.C2673q;
import p122r3.C2674r;
import p122r3.InterfaceC2665i;
import p154y3.C3033h;

/* JADX INFO: renamed from: com.luutinhit.launcher6.B2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherModel extends BroadcastReceiver implements InterfaceC2665i {

    /* JADX INFO: renamed from: A */
    public static final Handler sWorker;

    /* JADX INFO: renamed from: B */
    public static final ArrayList mDeferredBindRunnables;

    /* JADX INFO: renamed from: C */
    public static final ArrayList mBindCompleteRunnables;

    /* JADX INFO: renamed from: D */
    public static final Object sBgLock;

    /* JADX INFO: renamed from: E */
    public static final C0081x sBgItemsIdMap;

    /* JADX INFO: renamed from: F */
    public static final ArrayList sBgWorkspaceItems;

    /* JADX INFO: renamed from: G */
    public static final ArrayList sBgAppWidgets;

    /* JADX INFO: renamed from: H */
    public static final C0081x sBgFolders;

    /* JADX INFO: renamed from: I */
    public static final ArrayList sBgWorkspaceScreens;

    /* JADX INFO: renamed from: J */
    public static HashSet sBgWidgetProviders;

    /* JADX INFO: renamed from: K */
    public static final HashMap sPendingPackages;

    /* JADX INFO: renamed from: z */
    public static final HandlerThread sWorkerThread;

    /* JADX INFO: renamed from: j */
    public boolean f15342j;

    /* JADX INFO: renamed from: k */
    public LauncherAppState f15343k;

    /* JADX INFO: renamed from: l */
    public Object f15344l = new Object();

    /* JADX INFO: renamed from: m */
    public Partner f15345m;

    /* JADX INFO: renamed from: n */
    public LoaderTask mLoaderTask;

    /* JADX INFO: renamed from: o */
    public boolean f15347o;

    /* JADX INFO: renamed from: p */
    public boolean f15348p;

    /* JADX INFO: renamed from: q */
    public boolean f15349q;

    /* JADX INFO: renamed from: r */
    public boolean f15350r;

    /* JADX INFO: renamed from: s */
    public boolean f15351s;

    /* JADX INFO: renamed from: t */
    public WeakReference f15352t;

    /* JADX INFO: renamed from: u */
    public C0328n f15353u;

    /* JADX INFO: renamed from: v */
    public C3033h f15354v;

    /* JADX INFO: renamed from: w */
    public IconCache f15355w;

    /* JADX INFO: renamed from: x */
    public AbstractC2666j f15356x;

    /* JADX INFO: renamed from: y */
    public C2674r f15357y;

    static {
        HandlerThread handlerThread = new HandlerThread("launcher-loader");
        sWorkerThread = handlerThread;
        handlerThread.start();
        sWorker = new Handler(handlerThread.getLooper());
        mDeferredBindRunnables = new ArrayList();
        mBindCompleteRunnables = new ArrayList();
        sBgLock = new Object();
        sBgItemsIdMap = new C0081x();
        sBgWorkspaceItems = new ArrayList();
        sBgAppWidgets = new ArrayList();
        sBgFolders = new C0081x();
        sBgWorkspaceScreens = new ArrayList();
        sPendingPackages = new HashMap();
    }

    public LauncherModel(LauncherAppState launcherAppState, IconCache iconCache) {
        Partner partner = new Partner();
        partner.f16123k = new LinkedList();
        Looper.myQueue();
        partner.f16124l = new DeferredHandlerImpl(partner);
        this.f15345m = partner;
        launcherAppState.getClass();
        Context context = LauncherAppState.f16216i;
        String authority = Uri.parse(context.getString(R.string.old_launcher_provider_uri)).getAuthority();
        boolean z5 = false;
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.android.launcher2.settings", 0);
        ProviderInfo providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider(authority, 0);
        if (providerInfoResolveContentProvider != null && providerInfoResolveContentProvider2 != null) {
            z5 = true;
        }
        this.f15342j = z5;
        this.f15343k = launcherAppState;
        C0328n c0328n = new C0328n(17);
        c0328n.f1070k = new ArrayList(42);
        c0328n.f1071l = new ArrayList(42);
        c0328n.f1072m = new ArrayList();
        c0328n.f1073n = new ArrayList();
        c0328n.f1074o = iconCache;
        this.f15353u = c0328n;
        this.f15354v = new C3033h(context, iconCache);
        this.f15355w = iconCache;
        this.f15356x = AbstractC2666j.m9657c(context);
        this.f15357y = C2674r.m9673e(context);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0050 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:4:0x0006, B:8:0x0017, B:10:0x001f, B:13:0x0025, B:15:0x002f, B:19:0x0039, B:30:0x0055, B:26:0x0044, B:28:0x004c, B:29:0x0050), top: B:34:0x0006 }] */
    /* JADX INFO: renamed from: D */
    public static void checkItemInfo(long j6, ItemInfo itemInfo, StackTraceElement[] stackTraceElementArr) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Objects.toString(itemInfo);
        synchronized (sBgLock) {
            try {
                checkItemInfoLocked(j6, itemInfo, stackTraceElementArr);
                long j7 = itemInfo.container;
                if (j7 != -100 && j7 != -101 && !sBgFolders.m201f(j7)) {
                    itemInfo.toString();
                }
                ItemInfo itemInfo2 = (ItemInfo) sBgItemsIdMap.get(j6);
                if (itemInfo2 != null) {
                    long j8 = itemInfo2.container;
                    if (j8 == -100 || j8 == -101) {
                        int i6 = itemInfo2.itemType;
                        if (i6 == 0 || i6 == 1 || i6 == 2) {
                            ArrayList arrayList = sBgWorkspaceItems;
                            if (!arrayList.contains(itemInfo2)) {
                                arrayList.add(itemInfo2);
                            }
                        }
                    } else {
                        sBgWorkspaceItems.remove(itemInfo2);
                    }
                } else {
                    sBgWorkspaceItems.remove(itemInfo2);
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: E */
    public static void updateItemInDatabase(Context context, ItemInfo itemInfo) {
        Objects.toString(context);
        Objects.toString(itemInfo);
        ContentValues contentValues = new ContentValues();
        itemInfo.mo7672d(context, contentValues);
        m7550F(context, contentValues, itemInfo);
    }

    /* JADX INFO: renamed from: F */
    public static void m7550F(Context context, ContentValues contentValues, ItemInfo itemInfo) {
        Objects.toString(context);
        Objects.toString(contentValues);
        Objects.toString(itemInfo);
        long j6 = itemInfo.id;
        m7567y(new Al(context.getContentResolver(), Favorites.getContentUri(j6), contentValues, itemInfo, j6, new Throwable().getStackTrace(), 2));
    }

    /* JADX INFO: renamed from: G */
    public static void updateWorkspaceScreenOrder(Context context, ArrayList arrayList) {
        Objects.toString(context);
        Objects.toString(arrayList);
        ArrayList arrayList2 = new ArrayList(arrayList);
        ContentResolver contentResolver = context.getContentResolver();
        Uri uri = WorkspaceScreens.f15734a;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (((Long) it.next()).longValue() < 0) {
                it.remove();
            }
        }
        m7567y(new RunnableC0360p(uri, arrayList2, contentResolver, 14, false));
    }

    /* JADX INFO: renamed from: b */
    public static void addItemToDatabase(Context context, ItemInfo itemInfo, long j6, long j7, int i6, int i7) {
        Objects.toString(context);
        Objects.toString(itemInfo);
        itemInfo.container = j6;
        itemInfo.cellX = i6;
        itemInfo.cellY = i7;
        if ((context instanceof Launcher) && j7 < 0 && j6 == -101) {
            ((Launcher) context).getHotseat().getClass();
            itemInfo.screenId = i6;
        } else {
            itemInfo.screenId = j7;
        }
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        itemInfo.mo7672d(context, contentValues);
        long jGenerateNewItemId = LauncherAppState.getLauncherProvider().f15839k.generateNewItemId();
        itemInfo.id = jGenerateNewItemId;
        contentValues.put("_id", Long.valueOf(jGenerateNewItemId));
        m7567y(new RunnableC0031a(contentResolver, contentValues, itemInfo, new Throwable().getStackTrace(), 15));
    }

    /* JADX INFO: renamed from: c */
    public static void addOrMoveItemInDatabase(Context context, ItemInfo itemInfo, long j6, long j7, int i6, int i7) {
        Objects.toString(context);
        Objects.toString(itemInfo);
        if (itemInfo.container == -1) {
            addItemToDatabase(context, itemInfo, j6, j7, i6, i7);
        } else {
            moveItemInDatabase(context, itemInfo, j6, j7, i6, i7);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void checkItemInfoLocked(long j6, ItemInfo itemInfo, StackTraceElement[] stackTraceElementArr) {
        Objects.toString(itemInfo);
        ItemInfo itemInfo2 = (ItemInfo) sBgItemsIdMap.get(j6);
        if (itemInfo2 == null || itemInfo == itemInfo2) {
            return;
        }
        if (itemInfo2 instanceof ShortcutInfo) {
            ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo2;
            if (itemInfo instanceof ShortcutInfo) {
                ShortcutInfo shortcutInfo2 = (ShortcutInfo) itemInfo;
                if (shortcutInfo.title.toString().equals(shortcutInfo2.title.toString()) && shortcutInfo.f16553A.filterEquals(shortcutInfo2.f16553A) && shortcutInfo.id == shortcutInfo2.id && shortcutInfo.itemType == shortcutInfo2.itemType && shortcutInfo.container == shortcutInfo2.container && shortcutInfo.screenId == shortcutInfo2.screenId && shortcutInfo.cellX == shortcutInfo2.cellX && shortcutInfo.cellY == shortcutInfo2.cellY && shortcutInfo.spanX == shortcutInfo2.spanX && shortcutInfo.spanY == shortcutInfo2.spanY) {
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder("item: ");
        sb.append(itemInfo != null ? itemInfo.toString() : "null");
        sb.append("modelItem: ");
        sb.append(itemInfo2.toString());
        sb.append("Error: ItemInfo passed to checkItemInfo doesn't match original");
        RuntimeException runtimeException = new RuntimeException(sb.toString());
        if (stackTraceElementArr == null) {
            throw runtimeException;
        }
        runtimeException.setStackTrace(stackTraceElementArr);
        throw runtimeException;
    }

    /* JADX INFO: renamed from: e */
    public static void deleteItemFromDatabase(Context context, ItemInfo itemInfo) {
        Objects.toString(context);
        Objects.toString(itemInfo);
        ArrayList arrayList = new ArrayList();
        arrayList.add(itemInfo);
        m7556f(context, arrayList);
    }

    /* JADX INFO: renamed from: f */
    public static void m7556f(Context context, ArrayList arrayList) {
        Objects.toString(context);
        Objects.toString(arrayList);
        m7567y(new MergedModelRunnable(arrayList, context.getContentResolver(), 10, false));
    }

    /* JADX INFO: renamed from: g */
    public static void enqueuePackageUpdated(PackageUpdatedTask packageUpdatedTask) {
        Objects.toString(packageUpdatedTask);
        sWorker.post(packageUpdatedTask);
    }

    /* JADX INFO: renamed from: h */
    public static ArrayList filterItemInfos(Iterable iterable, ItemInfoFilter itemInfoFilter) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // endless loop in the jadx output; the original bytecode runs
        LauncherAppWidgetInfo launcherAppWidgetInfo;
        ComponentName componentName;
        Objects.toString(iterable);
        Objects.toString(itemInfoFilter);
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            ItemInfo itemInfo = (ItemInfo) it.next();
            if (itemInfo instanceof ShortcutInfo) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                ComponentName targetComponent = shortcutInfo.getTargetComponent();
                if (targetComponent != null && itemInfoFilter.mo856j(null, shortcutInfo, targetComponent)) {
                    hashSet.add(shortcutInfo);
                }
            } else if (itemInfo instanceof FolderInfo) {
                FolderInfo folderInfo = (FolderInfo) itemInfo;
                if (folderInfo.contents != null) {
                    int i6 = 0;
                    while (true) {
                        ArrayList arrayList = folderInfo.contents;
                        if (i6 < arrayList.size()) {
                            ShortcutInfo shortcutInfo2 = (ShortcutInfo) arrayList.get(i6);
                            ComponentName targetComponent2 = shortcutInfo2.getTargetComponent();
                            if (targetComponent2 != null && itemInfoFilter.mo856j(folderInfo, shortcutInfo2, targetComponent2)) {
                                hashSet.add(shortcutInfo2);
                            }
                            i6++;
                        }
                    }
                }
            } else if ((itemInfo instanceof LauncherAppWidgetInfo) && (componentName = (launcherAppWidgetInfo = (LauncherAppWidgetInfo) itemInfo).providerName) != null && itemInfoFilter.mo856j(null, launcherAppWidgetInfo, componentName)) {
                hashSet.add(launcherAppWidgetInfo);
            }
        }
        return new ArrayList(hashSet);
    }

    /* JADX INFO: renamed from: i */
    public static boolean m7559i(ArrayList arrayList, int[] iArr) {
        Objects.toString(arrayList);
        InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
        int i6 = invariantDeviceProfile.f16712d;
        int i7 = invariantDeviceProfile.f16711c;
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i6, i7);
        if (arrayList != null) {
            int size = arrayList.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList.get(i8);
                i8++;
                ItemInfo itemInfo = (ItemInfo) obj;
                int i9 = itemInfo.cellX;
                int i10 = itemInfo.spanX + i9;
                int i11 = itemInfo.cellY + itemInfo.spanY;
                while (i9 >= 0 && i9 < i10 && i9 < i6) {
                    for (int i12 = itemInfo.cellY; i12 >= 0 && i12 < i11 && i12 < i7; i12++) {
                        zArr[i9][i12] = true;
                    }
                    i9++;
                }
            }
        }
        Rect rect = Utilities.sOldBounds;
        int i13 = 0;
        while (true) {
            int i14 = i13 + 1;
            if (i14 > i7) {
                return false;
            }
            int i15 = 0;
            while (true) {
                int i16 = i15 + 1;
                if (i16 <= i6) {
                    boolean z5 = !zArr[i15][i13];
                    for (int i17 = i15; i17 < i16; i17++) {
                        for (int i18 = i13; i18 < i14; i18++) {
                            z5 = z5 && !zArr[i17][i18];
                            if (!z5) {
                                break;
                            }
                        }
                    }
                    if (z5) {
                        iArr[0] = i15;
                        iArr[1] = i13;
                        return true;
                    }
                    i15 = i16;
                } else {
                    break; // jadx dropped this: row exhausted, try the next one (AOSP findNextAvailableIconSpaceInScreen)
                }
            }
            i13 = i14;
        }
    }

    /* JADX INFO: renamed from: j */
    public static Pair m7560j(Context context, ArrayList arrayList, ArrayList arrayList2) {
        boolean zM7559i;
        long jGenerateNewScreenId;
        boolean z5 = true;
        Objects.toString(context);
        Objects.toString(arrayList);
        Objects.toString(arrayList2);
        LongSparseArray longSparseArray = new LongSparseArray();
        WeakReference weakReference = LauncherAppState.f16215h;
        synchronized (sBgLock) {
            try {
                C0081x c0081x = sBgItemsIdMap;
                c0081x.getClass();
                zM7559i = false;
                int i6 = 0;
                while (i6 < c0081x.size()) {
                    int i7 = i6 + 1;
                    ItemInfo itemInfo = (ItemInfo) c0081x.valueAt(i6);
                    if (itemInfo.container == -100) {
                        ArrayList arrayList3 = (ArrayList) longSparseArray.get(itemInfo.screenId);
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                            longSparseArray.put(itemInfo.screenId, arrayList3);
                        }
                        arrayList3.add(itemInfo);
                    }
                    i6 = i7;
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        int[] iArr = new int[2];
        int size = arrayList.size();
        int i8 = (!arrayList.isEmpty()) ? 1 : 0;
        if (i8 < size) {
            long jLongValue = ((Long) arrayList.get(i8)).longValue();
            zM7559i = m7559i((ArrayList) longSparseArray.get(jLongValue), iArr);
            jGenerateNewScreenId = jLongValue;
        } else {
            jGenerateNewScreenId = 0;
        }
        if (!zM7559i) {
            int i9 = 1;
            while (true) {
                if (i9 >= size) {
                    z5 = zM7559i;
                    break;
                }
                jGenerateNewScreenId = ((Long) arrayList.get(i9)).longValue();
                if (m7559i((ArrayList) longSparseArray.get(jGenerateNewScreenId), iArr)) {
                    break;
                }
                i9++;
            }
        } else {
            z5 = zM7559i;
        }
        if (!z5) {
            jGenerateNewScreenId = LauncherAppState.getLauncherProvider().f15839k.generateNewScreenId();
            arrayList.add(Long.valueOf(jGenerateNewScreenId));
            arrayList2.add(Long.valueOf(jGenerateNewScreenId));
            if (!m7559i((ArrayList) longSparseArray.get(jGenerateNewScreenId), iArr)) {
                throw new RuntimeException("Can't find space to add the item");
            }
        }
        return Pair.create(Long.valueOf(jGenerateNewScreenId), iArr);
    }

    /* JADX INFO: renamed from: m */
    public static Intent getMarketIntent(String str) {
        return new Intent("android.intent.action.VIEW").setData(new Uri.Builder().scheme("market").authority("details").appendQueryParameter("id", str).build());
    }

    /* JADX INFO: renamed from: o */
    public static Intent m7562o(Cursor cursor, Context context, Intent intent) {
        Objects.toString(cursor);
        Objects.toString(context);
        Objects.toString(intent);
        return getMarketIntent(intent.getComponent().getPackageName());
    }

    /* JADX INFO: renamed from: q */
    public static boolean isValidProvider(AppWidgetProviderInfo appWidgetProviderInfo) {
        ComponentName componentName;
        Objects.toString(appWidgetProviderInfo);
        return (appWidgetProviderInfo == null || (componentName = appWidgetProviderInfo.provider) == null || componentName.getPackageName() == null) ? false : true;
    }

    /* JADX INFO: renamed from: r */
    public static ArrayList loadWorkspaceScreensDb(Context context) {
        Objects.toString(context);
        Cursor cursorQuery = context.getContentResolver().query(WorkspaceScreens.f15734a, null, null, null, "screenRank");
        ArrayList arrayList = new ArrayList();
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(Long.valueOf(cursorQuery.getLong(columnIndexOrThrow)));
                } catch (Exception e) {
                    Launcher.addDumpLog("LauncherModel", "Desktop items loading interrupted - invalid screens: " + e, true);
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
    }

    /* JADX INFO: renamed from: s */
    public static void modifyItemInDatabase(Context context, ItemInfo itemInfo, long j6, long j7, int i6, int i7, int i8, int i9) {
        Objects.toString(context);
        Objects.toString(itemInfo);
        itemInfo.container = j6;
        itemInfo.cellX = i6;
        itemInfo.cellY = i7;
        itemInfo.spanX = i8;
        itemInfo.spanY = i9;
        if ((context instanceof Launcher) && j7 < 0 && j6 == -101) {
            ((Launcher) context).getHotseat().getClass();
            itemInfo.screenId = i6;
        } else {
            itemInfo.screenId = j7;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("container", Long.valueOf(itemInfo.container));
        contentValues.put("cellX", Integer.valueOf(itemInfo.cellX));
        contentValues.put("cellY", Integer.valueOf(itemInfo.cellY));
        contentValues.put("rank", Integer.valueOf(itemInfo.f16791t));
        contentValues.put("spanX", Integer.valueOf(itemInfo.spanX));
        contentValues.put("spanY", Integer.valueOf(itemInfo.spanY));
        contentValues.put("screen", Long.valueOf(itemInfo.screenId));
        m7550F(context, contentValues, itemInfo);
    }

    /* JADX INFO: renamed from: t */
    public static void moveItemInDatabase(Context context, ItemInfo itemInfo, long j6, long j7, int i6, int i7) {
        Objects.toString(context);
        Objects.toString(itemInfo);
        itemInfo.container = j6;
        itemInfo.cellX = i6;
        itemInfo.cellY = i7;
        if ((context instanceof Launcher) && j7 < 0 && j6 == -101) {
            ((Launcher) context).getHotseat().getClass();
            itemInfo.screenId = i6;
        } else {
            itemInfo.screenId = j7;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("container", Long.valueOf(itemInfo.container));
        contentValues.put("cellX", Integer.valueOf(itemInfo.cellX));
        contentValues.put("cellY", Integer.valueOf(itemInfo.cellY));
        contentValues.put("rank", Integer.valueOf(itemInfo.f16791t));
        contentValues.put("screen", Long.valueOf(itemInfo.screenId));
        m7550F(context, contentValues, itemInfo);
    }

    /* JADX INFO: renamed from: y */
    public static void m7567y(Runnable runnable) {
        Objects.toString(runnable);
        if (sWorkerThread.getThreadId() == Process.myTid()) {
            runnable.run();
        } else {
            sWorker.post(runnable);
        }
    }

    /* JADX INFO: renamed from: z */
    public static boolean m7568z(Intent intent, C2673q c2673q) {
        String uri;
        String uri2;
        Objects.toString(intent);
        Objects.toString(c2673q);
        if (intent == null) {
            return false;
        }
        WeakReference weakReference = LauncherAppState.f16215h;
        if (intent.getComponent() != null) {
            String packageName = intent.getComponent().getPackageName();
            if (intent.getPackage() != null) {
                uri = intent.toUri(0);
                uri2 = new Intent(intent).setPackage(null).toUri(0);
            } else {
                uri = new Intent(intent).setPackage(packageName).toUri(0);
                uri2 = intent.toUri(0);
            }
        } else {
            uri = intent.toUri(0);
            uri2 = intent.toUri(0);
        }
        synchronized (sBgLock) {
            try {
                C0081x c0081x = sBgItemsIdMap;
                c0081x.getClass();
                int i6 = 0;
                while (i6 < c0081x.size()) {
                    int i7 = i6 + 1;
                    ItemInfo itemInfo = (ItemInfo) c0081x.valueAt(i6);
                    if (itemInfo instanceof ShortcutInfo) {
                        ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                        Intent intent2 = shortcutInfo.f16563K;
                        if (intent2 == null) {
                            intent2 = shortcutInfo.f16553A;
                        }
                        if (intent2 != null && shortcutInfo.user.equals(c2673q)) {
                            if (intent2.filterEquals(intent)) {
                                return true;
                            }
                            intent2.setSourceBounds(intent.getSourceBounds());
                            String uri3 = intent2.toUri(0);
                            if (!uri.equals(uri3) && !uri2.equals(uri3)) {
                                if (Objects.equals(intent.getComponent(), intent2.getComponent()) && Integer.valueOf(intent.getFlags()).equals(Integer.valueOf(intent2.getFlags())) && Objects.equals(intent.getAction(), intent2.getAction()) && Objects.equals(intent.getCategories(), intent2.getCategories())) {
                                    return true;
                                }
                            }
                            return true;
                        }
                    }
                    i6 = i7;
                }
                return false;
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: A */
    public final void startLoader(int i6, int i7) {
        InstallShortcutReceiver.f15736b = true;
        synchronized (this.f15344l) {
            try {
                ArrayList arrayList = mDeferredBindRunnables;
                synchronized (arrayList) {
                    arrayList.clear();
                }
                WeakReference weakReference = this.f15352t;
                if (weakReference != null && weakReference.get() != null) {
                    LoaderTask loaderTask = this.mLoaderTask;
                    if (loaderTask != null) {
                        loaderTask.stopLocked();
                    }
                    this.f15343k.getClass();
                    LoaderTask loaderTask2 = new LoaderTask(this, LauncherAppState.f16216i, i7);
                    this.mLoaderTask = loaderTask2;
                    if (i6 == -1001 || !this.f15350r || !this.f15349q || this.f15347o) {
                        sWorkerThread.setPriority(5);
                        sWorker.post(this.mLoaderTask);
                    } else {
                        loaderTask2.runBindSynchronousPage(i6);
                    }
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final void unbindItemInfosAndClearQueuedBindRunnables() {
        if (sWorkerThread.getThreadId() == Process.myTid()) {
            throw new RuntimeException("Expected unbindLauncherItemInfos() to be called from the main thread");
        }
        ArrayList arrayList = mDeferredBindRunnables;
        synchronized (arrayList) {
            arrayList.clear();
        }
        this.f15345m.m7882a();
        unbindWorkspaceItemsOnMainThread();
    }

    /* JADX INFO: renamed from: C */
    public final void unbindWorkspaceItemsOnMainThread() {
        ArrayList arrayList;
        synchronized (sBgLock) {
            arrayList = new ArrayList(sBgWorkspaceItems);
            arrayList.addAll(sBgAppWidgets);
        }
        m7580x(new MergedUiRunnable(9, arrayList));
    }

    /* JADX INFO: renamed from: a */
    public final void addAppsToAllApps(Context context, ArrayList arrayList) {
        Objects.toString(context);
        Objects.toString(arrayList);
        LauncherModelCallbacks callback = getCallback();
        if (arrayList.isEmpty()) {
            return;
        }
        m7567y(new RunnableC0031a(this, arrayList, context, callback));
    }

    /* JADX INFO: renamed from: k */
    public final ShortcutInfo getAppShortcutInfo(Intent intent, C2673q c2673q, Context context, Cursor cursor, int i6, int i7, boolean z5) {
        Objects.toString(intent);
        Objects.toString(c2673q);
        Objects.toString(context);
        Objects.toString(cursor);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        Intent intent2 = new Intent(intent.getAction(), (Uri) null);
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setComponent(component);
        AbstractC2662f abstractC2662fMo9663g = this.f15356x.mo9663g(intent2, c2673q);
        if (abstractC2662fMo9663g == null && !z5) {
            component.toString();
            return null;
        }
        ShortcutInfo shortcutInfo = new ShortcutInfo();
        this.f15355w.m8019u(shortcutInfo, component, abstractC2662fMo9663g, c2673q, false, false);
        IconCache iconCache = this.f15355w;
        if (shortcutInfo.f16558F == null) {
            shortcutInfo.m8056i(iconCache);
        }
        if (iconCache.isDefaultIcon(shortcutInfo.f16558F, c2673q) && cursor != null) {
            Bitmap bitmapCreateIconBitmap = Utilities.createIconBitmap(cursor, i6, context);
            if (bitmapCreateIconBitmap == null) {
                bitmapCreateIconBitmap = iconCache.getDefaultIcon(c2673q);
            }
            shortcutInfo.f16558F = bitmapCreateIconBitmap;
        }
        if (abstractC2662fMo9663g != null && AbstractC0075r.m191l(abstractC2662fMo9663g.mo9651a())) {
            shortcutInfo.f16559G = 4;
        }
        if (TextUtils.isEmpty(shortcutInfo.title) && cursor != null) {
            shortcutInfo.title = Utilities.trim(cursor.getString(i7));
        }
        if (shortcutInfo.title == null) {
            shortcutInfo.title = component.getClassName();
        }
        shortcutInfo.itemType = 0;
        shortcutInfo.user = c2673q;
        shortcutInfo.contentDescription = this.f15357y.mo9675b(shortcutInfo.title, c2673q);
        if (abstractC2662fMo9663g != null) {
            shortcutInfo.f16562J = AppInfo.m7982g(abstractC2662fMo9663g);
        }
        return shortcutInfo;
    }

    /* JADX INFO: renamed from: l */
    public final LauncherModelCallbacks getCallback() {
        WeakReference weakReference = this.f15352t;
        if (weakReference != null) {
            return (LauncherModelCallbacks) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    public final ShortcutInfo getRestoredItemInfo(Cursor cursor, int i6, Intent intent, int i7, int i8, C0062e c0062e, Context context) {
        Objects.toString(cursor);
        Objects.toString(intent);
        Objects.toString(c0062e);
        Objects.toString(context);
        ShortcutInfo shortcutInfo = new ShortcutInfo();
        shortcutInfo.user = C2673q.m9672b();
        Bitmap bitmapM174a = c0062e.m174a(cursor, shortcutInfo, context);
        if (bitmapM174a == null) {
            this.f15355w.m8020v(shortcutInfo, intent, shortcutInfo.user, false);
        } else {
            shortcutInfo.f16558F = bitmapM174a;
        }
        if ((i7 & 1) != 0) {
            String string = cursor.getString(i6);
            if (!TextUtils.isEmpty(string)) {
                shortcutInfo.title = Utilities.trim(string);
            }
        } else {
            if ((i7 & 2) == 0) {
                throw new InvalidParameterException(SyntheticHelpers.m7909h(i7, "Invalid restoreType "));
            }
            if (TextUtils.isEmpty(shortcutInfo.title)) {
                shortcutInfo.title = Utilities.trim(cursor.getString(i6));
            }
        }
        shortcutInfo.contentDescription = this.f15357y.mo9675b(shortcutInfo.title, shortcutInfo.user);
        shortcutInfo.itemType = i8;
        shortcutInfo.f16563K = intent;
        shortcutInfo.f16560H = i7;
        return shortcutInfo;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        UserHandle userHandle;
        ComponentName componentNameUnflattenFromString;
        ComponentName componentNameUnflattenFromString2;
        ComponentName componentNameUnflattenFromString3;
        ComponentName targetComponent;
        Objects.toString(context);
        Objects.toString(intent);
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.LOCALE_CHANGED".equals(action)) {
                m7579w(true);
                LauncherModelCallbacks callback = getCallback();
                if (callback == null || callback.setLoadOnResume()) {
                    return;
                }
                startLoader(-1001, 0);
                return;
            }
            if ("android.intent.action.MANAGED_PROFILE_ADDED".equals(action) || "android.intent.action.MANAGED_PROFILE_REMOVED".equals(action)) {
                C2674r.m9673e(context).mo9674a();
                m7579w(true);
                LauncherModelCallbacks callback2 = getCallback();
                if (callback2 == null || callback2.setLoadOnResume()) {
                    return;
                }
                startLoader(-1001, 0);
                return;
            }
            C2673q c2673qM9671a = null;
            c2673qM9671a = null;
            if ("android.intent.action.MANAGED_PROFILE_AVAILABLE".equals(action) || "android.intent.action.MANAGED_PROFILE_UNAVAILABLE".equals(action)) {
                if (Utilities.f16752m && (userHandle = (UserHandle) intent.getParcelableExtra("android.intent.extra.USER")) != null) {
                    c2673qM9671a = C2673q.m9671a(userHandle);
                }
                if (c2673qM9671a != null) {
                    enqueuePackageUpdated(new PackageUpdatedTask(this, 7, new String[0], c2673qM9671a));
                    return;
                }
                return;
            }
            if (!"com.luutinhit.launcherios.ACTION_HIDDEN_APPS_IN_WORKSPACE".equals(action)) {
                if ("com.luutinhit.launcherios.ACTION_RELOAD_ICON".equals(action)) {
                    String stringExtra = intent.getStringExtra("EXTRA_COMPONENT_NAME");
                    int intExtra = intent.getIntExtra("EXTRA_ICON_ID", 0);
                    String stringExtra2 = intent.getStringExtra("EXTRA_ICON_PATH");
                    if (TextUtils.isEmpty(stringExtra2)) {
                        if (stringExtra != null && (componentNameUnflattenFromString2 = ComponentName.unflattenFromString(stringExtra)) != null) {
                            enqueuePackageUpdated(new PackageUpdatedTask(this, new String[]{componentNameUnflattenFromString2.getPackageName()}, stringExtra, C2673q.m9672b(), intExtra, null, 1));
                            return;
                        }
                    } else if (stringExtra != null && (componentNameUnflattenFromString3 = ComponentName.unflattenFromString(stringExtra)) != null) {
                        enqueuePackageUpdated(new PackageUpdatedTask(this, new String[]{componentNameUnflattenFromString3.getPackageName()}, stringExtra, C2673q.m9672b(), 0, stringExtra2, 2));
                        return;
                    }
                } else {
                    if (!"com.luutinhit.launcherios.ACTION_UPDATE_LABEL".equals(action)) {
                        if ("com.luutinhit.launcherios.ACTION_UPDATE_CATEGORY".equals(action)) {
                            String stringExtra3 = intent.getStringExtra("EXTRA_COMPONENT_NAME");
                            int intExtra2 = intent.getIntExtra("EXTRA_APP_CATEGORY", 0);
                            if (TextUtils.isEmpty(stringExtra3) || intExtra2 < 0) {
                                return;
                            }
                            enqueuePackageUpdated(new PackageUpdatedTask(this, stringExtra3, C2673q.m9672b(), intExtra2));
                            return;
                        }
                        return;
                    }
                    String stringExtra4 = intent.getStringExtra("EXTRA_COMPONENT_NAME");
                    String stringExtra5 = intent.getStringExtra("EXTRA_APP_LABEL");
                    if (!TextUtils.isEmpty(stringExtra4) && !TextUtils.isEmpty(stringExtra5) && (componentNameUnflattenFromString = ComponentName.unflattenFromString(stringExtra4)) != null) {
                        enqueuePackageUpdated(new PackageUpdatedTask(this, new String[]{componentNameUnflattenFromString.getPackageName()}, stringExtra4, C2673q.m9672b(), stringExtra5));
                        return;
                    }
                }
                return;
            }
            C2673q c2673qM9672b = C2673q.m9672b();
            String[] stringArrayExtra = intent.getStringArrayExtra("HIDDEN_APPS_UPDATED");
            String[] stringArrayExtra2 = intent.getStringArrayExtra("HIDDEN_APPS_REMOVED");
            HashSet hashSet = stringArrayExtra != null ? new HashSet(Arrays.asList(stringArrayExtra)) : null;
            HashSet hashSet2 = stringArrayExtra2 != null ? new HashSet(Arrays.asList(stringArrayExtra2)) : null;
            Objects.toString(hashSet);
            Objects.toString(hashSet2);
            Objects.toString(c2673qM9672b);
            LauncherModelCallbacks callback3 = getCallback();
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            synchronized (sBgLock) {
                try {
                    ArrayList arrayList4 = sBgWorkspaceItems;
                    arrayList4.size();
                    ((ArrayList) this.f15353u.f1070k).size();
                    int size = arrayList4.size();
                    int i7 = 0;
                    while (i7 < size) {
                        Object obj = arrayList4.get(i7);
                        i7++;
                        ItemInfo itemInfo = (ItemInfo) obj;
                        Objects.toString(itemInfo);
                        if (itemInfo instanceof ShortcutInfo) {
                            ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                            if (c2673qM9672b.equals(itemInfo.user) && itemInfo.itemType == 0 && (targetComponent = shortcutInfo.getTargetComponent()) != null && hashSet2 != null && hashSet2.contains(targetComponent.flattenToString())) {
                                shortcutInfo.m8056i(this.f15355w);
                                arrayList3.add(shortcutInfo);
                            }
                        }
                    }
                    ArrayList arrayList5 = (ArrayList) this.f15353u.f1070k;
                    int size2 = arrayList5.size();
                    while (i6 < size2) {
                        Object obj2 = arrayList5.get(i6);
                        i6++;
                        ShortcutInfo shortcutInfoMakeShortcut = ((AppInfo) obj2).makeShortcut();
                        ComponentName targetComponent2 = shortcutInfoMakeShortcut.getTargetComponent();
                        if (targetComponent2 != null && hashSet != null && hashSet.contains(targetComponent2.flattenToString())) {
                            shortcutInfoMakeShortcut.m8056i(this.f15355w);
                            arrayList2.add(shortcutInfoMakeShortcut);
                        }
                    }
                    this.f15353u.m859n(hashSet, c2673qM9672b, arrayList);
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
            arrayList2.size();
            arrayList3.size();
            if (!arrayList2.isEmpty() || !arrayList3.isEmpty()) {
                this.f15345m.m7884e(new RunnableC1089s((Object) this, (Object) callback3, (Serializable) arrayList2, (Object) arrayList3, (Object) c2673qM9672b, 5));
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f15345m.m7884e(new ModelCallbackRunnable(this, callback3, arrayList, 0));
        }
    }

    /* JADX INFO: renamed from: p */
    public final ShortcutInfo m7576p(Cursor cursor, Context context, int i6, C0062e c0062e) {
        Objects.toString(cursor);
        Objects.toString(context);
        Objects.toString(c0062e);
        ShortcutInfo shortcutInfo = new ShortcutInfo();
        shortcutInfo.user = C2673q.m9672b();
        shortcutInfo.itemType = 1;
        shortcutInfo.title = Utilities.trim(cursor.getString(i6));
        Bitmap bitmapM174a = c0062e.m174a(cursor, shortcutInfo, context);
        if (bitmapM174a == null) {
            bitmapM174a = this.f15355w.getDefaultIcon(shortcutInfo.user);
            shortcutInfo.f16555C = true;
        }
        shortcutInfo.f16558F = bitmapM174a;
        return shortcutInfo;
    }

    /* JADX INFO: renamed from: u */
    public final void m7577u(HashSet hashSet, C2673q c2673q) {
        Throwable th;
        LauncherModel launcherModel;
        ComponentName targetComponent;
        Objects.toString(hashSet);
        Objects.toString(c2673q);
        LauncherModelCallbacks callback = getCallback();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (sBgLock) {
            try {
                C0081x c0081x = sBgItemsIdMap;
                c0081x.getClass();
                int i6 = 0;
                while (i6 < c0081x.size()) {
                    int i7 = i6 + 1;
                    try {
                        ItemInfo itemInfo = (ItemInfo) c0081x.valueAt(i6);
                        if (itemInfo instanceof ShortcutInfo) {
                            ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                            if (c2673q.equals(itemInfo.user) && itemInfo.itemType == 0 && (targetComponent = shortcutInfo.getTargetComponent()) != null && hashSet.contains(targetComponent.getPackageName())) {
                                shortcutInfo.m8056i(this.f15355w);
                                arrayList2.add(shortcutInfo);
                            }
                        }
                        i6 = i7;
                    } catch (Throwable th2) {
                        th = th2;
                        while (true) {
                            try {
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                            } catch (Throwable th3) {
                                throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
                            }
                        }
                    }
                }
                this.f15353u.m859n(hashSet, c2673q, arrayList);
                if (arrayList2.isEmpty()) {
                    launcherModel = this;
                } else {
                    Partner partner = this.f15345m;
                    RunnableC0031a runnableC0031a = new RunnableC0031a(this, callback, arrayList2, c2673q, 11, false);
                    launcherModel = this;
                    partner.m7884e(runnableC0031a);
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                launcherModel.f15345m.m7884e(new ModelCallbackRunnable(this, callback, arrayList, 1));
            } catch (Throwable th4) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th4);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public final void enqueuePackageUpdate(int i6, String str) {
        enqueuePackageUpdated(new PackageUpdatedTask(this, str, C2673q.m9672b(), i6));
    }

    /* JADX INFO: renamed from: w */
    public final void m7579w(boolean z5) {
        synchronized (this.f15344l) {
            try {
                LoaderTask loaderTask = this.mLoaderTask;
                if (loaderTask != null) {
                    loaderTask.stopLocked();
                }
                if (z5) {
                    this.f15350r = false;
                }
                this.f15349q = false;
                this.f15351s = false;
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    /* JADX INFO: renamed from: x */
    public final void m7580x(Runnable runnable) {
        Objects.toString(runnable);
        if (sWorkerThread.getThreadId() == Process.myTid()) {
            this.f15345m.m7884e(runnable);
        } else {
            runnable.run();
        }
    }
}
