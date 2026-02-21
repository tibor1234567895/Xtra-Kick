package kb;

import hb.h0;
import la.c;
import la.v;
import n3.k2;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.q;

public final class a1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9265i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9266j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ c1 f9267k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a1(c1 c1Var, e eVar) {
        super(2, eVar);
        this.f9267k = c1Var;
    }

    public final e create(Object obj, e eVar) {
        a1 a1Var = new a1(this.f9267k, eVar);
        a1Var.f9266j = obj;
        return a1Var;
    }

    public final Object g(Object obj, Object obj2) {
        ((a1) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
        return a.COROUTINE_SUSPENDED;
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9265i;
        if (i10 == 0) {
            h0.O1(obj);
            k2 k2Var = new k2(new q(), 3, (j) this.f9266j);
            this.f9265i = 1;
            if (this.f9267k.b(k2Var, this) == aVar) {
                return aVar;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            h0.O1(obj);
        }
        throw new c();
    }
}
