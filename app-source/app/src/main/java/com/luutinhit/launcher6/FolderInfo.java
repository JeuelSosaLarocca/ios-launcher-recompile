package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.E0 */
/* JADX INFO: loaded from: classes.dex */
public final class FolderInfo extends ItemInfo {

    /* JADX INFO: renamed from: B */
    public boolean f15523B;

    /* JADX INFO: renamed from: A */
    public ArrayList contents = new ArrayList();

    /* JADX INFO: renamed from: C */
    public ArrayList f15524C = new ArrayList();

    public FolderInfo() {
        this.itemType = 2;
        this.user = C2673q.m9672b();
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: d */
    public final void mo7672d(Context context, ContentValues contentValues) {
        super.mo7672d(context, contentValues);
        contentValues.put("title", this.title.toString());
        contentValues.put("options", Integer.valueOf(this.f16792u));
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: e */
    public final void mo7673e() {
        this.f15524C.clear();
    }

    /* JADX INFO: renamed from: f */
    public final void add(ShortcutInfo shortcutInfo) {
        this.contents.add(shortcutInfo);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            ArrayList arrayList = this.f15524C;
            if (i7 >= arrayList.size()) {
                break;
            }
            ((FolderListener) arrayList.get(i7)).mo7661y(shortcutInfo);
            i7++;
        }
        while (true) {
            ArrayList arrayList2 = this.f15524C;
            if (i6 >= arrayList2.size()) {
                return;
            }
            ((FolderListener) arrayList2.get(i6)).mo7660v();
            i6++;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void remove(ShortcutInfo shortcutInfo) {
        this.contents.remove(shortcutInfo);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            ArrayList arrayList = this.f15524C;
            if (i7 >= arrayList.size()) {
                break;
            }
            ((FolderListener) arrayList.get(i7)).mo7658A(shortcutInfo);
            i7++;
        }
        while (true) {
            ArrayList arrayList2 = this.f15524C;
            if (i6 >= arrayList2.size()) {
                return;
            }
            ((FolderListener) arrayList2.get(i6)).mo7660v();
            i6++;
        }
    }

    /* JADX INFO: renamed from: h */
    public final void setOption(int i6, Context context, boolean z5) {
        int i7 = this.f16792u;
        if (z5) {
            this.f16792u = i6 | i7;
        } else {
            this.f16792u = (~i6) & i7;
        }
        if (context == null || i7 == this.f16792u) {
            return;
        }
        LauncherModel.updateItemInDatabase(context, this);
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    public final String toString() {
        return "FolderInfo(id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + Arrays.toString((int[]) null) + ")";
    }
}
