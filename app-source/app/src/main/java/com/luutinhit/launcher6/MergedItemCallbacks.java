package com.luutinhit.launcher6;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.view.View;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;
import p119q4.InterfaceC2621f;
import p127s4.InterfaceC2749b;

/* JADX INFO: renamed from: com.luutinhit.launcher6.x */
/* JADX INFO: loaded from: classes.dex */
public final class MergedItemCallbacks implements InterfaceC2621f, OnAlarmListener, ItemOperator {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f17233j;

    /* JADX INFO: renamed from: k */
    public Object f17234k;

    public /* synthetic */ MergedItemCallbacks(int i6, Object obj) {
        this.f17233j = i6;
        this.f17234k = obj;
    }

    @Override // p119q4.InterfaceC2621f, p119q4.InterfaceC2617b
    /* JADX INFO: renamed from: a */
    public void mo36a(Object obj) {
        ((Boolean) obj).booleanValue();
        SparseArray sparseArray = BubbleTextView.sPreloaderThemes;
        ((BubbleTextView) this.f17234k).getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.luutinhit.launcher6.ItemOperator
    /* JADX INFO: renamed from: d */
    public boolean mo2269d(ItemInfo itemInfo, View view, FolderIcon folderIcon) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        switch (this.f17233j) {
            case 4:
                if (view instanceof Folder) {
                    Folder folder = (Folder) view;
                    if (folder.getInfo() == ((FolderInfo) this.f17234k) && folder.getInfo().f15523B) {
                        return true;
                    }
                }
                return false;
            case 5:
                return itemInfo == this.f17234k;
            case 6:
                if (!(view instanceof DropTarget)) {
                    return false;
                }
                ((Workspace) this.f17234k).f23434X0.f16103l.remove((DropTarget) view);
                return false;
            default:
                boolean z5 = itemInfo instanceof ShortcutInfo;
                HashSet hashSet = (HashSet) this.f17234k;
                if (z5 && (view instanceof BubbleTextView) && hashSet.contains(itemInfo)) {
                    ((BubbleTextView) view).applyState(false);
                } else if ((view instanceof PendingAppWidgetHostView) && (itemInfo instanceof LauncherAppWidgetInfo) && hashSet.contains(itemInfo)) {
                    ((PendingAppWidgetHostView) view).applyState();
                }
                return false;
        }
    }

    @Override // com.luutinhit.launcher6.OnAlarmListener
    /* JADX INFO: renamed from: h */
    public void mo7775h(Alarm alarm) {
        ShortcutInfo shortcutInfoMakeShortcut;
        FolderIcon folderIcon = (FolderIcon) this.f17234k;
        ItemInfo itemInfo = folderIcon.f15647E;
        if (itemInfo instanceof AppInfo) {
            shortcutInfoMakeShortcut = ((AppInfo) itemInfo).makeShortcut();
            shortcutInfoMakeShortcut.spanX = 1;
            shortcutInfoMakeShortcut.spanY = 1;
        } else {
            shortcutInfoMakeShortcut = (ShortcutInfo) itemInfo;
        }
        Folder folder = folderIcon.mFolder;
        folder.f15606I = shortcutInfoMakeShortcut;
        folder.f15602E = folder.mContent.v0();
        folder.f15608K = true;
        folder.f15610M = true;
        folder.mDragController.f16104m.add(folder);
        folderIcon.f15649j.openFolder(folderIcon);
    }

    public MergedItemCallbacks(LauncherBackupHelper launcherBackupHelper, int i6) {
        ArrayList arrayList;
        this.f17233j = 3;
        if (i6 == 0) {
            arrayList = new ArrayList();
        } else {
            ArrayList arrayList2 = new ArrayList();
            XmlResourceParser xml = launcherBackupHelper.f16593a.getResources().getXml(i6);
            try {
                AutoInstallsLayout.beginDocument(xml, "resolve");
                int depth = xml.getDepth();
                while (true) {
                    int next = xml.next();
                    if ((next == 3 && xml.getDepth() <= depth) || next == 1) {
                        break; // jadx dropped this: END_TAG of the root or END_DOCUMENT ends the parse
                    }
                    if (next == 2 && "favorite".equals(xml.getName())) {
                        arrayList2.add(Intent.parseUri(AutoInstallsLayout.getAttributeValue(xml, "uri"), 0));
                    }
                }
            } catch (IOException | URISyntaxException | XmlPullParserException unused) {
            } finally {
                xml.close();
            }
            arrayList = arrayList2;
        }
        this.f17234k = arrayList;
    }

    @Override // p119q4.InterfaceC2621f, p119q4.InterfaceC2617b
    /* JADX INFO: renamed from: c */
    public void mo38c(InterfaceC2749b interfaceC2749b) {
    }

    @Override // p119q4.InterfaceC2621f, p119q4.InterfaceC2617b
    public void onError(Throwable th) {
    }
}
