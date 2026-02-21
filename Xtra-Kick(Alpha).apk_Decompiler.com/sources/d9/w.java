package d9;

import c9.n;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import q.c;
import q.e;

public final class w extends AbstractSet {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4686h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Map f4687i;

    public /* synthetic */ w(int i10, Map map) {
        this.f4686h = i10;
        this.f4687i = map;
    }

    public final void clear() {
        int i10 = this.f4686h;
        Map map = this.f4687i;
        switch (i10) {
            case 0:
                ((z) map).clear();
                return;
            case 1:
                ((z) map).clear();
                return;
            default:
                super.clear();
                return;
        }
    }

    public final boolean contains(Object obj) {
        int i10 = this.f4686h;
        Map map = this.f4687i;
        switch (i10) {
            case 0:
                z zVar = (z) map;
                Map a10 = zVar.a();
                if (a10 != null) {
                    return a10.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int b10 = zVar.b(entry.getKey());
                    if (b10 == -1 || !n.a(zVar.k(b10), entry.getValue())) {
                        return false;
                    }
                    return true;
                }
                return false;
            case 1:
                return ((z) map).containsKey(obj);
            default:
                return super.contains(obj);
        }
    }

    public final Iterator iterator() {
        int i10 = this.f4686h;
        Map map = this.f4687i;
        switch (i10) {
            case 0:
                z zVar = (z) map;
                Map a10 = zVar.a();
                if (a10 != null) {
                    return a10.entrySet().iterator();
                }
                return new v(zVar, 1);
            case 1:
                z zVar2 = (z) map;
                Map a11 = zVar2.a();
                if (a11 != null) {
                    return a11.keySet().iterator();
                }
                return new v(zVar2, 0);
            default:
                return new c((e) map);
        }
    }

    public final boolean remove(Object obj) {
        int i10 = this.f4686h;
        Map map = this.f4687i;
        switch (i10) {
            case 0:
                z zVar = (z) map;
                Map a10 = zVar.a();
                if (a10 != null) {
                    return a10.entrySet().remove(obj);
                }
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (zVar.e()) {
                    return false;
                }
                int i11 = (1 << (zVar.f4719l & 31)) - 1;
                Object key = entry.getKey();
                Object value = entry.getValue();
                Object obj2 = zVar.f4715h;
                Objects.requireNonNull(obj2);
                int c10 = a0.c(key, value, i11, obj2, zVar.g(), zVar.h(), zVar.i());
                if (c10 == -1) {
                    return false;
                }
                zVar.d(c10, i11);
                zVar.f4720m--;
                zVar.f4719l += 32;
                return true;
            case 1:
                z zVar2 = (z) map;
                Map a11 = zVar2.a();
                if (a11 != null) {
                    return a11.keySet().remove(obj);
                }
                if (zVar2.f(obj) != z.f4714q) {
                    return true;
                }
                return false;
            default:
                return super.remove(obj);
        }
    }

    public final int size() {
        int i10 = this.f4686h;
        Map map = this.f4687i;
        switch (i10) {
            case 0:
                return ((z) map).size();
            case 1:
                return ((z) map).size();
            default:
                return ((e) map).f13081j;
        }
    }
}
