package m1;

import j1.a;
import j1.l0;
import v1.a0;

public final class z0 {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f10547a;

    /* renamed from: b  reason: collision with root package name */
    public final long f10548b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10549c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10550d;

    /* renamed from: e  reason: collision with root package name */
    public final long f10551e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f10552f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f10553g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f10554h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f10555i;

    public z0(a0 a0Var, long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14 = z10;
        boolean z15 = z11;
        boolean z16 = z12;
        boolean z17 = z13;
        boolean z18 = false;
        a.b(!z17 || z15);
        a.b(!z16 || z15);
        if (!z14 || (!z15 && !z16 && !z17)) {
            z18 = true;
        }
        a.b(z18);
        this.f10547a = a0Var;
        this.f10548b = j10;
        this.f10549c = j11;
        this.f10550d = j12;
        this.f10551e = j13;
        this.f10552f = z14;
        this.f10553g = z15;
        this.f10554h = z16;
        this.f10555i = z17;
    }

    public final z0 a(long j10) {
        if (j10 == this.f10549c) {
            return this;
        }
        return new z0(this.f10547a, this.f10548b, j10, this.f10550d, this.f10551e, this.f10552f, this.f10553g, this.f10554h, this.f10555i);
    }

    public final z0 b(long j10) {
        if (j10 == this.f10548b) {
            return this;
        }
        return new z0(this.f10547a, j10, this.f10549c, this.f10550d, this.f10551e, this.f10552f, this.f10553g, this.f10554h, this.f10555i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z0.class != obj.getClass()) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.f10548b == z0Var.f10548b && this.f10549c == z0Var.f10549c && this.f10550d == z0Var.f10550d && this.f10551e == z0Var.f10551e && this.f10552f == z0Var.f10552f && this.f10553g == z0Var.f10553g && this.f10554h == z0Var.f10554h && this.f10555i == z0Var.f10555i && l0.a(this.f10547a, z0Var.f10547a);
    }

    public final int hashCode() {
        return ((((((((((((((((this.f10547a.hashCode() + 527) * 31) + ((int) this.f10548b)) * 31) + ((int) this.f10549c)) * 31) + ((int) this.f10550d)) * 31) + ((int) this.f10551e)) * 31) + (this.f10552f ? 1 : 0)) * 31) + (this.f10553g ? 1 : 0)) * 31) + (this.f10554h ? 1 : 0)) * 31) + (this.f10555i ? 1 : 0);
    }
}
