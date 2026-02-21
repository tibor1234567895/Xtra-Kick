package n3;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class k3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l3 f11286i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k3(l3 l3Var, e eVar) {
        super(2, eVar);
        this.f11286i = l3Var;
    }

    public final e create(Object obj, e eVar) {
        return new k3(this.f11286i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((k3) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        l3 l3Var = this.f11286i;
        l3Var.f11316i.h(new Integer(l3Var.f11314g));
        return v.f9814a;
    }
}
