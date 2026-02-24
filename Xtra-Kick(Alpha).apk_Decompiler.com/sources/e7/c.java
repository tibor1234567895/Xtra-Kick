package e7;

import hb.h0;
import la.v;
import n3.u3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class c extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5296i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f5297j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f5298k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(g gVar, e eVar) {
        super(2, eVar);
        this.f5298k = gVar;
    }

    public final e create(Object obj, e eVar) {
        c cVar = new c(this.f5298k, eVar);
        cVar.f5297j = obj;
        return cVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((c) create((u3) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5296i;
        if (i10 == 0) {
            h0.O1(obj);
            u3 u3Var = (u3) this.f5297j;
            i7.c cVar = this.f5298k.f5310r0;
            if (cVar != null) {
                this.f5296i = 1;
                if (cVar.d(u3Var, this) == aVar) {
                    return aVar;
                }
            } else {
                j.l("pagingAdapter");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
