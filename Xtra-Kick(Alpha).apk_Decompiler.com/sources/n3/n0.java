package n3;

import hb.h0;
import kb.j;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import wa.q;
import xa.u;

public final class n0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public u f11343i;

    /* renamed from: j  reason: collision with root package name */
    public int f11344j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11345k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f11346l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ kb.i f11347m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ q f11348n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n0(Object obj, kb.i iVar, q qVar, e eVar) {
        super(2, eVar);
        this.f11346l = obj;
        this.f11347m = iVar;
        this.f11348n = qVar;
    }

    public final e create(Object obj, e eVar) {
        n0 n0Var = new n0(this.f11346l, this.f11347m, this.f11348n, eVar);
        n0Var.f11345k = obj;
        return n0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((n0) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        j jVar;
        u uVar;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11344j;
        if (i10 == 0) {
            h0.O1(obj);
            j jVar2 = (j) this.f11345k;
            uVar = new u();
            Object obj2 = this.f11346l;
            uVar.f16818h = obj2;
            this.f11345k = jVar2;
            this.f11343i = uVar;
            this.f11344j = 1;
            if (jVar2.a(obj2, this) == aVar) {
                return aVar;
            }
            jVar = jVar2;
        } else if (i10 == 1) {
            uVar = this.f11343i;
            jVar = (j) this.f11345k;
            h0.O1(obj);
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        m0 m0Var = new m0(uVar, this.f11348n, jVar);
        this.f11345k = null;
        this.f11343i = null;
        this.f11344j = 2;
        if (this.f11347m.b(m0Var, this) == aVar) {
            return aVar;
        }
        return v.f9814a;
    }
}
