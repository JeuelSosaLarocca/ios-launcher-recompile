package com.luutinhit.launcher6;

import B1.RunnableC0031a;
import B3.AbstractC0074q;
import B3.AbstractC0075r;
import B3.C0050S;
import B3.C0051T;
import B3.C0072o;
import B3.C0073p;
import B3.C0081x;
import B3.C0083z;
import G1.C0328n;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import p122r3.AbstractC2662f;
import p122r3.AbstractC2666j;
import p122r3.C2673q;
import p122r3.C2674r;

/* JADX INFO: renamed from: com.luutinhit.launcher6.A2 */
/* JADX INFO: loaded from: classes.dex */
public final class PackageUpdatedTask implements Runnable {

    /* JADX INFO: renamed from: j */
    public int f15295j;

    /* JADX INFO: renamed from: k */
    public int f15296k;

    /* JADX INFO: renamed from: l */
    public int f15297l;

    /* JADX INFO: renamed from: m */
    public int f15298m;

    /* JADX INFO: renamed from: n */
    public String f15299n;

    /* JADX INFO: renamed from: o */
    public String f15300o;

    /* JADX INFO: renamed from: p */
    public String[] f15301p;

    /* JADX INFO: renamed from: q */
    public String f15302q;

    /* JADX INFO: renamed from: r */
    public C2673q f15303r;

    /* JADX INFO: renamed from: s */
    public /* synthetic */ LauncherModel f15304s;

