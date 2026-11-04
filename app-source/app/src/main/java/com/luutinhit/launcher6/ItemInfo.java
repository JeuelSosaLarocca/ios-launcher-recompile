package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.o1 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ItemInfo {

    /* JADX INFO: renamed from: k */
    public int itemType;

    /* JADX INFO: renamed from: u */
    public int f16792u;

    /* JADX INFO: renamed from: x */
    public CharSequence title;

    /* JADX INFO: renamed from: y */
    public CharSequence contentDescription;

    /* JADX INFO: renamed from: j */
    public long id = -1;

    /* JADX INFO: renamed from: l */
    public long container = -1;

    /* JADX INFO: renamed from: m */
    public long screenId = -1;

    /* JADX INFO: renamed from: n */
    public int cellX = -1;

    /* JADX INFO: renamed from: o */
    public int cellY = -1;

    /* JADX INFO: renamed from: p */
    public int spanX = 1;

    /* JADX INFO: renamed from: q */
    public int spanY = 1;

    /* JADX INFO: renamed from: r */
    public int minSpanX = 1;

    /* JADX INFO: renamed from: s */
    public int minSpanY = 1;

    /* JADX INFO: renamed from: t */
    public int f16791t = 0;

    /* JADX INFO: renamed from: v */
    public int f16793v = 0;

    /* JADX INFO: renamed from: w */
    public boolean requiresDbUpdate = false;

    /* JADX INFO: renamed from: z */
    public C2673q user = C2673q.m9672b();

    /* JADX INFO: renamed from: a */
    public final void copyFrom(ItemInfo itemInfo) {
        this.id = itemInfo.id;
        this.cellX = itemInfo.cellX;
        this.cellY = itemInfo.cellY;
        this.spanX = itemInfo.spanX;
        this.spanY = itemInfo.spanY;
        this.f16791t = itemInfo.f16791t;
        this.screenId = itemInfo.screenId;
        this.itemType = itemInfo.itemType;
        this.container = itemInfo.container;
        this.user = itemInfo.user;
        this.contentDescription = itemInfo.contentDescription;
    }

    /* JADX INFO: renamed from: b */
    public Intent mo7984b() {
        throw new RuntimeException("Unexpected Intent");
    }

    /* JADX INFO: renamed from: c */
    public boolean mo7985c() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public void mo7672d(Context context, ContentValues contentValues) {
        contentValues.put("itemType", Integer.valueOf(this.itemType));
        contentValues.put("container", Long.valueOf(this.container));
        contentValues.put("screen", Long.valueOf(this.screenId));
        contentValues.put("cellX", Integer.valueOf(this.cellX));
        contentValues.put("cellY", Integer.valueOf(this.cellY));
        contentValues.put("spanX", Integer.valueOf(this.spanX));
        contentValues.put("spanY", Integer.valueOf(this.spanY));
        contentValues.put("rank", Integer.valueOf(this.f16791t));
        contentValues.put("profileId", Long.valueOf(C2674r.m9673e(context).mo9676f(this.user)));
        if (this.screenId == -201) {
            throw new RuntimeException("Screen id should not be EXTRA_EMPTY_SCREEN_ID");
        }
    }

    /* JADX INFO: renamed from: e */
    public void mo7673e() {
    }

    public String toString() {
        return "Item(id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + Arrays.toString((int[]) null) + " user=" + this.user + ")";
    }
}
