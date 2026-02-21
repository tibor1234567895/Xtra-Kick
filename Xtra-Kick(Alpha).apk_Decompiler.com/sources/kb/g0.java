package kb;

import h3.u1;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class g0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9310i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9311j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ i f9312k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ k0 f9313l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f9314m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(i iVar, k0 k0Var, Object obj, e eVar) {
        super(2, eVar);
        this.f9312k = iVar;
        this.f9313l = k0Var;
        this.f9314m = obj;
    }

    public final e create(Object obj, e eVar) {
        g0 g0Var = new g0(this.f9312k, this.f9313l, this.f9314m, eVar);
        g0Var.f9311j = obj;
        return g0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((g0) create((v0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9310i;
        if (i10 == 0) {
            h0.O1(obj);
            int ordinal = ((v0) this.f9311j).ordinal();
            k0 k0Var = this.f9313l;
            if (ordinal == 0) {
                this.f9310i = 1;
                if (this.f9312k.b(k0Var, this) == aVar) {
                    return aVar;
                }
            } else if (ordinal == 2) {
                u1 u1Var = t0.f9395a;
                Object obj2 = this.f9314m;
                if (obj2 == u1Var) {
                    k0Var.c();
                } else {
                    k0Var.h(obj2);
                }
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
