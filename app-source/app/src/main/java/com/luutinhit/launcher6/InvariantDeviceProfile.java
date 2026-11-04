package com.luutinhit.launcher6;

import B3.C0056Y;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: renamed from: com.luutinhit.launcher6.m1 */
/* JADX INFO: loaded from: classes.dex */
public final class InvariantDeviceProfile {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public InvariantDeviceProfile() {
        super();
    }

    /* JADX INFO: renamed from: a */
    public float f16709a;

    /* JADX INFO: renamed from: b */
    public boolean f16710b;

    /* JADX INFO: renamed from: c */
    public int f16711c;

    /* JADX INFO: renamed from: d */
    public int f16712d;

    /* JADX INFO: renamed from: e */
    public int f16713e;

    /* JADX INFO: renamed from: f */
    public int f16714f;

    /* JADX INFO: renamed from: g */
    public float f16715g;

    /* JADX INFO: renamed from: h */
    public int f16716h;

    /* JADX INFO: renamed from: i */
    public int f16717i;

    /* JADX INFO: renamed from: j */
    public float f16718j;

    /* JADX INFO: renamed from: k */
    public int f16719k;

    /* JADX INFO: renamed from: l */
    public int f16720l;

    /* JADX INFO: renamed from: m */
    public String f16721m;

    /* JADX INFO: renamed from: n */
    public int f16722n;

    /* JADX INFO: renamed from: o */
    public float f16723o;

    /* JADX INFO: renamed from: p */
    public int f16724p;

    /* JADX INFO: renamed from: q */
    public DeviceProfile f16725q;

    /* JADX INFO: renamed from: r */
    public DeviceProfile f16726r;

    /* JADX INFO: renamed from: s */
    public float f16727s;

    /* JADX INFO: renamed from: t */
    public float f16728t;

    /* JADX INFO: renamed from: u */
    public WindowManager f16729u;

    /* JADX INFO: renamed from: v */
    public Context f16730v;

    /* JADX INFO: renamed from: w */
    public boolean f16731w;

    /* JADX INFO: renamed from: x */
    public boolean f16732x;

    /* JADX INFO: renamed from: y */
    public int f16733y;

    /* JADX INFO: renamed from: z */
    public C0056Y f16734z;

