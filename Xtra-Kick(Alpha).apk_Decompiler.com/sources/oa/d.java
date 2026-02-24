package oa;

import java.util.Comparator;
import xa.j;

public final class d implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public static final d f12367h = new d();

    private d() {
    }

    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        j.f("a", comparable);
        j.f("b", comparable2);
        return comparable2.compareTo(comparable);
    }

    public final Comparator reversed() {
        return c.f12366h;
    }
}
