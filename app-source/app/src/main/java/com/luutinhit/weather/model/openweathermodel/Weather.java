package com.luutinhit.weather.model.openweathermodel;

import androidx.annotation.Keep;
import p065d3.InterfaceC1908b;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class Weather {


    @InterfaceC1908b("description")
    public String description;

    @InterfaceC1908b("icon")
    public String icon;

    @InterfaceC1908b("id")
    public int id;

    @InterfaceC1908b("main")
    public String main;

    public String getDescription() {
        return this.description;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public String getMain() {
        return this.main;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i6) {
        this.id = i6;
    }

    public void setMain(String str) {
        this.main = str;
    }
}
