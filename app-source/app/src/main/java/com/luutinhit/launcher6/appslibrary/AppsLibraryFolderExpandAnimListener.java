package com.luutinhit.launcher6.appslibrary;

import B3.RunnableC0064g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luutinhit.launcher6.LauncherRootView;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.a */
/* JADX INFO: loaded from: classes.dex */
public final class AppsLibraryFolderExpandAnimListener extends AnimatorListenerAdapter {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16280j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ AppsLibraryFolderExpandView f16281k;

    public /* synthetic */ AppsLibraryFolderExpandAnimListener(AppsLibraryFolderExpandView appsLibraryFolderExpandView, int i6) {
        this.f16280j = i6;
        this.f16281k = appsLibraryFolderExpandView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f16280j) {
            case 0:
                this.f16281k.getClass();
                break;
            default:
                RunnableC0064g runnableC0064g = new RunnableC0064g(15, this);
                AppsLibraryFolderExpandView appsLibraryFolderExpandView = this.f16281k;
                appsLibraryFolderExpandView.post(runnableC0064g);
                LauncherRootView launcherRootView = (LauncherRootView) appsLibraryFolderExpandView.getParent();
                if (launcherRootView != null) {
                    launcherRootView.removeView(appsLibraryFolderExpandView);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f16280j) {
            case 0:
                this.f16281k.getClass();
                break;
            default:
                AppsLibraryFolderExpandView appsLibraryFolderExpandView = this.f16281k;
                appsLibraryFolderExpandView.getClass();
                appsLibraryFolderExpandView.f16282n.showAppsLibrary();
                break;
        }
    }
}
