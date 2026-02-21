package n3;

import la.g;
import xa.j;

public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    public a1 f11221a;

    /* renamed from: b  reason: collision with root package name */
    public a1 f11222b;

    /* renamed from: c  reason: collision with root package name */
    public a1 f11223c;

    public h1() {
        y0 y0Var = z0.f11599b;
        y0Var.getClass();
        z0 z0Var = z0.f11601d;
        this.f11221a = z0Var;
        y0Var.getClass();
        this.f11222b = z0Var;
        y0Var.getClass();
        this.f11223c = z0Var;
    }

    public final a1 a(d1 d1Var) {
        j.f("loadType", d1Var);
        int ordinal = d1Var.ordinal();
        if (ordinal == 0) {
            return this.f11221a;
        }
        if (ordinal == 1) {
            return this.f11222b;
        }
        if (ordinal == 2) {
            return this.f11223c;
        }
        throw new g();
    }

    public final void b(c1 c1Var) {
        j.f("states", c1Var);
        this.f11221a = c1Var.f11079a;
        this.f11223c = c1Var.f11081c;
        this.f11222b = c1Var.f11080b;
    }

    public final void c(d1 d1Var, a1 a1Var) {
        j.f("type", d1Var);
        j.f("state", a1Var);
        int ordinal = d1Var.ordinal();
        if (ordinal == 0) {
            this.f11221a = a1Var;
        } else if (ordinal == 1) {
            this.f11222b = a1Var;
        } else if (ordinal == 2) {
            this.f11223c = a1Var;
        } else {
            throw new g();
        }
    }

    public final c1 d() {
        return new c1(this.f11221a, this.f11222b, this.f11223c);
    }
}
