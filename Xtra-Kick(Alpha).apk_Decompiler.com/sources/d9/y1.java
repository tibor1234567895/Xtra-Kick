package d9;

import java.io.Serializable;

public final class y1 extends p1 implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final y1 f4713h = new y1();

    private y1() {
    }

    public final p1 a() {
        return o1.f4642h;
    }

    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
