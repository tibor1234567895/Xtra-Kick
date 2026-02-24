package n3;

import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.a;
import wa.l;

public final class p3 extends i implements l {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a f11407i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p3(a aVar, e eVar) {
        super(1, eVar);
        this.f11407i = aVar;
    }

    public final e create(e eVar) {
        return new p3(this.f11407i, eVar);
    }

    public final Object invoke(Object obj) {
        return ((p3) create((e) obj)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        return this.f11407i.b();
    }
}
