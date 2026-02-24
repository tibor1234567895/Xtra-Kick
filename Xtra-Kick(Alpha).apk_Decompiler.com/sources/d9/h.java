package d9;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class h extends b1 {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ b f4621i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(b bVar, Map map) {
        super(map);
        this.f4621i = bVar;
    }

    public final void clear() {
        e eVar = (e) iterator();
        while (eVar.hasNext()) {
            eVar.next();
            eVar.remove();
        }
    }

    public final boolean containsAll(Collection collection) {
        return this.f4595h.keySet().containsAll(collection);
    }

    public final boolean equals(Object obj) {
        return this == obj || this.f4595h.keySet().equals(obj);
    }

    public final int hashCode() {
        return this.f4595h.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new e(this, this.f4595h.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        int i10;
        Collection collection = (Collection) this.f4595h.remove(obj);
        if (collection != null) {
            i10 = collection.size();
            collection.clear();
            this.f4621i.f4593m -= i10;
        } else {
            i10 = 0;
        }
        if (i10 > 0) {
            return true;
        }
        return false;
    }
}
