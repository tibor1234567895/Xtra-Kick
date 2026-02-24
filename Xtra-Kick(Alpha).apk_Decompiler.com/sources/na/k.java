package na;

import java.util.Collection;
import java.util.Iterator;
import ma.g;
import xa.j;

public final class k extends g {

    /* renamed from: h  reason: collision with root package name */
    public final h f11794h;

    public k(h hVar) {
        j.f("backing", hVar);
        this.f11794h = hVar;
    }

    public final int a() {
        return this.f11794h.f11787o;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        j.f("elements", collection);
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.f11794h.clear();
    }

    public final boolean contains(Object obj) {
        return this.f11794h.containsValue(obj);
    }

    public final boolean isEmpty() {
        return this.f11794h.isEmpty();
    }

    public final Iterator iterator() {
        h hVar = this.f11794h;
        hVar.getClass();
        return new e(hVar, 2);
    }

    public final boolean remove(Object obj) {
        int i10;
        h hVar = this.f11794h;
        hVar.b();
        int i11 = hVar.f11785m;
        while (true) {
            i10 = -1;
            i11--;
            if (i11 < 0) {
                break;
            } else if (hVar.f11782j[i11] >= 0) {
                Object[] objArr = hVar.f11781i;
                j.c(objArr);
                if (j.a(objArr[i11], obj)) {
                    i10 = i11;
                    break;
                }
            }
        }
        if (i10 < 0) {
            return false;
        }
        hVar.i(i10);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        j.f("elements", collection);
        this.f11794h.b();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        j.f("elements", collection);
        this.f11794h.b();
        return super.retainAll(collection);
    }
}
