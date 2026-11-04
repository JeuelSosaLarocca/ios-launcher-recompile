package com.luutinhit.weather.model.openweathermodel;

import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class HourlyResponse {


    @InterfaceC1908b("city")
    public HourlyCity city;

    @InterfaceC1908b("cnt")
    public long cnt;

    @InterfaceC1908b("cod")
    public long cod;

    @InterfaceC1908b("list")
    public List<Hourly> list;

    @InterfaceC1908b("message")
    public long message;

    public HourlyCity getCity() {
        return this.city;
    }

    public long getCnt() {
        return this.cnt;
    }

    public long getCod() {
        return this.cod;
    }

    public List<Hourly> getList() {
        return this.list;
    }

    public long getMessage() {
        return this.message;
    }

    public void setCity(HourlyCity hourlyCity) {
        this.city = hourlyCity;
    }

    public void setCnt(long j6) {
        this.cnt = j6;
    }

    public void setCod(long j6) {
        this.cod = j6;
    }

    public void setList(List<Hourly> list) {
        this.list = list;
    }

    public void setMessage(long j6) {
        this.message = j6;
    }
}
