package ma;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import q.m;
import xa.j;

public abstract class f extends a implements List {

    /* renamed from: h  reason: collision with root package name */
    public static final c f10810h = new c(0);

    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        Collection collection = (Collection) obj;
        f10810h.getClass();
        j.f("other", collection);
        if (size() != collection.size()) {
            return false;
        }
        Iterator it = collection.iterator();
        for (Object a10 : this) {
            if (!j.a(a10, it.next())) {
            }
        }
        return true;
        return false;
    }

    public final int hashCode() {
        int i10;
        f10810h.getClass();
        int i11 = 1;
        for (Object next : this) {
            int i12 = i11 * 31;
            if (next != null) {
                i10 = next.hashCode();
            } else {
                i10 = 0;
            }
            i11 = i12 + i10;
        }
        return i11;
    }

    public int indexOf(Object obj) {
        int i10 = 0;
        for (Object a10 : this) {
            if (j.a(a10, obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public Iterator iterator() {
        return new m(2, this);
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (j.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public final ListIterator listIterator() {
        return new d(this, 0);
    }

    public final Object remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final List subList(int i10, int i11) {
        return new e(this, i10, i11);
    }

    public final ListIterator listIterator(int i10) {
        return new d(this, i10);
    }
}
