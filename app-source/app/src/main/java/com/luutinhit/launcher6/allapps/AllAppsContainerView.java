package com.luutinhit.launcher6.allapps;

import B3.C0059b;
import C2.C0144d;
import X2.ViewOnFocusChangeListenerC1159a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.luutinhit.launcher6.AppInfo;
import com.luutinhit.launcher6.BaseContainerView;
import com.luutinhit.launcher6.BubbleTextView;
import com.luutinhit.launcher6.CellLayout;
import com.luutinhit.launcher6.DeleteDropTarget;
import com.luutinhit.launcher6.DeviceProfile;
import com.luutinhit.launcher6.DragObject;
import com.luutinhit.launcher6.DragSource;
import com.luutinhit.launcher6.ExtendedEditText;
import com.luutinhit.launcher6.Folder;
import com.luutinhit.launcher6.ItemInfo;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.Utilities;
import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcherios.R;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import m3.AbstractC2394h;
import m3.AbstractC2402p;
import m3.C2390d;
import m3.C2393g;
import m3.C2399m;
import m3.C2400n;
import m3.C2401o;
import m3.InterfaceC2397k;
import p069e3.C1978f;
import p124s0.a0;

/* JADX INFO: loaded from: classes.dex */
public class AllAppsContainerView extends BaseContainerView implements DragSource, View.OnTouchListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: A */
    public int f16236A;

    /* JADX INFO: renamed from: B */
    public int f16237B;

    /* JADX INFO: renamed from: C */
    public int f16238C;

    /* JADX INFO: renamed from: D */
    public int f16239D;

    /* JADX INFO: renamed from: E */
    public Point f16240E;

    /* JADX INFO: renamed from: F */
    public Point f16241F;

    /* JADX INFO: renamed from: q */
    public Launcher f16242q;

    /* JADX INFO: renamed from: r */
    public C2399m f16243r;

    /* JADX INFO: renamed from: s */
    public C2393g f16244s;

    /* JADX INFO: renamed from: t */
    public final AllAppsGridAdapter$AppsGridLayoutManager f16245t;

    /* JADX INFO: renamed from: u */
    public C2390d f16246u;

    /* JADX INFO: renamed from: v */
    public Rect f16247v;

    /* JADX INFO: renamed from: w */
    public AllAppsRecyclerView f16248w;

    /* JADX INFO: renamed from: x */
    public View f16249x;

    /* JADX INFO: renamed from: y */
    public ExtendedEditText f16250y;

    /* JADX INFO: renamed from: z */
    public AbstractC2402p f16251z;

    public AllAppsContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16247v = new Rect();
        this.f16240E = new Point(-1, -1);
        this.f16241F = new Point();
        Resources resources = context.getResources();
        Launcher launcher = (Launcher) context;
        this.f16242q = launcher;
        this.f16236A = resources.getDimensionPixelSize(R.dimen.all_apps_grid_view_start_margin);
        C2399m c2399m = new C2399m(context);
        this.f16243r = c2399m;
        C2393g c2393g = new C2393g(launcher, c2399m, this, launcher, this);
        this.f16244s = c2393g;
        c2399m.f19669k = c2393g;
        this.f16245t = c2393g.f19635p;
        this.f16246u = c2393g.f19636q;
        this.f16239D = resources.getDimensionPixelSize(R.dimen.all_apps_list_top_bottom_padding);
        Selection.setSelection(new SpannableStringBuilder(), 0);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: F */
    public final void mo7691F(View view, DragObject dragObject, boolean z5) {
        com.luutinhit.launcher6.JadxSupport.useOriginalBytecode(); // jadx flagged this method; the original bytecode runs
        boolean z6;
        Launcher launcher = this.f16242q;
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

    /* JADX INFO: renamed from: b */
    public final boolean m7933b(MotionEvent motionEvent) {
        DeviceProfile deviceProfile = this.f16242q.getDeviceProfile();
        int x6 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        Point point = this.f16240E;
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                }
            } else if (point.x > -1) {
                if (((float) Math.hypot(motionEvent.getX() - point.x, motionEvent.getY() - point.y)) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    ((Launcher) getContext()).showWorkspace(true);
                    return true;
                }
            }
            point.set(-1, -1);
        } else {
            Rect rect = this.f16247v;
            if (!rect.isEmpty()) {
                Rect rect2 = new Rect(rect);
                rect2.inset((-deviceProfile.f15998X) / 2, 0);
                if (motionEvent.getX() < rect2.left || motionEvent.getX() > rect2.right) {
                    point.set(x6, y4);
                    return true;
                }
            } else if (motionEvent.getX() < getPaddingLeft() || motionEvent.getX() > getWidth() - getPaddingRight()) {
                point.set(x6, y4);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        throw null;
    }

    @Override // com.luutinhit.launcher6.DragSource
    public float getIntrinsicIconScaleFactor() {
        DeviceProfile deviceProfile = this.f16242q.getDeviceProfile();
        return deviceProfile.f15998X / deviceProfile.f15978D;
    }

    @Override // com.luutinhit.launcher6.BaseContainerView, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        getContentView().setOnFocusChangeListener(new ViewOnFocusChangeListenerC1159a(2, this));
        this.f16249x = findViewById(R.id.search_container);
        this.f16250y = (ExtendedEditText) findViewById(R.id.search_box_input);
        this.f16251z = Utilities.f16752m ? new C2401o(this.f16249x) : new C2400n(this.f16249x);
        AllAppsRecyclerView allAppsRecyclerView = (AllAppsRecyclerView) findViewById(R.id.apps_list_view);
        this.f16248w = allAppsRecyclerView;
        allAppsRecyclerView.setApps(this.f16243r);
        this.f16248w.setLayoutManager(this.f16245t);
        this.f16248w.setAdapter(this.f16244s);
        this.f16248w.setHasFixedSize(true);
        this.f16248w.m3420m(this.f16251z);
        this.f16248w.setElevationController(this.f16251z);
        C2390d c2390d = this.f16246u;
        if (c2390d != null) {
            this.f16248w.m3419l(c2390d);
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE);
        BubbleTextView bubbleTextView = (BubbleTextView) layoutInflaterFrom.inflate(R.layout.all_apps_icon, (ViewGroup) this, false);
        bubbleTextView.getClass();
        bubbleTextView.m7599H(bubbleTextView.f15396j.resizeIconDrawable(new ColorDrawable()), bubbleTextView.f15403q);
        bubbleTextView.setText("");
        bubbleTextView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        BubbleTextView bubbleTextView2 = (BubbleTextView) layoutInflaterFrom.inflate(R.layout.all_apps_prediction_bar_icon, (ViewGroup) this, false);
        bubbleTextView2.getClass();
        bubbleTextView2.m7599H(bubbleTextView2.f15396j.resizeIconDrawable(new ColorDrawable()), bubbleTextView2.f15403q);
        bubbleTextView2.setText("");
        bubbleTextView2.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        AllAppsRecyclerView allAppsRecyclerView2 = this.f16248w;
        int measuredHeight = bubbleTextView2.getMeasuredHeight();
        int measuredHeight2 = bubbleTextView.getMeasuredHeight();
        allAppsRecyclerView2.f23474e1 = measuredHeight;
        allAppsRecyclerView2.f23475f1 = measuredHeight2;
        updateBackgroundAndPaddings();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return m7933b(motionEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (!view.isInTouchMode()) {
            return false;
        }
        Launcher launcher = this.f16242q;
        if (launcher.isAppsViewVisible()) {
            launcher.getWorkspace().getClass();
            if (!launcher.isDraggingEnabled()) {
                return false;
            }
            launcher.getWorkspace().y0(view, this.f16241F, this, false);
            launcher.enterSpringLoadedDragMode();
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i6, int i7) {
        InterfaceC2397k c1978f;
        Rect rect = this.f16642k;
        int i8 = rect.left;
        int i9 = rect.top;
        int size = View.MeasureSpec.getSize(i6) - rect.right;
        int size2 = View.MeasureSpec.getSize(i7) - rect.bottom;
        Rect rect2 = this.f16247v;
        rect2.set(i8, i9, size, size2);
        int iWidth = (!rect2.isEmpty() ? rect2.width() : View.MeasureSpec.getSize(i6)) - (this.f16248w.getMaxScrollbarWidth() * 2);
        DeviceProfile deviceProfile = this.f16242q.getDeviceProfile();
        Resources resources = getResources();
        deviceProfile.getClass();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.all_apps_grid_view_start_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.all_apps_icon_width_gap);
        int i10 = ((iWidth > 0 ? iWidth : deviceProfile.f16012l) + dimensionPixelSize2) - dimensionPixelSize;
        int i11 = deviceProfile.f15998X;
        int i12 = i10 / (dimensionPixelSize2 + i11);
        int iMax = Math.max(deviceProfile.inv.f16722n, i12);
        if (this.f16237B != i12 || this.f16238C != iMax) {
            this.f16237B = i12;
            this.f16238C = iMax;
            if (this.f16236A == 0 || !deviceProfile.f16004d) {
                c1978f = new C1978f(14);
            } else {
                int iCeil = (int) Math.ceil(i12 / 2.0f);
                C0144d c0144d = new C0144d();
                c0144d.f418j = iCeil;
                c0144d.f419k = Charset.forName("US-ASCII").newEncoder();
                c1978f = c0144d;
            }
            AllAppsRecyclerView allAppsRecyclerView = this.f16248w;
            allAppsRecyclerView.f23473d1 = this.f16237B;
            a0 recycledViewPool = allAppsRecyclerView.getRecycledViewPool();
            int iCeil2 = (int) Math.ceil(deviceProfile.f16013m / i11);
            recycledViewPool.m9743b(3, 1);
            recycledViewPool.m9743b(4, 1);
            recycledViewPool.m9743b(5, 1);
            recycledViewPool.m9743b(1, allAppsRecyclerView.f23473d1 * iCeil2);
            recycledViewPool.m9743b(2, allAppsRecyclerView.f23473d1);
            recycledViewPool.m9743b(0, iCeil2);
            int i13 = this.f16237B;
            C2393g c2393g = this.f16244s;
            c2393g.f19629B = i13;
            c2393g.f19635p.q1(i13);
            int i14 = this.f16237B;
            int i15 = this.f16238C;
            C2399m c2399m = this.f16243r;
            c2399m.f19673o = i14;
            c2399m.f19674p = i15;
            c2399m.f19672n = c1978f;
            c2399m.m9247c();
            int i16 = this.f16237B;
            if (i16 > 0) {
                int i17 = ((iWidth / i16) - i11) / 2;
                this.f16250y.setPaddingRelative(i17, 0, i17, 0);
            }
        }
        super.onMeasure(i6, i7);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            return false;
        }
        this.f16241F.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return m7933b(motionEvent);
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: r */
    public final boolean mo7711r() {
        return true;
    }

    public void setApps(List<AppInfo> list) {
        C2399m c2399m = this.f16243r;
        HashMap map = c2399m.f19661c;
        map.clear();
        for (AppInfo appInfo : list) {
            map.put(new C0059b(appInfo.f16329D, appInfo.user), appInfo);
        }
        c2399m.m9246b();
    }

    public void setPredictedApps(List<C0059b> list) {
        C2399m c2399m = this.f16243r;
        ArrayList arrayList = c2399m.f19666h;
        arrayList.clear();
        arrayList.addAll(list);
        c2399m.m9246b();
    }

    public void setSearchBarController(AbstractC2394h abstractC2394h) {
        Object obj = null;
        obj.getClass();
        throw new RuntimeException("Expected search bar controller to only be set once");
    }

    @Override // com.luutinhit.launcher6.DragSource
    /* JADX INFO: renamed from: t */
    public final boolean mo7712t() {
        return false;
    }
}
