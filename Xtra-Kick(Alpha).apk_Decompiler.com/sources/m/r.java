package m;

import android.view.ActionProvider;
import android.view.View;
import m0.d;

public abstract class r extends d {

    /* renamed from: c  reason: collision with root package name */
    public final ActionProvider f10025c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ w f10026d;

    public r(w wVar, ActionProvider actionProvider) {
        this.f10026d = wVar;
        this.f10025c = actionProvider;
    }

    public final boolean a() {
        return this.f10025c.hasSubMenu();
    }

    public final View c() {
        return this.f10025c.onCreateActionView();
    }

    public final boolean e() {
        return this.f10025c.onPerformDefaultAction();
    }

    public final void f(i0 i0Var) {
        this.f10026d.getClass();
        this.f10025c.onPrepareSubMenu(i0Var);
    }
}
