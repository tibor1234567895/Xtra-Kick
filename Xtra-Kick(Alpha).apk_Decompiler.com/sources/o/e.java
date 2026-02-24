package o;

import java.util.Iterator;

public abstract class e extends f implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public c f11847h;

    /* renamed from: i  reason: collision with root package name */
    public c f11848i;

    public e(c cVar, c cVar2) {
        this.f11847h = cVar2;
        this.f11848i = cVar;
    }

    public final void a(c cVar) {
        c cVar2;
        if (this.f11847h == cVar && cVar == this.f11848i) {
            this.f11848i = null;
            this.f11847h = null;
        }
        c cVar3 = this.f11847h;
        if (cVar3 == cVar) {
            switch (((b) this).f11839j) {
                case 0:
                    cVar2 = cVar3.f11843k;
                    break;
                default:
                    cVar2 = cVar3.f11842j;
                    break;
            }
            this.f11847h = cVar2;
        }
        if (this.f11848i == cVar) {
            this.f11848i = b();
        }
    }

    public final c b() {
        c cVar = this.f11848i;
        c cVar2 = this.f11847h;
        if (cVar == cVar2 || cVar2 == null) {
            return null;
        }
        switch (((b) this).f11839j) {
            case 0:
                return cVar.f11842j;
            default:
                return cVar.f11843k;
        }
    }

    public final boolean hasNext() {
        return this.f11848i != null;
    }

    public final Object next() {
        c cVar = this.f11848i;
        this.f11848i = b();
        return cVar;
    }
}
