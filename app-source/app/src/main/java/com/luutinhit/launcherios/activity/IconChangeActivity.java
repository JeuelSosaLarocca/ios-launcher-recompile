package com.luutinhit.launcherios.activity;

import A4.RunnableC0026a;
import C2.C0144d;
import E4.AbstractC0212f;
import G3.CallableC0345a;
import J0.C0489j;
import P3.AbstractActivityC0816d;
import P3.DialogInterfaceOnClickListenerC0821i;
import P3.ViewTreeObserverOnScrollChangedListenerC0813a;
import Q3.C0895c;
import Q3.C0898f;
import S3.C0996g;
import S3.C0998i;
import S3.EnumC0999j;
import S3.EnumC1000k;
import W3.C1149a;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.C1697k;
import com.bumptech.glide.ComponentCallbacks2C1688b;
import com.luutinhit.launcher6.LauncherAppState;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.ioslauncher.BitmapLoadTarget;
import com.luutinhit.launcher6.util.RealTimeBlurView;
import com.luutinhit.launcher6.util.overscroll.OverScrollLayout;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.activity.IconChangeActivity;
import com.luutinhit.launcherios.cropper.CropImageActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p024a.AbstractC1314a;
import p029g.C2054g;
import p029g.DialogC2057j;
import p067e1.C1952j;
import p123r4.AbstractC2679b;
import p127s4.InterfaceC2749b;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
public class IconChangeActivity extends AbstractActivityC0816d {

    /* JADX INFO: renamed from: O */
    public static final /* synthetic */ int f17365O = 0;

    /* JADX INFO: renamed from: D */
    public Context f17366D;

    /* JADX INFO: renamed from: E */
    public LinearLayout f17367E;

    /* JADX INFO: renamed from: F */
    public C0895c f17368F;

    /* JADX INFO: renamed from: G */
    public RealTimeBlurView f17369G;

    /* JADX INFO: renamed from: H */
    public float f17370H;

    /* JADX INFO: renamed from: I */
    public int f17371I;

    /* JADX INFO: renamed from: J */
    public AppCompatImageView f17372J;

    /* JADX INFO: renamed from: K */
    public String f17373K;

    /* JADX INFO: renamed from: M */
    public InterfaceC2749b f17375M;

    /* JADX INFO: renamed from: L */
    public ArrayList f17374L = new ArrayList();

    /* JADX INFO: renamed from: N */
    public List f17376N = Arrays.asList(Integer.valueOf(R.drawable.call_icon), Integer.valueOf(R.drawable.calculator_icon), Integer.valueOf(R.drawable.calendar_icon), Integer.valueOf(R.drawable.camera_icon), Integer.valueOf(R.drawable.chrome_icon), Integer.valueOf(R.drawable.clock_icon), Integer.valueOf(R.drawable.compass_icon), Integer.valueOf(R.drawable.contact_icon), Integer.valueOf(R.drawable.drive_icon), Integer.valueOf(R.drawable.dropbox_icon), Integer.valueOf(R.drawable.email_icon), Integer.valueOf(R.drawable.facebook_icon), Integer.valueOf(R.drawable.flipboard_icon), Integer.valueOf(R.drawable.game_icon), Integer.valueOf(R.drawable.gmail_icon), Integer.valueOf(R.drawable.google_icon), Integer.valueOf(R.drawable.google_maps_icon), Integer.valueOf(R.drawable.google_photos_icon), Integer.valueOf(R.drawable.health_icon), Integer.valueOf(R.drawable.instagram_icon), Integer.valueOf(R.drawable.keep_icon), Integer.valueOf(R.drawable.line_icon), Integer.valueOf(R.drawable.message_icon), Integer.valueOf(R.drawable.music_icon), Integer.valueOf(R.drawable.notes_icon), Integer.valueOf(R.drawable.photos_icon), Integer.valueOf(R.drawable.safari_icon), Integer.valueOf(R.drawable.settings_icon), Integer.valueOf(R.drawable.siri_icon), Integer.valueOf(R.drawable.snapchat_icon), Integer.valueOf(R.drawable.spotify_icon), Integer.valueOf(R.drawable.store_icon), Integer.valueOf(R.drawable.translate_icon), Integer.valueOf(R.drawable.twitter_icon), Integer.valueOf(R.drawable.uber_icon), Integer.valueOf(R.drawable.viber_icon), Integer.valueOf(R.drawable.voice_memos_icon), Integer.valueOf(R.drawable.whatsapp_icon), Integer.valueOf(R.mipmap.ic_weather), Integer.valueOf(R.drawable.youtube_icon), Integer.valueOf(R.drawable.ic_facetime), Integer.valueOf(R.drawable.ic_files), Integer.valueOf(R.drawable.ic_videos), Integer.valueOf(R.drawable.ic_netflix), Integer.valueOf(R.drawable.ic_mifit), Integer.valueOf(R.drawable.ic_ap_maps), Integer.valueOf(R.drawable.ic_wallet), Integer.valueOf(R.drawable.ic_podcasts), Integer.valueOf(R.drawable.ic_news), Integer.valueOf(R.drawable.ic_radio), Integer.valueOf(R.drawable.ic_reminders), Integer.valueOf(R.drawable.ic_messenger), Integer.valueOf(R.drawable.ic_home), Integer.valueOf(R.drawable.ic_tv), Integer.valueOf(R.drawable.ic_tips), Integer.valueOf(R.drawable.ic_discord), Integer.valueOf(R.drawable.ic_deezer), Integer.valueOf(R.drawable.ic_fortnite), Integer.valueOf(R.drawable.ic_pinterest), Integer.valueOf(R.drawable.ic_tik_tok), Integer.valueOf(R.drawable.ic_shazam), Integer.valueOf(R.drawable.ic_stocks), Integer.valueOf(R.drawable.ic_book), Integer.valueOf(R.drawable.ic_telegram), Integer.valueOf(R.drawable.ic_itunes_store));

