package j3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import q.l;
import xa.j;
import ya.a;

public final class g1 implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public int f8536h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8537i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ h1 f8538j;

    public g1(h1 h1Var) {
        this.f8538j = h1Var;
    }

    public final boolean hasNext() {
        if (this.f8536h + 1 < this.f8538j.f8557r.g()) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (hasNext()) {
            this.f8537i = true;
            l lVar = this.f8538j.f8557r;
            int i10 = this.f8536h + 1;
            this.f8536h = i10;
            Object h10 = lVar.h(i10);
            j.e("nodes.valueAt(++index)", h10);
            return (c1) h10;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        if (this.f8537i) {
            l lVar = this.f8538j.f8557r;
            ((c1) lVar.h(this.f8536h)).f8507i = null;
            int i10 = this.f8536h;
            Object[] objArr = lVar.f13085j;
            Object obj = objArr[i10];
            Object obj2 = l.f13082l;
            if (obj != obj2) {
                objArr[i10] = obj2;
                lVar.f13083h = true;
            }
            this.f8536h = i10 - 1;
            this.f8537i = false;
            return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element".toString());
    }
}
