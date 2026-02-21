package x6;

import h3.b0;
import hb.f0;
import hb.h0;
import la.v;
import ra.i;
import wa.p;

public final class e extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f16688i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(h hVar, pa.e eVar) {
        super(2, eVar);
        this.f16688i = hVar;
    }

    public final pa.e create(Object obj, pa.e eVar) {
        return new e(this.f16688i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e) create((f0) obj, (pa.e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        long j10;
        h0.O1(obj);
        d dVar = h.H0;
        b0 s02 = this.f16688i.s0();
        if (s02 != null) {
            j10 = s02.j();
        } else {
            j10 = 0;
        }
        return new Double(((double) j10) / 1000.0d);
    }
}
