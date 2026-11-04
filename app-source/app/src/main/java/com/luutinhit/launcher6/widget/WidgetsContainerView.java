package com.luutinhit.launcher6.widget;

import A2.RunnableC0024c;
import A4.RunnableC0026a;
import B3.C0079v;
import C2.RunnableC0147g;
import D3.C0194b;
import E4.AbstractC0212f;
import F3.AbstractC0279f;
import F3.EnumC0278e;
import G3.C0343C;
import G3.C0350f;
import G3.C0351g;
import G3.C0361q;
import G3.C0364t;
import G3.C0367w;
import G3.C0368x;
import G3.C0369y;
import G3.C0370z;
import G3.CallableC0366v;
import G3.RunnableC0360p;
import G3.ViewOnLayoutChangeListenerC0359o;
import G3.ViewOnTouchListenerC0363s;
import J3.AbstractC0544c;
import T0.C1029l;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DeleteDropTarget;
import com.luutinhit.launcher6.DragController;
import com.luutinhit.launcher6.DragObject;
import com.luutinhit.launcher6.DragSource;
import com.luutinhit.launcher6.ExtendedEditText;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.IconCache;
import com.luutinhit.launcher6.Insettable;
import com.luutinhit.launcher6.ItemInfo;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherAppState;
import com.luutinhit.launcher6.LauncherAppWidgetProviderInfo;
import com.luutinhit.launcher6.PendingAddItemInfo;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.WidgetPreviewLoader;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.editscreen.LinearLayoutRound;
import com.luutinhit.launcher6.util.SpeedLinearLayoutManager;
import com.luutinhit.launcher6.widget.WidgetsContainerView;
import com.luutinhit.launcher6.widget.view.SlidingUpWidgetsCellAppStyle;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import p024a.AbstractC1314a;
import p123r4.AbstractC2679b;
import p154y3.C3033h;
import p159z4.C3082c;
import p159z4.CallableC3080a;

/* JADX INFO: loaded from: classes.dex */
public class WidgetsContainerView extends AbstractC0279f implements View.OnLongClickListener, View.OnClickListener, DragSource, Insettable {

    /* JADX INFO: renamed from: l0 */
    public static final /* synthetic */ int f23526l0 = 0;

    /* JADX INFO: renamed from: S */
    public Launcher f17185S;

    /* JADX INFO: renamed from: T */
    public DragController f17186T;

    /* JADX INFO: renamed from: U */
    public IconCache f17187U;

    /* JADX INFO: renamed from: V */
    public Rect f17188V;

    /* JADX INFO: renamed from: W */
    public RecyclerView f17189W;

    /* JADX INFO: renamed from: a0 */
    public C0343C f23527a0;

    /* JADX INFO: renamed from: b0 */
    public SpeedLinearLayoutManager f23528b0;

    /* JADX INFO: renamed from: c0 */
    public AppCompatImageView f23529c0;

    /* JADX INFO: renamed from: d0 */
    public ExtendedEditText f23530d0;

    /* JADX INFO: renamed from: e0 */
    public C3033h f23531e0;

    /* JADX INFO: renamed from: f0 */
    public Toast f23532f0;

    /* JADX INFO: renamed from: g0 */
    public WidgetPreviewLoader f23533g0;

    /* JADX INFO: renamed from: h0 */
    public InputMethodManager f23534h0;

    /* JADX INFO: renamed from: i0 */
    public boolean f23535i0;

    /* JADX INFO: renamed from: j0 */
    public LinearLayoutRound f23536j0;

    /* JADX INFO: renamed from: k0 */
    public C0370z f23537k0;

