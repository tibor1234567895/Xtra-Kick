package e6;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import retrofit2.Response;
import wa.p;

public final class v1 extends i implements p {
    public v1(e eVar) {
        super(2, eVar);
    }

    public final e create(Object obj, e eVar) {
        return new v1(eVar);
    }

    public final Object g(Object obj, Object obj2) {
        f0 f0Var = (f0) obj;
        return new v1((e) obj2).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return Response.success(null);
    }
}
