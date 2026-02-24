package n3;

import hb.f0;
import hb.h0;
import jb.g;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class e5 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11134i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11135j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f11136k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ p f11137l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e5(g gVar, p pVar, e eVar) {
        super(2, eVar);
        this.f11136k = gVar;
        this.f11137l = pVar;
    }

    public final e create(Object obj, e eVar) {
        e5 e5Var = new e5(this.f11136k, this.f11137l, eVar);
        e5Var.f11135j = obj;
        return e5Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((e5) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11134i;
        if (i10 == 0) {
            h0.O1(obj);
            k5 k5Var = new k5((f0) this.f11135j, this.f11136k);
            this.f11134i = 1;
            if (this.f11137l.g(k5Var, this) == aVar) {
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
