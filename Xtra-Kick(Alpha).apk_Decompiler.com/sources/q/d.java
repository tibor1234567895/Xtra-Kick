package q;

import java.util.Collection;
import java.util.Iterator;

public final class d implements Collection {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e f13047h;

    public d(e eVar) {
        this.f13047h = eVar;
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        this.f13047h.clear();
    }

    public final boolean contains(Object obj) {
        return this.f13047h.g(obj) >= 0;
    }

    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isEmpty() {
        return this.f13047h.isEmpty();
    }

    public final Iterator iterator() {
        return new a(this.f13047h, 1);
    }

    public final boolean remove(Object obj) {
        e eVar = this.f13047h;
        int g10 = eVar.g(obj);
        if (g10 < 0) {
            return false;
        }
        eVar.j(g10);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        e eVar = this.f13047h;
        int i10 = eVar.f13081j;
        int i11 = 0;
        boolean z10 = false;
        while (i11 < i10) {
            if (collection.contains(eVar.l(i11))) {
                eVar.j(i11);
                i11--;
                i10--;
                z10 = true;
            }
            i11++;
        }
        return z10;
    }

    public final boolean retainAll(Collection collection) {
        e eVar = this.f13047h;
        int i10 = eVar.f13081j;
        int i11 = 0;
        boolean z10 = false;
        while (i11 < i10) {
            if (!collection.contains(eVar.l(i11))) {
                eVar.j(i11);
                i11--;
                i10--;
                z10 = true;
            }
            i11++;
        }
        return z10;
    }

    public final int size() {
        return this.f13047h.f13081j;
    }

    public final Object[] toArray() {
        e eVar = this.f13047h;
        int i10 = eVar.f13081j;
        Object[] objArr = new Object[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = eVar.l(i11);
        }
        return objArr;
    }

    public final Object[] toArray(Object[] objArr) {
        return this.f13047h.n(1, objArr);
    }
}
