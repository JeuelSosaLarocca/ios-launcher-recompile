package com.luutinhit.launcher6;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Keep;
import com.luutinhit.launcherios.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class CommonAppTypeParser implements LayoutParserCallback {
    public static final int RESTORE_FLAG_BIT_SHIFT = 4;
    public static final int SUPPORTED_TYPE_COUNT = 7;
    public static final String TAG = "CommonAppTypeParser";
    Context mContext;
    public long mItemId;
    int mResId;
    Intent parsedIntent;
    String parsedTitle;
    ContentValues parsedValues;

    public CommonAppTypeParser(long j6, int i6, Context context) {
        this.mItemId = j6;
        this.mContext = context;
        this.mResId = getResourceForItemType(i6);
    }

    public static int decodeItemTypeFromFlag(int i6) {
        return (i6 & 240) >> 4;
    }

    public static int encodeItemTypeToFlag(int i6) {
        return i6 << 4;
    }

    public static int getResourceForItemType(int i6) {
        switch (i6) {
            case 1:
                return R.xml.app_target_phone;
            case 2:
                return R.xml.app_target_messenger;
            case 3:
                return R.xml.app_target_email;
            case 4:
                return R.xml.app_target_browser;
            case 5:
                return R.xml.app_target_gallery;
            case 6:
                return R.xml.app_target_camera;
            default:
                return 0;
        }
    }

    public boolean findDefaultApp() {
        if (this.mResId == 0) {
            return false;
        }
        this.parsedIntent = null;
        this.parsedValues = null;
        CommonAppResolveParser commonAppResolveParser = new CommonAppResolveParser(this);
        XmlResourceParser xml = commonAppResolveParser.f16615c.getXml(commonAppResolveParser.f16616d);
        try {
            AutoInstallsLayout.beginDocument(xml, commonAppResolveParser.f16617e);
            AppShortcutWithUriParser appShortcutWithUriParser = new AppShortcutWithUriParser(commonAppResolveParser);
            int depth = xml.getDepth();
            long jMo7776a = -1;
            while (true) {
                int next = xml.next();
                if (next == 3 && xml.getDepth() <= depth) {
                    break;
                }
                if (next == 2 && jMo7776a <= -1 && "favorite".equals(xml.getName())) {
                    jMo7776a = appShortcutWithUriParser.mo7776a(xml);
                }
            }
        } catch (IOException | XmlPullParserException unused) {
        }
        xml.close();
        return (this.parsedValues == null || this.parsedIntent == null) ? false : true;
    }

    @Override // com.luutinhit.launcher6.LayoutParserCallback
    public long generateNewItemId() {
        return this.mItemId;
    }

    @Override // com.luutinhit.launcher6.LayoutParserCallback
    public long insertAndCheck(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        this.parsedValues = contentValues;
        contentValues.put("iconType", (Integer) null);
        contentValues.put("iconPackage", (String) null);
        contentValues.put("iconResource", (String) null);
        contentValues.put("icon", (byte[]) null);
        return 1L;
    }
}
