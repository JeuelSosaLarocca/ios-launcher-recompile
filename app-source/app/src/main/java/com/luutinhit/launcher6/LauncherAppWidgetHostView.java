package com.luutinhit.launcher6;

import A2.C0022a;
import B3.C0056Y;
import C2.C0148h;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RemoteViews;
import androidx.emoji2.text.C1460n;
import com.luutinhit.launcher6.util.DeleteCircleView;
import com.luutinhit.launcher6.util.TextViewCustomFont;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Objects;
import p084i0.C2155e;
import p084i0.C2156f;
import p084i0.InterfaceC2154d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.g2 */
/* JADX INFO: loaded from: classes.dex */
public class LauncherAppWidgetHostView extends AppWidgetHostView implements TouchCompleteListener {


    /* JADX INFO: renamed from: A */
    public int[] f16531A;

    /* JADX INFO: renamed from: B */
    public boolean f16532B;

    /* JADX INFO: renamed from: C */
    public ObjectAnimator f16533C;

    /* JADX INFO: renamed from: D */
    public ObjectAnimator f16534D;

    /* JADX INFO: renamed from: E */
    public WidgetHostViewRunnable f16535E;

    /* JADX INFO: renamed from: j */
    public LayoutInflater f16536j;

    /* JADX INFO: renamed from: k */
    public C0148h f16537k;

    /* JADX INFO: renamed from: l */
    public StylusEventHelper f16538l;

    /* JADX INFO: renamed from: m */
    public Launcher f16539m;

    /* JADX INFO: renamed from: n */
    public DeviceProfile f16540n;

    /* JADX INFO: renamed from: o */
    public int f16541o;

    /* JADX INFO: renamed from: p */
    public DragLayer f16542p;

    /* JADX INFO: renamed from: q */
    public DeleteCircleView f16543q;

    /* JADX INFO: renamed from: r */
    public TextViewCustomFont f16544r;

    /* JADX INFO: renamed from: s */
    public int f16545s;

    /* JADX INFO: renamed from: t */
    public int f16546t;

    /* JADX INFO: renamed from: u */
    public float f16547u;

    /* JADX INFO: renamed from: v */
    public boolean f16548v;

    /* JADX INFO: renamed from: w */
    public String f16549w;

    /* JADX INFO: renamed from: x */
    public Paint f16550x;

    /* JADX INFO: renamed from: y */
    public Path f16551y;

    /* JADX INFO: renamed from: z */
    public float f16552z;

