package com.luutinhit.launcherios.cropper;

import P3.AbstractActivityC0816d;
import S3.C0996g;
import S3.C0998i;
import S3.InterfaceC1001l;
import S3.InterfaceC1005p;
import W4.AbstractC1154e;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.luutinhit.launcherios.R;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CropImageActivity extends AbstractActivityC0816d implements InterfaceC1005p, InterfaceC1001l, View.OnClickListener {

    /* JADX INFO: renamed from: D */
    public CropImageView f17455D;

    /* JADX INFO: renamed from: E */
    public Uri f17456E;

    /* JADX INFO: renamed from: F */
    public C0998i f17457F;

    /* JADX INFO: renamed from: K */
    public final void m8312K(Uri uri, Exception exc, int i6) {
        int i7 = exc == null ? -1 : 204;
        C0996g c0996g = new C0996g(this.f17455D.getImageUri(), uri, exc, this.f17455D.getCropPoints(), this.f17455D.getCropRect(), this.f17455D.getWholeImageRect(), this.f17455D.getRotatedDegrees(), i6);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", c0996g);
        setResult(i7, intent);
        finish();
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onActivityResult(int i6, int i7, Intent intent) {
        Uri uriFromFile;
        String action;
        super.onActivityResult(i6, i7, intent);
        if (i6 == 200) {
            if (i7 == 0) {
                setResult(0);
                finish();
            }
            if (i7 == -1) {
                if (intent == null || intent.getData() == null || (((action = intent.getAction()) != null && action.equals("android.media.action.IMAGE_CAPTURE")) || intent.getData() == null)) {
                    File externalCacheDir = getExternalCacheDir();
                    uriFromFile = externalCacheDir != null ? Uri.fromFile(new File(externalCacheDir.getPath(), "pickImageResult.jpeg")) : null;
                } else {
                    uriFromFile = intent.getData();
                }
                this.f17456E = uriFromFile;
                if (AbstractC1154e.m2427q(this, uriFromFile)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f17455D.setImageUriAsync(this.f17456E);
                }
            }
        }
    }

    @Override // P3.AbstractActivityC0816d, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view == null || view.getId() != R.id.ok_crop_button) {
            return;
        }
        C0998i c0998i = this.f17457F;
        if (c0998i.f2883U) {
            m8312K(null, null, 1);
            return;
        }
        Uri uriFromFile = c0998i.f2878P;
        if (uriFromFile == null || uriFromFile.equals(Uri.EMPTY)) {
            try {
                Bitmap.CompressFormat compressFormat = this.f17457F.f2879Q;
                if (compressFormat == Bitmap.CompressFormat.JPEG) {
                    str = ".jpg";
                } else {
                    str = compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp";
                }
                uriFromFile = Uri.fromFile(File.createTempFile("cropped", str, getCacheDir()));
            } catch (IOException e) {
                throw new RuntimeException("Failed to create temp file for output image", e);
            }
        }
        Uri uri = uriFromFile;
        CropImageView cropImageView = this.f17455D;
        C0998i c0998i2 = this.f17457F;
        Bitmap.CompressFormat compressFormat2 = c0998i2.f2879Q;
        int i6 = c0998i2.f2880R;
        int i7 = c0998i2.f2881S;
        int i8 = c0998i2.f2882T;
        int i9 = c0998i2.f22199f0;
        if (cropImageView.f17465G == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        cropImageView.m8320h(i7, i8, i9, uri, compressFormat2, i6);
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.crop_image_activity);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17455D = (CropImageView) findViewById(R.id.cropImageView);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f17456E = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.f17457F = (C0998i) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            Uri uri = this.f17456E;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (AbstractC1154e.m2425o(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    startActivityForResult(AbstractC1154e.m2421k(this, getString(R.string.pick_image)), 200);
                }
            } else if (AbstractC1154e.m2427q(this, this.f17456E)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f17455D.setImageUriAsync(this.f17456E);
            }
        }
        findViewById(R.id.ok_crop_button).setOnClickListener(this);
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        if (i6 == 201) {
            Uri uri = this.f17456E;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, R.string.crop_image_activity_no_permissions, 1).show();
                setResult(0);
                finish();
            } else {
                this.f17455D.setImageUriAsync(uri);
            }
        }
        if (i6 == 2011) {
            startActivityForResult(AbstractC1154e.m2421k(this, getString(R.string.pick_image)), 200);
        }
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.f17455D.setOnSetImageUriCompleteListener(this);
        this.f17455D.setOnCropImageCompleteListener(this);
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f17455D.setOnSetImageUriCompleteListener(null);
        this.f17455D.setOnCropImageCompleteListener(null);
    }
}
