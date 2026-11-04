package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.graphics.Rect;
import android.os.Parcel;

/* JADX INFO: renamed from: com.luutinhit.launcher6.i2 */
/* JADX INFO: loaded from: classes.dex */
public final class LauncherAppWidgetProviderInfo extends AppWidgetProviderInfo {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public LauncherAppWidgetProviderInfo(android.os.Parcel p0) {
        super(p0);
    }

    /* JADX INFO: renamed from: j */
    public int f16574j;

    /* JADX INFO: renamed from: k */
    public int f16575k;

    /* JADX INFO: renamed from: l */
    public int f16576l;

    /* JADX INFO: renamed from: m */
    public int f16577m;

    /* JADX INFO: renamed from: b */
    public static LauncherAppWidgetProviderInfo fromProviderInfo(AppWidgetProviderInfo appWidgetProviderInfo) {
        Parcel parcelObtain = Parcel.obtain();
        appWidgetProviderInfo.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo = new LauncherAppWidgetProviderInfo(parcelObtain);
        launcherAppWidgetProviderInfo.initSpans();
        parcelObtain.recycle();
        return launcherAppWidgetProviderInfo;
    }

    /* JADX INFO: renamed from: c */
    public final void initSpans() {
        ComponentName componentName = ((AppWidgetProviderInfo) this).provider;
        if (componentName != null) {
            componentName.getClassName();
            String className = ((AppWidgetProviderInfo) this).provider.getClassName();
            className.getClass();
            switch (className) {
                case "com.luutinhit.launcher6.widget.widgetprovider.WeatherAppWidgetProvider":
                    this.f16576l = 4;
                    this.f16574j = 4;
                    this.f16577m = 2;
                    this.f16575k = 2;
                    break;
                case "com.luutinhit.launcher6.widget.widgetprovider.BatteryWidgetProvider":
                case "com.luutinhit.launcher6.widget.widgetprovider.PictureAppWidgetProvider":
                    this.f16576l = 2;
                    this.f16574j = 2;
                    this.f16577m = 2;
                    this.f16575k = 2;
                    break;
                default:
                    InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
                    DeviceProfile deviceProfile = invariantDeviceProfile.f16726r;
                    float f6 = deviceProfile.f15982H;
                    float f7 = deviceProfile.f15983I;
                    int i6 = invariantDeviceProfile.f16726r.f15983I;
                    Rect defaultPaddingForWidget = AppWidgetHostView.getDefaultPaddingForWidget(LauncherAppState.f16216i, ((AppWidgetProviderInfo) this).provider, null);
                    this.f16574j = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minWidth + defaultPaddingForWidget.left) + defaultPaddingForWidget.right) / f6));
                    int iMax = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minHeight + defaultPaddingForWidget.top) + defaultPaddingForWidget.bottom) / f7));
                    this.f16575k = iMax;
                    int i7 = this.f16574j;
                    if (i7 == 1 && iMax > 1) {
                        i7 = 2;
                    }
                    this.f16574j = i7;
                    this.f16575k = (iMax != 1 || i7 <= 1) ? iMax : 2;
                    ((AppWidgetProviderInfo) this).provider.toString();
                    this.f16576l = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minResizeWidth + defaultPaddingForWidget.left) + defaultPaddingForWidget.right) / f6));
                    this.f16577m = Math.max(1, (int) Math.ceil(((((AppWidgetProviderInfo) this).minResizeHeight + defaultPaddingForWidget.top) + defaultPaddingForWidget.bottom) / f7));
                    ((AppWidgetProviderInfo) this).provider.toString();
                    ((AppWidgetProviderInfo) this).provider.toString();
                    break;
            }
        }
    }
}
