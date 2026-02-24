package d9;

import java.util.Collection;

public abstract class j0 extends t0 {
    public final m0 d() {
        throw new AssertionError("should never be called");
    }

    public final m0 f() {
        q1 g10 = g();
        u0 u0Var = g10.f4671i;
        if (u0Var != null) {
            return u0Var;
        }
        u1 c10 = g10.c();
        g10.f4671i = c10;
        return c10;
    }

    public abstract q1 g();

    public final Collection values() {
        q1 g10 = g();
        u0 u0Var = g10.f4671i;
        if (u0Var != null) {
            return u0Var;
        }
        u1 c10 = g10.c();
        g10.f4671i = c10;
        return c10;
    }
}
