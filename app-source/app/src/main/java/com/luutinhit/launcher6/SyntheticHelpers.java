package com.luutinhit.launcher6;

import F2.AbstractC0264a;
import android.content.ContentProviderClient;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.luutinhit.launcher6.Z1 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class SyntheticHelpers {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ int m7902a(int i6) {
        switch (i6) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            case 10:
                return 12;
            case 11:
                return 13;
            default:
                throw null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ boolean m7903b(int i6) {
        if (i6 == 1 || i6 == 2 || i6 == 3) {
            return false;
        }
        if (i6 == 4 || i6 == 5) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ float m7904c(int i6) {
        if (i6 == 1 || i6 == 2 || i6 == 3) {
            return 0.0f;
        }
        if (i6 == 4) {
            return 1.0f;
        }
        throw null;
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ float m7905d(int i6) {
        if (i6 == 1 || i6 == 2) {
            return 0.0f;
        }
        if (i6 == 3) {
            return 1.0f;
        }
        if (i6 == 4) {
            return 0.0f;
        }
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public static float m7906e(float f6, float f7, float f8, float f9) {
        return ((f6 - f7) * f8) + f9;
    }

    /* JADX INFO: renamed from: f */
    public static ClassCastException m7907f(int i6, ArrayList arrayList) {
        arrayList.get(i6).getClass();
        return new ClassCastException();
    }

    /* JADX INFO: renamed from: g */
    public static String m7908g(int i6, int i7, String str, String str2) {
        return str + i6 + str2 + i7;
    }

    /* JADX INFO: renamed from: h */
    public static String m7909h(int i6, String str) {
        return str + i6;
    }

    /* JADX INFO: renamed from: i */
    public static String m7910i(Uri uri, String str) {
        return str + uri;
    }

    /* JADX INFO: renamed from: j */
    public static String m7911j(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.m3402G());
        return sb.toString();
    }

    /* JADX INFO: renamed from: k */
    public static String m7912k(String str, long j6) {
        return str + j6;
    }

    /* JADX INFO: renamed from: l */
    public static String m7913l(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: renamed from: m */
    public static String m7914m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* JADX INFO: renamed from: n */
    public static String m7915n(StringBuilder sb, int i6, String str) {
        sb.append(i6);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: o */
    public static String m7916o(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: p */
    public static StringBuilder m7917p(String str, int i6, String str2, int i7, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i6);
        sb.append(str2);
        sb.append(i7);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: q */
    public static StringBuilder m7918q(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: r */
    public static /* synthetic */ void m7919r(ContentProviderClient contentProviderClient) throws Exception {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        if (contentProviderClient instanceof AutoCloseable) {
            contentProviderClient.close();
        } else if (contentProviderClient instanceof ExecutorService) {
            AbstractC0264a.m687w((ExecutorService) contentProviderClient);
        } else {
            contentProviderClient.release();
        }
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ String m7920s(int i6) {
        switch (i6) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }

    /* JADX INFO: renamed from: t */
    public static /* synthetic */ String m7921t(int i6) {
        switch (i6) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }

    /* JADX INFO: renamed from: u */
    public static /* synthetic */ String m7922u(int i6) {
        switch (i6) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }
}
