package com.luutinhit.launcher6;

import B3.C0083z;
import android.appwidget.AppWidgetHost;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.google.android.gms.internal.ads.C3534g7;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.C2 */
/* JADX INFO: loaded from: classes.dex */
public final class DatabaseHelper extends SQLiteOpenHelper implements LayoutParserCallback {

    /* JADX INFO: renamed from: j */
    public Context f15439j;

    /* JADX INFO: renamed from: k */
    public AppWidgetHost f15440k;

    /* JADX INFO: renamed from: l */
    public long f15441l;

    /* JADX INFO: renamed from: m */
    public long f15442m;

    /* JADX INFO: renamed from: n */
    public Launcher f15443n;

    public DatabaseHelper(Context context) {
        super(context, "launcher.db", (SQLiteDatabase.CursorFactory) null, 26);
        this.f15441l = -1L;
        this.f15442m = -1L;
        this.f15439j = context;
        this.f15440k = new AppWidgetHost(context, 1024);
        if (!m7619A("favorites") || !m7619A("workspaceScreens")) {
            m7620c(getWritableDatabase(), true);
            m7618h(getWritableDatabase(), true);
            addAppTypeTable(getWritableDatabase());
        }
        if (this.f15441l == -1) {
            this.f15441l = LauncherProvider.m7764e(getWritableDatabase(), "favorites");
        }
        if (this.f15442m == -1) {
            this.f15442m = LauncherProvider.m7764e(getWritableDatabase(), "workspaceScreens");
        }
    }

    /* JADX INFO: renamed from: B */
    public static boolean m7615B(SQLiteDatabase sQLiteDatabase, boolean z5) {
        sQLiteDatabase.beginTransaction();
        if (z5) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN rank INTEGER NOT NULL DEFAULT 0;");
            } catch (SQLException e) {
                e.getMessage();
                return false;
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT container, MAX(cellX) FROM favorites WHERE container IN (SELECT _id FROM favorites WHERE itemType = ?) GROUP BY container;", new String[]{Integer.toString(2)});
        while (cursorRawQuery.moveToNext()) {
            sQLiteDatabase.execSQL("UPDATE favorites SET rank=cellX+(cellY*?) WHERE container=? AND cellX IS NOT NULL AND cellY IS NOT NULL;", new Object[]{Long.valueOf(cursorRawQuery.getLong(1) + 1), Long.valueOf(cursorRawQuery.getLong(0))});
        }
        cursorRawQuery.close();
        sQLiteDatabase.setTransactionSuccessful();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void addAppTypeTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS appType (_id INTEGER PRIMARY KEY AUTOINCREMENT,appType TEXT,packageName TEXT,className TEXT,title TEXT,modified INTEGER NOT NULL DEFAULT 0,item_type INTEGER NOT NULL DEFAULT 0);");
    }

