package o;

import java.util.Iterator;

public final class d extends f implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public c f11844h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11845i = true;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g f11846j;

    public d(g gVar) {
        this.f11846j = gVar;
    }

    public final void a(c cVar) {
        c cVar2 = this.f11844h;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f11843k;
            this.f11844h = cVar3;
            this.f11845i = cVar3 == null;
        }
    }

    public final boolean hasNext() {
        if (this.f11845i) {
            return this.f11846j.f11849h != null;
        }
        c cVar = this.f11844h;
        return (cVar == null || cVar.f11842j == null) ? false : true;
    }

    public final Object next() {
        c cVar;
        if (this.f11845i) {
            this.f11845i = false;
            cVar = this.f11846j.f11849h;
        } else {
            c cVar2 = this.f11844h;
            cVar = cVar2 != null ? cVar2.f11842j : null;
        }
        this.f11844h = cVar;
        return cVar;
    }
}
