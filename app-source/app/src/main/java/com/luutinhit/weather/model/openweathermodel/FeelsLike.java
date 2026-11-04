package com.luutinhit.weather.model.openweathermodel;

import androidx.annotation.Keep;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FeelsLike {


    @InterfaceC1908b("day")
    public double day;

    @InterfaceC1908b("eve")
    public double eve;

    @InterfaceC1908b("morn")
    public double morn;

    @InterfaceC1908b("night")
    public double night;

    public double getDay() {
        return this.day;
    }

    public double getEve() {
        return this.eve;
    }

    public double getMorn() {
        return this.morn;
    }

    public double getNight() {
        return this.night;
    }

    public void setDay(double d6) {
        this.day = d6;
    }

    public void setEve(double d6) {
        this.eve = d6;
    }

    public void setMorn(double d6) {
        this.morn = d6;
    }

    public void setNight(double d6) {
        this.night = d6;
    }
}
