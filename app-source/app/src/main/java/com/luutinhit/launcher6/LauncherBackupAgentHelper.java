package com.luutinhit.launcher6;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;
import java.util.HashSet;
import p115p3.C2584b;
import p154y3.C3030e;

/* JADX INFO: loaded from: classes.dex */
public class LauncherBackupAgentHelper extends BackupAgentHelper {


    /* JADX INFO: renamed from: a */
    public LauncherBackupHelper f15836a;

    /* JADX INFO: renamed from: a */
    public static void dataChanged(Context context) {
        SharedPreferences sharedPreferencesM8165q = Utilities.m8165q(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j6 = sharedPreferencesM8165q.getLong("backup_manager_last_notified", 0L);
        if (jCurrentTimeMillis < j6 || jCurrentTimeMillis >= j6) {
            BackupManager.dataChanged(context.getPackageName());
            sharedPreferencesM8165q.edit().putLong("backup_manager_last_notified", jCurrentTimeMillis).apply();
        }
    }

    @Override // android.app.backup.BackupAgent
    public final void onCreate() {
        super.onCreate();
        LauncherBackupHelper launcherBackupHelper = new LauncherBackupHelper(this);
        this.f15836a = launcherBackupHelper;
        addHelper("L", launcherBackupHelper);
    }

    @Override // android.app.backup.BackupAgentHelper, android.app.backup.BackupAgent
    public final void onRestore(BackupDataInput backupDataInput, int i6, ParcelFileDescriptor parcelFileDescriptor){
        boolean zMoveToNext;
        if (Utilities.f16752m) {
            LauncherAppState.getLauncherProvider().createEmptyDB();
            try {
                super.onRestore(backupDataInput, i6, parcelFileDescriptor);
                Cursor cursorQuery = getContentResolver().query(Favorites.f15684a, null, null, null, null);
                zMoveToNext = cursorQuery.moveToNext();
                cursorQuery.close();
            } catch (Exception unused) {
                zMoveToNext = false;
            }
            if (!zMoveToNext || !this.f15836a.f16607o) {
                LauncherAppState.getLauncherProvider().createEmptyDB();
                return;
            }
            Utilities.m8165q(LauncherAppState.getLauncherProvider().getContext()).edit().remove("EMPTY_DATABASE_CREATED").apply();
            Utilities.m8165q(this).edit().putBoolean("cling_gel.workspace.dismissed", true).apply();
            if (this.f15836a.f16608p <= 3) {
                DatabaseHelper.m7615B(LauncherAppState.getLauncherProvider().f15839k.getWritableDatabase(), false);
            }
            if (C3030e.f21954q) {
                if (this.f15836a.f16605m != null) {
                    Context applicationContext = getApplicationContext();
                    LauncherBackupHelper launcherBackupHelper = this.f15836a;
                    HashSet hashSet = launcherBackupHelper.f16606n;
                    C2584b c2584b = launcherBackupHelper.f16605m;
                    Utilities.m8165q(applicationContext).edit().putString("migration_src_workspace_size", C3030e.m10264e((int) c2584b.f20428c, (int) c2584b.f20427b)).putString("migration_src_hotseat_size", C3030e.m10264e((int) c2584b.f20429d, c2584b.f20430e)).putStringSet("migration_widget_min_size", hashSet).apply();
                }
            }
            DatabaseHelper databaseHelper = LauncherAppState.getLauncherProvider().f15839k;
            databaseHelper.m7621o(databaseHelper.getWritableDatabase());
        }
    }
}
