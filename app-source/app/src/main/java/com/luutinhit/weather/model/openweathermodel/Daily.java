package com.luutinhit.weather.model.openweathermodel;

import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class Daily {


    @InterfaceC1908b("clouds")
    public int clouds;

    @InterfaceC1908b("deg")
    public long deg;

    @InterfaceC1908b("dt")
    public long dt;

    @InterfaceC1908b("feels_like")
    public FeelsLike feels_like;

    @InterfaceC1908b("gust")
    public double gust;

    @InterfaceC1908b("humidity")
    public long humidity;

    @InterfaceC1908b("pop")
    public double pop;

    @InterfaceC1908b("pressure")
    public long pressure;

    @InterfaceC1908b("rain")
    public Double rain;

    @InterfaceC1908b("snow")
    public Double snow;

    @InterfaceC1908b("speed")
    public double speed;

    @InterfaceC1908b("sunrise")
    public long sunrise;

    @InterfaceC1908b("sunset")
    public long sunset;

    @InterfaceC1908b("temp")
    public Temp temp;

    @InterfaceC1908b("weather")
    public List<Weather> weather;

    public int getClouds() {
        return this.clouds;
    }

    public long getDeg() {
        return this.deg;
    }

    public long getDt() {
        return this.dt * 1000;
    }

    public FeelsLike getFeelsLike() {
        return this.feels_like;
    }

    public double getGust() {
        return this.gust;
    }

    public String getHumidity() {
        return this.humidity + "";
    }

    public double getPop() {
        return this.pop;
    }

    public long getPressure() {
        return this.pressure;
    }

    public Double getRain() {
        return this.rain;
    }

    public Double getSnow() {
        return this.snow;
    }

    public double getSpeed() {
        return this.speed;
    }

    public long getSunrise() {
        return this.sunrise * 1000;
    }

    public long getSunset() {
        return this.sunset * 1000;
    }

    public Temp getTemp() {
        return this.temp;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public void setClouds(int i6) {
        this.clouds = i6;
    }

    public void setDeg(long j6) {
        this.deg = j6;
    }

    public void setDt(long j6) {
        this.dt = j6;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feels_like = feelsLike;
    }

    public void setGust(double d6) {
        this.gust = d6;
    }

    public void setHumidity(long j6) {
        this.humidity = j6;
    }

    public void setPop(double d6) {
        this.pop = d6;
    }

    public void setPressure(long j6) {
        this.pressure = j6;
    }

    public void setRain(Double d6) {
        this.rain = d6;
    }

    public void setSnow(Double d6) {
        this.snow = d6;
    }

    public void setSpeed(double d6) {
        this.speed = d6;
    }

    public void setSunrise(long j6) {
        this.sunrise = j6;
    }

    public void setSunset(long j6) {
        this.sunset = j6;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public void setWeather(List<Weather> list) {
        this.weather = list;
    }
}
