package ma;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import q.m;

public final class d extends m implements ListIterator {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ f f10803k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(f fVar, int i10) {
        super(2, fVar);
        this.f10803k = fVar;
        c cVar = f.f10810h;
        int a10 = fVar.a();
        cVar.getClass();
        c.b(i10, a10);
        this.f13088i = i10;
    }

    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final boolean hasPrevious() {
        return this.f13088i > 0;
    }

    public final int nextIndex() {
        return this.f13088i;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i10 = this.f13088i - 1;
            this.f13088i = i10;
            return this.f10803k.get(i10);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f13088i - 1;
    }

    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
