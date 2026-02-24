package e6;

import a6.c0;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class h1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ o1 f5141i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5142j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h1(o1 o1Var, int i10, e eVar) {
        super(2, eVar);
        this.f5141i = o1Var;
        this.f5142j = i10;
    }

    public final e create(Object obj, e eVar) {
        return new h1(this.f5141i, this.f5142j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return ((c0) this.f5141i.f5207a).a(this.f5142j);
    }
}
