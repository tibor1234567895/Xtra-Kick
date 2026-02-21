package kb;

import la.v;
import lb.t;
import pa.e;
import qa.a;
import wa.l;
import wa.p;
import xa.u;

public final class h implements i {

    /* renamed from: h  reason: collision with root package name */
    public final i f9316h;

    /* renamed from: i  reason: collision with root package name */
    public final l f9317i;

    /* renamed from: j  reason: collision with root package name */
    public final p f9318j;

    public h(i iVar) {
        p pVar = q.f9364a;
        o oVar = q.f9365b;
        this.f9316h = iVar;
        this.f9317i = pVar;
        this.f9318j = oVar;
    }

    public final Object b(j jVar, e eVar) {
        u uVar = new u();
        uVar.f16818h = t.f9862a;
        Object b10 = this.f9316h.b(new g(this, uVar, jVar), eVar);
        return b10 == a.COROUTINE_SUSPENDED ? b10 : v.f9814a;
    }
}
