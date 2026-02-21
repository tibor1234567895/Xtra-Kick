package v1;

import g1.r1;
import g1.t1;
import g1.u1;
import j1.l0;

public final class t extends p {

    /* renamed from: p  reason: collision with root package name */
    public static final Object f15785p = new Object();

    /* renamed from: n  reason: collision with root package name */
    public final Object f15786n;

    /* renamed from: o  reason: collision with root package name */
    public final Object f15787o;

    public t(u1 u1Var, Object obj, Object obj2) {
        super(u1Var);
        this.f15786n = obj;
        this.f15787o = obj2;
    }

    public final int k(Object obj) {
        Object obj2;
        if (f15785p.equals(obj) && (obj2 = this.f15787o) != null) {
            obj = obj2;
        }
        return this.f15746m.k(obj);
    }

    public final r1 o(int i10, r1 r1Var, boolean z10) {
        this.f15746m.o(i10, r1Var, z10);
        if (l0.a(r1Var.f6543i, this.f15787o) && z10) {
            r1Var.f6543i = f15785p;
        }
        return r1Var;
    }

    public final Object u(int i10) {
        Object u10 = this.f15746m.u(i10);
        return l0.a(u10, this.f15787o) ? f15785p : u10;
    }

    public final t1 w(int i10, t1 t1Var, long j10) {
        this.f15746m.w(i10, t1Var, j10);
        if (l0.a(t1Var.f6575h, this.f15786n)) {
            t1Var.f6575h = t1.f6573y;
        }
        return t1Var;
    }
}
