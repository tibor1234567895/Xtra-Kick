package n3;

import hb.f0;
import hb.h0;
import la.v;
import ob.d;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public h3 f11155i;

    /* renamed from: j  reason: collision with root package name */
    public d f11156j;

    /* renamed from: k  reason: collision with root package name */
    public g3 f11157k;

    /* renamed from: l  reason: collision with root package name */
    public int f11158l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g3 f11159m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f3(g3 g3Var, e eVar) {
        super(2, eVar);
        this.f11159m = g3Var;
    }

    public final e create(Object obj, e eVar) {
        return new f3(this.f11159m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f3) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h3 h3Var;
        d dVar;
        g3 g3Var;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11158l;
        if (i10 == 0) {
            h0.O1(obj);
            g3Var = this.f11159m;
            h3Var = g3Var.f11205l;
            d dVar2 = h3Var.f11229a;
            this.f11155i = h3Var;
            this.f11156j = dVar2;
            this.f11157k = g3Var;
            this.f11158l = 1;
            if (dVar2.e(this) == aVar) {
                return aVar;
            }
            dVar = dVar2;
        } else if (i10 == 1) {
            g3Var = this.f11157k;
            dVar = this.f11156j;
            h3Var = this.f11155i;
            h0.O1(obj);
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            l3 l3Var = h3Var.f11230b;
            kb.v vVar = new kb.v(new j3(l3Var, (e) null), h0.D(l3Var.f11317j));
            dVar.f((Object) null);
            d1 d1Var = d1.APPEND;
            this.f11155i = null;
            this.f11156j = null;
            this.f11157k = null;
            this.f11158l = 2;
            if (g3.a(g3Var, vVar, d1Var, this) == aVar) {
                return aVar;
            }
            return v.f9814a;
        } catch (Throwable th) {
            dVar.f((Object) null);
            throw th;
        }
    }
}
