package com.luutinhit.launcher6;

import android.net.Uri;
import android.provider.BaseColumns;

/* JADX INFO: renamed from: com.luutinhit.launcher6.G2 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Favorites implements BaseColumns {

    /* JADX INFO: renamed from: a */
    public static final Uri f15684a = Uri.parse("content://com.luutinhit.launcherios.settings/favorites");

    /* JADX INFO: renamed from: a */
    public static Uri getContentUri(long j6) {
        return Uri.parse("content://com.luutinhit.launcherios.settings/favorites/" + j6);
    }
}
