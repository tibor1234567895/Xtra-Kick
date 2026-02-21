package d7;

import hb.h0;
import la.v;
import n3.u3;
import o6.c;
import pa.e;
import ra.i;
import wa.p;
import xa.j;

public final class a extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f4563i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f4564j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ f f4565k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(f fVar, e eVar) {
        super(2, eVar);
        this.f4565k = fVar;
    }

    public final e create(Object obj, e eVar) {
        a aVar = new a(this.f4565k, eVar);
        aVar.f4564j = obj;
        return aVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((a) create((u3) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        int i10 = this.f4563i;
        if (i10 == 0) {
            h0.O1(obj);
            u3 u3Var = (u3) this.f4564j;
            c cVar = this.f4565k.f4580r0;
            if (cVar != null) {
                this.f4563i = 1;
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
