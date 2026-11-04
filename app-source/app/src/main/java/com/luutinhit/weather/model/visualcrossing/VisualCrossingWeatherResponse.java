package com.luutinhit.weather.model.visualcrossing;

import androidx.annotation.Keep;
import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class VisualCrossingWeatherResponse {

    @InterfaceC1908b("address")
    public String address;

    @InterfaceC1908b("alerts")
    public List<Object> alerts;

    @InterfaceC1908b("currentConditions")
    public CurrentConditions currentConditions;

    @InterfaceC1908b("days")
    public List<Day> days;

    @InterfaceC1908b("description")
    public String description;

    @InterfaceC1908b("latitude")
    public double latitude;

    @InterfaceC1908b("longitude")
    public double longitude;

    @InterfaceC1908b("queryCost")
    public int queryCost;

    @InterfaceC1908b("resolvedAddress")
    public String resolvedAddress;

    @InterfaceC1908b("stations")
    public Stations stations;

    @InterfaceC1908b("timezone")
    public String timezone;

    @InterfaceC1908b("tzoffset")
    public double tzoffset;
}
