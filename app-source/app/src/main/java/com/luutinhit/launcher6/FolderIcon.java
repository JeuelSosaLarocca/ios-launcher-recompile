package com.luutinhit.launcher6;

import B3.C0076s;
import C0.C0119k;
import C2.C0148h;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.luutinhit.launcher6.util.CustomIconView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import p118q3.C2615e;
import p118q3.InterfaceC2614d;
import p118q3.SharedPreferencesOnSharedPreferenceChangeListenerC2611a;

/* JADX INFO: loaded from: classes.dex */
public class FolderIcon extends FrameLayout implements FolderListener, SharedPreferences.OnSharedPreferenceChangeListener, InterfaceC2614d {

    /* JADX INFO: renamed from: G */
    public static boolean f15638G = true;

    /* JADX INFO: renamed from: H */
    public static int f15639H;

    /* JADX INFO: renamed from: I */
    public static int f15640I;

    /* JADX INFO: renamed from: J */
    public static int f15641J;

    /* JADX INFO: renamed from: K */
    public static int f15642K;

    /* JADX INFO: renamed from: A */
    public PreviewItemDrawingParams f15643A;

    /* JADX INFO: renamed from: B */
    public PreviewItemDrawingParams f15644B;

    /* JADX INFO: renamed from: C */
    public ArrayList f15645C;

    /* JADX INFO: renamed from: D */
    public Alarm mOpenAlarm;

    /* JADX INFO: renamed from: E */
    public ItemInfo f15647E;

    /* JADX INFO: renamed from: F */
    public MergedItemCallbacks f15648F;

    /* JADX INFO: renamed from: j */
    public Launcher f15649j;

    /* JADX INFO: renamed from: k */
    public Folder mFolder;

    /* JADX INFO: renamed from: l */
    public FolderInfo mInfo;

    /* JADX INFO: renamed from: m */
    public C0148h f15652m;

    /* JADX INFO: renamed from: n */
    public StylusEventHelper f15653n;

    /* JADX INFO: renamed from: o */
    public LiquidGlassSurfaceView f15654o;

    /* JADX INFO: renamed from: p */
    public RuntimeShaderGlassView f15655p;

    /* JADX INFO: renamed from: q */
    public boolean f15656q;

    /* JADX INFO: renamed from: r */
    public BubbleTextView f15657r;

    /* JADX INFO: renamed from: s */
    public FolderRingAnimator mFolderRingAnimator;

    /* JADX INFO: renamed from: t */
    public int f15659t;

    /* JADX INFO: renamed from: u */
    public int f15660u;

    /* JADX INFO: renamed from: v */
    public int f15661v;

    /* JADX INFO: renamed from: w */
    public boolean f15662w;

    /* JADX INFO: renamed from: x */
    public Rect f15663x;

    /* JADX INFO: renamed from: y */
    public float f15664y;

    /* JADX INFO: renamed from: z */
    public boolean f15665z;

