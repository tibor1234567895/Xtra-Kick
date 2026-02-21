package lb;

import hb.f0;
import hb.h0;
import jb.s;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f9825i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9826j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ j f9827k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ f f9828l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, j jVar, f fVar) {
        super(2, eVar);
        this.f9827k = jVar;
        this.f9828l = fVar;
    }

    public final e create(Object obj, e eVar) {
        d dVar = new d(eVar, this.f9827k, this.f9828l);
        dVar.f9826j = obj;
        return dVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f9825i;
        if (i10 == 0) {
            h0.O1(obj);
            s j10 = this.f9828l.j((f0) this.f9826j);
            this.f9825i = 1;
            Object R = h0.R(this.f9827k, j10, true, this);
            if (R != aVar) {
                R = v.f9814a;
            }
            if (R == aVar) {
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
