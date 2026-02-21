package d9;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class f0 extends g0 implements Map {
    /* renamed from: c */
    public abstract Map b();

    public final void clear() {
        b().clear();
    }

    public boolean containsKey(Object obj) {
        return b().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return b().containsValue(obj);
    }

    public Set entrySet() {
        return b().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    public Object get(Object obj) {
        return b().get(obj);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public boolean isEmpty() {
        return b().isEmpty();
    }

    public Set keySet() {
        return b().keySet();
    }

    public final Object put(Object obj, Object obj2) {
        return b().put(obj, obj2);
    }

    public final void putAll(Map map) {
        b().putAll(map);
    }

    public final Object remove(Object obj) {
        return b().remove(obj);
    }

    public int size() {
        return b().size();
    }

    public final Collection values() {
        return b().values();
    }
}
