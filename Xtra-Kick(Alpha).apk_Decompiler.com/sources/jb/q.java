package jb;

import hb.a;
import hb.h0;
import hb.m1;
import hb.s1;
import hb.w;
import java.util.concurrent.CancellationException;
import la.v;
import n3.j5;
import pa.e;
import pa.k;

public final class q extends a implements r, g {

    /* renamed from: k  reason: collision with root package name */
    public final g f8931k;

    public q(k kVar, c cVar) {
        super(kVar, true);
        this.f8931k = cVar;
    }

    public final void a(j5 j5Var) {
        this.f8931k.a(j5Var);
    }

    public final boolean b(Throwable th) {
        return this.f8931k.b(th);
    }

    public final boolean c() {
        return super.c();
    }

    public final void c0(Throwable th, boolean z10) {
        if (!this.f8931k.b(th) && !z10) {
            h0.K0(this.f7775j, th);
        }
    }

    public final void d0(Object obj) {
        v vVar = (v) obj;
        this.f8931k.b((Throwable) null);
    }

    public final void e(CancellationException cancellationException) {
        boolean z10;
        Object H = H();
        if ((H instanceof w) || ((H instanceof s1) && ((s1) H).d())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (cancellationException == null) {
                cancellationException = new m1(u(), (Throwable) null, this);
            }
            s(cancellationException);
        }
    }

    public final Object g(Object obj, e eVar) {
        return this.f8931k.g(obj, eVar);
    }

    public final Object h(Object obj) {
        return this.f8931k.h(obj);
    }

    public final b iterator() {
        return this.f8931k.iterator();
    }

    public final boolean l() {
        return this.f8931k.l();
    }

    public final void s(CancellationException cancellationException) {
        this.f8931k.e(cancellationException);
        r(cancellationException);
    }
}
