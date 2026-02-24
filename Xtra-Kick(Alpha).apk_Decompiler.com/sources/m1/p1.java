package m1;

import j1.a;
import j1.l0;

public final class p1 {

    /* renamed from: c  reason: collision with root package name */
    public static final p1 f10435c;

    /* renamed from: a  reason: collision with root package name */
    public final long f10436a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10437b;

    static {
        p1 p1Var = new p1(0, 0);
        new p1(Long.MAX_VALUE, Long.MAX_VALUE);
        new p1(Long.MAX_VALUE, 0);
        new p1(0, Long.MAX_VALUE);
        f10435c = p1Var;
    }

    public p1(long j10, long j11) {
        boolean z10 = true;
        a.b(j10 >= 0);
        a.b(j11 < 0 ? false : z10);
        this.f10436a = j10;
        this.f10437b = j11;
    }

    public final long a(long j10, long j11, long j12) {
        long j13 = this.f10437b;
        long j14 = this.f10436a;
        if (j14 == 0 && j13 == 0) {
            return j10;
        }
        int i10 = l0.f8453a;
        long j15 = j10 - j14;
        if (((j14 ^ j10) & (j10 ^ j15)) < 0) {
            j15 = Long.MIN_VALUE;
        }
        long j16 = j10 + j13;
        if (((j13 ^ j16) & (j10 ^ j16)) < 0) {
            j16 = Long.MAX_VALUE;
        }
        boolean z10 = false;
        boolean z11 = j15 <= j11 && j11 <= j16;
        if (j15 <= j12 && j12 <= j16) {
            z10 = true;
        }
        return (!z11 || !z10) ? z11 ? j11 : z10 ? j12 : j15 : Math.abs(j11 - j10) <= Math.abs(j12 - j10) ? j11 : j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p1.class != obj.getClass()) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return this.f10436a == p1Var.f10436a && this.f10437b == p1Var.f10437b;
    }

    public final int hashCode() {
        return (((int) this.f10436a) * 31) + ((int) this.f10437b);
    }
}
