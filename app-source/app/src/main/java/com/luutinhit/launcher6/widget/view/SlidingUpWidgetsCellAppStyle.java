package com.luutinhit.launcher6.widget.view;

import B3.ViewOnClickListenerC0065h;
import F3.AbstractC0279f;
import G3.C0350f;
import G3.C0351g;
import G3.C0364t;
import G3.ViewOnLayoutChangeListenerC0359o;
import J3.C0545d;
import J3.InterfaceC0549h;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;
import com.luutinhit.launcher6.Insettable;
import com.luutinhit.launcher6.InvariantDeviceProfile;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherAppState;
import com.luutinhit.launcher6.LauncherAppWidgetProviderInfo;
import com.luutinhit.launcher6.WidgetPreviewLoader;
import com.luutinhit.launcher6.editscreen.ConstraintLayoutRound;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import p122r3.AbstractC2659c;

/* JADX INFO: loaded from: classes.dex */
public class SlidingUpWidgetsCellAppStyle extends AbstractC0279f implements View.OnClickListener, Insettable {

    /* JADX INFO: renamed from: c0 */
    public static final /* synthetic */ int f23538c0 = 0;

    /* JADX INFO: renamed from: S */
    public Launcher f17194S;

    /* JADX INFO: renamed from: T */
    public ViewPager f17195T;

    /* JADX INFO: renamed from: U */
    public Rect f17196U;

    /* JADX INFO: renamed from: V */
    public WidgetPreviewLoader f17197V;

    /* JADX INFO: renamed from: W */
    public boolean f17198W;

    /* JADX INFO: renamed from: a0 */
    public ConstraintLayoutRound f23539a0;

    /* JADX INFO: renamed from: b0 */
    public InterfaceC0549h f23540b0;

    public SlidingUpWidgetsCellAppStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17196U = new Rect();
        Launcher launcher = (Launcher) context;
        this.f17194S = launcher;
        this.f17198W = launcher.isDarkMode;
    }

    public WidgetPreviewLoader getWidgetPreviewLoader() {
        if (this.f17197V == null) {
            this.f17197V = LauncherAppState.getInstance().f16220c;
        }
        return this.f17197V;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0549h interfaceC0549h = this.f23540b0;
        if (interfaceC0549h != null) {
            C0364t c0364t = (C0364t) interfaceC0549h;
            c0364t.getClass();
            ((WidgetsContainerView) c0364t.f1205k).m8244v();
        }
    }

    @Override // F3.AbstractC0279f, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        ConstraintLayoutRound constraintLayoutRound = (ConstraintLayoutRound) findViewById(R.id.widgets_content);
        this.f23539a0 = constraintLayoutRound;
        constraintLayoutRound.setDarkModeBackgroundColor(this.f17198W ? -14935012 : -2565928);
        ((AppCompatButton) findViewById(R.id.add_button_widgets_app_style)).setOnClickListener(this);
        this.f17195T = (ViewPager) findViewById(R.id.view_pager_widgets_scroll_container);
        findViewById(R.id.out_side_widgets_app_style).setOnClickListener(new ViewOnClickListenerC0065h(5, this));
    }

    public void setDarkMode(boolean z5) {
        this.f17198W = z5;
        ConstraintLayoutRound constraintLayoutRound = this.f23539a0;
        if (constraintLayoutRound != null) {
            constraintLayoutRound.setDarkModeBackgroundColor(z5 ? -14935012 : -2565928);
        }
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.f17196U;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }

    public void setOnAddWidgetButtonClickListener(InterfaceC0549h interfaceC0549h) {
        this.f23540b0 = interfaceC0549h;
    }

    /* JADX INFO: renamed from: u */
    public final void m8246u(ArrayList arrayList, WidgetsContainerView widgetsContainerView, WidgetsContainerView widgetsContainerView2) {
        char c6 = 0;
        if (getWidgetPreviewLoader() == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            Launcher launcher = this.f17194S;
            ViewOnLayoutChangeListenerC0359o viewOnLayoutChangeListenerC0359o = new ViewOnLayoutChangeListenerC0359o(launcher);
            viewOnLayoutChangeListenerC0359o.setOnClickListener(widgetsContainerView);
            viewOnLayoutChangeListenerC0359o.setOnLongClickListener(widgetsContainerView2);
            boolean z5 = arrayList.get(i6) instanceof LauncherAppWidgetProviderInfo;
            String str = viewOnLayoutChangeListenerC0359o.f1183p;
            if (z5) {
                LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo = (LauncherAppWidgetProviderInfo) arrayList.get(i6);
                viewOnLayoutChangeListenerC0359o.setTag(new C0351g(launcher, launcherAppWidgetProviderInfo));
                WidgetPreviewLoader widgetPreviewLoader = this.f17197V;
                InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
                viewOnLayoutChangeListenerC0359o.f1184q = launcherAppWidgetProviderInfo;
                viewOnLayoutChangeListenerC0359o.f1181n.setText(AbstractC2659c.m9639f(viewOnLayoutChangeListenerC0359o.getContext()).mo9648j(launcherAppWidgetProviderInfo));
                int iMin = Math.min(launcherAppWidgetProviderInfo.f16574j, invariantDeviceProfile.f16712d);
                int iMin2 = Math.min(launcherAppWidgetProviderInfo.f16575k, invariantDeviceProfile.f16711c);
                TextView textView = viewOnLayoutChangeListenerC0359o.f1182o;
                Integer numValueOf = Integer.valueOf(iMin);
                Integer numValueOf2 = Integer.valueOf(iMin2);
                Object[] objArr = new Object[2];
                objArr[c6] = numValueOf;
                objArr[1] = numValueOf2;
                textView.setText(String.format(str, objArr));
                viewOnLayoutChangeListenerC0359o.f1185r = widgetPreviewLoader;
            } else {
                if (arrayList.get(i6) instanceof ResolveInfo) {
                    ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i6);
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    C0350f c0350f = new C0350f();
                    c0350f.f1147B = activityInfo;
                    c0350f.componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                    c0350f.itemType = 1;
                    viewOnLayoutChangeListenerC0359o.setTag(c0350f);
                    PackageManager packageManager = launcher.getPackageManager();
                    WidgetPreviewLoader widgetPreviewLoader2 = this.f17197V;
                    viewOnLayoutChangeListenerC0359o.f1184q = resolveInfo;
                    viewOnLayoutChangeListenerC0359o.f1181n.setText(resolveInfo.loadLabel(packageManager));
                    viewOnLayoutChangeListenerC0359o.f1182o.setText(String.format(str, 1, 1));
                    viewOnLayoutChangeListenerC0359o.f1185r = widgetPreviewLoader2;
                }
                viewOnLayoutChangeListenerC0359o.m902a();
                c6 = 0;
                viewOnLayoutChangeListenerC0359o.setVisibility(0);
                arrayList2.add(viewOnLayoutChangeListenerC0359o);
            }
            viewOnLayoutChangeListenerC0359o.m902a();
            c6 = 0;
            viewOnLayoutChangeListenerC0359o.setVisibility(0);
            arrayList2.add(viewOnLayoutChangeListenerC0359o);
        }
        this.f17195T.setAdapter(new C0545d(arrayList2));
    }
}
