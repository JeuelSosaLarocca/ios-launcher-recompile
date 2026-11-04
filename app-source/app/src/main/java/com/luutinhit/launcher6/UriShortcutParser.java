package com.luutinhit.launcher6;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import java.net.URISyntaxException;

/* JADX INFO: renamed from: com.luutinhit.launcher6.S */
/* JADX INFO: loaded from: classes.dex */
public final class UriShortcutParser extends FolderParser {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public UriShortcutParser(com.luutinhit.launcher6.AutoInstallsLayout p0, java.lang.Object p1, int p2) {
        super(p0, p1, p2);
    }
    @Override // com.luutinhit.launcher6.FolderParser
    /* JADX INFO: renamed from: b */
    public final Intent mo7795b(XmlResourceParser xmlResourceParser) {
        try {
            return Intent.parseUri(AutoInstallsLayout.getAttributeValue(xmlResourceParser, "uri"), 0);
        } catch (URISyntaxException unused) {
            return null;
        }
    }
}
