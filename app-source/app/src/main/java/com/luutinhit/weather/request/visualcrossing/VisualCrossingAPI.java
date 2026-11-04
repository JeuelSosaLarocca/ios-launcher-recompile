package com.luutinhit.weather.request.visualcrossing;

import androidx.annotation.Keep;
import com.luutinhit.weather.model.visualcrossing.VisualCrossingWeatherResponse;
import v5.InterfaceC2891c;
import x5.InterfaceC2979f;
import x5.InterfaceC2992s;
import x5.InterfaceC2993t;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface VisualCrossingAPI {
    @InterfaceC2979f("{lat},{lon}?")
    InterfaceC2891c<VisualCrossingWeatherResponse> getWeatherData(@InterfaceC2992s("lat") double d6, @InterfaceC2992s("lon") double d7, @InterfaceC2993t("unitGroup") String str, @InterfaceC2993t("lang") String str2, @InterfaceC2993t("key") String str3);
}
