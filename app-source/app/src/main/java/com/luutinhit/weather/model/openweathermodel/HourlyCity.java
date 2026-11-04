package com.luutinhit.weather.model.openweathermodel;

/* JADX INFO: loaded from: classes.dex */
public class HourlyCity {

    public Coord coord;
    public String country;
    public long id;
    public String name;
    public long population;
    public long sunrise;
    public long sunset;
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

    public long getSunrise() {
        return this.sunrise * 1000;
    }

    public long getSunset() {
        return this.sunset * 1000;
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

    public void setSunrise(long j6) {
        this.sunrise = j6;
    }

    public void setSunset(long j6) {
        this.sunset = j6;
    }

    public void setTimezone(long j6) {
        this.timezone = j6;
    }
}
