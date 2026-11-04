package com.luutinhit.launcher6;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: com.luutinhit.launcher6.M */
/* JADX INFO: loaded from: classes.dex */
public final class CommonAppResolveParser extends DefaultLayoutParser {

    /* JADX INFO: renamed from: o */
    public /* synthetic */ CommonAppTypeParser f15846o;

    /* JADX WARN: Illegal instructions before constructor call */
    public CommonAppResolveParser(CommonAppTypeParser commonAppTypeParser) {
        super(commonAppTypeParser.mContext, null, commonAppTypeParser, commonAppTypeParser.mContext.getResources(), commonAppTypeParser.mResId, "resolve");
        this.f15846o = commonAppTypeParser;
    }

    @Override // com.luutinhit.launcher6.AutoInstallsLayout
    /* JADX INFO: renamed from: a */
    public final long mo7772a(String str, Intent intent, int i6) {
        if (i6 == 0) {
            CommonAppTypeParser commonAppTypeParser = this.f15846o;
            commonAppTypeParser.parsedIntent = intent;
            commonAppTypeParser.parsedTitle = str;
        }
        return super.mo7772a(str, intent, i6);
    }
}
