package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;
import m.a;

public final class c implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f772h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Object f773i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f774j;

    public c(ActionBarContextView actionBarContextView, l.c cVar) {
        this.f774j = actionBarContextView;
        this.f773i = cVar;
    }

    public final void onClick(View view) {
        int i10 = this.f772h;
        Object obj = this.f773i;
        switch (i10) {
            case 0:
                ((l.c) obj).a();
                return;
            default:
                d5 d5Var = (d5) this.f774j;
                Window.Callback callback = d5Var.f801k;
                if (callback != null && d5Var.f802l) {
                    callback.onMenuItemSelected(0, (a) obj);
                    return;
                }
                return;
        }
    }

    public c(d5 d5Var) {
        this.f774j = d5Var;
        this.f773i = new a(d5Var.f791a.getContext(), d5Var.f798h);
    }
}
