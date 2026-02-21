package e6;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class r1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5230i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ z1 f5231j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5232k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r1(z1 z1Var, int i10, e eVar) {
        super(2, eVar);
        this.f5231j = z1Var;
        this.f5232k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new r1(this.f5231j, this.f5232k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((r1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5230i;
        if (i10 == 0) {
            h0.O1(obj);
            x xVar = this.f5231j.f5286d;
            this.f5230i = 1;
            obj = xVar.g(this.f5232k, this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
