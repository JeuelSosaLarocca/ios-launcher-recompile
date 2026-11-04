package com.luutinhit.launcher6;

import android.content.DialogInterface;
import android.os.HandlerThread;
import android.view.View;
import java.util.HashSet;
import java.util.Objects;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.H1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherDialogClickListener implements DialogInterface.OnClickListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15699j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Launcher f15700k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Object f15701l;

    public /* synthetic */ LauncherDialogClickListener(Launcher launcher, Object obj, int i6) {
        this.f15699j = i6;
        this.f15700k = launcher;
        this.f15701l = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i6) {
        Object obj = this.f15701l;
        Launcher launcher = this.f15700k;
        switch (this.f15699j) {
            case 0:
                C2673q c2673qM9672b = C2673q.m9672b();
                Workspace workspace = launcher.mWorkspace;
                workspace.getClass();
                Objects.toString(c2673qM9672b);
                HashSet hashSet = new HashSet(1);
                String str = (String) obj;
                hashSet.add(str);
                Launcher launcher2 = workspace.f23432V0;
                HandlerThread handlerThread = LauncherModel.sWorkerThread;
                Objects.toString(launcher2);
                Objects.toString(c2673qM9672b);
                Objects.toString(c2673qM9672b);
                LauncherModel.m7556f(launcher2, LauncherModel.filterItemInfos(LauncherModel.sBgItemsIdMap, new Partner(3, str, c2673qM9672b)));
                workspace.k1(hashSet, c2673qM9672b);
                break;
            default:
                launcher.startAppShortcutOrInfoActivity((View) obj);
                break;
        }
    }
}
