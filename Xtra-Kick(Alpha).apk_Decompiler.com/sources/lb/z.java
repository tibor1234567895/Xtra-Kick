package lb;

import pa.e;
import pa.k;
import ra.d;

public final class z implements e, d {

    /* renamed from: h  reason: collision with root package name */
    public final e f9872h;

    /* renamed from: i  reason: collision with root package name */
    public final k f9873i;

    public z(e eVar, k kVar) {
        this.f9872h = eVar;
        this.f9873i = kVar;
    }

    public final d getCallerFrame() {
        e eVar = this.f9872h;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public final k getContext() {
        return this.f9873i;
    }

    public final void resumeWith(Object obj) {
        this.f9872h.resumeWith(obj);
    }
}
