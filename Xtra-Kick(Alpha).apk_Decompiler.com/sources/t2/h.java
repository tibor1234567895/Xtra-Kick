package t2;

import d2.t0;
import d2.v0;
import j1.a;
import j1.l0;

public final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public final long f14525a;

    /* renamed from: b  reason: collision with root package name */
    public final int f14526b;

    /* renamed from: c  reason: collision with root package name */
    public final long f14527c;

    /* renamed from: d  reason: collision with root package name */
    public final long f14528d;

    /* renamed from: e  reason: collision with root package name */
    public final long f14529e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f14530f;

    public h(long j10, int i10, long j11, long j12, long[] jArr) {
        this.f14525a = j10;
        this.f14526b = i10;
        this.f14527c = j11;
        this.f14530f = jArr;
        this.f14528d = j12;
        this.f14529e = j12 != -1 ? j10 + j12 : -1;
    }

    public final long b() {
        return this.f14529e;
    }

    public final boolean f() {
        return this.f14530f != null;
    }

    public final long g(long j10) {
        long j11;
        double d10;
        long j12 = j10 - this.f14525a;
        if (!f() || j12 <= ((long) this.f14526b)) {
            return 0;
        }
        long[] jArr = this.f14530f;
        a.f(jArr);
        double d11 = (((double) j12) * 256.0d) / ((double) this.f14528d);
        int f10 = l0.f(jArr, (long) d11, true);
        long j13 = this.f14527c;
        long j14 = (((long) f10) * j13) / 100;
        long j15 = jArr[f10];
        int i10 = f10 + 1;
        long j16 = (j13 * ((long) i10)) / 100;
        if (f10 == 99) {
            j11 = 256;
        } else {
            j11 = jArr[i10];
        }
        if (j15 == j11) {
            d10 = 0.0d;
        } else {
            d10 = (d11 - ((double) j15)) / ((double) (j11 - j15));
        }
        return Math.round(d10 * ((double) (j16 - j14))) + j14;
    }

    public final t0 i(long j10) {
        double d10;
        double d11;
        boolean f10 = f();
        int i10 = this.f14526b;
        long j11 = this.f14525a;
        if (!f10) {
            v0 v0Var = new v0(0, j11 + ((long) i10));
            return new t0(v0Var, v0Var);
        }
        long i11 = l0.i(j10, 0, this.f14527c);
        double d12 = (((double) i11) * 100.0d) / ((double) this.f14527c);
        double d13 = 0.0d;
        if (d12 > 0.0d) {
            if (d12 >= 100.0d) {
                d10 = 256.0d;
                d13 = 256.0d;
                double d14 = d13 / d10;
                long j12 = this.f14528d;
                v0 v0Var2 = new v0(i11, j11 + l0.i(Math.round(d14 * ((double) j12)), (long) i10, j12 - 1));
                return new t0(v0Var2, v0Var2);
            }
            int i12 = (int) d12;
            long[] jArr = this.f14530f;
            a.f(jArr);
            double d15 = (double) jArr[i12];
            if (i12 == 99) {
                d11 = 256.0d;
            } else {
                d11 = (double) jArr[i12 + 1];
            }
            d13 = d15 + ((d11 - d15) * (d12 - ((double) i12)));
        }
        d10 = 256.0d;
        double d142 = d13 / d10;
        long j122 = this.f14528d;
        v0 v0Var22 = new v0(i11, j11 + l0.i(Math.round(d142 * ((double) j122)), (long) i10, j122 - 1));
        return new t0(v0Var22, v0Var22);
    }

    public final long j() {
        return this.f14527c;
    }
}
