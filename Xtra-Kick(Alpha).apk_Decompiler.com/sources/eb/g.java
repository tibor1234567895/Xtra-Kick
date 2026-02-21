package eb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import wa.l;
import xa.j;
import ya.a;

public final class g implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public Object f5342h;

    /* renamed from: i  reason: collision with root package name */
    public int f5343i = -2;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ r f5344j;

    public g(r rVar) {
        this.f5344j = rVar;
    }

    public final void a() {
        Object obj;
        int i10;
        int i11 = this.f5343i;
        r rVar = this.f5344j;
        if (i11 == -2) {
            obj = ((wa.a) rVar.f5352b).b();
        } else {
            l lVar = rVar.f5353c;
            Object obj2 = this.f5342h;
            j.c(obj2);
            obj = lVar.invoke(obj2);
        }
        this.f5342h = obj;
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = 1;
        }
        this.f5343i = i10;
    }

    public final boolean hasNext() {
        if (this.f5343i < 0) {
            a();
        }
        return this.f5343i == 1;
    }

    public final Object next() {
        if (this.f5343i < 0) {
            a();
        }
        if (this.f5343i != 0) {
            Object obj = this.f5342h;
            j.d("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence", obj);
            this.f5343i = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
