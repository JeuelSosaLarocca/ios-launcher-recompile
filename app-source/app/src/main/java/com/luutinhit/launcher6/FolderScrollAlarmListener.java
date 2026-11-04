package com.luutinhit.launcher6;

/* JADX INFO: renamed from: com.luutinhit.launcher6.w0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderScrollAlarmListener implements OnAlarmListener {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17021j;

    /* JADX INFO: renamed from: k */
    public DragObject f17022k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Folder f17023l;

    public /* synthetic */ FolderScrollAlarmListener(Folder folder, DragObject dragObject, int i6) {
        this.f17021j = i6;
        this.f17023l = folder;
        this.f17022k = dragObject;
    }

    @Override // com.luutinhit.launcher6.OnAlarmListener
    /* JADX INFO: renamed from: h */
    public final void mo7775h(Alarm alarm) {
        switch (this.f17021j) {
            case 0:
                this.f17023l.onDragOver(this.f17022k);
                break;
            default:
                Folder folder = this.f17023l;
                int i6 = folder.f23334d0;
                if (i6 == 0) {
                    folder.mContent.h0();
                    folder.f23333c0 = -1;
                } else if (i6 == 1) {
                    folder.mContent.i0();
                    folder.f23333c0 = -1;
                }
                folder.f23334d0 = -1;
                FolderScrollAlarmListener folderScrollAlarmListener = new FolderScrollAlarmListener(folder, this.f17022k, 0);
                Alarm alarm2 = folder.f15624m;
                alarm2.f16206m = folderScrollAlarmListener;
                alarm2.setAlarm(900L);
                break;
        }
    }
}
