package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHost;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: com.luutinhit.launcher6.k */
/* JADX INFO: loaded from: classes.dex */
public class AutoInstallsLayout {

    /* JADX INFO: renamed from: n */
    public static final String f16612n;

    /* JADX INFO: renamed from: a */
    public LayoutParserCallback f16613a;

    /* JADX INFO: renamed from: b */
    public PackageManager f16614b;

    /* JADX INFO: renamed from: c */
    public Resources f16615c;

    /* JADX INFO: renamed from: d */
    public int f16616d;

    /* JADX INFO: renamed from: e */
    public String f16617e;

    /* JADX INFO: renamed from: f */
    public Context f16618f;

    /* JADX INFO: renamed from: g */
    public AppWidgetHost f16619g;

    /* JADX INFO: renamed from: i */
    public int f16621i;

    /* JADX INFO: renamed from: j */
    public int f16622j;

    /* JADX INFO: renamed from: k */
    public int f16623k;

    /* JADX INFO: renamed from: m */
    public SQLiteDatabase f16625m;

    /* JADX INFO: renamed from: l */
    public long[] mTemp = new long[2];

    /* JADX INFO: renamed from: h */
    public ContentValues f16620h = new ContentValues();

    static {
        Uri uri = Favorites.f15684a;
        f16612n = "hotseat";
    }

    public AutoInstallsLayout(Context context, AppWidgetHost appWidgetHost, LayoutParserCallback layoutParserCallback, Resources resources, int i6, String str) {
        this.f16618f = context;
        this.f16619g = appWidgetHost;
        this.f16613a = layoutParserCallback;
        this.f16614b = context.getPackageManager();
        this.f16617e = str;
        this.f16615c = resources;
        this.f16616d = i6;
        InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
        this.f16621i = invariantDeviceProfile.f16720l;
        this.f16622j = invariantDeviceProfile.f16711c;
        this.f16623k = invariantDeviceProfile.f16712d;
    }

    /* JADX INFO: renamed from: b */
    public static final void beginDocument(XmlResourceParser xmlResourceParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        if (xmlResourceParser.getName().equals(str)) {
            return;
        }
        throw new XmlPullParserException("Unexpected start tag: found " + xmlResourceParser.getName() + ", expected " + str);
    }

    /* JADX INFO: renamed from: c */
    public static AutoInstallsLayout get(Context context, String str, Resources resources, AppWidgetHost appWidgetHost, LayoutParserCallback layoutParserCallback) {
        InvariantDeviceProfile invariantDeviceProfile = LauncherAppState.getInstance().f16222e;
        Locale locale = Locale.ENGLISH;
        int i6 = invariantDeviceProfile.f16712d;
        StringBuilder sb = new StringBuilder("default_layout_");
        sb.append(i6);
        sb.append("x");
        int i7 = invariantDeviceProfile.f16711c;
        sb.append(i7);
        sb.append("_h");
        sb.append(invariantDeviceProfile.f16719k);
        int identifier = resources.getIdentifier(sb.toString(), "xml", str);
        if (identifier == 0) {
            identifier = resources.getIdentifier("default_layout_" + invariantDeviceProfile.f16712d + "x" + i7, "xml", str);
        }
        if (identifier == 0) {
            identifier = resources.getIdentifier("default_layout", "xml", str);
        }
        int i8 = identifier;
        if (i8 == 0) {
            return null;
        }
        return new AutoInstallsLayout(context, appWidgetHost, layoutParserCallback, resources, i8, "workspace");
    }

    /* JADX INFO: renamed from: d */
    public static int getAttributeResourceValue(XmlResourceParser xmlResourceParser, String str) {
        int attributeResourceValue = xmlResourceParser.getAttributeResourceValue("http://schemas.android.com/apk/res-auto/com.luutinhit.launcher6", str, 0);
        return attributeResourceValue == 0 ? xmlResourceParser.getAttributeResourceValue(null, str, 0) : attributeResourceValue;
    }

    /* JADX INFO: renamed from: e */
    public static String getAttributeValue(XmlResourceParser xmlResourceParser, String str) {
        String attributeValue = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res-auto/com.luutinhit.launcher6", str);
        return attributeValue == null ? xmlResourceParser.getAttributeValue(null, str) : attributeValue;
    }

