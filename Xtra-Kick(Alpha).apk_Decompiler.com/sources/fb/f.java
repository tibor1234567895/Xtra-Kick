package fb;

import cb.e;
import xa.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final String f6001a;

    /* renamed from: b  reason: collision with root package name */
    public final e f6002b;

    public f(String str, e eVar) {
        this.f6001a = str;
        this.f6002b = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return j.a(this.f6001a, fVar.f6001a) && j.a(this.f6002b, fVar.f6002b);
    }

    public final int hashCode() {
        return this.f6002b.hashCode() + (this.f6001a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f6001a + ", range=" + this.f6002b + ')';
    }
}
