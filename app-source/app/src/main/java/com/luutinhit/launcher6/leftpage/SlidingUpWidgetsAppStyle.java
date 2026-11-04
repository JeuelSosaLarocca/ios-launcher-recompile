package com.luutinhit.launcher6.leftpage;

import B3.ViewOnClickListenerC0065h;
import F3.AbstractC0279f;
import G3.C0364t;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager2.widget.ViewPager2;
import com.luutinhit.launcher6.Insettable;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.editscreen.FrameLayoutRound;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import n3.C2504b;
import p131t3.C2792e;
import p131t3.InterfaceC2793f;
import p131t3.RunnableC2788a;
import p131t3.ViewOnClickListenerC2791d;
import p145w3.C2933c;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpWidgetsAppStyle extends AbstractC0279f implements View.OnClickListener, Insettable {

    /* JADX INFO: renamed from: c0 */
    public static final /* synthetic */ int f23500c0 = 0;

    /* JADX INFO: renamed from: S */
    public Launcher f16653S;

    /* JADX INFO: renamed from: T */
    public C2504b f16654T;

    /* JADX INFO: renamed from: U */
    public ViewPager2 f16655U;

    /* JADX INFO: renamed from: V */
    public boolean f16656V;

    /* JADX INFO: renamed from: W */
    public FrameLayoutRound f16657W;

    /* JADX INFO: renamed from: a0 */
    public Rect f23501a0;

    /* JADX INFO: renamed from: b0 */
    public InterfaceC2793f f23502b0;

    public SlidingUpWidgetsAppStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23501a0 = new Rect();
        Launcher launcher = (Launcher) context;
        this.f16653S = launcher;
        this.f16656V = launcher.isDarkMode;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC2793f interfaceC2793f;
        int currentItem = this.f16655U.getCurrentItem();
        ArrayList arrayList = this.f16654T.f20208n;
        C2933c c2933c = arrayList != null ? (C2933c) arrayList.get(currentItem) : null;
        if (c2933c == null || (interfaceC2793f = this.f23502b0) == null) {
            return;
        }
        ViewOnClickListenerC2791d viewOnClickListenerC2791d = (ViewOnClickListenerC2791d) ((C0364t) interfaceC2793f).f1205k;
        viewOnClickListenerC2791d.m9950D();
        viewOnClickListenerC2791d.m9951y(c2933c.f21710b);
        SlidingUpWidgetsAppStyle slidingUpWidgetsAppStyle = viewOnClickListenerC2791d.f21283t;
        if (slidingUpWidgetsAppStyle != null) {
            slidingUpWidgetsAppStyle.postOnAnimation(new RunnableC2788a(viewOnClickListenerC2791d, 6));
        }
        SlidingUpWidgetsList slidingUpWidgetsList = viewOnClickListenerC2791d.f21282s;
        if (slidingUpWidgetsList != null) {
            slidingUpWidgetsList.postOnAnimation(new RunnableC2788a(viewOnClickListenerC2791d, 5));
        }
        viewOnClickListenerC2791d.f21281r.setVisibility(0);
        viewOnClickListenerC2791d.f21280q.setVisibility(0);
    }

    @Override // F3.AbstractC0279f, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        FrameLayoutRound frameLayoutRound = (FrameLayoutRound) findViewById(R.id.left_page_widgets_content);
        this.f16657W = frameLayoutRound;
        frameLayoutRound.setDarkModeBackgroundColor(this.f16656V ? -14935012 : -2565928);
        ((AppCompatButton) findViewById(R.id.add_button_widgets_app_style)).setOnClickListener(this);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.view_pager_widgets_app_style);
        this.f16655U = viewPager2;
        viewPager2.setOffscreenPageLimit(3);
        Launcher launcher = this.f16653S;
        this.f16655U.setPageTransformer(new C2792e(launcher.getResources().getDimensionPixelOffset(R.dimen.sliding_up_widgets_app_style_page_offset), launcher.getResources().getDimensionPixelOffset(R.dimen.sliding_up_widgets_app_style_page_margin)));
        findViewById(R.id.left_page_out_side_widgets_app_style).setOnClickListener(new ViewOnClickListenerC0065h(12, this));
    }

    public void setDarkMode(boolean z5) {
        this.f16656V = z5;
        FrameLayoutRound frameLayoutRound = this.f16657W;
        if (frameLayoutRound != null) {
            frameLayoutRound.setDarkModeBackgroundColor(z5 ? -14935012 : -2565928);
        }
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.f23501a0;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }

    public void setOnAddWidgetButtonClickListener(InterfaceC2793f interfaceC2793f) {
        this.f23502b0 = interfaceC2793f;
    }

    public void setWidgetsAppStyleList(ArrayList<C2933c> arrayList) {
        C2504b c2504b = new C2504b(1);
        c2504b.f20208n = arrayList;
        this.f16654T = c2504b;
        this.f16655U.setAdapter(c2504b);
    }
}
