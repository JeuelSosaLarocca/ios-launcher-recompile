package com.luutinhit.weather.model.openweathermodel;

import com.luutinhit.launcher6.SyntheticHelpers;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class Main {


    @InterfaceC1908b("feels_like")
    public double feelsLike;

    @InterfaceC1908b("grnd_level")
    public long grndLevel;

    @InterfaceC1908b("humidity")
    public int humidity;

    @InterfaceC1908b("pressure")
    public long pressure;

    @InterfaceC1908b("sea_level")
    public long seaLevel;

    @InterfaceC1908b("temp")
    public double temp;

    @InterfaceC1908b("temp_kf")
    public double tempKf;

    @InterfaceC1908b("temp_max")
    public double tempMax;

    @InterfaceC1908b("temp_min")
    public double tempMin;

    public int getFeelsLike() {
        return (int) this.feelsLike;
    }

    public long getGrndLevel() {
        return this.grndLevel;
    }

    public String getHumidity() {
        return SyntheticHelpers.m7915n(new StringBuilder(), this.humidity, "");
    }

    public long getPressure() {
        return this.pressure;
    }

    public long getSeaLevel() {
        return this.seaLevel;
    }

    public int getTemp() {
        return (int) this.temp;
    }

    public double getTempKf() {
        return this.tempKf;
    }

    public int getTempMax() {
        return (int) this.tempMax;
    }

    public int getTempMin() {
        return (int) this.tempMin;
    }

    public void setFeelsLike(double d6) {
        this.feelsLike = d6;
    }

    public void setGrndLevel(long j6) {
        this.grndLevel = j6;
    }

    public void setHumidity(int i6) {
        this.humidity = i6;
    }

    public void setPressure(long j6) {
        this.pressure = j6;
    }

    public void setSeaLevel(long j6) {
        this.seaLevel = j6;
    }

    public void setTemp(double d6) {
        this.temp = d6;
    }

    public void setTempKf(double d6) {
        this.tempKf = d6;
    }

    public void setTempMax(double d6) {
        this.tempMax = d6;
    }

    public void setTempMin(double d6) {
        this.tempMin = d6;
    }
}
