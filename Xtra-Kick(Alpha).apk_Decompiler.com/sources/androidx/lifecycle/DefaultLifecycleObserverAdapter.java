package androidx.lifecycle;

import xa.j;

public final class DefaultLifecycleObserverAdapter implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final h f1624h;

    /* renamed from: i  reason: collision with root package name */
    public final b0 f1625i;

    public DefaultLifecycleObserverAdapter(h hVar, b0 b0Var) {
        j.f("defaultLifecycleObserver", hVar);
        this.f1624h = hVar;
        this.f1625i = b0Var;
    }

    public final void d(d0 d0Var, r rVar) {
        int i10 = i.f1702a[rVar.ordinal()];
        h hVar = this.f1624h;
        switch (i10) {
            case 1:
                hVar.b(d0Var);
                break;
            case 2:
                hVar.onStart(d0Var);
                break;
            case 3:
                hVar.a(d0Var);
                break;
            case 4:
                hVar.f(d0Var);
                break;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                hVar.onStop(d0Var);
                break;
            case 6:
                hVar.onDestroy(d0Var);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        b0 b0Var = this.f1625i;
        if (b0Var != null) {
            b0Var.d(d0Var, rVar);
        }
    }
}