    public InvariantDeviceProfile(String str, float f6, float f7, int i6, int i7, int i8, int i9, int i10, float f8, float f9, int i11, float f10, int i12) {
        this.f16709a = 0.62f;
        boolean z5 = SettingsColumns.f15703b;
        this.f16710b = z5;
        this.f16731w = false;
        this.f16732x = false;
        this.f16733y = 0;
        if (!z5 && i11 % 2 == 0) {
            throw new RuntimeException("All Device Profiles must have an odd number of hotseat spaces");
        }
        this.f16721m = str;
        this.f16727s = f6;
        this.f16728t = f7;
        this.f16711c = i6;
        this.f16712d = i7;
        this.f16713e = i8;
        this.f16714f = i9;
        this.f16722n = i10;
        this.f16715g = f8;
        this.f16718j = f9;
        this.f16719k = i11;
        this.f16723o = f10;
        this.f16724p = i12;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m8146a() {
        try {
            return Build.MANUFACTURER.toLowerCase().contains("samsung");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x025c  */
    /* JADX WARN: Code duplicated, block: B:105:0x027f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0282  */
    /* JADX WARN: Code duplicated, block: B:108:0x0286  */
    /* JADX WARN: Code duplicated, block: B:109:0x0289  */
    /* JADX WARN: Code duplicated, block: B:112:0x0291  */
    /* JADX WARN: Code duplicated, block: B:113:0x0295  */
    /* JADX WARN: Code duplicated, block: B:116:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:117:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:119:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:120:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:123:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:124:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:127:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:128:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:130:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:131:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:134:0x0305  */
    /* JADX WARN: Code duplicated, block: B:135:0x0309  */
    /* JADX WARN: Code duplicated, block: B:138:0x0351  */
    /* JADX WARN: Code duplicated, block: B:140:0x0359  */
    /* JADX WARN: Code duplicated, block: B:147:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:148:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:153:0x046b  */
    /* JADX WARN: Code duplicated, block: B:154:0x046f  */
    /* JADX WARN: Code duplicated, block: B:157:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:159:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:167:0x04b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x008c  */
    /* JADX WARN: Code duplicated, block: B:23:0x009c  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:27:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:38:0x011b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0181  */
    /* JADX WARN: Code duplicated, block: B:48:0x018d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0192  */
    /* JADX WARN: Code duplicated, block: B:53:0x019b  */
    /* JADX WARN: Code duplicated, block: B:54:0x019e  */
    /* JADX WARN: Code duplicated, block: B:57:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:65:0x01df  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:76:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x021f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0222  */
    /* JADX WARN: Code duplicated, block: B:84:0x022a  */
    /* JADX WARN: Code duplicated, block: B:86:0x022e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0231  */
    /* JADX WARN: Code duplicated, block: B:89:0x0235  */
    /* JADX WARN: Code duplicated, block: B:90:0x0238  */
    /* JADX WARN: Code duplicated, block: B:93:0x0246  */
    /* JADX WARN: Code duplicated, block: B:97:0x024f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0253  */
    public InvariantDeviceProfile(Context context) {
        boolean z5 = false;
        int dimensionPixelSize;
        int i6;
        float f6;
        Display defaultDisplay;
        Point point;
        Point point2;
        float fMin;
        float fMin2;
        boolean z6;
        int i7;
        boolean z7;
        int i8;
        float f7;
        int i9;
        int i10;
        int i11;
        float f8;
        int i12;
        int i13;
        int i14;
        float f9;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        float f10;
        float f11;
        InvariantDeviceProfile invariantDeviceProfile;
        ArrayList arrayList;
        int i25;
        float f12;
        Point point3;
        Point point4;
        ArrayList arrayList2;
        float fHypot;
        float fPow;
        Point point5;
        int iMin;
        int[] iArr;
        int i26;
        int i27 = 0;
        int i28;
        Context context2;
        Resources resources;
        int identifier;
        this.f16709a = 0.62f;
        this.f16710b = SettingsColumns.f15703b;
        this.f16731w = false;
        this.f16732x = false;
        this.f16733y = 0;
        this.f16730v = context;
        this.f16734z = new C0056Y(context);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.f16729u = windowManager;
        try {
            Point point6 = new Point();
            Point point7 = new Point();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            point6.x = displayMetrics.widthPixels;
            point6.y = displayMetrics.heightPixels;
            windowManager.getDefaultDisplay().getSize(point7);
            if (point6.y <= point7.y && point6.x <= point7.x) {
                int identifier2 = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
                if (identifier2 > 0) {
                    context.getResources().getBoolean(identifier2);
                }
                z5 = identifier2 > 0 && context.getResources().getBoolean(identifier2);
                this.f16731w = z5;
                if (z5) {
                    boolean z8 = Utilities.f16753n;
                }
                this.f16732x = this.f16734z.f137a.getBoolean("hide_navigation", true);
                if (z5) {
                    context2 = this.f16730v;
                    resources = context2.getResources();
                    identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                    if (identifier > 0) {
                        dimensionPixelSize = resources.getDimensionPixelSize(identifier);
                    } else {
                        dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.navigation_bar_height);
                    }
                } else {
                    dimensionPixelSize = 0;
                }
                this.f16733y = dimensionPixelSize;
                ActivityManager activityManager = (ActivityManager) this.f16730v.getSystemService("activity");
                if ((Utilities.f16753n || (activityManager != null && activityManager.isLowRamDevice())) && !this.f16734z.m131a("notFirstRunning")) {
                    this.f16734z.f137a.edit().putBoolean("notFirstRunning", true).apply();
                    this.f16734z.f137a.edit().putBoolean("preference_blur_widget", false).apply();
                }
                i6 = this.f16734z.f137a.getInt("use_grid_size", 0);
                f6 = this.f16734z.f137a.getFloat("icon_padding_edge", 0.0f);
                this.f16709a = f6;
                if (f6 == 0.0f) {
                    Resources resources2 = context.getResources();
                    TypedValue typedValue = new TypedValue();
                    resources2.getValue(R.dimen.icon_padding_percent, typedValue, true);
                    this.f16709a = typedValue.getFloat();
                }
                defaultDisplay = this.f16729u.getDefaultDisplay();
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                point = new Point();
                point2 = new Point();
                defaultDisplay.getCurrentSizeRange(point, point2);
                fMin = Math.min(point.x, point.y) / (displayMetrics2.densityDpi / 160.0f);
                this.f16727s = fMin;
                fMin2 = Math.min(point2.x, point2.y) / (displayMetrics2.densityDpi / 160.0f);
                this.f16728t = fMin2;
                if (fMin2 / fMin <= 1.85f || fMin / fMin2 > 1.85f) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ArrayList arrayList3 = new ArrayList();
                if (i6 != 0) {
                    i7 = i6;
                } else {
                    i7 = 5;
                }
                z7 = this.f16710b;
                if (z7) {
                    i8 = 4;
                } else {
                    i8 = 5;
                }
                if (z7) {
                    f7 = 58.0f;
                } else {
                    f7 = 56.0f;
                }
                if (m8146a()) {
                    i9 = R.xml.default_workspace_5x4_samsung;
                } else {
                    i9 = R.xml.default_workspace_5x4;
                }
                arrayList3.add(new InvariantDeviceProfile("Nexus 4 296", 296.0f, 491.33f, i7, 4, 3, 3, 4, 58.0f, 11.0f, i8, f7, i9));
                if (i6 != 0) {
                    i10 = i6;
                } else {
                    i10 = 5;
                }
                if (z7) {
                    i11 = 4;
                } else {
                    i11 = 5;
                }
                if (z7) {
                    f8 = 58.0f;
                } else {
                    f8 = 56.0f;
                }
                if (m8146a()) {
                    i12 = R.xml.default_workspace_5x4_samsung;
                } else {
                    i12 = R.xml.default_workspace_5x4;
                }
                arrayList3.add(new InvariantDeviceProfile("Nexus 4 359", 359.0f, 567.0f, i10, 4, 3, 3, 4, 58.0f, 11.0f, i11, f8, i12));
                if (i6 != 0) {
                    i13 = i6;
                } else if (z5 && z6) {
                    i13 = 6;
                } else {
                    i13 = 5;
                }
                if (z7) {
                    i14 = 4;
                } else {
                    i14 = 5;
                }
                if (z7) {
                    f9 = 58.0f;
                } else {
                    f9 = 56.0f;
                }
                if (m8146a()) {
                    if (z5 && z6) {
                        i15 = R.xml.default_workspace_6x4_samsung;
                    } else {
                        i15 = R.xml.default_workspace_5x4_samsung;
                    }
                } else if (z5 && z6) {
                    i15 = R.xml.default_workspace_6x4;
                } else {
                    i15 = R.xml.default_workspace_5x4;
                }
                arrayList3.add(new InvariantDeviceProfile("Nexus 5", 335.0f, 567.0f, i13, 4, 3, 3, 4, 58.0f, 11.0f, i14, f9, i15));
                if (i6 != 0) {
                    i16 = i6;
                } else {
                    i16 = 6;
                }
                if (z7) {
                    i17 = 4;
                } else {
                    i17 = 5;
                }
                if (m8146a()) {
                    i18 = R.xml.default_workspace_6x4_samsung;
                } else {
                    i18 = R.xml.default_workspace_6x4;
                }
                arrayList3.add(new InvariantDeviceProfile("Large Phone", 406.0f, 694.0f, i16, 4, 3, 3, 4, 60.0f, 10.0f, i17, 60.0f, i18));
                if (i6 != 0) {
                    i19 = i6;
                } else {
                    i19 = 6;
                }
                if (z7) {
                    i20 = 4;
                } else {
                    i20 = 5;
                }
                if (m8146a()) {
                    i21 = R.xml.default_workspace_6x4_samsung;
                } else {
                    i21 = R.xml.default_workspace_6x4;
                }
                arrayList3.add(new InvariantDeviceProfile("New Large Phone", 450.0f, 950.0f, i19, 4, 3, 3, 4, 60.0f, 10.0f, i20, 60.0f, i21));
                if (i6 != 0) {
                    i22 = i6;
                } else {
                    i22 = 5;
                }
                if (z7) {
                    i23 = 4;
                } else {
                    i23 = 5;
                }
                if (m8146a()) {
                    i24 = R.xml.default_workspace_5x4_samsung;
                } else {
                    i24 = R.xml.default_workspace_5x4;
                }
                arrayList3.add(new InvariantDeviceProfile("Tablet", 575.0f, 904.0f, i22, 4, 3, 3, 4, 60.0f, 10.0f, i23, 60.0f, i24));
                Collections.sort(arrayList3, new DeviceProfileDistanceComparator(this, fMin, fMin2));
                f10 = this.f16727s;
                f11 = this.f16728t;
                invariantDeviceProfile = (InvariantDeviceProfile) arrayList3.get(0);
                arrayList = arrayList3;
                if (((float) Math.hypot(invariantDeviceProfile.f16727s - f10, invariantDeviceProfile.f16728t - f11)) == 0.0f) {
                    point3 = point;
                    point4 = point2;
                    arrayList2 = arrayList;
                } else {
                    invariantDeviceProfile = new InvariantDeviceProfile();
                    invariantDeviceProfile.f16709a = 0.62f;
                    invariantDeviceProfile.f16710b = SettingsColumns.f15703b;
                    invariantDeviceProfile.f16731w = false;
                    invariantDeviceProfile.f16732x = false;
                    invariantDeviceProfile.f16733y = 0;
                    i25 = 0;
                    f12 = 0.0f;
                    while (i25 < arrayList.size() && i25 < 3.0f) {
                        ArrayList arrayList4 = arrayList;
                        InvariantDeviceProfile invariantDeviceProfile2 = (InvariantDeviceProfile) arrayList4.get(i25);
                        float f13 = f10;
                        InvariantDeviceProfile invariantDeviceProfile3 = new InvariantDeviceProfile(invariantDeviceProfile2.f16721m, invariantDeviceProfile2.f16727s, invariantDeviceProfile2.f16728t, invariantDeviceProfile2.f16711c, invariantDeviceProfile2.f16712d, invariantDeviceProfile2.f16713e, invariantDeviceProfile2.f16714f, invariantDeviceProfile2.f16722n, invariantDeviceProfile2.f16715g, invariantDeviceProfile2.f16718j, invariantDeviceProfile2.f16719k, invariantDeviceProfile2.f16723o, invariantDeviceProfile2.f16724p);
                        Point point8 = point;
                        Point point9 = point2;
                        fHypot = (float) Math.hypot(invariantDeviceProfile3.f16727s - f13, invariantDeviceProfile3.f16728t - f11);
                        if (Float.compare(fHypot, 0.0f) == 0) {
                            fPow = Float.POSITIVE_INFINITY;
                        } else {
                            fPow = (float) (((double) 100000.0f) / Math.pow(fHypot, 5.0f));
                        }
                        f12 += fPow;
                        float f14 = invariantDeviceProfile3.f16715g * fPow;
                        invariantDeviceProfile3.f16715g = f14;
                        float f15 = invariantDeviceProfile3.f16718j * fPow;
                        invariantDeviceProfile3.f16718j = f15;
                        float f16 = invariantDeviceProfile3.f16723o * fPow;
                        invariantDeviceProfile3.f16723o = f16;
                        invariantDeviceProfile.f16715g += f14;
                        invariantDeviceProfile.f16718j += f15;
                        invariantDeviceProfile.f16723o += f16;
                        i25++;
                        arrayList = arrayList4;
                        point2 = point9;
                        f10 = f13;
                        point = point8;
                    }
                    point3 = point;
                    point4 = point2;
                    arrayList2 = arrayList;
                    float f17 = 1.0f / f12;
                    invariantDeviceProfile.f16715g *= f17;
                    invariantDeviceProfile.f16718j *= f17;
                    invariantDeviceProfile.f16723o *= f17;
                }
                InvariantDeviceProfile invariantDeviceProfile4 = (InvariantDeviceProfile) arrayList2.get(0);
                String str = invariantDeviceProfile4.f16721m;
                this.f16711c = invariantDeviceProfile4.f16711c;
                this.f16712d = invariantDeviceProfile4.f16712d;
                int i29 = invariantDeviceProfile4.f16719k;
                this.f16719k = i29;
                this.f16720l = i29 / 2;
                this.f16724p = invariantDeviceProfile4.f16724p;
                this.f16713e = invariantDeviceProfile4.f16713e;
                this.f16714f = invariantDeviceProfile4.f16714f;
                this.f16722n = invariantDeviceProfile4.f16722n;
                point5 = new Point();
                if (Utilities.f16754o) {
                    defaultDisplay.getRealSize(point5);
                } else {
                    defaultDisplay.getSize(point5);
                }
                int iMin2 = Math.min(point5.x, point5.y);
                int iMax = Math.max(point5.x, point5.y);
                this.f16715g = invariantDeviceProfile.f16715g;
                iMin = (int) ((Math.min(iMin2, iMax) / 4.0f) * this.f16709a);
                this.f16716h = iMin;
                this.f16718j = invariantDeviceProfile.f16718j;
                this.f16723o = invariantDeviceProfile.f16723o;
                iArr = new int[]{120, 160, 213, 240, 320, 480, 640};
                i26 = 640;
                for (i27 = 6; i27 >= 0; i27--) {
                    i28 = iArr[i27];
                    if ((i28 * 48.0f) / 160.0f >= iMin) {
                        i26 = i28;
                    }
                }
                this.f16717i = i26;
                Point point10 = point4;
                Point point11 = point3;
                this.f16725q = new DeviceProfile(context, this, point11, point10, iMax, iMin2, true);
                this.f16726r = new DeviceProfile(context, this, point11, point10, iMin2, iMax, false);
            }
        } catch (Throwable unused) {
        }
        this.f16731w = z5;
        if (z5) {
            boolean z9 = Utilities.f16753n;
        }
        this.f16732x = this.f16734z.f137a.getBoolean("hide_navigation", true);
        if (z5) {
            context2 = this.f16730v;
            resources = context2.getResources();
            identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                dimensionPixelSize = resources.getDimensionPixelSize(identifier);
            } else {
                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.navigation_bar_height);
            }
        } else {
            dimensionPixelSize = 0;
        }
        this.f16733y = dimensionPixelSize;
        ActivityManager activityManager2 = (ActivityManager) this.f16730v.getSystemService("activity");
        if (Utilities.f16753n) {
            this.f16734z.f137a.edit().putBoolean("notFirstRunning", true).apply();
            this.f16734z.f137a.edit().putBoolean("preference_blur_widget", false).apply();
        } else {
            this.f16734z.f137a.edit().putBoolean("notFirstRunning", true).apply();
            this.f16734z.f137a.edit().putBoolean("preference_blur_widget", false).apply();
        }
        i6 = this.f16734z.f137a.getInt("use_grid_size", 0);
        f6 = this.f16734z.f137a.getFloat("icon_padding_edge", 0.0f);
        this.f16709a = f6;
        if (f6 == 0.0f) {
            Resources resources3 = context.getResources();
            TypedValue typedValue2 = new TypedValue();
            resources3.getValue(R.dimen.icon_padding_percent, typedValue2, true);
            this.f16709a = typedValue2.getFloat();
        }
        defaultDisplay = this.f16729u.getDefaultDisplay();
        DisplayMetrics displayMetrics3 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics3);
        point = new Point();
        point2 = new Point();
        defaultDisplay.getCurrentSizeRange(point, point2);
        fMin = Math.min(point.x, point.y) / (displayMetrics3.densityDpi / 160.0f);
        this.f16727s = fMin;
        fMin2 = Math.min(point2.x, point2.y) / (displayMetrics3.densityDpi / 160.0f);
        this.f16728t = fMin2;
        if (fMin2 / fMin <= 1.85f) {
            z6 = true;
        } else {
            z6 = true;
        }
        ArrayList arrayList5 = new ArrayList();
        if (i6 != 0) {
            i7 = i6;
        } else {
            i7 = 5;
        }
        z7 = this.f16710b;
        if (z7) {
            i8 = 4;
        } else {
            i8 = 5;
        }
        if (z7) {
            f7 = 58.0f;
        } else {
            f7 = 56.0f;
        }
        if (m8146a()) {
            i9 = R.xml.default_workspace_5x4_samsung;
        } else {
            i9 = R.xml.default_workspace_5x4;
        }
        arrayList5.add(new InvariantDeviceProfile("Nexus 4 296", 296.0f, 491.33f, i7, 4, 3, 3, 4, 58.0f, 11.0f, i8, f7, i9));
        if (i6 != 0) {
            i10 = i6;
        } else {
            i10 = 5;
        }
        if (z7) {
            i11 = 4;
        } else {
            i11 = 5;
        }
        if (z7) {
            f8 = 58.0f;
        } else {
            f8 = 56.0f;
        }
        if (m8146a()) {
            i12 = R.xml.default_workspace_5x4_samsung;
        } else {
            i12 = R.xml.default_workspace_5x4;
        }
        arrayList5.add(new InvariantDeviceProfile("Nexus 4 359", 359.0f, 567.0f, i10, 4, 3, 3, 4, 58.0f, 11.0f, i11, f8, i12));
        if (i6 != 0) {
            i13 = i6;
        } else if (z5) {
            i13 = 5;
        } else {
            i13 = 5;
        }
        if (z7) {
            i14 = 4;
        } else {
            i14 = 5;
        }
        if (z7) {
            f9 = 58.0f;
        } else {
            f9 = 56.0f;
        }
        if (m8146a()) {
            if (z5) {
                i15 = R.xml.default_workspace_5x4_samsung;
            } else {
                i15 = R.xml.default_workspace_5x4_samsung;
            }
        } else if (z5) {
            i15 = R.xml.default_workspace_5x4;
        } else {
            i15 = R.xml.default_workspace_5x4;
        }
        arrayList5.add(new InvariantDeviceProfile("Nexus 5", 335.0f, 567.0f, i13, 4, 3, 3, 4, 58.0f, 11.0f, i14, f9, i15));
        if (i6 != 0) {
            i16 = i6;
        } else {
            i16 = 6;
        }
        if (z7) {
            i17 = 4;
        } else {
            i17 = 5;
        }
        if (m8146a()) {
            i18 = R.xml.default_workspace_6x4_samsung;
        } else {
            i18 = R.xml.default_workspace_6x4;
        }
        arrayList5.add(new InvariantDeviceProfile("Large Phone", 406.0f, 694.0f, i16, 4, 3, 3, 4, 60.0f, 10.0f, i17, 60.0f, i18));
        if (i6 != 0) {
            i19 = i6;
        } else {
            i19 = 6;
        }
        if (z7) {
            i20 = 4;
        } else {
            i20 = 5;
        }
        if (m8146a()) {
            i21 = R.xml.default_workspace_6x4_samsung;
        } else {
            i21 = R.xml.default_workspace_6x4;
        }
        arrayList5.add(new InvariantDeviceProfile("New Large Phone", 450.0f, 950.0f, i19, 4, 3, 3, 4, 60.0f, 10.0f, i20, 60.0f, i21));
        if (i6 != 0) {
            i22 = i6;
        } else {
            i22 = 5;
        }
        if (z7) {
            i23 = 4;
        } else {
            i23 = 5;
        }
        if (m8146a()) {
            i24 = R.xml.default_workspace_5x4_samsung;
        } else {
            i24 = R.xml.default_workspace_5x4;
        }
        arrayList5.add(new InvariantDeviceProfile("Tablet", 575.0f, 904.0f, i22, 4, 3, 3, 4, 60.0f, 10.0f, i23, 60.0f, i24));
        Collections.sort(arrayList5, new DeviceProfileDistanceComparator(this, fMin, fMin2));
        f10 = this.f16727s;
        f11 = this.f16728t;
        invariantDeviceProfile = (InvariantDeviceProfile) arrayList5.get(0);
        arrayList = arrayList5;
        if (((float) Math.hypot(invariantDeviceProfile.f16727s - f10, invariantDeviceProfile.f16728t - f11)) == 0.0f) {
            point3 = point;
            point4 = point2;
            arrayList2 = arrayList;
        } else {
            invariantDeviceProfile = new InvariantDeviceProfile();
            invariantDeviceProfile.f16709a = 0.62f;
            invariantDeviceProfile.f16710b = SettingsColumns.f15703b;
            invariantDeviceProfile.f16731w = false;
            invariantDeviceProfile.f16732x = false;
            invariantDeviceProfile.f16733y = 0;
            i25 = 0;
            f12 = 0.0f;
            while (i25 < arrayList.size()) {
                ArrayList arrayList6 = arrayList;
                InvariantDeviceProfile invariantDeviceProfile5 = (InvariantDeviceProfile) arrayList6.get(i25);
                float f18 = f10;
                InvariantDeviceProfile invariantDeviceProfile6 = new InvariantDeviceProfile(invariantDeviceProfile5.f16721m, invariantDeviceProfile5.f16727s, invariantDeviceProfile5.f16728t, invariantDeviceProfile5.f16711c, invariantDeviceProfile5.f16712d, invariantDeviceProfile5.f16713e, invariantDeviceProfile5.f16714f, invariantDeviceProfile5.f16722n, invariantDeviceProfile5.f16715g, invariantDeviceProfile5.f16718j, invariantDeviceProfile5.f16719k, invariantDeviceProfile5.f16723o, invariantDeviceProfile5.f16724p);
                Point point12 = point;
                Point point13 = point2;
                fHypot = (float) Math.hypot(invariantDeviceProfile6.f16727s - f18, invariantDeviceProfile6.f16728t - f11);
                if (Float.compare(fHypot, 0.0f) == 0) {
                    fPow = Float.POSITIVE_INFINITY;
                } else {
                    fPow = (float) (((double) 100000.0f) / Math.pow(fHypot, 5.0f));
                }
                f12 += fPow;
                float f19 = invariantDeviceProfile6.f16715g * fPow;
                invariantDeviceProfile6.f16715g = f19;
                float f110 = invariantDeviceProfile6.f16718j * fPow;
                invariantDeviceProfile6.f16718j = f110;
                float f111 = invariantDeviceProfile6.f16723o * fPow;
                invariantDeviceProfile6.f16723o = f111;
                invariantDeviceProfile.f16715g += f19;
                invariantDeviceProfile.f16718j += f110;
                invariantDeviceProfile.f16723o += f111;
                i25++;
                arrayList = arrayList6;
                point2 = point13;
                f10 = f18;
                point = point12;
            }
            point3 = point;
            point4 = point2;
            arrayList2 = arrayList;
            float f112 = 1.0f / f12;
            invariantDeviceProfile.f16715g *= f112;
            invariantDeviceProfile.f16718j *= f112;
            invariantDeviceProfile.f16723o *= f112;
        }
        InvariantDeviceProfile invariantDeviceProfile7 = (InvariantDeviceProfile) arrayList2.get(0);
        String str2 = invariantDeviceProfile7.f16721m;
        this.f16711c = invariantDeviceProfile7.f16711c;
        this.f16712d = invariantDeviceProfile7.f16712d;
        int i210 = invariantDeviceProfile7.f16719k;
        this.f16719k = i210;
        this.f16720l = i210 / 2;
        this.f16724p = invariantDeviceProfile7.f16724p;
        this.f16713e = invariantDeviceProfile7.f16713e;
        this.f16714f = invariantDeviceProfile7.f16714f;
        this.f16722n = invariantDeviceProfile7.f16722n;
        point5 = new Point();
        if (Utilities.f16754o) {
            defaultDisplay.getRealSize(point5);
        } else {
            defaultDisplay.getSize(point5);
        }
        int iMin3 = Math.min(point5.x, point5.y);
        int iMax2 = Math.max(point5.x, point5.y);
        this.f16715g = invariantDeviceProfile.f16715g;
        iMin = (int) ((Math.min(iMin3, iMax2) / 4.0f) * this.f16709a);
        this.f16716h = iMin;
        this.f16718j = invariantDeviceProfile.f16718j;
        this.f16723o = invariantDeviceProfile.f16723o;
        iArr = new int[]{120, 160, 213, 240, 320, 480, 640};
        i26 = 640;
        while (i27 >= 0) {
            i28 = iArr[i27];
            if ((i28 * 48.0f) / 160.0f >= iMin) {
                i26 = i28;
            }
        }
        this.f16717i = i26;
        Point point14 = point4;
        Point point15 = point3;
        this.f16725q = new DeviceProfile(context, this, point15, point14, iMax2, iMin3, true);
        this.f16726r = new DeviceProfile(context, this, point15, point14, iMin3, iMax2, false);
    }
}
