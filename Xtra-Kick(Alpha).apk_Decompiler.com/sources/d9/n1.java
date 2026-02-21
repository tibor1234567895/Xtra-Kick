package d9;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Map;

public abstract class n1 extends AbstractCollection {
    public abstract t a();

    public final void clear() {
        ((b) a()).h();
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            t a10 = a();
            Object key = entry.getKey();
            Object value = entry.getValue();
            Collection collection = (Collection) a10.a().get(key);
            if (collection == null || !collection.contains(value)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        t a10 = a();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Collection collection = (Collection) a10.a().get(key);
        if (collection == null || !collection.remove(value)) {
            return false;
        }
        return true;
    }

    public final int size() {
        return ((b) a()).f4593m;
    }
}
