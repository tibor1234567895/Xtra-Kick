package kb;

import h3.u1;
import jb.a;
import lb.i;
import lb.q;
import pa.e;
import pa.k;

public final class n0 implements c1, i, q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ c1 f9360h;

    public n0(e1 e1Var) {
        this.f9360h = e1Var;
    }

    public final Object b(j jVar, e eVar) {
        return this.f9360h.b(jVar, eVar);
    }

    public final i d(k kVar, int i10, a aVar) {
        boolean z10;
        u1 u1Var = f1.f9304a;
        if (i10 < 0 || i10 >= 2) {
            z10 = false;
        } else {
            z10 = true;
        }
        if ((!z10 && i10 != -2) || aVar != a.DROP_OLDEST) {
            u1 u1Var2 = t0.f9395a;
            if (!((i10 == 0 || i10 == -3) && aVar == a.SUSPEND)) {
                return new i(i10, kVar, aVar, this);
            }
        }
        return this;
    }

    public final Object getValue() {
        return this.f9360h.getValue();
    }
}
