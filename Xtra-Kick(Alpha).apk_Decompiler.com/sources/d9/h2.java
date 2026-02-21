package d9;

import java.util.Iterator;
import java.util.Map;

public abstract class h2 implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public final Iterator f4623h;

    public h2(Iterator it) {
        it.getClass();
        this.f4623h = it;
    }

    public final boolean hasNext() {
        return this.f4623h.hasNext();
    }

    public final Object next() {
        Object next = this.f4623h.next();
        int i10 = ((z0) this).f4724i;
        switch (i10) {
            case 0:
                Map.Entry entry = (Map.Entry) next;
                switch (i10) {
                    case 0:
                        return entry.getKey();
                    default:
                        return entry.getValue();
                }
            default:
                Map.Entry entry2 = (Map.Entry) next;
                switch (i10) {
                    case 0:
                        return entry2.getKey();
                    default:
                        return entry2.getValue();
                }
        }
    }

    public final void remove() {
        this.f4623h.remove();
    }
}
