package eb;

import java.util.Iterator;
import ya.a;

public final class s implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public final Iterator f5354h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r f5355i;

    public s(r rVar) {
        this.f5355i = rVar;
        this.f5354h = ((h) rVar.f5352b).iterator();
    }

    public final boolean hasNext() {
        return this.f5354h.hasNext();
    }

    public final Object next() {
        return this.f5355i.f5353c.invoke(this.f5354h.next());
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
