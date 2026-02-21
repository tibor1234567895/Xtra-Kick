package hb;

import pa.e;

public final class q1 extends l {

    /* renamed from: p  reason: collision with root package name */
    public final u1 f7837p;

    public q1(e eVar, t tVar) {
        super(1, eVar);
        this.f7837p = tVar;
    }

    public final String B() {
        return "AwaitContinuation";
    }

    public final Throwable t(u1 u1Var) {
        Throwable b10;
        Object H = this.f7837p.H();
        return (!(H instanceof s1) || (b10 = ((s1) H).b()) == null) ? H instanceof w ? ((w) H).f7875a : u1Var.C() : b10;
    }
}
