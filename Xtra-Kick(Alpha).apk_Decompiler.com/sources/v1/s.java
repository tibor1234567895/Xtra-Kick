package v1;

import a2.e;
import j1.l0;
import m1.p1;

public final class s implements y, x {

    /* renamed from: h  reason: collision with root package name */
    public final a0 f15778h;

    /* renamed from: i  reason: collision with root package name */
    public final long f15779i;

    /* renamed from: j  reason: collision with root package name */
    public final e f15780j;

    /* renamed from: k  reason: collision with root package name */
    public a f15781k;

    /* renamed from: l  reason: collision with root package name */
    public y f15782l;

    /* renamed from: m  reason: collision with root package name */
    public x f15783m;

    /* renamed from: n  reason: collision with root package name */
    public long f15784n = -9223372036854775807L;

    public s(a0 a0Var, e eVar, long j10) {
        this.f15778h = a0Var;
        this.f15780j = eVar;
        this.f15779i = j10;
    }

    public final long B(long j10) {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.B(j10);
    }

    public final boolean C(long j10) {
        y yVar = this.f15782l;
        return yVar != null && yVar.C(j10);
    }

    public final void D(long j10) {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        yVar.D(j10);
    }

    public final void a(a0 a0Var) {
        long j10 = this.f15784n;
        if (j10 == -9223372036854775807L) {
            j10 = this.f15779i;
        }
        a aVar = this.f15781k;
        aVar.getClass();
        y b10 = aVar.b(a0Var, this.f15780j, j10);
        this.f15782l = b10;
        if (this.f15783m != null) {
            b10.m(this, j10);
        }
    }

    public final void b() {
        if (this.f15782l != null) {
            a aVar = this.f15781k;
            aVar.getClass();
            aVar.n(this.f15782l);
        }
    }

    public final boolean c() {
        y yVar = this.f15782l;
        return yVar != null && yVar.c();
    }

    public final long f(long j10, p1 p1Var) {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.f(j10, p1Var);
    }

    public final void h(y yVar) {
        x xVar = this.f15783m;
        int i10 = l0.f8453a;
        xVar.h(this);
    }

    public final long j() {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.j();
    }

    public final long k() {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.k();
    }

    public final void m(x xVar, long j10) {
        this.f15783m = xVar;
        y yVar = this.f15782l;
        if (yVar != null) {
            long j11 = this.f15784n;
            if (j11 == -9223372036854775807L) {
                j11 = this.f15779i;
            }
            yVar.m(this, j11);
        }
    }

    public final l1 o() {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.o();
    }

    public final long p(z1.s[] sVarArr, boolean[] zArr, b1[] b1VarArr, boolean[] zArr2, long j10) {
        long j11;
        long j12 = this.f15784n;
        if (j12 == -9223372036854775807L || j10 != this.f15779i) {
            j11 = j10;
        } else {
            this.f15784n = -9223372036854775807L;
            j11 = j12;
        }
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.p(sVarArr, zArr, b1VarArr, zArr2, j11);
    }

    public final void r(d1 d1Var) {
        y yVar = (y) d1Var;
        x xVar = this.f15783m;
        int i10 = l0.f8453a;
        xVar.r(this);
    }

    public final long u() {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        return yVar.u();
    }

    public final void v() {
        y yVar = this.f15782l;
        if (yVar != null) {
            yVar.v();
            return;
        }
        a aVar = this.f15781k;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void y(long j10, boolean z10) {
        y yVar = this.f15782l;
        int i10 = l0.f8453a;
        yVar.y(j10, z10);
    }
}
