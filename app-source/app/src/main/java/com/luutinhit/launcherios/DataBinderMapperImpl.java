package com.luutinhit.launcherios;

import V3.C1123a;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.AbstractC1436a;
import androidx.databinding.AbstractC1438c;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends AbstractC1436a {

    /* JADX INFO: renamed from: a */
    public static final SparseIntArray f17276a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(1);
        f17276a = sparseIntArray;
        sparseIntArray.put(R.layout.item_battery, 1);
    }

    @Override // androidx.databinding.AbstractC1436a
    /* JADX INFO: renamed from: a */
    public final List mo3095a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.AbstractC1436a
    /* JADX INFO: renamed from: b */
    public final AbstractC1438c mo3093b(View view) {
        int i6 = f17276a.get(R.layout.item_battery);
        if (i6 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            if (i6 == 1) {
                if (!"layout/item_battery_0".equals(tag)) {
                    throw new IllegalArgumentException("The tag for item_battery is invalid. Received: " + tag);
                }
                Object[] objArr = new Object[3];
                AbstractC1438c.m3096Q(view, objArr, true);
                C1123a c1123a = new C1123a(view, (TextViewCustomFont) objArr[1], (TextViewCustomFont) objArr[2]);
                c1123a.f3274n = -1L;
                c1123a.f3271k.setTag(null);
                c1123a.f3272l.setTag(null);
                ((LinearLayout) objArr[0]).setTag(null);
                view.setTag(R.id.dataBinding, c1123a);
                synchronized (c1123a) {
                    c1123a.f3274n = 2L;
                }
                c1123a.m3098R();
                return c1123a;
            }
        }
        return null;
    }
}
