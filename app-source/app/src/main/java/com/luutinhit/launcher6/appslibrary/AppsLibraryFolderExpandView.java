package com.luutinhit.launcher6.appslibrary;

import P3.C0832t;
import Q3.C0911s;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luutinhit.launcher6.InsertAbleFrameLayoutParams;
import com.luutinhit.launcher6.InsettableBackgroundFrameLayout;
import com.luutinhit.launcher6.Launcher;
import com.luutinhit.launcher6.LauncherAnimUtils;
import com.luutinhit.launcher6.LauncherRootView;
import com.luutinhit.launcherios.R;
import java.util.Objects;

/* JADX INFO: renamed from: com.luutinhit.launcher6.appslibrary.b */
/* JADX INFO: loaded from: classes.dex */
public final class AppsLibraryFolderExpandView extends InsettableBackgroundFrameLayout {

    /* JADX INFO: renamed from: n */
    public Launcher f16282n;

    /* JADX INFO: renamed from: o */
    public RecyclerView f16283o;

    /* JADX INFO: renamed from: p */
    public C0911s f16284p;

    public AppsLibraryFolderExpandView(Context context) {
        super(context);
        setId(R.id.apps_library_folder_expand);
        setX(0.0f);
        setY(0.0f);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        Launcher launcher = (Launcher) context;
        this.f16282n = launcher;
        InsertAbleFrameLayoutParams insertAbleFrameLayoutParams = new InsertAbleFrameLayoutParams(launcher.screenWidth, launcher.screenHeight);
        ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams).gravity = 1;
        setLayoutParams(insertAbleFrameLayoutParams);
        RecyclerView recyclerView = new RecyclerView(context, null);
        this.f16283o = recyclerView;
        int i6 = launcher.getDeviceProfile().f15977C;
        setPadding(i6, 0, i6, 0);
        InsertAbleFrameLayoutParams insertAbleFrameLayoutParams2 = new InsertAbleFrameLayoutParams(launcher.screenWidth - (i6 * 2), -2);
        ((FrameLayout.LayoutParams) insertAbleFrameLayoutParams2).gravity = 17;
        addView(recyclerView, insertAbleFrameLayoutParams2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        gridLayoutManager.f5379K = new C0832t(this, gridLayoutManager, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setOverScrollMode(2);
        C0911s c0911s = new C0911s(launcher);
        this.f16284p = c0911s;
        recyclerView.setAdapter(c0911s);
        c0911s.f2691q = this;
    }

    /* JADX INFO: renamed from: a */
    public final void m7934a() {
        int i6 = 1;
        if (getParent() instanceof LauncherRootView) {
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = LauncherAnimUtils.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("alpha", 0.0f), PropertyValuesHolder.ofFloat("scaleX", 0.3f), PropertyValuesHolder.ofFloat("scaleY", 0.3f));
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.33f, 0.89f, 0.55f, 1.0f));
            objectAnimatorOfPropertyValuesHolder.addListener(new AppsLibraryFolderExpandAnimListener(this, i6));
            objectAnimatorOfPropertyValuesHolder.setDuration(368L);
            setLayerType(2, null);
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        Objects.toString(keyEvent);
        if (keyEvent == null || keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        m7934a();
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView;
        Objects.toString(motionEvent);
        if (motionEvent.getAction() == 0 && (recyclerView = this.f16283o) != null) {
            Rect rect = new Rect();
            recyclerView.getGlobalVisibleRect(rect);
            if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                m7934a();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
