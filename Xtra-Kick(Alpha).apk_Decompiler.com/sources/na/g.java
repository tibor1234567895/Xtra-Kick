package na;

import xa.j;

public abstract class g {

    /* renamed from: h  reason: collision with root package name */
    public final h f11776h;

    /* renamed from: i  reason: collision with root package name */
    public int f11777i;

    /* renamed from: j  reason: collision with root package name */
    public int f11778j = -1;

    public g(h hVar) {
        j.f("map", hVar);
        this.f11776h = hVar;
        a();
    }

    public final void a() {
        while (true) {
            int i10 = this.f11777i;
            h hVar = this.f11776h;
            if (i10 < hVar.f11785m && hVar.f11782j[i10] < 0) {
                this.f11777i = i10 + 1;
            } else {
                return;
            }
        }
    }

    public final boolean hasNext() {
        if (this.f11777i < this.f11776h.f11785m) {
            return true;
        }
        return false;
    }

    public final void remove() {
        boolean z10;
        if (this.f11778j != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            h hVar = this.f11776h;
            hVar.b();
            hVar.i(this.f11778j);
            this.f11778j = -1;
            return;
        }
        throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
    }
}
