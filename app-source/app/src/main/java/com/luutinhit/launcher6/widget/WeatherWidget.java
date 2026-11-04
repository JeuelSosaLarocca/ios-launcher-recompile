package com.luutinhit.launcher6.widget;

import B3.AbstractC0075r;
import B3.C0056Y;
import B3.RunnableC0054W;
import G3.C0357m;
import G3.RunnableC0354j;
import J3.AbstractC0543b;
import K0.AbstractC0577y;
import O3.AbstractC0744e;
import Z1.C1291i;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.LocationRequest;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import com.luutinhit.weather.WeatherActivity;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.Hourly;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import com.luutinhit.weather.network.OpenWeather;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import p003D.C0157a;
import p050a2.C1327e;
import p050a2.InterfaceC1324b;
import p088i4.C2206k;
import p105m4.EnumC2410h;
import p105m4.InterfaceC2415m;
import p121r2.AbstractC2649a;
import p121r2.C2650b;
import p121r2.C2654f;
import p139v2.C2865j;
import s5.AbstractC2752b;

/* JADX INFO: loaded from: classes.dex */
public class WeatherWidget extends AbstractC0543b implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener, InterfaceC2415m {

    /* JADX INFO: renamed from: K */
    public static final /* synthetic */ int f17137K = 0;

    /* JADX INFO: renamed from: A */
    public boolean f17138A;

    /* JADX INFO: renamed from: B */
    public boolean f17139B;

    /* JADX INFO: renamed from: C */
    public int f17140C;

    /* JADX INFO: renamed from: D */
    public C0056Y f17141D;

    /* JADX INFO: renamed from: E */
    public OpenWeather f17142E;

    /* JADX INFO: renamed from: F */
    public LocationManager f17143F;

    /* JADX INFO: renamed from: G */
    public int f17144G;

    /* JADX INFO: renamed from: H */
    public long f17145H;

    /* JADX INFO: renamed from: I */
    public int f17146I;

    /* JADX INFO: renamed from: J */
    public boolean f17147J;

    /* JADX INFO: renamed from: n */
    public Context f17148n;

    /* JADX INFO: renamed from: o */
    public View f17149o;

    /* JADX INFO: renamed from: p */
    public TextView f17150p;

    /* JADX INFO: renamed from: q */
    public TextView f17151q;

    /* JADX INFO: renamed from: r */
    public TextView f17152r;

    /* JADX INFO: renamed from: s */
    public TextView f17153s;

    /* JADX INFO: renamed from: t */
    public ImageView f17154t;

    /* JADX INFO: renamed from: u */
    public RecyclerView f17155u;

    /* JADX INFO: renamed from: v */
    public ConstraintLayout f17156v;

    /* JADX INFO: renamed from: w */
    public LinearLayout f17157w;

    /* JADX INFO: renamed from: x */
    public TextViewCustomFont f17158x;

    /* JADX INFO: renamed from: y */
    public C2206k f17159y;

    /* JADX INFO: renamed from: z */
    public boolean f17160z;

