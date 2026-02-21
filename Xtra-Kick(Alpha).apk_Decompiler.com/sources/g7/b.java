package g7;

import hb.h0;
import la.v;
import m7.h;
import n3.u3;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class b extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f6846i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f6847j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f6848k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(h hVar, e eVar) {
        super(2, eVar);
        this.f6848k = hVar;
    }

    public final e create(Object obj, e eVar) {
        b bVar = new b(this.f6848k, eVar);
        bVar.f6847j = obj;
        return bVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((b) create((u3) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f6846i;
        if (i10 == 0) {
            h0.O1(obj);
            u3 u3Var = (u3) this.f6847j;
            h hVar = this.f6848k.f6864s0;
            if (hVar != null) {
                this.f6846i = 1;
                if (hVar.d(u3Var, this) == aVar) {
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