    public FolderIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15656q = false;
        this.mFolderRingAnimator = null;
        this.f15662w = false;
        this.f15663x = new Rect();
        this.f15665z = false;
        this.f15643A = new PreviewItemDrawingParams(0.0f, 0.0f, 0.0f);
        this.f15644B = new PreviewItemDrawingParams(0.0f, 0.0f, 0.0f);
        this.f15645C = new ArrayList();
        this.mOpenAlarm = new Alarm();
        this.f15648F = new MergedItemCallbacks(2, this);
        this.f15652m = new C0148h(this);
        this.f15653n = new StylusEventHelper(this);
        setAccessibilityDelegate(LauncherAppState.getInstance().f16223f);
        if (context instanceof Launcher) {
            Launcher launcher = (Launcher) context;
            if (launcher.getBlurWallpaperProvider() != null) {
                launcher.getBlurWallpaperProvider().m9546b(this);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static PreviewItemDrawingParams computePreviewItemDrawingParams(int i6, PreviewItemDrawingParams previewItemDrawingParams) {
        Objects.toString(previewItemDrawingParams);
        float f6 = FolderRingAnimator.f15319l / 3.0f;
        float f7 = f6 / FolderRingAnimator.f15317j;
        float f8 = f15639H;
        float f9 = i6 % 3;
        float f10 = (f9 * f8) + (f6 * f9) + f8;
        float f11 = i6 / 3;
        float f12 = (f8 * f11) + (f6 * f11) + f8;
        if (previewItemDrawingParams == null) {
            return new PreviewItemDrawingParams(f10, f12, f7);
        }
        previewItemDrawingParams.f15433a = f10;
        previewItemDrawingParams.f15434b = f12;
        previewItemDrawingParams.f15435c = f7;
        return previewItemDrawingParams;
    }

    /* JADX INFO: renamed from: g */
    public static FolderIcon m7716g(Launcher launcher, CellLayout cellLayout, FolderInfo folderInfo, IconCache iconCache) {
        Objects.toString(launcher);
        Objects.toString(cellLayout);
        Objects.toString(folderInfo);
        Objects.toString(iconCache);
        f15641J = cellLayout.getCellWidth();
        f15642K = cellLayout.getCellHeight();
        int i6 = launcher.getDeviceProfile().f15978D;
        f15640I = i6;
        f15639H = i6 / 15;
        FolderIcon folderIcon = (FolderIcon) LayoutInflater.from(launcher).inflate(R.layout.folder_icon, (ViewGroup) cellLayout, false);
        folderIcon.f15649j = launcher;
        BubbleTextView bubbleTextView = (BubbleTextView) folderIcon.findViewById(R.id.folder_icon_name);
        folderIcon.f15657r = bubbleTextView;
        bubbleTextView.setText(folderInfo.title);
        folderIcon.f15657r.setTextColor(launcher.mIconTextColor);
        folderIcon.f15657r.getName().measure(0, 0);
        Launcher launcher2 = folderIcon.f15649j;
        int i7 = 2;
        if (!launcher2.isUseLiquidGlass) {
            CustomIconView iconView = folderIcon.f15657r.getIconView();
            iconView.getClass();
            try {
                Launcher launcher3 = (Launcher) iconView.f16917m;
                iconView.f16928x = launcher3.getDeviceProfile().getCurrentWidth();
                iconView.f16929y = launcher3.getDeviceProfile().getCurrentHeight();
                C2615e blurWallpaperProvider = launcher3.getBlurWallpaperProvider();
                float dimensionPixelSize = launcher3.getResources().getDimensionPixelSize(R.dimen.icon_round_corner);
                blurWallpaperProvider.getClass();
                SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = new SharedPreferencesOnSharedPreferenceChangeListenerC2611a(blurWallpaperProvider, dimensionPixelSize, 2);
                iconView.f16921q = sharedPreferencesOnSharedPreferenceChangeListenerC2611a;
                iconView.setBackground(sharedPreferencesOnSharedPreferenceChangeListenerC2611a);
            } catch (Throwable unused) {
                iconView.setBackgroundResource(R.drawable.icon_folder_background);
            }
        } else if (launcher2.isRuntimeRenderSupport) {
            folderIcon.setLayerType(2, null);
            RuntimeShaderGlassView runtimeShaderGlassView = new RuntimeShaderGlassView(launcher, false);
            folderIcon.f15655p = runtimeShaderGlassView;
            runtimeShaderGlassView.setLayerType(2, null);
            folderIcon.f15655p.setFullBitmap(launcher.getBlurGlassWallpaper());
            folderIcon.f15655p.setSdfTexture(R.drawable.draff);
            folderIcon.addView(folderIcon.f15655p, 0);
        } else {
            LiquidGlassSurfaceView liquidGlassSurfaceView = new LiquidGlassSurfaceView(launcher, 0.25f);
            folderIcon.f15654o = liquidGlassSurfaceView;
            liquidGlassSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 81));
            LiquidGlassSurfaceView liquidGlassSurfaceView2 = folderIcon.f15654o;
            int i8 = launcher.screenWidth;
            int i9 = launcher.screenHeight;
            liquidGlassSurfaceView2.f15805l = i8;
            liquidGlassSurfaceView2.f15806m = i9;
            liquidGlassSurfaceView2.f15815v = false;
            folderIcon.f15654o.setSdfTexture(R.drawable.draff);
            folderIcon.f15654o.setFullBitmap(folderIcon.getBlurGlassWallpaper());
            folderIcon.addView(folderIcon.f15654o, 0);
        }
        folderIcon.setTag(folderInfo);
        folderIcon.setOnClickListener(launcher);
        folderIcon.mInfo = folderInfo;
        folderIcon.setContentDescription(String.format(launcher.getString(R.string.folder_name_format), folderInfo.title));
        Rect rect = Folder.f23327h0;
        Folder folder = (Folder) launcher.getLayoutInflater().inflate(R.layout.user_folder, (ViewGroup) null);
        folder.setDragController(launcher.getDragController());
        folder.setFolderIcon(folderIcon);
        folder.mInfo = folderInfo;
        ArrayList arrayList = folderInfo.contents;
        Collections.sort(arrayList, Folder.f23330k0);
        FolderPagedView folderPagedView = folder.mContent;
        folderPagedView.getClass();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            arrayList2.add(folderPagedView.y0((ShortcutInfo) obj));
        }
        folderPagedView.w0(arrayList2.size(), arrayList2, false);
        int size2 = arrayList3.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList3.get(i11);
            i11++;
            ShortcutInfo shortcutInfo = (ShortcutInfo) obj2;
            folder.mInfo.remove(shortcutInfo);
            LauncherModel.deleteItemFromDatabase(folder.f15628q, shortcutInfo);
        }
        folder.f15605H = true;
        folder.updateTextViewFocus();
        folder.mInfo.f15524C.add(folder);
        if (Folder.sDefaultFolderName.contentEquals(folder.mInfo.title)) {
            folder.mFolderName.setText("");
        } else {
            folder.mFolderName.setText(folder.mInfo.title);
        }
        folder.mFolderName.measure(0, 0);
        if (((DragLayerLayoutParams) folder.getLayoutParams()) == null) {
            DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(0, 0);
            dragLayerLayoutParams.f16210d = true;
            folder.setLayoutParams(dragLayerLayoutParams);
        }
        folder.centerAboutIcon();
        folder.mFolderIcon.post(new FolderReplaceWithItemRunnable(folder, i7));
        if (folderIcon.f15649j.isUseLiquidGlass) {
            folder.setFolderBackgroundBitmap(folderIcon.getBlurGlassWallpaper());
        } else {
            folder.setFolderBackgroundResource(launcher.isDarkMode ? R.drawable.folder_background_dark : R.drawable.folder_background);
        }
        folderIcon.mFolder = folder;
        folderIcon.mFolderRingAnimator = new FolderRingAnimator(launcher, folderIcon);
        folderInfo.f15524C.add(folderIcon);
        folderIcon.setOnFocusChangeListener(launcher.mFocusHandler);
        return folderIcon;
    }

    /* JADX INFO: renamed from: i */
    public static Drawable m7717i(BubbleTextView bubbleTextView) {
        Objects.toString(bubbleTextView);
        Drawable icon = bubbleTextView.getIcon();
        return icon instanceof PreloadIconDrawable ? ((PreloadIconDrawable) icon).f16229d : icon;
    }

    public void setGlassViewVisibleFromGLSurface(boolean z5) {
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15654o;
        if (liquidGlassSurfaceView != null) {
            liquidGlassSurfaceView.setVisible(z5);
        }
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: A */
    public final void mo7658A(ShortcutInfo shortcutInfo) {
        Objects.toString(shortcutInfo);
        invalidate();
        requestLayout();
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: a */
    public final void mo7593a() {
        post(new MergedIdleRunnable(2, this));
    }

    /* JADX INFO: renamed from: b */
    public final void m7718b(Drawable drawable, int i6, boolean z5, FolderReplaceWithItemRunnable folderReplaceWithItemRunnable) {
        Objects.toString(drawable);
        Objects.toString(folderReplaceWithItemRunnable);
        PreviewItemDrawingParams previewItemDrawingParamsComputePreviewItemDrawingParams = computePreviewItemDrawingParams(0, null);
        float f6 = f15639H;
        float f7 = (FolderRingAnimator.f15319l / 3.0f) / FolderRingAnimator.f15317j;
        float f8 = f6 + 100.0f;
        this.f15657r.getIconView().getLeft();
        this.f15657r.getIconView().getTop();
        this.f15644B.f15436d = drawable;
        ValueAnimator valueAnimatorM7889c = LauncherAnimUtils.m7889c(0.0f, 1.0f);
        valueAnimatorM7889c.addUpdateListener(new FolderIconPreviewAnimUpdateListener(this, z5, f8, previewItemDrawingParamsComputePreviewItemDrawingParams, f8, f7));
        valueAnimatorM7889c.addListener(new C0119k(4, this, folderReplaceWithItemRunnable));
        valueAnimatorM7889c.setDuration(i6);
        valueAnimatorM7889c.start();
    }

    /* JADX INFO: renamed from: c */
    public final void m7719c(int i6) {
        this.f15659t = f15640I;
        RectF rectF = FolderRingAnimator.f15315h;
        this.f15657r.getIconView().getLeft();
        getWidth();
        getHeight();
        int x6 = (int) this.f15657r.getIconView().getX();
        int y4 = (int) this.f15657r.getIconView().getY();
        if (x6 != 0 || y4 != 0) {
            this.f15660u = (int) (this.f15657r.getIconView().getX() + FolderRingAnimator.f15318k);
            this.f15661v = (int) (this.f15657r.getIconView().getY() + FolderRingAnimator.f15318k);
            this.f15657r.getIconView().getX();
            this.f15657r.getIconView().getY();
            return;
        }
        int i7 = f15641J;
        if (i7 == 0 && f15642K == 0) {
            this.f15660u = ((getWidth() - f15640I) / 2) + FolderRingAnimator.f15318k;
            this.f15661v = ((getHeight() - f15640I) - this.f15657r.getName().getMeasuredHeight()) + FolderRingAnimator.f15318k;
        } else {
            this.f15660u = ((i7 - f15640I) / 2) + FolderRingAnimator.f15318k;
            this.f15661v = ((f15642K - f15640I) - this.f15657r.getName().getMeasuredHeight()) + FolderRingAnimator.f15318k;
        }
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        this.f15652m.m362b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
            Folder folder = this.mFolder;
            if (folder == null) {
                return;
            }
            if (folder.getItemCount() != 0 || this.f15662w) {
                ArrayList<View> itemsInReadingOrder = this.mFolder.getItemsInReadingOrder();
                boolean z5 = this.f15662w;
                PreviewItemDrawingParams previewItemDrawingParams = this.f15644B;
                if (z5) {
                    Drawable drawable = previewItemDrawingParams.f15436d;
                    Objects.toString(drawable);
                    drawable.getIntrinsicWidth();
                    m7719c(getMeasuredWidth());
                } else {
                    Drawable drawableM7717i = m7717i((BubbleTextView) itemsInReadingOrder.get(0));
                    Objects.toString(drawableM7717i);
                    drawableM7717i.getIntrinsicWidth();
                    m7719c(getMeasuredWidth());
                }
                int iMin = Math.min(itemsInReadingOrder.size(), 9);
                if (this.f15662w) {
                    drawPreviewItem(canvas, previewItemDrawingParams);
                    return;
                }
                for (int i6 = iMin - 1; i6 >= 0; i6--) {
                    BubbleTextView bubbleTextView = (BubbleTextView) itemsInReadingOrder.get(i6);
                    if (!this.f15645C.contains(bubbleTextView.getTag())) {
                        Drawable drawableM7717i2 = m7717i(bubbleTextView);
                        PreviewItemDrawingParams previewItemDrawingParamsComputePreviewItemDrawingParams = computePreviewItemDrawingParams(i6, this.f15643A);
                        this.f15643A = previewItemDrawingParamsComputePreviewItemDrawingParams;
                        previewItemDrawingParamsComputePreviewItemDrawingParams.f15436d = drawableM7717i2;
                        drawPreviewItem(canvas, previewItemDrawingParamsComputePreviewItemDrawingParams);
                    }
                }
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void drawPreviewItem(Canvas canvas, PreviewItemDrawingParams previewItemDrawingParams) {
        Objects.toString(canvas);
        Objects.toString(previewItemDrawingParams);
        canvas.save();
        canvas.translate(previewItemDrawingParams.f15433a + this.f15660u, previewItemDrawingParams.f15434b + this.f15661v);
        float f6 = previewItemDrawingParams.f15435c;
        canvas.scale(f6, f6);
        Drawable drawable = previewItemDrawingParams.f15436d;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            Rect rect = this.f15663x;
            rect.set(bounds);
            int i6 = this.f15659t;
            drawable.setBounds(0, 0, i6, i6);
            if (drawable instanceof FastBitmapDrawable) {
                FastBitmapDrawable fastBitmapDrawable = (FastBitmapDrawable) drawable;
                float f7 = fastBitmapDrawable.f15579e / 48.0f;
                fastBitmapDrawable.setBrightness(0.0f);
                drawable.draw(canvas);
                fastBitmapDrawable.setBrightness(f7);
            } else {
                drawable.setColorFilter(Color.argb((int) 0.0f, 255, 255, 255), PorterDuff.Mode.SRC_ATOP);
                drawable.draw(canvas);
                drawable.clearColorFilter();
            }
            drawable.setBounds(rect);
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: f */
    public final void m7721f() {
        if (this.f15654o != null) {
            setGlassViewVisibleFromGLSurface(false);
        } else {
            RuntimeShaderGlassView runtimeShaderGlassView = this.f15655p;
            if (runtimeShaderGlassView != null) {
                runtimeShaderGlassView.setVisibility(4);
            }
        }
        getIconView().setBackground(new C0076s());
    }

    public Bitmap getBlurGlassWallpaper() {
        C2615e blurWallpaperProvider = this.f15649j.getBlurWallpaperProvider();
        Bitmap bitmap = blurWallpaperProvider.f20556f;
        if (bitmap == null) {
            bitmap = blurWallpaperProvider.f20555e;
        }
        if (bitmap == null) {
            return this.f15649j.getBlurWallpaperProvider().f20557g;
        }
        bitmap.toString();
        return bitmap;
    }

    public Folder getFolder() {
        return this.mFolder;
    }

    public FolderInfo getFolderInfo() {
        return this.mInfo;
    }

    public View getFolderName() {
        return this.f15657r;
    }

    public View getIconView() {
        BubbleTextView bubbleTextView = this.f15657r;
        if (bubbleTextView != null) {
            return bubbleTextView.getIconView();
        }
        return null;
    }

    public boolean getTextVisible() {
        return this.f15657r.getVisibility() == 0;
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: h */
    public final void mo7659h(String str) {
        this.f15657r.setText(str);
        setContentDescription(String.format(getContext().getString(R.string.folder_name_format), str));
    }

    /* JADX INFO: renamed from: j */
    public final void onDrop(DragObject dragObject) {
        Objects.toString(dragObject);
        Object obj = dragObject.f16523g;
        ShortcutInfo shortcutInfoMakeShortcut = obj instanceof AppInfo ? ((AppInfo) obj).makeShortcut() : (ShortcutInfo) obj;
        Folder folder = this.mFolder;
        if (folder.f15610M) {
            folder.f15613P = true;
        }
        onDrop(shortcutInfoMakeShortcut, dragObject.f16522f, null, 1.0f, this.mInfo.contents.size(), dragObject.f16526j, dragObject);
    }

    /* JADX INFO: renamed from: k */
    public final void onDrop(ShortcutInfo shortcutInfo, DragView dragView, Rect rect, float f6, int i6, WorkspaceDropRunnable workspaceDropRunnable, DragObject dragObject) {
        Rect rect2;
        float descendantRectRelativeToSelf;
        Objects.toString(shortcutInfo);
        Objects.toString(dragView);
        Objects.toString(rect);
        Objects.toString(workspaceDropRunnable);
        Objects.toString(dragObject);
        shortcutInfo.cellX = -1;
        shortcutInfo.cellY = -1;
        if (dragView == null) {
            Objects.toString(shortcutInfo);
            this.mInfo.add(shortcutInfo);
            return;
        }
        DragLayer dragLayer = this.f15649j.getDragLayer();
        Rect rect3 = new Rect();
        dragLayer.getViewRectRelativeToSelf(dragView, rect3);
        if (rect == null) {
            rect2 = new Rect();
            this.f15649j.getWorkspace().setFinalTransitionTransform((CellLayout) getParent().getParent());
            float scaleX = getScaleX();
            float scaleY = getScaleY();
            setScaleX(1.0f);
            setScaleY(1.0f);
            descendantRectRelativeToSelf = dragLayer.getDescendantRectRelativeToSelf(this, rect2);
            setScaleX(scaleX);
            setScaleY(scaleY);
            Objects.toString((CellLayout) getParent().getParent());
        } else {
            rect2 = rect;
            descendantRectRelativeToSelf = f6;
        }
        PreviewItemDrawingParams previewItemDrawingParamsComputePreviewItemDrawingParams = computePreviewItemDrawingParams(Math.min(9, i6), this.f15643A);
        this.f15643A = previewItemDrawingParamsComputePreviewItemDrawingParams;
        float f7 = previewItemDrawingParamsComputePreviewItemDrawingParams.f15433a + this.f15660u;
        previewItemDrawingParamsComputePreviewItemDrawingParams.f15433a = f7;
        float f8 = previewItemDrawingParamsComputePreviewItemDrawingParams.f15434b + this.f15661v;
        previewItemDrawingParamsComputePreviewItemDrawingParams.f15434b = f8;
        float f9 = (previewItemDrawingParamsComputePreviewItemDrawingParams.f15435c * this.f15659t) / 2.0f;
        int[] iArr = {Math.round(f7 + f9), Math.round(f9 + f8)};
        float f10 = this.f15643A.f15435c;
        iArr[0] = Math.round(iArr[0] * descendantRectRelativeToSelf);
        iArr[1] = Math.round(iArr[1] * descendantRectRelativeToSelf);
        rect2.offset(iArr[0] - (dragView.getMeasuredWidth() / 2), iArr[1] - (dragView.getMeasuredHeight() / 2));
        float f11 = descendantRectRelativeToSelf * f10;
        dragLayer.animateView(dragView, rect3, rect2, i6 < 9 ? 0.5f : 0.0f, 1.0f, 1.0f, f11, f11, 400, new DecelerateInterpolator(2.0f), new AccelerateInterpolator(2.0f), workspaceDropRunnable, 0, null);
        Objects.toString(shortcutInfo);
        this.mInfo.add(shortcutInfo);
        this.f15645C.add(shortcutInfo);
        this.mFolder.m7700O(shortcutInfo).setVisibility(4);
        postDelayed(new MergedModelRunnable(4, this, shortcutInfo), 400L);
    }

    /* JADX INFO: renamed from: l */
    public final void m7724l() {
        RuntimeShaderGlassView runtimeShaderGlassView;
        BubbleTextView bubbleTextView;
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15654o;
        if (liquidGlassSurfaceView != null || this.f15655p != null) {
            boolean z5 = this.f15665z;
            if (z5 && liquidGlassSurfaceView != null) {
                liquidGlassSurfaceView.updatePositionAndRender();
                return;
            } else {
                if (!z5 || (runtimeShaderGlassView = this.f15655p) == null) {
                    return;
                }
                runtimeShaderGlassView.updateGlViewPosition();
                return;
            }
        }
        if (!this.f15665z || (bubbleTextView = this.f15657r) == null) {
            return;
        }
        CustomIconView iconView = bubbleTextView.getIconView();
        if (iconView.f16921q != null) {
            int[] iArr = iconView.f16923s;
            iconView.getLocationInWindow(iArr);
            int i6 = iArr[0];
            int i7 = iArr[1];
            if (i6 < 0 || i6 > iconView.f16928x || i7 < 0 || i7 > iconView.f16929y) {
                return;
            }
            if (i6 != iconView.f16924t) {
                iconView.f16924t = i6;
                iconView.f16921q.m9543c(i6);
            }
            int i8 = iArr[1];
            if (i8 != iconView.f16925u) {
                iconView.f16925u = i8;
                SharedPreferencesOnSharedPreferenceChangeListenerC2611a sharedPreferencesOnSharedPreferenceChangeListenerC2611a = iconView.f16921q;
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.f20537q = i8;
                sharedPreferencesOnSharedPreferenceChangeListenerC2611a.invalidateSelf();
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public final boolean m7725m(ItemInfo itemInfo) {
        Objects.toString(itemInfo);
        int i6 = itemInfo.itemType;
        if (i6 != 0 && i6 != 1) {
            return false;
        }
        this.mFolder.mContent.getClass();
        FolderInfo folderInfo = this.mInfo;
        return (itemInfo == folderInfo || folderInfo.f15523B) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f15664y = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f15649j.getTinyDB().m140j(this);
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15654o;
        if (liquidGlassSurfaceView != null) {
            liquidGlassSurfaceView.updatePositionAndRender();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f15649j.getTinyDB().f137a.unregisterOnSharedPreferenceChangeListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (z5) {
            LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15654o;
            if (liquidGlassSurfaceView != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) liquidGlassSurfaceView.getLayoutParams();
                int i10 = f15640I;
                layoutParams.width = i10;
                layoutParams.height = i10;
                boolean z6 = this.f15656q;
                layoutParams.bottomMargin = z6 ? this.f15649j.mDeviceProfile.f15980F : 0;
                layoutParams.gravity = z6 ? 81 : 17;
                this.f15654o.setLayoutParams(layoutParams);
                this.f15654o.updatePositionAndRender();
            }
            RuntimeShaderGlassView runtimeShaderGlassView = this.f15655p;
            if (runtimeShaderGlassView == null) {
                m7724l();
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) runtimeShaderGlassView.getLayoutParams();
            int i11 = f15640I;
            layoutParams2.width = i11;
            layoutParams2.height = i11;
            boolean z7 = this.f15656q;
            layoutParams2.bottomMargin = z7 ? this.f15649j.mDeviceProfile.f15980F : 0;
            layoutParams2.gravity = z7 ? 81 : 17;
            this.f15655p.setLayoutParams(layoutParams2);
            this.f15655p.updateGlViewPosition();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        f15638G = true;
        return super.onSaveInstanceState();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null || str == null || !str.equals("dark_mode")) {
            return;
        }
        boolean z5 = sharedPreferences.getBoolean(str, false);
        this.mFolder.setFolderBackgroundResource(z5 ? R.drawable.folder_background_dark : R.drawable.folder_background);
        FolderRingAnimator.f15316i.setColor(z5 ? 1493172224 : -2132877602);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r1 != 3) goto L17;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.f15653n.checkAndPerformStylusEvent(motionEvent)) {
            this.f15652m.m362b();
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f15652m.m364d();
            return zOnTouchEvent;
        }
        if (action != 1) {
            if (action == 2) {
                if (!Utilities.pointInView(this, motionEvent.getX(), motionEvent.getY(), this.f15664y)) {
                    this.f15652m.m362b();
                }
            }
            return zOnTouchEvent;
        }
        this.f15657r.onTouchEvent(motionEvent);
        this.f15657r.m7598G();
        this.f15652m.m362b();
        return zOnTouchEvent;
    }

    public void setGlassViewVisible(boolean z5) {
        if (!isAttachedToWindow()) {
            post(new FolderIconGlassRunnable(this, z5, 1));
            return;
        }
        LiquidGlassSurfaceView liquidGlassSurfaceView = this.f15654o;
        if (liquidGlassSurfaceView != null) {
            liquidGlassSurfaceView.setVisibility(z5 ? 0 : 4);
        }
    }

    public void setTextColor(int i6) {
        this.f15657r.setTextColor(i6);
    }

    public void setTextVisible(boolean z5) {
        this.f15656q = z5;
        this.f15657r.setTextVisibility(z5);
    }

    public void setUseTransparency(boolean z5) {
    }

    @Override // android.view.View
    public void setVisibility(int i6) {
        super.setVisibility(i6);
    }

    public void setVisibilityGlassBackground(boolean z5) {
        if (this.f15654o != null) {
            if (z5) {
                getIconView().setBackground(null);
                setGlassViewVisibleFromGLSurface(true);
                return;
            } else {
                getIconView().setBackgroundResource(R.drawable.icon_folder_background);
                setGlassViewVisibleFromGLSurface(false);
                return;
            }
        }
        if (this.f15655p != null) {
            if (z5) {
                getIconView().setBackground(null);
                this.f15655p.setVisibility(0);
            } else {
                getIconView().setBackgroundResource(R.drawable.icon_folder_background);
                this.f15655p.setVisibility(4);
            }
        }
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: v */
    public final void mo7660v() {
        invalidate();
        requestLayout();
    }

    @Override // com.luutinhit.launcher6.FolderListener
    /* JADX INFO: renamed from: y */
    public final void mo7661y(ShortcutInfo shortcutInfo) {
        Objects.toString(shortcutInfo);
        invalidate();
        requestLayout();
    }

    @Override // p118q3.InterfaceC2614d
    /* JADX INFO: renamed from: q */
    public final void mo7594q() {
    }
}
