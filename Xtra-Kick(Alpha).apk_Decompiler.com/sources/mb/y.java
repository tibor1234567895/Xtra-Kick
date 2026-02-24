package mb;

import hb.a;
import hb.h0;
import pa.e;
import pa.k;
import ra.d;
import wa.l;

public class y extends a implements d {

    /* renamed from: k  reason: collision with root package name */
    public final e f10888k;

    public y(e eVar, k kVar) {
        super(kVar, true);
        this.f10888k = eVar;
    }

    public final boolean O() {
        return true;
    }

    public final d getCallerFrame() {
        e eVar = this.f10888k;
        if (eVar instanceof d) {
            return (d) eVar;
        }
        return null;
    }

    public void p(Object obj) {
        j.a(qa.d.b(this.f10888k), h0.r1(obj), (l) null);
    }

    public void q(Object obj) {
        this.f10888k.resumeWith(h0.r1(obj));
    }
}
