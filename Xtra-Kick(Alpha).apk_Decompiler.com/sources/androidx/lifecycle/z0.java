package androidx.lifecycle;

import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class z0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f1803i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f1804j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ p f1805k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z0(p pVar, e eVar) {
        super(2, eVar);
        this.f1805k = pVar;
    }

    public final e create(Object obj, e eVar) {
        z0 z0Var = new z0(this.f1805k, eVar);
        z0Var.f1804j = obj;
        return z0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((z0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f1803i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f1803i = 1;
            if (this.f1805k.g((f0) this.f1804j, this) == aVar) {
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
