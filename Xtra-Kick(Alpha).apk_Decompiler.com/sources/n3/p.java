package n3;

import androidx.fragment.app.p0;
import hb.f0;
import hb.h0;
import j3.w0;
import la.v;
import pa.e;
import qa.a;
import ra.i;

public final class p extends i implements wa.p {

    /* renamed from: i  reason: collision with root package name */
    public int f11393i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ kb.i f11394j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w0 f11395k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(kb.i iVar, w0 w0Var, e eVar) {
        super(2, eVar);
        this.f11394j = iVar;
        this.f11395k = w0Var;
    }

    public final e create(Object obj, e eVar) {
        return new p(this.f11394j, this.f11395k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((p) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11393i;
        if (i10 == 0) {
            h0.O1(obj);
            p0 p0Var = new p0(3, this.f11394j);
            o oVar = new o(this.f11395k);
            this.f11393i = 1;
            if (p0Var.b(oVar, this) == aVar) {
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
