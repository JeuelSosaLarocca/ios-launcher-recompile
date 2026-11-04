package com.luutinhit.launcher6.ioslauncher;

/* JADX INFO: renamed from: com.luutinhit.launcher6.ioslauncher.a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class IOSLauncherTask implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16580j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ IOSLauncher f16581k;

    public /* synthetic */ IOSLauncherTask(IOSLauncher iOSLauncher, int i6) {
        this.f16580j = i6;
        this.f16581k = iOSLauncher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16580j) {
            case 0:
                this.f16581k.lambda$startPlayOpenAnimation$7();
                break;
            default:
                this.f16581k.lambda$resumeNormalHomeState$6();
                break;
        }
    }
}
