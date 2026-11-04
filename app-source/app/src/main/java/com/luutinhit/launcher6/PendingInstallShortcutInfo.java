package com.luutinhit.launcher6;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.Base64;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONStringer;
import p122r3.AbstractC2662f;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.k1 */
/* JADX INFO: loaded from: classes.dex */
public final class PendingInstallShortcutInfo {

    /* JADX INFO: renamed from: a */
    public AbstractC2662f f16635a;

    /* JADX INFO: renamed from: b */
    public Intent f16636b;

    /* JADX INFO: renamed from: c */
    public Context f16637c;

    /* JADX INFO: renamed from: d */
    public Intent f16638d;

    /* JADX INFO: renamed from: e */
    public String f16639e;

    /* JADX INFO: renamed from: f */
    public C2673q f16640f;

    public PendingInstallShortcutInfo(Context context, Intent intent) {
        this.f16636b = intent;
        this.f16637c = context;
        this.f16638d = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        this.f16639e = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        this.f16640f = C2673q.m9672b();
        this.f16635a = null;
    }

    /* JADX INFO: renamed from: a */
    public final String encodeToString() {
        AbstractC2662f abstractC2662f = this.f16635a;
        Context context = this.f16637c;
        Intent intent = this.f16638d;
        if (abstractC2662f != null) {
            try {
                return new JSONStringer().object().key("intent.launch").value(intent.toUri(0)).key("isAppShortcut").value(true).key("userHandle").value(C2674r.m9673e(context).mo9676f(this.f16640f)).endObject().toString();
            } catch (JSONException e) {
                e.toString();
                return null;
            }
        }
        if (intent.getAction() == null) {
            intent.setAction("android.intent.action.VIEW");
        } else if (intent.getAction().equals("android.intent.action.MAIN") && intent.getCategories() != null && intent.getCategories().contains("android.intent.category.LAUNCHER")) {
            intent.addFlags(270532608);
        }
        Object obj = InstallShortcutReceiver.f15735a;
        CharSequence charSequenceLoadLabel = this.f16639e;
        if (charSequenceLoadLabel == null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                charSequenceLoadLabel = packageManager.getActivityInfo(intent.getComponent(), 0).loadLabel(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
                charSequenceLoadLabel = "";
            }
        }
        String string = charSequenceLoadLabel.toString();
        Intent intent2 = this.f16636b;
        Bitmap bitmap = (Bitmap) intent2.getParcelableExtra("android.intent.extra.shortcut.ICON");
        Intent.ShortcutIconResource shortcutIconResource = (Intent.ShortcutIconResource) intent2.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
        try {
            JSONStringer jSONStringerValue = new JSONStringer().object().key("intent.launch").value(intent.toUri(0)).key("name").value(string);
            if (bitmap != null) {
                byte[] bArrFlattenBitmap = Utilities.flattenBitmap(bitmap);
                jSONStringerValue = jSONStringerValue.key("icon").value(Base64.encodeToString(bArrFlattenBitmap, 0, bArrFlattenBitmap.length, 0));
            }
            if (shortcutIconResource != null) {
                jSONStringerValue = jSONStringerValue.key("iconResource").value(shortcutIconResource.resourceName).key("iconResourcePackage").value(shortcutIconResource.packageName);
            }
            return jSONStringerValue.endObject().toString();
        } catch (JSONException e5) {
            e5.toString();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0067  */
    /* JADX INFO: renamed from: b */
    public final ShortcutInfo m8110b() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Intent.ShortcutIconResource shortcutIconResource = null;
        Bitmap bitmapCreateIconBitmap;
        ShortcutInfo shortcutInfo;
        C2673q c2673qM9672b;
        Context context = this.f16637c;
        AbstractC2662f abstractC2662f = this.f16635a;
        if (abstractC2662f != null) {
            return ShortcutInfo.m8053f(abstractC2662f, context);
        }
        LauncherModel launcherModel = LauncherAppState.getInstance().f16218a;
        launcherModel.getClass();
        Objects.toString(context);
        Intent intent = this.f16636b;
        Objects.toString(intent);
        Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        String stringExtra = intent.getStringExtra("android.intent.extra.shortcut.NAME");
        Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
        Bitmap defaultIcon = null;
        Intent.ShortcutIconResource shortcutIconResource2 = null;
        if (intent2 == null) {
            return null;
        }
        if (!(parcelableExtra instanceof Bitmap)) {
            Parcelable parcelableExtra2 = intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE");
            if (parcelableExtra2 instanceof Intent.ShortcutIconResource) {
                shortcutIconResource2 = (Intent.ShortcutIconResource) parcelableExtra2;
                bitmapCreateIconBitmap = Utilities.createIconBitmap(context, shortcutIconResource2.packageName, shortcutIconResource2.resourceName);
            } else {
                shortcutIconResource = null;
            }
            shortcutInfo = new ShortcutInfo();
            c2673qM9672b = C2673q.m9672b();
            shortcutInfo.user = c2673qM9672b;
            if (defaultIcon == null) {
                defaultIcon = launcherModel.f15355w.getDefaultIcon(c2673qM9672b);
                shortcutInfo.f16555C = true;
            }
            shortcutInfo.f16558F = Utilities.m8164p(context, defaultIcon);
            String strTrim = Utilities.trim(stringExtra);
            shortcutInfo.title = strTrim;
            shortcutInfo.contentDescription = launcherModel.f15357y.mo9675b(strTrim, shortcutInfo.user);
            shortcutInfo.f16553A = intent2;
            shortcutInfo.f16554B = true;
            shortcutInfo.f16557E = shortcutIconResource;
            shortcutInfo.toString();
            Objects.toString(shortcutInfo.f16557E);
            return shortcutInfo;
        }
        bitmapCreateIconBitmap = Utilities.createIconBitmap(context, (Bitmap) parcelableExtra);
        Intent.ShortcutIconResource shortcutIconResource3 = shortcutIconResource2;
        defaultIcon = bitmapCreateIconBitmap;
        shortcutIconResource = shortcutIconResource3;
        shortcutInfo = new ShortcutInfo();
        c2673qM9672b = C2673q.m9672b();
        shortcutInfo.user = c2673qM9672b;
        if (defaultIcon == null) {
            defaultIcon = launcherModel.f15355w.getDefaultIcon(c2673qM9672b);
            shortcutInfo.f16555C = true;
        }
        shortcutInfo.f16558F = Utilities.m8164p(context, defaultIcon);
        String strTrim2 = Utilities.trim(stringExtra);
        shortcutInfo.title = strTrim2;
        shortcutInfo.contentDescription = launcherModel.f15357y.mo9675b(strTrim2, shortcutInfo.user);
        shortcutInfo.f16553A = intent2;
        shortcutInfo.f16554B = true;
        shortcutInfo.f16557E = shortcutIconResource;
        shortcutInfo.toString();
        Objects.toString(shortcutInfo.f16557E);
        return shortcutInfo;
    }

    public PendingInstallShortcutInfo(AbstractC2662f abstractC2662f, Context context) {
        this.f16636b = null;
        this.f16637c = context;
        this.f16635a = abstractC2662f;
        C2673q c2673qMo9656f = abstractC2662f.mo9656f();
        this.f16640f = c2673qMo9656f;
        this.f16638d = AppInfo.makeLaunchIntent(context, abstractC2662f, c2673qMo9656f);
        this.f16639e = abstractC2662f.mo9655e().toString();
    }
}
