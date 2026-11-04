package com.luutinhit.launcher6;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import java.util.LinkedList;

/* JADX INFO: renamed from: com.luutinhit.launcher6.U */
/* JADX INFO: loaded from: classes.dex */
public final class DeferredHandlerImpl extends Handler implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Partner f15963j;

    public DeferredHandlerImpl(Partner partner) {
        this.f15963j = partner;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        synchronized (((LinkedList) this.f15963j.f16123k)) {
            try {
                if (((LinkedList) this.f15963j.f16123k).size() == 0) {
                    return;
                }
                ((Runnable) ((LinkedList) this.f15963j.f16123k).removeFirst()).run();
                synchronized (((LinkedList) this.f15963j.f16123k)) {
                    Partner partner = this.f15963j;
                    LinkedList linkedList = (LinkedList) partner.f16123k;
                    if (linkedList.size() > 0) {
                        ((DeferredHandlerImpl) partner.f16124l).sendEmptyMessage(1);
                    }
                }
            } catch (Throwable th) {
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
            }
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        handleMessage(null);
        return false;
    }
}
