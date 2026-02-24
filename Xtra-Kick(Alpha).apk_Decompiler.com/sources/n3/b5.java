package n3;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;
import xa.q;

public final class b5 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public q f11067i;

    /* renamed from: j  reason: collision with root package name */
    public int f11068j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ c5 f11069k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b5(c5 c5Var, e eVar) {
        super(2, eVar);
        this.f11069k = c5Var;
    }

    public final e create(Object obj, e eVar) {
        return new b5(this.f11069k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((b5) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        q qVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11068j;
        c5 c5Var = this.f11069k;
        if (i10 == 0) {
            h0.O1(obj);
            q qVar2 = new q();
            s5 s5Var = c5Var.f11096d;
            a5 a5Var = new a5(c5Var, qVar2, (e) null);
            this.f11067i = qVar2;
            this.f11068j = 1;
            if (s5Var.a(2, a5Var, this) == aVar) {
                return aVar;
            }
            qVar = qVar2;
        } else if (i10 == 1) {
            qVar = this.f11067i;
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (qVar.f16814h) {
            int i11 = c5.f11092e;
            c5Var.getClass();
            h0.b1(c5Var.f11093a, (h) null, 0, new y4(c5Var, (e) null), 3);
        }
        return v.f9814a;
    }
}
