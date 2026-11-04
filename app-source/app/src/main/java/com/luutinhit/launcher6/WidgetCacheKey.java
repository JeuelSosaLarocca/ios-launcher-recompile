package com.luutinhit.launcher6;

import B3.C0059b;
import android.content.ComponentName;
import java.util.Objects;
import p122r3.C2673q;

/* JADX INFO: renamed from: com.luutinhit.launcher6.r3 */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCacheKey extends C0059b {

    /* JADX INFO: renamed from: d */
    public String f16849d;

    public WidgetCacheKey(ComponentName componentName, C2673q c2673q, String str) {
        super(componentName, c2673q);
        this.f16849d = str;
    }

    @Override // B3.C0059b
    public final boolean equals(Object obj) {
        Objects.toString(obj);
        return super.equals(obj) && ((WidgetCacheKey) obj).f16849d.equals(this.f16849d);
    }

    @Override // B3.C0059b
    public final int hashCode() {
        return this.f16849d.hashCode() ^ this.f151c;
    }
}
