package com.luutinhit.launcher6.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import s5.AbstractC2752b;

/* JADX INFO: loaded from: classes.dex */
public class TimeView extends View {

    /* JADX INFO: renamed from: j */
    public Context f17199j;

    /* JADX INFO: renamed from: k */
    public Paint f17200k;

    /* JADX INFO: renamed from: l */
    public Paint f17201l;

    /* JADX INFO: renamed from: m */
    public SimpleDateFormat f17202m;

    /* JADX INFO: renamed from: n */
    public SimpleDateFormat f17203n;

    /* JADX INFO: renamed from: o */
    public Rect f17204o;

    public TimeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.f17200k = paint;
        Paint paint2 = new Paint(1);
        this.f17201l = paint2;
        this.f17204o = new Rect();
        this.f17199j = context;
        Locale locale = AbstractC2752b.m9849i(getResources().getConfiguration()).f1788a.get();
        locale = locale == null ? Locale.ENGLISH : locale;
        this.f17202m = new SimpleDateFormat("HH:mm", locale);
        this.f17203n = new SimpleDateFormat("EEEE, MMMM d", locale);
        locale.getLanguage();
        if ("vi".equals(locale.getLanguage())) {
            this.f17203n = new SimpleDateFormat("EEEE, d MMMM", locale);
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf");
        paint.setColor(-1);
        paint.setTypeface(typefaceCreateFromAsset);
        Typeface typefaceCreateFromAsset2 = Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf");
        paint2.setColor(-1);
        paint2.setTypeface(typefaceCreateFromAsset2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Context context = this.f17199j;
        SimpleDateFormat simpleDateFormat = this.f17202m;
        try {
            DateFormat.is24HourFormat(context);
            if (DateFormat.is24HourFormat(context)) {
                simpleDateFormat.applyPattern("HH:mm");
            } else {
                simpleDateFormat.applyPattern("h:mm");
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        int width = getWidth();
        int height = getHeight();
        Paint paint = this.f17200k;
        paint.setTextSize((height * 3) / 4.0f);
        Paint paint2 = this.f17201l;
        paint2.setTextSize(height / 5.0f);
        Date time = Calendar.getInstance().getTime();
        String str = simpleDateFormat.format(time);
        String str2 = this.f17203n.format(time);
        Rect rect = this.f17204o;
        rect.setEmpty();
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, (width - rect.width()) - 20, rect.height() + 1, paint);
        rect.setEmpty();
        paint2.getTextBounds(str2, 0, str2.length(), rect);
        canvas.drawText(str2, (width - rect.width()) - 20, (height - rect.bottom) - 1, paint2);
    }
}
