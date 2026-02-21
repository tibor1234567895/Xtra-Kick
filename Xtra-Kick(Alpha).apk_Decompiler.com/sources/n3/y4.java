package n3;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class y4 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11590i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c5 f11591j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y4(c5 c5Var, e eVar) {
        super(2, eVar);
        this.f11591j = c5Var;
    }

    public final e create(Object obj, e eVar) {
        return new y4(this.f11591j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((y4) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11590i;
        if (i10 == 0) {
            h0.O1(obj);
            c5 c5Var = this.f11591j;
            s5 s5Var = c5Var.f11096d;
            x4 x4Var = new x4(c5Var, (e) null);
            this.f11590i = 1;
            if (s5Var.a(1, x4Var, this) == aVar) {
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
