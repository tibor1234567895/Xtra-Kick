package d9;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class p extends n implements List {

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ b f4643m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(b bVar, Object obj, List list, n nVar) {
        super(bVar, obj, list, nVar);
        this.f4643m = bVar;
    }

    public final void add(int i10, Object obj) {
        b();
        boolean isEmpty = this.f4635i.isEmpty();
        ((List) this.f4635i).add(i10, obj);
        this.f4643m.f4593m++;
        if (isEmpty) {
            a();
        }
    }

    public final boolean addAll(int i10, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.f4635i).addAll(i10, collection);
        if (addAll) {
            this.f4643m.f4593m += this.f4635i.size() - size;
            if (size == 0) {
                a();
            }
        }
        return addAll;
    }

    public final Object get(int i10) {
        b();
        return ((List) this.f4635i).get(i10);
    }

    public final int indexOf(Object obj) {
        b();
        return ((List) this.f4635i).indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        b();
        return ((List) this.f4635i).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        b();
        return new o(this);
    }

    public final Object remove(int i10) {
        b();
        Object remove = ((List) this.f4635i).remove(i10);
        b bVar = this.f4643m;
        bVar.f4593m--;
        c();
        return remove;
    }

    public final Object set(int i10, Object obj) {
        b();
        return ((List) this.f4635i).set(i10, obj);
    }

    public final List subList(int i10, int i11) {
        b();
        List subList = ((List) this.f4635i).subList(i10, i11);
        n nVar = this.f4636j;
        if (nVar == null) {
            nVar = this;
        }
        b bVar = this.f4643m;
        bVar.getClass();
        boolean z10 = subList instanceof RandomAccess;
        Object obj = this.f4634h;
        if (z10) {
            return new k(bVar, obj, subList, nVar);
        }
        return new p(bVar, obj, subList, nVar);
    }

    public final ListIterator listIterator(int i10) {
        b();
        return new o(this, i10);
    }
}
