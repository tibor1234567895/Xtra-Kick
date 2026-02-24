package d9;

import c9.n;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public abstract class a1 extends d2 {
    public abstract Map a();

    public final void clear() {
        a().clear();
    }

    public boolean contains(Object obj) {
        Object obj2;
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Map a10 = a();
            a10.getClass();
            try {
                obj2 = a10.get(key);
            } catch (ClassCastException | NullPointerException unused) {
                obj2 = null;
            }
            if (!n.a(obj2, entry.getValue()) || (obj2 == null && !a().containsKey(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        return a().isEmpty();
    }

    public boolean remove(Object obj) {
        if (!contains(obj) || !(obj instanceof Map.Entry)) {
            return false;
        }
        return a().keySet().remove(((Map.Entry) obj).getKey());
    }

    public final boolean removeAll(Collection collection) {
        try {
            collection.getClass();
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            boolean z10 = false;
            for (Object remove : collection) {
                z10 |= remove(remove);
            }
            return z10;
        }
    }

    public final boolean retainAll(Collection collection) {
        int i10;
        try {
            collection.getClass();
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            int size = collection.size();
            if (size < 3) {
                u.a(size, "expectedSize");
                i10 = size + 1;
            } else if (size < 1073741824) {
                i10 = (int) ((((float) size) / 0.75f) + 1.0f);
            } else {
                i10 = Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(i10);
            for (Object next : collection) {
                if (contains(next) && (next instanceof Map.Entry)) {
                    hashSet.add(((Map.Entry) next).getKey());
                }
            }
            return a().keySet().retainAll(hashSet);
        }
    }

    public final int size() {
        return a().size();
    }
}
