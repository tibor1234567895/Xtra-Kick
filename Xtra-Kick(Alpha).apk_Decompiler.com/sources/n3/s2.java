package n3;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class s2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11473i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ g3 f11474j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k5 f11475k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s2(g3 g3Var, k5 k5Var, e eVar) {
        super(2, eVar);
        this.f11474j = g3Var;
        this.f11475k = k5Var;
    }

    public final e create(Object obj, e eVar) {
        return new s2(this.f11474j, this.f11475k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((s2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11473i;
        if (i10 == 0) {
            h0.O1(obj);
            kb.e D = h0.D(this.f11474j.f11204k);
            y1 y1Var = new y1(this.f11475k, 2);
            this.f11473i = 1;
            if (D.b(y1Var, this) == aVar) {
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
