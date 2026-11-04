package com.luutinhit.weather.model.openweathermodel;

import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class Hourly {


    @InterfaceC1908b("clouds")
    public Clouds clouds;

    @InterfaceC1908b("dt")
    public long dt;

    @InterfaceC1908b("dt_txt")
    public String dt_txt;

    @InterfaceC1908b("main")
    public Main main;

    @InterfaceC1908b("pop")
    public double pop;

    @InterfaceC1908b("rain")
    public Rain rain;

    @InterfaceC1908b("snow")
    public Snow snow;

    @InterfaceC1908b("sys")
    public Sys sys;

    @InterfaceC1908b("visibility")
    public long visibility;

    @InterfaceC1908b("weather")
    public List<Weather> weather;

    @InterfaceC1908b("wind")
    public Wind wind;

    public static class Sys {
        String pod;

        public String getPod() {
            return this.pod;
        }

        public void setPod(String str) {
            this.pod = str;
        }
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public long getDt() {
        return this.dt * 1000;
    }

    public String getDtTxt() {
        return this.dt_txt;
    }

    public Main getMain() {
        return this.main;
    }

    public double getPop() {
        return this.pop;
    }

    public Rain getRain() {
        return this.rain;
    }

    public Snow getSnow() {
        return this.snow;
    }

    public Sys getSys() {
        return this.sys;
    }

    public long getVisibility() {
        return this.visibility;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public Wind getWind() {
        return this.wind;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setDt(long j6) {
        this.dt = j6;
    }

    public void setDtTxt(String str) {
        this.dt_txt = str;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setPop(double d6) {
        this.pop = d6;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setVisibility(long j6) {
        this.visibility = j6;
    }

    public void setWeather(List<Weather> list) {
        this.weather = list;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
