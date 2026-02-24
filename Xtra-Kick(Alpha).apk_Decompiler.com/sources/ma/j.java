package ma;

import hb.h0;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import q.m;
import ya.a;

public final class j implements Collection, a {

    /* renamed from: h  reason: collision with root package name */
    public final Object[] f10811h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10812i;

    public j(Object[] objArr, boolean z10) {
        xa.j.f("values", objArr);
        this.f10811h = objArr;
        this.f10812i = z10;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean contains(Object obj) {
        return p.g(this.f10811h, obj);
    }

    public final boolean containsAll(Collection collection) {
        xa.j.f("elements", collection);
        if (collection.isEmpty()) {
            return true;
        }
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.f10811h.length == 0;
    }

    public final Iterator iterator() {
        Object[] objArr = this.f10811h;
        xa.j.f("array", objArr);
        return new m(objArr);
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

    public final int size() {
        return this.f10811h.length;
    }

    public final Object[] toArray() {
        Object[] objArr = this.f10811h;
        xa.j.f("<this>", objArr);
        Class<Object[]> cls = Object[].class;
        if (this.f10812i && xa.j.a(objArr.getClass(), cls)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, cls);
        xa.j.e("copyOf(this, this.size, Array<Any?>::class.java)", copyOf);
        return copyOf;
    }

    public final Object[] toArray(Object[] objArr) {
        xa.j.f("array", objArr);
        return h0.Q1(this, objArr);
    }
}
