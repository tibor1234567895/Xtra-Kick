package n3;

import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class a3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g3 f11044i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a3(g3 g3Var, e eVar) {
        super(2, eVar);
        this.f11044i = g3Var;
    }

    public final e create(Object obj, e eVar) {
        return new a3(this.f11044i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a3) create((a6) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        this.f11044i.f11201h.b();
        return v.f9814a;
    }
}