    public LauncherAppWidgetHostView(Context context) {
        super(context);
        this.f16550x = new Paint(1);
        this.f16551y = new Path();
        new RectF();
        this.f16532B = false;
        this.f16535E = new WidgetHostViewRunnable(this, 0);
        Launcher launcher = (Launcher) context;
        this.f16539m = launcher;
        this.f16540n = launcher.getDeviceProfile();
        TextViewCustomFont textViewCustomFont = new TextViewCustomFont(context);
        this.f16544r = textViewCustomFont;
        this.f16543q = new DeleteCircleView(getContext(), null);
        this.f16552z = context.getResources().getDimensionPixelSize(R.dimen.widget_round_corner);
        this.f16545s = launcher.mDeviceProfile.f15980F;
        this.f16537k = new C0148h(this);
        this.f16538l = new StylusEventHelper(this);
        this.f16536j = (LayoutInflater) context.getSystemService("layout_inflater");
        DragLayer dragLayer = ((Launcher) context).getDragLayer();
        this.f16542p = dragLayer;
        setAccessibilityDelegate(LauncherAppState.getInstance().f16223f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.98f, 1.05f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.98f, 1.05f));
        objectAnimatorOfPropertyValuesHolder.addListener(new C0022a(13, this));
        objectAnimatorOfPropertyValuesHolder.setDuration(368L);
        this.f16533C = objectAnimatorOfPropertyValuesHolder;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scaleX", 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.0f));
        objectAnimatorOfPropertyValuesHolder2.addListener(new SharedAnimatorListener(1));
        objectAnimatorOfPropertyValuesHolder2.setDuration(268L);
        this.f16534D = objectAnimatorOfPropertyValuesHolder2;
        setClipToPadding(false);
        setClipChildren(false);
        setClipToOutline(false);
        dragLayer.setClipChildren(false);
        dragLayer.setClipToPadding(false);
        dragLayer.setClipToOutline(false);
        setLayoutParams(new DragLayerLayoutParams(-2, -2));
        textViewCustomFont.setTextSize(1, 11.0f);
        textViewCustomFont.setTextAlignment(4);
        textViewCustomFont.setTextColor(launcher.mIconTextColor);
        textViewCustomFont.setSingleLine();
        textViewCustomFont.setEllipsize(TextUtils.TruncateAt.END);
        textViewCustomFont.setShadowLayer(10.0f, 0.0f, 0.0f, 1291845632);
        DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(-1, -2);
        ((FrameLayout.LayoutParams) dragLayerLayoutParams).gravity = 80;
        addView(textViewCustomFont, 0, dragLayerLayoutParams);
        textViewCustomFont.measure(0, 0);
    }

    public int[] getLocationIconViewOnScreen() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m8051a() {
        if (this.f16533C.isRunning()) {
            this.f16533C.cancel();
        }
        if (this.f16532B) {
            this.f16534D.start();
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean mo7923b() {
        return this.f16541o != this.f16539m.getResources().getConfiguration().orientation;
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.f16537k.m362b();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void clearChildFocus(View view) {
        super.clearChildFocus(view);
        setSelected(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f16548v || keyEvent.getKeyCode() != 111 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f16548v = false;
        requestFocus();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        int action = motionEvent.getAction();
        WidgetHostViewRunnable widgetHostViewRunnable = this.f16535E;
        Launcher launcher = this.f16539m;
        if (action == 0) {
            launcher.isShaking();
            if (!launcher.isShaking()) {
                this.f16532B = false;
                this.f16531A = getLocationIconViewOnScreen();
                postDelayed(widgetHostViewRunnable, ViewConfiguration.getTapTimeout() + 200);
            }
        } else if (action == 1 || action == 3) {
            removeCallbacks(widgetHostViewRunnable);
            if (!launcher.showingFloatingMenu) {
                m8051a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchUnhandledMove(View view, int i6) {
        return this.f16548v;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j6) {
        Objects.toString(view);
        if ((view instanceof TextViewCustomFont) || (view instanceof DeleteCircleView)) {
            return super.drawChild(canvas, view, j6);
        }
        canvas.save();
        int i6 = Build.VERSION.SDK_INT;
        Path path = this.f16551y;
        if (i6 >= 26) {
            canvas.clipOutPath(path);
        } else {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j6);
        canvas.restore();
        return zDrawChild;
    }

    /* JADX INFO: renamed from: e */
    public final void onTouchComplete() {
        DeleteCircleView deleteCircleView = this.f16543q;
        Objects.toString(deleteCircleView);
        if (deleteCircleView != null) {
            post(new WidgetDeleteButtonRunnable(this, 1));
        }
    }

    @Override // android.appwidget.AppWidgetHostView
    public AppWidgetProviderInfo getAppWidgetInfo() {
        AppWidgetProviderInfo appWidgetInfo = super.getAppWidgetInfo();
        if (appWidgetInfo == null || (appWidgetInfo instanceof LauncherAppWidgetProviderInfo)) {
            return appWidgetInfo;
        }
        throw new IllegalStateException("Launcher widget must have LauncherAppWidgetProviderInfo");
    }

    @Override // android.view.ViewGroup
    public int getDescendantFocusability() {
        return this.f16548v ? 131072 : 393216;
    }

    @Override // android.appwidget.AppWidgetHostView
    public View getErrorView() {
        return this.f16536j.inflate(R.layout.appwidget_error, (ViewGroup) this, false);
    }

    public String getKey() {
        return this.f16549w;
    }

    public CharSequence getLabel() {
        return this.f16544r.getText();
    }

    public LauncherAppWidgetProviderInfo getLauncherAppWidgetProviderInfo() {
        return (LauncherAppWidgetProviderInfo) getAppWidgetInfo();
    }

    public int[] getLocationWidget() {
        int[] iArr = this.f16531A;
        return iArr != null ? iArr : getLocationIconViewOnScreen();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16547u = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        post(new WidgetDeleteButtonRunnable(this, 0));
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z5, int i6, Rect rect) {
        if (z5) {
            this.f16548v = false;
            setSelected(false);
        }
        super.onFocusChanged(z5, i6, rect);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x007d  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Objects.toString(motionEvent);
        int action = motionEvent.getAction();
        WidgetHostViewRunnable widgetHostViewRunnable = this.f16535E;
        C0148h c0148h = this.f16537k;
        Launcher launcher = this.f16539m;
        if (action == 0) {
            c0148h.m362b();
            removeCallbacks(widgetHostViewRunnable);
            if (!launcher.showingFloatingMenu) {
                m8051a();
            }
        }
        if (c0148h.f428a) {
            c0148h.m362b();
            removeCallbacks(widgetHostViewRunnable);
            if (!launcher.showingFloatingMenu) {
                m8051a();
                return true;
            }
        } else {
            StylusEventHelper stylusEventHelper = this.f16538l;
            if (!stylusEventHelper.checkAndPerformStylusEvent(motionEvent)) {
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    if (!stylusEventHelper.f16610a) {
                        c0148h.m364d();
                    }
                    this.f16542p.setTouchCompleteListener(this);
                    launcher.isShaking();
                    if (!launcher.isShaking()) {
                        this.f16532B = false;
                        this.f16531A = getLocationIconViewOnScreen();
                        postDelayed(widgetHostViewRunnable, ViewConfiguration.getTapTimeout() + 200);
                    }
                } else if (action2 == 1) {
                    c0148h.m362b();
                    removeCallbacks(widgetHostViewRunnable);
                    if (!launcher.showingFloatingMenu) {
                        m8051a();
                        return false;
                    }
                } else if (action2 != 2) {
                    if (action2 == 3) {
                        c0148h.m362b();
                        removeCallbacks(widgetHostViewRunnable);
                        if (!launcher.showingFloatingMenu) {
                            m8051a();
                            return false;
                        }
                    }
                } else if (!Utilities.pointInView(this, motionEvent.getX(), motionEvent.getY(), this.f16547u)) {
                    c0148h.m362b();
                    removeCallbacks(widgetHostViewRunnable);
                    if (!launcher.showingFloatingMenu) {
                        m8051a();
                        return false;
                    }
                }
                return false;
            }
            c0148h.m362b();
            removeCallbacks(widgetHostViewRunnable);
            if (!launcher.showingFloatingMenu) {
                m8051a();
            }
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i6, KeyEvent keyEvent) {
        if (this.f16548v || i6 != 66) {
            return super.onKeyDown(i6, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i6, KeyEvent keyEvent) {
        if (keyEvent.isTracking() && !this.f16548v && i6 == 66) {
            this.f16548v = true;
            ArrayList<View> focusables = getFocusables(2);
            focusables.remove(this);
            int size = focusables.size();
            if (size != 0) {
                if (size == 1) {
                    Object tag = getTag();
                    if (tag instanceof ItemInfo) {
                        ItemInfo itemInfo = (ItemInfo) tag;
                        if (itemInfo.spanX == 1 && itemInfo.spanY == 1) {
                            focusables.get(0).performClick();
                            this.f16548v = false;
                            return true;
                        }
                    }
                }
                focusables.get(0).requestFocus();
                return true;
            }
            this.f16548v = false;
        }
        return super.onKeyUp(i6, keyEvent);
    }

    @Override // android.appwidget.AppWidgetHostView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        try {
            super.onLayout(z5, i6, i7, i8, i9);
        } catch (RuntimeException unused) {
            post(new WidgetHostViewRunnable(this, 1));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i6, int i7, int i8, int i9) {
        Launcher launcher = this.f16539m;
        super.onSizeChanged(i6, i7, i8, i9);
        View childAt = getChildAt(1);
        try {
            ComponentName componentName = getAppWidgetInfo().provider;
            TextViewCustomFont textViewCustomFont = this.f16544r;
            if (componentName == null || getAppWidgetInfo().provider.getPackageName() == null || !getAppWidgetInfo().provider.getPackageName().equals(launcher.getPackageName())) {
                childAt.setPadding(0, 0, 0, 0);
                Drawable background = childAt.getBackground();
                if (background == null && (childAt instanceof ViewGroup)) {
                    View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                    Objects.toString(textViewCustomFont.getText());
                    Objects.toString(childAt2);
                    if (childAt2 != null && (background = childAt2.getBackground()) == null && (childAt2 instanceof ImageView)) {
                        background = ((ImageView) childAt2).getDrawable();
                    }
                }
                Objects.toString(textViewCustomFont.getText());
                Objects.toString(background);
                if (background instanceof ColorDrawable) {
                    childAt.setBackgroundColor(((ColorDrawable) background).getColor());
                } else if (background instanceof GradientDrawable) {
                    Bitmap bitmapM8159k = Utilities.m8159k(background);
                    Objects.toString(textViewCustomFont.getText());
                    Objects.toString(bitmapM8159k);
                    if (bitmapM8159k != null) {
                        int i10 = 0;
                        new C1460n(bitmapM8159k).m3132c(new InterfaceC2154d() { // from class: com.luutinhit.launcher6.d2

                            /* JADX INFO: renamed from: k */
                            public /* synthetic */ LauncherAppWidgetHostView f16362k;

                            {
                                this.f16362k = LauncherAppWidgetHostView.this;
                            }

                            @Override // p084i0.InterfaceC2154d
                            /* JADX INFO: renamed from: a */
                            public final void mo907a(C2156f c2156f) {
                                C2155e c2155e;
                                C2155e c2155e2;
                                switch (i10) {
                                    case 0:
                                        TextViewCustomFont textViewCustomFont2 = this.f16362k.f16544r;
                                        Objects.toString(textViewCustomFont2.getText());
                                        Objects.toString(c2156f);
                                        if (c2156f != null && (c2155e = c2156f.f18870d) != null) {
                                            childAt.setBackgroundColor(c2155e != null ? c2155e.f18860d : 0);
                                            Objects.toString(textViewCustomFont2.getText());
                                            break;
                                        }
                                        break;
                                    default:
                                        LauncherAppWidgetHostView launcherAppWidgetHostView = this.f16362k;
                                        if (c2156f != null && (c2155e2 = c2156f.f18870d) != null) {
                                            childAt.setBackgroundColor(c2155e2 != null ? c2155e2.f18860d : -16777216);
                                            Objects.toString(launcherAppWidgetHostView.f16544r.getText());
                                            break;
                                        }
                                        break;
                                }
                            }
                        });
                    }
                } else if (background instanceof BitmapDrawable) {
                    C1460n c1460n = new C1460n(((BitmapDrawable) background).getBitmap());
                    int i11 = 1;
                    c1460n.m3132c(new InterfaceC2154d() { // from class: com.luutinhit.launcher6.d2

                        /* JADX INFO: renamed from: k */
                        public /* synthetic */ LauncherAppWidgetHostView f16362k;

                        {
                            this.f16362k = LauncherAppWidgetHostView.this;
                        }

                        @Override // p084i0.InterfaceC2154d
                        /* JADX INFO: renamed from: a */
                        public final void mo907a(C2156f c2156f) {
                            C2155e c2155e;
                            C2155e c2155e2;
                            switch (i11) {
                                case 0:
                                    TextViewCustomFont textViewCustomFont2 = this.f16362k.f16544r;
                                    Objects.toString(textViewCustomFont2.getText());
                                    Objects.toString(c2156f);
                                    if (c2156f != null && (c2155e = c2156f.f18870d) != null) {
                                        childAt.setBackgroundColor(c2155e != null ? c2155e.f18860d : 0);
                                        Objects.toString(textViewCustomFont2.getText());
                                        break;
                                    }
                                    break;
                                default:
                                    LauncherAppWidgetHostView launcherAppWidgetHostView = this.f16362k;
                                    if (c2156f != null && (c2155e2 = c2156f.f18870d) != null) {
                                        childAt.setBackgroundColor(c2155e2 != null ? c2155e2.f18860d : -16777216);
                                        Objects.toString(launcherAppWidgetHostView.f16544r.getText());
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                }
            } else {
                Objects.toString(textViewCustomFont.getText());
            }
        } catch (Throwable th) {
            th.getMessage();
        }
        DeviceProfile deviceProfile = this.f16540n;
        if (i6 <= deviceProfile.f15982H && i7 <= deviceProfile.f15983I) {
            this.f16552z = launcher.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
        }
        Path path = this.f16551y;
        path.reset();
        float f6 = i6;
        float f7 = i7 - this.f16545s;
        float f8 = this.f16552z;
        Path path2 = new Path();
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        float f9 = f6 - 0.0f;
        float f10 = f7 - 0.0f;
        float f11 = f8 * 2.0f;
        float fMin = f11 > Math.min(f9, f10) ? 1.0f - (Math.min(1.0f, ((f11 / Math.min(f9, f10)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        float fMin2 = ((double) (f11 / Math.min(f9, f10))) > 0.6d ? 1.0f + (Math.min(1.0f, ((f8 / Math.min(f9 / 2.0f, f10 / 2.0f)) - 0.6f) / 0.3f) * 0.042454004f) : 1.0f;
        float f12 = f9 / 2.0f;
        path2.moveTo(0.0f + f12, 0.0f);
        float f13 = f8 / 100.0f;
        float f14 = 128.19f * f13 * fMin;
        float f15 = f9 - f14;
        path2.lineTo(Math.max(f12, f15) + 0.0f, 0.0f);
        float f16 = f9 + 0.0f;
        float f17 = 83.62f * f13 * fMin2;
        float f18 = f16 - f17;
        float f19 = f13 * 67.45f;
        float f20 = f16 - f19;
        float f21 = f13 * 4.64f;
        float f22 = 0.0f + f21;
        float f23 = f13 * 51.16f;
        float f24 = f16 - f23;
        float f25 = 13.36f * f13;
        float f26 = 0.0f + f25;
        path2.cubicTo(f18, 0.0f, f20, f22, f24, f26);
        float f27 = f13 * 34.86f;
        float f28 = f16 - f27;
        float f29 = f13 * 22.07f;
        float f30 = 0.0f + f29;
        float f31 = f16 - f29;
        float f32 = 0.0f + f27;
        float f33 = f16 - f25;
        float f34 = 0.0f + f23;
        path2.cubicTo(f28, f30, f31, f32, f33, f34);
        float f35 = f16 - f21;
        float f36 = 0.0f + f19;
        float f37 = 0.0f + f17;
        float f38 = f10 / 2.0f;
        path2.cubicTo(f35, f36, f16, f37, f16, Math.min(f38, f14) + 0.0f);
        float f39 = f10 - f14;
        path2.lineTo(f16, Math.max(f38, f39) + 0.0f);
        float f40 = 0.0f + f10;
        float f41 = f40 - f17;
        float f42 = f40 - f19;
        float f43 = f40 - f23;
        path2.cubicTo(f16, f41, f35, f42, f33, f43);
        float f44 = f40 - f27;
        float f45 = f40 - f29;
        float f46 = f40 - f25;
        path2.cubicTo(f31, f44, f28, f45, f24, f46);
        float f47 = f40 - f21;
        path2.cubicTo(f20, f47, f18, f40, Math.max(f12, f15) + 0.0f, f40);
        path2.lineTo(Math.min(f12, f14) + 0.0f, f40);
        path2.cubicTo(f37, f40, f36, f47, f34, f46);
        path2.cubicTo(f32, f45, f30, f44, f26, f43);
        path2.cubicTo(f22, f42, 0.0f, f41, 0.0f, Math.max(f38, f39) + 0.0f);
        path2.lineTo(0.0f, Math.min(f38, f14) + 0.0f);
        path2.cubicTo(0.0f, f37, f22, f36, f26, f34);
        path2.cubicTo(f30, f32, f32, f30, f34, f26);
        path2.cubicTo(f36, f22, f37, 0.0f, Math.min(f12, f14) + 0.0f, 0.0f);
        path2.close();
        path.addPath(path2);
        path.setFillType(Path.FillType.INVERSE_WINDING);
        path.close();
        Paint paint = this.f16550x;
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        int action = motionEvent.getAction();
        Launcher launcher = this.f16539m;
        WidgetHostViewRunnable widgetHostViewRunnable = this.f16535E;
        C0148h c0148h = this.f16537k;
        if (action != 1) {
            if (action == 2) {
                if (Utilities.pointInView(this, motionEvent.getX(), motionEvent.getY(), this.f16547u)) {
                    return false;
                }
                c0148h.m362b();
                removeCallbacks(widgetHostViewRunnable);
                if (launcher.showingFloatingMenu) {
                    return false;
                }
                m8051a();
                return false;
            }
            if (action != 3) {
                return false;
            }
        }
        c0148h.m362b();
        removeCallbacks(widgetHostViewRunnable);
        if (launcher.showingFloatingMenu) {
            return false;
        }
        m8051a();
        return false;
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void prepareView(View view) {
        Objects.toString(view);
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.setMargins(0, 0, 0, this.f16546t);
            layoutParams.gravity = 119;
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        setSelected(this.f16548v && view2 != null);
        if (view2 != null) {
            view2.setFocusableInTouchMode(false);
        }
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void setAppWidget(int i6, AppWidgetProviderInfo appWidgetProviderInfo) {
        super.setAppWidget(i6, appWidgetProviderInfo);
        Objects.toString(appWidgetProviderInfo);
        this.f16549w = "widget_" + i6;
        String strLoadLabel = appWidgetProviderInfo.label;
        Launcher launcher = this.f16539m;
        if (strLoadLabel == null) {
            strLoadLabel = Utilities.f16752m ? appWidgetProviderInfo.loadLabel(launcher.getPackageManager()) : "";
        }
        C0056Y tinyDB = launcher.getTinyDB();
        int appWidgetId = getAppWidgetId();
        tinyDB.getClass();
        String string = tinyDB.f137a.getString("widget_label_" + appWidgetId, null);
        TextViewCustomFont textViewCustomFont = this.f16544r;
        if (string != null) {
            strLoadLabel = string;
        }
        textViewCustomFont.setText(strLoadLabel);
        this.f16545s = textViewCustomFont.getMeasuredHeight();
        this.f16546t = this.f16545s;
    }

    public void setLabel(CharSequence charSequence) {
        if (charSequence != null) {
            this.f16544r.setText(charSequence.toString());
            C0056Y tinyDB = this.f16539m.getTinyDB();
            int appWidgetId = getAppWidgetId();
            String string = charSequence.toString();
            tinyDB.getClass();
            String str = "widget_label_" + appWidgetId;
            str.getClass();
            string.getClass();
            tinyDB.f137a.edit().putString(str, string).apply();
        }
    }

    public void setTextColor(int i6) {
        this.f16544r.setTextColor(i6);
    }

    @Override // android.appwidget.AppWidgetHostView
    public final void updateAppWidget(RemoteViews remoteViews) {
        try {
            this.f16541o = this.f16539m.getResources().getConfiguration().orientation;
            setPadding(0, 0, 0, 0);
            super.updateAppWidget(remoteViews);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
