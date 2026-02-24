package d9;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class n extends AbstractCollection {

    /* renamed from: h  reason: collision with root package name */
    public final Object f4634h;

    /* renamed from: i  reason: collision with root package name */
    public Collection f4635i;

    /* renamed from: j  reason: collision with root package name */
    public final n f4636j;

    /* renamed from: k  reason: collision with root package name */
    public final Collection f4637k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ b f4638l;

    public n(b bVar, Object obj, Collection collection, n nVar) {
        Collection collection2;
        this.f4638l = bVar;
        this.f4634h = obj;
        this.f4635i = collection;
        this.f4636j = nVar;
        if (nVar == null) {
            collection2 = null;
        } else {
            collection2 = nVar.f4635i;
        }
        this.f4637k = collection2;
    }

    public final void a() {
        n nVar = this.f4636j;
        if (nVar != null) {
            nVar.a();
        } else {
            this.f4638l.f4592l.put(this.f4634h, this.f4635i);
        }
    }

    public final boolean add(Object obj) {
        b();
        boolean isEmpty = this.f4635i.isEmpty();
        boolean add = this.f4635i.add(obj);
        if (add) {
            this.f4638l.f4593m++;
            if (isEmpty) {
                a();
            }
        }
        return add;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f4635i.addAll(collection);
        if (addAll) {
            this.f4638l.f4593m += this.f4635i.size() - size;
            if (size == 0) {
                a();
            }
        }
        return addAll;
    }

    public final void b() {
        Collection collection;
        n nVar = this.f4636j;
        if (nVar != null) {
            nVar.b();
            if (nVar.f4635i != this.f4637k) {
                throw new ConcurrentModificationException();
            }
        } else if (this.f4635i.isEmpty() && (collection = (Collection) this.f4638l.f4592l.get(this.f4634h)) != null) {
            this.f4635i = collection;
        }
    }

    public final void c() {
        n nVar = this.f4636j;
        if (nVar != null) {
            nVar.c();
        } else if (this.f4635i.isEmpty()) {
            this.f4638l.f4592l.remove(this.f4634h);
        }
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.f4635i.clear();
            this.f4638l.f4593m -= size;
            c();
        }
    }

    public final boolean contains(Object obj) {
        b();
        return this.f4635i.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        b();
        return this.f4635i.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        b();
        return this.f4635i.equals(obj);
    }

    public final int hashCode() {
        b();
        return this.f4635i.hashCode();
    }

    public final Iterator iterator() {
        b();
        return new e(this);
    }

    public final boolean remove(Object obj) {
        b();
        boolean remove = this.f4635i.remove(obj);
        if (remove) {
            b bVar = this.f4638l;
            bVar.f4593m--;
            c();
        }
        return remove;
    }

    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f4635i.removeAll(collection);
        if (removeAll) {
            this.f4638l.f4593m += this.f4635i.size() - size;
            c();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.f4635i.retainAll(collection);
        if (retainAll) {
            this.f4638l.f4593m += this.f4635i.size() - size;
            c();
        }
        return retainAll;
    }

    public final int size() {
        b();
        return this.f4635i.size();
    }

    public final String toString() {
        b();
        return this.f4635i.toString();
    }
}
