package pa;

import java.io.Serializable;
import wa.p;
import xa.j;

public final class d implements k, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final k f12749h;

    /* renamed from: i  reason: collision with root package name */
    public final h f12750i;

    public d(h hVar, k kVar) {
        j.f("left", kVar);
        j.f("element", hVar);
        this.f12749h = kVar;
        this.f12750i = hVar;
    }

    public final k I0(k kVar) {
        j.f("context", kVar);
        if (kVar == l.f12754h) {
            return this;
        }
        return (k) kVar.j0(this, j.f12753h);
    }

    public final h N(i iVar) {
        j.f("key", iVar);
        d dVar = this;
        while (true) {
            h N = dVar.f12750i.N(iVar);
            if (N != null) {
                return N;
            }
            k kVar = dVar.f12749h;
            if (!(kVar instanceof d)) {
                return kVar.N(iVar);
            }
            dVar = (d) kVar;
        }
    }

    public final boolean equals(Object obj) {
        boolean z10;
        if (this != obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            dVar.getClass();
            int i10 = 2;
            d dVar2 = dVar;
            int i11 = 2;
            while (true) {
                k kVar = dVar2.f12749h;
                if (kVar instanceof d) {
                    dVar2 = (d) kVar;
                } else {
                    dVar2 = null;
                }
                if (dVar2 == null) {
                    break;
                }
                i11++;
            }
            d dVar3 = this;
            while (true) {
                k kVar2 = dVar3.f12749h;
                if (kVar2 instanceof d) {
                    dVar3 = (d) kVar2;
                } else {
                    dVar3 = null;
                }
                if (dVar3 == null) {
                    break;
                }
                i10++;
            }
            if (i11 != i10) {
                return false;
            }
            d dVar4 = this;
            while (true) {
                h hVar = dVar4.f12750i;
                if (j.a(dVar.N(hVar.getKey()), hVar)) {
                    k kVar3 = dVar4.f12749h;
                    if (!(kVar3 instanceof d)) {
                        j.d("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element", kVar3);
                        h hVar2 = (h) kVar3;
                        z10 = j.a(dVar.N(hVar2.getKey()), hVar2);
                        break;
                    }
                    dVar4 = (d) kVar3;
                } else {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f12750i.hashCode() + this.f12749h.hashCode();
    }

    public final Object j0(Object obj, p pVar) {
        j.f("operation", pVar);
        return pVar.g(this.f12749h.j0(obj, pVar), this.f12750i);
    }

    public final String toString() {
        return "[" + ((String) j0("", c.f12748h)) + ']';
    }

    public final k w(i iVar) {
        j.f("key", iVar);
        h hVar = this.f12750i;
        h N = hVar.N(iVar);
        k kVar = this.f12749h;
        if (N != null) {
            return kVar;
        }
        k w10 = kVar.w(iVar);
        return w10 == kVar ? this : w10 == l.f12754h ? hVar : new d(hVar, w10);
    }
}
