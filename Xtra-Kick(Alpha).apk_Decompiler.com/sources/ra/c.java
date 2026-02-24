package ra;

import hb.d0;
import hb.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import mb.i;
import pa.e;
import pa.g;
import pa.h;
import pa.k;
import xa.j;

public abstract class c extends a {
    private final k _context;
    private transient e<Object> intercepted;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }

    public k getContext() {
        k kVar = this._context;
        j.c(kVar);
        return kVar;
    }

    public final e<Object> intercepted() {
        e<Object> eVar = this.intercepted;
        if (eVar == null) {
            g gVar = (g) getContext().N(g.f12752g);
            if (gVar != null) {
                eVar = new i((d0) gVar, this);
            } else {
                eVar = this;
            }
            this.intercepted = eVar;
        }
        return eVar;
    }

    public void releaseIntercepted() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        l lVar;
        e<Object> eVar = this.intercepted;
        if (!(eVar == null || eVar == this)) {
            h N = getContext().N(g.f12752g);
            j.c(N);
            g gVar = (g) N;
            i iVar = (i) eVar;
            do {
                atomicReferenceFieldUpdater = i.f10859o;
            } while (atomicReferenceFieldUpdater.get(iVar) == mb.j.f10865b);
            Object obj = atomicReferenceFieldUpdater.get(iVar);
            if (obj instanceof l) {
                lVar = (l) obj;
            } else {
                lVar = null;
            }
            if (lVar != null) {
                lVar.r();
            }
        }
        this.intercepted = b.f13892h;
    }

    public c(e eVar, k kVar) {
        super(eVar);
        this._context = kVar;
    }
}
