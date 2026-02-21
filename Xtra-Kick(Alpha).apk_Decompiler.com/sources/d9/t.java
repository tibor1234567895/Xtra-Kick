package d9;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class t implements e1 {

    /* renamed from: h  reason: collision with root package name */
    public transient Collection f4666h;

    /* renamed from: i  reason: collision with root package name */
    public transient Set f4667i;

    /* renamed from: j  reason: collision with root package name */
    public transient Collection f4668j;

    /* renamed from: k  reason: collision with root package name */
    public transient Map f4669k;

    public Map a() {
        Map map = this.f4669k;
        if (map != null) {
            return map;
        }
        f b10 = b();
        this.f4669k = b10;
        return b10;
    }

    public abstract f b();

    public abstract r c();

    public abstract h d();

    public Collection e() {
        Collection collection = this.f4666h;
        if (collection != null) {
            return collection;
        }
        r c10 = c();
        this.f4666h = c10;
        return c10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e1) {
            return a().equals(((e1) obj).a());
        }
        return false;
    }

    public abstract c f();

    public Iterator g() {
        return new z0(e().iterator(), 1);
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
