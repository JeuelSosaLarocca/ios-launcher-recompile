package com.luutinhit.launcher6;

import B3.C0034B;
import B3.C0039G;
import android.view.View;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import p023Z.C1274e;
import p023Z.C1275f;

/* JADX INFO: renamed from: com.luutinhit.launcher6.v3 */
/* JADX INFO: loaded from: classes.dex */
public final class SearchPullClickListener implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public /* synthetic */ Workspace f17013j;

    public SearchPullClickListener(Workspace workspace) {
        this.f17013j = workspace;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0039G c0039g = this.f17013j.f23432V0.pullDetector;
        c0039g.m74a();
        SearchViewLayout searchViewLayout = c0039g.f105k;
        searchViewLayout.m8359L();
        searchViewLayout.animate().withLayer().alpha(1.0f).setDuration(368L).setInterpolator(C0039G.f92n).setUpdateListener(new C0034B(c0039g, 0)).start();
        float f6 = c0039g.f97c;
        C1274e c1274e = c0039g.f103i;
        c1274e.f3643a = f6;
        if (c1274e.f3647e) {
            c1274e.f3653k = 0.0f;
        } else {
            if (c1274e.f3652j == null) {
                c1274e.f3652j = new C1275f(0);
            }
            c1274e.f3652j.f3662i = 0.0f;
            c1274e.m2597e();
        }
        c1274e.m2597e();
        c0039g.f102h = false;
    }
}
