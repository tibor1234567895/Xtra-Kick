package lb;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9835i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9836j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f9837k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(h hVar, e eVar) {
        super(2, eVar);
        this.f9837k = hVar;
    }

    public final e create(Object obj, e eVar) {
        g gVar = new g(this.f9837k, eVar);
        gVar.f9836j = obj;
        return gVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9835i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f9835i = 1;
            if (this.f9837k.k((j) this.f9836j, this) == aVar) {
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
