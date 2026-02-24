package qa;

import pa.e;
import pa.k;
import pa.l;
import ra.a;
import ra.c;
import wa.p;
import xa.j;

public class d {
    public static final e a(Object obj, e eVar, p pVar) {
        j.f("<this>", pVar);
        j.f("completion", eVar);
        if (pVar instanceof a) {
            return ((a) pVar).create(obj, eVar);
        }
        k context = eVar.getContext();
        return context == l.f12754h ? new b(obj, eVar, pVar) : new c(eVar, context, pVar, obj);
    }

    public static final e b(e eVar) {
        e<Object> intercepted;
        j.f("<this>", eVar);
        c cVar = eVar instanceof c ? (c) eVar : null;
        return (cVar == null || (intercepted = cVar.intercepted()) == null) ? eVar : intercepted;
    }
}
