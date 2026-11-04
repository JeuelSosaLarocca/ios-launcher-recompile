package com.luutinhit.launcherios.activity;

import B3.RunnableC0064g;
import P3.AbstractActivityC0816d;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class SplashActivity extends AbstractActivityC0816d {

    /* JADX INFO: renamed from: D */
    public static final /* synthetic */ int f17405D = 0;

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0064g(8, this), 3000L);
    }
}
