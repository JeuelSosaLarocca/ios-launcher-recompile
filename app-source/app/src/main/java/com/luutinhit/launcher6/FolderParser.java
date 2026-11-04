package com.luutinhit.launcher6;

import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import A3.C0025a;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.HashMap;
import p044w.AbstractC2920f;

/* JADX INFO: renamed from: com.luutinhit.launcher6.h */
/* JADX INFO: loaded from: classes.dex */
public class FolderParser implements TagParser {

    /** Pass-through constructor R8 removed (creation sites called the superclass directly). */
    public FolderParser() {
        super();
    }


    /* JADX INFO: renamed from: a */
    public /* synthetic */ int f16564a;

    /* JADX INFO: renamed from: b */
    public /* synthetic */ AutoInstallsLayout f16565b;

    /* JADX INFO: renamed from: c */
    public Object f16566c;

    public /* synthetic */ FolderParser(AutoInstallsLayout autoInstallsLayout, Object obj, int i6) {
        this.f16564a = i6;
        this.f16565b = autoInstallsLayout;
        this.f16566c = obj;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02af  */
    /* JADX WARN: Code duplicated, block: B:133:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:135:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:137:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x03db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x039e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:0x039e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:95:0x028f  */
    /* JADX WARN: Code duplicated, block: B:98:0x029c  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.luutinhit.launcher6.TagParser
    /* JADX INFO: renamed from: a */
    public long mo7776a(XmlResourceParser xmlResourceParser){
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        String str;
        int i6;
        int next;
        int i7 = 0;
        TagParser tagParser;
        long jMo7776a;
        String str2;
        String str3;
        String str4;
        Cursor cursor;
        Cursor cursorQuery;
        ArrayList arrayList = null;
        int size;
        int i8;
        int i9;
        long jGenerateNewItemId;
        String str5;
        int i10;
        String str6;
        ComponentName componentName = null;
        ActivityInfo activityInfo = null;
        Intent intentMo7795b;
        Resources resources;
        Drawable drawable;
        switch (this.f16564a) {
            case 0:
                int attributeResourceValue = AutoInstallsLayout.getAttributeResourceValue(xmlResourceParser, "title");
                String attributeValue = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "option");
                AutoInstallsLayout autoInstallsLayout = this.f16565b;
                autoInstallsLayout.getClass();
                PackageManager packageManager = autoInstallsLayout.f16614b;
                int iIntValue = !TextUtils.isEmpty(attributeValue) ? Integer.valueOf(attributeValue).intValue() : 0;
                Context context = autoInstallsLayout.f16618f;
                String string = attributeResourceValue != 0 ? autoInstallsLayout.f16615c.getString(attributeResourceValue) : context.getResources().getString(R.string.folder_name);
                ContentValues contentValues = autoInstallsLayout.f16620h;
                contentValues.put("title", string);
                contentValues.put("itemType", (Integer) 2);
                contentValues.put("spanX", (Integer) 1);
                contentValues.put("spanY", (Integer) 1);
                LayoutParserCallback layoutParserCallback = autoInstallsLayout.f16613a;
                String str7 = "_id";
                contentValues.put("_id", Long.valueOf(layoutParserCallback.generateNewItemId()));
                contentValues.put("options", Integer.valueOf(iIntValue));
                long jInsertAndCheck = layoutParserCallback.insertAndCheck(autoInstallsLayout.f16625m, contentValues);
                if (jInsertAndCheck < 0) {
                    return -1L;
                }
                String attributeValue2 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "folderType");
                ArrayList arrayList2 = new ArrayList();
                if (TextUtils.isEmpty(attributeValue2)) {
                    str = null;
                } else {
                    switch (AbstractC2920f.m10114c(8)[Integer.valueOf(attributeValue2).intValue()]) {
                        case 1:
                            str4 = "LearnOffice";
                            break;
                        case 2:
                            str4 = "Game";
                            break;
                        case 3:
                            str4 = "NewsReading";
                            break;
                        case 4:
                            str4 = "ChatCommunication";
                            break;
                        case 5:
                            str4 = "LifeAmusement";
                            break;
                        case 6:
                            str4 = "AudioVideo";
                            break;
                        case 7:
                            str4 = "Theme";
                            break;
                        case 8:
                            str4 = "SystemTools";
                            break;
                        default:
                            throw null;
                    }
                    str = null;
                    try {
                        cursorQuery = context.getContentResolver().query(AppTypeColumns.f15570a, null, "appType=? AND item_type=? ", new String[]{str4, String.valueOf(1)}, null);
                        try {
                            try {
                                arrayList = new ArrayList();
                                if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    arrayList = null;
                                } else {
                                    while (cursorQuery.moveToNext()) {
                                        C0025a c0025a = new C0025a();
                                        cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("appType"));
                                        c0025a.f57a = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("packageName"));
                                        c0025a.f58b = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("className"));
                                        cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("title"));
                                        cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("item_type"));
                                        arrayList.add(c0025a);
                                    }
                                    cursorQuery.close();
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                if (cursorQuery != null) {
                                }
                                arrayList = null;
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                size = arrayList.size();
                                i8 = 0;
                                while (i8 < size) {
                                    Object obj = arrayList.get(i8);
                                    i9 = i8 + 1;
                                    C0025a c0025a2 = (C0025a) obj;
                                    ArrayList arrayList3 = arrayList;
                                    ContentValues contentValues2 = new ContentValues();
                                    jGenerateNewItemId = layoutParserCallback.generateNewItemId();
                                    int i11 = size;
                                    contentValues2.put(str7, Long.valueOf(jGenerateNewItemId));
                                    contentValues2.put("container", Long.valueOf(jInsertAndCheck));
                                    str5 = c0025a2.f57a;
                                    String str8 = c0025a2.f58b;
                                    if (TextUtils.isEmpty(str5)) {
                                        i10 = i9;
                                        str6 = str7;
                                    } else {
                                        i10 = i9;
                                        str6 = str7;
                                    }
                                    layoutParserCallback.insertAndCheck(autoInstallsLayout.f16625m, contentValues2);
                                    if (jGenerateNewItemId >= 0) {
                                        arrayList2.add(Long.valueOf(jGenerateNewItemId));
                                    }
                                    arrayList = arrayList3;
                                    size = i11;
                                    i8 = i10;
                                    str7 = str6;
                                }
                                ContentValues contentValues3 = new ContentValues(contentValues);
                                int depth = xmlResourceParser.getDepth();
                                i6 = 0;
                                while (true) {
                                    next = xmlResourceParser.next();
                                    i7 = next != 3 ? 2 : 2;
                                    if (next != i7) {
                                        contentValues.clear();
                                        contentValues.put("container", Long.valueOf(jInsertAndCheck));
                                        contentValues.put("rank", Integer.valueOf(i6));
                                        tagParser = (TagParser) ((HashMap) this.f16566c).get(xmlResourceParser.getName());
                                        if (tagParser != null) {
                                            throw new RuntimeException("Invalid folder item " + xmlResourceParser.getName());
                                        }
                                        jMo7776a = tagParser.mo7776a(xmlResourceParser);
                                        if (jMo7776a >= 0) {
                                            arrayList2.add(Long.valueOf(jMo7776a));
                                            i6++;
                                        }
                                    }
                                    str = str;
                                }
                            }
                        } catch (Throwable th) {
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                        }
                    } catch (Exception e5) {
                        Throwable e = e5;
                        cursorQuery = null;
                    } catch (Throwable th2) {
                        Throwable th = th2;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw com.luutinhit.launcher6.JadxSupport.sneaky(th);
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    size = arrayList.size();
                    i8 = 0;
                    while (i8 < size) {
                        Object obj2 = arrayList.get(i8);
                        i9 = i8 + 1;
                        C0025a c0025a3 = (C0025a) obj2;
                        ArrayList arrayList4 = arrayList;
                        ContentValues contentValues4 = new ContentValues();
                        jGenerateNewItemId = layoutParserCallback.generateNewItemId();
                        int i12 = size;
                        contentValues4.put(str7, Long.valueOf(jGenerateNewItemId));
                        contentValues4.put("container", Long.valueOf(jInsertAndCheck));
                        str5 = c0025a3.f57a;
                        String str9 = c0025a3.f58b;
                        if (TextUtils.isEmpty(str5) || TextUtils.isEmpty(str9)) {
                            i10 = i9;
                            str6 = str7;
                        } else {
                            i10 = i9;
                            try {
                                componentName = new ComponentName(str5, str9);
                                try {
                                    activityInfo = packageManager.getActivityInfo(componentName, 0);
                                } catch (PackageManager.NameNotFoundException unused) {
                                    componentName = new ComponentName(packageManager.currentToCanonicalPackageNames(new String[]{str5})[0], str9);
                                    activityInfo = packageManager.getActivityInfo(componentName, 0);
                                }
                                break;
                            } catch (PackageManager.NameNotFoundException unused2) {
                            }
                            try {
                                str6 = str7;
                                try {
                                    Intent intent = new Intent("android.intent.action.MAIN");
                                    intent.addCategory("android.intent.category.LAUNCHER");
                                    intent.setFlags(270532608);
                                    intent.setComponent(componentName);
                                    contentValues4.put("intent", intent.toUri(0));
                                    contentValues4.put("title", activityInfo.loadLabel(packageManager).toString());
                                    contentValues4.put("itemType", (Integer) 0);
                                    contentValues4.put("spanX", (Integer) 1);
                                    contentValues4.put("spanY", (Integer) 1);
                                    break;
                                } catch (Exception unused3) {
                                }
                            } catch (Exception unused4) {
                                str6 = str7;
                            }
                        }
                        layoutParserCallback.insertAndCheck(autoInstallsLayout.f16625m, contentValues4);
                        if (jGenerateNewItemId >= 0) {
                            arrayList2.add(Long.valueOf(jGenerateNewItemId));
                        }
                        arrayList = arrayList4;
                        size = i12;
                        i8 = i10;
                        str7 = str6;
                    }
                }
                ContentValues contentValues5 = new ContentValues(contentValues);
                int depth2 = xmlResourceParser.getDepth();
                i6 = 0;
                while (true) {
                    try { next = xmlResourceParser.next(); } catch (IOException | XmlPullParserException jadxEx) { throw com.luutinhit.launcher6.JadxSupport.sneaky(jadxEx); }
                    if (next != 3 && xmlResourceParser.getDepth() <= depth2) {
                        if (arrayList2.size() < 2) {
                            Uri contentUri = Favorites.getContentUri(jInsertAndCheck);
                            if (contentUri.getPathSegments().size() == 1) {
                                str3 = contentUri.getPathSegments().get(0);
                                str2 = str;
                            } else {
                                if (contentUri.getPathSegments().size() != 2) {
                                    throw new IllegalArgumentException(SyntheticHelpers.m7910i(contentUri, "Invalid URI: "));
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    throw new UnsupportedOperationException(SyntheticHelpers.m7910i(contentUri, "WHERE clause not supported: "));
                                }
                                String str10 = contentUri.getPathSegments().get(0);
                                str2 = "_id=" + ContentUris.parseId(contentUri);
                                str3 = str10;
                            }
                            autoInstallsLayout.f16625m.delete(str3, str2, (String[]) null);
                            if (arrayList2.size() == 1) {
                                ContentValues contentValues6 = new ContentValues();
                                contentValues6.put("container", contentValues5.getAsInteger("container"));
                                contentValues6.put("screen", contentValues5.getAsInteger("screen"));
                                contentValues6.put("cellX", contentValues5.getAsInteger("cellX"));
                                contentValues6.put("cellY", contentValues5.getAsInteger("cellY"));
                                long jLongValue = ((Long) arrayList2.get(0)).longValue();
                                autoInstallsLayout.f16625m.update("favorites", contentValues6, SyntheticHelpers.m7912k("_id=", jLongValue), null);
                                jInsertAndCheck = jLongValue;
                            } else {
                                jInsertAndCheck = -1;
                            }
                        }
                        return jInsertAndCheck;
                    }
                    if (next != i7) {
                        contentValues.clear();
                        contentValues.put("container", Long.valueOf(jInsertAndCheck));
                        contentValues.put("rank", Integer.valueOf(i6));
                        tagParser = (TagParser) ((HashMap) this.f16566c).get(xmlResourceParser.getName());
                        if (tagParser != null) {
                            throw new RuntimeException("Invalid folder item " + xmlResourceParser.getName());
                        }
                        jMo7776a = tagParser.mo7776a(xmlResourceParser);
                        if (jMo7776a >= 0) {
                            arrayList2.add(Long.valueOf(jMo7776a));
                            i6++;
                        }
                    }
                    str = str;
                }

            default:
                int attributeResourceValue2 = AutoInstallsLayout.getAttributeResourceValue(xmlResourceParser, "title");
                int attributeResourceValue3 = AutoInstallsLayout.getAttributeResourceValue(xmlResourceParser, "icon");
                String attributeValue3 = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "option");
                AutoInstallsLayout autoInstallsLayout2 = this.f16565b;
                autoInstallsLayout2.getClass();
                int iIntValue2 = !TextUtils.isEmpty(attributeValue3) ? Integer.valueOf(attributeValue3).intValue() : 0;
                if (attributeResourceValue2 == 0 || attributeResourceValue3 == 0 || (intentMo7795b = mo7795b(xmlResourceParser)) == null || (drawable = (resources = (Resources) this.f16566c).getDrawable(attributeResourceValue3)) == null) {
                    return -1L;
                }
                Bitmap bitmapCreateIconBitmap = Utilities.createIconBitmap(drawable, autoInstallsLayout2.f16618f);
                ContentValues contentValues7 = autoInstallsLayout2.f16620h;
                if (bitmapCreateIconBitmap != null) {
                    contentValues7.put("icon", Utilities.flattenBitmap(bitmapCreateIconBitmap));
                }
                contentValues7.put("iconType", (Integer) 0);
                contentValues7.put("iconPackage", resources.getResourcePackageName(attributeResourceValue3));
                contentValues7.put("iconResource", resources.getResourceName(attributeResourceValue3));
                contentValues7.put("options", Integer.valueOf(iIntValue2));
                intentMo7795b.setFlags(270532608);
                return autoInstallsLayout2.mo7772a(autoInstallsLayout2.f16615c.getString(attributeResourceValue2), intentMo7795b, 1);
        }

    }

    /* JADX INFO: renamed from: b */
    public Intent mo7795b(XmlResourceParser xmlResourceParser) {
        String attributeValue = AutoInstallsLayout.getAttributeValue(xmlResourceParser, "url");
        if (TextUtils.isEmpty(attributeValue) || !Patterns.WEB_URL.matcher(attributeValue).matches()) {
            return null;
        }
        return new Intent("android.intent.action.VIEW", (Uri) null).setData(Uri.parse(attributeValue));
    }
}