    public PackageUpdatedTask(LauncherModel launcherModel, int i6, String[] strArr, C2673q c2673q) {
        this.f15304s = launcherModel;
        this.f15296k = i6;
        this.f15301p = strArr;
        this.f15303r = c2673q;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0429  */
    /* JADX WARN: Code duplicated, block: B:169:0x04a4 A[Catch: all -> 0x0426, TryCatch #0 {all -> 0x0426, blocks: (B:127:0x03dc, B:128:0x03e2, B:130:0x03e8, B:132:0x03f4, B:134:0x03fd, B:136:0x0407, B:138:0x040b, B:140:0x0413, B:142:0x041f, B:146:0x042a, B:148:0x0430, B:150:0x043a, B:152:0x0449, B:154:0x0450, B:156:0x0471, B:158:0x047b, B:163:0x048e, B:169:0x04a4, B:170:0x04a8, B:173:0x04c4, B:175:0x04d2, B:177:0x04d6, B:178:0x04eb, B:187:0x0508, B:185:0x0503, B:164:0x0491, B:193:0x051a, B:195:0x051e, B:197:0x0525, B:199:0x052f, B:201:0x0536, B:203:0x0542, B:205:0x0554), top: B:262:0x03dc }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0503 A[Catch: all -> 0x0426, TryCatch #0 {all -> 0x0426, blocks: (B:127:0x03dc, B:128:0x03e2, B:130:0x03e8, B:132:0x03f4, B:134:0x03fd, B:136:0x0407, B:138:0x040b, B:140:0x0413, B:142:0x041f, B:146:0x042a, B:148:0x0430, B:150:0x043a, B:152:0x0449, B:154:0x0450, B:156:0x0471, B:158:0x047b, B:163:0x048e, B:169:0x04a4, B:170:0x04a8, B:173:0x04c4, B:175:0x04d2, B:177:0x04d6, B:178:0x04eb, B:187:0x0508, B:185:0x0503, B:164:0x0491, B:193:0x051a, B:195:0x051e, B:197:0x0525, B:199:0x052f, B:201:0x0536, B:203:0x0542, B:205:0x0554), top: B:262:0x03dc }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0508 A[Catch: all -> 0x0426, TryCatch #0 {all -> 0x0426, blocks: (B:127:0x03dc, B:128:0x03e2, B:130:0x03e8, B:132:0x03f4, B:134:0x03fd, B:136:0x0407, B:138:0x040b, B:140:0x0413, B:142:0x041f, B:146:0x042a, B:148:0x0430, B:150:0x043a, B:152:0x0449, B:154:0x0450, B:156:0x0471, B:158:0x047b, B:163:0x048e, B:169:0x04a4, B:170:0x04a8, B:173:0x04c4, B:175:0x04d2, B:177:0x04d6, B:178:0x04eb, B:187:0x0508, B:185:0x0503, B:164:0x0491, B:193:0x051a, B:195:0x051e, B:197:0x0525, B:199:0x052f, B:201:0x0536, B:203:0x0542, B:205:0x0554), top: B:262:0x03dc }] */
    /* JADX WARN: Code duplicated, block: B:195:0x051e A[Catch: all -> 0x0426, TryCatch #0 {all -> 0x0426, blocks: (B:127:0x03dc, B:128:0x03e2, B:130:0x03e8, B:132:0x03f4, B:134:0x03fd, B:136:0x0407, B:138:0x040b, B:140:0x0413, B:142:0x041f, B:146:0x042a, B:148:0x0430, B:150:0x043a, B:152:0x0449, B:154:0x0450, B:156:0x0471, B:158:0x047b, B:163:0x048e, B:169:0x04a4, B:170:0x04a8, B:173:0x04c4, B:175:0x04d2, B:177:0x04d6, B:178:0x04eb, B:187:0x0508, B:185:0x0503, B:164:0x0491, B:193:0x051a, B:195:0x051e, B:197:0x0525, B:199:0x052f, B:201:0x0536, B:203:0x0542, B:205:0x0554), top: B:262:0x03dc }] */
    /* JADX WARN: Code duplicated, block: B:274:0x0494 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:276:0x0494 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x014b  */
    /* JADX WARN: Code duplicated, block: B:51:0x015f  */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0028. Please report as an issue. */
    @Override // java.lang.Runnable
    public final void run(){
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        C0072o c0072o;
        boolean z5;
        AbstractC0074q c0073p;
        int i6 = 0;
        C2673q c2673q;
        ArrayList arrayList;
        int size = 0;
        AppInfo appInfo;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C0081x c0081x;
        int i7 = 0;
        boolean z6;
        boolean z7;
        AppInfo appInfo2;
        LauncherModel launcherModel = this.f15304s;
        if (launcherModel.f15348p) {
            launcherModel.f15343k.getClass();
            Context context = LauncherAppState.f16216i;
            String[] strArr = this.f15301p;
            int length = strArr.length;
            C0072o c0072o2 = AbstractC0074q.f213a;
            AbstractC0075r c0051t = new C0051T(new HashSet(Arrays.asList(strArr)));
            int i8 = this.f15296k;
            switch (i8) {
                case 1:
                    for (int i9 = 0; i9 < length; i9++) {
                        this.f15304s.f15355w.m7999L(strArr[i9], this.f15303r);
                        C0328n c0328n = this.f15304s.f15353u;
                        String str = strArr[i9];
                        C2673q c2673q2 = this.f15303r;
                        c0328n.getClass();
                        Iterator it = AbstractC2666j.m9657c(context).mo9660b(str, c2673q2).iterator();
                        while (it.hasNext()) {
                            c0328n.m851a(new AppInfo(context, (AbstractC2662f) it.next(), c2673q2, (IconCache) c0328n.f1074o));
                        }
                    }
                    C0083z c0083zM202c = C0083z.m202c(context, this.f15303r);
                    if (c0083zM202c != null) {
                        String[] strArr2 = this.f15301p;
                        c0083zM202c.f235h = new ArrayList();
                        c0083zM202c.f236i = new ArrayList();
                        c0083zM202c.f237j = new HashMap();
                        HashSet hashSet = new HashSet();
                        Set<String> stringSet = ((SharedPreferences) c0083zM202c.f233f).getStringSet((String) c0083zM202c.f234g, null);
                        if (stringSet == null) {
                            z5 = false;
                        } else {
                            hashSet.addAll(stringSet);
                            z5 = true;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        AbstractC2666j abstractC2666jM9657c = AbstractC2666j.m9657c((Context) c0083zM202c.f230c);
                        int length2 = strArr2.length;
                        int i10 = 0;
                        boolean z8 = false;
                        while (i10 < length2) {
                            String str2 = strArr2[i10];
                            if (!hashSet.contains(str2)) {
                                hashSet.add(str2);
                                List listMo9660b = abstractC2666jM9657c.mo9660b(str2, (C2673q) c0083zM202c.f231d);
                                if (!listMo9660b.isEmpty()) {
                                    c0083zM202c.m206d((AbstractC2662f) listMo9660b.get(0), jCurrentTimeMillis);
                                }
                                z8 = true;
                            }
                            i10++;
                            c0072o2 = c0072o2;
                        }
                        c0072o = c0072o2;
                        if (z8) {
                            ((SharedPreferences) c0083zM202c.f233f).edit().putStringSet((String) c0083zM202c.f234g, hashSet).apply();
                            c0083zM202c.m204a(z5);
                        }
                    } else {
                        c0072o = c0072o2;
                    }
                    c0073p = c0072o;
                    break;
                case 2:
                    for (int i11 = 0; i11 < length; i11++) {
                        this.f15304s.f15355w.m7999L(strArr[i11], this.f15303r);
                        this.f15304s.f15353u.m860o(context, strArr[i11], this.f15303r);
                        WidgetPreviewLoader widgetPreviewLoader = this.f15304s.f15343k.f16220c;
                        String str3 = strArr[i11];
                        C2673q c2673q3 = this.f15303r;
                        widgetPreviewLoader.getClass();
                        Objects.toString(c2673q3);
                        widgetPreviewLoader.removePackage(str3, c2673q3, widgetPreviewLoader.f16865e.mo9676f(c2673q3));
                    }
                    c0073p = new C0073p(2, 1);
                    break;
                case 3:
                    C0083z c0083zM202c2 = C0083z.m202c(context, this.f15303r);
                    if (c0083zM202c2 != null) {
                        String[] strArr3 = this.f15301p;
                        HashSet hashSet2 = new HashSet();
                        Set<String> stringSet2 = ((SharedPreferences) c0083zM202c2.f233f).getStringSet((String) c0083zM202c2.f234g, null);
                        if (stringSet2 != null) {
                            hashSet2.addAll(stringSet2);
                        }
                        boolean z9 = false;
                        for (String str4 : strArr3) {
                            if (hashSet2.remove(str4)) {
                                z9 = true;
                            }
                        }
                        if (z9) {
                            ((SharedPreferences) c0083zM202c2.f233f).edit().putStringSet((String) c0083zM202c2.f234g, hashSet2).apply();
                        }
                    }
                    for (String str5 : strArr) {
                        this.f15304s.f15355w.removeIconsForPkg(str5, this.f15303r);
                    }
                    for (i6 = 0; i6 < length; i6++) {
                        C0328n c0328n2 = this.f15304s.f15353u;
                        String str6 = strArr[i6];
                        c2673q = this.f15303r;
                        arrayList = (ArrayList) c0328n2.f1070k;
                        for (size = arrayList.size() - 1; size >= 0; size--) {
                            appInfo = (AppInfo) arrayList.get(size);
                            ComponentName component = appInfo.f16326A.getComponent();
                            if (!appInfo.user.equals(c2673q) && str6.equals(component.getPackageName())) {
                                ((ArrayList) c0328n2.f1072m).add(appInfo);
                                arrayList.remove(size);
                            }
                        }
                        WidgetPreviewLoader widgetPreviewLoader2 = this.f15304s.f15343k.f16220c;
                        String str7 = strArr[i6];
                        C2673q c2673q4 = this.f15303r;
                        widgetPreviewLoader2.getClass();
                        Objects.toString(c2673q4);
                        widgetPreviewLoader2.removePackage(str7, c2673q4, widgetPreviewLoader2.f16865e.mo9676f(c2673q4));
                    }
                    c0073p = new C0073p(2, 0);
                    break;
                case 4:
                    while (i6 < length) {
                        C0328n c0328n3 = this.f15304s.f15353u;
                        String str8 = strArr[i6];
                        c2673q = this.f15303r;
                        arrayList = (ArrayList) c0328n3.f1070k;
                        while (size >= 0) {
                            appInfo = (AppInfo) arrayList.get(size);
                            ComponentName component2 = appInfo.f16326A.getComponent();
                            if (!appInfo.user.equals(c2673q)) {
                            }
                        }
                        WidgetPreviewLoader widgetPreviewLoader3 = this.f15304s.f15343k.f16220c;
                        String str9 = strArr[i6];
                        C2673q c2673q5 = this.f15303r;
                        widgetPreviewLoader3.getClass();
                        Objects.toString(c2673q5);
                        widgetPreviewLoader3.removePackage(str9, c2673q5, widgetPreviewLoader3.f16865e.mo9676f(c2673q5));
                    }
                    c0073p = new C0073p(2, 0);
                    break;
                case 5:
                case 6:
                    c0073p = i8 == 5 ? new C0073p(4, 0) : new C0073p(4, 1);
                    this.f15304s.f15353u.m861p(c0051t, this.f15303r, c0073p);
                    break;
                case 7:
                    c0073p = C2674r.m9673e(context).mo9680j(this.f15303r) ? new C0073p(8, 0) : new C0073p(8, 1);
                    c0051t = new C0050S();
                    this.f15304s.f15353u.m861p(c0051t, this.f15303r, c0073p);
                    break;
                case 8:
                    for (String str10 : strArr) {
                        this.f15304s.f15355w.m8005f(this.f15302q, this.f15303r, this.f15297l, this.f15299n, this.f15295j);
                        this.f15304s.f15353u.m860o(context, str10, this.f15303r);
                    }
                    c0073p = new C0073p(2, 1);
                    break;
                case 9:
                    for (String str11 : strArr) {
                        this.f15304s.f15355w.m8001b(this.f15302q, this.f15303r, this.f15300o);
                    }
                    c0073p = new C0073p(2, 1);
                    break;
                case 10:
                    this.f15304s.f15355w.m8000a(this.f15302q, this.f15303r, this.f15298m);
                    c0073p = new C0073p(2, 1);
                    break;
                default:
                    c0072o = c0072o2;
                    c0073p = c0072o;
                    break;
            }
            ArrayList arrayList5 = new ArrayList();
            if (((ArrayList) this.f15304s.f15353u.f1071l).size() > 0) {
                arrayList2 = new ArrayList((ArrayList) this.f15304s.f15353u.f1071l);
                ((ArrayList) this.f15304s.f15353u.f1071l).clear();
            } else {
                arrayList2 = null;
            }
            if (((ArrayList) this.f15304s.f15353u.f1073n).size() > 0) {
                arrayList3 = new ArrayList((ArrayList) this.f15304s.f15353u.f1073n);
                ((ArrayList) this.f15304s.f15353u.f1073n).clear();
            } else {
                arrayList3 = null;
            }
            if (((ArrayList) this.f15304s.f15353u.f1072m).size() > 0) {
                arrayList5.addAll((ArrayList) this.f15304s.f15353u.f1072m);
                ((ArrayList) this.f15304s.f15353u.f1072m).clear();
            }
            HashMap map = new HashMap();
            if (arrayList2 != null) {
                if (LauncherAppState.getInstance().f16222e.f16710b) {
                    this.f15304s.addAppsToAllApps(context, arrayList2);
                } else {
                    LauncherModel launcherModel2 = this.f15304s;
                    launcherModel2.getClass();
                    Objects.toString(context);
                    Objects.toString(arrayList2);
                    LauncherModelCallbacks callback = launcherModel2.getCallback();
                    if (!arrayList2.isEmpty()) {
                        LauncherModel.m7567y(new ModelCallbackRunnable(launcherModel2, callback, arrayList2, 2));
                    }
                }
                int size2 = arrayList2.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj = arrayList2.get(i12);
                    i12++;
                    AppInfo appInfo3 = (AppInfo) obj;
                    map.put(appInfo3.f16329D, appInfo3);
                }
            }
            if (arrayList3 != null) {
                LauncherModelCallbacks callback2 = this.f15304s.getCallback();
                int size3 = arrayList3.size();
                int i13 = 0;
                while (i13 < size3) {
                    Object obj2 = arrayList3.get(i13);
                    i13++;
                    AppInfo appInfo4 = (AppInfo) obj2;
                    map.put(appInfo4.f16329D, appInfo4);
                }
                this.f15304s.f15345m.m7884e(new PackageUpdateBindRunnable(this, callback2, arrayList3, 0));
            }
            if (this.f15296k == 1 || c0073p != AbstractC0074q.f213a) {
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = new ArrayList();
                synchronized (LauncherModel.sBgLock) {
                    try {
                        C0081x c0081x2 = LauncherModel.sBgItemsIdMap;
                        c0081x2.getClass();
                        int i14 = 0;
                        while (i14 < c0081x2.size()) {
                            int i15 = i14 + 1;
                            ItemInfo itemInfo = (ItemInfo) c0081x2.valueAt(i14);
                            if (itemInfo instanceof ShortcutInfo) {
                                ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                                c0081x = c0081x2;
                                C2673q c2673q6 = this.f15303r;
                                if (c2673q6 != null) {
                                    i7 = i15;
                                    if (c2673q6.equals(itemInfo.user)) {
                                        Intent.ShortcutIconResource shortcutIconResource = shortcutInfo.f16557E;
                                        if (shortcutIconResource == null || !c0051t.mo123q(shortcutIconResource.packageName)) {
                                            z6 = false;
                                        } else {
                                            Intent.ShortcutIconResource shortcutIconResource2 = shortcutInfo.f16557E;
                                            Bitmap bitmapCreateIconBitmap = Utilities.createIconBitmap(context, shortcutIconResource2.packageName, shortcutIconResource2.resourceName);
                                            if (bitmapCreateIconBitmap != null) {
                                                shortcutInfo.f16558F = bitmapCreateIconBitmap;
                                                shortcutInfo.f16555C = false;
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                        }
                                        ComponentName targetComponent = shortcutInfo.getTargetComponent();
                                        if (targetComponent == null || !c0051t.mo123q(targetComponent.getPackageName())) {
                                            arrayList5 = arrayList5;
                                            z7 = z6;
                                        } else {
                                            AppInfo appInfo5 = (AppInfo) map.get(targetComponent);
                                            z7 = z6;
                                            if (shortcutInfo.hasStatusFlag(3)) {
                                                if (shortcutInfo.hasStatusFlag(2)) {
                                                    PackageManager packageManager = context.getPackageManager();
                                                    appInfo2 = appInfo5;
                                                    arrayList5 = arrayList5;
                                                    if (packageManager.resolveActivity(new Intent("android.intent.action.MAIN").setComponent(targetComponent).addCategory("android.intent.category.LAUNCHER"), 65536) == null) {
                                                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(targetComponent.getPackageName());
                                                        appInfo5 = launchIntentForPackage != null ? (AppInfo) map.get(launchIntentForPackage.getComponent()) : appInfo2;
                                                        if (launchIntentForPackage == null || appInfo5 == null) {
                                                            arrayList7.add(shortcutInfo);
                                                        } else {
                                                            shortcutInfo.f16563K = launchIntentForPackage;
                                                        }
                                                    }
                                                    if (appInfo5 != null) {
                                                        shortcutInfo.f16562J = appInfo5.f16331F;
                                                    }
                                                    shortcutInfo.f16553A = shortcutInfo.f16563K;
                                                    shortcutInfo.f16563K = null;
                                                    shortcutInfo.f16560H = 0;
                                                    shortcutInfo.m8056i(this.f15304s.f15355w);
                                                    z7 = true;
                                                } else {
                                                    arrayList5 = arrayList5;
                                                    appInfo2 = appInfo5;
                                                }
                                                appInfo5 = appInfo2;
                                                if (appInfo5 != null) {
                                                    shortcutInfo.f16562J = appInfo5.f16331F;
                                                }
                                                shortcutInfo.f16553A = shortcutInfo.f16563K;
                                                shortcutInfo.f16563K = null;
                                                shortcutInfo.f16560H = 0;
                                                shortcutInfo.m8056i(this.f15304s.f15355w);
                                                z7 = true;
                                            } else {
                                                arrayList5 = arrayList5;
                                            }
                                            if (appInfo5 != null && "android.intent.action.MAIN".equals(shortcutInfo.f16553A.getAction()) && shortcutInfo.itemType == 0) {
                                                shortcutInfo.m8056i(this.f15304s.f15355w);
                                                shortcutInfo.title = Utilities.trim(appInfo5.title);
                                                shortcutInfo.contentDescription = appInfo5.contentDescription;
                                                z7 = true;
                                            }
                                            int i16 = shortcutInfo.f16559G;
                                            int iMo179a = c0073p.mo179a(i16);
                                            shortcutInfo.f16559G = iMo179a;
                                            boolean z10 = iMo179a != i16;
                                            if (z7 || z10) {
                                                arrayList6.add(shortcutInfo);
                                            }
                                            if (z7) {
                                                LauncherModel.updateItemInDatabase(context, shortcutInfo);
                                            }
                                        }
                                        if (z7) {
                                            arrayList6.add(shortcutInfo);
                                        } else {
                                            arrayList6.add(shortcutInfo);
                                        }
                                        if (z7) {
                                            LauncherModel.updateItemInDatabase(context, shortcutInfo);
                                        }
                                    } else {
                                        arrayList5 = arrayList5;
                                        if (itemInfo instanceof LauncherAppWidgetInfo) {
                                            LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) itemInfo;
                                            if (this.f15296k != 1 && this.f15303r.equals(launcherAppWidgetInfo.user) && launcherAppWidgetInfo.hasRestoreFlag(2) && c0051t.mo123q(launcherAppWidgetInfo.providerName.getPackageName())) {
                                                launcherAppWidgetInfo.f16570C = (launcherAppWidgetInfo.f16570C & (-11)) | 4;
                                                arrayList8.add(launcherAppWidgetInfo);
                                                LauncherModel.updateItemInDatabase(context, launcherAppWidgetInfo);
                                            }
                                        }
                                    }
                                }
                                c0081x2 = c0081x;
                                i14 = i7;
                                arrayList5 = arrayList5;
                            } else {
                                c0081x = c0081x2;
                            }
                            i7 = i15;
                            if (itemInfo instanceof LauncherAppWidgetInfo) {
                                LauncherAppWidgetInfo launcherAppWidgetInfo2 = (LauncherAppWidgetInfo) itemInfo;
                                if (this.f15296k != 1) {
                                }
                            }
                            c0081x2 = c0081x;
                            i14 = i7;
                            arrayList5 = arrayList5;
                        }
                        arrayList4 = arrayList5;
                    } catch (Throwable th) {
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                }
                if (!arrayList6.isEmpty() || !arrayList7.isEmpty()) {
                    this.f15304s.f15345m.m7884e(new RunnableC0031a(this, this.f15304s.getCallback(), arrayList6, arrayList7, 16, false));
                    if (!arrayList7.isEmpty()) {
                        LauncherModel.m7556f(context, arrayList7);
                    }
                }
                if (!arrayList8.isEmpty()) {
                    this.f15304s.f15345m.m7884e(new PackageUpdateBindRunnable(this, this.f15304s.getCallback(), arrayList8, 1));
                }
            } else {
                arrayList4 = arrayList5;
            }
            HashSet<String> hashSet3 = new HashSet();
            HashSet<ComponentName> hashSet4 = new HashSet();
            int i17 = this.f15296k;
            if (i17 == 3) {
                Collections.addAll(hashSet3, strArr);
            } else if (i17 == 2) {
                for (int i18 = 0; i18 < length; i18++) {
                    String str12 = strArr[i18];
                    C2673q c2673q7 = this.f15303r;
                    Objects.toString(context);
                    Objects.toString(c2673q7);
                    if (!AbstractC2666j.m9657c(context).mo9662f(str12, c2673q7)) {
                        hashSet3.add(strArr[i18]);
                    }
                }
                int size4 = arrayList4.size();
                int i19 = 0;
                while (i19 < size4) {
                    Object obj3 = arrayList4.get(i19);
                    i19++;
                    hashSet4.add(((AppInfo) obj3).f16329D);
                }
            }
            ArrayList arrayList9 = arrayList4;
            if (!hashSet3.isEmpty() || !hashSet4.isEmpty()) {
                for (String str13 : hashSet3) {
                    C2673q c2673q8 = this.f15303r;
                    Objects.toString(context);
                    Objects.toString(c2673q8);
                    Objects.toString(c2673q8);
                    LauncherModel.m7556f(context, LauncherModel.filterItemInfos(LauncherModel.sBgItemsIdMap, new Partner(3, str13, c2673q8)));
                }
                for (ComponentName componentName : hashSet4) {
                    LauncherModel launcherModel3 = this.f15304s;
                    C2673q c2673q9 = this.f15303r;
                    launcherModel3.getClass();
                    Objects.toString(componentName);
                    Objects.toString(c2673q9);
                    LauncherModel.m7556f(context, LauncherModel.filterItemInfos(LauncherModel.sBgItemsIdMap, new Partner(4, componentName, c2673q9)));
                }
                InstallShortcutReceiver.removeFromInstallQueue(context, hashSet3, this.f15303r);
                this.f15304s.f15345m.m7884e(new RunnableC0031a(this, this.f15304s.getCallback(), hashSet3, hashSet4, 17, false));
            }
            if (!arrayList9.isEmpty()) {
                this.f15304s.f15345m.m7884e(new PackageUpdateBindRunnable(this, this.f15304s.getCallback(), arrayList9, 2));
            }
            int i20 = this.f15296k;
            if (i20 == 1 || i20 == 3 || i20 == 2) {
                LauncherModelCallbacks callback3 = this.f15304s.getCallback();
                if (!Utilities.f16748i) {
                    this.f15304s.f15345m.m7884e(new PackageRemoveBindRunnable(this, callback3, 0));
                }
                this.f15304s.f15345m.m7884e(new PackageRemoveBindRunnable(this, callback3, 1));
            }
        }
    }

    public PackageUpdatedTask(LauncherModel launcherModel, String[] strArr, String str, C2673q c2673q, int i6, String str2, int i7) {
        this.f15304s = launcherModel;
        this.f15296k = 8;
        this.f15301p = strArr;
        this.f15302q = str;
        this.f15303r = c2673q;
        this.f15297l = i6;
        this.f15299n = str2;
        this.f15295j = i7;
    }

    public PackageUpdatedTask(LauncherModel launcherModel, String[] strArr, String str, C2673q c2673q, String str2) {
        this.f15304s = launcherModel;
        this.f15296k = 9;
        this.f15301p = strArr;
        this.f15302q = str;
        this.f15303r = c2673q;
        this.f15300o = str2;
    }

    public PackageUpdatedTask(LauncherModel launcherModel, String str, C2673q c2673q, int i6) {
        this.f15304s = launcherModel;
        this.f15296k = 10;
        this.f15302q = str;
        this.f15303r = c2673q;
        this.f15298m = i6;
        this.f15301p = new String[0];
    }
}
