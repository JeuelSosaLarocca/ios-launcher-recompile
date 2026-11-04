package com.luutinhit.launcher6.widget;

import B3.AbstractC0075r;
import B3.C0056Y;
import B3.RunnableC0054W;
import B3.RunnableC0064g;
import G3.RunnableC0358n;
import J0.C0489j;
import J3.AbstractC0543b;
import K0.AbstractC0577y;
import T2.C1043e;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.C1416d;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.location.LocationRequest;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import p050a2.C1327e;
import p050a2.InterfaceC1324b;
import p105m4.EnumC2410h;
import p105m4.InterfaceC2415m;
import p121r2.AbstractC2649a;
import p121r2.C2650b;
import p121r2.C2654f;
import p139v2.C2865j;

/* JADX INFO: loaded from: classes.dex */
public class WeatherWidget_2x2 extends AbstractC0543b implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, InterfaceC2415m {

    /* JADX INFO: renamed from: H */
    public static final /* synthetic */ int f17161H = 0;

    /* JADX INFO: renamed from: A */
    public int f17162A;

    /* JADX INFO: renamed from: B */
    public C0056Y f17163B;

    /* JADX INFO: renamed from: C */
    public OpenWeather f17164C;

    /* JADX INFO: renamed from: D */
    public LocationManager f17165D;

    /* JADX INFO: renamed from: E */
    public int f17166E;

    /* JADX INFO: renamed from: F */
    public long f17167F;

    /* JADX INFO: renamed from: G */
    public int f17168G;

    /* JADX INFO: renamed from: n */
    public Context f17169n;

    /* JADX INFO: renamed from: o */
    public View f17170o;

    /* JADX INFO: renamed from: p */
    public TextView f17171p;

    /* JADX INFO: renamed from: q */
    public TextView f17172q;

    /* JADX INFO: renamed from: r */
    public TextView f17173r;

    /* JADX INFO: renamed from: s */
    public TextView f17174s;

    /* JADX INFO: renamed from: t */
    public ImageView f17175t;

    /* JADX INFO: renamed from: u */
    public ConstraintLayout f17176u;

    /* JADX INFO: renamed from: v */
    public LinearLayout f17177v;

    /* JADX INFO: renamed from: w */
    public TextViewCustomFont f17178w;

    /* JADX INFO: renamed from: x */
    public boolean f17179x;

    /* JADX INFO: renamed from: y */
    public boolean f17180y;

    /* JADX INFO: renamed from: z */
    public boolean f17181z;

