package m;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import g.m;

public final class p implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, b0 {

    /* renamed from: h  reason: collision with root package name */
    public final o f9996h;

    /* renamed from: i  reason: collision with root package name */
    public m f9997i;

    /* renamed from: j  reason: collision with root package name */
    public k f9998j;

    public p(o oVar) {
        this.f9996h = oVar;
    }

    public final void a(o oVar, boolean z10) {
        m mVar;
        if ((z10 || oVar == this.f9996h) && (mVar = this.f9997i) != null) {
            mVar.dismiss();
        }
    }

    public final boolean n(o oVar) {
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        k kVar = this.f9998j;
        if (kVar.f9964m == null) {
            kVar.f9964m = new j(kVar);
        }
        this.f9996h.q(kVar.f9964m.getItem(i10), (c0) null, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.f9998j.a(this.f9996h, true);
    }

    public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        o oVar = this.f9996h;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f9997i.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f9997i.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                oVar.c(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return oVar.performShortcut(i10, keyEvent, 0);
    }
}
