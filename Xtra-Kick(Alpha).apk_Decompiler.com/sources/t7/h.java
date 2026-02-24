package t7;

import cc.g;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14690i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f14691j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(k kVar, e eVar) {
        super(2, eVar);
        this.f14691j = kVar;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f14691j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14690i;
        k kVar = this.f14691j;
        if (i10 == 0) {
            h0.O1(obj);
            kVar.f14709h = false;
            g gVar = kVar.f14708g;
            if (gVar != null) {
                gVar.b(1000, (String) null);
            }
            this.f14690i = 1;
            if (h0.L(1000, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kVar.b();
        return v.f9814a;
    }
}
