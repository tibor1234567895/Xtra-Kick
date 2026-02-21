package n3;

import hb.h0;
import la.g;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.l;
import xa.q;

public final class a5 extends i implements l {

    /* renamed from: i  reason: collision with root package name */
    public int f11048i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ c5 f11049j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ q f11050k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a5(c5 c5Var, q qVar, e eVar) {
        super(1, eVar);
        this.f11049j = c5Var;
        this.f11050k = qVar;
    }

    public final e create(e eVar) {
        return new a5(this.f11049j, this.f11050k, eVar);
    }

    public final Object invoke(Object obj) {
        return ((a5) create((e) obj)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11048i;
        if (i10 == 0) {
            h0.O1(obj);
            c5 c5Var = this.f11049j;
            if (((o4) c5Var.f11095c.a(z4.f11618h)) == null) {
                return v.f9814a;
            }
            this.f11048i = 1;
            obj = c5Var.f11094b.a();
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q4 q4Var = (q4) obj;
        throw new g();
    }
}