    /* JADX INFO: renamed from: e */
    public static boolean addIntegerColumn(SQLiteDatabase sQLiteDatabase, String str, long j6) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN " + str + " INTEGER NOT NULL DEFAULT " + j6 + ";");
            sQLiteDatabase.setTransactionSuccessful();
            return true;
        } catch (SQLException e) {
            e.getMessage();
            return false;
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m7618h(SQLiteDatabase sQLiteDatabase, boolean z5) {
        sQLiteDatabase.execSQL("CREATE TABLE " + (z5 ? " IF NOT EXISTS " : "") + "workspaceScreens (_id INTEGER PRIMARY KEY,screenRank INTEGER,modified INTEGER NOT NULL DEFAULT 0);");
    }

    /* JADX INFO: renamed from: A */
    public final boolean m7619A(String str) {
        boolean z5 = false;
        try {
            Cursor cursorQuery = getReadableDatabase().query(true, "sqlite_master", new String[]{"tbl_name"}, "tbl_name = ?", new String[]{str}, null, null, null, null, null);
            z5 = cursorQuery.getCount() > 0;
            cursorQuery.close();
            return z5;
        } catch (Throwable th) {
            th.getMessage();
            return z5;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m7620c(SQLiteDatabase sQLiteDatabase, boolean z5) {
        StringBuilder sbM7918q = SyntheticHelpers.m7918q("CREATE TABLE ", z5 ? " IF NOT EXISTS " : "", "favorites (_id INTEGER PRIMARY KEY,title TEXT,intent TEXT,container INTEGER,screen INTEGER,cellX INTEGER,cellY INTEGER,spanX INTEGER,spanY INTEGER,itemType INTEGER,appWidgetId INTEGER NOT NULL DEFAULT -1,isShortcut INTEGER,iconType INTEGER,iconPackage TEXT,iconResource TEXT,icon BLOB,uri TEXT,displayMode INTEGER,appWidgetProvider TEXT,modified INTEGER NOT NULL DEFAULT 0,restored INTEGER NOT NULL DEFAULT 0,profileId INTEGER DEFAULT ");
        sbM7918q.append(C2674r.m9673e(this.f15439j).mo9676f(C2673q.m9672b()));
        sbM7918q.append(",rank INTEGER NOT NULL DEFAULT 0,options INTEGER NOT NULL DEFAULT 0);");
        sQLiteDatabase.execSQL(sbM7918q.toString());
    }

    @Override // com.luutinhit.launcher6.LayoutParserCallback
    public final long generateNewItemId() {
        long j6 = this.f15441l;
        if (j6 < 0) {
            throw new RuntimeException("Error: max item id was not initialized");
        }
        long j7 = j6 + 1;
        this.f15441l = j7;
        return j7;
    }

    @Override // com.luutinhit.launcher6.LayoutParserCallback
    public final long insertAndCheck(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return LauncherProvider.m7763b(this, sQLiteDatabase, "favorites", contentValues);
    }

    /* JADX INFO: renamed from: o */
    public final void m7621o(SQLiteDatabase sQLiteDatabase) {
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        sQLiteDatabase.beginTransaction();
        Cursor cursor = null;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery = sQLiteDatabase.query("favorites", new String[]{"_id", "intent"}, "itemType=1 AND profileId=" + C2674r.m9673e(this.f15439j).mo9676f(C2673q.m9672b()), null, null, null, null);
            try {
                sQLiteStatementCompileStatement = sQLiteDatabase.compileStatement("UPDATE favorites SET itemType=0 WHERE _id=?");
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("intent");
                while (cursorQuery.moveToNext()) {
                    try {
                        if (Utilities.isLauncherAppTarget(Intent.parseUri(cursorQuery.getString(columnIndexOrThrow2), 0))) {
                            sQLiteStatementCompileStatement.bindLong(1, cursorQuery.getLong(columnIndexOrThrow));
                            sQLiteStatementCompileStatement.executeUpdateDelete();
                        }
                    } catch (URISyntaxException unused) {
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                cursorQuery.close();
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
            } catch (SQLException unused2) {
                sQLiteStatement2 = sQLiteStatementCompileStatement;
                cursor2 = cursorQuery;
                sQLiteDatabase.endTransaction();
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
            } catch (Throwable th) {
                sQLiteStatement = sQLiteStatementCompileStatement;
                cursor = cursorQuery;
                sQLiteDatabase.endTransaction();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        } catch (SQLException unused3) {
            sQLiteStatement2 = null;
        } catch (Throwable th2) {
            Throwable th = th2;
            sQLiteStatement = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f15441l = 1L;
        this.f15442m = 0L;
        m7620c(sQLiteDatabase, false);
        m7618h(sQLiteDatabase, false);
        addAppTypeTable(sQLiteDatabase);
        AppWidgetHost appWidgetHost = this.f15440k;
        if (appWidgetHost != null) {
            appWidgetHost.deleteHost();
            new MainThreadExecutor().execute(new MergedUiRunnable(10, this));
        }
        this.f15441l = LauncherProvider.m7764e(sQLiteDatabase, "favorites");
        Context context = this.f15439j;
        Utilities.m8165q(context).edit().putBoolean("EMPTY_DATABASE_CREATED", true).apply();
        C0083z.m203e(context, Collections.EMPTY_LIST);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i6, int i7) {
        createEmptyDB(sQLiteDatabase);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0072  */
    /* JADX WARN: Code duplicated, block: B:24:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x009b A[Catch: all -> 0x00b1, TryCatch #1 {all -> 0x00b1, blocks: (B:27:0x0095, B:29:0x009b, B:31:0x00a9), top: B:84:0x0095 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c6 A[Catch: all -> 0x00f7, SQLException -> 0x00fa, LOOP:1: B:36:0x00c4->B:37:0x00c6, LOOP_END, TryCatch #5 {SQLException -> 0x00fa, blocks: (B:25:0x007f, B:35:0x00b4, B:37:0x00c6, B:42:0x00fc, B:60:0x0164, B:61:0x0167), top: B:90:0x007f, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (addIntegerColumn(r19, "restored", 0) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x010a, code lost:
    
        if (addIntegerColumn(r19, "options", 0) == false) goto L78;
     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i6, int i7){
        Cursor cursorQuery;
        ArrayList arrayList;
        long jMax;
        int size;
        int i8 = 0;
        long j6;
        Long lValueOf;
        SharedPreferences sharedPreferences = null;
        Context context = this.f15439j;
        switch (i6) {
            case 12:
                this.f15442m = 0L;
                m7618h(sQLiteDatabase, false);
            case 13:
                sQLiteDatabase.beginTransaction();
                try {
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN appWidgetProvider TEXT;");
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                        sQLiteDatabase.beginTransaction();
                        try {
                            try {
                                sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                                sQLiteDatabase.execSQL("ALTER TABLE workspaceScreens ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                                sQLiteDatabase.setTransactionSuccessful();
                                sQLiteDatabase.endTransaction();
                            } catch (SQLException e) {
                                e.getMessage();
                                sQLiteDatabase.endTransaction();
                                createEmptyDB(sQLiteDatabase);
                                return;
                            }
                        } catch (Throwable th) {
                            sQLiteDatabase.endTransaction();
                            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                        }
                    } catch (SQLException e5) {
                        e5.getMessage();
                        sQLiteDatabase.endTransaction();
                        createEmptyDB(sQLiteDatabase);
                        return;
                    }
                } catch (Throwable th2) {
                    sQLiteDatabase.endTransaction();
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
                }
                break;
            case 14:
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                sQLiteDatabase.execSQL("ALTER TABLE workspaceScreens ADD COLUMN modified INTEGER NOT NULL DEFAULT 0;");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                break;
            case 15:
                break;
            case 16:
                Utilities.m8165q(context).edit().putBoolean("cling_gel.workspace.dismissed", true).apply();
            case 17:
            case 18:
                sQLiteDatabase.execSQL("DELETE FROM favorites WHERE screen NOT IN (SELECT _id FROM workspaceScreens) AND container = -100");
                sQLiteDatabase.execSQL("DELETE FROM favorites WHERE container <> -100 AND container <> -101 AND container NOT IN (SELECT _id FROM favorites WHERE itemType = 2)");
            case 19:
                if (addIntegerColumn(sQLiteDatabase, "profileId", C2674r.m9673e(context).mo9676f(C2673q.m9672b()))) {
                    if (m7615B(sQLiteDatabase, true)) {
                        sQLiteDatabase.beginTransaction();
                        try {
                            try {
                                cursorQuery = sQLiteDatabase.query("workspaceScreens", new String[]{"_id"}, null, null, null, null, "screenRank");
                                arrayList = new ArrayList();
                                jMax = 0;
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        j6 = cursorQuery.getLong(0);
                                        lValueOf = Long.valueOf(j6);
                                        if (!arrayList.contains(lValueOf)) {
                                            arrayList.add(lValueOf);
                                            jMax = Math.max(jMax, j6);
                                        }
                                    } catch (Throwable th3) {
                                        cursorQuery.close();
                                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
                                    }
                                }
                                cursorQuery.close();
                                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS workspaceScreens");
                                m7618h(sQLiteDatabase, false);
                                size = arrayList.size();
                                for (i8 = 0; i8 < size; i8++) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("_id", (Long) arrayList.get(i8));
                                    contentValues.put("screenRank", Integer.valueOf(i8));
                                    int i9 = LauncherProvider.f15837l;
                                    contentValues.put("modified", Long.valueOf(System.currentTimeMillis()));
                                    sQLiteDatabase.insertOrThrow("workspaceScreens", null, contentValues);
                                }
                                sQLiteDatabase.setTransactionSuccessful();
                                this.f15442m = jMax;
                                sQLiteDatabase.endTransaction();
                            } catch (SQLException e6) {
                                e6.getMessage();
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th4) {
                            sQLiteDatabase.endTransaction();
                            throw com.luutinhit.launcher6.JadxSupport.sneaky(th4);
                        }
                    }
                    break;
                }
                createEmptyDB(sQLiteDatabase);
                return;
            case 20:
                if (m7615B(sQLiteDatabase, true)) {
                    sQLiteDatabase.beginTransaction();
                    cursorQuery = sQLiteDatabase.query("workspaceScreens", new String[]{"_id"}, null, null, null, null, "screenRank");
                    arrayList = new ArrayList();
                    jMax = 0;
                    while (cursorQuery.moveToNext()) {
                        j6 = cursorQuery.getLong(0);
                        lValueOf = Long.valueOf(j6);
                        if (!arrayList.contains(lValueOf)) {
                            arrayList.add(lValueOf);
                            jMax = Math.max(jMax, j6);
                        }
                    }
                    cursorQuery.close();
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS workspaceScreens");
                    m7618h(sQLiteDatabase, false);
                    size = arrayList.size();
                    while (i8 < size) {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("_id", (Long) arrayList.get(i8));
                        contentValues2.put("screenRank", Integer.valueOf(i8));
                        int i10 = LauncherProvider.f15837l;
                        contentValues2.put("modified", Long.valueOf(System.currentTimeMillis()));
                        sQLiteDatabase.insertOrThrow("workspaceScreens", null, contentValues2);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    this.f15442m = jMax;
                    sQLiteDatabase.endTransaction();
                    break;
                }
                createEmptyDB(sQLiteDatabase);
                return;
            case C3534g7.zzm /* 21 */:
                sQLiteDatabase.beginTransaction();
                cursorQuery = sQLiteDatabase.query("workspaceScreens", new String[]{"_id"}, null, null, null, null, "screenRank");
                arrayList = new ArrayList();
                jMax = 0;
                while (cursorQuery.moveToNext()) {
                    j6 = cursorQuery.getLong(0);
                    lValueOf = Long.valueOf(j6);
                    if (!arrayList.contains(lValueOf)) {
                        arrayList.add(lValueOf);
                        jMax = Math.max(jMax, j6);
                    }
                }
                cursorQuery.close();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS workspaceScreens");
                m7618h(sQLiteDatabase, false);
                size = arrayList.size();
                while (i8 < size) {
                    ContentValues contentValues3 = new ContentValues();
                    contentValues3.put("_id", (Long) arrayList.get(i8));
                    contentValues3.put("screenRank", Integer.valueOf(i8));
                    int i11 = LauncherProvider.f15837l;
                    contentValues3.put("modified", Long.valueOf(System.currentTimeMillis()));
                    sQLiteDatabase.insertOrThrow("workspaceScreens", null, contentValues3);
                }
                sQLiteDatabase.setTransactionSuccessful();
                this.f15442m = jMax;
                sQLiteDatabase.endTransaction();
                break;
            case 22:
                break;
            case 23:
            case 24:
                C2674r c2674rM9673e = C2674r.m9673e(context);
                C2673q c2673qM9672b = C2673q.m9672b();
                for (C2673q c2673q : (Iterable<C2673q>) (Iterable) (c2674rM9673e.mo9679i())) {
                    if (!c2673qM9672b.equals(c2673q)) {
                        if (sharedPreferences == null) {
                            sharedPreferences = context.getSharedPreferences("com.luutinhit.launcher6.managedusers.prefs", 0);
                        }
                        String str = "user_folder_" + c2674rM9673e.mo9676f(c2673q);
                        if (!sharedPreferences.contains(str)) {
                            sharedPreferences.edit().putLong(str, -1L).apply();
                        }
                    }
                }
            case 25:
                m7621o(sQLiteDatabase);
                return;
            case 26:
                return;
            default:
                createEmptyDB(sQLiteDatabase);
                return;
        }
    }

    /* JADX INFO: renamed from: r */
    public final void createEmptyDB(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorites");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS workspaceScreens");
        onCreate(sQLiteDatabase);
    }

    /* JADX INFO: renamed from: y */
    public final long generateNewScreenId() {
        long j6 = this.f15442m;
        if (j6 < 0) {
            throw new RuntimeException("Error: max screen id was not initialized");
        }
        long j7 = j6 + 1;
        this.f15442m = j7;
        return j7;
    }

    /* JADX INFO: renamed from: z */
    public final int m7624z(SQLiteDatabase sQLiteDatabase, AutoInstallsLayout autoInstallsLayout) {
        int layout;
        ArrayList arrayList = new ArrayList();
        autoInstallsLayout.f16625m = sQLiteDatabase;
        try {
            layout = autoInstallsLayout.parseLayout(autoInstallsLayout.f16616d, arrayList);
        } catch (Exception unused) {
            layout = -1;
        }
        Collections.sort(arrayList);
        ContentValues contentValues = new ContentValues();
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            contentValues.clear();
            contentValues.put("_id", (Long) obj);
            contentValues.put("screenRank", Integer.valueOf(i6));
            if (LauncherProvider.m7763b(this, sQLiteDatabase, "workspaceScreens", contentValues) < 0) {
                throw new RuntimeException("Failed initialize screen tablefrom default layout");
            }
            i6++;
        }
        this.f15441l = LauncherProvider.m7764e(sQLiteDatabase, "favorites");
        this.f15442m = LauncherProvider.m7764e(sQLiteDatabase, "workspaceScreens");
        return layout;
    }
}
