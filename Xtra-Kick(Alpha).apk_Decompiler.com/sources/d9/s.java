package d9;

import c9.n;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public final class s extends AbstractCollection {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4661h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f4662i;

    public /* synthetic */ s(int i10, Object obj) {
        this.f4661h = i10;
        this.f4662i = obj;
    }

    public final void clear() {
        int i10 = this.f4661h;
        Object obj = this.f4662i;
        switch (i10) {
            case 0:
                ((b) ((t) obj)).h();
                return;
            case 1:
                ((z) obj).clear();
                return;
            default:
                ((Map) obj).clear();
                return;
        }
    }

    public final boolean contains(Object obj) {
        int i10 = this.f4661h;
        Object obj2 = this.f4662i;
        switch (i10) {
            case 0:
                for (Collection contains : ((t) obj2).a().values()) {
                    if (contains.contains(obj)) {
                        return true;
                    }
                }
                return false;
            case 2:
                return ((Map) obj2).containsValue(obj);
            default:
                return super.contains(obj);
        }
    }

    public final boolean isEmpty() {
        switch (this.f4661h) {
            case 2:
                return ((Map) this.f4662i).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    public final Iterator iterator() {
        int i10 = this.f4661h;
        Object obj = this.f4662i;
        switch (i10) {
            case 0:
                return ((t) obj).g();
            case 1:
                z zVar = (z) obj;
                Map a10 = zVar.a();
                if (a10 != null) {
                    return a10.values().iterator();
                }
                return new v(zVar, 2);
            default:
                return new z0(((Map) obj).entrySet().iterator(), 1);
        }
    }

    public final boolean remove(Object obj) {
        switch (this.f4661h) {
            case 2:
                try {
                    return super.remove(obj);
                } catch (UnsupportedOperationException unused) {
                    Map map = (Map) this.f4662i;
                    for (Map.Entry entry : map.entrySet()) {
                        if (n.a(obj, entry.getValue())) {
                            map.remove(entry.getKey());
                            return true;
                        }
                    }
                    return false;
                }
            default:
                return super.remove(obj);
        }
    }

    public final boolean removeAll(Collection collection) {
        switch (this.f4661h) {
            case 2:
                try {
                    collection.getClass();
                    return super.removeAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    Map map = (Map) this.f4662i;
                    for (Map.Entry entry : map.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return map.keySet().removeAll(hashSet);
                }
            default:
                return super.removeAll(collection);
        }
    }

    public final boolean retainAll(Collection collection) {
        switch (this.f4661h) {
            case 2:
                try {
                    collection.getClass();
                    return super.retainAll(collection);
                } catch (UnsupportedOperationException unused) {
                    HashSet hashSet = new HashSet();
                    Map map = (Map) this.f4662i;
                    for (Map.Entry entry : map.entrySet()) {
                        if (collection.contains(entry.getValue())) {
                            hashSet.add(entry.getKey());
                        }
                    }
                    return map.keySet().retainAll(hashSet);
                }
            default:
                return super.retainAll(collection);
        }
    }

    public final int size() {
        int i10 = this.f4661h;
        Object obj = this.f4662i;
        switch (i10) {
            case 0:
                return ((b) ((t) obj)).f4593m;
            case 1:
                return ((z) obj).size();
            default:
                return ((Map) obj).size();
        }
    }

    public s(Map map) {
        this.f4661h = 2;
        map.getClass();
        this.f4662i = map;
    }
}
