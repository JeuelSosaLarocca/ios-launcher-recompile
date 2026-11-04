package com.luutinhit.launcher6;

import B3.AbstractC0048P;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.c1 */
/* JADX INFO: loaded from: classes.dex */
public final class IconDB extends AbstractC0048P {


    /* JADX INFO: renamed from: d */
    public /* synthetic */ int f16333d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IconDB(Context context, String str, int i6, String str2, int i7) {
        super(context, str, i6, str2);
        this.f16333d = i7;
    }

    /** Not implemented in the original bytecode either (R8 removed it); calling it there threw AbstractMethodError. */
    @Override // B3.AbstractC0048P
    public int mo116d(int i6) {
        throw new AbstractMethodError();
    }

    @Override // B3.AbstractC0048P
    /* JADX INFO: renamed from: g */
    public final void mo119g(SQLiteDatabase sQLiteDatabase) {
        switch (this.f16333d) {
            case 0:
                Objects.toString(sQLiteDatabase);
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS icons (_id INTEGER PRIMARY KEY AUTOINCREMENT, componentName TEXT NOT NULL, profileId INTEGER NOT NULL, lastUpdated INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, icon BLOB, icon_low_res BLOB, label TEXT, system_state TEXT, history INTEGER NOT NULL DEFAULT 0,customIcon INTEGER NOT NULL DEFAULT 0,iconName TEXT, data1 INTEGER NOT NULL DEFAULT 0,data2 INTEGER NOT NULL DEFAULT 0,data3 INTEGER NOT NULL DEFAULT 0,data4 TEXT, data5 TEXT, data6 TEXT, UNIQUE (_id, componentName, profileId) );");
                break;
            default:
                Objects.toString(sQLiteDatabase);
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS shortcut_and_widget_previews (componentName TEXT NOT NULL, profileId INTEGER NOT NULL, size TEXT NOT NULL, packageName TEXT NOT NULL, lastUpdated INTEGER NOT NULL DEFAULT 0, version INTEGER NOT NULL DEFAULT 0, preview_bitmap BLOB, PRIMARY KEY (componentName, profileId, size) );");
                break;
        }
    }
}
