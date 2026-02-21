package e6;

import a6.f;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class a0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f5076i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5077j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(e0 e0Var, int i10, e eVar) {
        super(2, eVar);
        this.f5076i = e0Var;
        this.f5077j = i10;
    }

    public final e create(Object obj, e eVar) {
        return new a0(this.f5076i, this.f5077j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return ((f) this.f5076i.f5105a).a(this.f5077j);
    }
}
