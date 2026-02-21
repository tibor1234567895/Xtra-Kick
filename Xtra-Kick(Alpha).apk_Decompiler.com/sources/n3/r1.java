package n3;

import xa.j;

public final class r1 extends s1 {

    /* renamed from: a  reason: collision with root package name */
    public final c1 f11453a;

    /* renamed from: b  reason: collision with root package name */
    public final c1 f11454b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r1(c1 c1Var, c1 c1Var2) {
        super(0);
        j.f("source", c1Var);
        this.f11453a = c1Var;
        this.f11454b = c1Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return j.a(this.f11453a, r1Var.f11453a) && j.a(this.f11454b, r1Var.f11454b);
    }

    public final int hashCode() {
        int hashCode = this.f11453a.hashCode() * 31;
        c1 c1Var = this.f11454b;
        return hashCode + (c1Var == null ? 0 : c1Var.hashCode());
    }

    public final String toString() {
        return "LoadStateUpdate(source=" + this.f11453a + ", mediator=" + this.f11454b + ')';
    }
}
