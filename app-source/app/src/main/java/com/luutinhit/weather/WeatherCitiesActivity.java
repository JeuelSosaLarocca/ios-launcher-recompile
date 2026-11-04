package com.luutinhit.weather;

import G3.C0355k;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import p029g.AbstractActivityC2058k;
import p083h4.C2141i;
import p088i4.C2200e;

/* JADX INFO: loaded from: classes.dex */
public class WeatherCitiesActivity extends AbstractActivityC2058k implements View.OnClickListener {


    /* JADX INFO: renamed from: D */
    public RecyclerView f17679D;

    /* JADX INFO: renamed from: E */
    public ImageView f17680E;

    /* JADX INFO: renamed from: F */
    public C2200e f17681F;

    /* JADX INFO: renamed from: G */
    public C2141i f17682G;

    /* JADX INFO: renamed from: I */
    public static C0355k m8372I(String str, String str2) {
        C0355k c0355k = new C0355k();
        c0355k.f1164d = str;
        c0355k.f1161a = str2;
        c0355k.f1162b = "" + (new Random().nextInt(10) + 25);
        StringBuilder sb = new StringBuilder("GMT");
        sb.append(str2.length() % 2 == 1 ? "-" : "+");
        sb.append(new Random().nextInt(12));
        c0355k.f1163c = TimeZone.getTimeZone(sb.toString());
        return c0355k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_weather_cities);
        this.f17679D = (RecyclerView) findViewById(R.id.cities);
        C2200e c2200e = new C2200e();
        c2200e.f18966m = new SparseArray();
        c2200e.f18967n = LayoutInflater.from(this);
        c2200e.f18968o = null;
        this.f17681F = c2200e;
        this.f17679D.setLayoutManager(new LinearLayoutManager(1));
        this.f17679D.setAdapter(this.f17681F);
        if (C2141i.f18762l == null) {
            synchronized (C2141i.class) {
                try {
                    if (C2141i.f18762l == null) {
                        C2141i c2141i = new C2141i(this, "weather.db", (SQLiteDatabase.CursorFactory) null, 1);
                        c2141i.f18764k = "create table if not exists city(_id integer primary key autoincrement, _city_name text not null, _city_code text not null, _timezone text)";
                        C2141i.f18762l = c2141i;
                    }
                } catch (Throwable th) {
                    throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                }
            }
        }
        this.f17682G = C2141i.f18762l;
        ArrayList arrayList = new ArrayList();
        arrayList.add(m8372I("0", getSharedPreferences("persistence", 0).getString("local_city", "")));
        this.f17682G.getClass();
        SQLiteDatabase writableDatabase = C2141i.f18762l.getWritableDatabase();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = writableDatabase.query("city", null, null, null, null, null, null);
        while (cursorQuery != null) {
            try {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    HashMap map = new HashMap();
                    int i6 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("_city_name"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_city_code"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("_timezone"));
                    map.put("id", Integer.valueOf(i6));
                    map.put("city", string);
                    map.put("cityCode", string2);
                    map.put("timezone", string3);
                    arrayList2.add(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                cursorQuery.close();
                throw com.luutinhit.launcher6.JadxSupport.sneaky(th2);
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        int size = arrayList2.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList2.get(i7);
            i7++;
            Map map2 = (Map) obj;
            arrayList.add(m8372I(map2.get("cityCode").toString(), map2.get("city").toString()));
        }
        C2200e c2200e2 = this.f17681F;
        c2200e2.f18968o = arrayList;
        c2200e2.m9703f();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_city_footer, (ViewGroup) this.f17679D, false);
        this.f17680E = (ImageView) viewInflate.findViewById(R.id.add_city);
        C2200e c2200e3 = this.f17681F;
        SparseArray sparseArray = c2200e3.f18966m;
        sparseArray.put(sparseArray.size() + 20000, viewInflate);
        ArrayList arrayList3 = c2200e3.f18968o;
        c2200e3.f20775j.m9712e(arrayList3 == null ? sparseArray.size() : (arrayList3.size() - 1) + sparseArray.size(), 1);
        this.f17680E.setOnClickListener(this);
        C2200e c2200e4 = this.f17681F;
        c2200e4.f18969p = this;
        c2200e4.f18970q = this;
    }
}