    public WeatherWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17160z = false;
        this.f17138A = false;
        this.f17139B = true;
        this.f17140C = 0;
        this.f17142E = OpenWeather.getInstance(5000, true);
        this.f17144G = 3600000;
        this.f17145H = 0L;
        this.f17148n = context;
        this.f17149o = LayoutInflater.from(context).inflate(R.layout.weather_widget, (ViewGroup) this, true);
        if (context instanceof Launcher) {
            Launcher launcher = (Launcher) context;
            this.f17141D = launcher.getTinyDB();
            this.f17146I = (int) (((double) launcher.getDeviceProfile().f15977C) * 0.68d);
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2234E);
            this.f17147J = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f17141D.m140j(this);
        this.f17160z = false;
        this.f17139B = m8233G("preference_unit") == 1;
        this.f17144G = m8233G("preference_auto_refresh") * 3600000;
        this.f17143F = (LocationManager) this.f17148n.getSystemService("location");
        this.f17150p = (TextView) this.f17149o.findViewById(R.id.current_temperature);
        this.f17151q = (TextView) this.f17149o.findViewById(R.id.temperature_range);
        this.f17152r = (TextView) this.f17149o.findViewById(R.id.city_name);
        this.f17153s = (TextView) this.f17149o.findViewById(R.id.weather_state);
        this.f17154t = (ImageView) this.f17149o.findViewById(R.id.weather_icon);
        this.f17155u = (RecyclerView) this.f17149o.findViewById(R.id.forecast_list);
        this.f17156v = (ConstraintLayout) this.f17149o.findViewById(R.id.weather_info);
        this.f17157w = (LinearLayout) this.f17149o.findViewById(R.id.request_location_permission);
        this.f17158x = (TextViewCustomFont) this.f17149o.findViewById(R.id.button_request_location_permission);
        this.f17155u.setLayoutManager(new GridLayoutManager(6, 0));
        RecyclerView recyclerView = this.f17155u;
        C2206k c2206k = new C2206k(this.f17148n);
        this.f17159y = c2206k;
        recyclerView.setAdapter(c2206k);
        setOnClickListener(this);
        this.f17158x.setOnClickListener(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX INFO: renamed from: H */
    public static int m8232H(int i6, String str) {
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
        if (AbstractC0075r.m194o(this.f17148n)) {
            this.f17145H = System.currentTimeMillis();
            EnumC2410h enumC2410h = this.f17139B ? EnumC2410h.f19711k : EnumC2410h.f19710j;
            OpenWeather openWeather = this.f17142E;
            openWeather.setUnit(enumC2410h);
            openWeather.queryWeatherByGPS(this.f17148n, this);
        }
    }

    public void setListHourlyForecast(List<Hourly> list) {
        if (list != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", AbstractC2752b.m9849i(getResources().getConfiguration()).f1788a.get());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int iMin = Math.min(list.size(), 6);
            for (int i6 = 0; i6 < iMin; i6++) {
                Hourly hourly = list.get(i6);
                C0357m c0357m = new C0357m();
                String str = simpleDateFormat.format(Long.valueOf(hourly.getDt()));
                c0357m.f1170a = str;
                arrayList2.add(str);
                int temp = hourly.getMain().getTemp();
                StringBuilder sb = new StringBuilder();
                sb.append(temp);
                sb.append((char) 176);
                String string = sb.toString();
                c0357m.f1171b = string;
                arrayList3.add(string);
                int iM8232H = m8232H(hourly.getWeather().get(0).getId(), hourly.getWeather().get(0).getIcon());
                c0357m.f1172c = iM8232H;
                arrayList4.add(Integer.valueOf(iM8232H));
                arrayList.add(c0357m);
            }
            postOnAnimation(new RunnableC0054W(4, this, arrayList));
            this.f17141D.m139i("daily_weather_day", arrayList2);
            this.f17141D.m139i("daily_weather_temp_low", arrayList3);
            this.f17141D.m137g(arrayList4);
        }
    }

    @Override // J3.AbstractC0544c
    /* JADX INFO: renamed from: A */
    public final void mo1297A() {
        m8234I();
        boolean zM8234I = m8234I();
        if (this.f17140C < 2 || zM8234I) {
            m8235J();
            return;
        }
        OpenWeather openWeather = this.f17142E;
        try {
            if (this.f17160z && System.currentTimeMillis() - this.f17145H < this.f17144G) {
                return;
            }
            if (this.f17141D.m132b("current_lat_location") != 0.0d || this.f17141D.m132b("current_lon_location") != 0.0d) {
                this.f17145H = System.currentTimeMillis();
            }
            openWeather.setUnit(this.f17139B ? EnumC2410h.f19711k : EnumC2410h.f19710j);
            openWeather.queryWeatherByGPS(this.f17148n, this);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: G */
    public final int m8233G(String str) {
        try {
            return Integer.parseInt(this.f17141D.f137a.getString(str, "1"));
        } catch (Throwable th) {
            th.getMessage();
            return 1;
        }
    }

    /* JADX INFO: renamed from: I */
    public final boolean m8234I() {
        this.f17143F.isProviderEnabled("network");
        this.f17143F.isProviderEnabled("gps");
        this.f17143F.isProviderEnabled("passive");
        LocationManager locationManager = this.f17143F;
        if (locationManager != null) {
            return locationManager.isProviderEnabled("gps") || this.f17143F.isProviderEnabled("network");
        }
        return false;
    }

    /* JADX INFO: renamed from: J */
    public final void m8235J() {
        if (!AbstractC0075r.m194o(this.f17148n)) {
            this.f17157w.setVisibility(0);
            this.f17156v.setVisibility(4);
            return;
        }
        this.f17157w.setVisibility(8);
        this.f17156v.setVisibility(0);
        if (!AbstractC0577y.m1345v(this.f17148n) || (this.f17160z && System.currentTimeMillis() - this.f17145H < this.f17144G)) {
            m8236K();
            return;
        }
        if (m8234I()) {
            if (!this.f17160z || System.currentTimeMillis() - this.f17145H >= this.f17144G) {
                getOpenWeather();
                return;
            }
            return;
        }
        this.f17140C++;
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.f14926r = true;
        locationRequest.m7396b();
        LocationRequest.m7395c(5000L);
        locationRequest.f14921m = true;
        locationRequest.f14920l = 5000L;
        locationRequest.f14918j = 104;
        ArrayList arrayList = new ArrayList();
        arrayList.add(locationRequest);
        Launcher launcher = (Launcher) this.f17148n;
        C2865j c2865jM9636d = new C2654f(launcher, launcher, AbstractC2649a.f20636a, InterfaceC1324b.f3813a, C1327e.f3815b).m9636d(new C2650b(arrayList, false, false, null));
        c2865jM9636d.m10007b((Launcher) this.f17148n, new C1291i(2));
        c2865jM9636d.m10006a((Launcher) this.f17148n, new C0157a(3, this));
    }

    /* JADX INFO: renamed from: K */
    public final void m8236K() {
        try {
            this.f17153s.setText(this.f17141D.m135e("weather_state"));
            this.f17154t.setImageResource(this.f17141D.f137a.getInt("current_drawable_id", R.drawable.ic_partly_sunny));
            this.f17150p.setText(this.f17141D.f137a.getString("current_temp", "N/A"));
            if (TextUtils.isEmpty(this.f17141D.m135e("city"))) {
                return;
            }
            this.f17152r.setText(this.f17141D.f137a.getString("city", "N/A"));
            this.f17151q.setText("H:" + this.f17141D.m135e("current_temp_high") + " L:" + this.f17141D.m135e("current_temp_low"));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: h */
    public final void mo2127h(HourlyResponse hourlyResponse) {
        List<Hourly> list;
        if (hourlyResponse == null || (list = hourlyResponse.getList()) == null || list.isEmpty()) {
            return;
        }
        setListHourlyForecast(list);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        View viewFindViewById = findViewById(R.id.icon_delete_widget);
        int i6 = -((Launcher) this.f17148n).getDeviceProfile().f15975A;
        viewFindViewById.setTranslationX(((Launcher) this.f17148n).isRTL ? -i6 : i6);
        viewFindViewById.setTranslationY(i6);
        C1416d c1416d = (C1416d) this.f17156v.getLayoutParams();
        if (this.f17147J) {
            int dimensionPixelSize = this.f17148n.getResources().getDimensionPixelSize(R.dimen.widget_margin_start_end);
            float dimensionPixelSize2 = this.f17148n.getResources().getDimensionPixelSize(R.dimen.widget_elevation_shadow);
            this.f17156v.setElevation(dimensionPixelSize2);
            this.f17157w.setElevation(dimensionPixelSize2);
            c1416d.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
            ((C1416d) this.f17157w.getLayoutParams()).setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        } else {
            int i7 = this.f17146I;
            c1416d.setMargins(i7, i7, i7, i7);
            C1416d c1416d2 = (C1416d) this.f17157w.getLayoutParams();
            int i8 = this.f17146I;
            c1416d2.setMargins(i8, i8, i8, i8);
        }
        ConstraintLayout constraintLayout = this.f17156v;
        int i9 = Calendar.getInstance().get(11);
        boolean z5 = i9 <= 6 || i9 >= 18;
        int i10 = R.drawable.weather_background_default_round;
        constraintLayout.setBackgroundResource(z5 ? R.drawable.weather_background_clear_night_round : R.drawable.weather_background_default_round);
        LinearLayout linearLayout = this.f17157w;
        int i11 = Calendar.getInstance().get(11);
        if (i11 <= 6 || i11 >= 18) {
            i10 = R.drawable.weather_background_clear_night_round;
        }
        linearLayout.setBackgroundResource(i10);
        m8235J();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Objects.toString(view);
        int id = view.getId();
        if (id == R.id.weather_content) {
            Intent intent = new Intent(this.f17148n, (Class<?>) WeatherActivity.class);
            if (this.f17138A) {
                intent.putExtra("have_history", true);
            }
            intent.addFlags(268435456);
            this.f17148n.startActivity(intent);
            return;
        }
        if (id == R.id.button_request_location_permission) {
            Context context = this.f17148n;
            if (context instanceof Launcher) {
                AbstractC0075r.m196r((Launcher) context);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f17141D.f137a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null) {
            switch (str) {
                case "preference_unit":
                    this.f17139B = m8233G(str) == 1;
                    getOpenWeather();
                    break;
                case "city":
                case "current_temp":
                    m8236K();
                    break;
                case "preference_auto_refresh":
                    this.f17144G = m8233G(str) * 3600000;
                    break;
            }
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: t */
    public final void mo2136t(String str, CurrentResponse currentResponse, Throwable th) {
        try {
            try {
                postOnAnimation(new RunnableC0354j(this, currentResponse, th, str, 0));
            } catch (Throwable th2) {
                th = th2;
                th.getMessage();
            }
        } catch (Throwable th3) {
            throw com.luutinhit.launcher6.JadxSupport.sneaky(th3);
        }
    }

    @Override // p105m4.InterfaceC2415m
    /* JADX INFO: renamed from: v */
    public final void mo2138v(DailyResponse dailyResponse) {
        postOnAnimation(new RunnableC0054W(3, this, dailyResponse));
    }
}
