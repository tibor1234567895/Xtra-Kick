package ma;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import xa.j;
import ya.a;

public final class c0 implements Map, Serializable, a {

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f10802h = new c0();

    private c0() {
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean containsKey(Object obj) {
        return false;
    }

    public final boolean containsValue(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        j.f("value", (Void) obj);
        return false;
    }

    public final Set entrySet() {
        return d0.f10804h;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Set keySet() {
        return d0.f10804h;
    }

    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final String toString() {
        return "{}";
    }

    public final Collection values() {
        return b0.f10801h;
    }
}
