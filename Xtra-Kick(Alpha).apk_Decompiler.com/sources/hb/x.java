package hb;

import wa.l;
import xa.j;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final Object f7880a;

    /* renamed from: b  reason: collision with root package name */
    public final l f7881b;

    public x(Object obj, l lVar) {
        this.f7880a = obj;
        this.f7881b = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return j.a(this.f7880a, xVar.f7880a) && j.a(this.f7881b, xVar.f7881b);
    }

    public final int hashCode() {
        Object obj = this.f7880a;
        return this.f7881b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f7880a + ", onCancellation=" + this.f7881b + ')';
    }
}