    public WeatherWidget_2x2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17179x = false;
        this.f17180y = false;
        this.f17181z = true;
        this.f17162A = 0;
        this.f17164C = OpenWeather.getInstance(5000, true);
        this.f17166E = 3600000;
        this.f17167F = 0L;
        this.f17169n = context;
        this.f17170o = LayoutInflater.from(context).inflate(R.layout.weather_widget_2x2, (ViewGroup) this, true);
        if (context instanceof Launcher) {
            Launcher launcher = (Launcher) context;
            this.f17163B = launcher.getTinyDB();
            this.f17168G = (int) (((double) launcher.getDeviceProfile().f15977C) * 0.68d);
        }
        this.f17163B.m140j(this);
        this.f17179x = false;
        this.f17181z = m8238G("preference_unit") == 1;
        this.f17166E = m8238G("preference_auto_refresh") * 3600000;
        this.f17165D = (LocationManager) this.f17169n.getSystemService("location");
        this.f17171p = (TextView) this.f17170o.findViewById(R.id.current_temperature);
        this.f17172q = (TextView) this.f17170o.findViewById(R.id.temperature_range);
        this.f17173r = (TextView) this.f17170o.findViewById(R.id.city_name);
        this.f17174s = (TextView) this.f17170o.findViewById(R.id.weather_state);
        this.f17175t = (ImageView) this.f17170o.findViewById(R.id.weather_icon);
        this.f17176u = (ConstraintLayout) this.f17170o.findViewById(R.id.weather_info);
        this.f17177v = (LinearLayout) this.f17170o.findViewById(R.id.request_location_permission);
        this.f17178w = (TextViewCustomFont) this.f17170o.findViewById(R.id.button_request_location_permission);
        setOnClickListener(this);
        this.f17178w.setOnClickListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX INFO: renamed from: H */
    public static int m8237H(int i6, String str) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        byte b4;
        switch (i6) {
            case 36:
                return R.drawable.ic_hot;
            case 200:
            case 201:
            case 202:
            case 210:
            case 211:
            case 221:
            case 230:
            case 231:
                return R.drawable.ic_thunderstorm;
            case 212:
            case 232:
                return R.drawable.ic_hurricane;
            case Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT /* 300 */:
            case 301:
            case 302:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 321:
                return R.drawable.ic_drizzle;
            case 500:
            case 501:
                return R.drawable.ic_weather_rain;
            case 502:
            case 503:
            case 504:
                return R.drawable.ic_heavy_rain;
            case 511:
                return R.drawable.ic_frigid_temps;
            case 520:
            case 521:
            case 522:
            case 531:
            case 771:
                return R.drawable.ic_hail;
            case 600:
            case 601:
            case 602:
                return R.drawable.ic_blowing_snow;
            case 611:
            case 612:
            case 613:
                return R.drawable.ic_snow_sleet;
            case 615:
            case 616:
                return R.drawable.ic_snow;
            case 620:
            case 621:
            case 622:
                return R.drawable.ic_scattered_snow;
            case 701:
            case 741:
                return R.drawable.ic_fog;
            case 711:
                return R.drawable.ic_weather_smoke;
            case 721:
            case 762:
                return R.drawable.ic_haze;
            case 731:
            case 761:
                return R.drawable.ic_dust;
            case 751:
                return R.drawable.ic_wind;
            case 781:
                return R.drawable.ic_tornado;
            case 800:
            case 801:
            case 802:
            case 803:
            case 804:
                switch (str) {
                    case "01d":
                        b4 = 0;
                        break;
                    case "01n":
                        b4 = 1;
                        break;
                    case "02d":
                        b4 = 2;
                        break;
                    case "02n":
                        b4 = 3;
                        break;
                    case "03d":
                        b4 = 4;
                        break;
                    case "03n":
                        b4 = 5;
                        break;
                    case "04d":
                        b4 = 6;
                        break;
                    case "04n":
                        b4 = 7;
                        break;
                    default:
                        b4 = -1;
                        break;
                }
                if (b4 == 0) {
                    return R.drawable.ic_sunny;
                }
                if (b4 == 1) {
                    return R.drawable.ic_clear_night;
                }
                if (b4 != 2) {
                    return b4 != 3 ? R.drawable.ic_cloudy : R.drawable.ic_partly_cloudy_night;
                }
                return R.drawable.ic_partly_sunny;
            default:
                return R.drawable.ic_cloudy;
        }
    }

    public void getOpenWeather() {
        if (AbstractC0075r.m194o(this.f17169n)) {
            this.f17167F = System.currentTimeMillis();
            EnumC2410h enumC2410h = this.f17181z ? EnumC2410h.f19711k : EnumC2410h.f19710j;
            OpenWeather openWeather = this.f17164C;
            openWeather.setUnit(enumC2410h);
            openWeather.queryWeatherByGPS(this.f17169n, this);
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        m8239I();
        boolean zM8239I = m8239I();
        if (this.f17162A < 2 || zM8239I) {
            m8240J();
            return;
        }
        OpenWeather openWeather = this.f17164C;
        try {
            if (this.f17179x && System.currentTimeMillis() - this.f17167F < this.f17166E) {
                return;
            }
            if (this.f17163B.m132b("current_lat_location") != 0.0d || this.f17163B.m132b("current_lon_location") != 0.0d) {
                this.f17167F = System.currentTimeMillis();
            }
            openWeather.setUnit(this.f17181z ? EnumC2410h.f19711k : EnumC2410h.f19710j);
            openWeather.queryWeatherByGPS(this.f17169n, this);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: G */
    public final int m8238G(String str) {
        try {
            return Integer.parseInt(this.f17163B.f137a.getString(str, "1"));
        } catch (Throwable th) {
            th.getMessage();
            return 1;
        }
    }

    /* JADX INFO: renamed from: I */
    public final boolean m8239I() {
        this.f17165D.isProviderEnabled("network");
        this.f17165D.isProviderEnabled("gps");
        this.f17165D.isProviderEnabled("passive");
        LocationManager locationManager = this.f17165D;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps") || this.f17165D.isProviderEnabled("network");
        }
        return false;
    }

    /* JADX INFO: renamed from: J */
    public final void m8240J() {
        if (!AbstractC0075r.m194o(this.f17169n)) {
            this.f17177v.setVisibility(0);
            this.f17176u.setVisibility(4);
            return;
        }
        this.f17177v.setVisibility(8);
        this.f17176u.setVisibility(0);
        if (!AbstractC0577y.m1345v(this.f17169n) || (this.f17179x && System.currentTimeMillis() - this.f17167F < this.f17166E)) {
            m8241K();
            return;
        }
        if (m8239I()) {
            if (!this.f17179x || System.currentTimeMillis() - this.f17167F >= this.f17166E) {
                getOpenWeather();
                return;
            }
            return;
        }
        this.f17162A++;
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.f14926r = true;
        locationRequest.m7396b();
        LocationRequest.m7395c(5000L);
        locationRequest.f14921m = true;
        locationRequest.f14920l = 5000L;
        locationRequest.f14918j = 104;
        ArrayList arrayList = new ArrayList();
        arrayList.add(locationRequest);
        Launcher launcher = (Launcher) this.f17169n;
        C2865j c2865jM9636d = new C2654f(launcher, launcher, AbstractC2649a.f20636a, InterfaceC1324b.f3813a, C1327e.f3815b).m9636d(new C2650b(arrayList, false, false, null));
        c2865jM9636d.m10007b((Launcher) this.f17169n, new C1043e());
        c2865jM9636d.m10006a((Launcher) this.f17169n, new C0489j(5, this));
    }

    /* JADX INFO: renamed from: K */
    public final void m8241K() {
        try {
            this.f17174s.setText(this.f17163B.m135e("weather_state"));
            this.f17175t.setImageResource(this.f17163B.f137a.getInt("current_drawable_id", R.drawable.ic_partly_sunny));
            this.f17171p.setText(this.f17163B.f137a.getString("current_temp", "N/A"));
            if (TextUtils.isEmpty(this.f17163B.m135e("city"))) {
                return;
            }
            this.f17173r.setText(this.f17163B.f137a.getString("city", "N/A"));
            this.f17172q.setText("H:" + this.f17163B.m135e("current_temp_high") + " L:" + this.f17163B.m135e("current_temp_low"));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f17169n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f17169n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
        C1416d c1416d = (C1416d) this.f17176u.getLayoutParams();
        int i7 = this.f17168G;
        c1416d.setMargins(i7, i7, i7, i7);
        ConstraintLayout constraintLayout = this.f17176u;
        int i8 = Calendar.getInstance().get(11);
        boolean z5 = i8 <= 6 || i8 >= 18;
        int i9 = R.drawable.weather_background_default_round;
        constraintLayout.setBackgroundResource(z5 ? R.drawable.weather_background_clear_night_round : R.drawable.weather_background_default_round);
        C1416d c1416d2 = (C1416d) this.f17177v.getLayoutParams();
        int i10 = this.f17168G;
        c1416d2.setMargins(i10, i10, i10, i10);
        LinearLayout linearLayout = this.f17177v;
        int i11 = Calendar.getInstance().get(11);
        if (i11 <= 6 || i11 >= 18) {
            i9 = R.drawable.weather_background_clear_night_round;
        }
        linearLayout.setBackgroundResource(i9);
        m8240J();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Objects.toString(view);
        int id = view.getId();
        if (id == R.id.weather_content) {
            Intent intent = new Intent(this.f17169n, (Class<?>) WeatherActivity.class);
            if (this.f17180y) {
                intent.putExtra("have_history", true);
            }
            intent.addFlags(268435456);
            this.f17169n.startActivity(intent);
            return;
        }
        if (id == R.id.button_request_location_permission) {
            Context context = this.f17169n;
            if (context instanceof Launcher) {
                AbstractC0075r.m196r((Launcher) context);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f17163B.f137a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i6);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "preference_unit":
                    this.f17181z = m8238G(str) == 1;
                    getOpenWeather();
                    break;
                case "city":
                case "current_temp":
                    m8241K();
                    break;
                case "preference_auto_refresh":
                    this.f17166E = m8238G(str) * 3600000;
                    break;
            }
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: t */
    public final void mo2136t(String str, CurrentResponse currentResponse, Throwable th) {
        try {
            if (currentResponse == null || th != null) {
                this.f17173r.postOnAnimation(new RunnableC0064g(5, this));
            } else {
                this.f17173r.postOnAnimation(new RunnableC0358n(this, str, currentResponse, 0));
            }
        } catch (Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: v */
    public final void mo2138v(DailyResponse dailyResponse) {
        postOnAnimation(new RunnableC0054W(5, this, dailyResponse));
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: h */
    public final void mo2127h(HourlyResponse hourlyResponse) {
    }
}
