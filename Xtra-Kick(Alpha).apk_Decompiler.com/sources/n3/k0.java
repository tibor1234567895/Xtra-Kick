package n3;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import wa.q;
import xa.u;

public final class k0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11274i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11275j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ kb.i f11276k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ q f11277l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(kb.i iVar, q qVar, e eVar) {
        super(2, eVar);
        this.f11276k = iVar;
        this.f11277l = qVar;
    }

    public final e create(Object obj, e eVar) {
        k0 k0Var = new k0(this.f11276k, this.f11277l, eVar);
        k0Var.f11275j = obj;
        return k0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((k0) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11274i;
        if (i10 == 0) {
            h0.O1(obj);
            u uVar = new u();
            uVar.f16818h = q0.f11419a;
            j0 j0Var = new j0(uVar, this.f11277l, (j) this.f11275j);
            this.f11274i = 1;
            if (this.f11276k.b(j0Var, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
