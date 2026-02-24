package n3;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class d3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11108i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g3 f11109j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d1 f11110k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d3(d1 d1Var, g3 g3Var, e eVar) {
        super(2, eVar);
        this.f11109j = g3Var;
        this.f11110k = d1Var;
    }

    public final e create(Object obj, e eVar) {
        return new d3(this.f11110k, this.f11109j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d3) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11108i;
        if (i10 == 0) {
            h0.O1(obj);
            g3 g3Var = this.f11109j;
            c3 c3Var = new c3(g3Var.f11202i.a(this.f11110k), g3Var, 0);
            a3 a3Var = new a3(g3Var, (e) null);
            this.f11108i = 1;
            if (h0.B(c3Var, a3Var, this) == aVar) {
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
