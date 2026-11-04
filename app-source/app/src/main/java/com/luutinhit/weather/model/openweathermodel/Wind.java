package com.luutinhit.weather.model.openweathermodel;

import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class Wind {


    @InterfaceC1908b("deg")
    public int deg;

    @InterfaceC1908b("gust")
    public double gust;

    @InterfaceC1908b("speed")
    public double speed;

    public int getDeg() {
        return this.deg;
    }

    public double getGust() {
        return this.gust;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setDeg(int i6) {
        this.deg = i6;
    }

    public void setGust(double d6) {
        this.gust = d6;
    }

    public void setSpeed(double d6) {
        this.speed = d6;
    }
}
