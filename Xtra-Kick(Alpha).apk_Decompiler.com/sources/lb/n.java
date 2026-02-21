package lb;

import hb.h0;
import jb.a;
import kb.i;
import kb.j;
import la.v;
import pa.e;
import pa.k;
import wa.q;

public final class n extends h {

    /* renamed from: l  reason: collision with root package name */
    public final q f9856l;

    public n(q qVar, i iVar, k kVar, int i10, a aVar) {
        super(i10, kVar, aVar, iVar);
        this.f9856l = qVar;
    }

    public final f g(k kVar, int i10, a aVar) {
        return new n(this.f9856l, this.f9838k, kVar, i10, aVar);
    }

    public final Object k(j jVar, e eVar) {
        Object H = h0.H(new m(this, jVar, (e) null), eVar);
        return H == qa.a.COROUTINE_SUSPENDED ? H : v.f9814a;
    }
}
