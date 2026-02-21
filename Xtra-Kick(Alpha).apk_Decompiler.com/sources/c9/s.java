package c9;

import java.io.Serializable;
import java.util.List;

public final class s implements r, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final List f3045h;

    public s(List list) {
        this.f3045h = list;
    }

    public final boolean apply(Object obj) {
        int i10 = 0;
        while (true) {
            List list = this.f3045h;
            if (i10 >= list.size()) {
                return true;
            }
            if (!((r) list.get(i10)).apply(obj)) {
                return false;
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f3045h.equals(((s) obj).f3045h);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3045h.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Predicates.and(");
        boolean z10 = true;
        for (Object next : this.f3045h) {
            if (!z10) {
                sb2.append(Constants.COMMA_CHAR);
            }
            sb2.append(next);
            z10 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
