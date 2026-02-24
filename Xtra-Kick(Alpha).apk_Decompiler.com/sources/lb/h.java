package lb;

import hb.h0;
import jb.a;
import jb.r;
import kb.i;
import kb.j;
import la.v;
import mb.f0;
import pa.e;
import pa.f;
import pa.g;
import pa.k;

public abstract class h extends f {

    /* renamed from: k  reason: collision with root package name */
    public final i f9838k;

    public h(int i10, k kVar, a aVar, i iVar) {
        super(kVar, i10, aVar);
        this.f9838k = iVar;
    }

    public final Object b(j jVar, e eVar) {
        boolean z10;
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (this.f9833i == -3) {
            k context = eVar.getContext();
            k I0 = context.I0(this.f9832h);
            if (xa.j.a(I0, context)) {
                Object k10 = k(jVar, eVar);
                if (k10 == aVar) {
                    return k10;
                }
            } else {
                f fVar = g.f12752g;
                if (xa.j.a(I0.N(fVar), context.N(fVar))) {
                    k context2 = eVar.getContext();
                    if (jVar instanceof y) {
                        z10 = true;
                    } else {
                        z10 = jVar instanceof s;
                    }
                    if (!z10) {
                        jVar = new kb.g(jVar, context2);
                    }
                    Object d22 = h0.d2(I0, jVar, f0.b(I0), new g(this, (e) null), eVar);
                    if (d22 != aVar) {
                        d22 = v.f9814a;
                    }
                    if (d22 == aVar) {
                        return d22;
                    }
                }
            }
            return v.f9814a;
        }
        Object b10 = super.b(jVar, eVar);
        if (b10 == aVar) {
            return b10;
        }
        return v.f9814a;
    }

    public final Object f(r rVar, e eVar) {
        Object k10 = k(new y(rVar), eVar);
        return k10 == qa.a.COROUTINE_SUSPENDED ? k10 : v.f9814a;
    }

    public abstract Object k(j jVar, e eVar);

    public final String toString() {
        return this.f9838k + " -> " + super.toString();
    }
}
