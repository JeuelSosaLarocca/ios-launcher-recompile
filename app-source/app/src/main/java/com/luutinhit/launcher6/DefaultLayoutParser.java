package com.luutinhit.launcher6;

import android.appwidget.AppWidgetHost;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.util.HashMap;

/* JADX INFO: renamed from: com.luutinhit.launcher6.T */
/* JADX INFO: loaded from: classes.dex */
public class DefaultLayoutParser extends AutoInstallsLayout {

    /** Pass-through constructor R8 removed (subclasses called the grandparent directly). */
    public DefaultLayoutParser(android.content.Context p0, android.appwidget.AppWidgetHost p1, com.luutinhit.launcher6.LayoutParserCallback p2, android.content.res.Resources p3, int p4, java.lang.String p5) {
        super(p0, p1, p2, p3, p4, p5);
    }
    public DefaultLayoutParser(Context context, AppWidgetHost appWidgetHost, LayoutParserCallback layoutParserCallback, Resources resources, int i6) {
        super(context, appWidgetHost, layoutParserCallback, resources, i6, "favorites");
    }

    @Override // com.luutinhit.launcher6.AutoInstallsLayout
    /* JADX INFO: renamed from: f */
    public final HashMap mo7802f() {
        HashMap map = new HashMap();
        map.put("favorite", new AppShortcutWithUriParser(this));
        map.put("shortcut", new UriShortcutParser(this, this.f16615c, 1));
        return map;
    }

    @Override // com.luutinhit.launcher6.AutoInstallsLayout
    /* JADX INFO: renamed from: g */
    public final HashMap mo7803g() {
        HashMap map = new HashMap();
        map.put("favorite", new AppShortcutWithUriParser(this));
        map.put("appwidget", new AppWidgetParser(this, 1));
        map.put("shortcut", new UriShortcutParser(this, this.f16615c, 1));
        map.put("resolve", new PartnerFolderParser(this, 1));
        map.put("folder", new MyFolderParser(this));
        map.put("partner-folder", new PartnerFolderParser(this, 0));
        return map;
    }

    @Override // com.luutinhit.launcher6.AutoInstallsLayout
    /* JADX INFO: renamed from: h */
    public final void mo7804h(XmlResourceParser xmlResourceParser, long[] jArr) {
        jArr[0] = -100;
        String attributeValue = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "container");
        if (attributeValue != null) {
            jArr[0] = Long.valueOf(attributeValue).longValue();
        }
        jArr[1] = Long.parseLong(AutoInstallsLayout.getAttributeValue(xmlResourceParser, "screen"));
    }
}
