package com.luutinhit.launcher6;

import android.widget.FrameLayout;
import com.luutinhit.launcher6.util.DeleteCircleView;

/* JADX INFO: renamed from: com.luutinhit.launcher6.e2 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetDeleteButtonRunnable implements Runnable {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f16372j;

    /* JADX INFO: renamed from: k */
    public /* synthetic */ LauncherAppWidgetHostView f16373k;

    public /* synthetic */ WidgetDeleteButtonRunnable(LauncherAppWidgetHostView launcherAppWidgetHostView, int i6) {
        this.f16372j = i6;
        this.f16373k = launcherAppWidgetHostView;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16372j) {
            case 0:
                LauncherAppWidgetHostView launcherAppWidgetHostView = this.f16373k;
                Launcher launcher = launcherAppWidgetHostView.f16539m;
                int i6 = -launcher.mDeviceProfile.f15975A;
                int i7 = launcher.mDeviceProfile.f16026z;
                DragLayerLayoutParams dragLayerLayoutParams = new DragLayerLayoutParams(i7, i7);
                ((FrameLayout.LayoutParams) dragLayerLayoutParams).gravity = 8388659;
                float f6 = launcher.isRTL ? -i6 : i6;
                DeleteCircleView deleteCircleView = launcherAppWidgetHostView.f16543q;
                deleteCircleView.setTranslationX(f6);
                deleteCircleView.setTranslationY(i6);
                try {
                    launcherAppWidgetHostView.removeView(deleteCircleView);
                } catch (Throwable th) {
                    th.getMessage();
                }
                launcherAppWidgetHostView.addView(deleteCircleView, launcherAppWidgetHostView.getChildCount(), dragLayerLayoutParams);
                deleteCircleView.measure(0, 0);
                deleteCircleView.setOnClickListener(new WidgetClickListener(launcherAppWidgetHostView, 2));
                break;
            default:
                LauncherAppWidgetHostView launcherAppWidgetHostView2 = this.f16373k;
                DeleteCircleView deleteCircleView2 = launcherAppWidgetHostView2.f16543q;
                deleteCircleView2.m8196c(0, true);
                launcherAppWidgetHostView2.bringChildToFront(deleteCircleView2);
                break;
        }
    }
}
