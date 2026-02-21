package n3;

import hb.h0;
import la.v;
import ma.e0;
import pa.e;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f11261i;

    public j(e eVar) {
        super(2, eVar);
    }

    public final e create(Object obj, e eVar) {
        j jVar = new j(eVar);
        jVar.f11261i = obj;
        return jVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((e0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z10;
        h0.O1(obj);
        if (((e0) this.f11261i) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
