package d9;

import j0.a;
import java.io.Serializable;
import java.util.Comparator;

public final class b0 extends p1 implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Comparator f4594h;

    public b0(a aVar) {
        this.f4594h = aVar;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f4594h.compare(obj, obj2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            return this.f4594h.equals(((b0) obj).f4594h);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4594h.hashCode();
    }

    public final String toString() {
        return this.f4594h.toString();
    }
}
