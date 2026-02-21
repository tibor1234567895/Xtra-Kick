package r3;

import a6.r;
import g.s0;
import hb.c1;
import hb.d0;
import hb.h0;
import java.util.Map;
import pa.e;
import q0.f;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final h f13681a = new h(0);

    private i() {
    }

    public static final Object a(n0 n0Var, r rVar, e eVar) {
        f13681a.getClass();
        if (n0Var.p() && n0Var.l()) {
            return rVar.call();
        }
        f.l(eVar.getContext().N(x0.f13772h));
        Map map = n0Var.f13729l;
        Object obj = map.get("TransactionDispatcher");
        if (obj == null) {
            s0 s0Var = n0Var.f13720c;
            if (s0Var != null) {
                obj = new c1(s0Var);
                map.put("TransactionDispatcher", obj);
            } else {
                j.l("internalTransactionExecutor");
                throw null;
            }
        }
        return h0.c2((d0) obj, new f(rVar, (e) null), eVar);
    }
}
