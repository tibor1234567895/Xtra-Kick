package t2;

import d2.t0;
import d2.v0;
import j1.l0;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f14521a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f14522b;

    /* renamed from: c  reason: collision with root package name */
    public final long f14523c;

    /* renamed from: d  reason: collision with root package name */
    public final long f14524d;

    public g(long[] jArr, long[] jArr2, long j10, long j11) {
        this.f14521a = jArr;
        this.f14522b = jArr2;
        this.f14523c = j10;
        this.f14524d = j11;
    }

    public final long b() {
        return this.f14524d;
    }

    public final boolean f() {
        return true;
    }

    public final long g(long j10) {
        return this.f14521a[l0.f(this.f14522b, j10, true)];
    }

    public final t0 i(long j10) {
        long[] jArr = this.f14521a;
        int f10 = l0.f(jArr, j10, true);
        long j11 = jArr[f10];
        long[] jArr2 = this.f14522b;
        v0 v0Var = new v0(j11, jArr2[f10]);
        if (j11 >= j10 || f10 == jArr.length - 1) {
            return new t0(v0Var, v0Var);
        }
        int i10 = f10 + 1;
        return new t0(v0Var, new v0(jArr[i10], jArr2[i10]));
    }

    public final long j() {
        return this.f14523c;
    }
}
