package t2;

import d2.t0;
import d2.v0;
import j1.l0;
import j1.w;

public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    public final long f14493a;

    /* renamed from: b  reason: collision with root package name */
    public final w f14494b;

    /* renamed from: c  reason: collision with root package name */
    public final w f14495c;

    /* renamed from: d  reason: collision with root package name */
    public long f14496d;

    public b(long j10, long j11, long j12) {
        this.f14496d = j10;
        this.f14493a = j12;
        w wVar = new w();
        this.f14494b = wVar;
        w wVar2 = new w();
        this.f14495c = wVar2;
        wVar.a(0);
        wVar2.a(j11);
    }

    public final boolean a(long j10) {
        w wVar = this.f14494b;
        if (j10 - wVar.b(wVar.f8479a - 1) < 100000) {
            return true;
        }
        return false;
    }

    public final long b() {
        return this.f14493a;
    }

    public final boolean f() {
        return true;
    }

    public final long g(long j10) {
        return this.f14494b.b(l0.c(this.f14495c, j10));
    }

    public final t0 i(long j10) {
        w wVar = this.f14494b;
        int c10 = l0.c(wVar, j10);
        long b10 = wVar.b(c10);
        w wVar2 = this.f14495c;
        v0 v0Var = new v0(b10, wVar2.b(c10));
        if (b10 == j10 || c10 == wVar.f8479a - 1) {
            return new t0(v0Var, v0Var);
        }
        int i10 = c10 + 1;
        return new t0(v0Var, new v0(wVar.b(i10), wVar2.b(i10)));
    }

    public final long j() {
        return this.f14496d;
    }
}
