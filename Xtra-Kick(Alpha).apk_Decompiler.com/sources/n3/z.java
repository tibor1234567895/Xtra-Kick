package n3;

import xa.j;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final a1 f11594a;

    /* renamed from: b  reason: collision with root package name */
    public final a1 f11595b;

    /* renamed from: c  reason: collision with root package name */
    public final a1 f11596c;

    /* renamed from: d  reason: collision with root package name */
    public final c1 f11597d;

    /* renamed from: e  reason: collision with root package name */
    public final c1 f11598e;

    public z(a1 a1Var, a1 a1Var2, a1 a1Var3, c1 c1Var, c1 c1Var2) {
        j.f("refresh", a1Var);
        j.f("prepend", a1Var2);
        j.f("append", a1Var3);
        j.f("source", c1Var);
        this.f11594a = a1Var;
        this.f11595b = a1Var2;
        this.f11596c = a1Var3;
        this.f11597d = c1Var;
        this.f11598e = c1Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(z.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            z zVar = (z) obj;
            return j.a(this.f11594a, zVar.f11594a) && j.a(this.f11595b, zVar.f11595b) && j.a(this.f11596c, zVar.f11596c) && j.a(this.f11597d, zVar.f11597d) && j.a(this.f11598e, zVar.f11598e);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
    }

    public final int hashCode() {
        int hashCode = this.f11595b.hashCode();
        int hashCode2 = (this.f11597d.hashCode() + ((this.f11596c.hashCode() + ((hashCode + (this.f11594a.hashCode() * 31)) * 31)) * 31)) * 31;
        c1 c1Var = this.f11598e;
        return hashCode2 + (c1Var == null ? 0 : c1Var.hashCode());
    }

    public final String toString() {
        return "CombinedLoadStates(refresh=" + this.f11594a + ", prepend=" + this.f11595b + ", append=" + this.f11596c + ", source=" + this.f11597d + ", mediator=" + this.f11598e + ')';
    }
}
