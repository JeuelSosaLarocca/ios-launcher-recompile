package com.luutinhit.launcher6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public class StartupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            context.sendStickyBroadcast(new Intent("com.luutinhit.launcher6.SYSTEM_READY"));
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
