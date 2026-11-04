package com.luutinhit.launcher6.appslibrary;

import android.content.Context;
import android.util.AttributeSet;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.Launcher;

/* JADX INFO: loaded from: classes.dex */
public class AppsLibraryBubbleTextView extends BubbleTextView {

    /* JADX INFO: renamed from: J */
    public Launcher f16253J;

    /* JADX INFO: renamed from: K */
    public AppsLibraryFolderExpandView f16254K;

    public AppsLibraryBubbleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        if (context instanceof Launcher) {
            this.f16253J = (Launcher) context;
        }
        this.f16254K = new AppsLibraryFolderExpandView(context);
    }
}
