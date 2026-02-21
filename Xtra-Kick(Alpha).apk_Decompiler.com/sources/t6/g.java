package t6;

import h3.b0;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14590i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f14591j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(l lVar, e eVar) {
        super(2, eVar);
        this.f14591j = lVar;
    }

    public final e create(Object obj, e eVar) {
        return new g(this.f14591j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f14590i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f14590i = 1;
            if (h0.L(1500, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            b0 s02 = this.f14591j.s0();
            if (s02 != null) {
                s02.e();
            }
        } catch (Exception unused) {
        }
        return v.f9814a;
    }
}
