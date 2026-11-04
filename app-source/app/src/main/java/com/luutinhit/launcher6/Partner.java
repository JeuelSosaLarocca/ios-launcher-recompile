package com.luutinhit.launcher6;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.X2 */
/* JADX INFO: loaded from: classes.dex */
public final class Partner implements ItemInfoFilter, ItemOperator {



    /* JADX INFO: renamed from: m */
    public static boolean f16120m = false;

    /* JADX INFO: renamed from: n */
    public static Partner f16121n;

    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16122j;

    /* JADX INFO: renamed from: k */
    public Object f16123k;

    /* JADX INFO: renamed from: l */
    public Object f16124l;

    public /* synthetic */ Partner() {
        this.f16122j = 1;
    }

    /* JADX INFO: renamed from: c */
    public static synchronized Partner get(PackageManager packageManager) {
        try {
            if (!f16120m) {
                Pair pairFindSystemApk = Utilities.findSystemApk(packageManager, "com.luutinhit.launcher6.action.PARTNER_CUSTOMIZATION");
                if (pairFindSystemApk != null) {
                    f16121n = new Partner(0, (String) pairFindSystemApk.first, (Resources) pairFindSystemApk.second);
                }
                f16120m = true;
            }
        } catch (Throwable th) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
        }
        return f16121n;
    }

    /* JADX INFO: renamed from: a */
    public void m7882a() {
        synchronized (((LinkedList) this.f16123k)) {
            ((LinkedList) this.f16123k).clear();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m7883b() {
        LinkedList linkedList = new LinkedList();
        synchronized (((LinkedList) this.f16123k)) {
            linkedList.addAll((LinkedList) this.f16123k);
            ((LinkedList) this.f16123k).clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // com.luutinhit.launcher6.ItemOperator
    /* JADX INFO: renamed from: d */
    public boolean mo2269d(ItemInfo itemInfo, View view, FolderIcon folderIcon) {
        switch (this.f16122j) {
            case 5:
                if (!((ItemOperator) this.f16123k).mo2269d(itemInfo, view, folderIcon)) {
                    return false;
                }
                ((View[]) this.f16124l)[0] = view;
                return true;
            default:
                if ((itemInfo instanceof ShortcutInfo) && (view instanceof BubbleTextView) && ((HashSet) this.f16123k).contains(itemInfo)) {
                    ShortcutInfo shortcutInfo = (ShortcutInfo) itemInfo;
                    BubbleTextView bubbleTextView = (BubbleTextView) view;
                    Workspace workspace = (Workspace) this.f16124l;
                    workspace.getClass();
                    Objects.toString(bubbleTextView);
                    Drawable icon = bubbleTextView.getIcon();
                    bubbleTextView.applyFromShortcutInfo(shortcutInfo, workspace.f23433W0, shortcutInfo.hasStatusFlag(3) != ((icon instanceof PreloadIconDrawable) && (((PreloadIconDrawable) icon).f16234i > 1.0f ? 1 : (((PreloadIconDrawable) icon).f16234i == 1.0f ? 0 : -1)) < 0));
                    if (folderIcon != null) {
                        folderIcon.invalidate();
                    }
                }
                return false;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m7884e(Runnable runnable) {
        synchronized (((LinkedList) this.f16123k)) {
            ((LinkedList) this.f16123k).add(runnable);
            if (((LinkedList) this.f16123k).size() == 1) {
                LinkedList linkedList = (LinkedList) this.f16123k;
                if (linkedList.size() > 0) {
                    ((DeferredHandlerImpl) this.f16124l).sendEmptyMessage(1);
                }
            }
        }
    }

    @Override // com.luutinhit.launcher6.ItemInfoFilter
    /* JADX INFO: renamed from: j */
    public boolean mo856j(FolderInfo folderInfo, ItemInfo itemInfo, ComponentName componentName) {
        switch (this.f16122j) {
            case 3:
                return componentName.getPackageName().equals((String) this.f16123k) && itemInfo.user.equals((C2673q) this.f16124l);
            default:
                C2673q c2673q = itemInfo.user;
                ComponentName componentName2 = (ComponentName) this.f16123k;
                if (c2673q == null) {
                    return componentName.equals(componentName2);
                }
                return componentName.equals(componentName2) && itemInfo.user.equals((C2673q) this.f16124l);
        }
    }

    public /* synthetic */ Partner(int i6, Object obj, Object obj2) {
        this.f16122j = i6;
        this.f16123k = obj;
        this.f16124l = obj2;
    }

    public Partner(Workspace workspace, HashSet hashSet) {
        this.f16122j = 6;
        this.f16124l = workspace;
        this.f16123k = hashSet;
    }
}
