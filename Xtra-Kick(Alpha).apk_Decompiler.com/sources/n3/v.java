package n3;

import hb.h0;
import kb.j;
import pa.e;
import ra.i;
import wa.p;

public final class v extends i implements p {
    public v(e eVar) {
        super(2, eVar);
    }

    public final e create(Object obj, e eVar) {
        return new v(eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((v) create((j) obj, (e) obj2)).invokeSuspend(la.v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return la.v.f9814a;
    }
}