    /* JADX INFO: renamed from: K */
    public final void m8300K(AppCompatImageView appCompatImageView, final String str, final int i6) {
        this.f17372J = appCompatImageView;
        C0144d c0144d = new C0144d(this);
        GridView gridView = new GridView(this.f17366D);
        gridView.setNumColumns(3);
        gridView.setStretchMode(2);
        C0898f c0898f = new C0898f();
        c0898f.f2655j = this.f17376N;
        gridView.setAdapter((ListAdapter) c0898f);
        C2054g c2054g = (C2054g) c0144d.f419k;
        c2054g.f18341t = gridView;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: P3.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                IconChangeActivity iconChangeActivity = IconChangeActivity.this;
                String str2 = str;
                iconChangeActivity.f17373K = str2;
                iconChangeActivity.m8301L(str2);
            }
        };
        c2054g.f18328g = c2054g.f18322a.getText(R.string.pick_image);
        c2054g.f18329h = onClickListener;
        DialogInterfaceOnClickListenerC0821i dialogInterfaceOnClickListenerC0821i = new DialogInterfaceOnClickListenerC0821i();
        c2054g.f18332k = c2054g.f18322a.getText(android.R.string.cancel);
        c2054g.f18333l = dialogInterfaceOnClickListenerC0821i;
        DialogC2057j dialogC2057jM351j = c0144d.m351j();
        dialogC2057jM351j.show();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: P3.j
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i7, long j6) {
                Bitmap bitmapCreateIconBitmap;
                String str2 = str;
                IconChangeActivity iconChangeActivity = IconChangeActivity.this;
                List list = iconChangeActivity.f17376N;
                try {
                    int iIntValue = ((Integer) list.get(i7)).intValue();
                    Intent intent = new Intent("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
                    intent.putExtra("EXTRA_COMPONENT_NAME", str2);
                    intent.putExtra("EXTRA_ICON_ID", iIntValue);
                    iconChangeActivity.sendBroadcast(intent);
                    Drawable drawable = iconChangeActivity.f17366D.getDrawable(((Integer) list.get(i7)).intValue());
                    if (drawable != null && (bitmapCreateIconBitmap = Utilities.createIconBitmap(drawable, iconChangeActivity.f17366D)) != null) {
                        C0895c c0895c = iconChangeActivity.f17368F;
                        Bitmap bitmapM8164p = Utilities.m8164p(iconChangeActivity.f17366D, bitmapCreateIconBitmap);
                        ArrayList arrayList = c0895c.f2649n;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            int i8 = i6;
                            if (size > i8) {
                                ((C1149a) c0895c.f2649n.get(i8)).f3366b = bitmapM8164p;
                                c0895c.m9704g(i8);
                            }
                        }
                    }
                    ArrayList arrayList2 = iconChangeActivity.f17374L;
                    if (iIntValue != R.drawable.clock_icon) {
                        arrayList2.remove(str2);
                    } else if (!arrayList2.contains(str2)) {
                        arrayList2.add(str2);
                    }
                } catch (Throwable th) {
                    th.getMessage();
                }
                dialogC2057jM351j.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: L */
    public final void m8301L(String str) {
        Uri uriFromFile;
        Rect rect = Utilities.sOldBounds;
        int i6 = LauncherAppState.getInstance().f16222e.f16716h;
        if (i6 <= 0) {
            i6 = (int) (((double) this.f17370H) / 0.23d);
        }
        C0998i c0998i = new C0998i();
        c0998i.f2902w = 1;
        c0998i.f2903x = 1;
        c0998i.f2901v = true;
        c0998i.f2893n = EnumC1000k.f2910k;
        c0998i.f2876N = getString(R.string.pick_image);
        c0998i.f2890k = this.f17370H / i6;
        c0998i.f2889j = EnumC0999j.f2907k;
        c0998i.f22197d0 = "Done";
        c0998i.f2879Q = Bitmap.CompressFormat.JPEG;
        c0998i.f2880R = 100;
        c0998i.f2881S = 200;
        c0998i.f2882T = 200;
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
        if (i6 == 203) {
            C0996g c0996g = intent != null ? (C0996g) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT") : null;
            if (i7 == -1 && (uri = c0996g.f2845k) != null) {
                uri.toString();
                Intent intent2 = new Intent("com.luutinhit.launcherios.ACTION_RELOAD_ICON");
                intent2.putExtra("EXTRA_COMPONENT_NAME", this.f17373K);
                Uri uri2 = c0996g.f2845k;
                intent2.putExtra("EXTRA_ICON_PATH", uri2.getPath());
                intent2.setPackage(getPackageName());
                sendBroadcast(intent2);
                C1697k c1697kMo1601S = ((C1697k) ((C1697k) ComponentCallbacks2C1688b.m3648e(this.f17366D).mo1609l().mo1575B()).mo1584h(C1952j.f17900c)).mo1601S(uri2);
                c1697kMo1601S.m3729Q(new BitmapLoadTarget(this, 2), c1697kMo1601S);
            } else if (i7 == 204) {
                Toast.makeText(this, "Cropping failed: " + c0996g.f2846l, 1).show();
            }
        }
        super.onActivityResult(i6, i7, intent);
    }

    @Override // P3.AbstractActivityC0816d, p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, p005F.AbstractActivityC0221g, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_change_icon);
        m1821J(findViewById(R.id.root_layout), true);
        this.f17366D = getApplicationContext();
        this.f17369G = (RealTimeBlurView) findViewById(R.id.blurring_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_apps);
        recyclerView.setNestedScrollingEnabled(false);
        this.f17370H = this.f17366D.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
        this.f17371I = getResources().getDimensionPixelSize(R.dimen.item_hidden_app_size);
        this.f17367E = (LinearLayout) findViewById(R.id.progress_layout);
        this.f17369G.setBlurredView((OverScrollLayout) findViewById(R.id.overscroll_layout));
        recyclerView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserverOnScrollChangedListenerC0813a(this, 1));
        new LinearLayoutManager(1).e1(1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.e1(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        C0895c c0895c = new C0895c(1);
        this.f17368F = c0895c;
        recyclerView.setAdapter(c0895c);
        this.f17368F.f2650o = this;
        this.f17367E.setVisibility(0);
        try {
            new CallableC3080a(new CallableC0345a(5, this)).m8812w(AbstractC0212f.f640a).m8810u(new RunnableC0026a(new C0489j(17, this), AbstractC2679b.m9681a(), 1));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC1314a.m2681A(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @Override // p029g.AbstractActivityC2058k, android.app.Activity
    public final void onDestroy() {
        InterfaceC2749b interfaceC2749b = this.f17375M;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
        super.onDestroy();
    }

    @Override // p029g.AbstractActivityC2058k, androidx.activity.AbstractActivityC1366f, android.app.Activity
    public final void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i6, strArr, iArr);
        if (i6 == 68) {
            m8301L(this.f17373K);
        }
    }
}
