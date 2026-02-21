package b1;

import xa.j;

public final class f extends c {
    public f() {
        this(0);
    }

    public final Object a(b bVar) {
        j.f("key", bVar);
        return this.f2410a.get(bVar);
    }

    public final void b(b bVar, Object obj) {
        j.f("key", bVar);
        this.f2410a.put(bVar, obj);
    }

    public /* synthetic */ f(int i10) {
        this((c) a.f2409b);
    }

    public f(c cVar) {
        j.f("initialExtras", cVar);
        this.f2410a.putAll(cVar.f2410a);
    }
}
