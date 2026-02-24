package n3;

import androidx.activity.t;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import wa.q;

public final class p0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11396i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f11397j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ kb.i f11398k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ q f11399l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p0(kb.i iVar, q qVar, e eVar) {
        super(2, eVar);
        this.f11398k = iVar;
        this.f11399l = qVar;
    }

    public final e create(Object obj, e eVar) {
        p0 p0Var = new p0(this.f11398k, this.f11399l, eVar);
        p0Var.f11397j = obj;
        return p0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((p0) create((k5) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11396i;
        if (i10 == 0) {
            h0.O1(obj);
            o0 o0Var = new o0(this.f11399l, new t((k5) this.f11397j), (e) null);
            this.f11396i = 1;
            if (h0.B(this.f11398k, o0Var, this) == aVar) {
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
