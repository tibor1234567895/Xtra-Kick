package v1;

import g1.r1;
import g1.t1;
import g1.u1;
import j1.l0;

public final class e extends p {

    /* renamed from: n  reason: collision with root package name */
    public final long f15609n;

    /* renamed from: o  reason: collision with root package name */
    public final long f15610o;

    /* renamed from: p  reason: collision with root package name */
    public final long f15611p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f15612q;

    public e(u1 u1Var, long j10, long j11) {
        super(u1Var);
        boolean z10 = false;
        if (u1Var.q() == 1) {
            t1 v10 = u1Var.v(0, new t1());
            long max = Math.max(0, j10);
            if (v10.f6586s || max == 0 || v10.f6582o) {
                long max2 = j11 == Long.MIN_VALUE ? v10.f6588u : Math.max(0, j11);
                long j12 = v10.f6588u;
                if (j12 != -9223372036854775807L) {
                    max2 = max2 > j12 ? j12 : max2;
                    if (max > max2) {
                        throw new f(2);
                    }
                }
                this.f15609n = max;
                this.f15610o = max2;
                int i10 = (max2 > -9223372036854775807L ? 1 : (max2 == -9223372036854775807L ? 0 : -1));
                this.f15611p = i10 == 0 ? -9223372036854775807L : max2 - max;
                if (v10.f6583p && (i10 == 0 || (j12 != -9223372036854775807L && max2 == j12))) {
                    z10 = true;
                }
                this.f15612q = z10;
                return;
            }
            throw new f(1);
        }
        throw new f(0);
    }

    public final r1 o(int i10, r1 r1Var, boolean z10) {
        long j10;
        this.f15746m.o(0, r1Var, z10);
        long j11 = r1Var.f6546l - this.f15609n;
        long j12 = this.f15611p;
        if (j12 == -9223372036854775807L) {
            j10 = -9223372036854775807L;
        } else {
            j10 = j12 - j11;
        }
        r1Var.p(r1Var.f6542h, r1Var.f6543i, 0, j10, j11);
        return r1Var;
    }

    public final t1 w(int i10, t1 t1Var, long j10) {
        this.f15746m.w(0, t1Var, 0);
        long j11 = t1Var.f6591x;
        long j12 = this.f15609n;
        t1Var.f6591x = j11 + j12;
        t1Var.f6588u = this.f15611p;
        t1Var.f6583p = this.f15612q;
        long j13 = t1Var.f6587t;
        if (j13 != -9223372036854775807L) {
            long max = Math.max(j13, j12);
            t1Var.f6587t = max;
            long j14 = this.f15610o;
            if (j14 != -9223372036854775807L) {
                max = Math.min(max, j14);
            }
            t1Var.f6587t = max - j12;
        }
        long Q = l0.Q(j12);
        long j15 = t1Var.f6579l;
        if (j15 != -9223372036854775807L) {
            t1Var.f6579l = j15 + Q;
        }
        long j16 = t1Var.f6580m;
        if (j16 != -9223372036854775807L) {
            t1Var.f6580m = j16 + Q;
        }
        return t1Var;
    }
}
