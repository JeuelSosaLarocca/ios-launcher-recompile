package com.luutinhit.weather.model.openweathermodel;

import androidx.annotation.Keep;
import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class CurrentResponse {


    @InterfaceC1908b("base")
    public String base;

    @InterfaceC1908b("clouds")
    public Clouds clouds;

    @InterfaceC1908b("cod")
    public long cod;

    @InterfaceC1908b("coord")
    public Coord coord;

    @InterfaceC1908b("dt")
    public long dt;

    @InterfaceC1908b("id")
    public long id;

    @InterfaceC1908b("main")
    public Main main;

    @InterfaceC1908b("name")
    public String name;

    @InterfaceC1908b("rain")
    public Rain rain;

    @InterfaceC1908b("snow")
    public Snow snow;

    @InterfaceC1908b("sys")
    public Sys sys;

    @InterfaceC1908b("timezone")
    public long timezone;

    @InterfaceC1908b("visibility")
    public long visibility;

    @InterfaceC1908b("weather")
    public List<Weather> weather = null;

    @InterfaceC1908b("wind")
    public Wind wind;

    public class Sys {
        public String country;
        public long id;
        public long sunrise;
        public long sunset;
        public long type;

        public Sys() {
        }

        public String getCountry() {
            return this.country;
        }

        public long getID() {
            return this.id;
        }

        public long getSunrise() {
            return this.sunrise * 1000;
        }

        public long getSunset() {
            return this.sunset * 1000;
        }

        public long getType() {
            return this.type;
        }

        public void setCountry(String str) {
            this.country = str;
        }

        public void setID(long j6) {
            this.id = j6;
        }

        public void setSunrise(long j6) {
            this.sunrise = j6;
        }

        public void setSunset(long j6) {
            this.sunset = j6;
        }

        public void setType(long j6) {
            this.type = j6;
        }
    }

    public String getBase() {
        return this.base;
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public long getCod() {
        return this.cod;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public long getDt() {
        return this.dt;
    }

    public long getID() {
        return this.id;
    }

    public Main getMain() {
        return this.main;
    }

    public String getName() {
        return this.name;
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

    public long getTimezone() {
        return this.timezone;
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

    public void setBase(String str) {
        this.base = str;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setCod(long j6) {
        this.cod = j6;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setDt(long j6) {
        this.dt = j6;
    }

    public void setID(long j6) {
        this.id = j6;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setName(String str) {
        this.name = str;
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

    public void setTimezone(long j6) {
        this.timezone = j6;
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
