package d9;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

public class l extends f implements SortedMap {

    /* renamed from: m  reason: collision with root package name */
    public SortedSet f4629m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ b f4630n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(b bVar, SortedMap sortedMap) {
        super(bVar, sortedMap);
        this.f4630n = bVar;
    }

    public final Comparator comparator() {
        return f().comparator();
    }

    /* renamed from: d */
    public SortedSet b() {
        return new m(this.f4630n, f());
    }

    /* renamed from: e */
    public SortedSet keySet() {
        SortedSet sortedSet = this.f4629m;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet d10 = b();
        this.f4629m = d10;
        return d10;
    }

    public SortedMap f() {
        return (SortedMap) this.f4611k;
    }

    public final Object firstKey() {
        return f().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new l(this.f4630n, f().headMap(obj));
    }

    public final Object lastKey() {
        return f().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new l(this.f4630n, f().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new l(this.f4630n, f().tailMap(obj));
    }
}
