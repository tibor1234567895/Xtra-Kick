package lb;

import jb.a;
import kb.j;
import la.v;
import pa.e;
import pa.k;
import pa.l;

public final class i extends h {
    public i(int i10, k kVar, a aVar, kb.i iVar) {
        super(i10, kVar, aVar, iVar);
    }

    public final f g(k kVar, int i10, a aVar) {
        return new i(i10, kVar, aVar, this.f9838k);
    }

    public final kb.i i() {
        return this.f9838k;
    }

    public final Object k(j jVar, e eVar) {
        Object b10 = this.f9838k.b(jVar, eVar);
        return b10 == qa.a.COROUTINE_SUSPENDED ? b10 : v.f9814a;
    }

    public i(kb.i iVar, int i10, a aVar) {
        super(i10, l.f12754h, aVar, iVar);
    }
}
