package com.luutinhit.wallpaper.livewallpaper;

import T0.C1022e;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import p070e4.C1994a;

/* JADX INFO: loaded from: classes.dex */
public class Cube extends View {

    /* JADX INFO: renamed from: j */
    public Paint f17649j;

    /* JADX INFO: renamed from: k */
    public Paint f17650k;

    /* JADX INFO: renamed from: l */
    public C1994a[] f17651l;

    /* JADX INFO: renamed from: m */
    public C1022e[] f17652m;

    /* JADX INFO: renamed from: n */
    public Path f17653n;

    /* JADX INFO: renamed from: o */
    public Path f17654o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cube(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        int i6 = 16;
        Paint paint = new Paint();
        this.f17649j = paint;
        Paint paint2 = new Paint();
        this.f17650k = paint2;
        this.f17653n = new Path();
        this.f17654o = new Path();
        paint.setColor(-1275068417);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3.0f);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint2.setColor(1711276031);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(2.0f);
        paint2.setStrokeCap(cap);
        paint2.setStyle(style);
        paint2.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f}, 0.0f));
        C1994a[] c1994aArr = {new C1994a(this, -1.0f, -1.0f, 1.0f), new C1994a(this, -1.0f, 1.0f, 1.0f), new C1994a(this, 1.0f, 1.0f, 1.0f), new C1994a(this, 1.0f, -1.0f, 1.0f), new C1994a(this, -1.0f, -1.0f, -1.0f), new C1994a(this, -1.0f, 1.0f, -1.0f), new C1994a(this, 1.0f, 1.0f, -1.0f), new C1994a(this, 1.0f, -1.0f, -1.0f)};
        this.f17651l = c1994aArr;
        C1994a c1994a = c1994aArr[0];
        C1994a c1994a2 = c1994aArr[1];
        C1022e c1022e = new C1022e(i6, c1994a, c1994a2);
        C1994a c1994a3 = c1994aArr[2];
        C1022e c1022e2 = new C1022e(i6, c1994a2, c1994a3);
        C1994a c1994a4 = c1994aArr[3];
        C1022e c1022e3 = new C1022e(i6, c1994a3, c1994a4);
        C1022e c1022e4 = new C1022e(i6, c1994a4, c1994a);
        C1994a c1994a5 = c1994aArr[4];
        C1022e c1022e5 = new C1022e(i6, c1994a, c1994a5);
        C1994a c1994a6 = c1994aArr[5];
        C1022e c1022e6 = new C1022e(i6, c1994a2, c1994a6);
        C1994a c1994a7 = c1994aArr[6];
        C1022e c1022e7 = new C1022e(i6, c1994a3, c1994a7);
        C1994a c1994a8 = c1994aArr[7];
        this.f17652m = new C1022e[]{c1022e, c1022e2, c1022e3, c1022e4, c1022e5, c1022e6, c1022e7, new C1022e(i6, c1994a4, c1994a8), new C1022e(i6, c1994a5, c1994a6), new C1022e(i6, c1994a6, c1994a7), new C1022e(i6, c1994a7, c1994a8), new C1022e(i6, c1994a8, c1994a5)};
    }

    public int getMaxSize() {
        return Math.min(getWidth(), getHeight());
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        C1022e[] c1022eArr;
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        int maxSize = getMaxSize();
        C1994a[] c1994aArr = this.f17651l;
        int i6 = 0;
        for (int length = c1994aArr.length; i6 < length; length = length) {
            C1994a c1994a = c1994aArr[i6];
            Cube cube = c1994a.f18059h;
            double d6 = 0.0f;
            double dSin = Math.sin(d6);
            double d7 = c1994a.f18054c;
            double dCos = Math.cos(d6);
            C1994a[] c1994aArr2 = c1994aArr;
            double d8 = c1994a.f18053b;
            c1994a.f18056e = (float) ((dCos * d8) + (dSin * d7));
            c1994a.f18057f = (float) ((Math.cos(d6) * d7) - (Math.sin(d6) * d8));
            double dSin2 = Math.sin(d6) * ((double) c1994a.f18057f);
            double dCos2 = Math.cos(d6);
            double d9 = c1994a.f18052a;
            c1994a.f18055d = (float) ((dCos2 * d9) + dSin2);
            float fCos = (float) ((Math.cos(d6) * ((double) c1994a.f18057f)) - (Math.sin(d6) * d9));
            c1994a.f18057f = fCos;
            float f6 = maxSize * 3.0f;
            float f7 = fCos + 10.0f;
            c1994a.f18055d = (c1994a.f18055d * f6) / f7;
            c1994a.f18056e = (f6 * c1994a.f18056e) / f7;
            i6++;
            c1994aArr = c1994aArr2;
        }
        C1994a[] c1994aArr3 = c1994aArr;
        int i7 = 0;
        while (true) {
            c1022eArr = this.f17652m;
            if (i7 >= 4) {
                break;
            }
            C1994a c1994a2 = c1994aArr3[i7];
            if (c1994a2.f18055d < c1022eArr[8].m2134r(c1994a2.f18056e) || c1994a2.f18055d > c1022eArr[10].m2134r(c1994a2.f18056e) || c1994a2.f18056e < c1022eArr[11].m2135s(c1994a2.f18055d) || c1994a2.f18056e > c1022eArr[9].m2135s(c1994a2.f18055d)) {
                c1994a2.f18058g = false;
            } else {
                c1994a2.f18058g = true;
            }
            i7++;
        }
        Path path = this.f17653n;
        path.reset();
        Path path2 = this.f17654o;
        path2.reset();
        for (C1022e c1022e : c1022eArr) {
            C1994a c1994a3 = (C1994a) c1022e.f2955k;
            boolean z5 = c1994a3.f18058g;
            C1994a c1994a4 = (C1994a) c1022e.f2956l;
            if (z5 || c1994a4.f18058g) {
                path2.moveTo(c1994a3.f18055d, c1994a3.f18056e);
                path2.lineTo(c1994a4.f18055d, c1994a4.f18056e);
            } else {
                path.moveTo(c1994a3.f18055d, c1994a3.f18056e);
                path.lineTo(c1994a4.f18055d, c1994a4.f18056e);
            }
        }
        canvas.drawPath(path2, this.f17650k);
        canvas.drawPath(path, this.f17649j);
        canvas.restore();
    }
}
