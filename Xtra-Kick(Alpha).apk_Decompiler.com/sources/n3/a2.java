package n3;

import androidx.fragment.app.p0;
import hb.h0;
import kb.o0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class a2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11040i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11041j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ r4 f11042k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ i2 f11043l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a2(r4 r4Var, i2 i2Var, e eVar) {
        super(2, eVar);
        this.f11042k = r4Var;
        this.f11043l = i2Var;
    }

    public final e create(Object obj, e eVar) {
        a2 a2Var = new a2(this.f11042k, this.f11043l, eVar);
        a2Var.f11041j = obj;
        return a2Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((a2) create((k5) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        c5 c5Var;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11040i;
        if (i10 == 0) {
            h0.O1(obj);
            k5 k5Var = (k5) this.f11041j;
            r4 r4Var = this.f11042k;
            if (r4Var == null) {
                c5Var = null;
            } else {
                j.f("scope", k5Var);
                c5Var = new c5(k5Var, r4Var);
            }
            i2 i2Var = this.f11043l;
            kb.v vVar = new kb.v(new v1(c5Var, (e) null), i2Var.f11253d.f11057b);
            x1 x1Var = new x1(i2Var, c5Var, (e) null);
            Object obj2 = q0.f11419a;
            kb.i a10 = q0.a(new p0(2, new o0(new n0((Object) null, vVar, x1Var, (e) null))), new z1((e) null, i2Var, c5Var, 0));
            y1 y1Var = new y1(k5Var, 0);
            this.f11040i = 1;
            if (a10.b(y1Var, this) == aVar) {
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
