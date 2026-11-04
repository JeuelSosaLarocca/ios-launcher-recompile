package com.luutinhit.launcher6.widget.widgetprovider.config;

import G3.C0364t;
import S3.C0996g;
import S3.C0998i;
import S3.EnumC0999j;
import S3.EnumC1000k;
import android.appwidget.AppWidgetManager;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.C1506y;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherAppState;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.widget.widgetprovider.PictureAppWidgetProvider;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import java.io.File;
import java.util.HashMap;
import p029g.AbstractActivityC2058k;
import p089j0.C2234v;

/* JADX INFO: loaded from: classes.dex */
public class PictureAppWidgetProviderConfigureActivity extends AbstractActivityC2058k {

    /* JADX INFO: renamed from: G */
    public static final /* synthetic */ int f17217G = 0;

    /* JADX INFO: renamed from: D */
    public SharedPreferences f17218D;

    /* JADX INFO: renamed from: E */
    public int f17219E = 0;

    /* JADX INFO: renamed from: F */
    public float f17220F;

    public PictureAppWidgetProviderConfigureActivity() {
        this.f3950r.m2839c("activity_rq#" + this.f3949q.getAndIncrement(), this, new C1506y(2), new C0364t(2, this));
    }

    /* JADX INFO: renamed from: I */
    public final void m8250I(String str) {
        Uri uriFromFile;
        Rect rect = Utilities.sOldBounds;
        int i6 = (LauncherAppState.getInstance().f16222e.f16726r.f15977C * 6) + (LauncherAppState.getInstance().f16222e.f16716h * 4);
        if (i6 < 0) {
            i6 = Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT;
        }
        C0998i c0998i = new C0998i();
        c0998i.f2902w = 1;
        c0998i.f2903x = 1;
        c0998i.f2901v = true;
        c0998i.f2893n = EnumC1000k.f2910k;
        c0998i.f2876N = getString(R.string.pick_image);
        c0998i.f2890k = this.f17220F / i6;
        c0998i.f2889j = EnumC0999j.f2907k;
        c0998i.f2879Q = Bitmap.CompressFormat.JPEG;
        c0998i.f2880R = 100;
        c0998i.f2881S = i6;
        c0998i.f2882T = i6;
        c0998i.f22199f0 = 3;
        try {
            uriFromFile = Uri.fromFile(new File(new ContextWrapper(this).getDir("image", 0), str.replace("/", "_") + ".jpg"));
        } catch (Throwable unused) {
            uriFromFile = null;
        }
        c0998i.f2878P = uriFromFile;
        c0998i.m2060b();
        c0998i.m2060b();
        Intent intent = new Intent();
        intent.setClass(this, CropImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("CROP_IMAGE_EXTRA_SOURCE", null);
        bundle.putParcelable("CROP_IMAGE_EXTRA_OPTIONS", c0998i);
        intent.putExtra("CROP_IMAGE_EXTRA_BUNDLE", bundle);
        startActivityForResult(intent, 203);
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onActivityResult(int i6, int i7, Intent intent) {
        Uri uri;
        super.onActivityResult(i6, i7, intent);
        if (i7 == -1 && i6 == 203 && intent != null && (uri = ((C0996g) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT")).f2845k) != null) {
            uri.toString();
            int i8 = this.f17219E;
            String string = uri.toString();
            SharedPreferences.Editor editorEdit = this.f17218D.edit();
            editorEdit.putString("appwidget_" + i8, string);
            editorEdit.apply();
            PictureAppWidgetProvider.m8249a(this, AppWidgetManager.getInstance(this), this.f17219E);
            Intent intent2 = new Intent();
            intent2.putExtra("appWidgetId", this.f17219E);
            setResult(-1, intent2);
        }
        finish();
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17218D = getSharedPreferences(C2234v.m8924b(this), 0);
        setResult(0);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f17219E = extras.getInt("appWidgetId", 0);
        }
        if (this.f17219E == 0) {
            finish();
            return;
        }
        this.f17220F = getResources().getDimensionPixelSize(R.dimen.widget_round_corner);
        m8250I("appwidget_" + this.f17219E);
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        if (i6 == 68) {
            try {
                HashMap map = new HashMap();
                for (int i7 = 0; i7 < strArr.length; i7++) {
                    map.put(strArr[i7], Integer.valueOf(iArr[i7]));
                }
                if (((Integer) map.get("android.permission.READ_EXTERNAL_STORAGE")).intValue() != 0 || ((Integer) map.get("android.permission.WRITE_EXTERNAL_STORAGE")).intValue() != 0) {
                    Toast.makeText(this, R.string.required_storage_permission, 1).show();
                    return;
                }
                m8250I("appwidget_" + this.f17219E);
            } catch (Throwable unused) {
                Toast.makeText(this, R.string.required_storage_permission, 1).show();
            }
        }
    }
}
