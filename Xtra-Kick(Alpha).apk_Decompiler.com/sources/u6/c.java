package u6;

import h3.b0;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class c extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ d f15367i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(d dVar, e eVar) {
        super(2, eVar);
        this.f15367i = dVar;
    }

    public final e create(Object obj, e eVar) {
        return new c(this.f15367i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((c) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        long j10;
        h0.O1(obj);
        b bVar = d.I0;
        b0 s02 = this.f15367i.s0();
        if (s02 != null) {
            j10 = s02.j();
        } else {
            j10 = 0;
        }
        return new Double(((double) j10) / 1000.0d);
    }
}
