package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.luutinhit.launcherios.R;
import p006H.AbstractC0401n;

/* JADX INFO: renamed from: com.luutinhit.launcher6.o2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherClings implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public Launcher f16798j;

    /* JADX INFO: renamed from: k */
    public LayoutInflater f16799k;

    /* JADX INFO: renamed from: l */
    public boolean f16800l;

    public LauncherClings(Launcher launcher) {
        this.f16798j = launcher;
        this.f16799k = LayoutInflater.from(launcher);
    }

    /* JADX INFO: renamed from: a */
    public final void m8179a(View view, MergedUiRunnable mergedUiRunnable, String str) {
        if (view == null || view.getVisibility() == 8) {
            return;
        }
        view.animate().withLayer().alpha(0.0f).setDuration(200).withEndAction(new RunnableC0031a(this, view, str, mergedUiRunnable, 10, false));
    }

    /* JADX INFO: renamed from: b */
    public final void showLongPressCling(boolean z5) {
        this.f16800l = true;
        Launcher launcher = this.f16798j;
        ViewGroup viewGroup = (ViewGroup) launcher.findViewById(R.id.launcher);
        LayoutInflater layoutInflater = this.f16799k;
        View viewInflate = layoutInflater.inflate(R.layout.longpress_cling, viewGroup, false);
        viewInflate.setOnLongClickListener(new ClingLongClickListener(this));
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.cling_content);
        layoutInflater.inflate(z5 ? R.layout.longpress_cling_welcome_content : R.layout.longpress_cling_content, viewGroup2);
        viewGroup2.findViewById(R.id.cling_dismiss_longpress_info).setOnClickListener(this);
        if ("crop_bg_top_and_sides".equals(viewGroup2.getTag())) {
            Resources resources = launcher.getResources();
            Resources.Theme theme = launcher.getTheme();
            ThreadLocal threadLocal = AbstractC0401n.f1268a;
            viewGroup2.setBackground(new PaddedDrawable(resources.getDrawable(R.drawable.cling_background, theme)));
        }
        viewGroup.addView(viewInflate);
        if (z5) {
            return;
        }
        viewGroup2.getViewTreeObserver().addOnGlobalLayoutListener(new ClingGlobalLayoutListener(0, viewGroup2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i6 = 1;
        int i7 = 0;
        Launcher launcher = this.f16798j;
        int id = view.getId();
        if (id == R.id.cling_dismiss_migration_use_default) {
            launcher.showWorkspaceSearchAndHotseat();
            launcher.getWorkspace().post(new ClingDismissRunnable(this, i7));
            return;
        }
        if (id != R.id.cling_dismiss_migration_copy_apps) {
            if (id == R.id.cling_dismiss_longpress_info) {
                launcher.getWorkspace().post(new ClingDismissRunnable(this, i6));
                return;
            }
            return;
        }
        LauncherModel model = launcher.getModel();
        model.m7579w(false);
        model.startLoader(-1001, 3);
        Rect rect = Utilities.sOldBounds;
        SharedPreferences.Editor editorEdit = launcher.getSharedPreferences("com.luutinhit.launcher6.prefs", 0).edit();
        editorEdit.putBoolean(Launcher.USER_HAS_MIGRATED, true);
        editorEdit.apply();
        launcher.showWorkspaceSearchAndHotseat();
        launcher.getWorkspace().post(new ClingDismissRunnable(this, i7));
    }
}
