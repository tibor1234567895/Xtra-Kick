package d9;

import java.io.Serializable;

public final class o1 extends p1 implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final o1 f4642h = new o1();

    private o1() {
    }

    public final p1 a() {
        return y1.f4713h;
    }

    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
