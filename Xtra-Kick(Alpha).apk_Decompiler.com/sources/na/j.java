package na;

import java.util.Collection;
import java.util.Iterator;
import ma.i;

public final class j extends i {

    /* renamed from: h  reason: collision with root package name */
    public final h f11793h;

    public j(h hVar) {
        xa.j.f("backing", hVar);
        this.f11793h = hVar;
    }

    public final int a() {
        return this.f11793h.f11787o;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        xa.j.f("elements", collection);
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.f11793h.clear();
    }

    public final boolean contains(Object obj) {
        return this.f11793h.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.f11793h.isEmpty();
    }

    public final Iterator iterator() {
        h hVar = this.f11793h;
        hVar.getClass();
        return new e(hVar, 1);
    }

    public final boolean remove(Object obj) {
        h hVar = this.f11793h;
        hVar.b();
        int f10 = hVar.f(obj);
        if (f10 < 0) {
            f10 = -1;
        } else {
            hVar.i(f10);
        }
        if (f10 >= 0) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(Collection collection) {
        xa.j.f("elements", collection);
        this.f11793h.b();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        xa.j.f("elements", collection);
        this.f11793h.b();
        return super.retainAll(collection);
    }
}