    /* JADX INFO: renamed from: a */
    public long mo7772a(String str, Intent intent, int i6) {
        LayoutParserCallback layoutParserCallback = this.f16613a;
        long jGenerateNewItemId = layoutParserCallback.generateNewItemId();
        String uri = intent.toUri(0);
        ContentValues contentValues = this.f16620h;
        contentValues.put("intent", uri);
        contentValues.put("title", str);
        contentValues.put("itemType", Integer.valueOf(i6));
        contentValues.put("spanX", (Integer) 1);
        contentValues.put("spanY", (Integer) 1);
        contentValues.put("_id", Long.valueOf(jGenerateNewItemId));
        if (layoutParserCallback.insertAndCheck(this.f16625m, contentValues) < 0) {
            return -1L;
        }
        return jGenerateNewItemId;
    }

    /* JADX INFO: renamed from: f */
    public HashMap mo7802f() {
        HashMap map = new HashMap();
        map.put("appicon", new AppWidgetParser(this, 0));
        map.put("autoinstall", new AppWidgetParser(this, 2));
        map.put("shortcut", new FolderParser(this, this.f16615c, 1));
        return map;
    }

    /* JADX INFO: renamed from: g */
    public HashMap mo7803g() {
        HashMap map = new HashMap();
        map.put("appicon", new AppWidgetParser(this, 0));
        map.put("autoinstall", new AppWidgetParser(this, 2));
        map.put("folder", new FolderParser(this, mo7802f(), 0));
        map.put("appwidget", new AppWidgetParser(this, 1));
        map.put("shortcut", new FolderParser(this, this.f16615c, 1));
        return map;
    }

    /* JADX INFO: renamed from: h */
    public void mo7804h(XmlResourceParser xmlResourceParser, long[] jArr) {
        long j6 = 0;
        if (!f16612n.equals(getAttributeValue(xmlResourceParser, "container"))) {
            jArr[0] = -100;
            String attributeValue = getAttributeValue(xmlResourceParser, "screen");
            if (attributeValue != null && !attributeValue.isEmpty()) {
                j6 = Long.parseLong(attributeValue);
            }
            jArr[1] = j6;
            return;
        }
        jArr[0] = -101;
        String attributeValue2 = getAttributeValue(xmlResourceParser, "rank");
        if (attributeValue2 != null && !attributeValue2.isEmpty()) {
            j6 = Long.parseLong(attributeValue2);
        }
        if (j6 >= this.f16621i) {
            j6++;
        }
        jArr[1] = j6;
    }

    /* JADX INFO: renamed from: i */
    public final int parseLayout(int i6, ArrayList arrayList) throws XmlPullParserException, IOException {
        int i7;
        int i8;
        XmlResourceParser xml = this.f16615c.getXml(i6);
        beginDocument(xml, this.f16617e);
        int depth = xml.getDepth();
        HashMap mapMo7803g = mo7803g();
        int i9 = 0;
        while (true) {
            int next = xml.next();
            if (next == 3 && xml.getDepth() <= depth) {
                break;
            }
            int layout = 1;
            if (next == 1) {
                break;
            }
            if (next == 2) {
                if ("include".equals(xml.getName())) {
                    int attributeResourceValue = getAttributeResourceValue(xml, "workspace");
                    layout = attributeResourceValue != 0 ? parseLayout(attributeResourceValue, arrayList) : 0;
                } else {
                    ContentValues contentValues = this.f16620h;
                    contentValues.clear();
                    long[] jArr = this.mTemp;
                    mo7804h(xml, jArr);
                    long j6 = jArr[0];
                    long j7 = jArr[1];
                    contentValues.put("container", Long.valueOf(j6));
                    contentValues.put("screen", Long.valueOf(j7));
                    String attributeValue = getAttributeValue(xml, "x");
                    if (!TextUtils.isEmpty(attributeValue) && (i8 = Integer.parseInt(attributeValue)) < 0) {
                        attributeValue = Integer.toString(this.f16623k + i8);
                    }
                    contentValues.put("cellX", attributeValue);
                    String attributeValue2 = getAttributeValue(xml, "y");
                    if (!TextUtils.isEmpty(attributeValue2) && (i7 = Integer.parseInt(attributeValue2)) < 0) {
                        attributeValue2 = Integer.toString(this.f16622j + i7);
                    }
                    contentValues.put("cellY", attributeValue2);
                    TagParser tagParser = (TagParser) mapMo7803g.get(xml.getName());
                    if (tagParser == null) {
                        xml.getName();
                    } else if (tagParser.mo7776a(xml) >= 0) {
                        if (!arrayList.contains(Long.valueOf(j7)) && j6 == -100) {
                            arrayList.add(Long.valueOf(j7));
                        }
                    }
                }
                i9 += layout;
            }
        }
        return i9;
    }
}
