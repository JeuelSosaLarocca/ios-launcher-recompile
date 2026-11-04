package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.luutinhit.launcherios.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: com.luutinhit.launcher6.g */
/* JADX INFO: loaded from: classes.dex */
public class AppWidgetParser implements TagParser {


    /* JADX INFO: renamed from: a */
    public /* synthetic */ int f16515a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ AutoInstallsLayout f16516b;

    public /* synthetic */ AppWidgetParser(AutoInstallsLayout autoInstallsLayout, int i6) {
        this.f16515a = i6;
        this.f16516b = autoInstallsLayout;
    }

    @Override // com.luutinhit.launcher6.TagParser
    /* JADX INFO: renamed from: a */
    public final long mo7776a(XmlResourceParser xmlResourceParser){
        ComponentName componentName;
        ActivityInfo activityInfo;
        LayoutParserCallback layoutParserCallback = null;
        ContentValues contentValues = null;
        Bundle bundle = null;
        int depth = 0;
        switch (this.f16515a) {
            case 0:
                AutoInstallsLayout autoInstallsLayout = this.f16516b;
                String attributeValue = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "packageName");
                String attributeValue2 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "className");
                if (TextUtils.isEmpty(attributeValue) || TextUtils.isEmpty(attributeValue2)) {
                    return mo7773b(xmlResourceParser);
                }
                try {
                    try {
                        componentName = new ComponentName(attributeValue, attributeValue2);
                        activityInfo = autoInstallsLayout.f16614b.getActivityInfo(componentName, 0);
                        break;
                    } catch (PackageManager.NameNotFoundException unused) {
                        componentName = new ComponentName(autoInstallsLayout.f16614b.currentToCanonicalPackageNames(new String[]{attributeValue})[0], attributeValue2);
                        activityInfo = autoInstallsLayout.f16614b.getActivityInfo(componentName, 0);
                    }
                    return autoInstallsLayout.mo7772a(activityInfo.loadLabel(autoInstallsLayout.f16614b).toString(), new Intent("android.intent.action.MAIN", (Uri) null).addCategory("android.intent.category.LAUNCHER").setComponent(componentName).setFlags(270532608), 0);
                } catch (PackageManager.NameNotFoundException unused2) {
                    return -1L;
                }
            case 1:
                AutoInstallsLayout autoInstallsLayout2 = this.f16516b;
                String attributeValue3 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "packageName");
                String attributeValue4 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "className");
                long jInsertAndCheck = -1;
                if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(attributeValue4)) {
                    ComponentName componentName2 = new ComponentName(attributeValue3, attributeValue4);
                    try {
                        autoInstallsLayout2.f16614b.getReceiverInfo(componentName2, 0);
                        while (true) {
                            int next = xmlResourceParser.next();
                            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                                Context context = autoInstallsLayout2.f16618f;
                                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                                AppWidgetHost appWidgetHost = autoInstallsLayout2.f16619g;
                                int iAllocateAppWidgetId = appWidgetHost.allocateAppWidgetId();
                                if (appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, componentName2)) {
                                    contentValues.put("itemType", (Integer) 4);
                                    contentValues.put("appWidgetId", Integer.valueOf(iAllocateAppWidgetId));
                                    contentValues.put("appWidgetProvider", componentName2.flattenToString());
                                    contentValues.put("_id", Long.valueOf(layoutParserCallback.generateNewItemId()));
                                    jInsertAndCheck = layoutParserCallback.insertAndCheck(autoInstallsLayout2.f16625m, contentValues);
                                    if (jInsertAndCheck < 0) {
                                        appWidgetHost.deleteAppWidgetId(iAllocateAppWidgetId);
                                    } else if (!bundle.isEmpty()) {
                                        Intent intent = new Intent("com.android.launcher.action.APPWIDGET_DEFAULT_WORKSPACE_CONFIGURE");
                                        intent.setComponent(componentName2);
                                        intent.putExtras(bundle);
                                        intent.putExtra("appWidgetId", iAllocateAppWidgetId);
                                        context.sendBroadcast(intent);
                                    }
                                } else {
                                    componentName2.toString();
                                }
                            } else if (next == 2) {
                                if (!"extra".equals(xmlResourceParser.getName())) {
                                    throw new RuntimeException("Widgets can contain only extras");
                                }
                                String attributeValue5 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "key");
                                String attributeValue6 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "value");
                                if (attributeValue5 == null || attributeValue6 == null) {
                                    throw new RuntimeException("Widget extras must have a key and value");
                                }
                                bundle.putString(attributeValue5, attributeValue6);
                            }
                        }
                    } catch (Exception unused3) {
                        componentName2 = new ComponentName(autoInstallsLayout2.f16614b.currentToCanonicalPackageNames(new String[]{attributeValue3})[0], attributeValue4);
                        try {
                            autoInstallsLayout2.f16614b.getReceiverInfo(componentName2, 0);
                            break;
                        } catch (Exception unused4) {
                        }
                    }
                    ContentValues contentValues2 = autoInstallsLayout2.f16620h;
                    layoutParserCallback = autoInstallsLayout2.f16613a;
                    contentValues2.put("spanX", AutoInstallsLayout.getAttributeValue(xmlResourceParser, "spanX"));
                    String attributeValue7 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "spanY");
                    contentValues = autoInstallsLayout2.f16620h;
                    contentValues.put("spanY", attributeValue7);
                    bundle = new Bundle();
                    depth = xmlResourceParser.getDepth();
                }
                return jInsertAndCheck;
            default:
                String attributeValue8 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "packageName");
                String attributeValue9 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "className");
                if (TextUtils.isEmpty(attributeValue8) || TextUtils.isEmpty(attributeValue9)) {
                    return -1L;
                }
                AutoInstallsLayout autoInstallsLayout3 = this.f16516b;
                autoInstallsLayout3.f16620h.put("restored", (Integer) 2);
                return autoInstallsLayout3.mo7772a(autoInstallsLayout3.f16618f.getString(R.string.package_state_unknown), new Intent("android.intent.action.MAIN", (Uri) null).addCategory("android.intent.category.LAUNCHER").setComponent(new ComponentName(attributeValue8, attributeValue9)).setFlags(270532608), 0);
        }
        return 0L; // jadx: method fell off the end
    }

    /* JADX INFO: renamed from: b */
    public long mo7773b(XmlResourceParser xmlResourceParser) {
        return -1L;
    }
}
