package androidx.lifecycle;

import hb.f0;
import hb.h0;
import java.util.concurrent.CancellationException;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class y extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f1790i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LifecycleCoroutineScopeImpl f1791j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, e eVar) {
        super(2, eVar);
        this.f1791j = lifecycleCoroutineScopeImpl;
    }

    public final e create(Object obj, e eVar) {
        y yVar = new y(this.f1791j, eVar);
        yVar.f1790i = obj;
        return yVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((y) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        f0 f0Var = (f0) this.f1790i;
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = this.f1791j;
        if (lifecycleCoroutineScopeImpl.f1628h.b().compareTo(s.INITIALIZED) >= 0) {
            lifecycleCoroutineScopeImpl.f1628h.a(lifecycleCoroutineScopeImpl);
        } else {
            h0.w(f0Var.v(), (CancellationException) null);
        }
        return v.f9814a;
    }
}
