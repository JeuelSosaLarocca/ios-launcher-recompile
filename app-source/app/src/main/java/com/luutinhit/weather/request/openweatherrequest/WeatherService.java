package com.luutinhit.weather.request.openweatherrequest;

import androidx.annotation.Keep;
import com.luutinhit.weather.model.openweathermodel.CurrentResponse;
import com.luutinhit.weather.model.openweathermodel.DailyResponse;
import com.luutinhit.weather.model.openweathermodel.HourlyResponse;
import v5.InterfaceC2891c;
import x5.InterfaceC2979f;
import x5.InterfaceC2993t;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface WeatherService {
    @InterfaceC2979f("data/2.5/weather?")
    InterfaceC2891c<CurrentResponse> getCurrentWeatherData(@InterfaceC2993t("lat") double d6, @InterfaceC2993t("lon") double d7, @InterfaceC2993t("units") String str, @InterfaceC2993t("lang") String str2, @InterfaceC2993t("appid") String str3);

    @InterfaceC2979f("data/2.5/forecast/daily?")
    InterfaceC2891c<DailyResponse> getDailyWeatherData(@InterfaceC2993t("lat") double d6, @InterfaceC2993t("lon") double d7, @InterfaceC2993t("units") String str, @InterfaceC2993t("lang") String str2, @InterfaceC2993t("appid") String str3);

    @InterfaceC2979f("data/2.5/forecast/hourly?")
    InterfaceC2891c<HourlyResponse> getHourlyWeatherData(@InterfaceC2993t("lat") double d6, @InterfaceC2993t("lon") double d7, @InterfaceC2993t("units") String str, @InterfaceC2993t("lang") String str2, @InterfaceC2993t("appid") String str3);
}
