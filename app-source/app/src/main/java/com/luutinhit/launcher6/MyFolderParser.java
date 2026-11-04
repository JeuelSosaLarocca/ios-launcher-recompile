package com.luutinhit.launcher6;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: com.luutinhit.launcher6.P */
/* JADX INFO: loaded from: classes.dex */
public final class MyFolderParser extends FolderParser {

    /* JADX INFO: renamed from: d */
    public /* synthetic */ DefaultLayoutParser f15872d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyFolderParser(DefaultLayoutParser defaultLayoutParser) {
        super(defaultLayoutParser, defaultLayoutParser.mo7802f(), 0);
        this.f15872d = defaultLayoutParser;
    }

    @Override // com.luutinhit.launcher6.FolderParser, com.luutinhit.launcher6.TagParser
    /* JADX INFO: renamed from: a */
    public final long mo7776a(XmlResourceParser xmlResourceParser){
        int attributeResourceValue = AutoInstallsLayout.getAttributeResourceValue(xmlResourceParser, "folderItems");
        if (attributeResourceValue != 0) {
            xmlResourceParser = this.f15872d.f16615c.getXml(attributeResourceValue);
            try { AutoInstallsLayout.beginDocument(xmlResourceParser, "folder"); } catch (XmlPullParserException | IOException jadxEx) { throw com.luutinhit.launcher6.JadxSupport.sneaky(jadxEx); }
        }
        return super.mo7776a(xmlResourceParser);
    }
}
