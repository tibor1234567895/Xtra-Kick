package n3;

import la.g;
import xa.j;

public final class c1 {

    /* renamed from: d  reason: collision with root package name */
    public static final b1 f11077d = new b1(0);

    /* renamed from: e  reason: collision with root package name */
    public static final c1 f11078e;

    /* renamed from: a  reason: collision with root package name */
    public final a1 f11079a;

    /* renamed from: b  reason: collision with root package name */
    public final a1 f11080b;

    /* renamed from: c  reason: collision with root package name */
    public final a1 f11081c;

    static {
        z0.f11599b.getClass();
        z0 z0Var = z0.f11601d;
        f11078e = new c1(z0Var, z0Var, z0Var);
    }

    public c1(a1 a1Var, a1 a1Var2, a1 a1Var3) {
        j.f("refresh", a1Var);
        j.f("prepend", a1Var2);
        j.f("append", a1Var3);
        this.f11079a = a1Var;
        this.f11080b = a1Var2;
        this.f11081c = a1Var3;
    }

    public static c1 a(c1 c1Var, z0 z0Var, z0 z0Var2, z0 z0Var3, int i10) {
        a1 a1Var = z0Var;
        if ((i10 & 1) != 0) {
            a1Var = c1Var.f11079a;
        }
        a1 a1Var2 = z0Var2;
        if ((i10 & 2) != 0) {
            a1Var2 = c1Var.f11080b;
        }
        a1 a1Var3 = z0Var3;
        if ((i10 & 4) != 0) {
            a1Var3 = c1Var.f11081c;
        }
        c1Var.getClass();
        j.f("refresh", a1Var);
        j.f("prepend", a1Var2);
        j.f("append", a1Var3);
        return new c1(a1Var, a1Var2, a1Var3);
    }

    public final c1 b(d1 d1Var, z0 z0Var) {
        int i10;
        z0 z0Var2;
        j.f("newState", z0Var);
        int ordinal = d1Var.ordinal();
        if (ordinal == 0) {
            i10 = 6;
            z0Var2 = null;
        } else if (ordinal == 1) {
            i10 = 5;
            z0Var2 = z0Var;
            z0Var = null;
        } else if (ordinal == 2) {
            return a(this, (z0) null, (z0) null, z0Var, 3);
        } else {
            throw new g();
        }
        return a(this, z0Var, z0Var2, (z0) null, i10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return j.a(this.f11079a, c1Var.f11079a) && j.a(this.f11080b, c1Var.f11080b) && j.a(this.f11081c, c1Var.f11081c);
    }

    public final int hashCode() {
        int hashCode = this.f11080b.hashCode();
        return this.f11081c.hashCode() + ((hashCode + (this.f11079a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LoadStates(refresh=" + this.f11079a + ", prepend=" + this.f11080b + ", append=" + this.f11081c + ')';
    }
}
