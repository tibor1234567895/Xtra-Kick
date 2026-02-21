package eb;

import java.util.Iterator;
import q.m;
import xa.j;

public final class b implements h, c {

    /* renamed from: a  reason: collision with root package name */
    public final h f5331a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5332b;

    public b(h hVar, int i10) {
        j.f("sequence", hVar);
        this.f5331a = hVar;
        this.f5332b = i10;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
        }
    }

    public final h a(int i10) {
        int i11 = this.f5332b + i10;
        return i11 < 0 ? new b(this, i10) : new b(this.f5331a, i11);
    }

    public final Iterator iterator() {
        return new m(this);
    }
}
