package com.luutinhit.launcherios.customsettings;

import O3.AbstractC0744e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;

/* JADX INFO: loaded from: classes.dex */
public class SettingsItem extends ConstraintLayout {
    public SettingsItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.settings_item, (ViewGroup) this, true);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0744e.f2261y);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, R.mipmap.ic_launcher);
            if (resourceId > 0) {
                ((AppCompatImageView) findViewById(R.id.settings_icon)).setImageResource(resourceId);
            }
            String string = typedArrayObtainStyledAttributes.getString(2);
            if (string != null) {
                ((TextViewCustomFont) findViewById(R.id.settings_text)).setText(string);
            }
            if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
                findViewById(R.id.divider_line).setVisibility(8);
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        setClickable(true);
        setFocusable(true);
        setBackgroundResource(R.drawable.item_press_state);
    }
}
