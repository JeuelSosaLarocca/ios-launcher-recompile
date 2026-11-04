package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.h2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherAppWidgetInfo extends ItemInfo {

    /* JADX INFO: renamed from: A */
    public int f16568A;

    /* JADX INFO: renamed from: B */
    public ComponentName providerName;

    /* JADX INFO: renamed from: C */
    public int f16570C;

    /* JADX INFO: renamed from: E */
    public boolean f16572E;

    /* JADX INFO: renamed from: D */
    public int f16571D = -1;

    /* JADX INFO: renamed from: F */
    public AppWidgetHostView f16573F = null;

    public LauncherAppWidgetInfo(int i6, ComponentName componentName) {
        this.f16568A = -1;
        if (i6 == -100) {
            this.itemType = 5;
        } else {
            this.itemType = 4;
        }
        this.f16568A = i6;
        this.providerName = componentName;
        this.spanX = -1;
        this.spanY = -1;
        this.user = C2673q.m9672b();
        this.f16570C = 0;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: d */
    public final void mo7672d(Context context, ContentValues contentValues) {
        super.mo7672d(context, contentValues);
        contentValues.put("appWidgetId", Integer.valueOf(this.f16568A));
        contentValues.put("appWidgetProvider", this.providerName.flattenToString());
        contentValues.put("restored", Integer.valueOf(this.f16570C));
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: e */
    public final void mo7673e() {
        this.f16573F = null;
    }

    /* JADX INFO: renamed from: f */
    public final boolean hasRestoreFlag(int i6) {
        return (this.f16570C & i6) == i6;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    public final String toString() {
        return "AppWidget(id=" + Integer.toString(this.f16568A) + ")";
    }
}
