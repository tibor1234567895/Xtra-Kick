package e6;

import a6.b0;
import a6.c0;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import r3.n0;
import ra.i;
import u3.o;
import wa.p;

public final class n1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ o1 f5195i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5196j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f5197k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n1(o1 o1Var, int i10, long j10, e eVar) {
        super(2, eVar);
        this.f5195i = o1Var;
        this.f5196j = i10;
        this.f5197k = j10;
    }

    public final e create(Object obj, e eVar) {
        return new n1(this.f5195i, this.f5196j, this.f5197k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        c0 c0Var = (c0) this.f5195i.f5207a;
        n0 n0Var = c0Var.f221a;
        n0Var.b();
        b0 b0Var = c0Var.f225e;
        o c10 = b0Var.c();
        c10.g0(1, this.f5197k);
        c10.g0(2, (long) this.f5196j);
        n0Var.c();
        try {
            c10.x();
            n0Var.r();
            n0Var.g();
            b0Var.g(c10);
            return v.f9814a;
        } catch (Throwable th) {
            n0Var.g();
            b0Var.g(c10);
            throw th;
        }
    }
}
