package com.luutinhit.launcher6;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.t0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderEditTextKeyListener implements View.OnKeyListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ View f16877j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Folder f16878k;

    public FolderEditTextKeyListener(Folder folder, View view) {
        this.f16878k = folder;
        this.f16877j = view;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i6, KeyEvent keyEvent) {
        return i6 == 61 && keyEvent.hasModifiers(1) && this.f16878k.isFocused() && this.f16877j.requestFocus();
    }
}
