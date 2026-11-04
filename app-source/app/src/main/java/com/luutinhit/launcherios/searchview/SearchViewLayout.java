package com.luutinhit.launcherios.searchview;

import A2.C0022a;
import B3.AbstractC0075r;
import B3.C0056Y;
import C2.RunnableC0147g;
import G3.C0347c;
import G3.C0370z;
import I2.C0463a;
import O3.AbstractC0744e;
import Y3.C1212b;
import Y3.C1213c;
import Y3.EnumC1218h;
import Y3.InterfaceC1217g;
import Y3.RunnableC1216f;
import Y3.ViewTreeObserverOnPreDrawListenerC1215e;
import Z3.C1302b;
import Z3.C1306f;
import Z3.C1309i;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.AppInfo;
import com.luutinhit.launcher6.InsertAbleConstraintLayout;
import com.luutinhit.launcher6.InsertAbleConstraintLayoutParams;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.RuntimeShaderGlassView;
import com.luutinhit.launcher6.editscreen.CustomViewRound;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import com.luutinhit.launcherios.searchview.SearchViewLayout;
import java.util.ArrayList;
import p029g.AbstractC2060m;
import p035n.O0;
import p041t.C2757e;
import p081h2.AbstractC2127a;
import p091j2.AbstractC2247e;
import p118q3.InterfaceC2614d;
import p127s4.InterfaceC2749b;

/* JADX INFO: loaded from: classes.dex */
public class SearchViewLayout extends InsertAbleConstraintLayout implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener, InterfaceC2614d {

    /* JADX INFO: renamed from: L */
    public static final /* synthetic */ int f17618L = 0;

    /* JADX INFO: renamed from: A */
    public AppCompatImageView f17619A;

    /* JADX INFO: renamed from: B */
    public TextViewCustomFont f17620B;

    /* JADX INFO: renamed from: C */
    public RecyclerView f17621C;

    /* JADX INFO: renamed from: D */
    public ViewStub f17622D;

    /* JADX INFO: renamed from: E */
    public LinearLayout f17623E;

    /* JADX INFO: renamed from: F */
    public C1309i f17624F;

    /* JADX INFO: renamed from: G */
    public InterfaceC1217g f17625G;

    /* JADX INFO: renamed from: H */
    public Handler f17626H;

    /* JADX INFO: renamed from: I */
    public InputMethodManager f17627I;

    /* JADX INFO: renamed from: J */
    public InterfaceC2749b f17628J;

    /* JADX INFO: renamed from: K */
    public C0370z f17629K;

    /* JADX INFO: renamed from: j */
    public EnumC1218h f17630j;

    /* JADX INFO: renamed from: k */
    public int f17631k;

    /* JADX INFO: renamed from: l */
    public Context f17632l;

    /* JADX INFO: renamed from: m */
    public Launcher f17633m;

    /* JADX INFO: renamed from: n */
    public C0056Y f17634n;

    /* JADX INFO: renamed from: o */
    public String f17635o;

    /* JADX INFO: renamed from: p */
    public EditText f17636p;

    /* JADX INFO: renamed from: q */
    public ConstraintLayout f17637q;

    /* JADX INFO: renamed from: r */
    public CustomViewRound f17638r;

    /* JADX INFO: renamed from: s */
    public RuntimeShaderGlassView f17639s;

    /* JADX INFO: renamed from: t */
    public TextViewCustomFont f17640t;

    /* JADX INFO: renamed from: u */
    public RecyclerView f17641u;

    /* JADX INFO: renamed from: v */
    public C1302b f17642v;

    /* JADX INFO: renamed from: w */
    public C1306f f17643w;

    /* JADX INFO: renamed from: x */
    public ViewTreeObserverOnPreDrawListenerC1215e f17644x;

    /* JADX INFO: renamed from: y */
    public ArrayList f17645y;

    /* JADX INFO: renamed from: z */
    public AppCompatImageView f17646z;

