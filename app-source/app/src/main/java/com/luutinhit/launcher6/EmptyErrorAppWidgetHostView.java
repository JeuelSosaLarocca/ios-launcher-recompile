package com.luutinhit.launcher6;

import android.view.View;

/* JADX INFO: renamed from: com.luutinhit.launcher6.b2 */
/* JADX INFO: loaded from: classes.dex */
public final class EmptyErrorAppWidgetHostView extends LauncherAppWidgetHostView {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public EmptyErrorAppWidgetHostView(android.content.Context p0) {
        super(p0);
    }
    @Override // com.luutinhit.launcher6.LauncherAppWidgetHostView, android.appwidget.AppWidgetHostView
    public final View getErrorView() {
        return new View(getContext());
    }
}
