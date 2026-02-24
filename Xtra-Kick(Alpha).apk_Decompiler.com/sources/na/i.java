package na;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import xa.j;

public final class i extends a {

    /* renamed from: h  reason: collision with root package name */
    public final h f11792h;

    public i(h hVar) {
        j.f("backing", hVar);
        this.f11792h = hVar;
    }

    public final int a() {
        return this.f11792h.f11787o;
    }

    public final boolean add(Object obj) {
        j.f("element", (Map.Entry) obj);
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        j.f("elements", collection);
        throw new UnsupportedOperationException();
    }

    public final boolean b(Map.Entry entry) {
        j.f("element", entry);
        return this.f11792h.d(entry);
    }

    public final boolean c(Map.Entry entry) {
        j.f("element", entry);
        h hVar = this.f11792h;
        hVar.getClass();
        hVar.b();
        int f10 = hVar.f(entry.getKey());
        if (f10 < 0) {
            return false;
        }
        Object[] objArr = hVar.f11781i;
        j.c(objArr);
        if (!j.a(objArr[f10], entry.getValue())) {
            return false;
        }
        hVar.i(f10);
        return true;
    }

    public final void clear() {
        this.f11792h.clear();
    }

    public final boolean containsAll(Collection collection) {
        j.f("elements", collection);
        return this.f11792h.c(collection);
    }

    public final boolean isEmpty() {
        return this.f11792h.isEmpty();
    }

    public final Iterator iterator() {
        h hVar = this.f11792h;
        hVar.getClass();
        return new e(hVar, 0);
    }

    public final boolean removeAll(Collection collection) {
        j.f("elements", collection);
        this.f11792h.b();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        j.f("elements", collection);
        this.f11792h.b();
        return super.retainAll(collection);
    }
}
