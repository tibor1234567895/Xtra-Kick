package ma;

import hb.h0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import xa.j;
import ya.a;

public final class d0 implements Set, Serializable, a {

    /* renamed from: h  reason: collision with root package name */
    public static final d0 f10804h = new d0();

    private d0() {
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Void)) {
            return false;
        }
        j.f("element", (Void) obj);
        return false;
    }

    public final boolean containsAll(Collection collection) {
        j.f("elements", collection);
        return collection.isEmpty();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Iterator iterator() {
        return a0.f10798h;
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final Object[] toArray() {
        return h0.P1(this);
    }

    public final String toString() {
        return "[]";
    }

    public final Object[] toArray(Object[] objArr) {
        j.f("array", objArr);
        return h0.Q1(this, objArr);
    }
}
