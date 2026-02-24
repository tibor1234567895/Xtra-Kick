package d9;

import c9.n;
import c9.q;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class r0 extends m0 implements List, RandomAccess {

    /* renamed from: i  reason: collision with root package name */
    public static final p0 f4657i = new p0(0, r1.f4658l);

    public static r1 h(int i10, Object[] objArr) {
        if (i10 == 0) {
            return r1.f4658l;
        }
        return new r1(i10, objArr);
    }

    public static r1 i(Object... objArr) {
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            if (objArr[i10] != null) {
                i10++;
            } else {
                StringBuilder sb2 = new StringBuilder(20);
                sb2.append("at index ");
                sb2.append(i10);
                throw new NullPointerException(sb2.toString());
            }
        }
        return h(objArr.length, objArr);
    }

    public static r0 j(Collection collection) {
        if (!(collection instanceof m0)) {
            return i(collection.toArray());
        }
        r0 a10 = ((m0) collection).a();
        if (!a10.f()) {
            return a10;
        }
        Object[] array = a10.toArray();
        return h(array.length, array);
    }

    public static r1 k(Object[] objArr) {
        if (objArr.length == 0) {
            return r1.f4658l;
        }
        return i((Object[]) objArr.clone());
    }

    public static r1 m(Long l10, Long l11, Long l12, Long l13, Long l14) {
        return i(l10, l11, l12, l13, l14);
    }

    public static r1 n(Object obj) {
        return i(obj);
    }

    public final r0 a() {
        return this;
    }

    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int b(int i10, Object[] objArr) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i10 = 0;
                    while (i10 < size) {
                        if (n.a(get(i10), list.get(i10))) {
                            i10++;
                        }
                    }
                    return true;
                }
                Iterator it = list.iterator();
                for (Object a10 : this) {
                    if (it.hasNext()) {
                        if (!n.a(a10, it.next())) {
                        }
                    }
                }
                return !it.hasNext();
            }
        }
        return false;
    }

    public final i2 g() {
        return listIterator(0);
    }

    public final int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~(get(i11).hashCode() + (i10 * 31)));
        }
        return i10;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    /* renamed from: l */
    public final p0 listIterator(int i10) {
        q.d(i10, size());
        return isEmpty() ? f4657i : new p0(i10, this);
    }

    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    /* renamed from: o */
    public r0 subList(int i10, int i11) {
        q.e(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return r1.f4658l;
        }
        return new q0(this, i10, i12);
    }

    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }
}
