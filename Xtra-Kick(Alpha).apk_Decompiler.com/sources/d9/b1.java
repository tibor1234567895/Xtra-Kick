package d9;

import java.util.Iterator;
import java.util.Map;

public class b1 extends d2 {

    /* renamed from: h  reason: collision with root package name */
    public final Map f4595h;

    public b1(Map map) {
        map.getClass();
        this.f4595h = map;
    }

    public void clear() {
        this.f4595h.clear();
    }

    public final boolean contains(Object obj) {
        return this.f4595h.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.f4595h.isEmpty();
    }

    public Iterator iterator() {
        return new z0(this.f4595h.entrySet().iterator(), 0);
    }

    public boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        this.f4595h.remove(obj);
        return true;
    }

    public final int size() {
        return this.f4595h.size();
    }
}
