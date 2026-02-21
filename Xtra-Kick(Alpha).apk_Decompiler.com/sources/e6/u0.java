package e6;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class u0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ y0 f5248i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5249j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u0(y0 y0Var, int i10, e eVar) {
        super(2, eVar);
        this.f5248i = y0Var;
        this.f5249j = i10;
    }

    public final e create(Object obj, e eVar) {
        return new u0(this.f5248i, this.f5249j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((u0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return ((a6.i) this.f5248i.f5273a).a(this.f5249j);
    }
}
