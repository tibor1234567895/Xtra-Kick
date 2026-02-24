package y1;

import d9.p0;
import d9.r0;
import d9.r1;
import j1.a;
import java.util.List;
import w2.d;

public final class b implements d {

    /* renamed from: h  reason: collision with root package name */
    public final long f16860h;

    /* renamed from: i  reason: collision with root package name */
    public final r0 f16861i;

    public b(long j10, r1 r1Var) {
        this.f16860h = j10;
        this.f16861i = r1Var;
    }

    public final int a(long j10) {
        return this.f16860h > j10 ? 0 : -1;
    }

    public final long b(int i10) {
        a.b(i10 == 0);
        return this.f16860h;
    }

    public final List c(long j10) {
        if (j10 >= this.f16860h) {
            return this.f16861i;
        }
        p0 p0Var = r0.f4657i;
        return r1.f4658l;
    }

    public final int d() {
        return 1;
    }
}
