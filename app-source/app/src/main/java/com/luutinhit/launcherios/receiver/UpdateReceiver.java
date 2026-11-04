package com.luutinhit.launcherios.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.ioslauncher.IOSLauncher;

/* JADX INFO: loaded from: classes.dex */
public class UpdateReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intent intent2;
        try {
            try {
                if (Utilities.m8172x() || Utilities.m8168t()) {
                    intent2 = new Intent(context, (Class<?>) IOSLauncher.class);
                    intent2.addFlags(268435456);
                } else {
                    intent2 = new Intent("android.intent.action.MAIN");
                    intent2.addCategory("android.intent.category.HOME");
                }
                context.startActivity(intent2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            Intent intent3 = new Intent(context, (Class<?>) IOSLauncher.class);
            intent3.addFlags(268435456);
            context.startActivity(intent3);
        }
    }
}
