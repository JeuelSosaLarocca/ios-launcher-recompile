package com.luutinhit.weather.model.openweathermodel;

import androidx.annotation.Keep;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Rain {


    @InterfaceC1908b("1h")
    public double _1h;

    @InterfaceC1908b("3h")
    public double _3h;

    public double get1h() {
        return this._1h;
    }

    public double get3h() {
        return this._3h;
    }

    public void set1h(double d6) {
        this._1h = d6;
    }

    public void set3h(double d6) {
        this._3h = d6;
    }
}
