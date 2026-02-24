package kb;

import h3.u1;
import jb.a;
import lb.i;
import lb.q;
import pa.e;
import pa.k;

public final class m0 implements p0, i, q {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ p0 f9357h;

    public m0(s0 s0Var) {
        this.f9357h = s0Var;
    }

    public final Object b(j jVar, e eVar) {
        return this.f9357h.b(jVar, eVar);
    }

    public final i d(k kVar, int i10, a aVar) {
        u1 u1Var = t0.f9395a;
        if ((i10 == 0 || i10 == -3) && aVar == a.SUSPEND) {
            return this;
        }
        return new i(i10, kVar, aVar, this);
    }
}
