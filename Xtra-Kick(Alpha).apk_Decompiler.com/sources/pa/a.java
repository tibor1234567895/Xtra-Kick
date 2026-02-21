package pa;

import hb.h0;
import wa.p;
import xa.j;

public abstract class a implements h {

    /* renamed from: h  reason: collision with root package name */
    public final i f12745h;

    public a(i iVar) {
        j.f("key", iVar);
        this.f12745h = iVar;
    }

    public final k I0(k kVar) {
        return h0.j1(this, kVar);
    }

    public h N(i iVar) {
        return h0.Z(this, iVar);
    }

    public final i getKey() {
        return this.f12745h;
    }

    public final Object j0(Object obj, p pVar) {
        j.f("operation", pVar);
        return pVar.g(obj, this);
    }

    public k w(i iVar) {
        return h0.d1(this, iVar);
    }
}
