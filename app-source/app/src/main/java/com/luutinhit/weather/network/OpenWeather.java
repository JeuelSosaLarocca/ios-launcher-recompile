package com.luutinhit.weather.network;

import A4.RunnableC0026a;
import B3.C0056Y;
import E4.AbstractC0212f;
import G3.RunnableC0358n;
import I1.C0460k;
import K0.AbstractC0577y;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.android.gms.internal.ads.C3941pm;
import com.luutinhit.launcher6.SyntheticHelpers;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
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
import o4.C2536a;
import p024a.AbstractC1314a;
import p044w.AbstractC2920f;
import p105m4.C2404b;
import p105m4.C2406d;
import p105m4.C2407e;
import p105m4.C2408f;
import p105m4.CallableC2405c;
import p105m4.EnumC2409g;
import p105m4.EnumC2410h;
import p105m4.EnumC2414l;
import p105m4.InterfaceC2413k;
import p105m4.InterfaceC2415m;
import p105m4.RunnableC2403a;
import p123r4.AbstractC2679b;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class OpenWeather implements InterfaceC2413k {
    public static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    public static final int FORECAST_INFO_MAX_SIZE = 10;
    public static final OpenWeather mInstance = new OpenWeather();
    public double lat;
    public double lon;
    public Context mContext;
    public C0056Y mTinyDB;
    public InterfaceC2415m mWeatherInfoResult;
    public String TAG = "OpenWeather";
    public EnumC2409g mErrorType = null;
    public int mConnectionTimeout = DEFAULT_CONNECTION_TIMEOUT;
    public EnumC2410h mUnit = EnumC2410h.f19711k;
    public List<String> mLanguageSupport = Arrays.asList("af", "al", "ar", "az", "bg", "ca", "cz", "da", "de", "el", "en", "eu", "fa", "fi", "fr", "gl", "he", "hi", "hr", "hu", "id", "it", "ja", "kr", "la", "lt", "mk", "no", "nl", "pl", "pt", "pt_br", "ro", "ru", "sv", "se", "sk", "sl", "sp", "es", "sr", "th", "tr", "ua", "uk", "vi", "zh_cn", "zh_tw", "zu");

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

    public static OpenWeather getInstance() {
        getInstance(DEFAULT_CONNECTION_TIMEOUT);
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$requestAllWeatherInfo$1(Geocoder geocoder, double d6, double d7) throws IOException {
        return geocoder.getFromLocation(d6, d7, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCurrentWeatherInfo$2(String str, String str2, double d6, double d7, String str3) {
        try {
            if (isFileSaveOneHour(this.mContext, str)) {
                restoreCurrentResponse(str2, str);
            } else {
                new C2536a(this.mContext.getPackageName(), d6, d7, this.mUnit == EnumC2410h.f19711k ? "metric" : "imperial", str3, new C2407e(this, str2, str)).m9464a();
            }
        } catch (Throwable th) {
            th.getMessage();
            restoreCurrentResponse(str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestDailyWeatherInfo$6(String str, String str2, double d6, double d7, String str3) {
        try {
            if (isFileSaveOneHour(this.mContext, str)) {
                restoreDailyResponse(str, str2);
            } else {
                new C2536a(this.mContext.getPackageName(), d6, d7, this.mUnit == EnumC2410h.f19711k ? "metric" : "imperial", str3, new C2408f(this, str2, str), false).m9465b();
            }
        } catch (Throwable th) {
            th.getMessage();
            restoreDailyResponse(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestHourlyWeatherInfo$4(String str, String str2, double d6, double d7, String str3) {
        try {
            if (isFileSaveOneHour(this.mContext, str)) {
                restoreHourlyResponse(str2, str);
            } else {
                new C2536a(this.mContext.getPackageName(), d6, d7, this.mUnit == EnumC2410h.f19711k ? "metric" : "imperial", str3, new C2408f(this, str2, str)).m9466c();
            }
        } catch (Throwable th) {
            th.getMessage();
            restoreHourlyResponse(str2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreCurrentResponse$3(String str, CurrentResponse currentResponse) {
        this.mWeatherInfoResult.mo2136t(str, currentResponse, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreDailyResponse$7(String str, DailyResponse dailyResponse) {
        this.mWeatherInfoResult.mo2138v(dailyResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreHourlyResponse$5(String str, HourlyResponse hourlyResponse) {
        this.mWeatherInfoResult.mo2127h(hourlyResponse);
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
                geocoder.getFromLocation(d6, d7, 1, new C2404b(this, d6, d7, 0));
                return;
            }
            try {
                new CallableC3080a(new CallableC2405c(geocoder, d6, d7, 0)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C2406d(this, d6, d7, 0), AbstractC2679b.m9681a(), 1));
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
            this.mWeatherInfoResult.mo2136t(null, null, th2);
        }
    }

    public void requestCurrentWeatherInfo(String str, double d6, double d7) {
        AbstractC0212f.f640a.m9550b(new RunnableC2403a(this, str, d6, d7, this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en", 0));
    }

    public void requestDailyWeatherInfo(String str, double d6, double d7) {
        AbstractC0212f.f640a.m9550b(new RunnableC2403a(this, str, d6, d7, this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en", 2));
    }

    public void requestHourlyWeatherInfo(String str, double d6, double d7) {
        AbstractC0212f.f640a.m9550b(new RunnableC2403a(this, str, d6, d7, this.mLanguageSupport.contains(Locale.getDefault().getLanguage()) ? Locale.getDefault().getLanguage() : "en", 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreCurrentResponse(String str, String str2) {
        CurrentResponse currentResponse;
        try {
            if (!isFilePresent(this.mContext, str2) || (currentResponse = (CurrentResponse) new C0460k(2).m1087d(CurrentResponse.class, read(this.mContext, str2))) == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC0358n(this, str, currentResponse, 13));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreDailyResponse(String str, String str2) {
        String str3;
        DailyResponse dailyResponse;
        try {
            if (!isFilePresent(this.mContext, str) || (str3 = read(this.mContext, str)) == null || str3.trim().isEmpty() || (dailyResponse = (DailyResponse) new C0460k(2).m1087d(DailyResponse.class, str3)) == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new RunnableC0358n(this, str2, dailyResponse, 12));
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restoreHourlyResponse(String str, String str2) {
        if (isFilePresent(this.mContext, str2)) {
            try {
                HourlyResponse hourlyResponse = (HourlyResponse) new C0460k(2).m1087d(HourlyResponse.class, read(this.mContext, str2));
                if (hourlyResponse != null) {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0358n(this, str, hourlyResponse, 11));
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
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

    public EnumC2410h getUnit() {
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
                this.mErrorType = EnumC2409g.f19708l;
            } else {
                this.mErrorType = EnumC2409g.f19707k;
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
            this.mWeatherInfoResult.mo2136t(null, null, th);
        }
    }

    public boolean isFilePresent(Context context, String str) {
        return new File(context.getFilesDir().getAbsolutePath() + "/" + str).exists();
    }

    public boolean isFileSaveOneHour(Context context, String str) {
        File file = new File(context.getFilesDir(), str);
        return file.exists() && System.currentTimeMillis() - file.lastModified() < 3600000;
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

    public void queryWeatherByGPS(Context context, InterfaceC2415m interfaceC2415m) {
        if (!AbstractC0577y.m1345v(context)) {
            this.mErrorType = EnumC2409g.f19706j;
            return;
        }
        this.mContext = context;
        this.mTinyDB = new C0056Y(context);
        this.mWeatherInfoResult = interfaceC2415m;
        new C3941pm().m6670a(context, this);
    }

    public void setUnit(EnumC2410h enumC2410h) {
        this.mUnit = enumC2410h;
    }

    public static OpenWeather getInstance(int i6) {
        return getInstance(i6, false);
    }

    public static OpenWeather getInstance(int i6, boolean z5) {
        OpenWeather openWeather = mInstance;
        openWeather.mConnectionTimeout = i6;
        return openWeather;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: requestAllWeatherInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$requestAllWeatherInfo$0(List<Address> list, double d6, double d7) {
        OpenWeather openWeather;
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
            openWeather = this;
            d8 = d6;
            d9 = d7;
            str = TextUtils.isEmpty(subAdminArea) ? adminArea : subAdminArea;
        } else {
            openWeather = this;
            d8 = d6;
            d9 = d7;
            str = locality;
        }
        openWeather.requestCurrentWeatherInfo(str, d8, d9);
        openWeather.requestHourlyWeatherInfo(str, d8, d9);
        openWeather.requestDailyWeatherInfo(str, d8, d9);
    }
}
