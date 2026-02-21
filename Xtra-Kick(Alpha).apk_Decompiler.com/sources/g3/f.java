package g3;

import d2.b;
import d2.t0;
import d2.u0;
import d2.v0;
import j1.l0;

public final class f implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public final b f6825a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6826b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6827c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6828d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6829e;

    public f(b bVar, int i10, long j10, long j11) {
        this.f6825a = bVar;
        this.f6826b = i10;
        this.f6827c = j10;
        long j12 = (j11 - j10) / ((long) bVar.f4146c);
        this.f6828d = j12;
        this.f6829e = a(j12);
    }

    public final long a(long j10) {
        return l0.M(j10 * ((long) this.f6826b), 1000000, (long) this.f6825a.f4145b);
    }

    public final boolean f() {
        return true;
    }

    public final t0 i(long j10) {
        b bVar = this.f6825a;
        long j11 = (((long) bVar.f4145b) * j10) / (((long) this.f6826b) * 1000000);
        long j12 = this.f6828d;
        long i10 = l0.i(j11, 0, j12 - 1);
        long j13 = this.f6827c;
        long a10 = a(i10);
        v0 v0Var = new v0(a10, (((long) bVar.f4146c) * i10) + j13);
        if (a10 >= j10 || i10 == j12 - 1) {
            return new t0(v0Var, v0Var);
        }
        long j14 = i10 + 1;
        return new t0(v0Var, new v0(a(j14), (((long) bVar.f4146c) * j14) + j13));
    }

    public final long j() {
        return this.f6829e;
    }
}
