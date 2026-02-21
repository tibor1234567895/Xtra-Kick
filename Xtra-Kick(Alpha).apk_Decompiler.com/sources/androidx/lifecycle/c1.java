package androidx.lifecycle;

import hb.f0;
import hb.h0;
import hb.p0;
import hb.x1;
import la.v;
import mb.u;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class c1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f1666i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f1667j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ t f1668k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ s f1669l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ p f1670m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c1(t tVar, s sVar, p pVar, e eVar) {
        super(2, eVar);
        this.f1668k = tVar;
        this.f1669l = sVar;
        this.f1670m = pVar;
    }

    public final e create(Object obj, e eVar) {
        c1 c1Var = new c1(this.f1668k, this.f1669l, this.f1670m, eVar);
        c1Var.f1667j = obj;
        return c1Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((c1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f1666i;
        if (i10 == 0) {
            h0.O1(obj);
            nb.e eVar = p0.f7833a;
            x1 Q0 = u.f10886a.Q0();
            b1 b1Var = new b1(this.f1668k, this.f1669l, (f0) this.f1667j, this.f1670m, (e) null);
            this.f1666i = 1;
            if (h0.c2(Q0, b1Var, this) == aVar) {
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
