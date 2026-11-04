package com.luutinhit.launcher6;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import java.util.Arrays;
import p122r3.AbstractC2662f;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.g3 */
/* JADX INFO: loaded from: classes.dex */
public final class ShortcutInfo extends ItemInfo {

    /* JADX INFO: renamed from: A */
    public Intent f16553A;

    /* JADX INFO: renamed from: B */
    public boolean f16554B;

    /* JADX INFO: renamed from: C */
    public boolean f16555C;

    /* JADX INFO: renamed from: D */
    public boolean f16556D;

    /* JADX INFO: renamed from: E */
    public Intent.ShortcutIconResource f16557E;

    /* JADX INFO: renamed from: F */
    public Bitmap f16558F;

    /* JADX INFO: renamed from: H */
    public int f16560H;

    /* JADX INFO: renamed from: I */
    public int f16561I;

    /* JADX INFO: renamed from: K */
    public Intent f16563K;

    /* JADX INFO: renamed from: G */
    public int f16559G = 0;

    /* JADX INFO: renamed from: J */
    public int f16562J = 0;

    public ShortcutInfo() {
        this.itemType = 1;
    }

    /* JADX INFO: renamed from: f */
    public static ShortcutInfo m8053f(AbstractC2662f abstractC2662f, Context context) {
        ShortcutInfo shortcutInfo = new ShortcutInfo();
        shortcutInfo.user = abstractC2662f.mo9656f();
        shortcutInfo.title = Utilities.trim(abstractC2662f.mo9655e());
        shortcutInfo.contentDescription = C2674r.m9673e(context).mo9675b(abstractC2662f.mo9655e(), abstractC2662f.mo9656f());
        shortcutInfo.f16554B = false;
        shortcutInfo.f16553A = AppInfo.makeLaunchIntent(context, abstractC2662f, abstractC2662f.mo9656f());
        shortcutInfo.itemType = 0;
        shortcutInfo.f16562J = AppInfo.m7982g(abstractC2662f);
        return shortcutInfo;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: b */
    public final Intent mo7984b() {
        return this.f16553A;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: c */
    public final boolean mo7985c() {
        return this.f16559G != 0;
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    /* JADX INFO: renamed from: d */
    public final void mo7672d(Context context, ContentValues contentValues) {
        Bitmap bitmap;
        super.mo7672d(context, contentValues);
        CharSequence charSequence = this.title;
        String uri = null;
        contentValues.put("title", charSequence != null ? charSequence.toString() : null);
        Intent intent = this.f16563K;
        if (intent != null) {
            uri = intent.toUri(0);
        } else {
            Intent intent2 = this.f16553A;
            if (intent2 != null) {
                uri = intent2.toUri(0);
            }
        }
        contentValues.put("intent", uri);
        contentValues.put("restored", Integer.valueOf(this.f16560H));
        if (this.f16554B) {
            contentValues.put("iconType", (Integer) 1);
            Bitmap bitmap2 = this.f16558F;
            if (bitmap2 != null) {
                contentValues.put("icon", Utilities.flattenBitmap(bitmap2));
                return;
            }
            return;
        }
        if (!this.f16555C && (bitmap = this.f16558F) != null) {
            contentValues.put("icon", Utilities.flattenBitmap(bitmap));
        }
        if (this.f16557E != null) {
            contentValues.put("iconType", (Integer) 0);
            contentValues.put("iconPackage", this.f16557E.packageName);
            contentValues.put("iconResource", this.f16557E.resourceName);
        }
    }

    /* JADX INFO: renamed from: g */
    public final ComponentName getTargetComponent() {
        Intent intent = this.f16563K;
        return intent != null ? intent.getComponent() : this.f16553A.getComponent();
    }

    /* JADX INFO: renamed from: h */
    public final boolean hasStatusFlag(int i6) {
        return (i6 & this.f16560H) != 0;
    }

    /* JADX INFO: renamed from: i */
    public final void m8056i(IconCache iconCache) {
        boolean z5 = this.f16556D && this.container >= 0 && this.f16791t >= 9;
        if (this.itemType == 0) {
            Intent intent = this.f16563K;
            if (intent == null) {
                intent = this.f16553A;
            }
            iconCache.m8020v(this, intent, this.user, z5);
        }
    }

    @Override // com.luutinhit.launcher6.ItemInfo
    public final String toString() {
        return "ShortcutInfo(title=" + ((Object) this.title) + "intent=" + this.f16553A + "id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + Arrays.toString((int[]) null) + " user=" + this.user + ")";
    }
}
