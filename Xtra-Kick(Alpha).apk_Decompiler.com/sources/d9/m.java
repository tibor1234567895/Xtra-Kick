package d9;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class m extends h implements SortedSet {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ b f4631j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(b bVar, SortedMap sortedMap) {
        super(bVar, sortedMap);
        this.f4631j = bVar;
    }

    public SortedMap a() {
        return (SortedMap) this.f4595h;
    }

    public final Comparator comparator() {
        return a().comparator();
    }

    public final Object first() {
        return a().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new m(this.f4631j, a().headMap(obj));
    }

    public final Object last() {
        return a().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new m(this.f4631j, a().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new m(this.f4631j, a().tailMap(obj));
    }
}
