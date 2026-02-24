package s4;

import java.util.Map;
import ma.j0;
import xa.j;

public final class t {

    /* renamed from: b  reason: collision with root package name */
    public static final s f14301b = new s(0);

    /* renamed from: c  reason: collision with root package name */
    public static final t f14302c = new t(j0.d());

    /* renamed from: a  reason: collision with root package name */
    public final Map f14303a;

    public t(Map map) {
        this.f14303a = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            if (j.a(this.f14303a, ((t) obj).f14303a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f14303a.hashCode();
    }

    public final String toString() {
        return "Tags(tags=" + this.f14303a + ')';
    }
}
