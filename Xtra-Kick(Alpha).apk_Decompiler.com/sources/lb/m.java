package lb;

import hb.f0;
import hb.h0;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.u;

public final class m extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9852i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9853j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ n f9854k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ j f9855l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(n nVar, j jVar, e eVar) {
        super(2, eVar);
        this.f9854k = nVar;
        this.f9855l = jVar;
    }

    public final e create(Object obj, e eVar) {
        m mVar = new m(this.f9854k, this.f9855l, eVar);
        mVar.f9853j = obj;
        return mVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((m) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9852i;
        if (i10 == 0) {
            h0.O1(obj);
            u uVar = new u();
            n nVar = this.f9854k;
            kb.i iVar = nVar.f9838k;
            l lVar = new l(uVar, (f0) this.f9853j, nVar, this.f9855l);
            this.f9852i = 1;
            if (iVar.b(lVar, this) == aVar) {
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
