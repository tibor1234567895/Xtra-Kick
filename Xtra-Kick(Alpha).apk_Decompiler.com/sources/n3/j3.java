package n3;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class j3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l3 f11266i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j3(l3 l3Var, e eVar) {
        super(2, eVar);
        this.f11266i = l3Var;
    }

    public final e create(Object obj, e eVar) {
        return new j3(this.f11266i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j3) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        l3 l3Var = this.f11266i;
        l3Var.f11317j.h(new Integer(l3Var.f11315h));
        return v.f9814a;
    }
}
