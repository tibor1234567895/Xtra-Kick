package eb;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import m0.h1;

public final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f5330a;

    public a(h1 h1Var) {
        this.f5330a = new AtomicReference(h1Var);
    }

    public final Iterator iterator() {
        h hVar = (h) this.f5330a.getAndSet((Object) null);
        if (hVar != null) {
            return hVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
