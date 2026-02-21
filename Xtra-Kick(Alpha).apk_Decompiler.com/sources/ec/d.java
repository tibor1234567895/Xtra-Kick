package ec;

import dc.f0;
import dc.n;
import fb.w;

public final class d {
    private d() {
    }

    public /* synthetic */ d(int i10) {
        this();
    }

    public static final boolean a(d dVar, f0 f0Var) {
        dVar.getClass();
        f0Var.getClass();
        n nVar = l.f5386a;
        n nVar2 = l.f5386a;
        n nVar3 = f0Var.f4763h;
        int k10 = n.k(nVar3, nVar2);
        if (k10 == -1) {
            k10 = n.k(nVar3, l.f5387b);
        }
        if (k10 != -1) {
            nVar3 = n.o(nVar3, k10 + 1, 0, 2);
        } else if (f0Var.f() != null && nVar3.d() == 2) {
            nVar3 = n.f4803l;
        }
        return !w.f(nVar3.q(), ".class", true);
    }
}
