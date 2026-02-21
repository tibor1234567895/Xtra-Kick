package d9;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public abstract class t0 implements Map, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public transient u0 f4670h;

    /* renamed from: i  reason: collision with root package name */
    public transient u0 f4671i;

    /* renamed from: j  reason: collision with root package name */
    public transient m0 f4672j;

    public static t0 a(Map map) {
        int i10;
        if (!(map instanceof t0) || (map instanceof SortedMap)) {
            Set entrySet = map.entrySet();
            if (entrySet instanceof Collection) {
                i10 = entrySet.size();
            } else {
                i10 = 4;
            }
            s0 s0Var = new s0(i10);
            s0Var.d(entrySet);
            return s0Var.a();
        }
        t0 t0Var = (t0) map;
        t0Var.e();
        return t0Var;
    }

    public abstract t1 b();

    public abstract u1 c();

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract m0 d();

    public abstract void e();

    public final Set entrySet() {
        u0 u0Var = this.f4670h;
        if (u0Var != null) {
            return u0Var;
        }
        t1 b10 = b();
        this.f4670h = b10;
        return b10;
    }

    public final boolean equals(Object obj) {
        return d1.a(this, obj);
    }

    /* renamed from: f */
    public m0 values() {
        m0 m0Var = this.f4672j;
        if (m0Var != null) {
            return m0Var;
        }
        m0 d10 = d();
        this.f4672j = d10;
        return d10;
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        u0 u0Var = this.f4670h;
        if (u0Var == null) {
            u0Var = b();
            this.f4670h = u0Var;
        }
        return f2.c(u0Var);
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final Set keySet() {
        u0 u0Var = this.f4671i;
        if (u0Var != null) {
            return u0Var;
        }
        u1 c10 = c();
        this.f4671i = c10;
        return c10;
    }

    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        u.a(size, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb2.append('{');
        boolean z10 = true;
        for (Map.Entry entry : entrySet()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z10 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }
}
