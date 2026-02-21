package k1;

import d9.b2;
import d9.d1;
import d9.f0;
import d9.f2;
import d9.z0;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r extends f0 {

    /* renamed from: h  reason: collision with root package name */
    public final Map f9050h;

    public r(Map map) {
        this.f9050h = map;
    }

    public final Object b() {
        return this.f9050h;
    }

    public final Map c() {
        return this.f9050h;
    }

    public final boolean containsKey(Object obj) {
        return obj != null && super.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        z0 z0Var = new z0(((b2) entrySet()).iterator(), 1);
        if (obj == null) {
            while (z0Var.hasNext()) {
                if (z0Var.next() == null) {
                    return true;
                }
            }
        } else {
            while (z0Var.hasNext()) {
                if (obj.equals(z0Var.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Set entrySet() {
        return f2.b(super.entrySet(), new q(0));
    }

    public final boolean equals(Object obj) {
        return obj != null && d1.a(this, obj);
    }

    public final Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) super.get(obj);
    }

    public final int hashCode() {
        return f2.c(entrySet());
    }

    public final boolean isEmpty() {
        if (!super.isEmpty()) {
            return super.size() == 1 && super.containsKey((Object) null);
        }
        return true;
    }

    public final Set keySet() {
        return f2.b(super.keySet(), new q(1));
    }

    public final int size() {
        return super.size() - (super.containsKey((Object) null) ? 1 : 0);
    }
}
