package com.luutinhit.launcher6.leftpage;

import B3.ViewOnClickListenerC0065h;
import F3.AbstractC0279f;
import G3.C0346b;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.leftpage.adapter.WrapStaggeredGridLayoutManager;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import p131t3.InterfaceC2794g;
import p135u3.C2832f;
import p145w3.C2932b;
import p145w3.C2933c;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpWidgetsList extends AbstractC0279f {

    /* JADX INFO: renamed from: d0 */
    public static final /* synthetic */ int f23503d0 = 0;

    /* JADX INFO: renamed from: S */
    public Launcher f16658S;

    /* JADX INFO: renamed from: T */
    public C2832f f16659T;

    /* JADX INFO: renamed from: U */
    public RecyclerView f16660U;

    /* JADX INFO: renamed from: V */
    public ArrayList f16661V;

    /* JADX INFO: renamed from: W */
    public int f16662W;

    /* JADX INFO: renamed from: a0 */
    public boolean f23504a0;

    /* JADX INFO: renamed from: b0 */
    public LinearLayoutRound f23505b0;

    /* JADX INFO: renamed from: c0 */
    public InterfaceC2794g f23506c0;

    public SlidingUpWidgetsList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16661V = new ArrayList();
        Launcher launcher = (Launcher) context;
        this.f16658S = launcher;
        this.f16662W = launcher.getDeviceProfile().f15977C;
        this.f23504a0 = launcher.isDarkMode;
    }

    @Override // F3.AbstractC0279f, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f16660U = (RecyclerView) findViewById(R.id.left_page_widgets_lists);
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.widgets_content_list);
        this.f23505b0 = linearLayoutRound;
        linearLayoutRound.setDarkModeBackgroundColor(this.f23504a0 ? -14935012 : -2565928);
        findViewById(R.id.out_side_widgets_list).setOnClickListener(new ViewOnClickListenerC0065h(13, this));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16660U.getLayoutParams();
        int i6 = this.f16662W;
        double d6 = i6;
        double d7 = 0.68d * d6;
        int i7 = (int) d7;
        layoutParams.rightMargin = i7;
        layoutParams.leftMargin = i7;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById(R.id.search_box).getLayoutParams();
        int i8 = (int) (d7 + d6);
        layoutParams2.rightMargin = i8;
        layoutParams2.leftMargin = i8;
        ArrayList arrayList = new ArrayList();
        Launcher launcher = this.f16658S;
        arrayList.add(new C2933c(launcher.getDrawable(R.drawable.sample_weather_widget_square), 10));
        arrayList.add(new C2933c(launcher.getDrawable(R.drawable.sample_weather_widget), 11));
        C2932b c2932b = new C2932b(launcher.getDrawable(R.drawable.sample_weather_widget), launcher.getString(R.string.weather), 1, arrayList);
        ArrayList arrayList2 = this.f16661V;
        arrayList2.add(c2932b);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new C2933c(launcher.getDrawable(R.drawable.sample_battery_widget), 60));
        arrayList2.add(new C2932b(launcher.getDrawable(R.drawable.sample_battery_widget), launcher.getString(R.string.battery), 0, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new C2933c(launcher.getDrawable(R.drawable.sample_photo_widget), 30));
        arrayList2.add(new C2932b(launcher.getDrawable(R.drawable.sample_photo_widget), launcher.getString(R.string.picture), 0, arrayList4));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new C2933c(launcher.getDrawable(R.drawable.sample_app_suggestions), 71));
        arrayList2.add(new C2932b(launcher.getDrawable(R.drawable.sample_app_suggestions), launcher.getString(R.string.suggestions), 1, arrayList5));
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new C2933c(launcher.getDrawable(R.drawable.sample_contact_favorite), 51));
        arrayList2.add(new C2932b(launcher.getDrawable(R.drawable.sample_contact_favorite), launcher.getString(R.string.favorites), 1, arrayList6));
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(new C2933c(launcher.getDrawable(R.drawable.sample_calendar_widget), 40));
        arrayList2.add(new C2932b(launcher.getDrawable(R.drawable.sample_calendar_widget), launcher.getString(R.string.calendar), 0, arrayList7));
        this.f16659T = new C2832f(arrayList2, this.f23504a0);
        WrapStaggeredGridLayoutManager wrapStaggeredGridLayoutManager = new WrapStaggeredGridLayoutManager();
        this.f16660U.m3419l(new C0346b(i6, 2));
        this.f16660U.setLayoutManager(wrapStaggeredGridLayoutManager);
        this.f16660U.setAdapter(this.f16659T);
        this.f16659T.f21394o = this;
    }

    public void setDarkMode(boolean z5) {
        this.f23504a0 = z5;
        LinearLayoutRound linearLayoutRound = this.f23505b0;
        if (linearLayoutRound != null) {
            linearLayoutRound.setDarkModeBackgroundColor(z5 ? -14935012 : -2565928);
        }
        C2832f c2832f = this.f16659T;
        if (c2832f != null) {
            c2832f.f21393n = z5;
        }
    }

    public void setOnItemClickListener(InterfaceC2794g interfaceC2794g) {
        this.f23506c0 = interfaceC2794g;
    }
}
