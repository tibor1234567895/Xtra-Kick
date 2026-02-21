package d9;

import c9.q;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class x implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public int f4695h;

    /* renamed from: i  reason: collision with root package name */
    public int f4696i;

    /* renamed from: j  reason: collision with root package name */
    public int f4697j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ z f4698k;

    public x(z zVar) {
        int i10;
        this.f4698k = zVar;
        this.f4695h = zVar.f4719l;
        if (zVar.isEmpty()) {
            i10 = -1;
        } else {
            i10 = 0;
        }
        this.f4696i = i10;
        this.f4697j = -1;
    }

    public final boolean hasNext() {
        return this.f4696i >= 0;
    }

    public final Object next() {
        Object obj;
        z zVar = this.f4698k;
        if (zVar.f4719l != this.f4695h) {
            throw new ConcurrentModificationException();
        } else if (hasNext()) {
            int i10 = this.f4696i;
            this.f4697j = i10;
            v vVar = (v) this;
            int i11 = vVar.f4681l;
            z zVar2 = vVar.f4682m;
            switch (i11) {
                case 0:
                    obj = zVar2.c(i10);
                    break;
                case 1:
                    obj = new y(zVar2, i10);
                    break;
                default:
                    obj = zVar2.k(i10);
                    break;
            }
            int i12 = this.f4696i + 1;
            if (i12 >= zVar.f4720m) {
                i12 = -1;
            }
            this.f4696i = i12;
            return obj;
        } else {
            throw new NoSuchElementException();
        }
    }

    public final void remove() {
        boolean z10;
        z zVar = this.f4698k;
        if (zVar.f4719l == this.f4695h) {
            if (this.f4697j >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            q.f("no calls to next() since the last call to remove()", z10);
            this.f4695h += 32;
            zVar.remove(zVar.c(this.f4697j));
            this.f4696i--;
            this.f4697j = -1;
            return;
        }
        throw new ConcurrentModificationException();
    }
}
