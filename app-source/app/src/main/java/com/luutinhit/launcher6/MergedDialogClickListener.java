package com.luutinhit.launcher6;

import C2.C0144d;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.luutinhit.launcherios.R;
import java.util.ArrayList;
import p029g.C2054g;
import p029g.DialogC2057j;
import p035n.C2449G;
import p035n.C2454L;
import p035n.InterfaceC2453K;
import p101l3.C2339d;

/* JADX INFO: renamed from: com.luutinhit.launcher6.G1 */
/* JADX INFO: loaded from: classes.dex */
public final class MergedDialogClickListener implements DialogInterface.OnClickListener, InterfaceC2453K {


    /* JADX INFO: renamed from: j */
    public /* synthetic */ int f15679j;

    /* JADX INFO: renamed from: k */
    public Object f15680k;

    /* JADX INFO: renamed from: l */
    public Object f15681l;

    /* JADX INFO: renamed from: m */
    public Object f15682m;

    /* JADX INFO: renamed from: n */
    public /* synthetic */ Object f15683n;

    public /* synthetic */ MergedDialogClickListener(Object obj, Object obj2, Object obj3, LauncherAppWidgetInfo launcherAppWidgetInfo, int i6) {
        this.f15679j = i6;
        this.f15683n = obj;
        this.f15681l = obj2;
        this.f15682m = obj3;
        this.f15680k = launcherAppWidgetInfo;
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: a */
    public int mo7730a() {
        return 0;
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: b */
    public boolean mo7731b() {
        DialogC2057j dialogC2057j = (DialogC2057j) this.f15681l;
        if (dialogC2057j != null) {
            return dialogC2057j.isShowing();
        }
        return false;
    }

    @Override // p035n.InterfaceC2453K
    public void dismiss() {
        DialogC2057j dialogC2057j = (DialogC2057j) this.f15681l;
        if (dialogC2057j != null) {
            dialogC2057j.dismiss();
            this.f15681l = null;
        }
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: e */
    public Drawable mo7732e() {
        return null;
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: g */
    public void mo7733g(CharSequence charSequence) {
        this.f15680k = charSequence;
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: m */
    public void mo7738m(int i6, int i7) {
        if (((C2449G) this.f15682m) == null) {
            return;
        }
        C2454L c2454l = (C2454L) this.f15683n;
        C0144d c0144d = new C0144d(c2454l.getPopupContext());
        CharSequence charSequence = (CharSequence) this.f15680k;
        C2054g c2054g = (C2054g) c0144d.f419k;
        if (charSequence != null) {
            c2054g.f18325d = charSequence;
        }
        C2449G c2449g = (C2449G) this.f15682m;
        int selectedItemPosition = c2454l.getSelectedItemPosition();
        c2054g.f18339r = c2449g;
        c2054g.f18340s = this;
        c2054g.f18345x = selectedItemPosition;
        c2054g.f18344w = true;
        DialogC2057j dialogC2057jM351j = c0144d.m351j();
        this.f15681l = dialogC2057jM351j;
        AlertController$RecycleListView alertController$RecycleListView = dialogC2057jM351j.f18382l.f18359f;
        alertController$RecycleListView.setTextDirection(i6);
        alertController$RecycleListView.setTextAlignment(i7);
        ((DialogC2057j) this.f15681l).show();
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: n */
    public int mo7739n() {
        return 0;
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: o */
    public CharSequence mo7740o() {
        return (CharSequence) this.f15680k;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i6) {
        Object obj = this.f15683n;
        switch (this.f15679j) {
            case 0:
                ((Launcher) obj).startActivitySafely((PendingAppWidgetHostView) this.f15681l, LauncherModel.getMarketIntent((String) this.f15682m), (LauncherAppWidgetInfo) this.f15680k);
                break;
            case 1:
                int iIntValue = ((Integer) ((ArrayList) this.f15681l).get(i6)).intValue();
                C2339d c2339d = (C2339d) obj;
                View view = (View) this.f15682m;
                CellLayoutLayoutParams cellLayoutLayoutParams = (CellLayoutLayoutParams) view.getLayoutParams();
                CellLayout cellLayout = (CellLayout) view.getParent().getParent();
                cellLayout.markCellsAsUnoccupiedForView(view);
                LauncherAppWidgetInfo launcherAppWidgetInfo = (LauncherAppWidgetInfo) this.f15680k;
                if (iIntValue == R.string.action_increase_width) {
                    if ((view.getLayoutDirection() == 1 && cellLayout.isRegionVacant(launcherAppWidgetInfo.cellX - 1, launcherAppWidgetInfo.cellY, 1, launcherAppWidgetInfo.spanY)) || !cellLayout.isRegionVacant(launcherAppWidgetInfo.cellX + launcherAppWidgetInfo.spanX, launcherAppWidgetInfo.cellY, 1, launcherAppWidgetInfo.spanY)) {
                        cellLayoutLayoutParams.f15685a--;
                        launcherAppWidgetInfo.cellX--;
                    }
                    cellLayoutLayoutParams.f15690f++;
                    launcherAppWidgetInfo.spanX++;
                } else if (iIntValue == R.string.action_decrease_width) {
                    cellLayoutLayoutParams.f15690f--;
                    launcherAppWidgetInfo.spanX--;
                } else if (iIntValue == R.string.action_increase_height) {
                    if (!cellLayout.isRegionVacant(launcherAppWidgetInfo.cellX, launcherAppWidgetInfo.cellY + launcherAppWidgetInfo.spanY, launcherAppWidgetInfo.spanX, 1)) {
                        cellLayoutLayoutParams.f15686b--;
                        launcherAppWidgetInfo.cellY--;
                    }
                    cellLayoutLayoutParams.f15691g++;
                    launcherAppWidgetInfo.spanY++;
                } else if (iIntValue == R.string.action_decrease_height) {
                    cellLayoutLayoutParams.f15691g--;
                    launcherAppWidgetInfo.spanY--;
                }
                cellLayout.markCellsAsOccupiedForView(view);
                Rect rect = new Rect();
                int i7 = launcherAppWidgetInfo.spanX;
                int i8 = launcherAppWidgetInfo.spanY;
                Launcher launcher = c2339d.f19393k;
                AppWidgetResizeFrame.getWidgetSizeRanges(launcher, i7, i8, rect);
                ((LauncherAppWidgetHostView) view).updateAppWidgetSize(null, rect.left, rect.top, rect.right, rect.bottom);
                view.requestLayout();
                LauncherModel.updateItemInDatabase(launcher, launcherAppWidgetInfo);
                launcher.getDragLayer().announceForAccessibility(launcher.getString(R.string.widget_resized, Integer.valueOf(launcherAppWidgetInfo.spanX), Integer.valueOf(launcherAppWidgetInfo.spanY)));
                dialogInterface.dismiss();
                break;
            default:
                C2454L c2454l = (C2454L) obj;
                c2454l.setSelection(i6);
                if (c2454l.getOnItemClickListener() != null) {
                    c2454l.performItemClick(null, i6, ((C2449G) this.f15682m).getItemId(i6));
                }
                dismiss();
                break;
        }
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: p */
    public void mo7741p(ListAdapter listAdapter) {
        this.f15682m = (C2449G) listAdapter;
    }

    public MergedDialogClickListener(C2454L c2454l) {
        this.f15679j = 2;
        this.f15683n = c2454l;
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: h */
    public void mo7734h(Drawable drawable) {
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: j */
    public void mo7735j(int i6) {
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: k */
    public void mo7736k(int i6) {
    }

    @Override // p035n.InterfaceC2453K
    /* JADX INFO: renamed from: l */
    public void mo7737l(int i6) {
    }
}
