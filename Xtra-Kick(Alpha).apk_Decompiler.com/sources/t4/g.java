package t4;

import xa.j;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final g f14547c;

    /* renamed from: a  reason: collision with root package name */
    public final c f14548a;

    /* renamed from: b  reason: collision with root package name */
    public final c f14549b;

    static {
        new f(0);
        b bVar = b.f14543a;
        f14547c = new g(bVar, bVar);
    }

    public g(c cVar, c cVar2) {
        this.f14548a = cVar;
        this.f14549b = cVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return j.a(this.f14548a, gVar.f14548a) && j.a(this.f14549b, gVar.f14549b);
    }

    public final int hashCode() {
        return this.f14549b.hashCode() + (this.f14548a.hashCode() * 31);
    }

    public final String toString() {
        return "Size(width=" + this.f14548a + ", height=" + this.f14549b + ')';
    }
}