    public WidgetsContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17188V = new Rect();
        this.f23537k0 = new C0370z(0, this);
        Launcher launcher = (Launcher) context;
        this.f17185S = launcher;
        this.f17186T = launcher.getDragController();
        this.f23527a0 = new C0343C(context, this, this, this, launcher);
        this.f17187U = LauncherAppState.getInstance().f16219b;
        this.f23534h0 = (InputMethodManager) context.getSystemService("input_method");
        this.f23535i0 = launcher.isDarkMode;
    }

    public WidgetPreviewLoader getWidgetPreviewLoader() {
        if (this.f23533g0 == null) {
            this.f23533g0 = LauncherAppState.getInstance().f16220c;
        }
        return this.f23533g0;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: F */
    public final void mo7691F(View view, DragObject dragObject, boolean z5) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z6;
        Launcher launcher = this.f17185S;
        if (!z5 || (view != launcher.getWorkspace() && !(view instanceof DeleteDropTarget) && !(view instanceof Folder))) {
            launcher.exitSpringLoadedDragModeDelayed(true, Launcher.EXIT_SPRINGLOADED_MODE_SHORT_TIMEOUT, null);
        }
        launcher.unlockScreenOrientation(false);
        if (z5) {
            return;
        }
        if (view instanceof Workspace) {
            CellLayout cellLayout = (CellLayout) ((Workspace) view).getChildAt(launcher.getCurrentWorkspaceScreen());
            ItemInfo itemInfo = (ItemInfo) dragObject.f16523g;
            if (cellLayout != null) {
                z6 = !cellLayout.m7646o(itemInfo.spanX, itemInfo.spanY, null);
            } else {
                z6 = false;
            }
        } else {
            z6 = false;
        }
        if (z6) {
            launcher.showOutOfSpaceMessage(false);
        }
        dragObject.f16528l = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        InputMethodManager inputMethodManager = this.f23534h0;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
        super.clearFocus();
        try {
            this.f23530d0.setText("");
            C3033h c3033h = this.f23531e0;
            if (c3033h != null) {
                HashMap map = c3033h.f21982d;
                map.clear();
                map.putAll(c3033h.f21981c);
                ArrayList arrayList = c3033h.f21980b;
                arrayList.clear();
                arrayList.addAll(c3033h.f21979a);
                C0343C c0343c = this.f23527a0;
                C3033h c3033h2 = this.f23531e0;
                c0343c.f1124o = c3033h2;
                c0343c.f1131v = new boolean[c3033h2.f21980b.size()];
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.luutinhit.launcher6.DragSource
    public float getIntrinsicIconScaleFactor() {
        return 0.0f;
    }

    @Override // F3.AbstractC0279f, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        SlidingUpWidgetsCellAppStyle slidingUpWidgetsCellAppStyle;
        super.onAttachedToWindow();
        Launcher launcher = this.f17185S;
        if (launcher == null || (slidingUpWidgetsCellAppStyle = launcher.mWidgetsAppStyle) == null) {
            return;
        }
        Objects.toString(slidingUpWidgetsCellAppStyle);
        launcher.mWidgetsAppStyle.setOnAddWidgetButtonClickListener(new C0364t(0, this));
        launcher.mWidgetsAppStyle.m737a(new C0369y(0, this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Launcher launcher = this.f17185S;
        if (launcher.isWidgetsViewVisible()) {
            launcher.getWorkspace().getClass();
            boolean z5 = view instanceof AbstractC0544c;
            m8244v();
        }
    }

    @Override // F3.AbstractC0279f, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        LinearLayoutRound linearLayoutRound = (LinearLayoutRound) findViewById(R.id.widgets_view_content);
        this.f23536j0 = linearLayoutRound;
        linearLayoutRound.setDarkModeBackgroundColor(this.f23535i0 ? -14935012 : -2565928);
        this.f17189W = (RecyclerView) findViewById(R.id.widgets_list_view);
        Launcher launcher = this.f17185S;
        SpeedLinearLayoutManager speedLinearLayoutManager = new SpeedLinearLayoutManager(1);
        this.f23528b0 = speedLinearLayoutManager;
        this.f17189W.setLayoutManager(speedLinearLayoutManager);
        RecyclerView recyclerView = this.f17189W;
        C0343C c0343c = this.f23527a0;
        recyclerView.setAdapter(c0343c);
        c0343c.f1129t = this.f23535i0;
        this.f23529c0 = (AppCompatImageView) findViewById(R.id.action_clear);
        ExtendedEditText extendedEditText = (ExtendedEditText) findViewById(R.id.search_widget);
        this.f23530d0 = extendedEditText;
        extendedEditText.addTextChangedListener(this.f23537k0);
        this.f17189W.m3420m(new C0194b(1, this));
        C0079v c0079v = new C0079v();
        TypedArray typedArrayObtainStyledAttributes = launcher.obtainStyledAttributes(C0079v.f221k);
        c0079v.f222j = launcher.getDrawable(R.drawable.divider_white);
        typedArrayObtainStyledAttributes.recycle();
        this.f17189W.m3419l(c0079v);
        int i6 = 0;
        this.f23529c0.setOnClickListener(new View.OnClickListener() { // from class: G3.r

            /* JADX INFO: renamed from: k */
            public /* synthetic */ WidgetsContainerView f1201k;

            {
                this.f1201k = WidgetsContainerView.this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetsContainerView widgetsContainerView = this.f1201k;
                switch (i6) {
                    case 0:
                        widgetsContainerView.f23530d0.setText("");
                        widgetsContainerView.m8243u("");
                        break;
                    default:
                        int i7 = WidgetsContainerView.f23526l0;
                        widgetsContainerView.setPanelState(EnumC0278e.f850k);
                        break;
                }
            }
        });
        int i7 = 1;
        findViewById(R.id.out_side_widgets_view).setOnClickListener(new View.OnClickListener() { // from class: G3.r

            /* JADX INFO: renamed from: k */
            public /* synthetic */ WidgetsContainerView f1201k;

            {
                this.f1201k = WidgetsContainerView.this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetsContainerView widgetsContainerView = this.f1201k;
                switch (i7) {
                    case 0:
                        widgetsContainerView.f23530d0.setText("");
                        widgetsContainerView.m8243u("");
                        break;
                    default:
                        int i8 = WidgetsContainerView.f23526l0;
                        widgetsContainerView.setPanelState(EnumC0278e.f850k);
                        break;
                }
            }
        });
        m737a(new C0368x(0, this));
        this.f17189W.setOnTouchListener(new ViewOnTouchListenerC0363s(0, this));
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:58:0x021f  */
    /* JADX WARN: Code duplicated, block: B:59:0x0222  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        Bitmap bitmapCreateIconBitmap;
        float fWidth = 0.0f;
        int width = 0;
        float f6 = 0.0f;
        C0361q c0361q;
        C0351g c0351g;
        LauncherAppWidgetProviderInfo launcherAppWidgetProviderInfo;
        Bundle bundleM904a;
        Bitmap bitmapCreateIconBitmap2;
        float fWidth2;
        int width2;
        boolean z5 = true;
        int i6 = 0;
        String.format("onLonglick [v=%s]", view);
        if (view.isInTouchMode()) {
            Launcher launcher = this.f17185S;
            if (launcher.isWidgetsViewVisible()) {
                launcher.getWorkspace().getClass();
                if (launcher.isDraggingEnabled()) {
                    boolean z6 = view instanceof ViewOnLayoutChangeListenerC0359o;
                    IconCache iconCache = this.f17187U;
                    if (z6) {
                        ViewOnLayoutChangeListenerC0359o viewOnLayoutChangeListenerC0359o = (ViewOnLayoutChangeListenerC0359o) view;
                        WidgetImageView widgetImageView = (WidgetImageView) viewOnLayoutChangeListenerC0359o.findViewById(R.id.widget_preview);
                        PendingAddItemInfo pendingAddItemInfo = (PendingAddItemInfo) viewOnLayoutChangeListenerC0359o.getTag();
                        if (widgetImageView.getBitmap() == null) {
                            z5 = false;
                        } else {
                            Rect bitmapBounds = widgetImageView.getBitmapBounds();
                            Objects.toString(bitmapBounds);
                            boolean z7 = pendingAddItemInfo instanceof C0351g;
                            if (z7) {
                                C0351g c0351g2 = (C0351g) pendingAddItemInfo;
                                int[] iArrJ0 = launcher.getWorkspace().J0(c0351g2, true);
                                Bitmap bitmap = widgetImageView.getBitmap();
                                int iMin = Math.min((int) (bitmap.getWidth() * 1.25f), iArrJ0[0]);
                                int[] iArr = new int[1];
                                bitmapCreateIconBitmap2 = getWidgetPreviewLoader().generateWidgetPreview(this.f17185S, c0351g2.f1149C, iMin, null, iArr);
                                if (iArr[0] < bitmap.getWidth()) {
                                    int width3 = (bitmap.getWidth() - iArr[0]) / 2;
                                    if (bitmap.getWidth() > widgetImageView.getWidth()) {
                                        width3 = (widgetImageView.getWidth() * width3) / bitmap.getWidth();
                                    }
                                    bitmapBounds.left += width3;
                                    bitmapBounds.right -= width3;
                                }
                                fWidth2 = bitmapBounds.width();
                                width2 = bitmapCreateIconBitmap2.getWidth();
                            } else {
                                bitmapCreateIconBitmap2 = Utilities.createIconBitmap(iconCache.getFullResIcon(((C0350f) viewOnLayoutChangeListenerC0359o.getTag()).f1147B), launcher);
                                pendingAddItemInfo.spanY = 1;
                                pendingAddItemInfo.spanX = 1;
                                fWidth2 = launcher.getDeviceProfile().f15978D;
                                width2 = bitmapCreateIconBitmap2.getWidth();
                            }
                            float f7 = fWidth2 / width2;
                            Bitmap bitmap2 = bitmapCreateIconBitmap2;
                            if (z7) {
                                int i7 = ((C0351g) pendingAddItemInfo).f1148B;
                            }
                            Objects.toString(bitmapBounds);
                            launcher.lockScreenOrientation();
                            Workspace workspace = launcher.getWorkspace();
                            workspace.getClass();
                            Objects.toString(pendingAddItemInfo);
                            Objects.toString(bitmap2);
                            workspace.J0(pendingAddItemInfo, false);
                            this.f17186T.m7880n(widgetImageView, bitmap2, this, pendingAddItemInfo, bitmapBounds, f7);
                            bitmap2.recycle();
                        }
                        if (z5 && (view.getTag() instanceof C0351g)) {
                            c0361q = new C0361q(launcher, view);
                            c0351g = c0361q.f1198o;
                            launcherAppWidgetProviderInfo = c0351g.f1149C;
                            launcherAppWidgetProviderInfo.getClass();
                            bundleM904a = C0361q.m904a(launcher, c0351g);
                            if (((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).configure != null) {
                                c0351g.f1151E = bundleM904a;
                            } else {
                                RunnableC0360p runnableC0360p = new RunnableC0360p(c0361q, launcherAppWidgetProviderInfo, bundleM904a, i6);
                                c0361q.f1194k = runnableC0360p;
                                c0361q.f1193j = new RunnableC0024c(c0361q, launcherAppWidgetProviderInfo, 8, false);
                                c0361q.f1196m.post(runnableC0360p);
                            }
                            launcher.getDragController().f16104m.add(c0361q);
                        }
                        return z5;
                    }
                    if (view instanceof AbstractC0544c) {
                        AbstractC0544c abstractC0544c = (AbstractC0544c) view;
                        PendingAddItemInfo pendingAddItemInfo2 = (PendingAddItemInfo) abstractC0544c.getTag();
                        Rect rect = new Rect(0, 0, abstractC0544c.getWidth(), abstractC0544c.getHeight());
                        rect.toString();
                        boolean z8 = pendingAddItemInfo2 instanceof C0351g;
                        if (z8) {
                            C0351g c0351g3 = (C0351g) pendingAddItemInfo2;
                            int[] iArrJ1 = launcher.getWorkspace().J0(c0351g3, true);
                            bitmapCreateIconBitmap = Utilities.m8151c(abstractC0544c);
                            if (bitmapCreateIconBitmap != null) {
                                f6 = 1.0f;
                            } else {
                                int[] iArr2 = new int[1];
                                bitmapCreateIconBitmap = getWidgetPreviewLoader().generateWidgetPreview(this.f17185S, c0351g3.f1149C, Math.min((int) (rect.width() * 1.25f), iArrJ1[0]), null, iArr2);
                                if (iArr2[0] < rect.width()) {
                                    int iWidth = (rect.width() - iArr2[0]) / 2;
                                    if (rect.width() > abstractC0544c.getWidth()) {
                                        iWidth = (abstractC0544c.getWidth() * iWidth) / rect.width();
                                    }
                                    rect.left += iWidth;
                                    rect.right -= iWidth;
                                }
                                fWidth = rect.width();
                                width = bitmapCreateIconBitmap.getWidth();
                            }
                            Bitmap bitmap3 = bitmapCreateIconBitmap;
                            if (z8) {
                                int i8 = ((C0351g) pendingAddItemInfo2).f1148B;
                            }
                            rect.toString();
                            launcher.lockScreenOrientation();
                            Workspace workspace2 = launcher.getWorkspace();
                            workspace2.getClass();
                            Objects.toString(pendingAddItemInfo2);
                            Objects.toString(bitmap3);
                            workspace2.J0(pendingAddItemInfo2, false);
                            this.f17186T.m7880n(abstractC0544c, bitmap3, this, pendingAddItemInfo2, rect, f6);
                            bitmap3.recycle();
                        } else {
                            bitmapCreateIconBitmap = Utilities.createIconBitmap(iconCache.getFullResIcon(((C0350f) abstractC0544c.getTag()).f1147B), launcher);
                            pendingAddItemInfo2.spanY = 1;
                            pendingAddItemInfo2.spanX = 1;
                            fWidth = launcher.getDeviceProfile().f15978D;
                            width = bitmapCreateIconBitmap.getWidth();
                        }
                        f6 = fWidth / width;
                        Bitmap bitmap4 = bitmapCreateIconBitmap;
                        if (z8) {
                            int i9 = ((C0351g) pendingAddItemInfo2).f1148B;
                        }
                        rect.toString();
                        launcher.lockScreenOrientation();
                        Workspace workspace3 = launcher.getWorkspace();
                        workspace3.getClass();
                        Objects.toString(pendingAddItemInfo2);
                        Objects.toString(bitmap4);
                        workspace3.J0(pendingAddItemInfo2, false);
                        this.f17186T.m7880n(abstractC0544c, bitmap4, this, pendingAddItemInfo2, rect, f6);
                        bitmap4.recycle();
                    } else {
                        Objects.toString(view);
                    }
                    if (launcher.getDragController().f16097f) {
                        launcher.enterSpringLoadedDragMode();
                    }
                    if (z5) {
                        c0361q = new C0361q(launcher, view);
                        c0351g = c0361q.f1198o;
                        launcherAppWidgetProviderInfo = c0351g.f1149C;
                        launcherAppWidgetProviderInfo.getClass();
                        bundleM904a = C0361q.m904a(launcher, c0351g);
                        if (((AppWidgetProviderInfo) launcherAppWidgetProviderInfo).configure != null) {
                            c0351g.f1151E = bundleM904a;
                        } else {
                            RunnableC0360p runnableC0360p2 = new RunnableC0360p(c0361q, launcherAppWidgetProviderInfo, bundleM904a, i6);
                            c0361q.f1194k = runnableC0360p2;
                            c0361q.f1193j = new RunnableC0024c(c0361q, launcherAppWidgetProviderInfo, 8, false);
                            c0361q.f1196m.post(runnableC0360p2);
                        }
                        launcher.getDragController().f16104m.add(c0361q);
                    }
                    return z5;
                }
            }
        }
        return false;
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: r */
    public final boolean mo7711r() {
        return true;
    }

    public void setDarkMode(boolean z5) {
        this.f23535i0 = z5;
        LinearLayoutRound linearLayoutRound = this.f23536j0;
        if (linearLayoutRound != null) {
            linearLayoutRound.setDarkModeBackgroundColor(z5 ? -14935012 : -2565928);
        }
        C0343C c0343c = this.f23527a0;
        if (c0343c != null) {
            c0343c.f1129t = z5;
        }
    }

    @Override // F3.AbstractC0279f
    public void setDragView(View view) {
        super.setDragView(view);
    }

    @Override // com.luutinhit.launcher6.Insettable
    public void setInsets(Rect rect) {
        Rect rect2 = new Rect(0, 0, 0, 0);
        Rect rect3 = this.f17188V;
        if (rect2.equals(rect3)) {
            return;
        }
        rect3.set(rect2);
        setPadding(0, rect2.top, 0, rect2.bottom);
        setPadding(0, 0, 0, 0);
    }

    public final void setSearchBarBounds(Rect rect) {
        post(new RunnableC0147g(10, this));
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        if (i6 == 0) {
            setAlpha(1.0f);
        } else {
            this.f23529c0.setVisibility(8);
        }
        super.setVisibility(i6);
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: t */
    public final boolean mo7712t() {
        return false;
    }

    /* JADX INFO: renamed from: u */
    public final void m8243u(CharSequence charSequence) {
        try {
            new C3082c(new CallableC3080a(new CallableC0366v(this, charSequence, 0)).m8812w(AbstractC0212f.f640a), new C0367w(0), 0).m8810u(new RunnableC0026a(new C1029l(6, this), AbstractC2679b.m9681a(), 1));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            AbstractC1314a.m2681A(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m8244v() {
        Toast toast = this.f23532f0;
        if (toast != null) {
            toast.cancel();
        }
        CharSequence text = getContext().getText(R.string.long_press_widget_to_add);
        String string = getContext().getString(R.string.long_accessible_way_to_add);
        if (Utilities.f16752m) {
            SpannableString spannableString = new SpannableString(text);
            spannableString.setSpan(new TtsSpan.TextBuilder(string).build(), 0, spannableString.length(), 18);
            text = spannableString;
        }
        Toast toastMakeText = Toast.makeText(getContext(), text, 0);
        this.f23532f0 = toastMakeText;
        toastMakeText.show();
    }
}
