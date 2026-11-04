package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: renamed from: com.luutinhit.launcher6.i */
/* JADX INFO: loaded from: classes.dex */
public interface LayoutParserCallback {
    long generateNewItemId();

    long insertAndCheck(SQLiteDatabase sQLiteDatabase, ContentValues contentValues);
}
