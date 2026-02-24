package q;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class b implements Set {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e f13042h;

    public b(e eVar) {
        this.f13042h = eVar;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.f13042h.clear();
    }

    public final boolean contains(Object obj) {
        return this.f13042h.containsKey(obj);
    }

    public final boolean containsAll(Collection collection) {
        e eVar = this.f13042h;
        eVar.getClass();
        for (Object containsKey : collection) {
            if (!eVar.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public final int hashCode() {
        e eVar = this.f13042h;
        int i10 = 0;
        for (int i11 = eVar.f13081j - 1; i11 >= 0; i11--) {
            Object h10 = eVar.h(i11);
            i10 += h10 == null ? 0 : h10.hashCode();
        }
        return i10;
    }

    public final boolean isEmpty() {
        return this.f13042h.isEmpty();
    }

    public final Iterator iterator() {
        return new a(this.f13042h, 0);
    }

    public final boolean remove(Object obj) {
        e eVar = this.f13042h;
        int e10 = eVar.e(obj);
        if (e10 < 0) {
            return false;
        }
        eVar.j(e10);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        e eVar = this.f13042h;
        int i10 = eVar.f13081j;
        for (Object remove : collection) {
            eVar.remove(remove);
        }
        if (i10 != eVar.f13081j) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(Collection collection) {
        return this.f13042h.m(collection);
    }

    public final int size() {
        return this.f13042h.f13081j;
    }

    public final Object[] toArray() {
        e eVar = this.f13042h;
        int i10 = eVar.f13081j;
        Object[] objArr = new Object[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = eVar.h(i11);
        }
        return objArr;
    }

    public final Object[] toArray(Object[] objArr) {
        return this.f13042h.n(0, objArr);
    }
}
