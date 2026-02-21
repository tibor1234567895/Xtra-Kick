package eb;

import hb.h0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import la.v;
import pa.e;
import pa.k;
import pa.l;
import xa.j;
import ya.a;

public final class i extends j implements Iterator, e, a {

    /* renamed from: h  reason: collision with root package name */
    public int f5345h;

    /* renamed from: i  reason: collision with root package name */
    public Object f5346i;

    /* renamed from: j  reason: collision with root package name */
    public Iterator f5347j;

    /* renamed from: k  reason: collision with root package name */
    public e f5348k;

    public final void a(Object obj, e eVar) {
        this.f5346i = obj;
        this.f5345h = 3;
        this.f5348k = eVar;
        h0.m1(eVar);
    }

    public final Object b(Iterator it, e eVar) {
        if (!it.hasNext()) {
            return v.f9814a;
        }
        this.f5347j = it;
        this.f5345h = 2;
        this.f5348k = eVar;
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        h0.m1(eVar);
        return aVar;
    }

    public final RuntimeException c() {
        int i10 = this.f5345h;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f5345h);
    }

    public final k getContext() {
        return l.f12754h;
    }

    public final boolean hasNext() {
        while (true) {
            int i10 = this.f5345h;
            if (i10 != 0) {
                if (i10 == 1) {
                    Iterator it = this.f5347j;
                    j.c(it);
                    if (it.hasNext()) {
                        this.f5345h = 2;
                        return true;
                    }
                    this.f5347j = null;
                } else if (i10 == 2 || i10 == 3) {
                    return true;
                } else {
                    if (i10 == 4) {
                        return false;
                    }
                    throw c();
                }
            }
            this.f5345h = 5;
            e eVar = this.f5348k;
            j.c(eVar);
            this.f5348k = null;
            int i11 = la.l.f9802h;
            eVar.resumeWith(v.f9814a);
        }
    }

    public final Object next() {
        int i10 = this.f5345h;
        if (i10 == 0 || i10 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i10 == 2) {
            this.f5345h = 1;
            Iterator it = this.f5347j;
            j.c(it);
            return it.next();
        } else if (i10 == 3) {
            this.f5345h = 0;
            Object obj = this.f5346i;
            this.f5346i = null;
            return obj;
        } else {
            throw c();
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void resumeWith(Object obj) {
        h0.O1(obj);
        this.f5345h = 4;
    }
}
