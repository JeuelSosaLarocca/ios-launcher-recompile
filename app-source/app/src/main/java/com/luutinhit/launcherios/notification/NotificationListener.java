package com.luutinhit.launcherios.notification;

import U2.C1098d;
import X3.C1185a;
import X3.C1186b;
import android.app.Notification;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.luutinhit.launcher6.LauncherModel;
import com.luutinhit.launcher6.Utilities;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class NotificationListener extends NotificationListenerService {

    /* JADX INFO: renamed from: m */
    public static C1185a f17614m;

    /* JADX INFO: renamed from: j */
    public NotificationListenerService.Ranking f17615j;

    /* JADX INFO: renamed from: k */
    public Handler f17616k;

    /* JADX INFO: renamed from: l */
    public Handler f17617l;

    public NotificationListener() {
        C1098d c1098d = new C1098d(1, this);
        C1186b c1186b = new C1186b(0);
        if (Utilities.f16752m) {
            this.f17615j = new NotificationListenerService.Ranking();
        }
        this.f17616k = new Handler(LauncherModel.sWorkerThread.getLooper(), c1098d);
        this.f17617l = new Handler(Looper.getMainLooper(), c1186b);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0080 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    /* JADX WARN: Code duplicated, block: B:51:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x0056, please report this as an issue */
    /* JADX INFO: renamed from: a */
    public static ArrayList m8348a(NotificationListener notificationListener, StatusBarNotification[] statusBarNotificationArr) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Notification notification;
        boolean z5;
        boolean z6;
        if (statusBarNotificationArr == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < statusBarNotificationArr.length; i6++) {
            StatusBarNotification statusBarNotification = statusBarNotificationArr[i6];
            boolean z7 = Utilities.f16752m;
            NotificationListenerService.Ranking ranking = notificationListener.f17615j;
            if (z7) {
                notificationListener.getCurrentRanking().getRanking(statusBarNotification.getKey(), ranking);
                if (!Utilities.f16743d || ranking.canShowBadge()) {
                    notification = statusBarNotification.getNotification();
                    z5 = Utilities.f16743d;
                    if (z5 || !ranking.getChannel().getId().equals("miscellaneous") ? !(z5 || (notification.flags & 2) == 0) : (notification.flags & 2) != 0) {
                        hashSet.add(Integer.valueOf(i6));
                    } else if (z7) {
                        if ((notification.flags & 512) != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        boolean z8 = !TextUtils.isEmpty(notification.extras.getCharSequence("android.title")) && TextUtils.isEmpty(notification.extras.getCharSequence("android.text"));
                        if (!z6 || z8) {
                            hashSet.add(Integer.valueOf(i6));
                        }
                    }
                } else {
                    hashSet.add(Integer.valueOf(i6));
                }
            } else {
                notification = statusBarNotification.getNotification();
                z5 = Utilities.f16743d;
                if (z5) {
                    if (z7) {
                        if ((notification.flags & 512) != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (TextUtils.isEmpty(notification.extras.getCharSequence("android.title"))) {
                        }
                        if (!z6) {
                        }
                    }
                } else if (z7) {
                    if ((notification.flags & 512) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (TextUtils.isEmpty(notification.extras.getCharSequence("android.title"))) {
                    }
                    if (!z6) {
                    }
                }
                hashSet.add(Integer.valueOf(i6));
            }
        }
        ArrayList arrayList = new ArrayList(statusBarNotificationArr.length - hashSet.size());
        for (int i7 = 0; i7 < statusBarNotificationArr.length; i7++) {
            if (!hashSet.contains(Integer.valueOf(i7))) {
                arrayList.add(statusBarNotificationArr[i7]);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public final void m8349b() {
        Handler handler = this.f17616k;
        handler.removeCallbacksAndMessages(null);
        handler.sendEmptyMessageDelayed(3, 500L);
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerConnected() {
        m8349b();
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerDisconnected() {
        this.f17617l.obtainMessage(3).sendToTarget();
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            m8349b();
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            m8349b();
        }
    }
}
