package h3;

import c9.n;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.m0;
import g1.s0;
import g1.t1;
import g1.u1;
import java.util.Arrays;
import java.util.List;

public final class c4 extends u1 {

    /* renamed from: o  reason: collision with root package name */
    public static final c4 f6960o = new c4(r1.f4658l, (s0) null);

    /* renamed from: p  reason: collision with root package name */
    public static final Object f6961p = new Object();

    /* renamed from: m  reason: collision with root package name */
    public final r0 f6962m;

    /* renamed from: n  reason: collision with root package name */
    public final s0 f6963n;

    static {
        p0 p0Var = r0.f4657i;
    }

    public c4(r0 r0Var, s0 s0Var) {
        this.f6962m = r0Var;
        this.f6963n = s0Var;
    }

    public final s0 A(int i10) {
        r0 r0Var = this.f6962m;
        if (i10 >= 0 && i10 < r0Var.size()) {
            return ((b4) r0Var.get(i10)).f6941a;
        }
        if (i10 == r0Var.size()) {
            return this.f6963n;
        }
        return null;
    }

    public final long B(int i10) {
        if (i10 >= 0) {
            r0 r0Var = this.f6962m;
            if (i10 < r0Var.size()) {
                return ((b4) r0Var.get(i10)).f6942b;
            }
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c4)) {
            return false;
        }
        c4 c4Var = (c4) obj;
        return n.a(this.f6962m, c4Var.f6962m) && n.a(this.f6963n, c4Var.f6963n);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6962m, this.f6963n});
    }

    public final int k(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final g1.r1 o(int i10, g1.r1 r1Var, boolean z10) {
        r1Var.p((Object) null, (Object) null, i10, -9223372036854775807L, 0);
        return r1Var;
    }

    public final int q() {
        return x();
    }

    public final Object u(int i10) {
        throw new UnsupportedOperationException();
    }

    public final t1 w(int i10, t1 t1Var, long j10) {
        s0 s0Var;
        s0 s0Var2;
        int i11 = i10;
        r0 r0Var = this.f6962m;
        if (i11 != r0Var.size() || (s0Var2 = this.f6963n) == null) {
            s0Var = ((b4) r0Var.get(i11)).f6941a;
        } else {
            s0Var = s0Var2;
        }
        t1Var.l(f6961p, s0Var, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, true, false, (m0) null, 0, -9223372036854775807L, i10, i10, 0);
        return t1Var;
    }

    public final int x() {
        return this.f6962m.size() + (this.f6963n == null ? 0 : 1);
    }

    public final c4 z(List list, int i10) {
        o0 o0Var = new o0();
        r0 r0Var = this.f6962m;
        o0Var.d(r0Var.subList(0, i10));
        for (int i11 = 0; i11 < list.size(); i11++) {
            o0Var.c(new b4((s0) list.get(i11), -1));
        }
        o0Var.d(r0Var.subList(i10, r0Var.size()));
        return new c4(o0Var.e(), this.f6963n);
    }
}
