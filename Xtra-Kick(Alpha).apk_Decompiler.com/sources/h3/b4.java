package h3;

import g1.s0;

public final class b4 {

    /* renamed from: a  reason: collision with root package name */
    public final s0 f6941a;

    /* renamed from: b  reason: collision with root package name */
    public final long f6942b;

    public b4(s0 s0Var, long j10) {
        this.f6941a = s0Var;
        this.f6942b = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return this.f6942b == b4Var.f6942b && this.f6941a.equals(b4Var.f6941a);
    }

    public final int hashCode() {
        long j10 = this.f6942b;
        return this.f6941a.hashCode() + ((217 + ((int) (j10 ^ (j10 >>> 32)))) * 31);
    }
}
