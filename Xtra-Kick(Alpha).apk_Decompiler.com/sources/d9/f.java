package d9;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public class f extends c1 {

    /* renamed from: k  reason: collision with root package name */
    public final transient Map f4611k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ b f4612l;

    public f(b bVar, Map map) {
        this.f4612l = bVar;
        this.f4611k = map;
    }

    public final d a() {
        return new d(this);
    }

    public final n0 c(Map.Entry entry) {
        Object obj;
        Object key = entry.getKey();
        b bVar = this.f4612l;
        bVar.getClass();
        List list = (List) ((Collection) entry.getValue());
        if (list instanceof RandomAccess) {
            obj = new k(bVar, key, list, (n) null);
        } else {
            obj = new p(bVar, key, list, (n) null);
        }
        return new n0(key, obj);
    }

    public final void clear() {
        b bVar = this.f4612l;
        if (this.f4611k == bVar.f4592l) {
            bVar.h();
            return;
        }
        e eVar = new e(this);
        while (eVar.hasNext()) {
            eVar.next();
            eVar.remove();
        }
    }

    public final boolean containsKey(Object obj) {
        Map map = this.f4611k;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean equals(Object obj) {
        return this == obj || this.f4611k.equals(obj);
    }

    public final Object get(Object obj) {
        Object obj2;
        Object obj3;
        Map map = this.f4611k;
        map.getClass();
        try {
            obj2 = map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection == null) {
            return null;
        }
        b bVar = this.f4612l;
        bVar.getClass();
        List list = (List) collection;
        if (list instanceof RandomAccess) {
            obj3 = new k(bVar, obj, list, (n) null);
        } else {
            obj3 = new p(bVar, obj, list, (n) null);
        }
        return obj3;
    }

    public final int hashCode() {
        return this.f4611k.hashCode();
    }

    public Set keySet() {
        b bVar = this.f4612l;
        Set set = bVar.f4667i;
        if (set != null) {
            return set;
        }
        h d10 = bVar.d();
        bVar.f4667i = d10;
        return d10;
    }

    public final Object remove(Object obj) {
        Collection collection = (Collection) this.f4611k.remove(obj);
        if (collection == null) {
            return null;
        }
        b bVar = this.f4612l;
        List list = (List) ((m1) bVar).f4633n.get();
        list.addAll(collection);
        bVar.f4593m -= collection.size();
        collection.clear();
        return list;
    }

    public final int size() {
        return this.f4611k.size();
    }

    public final String toString() {
        return this.f4611k.toString();
    }
}
