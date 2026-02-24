package h5;

import java.util.ArrayDeque;
import w5.p;

public final class f0 {

    /* renamed from: d  reason: collision with root package name */
    public static final ArrayDeque f7570d = new ArrayDeque(0);

    /* renamed from: a  reason: collision with root package name */
    public int f7571a;

    /* renamed from: b  reason: collision with root package name */
    public int f7572b;

    /* renamed from: c  reason: collision with root package name */
    public Object f7573c;

    static {
        char[] cArr = p.f16126a;
    }

    private f0() {
    }

    public static f0 a(Object obj) {
        f0 f0Var;
        ArrayDeque arrayDeque = f7570d;
        synchronized (arrayDeque) {
            f0Var = (f0) arrayDeque.poll();
        }
        if (f0Var == null) {
            f0Var = new f0();
        }
        f0Var.f7573c = obj;
        f0Var.f7572b = 0;
        f0Var.f7571a = 0;
        return f0Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f7572b == f0Var.f7572b && this.f7571a == f0Var.f7571a && this.f7573c.equals(f0Var.f7573c);
    }

    public final int hashCode() {
        return this.f7573c.hashCode() + (((this.f7571a * 31) + this.f7572b) * 31);
    }
}
