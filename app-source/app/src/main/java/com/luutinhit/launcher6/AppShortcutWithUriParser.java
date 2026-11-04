package com.luutinhit.launcher6;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.net.URISyntaxException;
import java.util.List;

/* JADX INFO: renamed from: com.luutinhit.launcher6.O */
/* JADX INFO: loaded from: classes.dex */
public final class AppShortcutWithUriParser extends AppWidgetParser {

    /* JADX INFO: renamed from: c */
    public /* synthetic */ DefaultLayoutParser f15858c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppShortcutWithUriParser(DefaultLayoutParser defaultLayoutParser) {
        super(defaultLayoutParser, 0);
        this.f15858c = defaultLayoutParser;
    }

    @Override // com.luutinhit.launcher6.AppWidgetParser
    /* JADX INFO: renamed from: b */
    public final long mo7773b(XmlResourceParser xmlResourceParser) {
        String attributeValue = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "uri");
        if (!TextUtils.isEmpty(attributeValue)) {
            try {
                Intent uri = Intent.parseUri(attributeValue, 0);
                DefaultLayoutParser defaultLayoutParser = this.f15858c;
                ResolveInfo resolveInfoResolveActivity = defaultLayoutParser.f16614b.resolveActivity(uri, 65536);
                PackageManager packageManager = defaultLayoutParser.f16614b;
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(uri, 65536);
                int i6 = 0;
                while (true) {
                    if (i6 >= listQueryIntentActivities.size()) {
                        int size = listQueryIntentActivities.size();
                        ResolveInfo resolveInfo = null;
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size) {
                                resolveInfoResolveActivity = resolveInfo;
                                break;
                            }
                            try {
                                if ((packageManager.getApplicationInfo(listQueryIntentActivities.get(i7).activityInfo.packageName, 0).flags & 1) != 0) {
                                    if (resolveInfo == null) {
                                        resolveInfo = listQueryIntentActivities.get(i7);
                                    }
                                    resolveInfoResolveActivity = null;
                                    break;
                                }
                                i7++;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                        }
                        if (resolveInfoResolveActivity != null) {
                            break;
                        }
                        uri.toString();
                        return -1L;
                    }
                    ResolveInfo resolveInfo2 = listQueryIntentActivities.get(i6);
                    if (resolveInfo2.activityInfo.name.equals(resolveInfoResolveActivity.activityInfo.name) && resolveInfo2.activityInfo.packageName.equals(resolveInfoResolveActivity.activityInfo.packageName)) {
                        break;
                    }
                    i6++;
                }
                ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(activityInfo.packageName);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(270532608);
                    return defaultLayoutParser.mo7772a(activityInfo.loadLabel(packageManager).toString(), launchIntentForPackage, 0);
                }
            } catch (URISyntaxException unused2) {
            }
        }
        return -1L;
    }
}
