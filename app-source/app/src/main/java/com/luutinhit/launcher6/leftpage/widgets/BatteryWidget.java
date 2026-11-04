package com.luutinhit.launcher6.leftpage.widgets;

import H3.C0427i;
import I3.C0464a;
import J3.AbstractC0543b;
import J3.C0548g;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C1416d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.SyntheticHelpers;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcherios.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p055b2.RunnableC1584s;
import p127s4.InterfaceC2749b;

/* JADX INFO: loaded from: classes.dex */
public class BatteryWidget extends AbstractC0543b {

    /* JADX INFO: renamed from: w */
    public static final /* synthetic */ int f16665w = 0;

    /* JADX INFO: renamed from: n */
    public Context f16666n;

    /* JADX INFO: renamed from: o */
    public View f16667o;

    /* JADX INFO: renamed from: p */
    public RecyclerView f16668p;

    /* JADX INFO: renamed from: q */
    public C0427i f16669q;

    /* JADX INFO: renamed from: r */
    public ArrayList f16670r;

    /* JADX INFO: renamed from: s */
    public InterfaceC2749b f16671s;

    /* JADX INFO: renamed from: t */
    public Handler f16672t;

    /* JADX INFO: renamed from: u */
    public RunnableC1584s f16673u;

    /* JADX INFO: renamed from: v */
    public int f16674v;

    public BatteryWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16670r = new ArrayList();
        this.f16672t = new Handler();
        this.f16673u = new RunnableC1584s(17, this);
        this.f16666n = context;
        this.f16674v = (int) (((double) ((Launcher) context).getDeviceProfile().f15977C) * 0.8d);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.battery_widget, (ViewGroup) this, true);
        this.f16667o = viewInflate;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.list_devices);
        this.f16668p = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView2 = this.f16668p;
        C0548g c0548g = new C0548g();
        c0548g.f1687j = context.getResources().getDrawable(R.drawable.divider);
        c0548g.f1688k = Utilities.isRtl(context.getResources());
        c0548g.f1689l = context.getResources().getDimensionPixelSize(R.dimen.divider_margin);
        recyclerView2.m3419l(c0548g);
        boolean zM1295D = m1295D();
        C0427i c0427i = new C0427i();
        c0427i.f1349n = zM1295D;
        this.f16669q = c0427i;
        this.f16668p.setAdapter(c0427i);
    }

    /* JADX INFO: renamed from: G */
    public static /* synthetic */ List m8138G(BatteryWidget batteryWidget) {
        Thread.currentThread().getName();
        return batteryWidget.getBatteries();
    }

    /* JADX INFO: renamed from: H */
    public static int m8139H(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("getBatteryLevel", null);
            method.setAccessible(true);
            return ((Integer) method.invoke(bluetoothDevice, null)).intValue();
        } catch (Throwable unused) {
            return 100;
        }
    }

    public List<C0464a> getBatteries() {
        if (this.f16670r == null) {
            this.f16670r = new ArrayList();
        }
        this.f16670r.clear();
        C0464a currentPhoneItem = getCurrentPhoneItem();
        if (currentPhoneItem != null) {
            this.f16670r.add(currentPhoneItem);
        }
        if (Utilities.f16755p) {
            Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
            bondedDevices.size();
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                if (bluetoothDevice != null && bluetoothDevice.getName() != null) {
                    bluetoothDevice.getName();
                    m8139H(bluetoothDevice);
                    C0464a c0464a = new C0464a();
                    c0464a.f1480a = this.f16666n.getDrawable(R.drawable.ic_bluetooth);
                    c0464a.f1481b = bluetoothDevice.getName();
                    int iM8139H = m8139H(bluetoothDevice);
                    if (iM8139H >= 0) {
                        c0464a.f1482c = SyntheticHelpers.m7913l(String.valueOf(iM8139H), "%");
                        c0464a.f1483d = m8140I(iM8139H, false);
                        this.f16670r.add(c0464a);
                    }
                }
            }
        }
        this.f16670r.size();
        return this.f16670r;
    }

    public C0464a getCurrentPhoneItem() {
        try {
            C0464a c0464a = new C0464a();
            c0464a.f1480a = this.f16666n.getDrawable(R.drawable.ic_phone);
            c0464a.f1481b = "iPhone";
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            Intent intentRegisterReceiver = Utilities.f16749j ? this.f16666n.registerReceiver(null, intentFilter, 2) : this.f16666n.registerReceiver(null, intentFilter);
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
            boolean z5 = intExtra == 2 || intExtra == 5;
            int intExtra2 = (int) (((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : -1) / (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1)) * 100.0f);
            c0464a.f1482c = intExtra2 + "%";
            c0464a.f1483d = m8140I(intExtra2, z5);
            return c0464a;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        Handler handler = this.f16672t;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.f16673u, 2000L);
    }

    /* JADX INFO: renamed from: I */
    public final Drawable m8140I(int i6, boolean z5) {
        if (z5) {
            if (i6 <= 5) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_0);
            }
            if (i6 <= 10) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_10);
            }
            if (i6 <= 20) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_20);
            }
            if (i6 <= 30) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_30);
            }
            if (i6 <= 40) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_40);
            }
            if (i6 <= 50) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_50);
            }
            if (i6 <= 60) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_60);
            }
            if (i6 <= 70) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_70);
            }
            if (i6 <= 80) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_80);
            }
            if (i6 <= 90) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_90);
            }
            if (i6 <= 100) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_charging_100);
            }
        } else {
            if (i6 <= 5) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_0);
            }
            if (i6 <= 10) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_10);
            }
            if (i6 <= 20) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_20);
            }
            if (i6 <= 30) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_30);
            }
            if (i6 <= 40) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_40);
            }
            if (i6 <= 50) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_50);
            }
            if (i6 <= 60) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_60);
            }
            if (i6 <= 70) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_70);
            }
            if (i6 <= 80) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_80);
            }
            if (i6 <= 90) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_90);
            }
            if (i6 <= 100) {
                return this.f16666n.getDrawable(R.drawable.ic_battery_100);
            }
        }
        return this.f16666n.getDrawable(R.drawable.ic_battery_100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f16666n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f16666n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.battery_widget_content);
        C1416d c1416d = (C1416d) linearLayoutRound.getLayoutParams();
        int i7 = this.f16674v;
        c1416d.setMargins(i7, i7, i7, i7);
        linearLayoutRound.setDarkModeBackgroundColor(m1295D() ? getResources().getColor(R.color.folder_color_dark) : getResources().getColor(R.color.folder_color));
        Handler handler = this.f16672t;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(this.f16673u, 2000L);
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: y */
    public final void mo1298y() {
        InterfaceC2749b interfaceC2749b = this.f16671s;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
    }
}
