package com.luutinhit.launcher6;

import android.content.OperationApplicationException;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Process;
import android.os.StrictMode;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.luutinhit.launcherios.R;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import p122r3.AbstractC2666j;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: loaded from: classes.dex */
public class LauncherProvider extends ContentProvider {


    /* JADX INFO: renamed from: l */
    public static final /* synthetic */ int f15837l = 0;

    /* JADX INFO: renamed from: j */
    public Launcher f15838j;

    /* JADX INFO: renamed from: k */
    public DatabaseHelper f15839k;

    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0097 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:15:0x004a, B:17:0x0052, B:20:0x005d, B:22:0x0063, B:24:0x0069, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:35:0x0097, B:38:0x009f, B:42:0x00a8, B:44:0x00ae, B:46:0x00b4, B:48:0x00ba, B:50:0x00c0, B:53:0x00c7, B:56:0x00cd, B:58:0x00d3, B:60:0x00d9, B:62:0x00df, B:66:0x00e8, B:27:0x0070), top: B:75:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x009f A[Catch: all -> 0x00a5, TRY_ENTER, TryCatch #1 {all -> 0x00a5, blocks: (B:15:0x004a, B:17:0x0052, B:20:0x005d, B:22:0x0063, B:24:0x0069, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:35:0x0097, B:38:0x009f, B:42:0x00a8, B:44:0x00ae, B:46:0x00b4, B:48:0x00ba, B:50:0x00c0, B:53:0x00c7, B:56:0x00cd, B:58:0x00d3, B:60:0x00d9, B:62:0x00df, B:66:0x00e8, B:27:0x0070), top: B:75:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:15:0x004a, B:17:0x0052, B:20:0x005d, B:22:0x0063, B:24:0x0069, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:35:0x0097, B:38:0x009f, B:42:0x00a8, B:44:0x00ae, B:46:0x00b4, B:48:0x00ba, B:50:0x00c0, B:53:0x00c7, B:56:0x00cd, B:58:0x00d3, B:60:0x00d9, B:62:0x00df, B:66:0x00e8, B:27:0x0070), top: B:75:0x004a, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    public static long m7763b(DatabaseHelper databaseHelper, SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        ComponentName component;
        String strFlattenToString = null;
        Cursor cursorQuery = null;
        int columnIndex;
        String strFlattenToString2;
        String string;
        int columnIndex2;
        String string2;
        Intent uri;
        ComponentName component2;
        if (contentValues == null) {
            throw new RuntimeException("Error: attempting to insert null values");
        }
        if (!str.equals("appType")) {
            if (!contentValues.containsKey("_id")) {
                throw new RuntimeException("Error: attempting to add item without specifying an id");
            }
            databaseHelper.getClass();
            long jLongValue = contentValues.getAsLong("_id").longValue();
            if (str.equals("workspaceScreens")) {
                databaseHelper.f15442m = Math.max(jLongValue, databaseHelper.f15442m);
            } else {
                databaseHelper.f15441l = Math.max(jLongValue, databaseHelper.f15441l);
            }
        }
        try {
            if (str.equals("favorites")) {
                String asString = contentValues.getAsString("title");
                String asString2 = contentValues.getAsString("intent");
                if (asString2 != null) {
                    try {
                        Intent uri2 = Intent.parseUri(asString2, 0);
                        if (uri2 == null || (component = uri2.getComponent()) == null) {
                            strFlattenToString = null;
                        } else {
                            strFlattenToString = component.flattenToString();
                        }
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str) && (cursorQuery = sQLiteDatabase.query(str, new String[]{"title", "intent"}, "itemType = ? AND title = ?", new String[]{"0", asString}, null, null, null)) != null) {
                        while (cursorQuery.moveToNext()) {
                            columnIndex = cursorQuery.getColumnIndex("title");
                            strFlattenToString2 = "";
                            if (columnIndex >= 0) {
                                string = cursorQuery.getString(columnIndex);
                            } else {
                                string = "";
                            }
                            columnIndex2 = cursorQuery.getColumnIndex("intent");
                            if (columnIndex2 >= 0) {
                                string2 = cursorQuery.getString(columnIndex2);
                                if (string2 != null) {
                                    try {
                                        uri = Intent.parseUri(string2, 0);
                                        if (uri != null || (component2 = uri.getComponent()) == null) {
                                            strFlattenToString2 = null;
                                        } else {
                                            strFlattenToString2 = component2.flattenToString();
                                        }
                                    } catch (URISyntaxException e5) {
                                        e5.printStackTrace();
                                    }
                                } else {
                                    strFlattenToString2 = null;
                                }
                            }
                            if (strFlattenToString == null && !TextUtils.isEmpty(strFlattenToString2) && strFlattenToString.equals(strFlattenToString2) && !TextUtils.isEmpty(string) && string.equals(asString)) {
                                return -1L;
                            }
                        }
                        cursorQuery.close();
                    }
                } else {
                    strFlattenToString = null;
                    if (!TextUtils.isEmpty(str)) {
                        while (cursorQuery.moveToNext()) {
                            columnIndex = cursorQuery.getColumnIndex("title");
                            strFlattenToString2 = "";
                            if (columnIndex >= 0) {
                                string = cursorQuery.getString(columnIndex);
                            } else {
                                string = "";
                            }
                            columnIndex2 = cursorQuery.getColumnIndex("intent");
                            if (columnIndex2 >= 0) {
                                string2 = cursorQuery.getString(columnIndex2);
                                if (string2 != null) {
                                    uri = Intent.parseUri(string2, 0);
                                    if (uri != null) {
                                        strFlattenToString2 = null;
                                    } else {
                                        strFlattenToString2 = null;
                                    }
                                } else {
                                    strFlattenToString2 = null;
                                }
                            }
                            if (strFlattenToString == null) {
                            }
                        }
                        cursorQuery.close();
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    /* JADX INFO: renamed from: e */
    public static long m7764e(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT MAX(_id) FROM ".concat(str), null);
        long j6 = (cursorRawQuery == null || !cursorRawQuery.moveToNext()) ? -1L : cursorRawQuery.getLong(0);
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        if (j6 != -1) {
            return j6;
        }
        throw new RuntimeException("Error: could not query max id in ".concat(str));
    }

    /* JADX INFO: renamed from: i */
    public static void reloadLauncherIfExternal() {
        LauncherAppState launcherAppState;
        if (!Utilities.f16748i || Binder.getCallingPid() == Process.myPid() || (launcherAppState = LauncherAppState.f16217j) == null) {
            return;
        }
        LauncherModel launcherModel = launcherAppState.f16218a;
        launcherModel.m7579w(false);
        LauncherModelCallbacks callback = launcherModel.getCallback();
        if (callback == null || callback.setLoadOnResume()) {
            return;
        }
        launcherModel.startLoader(-1001, 0);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void createEmptyDB() {
        DatabaseHelper databaseHelper = this.f15839k;
        databaseHelper.createEmptyDB(databaseHelper.getWritableDatabase());
    }

    @Override // android.content.ContentProvider
    public final ContentProviderResult[] applyBatch(ArrayList arrayList) throws OperationApplicationException {
        SQLiteDatabase writableDatabase = this.f15839k.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            ContentProviderResult[] contentProviderResultArrApplyBatch = super.applyBatch(arrayList);
            writableDatabase.setTransactionSuccessful();
            reloadLauncherIfExternal();
            return contentProviderResultArrApplyBatch;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public final int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        if (uri.getPathSegments().size() != 1) {
            throw new IllegalArgumentException(SyntheticHelpers.m7910i(uri, "Invalid URI: "));
        }
        String str = uri.getPathSegments().get(0);
        SQLiteDatabase writableDatabase = this.f15839k.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            int length = contentValuesArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                contentValuesArr[i6].put("modified", Long.valueOf(System.currentTimeMillis()));
                if (m7763b(this.f15839k, writableDatabase, str, contentValuesArr[i6]) < 0) {
                    writableDatabase.endTransaction();
                    return 0;
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            notifyListeners();
            reloadLauncherIfExternal();
            return contentValuesArr.length;
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void recreateEmptyDB() {
        DatabaseHelper databaseHelper = this.f15839k;
        databaseHelper.createEmptyDB(databaseHelper.getWritableDatabase());
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        if (Binder.getCallingUid() != Process.myUid()) {
            return null;
        }
        str.getClass();
        if (str.equals("get_boolean_setting")) {
            Bundle bundle2 = new Bundle();
            if ("pref_allowRotation".equals(str2)) {
                bundle2.putBoolean("value", Utilities.isRotationAllowedForDevice(getContext()));
                return bundle2;
            }
            bundle2.putBoolean("value", Utilities.m8165q(getContext()).getBoolean(str2, bundle.getBoolean("default_value")));
            return bundle2;
        }
        if (!str.equals("set_boolean_setting")) {
            return null;
        }
        boolean z5 = bundle.getBoolean("value");
        Utilities.m8165q(getContext()).edit().putBoolean(str2, z5).apply();
        Launcher launcher = this.f15838j;
        if (launcher != null) {
            launcher.onSettingsChanged(str2, z5);
        }
        if (bundle.getBoolean("notify_backup")) {
            LauncherBackupAgentHelper.dataChanged(getContext());
        }
        Bundle bundle3 = new Bundle();
        bundle3.putBoolean("value", z5);
        return bundle3;
    }

    /* JADX INFO: renamed from: d */
    public final ArrayList deleteEmptyFolders() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = this.f15839k.getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Cursor cursorQuery = writableDatabase.query("favorites", new String[]{"_id"}, "itemType = 2 AND _id NOT IN (SELECT container FROM favorites)", null, null, null, null);
            while (cursorQuery.moveToNext()) {
                arrayList.add(Long.valueOf(cursorQuery.getLong(0)));
            }
            cursorQuery.close();
            if (arrayList.size() > 0) {
                writableDatabase.delete("favorites", Utilities.createDbSelectionQuery("_id", arrayList), null);
            }
            writableDatabase.setTransactionSuccessful();
            return arrayList;
        } catch (SQLException e) {
            e.getMessage();
            arrayList.clear();
            return arrayList;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        String str2;
        if (uri.getPathSegments().size() == 1) {
            str2 = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(SyntheticHelpers.m7910i(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException(SyntheticHelpers.m7910i(uri, "WHERE clause not supported: "));
            }
            String str3 = uri.getPathSegments().get(0);
            strArr = null;
            str = "_id=" + ContentUris.parseId(uri);
            str2 = str3;
        }
        int iDelete = this.f15839k.getWritableDatabase().delete(str2, str, strArr);
        if (iDelete > 0) {
            notifyListeners();
        }
        reloadLauncherIfExternal();
        return iDelete;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: f */
    public static final boolean SKIP_PLAY_AUTO_INSTALL_LAYOUT = true;

    public final synchronized void loadDefaultFavoritesIfNecessary() {
        com.luutinhit.launcher6.JadxSupport.useSource(); // changed on purpose (skips the Play Auto Installs layout)
        String string;
        AutoInstallsLayout defaultLayoutParser;
        Partner partner;
        Resources resources;
        int identifier;
        try {
            if (Utilities.m8165q(getContext()).getBoolean("EMPTY_DATABASE_CREATED", false)) {
                AutoInstallsLayout autoInstallsLayout = null;
                if (Utilities.f16755p) {
                    Context context = getContext();
                    Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
                    if (applicationRestrictions == null || (string = applicationRestrictions.getString("workspace.configuration.package.name")) == null) {
                        defaultLayoutParser = null;
                    } else {
                        try {
                            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(string);
                            DatabaseHelper databaseHelper = this.f15839k;
                            defaultLayoutParser = AutoInstallsLayout.get(context, string, resourcesForApplication, databaseHelper.f15440k, databaseHelper);
                        } catch (PackageManager.NameNotFoundException unused) {
                            defaultLayoutParser = null;
                        }
                    }
                } else {
                    defaultLayoutParser = null;
                }
                if (defaultLayoutParser == null) {
                    Context context2 = getContext();
                    DatabaseHelper databaseHelper2 = this.f15839k;
                    AppWidgetHost appWidgetHost = databaseHelper2.f15440k;
                    String str = AutoInstallsLayout.f16612n;
                    // Local change: skip the Play Auto Installs layout. Samsung's (android.autoinstalls.config.samsung)
                    // lists `autoinstall` items without screen/x/y, so every item ended up unplaced and the home
                    // screen stayed empty. The app's own default_workspace_*.xml is used instead.
                    Pair pairFindSystemApk = SKIP_PLAY_AUTO_INSTALL_LAYOUT ? null : Utilities.findSystemApk(context2.getPackageManager(), "android.autoinstalls.config.action.PLAY_AUTO_INSTALL");
                    if (pairFindSystemApk != null) {
                        autoInstallsLayout = AutoInstallsLayout.get(context2, (String) pairFindSystemApk.first, (Resources) pairFindSystemApk.second, appWidgetHost, databaseHelper2);
                    }
                    defaultLayoutParser = autoInstallsLayout;
                }
                if (defaultLayoutParser == null && (partner = Partner.get(getContext().getPackageManager())) != null && ((Resources) partner.f16124l).getIdentifier("partner_default_layout", "xml", (String) partner.f16123k) != 0 && (identifier = (resources = (Resources) partner.f16124l).getIdentifier("partner_default_layout", "xml", (String) partner.f16123k)) != 0) {
                    Context context3 = getContext();
                    DatabaseHelper databaseHelper3 = this.f15839k;
                    defaultLayoutParser = new DefaultLayoutParser(context3, databaseHelper3.f15440k, databaseHelper3, resources, identifier);
                }
                boolean z5 = defaultLayoutParser != null;
                if (defaultLayoutParser == null) {
                    int i6 = LauncherAppState.getInstance().f16222e.f16724p;
                    Context context4 = getContext();
                    DatabaseHelper databaseHelper4 = this.f15839k;
                    defaultLayoutParser = new DefaultLayoutParser(context4, databaseHelper4.f15440k, databaseHelper4, getContext().getResources(), i6);
                }
                createEmptyDB();
                DatabaseHelper databaseHelper5 = this.f15839k;
                if (databaseHelper5.m7624z(databaseHelper5.getWritableDatabase(), defaultLayoutParser) <= 0 && z5) {
                    createEmptyDB();
                    DatabaseHelper databaseHelper6 = this.f15839k;
                    SQLiteDatabase writableDatabase = databaseHelper6.getWritableDatabase();
                    int i7 = LauncherAppState.getInstance().f16222e.f16724p;
                    Context context5 = getContext();
                    DatabaseHelper databaseHelper7 = this.f15839k;
                    databaseHelper6.m7624z(writableDatabase, new DefaultLayoutParser(context5, databaseHelper7.f15440k, databaseHelper7, getContext().getResources(), i7));
                }
                Utilities.m8165q(getContext()).edit().remove("EMPTY_DATABASE_CREATED").apply();
            }
        } catch (Throwable th) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0365 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:12:0x00a0, B:14:0x00a6, B:15:0x0144, B:17:0x014c, B:23:0x0163, B:25:0x0188, B:27:0x018e, B:32:0x01b4, B:33:0x01ce, B:37:0x0200, B:40:0x020a, B:44:0x022d, B:45:0x0231, B:47:0x023b, B:50:0x0259, B:55:0x027e, B:59:0x028f, B:61:0x02a8, B:62:0x02af, B:66:0x02c4, B:68:0x0365, B:72:0x0374, B:74:0x03a2, B:76:0x03ae, B:77:0x03b6, B:53:0x0278, B:64:0x02b5, B:30:0x01a1, B:79:0x03e8, B:81:0x03fd, B:83:0x040d, B:85:0x0415, B:87:0x041b, B:92:0x0431, B:93:0x043a, B:94:0x0445, B:96:0x045a, B:99:0x0471, B:101:0x048e, B:102:0x0490, B:104:0x0494, B:105:0x049c, B:107:0x04a4, B:117:0x04ca, B:127:0x04f0, B:128:0x04f3, B:126:0x04ec, B:130:0x04fb, B:136:0x0520, B:143:0x0532, B:144:0x053c, B:145:0x053f, B:133:0x0501, B:142:0x052f), top: B:162:0x00a0, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x036f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0374 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:12:0x00a0, B:14:0x00a6, B:15:0x0144, B:17:0x014c, B:23:0x0163, B:25:0x0188, B:27:0x018e, B:32:0x01b4, B:33:0x01ce, B:37:0x0200, B:40:0x020a, B:44:0x022d, B:45:0x0231, B:47:0x023b, B:50:0x0259, B:55:0x027e, B:59:0x028f, B:61:0x02a8, B:62:0x02af, B:66:0x02c4, B:68:0x0365, B:72:0x0374, B:74:0x03a2, B:76:0x03ae, B:77:0x03b6, B:53:0x0278, B:64:0x02b5, B:30:0x01a1, B:79:0x03e8, B:81:0x03fd, B:83:0x040d, B:85:0x0415, B:87:0x041b, B:92:0x0431, B:93:0x043a, B:94:0x0445, B:96:0x045a, B:99:0x0471, B:101:0x048e, B:102:0x0490, B:104:0x0494, B:105:0x049c, B:107:0x04a4, B:117:0x04ca, B:127:0x04f0, B:128:0x04f3, B:126:0x04ec, B:130:0x04fb, B:136:0x0520, B:143:0x0532, B:144:0x053c, B:145:0x053f, B:133:0x0501, B:142:0x052f), top: B:162:0x00a0, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0396  */
    /* JADX WARN: Code duplicated, block: B:76:0x03ae A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:12:0x00a0, B:14:0x00a6, B:15:0x0144, B:17:0x014c, B:23:0x0163, B:25:0x0188, B:27:0x018e, B:32:0x01b4, B:33:0x01ce, B:37:0x0200, B:40:0x020a, B:44:0x022d, B:45:0x0231, B:47:0x023b, B:50:0x0259, B:55:0x027e, B:59:0x028f, B:61:0x02a8, B:62:0x02af, B:66:0x02c4, B:68:0x0365, B:72:0x0374, B:74:0x03a2, B:76:0x03ae, B:77:0x03b6, B:53:0x0278, B:64:0x02b5, B:30:0x01a1, B:79:0x03e8, B:81:0x03fd, B:83:0x040d, B:85:0x0415, B:87:0x041b, B:92:0x0431, B:93:0x043a, B:94:0x0445, B:96:0x045a, B:99:0x0471, B:101:0x048e, B:102:0x0490, B:104:0x0494, B:105:0x049c, B:107:0x04a4, B:117:0x04ca, B:127:0x04f0, B:128:0x04f3, B:126:0x04ec, B:130:0x04fb, B:136:0x0520, B:143:0x0532, B:144:0x053c, B:145:0x053f, B:133:0x0501, B:142:0x052f), top: B:162:0x00a0, inners: #1, #3 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x03b6 A[Catch: all -> 0x019e, TryCatch #4 {all -> 0x019e, blocks: (B:12:0x00a0, B:14:0x00a6, B:15:0x0144, B:17:0x014c, B:23:0x0163, B:25:0x0188, B:27:0x018e, B:32:0x01b4, B:33:0x01ce, B:37:0x0200, B:40:0x020a, B:44:0x022d, B:45:0x0231, B:47:0x023b, B:50:0x0259, B:55:0x027e, B:59:0x028f, B:61:0x02a8, B:62:0x02af, B:66:0x02c4, B:68:0x0365, B:72:0x0374, B:74:0x03a2, B:76:0x03ae, B:77:0x03b6, B:53:0x0278, B:64:0x02b5, B:30:0x01a1, B:79:0x03e8, B:81:0x03fd, B:83:0x040d, B:85:0x0415, B:87:0x041b, B:92:0x0431, B:93:0x043a, B:94:0x0445, B:96:0x045a, B:99:0x0471, B:101:0x048e, B:102:0x0490, B:104:0x0494, B:105:0x049c, B:107:0x04a4, B:117:0x04ca, B:127:0x04f0, B:128:0x04f3, B:126:0x04ec, B:130:0x04fb, B:136:0x0520, B:143:0x0532, B:144:0x053c, B:145:0x053f, B:133:0x0501, B:142:0x052f), top: B:162:0x00a0, inners: #1, #3 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 15 */
    /* JADX INFO: renamed from: g */
    public final void migrateLauncher2Shortcuts() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Cursor cursorQuery;
        String str;
        String str2 = null;
        DatabaseHelper databaseHelper = null;
        SQLiteDatabase sQLiteDatabase;
        int i6;
        int i7;
        SparseArray sparseArray;
        int i8 = 0;
        int i9;
        int i10;
        C2673q c2673qMo9678h;
        long j6;
        int i11;
        ContentValues contentValues;
        SparseArray sparseArray2;
        String str3;
        String str4;
        String str5;
        ArrayList arrayList;
        ArrayList arrayList2;
        DatabaseHelper databaseHelper2 = this.f15839k;
        SQLiteDatabase writableDatabase = databaseHelper2.getWritableDatabase();
        Uri uri = Uri.parse(getContext().getString(R.string.old_launcher_provider_uri));
        Context context = databaseHelper2.f15439j;
        String str6 = "intent";
        DatabaseHelper databaseHelper3 = databaseHelper2;
        SQLiteDatabase sQLiteDatabase2 = writableDatabase;
        String str7 = "title";
        try {
            cursorQuery = context.getContentResolver().query(uri, null, null, null, "title ASC");
        } catch (Exception unused) {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow(str6);
                    String str8 = "workspaceScreens";
                    int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow(str7);
                    String str9 = "favorites";
                    int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("iconType");
                    String str10 = "iconType";
                    int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("icon");
                    String str11 = "icon";
                    int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("iconPackage");
                    String str12 = "iconPackage";
                    int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("iconResource");
                    String str13 = "iconResource";
                    int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("container");
                    String str14 = "container";
                    int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("itemType");
                    String str15 = "itemType";
                    int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("screen");
                    String str16 = "screen";
                    int i12 = columnIndexOrThrow7;
                    int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("cellX");
                    String str17 = "cellX";
                    int i13 = columnIndexOrThrow6;
                    int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("cellY");
                    String str18 = "cellY";
                    int i14 = columnIndexOrThrow5;
                    String str19 = "uri";
                    int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("uri");
                    String str20 = "displayMode";
                    int columnIndexOrThrow14 = cursorQuery.getColumnIndexOrThrow("displayMode");
                    int columnIndex = cursorQuery.getColumnIndex("profileId");
                    String str21 = "profileId";
                    InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
                    int i15 = columnIndexOrThrow4;
                    int i16 = invariantDeviceProfile.f16712d;
                    int i17 = invariantDeviceProfile.f16711c;
                    int i18 = invariantDeviceProfile.f16719k;
                    InvariantDeviceProfile invariantDeviceProfile2 = invariantDeviceProfile;
                    HashSet hashSet = new HashSet(cursorQuery.getCount());
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    SparseArray sparseArray3 = new SparseArray();
                    while (true) {
                        sparseArray = sparseArray3;
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        int i19 = cursorQuery.getInt(columnIndexOrThrow9);
                        columnIndexOrThrow9 = columnIndexOrThrow9;
                        String str22 = str7;
                        if (i19 == 0 || i19 == 1 || i19 == 2) {
                            int i20 = cursorQuery.getInt(columnIndexOrThrow11);
                            int i21 = cursorQuery.getInt(columnIndexOrThrow12);
                            int i22 = columnIndexOrThrow12;
                            int i23 = cursorQuery.getInt(columnIndexOrThrow10);
                            int i24 = columnIndexOrThrow10;
                            int i25 = cursorQuery.getInt(columnIndexOrThrow8);
                            int i26 = columnIndexOrThrow8;
                            String string = cursorQuery.getString(columnIndexOrThrow2);
                            int i27 = columnIndexOrThrow2;
                            C2674r c2674rM9673e = C2674r.m9673e(context);
                            int i28 = columnIndexOrThrow11;
                            if (columnIndex == -1 || cursorQuery.isNull(columnIndex)) {
                                i10 = -1;
                                C2673q c2673qM9672b = C2673q.m9672b();
                                long jMo9676f = c2674rM9673e.mo9676f(c2673qM9672b);
                                c2673qMo9678h = c2673qM9672b;
                                j6 = jMo9676f;
                            } else {
                                i10 = -1;
                                j6 = cursorQuery.getInt(columnIndex);
                                c2673qMo9678h = c2674rM9673e.mo9678h(j6);
                            }
                            if (c2673qMo9678h == null) {
                                Launcher.addDumpLog("LauncherProvider", "skipping deleted user", true);
                                sparseArray3 = sparseArray;
                                str7 = str22;
                                columnIndexOrThrow12 = i22;
                                columnIndexOrThrow10 = i24;
                                columnIndexOrThrow8 = i26;
                                columnIndexOrThrow2 = i27;
                                columnIndexOrThrow11 = i28;
                                columnIndexOrThrow = columnIndexOrThrow;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                int i29 = columnIndex;
                                sb.append("migrating \"");
                                sb.append(cursorQuery.getString(columnIndexOrThrow3));
                                sb.append("\" (");
                                sb.append(i20);
                                sb.append(",");
                                sb.append(i21);
                                sb.append("@");
                                Uri uri2 = Favorites.f15684a;
                                sb.append(i25 != -101 ? i25 != -100 ? String.valueOf(i25) : "desktop" : "hotseat");
                                sb.append("/");
                                sb.append(i23);
                                sb.append("): ");
                                sb.append(string);
                                Launcher.addDumpLog("LauncherProvider", sb.toString(), true);
                                if (i19 != 2) {
                                    i11 = i21;
                                    try {
                                        Intent uri3 = Intent.parseUri(string, 0);
                                        ComponentName component = uri3.getComponent();
                                        if (TextUtils.isEmpty(string)) {
                                            Launcher.addDumpLog("LauncherProvider", "skipping empty intent", true);
                                        } else {
                                            if (component != null) {
                                                HandlerThread handlerThread = LauncherModel.sWorkerThread;
                                                Objects.toString(context);
                                                Objects.toString(component);
                                                Objects.toString(c2673qMo9678h);
                                                AbstractC2666j abstractC2666jM9657c = AbstractC2666j.m9657c(context);
                                                if (!(!abstractC2666jM9657c.mo9662f(component.getPackageName(), c2673qMo9678h) ? false : abstractC2666jM9657c.mo9661e(component, c2673qMo9678h))) {
                                                    Launcher.addDumpLog("LauncherProvider", "skipping item whose component no longer exists.", true);
                                                }
                                            }
                                            if (i25 == -100) {
                                                uri3.setPackage(null);
                                                int flags = uri3.getFlags();
                                                uri3.setFlags(0);
                                                String uri4 = uri3.toUri(0);
                                                uri3.setFlags(flags);
                                                if (hashSet.contains(uri4)) {
                                                    Launcher.addDumpLog("LauncherProvider", "skipping duplicate", true);
                                                } else {
                                                    hashSet.add(uri4);
                                                }
                                            }
                                            contentValues = new ContentValues(cursorQuery.getColumnCount());
                                            int i30 = columnIndexOrThrow;
                                            contentValues.put("_id", Integer.valueOf(cursorQuery.getInt(i30)));
                                            contentValues.put(str6, string);
                                            contentValues.put(str22, cursorQuery.getString(columnIndexOrThrow3));
                                            int i31 = i15;
                                            String str23 = str10;
                                            contentValues.put(str23, Integer.valueOf(cursorQuery.getInt(i31)));
                                            int i32 = i14;
                                            String str24 = str6;
                                            String str25 = str11;
                                            contentValues.put(str25, cursorQuery.getBlob(i32));
                                            str11 = str25;
                                            int i33 = i13;
                                            String string2 = cursorQuery.getString(i33);
                                            i13 = i33;
                                            String str26 = str12;
                                            contentValues.put(str26, string2);
                                            str12 = str26;
                                            int i34 = i12;
                                            String string3 = cursorQuery.getString(i34);
                                            i12 = i34;
                                            String str27 = str13;
                                            contentValues.put(str27, string3);
                                            str13 = str27;
                                            String str28 = str15;
                                            contentValues.put(str28, Integer.valueOf(i19));
                                            str15 = str28;
                                            contentValues.put("appWidgetId", Integer.valueOf(i10));
                                            int i35 = columnIndexOrThrow13;
                                            String string4 = cursorQuery.getString(i35);
                                            columnIndexOrThrow13 = i35;
                                            String str29 = str19;
                                            contentValues.put(str29, string4);
                                            int i36 = columnIndexOrThrow14;
                                            str19 = str29;
                                            Integer numValueOf = Integer.valueOf(cursorQuery.getInt(i36));
                                            columnIndexOrThrow14 = i36;
                                            String str30 = str20;
                                            contentValues.put(str30, numValueOf);
                                            str20 = str30;
                                            str21 = str21;
                                            contentValues.put(str21, Long.valueOf(j6));
                                            if (i25 == -101) {
                                                sparseArray2 = sparseArray;
                                                sparseArray2.put(i23, contentValues);
                                            } else {
                                                sparseArray2 = sparseArray;
                                            }
                                            if (i25 != -100) {
                                                str3 = str16;
                                                contentValues.put(str3, Integer.valueOf(i23));
                                                str4 = str17;
                                                contentValues.put(str4, Integer.valueOf(i20));
                                                str5 = str18;
                                                contentValues.put(str5, Integer.valueOf(i11));
                                            } else {
                                                str3 = str16;
                                                str4 = str17;
                                                str5 = str18;
                                            }
                                            Integer numValueOf2 = Integer.valueOf(i25);
                                            String str31 = str14;
                                            contentValues.put(str31, numValueOf2);
                                            if (i19 != 2) {
                                                arrayList = arrayList3;
                                                arrayList.add(contentValues);
                                                arrayList2 = arrayList4;
                                            } else {
                                                arrayList = arrayList3;
                                                arrayList2 = arrayList4;
                                                arrayList2.add(contentValues);
                                            }
                                            sparseArray3 = sparseArray2;
                                            str7 = str22;
                                            arrayList3 = arrayList;
                                            arrayList4 = arrayList2;
                                            str16 = str3;
                                            str17 = str4;
                                            str18 = str5;
                                            i15 = i31;
                                            str14 = str31;
                                            str6 = str24;
                                            columnIndexOrThrow3 = columnIndexOrThrow3;
                                            columnIndexOrThrow12 = i22;
                                            columnIndexOrThrow10 = i24;
                                            columnIndexOrThrow2 = i27;
                                            columnIndexOrThrow = i30;
                                            columnIndex = i29;
                                            i14 = i32;
                                            str10 = str23;
                                            columnIndexOrThrow8 = i26;
                                            columnIndexOrThrow11 = i28;
                                        }
                                    } catch (URISyntaxException unused2) {
                                        Launcher.addDumpLog("LauncherProvider", "skipping invalid intent uri", true);
                                    }
                                    sparseArray3 = sparseArray;
                                    str7 = str22;
                                    columnIndexOrThrow12 = i22;
                                    columnIndexOrThrow10 = i24;
                                    columnIndexOrThrow8 = i26;
                                    columnIndexOrThrow2 = i27;
                                    columnIndexOrThrow11 = i28;
                                    columnIndexOrThrow = columnIndexOrThrow;
                                    columnIndex = i29;
                                } else {
                                    i11 = i21;
                                    i20 = i20;
                                    j6 = j6;
                                }
                                contentValues = new ContentValues(cursorQuery.getColumnCount());
                                int i37 = columnIndexOrThrow;
                                contentValues.put("_id", Integer.valueOf(cursorQuery.getInt(i37)));
                                contentValues.put(str6, string);
                                contentValues.put(str22, cursorQuery.getString(columnIndexOrThrow3));
                                int i38 = i15;
                                String str210 = str10;
                                contentValues.put(str210, Integer.valueOf(cursorQuery.getInt(i38)));
                                int i39 = i14;
                                String str211 = str6;
                                String str212 = str11;
                                contentValues.put(str212, cursorQuery.getBlob(i39));
                                str11 = str212;
                                int i310 = i13;
                                String string5 = cursorQuery.getString(i310);
                                i13 = i310;
                                String str213 = str12;
                                contentValues.put(str213, string5);
                                str12 = str213;
                                int i311 = i12;
                                String string6 = cursorQuery.getString(i311);
                                i12 = i311;
                                String str214 = str13;
                                contentValues.put(str214, string6);
                                str13 = str214;
                                String str215 = str15;
                                contentValues.put(str215, Integer.valueOf(i19));
                                str15 = str215;
                                contentValues.put("appWidgetId", Integer.valueOf(i10));
                                int i312 = columnIndexOrThrow13;
                                String string7 = cursorQuery.getString(i312);
                                columnIndexOrThrow13 = i312;
                                String str216 = str19;
                                contentValues.put(str216, string7);
                                int i313 = columnIndexOrThrow14;
                                str19 = str216;
                                Integer numValueOf3 = Integer.valueOf(cursorQuery.getInt(i313));
                                columnIndexOrThrow14 = i313;
                                String str32 = str20;
                                contentValues.put(str32, numValueOf3);
                                str20 = str32;
                                str21 = str21;
                                contentValues.put(str21, Long.valueOf(j6));
                                if (i25 == -101) {
                                    sparseArray2 = sparseArray;
                                    sparseArray2.put(i23, contentValues);
                                } else {
                                    sparseArray2 = sparseArray;
                                }
                                if (i25 != -100) {
                                    str3 = str16;
                                    contentValues.put(str3, Integer.valueOf(i23));
                                    str4 = str17;
                                    contentValues.put(str4, Integer.valueOf(i20));
                                    str5 = str18;
                                    contentValues.put(str5, Integer.valueOf(i11));
                                } else {
                                    str3 = str16;
                                    str4 = str17;
                                    str5 = str18;
                                }
                                Integer numValueOf4 = Integer.valueOf(i25);
                                String str33 = str14;
                                contentValues.put(str33, numValueOf4);
                                if (i19 != 2) {
                                    arrayList = arrayList3;
                                    arrayList.add(contentValues);
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList = arrayList3;
                                    arrayList2 = arrayList4;
                                    arrayList2.add(contentValues);
                                }
                                sparseArray3 = sparseArray2;
                                str7 = str22;
                                arrayList3 = arrayList;
                                arrayList4 = arrayList2;
                                str16 = str3;
                                str17 = str4;
                                str18 = str5;
                                i15 = i38;
                                str14 = str33;
                                str6 = str211;
                                columnIndexOrThrow3 = columnIndexOrThrow3;
                                columnIndexOrThrow12 = i22;
                                columnIndexOrThrow10 = i24;
                                columnIndexOrThrow2 = i27;
                                columnIndexOrThrow = i37;
                                columnIndex = i29;
                                i14 = i39;
                                str10 = str210;
                                columnIndexOrThrow8 = i26;
                                columnIndexOrThrow11 = i28;
                            }
                        } else {
                            sparseArray3 = sparseArray;
                            str7 = str22;
                        }
                        cursorQuery.close();
                        throw new RuntimeException("jadx lost the exception rethrown here (see RECOMPILE-NOTES.md)");
                    }
                    String str34 = str14;
                    String str35 = str16;
                    String str36 = str17;
                    String str37 = str18;
                    ArrayList arrayList5 = arrayList3;
                    ArrayList arrayList6 = arrayList4;
                    int i40 = 0;
                    for (int size = sparseArray.size(); i40 < size; size = size) {
                        int iKeyAt = sparseArray.keyAt(i40);
                        ContentValues contentValues2 = (ContentValues) sparseArray.valueAt(i40);
                        InvariantDeviceProfile invariantDeviceProfile3 = invariantDeviceProfile2;
                        if (iKeyAt == invariantDeviceProfile3.f16720l) {
                            while (true) {
                                iKeyAt++;
                                i9 = i18;
                                if (iKeyAt >= i9) {
                                    break;
                                }
                                if (sparseArray.get(iKeyAt) == null) {
                                    contentValues2.put(str35, Integer.valueOf(iKeyAt));
                                    break;
                                }
                                i18 = i9;
                            }
                        } else {
                            i9 = i18;
                        }
                        if (iKeyAt >= i9) {
                            contentValues2.put(str34, (Integer) (-100));
                        }
                        i40++;
                        invariantDeviceProfile2 = invariantDeviceProfile3;
                        i18 = i9;
                    }
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.addAll(arrayList6);
                    arrayList7.addAll(arrayList5);
                    int size2 = arrayList7.size();
                    int i41 = 0;
                    int i42 = 0;
                    int i43 = 0;
                    int iGenerateNewScreenId = 0;
                    while (i43 < size2) {
                        Object obj = arrayList7.get(i43);
                        i43++;
                        ContentValues contentValues3 = (ContentValues) obj;
                        if (contentValues3.getAsInteger(str34).intValue() == -100) {
                            contentValues3.put(str35, Integer.valueOf(iGenerateNewScreenId));
                            contentValues3.put(str36, Integer.valueOf(i41));
                            contentValues3.put(str37, Integer.valueOf(i42));
                            i41 = (i41 + 1) % i16;
                            if (i41 == 0) {
                                i42++;
                            }
                            if (i42 == i17 - 1) {
                                iGenerateNewScreenId = (int) databaseHelper3.generateNewScreenId();
                                i42 = 0;
                            }
                        }
                    }
                    if (arrayList7.size() > 0) {
                        sQLiteDatabase2.beginTransaction();
                        try {
                            int size3 = arrayList7.size();
                            i8 = 0;
                            int i44 = 0;
                            while (i44 < size3) {
                                Object obj2 = arrayList7.get(i44);
                                i44++;
                                ContentValues contentValues4 = (ContentValues) obj2;
                                if (contentValues4 != null) {
                                    DatabaseHelper databaseHelper4 = databaseHelper3;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    String str38 = str9;
                                    try {
                                        if (m7763b(databaseHelper4, sQLiteDatabase, str38, contentValues4) < 0) {
                                            sQLiteDatabase.endTransaction();
                                            cursorQuery.close();
                                            return;
                                        } else {
                                            i8++;
                                            databaseHelper3 = databaseHelper4;
                                            sQLiteDatabase2 = sQLiteDatabase;
                                            str9 = str38;
                                        }
                                    } catch (Throwable th) {
                                        sQLiteDatabase.endTransaction();
                                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                                    }
                                }
                            }
                            databaseHelper = databaseHelper3;
                            sQLiteDatabase = sQLiteDatabase2;
                            str2 = str9;
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable th2) {
                            Throwable th = th2;
                            sQLiteDatabase = sQLiteDatabase2;
                        }
                    } else {
                        databaseHelper = databaseHelper3;
                        sQLiteDatabase = sQLiteDatabase2;
                        str2 = str9;
                        i8 = 0;
                    }
                    sQLiteDatabase.beginTransaction();
                    int i45 = 0;
                    while (i45 <= iGenerateNewScreenId) {
                        try {
                            ContentValues contentValues5 = new ContentValues();
                            contentValues5.put("_id", Integer.valueOf(i45));
                            contentValues5.put("screenRank", Integer.valueOf(i45));
                            String str39 = str8;
                            if (m7763b(databaseHelper, sQLiteDatabase, str39, contentValues5) < 0) {
                                sQLiteDatabase.endTransaction();
                                cursorQuery.close();
                                return;
                            } else {
                                i45++;
                                str8 = str39;
                            }
                        } catch (Throwable th3) {
                            sQLiteDatabase.endTransaction();
                            throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
                        }
                    }
                    str = str8;
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    DatabaseHelper.m7615B(sQLiteDatabase, false);
                    i6 = iGenerateNewScreenId;
                    i7 = i8;
                } else {
                    str = "workspaceScreens";
                    str2 = "favorites";
                    databaseHelper = databaseHelper3;
                    sQLiteDatabase = sQLiteDatabase2;
                    i6 = 0;
                    i7 = 0;
                }
                cursorQuery.close();
            } catch (Throwable th4) {
                cursorQuery.close();
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th4);
            }
        } else {
            str = "workspaceScreens";
            str2 = "favorites";
            databaseHelper = databaseHelper3;
            sQLiteDatabase = sQLiteDatabase2;
            i6 = 0;
            i7 = 0;
        }
        Launcher.addDumpLog("LauncherProvider", "migrated " + i7 + " icons from Launcher2 into " + (i6 + 1) + " screens", true);
        Rect rect = Utilities.sOldBounds;
        context.getSharedPreferences("com.luutinhit.launcher6.prefs", 0).edit().putBoolean("EMPTY_DATABASE_CREATED", false).commit();
        databaseHelper.f15441l = m7764e(sQLiteDatabase, str2);
        databaseHelper.f15442m = m7764e(sQLiteDatabase, str);
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        String str;
        String str2 = null;
        if (uri.getPathSegments().size() == 1) {
            str = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(SyntheticHelpers.m7910i(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(null)) {
                throw new UnsupportedOperationException(SyntheticHelpers.m7910i(uri, "WHERE clause not supported: "));
            }
            String str3 = uri.getPathSegments().get(0);
            str2 = "_id=" + ContentUris.parseId(uri);
            str = str3;
        }
        if (TextUtils.isEmpty(str2)) {
            return "vnd.android.cursor.dir/" + str;
        }
        return "vnd.android.cursor.item/" + str;
    }

    /* JADX INFO: renamed from: h */
    public final void notifyListeners() {
        LauncherBackupAgentHelper.dataChanged(getContext());
        Launcher launcher = this.f15838j;
        if (launcher != null) {
            launcher.onLauncherProviderChange();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0076  */
    /* JADX WARN: Code duplicated, block: B:19:0x009a  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:29:0x00be  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:35:0x0100  */
    /* JADX WARN: Code duplicated, block: B:37:0x010b  */
    /* JADX WARN: Code duplicated, block: B:39:0x010f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0115  */
    /* JADX WARN: Code duplicated, block: B:45:0x012c  */
    /* JADX WARN: Code duplicated, block: B:50:0x013f  */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x0076, please report this as an issue */
    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        long jM7763b;
        Uri uriWithAppendedId;
        LauncherAppState launcherAppState;
        String queryParameter;
        LauncherModel launcherModel;
        LauncherModelCallbacks callback;
        Long asLong;
        Cursor cursorRawQuery;
        Cursor cursorRawQuery2;
        int i6;
        ContentValues contentValues2;
        int count;
        if (uri.getPathSegments().size() != 1) {
            throw new IllegalArgumentException(SyntheticHelpers.m7910i(uri, "Invalid URI: "));
        }
        String str = uri.getPathSegments().get(0);
        if (Binder.getCallingPid() != Process.myPid()) {
            DatabaseHelper databaseHelper = this.f15839k;
            contentValues.put("_id", Long.valueOf(databaseHelper.generateNewItemId()));
            Integer asInteger = contentValues.getAsInteger("itemType");
            if (asInteger == null || asInteger.intValue() != 4 || contentValues.containsKey("appWidgetId")) {
                asLong = contentValues.getAsLong("screen");
                long jLongValue = asLong.longValue();
                cursorRawQuery = databaseHelper.getWritableDatabase().rawQuery("SELECT * FROM workspaceScreens WHERE _id = " + jLongValue, null);
                if (cursorRawQuery != null) {
                    count = cursorRawQuery.getCount();
                    cursorRawQuery.close();
                    if (count > 0) {
                        SQLiteDatabase writableDatabase = this.f15839k.getWritableDatabase();
                        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                        jM7763b = m7763b(this.f15839k, writableDatabase, str, contentValues);
                        if (jM7763b >= 0) {
                            uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                            notifyListeners();
                            if (Utilities.f16748i) {
                                reloadLauncherIfExternal();
                                return uriWithAppendedId;
                            }
                            launcherAppState = LauncherAppState.f16217j;
                            if (launcherAppState != null && "true".equals(uriWithAppendedId.getQueryParameter("isExternalAdd"))) {
                                launcherModel = launcherAppState.f16218a;
                                launcherModel.m7579w(false);
                                callback = launcherModel.getCallback();
                                if (callback != null && !callback.setLoadOnResume()) {
                                    launcherModel.startLoader(-1001, 0);
                                }
                            }
                            queryParameter = uriWithAppendedId.getQueryParameter("notify");
                            if (queryParameter == null && !"true".equals(queryParameter)) {
                                return uriWithAppendedId;
                            }
                            getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                            return uriWithAppendedId;
                        }
                    } else {
                        cursorRawQuery2 = databaseHelper.getWritableDatabase().rawQuery("SELECT MAX(screenRank) FROM workspaceScreens", null);
                        if (cursorRawQuery2 == null && cursorRawQuery2.moveToNext()) {
                            i6 = cursorRawQuery2.getInt(0);
                        } else {
                            i6 = -1;
                        }
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        contentValues2 = new ContentValues();
                        contentValues2.put("_id", asLong);
                        contentValues2.put("screenRank", Integer.valueOf(i6 + 1));
                        if (m7763b(databaseHelper, databaseHelper.getWritableDatabase(), "workspaceScreens", contentValues2) >= 0) {
                            SQLiteDatabase writableDatabase2 = this.f15839k.getWritableDatabase();
                            contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                            jM7763b = m7763b(this.f15839k, writableDatabase2, str, contentValues);
                            if (jM7763b >= 0) {
                                uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                                notifyListeners();
                                if (Utilities.f16748i) {
                                    reloadLauncherIfExternal();
                                    return uriWithAppendedId;
                                }
                                launcherAppState = LauncherAppState.f16217j;
                                if (launcherAppState != null) {
                                    launcherModel = launcherAppState.f16218a;
                                    launcherModel.m7579w(false);
                                    callback = launcherModel.getCallback();
                                    if (callback != null) {
                                        launcherModel.startLoader(-1001, 0);
                                    }
                                }
                                queryParameter = uriWithAppendedId.getQueryParameter("notify");
                                if (queryParameter == null) {
                                }
                                getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                                return uriWithAppendedId;
                            }
                        }
                    }
                } else {
                    cursorRawQuery2 = databaseHelper.getWritableDatabase().rawQuery("SELECT MAX(screenRank) FROM workspaceScreens", null);
                    if (cursorRawQuery2 == null) {
                        i6 = -1;
                    } else {
                        i6 = -1;
                    }
                    if (cursorRawQuery2 != null) {
                        cursorRawQuery2.close();
                    }
                    contentValues2 = new ContentValues();
                    contentValues2.put("_id", asLong);
                    contentValues2.put("screenRank", Integer.valueOf(i6 + 1));
                    if (m7763b(databaseHelper, databaseHelper.getWritableDatabase(), "workspaceScreens", contentValues2) >= 0) {
                        SQLiteDatabase writableDatabase3 = this.f15839k.getWritableDatabase();
                        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                        jM7763b = m7763b(this.f15839k, writableDatabase3, str, contentValues);
                        if (jM7763b >= 0) {
                            uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                            notifyListeners();
                            if (Utilities.f16748i) {
                                reloadLauncherIfExternal();
                                return uriWithAppendedId;
                            }
                            launcherAppState = LauncherAppState.f16217j;
                            if (launcherAppState != null) {
                                launcherModel = launcherAppState.f16218a;
                                launcherModel.m7579w(false);
                                callback = launcherModel.getCallback();
                                if (callback != null) {
                                    launcherModel.startLoader(-1001, 0);
                                }
                            }
                            queryParameter = uriWithAppendedId.getQueryParameter("notify");
                            if (queryParameter == null) {
                            }
                            getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                            return uriWithAppendedId;
                        }
                    }
                }
            } else {
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(databaseHelper.f15439j);
                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(contentValues.getAsString("appWidgetProvider"));
                if (componentNameUnflattenFromString != null) {
                    try {
                        int iAllocateAppWidgetId = databaseHelper.f15440k.allocateAppWidgetId();
                        contentValues.put("appWidgetId", Integer.valueOf(iAllocateAppWidgetId));
                        if (appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, componentNameUnflattenFromString)) {
                            asLong = contentValues.getAsLong("screen");
                            long jLongValue2 = asLong.longValue();
                            cursorRawQuery = databaseHelper.getWritableDatabase().rawQuery("SELECT * FROM workspaceScreens WHERE _id = " + jLongValue2, null);
                            if (cursorRawQuery != null) {
                                count = cursorRawQuery.getCount();
                                cursorRawQuery.close();
                                if (count > 0) {
                                    SQLiteDatabase writableDatabase4 = this.f15839k.getWritableDatabase();
                                    contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                                    jM7763b = m7763b(this.f15839k, writableDatabase4, str, contentValues);
                                    if (jM7763b >= 0) {
                                        uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                                        notifyListeners();
                                        if (Utilities.f16748i) {
                                            reloadLauncherIfExternal();
                                            return uriWithAppendedId;
                                        }
                                        launcherAppState = LauncherAppState.f16217j;
                                        if (launcherAppState != null) {
                                            launcherModel = launcherAppState.f16218a;
                                            launcherModel.m7579w(false);
                                            callback = launcherModel.getCallback();
                                            if (callback != null) {
                                                launcherModel.startLoader(-1001, 0);
                                            }
                                        }
                                        queryParameter = uriWithAppendedId.getQueryParameter("notify");
                                        if (queryParameter == null) {
                                        }
                                        getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                                        return uriWithAppendedId;
                                    }
                                } else {
                                    cursorRawQuery2 = databaseHelper.getWritableDatabase().rawQuery("SELECT MAX(screenRank) FROM workspaceScreens", null);
                                    if (cursorRawQuery2 == null) {
                                        i6 = -1;
                                    } else {
                                        i6 = -1;
                                    }
                                    if (cursorRawQuery2 != null) {
                                        cursorRawQuery2.close();
                                    }
                                    contentValues2 = new ContentValues();
                                    contentValues2.put("_id", asLong);
                                    contentValues2.put("screenRank", Integer.valueOf(i6 + 1));
                                    if (m7763b(databaseHelper, databaseHelper.getWritableDatabase(), "workspaceScreens", contentValues2) >= 0) {
                                        SQLiteDatabase writableDatabase5 = this.f15839k.getWritableDatabase();
                                        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                                        jM7763b = m7763b(this.f15839k, writableDatabase5, str, contentValues);
                                        if (jM7763b >= 0) {
                                            uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                                            notifyListeners();
                                            if (Utilities.f16748i) {
                                                reloadLauncherIfExternal();
                                                return uriWithAppendedId;
                                            }
                                            launcherAppState = LauncherAppState.f16217j;
                                            if (launcherAppState != null) {
                                                launcherModel = launcherAppState.f16218a;
                                                launcherModel.m7579w(false);
                                                callback = launcherModel.getCallback();
                                                if (callback != null) {
                                                    launcherModel.startLoader(-1001, 0);
                                                }
                                            }
                                            queryParameter = uriWithAppendedId.getQueryParameter("notify");
                                            if (queryParameter == null) {
                                            }
                                            getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                                            return uriWithAppendedId;
                                        }
                                    }
                                }
                            } else {
                                cursorRawQuery2 = databaseHelper.getWritableDatabase().rawQuery("SELECT MAX(screenRank) FROM workspaceScreens", null);
                                if (cursorRawQuery2 == null) {
                                    i6 = -1;
                                } else {
                                    i6 = -1;
                                }
                                if (cursorRawQuery2 != null) {
                                    cursorRawQuery2.close();
                                }
                                contentValues2 = new ContentValues();
                                contentValues2.put("_id", asLong);
                                contentValues2.put("screenRank", Integer.valueOf(i6 + 1));
                                if (m7763b(databaseHelper, databaseHelper.getWritableDatabase(), "workspaceScreens", contentValues2) >= 0) {
                                    SQLiteDatabase writableDatabase6 = this.f15839k.getWritableDatabase();
                                    contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                                    jM7763b = m7763b(this.f15839k, writableDatabase6, str, contentValues);
                                    if (jM7763b >= 0) {
                                        uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                                        notifyListeners();
                                        if (Utilities.f16748i) {
                                            reloadLauncherIfExternal();
                                            return uriWithAppendedId;
                                        }
                                        launcherAppState = LauncherAppState.f16217j;
                                        if (launcherAppState != null) {
                                            launcherModel = launcherAppState.f16218a;
                                            launcherModel.m7579w(false);
                                            callback = launcherModel.getCallback();
                                            if (callback != null) {
                                                launcherModel.startLoader(-1001, 0);
                                            }
                                        }
                                        queryParameter = uriWithAppendedId.getQueryParameter("notify");
                                        if (queryParameter == null) {
                                        }
                                        getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                                        return uriWithAppendedId;
                                    }
                                }
                            }
                        }
                    } catch (RuntimeException unused) {
                    }
                }
            }
        } else {
            SQLiteDatabase writableDatabase7 = this.f15839k.getWritableDatabase();
            contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
            jM7763b = m7763b(this.f15839k, writableDatabase7, str, contentValues);
            if (jM7763b >= 0) {
                uriWithAppendedId = ContentUris.withAppendedId(uri, jM7763b);
                notifyListeners();
                if (Utilities.f16748i) {
                    reloadLauncherIfExternal();
                    return uriWithAppendedId;
                }
                launcherAppState = LauncherAppState.f16217j;
                if (launcherAppState != null) {
                    launcherModel = launcherAppState.f16218a;
                    launcherModel.m7579w(false);
                    callback = launcherModel.getCallback();
                    if (callback != null) {
                        launcherModel.startLoader(-1001, 0);
                    }
                }
                queryParameter = uriWithAppendedId.getQueryParameter("notify");
                if (queryParameter == null) {
                }
                getContext().getContentResolver().notifyChange(uriWithAppendedId, null);
                return uriWithAppendedId;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        Context applicationContext = context.getApplicationContext();
        Context context2 = LauncherAppState.f16216i;
        if (context2 != null) {
            Objects.toString(context2);
            Objects.toString(applicationContext);
        }
        LauncherAppState.f16216i = applicationContext.getApplicationContext();
        LauncherAppState.f16215h = new WeakReference(this);
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        this.f15839k = new DatabaseHelper(context);
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        String str3;
        if (uri.getPathSegments().size() == 1) {
            str3 = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(SyntheticHelpers.m7910i(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException(SyntheticHelpers.m7910i(uri, "WHERE clause not supported: "));
            }
            str3 = uri.getPathSegments().get(0);
            str = "_id=" + ContentUris.parseId(uri);
            strArr2 = null;
        }
        String str4 = str;
        String[] strArr3 = strArr2;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables(str3);
        Cursor cursorQuery = sQLiteQueryBuilder.query(this.f15839k.getWritableDatabase(), strArr, str4, strArr3, null, null, str2);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        return cursorQuery;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        String str2;
        if (uri.getPathSegments().size() == 1) {
            str2 = uri.getPathSegments().get(0);
        } else {
            if (uri.getPathSegments().size() != 2) {
                throw new IllegalArgumentException(SyntheticHelpers.m7910i(uri, "Invalid URI: "));
            }
            if (!TextUtils.isEmpty(str)) {
                throw new UnsupportedOperationException(SyntheticHelpers.m7910i(uri, "WHERE clause not supported: "));
            }
            String str3 = uri.getPathSegments().get(0);
            strArr = null;
            str = "_id=" + ContentUris.parseId(uri);
            str2 = str3;
        }
        contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
        int iUpdate = this.f15839k.getWritableDatabase().update(str2, contentValues, str, strArr);
        if (iUpdate > 0) {
            notifyListeners();
        }
        reloadLauncherIfExternal();
        return iUpdate;
    }
}
