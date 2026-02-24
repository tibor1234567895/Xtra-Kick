package lb;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class b0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9822i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9823j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j f9824k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(j jVar, e eVar) {
        super(2, eVar);
        this.f9824k = jVar;
    }

    public final e create(Object obj, e eVar) {
        b0 b0Var = new b0(this.f9824k, eVar);
        b0Var.f9823j = obj;
        return b0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((b0) create(obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9822i;
        if (i10 == 0) {
            h0.O1(obj);
            Object obj2 = this.f9823j;
            this.f9822i = 1;
            if (this.f9824k.a(obj2, this) == aVar) {
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
