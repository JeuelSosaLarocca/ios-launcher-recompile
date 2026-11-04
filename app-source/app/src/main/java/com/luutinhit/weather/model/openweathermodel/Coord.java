package com.luutinhit.weather.model.openweathermodel;

import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class Coord {


    @InterfaceC1908b("lat")
    public double lat;

    @InterfaceC1908b("lon")
    public double lon;

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLat(double d6) {
        this.lat = d6;
    }

    public void setLon(double d6) {
        this.lon = d6;
    }
}
