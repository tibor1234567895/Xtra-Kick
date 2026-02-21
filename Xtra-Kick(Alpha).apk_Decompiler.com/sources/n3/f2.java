package n3;

import hb.f0;
import hb.h0;
import java.util.concurrent.atomic.AtomicInteger;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class f2 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f11149i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k5 f11150j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ kb.i f11151k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f11152l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ x5 f11153m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f11154n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f2(kb.i iVar, AtomicInteger atomicInteger, k5 k5Var, x5 x5Var, int i10, e eVar) {
        super(2, eVar);
        this.f11151k = iVar;
        this.f11152l = atomicInteger;
        this.f11153m = x5Var;
        this.f11154n = i10;
        this.f11150j = k5Var;
    }

    public final e create(Object obj, e eVar) {
        return new f2(this.f11151k, this.f11152l, this.f11150j, this.f11153m, this.f11154n, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f2) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11149i;
        k5 k5Var = this.f11150j;
        AtomicInteger atomicInteger = this.f11152l;
        if (i10 == 0) {
            h0.O1(obj);
            kb.i iVar = this.f11151k;
            e2 e2Var = new e2(this.f11153m, this.f11154n, 0);
            this.f11149i = 1;
            if (iVar.b(e2Var, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Throwable th) {
                if (atomicInteger.decrementAndGet() == 0) {
                    k5Var.b((Throwable) null);
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (atomicInteger.decrementAndGet() == 0) {
            k5Var.b((Throwable) null);
        }
        return v.f9814a;
    }
}
