package n3;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h5 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11232i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11233j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ p f11234k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h5(p pVar, e eVar) {
        super(2, eVar);
        this.f11234k = pVar;
    }

    public final e create(Object obj, e eVar) {
        h5 h5Var = new h5(this.f11234k, eVar);
        h5Var.f11233j = obj;
        return h5Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((h5) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11232i;
        if (i10 == 0) {
            h0.O1(obj);
            g5 g5Var = new g5((j) this.f11233j, this.f11234k, (e) null);
            this.f11232i = 1;
            if (h0.H(g5Var, this) == aVar) {
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
