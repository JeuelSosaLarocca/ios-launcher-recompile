package com.luutinhit.launcher6;

import android.os.Handler;

/* JADX INFO: renamed from: com.luutinhit.launcher6.a */
/* JADX INFO: loaded from: classes.dex */
public final class Alarm implements Runnable {

    /* JADX INFO: renamed from: j */
    public long f16203j;

    /* JADX INFO: renamed from: k */
    public boolean f16204k;

    /* JADX INFO: renamed from: m */
    public OnAlarmListener f16206m;

    /* JADX INFO: renamed from: n */
    public boolean f16207n = false;

    /* JADX INFO: renamed from: l */
    public Handler f16205l = new Handler();

    /* JADX INFO: renamed from: a */
    public final void cancelAlarm() {
        this.f16203j = 0L;
        this.f16207n = false;
    }

    /* JADX INFO: renamed from: b */
    public final void setAlarm(long j6) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f16207n = true;
        long j7 = j6 + jCurrentTimeMillis;
        this.f16203j = j7;
        if (this.f16204k) {
            return;
        }
        this.f16205l.postDelayed(this, j7 - jCurrentTimeMillis);
        this.f16204k = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f16204k = false;
        if (this.f16203j != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j6 = this.f16203j;
            if (j6 > jCurrentTimeMillis) {
                this.f16205l.postDelayed(this, Math.max(0L, j6 - jCurrentTimeMillis));
                this.f16204k = true;
                return;
            }
            this.f16207n = false;
            OnAlarmListener onAlarmListener = this.f16206m;
            if (onAlarmListener != null) {
                onAlarmListener.mo7775h(this);
            }
        }
    }
}
