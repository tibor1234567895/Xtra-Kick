package oa;

import java.util.Comparator;
import xa.j;

public final class c implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public static final c f12366h = new c();

    private c() {
    }

    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        j.f("a", comparable);
        j.f("b", comparable2);
        return comparable.compareTo(comparable2);
    }

    public final Comparator reversed() {
        return d.f12367h;
    }
}
