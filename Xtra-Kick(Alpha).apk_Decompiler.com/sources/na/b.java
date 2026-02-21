package na;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import xa.j;
import ya.a;

public final class b implements ListIterator, a {

    /* renamed from: h  reason: collision with root package name */
    public final c f11764h;

    /* renamed from: i  reason: collision with root package name */
    public int f11765i;

    /* renamed from: j  reason: collision with root package name */
    public int f11766j = -1;

    public b(c cVar, int i10) {
        j.f("list", cVar);
        this.f11764h = cVar;
        this.f11765i = i10;
    }

    public final void add(Object obj) {
        int i10 = this.f11765i;
        this.f11765i = i10 + 1;
        this.f11764h.add(i10, obj);
        this.f11766j = -1;
    }

    public final boolean hasNext() {
        if (this.f11765i < this.f11764h.f11769j) {
            return true;
        }
        return false;
    }

    public final boolean hasPrevious() {
        return this.f11765i > 0;
    }

    public final Object next() {
        int i10 = this.f11765i;
        c cVar = this.f11764h;
        if (i10 < cVar.f11769j) {
            this.f11765i = i10 + 1;
            this.f11766j = i10;
            return cVar.f11767h[cVar.f11768i + i10];
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f11765i;
    }

    public final Object previous() {
        int i10 = this.f11765i;
        if (i10 > 0) {
            int i11 = i10 - 1;
            this.f11765i = i11;
            this.f11766j = i11;
            c cVar = this.f11764h;
            return cVar.f11767h[cVar.f11768i + i11];
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f11765i - 1;
    }

    public final void remove() {
        boolean z10;
        int i10 = this.f11766j;
        if (i10 != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f11764h.b(i10);
            this.f11765i = this.f11766j;
            this.f11766j = -1;
            return;
        }
        throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
    }

    public final void set(Object obj) {
        int i10 = this.f11766j;
        if (i10 != -1) {
            this.f11764h.set(i10, obj);
            return;
        }
        throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
    }
}
