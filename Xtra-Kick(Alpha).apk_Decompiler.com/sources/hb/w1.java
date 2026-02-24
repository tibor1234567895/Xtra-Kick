package hb;

import la.l;
import la.v;
import mb.j;
import pa.e;
import pa.k;
import qa.d;
import wa.p;

public final class w1 extends c2 {

    /* renamed from: k  reason: collision with root package name */
    public final e f7879k;

    public w1(k kVar, p pVar) {
        super(kVar, false);
        this.f7879k = d.a(this, this, pVar);
    }

    public final void V() {
        try {
            e b10 = d.b(this.f7879k);
            int i10 = l.f9802h;
            j.a(b10, v.f9814a, (wa.l) null);
        } catch (Throwable th) {
            int i11 = l.f9802h;
            resumeWith(h0.I(th));
            throw th;
        }
    }
}