    public SearchViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17630j = EnumC1218h.f3543m;
        this.f17645y = new ArrayList();
        this.f17629K = new C0370z(3, this);
        this.f17632l = context;
        if (context instanceof Launcher) {
            Launcher launcher = (Launcher) context;
            this.f17633m = launcher;
            C0056Y tinyDB = launcher.getTinyDB();
            this.f17634n = tinyDB;
            tinyDB.m140j(this);
            this.f17627I = (InputMethodManager) context.getSystemService("input_method");
        }
        this.f17626H = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: Y3.a
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i6 = SearchViewLayout.f17618L;
                SearchViewLayout searchViewLayout = SearchViewLayout.this;
                try {
                    C1309i c1309i = searchViewLayout.f17624F;
                    if (c1309i == null) {
                        return true;
                    }
                    c1309i.f3781s.filter((String) message.obj);
                    C1306f c1306f = searchViewLayout.f17643w;
                    if (c1306f == null) {
                        return true;
                    }
                    c1306f.f3772u.filter((String) message.obj);
                    return true;
                } catch (Throwable th) {
                    th.getMessage();
                    return true;
                }
            }
        });
        LayoutInflater.from(context).inflate(R.layout.search_view, (ViewGroup) this, true);
        this.f17636p = (EditText) findViewById(R.id.et_search);
        this.f17646z = (AppCompatImageView) findViewById(R.id.action_voice);
        this.f17619A = (AppCompatImageView) findViewById(R.id.action_clear);
        this.f17637q = (ConstraintLayout) findViewById(R.id.search_box);
        this.f17638r = (CustomViewRound) findViewById(R.id.search_box_background);
        this.f17620B = (TextViewCustomFont) findViewById(R.id.suggestion_text);
        this.f17621C = (RecyclerView) findViewById(R.id.suggestion_list);
        this.f17640t = (TextViewCustomFont) findViewById(R.id.contact_list_text);
        this.f17641u = (RecyclerView) findViewById(R.id.contact_list);
        this.f17622D = (ViewStub) findViewById(R.id.other_search_stub);
        this.f17621C.setItemAnimator(null);
        this.f17641u.setItemAnimator(null);
        C0463a c0463a = new C0463a(context);
        c0463a.f1478p = false;
        c0463a.f1473k = 1;
        int iM8795i = AbstractC2127a.m8795i(context, R.color.white_68);
        c0463a.f1474l = iM8795i;
        Drawable drawableM8803x = AbstractC2127a.m8803x(c0463a.f1472j);
        c0463a.f1472j = drawableM8803x;
        drawableM8803x.setTint(iM8795i);
        c0463a.f1476n = AbstractC2247e.m8942h(70);
        this.f17641u.m3419l(c0463a);
        Launcher launcher2 = this.f17633m;
        if (launcher2 != null) {
            this.f17631k = launcher2.getDeviceProfile().f15977C;
            InsertAbleConstraintLayoutParams insertAbleConstraintLayoutParams = (InsertAbleConstraintLayoutParams) this.f17637q.getLayoutParams();
            int i6 = this.f17631k;
            insertAbleConstraintLayoutParams.setMargins(i6, i6, i6, 0);
            TextViewCustomFont textViewCustomFont = this.f17640t;
            int i7 = this.f17631k;
            textViewCustomFont.setPadding(i7, i7, i7, i7 / 2);
            TextViewCustomFont textViewCustomFont2 = this.f17620B;
            int i8 = this.f17631k;
            textViewCustomFont2.setPadding(i8, 0, i8, i8 / 2);
            RecyclerView recyclerView = this.f17621C;
            int i9 = this.f17631k / 2;
            recyclerView.setPadding(0, i9, 0, i9);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17621C.getLayoutParams();
            int i10 = this.f17631k;
            layoutParams.setMargins(i10, 0, i10, 0);
            if (launcher2.isUseLiquidGlass && launcher2.isRuntimeRenderSupport && this.f17639s == null) {
                if (launcher2.getBlurWallpaperProvider() != null) {
                    launcher2.getBlurWallpaperProvider().m9546b(this);
                }
                setLayerType(2, null);
                RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher2, false);
                this.f17639s = runtimeShaderGlassView;
                runtimeShaderGlassView.setLayerType(2, null);
                this.f17639s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
                this.f17639s.setCornerRadiusPercent(0.5f);
                CustomViewRound customViewRound = this.f17638r;
                customViewRound.f16399p = false;
                customViewRound.invalidate();
                this.f17638r.addView(this.f17639s, 0);
            }
            setDarkMode(launcher2.isDarkMode);
        }
        findViewById(R.id.result_layout).setOnClickListener(this);
        this.f17646z.setOnClickListener(this);
        this.f17619A.setOnClickListener(this);
        m8356I(true);
        this.f17636p.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: Y3.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                int i12 = SearchViewLayout.f17618L;
                SearchViewLayout searchViewLayout = SearchViewLayout.this;
                InputMethodManager inputMethodManager = searchViewLayout.f17627I;
                if (inputMethodManager == null) {
                    return true;
                }
                inputMethodManager.hideSoftInputFromWindow(searchViewLayout.getWindowToken(), 0);
                return true;
            }
        });
        if (AbstractC0075r.m193n(context)) {
            C1302b c1302b = new C1302b(context.getApplicationContext());
            this.f17642v = c1302b;
            C1212b c1212b = new C1212b(this);
            boolean z5 = c1302b.f3751g;
            if (!z5) {
                c1302b.f3749e = c1212b;
                ContentResolver contentResolver = c1302b.f3745a;
                if (!c1302b.f3750f && !z5) {
                    try {
                        Uri uri = ContactsContract.Contacts.CONTENT_URI;
                        C0347c c0347c = c1302b.f3748d;
                        contentResolver.registerContentObserver(uri, true, c0347c);
                        contentResolver.registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, c0347c);
                        contentResolver.registerContentObserver(ContactsContract.Data.CONTENT_URI, true, c0347c);
                        contentResolver.registerContentObserver(ContactsContract.RawContacts.CONTENT_URI, true, c0347c);
                        c1302b.f3750f = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                c1302b.f3754j++;
                Handler handler = c1302b.f3747c;
                RunnableC0147g runnableC0147g = c1302b.f3755k;
                handler.removeCallbacks(runnableC0147g);
                handler.postDelayed(runnableC0147g, 0L);
            }
        }
        C2757e c2757e = AbstractC2060m.f18389j;
        int i11 = O0.f19973a;
        TypedArray typedArrayObtainStyledAttributes = this.f17632l.obtainStyledAttributes(attributeSet, AbstractC0744e.f2260x, 0, 0);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            setVoiceHintPrompt(typedArrayObtainStyledAttributes.getString(0));
        }
        setFitsSystemWindows(true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdapter(ArrayList<AppInfo> arrayList) {
        C1309i c1309i = new C1309i(this.f17632l, arrayList);
        this.f17624F = c1309i;
        c1309i.f3779q = new C1212b(this);
        c1309i.f3780r = new C1212b(this);
        this.f17621C.setAdapter(c1309i);
    }

    public void setDarkModeForOtherSearch(boolean z5) {
        LinearLayout linearLayout = this.f17623E;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(z5 ? R.drawable.round_rect_qsb_dark : R.drawable.round_rect_qsb);
        }
    }

    /* JADX INFO: renamed from: y */
    public static void m8351y(SearchViewLayout searchViewLayout) {
        ViewStub viewStub;
        if (searchViewLayout.f17623E != null || (viewStub = searchViewLayout.f17622D) == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) viewStub.inflate();
        searchViewLayout.f17623E = linearLayout;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int i6 = searchViewLayout.f17631k;
        layoutParams.setMargins(i6, i6, i6, i6);
        LinearLayout linearLayout2 = (LinearLayout) searchViewLayout.f17623E.findViewById(R.id.search_web);
        LinearLayout linearLayout3 = (LinearLayout) searchViewLayout.f17623E.findViewById(R.id.search_store);
        LinearLayout linearLayout4 = (LinearLayout) searchViewLayout.f17623E.findViewById(R.id.search_maps);
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(searchViewLayout);
        }
        if (linearLayout3 != null) {
            linearLayout3.setOnClickListener(searchViewLayout);
        }
        if (linearLayout4 != null) {
            linearLayout4.setOnClickListener(searchViewLayout);
        }
        Launcher launcher = searchViewLayout.f17633m;
        if (launcher != null) {
            searchViewLayout.setDarkModeForOtherSearch(launcher.isDarkMode);
        }
    }

    /* JADX INFO: renamed from: D */
    public final void m8352D() {
        EnumC1218h enumC1218h;
        EnumC1218h enumC1218h2 = this.f17630j;
        if (enumC1218h2 == EnumC1218h.f3543m || enumC1218h2 == (enumC1218h = EnumC1218h.f3542l)) {
            return;
        }
        this.f17630j = enumC1218h;
        m8354G();
        this.f17636p.removeTextChangedListener(this.f17629K);
        this.f17636p.setText("");
        m8355H(false);
        m8356I(true);
        if (this.f17636p.length() == 0) {
            LinearLayout linearLayout = this.f17623E;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.f17640t.setVisibility(8);
            this.f17641u.setVisibility(8);
        }
        animate().withLayer().alpha(0.0f).setDuration(368L).setInterpolator(new DecelerateInterpolator()).setListener(new C0022a(6, this)).setUpdateListener(new C1213c(0, this)).start();
        InterfaceC1217g interfaceC1217g = this.f17625G;
        if (interfaceC1217g != null) {
            interfaceC1217g.onSearchViewClosed(368);
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m8353F() {
        EnumC1218h enumC1218h = this.f17630j;
        EnumC1218h enumC1218h2 = EnumC1218h.f3543m;
        if (enumC1218h == enumC1218h2 || enumC1218h == EnumC1218h.f3542l) {
            return;
        }
        this.f17630j = enumC1218h2;
        m8354G();
        this.f17636p.removeTextChangedListener(this.f17629K);
        this.f17636p.setText("");
        m8355H(false);
        m8356I(true);
        postOnAnimationDelayed(new RunnableC1216f(this, 0), 200L);
        if (this.f17636p.length() == 0) {
            LinearLayout linearLayout = this.f17623E;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.f17640t.setVisibility(8);
            this.f17641u.setVisibility(8);
        }
        setVisibility(8);
        C1309i c1309i = this.f17624F;
        if (c1309i != null) {
            c1309i.f3781s.filter(null);
        }
        InterfaceC1217g interfaceC1217g = this.f17625G;
        if (interfaceC1217g != null) {
            interfaceC1217g.onSearchViewClosed(0);
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m8354G() {
        if (this.f17644x != null && getViewTreeObserver().isAlive()) {
            getViewTreeObserver().removeOnPreDrawListener(this.f17644x);
        }
        this.f17644x = null;
    }

    /* JADX INFO: renamed from: H */
    public final void m8355H(boolean z5) {
        this.f17619A.setVisibility(z5 ? 0 : 8);
    }

    /* JADX INFO: renamed from: I */
    public final void m8356I(boolean z5) {
        if (!z5 || this.f17632l.getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).isEmpty()) {
            this.f17646z.setVisibility(4);
        } else {
            this.f17646z.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: J */
    public final boolean m8357J() {
        return this.f17630j == EnumC1218h.f3541k;
    }

    /* JADX INFO: renamed from: K */
    public final void m8358K(ArrayList arrayList) {
        ArrayList arrayList2 = this.f17645y;
        try {
            arrayList2.clear();
        } catch (Throwable th) {
            th.getMessage();
        }
        arrayList2.addAll(arrayList);
        setAdapter(arrayList);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [Y3.e] */
    /* JADX INFO: renamed from: L */
    public final void m8359L() {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        EnumC1218h enumC1218h;
        EnumC1218h enumC1218h2 = this.f17630j;
        if (enumC1218h2 == EnumC1218h.f3541k || enumC1218h2 == (enumC1218h = EnumC1218h.f3540j)) {
            return;
        }
        setVisibility(0);
        this.f17630j = enumC1218h;
        setAlpha(0.0f);
        this.f17620B.setVisibility(0);
        this.f17621C.setVisibility(0);
        EditText editText = this.f17636p;
        C0370z c0370z = this.f17629K;
        editText.removeTextChangedListener(c0370z);
        this.f17636p.addTextChangedListener(c0370z);
        if (this.f17644x == null && this.f17639s != null && getViewTreeObserver().isAlive()) {
            this.f17644x = new Y3.ViewTreeObserverOnPreDrawListenerC1215e(SearchViewLayout.this) /* original class Y3.e; the field is typed with it */;
            getViewTreeObserver().addOnPreDrawListener(this.f17644x);
        }
        InterfaceC1217g interfaceC1217g = this.f17625G;
        if (interfaceC1217g != null) {
            interfaceC1217g.onSearchViewOpened();
        }
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: a */
    public final void mo7593a() {
        post(new RunnableC1216f(this, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        m8352D();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f17630j != EnumC1218h.f3542l) {
            return super.dispatchTouchEvent(motionEvent);
        }
        MotionEvent.actionToString(motionEvent.getActionMasked());
        return true;
    }

    public EnumC1218h getState() {
        return this.f17630j;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        if (view != null) {
            int id = view.getId();
            Context context = this.f17632l;
            if (id == R.id.search_web) {
                EditText editText2 = this.f17636p;
                if (editText2 != null) {
                    String strValueOf = String.valueOf(editText2.getText());
                    if (TextUtils.isEmpty(strValueOf)) {
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
                        intent.putExtra("query", strValueOf);
                        context.startActivity(intent);
                        return;
                    } catch (Throwable unused) {
                        Toast.makeText(context, R.string.application_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (id == R.id.search_store) {
                EditText editText3 = this.f17636p;
                if (editText3 != null) {
                    String strValueOf2 = String.valueOf(editText3.getText());
                    if (TextUtils.isEmpty(strValueOf2)) {
                        return;
                    }
                    try {
                        try {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search").buildUpon().appendQueryParameter("c", "apps").appendQueryParameter("q", strValueOf2).build()));
                            return;
                        } catch (Throwable unused2) {
                            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/search?q=".concat(strValueOf2))));
                            Toast.makeText(context, R.string.application_not_found, 0).show();
                            return;
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        Toast.makeText(context, R.string.application_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (id == R.id.search_maps) {
                EditText editText4 = this.f17636p;
                if (editText4 != null) {
                    String strValueOf3 = String.valueOf(editText4.getText());
                    if (TextUtils.isEmpty(strValueOf3)) {
                        return;
                    }
                    try {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=".concat(strValueOf3)));
                        intent2.setPackage("com.google.android.apps.maps");
                        context.startActivity(intent2);
                        return;
                    } catch (Throwable unused3) {
                        Toast.makeText(context, R.string.application_not_found, 0).show();
                        return;
                    }
                }
                return;
            }
            if (id == R.id.result_layout) {
                m8352D();
                return;
            }
            if (id != R.id.action_voice) {
                if (id != R.id.action_clear || (editText = this.f17636p) == null) {
                    return;
                }
                editText.setText("");
                return;
            }
            Intent intent3 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            intent3.putExtra("android.speech.extra.PROMPT", this.f17635o);
            intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent3.putExtra("android.speech.extra.MAX_RESULTS", 1);
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent3, 42);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        m8354G();
        InterfaceC2749b interfaceC2749b = this.f17628J;
        if (interfaceC2749b != null) {
            interfaceC2749b.mo37b();
        }
        C1302b c1302b = this.f17642v;
        if (c1302b != null) {
            if (!c1302b.f3751g) {
                c1302b.f3751g = true;
                c1302b.f3747c.removeCallbacksAndMessages(null);
                if (c1302b.f3750f) {
                    try {
                        c1302b.f3745a.unregisterContentObserver(c1302b.f3748d);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    c1302b.f3750f = false;
                }
                c1302b.f3746b.shutdownNow();
                c1302b.f3749e = null;
            }
            this.f17642v = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        RuntimeShaderGlassView runtimeShaderGlassView = this.f17639s;
        if (runtimeShaderGlassView != null) {
            runtimeShaderGlassView.updateGlViewPosition();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        C0056Y c0056y;
        if (str == null || !str.equals("dark_mode") || (c0056y = this.f17634n) == null) {
            return;
        }
        setDarkMode(c0056y.m131a("dark_mode"));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i6, Rect rect) {
        return isFocusable() && this.f17636p.requestFocus(i6, rect);
    }

    public void setDarkMode(boolean z5) {
        this.f17638r.setDarkModeTransparentBackground(z5);
        this.f17621C.setBackgroundResource(z5 ? R.drawable.round_rect_qsb_dark : R.drawable.round_rect_qsb);
        setDarkModeForOtherSearch(z5);
    }

    public void setEditText(String str) {
        EditText editText = this.f17636p;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setSearchViewListener(InterfaceC1217g interfaceC1217g) {
        this.f17625G = interfaceC1217g;
    }

    public void setState(boolean z5) {
        this.f17630j = z5 ? EnumC1218h.f3541k : EnumC1218h.f3543m;
    }

    @Override // android.view.View
    public void setTranslationY(float f6) {
        super.setTranslationY(f6);
        InterfaceC1217g interfaceC1217g = this.f17625G;
        if (interfaceC1217g != null) {
            interfaceC1217g.onSearchViewTranslationYChanged(f6);
        }
    }

    public void setUseTransparency(boolean z5) {
    }

    public void setVoiceHintPrompt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f17635o = this.f17632l.getString(R.string.hint_prompt);
        } else {
            this.f17635o = str;
        }
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: q */
    public final void mo7594q() {
    }
}
