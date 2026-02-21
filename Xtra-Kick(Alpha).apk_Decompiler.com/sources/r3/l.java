package r3;

import m.d;
import u3.o;
import xa.j;

public abstract class l extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(n0 n0Var, int i10) {
        super(n0Var);
        if (i10 != 1) {
            j.f("database", n0Var);
            return;
        }
        j.f("database", n0Var);
        super(n0Var);
    }

    public abstract void h(o oVar, Object obj);

    public final void i(Object obj) {
        o c10 = c();
        try {
            h(c10, obj);
            c10.x();
        } finally {
            g(c10);
        }
    }

    public final void j(Iterable iterable) {
        j.f("entities", iterable);
        o c10 = c();
        try {
            for (Object h10 : iterable) {
                h(c10, h10);
                c10.x();
            }
        } finally {
            g(c10);
        }
    }

    public final void k(Object obj) {
        o c10 = c();
        try {
            h(c10, obj);
            c10.A0();
        } finally {
            g(c10);
        }
    }
}
