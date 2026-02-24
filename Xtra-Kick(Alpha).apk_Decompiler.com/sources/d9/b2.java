package d9;

import c9.q;
import c9.r;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

public class b2 extends AbstractCollection implements Set {

    /* renamed from: h  reason: collision with root package name */
    public final Collection f4596h;

    /* renamed from: i  reason: collision with root package name */
    public final r f4597i;

    public b2(Set set, r rVar) {
        this.f4596h = set;
        this.f4597i = rVar;
    }

    /* renamed from: a */
    public final boolean add(Object obj) {
        if (this.f4597i.apply(obj)) {
            return this.f4596h.add(obj);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public final boolean addAll(Collection collection) {
        for (Object apply : collection) {
            if (!this.f4597i.apply(apply)) {
                throw new IllegalArgumentException();
            }
        }
        return this.f4596h.addAll(collection);
    }

    /* renamed from: c */
    public final void clear() {
        Collection collection = this.f4596h;
        boolean z10 = collection instanceof RandomAccess;
        r rVar = this.f4597i;
        if (!z10 || !(collection instanceof List)) {
            Iterator it = collection.iterator();
            rVar.getClass();
            while (it.hasNext()) {
                if (rVar.apply(it.next())) {
                    it.remove();
                }
            }
            return;
        }
        List list = (List) collection;
        rVar.getClass();
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size()) {
            Object obj = list.get(i10);
            if (!rVar.apply(obj)) {
                if (i10 > i11) {
                    try {
                        list.set(i11, obj);
                    } catch (IllegalArgumentException | UnsupportedOperationException unused) {
                        int size = list.size();
                        while (true) {
                            size--;
                            if (size <= i10) {
                                break;
                            } else if (rVar.apply(list.get(size))) {
                                list.remove(size);
                            }
                        }
                        while (true) {
                            i10--;
                            if (i10 >= i11) {
                                list.remove(i10);
                            } else {
                                return;
                            }
                        }
                    }
                }
                i11++;
            }
            i10++;
        }
        list.subList(i11, list.size()).clear();
    }

    /* renamed from: d */
    public final boolean contains(Object obj) {
        boolean z10;
        Collection collection = this.f4596h;
        collection.getClass();
        try {
            z10 = collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            z10 = false;
        }
        if (z10) {
            return this.f4597i.apply(obj);
        }
        return false;
    }

    /* renamed from: e */
    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return f2.a(this, obj);
    }

    /* renamed from: f */
    public final boolean isEmpty() {
        Iterator it = this.f4596h.iterator();
        r rVar = this.f4597i;
        q.c(rVar, "predicate");
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            } else if (rVar.apply(it.next())) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            z10 = true;
        }
        return true ^ z10;
    }

    /* renamed from: g */
    public final Iterator iterator() {
        Iterator it = this.f4596h.iterator();
        it.getClass();
        r rVar = this.f4597i;
        rVar.getClass();
        return new w0(it, rVar);
    }

    /* renamed from: h */
    public final boolean remove(Object obj) {
        return contains(obj) && this.f4596h.remove(obj);
    }

    public final int hashCode() {
        return f2.c(this);
    }

    /* renamed from: i */
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f4596h.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f4597i.apply(next) && collection.contains(next)) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: j */
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f4596h.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f4597i.apply(next) && !collection.contains(next)) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: k */
    public final int size() {
        int i10 = 0;
        for (Object apply : this.f4596h) {
            if (this.f4597i.apply(apply)) {
                i10++;
            }
        }
        return i10;
    }

    /* renamed from: l */
    public final Object[] toArray() {
        w0 w0Var = (w0) iterator();
        ArrayList arrayList = new ArrayList();
        while (w0Var.hasNext()) {
            arrayList.add(w0Var.next());
        }
        return arrayList.toArray();
    }

    /* renamed from: m */
    public final Object[] toArray(Object[] objArr) {
        w0 w0Var = (w0) iterator();
        ArrayList arrayList = new ArrayList();
        while (w0Var.hasNext()) {
            arrayList.add(w0Var.next());
        }
        return arrayList.toArray(objArr);
    }
}
