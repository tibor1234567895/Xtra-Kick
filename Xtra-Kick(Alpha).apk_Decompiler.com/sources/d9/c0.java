package d9;

import java.util.Comparator;

public final class c0 extends e0 {
    public c0() {
        super(0);
    }

    public static e0 f(int i10) {
        if (i10 < 0) {
            return e0.f4609b;
        }
        if (i10 > 0) {
            return e0.f4610c;
        }
        return e0.f4608a;
    }

    public final e0 a(int i10, int i11) {
        return f(i10 < i11 ? -1 : i10 > i11 ? 1 : 0);
    }

    public final e0 b(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    public final e0 c(boolean z10, boolean z11) {
        return f(z10 == z11 ? 0 : z10 ? 1 : -1);
    }

    public final e0 d(boolean z10, boolean z11) {
        return f(z11 == z10 ? 0 : z11 ? 1 : -1);
    }

    public final int e() {
        return 0;
    }
}
