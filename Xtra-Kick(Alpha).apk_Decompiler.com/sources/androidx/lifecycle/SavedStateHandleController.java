package androidx.lifecycle;

import t3.e;
import xa.j;

public final class SavedStateHandleController implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final String f1642h;

    /* renamed from: i  reason: collision with root package name */
    public final j1 f1643i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1644j;

    public SavedStateHandleController(String str, j1 j1Var) {
        this.f1642h = str;
        this.f1643i = j1Var;
    }

    public final void c(t tVar, e eVar) {
        j.f("registry", eVar);
        j.f("lifecycle", tVar);
        if (!this.f1644j) {
            this.f1644j = true;
            tVar.a(this);
            eVar.c(this.f1642h, this.f1643i.f1717e);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public final void d(d0 d0Var, r rVar) {
        if (rVar == r.ON_DESTROY) {
            this.f1644j = false;
            d0Var.o().c(this);
        }
    }
}
