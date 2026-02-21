package v1;

import m1.p1;
import z1.s;

public final class i0 implements y, x {

    /* renamed from: h  reason: collision with root package name */
    public final y f15660h;

    /* renamed from: i  reason: collision with root package name */
    public final long f15661i;

    /* renamed from: j  reason: collision with root package name */
    public x f15662j;

    public i0(y yVar, long j10) {
        this.f15660h = yVar;
        this.f15661i = j10;
    }

    public final long B(long j10) {
        long j11 = this.f15661i;
        return this.f15660h.B(j10 - j11) + j11;
    }

    public final boolean C(long j10) {
        return this.f15660h.C(j10 - this.f15661i);
    }

    public final void D(long j10) {
        this.f15660h.D(j10 - this.f15661i);
    }

    public final boolean c() {
        return this.f15660h.c();
    }

    public final long f(long j10, p1 p1Var) {
        long j11 = this.f15661i;
        return this.f15660h.f(j10 - j11, p1Var) + j11;
    }

    public final void h(y yVar) {
        x xVar = this.f15662j;
        xVar.getClass();
        xVar.h(this);
    }

    public final long j() {
        long j10 = this.f15660h.j();
        if (j10 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f15661i + j10;
    }

    public final long k() {
        long k10 = this.f15660h.k();
        if (k10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f15661i + k10;
    }

    public final void m(x xVar, long j10) {
        this.f15662j = xVar;
        this.f15660h.m(this, j10 - this.f15661i);
    }

    public final l1 o() {
        return this.f15660h.o();
    }

    public final long p(s[] sVarArr, boolean[] zArr, b1[] b1VarArr, boolean[] zArr2, long j10) {
        b1[] b1VarArr2 = b1VarArr;
        b1[] b1VarArr3 = new b1[b1VarArr2.length];
        int i10 = 0;
        while (true) {
            b1 b1Var = null;
            if (i10 >= b1VarArr2.length) {
                break;
            }
            j0 j0Var = (j0) b1VarArr2[i10];
            if (j0Var != null) {
                b1Var = j0Var.f15680a;
            }
            b1VarArr3[i10] = b1Var;
            i10++;
        }
        y yVar = this.f15660h;
        long j11 = this.f15661i;
        long p10 = yVar.p(sVarArr, zArr, b1VarArr3, zArr2, j10 - j11);
        for (int i11 = 0; i11 < b1VarArr2.length; i11++) {
            b1 b1Var2 = b1VarArr3[i11];
            if (b1Var2 == null) {
                b1VarArr2[i11] = null;
            } else {
                b1 b1Var3 = b1VarArr2[i11];
                if (b1Var3 == null || ((j0) b1Var3).f15680a != b1Var2) {
                    b1VarArr2[i11] = new j0(b1Var2, j11);
                }
            }
        }
        return p10 + j11;
    }

    public final void r(d1 d1Var) {
        y yVar = (y) d1Var;
        x xVar = this.f15662j;
        xVar.getClass();
        xVar.r(this);
    }

    public final long u() {
        long u10 = this.f15660h.u();
        if (u10 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f15661i + u10;
    }

    public final void v() {
        this.f15660h.v();
    }

    public final void y(long j10, boolean z10) {
        this.f15660h.y(j10 - this.f15661i, z10);
    }
}
