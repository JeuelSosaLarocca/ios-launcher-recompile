package com.luutinhit.launcher6;

import android.os.AsyncTask;
import androidx.emoji2.text.C1460n;
import p084i0.C2156f;
import p084i0.InterfaceC2154d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.F1 */
/* JADX INFO: loaded from: classes.dex */
public final class DeleteAppWidgetIdTask extends AsyncTask {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f15567a = 1;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ Object f15568b;

    /* JADX INFO: renamed from: c */
    public /* synthetic */ Object f15569c;

    public DeleteAppWidgetIdTask(C1460n c1460n, InterfaceC2154d interfaceC2154d) {
        this.f15569c = c1460n;
        this.f15568b = interfaceC2154d;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        switch (this.f15567a) {
            case 0:
                ((LauncherAppWidgetHost) this.f15568b).deleteAppWidgetId(((LauncherAppWidgetInfo) this.f15569c).f16568A);
                return null;
            default:
                try {
                    return ((C1460n) this.f15569c).m3131b();
                } catch (Exception unused) {
                    return null;
                }
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Object obj) {
        switch (this.f15567a) {
            case 1:
                ((InterfaceC2154d) this.f15568b).mo907a((C2156f) obj);
                break;
            default:
                super.onPostExecute(obj);
                break;
        }
    }

    public DeleteAppWidgetIdTask(LauncherAppWidgetHost launcherAppWidgetHost, LauncherAppWidgetInfo launcherAppWidgetInfo) {
        this.f15568b = launcherAppWidgetHost;
        this.f15569c = launcherAppWidgetInfo;
    }
}
