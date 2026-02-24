package n3;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class e1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f1 f11124i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e1(f1 f1Var, e eVar) {
        super(2, eVar);
        this.f11124i = f1Var;
    }

    public final e create(Object obj, e eVar) {
        return new e1(this.f11124i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e1) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        this.f11124i.getClass();
        return v.f9814a;
    }
}
