package n3;

import hb.f0;
import hb.h0;
import la.v;
import ob.d;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class e3 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public h3 f11128i;

    /* renamed from: j  reason: collision with root package name */
    public d f11129j;

    /* renamed from: k  reason: collision with root package name */
    public g3 f11130k;

    /* renamed from: l  reason: collision with root package name */
    public int f11131l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ g3 f11132m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e3(g3 g3Var, e eVar) {
        super(2, eVar);
        this.f11132m = g3Var;
    }

    public final e create(Object obj, e eVar) {
        return new e3(this.f11132m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((e3) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h3 h3Var;
        d dVar;
        g3 g3Var;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11131l;
        if (i10 == 0) {
            h0.O1(obj);
            g3Var = this.f11132m;
            h3Var = g3Var.f11205l;
            d dVar2 = h3Var.f11229a;
            this.f11128i = h3Var;
            this.f11129j = dVar2;
            this.f11130k = g3Var;
            this.f11131l = 1;
            if (dVar2.e(this) == aVar) {
                return aVar;
            }
            dVar = dVar2;
        } else if (i10 == 1) {
            g3Var = this.f11130k;
            dVar = this.f11129j;
            h3Var = this.f11128i;
            h0.O1(obj);
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            l3 l3Var = h3Var.f11230b;
            kb.v vVar = new kb.v(new k3(l3Var, (e) null), h0.D(l3Var.f11316i));
            dVar.f((Object) null);
            d1 d1Var = d1.PREPEND;
            this.f11128i = null;
            this.f11129j = null;
            this.f11130k = null;
            this.f11131l = 2;
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
