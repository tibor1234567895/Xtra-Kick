package lb;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import wa.q;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9839i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ n f9840j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ kb.j f9841k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f9842l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(n nVar, kb.j jVar, Object obj, e eVar) {
        super(2, eVar);
        this.f9840j = nVar;
        this.f9841k = jVar;
        this.f9842l = obj;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f9840j, this.f9841k, this.f9842l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9839i;
        if (i10 == 0) {
            h0.O1(obj);
            q qVar = this.f9840j.f9856l;
            this.f9839i = 1;
            if (qVar.e(this.f9841k, this.f9842l, this) == aVar) {
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
