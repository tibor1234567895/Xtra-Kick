package c7;

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
    public int f2977i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2978j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f2979k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(h hVar, e eVar) {
        super(2, eVar);
        this.f2979k = hVar;
    }

    public final e create(Object obj, e eVar) {
        c cVar = new c(this.f2979k, eVar);
        cVar.f2978j = obj;
        return cVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((c) create((u3) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f2977i;
        if (i10 == 0) {
            h0.O1(obj);
            u3 u3Var = (u3) this.f2978j;
            o6.c cVar = this.f2979k.f2994r0;
            if (cVar != null) {
                this.f2977i = 1;
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
