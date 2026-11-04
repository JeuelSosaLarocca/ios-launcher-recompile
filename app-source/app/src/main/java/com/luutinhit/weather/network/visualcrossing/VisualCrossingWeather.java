package com.luutinhit.weather.network.visualcrossing;

import A4.RunnableC0026a;
import B3.C0056Y;
import E4.AbstractC0212f;
import I1.C0460k;
import K0.AbstractC0577y;
import T0.C1020c;
import T0.C1031n;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.android.gms.internal.ads.C3941pm;
import com.luutinhit.launcher6.SyntheticHelpers;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import com.luutinhit.weather.request.visualcrossing.VisualCrossingAPI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import p015Q.AbstractC0839e;
import p024a.AbstractC1314a;
import p044w.AbstractC2920f;
import p067e1.C1953k;
import p083h4.C2142j;
import p085i1.C2188y;
import p105m4.C2404b;
import p105m4.C2406d;
import p105m4.CallableC2405c;
import p105m4.EnumC2414l;
import p105m4.InterfaceC2413k;
import p108n4.EnumC2511a;
import p108n4.EnumC2512b;
import p108n4.InterfaceC2513c;
import p123r4.AbstractC2679b;
import p159z4.CallableC3080a;
import v5.InterfaceC2891c;
import w5.C2935a;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class VisualCrossingWeather implements InterfaceC2413k {
    public static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    public static final int FORECAST_INFO_MAX_SIZE = 10;
    public static final VisualCrossingWeather mInstance = new VisualCrossingWeather();
    public double lat;
    public double lon;
    public Context mContext;
    public C0056Y mTinyDB;
    public InterfaceC2513c mWeatherInfoResult;
    public String TAG = "VisualCrossingWeather";
    public EnumC2511a mErrorType = null;
    public int mConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    public EnumC2512b mUnit = EnumC2512b.f20224j;
    public List<String> mLanguageSupport = Arrays.asList("ar", "bg", "cs", "da", "de", "el", "en", "es", "fa", "fi", "fr", "he", "hu", "it", "ja", "ko", "nl", "pl", "pt", "ru", "sk", "sr", "sv", "tr", "uk", "vi", "zh");

    public static String addressToPlaceName(Address address) {
        String strM7913l = "";
        if (address.getLocality() != null) {
            strM7913l = SyntheticHelpers.m7913l("" + address.getLocality(), " ");
        }
        if (address.getAdminArea() != null) {
            StringBuilder sbM10112a = AbstractC2920f.m10112a(strM7913l);
            sbM10112a.append(address.getAdminArea());
            strM7913l = SyntheticHelpers.m7913l(sbM10112a.toString(), " ");
        }
        if (address.getCountryName() == null) {
            return strM7913l;
        }
        StringBuilder sbM10112a2 = AbstractC2920f.m10112a(strM7913l);
        sbM10112a2.append(address.getCountryName());
        return SyntheticHelpers.m7913l(sbM10112a2.toString(), " ");
    }

    public static VisualCrossingWeather getInstance() {
        getInstance(DEFAULT_CONNECTION_TIMEOUT);
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$requestAllWeatherInfo$1(Geocoder geocoder, double d6, double d7) throws IOException {
        return geocoder.getFromLocation(d6, d7, 1);
    }

    public static String read(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.openFileInput(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public void requestAllWeatherInfo(double d6, double d7) {
        try {
            Geocoder geocoder = new Geocoder(this.mContext, Locale.getDefault());
            if (Utilities.f16749j) {
                AbstractC0839e.m1884q(geocoder, d6, d7, new C2404b(this, d6, d7, 1));
                return;
            }
            try {
                new CallableC3080a(new CallableC2405c(geocoder, d6, d7, 1)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C2406d(this, d6, d7, 1), AbstractC2679b.m9681a(), 1));
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
            ((C2142j) this.mWeatherInfoResult).m8824U(null, null, th2);
        }
    }

    public void requestCurrentWeatherInfo(String str, double d6, double d7) {
        String language = this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en";
        if (isFileSaveOneHour(this.mContext, "current_visual_crossing_weather.json")) {
            ((C2142j) this.mWeatherInfoResult).m8824U(str, (VisualCrossingWeatherResponse) new C0460k(2).m1087d(VisualCrossingWeatherResponse.class, read(this.mContext, "current_visual_crossing_weather.json")), null);
            return;
        }
        this.mContext.getPackageName();
        String str2 = this.mUnit == EnumC2512b.f20224j ? "metric" : "imperial";
        C1020c c1020c = new C1020c(11, this, str);
        C2188y c2188y = new C2188y(9);
        c2188y.f18945k = c1020c;
        C1031n c1031n = new C1031n(12);
        c1031n.m2206b("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/");
        c1031n.m2205a(new C2935a(new C0460k(2)));
        InterfaceC2891c<VisualCrossingWeatherResponse> weatherData = ((VisualCrossingAPI) c1031n.m2208d().m639c(VisualCrossingAPI.class)).getWeatherData(d6, d7, str2, language, "2CAQ98KCZNT7S4J9TPPRB38V2");
        String str3 = weatherData.mo10066o().f18695a.f18638i;
        weatherData.mo10065e(new C1953k(11, c2188y));
    }

    public static int turnCtoF(int i6) {
        return (int) (((i6 * 9.0f) / 5.0f) + 32.0f);
    }

    public static int turnFtoC(int i6) {
        return (int) (((i6 - 32) * 5.0f) / 9.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean write(Context context, String str, String str2) {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
            if (str2 != null) {
                fileOutputStreamOpenFileOutput.write(str2.getBytes());
            }
            fileOutputStreamOpenFileOutput.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public EnumC2512b getUnit() {
        return this.mUnit;
    }

    @Override // p105m4.InterfaceC2413k
    public void gotLocation(Location location, EnumC2414l enumC2414l) {
        try {
            Objects.toString(location);
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                C0056Y c0056y = this.mTinyDB;
                c0056y.getClass();
                c0056y.m138h("current_lat_location", String.valueOf(latitude));
                C0056Y c0056y2 = this.mTinyDB;
                c0056y2.getClass();
                c0056y2.m138h("current_lon_location", String.valueOf(longitude));
                requestAllWeatherInfo(latitude, longitude);
                return;
            }
            if (enumC2414l == EnumC2414l.f19716j || enumC2414l == EnumC2414l.f19717k) {
                this.mErrorType = EnumC2511a.f20222l;
            } else {
                this.mErrorType = EnumC2511a.f20221k;
            }
            double dM132b = this.mTinyDB.m132b("current_lat_location");
            double dM132b2 = this.mTinyDB.m132b("current_lon_location");
            if (dM132b == this.lat || dM132b2 == this.lon) {
                return;
            }
            if (dM132b == 0.0d && dM132b2 == 0.0d) {
                return;
            }
            requestAllWeatherInfo(dM132b, dM132b2);
        } catch (Throwable th) {
            ((C2142j) this.mWeatherInfoResult).m8824U(null, null, th);
        }
    }

    public boolean isFilePresent(Context context, String str) {
        return new File(context.getFilesDir().getAbsolutePath() + "/" + str).exists();
    }

    public boolean isFileSaveOneHour(Context context, String str) {
        File file = new File(context.getFilesDir().getAbsolutePath() + "/" + str);
        return file.exists() && ((int) ((System.currentTimeMillis() - file.lastModified()) / 3600000)) < 1;
    }

    public boolean needRequestWeatherInfo(String str, String str2, String str3, String str4) {
        try {
            if (!isFilePresent(this.mContext, str)) {
                return true;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            String str5 = simpleDateFormat.format(calendar.getTime());
            calendar.setTimeInMillis(new File(this.mContext.getFilesDir().getAbsolutePath(), str).lastModified());
            if (!str5.equals(simpleDateFormat.format(calendar.getTime()))) {
                return true;
            }
            if (str2 != null && TextUtils.equals(str2, this.mTinyDB.m135e("current_locality"))) {
                return false;
            }
            if (str3 != null && TextUtils.equals(str3, this.mTinyDB.m135e("current_subcity"))) {
                return false;
            }
            if (str4 != null && TextUtils.equals(str4, this.mTinyDB.m135e("current_city"))) {
                return false;
            }
            if (str2 != null) {
                this.mTinyDB.m138h("current_locality", str2);
            }
            if (str3 != null) {
                this.mTinyDB.m138h("current_subcity", str3);
            }
            if (str4 == null) {
                return true;
            }
            this.mTinyDB.m138h("current_city", str4);
            return true;
        } catch (Throwable th) {
            th.getMessage();
            return true;
        }
    }

    public void queryWeatherByGPS(Context context, InterfaceC2513c interfaceC2513c) {
        if (!AbstractC0577y.m1345v(context)) {
            this.mErrorType = EnumC2511a.f20220j;
            return;
        }
        this.mContext = context;
        this.mTinyDB = new C0056Y(context);
        this.mWeatherInfoResult = interfaceC2513c;
        new C3941pm().m6670a(context, this);
    }

    public void setUnit(EnumC2512b enumC2512b) {
        this.mUnit = enumC2512b;
    }

    public static VisualCrossingWeather getInstance(int i6) {
        return getInstance(i6, false);
    }

    public static VisualCrossingWeather getInstance(int i6, boolean z5) {
        VisualCrossingWeather visualCrossingWeather = mInstance;
        visualCrossingWeather.mConnectionTimeout = i6;
        return visualCrossingWeather;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestAllWeatherInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$requestAllWeatherInfo$0(List<Address> list, double d6, double d7) {
        VisualCrossingWeather visualCrossingWeather;
        double d8;
        double d9;
        String str;
        if (list == null || list.size() <= 0) {
            return;
        }
        String locality = list.get(0).getLocality();
        String subAdminArea = list.get(0).getSubAdminArea();
        String adminArea = list.get(0).getAdminArea();
        list.get(0).getCountryName();
        if (TextUtils.isEmpty(locality)) {
            visualCrossingWeather = this;
            d8 = d6;
            d9 = d7;
            str = TextUtils.isEmpty(subAdminArea) ? adminArea : subAdminArea;
        } else {
            visualCrossingWeather = this;
            d8 = d6;
            d9 = d7;
            str = locality;
        }
        visualCrossingWeather.requestCurrentWeatherInfo(str, d8, d9);
    }
}
