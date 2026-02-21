package t2;

import android.util.Pair;
import d2.t0;
import d2.v0;
import j1.l0;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f14497a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f14498b;

    /* renamed from: c  reason: collision with root package name */
    public final long f14499c;

    public c(long j10, long[] jArr, long[] jArr2) {
        this.f14497a = jArr;
        this.f14498b = jArr2;
        this.f14499c = j10 == -9223372036854775807L ? l0.H(jArr2[jArr2.length - 1]) : j10;
    }

    public static Pair a(long j10, long[] jArr, long[] jArr2) {
        Long l10;
        Long l11;
        int f10 = l0.f(jArr, j10, true);
        long j11 = jArr[f10];
        long j12 = jArr2[f10];
        int i10 = f10 + 1;
        if (i10 == jArr.length) {
            l11 = Long.valueOf(j11);
            l10 = Long.valueOf(j12);
        } else {
            long j13 = jArr[i10];
            long j14 = jArr2[i10];
            double d10 = j13 == j11 ? 0.0d : (((double) j10) - ((double) j11)) / ((double) (j13 - j11));
            l11 = Long.valueOf(j10);
            l10 = Long.valueOf(((long) (d10 * ((double) (j14 - j12)))) + j12);
        }
        return Pair.create(l11, l10);
    }

    public final long b() {
        return -1;
    }

    public final boolean f() {
        return true;
    }

    public final long g(long j10) {
        return l0.H(((Long) a(j10, this.f14497a, this.f14498b).second).longValue());
    }

    public final t0 i(long j10) {
        Pair a10 = a(l0.Q(l0.i(j10, 0, this.f14499c)), this.f14498b, this.f14497a);
        v0 v0Var = new v0(l0.H(((Long) a10.first).longValue()), ((Long) a10.second).longValue());
        return new t0(v0Var, v0Var);
    }

    public final long j() {
        return this.f14499c;
    }
}
