package n3;

import hb.f0;
import hb.h0;
import jb.g;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class x2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11560i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11561j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f11562k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g3 f11563l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x2(g3 g3Var, e eVar, g gVar) {
        super(2, eVar);
        this.f11562k = gVar;
        this.f11563l = g3Var;
    }

    public final e create(Object obj, e eVar) {
        x2 x2Var = new x2(this.f11563l, eVar, this.f11562k);
        x2Var.f11561j = obj;
        return x2Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((x2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11560i;
        if (i10 == 0) {
            h0.O1(obj);
            kb.e D = h0.D(this.f11562k);
            w2 w2Var = new w2(this.f11563l, (f0) this.f11561j);
            this.f11560i = 1;
            if (D.b(w2Var, this) == aVar) {
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
