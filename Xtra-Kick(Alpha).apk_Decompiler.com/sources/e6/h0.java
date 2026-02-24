package e6;

import hb.f0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5138i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s0 f5139j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f5140k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h0(s0 s0Var, String str, e eVar) {
        super(2, eVar);
        this.f5139j = s0Var;
        this.f5140k = str;
    }

    public final e create(Object obj, e eVar) {
        return new h0(this.f5139j, this.f5140k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f5138i;
        if (i10 == 0) {
            hb.h0.O1(obj);
            this.f5138i = 1;
            s0 s0Var = this.f5139j;
            s0Var.getClass();
            obj = hb.h0.c2(p0.f7834b, new m0(s0Var, this.f5140k, (e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            hb.h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
