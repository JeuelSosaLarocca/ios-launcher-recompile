package com.luutinhit.launcher6;

import B3.AbstractC0075r;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import p122r3.AbstractC2662f;
import p122r3.AbstractC2666j;
import p122r3.C2663g;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: loaded from: classes.dex */
public class InstallShortcutReceiver extends BroadcastReceiver {


    /* JADX INFO: renamed from: a */
    public static final Object f15735a = new Object();

    /* JADX INFO: renamed from: b */
    public static boolean f15736b = false;

    /* JADX INFO: renamed from: a */
    public static PendingInstallShortcutInfo m7747a(Context context, Intent intent) {
        Parcelable parcelableExtra;
        PendingInstallShortcutInfo pendingInstallShortcutInfo;
        Intent intent2;
        ResolveInfo resolveInfoResolveActivity;
        Parcelable parcelableExtra2 = intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
        if (!(parcelableExtra2 == null || Intent.class.isInstance(parcelableExtra2)) || ((parcelableExtra = intent.getParcelableExtra("android.intent.extra.shortcut.ICON_RESOURCE")) != null && !Intent.ShortcutIconResource.class.isInstance(parcelableExtra))) {
            return null;
        }
        Parcelable parcelableExtra3 = intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
        if ((parcelableExtra3 == null || Bitmap.class.isInstance(parcelableExtra3)) && (intent2 = (pendingInstallShortcutInfo = new PendingInstallShortcutInfo(context, intent)).f16638d) != null && pendingInstallShortcutInfo.f16639e != null) {
            if (Utilities.isLauncherAppTarget(intent2)) {
                if (pendingInstallShortcutInfo.f16640f.equals(C2673q.m9672b()) && (resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent2, 0)) != null) {
                    return new PendingInstallShortcutInfo(new C2663g(context, resolveInfoResolveActivity), context);
                }
            }
            return pendingInstallShortcutInfo;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static PendingInstallShortcutInfo decode(Context context, String str) {
        AbstractC2662f abstractC2662fMo9663g;
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            Intent uri = Intent.parseUri(jSONObject.getString("intent.launch"), 0);
            if (jSONObject.optBoolean("isAppShortcut")) {
                C2673q c2673qMo9678h = C2674r.m9673e(context).mo9678h(jSONObject.getLong("userHandle"));
                if (c2673qMo9678h != null && (abstractC2662fMo9663g = AbstractC2666j.m9657c(context).mo9663g(uri, c2673qMo9678h)) != null) {
                    return new PendingInstallShortcutInfo(abstractC2662fMo9663g, context);
                }
                return null;
            }
            Intent intent = new Intent();
            intent.putExtra("android.intent.extra.shortcut.INTENT", uri);
            intent.putExtra("android.intent.extra.shortcut.NAME", jSONObject.getString("name"));
            String strOptString = jSONObject.optString("icon");
            String strOptString2 = jSONObject.optString("iconResource");
            String strOptString3 = jSONObject.optString("iconResourcePackage");
            if (strOptString != null && !strOptString.isEmpty()) {
                byte[] bArrDecode = Base64.decode(strOptString, 0);
                intent.putExtra("android.intent.extra.shortcut.ICON", BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            } else if (strOptString2 != null && !strOptString2.isEmpty()) {
                Intent.ShortcutIconResource shortcutIconResource = new Intent.ShortcutIconResource();
                shortcutIconResource.resourceName = strOptString2;
                shortcutIconResource.packageName = strOptString3;
                intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcutIconResource);
            }
            return new PendingInstallShortcutInfo(context, intent);
        } catch (URISyntaxException e) {
            e = e;
            e.toString();
            return null;
        } catch (JSONException e5) {
            Throwable e = e5;
            e.toString();
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void flushInstallQueue(Context context) {
        ArrayList<PendingInstallShortcutInfo> arrayList;
        SharedPreferences sharedPreferencesM8165q = Utilities.m8165q(context);
        synchronized (f15735a) {
            try {
                Set<String> stringSet = sharedPreferencesM8165q.getStringSet("apps_to_install", null);
                if (stringSet == null) {
                    arrayList = new ArrayList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<String> it = stringSet.iterator();
                    while (it.hasNext()) {
                        PendingInstallShortcutInfo pendingInstallShortcutInfoDecode = decode(context, it.next());
                        if (pendingInstallShortcutInfoDecode != null) {
                            arrayList2.add(pendingInstallShortcutInfoDecode);
                        }
                    }
                    sharedPreferencesM8165q.edit().putStringSet("apps_to_install", new HashSet()).apply();
                    arrayList = arrayList2;
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (PendingInstallShortcutInfo pendingInstallShortcutInfo : arrayList) {
            Intent intent = pendingInstallShortcutInfo.f16638d;
            String packageName = intent.getPackage();
            if (packageName == null) {
                packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
            }
            if (!TextUtils.isEmpty(packageName)) {
                C2673q c2673qM9672b = C2673q.m9672b();
                HandlerThread handlerThread = LauncherModel.sWorkerThread;
                Objects.toString(context);
                Objects.toString(c2673qM9672b);
                if (!(packageName == null ? false : AbstractC2666j.m9657c(context).mo9662f(packageName, c2673qM9672b))) {
                }
            }
            arrayList3.add(pendingInstallShortcutInfo.m8110b());
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        LauncherAppState.getInstance().f16218a.addAppsToAllApps(context, arrayList3);
    }

    /* JADX INFO: renamed from: d */
    public static void removeFromInstallQueue(Context context, HashSet hashSet, C2673q c2673q) {
        if (hashSet.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferencesM8165q = Utilities.m8165q(context);
        synchronized (f15735a) {
            try {
                Set<String> stringSet = sharedPreferencesM8165q.getStringSet("apps_to_install", null);
                if (stringSet != null) {
                    HashSet hashSet2 = new HashSet(stringSet);
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        PendingInstallShortcutInfo pendingInstallShortcutInfoDecode = decode(context, (String) it.next());
                        if (pendingInstallShortcutInfoDecode != null) {
                            Intent intent = pendingInstallShortcutInfoDecode.f16638d;
                            String packageName = intent.getPackage();
                            if (packageName == null) {
                                packageName = intent.getComponent() == null ? null : intent.getComponent().getPackageName();
                            }
                            if (!hashSet.contains(packageName) || !c2673q.equals(pendingInstallShortcutInfoDecode.f16640f)) {
                            }
                        }
                        it.remove();
                    }
                    sharedPreferencesM8165q.edit().putStringSet("apps_to_install", hashSet2).apply();
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PendingInstallShortcutInfo pendingInstallShortcutInfoM7747a;
        if ("com.android.launcher.action.INSTALL_SHORTCUT".equals(intent.getAction()) && (pendingInstallShortcutInfoM7747a = m7747a(context, intent)) != null) {
            if (!(pendingInstallShortcutInfoM7747a.f16635a != null) && !AbstractC0075r.m187h(context, pendingInstallShortcutInfoM7747a.f16638d, null)) {
                pendingInstallShortcutInfoM7747a.f16638d.toUri(0);
                return;
            }
            boolean z5 = LauncherAppState.getInstance().f16218a.getCallback() == null;
            SharedPreferences sharedPreferencesM8165q = Utilities.m8165q(context);
            synchronized (f15735a) {
                try {
                    String strEncodeToString = pendingInstallShortcutInfoM7747a.encodeToString();
                    if (strEncodeToString != null) {
                        Set<String> stringSet = sharedPreferencesM8165q.getStringSet("apps_to_install", null);
                        HashSet hashSet = stringSet == null ? new HashSet(1) : new HashSet(stringSet);
                        hashSet.add(strEncodeToString);
                        sharedPreferencesM8165q.edit().putStringSet("apps_to_install", hashSet).apply();
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
            if (f15736b || z5) {
                return;
            }
            flushInstallQueue(context);
        }
    }
}
