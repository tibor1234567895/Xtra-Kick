package na;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import ma.i;
import xa.j;

public final class l extends i implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final h f11795h = new h();

    public final int a() {
        return this.f11795h.f11787o;
    }

    public final boolean add(Object obj) {
        return this.f11795h.a(obj) >= 0;
    }

    public final boolean addAll(Collection collection) {
        j.f("elements", collection);
        this.f11795h.b();
        return super.addAll(collection);
    }

    public final void clear() {
        this.f11795h.clear();
    }

    public final boolean contains(Object obj) {
        return this.f11795h.containsKey(obj);
    }

    public final boolean isEmpty() {
        return this.f11795h.isEmpty();
    }

    public final Iterator iterator() {
        h hVar = this.f11795h;
        hVar.getClass();
        return new e(hVar, 1);
    }

    public final boolean remove(Object obj) {
        h hVar = this.f11795h;
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
        j.f("elements", collection);
        this.f11795h.b();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        j.f("elements", collection);
        this.f11795h.b();
        return super.retainAll(collection);
    }
}
