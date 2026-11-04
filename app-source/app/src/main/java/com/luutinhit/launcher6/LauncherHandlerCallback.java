package com.luutinhit.launcher6;

import A4.RunnableC0026a;
import E4.AbstractC0212f;
import G3.CallableC0366v;
import T0.C1029l;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Advanceable;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.Iterator;
import java.util.List;
import p024a.AbstractC1314a;
import p123r4.AbstractC2679b;
import p159z4.CallableC3080a;

/* JADX INFO: renamed from: com.luutinhit.launcher6.D1 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherHandlerCallback implements Handler.Callback {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15491j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ Launcher f15492k;

    public /* synthetic */ LauncherHandlerCallback(Launcher launcher, int i6) {
        this.f15491j = i6;
        this.f15492k = launcher;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f15491j) {
            case 0:
                int i6 = message.what;
                int i7 = 0;
                Launcher launcher = this.f15492k;
                if (i6 == 1) {
                    for (View view : launcher.mWidgetsToAdvance.keySet()) {
                        View viewFindViewById = view.findViewById(launcher.mWidgetsToAdvance.get(view).autoAdvanceViewId);
                        int i8 = i7 * 250;
                        if (viewFindViewById instanceof Advanceable) {
                            launcher.mHandler.postDelayed(new MergedUiRunnable(6, viewFindViewById), i8);
                        }
                        i7++;
                    }
                    launcher.sendAdvanceMessage(20000L);
                } else if (i6 == 2) {
                    launcher.mUserPresent = false;
                    launcher.mDragLayer.clearAllResizeFrames();
                    launcher.updateAutoAdvanceState();
                    if (launcher.getCurrentWorkspaceScreen() == 0) {
                        launcher.moveWorkspaceToDefaultScreen();
                        launcher.showBlurWallpaperBackground(0.0f);
                    }
                }
                return true;
            default:
                try {
                    int i9 = message.what;
                    Launcher launcher2 = this.f15492k;
                    if (i9 == 0) {
                        launcher2.clearBadgeCount();
                        launcher2.mUiHandler.obtainMessage(message.what).sendToTarget();
                        return true;
                    }
                    if (i9 == 1) {
                        launcher2.clearBadgeCount();
                        Iterator it = ((List) message.obj).iterator();
                        while (it.hasNext()) {
                            Launcher.updateDialerShortcut(launcher2, (String) it.next());
                        }
                        launcher2.mUiHandler.obtainMessage(message.what).sendToTarget();
                        return true;
                    }
                    if (i9 != 3) {
                        return true;
                    }
                    try {
                        BubbleTextView bubbleTextView = (BubbleTextView) message.obj;
                        if (launcher2.mSearchView == null || bubbleTextView == null) {
                            return true;
                        }
                        Object tag = bubbleTextView.getTag();
                        Intent intent = tag instanceof ShortcutInfo ? ((ShortcutInfo) tag).f16553A : tag instanceof AppInfo ? ((AppInfo) tag).f16326A : null;
                        if (intent == null || intent.getComponent() == null) {
                            return true;
                        }
                        String strFlattenToString = intent.getComponent().flattenToString();
                        if (launcher2.mSearchView == null) {
                            return true;
                        }
                        SearchViewLayout searchViewLayout = launcher2.mSearchView;
                        searchViewLayout.getClass();
                        try {
                            new CallableC3080a(new CallableC0366v(searchViewLayout, strFlattenToString, 1)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C1029l(23, searchViewLayout), AbstractC2679b.m9681a(), 1));
                            return true;
                        } catch (NullPointerException e) {
                            throw e;
                        } catch (Throwable th) {
                            AbstractC1314a.m2681A(th);
                            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
                            nullPointerException.initCause(th);
                            throw nullPointerException;
                        }
                    } catch (Throwable th2) {
                        th2.getMessage();
                        return true;
                    }
                } catch (Throwable th3) {
                    th3.getMessage();
                    return false;
                }
        }
    }
}
