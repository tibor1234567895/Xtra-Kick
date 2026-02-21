package d9;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public abstract class g implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public final Iterator f4614h;

    /* renamed from: i  reason: collision with root package name */
    public Object f4615i = null;

    /* renamed from: j  reason: collision with root package name */
    public Collection f4616j = null;

    /* renamed from: k  reason: collision with root package name */
    public Iterator f4617k = y0.f4711h;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ b f4618l;

    public g(b bVar) {
        this.f4618l = bVar;
        this.f4614h = bVar.f4592l.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.f4614h.hasNext() || this.f4617k.hasNext();
    }

    public final Object next() {
        if (!this.f4617k.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f4614h.next();
            this.f4615i = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f4616j = collection;
            this.f4617k = collection.iterator();
        }
        Object obj = this.f4615i;
        Object next = this.f4617k.next();
        switch (((c) this).f4598m) {
            case 0:
                return next;
            default:
                return new n0(obj, next);
        }
    }

    public final void remove() {
        this.f4617k.remove();
        Collection collection = this.f4616j;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f4614h.remove();
        }
        b bVar = this.f4618l;
        bVar.f4593m--;
    }
}
