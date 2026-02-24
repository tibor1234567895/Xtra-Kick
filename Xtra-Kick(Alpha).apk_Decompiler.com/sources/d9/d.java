package d9;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class d extends a1 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ f f4602h;

    public d(f fVar) {
        this.f4602h = fVar;
    }

    public final Map a() {
        return this.f4602h;
    }

    public final boolean contains(Object obj) {
        Set entrySet = this.f4602h.f4611k.entrySet();
        entrySet.getClass();
        try {
            return entrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Iterator iterator() {
        return new e(this.f4602h);
    }

    public final boolean remove(Object obj) {
        Object obj2;
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        b bVar = this.f4602h.f4612l;
        Object key = entry.getKey();
        Map map = bVar.f4592l;
        map.getClass();
        try {
            obj2 = map.remove(key);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return true;
        }
        int size = collection.size();
        collection.clear();
        bVar.f4593m -= size;
        return true;
    }
}
