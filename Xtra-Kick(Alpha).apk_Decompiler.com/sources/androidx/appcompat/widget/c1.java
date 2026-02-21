package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import m.e;

public final class c1 implements PopupWindow.OnDismissListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f778h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d1 f779i;

    public c1(d1 d1Var, e eVar) {
        this.f779i = d1Var;
        this.f778h = eVar;
    }

    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f779i.O.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f778h);
        }
    }
}
