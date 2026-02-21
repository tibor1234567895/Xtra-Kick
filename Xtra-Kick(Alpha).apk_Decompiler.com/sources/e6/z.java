package e6;

import a6.f;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class z extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f5278i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f5279j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(e0 e0Var, String str, e eVar) {
        super(2, eVar);
        this.f5278i = e0Var;
        this.f5279j = str;
    }

    public final e create(Object obj, e eVar) {
        return new z(this.f5278i, this.f5279j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((z) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return ((f) this.f5278i.f5105a).b(this.f5279j);
    }
}
