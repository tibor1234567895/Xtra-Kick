package n3;

import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11224i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11225j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ d5 f11226k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ g3 f11227l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ h1 f11228m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h2(d5 d5Var, g3 g3Var, h1 h1Var, e eVar) {
        super(2, eVar);
        this.f11226k = d5Var;
        this.f11227l = g3Var;
        this.f11228m = h1Var;
    }

    public final e create(Object obj, e eVar) {
        h2 h2Var = new h2(this.f11226k, this.f11227l, this.f11228m, eVar);
        h2Var.f11225j = obj;
        return h2Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((h2) create((k5) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11224i;
        if (i10 == 0) {
            h0.O1(obj);
            kb.i G1 = h0.G1(new g2(((c5) this.f11226k).f11095c.f11098b, this.f11227l.f11207n, (e) null, this.f11228m));
            y1 y1Var = new y1((k5) this.f11225j, 1);
            this.f11224i = 1;
            if (G1.b(y1Var, this) == aVar) {
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
