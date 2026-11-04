package com.luutinhit.weather.model.visualcrossing;

import androidx.annotation.Keep;
import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Day {

    @InterfaceC1908b("cloudcover")
    public double cloudcover;

    @InterfaceC1908b("conditions")
    public String conditions;

    @InterfaceC1908b("datetime")
    public String datetime;

    @InterfaceC1908b("datetimeEpoch")
    public long datetimeEpoch;

    @InterfaceC1908b("description")
    public String description;

    @InterfaceC1908b("dew")
    public double dew;

    @InterfaceC1908b("feelslike")
    public double feelslike;

    @InterfaceC1908b("feelslikemax")
    public double feelslikemax;

    @InterfaceC1908b("feelslikemin")
    public double feelslikemin;

    @InterfaceC1908b("hours")
    public List<Hour> hours;

    @InterfaceC1908b("humidity")
    public double humidity;

    @InterfaceC1908b("icon")
    public String icon;

    @InterfaceC1908b("moonphase")
    public double moonphase;

    @InterfaceC1908b("precip")
    public double precip;

    @InterfaceC1908b("precipcover")
    public double precipcover;

    @InterfaceC1908b("precipprob")
    public double precipprob;

    @InterfaceC1908b("preciptype")
    public List<String> preciptype;

    @InterfaceC1908b("pressure")
    public double pressure;

    @InterfaceC1908b("severerisk")
    public double severerisk;

    @InterfaceC1908b("snow")
    public double snow;

    @InterfaceC1908b("snowdepth")
    public double snowdepth;

    @InterfaceC1908b("solarenergy")
    public double solarenergy;

    @InterfaceC1908b("solarradiation")
    public double solarradiation;

    @InterfaceC1908b("source")
    public String source;

    @InterfaceC1908b("stations")
    public List<String> stations;

    @InterfaceC1908b("sunrise")
    public String sunrise;

    @InterfaceC1908b("sunriseEpoch")
    public long sunriseEpoch;

    @InterfaceC1908b("sunset")
    public String sunset;

    @InterfaceC1908b("sunsetEpoch")
    public long sunsetEpoch;

    @InterfaceC1908b("temp")
    public double temp;

    @InterfaceC1908b("tempmax")
    public double tempmax;

    @InterfaceC1908b("tempmin")
    public double tempmin;

    @InterfaceC1908b("uvindex")
    public double uvindex;

    @InterfaceC1908b("visibility")
    public double visibility;

    @InterfaceC1908b("winddir")
    public double winddir;

    @InterfaceC1908b("windgust")
    public double windgust;

    @InterfaceC1908b("windspeed")
    public double windspeed;
}
