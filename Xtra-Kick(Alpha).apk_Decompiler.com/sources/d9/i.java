package d9;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class i extends l implements NavigableMap {

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ b f4624o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(b bVar, NavigableMap navigableMap) {
        super(bVar, navigableMap);
        this.f4624o = bVar;
    }

    public final Set b() {
        return new j(this.f4624o, f());
    }

    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry ceilingEntry = f().ceilingEntry(obj);
        if (ceilingEntry == null) {
            return null;
        }
        return c(ceilingEntry);
    }

    public final Object ceilingKey(Object obj) {
        return f().ceilingKey(obj);
    }

    public final SortedSet d() {
        return new j(this.f4624o, f());
    }

    public final NavigableSet descendingKeySet() {
        return ((i) descendingMap()).navigableKeySet();
    }

    public final NavigableMap descendingMap() {
        return new i(this.f4624o, f().descendingMap());
    }

    public final SortedSet e() {
        return (NavigableSet) super.keySet();
    }

    public final Map.Entry firstEntry() {
        Map.Entry firstEntry = f().firstEntry();
        if (firstEntry == null) {
            return null;
        }
        return c(firstEntry);
    }

    public final Map.Entry floorEntry(Object obj) {
        Map.Entry floorEntry = f().floorEntry(obj);
        if (floorEntry == null) {
            return null;
        }
        return c(floorEntry);
    }

    public final Object floorKey(Object obj) {
        return f().floorKey(obj);
    }

    public final n0 g(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        List list = (List) ((m1) this.f4624o).f4633n.get();
        list.addAll((Collection) entry.getValue());
        it.remove();
        return new n0(entry.getKey(), Collections.unmodifiableList(list));
    }

    /* renamed from: h */
    public final NavigableMap f() {
        return (NavigableMap) ((SortedMap) this.f4611k);
    }

    public final NavigableMap headMap(Object obj, boolean z10) {
        return new i(this.f4624o, f().headMap(obj, z10));
    }

    public final Map.Entry higherEntry(Object obj) {
        Map.Entry higherEntry = f().higherEntry(obj);
        if (higherEntry == null) {
            return null;
        }
        return c(higherEntry);
    }

    public final Object higherKey(Object obj) {
        return f().higherKey(obj);
    }

    public final Set keySet() {
        return (NavigableSet) super.keySet();
    }

    public final Map.Entry lastEntry() {
        Map.Entry lastEntry = f().lastEntry();
        if (lastEntry == null) {
            return null;
        }
        return c(lastEntry);
    }

    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry lowerEntry = f().lowerEntry(obj);
        if (lowerEntry == null) {
            return null;
        }
        return c(lowerEntry);
    }

    public final Object lowerKey(Object obj) {
        return f().lowerKey(obj);
    }

    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.keySet();
    }

    public final Map.Entry pollFirstEntry() {
        return g(entrySet().iterator());
    }

    public final Map.Entry pollLastEntry() {
        return g(((c1) descendingMap()).entrySet().iterator());
    }

    public final NavigableMap subMap(Object obj, boolean z10, Object obj2, boolean z11) {
        return new i(this.f4624o, f().subMap(obj, z10, obj2, z11));
    }

    public final NavigableMap tailMap(Object obj, boolean z10) {
        return new i(this.f4624o, f().tailMap(obj, z10));
    }

    public final SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    public final SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
