package d9;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

public final class j extends m implements NavigableSet {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ b f4625k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(b bVar, NavigableMap navigableMap) {
        super(bVar, navigableMap);
        this.f4625k = bVar;
    }

    /* renamed from: b */
    public final NavigableMap a() {
        return (NavigableMap) ((SortedMap) this.f4595h);
    }

    public final Object ceiling(Object obj) {
        return a().ceilingKey(obj);
    }

    public final Iterator descendingIterator() {
        return ((h) descendingSet()).iterator();
    }

    public final NavigableSet descendingSet() {
        return new j(this.f4625k, a().descendingMap());
    }

    public final Object floor(Object obj) {
        return a().floorKey(obj);
    }

    public final NavigableSet headSet(Object obj, boolean z10) {
        return new j(this.f4625k, a().headMap(obj, z10));
    }

    public final Object higher(Object obj) {
        return a().higherKey(obj);
    }

    public final Object lower(Object obj) {
        return a().lowerKey(obj);
    }

    public final Object pollFirst() {
        e eVar = (e) iterator();
        if (!eVar.hasNext()) {
            return null;
        }
        Object next = eVar.next();
        eVar.remove();
        return next;
    }

    public final Object pollLast() {
        Iterator descendingIterator = descendingIterator();
        if (!descendingIterator.hasNext()) {
            return null;
        }
        Object next = descendingIterator.next();
        descendingIterator.remove();
        return next;
    }

    public final NavigableSet subSet(Object obj, boolean z10, Object obj2, boolean z11) {
        return new j(this.f4625k, a().subMap(obj, z10, obj2, z11));
    }

    public final NavigableSet tailSet(Object obj, boolean z10) {
        return new j(this.f4625k, a().tailMap(obj, z10));
    }

    public final SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }
}
