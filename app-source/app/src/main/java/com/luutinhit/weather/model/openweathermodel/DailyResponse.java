package com.luutinhit.weather.model.openweathermodel;

import java.util.List;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
public class DailyResponse {


    @InterfaceC1908b("city")
    public DailyCity city;

    @InterfaceC1908b("cnt")
    public long cnt;

    @InterfaceC1908b("cod")
    public String cod;

    @InterfaceC1908b("list")
    public List<Daily> list;

    @InterfaceC1908b("message")
    public double message;

    public DailyCity getCity() {
        return this.city;
    }

    public long getCnt() {
        return this.cnt;
    }

    public String getCod() {
        return this.cod;
    }

    public List<Daily> getList() {
        return this.list;
    }

    public double getMessage() {
        return this.message;
    }

    public void setCity(DailyCity dailyCity) {
        this.city = dailyCity;
    }

    public void setCnt(long j6) {
        this.cnt = j6;
    }

    public void setCod(String str) {
        this.cod = str;
    }

    public void setList(List<Daily> list) {
        this.list = list;
    }

    public void setMessage(double d6) {
        this.message = d6;
    }
}
