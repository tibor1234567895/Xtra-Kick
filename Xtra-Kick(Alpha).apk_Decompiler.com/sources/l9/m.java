package l9;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class m implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public n f9773h;

    /* renamed from: i  reason: collision with root package name */
    public n f9774i = null;

    /* renamed from: j  reason: collision with root package name */
    public int f9775j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ o f9776k;

    public m(o oVar) {
        this.f9776k = oVar;
        this.f9773h = oVar.f9790l.f9780k;
        this.f9775j = oVar.f9789k;
    }

    public final n a() {
        n nVar = this.f9773h;
        o oVar = this.f9776k;
        if (nVar == oVar.f9790l) {
            throw new NoSuchElementException();
        } else if (oVar.f9789k == this.f9775j) {
            this.f9773h = nVar.f9780k;
            this.f9774i = nVar;
            return nVar;
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        return this.f9773h != this.f9776k.f9790l;
    }

    public final void remove() {
        n nVar = this.f9774i;
        if (nVar != null) {
            o oVar = this.f9776k;
            oVar.d(nVar, true);
            this.f9774i = null;
            this.f9775j = oVar.f9789k;
            return;
        }
        throw new IllegalStateException();
    }
}
