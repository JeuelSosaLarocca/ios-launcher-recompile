package com.luutinhit.launcher6;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;

/* JADX INFO: loaded from: classes.dex */
public class ExtendedEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: o */
    public OnBackKeyListener mBackKeyListener;

    public ExtendedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/SFProTextLight.otf"));
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i6, KeyEvent keyEvent) {
        if (i6 != 4 || keyEvent.getAction() != 1) {
            return super.onKeyPreIme(i6, keyEvent);
        }
        OnBackKeyListener onBackKeyListener = this.mBackKeyListener;
        if (onBackKeyListener == null) {
            return false;
        }
        ((FolderReorderAlarmListener) onBackKeyListener).f16827k.doneEditingFolderName();
        return false;
    }

    public void setOnBackKeyListener(OnBackKeyListener onBackKeyListener) {
        this.mBackKeyListener = onBackKeyListener;
    }
}
