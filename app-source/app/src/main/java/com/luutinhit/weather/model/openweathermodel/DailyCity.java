package com.luutinhit.weather.model.openweathermodel;

import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class DailyCity {


    @InterfaceC1908b("coord")
    public Coord coord;

    @InterfaceC1908b("country")
    public String country;

    @InterfaceC1908b("id")
    public long id;

    @InterfaceC1908b("name")
    public String name;

    @InterfaceC1908b("population")
    public long population;

    @InterfaceC1908b("timezone")
    public long timezone;

    public Coord getCoord() {
        return this.coord;
    }

    public String getCountry() {
        return this.country;
    }

    public long getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getPopulation() {
        return this.population;
    }

    public long getTimezone() {
        return this.timezone;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setID(long j6) {
        this.id = j6;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPopulation(long j6) {
        this.population = j6;
    }

    public void setTimezone(long j6) {
        this.timezone = j6;
    }
}
