package e6;

import a6.c0;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class i1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ o1 f5153i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5154j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i1(o1 o1Var, int i10, e eVar) {
        super(2, eVar);
        this.f5153i = o1Var;
        this.f5154j = i10;
    }

    public final e create(Object obj, e eVar) {
        return new i1(this.f5153i, this.f5154j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((i1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return ((c0) this.f5153i.f5207a).b(this.f5154j);
    }
}
