package com.luutinhit.launcher6;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Q */
/* JADX INFO: loaded from: classes.dex */
public final class PartnerFolderParser implements TagParser {

    /* JADX INFO: renamed from: a */
    public /* synthetic */ int f15930a;

    /* JADX INFO: renamed from: b */
    public Object f15931b;

    public PartnerFolderParser(DefaultLayoutParser defaultLayoutParser, int i6) {
        this.f15930a = i6;
        switch (i6) {
            case 1:
                this.f15931b = new AppShortcutWithUriParser(defaultLayoutParser);
                break;
            default:
                this.f15931b = defaultLayoutParser;
                break;
        }
    }

    @Override // com.luutinhit.launcher6.TagParser
    /* JADX INFO: renamed from: a */
    public final long mo7776a(XmlResourceParser xmlResourceParser){
        switch (this.f15930a) {
            case 0:
                DefaultLayoutParser defaultLayoutParser = (DefaultLayoutParser) this.f15931b;
                Partner partner = Partner.get(defaultLayoutParser.f16614b);
                if (partner != null) {
                    String str = (String) partner.f16123k;
                    Resources resources = (Resources) partner.f16124l;
                    int identifier = resources.getIdentifier("partner_folder", "xml", str);
                    if (identifier != 0) {
                        XmlResourceParser xml = resources.getXml(identifier);
                        try { AutoInstallsLayout.beginDocument(xml, "folder"); } catch (XmlPullParserException | IOException jadxEx) { throw com.luutinhit.launcher6.JadxSupport.sneaky(jadxEx); }
                        HashMap map = new HashMap();
                        map.put("favorite", new AppShortcutWithUriParser(defaultLayoutParser));
                        map.put("shortcut", new UriShortcutParser(defaultLayoutParser, resources, 1));
                        return new FolderParser(defaultLayoutParser, map, 0).mo7776a(xml);
                    }
                }
                return -1L;
            default:
                int depth = xmlResourceParser.getDepth();
                long jMo7776a = -1;
                while (true) {
                    int next; try { next = xmlResourceParser.next(); } catch (IOException | XmlPullParserException jadxEx) { throw com.luutinhit.launcher6.JadxSupport.sneaky(jadxEx); }
                    if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                        return jMo7776a;
                    }
                    if (next == 2 && jMo7776a <= -1 && "favorite".equals(xmlResourceParser.getName())) {
                        jMo7776a = ((AppShortcutWithUriParser) this.f15931b).mo7776a(xmlResourceParser);
                    }
                }

        }

    }
}
